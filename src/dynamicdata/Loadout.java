package dynamicdata;

import staticdata.Armour;
import staticdata.Food;
import staticdata.Weapon;

public class Loadout {

    private Weapon mainWep;
    private Food foodUsed;
    private Armour head;
    private Armour torso;
    private Armour legs;
    private Armour hands;
    private Armour feet;


    public Loadout(Weapon mainWep, Food foodUsed, Armour head, Armour torso, Armour legs, Armour hands, Armour feet) {
        this.mainWep = mainWep;
        this.foodUsed = foodUsed;
        this.head = head;
        this.torso = torso;
        this.legs = legs;
        this.hands = hands;
        this.feet = feet;
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

    public int totalArmour() {
        return head.getArmour() + torso.getArmour() + legs.getArmour() + hands.getArmour() + feet.getArmour();
    }

    public double totalReduc() {
        return head.getReduc() + torso.getReduc() + legs.getReduc() + hands.getReduc() + feet.getReduc();
    }
}