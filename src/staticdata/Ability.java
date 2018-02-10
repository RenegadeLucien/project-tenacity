package staticdata;

import dynamicdata.Player;
import dynamicdata.Requirement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Ability {
    AUTO_ATTACK("Auto-attack", "None", "Any", "Auto", 4, 0.5, new ArrayList<>()),
    SLICE("Slice", "Melee", "Any", "Basic", 5, 0.75, new ArrayList<>()),
    SLAUGHTER("Slaughter", "Melee", "Any", "Threshold", 50, 1.75, new ArrayList<>()),
    OVERPOWER("Overpower", "Melee", "Any", "Ultimate", 50, 3, Collections.singletonList(new Requirement("Attack", 2))),
    HAVOC("Havoc", "Melee", "Dual", "Basic", 17, 0.942, Collections.singletonList(new Requirement("Attack", 5))),
    BACKHAND("Backhand", "Melee", "Any", "Basic", 25, 0.6, Collections.singletonList(new Requirement("Attack", 10))),
    FORCEFUL_BACKHAND("Forceful Backhand", "Melee", "Any", "Threshold", 25, 1.2, Collections.singletonList(new Requirement("Attack", 15))),
    SMASH("Smash", "Melee", "Two-handed", "Basic", 17, 0.942, Collections.singletonList(new Requirement("Attack", 20))),
    BARGE("Barge", "Melee", "Any", "Basic", 34, 0.75, Collections.singletonList(new Requirement("Attack", 30))),
    FLURRY("Flurry", "Melee", "Dual", "Threshold", 34, 2.04, Collections.singletonList(new Requirement("Attack", 37))),
    SEVER("Sever", "Melee", "Any", "Basic", 25, 1.128, Collections.singletonList(new Requirement("Attack", 45))),
    KICK("Kick", "Melee", "Any", "Basic", 25, 0.6, Collections.singletonList(new Requirement("Strength", 3))),
    STOMP("Stomp", "Melee", "Any", "Threshold", 25, 1.2, Collections.singletonList(new Requirement("Strength", 3))),
    PUNISH("Punish", "Melee", "Any", "Basic", 5, 0.564, Collections.singletonList(new Requirement("Strength", 8))),
    DISMEMBER("Dismember", "Melee", "Any", "Basic", 25, 1.206, Collections.singletonList(new Requirement("Strength", 14))),
    FURY("Fury", "Melee", "Any", "Basic", 9, 1.476, Collections.singletonList(new Requirement("Strength", 24))),
    DESTROY("Destroy", "Melee", "Dual", "Threshold", 37, 4.512, Collections.singletonList(new Requirement("Strength", 37))),
    WRACK("Wrack", "Magic", "Any", "Basic", 5, 0.564, new ArrayList<>()),
    ASPHYXIATE("Asphyxiate", "Magic", "Any", "Threshold", 33, 4.512, Collections.singletonList(new Requirement("Magic", 2))),
    OMNIPOWER("Omnipower", "Magic", "Any", "Ultimate", 50, 3, Collections.singletonList(new Requirement("Magic", 2))),
    DRAGON_BREATH("Dragon Breath", "Magic", "Any", "Basic", 17, 1.128, Collections.singletonList(new Requirement("Magic", 5))),
    SONIC_WAVE("Sonic Wave", "Magic", "Two-handed", "Basic", 8, 0.942, Collections.singletonList(new Requirement("Magic", 8))),
    SNAP_SHOT("Snap Shot", "Ranged", "Any","Threshold", 34, 2.65, new ArrayList<>()),
    PIERCING_SHOT("Piercing Shot", "Ranged", "Any", "Basic", 5, 0.564, new ArrayList<>()),
    DEADSHOT("Deadshot", "Ranged", "Any", "Ultimate", 50, 4.258, Collections.singletonList(new Requirement("Ranged", 2))),
    SNIPE("Snipe", "Ranged", "Any", "Basic", 17, 1.72, Collections.singletonList(new Requirement("Ranged", 5))),
    DAZING_SHOT("Dazing Shot", "Ranged", "Two-handed", "Basic", 8, 0.942, Collections.singletonList(new Requirement("Ranged", 8)));

    private String name;
    private String weaponType;
    private String weaponStyle;
    private String type;
    private int cooldown;
    private double expectedDamage;
    private List<Requirement> reqs;

    Ability(String name, String weaponType, String weaponStyle, String type, int cooldown, double expectedDamage, List<Requirement> reqs) {
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