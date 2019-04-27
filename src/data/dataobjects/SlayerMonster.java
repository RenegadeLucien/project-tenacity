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

    public String getMonster() {
        return monster;
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
        CombatResults combatResults = new Encounter(monster).calculateCombat(player, new CombatParameters(0, combatStyle, true, 0, false));
        if (combatResults.getHpLost() == 1000000000) {
            return 1000000000;
        }
        int killsPerTrip = combatResults.getKills();
        if (killsPerTrip >= monstersInTask) {
            return monstersInTask * combatResults.getTicks() / killsPerTrip;
        }
        else {
            return monstersInTask * (combatResults.getTicks() + 100) / killsPerTrip;
        }
    }
}
