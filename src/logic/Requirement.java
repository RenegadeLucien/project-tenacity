package logic;

import data.dataobjects.Achievement;
import data.dataobjects.Item;

import java.util.HashMap;
import java.util.Map;

public class Requirement implements java.io.Serializable {
    private String qualifier;
    private int quantifier;

    public Requirement(String qualifier, int quantifier) {
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
        } else if (Item.getItemByName(qualifier) != null) {
            if (player.getBank().keySet().contains(qualifier)
                && player.getBank().get(qualifier) >= quantifier) {
                return true;
            }
        } else {
            if (player.getQualities().keySet().contains(qualifier) && player.getQualities().get(qualifier) >= quantifier) {
                return true;
            }
        }
        return false;
    }

    public GoalResults timeAndActionsToMeetRequirement(Player player) {
        if (meetsRequirement(player)) {
            return new GoalResults(0, Map.of("", 0.0));
        }
        double time;
        Map<String, Double> actions = new HashMap<>();
        GoalResults goalResults;
        if (qualifier.equals("Strength") || qualifier.equals("Attack")) {
            goalResults = player.efficientGoalCompletion("mCombat", player.getXpToLevel(qualifier, quantifier));
        } else if (qualifier.equals("Ranged")) {
            goalResults = player.efficientGoalCompletion("rCombat", player.getXpToLevel(qualifier, quantifier));
        } else if (qualifier.equals("Magic")) {
            goalResults = player.efficientGoalCompletion("aCombat", player.getXpToLevel(qualifier, quantifier));
        } else if (qualifier.equals("Defence")) {
            GoalResults meleeResults = player.efficientGoalCompletion("aCombat", player.getXpToLevel(qualifier, quantifier));
            GoalResults rangedResults = player.efficientGoalCompletion("aCombat", player.getXpToLevel(qualifier, quantifier));
            GoalResults magicResults = player.efficientGoalCompletion("aCombat", player.getXpToLevel(qualifier, quantifier));
            if (meleeResults.getTotalTime() < rangedResults.getTotalTime() && meleeResults.getTotalTime() < magicResults.getTotalTime()) {
                goalResults = meleeResults;
            } else if (rangedResults.getTotalTime() < magicResults.getTotalTime()) {
                goalResults = rangedResults;
            } else {
                goalResults = magicResults;
            }
        } else if (Player.ALL_SKILLS.contains(qualifier)) {
            goalResults = player.efficientGoalCompletion(qualifier, player.getXpToLevel(qualifier, quantifier));

        } else if (Item.getItemByName(qualifier) != null && player.getStatus() == 0) {
            goalResults = player.efficientGoalCompletion(qualifier, quantifier);
            if (player.efficientGoalCompletion("Coins", Item.getItemByName(qualifier).coinValue(player) * quantifier).getTotalTime() < goalResults.getTotalTime()) {
                goalResults = player.efficientGoalCompletion("Coins", Item.getItemByName(qualifier).coinValue(player) * quantifier);
            }
        } else if (Achievement.getAchievementByName(qualifier) != null) {
            return player.getTaskDetails().get(Achievement.getAchievementByName(qualifier));
        } else if (qualifier.equals("Flags unfurled")) {
            goalResults = new Requirement("Master Quester", 1).timeAndActionsToMeetRequirement(player);
            for (String skill : Player.ALL_SKILLS) {
                GoalResults skillResults = player.efficientGoalCompletion(skill, player.getXpToLevel(skill, 99));
                if (skillResults.getTotalTime() < goalResults.getTotalTime()) {
                    goalResults = skillResults;
                }
            }
        } else if (qualifier.equals("Ports unlocked")) {
            goalResults = player.efficientGoalCompletion("Agility", player.getXpToLevel("Agility", 90));
            for (String skill : Player.PORTS_SKILLS) {
                GoalResults skillResults = player.efficientGoalCompletion(skill, player.getXpToLevel(skill, 90));
                if (skillResults.getTotalTime() < goalResults.getTotalTime()) {
                    goalResults = skillResults;
                }
            }
        } else {
            goalResults = player.efficientGoalCompletion(qualifier, quantifier);
        }
        time = goalResults.getTotalTime();
        addItemsToMap(actions, goalResults.getActionsWithTimes());
        //System.out.println(quantifier + " " +qualifier + " will be achieved in " + time + " hours");
        return new GoalResults(time, actions);
    }

    public void addItemsToMap(Map<String, Double> a, Map<String, Double> b) {
        for (String item : b.keySet()) {
            if (a.containsKey(item) && Item.getItemByName(item) != null) {
                a.put(item, a.get(item) + b.get(item));
            } else if (a.containsKey(item)) {
                a.put(item, Math.max(a.get(item), b.get(item)));
            } else {
                a.put(item, b.get(item));
            }
        }
    }
}