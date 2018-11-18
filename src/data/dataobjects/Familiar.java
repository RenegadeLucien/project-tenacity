package data.dataobjects;

import data.databases.FamiliarDatabase;

public class Familiar {

    private String name;
    private int invenSpaces;
    private int summonReq;

    public Familiar(String name, int invenSpaces, int summonReq) {
        this.name = name;
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
