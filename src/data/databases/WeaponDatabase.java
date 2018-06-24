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
        /*weapons.add(new Weapon("Bronze sword", "Melee", "Stab", "Mainhand", 61, 150, 5, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze battleaxe", "Melee", "Slash", "Mainhand", 74, 150, 6, 0, new ArrayList<>()));
        weapons.add(new Weapon("Iron battleaxe", "Melee", "Slash", "Mainhand", 149, 202, 6, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Excalibur", "Melee", "Slash", "Mainhand", 367, 454, 5, 0, Arrays.asList(new Requirement("Attack", 30), new Requirement("Merlin's Crystal", 1))));
        weapons.add(new Weapon("Bronze 2h sword", "Melee", "Slash", "Two-handed", 111, 150, 6, 0, new ArrayList<>()));
        weapons.add(new Weapon("Iron 2h sword", "Melee", "Slash", "Two-handed", 223, 202, 6, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Shieldbow", "Ranged", "Arrows", "Mainhand", 26, 150, 6, 48, new ArrayList<>()));
        weapons.add(new Weapon("Shortbow", "Ranged", "Arrows", "Two-handed", 43, 150, 5, 48, new ArrayList<>()));
        weapons.add(new Weapon("Chargebow", "Ranged", "Arrows", "Two-handed", 91, 150, 5, 0, new ArrayList<>()));
        weapons.add(new Weapon("Staff", "Magic", "Magic", "Two-handed", 0, 150, 6, 111, new ArrayList<>()));
        weapons.add(new Weapon("Magic staff", "Magic", "Magic", "Two-handed", 0, 150, 6, 111, new ArrayList<>()));
        weapons.add(new Weapon("Tower mindspike", "Magic", "Magic","Two-handed", 0, 160, 6, 134, new ArrayList<>()));*/

        //to resolve most battles, further combat tweaking will be done later
        weapons.add(new Weapon("Zaros godsword", "Melee", "Slash", "Two-handed", 2056, 2577, 6, 0, Collections.singletonList(new Requirement("Attack", 92))));
        weapons.add(new Weapon("Seren godbow", "Ranged", "Arrows", "Two-handed", 2056, 2577, 6, 0, Collections.singletonList(new Requirement("Ranged", 92))));
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
