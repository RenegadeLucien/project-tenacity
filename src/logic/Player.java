package logic;


import data.databases.*;
import data.dataobjects.*;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Player implements Serializable {

    //Ordered by Jagex ID
    public static final ArrayList<String> ALL_SKILLS = new ArrayList<>(Arrays.asList("Attack", "Defence", "Strength", "Constitution",
        "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining",
        "Herblore", "Agility", "Thieving", "Slayer", "Farming", "Runecrafting", "Hunter", "Construction", "Summoning",
        "Dungeoneering", "Divination", "Invention"));

    public static final ArrayList<String> PORTS_SKILLS = new ArrayList<>(Arrays.asList("Agility", "Construction", "Cooking",
        "Divination", "Dungeoneering", "Fishing", "Herblore", "Hunter", "Prayer", "Runecrafting", "Slayer", "Thieving"));

    private static final ArrayList<String> COMBAT_STYLES = new ArrayList<>(Arrays.asList("Melee", "Ranged", "Magic"));

    private static final int[] XP_TO_LEVELS = {0, 83, 174, 276, 388, 512, 650, 801, 969, 1154, 1358, 1584, 1833, 2107, 2411, 2746, 3115, 3523,
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

    private List<Requirement> currentTargets = new ArrayList<>();
    private List<QualifierAction> lockedActions = new ArrayList<>();

    private Map<Requirement, GoalResults> previousEfficiencyResults = new HashMap<>();
    private Map<Achievement, GoalResults> achievementResults = new HashMap<>();

    private int totalEncounters = 0;

    public Player(String name, String status) {
        this.name = name;
        if (status.equals("Mainscape"))
            this.status = 0;
        else if (status.equals("Ironman"))
            this.status = 1;
        else if (status.equals("Hardcore"))
            this.status = 2;
        xp = setInitialXP();
        //While these aren't obtained strictly at startup, they can be obtained for free in 30 seconds.
        weapons.add(Weapon.getWeaponByName("Bronze 2h sword"));
        weapons.add(Weapon.getWeaponByName("Dwarven army axe"));
        weapons.add(Weapon.getWeaponByName("Chargebow"));
        weapons.add(Weapon.getWeaponByName("Staff"));
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

    public int getTotalEncounters() {
        return totalEncounters;
    }

    public void setTotalEncounters(int totalEncounters) {
        this.totalEncounters = totalEncounters;
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
            if (skillXp < XP_TO_LEVELS[i]) {
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
        return Math.max(0, XP_TO_LEVELS[level-1] - xp.get(skill).intValue());
    }

    public Map<String, Double> nextGear(String combatStyle) {
        if (!COMBAT_STYLES.contains(combatStyle)) {
            throw new IllegalArgumentException(String.format("Combat style provided was %s. Must be Melee, Ranged, or Magic.", combatStyle));
        }
        double minTimeToGear = 1000000000.0;
        String minGear = null;
        for (Weapon weapon : WeaponDatabase.getWeaponDatabase().getWeapons().stream().filter(w -> w.getWeaponClass().equals(combatStyle)).collect(Collectors.toList())) {
            if (!weapons.contains(weapon) && !checkIfHaveBetterWeapon(weapon)) {
                double weaponTime = 0;
                if (ItemDatabase.getItemDatabase().getItems().get(weapon.getName()) != null) {
                    weaponTime += new Requirement("Coins", ItemDatabase.getItemDatabase().getItems().get(weapon.getName()).coinValue(this)).timeAndActionsToMeetRequirement(this).getTotalTime();
                }
                else {
                    //Getting time to untradeable gear that aren't already owned is unsupported
                    weaponTime += 1000000000.0;
                }
                for (Requirement weaponReq : weapon.getReqs()) {
                    weaponTime += weaponReq.timeAndActionsToMeetRequirement(this).getTotalTime();
                }
                if (minTimeToGear > weaponTime) {
                    minTimeToGear = weaponTime;
                    minGear = weapon.getName();
                }
            }
        }
        for (Armour armourPiece : ArmourDatabase.getArmourDatabase().getArmours().stream().filter(a -> a.getType().equals(combatStyle) || a.getType().equals("All")).collect(Collectors.toList())) {
            if (!armour.contains(armourPiece) && !checkIfHaveBetterArmour(armourPiece)) {
                double armourTime = 0;
                if (ItemDatabase.getItemDatabase().getItems().get(armourPiece.getName()) != null) {
                    armourTime += new Requirement("Coins", ItemDatabase.getItemDatabase().getItems().get(armourPiece.getName()).coinValue(this)).timeAndActionsToMeetRequirement(this).getTotalTime();
                }
                else {
                    //Getting time to untradeable gear that aren't already owned is unsupported
                    armourTime += 1000000000.0;
                }
                for (Requirement armourReq : armourPiece.getReqs()) {
                    armourTime += armourReq.timeAndActionsToMeetRequirement(this).getTotalTime();
                }
                if (minTimeToGear > armourTime) {
                    minTimeToGear = armourTime;
                    minGear = armourPiece.getName();
                }
            }
        }
        for (Food newFood : FoodDatabase.getFoodDatabase().getFoods()) {
            if (getLevel("Constitution") < 99 && newFood.getAmountHealed() > getLevel("Constitution")*25) {
                double foodTime = new Requirement("Constitution", Math.min(99, newFood.getAmountHealed()/25)).timeAndActionsToMeetRequirement(this).getTotalTime();
                if (minTimeToGear > foodTime) {
                    minTimeToGear = foodTime;
                    minGear = newFood.getName();
                }
            }
        }
        for (Familiar familiar : FamiliarDatabase.getFamiliarDatabase().getFamiliars()) {
            if (familiar.getSummonReq() > getLevel("Summoning")) {
                double familiarTime = new Requirement("Summoning", familiar.getSummonReq()).timeAndActionsToMeetRequirement(this).getTotalTime();
                if (minTimeToGear > familiarTime) {
                    minTimeToGear = familiarTime;
                    minGear = familiar.getName();
                }
            }
        }
        if (minGear != null) {
            return Map.of(minGear, minTimeToGear);
        }
        return null;
    }

    public void addWeapon(Weapon newWeapon) {
        weapons.add(newWeapon);
        List<Weapon> weaponsToRemove = new ArrayList<>();
        for (Weapon weapon : weapons) {
            if (checkIfHaveBetterWeapon(weapon)) {
                weaponsToRemove.add(weapon);
            }
        }
        weapons.removeAll(weaponsToRemove);
    }

    public void addArmour(Armour newArmour) {
        armour.add(newArmour);
        List<Armour> armoursToRemove = new ArrayList<>();
        for (Armour armour : armour) {
            if (checkIfHaveBetterArmour(armour)) {
                armoursToRemove.add(armour);
            }
        }
        armour.removeAll(armoursToRemove);
    }

    private boolean checkIfHaveBetterWeapon(Weapon weapon) {
        for (Weapon ownedWeapon : weapons) {
            if (!weapon.equals(ownedWeapon) && weapon.getWeaponClass().equals(ownedWeapon.getWeaponClass()) && weapon.getSlot().equals(ownedWeapon.getSlot()) &&
                weapon.effectiveDamage() <= ownedWeapon.effectiveDamage() && weapon.getAccuracy() <= ownedWeapon.getAccuracy()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfHaveBetterArmour(Armour newArmour) {
        for (Armour ownedArmour : armour) {
            if (!ownedArmour.equals(newArmour) && (newArmour.getType().equals(ownedArmour.getType()) || ownedArmour.getType().equals("All")) && newArmour.getSlot().equals(ownedArmour.getSlot()) &&
                newArmour.getArmour() <= ownedArmour.getArmour() && newArmour.getReduc() <= ownedArmour.getReduc() && newArmour.getBonus() <= ownedArmour.getBonus()) {
                return true;
            }
        }
        return false;
    }

    public Map<String, Double> calcAllAchievements() {
        long time = System.nanoTime();
        previousEfficiencyResults.clear();
        achievementResults.clear();
        totalEncounters = 0;
        StoredCombatCalcs.getCalculatedCombats().clear();
        StoredCombatCalcs.getSuccessfulCombats().clear();
        ActionDatabase.reset();
        Map<String, Double> achievementCalcResults = new HashMap<>();
        for (Achievement achievement : AchievementDatabase.getAchievementDatabase().getAchievements()) {
            if (!qualities.containsKey(achievement.getName())) {
                if (achievement.getTime() < 0 && achievement.getReqs().stream().allMatch(r -> r.meetsRequirement(this))) {
                    qualities.put(achievement.getName(), 1);
                }
                else {
                    StoredCombatCalcs.getCalculatedCombats().clear();
                    System.out.print(achievement.getName() + "\t");
                    long taskTime = System.nanoTime();
                    int currentEncounters = totalEncounters;
                    GoalResults actionsAndTime = achievement.getTimeForRequirements(this);
                    achievementCalcResults.put(achievement.getName(), actionsAndTime.getTotalTime() - achievement.getGainFromRewards(this));
                    achievementResults.put(achievement, actionsAndTime);
                    System.out.print(totalEncounters - currentEncounters + "\t");
                    System.out.println((System.nanoTime() - taskTime) / 1000000000.0);
                }
            }
        }
        System.out.println((System.nanoTime() - time) / 1000000000.0);
        System.out.println("====================================");
        for (Map.Entry<Requirement, GoalResults> entry : previousEfficiencyResults.entrySet()) {
           // System.out.println(entry.getKey().getQualifier() + " " + entry.getKey().getQuantifier() + " in " + entry.getValue().getTotalTime() + " hours");
        }
        System.out.println("The total bank value of this account is " + getTotalBankValue());
        System.out.println(String.format("%d total combat encounters were calculated", totalEncounters));
        return achievementCalcResults;
    }

    public void completeTask(String taskName) {
        Achievement task = Achievement.getAchievementByName(taskName);
        for (Requirement requirement : task.getReqs()) {
            if (Achievement.getAchievementByName(requirement.getQualifier()) != null && !qualities.containsKey(requirement.getQualifier())) {
                completeTask(requirement.getQualifier());
            } else if (ALL_SKILLS.contains(requirement.getQualifier())) {
                if (!requirement.meetsRequirement(this)) {
                    String trueTarget = requirement.getQualifier();
                    if (trueTarget.equals("Attack") || trueTarget.equals("Strength")) {
                        trueTarget = "mCombat";
                    }
                    if (trueTarget.equals("Defence")) {
                        GoalResults meleeResults = previousEfficiencyResults.get(new Requirement("mCombat",
                            XP_TO_LEVELS[requirement.getQuantifier() - 1] - (int) Math.floor(xp.get(requirement.getQualifier()))));
                        GoalResults rangedResults = previousEfficiencyResults.get(new Requirement("rCombat",
                            XP_TO_LEVELS[requirement.getQuantifier() - 1] - (int) Math.floor(xp.get(requirement.getQualifier()))));
                        GoalResults magicResults = previousEfficiencyResults.get(new Requirement("aCombat",
                            XP_TO_LEVELS[requirement.getQuantifier() - 1] - (int) Math.floor(xp.get(requirement.getQualifier()))));
                        if (meleeResults == null) {
                            new Requirement("mCombat", XP_TO_LEVELS[requirement.getQuantifier() - 1] - (int) Math.floor(xp.get(requirement.getQualifier())))
                                .timeAndActionsToMeetRequirement(this);
                        }
                        if (rangedResults == null) {
                            new Requirement("rCombat", XP_TO_LEVELS[requirement.getQuantifier() - 1] - (int) Math.floor(xp.get(requirement.getQualifier())))
                                .timeAndActionsToMeetRequirement(this);
                        }
                        if (magicResults == null) {
                            new Requirement("aCombat", XP_TO_LEVELS[requirement.getQuantifier() - 1] - (int) Math.floor(xp.get(requirement.getQualifier())))
                                .timeAndActionsToMeetRequirement(this);
                        }
                        if (meleeResults.getTotalTime() < rangedResults.getTotalTime() && meleeResults.getTotalTime() < magicResults.getTotalTime()) {
                            trueTarget = "mCombat";
                        }
                        else if(rangedResults.getTotalTime() < magicResults.getTotalTime()) {
                            trueTarget = "rCombat";
                        }
                        else {
                            trueTarget = "aCombat";
                        }
                    }
                    GoalResults reqResults = previousEfficiencyResults.get(new Requirement(trueTarget,
                        XP_TO_LEVELS[requirement.getQuantifier() - 1] - (int) Math.floor(xp.get(requirement.getQualifier()))));
                    if (reqResults == null) {
                        reqResults = requirement.timeAndActionsToMeetRequirement(this);
                    }
                    Action primeAction = null;
                    for (String action : reqResults.getActionsWithTimes().keySet()) {
                        if (!(action.equals("")) && Action.getActionByName(action, this).getOutputs().keySet().contains(trueTarget)) {
                            primeAction = Action.getActionByName(action, this);
                            break;
                        }
                    }
                    performAction(primeAction, reqResults.getActionsWithTimes().get(primeAction.getName()), requirement.getQualifier());
                }
            } else if (ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()) != null) {
                updateBank(requirement.getQualifier(), requirement.getQuantifier());
            } else if (!requirement.meetsRequirement(this)) {
                if (qualities.containsKey(requirement.getQualifier()))
                    qualities.put(requirement.getQualifier(), Math.max(qualities.get(requirement.getQualifier()), requirement.getQuantifier()));
                else
                    qualities.put(requirement.getQualifier(), requirement.getQuantifier());
            }
        }
        for (Encounter e : task.getEncounters()) {
            final Map<String, Double> initialXP = new HashMap<>(this.getXp());
            CombatResults meleeCombatResults;
            CombatResults rangedCombatResults;
            CombatResults magicCombatResults;
            do {
                meleeCombatResults = e.calculateCombat(this, new CombatParameters(28, "Melee", false, 0, false));
                rangedCombatResults = e.calculateCombat(this, new CombatParameters(28, "Ranged", false, 0, false));
                magicCombatResults = e.calculateCombat(this, new CombatParameters(28, "Magic", false, 0, false));
                if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000) {
                    this.getXp().put("Attack", this.getXp().get("Attack") + this.getXpToLevel("Attack", this.getLevel("Attack")+1));
                    this.getXp().put("Strength", this.getXp().get("Strength") + this.getXpToLevel("Strength", this.getLevel("Strength")+1));
                    this.getXp().put("Ranged", this.getXp().get("Ranged") + this.getXpToLevel("Ranged", this.getLevel("Ranged")+1));
                    this.getXp().put("Magic", this.getXp().get("Magic") + this.getXpToLevel("Magic", this.getLevel("Magic")+1));
                    this.getXp().put("Defence", this.getXp().get("Defence") + this.getXpToLevel("Defence", this.getLevel("Defence")+1));
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Constitution", this.getLevel("Constitution") + 1));
                }
                else {
                    break;
                }
            }
            while (this.getLevel("Constitution") < 99 || this.getLevel("Attack") < 99 || this.getLevel("Strength") < 99 || this.getLevel("Defence") < 99 ||
                this.getLevel("Magic") < 99 || this.getLevel("Ranged") < 99);
            this.setXp(initialXP);
            for (List<Enemy> enemyGroup : e.getEnemyGroups()) {
                for (Enemy enemy : enemyGroup) {
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + enemy.getHpxp());
                    if (rangedCombatResults.getHpLost() < meleeCombatResults.getHpLost() && rangedCombatResults.getHpLost() < magicCombatResults.getHpLost()) {
                        this.getXp().put("Ranged", this.getXp().get("Ranged") + enemy.getCbxp());
                    }
                    else if (meleeCombatResults.getHpLost() < magicCombatResults.getHpLost()) {
                        if (getLevel("Attack") <= getLevel("Strength")) {
                            this.getXp().put("Attack", this.getXp().get("Attack") + enemy.getCbxp());
                        }
                        else {
                            this.getXp().put("Strength", this.getXp().get("Strength") + enemy.getCbxp());
                        }
                    }
                    else {
                        this.getXp().put("Magic", this.getXp().get("Magic") + enemy.getCbxp());
                    }
                }
            }
        }
        ArrayList<Reward> rewards = new ArrayList<>(task.getRewards());
        for (Reward reward : rewards) {
            if (ALL_SKILLS.contains(reward.getQualifier())) {
                xp.put(reward.getQualifier(), xp.get(reward.getQualifier()) + reward.getQuantifier());
            } else if (Armour.getArmourByName(reward.getQualifier()) != null) {
                armour.add(Armour.getArmourByName(reward.getQualifier()));
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
        for (Lamp lamp : task.getLamps()) {
            Reward reward = lamp.getBestReward(this);
            xp.put(reward.getQualifier(), xp.get(reward.getQualifier()) + reward.getQuantifier());
        }
    }

    public GoalResults efficientGoalCompletion(String qualifier, int quantifier) {
        Requirement generatedRequirement = new Requirement(qualifier, quantifier);
        if (previousEfficiencyResults.get(generatedRequirement) != null) {
            return previousEfficiencyResults.get(generatedRequirement);
        }
        //Basically, this if you're trying to make 15000 coins to get 3000 coins. By definition, you won't need to do this, so this should not be done
        if (!qualifier.equals("Coins") && currentTargets.stream().anyMatch(r -> r.getQualifier().equals(qualifier) && r.getQuantifier() <= quantifier)) {
            return new GoalResults(1000000000.0, Map.of("Impossible", 1000000000.0));
        }
        currentTargets.add(generatedRequirement);
        if (qualifier.equals("Quest points")) {
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
                GoalResults oneQuestResults = achievementResults.get(quest);
                for (Entry<String, Double> actionEntry : oneQuestResults.getActionsWithTimes().entrySet()) {
                    if (questTotalActions.containsKey(actionEntry.getKey())) {
                        questTotalActions.put(actionEntry.getKey(), Math.max(questTotalActions.get(actionEntry.getKey()), actionEntry.getValue()));
                    }
                    else {
                        questTotalActions.put(actionEntry.getKey(), actionEntry.getValue());
                    }
                }
                questpoints += quest.getRewards().stream().filter(a -> a.getQualifier().equals("Quest points")).collect(Collectors.toList()).get(0).getQuantifier();
                questPointMap.remove(quest);
            }
            if (questpoints < quantifier) {
                return new GoalResults(1000000000.0, Map.of("Impossible", 1000000000.0));
            }
            double questTotalTime = questTotalActions.values().stream().mapToDouble(d -> d).sum();
            GoalResults result = new GoalResults(questTotalTime, questTotalActions);
            previousEfficiencyResults.put(generatedRequirement, result);
            currentTargets.remove(generatedRequirement);
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
                currentTargets.remove(generatedRequirement);
                return result;
            } else if (ranged.getTotalTime() < magic.getTotalTime()) {
                GoalResults result = new GoalResults(ranged.getTotalTime() + Defence.getTotalTime() + prayer.getTotalTime() + summ.getTotalTime() + hp.getTotalTime(), rangedMap);
                previousEfficiencyResults.put(generatedRequirement, result);
                currentTargets.remove(generatedRequirement);
                return result;
            } else {
                GoalResults result = new GoalResults(magic.getTotalTime() + Defence.getTotalTime() + prayer.getTotalTime() + summ.getTotalTime() + hp.getTotalTime(), magicMap);
                previousEfficiencyResults.put(generatedRequirement, result);
                currentTargets.remove(generatedRequirement);
                return result;
            }
        }
        double minimum = Double.POSITIVE_INFINITY;
        String minAction = qualifier;
        Map<String, Double> efficiency = new HashMap<>();
        for (Action action : ActionDatabase.getActionDatabase(this).getDatabase()) {
            boolean validAction = false;
            Requirement extraReq = null;
            if (qualifier.equals("Coins")) {
                double coinGain = 0;
                for (Map.Entry<String, Integer> output : action.getOutputs().entrySet()) {
                    Item item = ItemDatabase.getItemDatabase().getItems().get(output.getKey());
                    if (item != null) {
                        coinGain += output.getValue()*item.coinValue(this);
                    }
                }
                int inputLoss = 0;
                for (Map.Entry<String, Integer> input : action.getInputs().entrySet()) {
                    Item item = ItemDatabase.getItemDatabase().getItems().get(input.getKey());
                    if (item != null) {
                        inputLoss += input.getValue()*item.coinValue(this);

                    }
                    coinGain -= inputLoss;
                }
                //Rather arbitrary cutoff: must have 15 minutes worth of inputs in order for using an action for making money to be valid
                if (coinGain > 0) {
                    if (inputLoss/4 > getTotalBankValue()) {
                        if (inputLoss/4 - getTotalBankValue() < quantifier) {
                            //Might cause overflow errors if it gets to this point with a bank value greater than MAX_INT...but let's be real here, when will you ever have a requirement that big?
                            extraReq = new Requirement("Coins", inputLoss / 4 - Math.toIntExact(getTotalBankValue()));
                            validAction = true;
                        }
                    }
                    else {
                        validAction = true;
                    }
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
                if (extraReq != null) {
                    GoalResults reqResults = extraReq.timeAndActionsToMeetRequirement(this);
                    effectiveTimeThisAction += reqResults.getTotalTime();
                    addItemsToMap(efficiencyThisAction, reqResults.getActionsWithTimes());
                }
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
        GoalResults result = new GoalResults(minimum, efficiency);
        if (minimum < 1000000000.0) {
            previousEfficiencyResults.put(generatedRequirement, result);
        }
        currentTargets.remove(generatedRequirement);
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

    public long getTotalBankValue() {
        long bankVal = 0;
        for (Map.Entry<String, Integer> entry : bank.entrySet()) {
            bankVal += ((long) ItemDatabase.getItemDatabase().getItems().get(entry.getKey()).coinValue(this)) * entry.getValue();
        }
        return bankVal;
    }

    private void performAction(Action action, double time, String mainTarget) {
        int steps = (int)Math.ceil(time*action.getActionsPerHour());
        for (Entry<String, Integer> input : action.getInputs().entrySet()) {
            updateBank(input.getKey(), input.getValue()*steps/action.getActionsPerHour());
        }
        for (Entry<String, Integer> output : action.getOutputs().entrySet()) {
            if (output.getKey().equals("mCombat")) {
                xp.put(mainTarget, xp.get(mainTarget) + output.getValue()*steps/action.getActionsPerHour());
            }
            else if (ALL_SKILLS.contains(output.getKey())) {
                xp.put(output.getKey(), xp.get(output.getKey()) + output.getValue()*steps/action.getActionsPerHour());
            }
            else if (ItemDatabase.getItemDatabase().getItems().get(output.getKey()) != null && output.getValue()*steps/action.getActionsPerHour() > 0) {
                if (bank.containsKey(output.getKey()))
                    bank.put(output.getKey(), bank.get(output.getKey()) + output.getValue()*steps/action.getActionsPerHour());
                else
                    bank.put(output.getKey(), output.getValue()*steps/action.getActionsPerHour());
            }
        }
    }

    private void updateBank(String item, int quantity) {
        if (!item.equals("Coins") && bank.containsKey(item)) {
            if (bank.get(item) > quantity) {
                bank.put(item, (bank.get(item) - quantity));
            } else if (bank.containsKey("Coins") && bank.get("Coins") >= (quantity-bank.get(item))
                *ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
                bank.put("Coins", bank.get("Coins")-(quantity-bank.get(item))
                    *ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this));
                bank.remove(item);
            }
        } else if (bank.containsKey("Coins") && bank.get("Coins") >= quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
                bank.put("Coins", bank.get("Coins")-quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this));
        } else if (getTotalBankValue() > quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
            List<String> entriesToRemove = new ArrayList<>();
            for (Entry<String, Integer> bankEntry : bank.entrySet()) {
                if (!bankEntry.getKey().equals("Coins")) {
                    bank.put("Coins", bank.get("Coins") + ItemDatabase.getItemDatabase().getItems().get(bankEntry.getKey()).coinValue(this)*bankEntry.getValue());
                    entriesToRemove.add(bankEntry.getKey());
                }
                if (bank.get("Coins") >= quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
                    break;
                }
            }
            for (String removal : entriesToRemove) {
                bank.remove(removal);
            }
            bank.put("Coins", bank.get("Coins")-quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this));
        }
        //Might cause overflow errors if it gets to this point with a bank value greater than MAX_INT...but let's be real here, when will you ever have a requirement that big?
        else {
            GoalResults actionsForMoney = new Requirement(item, quantity).timeAndActionsToMeetRequirement(this);
            for (Entry<String, Double> actionWithTime : actionsForMoney.getActionsWithTimes().entrySet()) {
                if (!actionWithTime.getKey().equals("")) {
                    performAction(Action.getActionByName(actionWithTime.getKey(), this), actionWithTime.getValue(), "Coins");
                }
            }
            updateBank(item, quantity);
        }
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