package data.dataobjects;

import data.databases.EnemyDatabase;

import java.io.Serializable;

public class Enemy implements Serializable {

    private String name;
    private int lp;
    private double cbxp;
    private double hpxp;
    private int maxhitmelee;
    private int maxhitranged;
    private int maxhitmagic;
    private int attack;
    private int ranged;
    private int magic;
    private int atkspd;
    private int accmelee;
    private int accranged;
    private int accmage;
    private int armor;
    private int def;
    private String weakness;
    private int affweakness;
    private int affmelee;
    private int affranged;
    private int affmage;

    public Enemy(String name, int lp, double cbxp, double hpxp, int maxhitmelee, int maxhitranged,
          int maxhitmagic, int attack, int ranged, int magic, int atkspd, int accmelee, int accranged, int accmage,
          int armor, int def, String weakness, int affweakness, int affmelee, int affranged, int affmage) {

        this.name = name;
        this.lp = lp;
        this.cbxp = cbxp;
        this.hpxp = hpxp;
        this.maxhitmelee = maxhitmelee;
        this.maxhitranged = maxhitranged;
        this.maxhitmagic = maxhitmagic;
        this.attack = attack;
        this.ranged = ranged;
        this.magic = magic;
        this.atkspd = atkspd;
        this.accmelee = accmelee;
        this.accranged = accranged;
        this.accmage = accmage;
        this.armor = armor;
        this.def = def;
        this.weakness = weakness;
        this.affweakness = affweakness;
        this.affmelee = affmelee;
        this.affranged = affranged;
        this.affmage = affmage;
    }

    public static Enemy getEnemyByName(String name) {
        for (Enemy e : EnemyDatabase.getEnemyDatabase().getEnemies()) {
            if (name.equals(e.getName()))
                return e;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public double getCbxp() {
        return cbxp;
    }

    public double getHpxp() {
        return hpxp;
    }

    public int getAffmelee() {
        return affmelee;
    }

    public int getAffranged() {
        return affranged;
    }

    public int getAffmage() {
        return affmage;
    }

    public int getArmor() {
        return armor;
    }

    public int getDef() {
        return def;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getAccmage() {
        return accmage;
    }

    public int getAccmelee() {
        return accmelee;
    }

    public int getAccranged() {
        return accranged;
    }

    public int getAffweakness() {
        return affweakness;
    }

    public int getAttack() {
        return attack;
    }

    public int getRanged() {
        return ranged;
    }

    public int getMagic() {
        return magic;
    }

    public int getMaxhitmagic() {
        return maxhitmagic;
    }

    public int getMaxhitmelee() {
        return maxhitmelee;
    }

    public int getMaxhitranged() {
        return maxhitranged;
    }

    public int getLp() {
        return lp;
    }

    public int getAtkspd() {
        return atkspd;
    }
}
