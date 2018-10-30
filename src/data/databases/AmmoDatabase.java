package data.databases;

import data.dataobjects.Ammo;
import logic.Requirement;

import java.util.*;

public class AmmoDatabase {

    private static AmmoDatabase ammoDatabase;

    private List<Ammo> ammos = new ArrayList<>();

    private AmmoDatabase() {addAmmos();}

    private void addAmmos() {
        ammos.add(new Ammo("None", "None", "None", 0, new HashMap<>(), new ArrayList<>()));

        ammos.add(new Ammo("Bronze arrow", "Ranged", "Arrows", 48, Map.of("Bronze arrow", 1), new ArrayList<>()));
        ammos.add(new Ammo("Bronze bolts", "Ranged", "Bolts", 48, Map.of("Bronze bolts", 1), new ArrayList<>()));
        ammos.add(new Ammo("Air Strike", "Magic", "Air", 153, Map.of("Air rune", 1), new ArrayList<>()));
       // ammos.add(new Ammo("Water Strike", "Magic", "Water", 211, Map.of("Water rune", 1, "Air rune", 1)));
       // ammos.add(new Ammo("Earth Strike", "Magic", "Earth", 268, Map.of("Earth rune", 1, "Air rune", 1)));
       // ammos.add(new Ammo("Fire Strike", "Magic", "Fire", 326, Map.of("Fire rune", 1, "Air rune", 1)));

        //to resolve most battles, further combat tweaking will be done later
        ammos.add(new Ammo("Air Surge", "Magic", "Air", 2056, Map.of("Air rune", 5), Collections.singletonList(new Requirement("Magic", 81))));
    }

    public static AmmoDatabase getAmmoDatabase() {
        if (ammoDatabase == null) {
            ammoDatabase = new AmmoDatabase();
        }
        return ammoDatabase;
    }

    public List<Ammo> getAmmos() {
        return ammos;
    }
}
