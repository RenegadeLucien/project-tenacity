package data.dataobjects;

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
    private List<Requirement> reqs;

    public Ability(String name, String weaponType, String weaponStyle, String type, int cooldown, double expectedDamage, List<Requirement> reqs) {
        this.name = name;
        this.weaponType = weaponType;
        this.weaponStyle = weaponStyle;
        this.type = type;
        this.cooldown = cooldown;
        this.expectedDamage = expectedDamage;
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

    public List<Requirement> getReqs() {
        return reqs;
    }

    public boolean canUse(int adren, Weapon weapon, Player player) {
        if (type.equals("Auto") || weaponType.equals("Any"))
            return true;
        if (weapon.getWeaponClass().equals(weaponType) && (weaponStyle.equals("Any") || weaponStyle.equals(weapon.getSlot()))) {
            for (Requirement requirement : reqs) {
                if (!requirement.meetsRequirement(player))
                    return false;
            }
            if (type.equals("Basic"))
                return true;
            else if (type.equals("Threshold"))
                return (adren >= 50);
            else if (type.equals("Ultimate"))
                return (adren == 100);
            else
                System.out.println("This is very bad");
        }
        return false;
    }
}