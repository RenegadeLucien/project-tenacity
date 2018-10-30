package data.dataobjects;

import data.databases.FamiliarDatabase;

public class Familiar {

    private String name;
    private int lp;
    private int maxhit;
    private int attack;
    private int defence;
    private int ranged;
    private int magic;
    private int invenSpaces;
    private int summonReq;

    public Familiar(String name, int lp, int maxhit, int attack, int defence, int ranged, int magic, int invenSpaces, int summonReq) {
        this.name = name;
        this.lp = lp;
        this.maxhit = maxhit;
        this.attack = attack;
        this.defence = defence;
        this.ranged = ranged;
        this.magic = magic;
        this.invenSpaces = invenSpaces;
        this.summonReq = summonReq;
    }

    public int getInvenSpaces() {
        return invenSpaces;
    }

    public int getSummonReq() { return summonReq; }

    public String getName() { return name; }

    public static Familiar getFamiliarByName(String name) {
        for (Familiar f : FamiliarDatabase.getFamiliarDatabase().getFamiliars()) {
            if (name.equals(f.getName()))
                return f;
        }
        return null;
    }
}
