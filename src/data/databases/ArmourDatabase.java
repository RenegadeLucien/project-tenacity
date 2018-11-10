package data.databases;

import data.dataobjects.Armour;
import logic.Requirement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArmourDatabase {

    private static ArmourDatabase armourDatabase;

    private List<Armour> armours = new ArrayList<>();

    private ArmourDatabase() {addArmours();}

    private void addArmours() {

        //Placeholder, if you don't have a certain piece of armour
        armours.add(new Armour("None", "None", "None", 0, 0, 0, 0, 0, new ArrayList<>()));

        //Melee head
        armours.add(new Armour("Bronze full helm", "Melee", "Head", 30, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Spiny helmet", "Melee", "Head", 40, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 5))));
        armours.add(new Armour("Steel full helm", "Melee", "Head", 63, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Black full helm", "Melee", "Head", 76, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Mithril full helm", "Melee", "Head", 90, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Adamant full helm", "Melee", "Head", 125, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Elite black full helm", "Melee", "Head", 107, 0, 0, 0, 9, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Berserker helm", "Melee", "Head", 125, 0, 0, 0, 11, Arrays.asList(new Requirement("Defence", 45), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Warrior helm", "Melee", "Head", 146, 0, 0, 0.009, 0, Arrays.asList(new Requirement("Defence", 45), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Rune full helm", "Melee", "Head", 170, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Rock-shell helm", "Melee", "Head", 146, 0, 0, 0, 12, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Granite helm", "Melee", "Head", 196, 0, 0, 0.011, 0, Arrays.asList(new Requirement("Strength", 55), new Requirement("Defence", 55))));
        armours.add(new Armour("Helm of neitiznot", "Melee", "Head", 196, 0, 0, 0.011, 0, Arrays.asList(new Requirement("Defence", 55), new Requirement("Crafting", 46),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 56), new Requirement("Construction", 20), new Requirement("Agility", 40))));
        armours.add(new Armour("Dragon helm", "Melee", "Head", 214, 0, 0, 0.0116, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Dragon full helm", "Melee", "Head", 226, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Third-age full helmet", "Melee", "Head", 259, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Bandos helmet", "Melee", "Head", 259, 0, 1, 0, 17, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Dharok's helm", "Melee", "Head", 297, 0, 0, 0.014, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Statius's full helm", "Melee", "Head", 384, 0, 0, 0, 20, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Torva full helm", "Melee", "Head", 338, 110, 2, 0, 20, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Second-Age full helm", "Melee", "Head", 384, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Linza's helmet", "Melee", "Head", 384, 0, 0, 0.016, 0, Arrays.asList(new Requirement("Defence", 80), new Requirement("Herblore", 60),
            new Requirement("Agility", 60), new Requirement("Crafting", 60), new Requirement("Smithing", 60))));
        armours.add(new Armour("Tetsu helm", "Melee", "Head", 414, 280, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Malevolent helm", "Melee", "Head", 435, 0, 2, 0, 23, Collections.singletonList(new Requirement("Defence", 90))));

        //Ranged head
        armours.add(new Armour("Leather cowl", "Ranged", "Head", 30, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather cowl", "Ranged", "Head", 40, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Studded leather coif", "Ranged", "Head", 63, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Carapace helm", "Ranged", "Head", 90, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Green dragonhide coif", "Ranged", "Head", 125, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Robin Hood hat", "Ranged", "Head", 107, 0, 0, 0, 9, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Archer helm", "Ranged", "Head", 125, 0, 0, 0, 11, Arrays.asList(new Requirement("Defence", 45), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Blue dragonhide coif", "Ranged", "Head", 170, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Spined helm", "Ranged", "Head", 146, 0, 0, 0, 12, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Red dragonhide coif", "Ranged", "Head", 196, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Black dragonhide coif", "Ranged", "Head", 226, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Demon slayer circlet", "Ranged", "Head", 196, 0, 0, 0, 14, Arrays.asList(new Requirement("Defence", 60), new Requirement("Ranged", 60))));
        armours.add(new Armour("Royal dragonhide coif", "Ranged", "Head", 259, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Armadyl helmet", "Ranged", "Head", 259, 0, 1, 0, 17, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Karil's coif", "Ranged", "Head", 297, 0, 0, 0.014, 0, Arrays.asList(new Requirement("Defence", 70), new Requirement("Ranged", 70))));
        armours.add(new Armour("Morrigan's coif", "Ranged", "Head", 384, 0, 0, 0, 20, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Pernix cowl", "Ranged", "Head", 338, 110, 2, 0, 20, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Second-Age range coif", "Ranged", "Head", 384, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Death Lotus hood", "Ranged", "Head", 414, 280, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Sirenic mask", "Ranged", "Head", 435, 0, 2, 0, 23, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elite sirenic mask", "Ranged", "Head", 457, 0, 2, 0, 24, Collections.singletonList(new Requirement("Defence", 92))));

        //Magic head
        armours.add(new Armour("Black wizard hat", "Magic", "Head", 30, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide hood", "Magic", "Head", 40, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Spider silk hood", "Magic", "Head", 63, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Combat hood 0", "Magic", "Head", 63, 0, 0, 0, 4, Arrays.asList(new Requirement("Defence", 20), new Requirement("Magic", 10))));
        armours.add(new Armour("Fungal visor", "Magic", "Head", 78, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Batwing hood", "Magic", "Head", 90, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Druidic mage hood 0", "Magic", "Head", 117, 0, 0, 0, 10, Collections.singletonList(new Requirement("Defence", 35))));
        armours.add(new Armour("Splitbark helm", "Magic", "Head", 125, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Enchanted hat", "Magic", "Head", 146, 0, 0, 0.009, 0, Collections.singletonList(new Requirement("Defence", 45))));
        armours.add(new Armour("Farseer helm", "Magic", "Head", 125, 0, 0, 0, 11, Arrays.asList(new Requirement("Defence", 45), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Mystic hat (blue)", "Magic", "Head", 170, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Battle hood 0", "Magic", "Head", 170, 0, 0, 0, 12, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Infinity hat", "Magic", "Head", 196, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Grifolic visor", "Magic", "Head", 226, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Third-age mage hat", "Magic", "Head", 259, 0, 0, 0.013, 0, Arrays.asList(new Requirement("Defence", 65), new Requirement("Magic", 65))));
        armours.add(new Armour("Ahrim's hood", "Magic", "Head", 297, 0, 0, 0.014, 0, Arrays.asList(new Requirement("Defence", 70), new Requirement("Magic", 70))));
        armours.add(new Armour("Hood of subjugation", "Magic", "Head", 259, 0, 1, 0, 17, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Ganodermic visor", "Magic", "Head", 338, 0, 0, 0.015, 0, Collections.singletonList(new Requirement("Defence", 75))));
        armours.add(new Armour("Zuriel's hood", "Magic", "Head", 384, 0, 0, 0, 20, Arrays.asList(new Requirement("Defence", 78), new Requirement("Magic", 78))));
        armours.add(new Armour("Anima Core helm of Seren", "Magic", "Head", 338, 0, 0, 0, 20, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Second-Age mage mask", "Magic", "Head", 384, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Virtus mask", "Magic", "Head", 338, 110, 2, 0, 20, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Seasinger's hood", "Magic", "Head", 414, 280, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Tectonic mask", "Magic", "Head", 435, 0, 2, 0, 23, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elite tectonic mask", "Magic", "Head", 457, 0, 2, 0, 24, Collections.singletonList(new Requirement("Defence", 92))));

        //Melee torso
        armours.add(new Armour("Bronze platebody", "Melee", "Torso", 34, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Iron platebody", "Melee", "Torso", 46, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Yak-hide armour (top)", "Melee", "Torso", 87, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Mithril platebody", "Melee", "Torso", 104, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Adamant platebody", "Melee", "Torso", 144, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Elite black platebody", "Melee", "Torso", 123, 0, 0, 0, 14, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Rune platebody", "Melee", "Torso", 195, 0, 0, 0.001, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Rock-shell plate", "Melee", "Torso", 160, 0, 0, 0, 18, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Granite body", "Melee", "Torso", 226, 0, 0, 0.0011, 0, Arrays.asList(new Requirement("Defence", 55), new Requirement("Strength", 55))));
        armours.add(new Armour("Gud raider chainbody", "Melee", "Torso", 195, 0, 0, 0, 20, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Dragon platebody", "Melee", "Torso", 260, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Third-age platebody", "Melee", "Torso", 298, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Bandos chestplate", "Melee", "Torso", 298, 0, 2, 0, 26, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Verac's brassard", "Melee", "Torso", 341, 0, 2, 0.014, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Statius's platebody", "Melee", "Torso", 442, 0, 0, 0, 30, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Torva platebody", "Melee", "Torso", 389, 220, 3, 0, 30, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Linza's cuirass", "Melee", "Torso", 442, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Tetsu body", "Melee", "Torso", 477, 560, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Malevolent cuirass", "Melee", "Torso", 500, 0, 3, 0, 34, Collections.singletonList(new Requirement("Defence", 90))));

        //Ranged torso

        //Magic torso

        //Melee legs

        //Ranged legs

        //Magic legs

        //Melee hands
        armours.add(new Armour("Safety gloves", "Melee", "Hands", 7, 0, 0, 0.0008, 0, new ArrayList<>()));

        //Ranged hands
        armours.add(new Armour("Leather gloves", "Ranged", "Hands", 5, 0, 0, 0.0002, 0, new ArrayList<>()));

        //Magic hands

        //Melee feet

        //Ranged feet

        //Magic feet

        //Melee shield

        //Ranged shield

        //Magic shield

        //Neck

        //Ring

        //Cape


        /*
        armours.add(new Armour("Leather body", "Ranged", "Torso", 34, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather body", "Ranged", "Torso", 46, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Wizard robe top", "Magic", "Torso", 25, 0, 0, 0.0002, 0, new ArrayList<>()));
        armours.add(new Armour("Bronze platelegs", "Melee", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Bronze plateskirt", "Melee", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Iron platelegs", "Melee", "Legs", 44, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Iron plateskirt", "Melee", "Legs", 44, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Leather chaps", "Ranged", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather chaps", "Ranged", "Legs", 44, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Wizard robe skirt", "Magic", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Bronze sq shield", "Melee", "Shield", 26, 0, 0, 0.003, 0, new ArrayList<>()));
        armours.add(new Armour("Iron sq shield", "Melee", "Shield", 36, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Leather shield", "Ranged", "Shield", 30, 0, 0, 0.005, 0, new ArrayList<>()));
        armours.add(new Armour("Shieldbow", "Ranged", "Shield", 30, 0, 0, 0.005, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather shield", "Ranged", "Shield", 40, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Wizard shield", "Magic", "Shield", 30, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Leather vambraces", "Ranged", "Hands", 5, 0, 0, 0.0002, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather gloves", "Ranged", "Hands", 10, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Wizard gloves", "Magic", "Hands", 7, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide gloves", "Magic", "Hands", 10, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Leather boots", "Ranged", "Feet", 5, 0, 0, 0.0002, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather boots", "Ranged", "Feet", 7, 0, 0, 0.001, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Wizard boots", "Magic", "Feet", 7, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide boots", "Magic", "Feet", 10, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Elite sirenic mask", "Ranged", "Head", 457, 0, 2, 0, 24, Collections.singletonList(new Requirement("Defence", 92))));
        armours.add(new Armour("Amulet of souls (or)", "All", "Neck", 0, 0, 5, 0, 48, new ArrayList<>()));
        armours.add(new Armour("Superior leviathan ring", "All", "Ring", 43, 0, 0, 0, 15, Collections.singletonList(new Requirement("Defence", 85))));*/
    }

    public static ArmourDatabase getArmourDatabase() {
        if (armourDatabase == null) {
            armourDatabase = new ArmourDatabase();
        }
        return armourDatabase;
    }


    public List<Armour> getArmours() {
        return armours;
    }
}