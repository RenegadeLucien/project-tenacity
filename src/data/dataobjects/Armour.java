package data.dataobjects;

import data.databases.ArmourDatabase;
import logic.Requirement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Armour implements Serializable {

    private String name;
    private String type;
    private String slot;
    private int armour;
    private int lp;
    private int pray;
    private double reduc;
    private int bonus;
    private List<Requirement> reqs;

    public Armour(String name, String type, String slot, int armour, int lp, int pray, double reduc, int bonus, List<Requirement> reqs) {
        this.name = name;
        this.type = type;
        this.slot = slot;
        this.armour = armour;
        this.lp = lp;
        this.pray = pray;
        this.reduc = reduc;
        this.bonus = bonus;
        this.reqs = reqs;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSlot() {
        return slot;
    }

    public int getArmour() {
        return armour;
    }

    public int getLp() {
        return lp;
    }

    public int getPray() {
        return pray;
    }

    public double getReduc() {
        return reduc;
    }

    public int getBonus() {
        return bonus;
    }

    public List<Requirement> getReqs() {
        return reqs;
    }

    public static Armour getArmourByName(String name) {
        for (Armour a : ArmourDatabase.getArmourDatabase().getArmours()) {
            if (name.equals(a.getName()))
                return a;
        }
        return null;
    }
}
