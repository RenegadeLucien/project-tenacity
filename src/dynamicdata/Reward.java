package dynamicdata;

import staticdata.Item;

public class Reward {
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
        } else if (qualifier.equals("Defense")) {
            return Math.max(player.efficientGoalCompletion("mCombat", quantifier).getTotalTime(),
                Math.max(player.efficientGoalCompletion("rCombat", quantifier).getTotalTime(),
                    player.efficientGoalCompletion("aCombat", quantifier).getTotalTime()));
        } else if (Player.ALL_SKILLS.contains(qualifier)) {
            return player.efficientGoalCompletion(qualifier, quantifier).getTotalTime();
        } else if (qualifier.equals("Coins")) {
            return player.efficientGoalCompletion(qualifier, quantifier).getTotalTime();
        } else if (Item.getItemByName(qualifier) != null) {
            if (player.getStatus() == 0) {
                return player.efficientGoalCompletion("Coins", quantifier * Item.getItemByName(qualifier).coinValue(player)).getTotalTime();
            } else {
                return player.efficientGoalCompletion(qualifier, quantifier).getTotalTime();
            }
        }
        return 0;
    }
}