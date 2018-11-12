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
        weapons.add(new Weapon("Dwarven army axe", "Melee", "Slash", "Mainhand", 183, 160, 5, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Excalibur", "Melee", "Slash", "Mainhand", 367, 454, 5, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));

        //Melee off-hand

        //Melee two-hand
        weapons.add(new Weapon("Bronze 2h sword", "Melee", "Slash", "Two-handed", 111, 150, 6, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Rune halberd", "Melee", "Slash", "Two-handed", 850, 1117, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Zaros godsword", "Melee", "Slash", "Two-handed", 2056, 2577, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 92))));

        //Ranged main-hand

        //Ranged off-hand

        //Ranged two-hand
        weapons.add(new Weapon("Chargebow", "Ranged", "Arrows", "Two-handed", 91, 150, 5, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Seren godbow", "Ranged", "Arrows", "Two-handed", 2056, 2577, 6, 0, 0, Collections.singletonList(new Requirement("Ranged", 92))));

        //Magic main-hand (done)
        weapons.add(new Weapon("Wizard wand", "Magic", "Magic", "Mainhand", 0, 150, 4, 48, 0, new ArrayList<>()));
        weapons.add(new Weapon("Imp horn wand", "Magic", "Magic", "Mainhand", 0, 202, 4, 96, 0, Collections.singletonList(new Requirement("Magic", 10))));
        weapons.add(new Weapon("Spider wand", "Magic", "Magic", "Mainhand", 0, 316, 4, 192, 0, Collections.singletonList(new Requirement("Magic", 20))));
        weapons.add(new Weapon("Batwing wand", "Magic", "Magic", "Mainhand", 0, 454, 4, 288, 0, Collections.singletonList(new Requirement("Magic", 30))));
        weapons.add(new Weapon("Splitbark wand", "Magic", "Magic", "Mainhand", 0, 628, 4, 384, 0, Collections.singletonList(new Requirement("Magic", 40))));
        weapons.add(new Weapon("Beginner wand", "Magic", "Magic", "Mainhand", 0, 732, 4, 432, 0, Collections.singletonList(new Requirement("Magic", 45))));
        weapons.add(new Weapon("Mystic wand", "Magic", "Magic", "Mainhand", 0, 850, 4, 480, 0, Collections.singletonList(new Requirement("Magic", 50))));
        weapons.add(new Weapon("Teacher wand", "Magic", "Magic", "Mainhand", 0, 983, 4, 528, 0, Collections.singletonList(new Requirement("Magic", 55))));
        weapons.add(new Weapon("Grifolic wand", "Magic", "Magic", "Mainhand", 0, 1132, 4, 576, 0, Collections.singletonList(new Requirement("Magic", 60))));
        weapons.add(new Weapon("Wand of treachery", "Magic", "Magic", "Mainhand", 0, 1486, 4, 672, 0, Collections.singletonList(new Requirement("Magic", 70))));
        weapons.add(new Weapon("Abyssal wand", "Magic", "Magic", "Mainhand", 0, 1694, 4, 720, 0, Collections.singletonList(new Requirement("Magic", 75))));
        weapons.add(new Weapon("Virtus wand", "Magic", "Magic", "Mainhand", 0, 1924, 4, 768, 2, Collections.singletonList(new Requirement("Magic", 80))));
        weapons.add(new Weapon("Wand of the Cywir elders", "Magic", "Magic", "Mainhand", 0, 2458, 4, 768, 0, Collections.singletonList(new Requirement("Magic", 85))));
        weapons.add(new Weapon("Seismic wand", "Magic", "Magic", "Mainhand", 0, 2458, 4, 864, 0, Collections.singletonList(new Requirement("Magic", 90))));
        weapons.add(new Weapon("Wand of the praesul", "Magic", "Magic", "Mainhand", 0, 2577, 4, 883, 0, Collections.singletonList(new Requirement("Magic", 92))));

        //Magic off-hand

        //Magic two-hand
        weapons.add(new Weapon("Staff", "Magic", "Magic", "Two-handed", 0, 150, 6, 111, 0, new ArrayList<>()));
        weapons.add(new Weapon("Staff of Sliske", "Magic", "Magic", "Two-handed", 0, 2577, 6, 2056, 0, Collections.singletonList(new Requirement("Magic", 92))));
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
