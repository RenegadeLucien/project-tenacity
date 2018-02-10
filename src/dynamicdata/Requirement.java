package dynamicdata;

import staticdata.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Requirement {
	private String qualifier;
	private int quantifier;

	public Requirement(String qualifier, int quantifier)
	{
		this.qualifier = qualifier;
		this.quantifier = quantifier;
	}

	public String getQualifier() {
		return qualifier;
	}

	public int getQuantifier() {
		return quantifier;
	}

	public boolean meetsRequirement(Player player) {
		if (Player.ALL_SKILLS.contains(qualifier)) {
			if (player.getLevel(qualifier) >= quantifier) {
				return true;
			}
		}
		else if (Item.getItemByName(qualifier) != null){
			if (player.getBank().keySet().contains(qualifier)
					&& player.getBank().get(qualifier) >= quantifier) {
				return true;
			}
		}
		else {
			if (player.getQualities().keySet().contains(qualifier) && player.getQualities().get(qualifier) >= quantifier) {
				return true;
			}
		}
		return false;
	}

	public GoalResults timeAndActionsToMeetRequirement(Player player) {
		if (meetsRequirement(player)) {return new GoalResults(0, new ArrayList(), Map.of("", 0.0));}
		double time = 99999;
		Map<String,Double> actions = new HashMap<>();
		List<Requirement> recursiveRequirements = new ArrayList<>();
		if (qualifier.equals("Strength") || qualifier.equals("Attack")) {
			GoalResults goalResults = player.efficientGoalCompletion("mCombat", player.getXpToLevel(qualifier, quantifier));
			time = goalResults.getTotalTime();
			addItemsToMap(actions, goalResults.getActionsWithTimes());
			recursiveRequirements.addAll(goalResults.getRequirements());
		}
		else if (qualifier.equals("Ranged")) {
			GoalResults goalResults = player.efficientGoalCompletion("rCombat", player.getXpToLevel(qualifier, quantifier));
			time = goalResults.getTotalTime();
			addItemsToMap(actions, goalResults.getActionsWithTimes());
			recursiveRequirements.addAll(goalResults.getRequirements());
		}
		else if (qualifier.equals("Magic")) {
			GoalResults goalResults = player.efficientGoalCompletion("aCombat", player.getXpToLevel(qualifier, quantifier));
			time = goalResults.getTotalTime();
			addItemsToMap(actions, goalResults.getActionsWithTimes());
			recursiveRequirements.addAll(goalResults.getRequirements());
		}
		else if (qualifier.equals("Defense")) {
			GoalResults meleeResults = player.efficientGoalCompletion("aCombat", player.getXpToLevel(qualifier, quantifier));
			GoalResults rangedResults = player.efficientGoalCompletion("aCombat", player.getXpToLevel(qualifier, quantifier));
			GoalResults magicResults = player.efficientGoalCompletion("aCombat", player.getXpToLevel(qualifier, quantifier));
			if (meleeResults.getTotalTime() < rangedResults.getTotalTime() && meleeResults.getTotalTime() < magicResults.getTotalTime()) {
				time = meleeResults.getTotalTime();
				addItemsToMap(actions, meleeResults.getActionsWithTimes());
				recursiveRequirements.addAll(meleeResults.getRequirements());
			}
			else if (rangedResults.getTotalTime() < magicResults.getTotalTime()) {
				time = rangedResults.getTotalTime();
				addItemsToMap(actions, rangedResults.getActionsWithTimes());
				recursiveRequirements.addAll(rangedResults.getRequirements());
			}
			else {
				time = magicResults.getTotalTime();
				addItemsToMap(actions, magicResults.getActionsWithTimes());
				recursiveRequirements.addAll(magicResults.getRequirements());
			}
		}
		else if (Player.ALL_SKILLS.contains(qualifier)) {
			GoalResults goalResults = player.efficientGoalCompletion(qualifier, player.getXpToLevel(qualifier, quantifier));
			time = goalResults.getTotalTime();
			addItemsToMap(actions, goalResults.getActionsWithTimes());
			recursiveRequirements.addAll(goalResults.getRequirements());
		}
		else {
			GoalResults goalResults = player.efficientGoalCompletion(qualifier, quantifier);
			if (Item.getItemByName(qualifier) != null && player.getStatus() == 0) {
				if (player.efficientGoalCompletion("Coins", Item.getItemByName(qualifier).coinValue(player) * quantifier).getTotalTime() < time) {
					goalResults = player.efficientGoalCompletion("Coins", Item.getItemByName(qualifier).coinValue(player) * quantifier);
				}
			}
			time = goalResults.getTotalTime();
			addItemsToMap(actions, goalResults.getActionsWithTimes());
			recursiveRequirements.addAll(goalResults.getRequirements());
		}
		//System.out.println(quantifier + " " +qualifier + " will be achieved in " + time + " hours");
		return new GoalResults(time, recursiveRequirements, actions);
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