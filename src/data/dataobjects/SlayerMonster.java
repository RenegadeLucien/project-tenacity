package data.dataobjects;

import logic.*;

import java.util.ArrayList;
import java.util.List;

public class SlayerMonster {

    private String monster;
    private double slayerXp;
    private String category;
    private List<Requirement> reqs;

    public SlayerMonster(String monster, double slayerXp, String category, List<Requirement> reqs) {
        this.monster = monster;
        this.slayerXp = slayerXp;
        this.category = category;
        this.reqs = reqs;
    }

    public String getCategory() {
        return category;
    }

    public double getSlayerXp() {
        return slayerXp;
    }

    public List<Requirement> getReqs() {
        return reqs;
    }

    public int timeToTask(Player player, String combatStyle, int monstersInTask) {
        CombatResults combatResults = new Encounter(monster, new ArrayList<>()).calculateCombat(player, 0, combatStyle);
        if (combatResults.getHpLost() == 1000000000) {
            return 1000000000;
        }
        int time = 0;
        double currentHp = player.getLevel("Constitution") * 100;
        int kills = 0;
        while (kills < monstersInTask) {
            int ticksThisKill = combatResults.getTicksTaken();
            ticksThisKill = Math.max(3, ticksThisKill);
            if (currentHp < combatResults.getHpLost()) {
                ticksThisKill += 100;
                currentHp = player.getLevel("Constitution") * 100;
            }
            kills++;
            time += ticksThisKill;
            currentHp -= combatResults.getHpLost();
        }
        return time;
    }
}
