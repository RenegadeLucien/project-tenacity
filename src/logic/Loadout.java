package logic;

import data.dataobjects.*;

public class Loadout {

    private Weapon mainWep;
    private Food foodUsed;
    private Armour head;
    private Armour torso;
    private Armour legs;
    private Armour hands;
    private Armour feet;
    private Armour cape;
    private Armour neck;
    private Armour ring;
    private Ammo ammo;
    private Familiar familiar;
    private Prayer prayer;


    public Loadout(Weapon mainWep, Food foodUsed, Armour head, Armour torso, Armour legs, Armour hands, Armour feet, Armour cape, Armour neck, Armour ring, Ammo ammo, Familiar familiar, Prayer prayer) {
        this.mainWep = mainWep;
        this.foodUsed = foodUsed;
        this.head = head;
        this.torso = torso;
        this.legs = legs;
        this.hands = hands;
        this.feet = feet;
        this.cape = cape;
        this.neck = neck;
        this.ring = ring;
        this.ammo = ammo;
        this.familiar = familiar;
        this.prayer = prayer;
    }

    public Weapon getMainWep() {
        return mainWep;
    }

    public Food getFoodUsed() {
        return foodUsed;
    }

    public Ammo getAmmo() {
        return ammo;
    }

    public Familiar getFamiliar() {
        return familiar;
    }

    public Prayer getPrayer() {
        return prayer;
    }

    public int totalArmour() {
        return head.getArmour() + torso.getArmour() + legs.getArmour() + hands.getArmour() + feet.getArmour() + cape.getArmour() + neck.getArmour() + ring.getArmour();
    }

    public double totalReduc() {
        return head.getReduc() + torso.getReduc() + legs.getReduc() + hands.getReduc() + feet.getReduc() + cape.getReduc() + neck.getReduc() + ring.getReduc();
    }

    public int totalBonus() {
        return head.getBonus() + torso.getBonus() + legs.getBonus() + hands.getBonus() + feet.getBonus() + cape.getBonus() + neck.getBonus() + ring.getBonus();
    }

    public int totalLp() {
        return head.getLp() + torso.getLp() + legs.getLp() + hands.getLp() + feet.getLp() + cape.getLp() + neck.getLp() + ring.getLp();
    }

    public int totalPrayBonus() {
        return head.getPray() + torso.getPray() + legs.getPray() + hands.getPray() + feet.getPray() + cape.getPray() + neck.getPray() + ring.getPray();
    }
}