package staticdata;

import dynamicdata.CombatResults;
import dynamicdata.Encounter;
import dynamicdata.GoalResults;
import dynamicdata.Lamp;
import dynamicdata.Player;
import dynamicdata.Requirement;
import dynamicdata.Reward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Achievement {

    private String name; //name of the task
    private double time; //est. time taken in hours [not including time to gather items/complete requirements]
    private List<Requirement> reqs; //list of requirements
    private List<Encounter> encounters; //list of combat encounters
    private List<Reward> rewards; //list of static rewards
    private List<Lamp> lamps; //list of lamps
    private boolean display; //if task is a "true" achievement, and should be displayed on the task list

    Achievement(AchievementBuilder builder) {
        this.name = builder.name;
        this.time = builder.time;
        this.reqs = builder.reqs;
        this.encounters = builder.encounters;
        this.rewards = builder.rewards;
        this.lamps = builder.lamps;
        this.display = builder.display;
    }

    public static class AchievementBuilder {

        private String name;
        private double time;
        private List<Requirement> reqs;
        private List<Encounter> encounters;
        private List<Reward> rewards;
        private List<Lamp> lamps;
        private boolean display;

        AchievementBuilder(String name, double time, boolean display) {
            this.name = name;
            this.time = time;
            this.display = display;
            this.reqs = new ArrayList<>();
            this.encounters = new ArrayList<>();
            this.rewards = new ArrayList<>();
            this.lamps = new ArrayList<>();
            rewards.add(new Reward(name, 1));
        }

        public AchievementBuilder requirement(String qualifier, int quantifier) {
            if (quantifier > 0) {
                reqs.add(new Requirement(qualifier, quantifier));
            }
            else if (quantifier == 0) {
                reqs.add(new Requirement(qualifier, 1));
                rewards.add(new Reward(qualifier, 1));
            }
            return this;
        }

        public AchievementBuilder encounter(Encounter encounter) {
            encounters.add(encounter);
            return this;
        }

        public AchievementBuilder reward(String qualifier, int quantifier) {
            rewards.add(new Reward(qualifier, quantifier));
            return this;
        }

        public AchievementBuilder lamp(List<String> choices, int xp, int minLevel) {
            lamps.add(new Lamp(choices, xp, minLevel));
            return this;
        }

        public Achievement build() {
            return new Achievement(this);
        }
    }

    public GoalResults getTimeForRequirements(Player player) {
        double totalTimeForAllReqs = 0;
        Map<String, Double> totalActionsWithTimesForAllReqs = new HashMap<>();
        List<Requirement> recursiveRequirements = new ArrayList<>();
        Map<String, Double> originalMap = player.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        List<Weapon> weaponList = new ArrayList<>(player.getWeapons());
        for (Requirement r : reqs) {
            GoalResults resultsForOneRequirement = r.timeAndActionsToMeetRequirement(player);
            for (Entry<String, Double> actionWithTime : resultsForOneRequirement.getActionsWithTimes().entrySet()) {
                if (Achievement.getAchievementByName(actionWithTime.getKey()) == null || !totalActionsWithTimesForAllReqs.containsKey(actionWithTime.getKey())) {
                    totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), actionWithTime.getValue());
                    totalTimeForAllReqs += actionWithTime.getValue();
                }
            }
            recursiveRequirements.addAll(resultsForOneRequirement.getRequirements());
            if (Player.ALL_SKILLS.contains(r.getQualifier())) {
                player.getXp().put(r.getQualifier(), player.getXp().get(r.getQualifier()) + player.getXpToLevel(r.getQualifier(), r.getQuantifier()));
            }
            if (Weapon.getWeaponByName(r.getQualifier()) != null) {
                player.addWeapon(Weapon.getWeaponByName(r.getQualifier()));
            }
        }
        for (Requirement r : recursiveRequirements) {
            if (Player.ALL_SKILLS.contains(r.getQualifier())) {
                player.getXp().put(r.getQualifier(), player.getXp().get(r.getQualifier()) + player.getXpToLevel(r.getQualifier(), r.getQuantifier()));
            }
        }
        for (Encounter e : encounters) {
            CombatResults meleeCombatResults = e.calculateCombat(player, 27, "Melee");
            CombatResults rangedCombatResults = e.calculateCombat(player, 27, "Ranged");
            CombatResults magicCombatResults = e.calculateCombat(player, 27, "Magic");
            if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000) {
                //System.out.println("Time to update the combat simulator");
                totalTimeForAllReqs += 2147000.0;
            }
        }
        player.setXp(originalMap);
        player.setWeapons(weaponList);
        return new GoalResults(totalTimeForAllReqs, recursiveRequirements, totalActionsWithTimesForAllReqs);
    }

    public double getGainFromRewards(Player player) {
        double totalGainFromAllRewards = 0;
        for (Reward r : rewards) {
            totalGainFromAllRewards += r.getGainFromReward(player);
        }
        for (Lamp lamp : lamps) {
            try {
                totalGainFromAllRewards += lamp.getBestReward(player).getGainFromReward(player);
            } catch (NullPointerException e) { //can't access lamp yet
                totalGainFromAllRewards -= 1000000000;
            }
        }
        for (Encounter e : encounters) {
            for (List<Enemy> enemyGroup : e.getEnemyGroups())
                for (Enemy enemy : enemyGroup)
                    totalGainFromAllRewards += player.efficientGoalCompletion("Constitution", (int) enemy.getHpxp()).getTotalTime();
            //totalGainFromAllRewards += player.getActionDatabase().bestEffectiveRate("Combat", player);
        }
        return totalGainFromAllRewards;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public List<Requirement> getReqs() {
        return reqs;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public List<Lamp> getLamps() {
        return lamps;
    }

    public boolean isDisplay() {
        return display;
    }

    public static Achievement getAchievementByName(String name) {
        for (Achievement a : AchievementDatabase.getAchievementDatabase().getAchievements()) {
            if (a.getName().equals(name))
                return a;
        }
        return null;
    }
}