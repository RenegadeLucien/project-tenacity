package data.dataobjects;

import data.databases.AchievementDatabase;
import data.databases.ItemDatabase;
import data.databases.WeaponDatabase;
import logic.*;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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

    private List<Requirement> getTrueRequirements(Player player) {
        Map<String, Integer> trueReqsMap = new HashMap<>();
        for (Requirement r : reqs) {
            if (Achievement.getAchievementByName(r.getQualifier()) != null) {
                List<Requirement> subReqs = Achievement.getAchievementByName(r.getQualifier()).getTrueRequirements(player);
                combineRequirements(trueReqsMap, subReqs);
            } else {
                combineRequirements(trueReqsMap, Collections.singletonList(r));
            }
        }
        combineRequirements(trueReqsMap, getRequirementsFromEncounters(player));
        List<Requirement> trueReqs = new ArrayList<>();
        for (Entry<String, Integer> req : trueReqsMap.entrySet()) {
            trueReqs.add(new Requirement(req.getKey(), req.getValue()));
        }
        if (time >= 0) {
            trueReqs.add(new Requirement(name, 1));
        }
        return trueReqs;
    }

    private void combineRequirements(Map<String, Integer> reqsMap, List<Requirement> newReqs) {
        for (Requirement requirement : newReqs) {
            if (Weapon.getWeaponByName(requirement.getQualifier()) != null || Armour.getArmourByName(requirement.getQualifier()) != null) {
                reqsMap.put(requirement.getQualifier(), 1);
            } else if (reqsMap.containsKey(requirement.getQualifier()) && ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()) != null) {
                reqsMap.put(requirement.getQualifier(), reqsMap.get(requirement.getQualifier()) + requirement.getQuantifier());
            } else if (reqsMap.containsKey(requirement.getQualifier())) {
                reqsMap.put(requirement.getQualifier(), Math.max(reqsMap.get(requirement.getQualifier()),requirement.getQuantifier()));
            } else {
                reqsMap.put(requirement.getQualifier(), requirement.getQuantifier());
            }
        }
    }

    private List<Requirement> getRequirementsFromEncounters(Player player) {
        List<Requirement> allEncounterRequirements = new ArrayList<>();
        Map<String, Integer> allEncounterReqsMap = new HashMap<>();
        final Map<String, Double> initialXP = new HashMap<>(player.getXp());
        List<Weapon> initialWeapons = new ArrayList<>(player.getWeapons());
        List<Armour> initialArmours = new ArrayList<>(player.getArmour());
        int ticksOnFights = 0;
        for (Encounter e : encounters) {
            List<Requirement> singleEncounterRequirements = new ArrayList<>();
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
                        player.addGearToPlayer(nextGearMelee.keySet().iterator().next());
                    }
                    else if (timeToMagic != Double.POSITIVE_INFINITY && timeToMagic <= timeToRanged) {
                        player.addGearToPlayer(nextGearMagic.keySet().iterator().next());
                    }
                    else if (timeToRanged != Double.POSITIVE_INFINITY){
                        player.addGearToPlayer(nextGearRanged.keySet().iterator().next());
                    }
                }
                else {
                    Loadout loadout = null;
                    if (meleeCombatResults.getHpLost() < 1000000) {
                        loadout = meleeCombatResults.getLoadoutUsed();
                        player.setXp(loadout.getXp());
                        if (player.getXp().get("Attack") > initialXP.get("Attack")) {
                            singleEncounterRequirements.add(new Requirement("Attack", player.getLevel("Attack")));
                        }
                        if (player.getXp().get("Strength") > initialXP.get("Strength")) {
                            singleEncounterRequirements.add(new Requirement("Strength", player.getLevel("Strength")));
                        }
                    }
                    else if (rangedCombatResults.getHpLost() < 1000000) {
                        loadout = rangedCombatResults.getLoadoutUsed();
                        player.setXp(loadout.getXp());
                        if (player.getXp().get("Ranged") > initialXP.get("Ranged")) {
                            singleEncounterRequirements.add(new Requirement("Ranged", player.getLevel("Ranged")));
                        }
                    }
                    else if (magicCombatResults.getHpLost() < 1000000) {
                        loadout = magicCombatResults.getLoadoutUsed();
                        player.setXp(loadout.getXp());
                        if (player.getXp().get("Magic") > initialXP.get("Magic")) {
                            singleEncounterRequirements.add(new Requirement("Magic", player.getLevel("Magic")));
                        }
                    }
                    if (player.getXp().get("Defence") > initialXP.get("Defence")) {
                        singleEncounterRequirements.add(new Requirement("Defence", player.getLevel("Defence")));
                    }
                    if (player.getXp().get("Constitution") > initialXP.get("Constitution")) {
                        singleEncounterRequirements.add(new Requirement("Constitution", player.getLevel("Constitution")));
                    }
                    if (player.getXp().get("Summoning") > initialXP.get("Summoning")) {
                        singleEncounterRequirements.add(new Requirement("Summoning", player.getLevel("Summoning")));
                    }
                    if (player.getXp().get("Herblore") > initialXP.get("Herblore")) {
                        singleEncounterRequirements.add(new Requirement("Herblore", player.getLevel("Herblore")));
                    }
                    if (!initialArmours.contains(loadout.getHead()) && !loadout.getHead().equals(Armour.getArmourByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getHead().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getTorso()) && !loadout.getTorso().equals(Armour.getArmourByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getTorso().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getLegs()) && !loadout.getLegs().equals(Armour.getArmourByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getLegs().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getHands()) && !loadout.getHands().equals(Armour.getArmourByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getHands().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getFeet()) && !loadout.getFeet().equals(Armour.getArmourByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getFeet().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getRing()) && !loadout.getRing().equals(Armour.getArmourByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getRing().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getNeck()) && !loadout.getNeck().equals(Armour.getArmourByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getNeck().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getCape()) && !loadout.getCape().equals(Armour.getArmourByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getCape().getName(), 1));
                    }
                    if (!initialWeapons.contains(loadout.getMainWep())) {
                        singleEncounterRequirements.add(new Requirement(loadout.getMainWep().getName(), 1));
                    }
                    if (!initialWeapons.contains(loadout.getOffWep()) && !loadout.getOffWep().equals(Weapon.getWeaponByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getOffWep().getName(), 1));
                    }
                    if (!initialArmours.contains(loadout.getShield()) && !loadout.getShield().equals(Armour.getArmourByName("None"))) {
                        singleEncounterRequirements.add(new Requirement(loadout.getShield().getName(), 1));
                    }
                    break;
                }
            }
            if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000) {
                singleEncounterRequirements.add(new Requirement("Fight is impossible", 2147000));
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
                ticksOnFights += minEncounterTime;
            }
            combineRequirements(allEncounterReqsMap, singleEncounterRequirements);
        }
        for (Entry<String, Integer> req : allEncounterReqsMap.entrySet()) {
            if (Weapon.getWeaponByName(req.getKey()) != null || Armour.getArmourByName(req.getKey())!= null) {
                allEncounterRequirements.add(new Requirement(req.getKey(), 1));
            } else {
                allEncounterRequirements.add(new Requirement(req.getKey(), req.getValue()));
            }
        }
        if (ticksOnFights > 0) {
            allEncounterRequirements.add(new Requirement("Time spent on scripted fights", ticksOnFights));
        }
        player.setXp(initialXP);
        player.setWeapons(initialWeapons);
        player.setArmour(initialArmours);
        return allEncounterRequirements;
    }

    public GoalResults getTimeForRequirements(Player player) {
        double totalTimeForAllReqs = 0;
        Map<String, Double> totalActionsWithTimesForAllReqs = new HashMap<>();
        List<Requirement> trueReqs = getTrueRequirements(player);
        int totalCoinReq = 0;
        for (Requirement r : trueReqs) {
            if (ItemDatabase.getItemDatabase().getItems().get(r.getQualifier()) != null) {
                totalCoinReq += ItemDatabase.getItemDatabase().getItems().get(r.getQualifier()).coinValue(player)*r.getQuantifier();
            } else {
                GoalResults resultsForOneRequirement = r.timeAndActionsToMeetRequirement(player);
                for (Entry<String, Double> actionWithTime : resultsForOneRequirement.getActionsWithTimes().entrySet()) {
                    if (totalActionsWithTimesForAllReqs.containsKey(actionWithTime.getKey())) {
                        totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), Math.max(totalActionsWithTimesForAllReqs.get(actionWithTime.getKey()), actionWithTime.getValue()));
                    } else {
                        totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), actionWithTime.getValue());
                    }
                }
            }
        }
        if (totalCoinReq > 0) {
            GoalResults resultsForOneRequirement = new Requirement("Coins", totalCoinReq).timeAndActionsToMeetRequirement(player);
            for (Entry<String, Double> actionWithTime : resultsForOneRequirement.getActionsWithTimes().entrySet()) {
                if (totalActionsWithTimesForAllReqs.containsKey(actionWithTime.getKey())) {
                    totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), Math.max(totalActionsWithTimesForAllReqs.get(actionWithTime.getKey()), actionWithTime.getValue()));
                } else {
                    totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), actionWithTime.getValue());
                }
            }
        }
        for (Entry<String, Double> action : totalActionsWithTimesForAllReqs.entrySet()) {
            totalTimeForAllReqs += action.getValue();
        }
        return new GoalResults(totalTimeForAllReqs, totalActionsWithTimesForAllReqs, trueReqs);
    }

    public double getGainFromRewards(Player player) {
        double totalGainFromAllRewards = 0;
        for (Reward r : rewards) {
            totalGainFromAllRewards += r.getGainFromReward(player);
        }
        final Map<String, Double> initialXP = new HashMap<>(player.getXp());
        for (Encounter e : encounters) {
            CombatResults meleeCombatResults = e.calculateCombat(player, new CombatParameters(28, "Melee", false, 0, false));
            CombatResults rangedCombatResults = e.calculateCombat(player, new CombatParameters(28, "Ranged", false, 0, false));
            CombatResults magicCombatResults = e.calculateCombat(player, new CombatParameters(28, "Magic", false, 0, false));
            for (List<Enemy> enemyGroup : e.getEnemyGroups()) {
                for (Enemy enemy : enemyGroup) {
                    totalGainFromAllRewards += player.efficientGoalCompletion("Constitution", (int) enemy.getHpxp()/e.getPartySize()).getTotalTime();
                    if (rangedCombatResults.getHpLost() < meleeCombatResults.getHpLost() && rangedCombatResults.getHpLost() < magicCombatResults.getHpLost()) {
                        totalGainFromAllRewards += player.efficientGoalCompletion("rCombat", (int) enemy.getCbxp()/e.getPartySize()).getTotalTime();
                    }
                    else if (meleeCombatResults.getHpLost() < magicCombatResults.getHpLost()) {
                        totalGainFromAllRewards += player.efficientGoalCompletion("mCombat", (int) enemy.getCbxp()/e.getPartySize()).getTotalTime();
                    }
                    else {
                        totalGainFromAllRewards += player.efficientGoalCompletion("aCombat", (int) enemy.getCbxp()/e.getPartySize()).getTotalTime();
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