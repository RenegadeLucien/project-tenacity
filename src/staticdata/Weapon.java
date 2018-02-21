package staticdata;

import dynamicdata.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Weapon {
    BRONZE_SWORD("Bronze sword", "Melee", "Stab", "Mainhand", 48, 150, new ArrayList<>()),
    BRONZE_BATTLEAXE("Bronze battleaxe", "Melee", "Slash", "Mainhand", 48, 150, new ArrayList<>()),
    IRON_BATTLEAXE("Iron battleaxe", "Melee", "Slash", "Mainhand", 96, 202, Arrays.asList(new Requirement("Attack", 10))),
    EXCALIBUR("Excalibur", "Melee", "Slash", "Mainhand", 288, 454, Arrays.asList(new Requirement("Attack", 30), new Requirement("Merlin's Crystal", 1))),
    BRONZE_2H_SWORD("Bronze 2h sword", "Melee", "Slash", "Two-handed", 72, 150, new ArrayList<>()),
    IRON_2H_SWORD("Iron 2h sword", "Melee", "Slash", "Two-handed", 144, 202, Arrays.asList(new Requirement("Attack", 10))),
    SHIELDBOW("Shieldbow", "Ranged", "Arrows", "Mainhand", 26, 150, new ArrayList<>()),
    SHORTBOW("Shortbow", "Ranged", "Arrows", "Two-handed", 43, 150, new ArrayList<>()),
    CHARGEBOW("Chargebow", "Ranged", "Arrows", "Two-handed", 72, 150, new ArrayList<>()),
    //BRONZE_ARROW("Bronze arrow", "Ranged", "Ammo", "Ammo", 48, 0, new ArrayList<>()),
    STAFF("Staff", "Magic", "Two-handed", "Magic", 72, 150, new ArrayList<>()),
    MAGIC_STAFF("Magic staff", "Magic", "Two-handed", "Magic", 72, 150, new ArrayList<>()),
    TOWER_MINDSPIKE("Tower mindspike", "Magic", "Two-handed", "Magic", 86, 160, new ArrayList<>());

    private String name;
    private String weaponClass;
    private String style;
    private String slot;
    private int damage;
    private int accuracy;
    private List<Requirement> reqs;

    Weapon(String name, String weaponClass, String style, String slot, int damage, int accuracy, List<Requirement> reqs) {
        this.name = name;
        this.weaponClass = weaponClass;
        this.style = style;
        this.slot = slot;
        this.damage = damage;
        this.accuracy = accuracy;
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

    public List<Requirement> getReqs() {
        return reqs;
    }

    public static Weapon getWeaponByName(String name) {
        for (Weapon w : values()) {
            if (name.equals(w.getName()))
                return w;
        }
        return null;
    }
}
