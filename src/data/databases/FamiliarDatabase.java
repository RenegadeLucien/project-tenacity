package data.databases;

import data.dataobjects.Familiar;

import java.util.ArrayList;
import java.util.List;

public class FamiliarDatabase {

    private static FamiliarDatabase familiarDatabase;

    private List<Familiar> familiars = new ArrayList<>();

    private FamiliarDatabase() {
        addFamiliars();
    }

    private void addFamiliars() {
        familiars.add(new Familiar("None", 0, 0));
        familiars.add(new Familiar("Thorny snail", 3, 13));
        familiars.add(new Familiar("Spirit kalphite", 6, 25));
        familiars.add(new Familiar("Bull ant", 9, 40));
        familiars.add(new Familiar("Spirit terrorbird", 12, 52));
        familiars.add(new Familiar("War tortoise", 18, 67));
        familiars.add(new Familiar("Pack yak", 30, 96));
        familiars.add(new Familiar("Pack mammoth", 32, 99));
    }

    public static FamiliarDatabase getFamiliarDatabase() {
        if (familiarDatabase == null) {
            familiarDatabase = new FamiliarDatabase();
        }
        return familiarDatabase;
    }

    public List<Familiar> getFamiliars() {
        return familiars;
    }
}
