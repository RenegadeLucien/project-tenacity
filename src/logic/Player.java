package logic;


import data.databases.*;
import data.dataobjects.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class Player implements java.io.Serializable {

    public static final ArrayList<String> ALL_SKILLS = new ArrayList<>(Arrays.asList("Agility", "Attack",
        "Constitution", "Construction", "Cooking", "Crafting", "Defense", "Divination",
        "Dungeoneering", "Farming", "Firemaking", "Fishing", "Fletching", "Herblore",
        "Hunter", "Invention", "Magic", "Mining", "Prayer", "Ranged", "Runecrafting",
        "Slayer", "Smithing", "Strength", "Summoning", "Thieving", "Woodcutting"));

    public static final ArrayList<String> PORTS_SKILLS = new ArrayList<>(Arrays.asList("Agility", "Construction", "Cooking",
        "Divination", "Dungeoneering", "Fishing", "Herblore", "Hunter", "Prayer", "Runecrafting", "Slayer", "Thieving"));

    public static final ArrayList<String> COMBAT_STYLES = new ArrayList<>(Arrays.asList("Melee", "Ranged", "Magic"));

    private static final long serialVersionUID = 1L;

    private String name;
    private int status; //0 = mainscape, 1 = ironman, 2 = HCIM
    private Map<Achievement, Double> playerTasks = new LinkedHashMap<>();
    private Map<Achievement, GoalResults> taskDetails = new HashMap<>();
    private Map<String, Double> xp = new HashMap<>();
    private Map<String, Integer> qualities = new HashMap<>();
    private Map<String, Integer> bank = new HashMap<>();
    private List<Weapon> weapons = new ArrayList<>();
    private List<Armour> armour = new ArrayList<>();
    private List<Food> food = new ArrayList<>();

    public Player(String name, String status) {
        this.name = name;
        if (status.equals("Mainscape"))
            this.status = 0;
        else if (status.equals("Ironman"))
            this.status = 1;
        else if (status.equals("Hardcore"))
            this.status = 2;
        xp = setInitialXP();
        for (Achievement t : AchievementDatabase.getAchievementDatabase().getAchievements()) {
            taskDetails.put(t, new GoalResults(1000000000.0, Map.of("Impossible", 1000000000.0)));
            playerTasks.put(t, 1000000000.0);
        }
        calcAllAchievements();
    }

    public Map<Achievement, Double> getPlayerTasks() {
        return playerTasks;
    }

    public Map<Achievement, GoalResults> getTaskDetails() {
        return taskDetails;
    }

    public Map<String, Double> getXp() {
        return xp;
    }

    public Map<String, Integer> getBank() {
        return bank;
    }

    public Map<String, Integer> getQualities() {
        return qualities;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Armour> getArmour() {
        return armour;
    }

    public List<Food> getFood() {
        return food;
    }

    public int getStatus() {
        return status;
    }

    public void setWeapons(List<Weapon> newWeapons) {
        weapons = newWeapons;
    }

    public void setArmour(List<Armour> newArmour) {
        armour = newArmour;
    }

    public void setXp(Map<String, Double> newXp) {
        xp = newXp;
    }

    public Map<String, Double> setInitialXP() {
        Map<String, Double> initialXP = new HashMap<>();
        for (String skill : Player.ALL_SKILLS) {
            initialXP.put(skill, 0.0);
        }
        initialXP.put("Constitution", 1154.0);
        return initialXP;
    }

    public int getLevel(String skill) {
        double skillXp = xp.get(skill);
        int level = 1;
        int sumXP = 0;
        while (true) {
            sumXP += Math.floor(level + 300 * Math.pow(2, level / 7.0));
            int xpToLevel = (int) Math.floor(sumXP / 4);
            if (xpToLevel > skillXp) {
                return level;
            } else {
                level++;
            }
        }
    }

    public double calcCombatLevel() {
        return (13 * Math.max(getLevel("Attack") + getLevel("Strength"), Math.max(getLevel("Ranged") * 2, getLevel("Magic") * 2)) / 10.0 +
            getLevel("Defense") + getLevel("Constitution") + getLevel("Prayer") / 2 + getLevel("Summoning") / 2) / 4.0;
    }

    public int getXpToLevel(String skill, int level) {
        double skillXp = xp.get(skill);
        int intermediateLevel = 1;
        int sumXP = 0;
        while (intermediateLevel < level) {
            sumXP += Math.floor(intermediateLevel + 300 * Math.pow(2, intermediateLevel / 7.0));
            intermediateLevel++;
        }
        sumXP = (int) Math.floor(sumXP / 4);
        return Math.max(0, sumXP - (int) skillXp);
    }

    public List<Loadout> generateLoadouts(String combatStyle) {
        if (!COMBAT_STYLES.contains(combatStyle)) {
            throw new RuntimeException("Invalid combat style, must be either Melee, Ranged, or Magic");
        }
        List<Loadout> loadouts = new ArrayList<>();
        List<Weapon> weaponList = new ArrayList<>();
        List<Armour> headArmour = new ArrayList<>();
        List<Armour> torsoArmour = new ArrayList<>();
        List<Armour> legArmour = new ArrayList<>();
        List<Armour> handArmour = new ArrayList<>();
        List<Armour> feetArmour = new ArrayList<>();
        List<Ammo> ammoList = new ArrayList<>();
        for (Weapon w : WeaponDatabase.getWeaponDatabase().getWeapons()) {
            if (w.getWeaponClass().equals(combatStyle)) {
                weaponList.add(w);
            }
        }
        for (Armour a : ArmourDatabase.getArmourDatabase().getArmours()) {
            if (a.getSlot().equals("Head") && a.getType().equals(combatStyle)) {
                headArmour.add(a);
            } else if (a.getSlot().equals("Torso") && a.getType().equals(combatStyle)) {
                torsoArmour.add(a);
            } else if (a.getSlot().equals("Legs") && a.getType().equals(combatStyle)) {
                legArmour.add(a);
            } else if (a.getSlot().equals("Hands") && a.getType().equals(combatStyle)) {
                handArmour.add(a);
            } else if (a.getSlot().equals("Feet") && a.getType().equals(combatStyle)) {
                feetArmour.add(a);
            }
        }
        for (Ammo am : AmmoDatabase.getAmmoDatabase().getAmmos()) {
            if (am.getStyle().equals(combatStyle)) {
                ammoList.add(am);
            }
        }
        if (headArmour.size() == 0) {
            headArmour.add(Armour.getArmourByName("None"));
        }
        if (torsoArmour.size() == 0) {
            torsoArmour.add(Armour.getArmourByName("None"));
        }
        if (legArmour.size() == 0) {
            legArmour.add(Armour.getArmourByName("None"));
        }
        if (handArmour.size() == 0) {
            handArmour.add(Armour.getArmourByName("None"));
        }
        if (feetArmour.size() == 0) {
            feetArmour.add(Armour.getArmourByName("None"));
        }
        if (ammoList.size() == 0) {
            ammoList.add(Ammo.getAmmoByName("None"));
        }
        for (Weapon w : weaponList)
            for (Food f : Food.values())
                for (Armour head : headArmour)
                    for (Armour torso : torsoArmour)
                        for (Armour leg : legArmour)
                            for (Armour hand : handArmour)
                                for (Armour foot : feetArmour)
                                    for (Ammo ammo : ammoList)
                                        loadouts.add(new Loadout(w, f, head, torso, leg, hand, foot, ammo));
        //System.out.println(loadouts.size());
        return loadouts;
    }

    public void calcAllAchievements() {
        long time = System.nanoTime();
        for (Entry<Achievement, Double> taskWithTime : playerTasks.entrySet()) {
            Achievement t = taskWithTime.getKey();
            GoalResults actionsAndTime = t.getTimeForRequirements(this);
            playerTasks.put(t, t.getTime() + actionsAndTime.getTotalTime() - t.getGainFromRewards(this));
            taskDetails.put(t, actionsAndTime);
        }
        System.out.println((System.nanoTime() - time) / 1000000000.0);
        System.out.println("====================================");
    }

    public void completeTask(Achievement task) {
        for (Requirement requirement : task.getReqs()) {
            if (Achievement.getAchievementByName(requirement.getQualifier()) != null && playerTasks.containsKey(Achievement.getAchievementByName(requirement.getQualifier()))) {
                completeTask(Achievement.getAchievementByName(requirement.getQualifier()));
            } else if (ALL_SKILLS.contains(requirement.getQualifier())) {
                xp.put(requirement.getQualifier(), xp.get(requirement.getQualifier()) + getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
            } else if (Item.getItemByName(requirement.getQualifier()) != null) {
                if (bank.containsKey(requirement.getQualifier())) {
                    if (bank.get(requirement.getQualifier()) > requirement.getQuantifier()) {
                        bank.put(requirement.getQualifier(), (bank.get(requirement.getQualifier()) - requirement.getQuantifier()));
                    } else {
                        bank.remove(requirement.getQualifier());
                    }
                }
            } else if (!requirement.meetsRequirement(this)) {
                if (qualities.containsKey(requirement.getQualifier()))
                    qualities.put(requirement.getQualifier(), Math.max(qualities.get(requirement.getQualifier()), requirement.getQuantifier()));
                else
                    qualities.put(requirement.getQualifier(), requirement.getQuantifier());
            }
        }
        ArrayList<Reward> rewards = new ArrayList<>(task.getRewards());
        for (Lamp lamp : task.getLamps()) {
            rewards.add(lamp.getBestReward(this));
        }
        for (Reward reward : rewards) {
            if (ALL_SKILLS.contains(reward.getQualifier())) {
                xp.put(reward.getQualifier(), xp.get(reward.getQualifier()) + reward.getQuantifier());
            } else if (Item.getItemByName(reward.getQualifier()) != null) {
                if (bank.containsKey(reward.getQualifier()))
                    bank.put(reward.getQualifier(), bank.get(reward.getQualifier()) + reward.getQuantifier());
                else
                    bank.put(reward.getQualifier(), reward.getQuantifier());
            } else {
                if (qualities.containsKey(reward.getQualifier()))
                    qualities.put(reward.getQualifier(), qualities.get(reward.getQualifier()) + reward.getQuantifier());
                else
                    qualities.put(reward.getQualifier(), reward.getQuantifier());
            }

        }
        for (Encounter encounter : task.getEncounters()) {
            for (List<Enemy> enemyGroup : encounter.getEnemyGroups()) {
                for (Enemy enemy : enemyGroup) {
                    xp.put("Constitution", xp.get("Constitution") + enemy.getHpxp());
                    //xp.put("Attack", xp.get("Attack") + enemy.getCbxp());
                }
            }
        }

        playerTasks.remove(task);
        taskDetails.remove(task);
        calcAllAchievements();
    }

    public GoalResults efficientGoalCompletion(String qualifier, int quantifier) {
        if (qualifier.equals("Coins")) {
            double money = 0;
            String bestAction = "";
            for (Action action : ActionDatabase.getActionDatabase(this).getDatabase()) {
                double moneyForThisAction = action.moneyFromAction(this);
                if (moneyForThisAction > money) {
                    money = moneyForThisAction;
                    bestAction = action.getName();
                }
            }
            //System.out.println("Best effective rate of money is " + money + " GP per hour.");
            return new GoalResults(quantifier / money, Map.of(bestAction, quantifier / money));
        } else if (qualifier.equals("Quest points")) {
            double questTotalTime = 0;
            Map <String, Double> questTotalActions = new HashMap<>();
            Map<Achievement, Double> questPointMap = new LinkedHashMap<>();
            for (Achievement achievement : playerTasks.keySet()) {
                List<Reward> questPointReward = achievement.getRewards().stream().filter(a -> a.getQualifier().equals("Quest points")).collect(Collectors.toList());
                List<Requirement> questPointRequirements = achievement.getReqs().stream().filter(a -> a.getQualifier().equals("Quest points")).collect(Collectors.toList());
                if (questPointReward.size() > 0 && questPointRequirements.size() == 0) {
                    questPointMap.put(achievement, playerTasks.get(achievement)/questPointReward.get(0).getQuantifier());
                }
                questPointMap = questPointMap.entrySet().stream().sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
                    .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                    ));
            }
            int questpoints = 0;
            if (qualities.size() > 0) {
                questpoints = qualities.get("Quest points");
            }
            while (questpoints < quantifier && questPointMap.size() > 0) {
                Achievement quest = questPointMap.keySet().iterator().next();
                GoalResults oneQuestResults = quest.getTimeForRequirements(this);
                questTotalTime += oneQuestResults.getTotalTime();
                addItemsToMap(questTotalActions, oneQuestResults.getActionsWithTimes());
                questpoints += quest.getRewards().stream().filter(a -> a.getQualifier().equals("Quest points")).collect(Collectors.toList()).get(0).getQuantifier();
                questPointMap.remove(quest);
            }
            if (questpoints < quantifier) {
                questTotalTime = 1000000000.0;
            }
            return new GoalResults(questTotalTime, questTotalActions);
        } else if (qualifier.equals("Combat")) {
            Map<String, Double> originalMap = this.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
            double levelingByMelee = 0;
            double levelingByRanged = 0;
            double levelingByMagic = 0;
            Map<String, Double> meleeMap = new HashMap();
            Map<String, Double> rangedMap = new HashMap();
            Map<String, Double> magicMap = new HashMap();
            //Using melee
            while (this.calcCombatLevel() < quantifier) {
                double attack = 0.325 / this.efficientGoalCompletion("mCombat", this.getXpToLevel("Attack", this.getLevel("Attack") + 1)).getTotalTime();
                double strength = 0.325 / this.efficientGoalCompletion("mCombat", this.getXpToLevel("Strength", this.getLevel("Strength") + 1)).getTotalTime();
                double defense = 0.25 / this.efficientGoalCompletion("mCombat", this.getXpToLevel("Defense", this.getLevel("Defense") + 1)).getTotalTime();
                double prayer = 0.25 / this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer") + 1)).getTotalTime();
                double summ = 0.25 / this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning") + 1)).getTotalTime();
                GoalResults bestSubReq = null;
                if (attack > strength && attack > defense && attack > prayer && attack > summ) {
                    bestSubReq = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Attack", this.getLevel("Attack") + 1));
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Attack", this.getLevel("Attack") + 1) / 3);
                    this.getXp().put("Attack", this.getXp().get("Attack") + this.getXpToLevel("Attack", this.getLevel("Attack") + 1));
                } else if (strength > defense && strength > prayer && strength > summ) {
                    bestSubReq = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Strength", this.getLevel("Strength") + 1));
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Strength", this.getLevel("Strength") + 1) / 3);
                    this.getXp().put("Strength", this.getXp().get("Strength") + this.getXpToLevel("Strength", this.getLevel("Strength") + 1));
                } else if (defense > prayer && defense > summ) {
                    bestSubReq = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Defense", this.getLevel("Defense") + 1));
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Defense", this.getLevel("Defense") + 1) / 3);
                    this.getXp().put("Defense", this.getXp().get("Defense") + this.getXpToLevel("Defense", this.getLevel("Defense") + 1));
                } else if (prayer > summ) {
                    bestSubReq = this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer") + 1));
                    this.getXp().put("Prayer", this.getXp().get("Prayer") + this.getXpToLevel("Prayer", ((this.getLevel("Prayer") / 2) + 1) * 2));
                } else {
                    bestSubReq = this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning") + 1));
                    this.getXp().put("Summoning", this.getXp().get("Summoning") + this.getXpToLevel("Summoning", ((this.getLevel("Summoning") / 2) + 1) * 2));
                }
                levelingByMelee += bestSubReq.getTotalTime();
                if (meleeMap.keySet().contains(bestSubReq.getActionsWithTimes().keySet().iterator().next()))
                    meleeMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(bestSubReq.getActionsWithTimes().keySet().iterator().next()) + bestSubReq.getTotalTime());
                else
                    meleeMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), bestSubReq.getTotalTime());
            }
            this.setXp(originalMap);
            originalMap = this.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
            //Using ranged
            while (this.calcCombatLevel() < quantifier) {
                double ranged = 0.65 / this.efficientGoalCompletion("rCombat", this.getXpToLevel("Ranged", this.getLevel("Ranged") + 1)).getTotalTime();
                double defense = 0.25 / this.efficientGoalCompletion("rCombat", this.getXpToLevel("Defense", this.getLevel("Defense") + 1)).getTotalTime();
                double prayer = 0.25 / this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer") + 1)).getTotalTime();
                double summ = 0.25 / this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning") + 1)).getTotalTime();
                GoalResults bestSubReq = null;
                if (ranged > defense && ranged > prayer && ranged > summ) {
                    bestSubReq = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Ranged", this.getLevel("Ranged") + 1));
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Ranged", this.getLevel("Ranged") + 1) / 3);
                    this.getXp().put("Ranged", this.getXp().get("Ranged") + this.getXpToLevel("Ranged", this.getLevel("Ranged") + 1));
                } else if (defense > prayer && defense > summ) {
                    bestSubReq = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Defense", this.getLevel("Defense") + 1));
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Defense", this.getLevel("Defense") + 1) / 3);
                    this.getXp().put("Defense", this.getXp().get("Defense") + this.getXpToLevel("Defense", this.getLevel("Defense") + 1));
                } else if (prayer > summ) {
                    bestSubReq = this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer") + 1));
                    this.getXp().put("Prayer", this.getXp().get("Prayer") + this.getXpToLevel("Prayer", ((this.getLevel("Prayer") / 2) + 1) * 2));
                } else {
                    bestSubReq = this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning") + 1));
                    this.getXp().put("Summoning", this.getXp().get("Summoning") + this.getXpToLevel("Summoning", ((this.getLevel("Summoning") / 2) + 1) * 2));
                }
                levelingByRanged += bestSubReq.getTotalTime();
                if (rangedMap.keySet().contains(bestSubReq.getActionsWithTimes().keySet().iterator().next()))
                    rangedMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(bestSubReq.getActionsWithTimes().keySet().iterator().next()) + bestSubReq.getTotalTime());
                else
                    rangedMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), bestSubReq.getTotalTime());
            }
            this.setXp(originalMap);
            originalMap = this.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
            //Using magic
            while (this.calcCombatLevel() < quantifier) {
                double magic = 0.65 / this.efficientGoalCompletion("aCombat", this.getXpToLevel("Magic", this.getLevel("Magic") + 1)).getTotalTime();
                double defense = 0.25 / this.efficientGoalCompletion("aCombat", this.getXpToLevel("Defense", this.getLevel("Defense") + 1)).getTotalTime();
                double prayer = 0.25 / this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer") + 1)).getTotalTime();
                double summ = 0.25 / this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning") + 1)).getTotalTime();
                GoalResults bestSubReq = null;
                if (magic > defense && magic > prayer && magic > summ) {
                    bestSubReq = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Magic", this.getLevel("Magic") + 1));
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Magic", this.getLevel("Magic") + 1) / 3);
                    this.getXp().put("Magic", this.getXp().get("Magic") + this.getXpToLevel("Magic", this.getLevel("Magic") + 1));
                } else if (defense > prayer && defense > summ) {
                    bestSubReq = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Defense", this.getLevel("Defense") + 1));
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Defense", this.getLevel("Defense") + 1) / 3);
                    this.getXp().put("Defense", this.getXp().get("Defense") + this.getXpToLevel("Defense", this.getLevel("Defense") + 1));
                } else if (prayer > summ) {
                    bestSubReq = this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer") + 1));
                    this.getXp().put("Prayer", this.getXp().get("Prayer") + this.getXpToLevel("Prayer", ((this.getLevel("Prayer") / 2) + 1) * 2));
                } else {
                    bestSubReq = this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning") + 1));
                    this.getXp().put("Summoning", this.getXp().get("Summoning") + this.getXpToLevel("Summoning", ((this.getLevel("Summoning") / 2) + 1) * 2));
                }
                levelingByMagic += bestSubReq.getTotalTime();
                if (magicMap.keySet().contains(bestSubReq.getActionsWithTimes().keySet().iterator().next()))
                    magicMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), magicMap.get(bestSubReq.getActionsWithTimes().keySet().iterator().next()) + bestSubReq.getTotalTime());
                else
                    magicMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), bestSubReq.getTotalTime());
            }
            this.setXp(originalMap);
            if (levelingByMelee < levelingByMagic && levelingByMelee < levelingByRanged) {
                return new GoalResults(levelingByMelee, meleeMap);
            } else if (levelingByRanged < levelingByMagic) {
                return new GoalResults(levelingByRanged, rangedMap);
            } else {
                return new GoalResults(levelingByMagic, magicMap);
            }
        }
        double minimum = Double.POSITIVE_INFINITY;
        String minAction = qualifier;
        Map<String, Double> efficiency = new HashMap<>();
        for (Action action : ActionDatabase.getActionDatabase(this).getDatabase()) {
            if (action.getOutputs().containsKey(qualifier)) {
                double effectiveTimeThisAction = 0.0;
                Map<String,Double> recursiveActions = new HashMap<>();
                for (Requirement requirement : action.getReqs()) {
                    if (requirement.getQualifier().equals(qualifier) && !requirement.meetsRequirement(this)) {
                        // avoids a stack overflow (trying to train to unlock an action by training to unlock that action by training to unlock that action...)
                        effectiveTimeThisAction += 9999999;
                        break;
                    } else {
                        GoalResults reqResults = requirement.timeAndActionsToMeetRequirement(this);
                        effectiveTimeThisAction += reqResults.getTotalTime();
                    }
                }
                effectiveTimeThisAction += quantifier / action.effectiveRate(qualifier, this);
                if (effectiveTimeThisAction < minimum) {
                    minimum = effectiveTimeThisAction;
                    minAction = action.getName();
                    efficiency = recursiveActions;
                }
            }
        }
        if (minimum == Double.POSITIVE_INFINITY) {
            minimum = 1000000000.0;
        }
        efficiency.put(minAction, minimum);
        //System.out.println(minReqs);
        //System.out.println(efficiency);
        //System.out.println(minAction + " will achieve " + quantifier + " " +qualifier + " in " + minimum + " hours.");
        return new GoalResults(minimum, efficiency);
    }

    public Map addItemsToMap(Map<String, Double> a, Map<String, Double> b) {
        for (String item : b.keySet()) {
            if (a.containsKey(item)) {
                a.put(item, a.get(item) + b.get(item));
            } else {
                a.put(item, b.get(item));
            }
        }
        return a;
    }
}