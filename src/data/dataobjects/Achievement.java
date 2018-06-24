package data.dataobjects;

import data.databases.AchievementDatabase;
import logic.CombatResults;
import logic.Encounter;
import logic.GoalResults;
import logic.Lamp;
import logic.Player;
import logic.Requirement;
import logic.Reward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Achievement implements java.io.Serializable {

    private String name; //name of the task
    private double time; //est. time taken in hours [not including time to gather items/complete requirements]
    private List<Requirement> reqs; //list of requirements
    private List<Encounter> encounters; //list of combat encounters
    private List<Reward> rewards; //list of static rewards
    private List<Lamp> lamps; //list of lamps

    Achievement(AchievementBuilder builder) {
        this.name = builder.name;
        this.time = builder.time;
        this.reqs = builder.reqs;
        this.encounters = builder.encounters;
        this.rewards = builder.rewards;
        this.lamps = builder.lamps;
    }

    public static class AchievementBuilder {

        private String name;
        private double time;
        private List<Requirement> reqs;
        private List<Encounter> encounters;
        private List<Reward> rewards;
        private List<Lamp> lamps;

        public AchievementBuilder(String name, double time) {
            this.name = name;
            this.time = time;
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
            else  {
                reqs.add(new Requirement(qualifier, quantifier*-1));
                rewards.add(new Reward(qualifier, quantifier*-1));
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
        Map<String, Double> initialXP = new HashMap<>();
        initialXP.putAll(player.getXp());
        Map<String, Double> totalActionsWithTimesForAllReqs = new HashMap<>();
        for (Requirement r : reqs) {
            if (Achievement.getAchievementByName(r.getQualifier()) == null || !totalActionsWithTimesForAllReqs.containsKey(r.getQualifier())) {
                GoalResults resultsForOneRequirement = r.timeAndActionsToMeetRequirement(player);
                for (Entry<String, Double> actionWithTime : resultsForOneRequirement.getActionsWithTimes().entrySet()) {
                    totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), actionWithTime.getValue());
                }
            }
        }
        for (Entry<String, Double> action : totalActionsWithTimesForAllReqs.entrySet()) {
            totalTimeForAllReqs += action.getValue();
        }
        //If player does not
        for (Requirement r : reqs) {
            if (Player.ALL_SKILLS.contains(r.getQualifier())) {
                player.getXp().put(r.getQualifier(), player.getXp().get(r.getQualifier()) + player.getXpToLevel(r.getQualifier(), r.getQuantifier()));
            }
        }
        for (Encounter e : encounters) {
            CombatResults meleeCombatResults = e.calculateCombat(player, 27, "Melee");
            CombatResults rangedCombatResults = e.calculateCombat(player, 27, "Ranged");
            CombatResults magicCombatResults = e.calculateCombat(player, 27, "Magic");
            if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000) {
                totalTimeForAllReqs += 2147000.0;
            }
        }
        player.setXp(initialXP);
        return new GoalResults(totalTimeForAllReqs, totalActionsWithTimesForAllReqs);
    }

    public double getGainFromRewards(Player player) {
        double totalGainFromAllRewards = 0;
        for (Reward r : rewards) {
            totalGainFromAllRewards += r.getGainFromReward(player);
        }
        for (Lamp lamp : lamps) {
            totalGainFromAllRewards += lamp.getBestReward(player).getGainFromReward(player);
        }
        for (Encounter e : encounters) {
            for (List<Enemy> enemyGroup : e.getEnemyGroups())
                for (Enemy enemy : enemyGroup)
                    totalGainFromAllRewards += player.efficientGoalCompletion("Constitution", (int) enemy.getHpxp()).getTotalTime();
            //totalGainFromAllRewards += player.getActionDatabase().bestEffectiveRate("Combat", player);
        }
        return totalGainFromAllRewards;
    }
/*
    public List<Requirement> getRecursiveRequirements() {
        List<Requirement> recursiveReqs = reqs;
        List<String> achievementsParsed = new ArrayList<>();
        boolean newReqs = true;
        while (newReqs) {
            newReqs = false;
            List<Requirement> newRecReqs = new ArrayList<>();
            for (Requirement r : recursiveReqs) {
                if (Achievement.getAchievementByName(r.getQualifier()) != null && !achievementsParsed.contains(r.getQualifier())) {
                    newReqs = true;
                    for (Requirement achievementReq : Achievement.getAchievementByName(r.getQualifier()).getReqs()) {
                        if (!achievementsParsed.contains(achievementReq.getQualifier())) {
                            newRecReqs.add(achievementReq);
                        }
                    }
                    achievementsParsed.add(r.getQualifier());
                    newRecReqs.add(r);
                }
                else if (!achievementsParsed.contains(r.getQualifier()) || newRecReqs.stream().noneMatch(a -> a.getQualifier().equals(r.getQualifier()))){
                    newRecReqs.add(r);
                }
            }
            recursiveReqs = newRecReqs;
        }
        return recursiveReqs;
    }*/

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

    public static Achievement getAchievementByName(String name) {
        for (Achievement a : AchievementDatabase.getAchievementDatabase().getAchievements()) {
            if (a.getName().equals(name))
                return a;
        }
        return null;
    }
}