package data.databases;

import data.dataobjects.Armour;
import logic.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ArmourDatabase {

    private static ArmourDatabase armourDatabase;

    private List<Armour> armours = new ArrayList<>();
    private Map<String, Armour> namedArmours = new LinkedHashMap<>();

    private ArmourDatabase() {addArmours();}

    private void addArmours() {

        //Placeholder, if you don't have a certain piece of armour
        armours.add(new Armour("None", "None", "None", 0, 0, 0, 0, 0, new ArrayList<>()));

        //Melee head (done)
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
        armours.add(new Armour("Dragon helm", "Melee", "Head", 196, 0, 0, 0, 14, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Third-age full helmet", "Melee", "Head", 259, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Bandos helmet", "Melee", "Head", 259, 0, 1, 0, 17, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Dharok's helm", "Melee", "Head", 297, 0, 0, 0.014, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium full helm + 1", "Melee", "Head", 305, 40, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium full helm + 2", "Melee", "Head", 313, 60, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium full helm + 3", "Melee", "Head", 321, 80, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium full helm + 4", "Melee", "Head", 330, 100, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Statius's full helm", "Melee", "Head", 384, 0, 0, 0, 20, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Second-Age full helm", "Melee", "Head", 384, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Linza's helm", "Melee", "Head", 384, 0, 0, 0.016, 0, Arrays.asList(new Requirement("Defence", 80), new Requirement("Herblore", 60),
            new Requirement("Agility", 60), new Requirement("Crafting", 60), new Requirement("Smithing", 60))));
        armours.add(new Armour("Tetsu helm", "Melee", "Head", 414, 280, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Elder rune full helm", "Melee", "Head", 384, 220, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune full helm + 1", "Melee", "Head", 394, 240, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune full helm + 2", "Melee", "Head", 404, 260, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune full helm + 5", "Melee", "Head", 435, 320, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Malevolent helm", "Melee", "Head", 435, 0, 2, 0, 23, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Trimmed masterwork helm", "Melee", "Head", 457, 0, 2, 0, 24, Collections.singletonList(new Requirement("Defence", 92))));

        //Ranged head (done)
        armours.add(new Armour("Leather cowl", "Ranged", "Head", 30, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather cowl", "Ranged", "Head", 40, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Studded leather coif", "Ranged", "Head", 63, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Carapace helm", "Ranged", "Head", 90, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Green dragonhide coif", "Ranged", "Head", 125, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Robin Hood hat", "Ranged", "Head", 107, 0, 0, 0, 9, Collections.singletonList(new Requirement("Ranged", 40))));
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

        //All/hybrid head
        armours.add(new Armour("Mask of the Troll", "All", "Head", 40, 0, 0, 0, 0, new ArrayList<>()));

        //Magic head (done)
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

        //Melee torso (done)
        armours.add(new Armour("Bronze platebody", "Melee", "Torso", 34, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Iron platebody", "Melee", "Torso", 46, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Black chainbody", "Melee", "Torso", 81, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Yak-hide armour (top)", "Melee", "Torso", 87, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Mithril platebody", "Melee", "Torso", 104, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Adamant platebody", "Melee", "Torso", 144, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Elite black platebody", "Melee", "Torso", 123, 0, 0, 0, 14, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Rune platebody", "Melee", "Torso", 195, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Rock-shell plate", "Melee", "Torso", 168, 0, 0, 0, 18, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Granite body", "Melee", "Torso", 226, 0, 0, 0.011, 0, Arrays.asList(new Requirement("Defence", 55), new Requirement("Strength", 55))));
        armours.add(new Armour("Gud raider chainbody", "Melee", "Torso", 195, 0, 0, 0, 20, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Dragon chainbody", "Melee", "Torso", 226, 0, 0, 0, 22, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Third-age platebody", "Melee", "Torso", 298, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Bandos chestplate", "Melee", "Torso", 298, 0, 2, 0, 26, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium platebody", "Melee", "Torso", 341, 40, 0, 0.014, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium platebody + 1", "Melee", "Torso", 350, 80, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium platebody + 2", "Melee", "Torso", 360, 120, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium platebody + 4", "Melee", "Torso", 379, 200, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Statius's platebody", "Melee", "Torso", 442, 0, 0, 0, 30, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Linza's cuirass", "Melee", "Torso", 442, 0, 0, 0.016, 0, Arrays.asList(new Requirement("Defence", 80), new Requirement("Herblore", 60),
            new Requirement("Agility", 60), new Requirement("Crafting", 60), new Requirement("Smithing", 60))));
        armours.add(new Armour("Second-Age platebody", "Melee", "Torso", 442, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Bane platebody", "Melee", "Torso", 389, 240, 0, 0.015, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Tetsu body", "Melee", "Torso", 477, 560, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Elder rune platebody", "Melee", "Torso", 442, 440, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune platebody + 1", "Melee", "Torso", 453, 480, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune platebody + 2", "Melee", "Torso", 465, 520, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune platebody + 5", "Melee", "Torso", 500, 640, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Malevolent cuirass", "Melee", "Torso", 500, 0, 3, 0, 34, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Trimmed masterwork platebody", "Melee", "Torso", 526, 0, 3, 0, 36, Collections.singletonList(new Requirement("Defence", 92))));

        //Ranged torso (done)
        armours.add(new Armour("Leather body", "Ranged", "Torso", 34, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather body", "Ranged", "Torso", 46, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Studded body", "Ranged", "Torso", 72, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Frog-leather body", "Ranged", "Torso", 87, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Carapace torso", "Ranged", "Torso", 104, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Green dragonhide body", "Ranged", "Torso", 144, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Robin Hood tunic", "Ranged", "Torso", 123, 0, 0, 0, 14, Collections.singletonList(new Requirement("Ranged", 40))));
        armours.add(new Armour("Blue dragonhide body", "Ranged", "Torso", 195, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Spined body", "Ranged", "Torso", 168, 0, 0, 0, 18, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Red dragonhide body", "Ranged", "Torso", 226, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Black dragonhide body", "Ranged", "Torso", 260, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Demon slayer torso", "Ranged", "Torso", 226, 0, 0, 0, 22, Arrays.asList(new Requirement("Defence", 60), new Requirement("Ranged", 60))));
        armours.add(new Armour("Royal dragonhide body", "Ranged", "Torso", 298, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Armadyl chestplate", "Ranged", "Torso", 298, 0, 2, 0, 26, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Karil's top", "Ranged", "Torso", 341, 0, 0, 0.014, 0, Arrays.asList(new Requirement("Defence", 70), new Requirement("Ranged", 70))));
        armours.add(new Armour("Morrigan's leather body", "Ranged", "Torso", 442, 0, 0, 0, 30, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Pernix body", "Ranged", "Torso", 389, 220, 3, 0, 30, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Second-Age range top", "Ranged", "Torso", 442, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Death Lotus chestplate", "Ranged", "Torso", 477, 560, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Sirenic hauberk", "Ranged", "Torso", 500, 0, 3, 0, 34, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elite sirenic hauberk", "Ranged", "Torso", 526, 0, 3, 0, 36, Collections.singletonList(new Requirement("Defence", 92))));

        //Magic torso (done)
        armours.add(new Armour("Zamorak robe (top)", "Magic", "Torso", 34, 0, 3, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide robe top", "Magic", "Torso", 46, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Spider silk robe top", "Magic", "Torso", 72, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Combat robe top 0", "Magic", "Torso", 72, 0, 0, 0, 7, Arrays.asList(new Requirement("Defence", 10), new Requirement("Magic", 20))));
        armours.add(new Armour("Fungal poncho", "Magic", "Torso", 87, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Batwing torso", "Magic", "Torso", 104, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Druidic mage top 0", "Magic", "Torso", 123, 0, 0, 0, 12, Collections.singletonList(new Requirement("Defence", 35))));
        armours.add(new Armour("Splitbark body", "Magic", "Torso", 144, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Dagon'hai robe top", "Magic", "Torso", 123, 0, 2, 0, 14, Arrays.asList(new Requirement("Defence", 40), new Requirement("Magic", 40))));
        armours.add(new Armour("Enchanted top", "Magic", "Torso", 168, 0, 0, 0.009, 0, Collections.singletonList(new Requirement("Defence", 45))));
        armours.add(new Armour("Mystic robe top (blue)", "Magic", "Torso", 195, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Battle robe top 0", "Magic", "Torso", 195, 0, 0, 0, 18, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Infinity top", "Magic", "Torso", 226, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Grifolic poncho", "Magic", "Torso", 260, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Third-age robe top", "Magic", "Torso", 298, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Ahrim's robe top", "Magic", "Torso", 341, 0, 0, 0.014, 0, Arrays.asList(new Requirement("Defence", 70), new Requirement("Magic", 70))));
        armours.add(new Armour("Garb of subjugation", "Magic", "Torso", 298, 0, 2, 0, 26, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Ganodermic poncho", "Magic", "Torso", 389, 0, 0, 0.015, 0, Collections.singletonList(new Requirement("Defence", 75))));
        armours.add(new Armour("Zuriel's robe top", "Magic", "Torso", 442, 0, 0, 0, 30, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Virtus robe top", "Magic", "Torso", 389, 220, 3, 0, 30, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Second-Age robe top", "Magic", "Torso", 442, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Seasinger's robe top", "Magic", "Torso", 477, 560, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Tectonic robe top", "Magic", "Torso", 500, 0, 3, 0, 34, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elite tectonic robe top", "Magic", "Torso", 526, 0, 3, 0, 36, Collections.singletonList(new Requirement("Defence", 92))));

        //Melee legs (done)
        armours.add(new Armour("Bronze platelegs", "Melee", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Iron platelegs", "Melee", "Legs", 44, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Yak-hide armour (legs)", "Melee", "Legs", 83, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Mithril platelegs", "Melee", "Legs", 99, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Adamant platelegs", "Melee", "Legs", 138, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Elite black platelegs", "Melee", "Legs", 117, 0, 0, 0, 12, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Rune platelegs", "Melee", "Legs", 187, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Rock-shell legs", "Melee", "Legs", 161, 0, 0, 0, 15, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Granite legs", "Melee", "Legs", 216, 0, 0, 0.011, 0, Arrays.asList(new Requirement("Defence", 55), new Requirement("Strength", 55))));
        armours.add(new Armour("Dragon platelegs", "Melee", "Legs", 216, 0, 0, 0, 18, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Third-age platelegs", "Melee", "Legs", 285, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Bandos tassets", "Melee", "Legs", 285, 0, 1, 0, 22, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium platelegs", "Melee", "Legs", 326, 30, 0, 0.014, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium platelegs + 1", "Melee", "Legs", 335, 60, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium platelegs + 2", "Melee", "Legs", 344, 90, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium platelegs + 3", "Melee", "Legs", 353, 120, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium platelegs + 4", "Melee", "Legs", 363, 150, 0, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Statius's platelegs", "Melee", "Legs", 423, 0, 0, 0, 25, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Bane platelegs", "Melee", "Legs", 372, 180, 0, 0.015, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Second-Age platelegs", "Melee", "Legs", 423, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Tetsu platelegs", "Melee", "Legs", 456, 420, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Elder rune platelegs", "Melee", "Legs", 423, 330, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune platelegs + 1", "Melee", "Legs", 434, 360, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune platelegs + 2", "Melee", "Legs", 445, 390, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune platelegs + 5", "Melee", "Legs", 479, 480, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Malevolent greaves", "Melee", "Legs", 479, 0, 2, 0, 29, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Trimmed masterwork platelegs", "Melee", "Legs", 503, 0, 2, 0, 31, Collections.singletonList(new Requirement("Defence", 92))));

        //Ranged legs (done)
        armours.add(new Armour("Leather chaps", "Ranged", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather chaps", "Ranged", "Legs", 44, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Studded chaps", "Ranged", "Legs", 69, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Frog-leather chaps", "Ranged", "Legs", 83, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Carapace legs", "Ranged", "Legs", 99, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Green dragonhide chaps", "Ranged", "Legs", 138, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Robin Hood tights", "Ranged", "Legs", 117, 0, 0, 0, 12, Collections.singletonList(new Requirement("Ranged", 40))));
        armours.add(new Armour("Blue dragonhide chaps", "Ranged", "Legs", 187, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Spined chaps", "Ranged", "Legs", 161, 0, 0, 0, 15, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Red dragonhide chaps", "Ranged", "Legs", 216, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Black dragonhide chaps", "Ranged", "Legs", 249, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Demon slayer skirt", "Ranged", "Legs", 216, 0, 0, 0, 18, Arrays.asList(new Requirement("Defence", 60), new Requirement("Ranged", 60))));
        armours.add(new Armour("Royal dragonhide chaps", "Ranged", "Legs", 285, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Armadyl chainskirt", "Ranged", "Legs", 285, 0, 1, 0, 22, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Karil's skirt", "Ranged", "Legs", 326, 0, 1, 0.014, 0, Arrays.asList(new Requirement("Defence", 70), new Requirement("Ranged", 70))));
        armours.add(new Armour("Morrigan's leather chaps", "Ranged", "Legs", 423, 0, 0, 0, 25, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Pernix chaps", "Ranged", "Legs", 372, 165, 2, 0, 25, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Second-Age range legs", "Ranged", "Legs", 423, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Death Lotus chaps", "Ranged", "Legs", 456, 420, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Sirenic chaps", "Ranged", "Legs", 479, 0, 2, 0, 29, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elite sirenic chaps", "Ranged", "Legs", 503, 0, 2, 0, 31, Collections.singletonList(new Requirement("Defence", 92))));

        //Magic legs (done)
        armours.add(new Armour("Wizard robe skirt", "Magic", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide robe bottom", "Magic", "Legs", 44, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Spider silk robe bottom", "Magic", "Legs", 69, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Combat robe bottom 0", "Magic", "Legs", 69, 0, 0, 0, 6, Arrays.asList(new Requirement("Defence", 10), new Requirement("Magic", 20))));
        armours.add(new Armour("Fungal leggings", "Magic", "Legs", 83, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Batwing legs", "Magic", "Legs", 99, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Druidic mage bottom 0", "Magic", "Legs", 117, 0, 0, 0, 10, Collections.singletonList(new Requirement("Defence", 35))));
        armours.add(new Armour("Dagon'hai robe bottom", "Magic", "Legs", 117, 0, 2, 0, 12, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Splitbark legs", "Magic", "Legs", 138, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Enchanted robe", "Magic", "Legs", 161, 0, 0, 0.009, 0, Collections.singletonList(new Requirement("Defence", 45))));
        armours.add(new Armour("Battle robe bottom 0", "Magic", "Legs", 187, 0, 0, 0, 15, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Mystic robe bottom (blue)", "Magic", "Legs", 187, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Infinity bottoms", "Magic", "Legs", 216, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Grifolic leggings", "Magic", "Legs", 249, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Third-age robe", "Magic", "Legs", 285, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Gown of subjugation", "Magic", "Legs", 285, 0, 1, 0, 22, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Ahrim's robe skirt", "Magic", "Legs", 326, 0, 1, 0.014, 0, Arrays.asList(new Requirement("Defence", 70), new Requirement("Magic", 70))));
        armours.add(new Armour("Ganodermic leggings", "Magic", "Legs", 372, 0, 0, 0.015, 0, Collections.singletonList(new Requirement("Defence", 75))));
        armours.add(new Armour("Zuriel's robe bottom", "Magic", "Legs", 423, 0, 0, 0, 25, Collections.singletonList(new Requirement("Defence", 78))));
        armours.add(new Armour("Second-Age robe bottom", "Magic", "Legs", 423, 0, 0, 0.016, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Virtus robe legs", "Magic", "Legs", 372, 165, 2, 0, 25, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Seasinger's robe bottom", "Magic", "Legs", 456, 420, 0, 0.0166, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Tectonic robe bottom", "Magic", "Legs", 479, 0, 2, 0, 29, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elite tectonic robe bottom", "Magic", "Legs", 503, 0, 2, 0, 31, Collections.singletonList(new Requirement("Defence", 92))));


        //Melee hands (done)
        armours.add(new Armour("Safety gloves", "Melee", "Hands", 7, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Pirate hook (left)", "Melee", "Hands", 7, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Black gauntlets", "Melee", "Hands", 19, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Mithril gauntlets", "Melee", "Hands", 22, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Rock-shell gloves", "Melee", "Hands", 36, 0, 0, 0, 7, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Rune gauntlets", "Melee", "Hands", 42, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Dragon gauntlets", "Melee", "Hands", 49, 0, 0, 0, 9, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Bandos gloves", "Melee", "Hands", 64, 0, 1, 0, 11, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium gauntlets", "Melee", "Hands", 74, 0, 0, 0.014, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Torva gloves", "Melee", "Hands", 84, 0, 2, 0, 12, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Gloves of passage", "Melee", "Hands", 96, 0, 0, 0, 13, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Pneumatic gloves", "Melee", "Hands", 108, 0, 0, 0.017, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Elder rune gauntlets", "Melee", "Hands", 96, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune gauntlets + 1", "Melee", "Hands", 98, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune gauntlets + 2", "Melee", "Hands", 101, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune gauntlets + 5", "Melee", "Hands", 108, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Razorback gauntlets", "Melee", "Hands", 108, 0, 2, 0, 14, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Trimmed masterwork gloves", "Melee", "Hands", 114, 0, 0, 0, 15, Collections.singletonList(new Requirement("Defence", 92))));

        //Ranged hands (done)
        armours.add(new Armour("Leather gloves", "Ranged", "Hands", 5, 0, 0, 0.0002, 0, new ArrayList<>()));
        armours.add(new Armour("Spiky vambraces", "Ranged", "Hands", 5, 0, 0, 0, 1, new ArrayList<>()));
        armours.add(new Armour("Hard leather gloves", "Ranged", "Hands", 10, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Studded leather gloves", "Ranged", "Hands", 15, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Carapace gloves", "Ranged", "Hands", 22, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Green dragonhide vambraces", "Ranged", "Hands", 31, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Green spiky vambraces", "Ranged", "Hands", 31, 0, 0, 0, 6, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Blue dragonhide vambraces", "Ranged", "Hands", 42, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Blue spiky vambraces", "Ranged", "Hands", 42, 0, 0, 0, 7, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Red dragonhide vambraces", "Ranged", "Hands", 49, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Red spiky vambraces", "Ranged", "Hands", 49, 0, 0, 0, 8, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Black dragonhide vambraces", "Ranged", "Hands", 56, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Black spiky vambraces", "Ranged", "Hands", 56, 0, 0, 0, 9, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Royal dragonhide vambraces", "Ranged", "Hands", 64, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Royal spiky vambraces", "Ranged", "Hands", 64, 0, 0, 0, 10, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Armadyl gloves", "Ranged", "Hands", 64, 0, 1, 0, 11, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Pernix gloves", "Ranged", "Hands", 84, 0, 2, 0, 12, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Nightmare gauntlets", "Ranged", "Hands", 96, 0, 0, 0, 13, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Tracking gloves", "Ranged", "Hands", 108, 0, 0, 0.017, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Ascension grips", "Ranged", "Hands", 108, 0, 2, 0, 14, Collections.singletonList(new Requirement("Defence", 90))));

        //Magic hands (done)
        armours.add(new Armour("Wizard gloves", "Magic", "Hands", 7, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide gloves", "Magic", "Hands", 10, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Spider silk gloves", "Magic", "Hands", 15, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Batwing gloves", "Magic", "Hands", 22, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Splitbark gauntlets", "Magic", "Hands", 31, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Mystic gloves (blue)", "Magic", "Hands", 42, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Skeletal gloves", "Magic", "Hands", 36, 0, 0, 0, 7, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Infinity gloves", "Magic", "Hands", 49, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Grifolic gloves", "Magic", "Hands", 56, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Gloves of subjugation", "Magic", "Hands", 64, 0, 1, 0, 11, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Ganodermic gloves", "Magic", "Hands", 84, 0, 0, 0.015, 0, Collections.singletonList(new Requirement("Defence", 75))));
        armours.add(new Armour("Virtus gloves", "Magic", "Hands", 84, 0, 2, 0, 12, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Static gloves", "Magic", "Hands", 108, 0, 0, 0.017, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Celestial handwraps", "Magic", "Hands", 108, 0, 2, 0, 14, Collections.singletonList(new Requirement("Defence", 90))));

        //Melee feet (done)
        armours.add(new Armour("Bronze armoured boots", "Melee", "Feet", 7, 0, 0, 0.0008, 0, new ArrayList<>()));
        armours.add(new Armour("Fancy boots", "Melee", "Feet", 7, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Steel armoured boots", "Melee", "Feet", 15, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Black boots", "Melee", "Feet", 19, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Mithril armoured boots", "Melee", "Feet", 22, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Adamant armoured boots", "Melee", "Feet", 31, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Rune armoured boots", "Melee", "Feet", 42, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Rock-shell boots", "Melee", "Feet", 36, 0, 0, 0, 7, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Dragon boots", "Melee", "Feet", 49, 0, 0, 0, 9, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Bandos boots", "Melee", "Feet", 64, 0, 1, 0, 11, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Necronium armoured botos", "Melee", "Feet", 74, 0, 0, 0.014, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Torva boots", "Melee", "Feet", 84, 0, 2, 0, 12, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Steadfast boots", "Melee", "Feet", 108, 0, 0, 0.017, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Elder rune armoured boots", "Melee", "Feet", 96, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune armoured boots + 1", "Melee", "Feet", 98, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune armoured boots + 2", "Melee", "Feet", 101, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Elder rune armoured boots + 5", "Melee", "Feet", 108, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Emberkeen boots", "Melee", "Feet", 108, 0, 2, 0, 14, Collections.singletonList(new Requirement("Defence", 90))));
        armours.add(new Armour("Trimmed masterwork boots", "Melee", "Feet", 114, 0, 0, 0, 15, Collections.singletonList(new Requirement("Defence", 92))));

        //Ranged feet (done)
        armours.add(new Armour("Leather boots", "Ranged", "Feet", 5, 0, 0, 0.0002, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather boots", "Ranged", "Feet", 7, 0, 0, 0.001, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Studded leather boots", "Ranged", "Feet", 15, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Frog-leather boots", "Ranged", "Feet", 19, 0, 0, 0.005, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Carapace boots", "Ranged", "Feet", 22, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Green dragonhide boots", "Ranged", "Feet", 31, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Ranger boots", "Ranged", "Feet", 26, 0, 0, 0, 6, Collections.singletonList(new Requirement("Ranged", 40))));
        armours.add(new Armour("Basilisk boots", "Ranged", "Feet", 26, 0, 0, 0, 6, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Blue dragonhide boots", "Ranged", "Feet", 42, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Turoth boots", "Ranged", "Feet", 36, 0, 0, 0, 7, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Red dragonhide boots", "Ranged", "Feet", 49, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Black dragonhide boots", "Ranged", "Feet", 56, 0, 0, 0.012, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Kurask boots", "Ranged", "Feet", 49, 0, 0, 0, 9, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Royal dragonhide boots", "Ranged", "Feet", 64, 0, 0, 0.013, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Armadyl boots", "Ranged", "Feet", 64, 0, 1, 0, 11, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Pernix boots", "Ranged", "Feet", 84, 0, 2, 0, 12, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Glaiven boots", "Ranged", "Feet", 108, 0, 0, 0.017, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Flarefrost boots", "Ranged", "Feet", 108, 0, 2, 0, 14, Collections.singletonList(new Requirement("Defence", 90))));

        //Magic feet (done)
        armours.add(new Armour("Wizard boots", "Magic", "Feet", 7, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide boots", "Magic", "Feet", 10, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Spider silk boots", "Magic", "Feet", 15, 0, 0, 0.004, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Batwing boots", "Magic", "Feet", 22, 0, 0, 0.006, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Splitbark boots", "Magic", "Feet", 31, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Mystic boots (blue)", "Magic", "Feet", 42, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Skeletal boots", "Magic", "Feet", 36, 0, 0, 0, 7, Arrays.asList(new Requirement("Defence", 50), new Requirement("Crafting", 40),
            new Requirement("Fletching", 25), new Requirement("Woodcutting", 40))));
        armours.add(new Armour("Infinity boots", "Magic", "Feet", 49, 0, 0, 0.011, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Boots of subjugation", "Magic", "Feet", 64, 0, 1, 0, 11, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Ganodermic boots", "Magic", "Feet", 84, 0, 0, 0.015, 0, Collections.singletonList(new Requirement("Defence", 75))));
        armours.add(new Armour("Virtus boots", "Magic", "Feet", 84, 0, 2, 0, 12, Arrays.asList(new Requirement("Defence", 80), new Requirement("Constitution", 80))));
        armours.add(new Armour("Ragefire boots", "Magic", "Feet", 108, 0, 0, 0.017, 0, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Hailfire boots", "Magic", "Feet", 108, 0, 2, 0, 14, Collections.singletonList(new Requirement("Defence", 90))));

        //All/hybrid feet
        armours.add(new Armour("Silverhawk boots", "All", "Feet", 5, 0, 0, 0, 0, new ArrayList<>()));

        //Melee shield (done)
        armours.add(new Armour("Bronze kiteshield", "Melee", "Shield", 30, 0, 0, 0.005, 0, new ArrayList<>()));
        armours.add(new Armour("Iron kiteshield", "Melee", "Shield", 40, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Steel kiteshield", "Melee", "Shield", 63, 0, 0, 0.02, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Broodoo shield (blue)", "Melee", "Shield", 76, 0, 0, 0.025, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Mithril kiteshield", "Melee", "Shield", 90, 0, 0, 0.03, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Adamant kiteshield", "Melee", "Shield", 125, 0, 0, 0.04, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Rune kiteshield", "Melee", "Shield", 170, 0, 0, 0.05, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Granite shield", "Melee", "Shield", 196, 0, 0, 0.055, 0, Arrays.asList(new Requirement("Defence", 55), new Requirement("Strength", 55))));
        armours.add(new Armour("Gud raider shield", "Melee", "Shield", 196, 0, 0, 0.055, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Toktz-ket-xil", "Melee", "Shield", 226, 0, 0, 0.06, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Third-age kiteshield", "Melee", "Shield", 259, 0, 0, 0.065, 0, Collections.singletonList(new Requirement("Defence", 65))));
        armours.add(new Armour("Bandos warshield", "Melee", "Shield", 297, 35, 1, 0.07, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Divine spirit shield", "Melee", "Shield", 338, 0, 3, 0.075, 0, Arrays.asList(new Requirement("Defence", 75), new Requirement("Prayer", 75))));
        armours.add(new Armour("Linza's shield", "Melee", "Shield", 384, 385, 0, 0.08, 0, Collections.singletonList(new Requirement("Defence", 80))));
        armours.add(new Armour("Malevolent kiteshield", "Melee", "Shield", 491, 735, 0, 0.09, 0, Collections.singletonList(new Requirement("Defence", 90))));

        //Ranged shield (done)
        armours.add(new Armour("Leather shield", "Ranged", "Shield", 30, 0, 0, 0.005, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather shield", "Ranged", "Shield", 40, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Studded leather shield", "Ranged", "Shield", 63, 0, 0, 0.02, 0, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Broodoo shield (orange)", "Ranged", "Shield", 76, 0, 0, 0.025, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Carapace shield", "Ranged", "Shield", 90, 0, 0, 0.03, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Green dragonhide shield", "Ranged", "Shield", 125, 0, 0, 0.04, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Blue dragonhide shield", "Ranged", "Shield", 170, 0, 0, 0.05, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Red dragonhide shield", "Ranged", "Shield", 196, 0, 0, 0.055, 0, Collections.singletonList(new Requirement("Defence", 55))));
        armours.add(new Armour("Black dragonhide shield", "Ranged", "Shield", 226, 0, 0, 0.06, 0, Collections.singletonList(new Requirement("Defence", 60))));
        armours.add(new Armour("Dragonfire deflector", "Ranged", "Shield", 297, 35, 0, 0.07, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Crystal deflector", "Ranged", "Shield", 297, 35, 0, 0.07, 0, Arrays.asList(new Requirement("Defence", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10), new Requirement("Ranged", 25))));
        armours.add(new Armour("Elysian spirit shield", "Ranged", "Shield", 338, 0, 3, 0.075, 0, Arrays.asList(new Requirement("Defence", 75), new Requirement("Prayer", 75))));
        armours.add(new Armour("Vengeful kiteshield", "Ranged", "Shield", 491, 735, 0, 0.09, 0, Collections.singletonList(new Requirement("Defence", 90))));

        //Magic shield (done)
        armours.add(new Armour("Wizard shield", "Magic", "Shield", 30, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide shield", "Magic", "Shield", 40, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defence", 10))));
        armours.add(new Armour("Broodoo shield (green)", "Magic", "Shield", 76, 0, 0, 0.025, 0, Collections.singletonList(new Requirement("Defence", 25))));
        armours.add(new Armour("Batwing shield", "Magic", "Shield", 90, 0, 0, 0.03, 0, Collections.singletonList(new Requirement("Defence", 30))));
        armours.add(new Armour("Splitbark shield", "Magic", "Shield", 125, 0, 0, 0.04, 0, Collections.singletonList(new Requirement("Defence", 40))));
        armours.add(new Armour("Mystic shield", "Magic", "Shield", 170, 0, 0, 0.05, 0, Collections.singletonList(new Requirement("Defence", 50))));
        armours.add(new Armour("Dragon ward", "Magic", "Shield", 226, 0, 0, 0.06, 0, Arrays.asList(new Requirement("Defence", 60), new Requirement("Magic", 60))));
        armours.add(new Armour("Crystal ward", "Magic", "Shield", 297, 35, 0, 0.07, 0, Arrays.asList(new Requirement("Defence", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10), new Requirement("Ranged", 25))));
        armours.add(new Armour("Ward of subjugation", "Magic", "Shield", 297, 35, 1, 0.07, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Spectral spirit shield", "Magic", "Shield", 338, 210, 3, 0.075, 0, Arrays.asList(new Requirement("Defence", 75), new Requirement("Prayer", 75))));
        armours.add(new Armour("Merciless kiteshield", "Magic", "Shield", 491, 735, 0, 0.09, 0, Collections.singletonList(new Requirement("Defence", 90))));

        //Neck (done)
        armours.add(new Armour("Amulet of defence", "All", "Neck", 6, 0, 0, 0, 8, Collections.singletonList(new Requirement("Defence", 20))));
        armours.add(new Armour("Amulet of glory", "All", "Neck", 0, 0, 2, 0, 26, new ArrayList<>()));
        armours.add(new Armour("Berserker necklace", "Melee", "Neck", 0, 0, 3, 0, 30, new ArrayList<>()));
        armours.add(new Armour("Amulet of ranging", "Ranged", "Neck", 0, 0, 0, 0, 32, new ArrayList<>()));
        armours.add(new Armour("Amulet of fury (t)", "All", "Neck", 0, 0, 4, 0, 34, new ArrayList<>()));
        armours.add(new Armour("Saradomin's whisper", "Melee", "Neck", 0, 0, 2, 0, 36, Collections.singletonList(new Requirement("Strength", 70))));
        armours.add(new Armour("Saradomin's murmur", "Ranged", "Neck", 0, 0, 2, 0, 36, Collections.singletonList(new Requirement("Ranged", 70))));
        armours.add(new Armour("Saradomin's hiss", "Magic", "Neck", 0, 0, 2, 0, 36, Collections.singletonList(new Requirement("Magic", 70))));
        armours.add(new Armour("Amulet of the forsaken", "All", "Neck", 0, 0, 3, 0, 36, new ArrayList<>()));
        armours.add(new Armour("Amulet of souls", "All", "Neck", 0, 0, 5, 0, 46, new ArrayList<>()));

        //Ring (done)
        armours.add(new Armour("Ring of wealth", "All", "Ring", 0, 0, 0, 0, 10, new ArrayList<>()));
        armours.add(new Armour("Berserker ring", "All", "Ring", 5, 0, 0, 0, 12, new ArrayList<>()));
        armours.add(new Armour("Leviathan ring", "All", "Ring", 41, 0, 0, 0, 13, Collections.singletonList(new Requirement("Defence", 85))));
        armours.add(new Armour("Warrior ring", "Melee", "Ring", 0, 0, 0, 0, 17, new ArrayList<>()));
        armours.add(new Armour("Archers' ring", "Ranged", "Ring", 0, 0, 0, 0, 17, new ArrayList<>()));
        armours.add(new Armour("Seers' ring", "Magic", "Ring", 0, 0, 0, 0, 17, new ArrayList<>()));
        armours.add(new Armour("Luck of the dwarves", "All", "Ring", 0, 0, 0, 0, 17, new ArrayList<>()));
        armours.add(new Armour("Ring of death", "All", "Ring", 0, 0, 3, 0, 25, new ArrayList<>()));

        //Cape (done)
        armours.add(new Armour("Bladestorm drape", "Melee", "Cape", 4, 0, 0, 0, 1, new ArrayList<>()));
        armours.add(new Armour("Arrowstorm drape", "Ranged", "Cape", 4, 0, 0, 0, 1, new ArrayList<>()));
        armours.add(new Armour("Spellstorm drape", "Magic", "Cape", 4, 0, 0, 0, 1, new ArrayList<>()));
        armours.add(new Armour("Obsidian cape", "All", "Cape", 16, 0, 0, 0, 17, new ArrayList<>()));
        armours.add(new Armour("Ancient cloak", "All", "Cape", 18, 0, 3, 0, 0, Arrays.asList(new Requirement("Prayer", 40), new Requirement("Defence", 40))));
        armours.add(new Armour("Dragon Rider cape", "All", "Cape", 29, 0, 6, 0, 0, Collections.singletonList(new Requirement("Defence", 70))));
        armours.add(new Armour("Explosive barrel", "All", "Cape", 38, 0, 0, 0, 0, new ArrayList<>()));
        armours.add(new Armour("Third-age druidic cloak", "All", "Cape", 44, 0, 2, 0, 0, Arrays.asList(new Requirement("Defence", 65), new Requirement("Prayer", 65))));
        armours.add(new Armour("Abomination cape", "Melee", "Cape", 50, 0, 0, 0, 28, Collections.singletonList(new Requirement("Defence", 75))));
        armours.add(new Armour("Reefwalker's cape", "All", "Cape", 62, 200, 0, 0, 9, Collections.singletonList(new Requirement("Defence", 85))));

        for (Armour armour : armours) {
            namedArmours.put(armour.getName(), armour);
        }

    }

    public static ArmourDatabase getArmourDatabase() {
        if (armourDatabase == null) {
            armourDatabase = new ArmourDatabase();
        }
        return armourDatabase;
    }


    public Map<String, Armour> getArmours() {
        return namedArmours;
    }
}
