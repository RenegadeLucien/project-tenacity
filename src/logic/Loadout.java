package logic;

import data.dataobjects.Ammo;
import data.dataobjects.Armour;
import data.dataobjects.Food;
import data.dataobjects.Weapon;

public class Loadout {

    private Weapon mainWep;
    private Food foodUsed;
    private Armour head;
    private Armour torso;
    private Armour legs;
    private Armour hands;
    private Armour feet;
    private Ammo ammo;


    public Loadout(Weapon mainWep, Food foodUsed, Armour head, Armour torso, Armour legs, Armour hands, Armour feet, Ammo ammo) {
        this.mainWep = mainWep;
        this.foodUsed = foodUsed;
        this.head = head;
        this.torso = torso;
        this.legs = legs;
        this.hands = hands;
        this.feet = feet;
        this.ammo = ammo;
    }

    public Weapon getMainWep() {
        return mainWep;
    }

    public Food getFoodUsed() {
        return foodUsed;
    }

    public Armour getHead() {
        return head;
    }

    public Armour getTorso() {
        return torso;
    }

    public Armour getLegs() {
        return legs;
    }

    public Armour getHands() {
        return hands;
    }

    public Armour getFeet() {
        return feet;
    }

    public Ammo getAmmo() {
        return ammo;
    }

    public int totalArmour() {
        return head.getArmour() + torso.getArmour() + legs.getArmour() + hands.getArmour() + feet.getArmour();
    }

    public double totalReduc() {
        return head.getReduc() + torso.getReduc() + legs.getReduc() + hands.getReduc() + feet.getReduc();
    }

    public int totalLp() {
        return head.getLp() + torso.getLp() + legs.getLp() + hands.getLp() + feet.getLp();
    }
}