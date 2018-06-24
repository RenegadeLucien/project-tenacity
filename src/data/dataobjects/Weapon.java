package data.dataobjects;

import data.databases.WeaponDatabase;
import logic.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weapon {

    private String name;
    private String weaponClass;
    private String style;
    private String slot;
    private int damage;
    private int accuracy;
    private int atkspd;
    private int maxAmmo;
    private List<Requirement> reqs;

    public Weapon(String name, String weaponClass, String style, String slot, int damage, int accuracy, int atkspd, int maxAmmo, List<Requirement> reqs) {
        this.name = name;
        this.weaponClass = weaponClass;
        this.style = style;
        this.slot = slot;
        this.damage = damage;
        this.accuracy = accuracy;
        this.atkspd = atkspd;
        this.maxAmmo = maxAmmo;
        this.reqs = reqs;
    }

    public String getName() {
        return name;
    }

    public String getWeaponClass() {
        return weaponClass;
    }

    public String getStyle() {
        return style;
    }

    public String getSlot() {
        return slot;
    }

    public int getDamage() {
        return damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public int getAtkspd() {
        return atkspd;
    }

    public List<Requirement> getReqs() {
        return reqs;
    }

    public static Weapon getWeaponByName(String name) {
        for (Weapon w : WeaponDatabase.getWeaponDatabase().getWeapons()) {
            if (name.equals(w.getName()))
                return w;
        }
        return null;
    }
}
