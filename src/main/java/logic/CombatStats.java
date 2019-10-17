package logic;

public class CombatStats {

    private double accuracy;
    private double armour;
    private double damage;
    private double reduc;

    public CombatStats(double accuracy, double armour, double damage, double reduc) {
        this.accuracy = accuracy;
        this.armour = armour;
        this.damage = damage;
        this.reduc = reduc;
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
