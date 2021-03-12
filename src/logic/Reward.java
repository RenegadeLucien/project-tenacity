package logic;

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
        } else if (qualifier.equals("Defence")) {
            return Math.min(player.efficientGoalCompletion("mCombat", quantifier).getTotalTime(),
                Math.min(player.efficientGoalCompletion("rCombat", quantifier).getTotalTime(),
                    player.efficientGoalCompletion("aCombat", quantifier).getTotalTime()));
        }  else if (qualifier.equals("Invention") && !(LevelHelper.getLevel("Divination", player.getXp().get("Divination")) >= 80
            && LevelHelper.getLevel("Crafting", player.getXp().get("Crafting")) >= 80 && LevelHelper.getLevel("Smithing", player.getXp().get("Smithing")) >= 80)) {
           return 0;
        }  else if (Player.ALL_SKILLS.contains(qualifier)) {
            return player.efficientGoalCompletion(qualifier, quantifier).getTotalTime();
        } else if (qualifier.equals("Coins")) {
            return player.efficientGoalCompletion(qualifier, quantifier).getTotalTime();
        } else if (PriceFetcher.getPrice(qualifier) > 0) {
            if (player.getStatus() == 0) {
                return player.efficientGoalCompletion("Coins", quantifier * PriceFetcher.getPrice(qualifier)).getTotalTime();
            } else {
                return player.efficientGoalCompletion(qualifier, quantifier).getTotalTime();
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", qualifier, quantifier);
    }
}
