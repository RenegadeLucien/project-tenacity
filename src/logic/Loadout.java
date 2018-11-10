package logic;

import data.dataobjects.*;

public class Loadout {

    private Weapon mainWep;
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


    public Loadout(Weapon mainWep, Armour head, Armour torso, Armour legs, Armour hands, Armour feet, Armour cape, Armour neck, Armour ring, Familiar familiar, Prayer prayer) {
        this.mainWep = mainWep;
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