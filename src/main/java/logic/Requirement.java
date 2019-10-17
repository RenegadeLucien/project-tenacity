package logic;

import com.google.common.collect.ImmutableMap;
import data.databases.AchievementDatabase;
import data.databases.ItemDatabase;
import data.dataobjects.Achievement;

import java.util.HashMap;
import java.util.Map;

public class Requirement {
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
            return (player.getLevel(qualifier) >= quantifier);
        } else if (ItemDatabase.getItemDatabase().getItems().get(qualifier) != null) {
            return player.getBankValue() >= ItemDatabase.getItemDatabase().getItems().get(qualifier).coinValue(player)*quantifier;
        } else {
            return (player.getQualities().get(qualifier) != null && player.getQualities().get(qualifier) >= quantifier);
        }
    }

    public GoalResults timeAndActionsToMeetRequirement(Player player) {
        if (meetsRequirement(player)) {
            return new GoalResults(0, ImmutableMap.of("", 0.0));
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
            GoalResults meleeResults = player.efficientGoalCompletion("mCombat", player.getXpToLevel(qualifier, quantifier));
            GoalResults rangedResults = player.efficientGoalCompletion("rCombat", player.getXpToLevel(qualifier, quantifier));
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
        } else if (ItemDatabase.getItemDatabase().getItems().get(qualifier) != null && player.getStatus() == 0) {
            goalResults = player.efficientGoalCompletion("Coins", Math.max(0, ItemDatabase.getItemDatabase().getItems().get(qualifier).coinValue(player)*quantifier)-(int)Math.min(Integer.MAX_VALUE, player.getBankValue()));
        } else if (AchievementDatabase.getAchievementDatabase().getAchievements().get(qualifier) != null) {
            Achievement achievement = AchievementDatabase.getAchievementDatabase().getAchievements().get(qualifier);
            if (player.getAchievementResults().get(achievement) != null) {
                goalResults = player.getAchievementResults().get(achievement);
            }
            else {
                goalResults = new GoalResults(1000000000.0, ImmutableMap.of("Impossible", 1000000000.0));
            }
        } else if (qualifier.equals("Time spent on scripted fights")) {
            goalResults = new GoalResults(quantifier/6000.0, ImmutableMap.of("Time spent on scripted fights", quantifier/6000.0));
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
            if (player.getQualities().containsKey(qualifier)) {
                goalResults = player.efficientGoalCompletion(qualifier, quantifier-player.getQualities().get(qualifier));
            }
            else {
                goalResults = player.efficientGoalCompletion(qualifier, quantifier);
            }
        }
        return goalResults;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Requirement)) {
            return false;
        }
        Requirement r = (Requirement) o;
        return this.quantifier == r.quantifier && this.qualifier.equals(r.qualifier);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + qualifier.hashCode();
        result = 31 * result + quantifier;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", qualifier, quantifier);
    }
}
