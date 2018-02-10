package dynamicdata;


import staticdata.Armour;
import staticdata.Food;
import staticdata.Achievement;
import staticdata.Weapon;
import staticdata.Item;
import staticdata.Enemy;

import java.lang.reflect.Array;
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

	public static final ArrayList<String> COMBAT_SKILLS = new ArrayList<>(Arrays.asList("Attack", "Strength", "Defense", "Magic", "Ranged"));

	public static final ArrayList<String> COMBAT_STYLES = new ArrayList<>(Arrays.asList("Melee", "Ranged", "Magic"));
	
	private static final long serialVersionUID = 1L;

	private String name;
	private int status; //0 = mainscape, 1 = ironman, 2 = HCIM
	private Map<Achievement, Double> playerTasks = new LinkedHashMap<>();
	private Map<String, Double> xp;
	private Map<String, Integer> qualities = new HashMap<>();
	private Map<String, Integer> bank = new HashMap<>();
	private List<Weapon> weapons = new ArrayList<>();
	private List<Armour> armour = new ArrayList<>();
	private List<Food> food = new ArrayList<>();
	private ActionDatabase actionDatabase;
	
	public Player(String name, String status) {
		this.name = name;
		if (status.equals("Mainscape"))
			this.status = 0;
		else if (status.equals("Ironman"))
			this.status = 1;
		else if (status.equals("Hardcore"))
			this.status = 2;
		xp = setInitialXP();
		for (Achievement t : Achievement.values()) {
			playerTasks.put(t, 1000000000.0);
		}
		weapons.add(Weapon.BRONZE_SWORD); //not technically obtained on startup but you can get these in 30 seconds and it is required to make the combat calcs work
		weapons.add(Weapon.CHARGEBOW);
		weapons.add(Weapon.STAFF);
		calcFood();
		actionDatabase = new ActionDatabase(this);
		calcList();
	}

	public Map<Achievement, Double> getPlayerTasks() {
		return playerTasks;
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

	public ActionDatabase getActionDatabase() {
		return actionDatabase;
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
		while(true) {
			sumXP += Math.floor(level + 300 * Math.pow(2, level/7.0));
			int xpToLevel = (int)Math.floor(sumXP/4);
			if (xpToLevel > skillXp) {
				return level;
			}
			else {
				level++;
			}
		}
	}

	public double calcCombatLevel() {
		return (13*Math.max(getLevel("Attack") + getLevel("Strength"), Math.max(getLevel("Ranged")*2, getLevel("Magic")*2))/10.0 +
		getLevel("Defense") + getLevel("Constitution") + getLevel("Prayer")/2 + getLevel("Summoning")/2)/4.0;
	}

	public int getXpToLevel(String skill, int level) {
		double skillXp = xp.get(skill);
		int intermediateLevel = 1;
		int sumXP = 0;
		while(intermediateLevel < level) {
			sumXP += Math.floor(intermediateLevel + 300 * Math.pow(2, intermediateLevel / 7.0));
			intermediateLevel++;
		}
		sumXP = (int) Math.floor(sumXP / 4);
		return sumXP - (int)skillXp;
	}

	public void calcFood() {
		int maxHealing = this.getLevel("Constitution") * 25;
		List<Food> allFood = new ArrayList<>(Arrays.asList(Food.values()));
		allFood.removeAll(food);
		List<Food> foodToRemove = new ArrayList<>();
		for (Food f : allFood) {
			boolean addFood = true;
			for (Food currentFood : food) {
				if (Math.min(f.getAmountHealed(), maxHealing) <= Math.min(currentFood.getAmountHealed(), maxHealing)
						&& Item.getItemByName(f.getName()).coinValue(this) >= Item.getItemByName(currentFood.getName()).coinValue(this)) {
					addFood = false;
					break;
				}
				else if (Math.min(f.getAmountHealed(), maxHealing) >= Math.min(currentFood.getAmountHealed(), maxHealing)
						&& Item.getItemByName(f.getName()).coinValue(this) <= Item.getItemByName(currentFood.getName()).coinValue(this)) {
					foodToRemove.add(currentFood);
				}

			}
			if (addFood == true)
				food.add(f);

		}
		food.removeAll(foodToRemove);
	}

	public boolean checkWeapon(Weapon weapon) {
		if (weapons.contains(weapon))
			return false;
		for (Weapon currentWeapon : weapons) {
			if (weapon.getWeaponClass().equals(currentWeapon.getWeaponClass()) && weapon.getStyle().equals(currentWeapon.getStyle())
					&& weapon.getSlot().equals(currentWeapon.getSlot())) {
				if (weapon.getDamage() <= currentWeapon.getDamage() && weapon.getAccuracy() <= currentWeapon.getAccuracy())
					return false;
			}
		}
		return true;
	}

	public void addWeapon(Weapon weapon) {
		List<Weapon> obsoleteWeapons = new ArrayList<>();
		for (Weapon currentWeapon : weapons) {
			if (weapon.getWeaponClass().equals(currentWeapon.getWeaponClass()) && weapon.getStyle().equals(currentWeapon.getStyle())
					&& weapon.getSlot().equals(currentWeapon.getSlot())) {
				if (weapon.getDamage() >= currentWeapon.getDamage() && weapon.getAccuracy() >= currentWeapon.getAccuracy())
					obsoleteWeapons.add(currentWeapon);
			}
		}
		weapons.removeAll(obsoleteWeapons);
		weapons.add(weapon);
	}

	public boolean checkArmour(Armour armour1) {
		if (armour.contains(armour1))
			return false;
		for (Armour currentArmour : armour) {
			if (armour1.getType().equals(currentArmour.getType()) && armour1.getSlot().equals(currentArmour.getSlot())) {
				if (armour1.getArmour() <= currentArmour.getArmour()
						&& armour1.getLp() <= currentArmour.getLp()
						&& armour1.getPray() <= currentArmour.getPray()
						&& armour1.getReduc() <= currentArmour.getReduc()
						&& armour1.getBonus() <= currentArmour.getBonus())
					return false;
			}
		}
		return true;
	}

	public void addArmour(Armour armour1) {
		List<Armour> obsoleteArmour = new ArrayList<>();
		for (Armour currentArmour : armour) {
			if (armour1.getType().equals(currentArmour.getType()) && armour1.getSlot().equals(currentArmour.getSlot())) {
				if (armour1.getArmour() >= currentArmour.getArmour()
						&& armour1.getLp() >= currentArmour.getLp()
						&& armour1.getPray() >= currentArmour.getPray()
						&& armour1.getReduc() >= currentArmour.getReduc()
						&& armour1.getBonus() >= currentArmour.getBonus())
					obsoleteArmour.add(currentArmour);
			}
		}
		armour.removeAll(obsoleteArmour);
		armour.add(armour1);
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
		for (Weapon w : weapons) {
			if (w.getWeaponClass().equals(combatStyle)) {
				weaponList.add(w);
			}
		}
		for (Armour a : armour) {
			if (a.getSlot().equals("Head") && a.getType().equals(combatStyle)) {
				headArmour.add(a);
			}
			else if (a.getSlot().equals("Torso") && a.getType().equals(combatStyle)) {
				torsoArmour.add(a);
			}
			else if (a.getSlot().equals("Legs") && a.getType().equals(combatStyle)) {
				legArmour.add(a);
			}
			else if (a.getSlot().equals("Hands") && a.getType().equals(combatStyle)) {
				handArmour.add(a);
			}
			else if (a.getSlot().equals("Feet") && a.getType().equals(combatStyle)) {
				feetArmour.add(a);
			}
		}
		headArmour.add(Armour.NONE);
		torsoArmour.add(Armour.NONE);
		legArmour.add(Armour.NONE);
		handArmour.add(Armour.NONE);
		feetArmour.add(Armour.NONE);
		for (Weapon w : weaponList)
			for (Food f : food)
				for (Armour head : headArmour)
					for (Armour torso : torsoArmour)
						for (Armour leg : legArmour)
							for (Armour hand : handArmour)
								for (Armour foot : feetArmour)
										loadouts.add(new Loadout(w, f, head, torso, leg, hand, foot));

		return loadouts;
	}

	public void calcList() {
		long time = System.nanoTime();
		calcFood();
		for (Entry<Achievement, Double> taskWithTime : playerTasks.entrySet()) {
			Achievement t = taskWithTime.getKey();
			playerTasks.put(t, t.getTime() + t.getTimeForRequirements(this).getTotalTime() - t.getGainFromRewards(this));
		}
		playerTasks = playerTasks.entrySet().stream().sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						LinkedHashMap::new
				));
		System.out.println((System.nanoTime() - time)/1000000000.0);
	}

	public void completeTask(Achievement task) {
		ArrayList<Requirement> masterListOfRequirements = new ArrayList<>(task.getReqs());
		masterListOfRequirements.addAll(task.getTimeForRequirements(this).getRequirements());
		for (Requirement requirement : masterListOfRequirements) {
			if (Achievement.getAchievementByName(requirement.getQualifier()) != null && playerTasks.containsKey(Achievement.getAchievementByName(requirement.getQualifier()))) {
				completeTask(Achievement.getAchievementByName(requirement.getQualifier()));
			}
			else if (ALL_SKILLS.contains(requirement.getQualifier()) && getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()) > 0) {
				xp.put(requirement.getQualifier(), xp.get(requirement.getQualifier()) + getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
			}
			else if (Item.getItemByName(requirement.getQualifier()) != null) {
				if (bank.containsKey(requirement.getQualifier())) {
					if (bank.get(requirement.getQualifier()) > requirement.getQuantifier()) {
						bank.put(requirement.getQualifier(), (bank.get(requirement.getQualifier()) - requirement.getQuantifier()));
					}
					else {
						bank.remove(requirement.getQualifier());
					}
				}
			}
			else if (!requirement.meetsRequirement(this)){
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
			}
			else if (Weapon.getWeaponByName(reward.getQualifier()) != null) {
				addWeapon(Weapon.getWeaponByName(reward.getQualifier()));
			}
			else if (Item.getItemByName(reward.getQualifier()) != null){
				if (bank.containsKey(reward.getQualifier()))
					bank.put(reward.getQualifier(), bank.get(reward.getQualifier()) + reward.getQuantifier());
				else
					bank.put(reward.getQualifier(), reward.getQuantifier());
			}
			else {
				if (qualities.containsKey(reward.getQualifier()))
					qualities.put(reward.getQualifier(), qualities.get(reward.getQualifier()) + reward.getQuantifier());
				else
					qualities.put(reward.getQualifier(), reward.getQuantifier());
			}

		}
		for (Encounter encounter : task.getEncounters()) {
			for (Enemy enemy : encounter.getEnemies()) {
				xp.put("Constitution", xp.get("Constitution") + enemy.getHpxp());
				//xp.put("Attack", xp.get("Attack") + enemy.getCbxp());
			}
		}

		playerTasks.remove(task);
		calcList();
	}

	public GoalResults efficientGoalCompletion(String qualifier, int quantifier) {
		if (qualifier.equals("Coins")) {
			double money = 0;
			String bestAction = "";
			List<Requirement> minReqs = new ArrayList<>();
			for (Action action : actionDatabase.getDatabase()) {
				double moneyForThisAction = action.moneyFromAction(this);
				if (moneyForThisAction > money) {
					money = moneyForThisAction;
					bestAction = action.getName();
					minReqs = action.getReqs();
				}
			}
			//System.out.println("Best effective rate of money is " + money + " GP per hour.");
			return new GoalResults(quantifier/money, minReqs, Map.of(bestAction, quantifier/money));
		}
		else if (qualifier.equals("Combat")) {
			Map<String,Double> originalMap = this.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
			double levelingByMelee = 0;
			double levelingByRanged = 0;
			double levelingByMagic = 0;
			Map<String,Double> meleeMap = new HashMap();
			Map<String,Double> rangedMap = new HashMap();
			Map<String,Double> magicMap = new HashMap();
			List<Requirement> meleeReqs = new ArrayList<>();
			List<Requirement> rangedReqs = new ArrayList<>();
			List<Requirement> magicReqs = new ArrayList<>();
			//Using melee
			while (this.calcCombatLevel() < quantifier) {
				double attack = 0.325/this.efficientGoalCompletion("mCombat", this.getXpToLevel("Attack", this.getLevel("Attack")+1)).getTotalTime();
				double strength = 0.325/this.efficientGoalCompletion("mCombat", this.getXpToLevel("Strength", this.getLevel("Strength")+1)).getTotalTime();
				double defense = 0.25/this.efficientGoalCompletion("mCombat", this.getXpToLevel("Defense", this.getLevel("Defense")+1)).getTotalTime();
				double prayer = 0.25/this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer")+1)).getTotalTime();
				double summ = 0.25/this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning")+1)).getTotalTime();
				GoalResults bestSubReq = null;
				if (attack > strength && attack > defense && attack > prayer && attack > summ) {
					bestSubReq = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Attack", this.getLevel("Attack")+1));
					this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Attack", this.getLevel("Attack")+1)/3);
					this.getXp().put("Attack", this.getXp().get("Attack") + this.getXpToLevel("Attack", this.getLevel("Attack")+1));
				}
				else if (strength > defense && strength > prayer && strength > summ) {
					bestSubReq = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Strength", this.getLevel("Strength")+1));
					this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Strength", this.getLevel("Strength")+1)/3);
					this.getXp().put("Strength", this.getXp().get("Strength") + this.getXpToLevel("Strength", this.getLevel("Strength")+1));
				}
				else if (defense > prayer && defense > summ) {
					bestSubReq = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Defense", this.getLevel("Defense")+1));
					this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Defense", this.getLevel("Defense")+1)/3);
					this.getXp().put("Defense", this.getXp().get("Defense") + this.getXpToLevel("Defense", this.getLevel("Defense")+1));
				}
				else if (prayer > summ) {
					bestSubReq = this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer")+1));
					this.getXp().put("Prayer", this.getXp().get("Prayer") + this.getXpToLevel("Prayer", ((this.getLevel("Prayer")/2)+1)*2));
				}
				else {
					bestSubReq = this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning")+1));
					this.getXp().put("Summoning", this.getXp().get("Summoning") + this.getXpToLevel("Summoning", ((this.getLevel("Summoning")/2)+1)*2));
				}
				levelingByMelee += bestSubReq.getTotalTime();
				if (meleeMap.keySet().contains(bestSubReq.getActionsWithTimes().keySet().iterator().next()))
					meleeMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(bestSubReq.getActionsWithTimes().keySet().iterator().next()) + bestSubReq.getTotalTime());
				else
					meleeMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), bestSubReq.getTotalTime());
			}
			if (this.getXp().get("Attack") > originalMap.get("Attack")) {
				meleeReqs.add(new Requirement("Attack", this.getLevel("Attack")));
			}
			if (this.getXp().get("Strength") > originalMap.get("Strength")) {
				meleeReqs.add(new Requirement("Strength", this.getLevel("Strength")));
			}
			if (this.getXp().get("Defense") > originalMap.get("Defense")) {
				meleeReqs.add(new Requirement("Defense", this.getLevel("Defense")));
			}
			if (this.getXp().get("Constitution") > originalMap.get("Constitution")) {
				meleeReqs.add(new Requirement("Constitution", this.getLevel("Constitution")));
			}
			if (this.getXp().get("Prayer") > originalMap.get("Prayer")) {
				meleeReqs.add(new Requirement("Prayer", this.getLevel("Prayer")));
			}
			if (this.getXp().get("Summoning") > originalMap.get("Summoning")) {
				meleeReqs.add(new Requirement("Summoning", this.getLevel("Summoning")));
			}
			this.setXp(originalMap);
			originalMap = this.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
			//Using ranged
			while (this.calcCombatLevel() < quantifier) {
				double ranged = 0.65/this.efficientGoalCompletion("rCombat", this.getXpToLevel("Ranged", this.getLevel("Ranged")+1)).getTotalTime();
				double defense = 0.25/this.efficientGoalCompletion("rCombat", this.getXpToLevel("Defense", this.getLevel("Defense")+1)).getTotalTime();
				double prayer = 0.25/this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer")+1)).getTotalTime();
				double summ = 0.25/this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning")+1)).getTotalTime();
				GoalResults bestSubReq = null;
				if (ranged > defense && ranged > prayer && ranged > summ) {
					bestSubReq = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Ranged", this.getLevel("Ranged")+1));
					this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Ranged", this.getLevel("Ranged")+1)/3);
					this.getXp().put("Ranged", this.getXp().get("Ranged") + this.getXpToLevel("Ranged", this.getLevel("Ranged")+1));
				}
				else if (defense > prayer && defense > summ) {
					bestSubReq = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Defense", this.getLevel("Defense")+1));
					this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Defense", this.getLevel("Defense")+1)/3);
					this.getXp().put("Defense", this.getXp().get("Defense") + this.getXpToLevel("Defense", this.getLevel("Defense")+1));
				}
				else if (prayer > summ) {
					bestSubReq = this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer")+1));
					this.getXp().put("Prayer", this.getXp().get("Prayer") + this.getXpToLevel("Prayer", ((this.getLevel("Prayer")/2)+1)*2));
				}
				else {
					bestSubReq = this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning")+1));
					this.getXp().put("Summoning", this.getXp().get("Summoning") + this.getXpToLevel("Summoning", ((this.getLevel("Summoning")/2)+1)*2));
				}
				levelingByRanged += bestSubReq.getTotalTime();
				if (rangedMap.keySet().contains(bestSubReq.getActionsWithTimes().keySet().iterator().next()))
					rangedMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(bestSubReq.getActionsWithTimes().keySet().iterator().next()) + bestSubReq.getTotalTime());
				else
					rangedMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), bestSubReq.getTotalTime());
			}
			if (this.getXp().get("Ranged") > originalMap.get("Ranged")) {
				rangedReqs.add(new Requirement("Ranged", this.getLevel("Ranged")));
			}
			if (this.getXp().get("Defense") > originalMap.get("Defense")) {
				rangedReqs.add(new Requirement("Defense", this.getLevel("Defense")));
			}
			if (this.getXp().get("Constitution") > originalMap.get("Constitution")) {
				rangedReqs.add(new Requirement("Constitution", this.getLevel("Constitution")));
			}
			if (this.getXp().get("Prayer") > originalMap.get("Prayer")) {
				rangedReqs.add(new Requirement("Prayer", this.getLevel("Prayer")));
			}
			if (this.getXp().get("Summoning") > originalMap.get("Summoning")) {
				rangedReqs.add(new Requirement("Summoning", this.getLevel("Summoning")));
			}
			this.setXp(originalMap);
			originalMap = this.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
			//Using magic
			while (this.calcCombatLevel() < quantifier) {
				double magic = 0.65/this.efficientGoalCompletion("aCombat", this.getXpToLevel("Magic", this.getLevel("Magic")+1)).getTotalTime();
				double defense = 0.25/this.efficientGoalCompletion("aCombat", this.getXpToLevel("Defense", this.getLevel("Defense")+1)).getTotalTime();
				double prayer = 0.25/this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer")+1)).getTotalTime();
				double summ = 0.25/this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning")+1)).getTotalTime();
				GoalResults bestSubReq = null;
				if (magic > defense && magic > prayer && magic > summ) {
					bestSubReq = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Magic", this.getLevel("Magic")+1));
					this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Magic", this.getLevel("Magic")+1)/3);
					this.getXp().put("Magic", this.getXp().get("Magic") + this.getXpToLevel("Magic", this.getLevel("Magic")+1));
				}
				else if (defense > prayer && defense > summ) {
					bestSubReq = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Defense", this.getLevel("Defense")+1));
					this.getXp().put("Constitution", this.getXp().get("Constitution") + this.getXpToLevel("Defense", this.getLevel("Defense")+1)/3);
					this.getXp().put("Defense", this.getXp().get("Defense") + this.getXpToLevel("Defense", this.getLevel("Defense")+1));
				}
				else if (prayer > summ) {
					bestSubReq = this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", this.getLevel("Prayer")+1));
					this.getXp().put("Prayer", this.getXp().get("Prayer") + this.getXpToLevel("Prayer", ((this.getLevel("Prayer")/2)+1)*2));
				}
				else {
					bestSubReq = this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", this.getLevel("Summoning")+1));
					this.getXp().put("Summoning", this.getXp().get("Summoning") + this.getXpToLevel("Summoning", ((this.getLevel("Summoning")/2)+1)*2));
				}
				levelingByMagic += bestSubReq.getTotalTime();
				if (magicMap.keySet().contains(bestSubReq.getActionsWithTimes().keySet().iterator().next()))
					magicMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), magicMap.get(bestSubReq.getActionsWithTimes().keySet().iterator().next()) + bestSubReq.getTotalTime());
				else
					magicMap.put(bestSubReq.getActionsWithTimes().keySet().iterator().next(), bestSubReq.getTotalTime());
			}
			if (this.getXp().get("Magic") > originalMap.get("Magic")) {
				magicReqs.add(new Requirement("Magic", this.getLevel("Magic")));
			}
			if (this.getXp().get("Defense") > originalMap.get("Defense")) {
				magicReqs.add(new Requirement("Defense", this.getLevel("Defense")));
			}
			if (this.getXp().get("Constitution") > originalMap.get("Constitution")) {
				magicReqs.add(new Requirement("Constitution", this.getLevel("Constitution")));
			}
			if (this.getXp().get("Prayer") > originalMap.get("Prayer")) {
				magicReqs.add(new Requirement("Prayer", this.getLevel("Prayer")));
			}
			if (this.getXp().get("Summoning") > originalMap.get("Summoning")) {
				magicReqs.add(new Requirement("Summoning", this.getLevel("Summoning")));
			}
			this.setXp(originalMap);
			if (levelingByMelee < levelingByMagic && levelingByMelee < levelingByRanged) {
				return new GoalResults(levelingByMelee, meleeReqs, meleeMap);
			}
			else if (levelingByRanged < levelingByMagic) {
				return new GoalResults(levelingByRanged, rangedReqs, rangedMap);
			}
			else  {
				return new GoalResults(levelingByMagic, magicReqs, magicMap);
			}
		}
		double minimum = 1000000000.0;
		String minAction = "";
		List<Requirement> minReqs = new ArrayList<>();
		Map<String,Double> efficiency = new HashMap<>();
		for (Achievement achievement : playerTasks.keySet()) {
			for (Reward reward : achievement.getRewards()) {
				if (reward.getQualifier().equals(qualifier) && reward.getQuantifier() >= quantifier) {
					minimum = Math.min(minimum, playerTasks.get(achievement));
					minAction = achievement.getName();
					minReqs = achievement.getReqs();
				}
			}
		}
		for (Action action : actionDatabase.getDatabase()) {
			if (action.getOutputs().containsKey(qualifier)) {
				double effectiveTimeThisAction = 0.0;
				for (Requirement requirement : action.getReqs()) {
					if (requirement.getQualifier().equals(qualifier) && !requirement.meetsRequirement(this)) {
						// avoids a stack overflow (trying to train to unlock an action by training to unlock that action by training to unlock that action...)
						effectiveTimeThisAction += 9999999;
						break;
					}
					else {
						GoalResults reqResults = requirement.timeAndActionsToMeetRequirement(this);
						effectiveTimeThisAction += reqResults.getTotalTime();
						addItemsToMap(efficiency, reqResults.getActionsWithTimes());
					}
				}
				effectiveTimeThisAction += quantifier/action.effectiveRate(qualifier, this);
				if (effectiveTimeThisAction < minimum) {
					minimum = effectiveTimeThisAction;
					minAction = action.getName();
					minReqs = action.getReqs();
				}
			}
		}
		efficiency.put(minAction, minimum);
		//System.out.println(minReqs);
		//System.out.println(efficiency);
		//System.out.println(minAction + " will achieve " + quantifier + " " +qualifier + " in " + minimum + " hours.");
		return new GoalResults(minimum, minReqs, efficiency);
	}

	public Map addItemsToMap(Map<String,Double> a, Map<String,Double> b) {
		for (String item : b.keySet()) {
			if (a.containsKey(item)) {
				a.put(item, a.get(item) + b.get(item));
			}
			else {
				a.put(item,b.get(item));
			}
		}
		return a;
	}
}