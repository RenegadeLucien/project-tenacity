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

    private Map<Integer, GoalResults> combatCalcResults = new HashMap<>();

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
        List<Armour> capeArmour = new ArrayList<>();
        List<Armour> neckArmour = new ArrayList<>();
        List<Armour> ringArmour = new ArrayList<>();
        List<Ammo> ammoList = new ArrayList<>();
        List<Familiar> familiarList = new ArrayList<>();
        List<Prayer> prayerList = new ArrayList<>();
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
            } else if (a.getSlot().equals("Cape") && (a.getType().equals(combatStyle) || a.getType().equals("All"))) {
                capeArmour.add(a);
            } else if (a.getSlot().equals("Neck") && (a.getType().equals(combatStyle) || a.getType().equals("All"))) {
                neckArmour.add(a);
            } else if (a.getSlot().equals("Ring") && (a.getType().equals(combatStyle) || a.getType().equals("All"))) {
                ringArmour.add(a);
            }
        }
        for (Ammo am : AmmoDatabase.getAmmoDatabase().getAmmos()) {
            if (am.getStyle().equals(combatStyle)) {
                ammoList.add(am);
            }
        }
        for (Familiar f : FamiliarDatabase.getFamiliarDatabase().getFamiliars()) {
            familiarList.add(f);
        }
        for (Prayer p : PrayerDatabase.getPrayerDatabase().getPrayers()) {
            prayerList.add(p);
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
        if (capeArmour.size() == 0) {
            capeArmour.add(Armour.getArmourByName("None"));
        }
        if (neckArmour.size() == 0) {
            neckArmour.add(Armour.getArmourByName("None"));
        }
        if (ringArmour.size() == 0) {
            ringArmour.add(Armour.getArmourByName("None"));
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
                                    for (Armour cape : capeArmour)
                                        for (Armour neck : neckArmour)
                                            for (Armour ring : ringArmour)
                                                for (Ammo ammo : ammoList)
                                                    for (Familiar familiar : familiarList)
                                                        for (Prayer prayer : prayerList)
                                                            loadouts.add(new Loadout(w, f, head, torso, leg, hand, foot, cape, neck, ring, ammo, familiar, prayer));
        //System.out.println(loadouts.size());
        return loadouts;
    }

    public void calcAllAchievements() {
        long time = System.nanoTime();
        combatCalcResults.clear();
        for (Entry<Achievement, Double> taskWithTime : playerTasks.entrySet()) {
            System.out.print(taskWithTime.getKey().getName() + "\t");
            long taskTime = System.nanoTime();
            Achievement t = taskWithTime.getKey();
            GoalResults actionsAndTime = t.getTimeForRequirements(this);
            playerTasks.put(t, t.getTime() + actionsAndTime.getTotalTime() - t.getGainFromRewards(this));
            taskDetails.put(t, actionsAndTime);
            System.out.println((System.nanoTime() - taskTime) / 1000000000.0);
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
        Requirement thisGoal = new Requirement(qualifier, quantifier);
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
                if (questPointReward.size() > 0) {
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
            if (qualities.containsKey("Quest points")) {
                questpoints = qualities.get("Quest points");
            }
            while (questpoints < quantifier && questPointMap.size() > 0) {
                Achievement quest = questPointMap.keySet().iterator().next();
                Requirement questPointRequirement = null;
                for (Requirement r : quest.getReqs()) {
                    if (r.getQualifier().equals("Quest points")) {
                        questPointRequirement = r;
                        break;
                    }
                }
                if (questPointRequirement != null) {
                    quest.getReqs().remove(questPointRequirement);
                }
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
            //since the combat calculations give the same result every time, utilize a lookup table to speed up program
            if (combatCalcResults.containsKey(quantifier)) {
                return combatCalcResults.get(quantifier);
            }
            int targetLevel = (int)Math.floor(quantifier/1.4);
            GoalResults attack = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Attack", targetLevel));
            GoalResults strength = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Strength", targetLevel));
            GoalResults meleeDefense = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Defense", targetLevel));
            GoalResults rangedDefense = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Defense", targetLevel));
            GoalResults magicDefense = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Defense", targetLevel));
            GoalResults defense;
            if (meleeDefense.getTotalTime() < Math.min(rangedDefense.getTotalTime(), magicDefense.getTotalTime())) {
                defense = meleeDefense;
            }
            else if (rangedDefense.getTotalTime() < magicDefense.getTotalTime()) {
                defense = rangedDefense;
            }
            else  {
                defense = magicDefense;
            }
            GoalResults ranged = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Ranged", targetLevel));
            GoalResults magic = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Magic", targetLevel));
            GoalResults prayer = this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", targetLevel));
            GoalResults summ = this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", targetLevel));
            GoalResults hp = this.efficientGoalCompletion("Constitution", this.getXpToLevel("Constitution", targetLevel));
            Map<String,Double> meleeMap = new HashMap();
            Map<String,Double> rangedMap = new HashMap();
            Map<String,Double> magicMap = new HashMap();
            meleeMap.put(attack.getActionsWithTimes().keySet().iterator().next(), attack.getTotalTime());
            if (meleeMap.keySet().contains(strength.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(strength.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(strength.getActionsWithTimes().keySet().iterator().next()) + strength.getTotalTime());
            else
                meleeMap.put(strength.getActionsWithTimes().keySet().iterator().next(), strength.getTotalTime());
            if (meleeMap.keySet().contains(defense.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(defense.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(defense.getActionsWithTimes().keySet().iterator().next()) + defense.getTotalTime());
            else
                meleeMap.put(defense.getActionsWithTimes().keySet().iterator().next(), defense.getTotalTime());
            if (meleeMap.keySet().contains(prayer.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(prayer.getActionsWithTimes().keySet().iterator().next()) + prayer.getTotalTime());
            else
                meleeMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), prayer.getTotalTime());
            if (meleeMap.keySet().contains(summ.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(summ.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(summ.getActionsWithTimes().keySet().iterator().next()) + summ.getTotalTime());
            else
                meleeMap.put(summ.getActionsWithTimes().keySet().iterator().next(), summ.getTotalTime());
            if (meleeMap.keySet().contains(hp.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(hp.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(hp.getActionsWithTimes().keySet().iterator().next()) + hp.getTotalTime());
            else
                meleeMap.put(hp.getActionsWithTimes().keySet().iterator().next(), hp.getTotalTime());
            rangedMap.put(ranged.getActionsWithTimes().keySet().iterator().next(), ranged.getTotalTime());
            if (rangedMap.keySet().contains(defense.getActionsWithTimes().keySet().iterator().next()))
                rangedMap.put(defense.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(defense.getActionsWithTimes().keySet().iterator().next()) + defense.getTotalTime());
            else
                rangedMap.put(defense.getActionsWithTimes().keySet().iterator().next(), defense.getTotalTime());
            if (rangedMap.keySet().contains(prayer.getActionsWithTimes().keySet().iterator().next()))
                rangedMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(prayer.getActionsWithTimes().keySet().iterator().next()) + prayer.getTotalTime());
            else
                rangedMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), prayer.getTotalTime());
            if (rangedMap.keySet().contains(summ.getActionsWithTimes().keySet().iterator().next()))
                rangedMap.put(summ.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(summ.getActionsWithTimes().keySet().iterator().next()) + summ.getTotalTime());
            else
                rangedMap.put(summ.getActionsWithTimes().keySet().iterator().next(), summ.getTotalTime());
            if (rangedMap.keySet().contains(hp.getActionsWithTimes().keySet().iterator().next()))
                rangedMap.put(hp.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(hp.getActionsWithTimes().keySet().iterator().next()) + hp.getTotalTime());
            else
                rangedMap.put(hp.getActionsWithTimes().keySet().iterator().next(), hp.getTotalTime());
            magicMap.put(magic.getActionsWithTimes().keySet().iterator().next(), magic.getTotalTime());
            if (magicMap.keySet().contains(defense.getActionsWithTimes().keySet().iterator().next()))
                magicMap.put(defense.getActionsWithTimes().keySet().iterator().next(), magicMap.get(defense.getActionsWithTimes().keySet().iterator().next()) + defense.getTotalTime());
            else
                magicMap.put(defense.getActionsWithTimes().keySet().iterator().next(), defense.getTotalTime());
            if (magicMap.keySet().contains(prayer.getActionsWithTimes().keySet().iterator().next()))
                magicMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), magicMap.get(prayer.getActionsWithTimes().keySet().iterator().next()) + prayer.getTotalTime());
            else
                magicMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), prayer.getTotalTime());
            if (magicMap.keySet().contains(summ.getActionsWithTimes().keySet().iterator().next()))
                magicMap.put(summ.getActionsWithTimes().keySet().iterator().next(), magicMap.get(summ.getActionsWithTimes().keySet().iterator().next()) + summ.getTotalTime());
            else
                magicMap.put(summ.getActionsWithTimes().keySet().iterator().next(), summ.getTotalTime());
            if (magicMap.keySet().contains(hp.getActionsWithTimes().keySet().iterator().next()))
                magicMap.put(hp.getActionsWithTimes().keySet().iterator().next(), magicMap.get(hp.getActionsWithTimes().keySet().iterator().next()) + hp.getTotalTime());
            else
                magicMap.put(hp.getActionsWithTimes().keySet().iterator().next(), hp.getTotalTime());
            if (attack.getTotalTime() + strength.getTotalTime() < ranged.getTotalTime() && attack.getTotalTime() + strength.getTotalTime() < magic.getTotalTime()) {
                GoalResults result = new GoalResults(attack.getTotalTime()+strength.getTotalTime()+defense.getTotalTime()+prayer.getTotalTime()+summ.getTotalTime()+hp.getTotalTime(), meleeMap);
                combatCalcResults.put(quantifier, result);
                return result;
            } else if (ranged.getTotalTime() < magic.getTotalTime()) {
                GoalResults result = new GoalResults(ranged.getTotalTime()+defense.getTotalTime()+prayer.getTotalTime()+summ.getTotalTime()+hp.getTotalTime(), rangedMap);
                combatCalcResults.put(quantifier, result);
                return result;
            } else {
                GoalResults result = new GoalResults(magic.getTotalTime()+defense.getTotalTime()+prayer.getTotalTime()+summ.getTotalTime()+hp.getTotalTime(), magicMap);
                combatCalcResults.put(quantifier, result);
                return result;
            }
        }
        double minimum = Double.POSITIVE_INFINITY;
        String minAction = qualifier;
        Map<String, Double> efficiency = new HashMap<>();
        for (Action action : ActionDatabase.getActionDatabase(this).getDatabase()) {
            if (action.getOutputs().containsKey(qualifier) && ActionDatabase.getActionDatabase(this).getUsedFlags().get(action)) {
                ActionDatabase.getActionDatabase(this).getUsedFlags().put(action, false);
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
                ActionDatabase.getActionDatabase(this).getUsedFlags().put(action, true);
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