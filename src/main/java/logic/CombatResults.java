package logic;

public class CombatResults {
    private double hpLost;
    private int kills;
    private int ticks;
    private Loadout loadoutUsed;

    public CombatResults(double hpLost, int kills, int ticks, Loadout loadoutUsed) {
        this.hpLost = hpLost;
        this.kills = kills;
        this.ticks = ticks;
        this.loadoutUsed = loadoutUsed;
    }

    public double getHpLost() {
        return hpLost;
    }

    public int getKills() {
        return kills;
    }

    public int getTicks() {
        return ticks;
    }

    public Loadout getLoadoutUsed() {
        return loadoutUsed;
    }
}
