package logic;

public class CombatResults {
    private double hpLost;
    private int ticksTaken;
    private Loadout loadoutUsed;

    public CombatResults(double hpLost, int ticksTaken, Loadout loadoutUsed) {
        this.hpLost = hpLost;
        this.ticksTaken = ticksTaken;
        this.loadoutUsed = loadoutUsed;
    }

    public double getHpLost() {
        return hpLost;
    }

    public int getTicksTaken() {
        return ticksTaken;
    }

    public Loadout getLoadoutUsed() {
        return loadoutUsed;
    }
}