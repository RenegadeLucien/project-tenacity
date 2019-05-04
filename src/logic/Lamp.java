package logic;

import java.io.Serializable;
import java.util.List;

public class Lamp implements Serializable {
    private static final Integer[] PRISMATIC_LAMP_EXP_VALUES = {-1, 62, 69, 77, 85, 93, 104, 123, 127, 194, 153, 170, 188,
        205, 229, 252, 261, 274, 285, 298, 310, 324, 337, 352, 367, 384, 399, 405, 414, 453, 473, 493, 514, 536, 559,
        583, 608, 635, 662, 691, 720, 752, 784, 818, 853, 889, 929, 970, 1012, 1055, 1101, 1148, 1200, 1249, 1304, 1362,
        1422, 1485, 1546, 1616, 1684, 1757, 1835, 1911, 2004, 2108, 2171, 2269, 2379, 2470, 2592, 2693, 2809, 2946, 3082,
        3213, 3339, 3495, 3646, 3792, 3980, 4166, 4347, 4521, 4762, 4918, 5033, 5375, 5592, 5922, 6121, 6451, 6614, 6928,
        7236, 7532, 8064, 8347, 8602, 0};

    private List<String> choices;
    private int xp;
    private int minLevel;

    public Lamp(List<String> choices, int xp, int minLevel) {
        this.choices = choices;
        this.xp = xp;
        this.minLevel = minLevel;
    }

    public Reward getBestReward(Player player) {
        double maxGain = 0;
        //Placeholder so null reward doesn't get returned and cause a mess if can't use lamp yet. This should be overwritten
        Reward maxReward = new Reward("Attack", 1);
        boolean cantUse = true;
        for (String choice : choices) {
            if (player.getLevel(choice) >= minLevel) {
                cantUse = false;
                if (player.getLevel(choice) < 99) {
                    int xpReward = xp;
                    //-5: Shattered Heart (gold)
                    if (xp == -5) {
                        xpReward = (int)(Math.floor(player.getLevel(choice)*player.getLevel(choice)*1.2 - player.getLevel(choice)*2.4 + 120));
                    }
                    //-6: Shattered Heart
                    else if (xp == -6) {
                        xpReward = player.getLevel(choice)*player.getLevel(choice) - player.getLevel(choice)*2 + 100;
                    }
                    //-7: Troll Invasion
                    else if (xp == -7) {
                        xpReward = 8*(player.getLevel(choice)*player.getLevel(choice) - player.getLevel(choice)*2 + 100);
                    }
                    //-1: small pris, -2: med pris, -4: large pris, -8: huge pris, -3: other rewards that use pris formula
                    else if (xp < 0 && xp > -9) {
                        xpReward = PRISMATIC_LAMP_EXP_VALUES[player.getLevel(choice)] * -1 * xp;
                    }
                    //-9: dragonkin lamp
                    else if (xp == -9) {
                        xpReward = (int) Math.floor((Math.pow(player.getLevel(choice), 3) - 2 * Math.pow(player.getLevel(choice), 2) + 100 * player.getLevel(choice)) / 20);
                    }
                    //-10+: flat level multiplier (ex. goulash, peng points)
                    else if (xp <= -10) {
                        xpReward = player.getLevel(choice) * -1 * xp;
                    }
                    Reward choiceReward = new Reward(choice, xpReward);
                    double gain = choiceReward.getGainFromReward(player);
                    if (gain > maxGain) {
                        maxGain = gain;
                        maxReward = choiceReward;
                    }
                }
            }
        }
        if (maxReward.getQuantifier() == 1 && maxReward.getQualifier().equals("Attack") && !cantUse) {
            maxReward = new Reward("Attack", 2);
        }
        return maxReward;
    }
}