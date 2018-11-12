package logic;

public class CombatStats {

    private double accuracy;
    private double armour;
    private double damage;
    private double lp;
    private double reduc;

    public CombatStats(double accuracy, double armour, double damage, double lp, double reduc) {
        this.accuracy = accuracy;
        this.armour = armour;
        this.damage = damage;
        this.lp = lp;
        this.reduc = reduc;
    }

    public double getLp() {
        return lp;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getArmour() {
        return armour;
    }

    public double getDamage() {
        return damage;
    }

    public double getReduc() {
        return reduc;
    }
}
