package data.dataobjects;

import data.databases.AmmoDatabase;
import logic.Requirement;

import java.util.List;
import java.util.Map;

public class Ammo {

    private String name;
    private String style;
    private String type;
    private int damage;
    private Map<String, Integer> itemsToUse;
    private List<Requirement> requirements;

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public String getType() {
        return type;
    }

    public Ammo(String name, String style, String type, int damage, Map<String,Integer> itemsToUse, List<Requirement> requirements) {
        this.name = name;
        this.style = style;
        this.type = type;
        this.damage = damage;
        this.itemsToUse = itemsToUse;
        this.requirements = requirements;
    }

    public static Ammo getAmmoByName(String name) {
        for (Ammo a : AmmoDatabase.getAmmoDatabase().getAmmos()) {
            if (name.equals(a.getName()))
                return a;
        }
        return null;
    }
}
