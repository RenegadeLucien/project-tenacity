package logic;


import data.databases.*;
import data.dataobjects.*;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Player implements Serializable {

    public static final ArrayList<String> ALL_SKILLS = new ArrayList<>(Arrays.asList("Agility", "Attack",
        "Constitution", "Construction", "Cooking", "Crafting", "Defence", "Divination",
        "Dungeoneering", "Farming", "Firemaking", "Fishing", "Fletching", "Herblore",
        "Hunter", "Invention", "Magic", "Mining", "Prayer", "Ranged", "Runecrafting",
        "Slayer", "Smithing", "Strength", "Summoning", "Thieving", "Woodcutting"));

    public static final ArrayList<String> PORTS_SKILLS = new ArrayList<>(Arrays.asList("Agility", "Construction", "Cooking",
        "Divination", "Dungeoneering", "Fishing", "Herblore", "Hunter", "Prayer", "Runecrafting", "Slayer", "Thieving"));

    public static final ArrayList<String> COMBAT_STYLES = new ArrayList<>(Arrays.asList("Melee", "Ranged", "Magic"));

    private static final int[] XP_TO_LEVELS = {0, 0, 83, 174, 276, 388, 512, 650, 801, 969, 1154, 1358, 1584, 1833, 2107, 2411, 2746, 3115, 3523,
        3973, 4470, 5018, 5624, 6291, 7028, 7842, 8740, 9730, 10824, 12031, 13363, 14833, 16456, 18247, 20224, 22406, 24815, 27473, 30408, 33648,
        37224, 41171, 45529, 50339, 55649, 61512, 67983, 75127, 83014, 91721, 101333, 111945, 123660, 136954, 150872, 166636, 184040, 203254, 224466,
        247886, 273742, 302288, 333804, 368599, 407015, 449428, 496254, 547953, 605032, 668051, 737627, 814445, 899257, 992895, 1086278, 1210421,
        1336443, 1475581, 1629200, 1798808, 1986068, 2192818, 2421087, 2673114, 2951373, 3258594, 3597792, 3972294, 4385776, 4842295, 5346332, 5902831,
        6517253, 7195629, 7944614, 8771558, 9684577, 10692629, 11805606, 13034431, 14391160, 15889109, 17542976, 19368992, 21385073, 23611006, 26068632,
        28782069, 31777943, 35085654, 38737661, 42769801, 47221641, 52136869, 57563718, 63555443, 70170840, 77474828, 85539082, 94442737, 104273167};

    private static final long serialVersionUID = 1L;

    private String name;
    private int status; //0 = mainscape, 1 = ironman, 2 = HCIM
    private Map<String, Double> xp = new HashMap<>();
    private Map<String, Integer> qualities = new HashMap<>();
    private Map<String, Integer> bank = new HashMap<>();
    private List<Weapon> weapons = new ArrayList<>();
    private List<Armour> armour = new ArrayList<>();
    private List<Food> food = new ArrayList<>();

    private Map<Requirement, GoalResults> previousEfficiencyResults = new HashMap<>();
    private List<QualifierAction> lockedActions = new ArrayList<>();
    private Map<Achievement, GoalResults> achievementResults = new HashMap<>();

    public Player(String name, String status) {
        this.name = name;
        if (status.equals("Mainscape"))
            this.status = 0;
        else if (status.equals("Ironman"))
            this.status = 1;
        else if (status.equals("Hardcore"))
            this.status = 2;
        xp = setInitialXP();
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

    public String getName() {
        return name;
    }

    public Map<Achievement, GoalResults> getAchievementResults() {
        return achievementResults;
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

    private Map<String, Double> setInitialXP() {
        Map<String, Double> initialXP = new HashMap<>();
        for (String skill : Player.ALL_SKILLS) {
            initialXP.put(skill, 0.0);
        }
        initialXP.put("Constitution", 1154.0);
        return initialXP;
    }

    public int getLevel(String skill) {
        double skillXp = xp.get(skill);
        for (int i = 1; i < XP_TO_LEVELS.length; i++) {
            if (skillXp <= XP_TO_LEVELS[i]) {
                return i;
            }
            if (i == 99 && !(skill.equals("Dungeoneering") || skill.equals("Slayer") || skill.equals("Invention"))) {
                return 99;
            }
        }
        return 120;
    }

    public double calcCombatLevel() {
        return (13 * Math.max(getLevel("Attack") + getLevel("Strength"), Math.max(getLevel("Ranged") * 2, getLevel("Magic") * 2)) / 10.0 +
            getLevel("Defence") + getLevel("Constitution") + getLevel("Prayer") / 2 + getLevel("Summoning") / 2) / 4.0;
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

    public Map<String, Double> calcAllAchievements() {
        long time = System.nanoTime();
        previousEfficiencyResults.clear();
        achievementResults.clear();
        Map<String, Double> achievementCalcResults = new HashMap<>();
        for (Achievement achievement : AchievementDatabase.getAchievementDatabase().getAchievements()) {
            if (!qualities.containsKey(achievement.getName())) {
                //System.out.print(achievement.getName() + "\t");
                long taskTime = System.nanoTime();
                GoalResults actionsAndTime = achievement.getTimeForRequirements(this);
                achievementCalcResults.put(achievement.getName(), actionsAndTime.getTotalTime() - achievement.getGainFromRewards(this));
                achievementResults.put(achievement, actionsAndTime);
                //System.out.println((System.nanoTime() - taskTime) / 1000000000.0);
            }
        }
        System.out.println((System.nanoTime() - time) / 1000000000.0);
        System.out.println("====================================");
        for (Map.Entry<Requirement, GoalResults> entry : previousEfficiencyResults.entrySet()) {
            System.out.println(entry.getKey().getQuantifier() + " " + entry.getKey().getQualifier() + " in " + entry.getValue().getTotalTime() + " hours");
        }
        return achievementCalcResults;
    }

    public void completeTask(String taskName) {
        Achievement task = Achievement.getAchievementByName(taskName);
        for (Requirement requirement : task.getReqs()) {
            if (Achievement.getAchievementByName(requirement.getQualifier()) != null && !qualities.containsKey(requirement.getQualifier())) {
                completeTask(requirement.getQualifier());
            } else if (ALL_SKILLS.contains(requirement.getQualifier())) {
                xp.put(requirement.getQualifier(), xp.get(requirement.getQualifier()) + getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
            } else if (ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()) != null) {
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
            } else if (ItemDatabase.getItemDatabase().getItems().get(reward.getQualifier()) != null) {
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
    }

    public GoalResults efficientGoalCompletion(String qualifier, int quantifier) {
        Requirement generatedRequirement = new Requirement(qualifier, quantifier);
        if (previousEfficiencyResults.get(generatedRequirement) != null) {
            return previousEfficiencyResults.get(generatedRequirement);
        }
        if (qualifier.equals("Quest points")) {
            double questTotalTime = 0;
            Map <String, Double> questTotalActions = new HashMap<>();
            Map<Achievement, Double> questPointMap = new LinkedHashMap<>();
            for (Achievement achievement : achievementResults.keySet()) {
                List<Reward> questPointReward = achievement.getRewards().stream().filter(a -> a.getQualifier().equals("Quest points")).collect(Collectors.toList());
                if (questPointReward.size() > 0) {
                    questPointMap.put(achievement, achievementResults.get(achievement).getTotalTime()/questPointReward.get(0).getQuantifier());
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
            GoalResults result = new GoalResults(questTotalTime, questTotalActions);
            previousEfficiencyResults.put(generatedRequirement, result);
            return result;
        } else if (qualifier.equals("Combat")) {
            int targetLevel = (int) Math.floor(quantifier / 1.4);
            GoalResults attack = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Attack", targetLevel));
            GoalResults strength = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Strength", targetLevel));
            GoalResults meleeDefence = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Defence", targetLevel));
            GoalResults rangedDefence = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Defence", targetLevel));
            GoalResults magicDefence = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Defence", targetLevel));
            GoalResults Defence;
            if (meleeDefence.getTotalTime() < Math.min(rangedDefence.getTotalTime(), magicDefence.getTotalTime())) {
                Defence = meleeDefence;
            } else if (rangedDefence.getTotalTime() < magicDefence.getTotalTime()) {
                Defence = rangedDefence;
            } else {
                Defence = magicDefence;
            }
            GoalResults ranged = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Ranged", targetLevel));
            GoalResults magic = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Magic", targetLevel));
            GoalResults prayer = this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", targetLevel));
            GoalResults summ = this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", targetLevel));
            GoalResults hp = this.efficientGoalCompletion("Constitution", this.getXpToLevel("Constitution", targetLevel));
            Map<String, Double> meleeMap = new HashMap<>();
            Map<String, Double> rangedMap = new HashMap<>();
            Map<String, Double> magicMap = new HashMap<>();
            meleeMap.put(attack.getActionsWithTimes().keySet().iterator().next(), attack.getTotalTime());
            if (meleeMap.keySet().contains(strength.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(strength.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(strength.getActionsWithTimes().keySet().iterator().next()) + strength.getTotalTime());
            else
                meleeMap.put(strength.getActionsWithTimes().keySet().iterator().next(), strength.getTotalTime());
            if (meleeMap.keySet().contains(Defence.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(Defence.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(Defence.getActionsWithTimes().keySet().iterator().next()) + Defence.getTotalTime());
            else
                meleeMap.put(Defence.getActionsWithTimes().keySet().iterator().next(), Defence.getTotalTime());
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
            if (rangedMap.keySet().contains(Defence.getActionsWithTimes().keySet().iterator().next()))
                rangedMap.put(Defence.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(Defence.getActionsWithTimes().keySet().iterator().next()) + Defence.getTotalTime());
            else
                rangedMap.put(Defence.getActionsWithTimes().keySet().iterator().next(), Defence.getTotalTime());
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
            if (magicMap.keySet().contains(Defence.getActionsWithTimes().keySet().iterator().next()))
                magicMap.put(Defence.getActionsWithTimes().keySet().iterator().next(), magicMap.get(Defence.getActionsWithTimes().keySet().iterator().next()) + Defence.getTotalTime());
            else
                magicMap.put(Defence.getActionsWithTimes().keySet().iterator().next(), Defence.getTotalTime());
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
                GoalResults result = new GoalResults(attack.getTotalTime() + strength.getTotalTime() + Defence.getTotalTime() + prayer.getTotalTime() + summ.getTotalTime() + hp.getTotalTime(), meleeMap);
                previousEfficiencyResults.put(generatedRequirement, result);
                return result;
            } else if (ranged.getTotalTime() < magic.getTotalTime()) {
                GoalResults result = new GoalResults(ranged.getTotalTime() + Defence.getTotalTime() + prayer.getTotalTime() + summ.getTotalTime() + hp.getTotalTime(), rangedMap);
                previousEfficiencyResults.put(generatedRequirement, result);
                return result;
            } else {
                GoalResults result = new GoalResults(magic.getTotalTime() + Defence.getTotalTime() + prayer.getTotalTime() + summ.getTotalTime() + hp.getTotalTime(), magicMap);
                previousEfficiencyResults.put(generatedRequirement, result);
                return result;
            }
        }
        double minimum = Double.POSITIVE_INFINITY;
        String minAction = qualifier;
        Map<String, Double> efficiency = new HashMap<>();
        for (Action action : ActionDatabase.getActionDatabase(this).getDatabase()) {
            boolean validAction = false;
            if (qualifier.equals("Coins")) {
                double coinGain = 0;
                for (Map.Entry<String, Integer> output : action.getOutputs().entrySet()) {
                    Item item = ItemDatabase.getItemDatabase().getItems().get(output.getKey());
                    if (item != null) {
                        coinGain += output.getValue()*item.coinValue(this);
                    }
                }
                for (Map.Entry<String, Integer> input : action.getInputs().entrySet()) {
                    Item item = ItemDatabase.getItemDatabase().getItems().get(input.getKey());
                    if (item != null) {
                       coinGain -= input.getValue()*item.coinValue(this);
                    }
                }
                if (coinGain > 0) {
                    validAction = true;
                }
            }
            else if (action.getOutputs().containsKey(qualifier)) {
                validAction = true;
            }
            if (lockedActions.stream().anyMatch(la -> la.getQualifier().equals(qualifier) && la.getAction().equals(action.getName()))) {
                validAction = false;
            }
            if (validAction) {
                QualifierAction qualifierAction = new QualifierAction(qualifier, action.getName());
                lockedActions.add(qualifierAction);
                double effectiveTimeThisAction = 0.0;
                Map<String, Double> efficiencyThisAction = new HashMap<>();
                for (Requirement requirement : action.getReqs()) {
                    GoalResults reqResults = requirement.timeAndActionsToMeetRequirement(this);
                    effectiveTimeThisAction += reqResults.getTotalTime();
                    addItemsToMap(efficiencyThisAction, reqResults.getActionsWithTimes());
                }
                GoalResults actionResults = action.effectiveRate(qualifier, quantifier, this);
                effectiveTimeThisAction += actionResults.getTotalTime();
                addItemsToMap(efficiencyThisAction, actionResults.getActionsWithTimes());
                if (effectiveTimeThisAction < minimum) {
                    minimum = effectiveTimeThisAction;
                    efficiency = efficiencyThisAction;
                }
                lockedActions.remove(qualifierAction);
            }
        }
        if (minimum == Double.POSITIVE_INFINITY) {
            minimum = 1000000000.0;
            efficiency.put(minAction, minimum);
        }
        //System.out.println(minReqs);
        //System.out.println(efficiency);
        //System.out.println(minAction + " will achieve " + quantifier + " " +qualifier + " in " + minimum + " hours.");
        GoalResults result = new GoalResults(minimum, efficiency);
        if (minimum < 1000000000.0) {
            previousEfficiencyResults.put(generatedRequirement, result);
        }
        return result;
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

    private class QualifierAction {

        private String qualifier;
        private String action;

        QualifierAction(String qualifier, String action) {
            this.qualifier = qualifier;
            this.action = action;
        }

        String getQualifier() {
            return qualifier;
        }

        String getAction() {
            return action;
        }
    }
}