package data.dataobjects;

import data.databases.WeaponDatabase;
import logic.Player;
import logic.Requirement;

import java.util.List;

public class Ability {

    private String name;
    private String weaponType;
    private String weaponStyle;
    private String type;
    private int cooldown;
    private double expectedDamage;
    private int stunTicks;
    private double stunDamage;
    private List<Requirement> reqs;

    public Ability(String name, String weaponType, String weaponStyle, String type, int cooldown, double expectedDamage, int stunTicks, double stunDamage, List<Requirement> reqs) {
        this.name = name;
        this.weaponType = weaponType;
        this.weaponStyle = weaponStyle;
        this.type = type;
        this.cooldown = cooldown;
        this.expectedDamage = expectedDamage;
        this.stunTicks = stunTicks;
        this.stunDamage = stunDamage;
        this.reqs = reqs;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCooldown() {
        return cooldown;
    }

    public double getExpectedDamage() {
        return expectedDamage;
    }

    public double getStunDamage() {
        return stunDamage;
    }

    public int getStunTicks() {
        return stunTicks;
    }

    public boolean canUse(Weapon mainWep, Weapon offWep, Player player) {
        if (type.equals("Auto") || weaponType.equals("Any")) {
            return true;
        }
        if (mainWep.getWeaponClass().equals(weaponType) && (weaponStyle.equals("Any") || (weaponStyle.equals("Dual") && !offWep.equals(WeaponDatabase.getWeaponDatabase().getWeapons().get("None"))) ||
            (weaponStyle.equals("Two-handed") && mainWep.getSlot().equals("Two-handed")))) {
            for (Requirement requirement : reqs) {
                if (!requirement.meetsRequirement(player))
                    return false;
            }
            return true;
        }
        return false;
    }
}