package dynamicdata;

import java.util.List;

public class Lamp {
    List<String> choices;
    int xp;
    int minLevel;

    public Lamp (List<String> choices, int xp, int minLevel) {
        this.choices = choices;
        this.xp = xp;
        this.minLevel = minLevel;
    }

    public Reward getBestReward(Player player) {
        double maxGain = 0;
        Reward maxReward = null;
        for (String choice : choices) {
            if (player.getLevel(choice) >= minLevel && player.getLevel(choice) < 99) {
                Reward choiceReward = new Reward(choice, xp);
                double gain = choiceReward.getGainFromReward(player);
                if (gain > maxGain) {
                    maxGain = gain;
                    maxReward = choiceReward;
                }
            }
        }
        return maxReward;
    }
}