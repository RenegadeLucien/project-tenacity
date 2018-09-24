package logic;

import data.databases.ItemDatabase;

import java.io.Serializable;

public class Reward implements Serializable {
    private String qualifier;
    private int quantifier;

    public Reward(String qualifier, int quantifier) {
        this.qualifier = qualifier;
        this.quantifier = quantifier;
    }

    public String getQualifier() {
        return qualifier;
    }

    public int getQuantifier() {
        return quantifier;
    }

    public double getGainFromReward(Player player) {
        if (qualifier.equals("Attack") || qualifier.equals("Strength"))
            return player.efficientGoalCompletion("mCombat", quantifier).getTotalTime();
        else if (qualifier.equals("Ranged")) {
            return player.efficientGoalCompletion("rCombat", quantifier).getTotalTime();
        } else if (qualifier.equals("Magic")) {
            return player.efficientGoalCompletion("aCombat", quantifier).getTotalTime();
        } else if (qualifier.equals("Defence")) {
            return Math.max(player.efficientGoalCompletion("mCombat", quantifier).getTotalTime(),
                Math.max(player.efficientGoalCompletion("rCombat", quantifier).getTotalTime(),
                    player.efficientGoalCompletion("aCombat", quantifier).getTotalTime()));
        }  else if (qualifier.equals("Invention") && !(player.getLevel("Divination") >= 80 && player.getLevel("Crafting") >= 80 && player.getLevel("Smithing") >= 80)) {
           return 0;
        }  else if (Player.ALL_SKILLS.contains(qualifier)) {
            return player.efficientGoalCompletion(qualifier, quantifier).getTotalTime();
        } else if (qualifier.equals("Coins")) {
            return player.efficientGoalCompletion(qualifier, quantifier).getTotalTime();
        } else if (ItemDatabase.getItemDatabase().getItems().get(qualifier) != null) {
            if (player.getStatus() == 0) {
                return player.efficientGoalCompletion("Coins", quantifier * ItemDatabase.getItemDatabase().getItems().get(qualifier).coinValue(player)).getTotalTime();
            } else {
                return player.efficientGoalCompletion(qualifier, quantifier).getTotalTime();
            }
        }
        return 0;
    }
}