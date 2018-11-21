package logic;

import data.dataobjects.*;

public class Loadout {

    private Weapon mainWep;
    private Weapon offWep;
    private Armour shield;
    private Armour head;
    private Armour torso;
    private Armour legs;
    private Armour hands;
    private Armour feet;
    private Armour cape;
    private Armour neck;
    private Armour ring;
    private Familiar familiar;
    private Prayer prayer;


    public Loadout(Weapon mainWep, Weapon offWep, Armour shield, Armour head, Armour torso, Armour legs, Armour hands, Armour feet, Armour cape, Armour neck, Armour ring, Familiar familiar, Prayer prayer) {
        this.mainWep = mainWep;
        this.offWep = offWep;
        this.shield = shield;
        this.head = head;
        this.torso = torso;
        this.legs = legs;
        this.hands = hands;
        this.feet = feet;
        this.cape = cape;
        this.neck = neck;
        this.ring = ring;
        this.familiar = familiar;
        this.prayer = prayer;
    }

    public Weapon getMainWep() {
        return mainWep;
    }

    public Weapon getOffWep() {
        return offWep;
    }

    public Familiar getFamiliar() {
        return familiar;
    }

    public Prayer getPrayer() {
        return prayer;
    }

    public Armour getCape() {
        return cape;
    }

    public Armour getFeet() {
        return feet;
    }

    public Armour getHands() {
        return hands;
    }

    public Armour getHead() {
        return head;
    }

    public Armour getLegs() {
        return legs;
    }

    public Armour getNeck() {
        return neck;
    }

    public Armour getRing() {
        return ring;
    }

    public Armour getTorso() {
        return torso;
    }

    public Armour getShield() {
        return shield;
    }

    public int totalArmour() {
        return head.getArmour() + torso.getArmour() + legs.getArmour() + hands.getArmour() + feet.getArmour() + cape.getArmour() + neck.getArmour() + ring.getArmour() + shield.getArmour()
            + mainWep.getArmour() + offWep.getArmour();
    }

    public double totalReduc() {
        return head.getReduc() + torso.getReduc() + legs.getReduc() + hands.getReduc() + feet.getReduc() + cape.getReduc() + neck.getReduc() + ring.getReduc() + shield.getReduc();
    }

    public int totalBonus() {
        return head.getBonus() + torso.getBonus() + legs.getBonus() + hands.getBonus() + feet.getBonus() + cape.getBonus() + neck.getBonus() + ring.getBonus() + shield.getBonus();
    }

    public int totalLp() {
        return head.getLp() + torso.getLp() + legs.getLp() + hands.getLp() + feet.getLp() + cape.getLp() + neck.getLp() + ring.getLp() + shield.getLp();
    }

    public int totalPrayBonus() {
        return head.getPray() + torso.getPray() + legs.getPray() + hands.getPray() + feet.getPray() + cape.getPray() + neck.getPray() + ring.getPray() + shield.getPray();
    }

    public CombatStats getCombatStats(Player player, String combatStyle) {
        String damageSkill;
        String accuracySkill;
        if (combatStyle.equals("Melee")) {
            accuracySkill = "Attack";
            damageSkill = "Strength";
        } else if (combatStyle.equals("Ranged")) {
            accuracySkill = damageSkill = "Ranged";
        } else {
            accuracySkill = damageSkill = "Magic";
        }
        double myDamage;
        if (mainWep.getAtkspd() == 4) {
            myDamage = 2.5 * player.getLevel(damageSkill) + mainWep.getDamage() + mainWep.getMaxAmmo() + totalBonus();
        }
        else if (mainWep.getAtkspd() == 5) {
            myDamage = 2.5 * player.getLevel(damageSkill) + (mainWep.getDamage() + mainWep.getMaxAmmo())*192.0/245.0 + totalBonus();
        }
        else if (mainWep.getAtkspd() == 6) {
            myDamage = 2.5 * player.getLevel(damageSkill) + (mainWep.getDamage() + mainWep.getMaxAmmo())*96.0/149.0 + totalBonus();
        }
        else {
            System.out.println("What the heck kind of weapon do you have?");
            throw new RuntimeException("Error: Weapon has invalid attack speed. Must be 4, 5, or 6");
        }
        if (offWep.getAtkspd() == 4) {
            myDamage += 1.25 * player.getLevel(damageSkill) + offWep.getDamage() + offWep.getMaxAmmo() + totalBonus()*.5;
        }
        else if (offWep.getAtkspd() == 5) {
            myDamage += 1.25 * player.getLevel(damageSkill) + (offWep.getDamage() + offWep.getMaxAmmo())*192.0/245.0 + totalBonus()*.5;
        }
        else if (offWep.getAtkspd() == 6) {
            myDamage += 1.25 * player.getLevel(damageSkill) + (offWep.getDamage() + offWep.getMaxAmmo())*96.0/149.0 + totalBonus()*.5;
        }
        if (mainWep.getSlot().equals("Two-handed")) {
            myDamage += 1.25 * player.getLevel(damageSkill) + totalBonus()*0.5;
        }
        double myArmour = (0.0008 * Math.pow(player.getLevel("Defence"), 3) + 4 * player.getLevel("Defence") + 40) + totalArmour();
        double myAccuracy = (0.0008 * Math.pow(player.getLevel(accuracySkill), 3) + 4 * player.getLevel(accuracySkill) + 40) + mainWep.getAccuracy();
        return new CombatStats(myAccuracy, myArmour, myDamage, totalReduc() + player.getLevel("Defence")/1000.0);
    }

    public boolean checkValid() {
        int hands = 0;
        if (mainWep.getSlot().equals("Two-handed")) {
            hands+=2;
        }
        else {
            hands++;
        }
        if (!offWep.equals(Weapon.getWeaponByName("None"))) {
            hands++;
        }
        if (!shield.equals(Armour.getArmourByName("None"))) {
            hands++;
        }
        return hands<3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Loadout)) {
            return false;
        }
        Loadout loadout = (Loadout) obj;
        return mainWep.equals(loadout.getMainWep()) && head.equals(loadout.getHead()) && torso.equals(loadout.getTorso()) && legs.equals(loadout.getLegs())
            && hands.equals(loadout.getHands()) && feet.equals(loadout.getFeet()) && cape.equals(loadout.getCape()) && neck.equals(loadout.getNeck())
            && ring.equals(loadout.getRing()) && familiar.equals(loadout.getFamiliar()) && prayer.equals(loadout.getPrayer());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + mainWep.hashCode();
        result = 31*result + head.hashCode();
        result = 31*result + torso.hashCode();
        result = 31*result + legs.hashCode();
        result = 31*result + hands.hashCode();
        result = 31*result + feet.hashCode();
        result = 31*result + cape.hashCode();
        result = 31*result + neck.hashCode();
        result = 31*result + ring.hashCode();
        result = 31*result + familiar.hashCode();
        result = 31*result + prayer.hashCode();
        return result;
    }
}