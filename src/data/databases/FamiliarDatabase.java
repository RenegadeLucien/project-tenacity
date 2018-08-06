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
        familiars.add(new Familiar("Pack mammoth", 46500, 1296, 90, 90, 80, 90, 32, 99));
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
