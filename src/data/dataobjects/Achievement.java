package data.dataobjects;

import data.databases.AchievementDatabase;
import data.databases.ItemDatabase;
import logic.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Achievement implements Serializable {

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
        final Map<String, Double> initialXP = new HashMap<>(player.getXp());
        Map<String, Double> totalActionsWithTimesForAllReqs = new HashMap<>();
        if (this.time > 0) {
            totalActionsWithTimesForAllReqs.put(this.name, this.time);
        }
        for (Requirement r : reqs) {
            GoalResults resultsForOneRequirement = r.timeAndActionsToMeetRequirement(player);
            for (Entry<String, Double> actionWithTime : resultsForOneRequirement.getActionsWithTimes().entrySet()) {
                if (totalActionsWithTimesForAllReqs.containsKey(actionWithTime.getKey())) {
                    if (ItemDatabase.getItemDatabase().getItems().get(r.getQualifier()) == null) {
                        totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), Math.max(totalActionsWithTimesForAllReqs.get(actionWithTime.getKey()), actionWithTime.getValue()));
                    }
                    else  {
                        totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), totalActionsWithTimesForAllReqs.get(actionWithTime.getKey()) + actionWithTime.getValue());
                    }
                }
                else {
                    totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), actionWithTime.getValue());
                }
            }
        }
        for (Requirement r : reqs) {
            if (Player.ALL_SKILLS.contains(r.getQualifier())) {
                player.getXp().put(r.getQualifier(), player.getXp().get(r.getQualifier()) + player.getXpToLevel(r.getQualifier(), r.getQuantifier()));
            }
        }
        List<Requirement> encounterRequirements = new ArrayList<>();
        List<Weapon> initialWeapons = new ArrayList<>(player.getWeapons());
        List<Armour> initialArmours = new ArrayList<>(player.getArmour());
        for (Encounter e : encounters) {
            CombatResults meleeCombatResults;
            CombatResults rangedCombatResults;
            CombatResults magicCombatResults;
            while(true) {
                meleeCombatResults = e.calculateCombat(player, new CombatParameters(28, "Melee", false, 0, false));
                rangedCombatResults = e.calculateCombat(player, new CombatParameters(28, "Ranged", false, 0, false));
                magicCombatResults = e.calculateCombat(player, new CombatParameters(28, "Magic", false, 0, false));
                if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000) {
                    Map<String, Double> nextGearMelee = player.nextGear("Melee");
                    Map<String, Double> nextGearRanged = player.nextGear("Ranged");
                    Map<String, Double> nextGearMagic = player.nextGear("Magic");
                    if (nextGearMelee == null && nextGearRanged == null && nextGearMagic == null) {
                        break;
                    }
                    double timeToMelee = nextGearMelee == null ? Double.POSITIVE_INFINITY : nextGearMelee.values().iterator().next();
                    double timeToMagic = nextGearMagic == null ? Double.POSITIVE_INFINITY : nextGearMagic.values().iterator().next();
                    double timeToRanged = nextGearRanged == null ? Double.POSITIVE_INFINITY : nextGearRanged.values().iterator().next();
                    if (timeToMelee != Double.POSITIVE_INFINITY && timeToMelee <= Math.min(timeToMagic, timeToRanged)) {
                        addGearToPlayer(player, nextGearMelee.keySet().iterator().next());
                    }
                    else if (timeToMagic != Double.POSITIVE_INFINITY && timeToMagic <= timeToRanged) {
                        addGearToPlayer(player, nextGearMagic.keySet().iterator().next());
                    }
                    else if (timeToRanged != Double.POSITIVE_INFINITY){
                        addGearToPlayer(player, nextGearRanged.keySet().iterator().next());
                    }
                }
                else {
                    Loadout loadout = null;
                    if (player.getXp().get("Defence") > initialXP.get("Defence")) {
                        encounterRequirements.add(new Requirement("Defence", player.getLevel("Defence")));
                    }
                    if (player.getXp().get("Constitution") > initialXP.get("Constitution")) {
                        encounterRequirements.add(new Requirement("Constitution", player.getLevel("Constitution")));
                    }
                    if (player.getXp().get("Summoning") > initialXP.get("Summoning")) {
                        encounterRequirements.add(new Requirement("Summoning", player.getLevel("Summoning")));
                    }
                    if (meleeCombatResults.getHpLost() < 1000000) {
                        loadout = meleeCombatResults.getLoadoutUsed();
                        if (player.getXp().get("Attack") > initialXP.get("Attack")) {
                            encounterRequirements.add(new Requirement("Attack", player.getLevel("Attack")));
                        }
                        if (player.getXp().get("Strength") > initialXP.get("Strength")) {
                            encounterRequirements.add(new Requirement("Strength", player.getLevel("Strength")));
                        }
                    }
                    else if (rangedCombatResults.getHpLost() < 1000000) {
                        loadout = rangedCombatResults.getLoadoutUsed();
                        if (player.getXp().get("Ranged") > initialXP.get("Ranged")) {
                            encounterRequirements.add(new Requirement("Ranged", player.getLevel("Ranged")));
                        }
                    }
                    else if (magicCombatResults.getHpLost() < 1000000) {
                        loadout = magicCombatResults.getLoadoutUsed();
                        if (player.getXp().get("Magic") > initialXP.get("Magic")) {
                            encounterRequirements.add(new Requirement("Magic", player.getLevel("Magic")));
                        }
                    }
                    if (!initialArmours.contains(loadout.getHead()) && !loadout.getHead().equals(Armour.getArmourByName("None"))) {
                        encounterRequirements.add(new Requirement(loadout.getHead().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getTorso()) && !loadout.getTorso().equals(Armour.getArmourByName("None"))) {
                        encounterRequirements.add(new Requirement(loadout.getTorso().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getLegs()) && !loadout.getLegs().equals(Armour.getArmourByName("None"))) {
                        encounterRequirements.add(new Requirement(loadout.getLegs().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getHands()) && !loadout.getHands().equals(Armour.getArmourByName("None"))) {
                        encounterRequirements.add(new Requirement(loadout.getHands().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getFeet()) && !loadout.getFeet().equals(Armour.getArmourByName("None"))) {
                        encounterRequirements.add(new Requirement(loadout.getFeet().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getRing()) && !loadout.getRing().equals(Armour.getArmourByName("None"))) {
                        encounterRequirements.add(new Requirement(loadout.getRing().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getNeck()) && !loadout.getNeck().equals(Armour.getArmourByName("None"))) {
                        encounterRequirements.add(new Requirement(loadout.getNeck().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getCape()) && !loadout.getCape().equals(Armour.getArmourByName("None"))) {
                        encounterRequirements.add(new Requirement(loadout.getCape().getName(), 1));
                    }
                    if (!initialWeapons.contains(loadout.getMainWep())) {
                        encounterRequirements.add(new Requirement(loadout.getMainWep().getName(), 1));
                    }
                    break;
                }
            }
            if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000) {
                totalTimeForAllReqs += 2147000.0;
            }
            else {
                double minEncounterTime = 9999999;
                if (meleeCombatResults.getHpLost() <= 1000000) {
                    minEncounterTime = Math.min(minEncounterTime, meleeCombatResults.getTicks());
                }
                if (rangedCombatResults.getHpLost() <= 1000000) {
                    minEncounterTime = Math.min(minEncounterTime, rangedCombatResults.getTicks());
                }
                if (magicCombatResults.getHpLost() <= 1000000) {
                    minEncounterTime = Math.min(minEncounterTime, magicCombatResults.getTicks());
                }
                totalActionsWithTimesForAllReqs.put("Time fighting", minEncounterTime/6000.0);
            }
        }
        player.setXp(initialXP);
        player.setWeapons(initialWeapons);
        player.setArmour(initialArmours);
        for (Requirement r : encounterRequirements) {
            GoalResults resultsForOneRequirement = r.timeAndActionsToMeetRequirement(player);
            for (Entry<String, Double> actionWithTime : resultsForOneRequirement.getActionsWithTimes().entrySet()) {
                if (totalActionsWithTimesForAllReqs.containsKey(actionWithTime.getKey())) {
                    totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), Math.max(totalActionsWithTimesForAllReqs.get(actionWithTime.getKey()), actionWithTime.getValue()));
                }
                else {
                    totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), actionWithTime.getValue());
                }
            }
        }
        for (Entry<String, Double> action : totalActionsWithTimesForAllReqs.entrySet()) {
            totalTimeForAllReqs += action.getValue();
        }
        return new GoalResults(totalTimeForAllReqs, totalActionsWithTimesForAllReqs);
    }

    public double getGainFromRewards(Player player) {
        double totalGainFromAllRewards = 0;
        for (Reward r : rewards) {
            totalGainFromAllRewards += r.getGainFromReward(player);
        }
        final Map<String, Double> initialXP = new HashMap<>(player.getXp());
        for (Encounter e : encounters) {
            CombatResults meleeCombatResults;
            CombatResults rangedCombatResults;
            CombatResults magicCombatResults;
            do {
                meleeCombatResults = e.calculateCombat(player, new CombatParameters(28, "Melee", false, 0, false));
                rangedCombatResults = e.calculateCombat(player, new CombatParameters(28, "Ranged", false, 0, false));
                magicCombatResults = e.calculateCombat(player, new CombatParameters(28, "Magic", false, 0, false));
                if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000) {
                    player.getXp().put("Attack", player.getXp().get("Attack") + player.getXpToLevel("Attack", player.getLevel("Attack")+1));
                    player.getXp().put("Strength", player.getXp().get("Strength") + player.getXpToLevel("Strength", player.getLevel("Strength")+1));
                    player.getXp().put("Ranged", player.getXp().get("Ranged") + player.getXpToLevel("Ranged", player.getLevel("Ranged")+1));
                    player.getXp().put("Magic", player.getXp().get("Magic") + player.getXpToLevel("Magic", player.getLevel("Magic")+1));
                    player.getXp().put("Defence", player.getXp().get("Defence") + player.getXpToLevel("Defence", player.getLevel("Defence")+1));
                    player.getXp().put("Constitution", player.getXp().get("Constitution") + player.getXpToLevel("Constitution", player.getLevel("Constitution") + 1));
                }
                else {
                    break;
                }
            }
            while (player.getLevel("Constitution") < 99 || player.getLevel("Attack") < 99 || player.getLevel("Strength") < 99 || player.getLevel("Defence") < 99 ||
                player.getLevel("Magic") < 99 || player.getLevel("Ranged") < 99);
            for (List<Enemy> enemyGroup : e.getEnemyGroups()) {
                for (Enemy enemy : enemyGroup) {
                    totalGainFromAllRewards += player.efficientGoalCompletion("Constitution", (int) enemy.getHpxp()).getTotalTime();
                    if (rangedCombatResults.getHpLost() < meleeCombatResults.getHpLost() && rangedCombatResults.getHpLost() < magicCombatResults.getHpLost()) {
                        totalGainFromAllRewards += player.efficientGoalCompletion("rCombat", (int) enemy.getCbxp()).getTotalTime();
                    }
                    else if (meleeCombatResults.getHpLost() < magicCombatResults.getHpLost()) {
                        totalGainFromAllRewards += player.efficientGoalCompletion("mCombat", (int) enemy.getCbxp()).getTotalTime();
                    }
                    else {
                        totalGainFromAllRewards += player.efficientGoalCompletion("aCombat", (int) enemy.getCbxp()).getTotalTime();
                    }
                }
            }
        }
        player.setXp(new HashMap<>(initialXP));
        for (Lamp lamp : lamps) {
            Reward reward = lamp.getBestReward(player);
            totalGainFromAllRewards += reward.getGainFromReward(player);
            player.getXp().put(reward.getQualifier(), player.getXp().get(reward.getQualifier()) + reward.getQuantifier());
        }
        player.setXp(initialXP);
        return totalGainFromAllRewards;
    }

    private void addGearToPlayer(Player player, String gear) {
        Weapon weapon = Weapon.getWeaponByName(gear);
        Armour armour = Armour.getArmourByName(gear);
        Food food = Food.getFoodByName(gear);
        Familiar familiar = Familiar.getFamiliarByName(gear);
        if (weapon != null) {
            for (Requirement requirement : weapon.getReqs()) {
                player.getXp().put(requirement.getQualifier(), player.getXp().get(requirement.getQualifier()) + player.getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
            }
            player.addWeapon(weapon);
        }
        else if (armour != null) {
            for (Requirement requirement : armour.getReqs()) {
                player.getXp().put(requirement.getQualifier(), player.getXp().get(requirement.getQualifier()) + player.getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
            }
            player.addArmour(armour);
        }
        else if (food != null) {
            player.getXp().put("Constitution", player.getXp().get("Constitution") + player.getXpToLevel("Constitution", Math.min(99, food.getAmountHealed()/25)));
        }
        else if (familiar != null) {
            player.getXp().put("Summoning", player.getXp().get("Summoning") + player.getXpToLevel("Summoning", familiar.getSummonReq()));
        }
        else {
            throw new RuntimeException(String.format("Attempted to equip gear that does not exist: %s. Please raise a T99 issue.", gear));
        }
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

    public static Achievement getAchievementByName(String name) {
        for (Achievement a : AchievementDatabase.getAchievementDatabase().getAchievements()) {
            if (a.getName().equals(name))
                return a;
        }
        return null;
    }
}