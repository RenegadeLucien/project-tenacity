package data.databases;

import data.dataobjects.Weapon;
import logic.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeaponDatabase {

    private static WeaponDatabase weaponDatabase;

    private List<Weapon> weapons = new ArrayList<>();

    private WeaponDatabase() {addWeapons();}

    private void addWeapons() {

        //Melee main-hand
        weapons.add(new Weapon("Dwarven army axe", "Melee", "Slash", "Mainhand", 183, 160, 5, 0, new ArrayList<>()));
        weapons.add(new Weapon("Excalibur", "Melee", "Slash", "Mainhand", 367, 454, 5, 0, Collections.singletonList(new Requirement("Attack", 30))));

        //Melee off-hand

        //Melee two-hand
        weapons.add(new Weapon("Bronze 2h sword", "Melee", "Slash", "Two-handed", 111, 150, 6, 0, new ArrayList<>()));
        weapons.add(new Weapon("Zaros godsword", "Melee", "Slash", "Two-handed", 2056, 2577, 6, 0, Collections.singletonList(new Requirement("Attack", 92))));

        //Ranged main-hand

        //Ranged off-hand

        //Ranged two-hand
        weapons.add(new Weapon("Chargebow", "Ranged", "Arrows", "Two-handed", 91, 150, 5, 0, new ArrayList<>()));
        weapons.add(new Weapon("Seren godbow", "Ranged", "Arrows", "Two-handed", 2056, 2577, 6, 0, Collections.singletonList(new Requirement("Ranged", 92))));

        //Magic main-hand

        //Magic off-hand

        //Magic two-hand
        weapons.add(new Weapon("Staff", "Magic", "Magic", "Two-handed", 0, 150, 6, 111, new ArrayList<>()));
        weapons.add(new Weapon("Staff of Sliske", "Magic", "Magic", "Two-handed", 0, 2577, 6, 2056, Collections.singletonList(new Requirement("Magic", 92))));
    }

    public static WeaponDatabase getWeaponDatabase() {
        if (weaponDatabase == null) {
            weaponDatabase = new WeaponDatabase();
        }
        return weaponDatabase;
    }


    public List<Weapon> getWeapons() {
        return weapons;
    }
}
