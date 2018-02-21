package staticdata;

import dynamicdata.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Armour {
    NONE("None", "None", "None", 0, 0, 0, 0, 0, new ArrayList<>()),

    BRONZE_HELM("Bronze helm", "Melee", "Head", 26, 0, 0, 0.0006, 0, new ArrayList<>()),
    IRON_HELM("Iron helm", "Melee", "Head", 36, 0, 0, 0.0016, 0, Arrays.asList(new Requirement("Defense", 10))),
    LEATHER_COWL("Leather cowl", "Ranged", "Head", 30, 0, 0, 0.001, 0, new ArrayList<>()),
    HARD_LEATHER_COWL("Hard leather cowl", "Ranged", "Head", 40, 0, 0, 0.002, 0, Arrays.asList(new Requirement("Defense", 10))),
    WIZARD_HAT_BLUE("Wizard hat (blue)", "Magic", "Head", 22, 0, 0, 0.0002, 0, new ArrayList<>()),
    FIRST_TOWER_HAT("First tower hat", "Magic", "Head", 40, 0, 0, 0.002, 0, new ArrayList<>()),
    BRONZE_CHAINBODY("Bronze chainbody", "Melee", "Torso", 29, 0, 0, 0.0006, 0, new ArrayList<>()),
    BRONZE_PLATEBODY("Bronze platebody", "Melee", "Torso", 34, 0, 0, 0.001, 0, new ArrayList<>()),
    IRON_CHAINBODY("Iron chainbody", "Melee", "Torso", 41, 0, 0, 0.0016, 0, Arrays.asList(new Requirement("Defense", 10))),
    IRON_PLATEBODY("Iron platebody", "Melee", "Torso", 46, 0, 0, 0.002, 0, Arrays.asList(new Requirement("Defense", 10))),
    LEATHER_BODY("Leather body", "Ranged", "Torso", 34, 0, 0, 0.001, 0, new ArrayList<>()),
    HARD_LEATHER_BODY("Hard leather body", "Ranged", "Torso", 46, 0, 0, 0.002, 0, Arrays.asList(new Requirement("Defense", 10))),
    WIZARD_ROBE_TOP("Wizard robe top", "Magic", "Torso", 25, 0, 0, 0.0002, 0, new ArrayList<>()),
    BRONZE_PLATELEGS("Bronze platelegs", "Melee", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()),
    BRONZE_PLATESKIRT("Bronze plateskirt", "Melee", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()),
    IRON_PLATELEGS("Iron platelegs", "Melee", "Legs", 44, 0, 0, 0.002, 0, Arrays.asList(new Requirement("Defense", 10))),
    IRON_PLATESKIRT("Iron plateskirt", "Melee", "Legs", 44, 0, 0, 0.002, 0, Arrays.asList(new Requirement("Defense", 10))),
    LEATHER_CHAPS("Leather chaps", "Ranged", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()),
    HARD_LEATHER_CHAPS("Hard leather chaps", "Ranged", "Legs", 44, 0, 0, 0.002, 0, Arrays.asList(new Requirement("Defense", 10))),
    WIZARD_ROBE_SKIRT("Wizard robe skirt", "Magic", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()),
    BRONZE_SQ_SHIELD("Bronze sq shield", "Melee", "Shield", 26, 0, 0, 0.003, 0, new ArrayList<>()),
    IRON_SQ_SHIELD("Iron sq shield", "Melee", "Shield", 36, 0, 0, 0.008, 0, Arrays.asList(new Requirement("Defense", 10))),
    LEATHER_SHIELD("Leather shield", "Ranged", "Shield", 30, 0, 0, 0.005, 0, new ArrayList<>()),
    SHIELDBOW("Shieldbow", "Ranged", "Shield", 30, 0, 0, 0.005, 0, new ArrayList<>()),
    HARD_LEATHER_SHIELD("Hard leather shield", "Ranged", "Shield", 40, 0, 0, 0.01, 0, Arrays.asList(new Requirement("Defense", 10))),
    WIZARD_SHIELD("Wizard shield", "Magic", "Shield", 30, 0, 0, 0.001, 0, new ArrayList<>()),
    LEATHER_VAMBRACES("Leather vambraces", "Ranged", "Hands", 5, 0, 0, 0.0002, 0, new ArrayList<>()),
    HARD_LEATHER_GLOVES("Hard leather gloves", "Ranged", "Hands", 10, 0, 0, 0.002, 0, Arrays.asList(new Requirement("Defense", 10))),
    WIZARD_GLOVES("Wizard gloves", "Magic", "Hands", 7, 0, 0, 0.001, 0, new ArrayList<>()),
    IMPHIDE_GLOVES("Imphide gloves", "Magic", "Hands", 10, 0, 0, 0.002, 0, Arrays.asList(new Requirement("Defense", 10))),
    LEATHER_BOOTS("Leather boots", "Ranged", "Feet", 5, 0, 0, 0.0002, 0, new ArrayList<>()),
    HARD_LEATHER_BOOTS("Hard leather boots", "Ranged", "Feet", 7, 0, 0, 0.001, 0, Arrays.asList(new Requirement("Defense", 10))),
    WIZARD_BOOTS("Wizard boots", "Magic", "Feet", 7, 0, 0, 0.001, 0, new ArrayList<>()),
    IMPHIDE_BOOTS("Imphide boots", "Magic", "Feet", 10, 0, 0, 0.002, 0, Arrays.asList(new Requirement("Defense", 10)));

    private String name;
    private String type;
    private String slot;
    private int armour;
    private int lp;
    private int pray;
    private double reduc;
    private int bonus;
    private List<Requirement> reqs;

    Armour(String name, String type, String slot, int armour, int lp, int pray, double reduc, int bonus, List<Requirement> reqs) {
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
        for (Armour a : values()) {
            if (name.equals(a.getName()))
                return a;
        }
        return null;
    }
}
