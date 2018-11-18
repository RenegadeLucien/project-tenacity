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

        //Melee two-hand (done)
        weapons.add(new Weapon("Bronze 2h sword", "Melee", "Slash", "Two-handed", 111, 150, 6, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Iron halberd", "Melee", "Slash", "Two-handed", 223, 202, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Gadderhammer", "Melee", "Crush", "Two-handed", 223, 202, 6, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bone spear", "Melee", "Stab", "Two-handed", 335, 257, 6, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Steel spear", "Melee", "Stab", "Two-handed", 447, 316, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel halberd", "Melee", "Slash", "Two-handed", 447, 316, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Black spear", "Melee", "Stab", "Two-handed", 558, 381, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Black halberd", "Melee", "Slash", "Two-handed", 558, 381, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Mithril spear", "Melee", "Stab", "Two-handed", 670, 454, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril 2h sword", "Melee", "Slash", "Two-handed", 670, 454, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Adamant spear", "Melee", "Stab", "Two-handed", 894, 628, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant 2h sword", "Melee", "Slash", "Two-handed", 894, 628, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Rune spear", "Melee", "Stab", "Two-handed", 1117, 850, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune 2h sword", "Melee", "Slash", "Two-handed", 1117, 850, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Granite maul", "Melee", "Crush", "Two-handed", 1229, 983, 6, 0, 0, Arrays.asList(new Requirement("Attack", 55), new Requirement("Strength", 55))));
        weapons.add(new Weapon("Dragon spear", "Melee", "Stab", "Two-handed", 1341, 1132, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 60))));
        weapons.add(new Weapon("Dragon 2h sword", "Melee", "Slash", "Two-handed", 1341, 1132, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 60))));
        weapons.add(new Weapon("Tzhaar-ket-om", "Melee", "Crush", "Two-handed", 1341, 1132, 6, 0, 0, Collections.singletonList(new Requirement("Strength", 60))));
        weapons.add(new Weapon("Guthan's warspear", "Melee", "Stab", "Two-handed", 1564, 1486, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 70))));
        weapons.add(new Weapon("Dharok's greataxe", "Melee", "Slash", "Two-handed", 1564, 1486, 6, 0, 0, Arrays.asList(new Requirement("Attack", 70), new Requirement("Strength", 70))));
        weapons.add(new Weapon("Crystal halberd", "Melee", "Slash", "Two-handed", 1564, 1486, 6, 0, 0, Arrays.asList(new Requirement("Attack", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10), new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Verac's flail", "Melee", "Crush", "Two-handed", 1564, 1486, 6, 0, 2, Collections.singletonList(new Requirement("Attack", 70))));
        weapons.add(new Weapon("Zamorakian spear", "Melee", "Stab", "Two-handed", 1676, 1694, 6, 0, 2, Collections.singletonList(new Requirement("Attack", 75))));
        weapons.add(new Weapon("Bandos godsword", "Melee", "Slash", "Two-handed", 1676, 1694, 6, 0, 4, Collections.singletonList(new Requirement("Attack", 75))));
        weapons.add(new Weapon("Saradomin sword", "Melee", "Crush", "Two-handed", 1378, 1694, 5, 0, 2, Collections.singletonList(new Requirement("Attack", 75))));
        weapons.add(new Weapon("Vesta's spear", "Melee", "Stab", "Two-handed", 1743, 1829, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 78))));
        weapons.add(new Weapon("Masuta's warspear", "Melee", "Stab", "Two-handed", 1832, 2023, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 82))));
        weapons.add(new Weapon("Mizuyari", "Melee", "Stab", "Two-handed", 1899, 2178, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 85))));
        weapons.add(new Weapon("Dragon Rider lance", "Melee", "Slash", "Two-handed", 1788, 2458, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 85))));
        weapons.add(new Weapon("Annihilation", "Melee", "Crush", "Two-handed", 1944, 2287, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 87))));
        weapons.add(new Weapon("Noxious scythe", "Melee", "Slash", "Two-handed", 2011, 2458, 6, 0, 0, Collections.singletonList(new Requirement("Attack", 90))));
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

        //Magic two-hand (done)
        weapons.add(new Weapon("Staff", "Magic", "Magic", "Two-handed", 0, 150, 6, 112, 0, new ArrayList<>()));
        weapons.add(new Weapon("White magic staff", "Magic", "Magic", "Two-handed", 0, 381, 6, 559, 0, Arrays.asList(new Requirement("Magic", 25), new Requirement("Herblore", 3),
            new Requirement("Agility", 13), new Requirement("Mining", 17), new Requirement("Thieving", 13))));
        weapons.add(new Weapon("Air battlestaff", "Magic", "Magic", "Two-handed", 0, 454, 6, 671, 0, Collections.singletonList(new Requirement("Magic", 30))));
        weapons.add(new Weapon("Mystic air staff", "Magic", "Magic", "Two-handed", 0, 628, 6, 894, 0, Collections.singletonList(new Requirement("Magic", 40))));
        weapons.add(new Weapon("Slayer's staff", "Magic", "Magic", "Two-handed", 0, 850, 6, 1118, 0, Arrays.asList(new Requirement("Magic", 50), new Requirement("Slayer", 55))));
        weapons.add(new Weapon("Toktz-mej-tal", "Magic", "Magic", "Two-handed", 0, 1132, 6, 1341, 2, Collections.singletonList(new Requirement("Magic", 60))));
        weapons.add(new Weapon("Ahrim's staff", "Magic", "Magic", "Two-handed", 0, 1486, 6, 1565, 0, Collections.singletonList(new Requirement("Magic", 70))));
        weapons.add(new Weapon("Crystal staff", "Magic", "Magic", "Two-handed", 0, 1486, 6, 1565, 0, Arrays.asList(new Requirement("Magic", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10), new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Staff of light", "Magic", "Magic", "Two-handed", 0, 1694, 6, 1676, 0, Collections.singletonList(new Requirement("Magic", 75))));
        weapons.add(new Weapon("Armadyl battlestaff", "Magic", "Magic", "Two-handed", 0, 1783, 6, 1721, 0, Collections.singletonList(new Requirement("Magic", 77))));
        weapons.add(new Weapon("Zuriel's staff", "Magic", "Magic", "Two-handed", 0, 1829, 6, 1743, 0, Collections.singletonList(new Requirement("Magic", 78))));
        weapons.add(new Weapon("Second-Age staff", "Magic", "Magic", "Two-handed", 0, 1924, 6, 1788, 0, Collections.singletonList(new Requirement("Magic", 80))));
        weapons.add(new Weapon("Camel staff", "Magic", "Magic", "Two-handed", 0, 2178, 6, 1900, 0, Collections.singletonList(new Requirement("Magic", 85))));
        weapons.add(new Weapon("Obliteration", "Magic", "Magic", "Two-handed", 0, 2287, 6, 1944, 0, Collections.singletonList(new Requirement("Magic", 87))));
        weapons.add(new Weapon("Noxious staff", "Magic", "Magic", "Two-handed", 0, 2458, 6, 2012, 0, Collections.singletonList(new Requirement("Magic", 90))));
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
