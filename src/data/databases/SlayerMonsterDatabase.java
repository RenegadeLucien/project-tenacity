package data.databases;

import data.dataobjects.SlayerMonster;
import logic.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SlayerMonsterDatabase {

    private static SlayerMonsterDatabase slayerMonsterDatabase;

    private List<SlayerMonster> slayerMonsters = new ArrayList<>();

    private SlayerMonsterDatabase() {
        addSlayerMonsters();
    }

    private void addSlayerMonsters() {
        slayerMonsters.add(new SlayerMonster("Aberrant spectre", 109.6, "Aberrant spectres", Collections.singletonList(new Requirement("Slayer", 60))));
        slayerMonsters.add(new SlayerMonster("Abyssal demon", 278, "Abyssal demons", Collections.singletonList(new Requirement("Slayer", 85))));
        slayerMonsters.add(new SlayerMonster("Acheron mammoth", 4215.6, "Acheron mammoths", Collections.singletonList(new Requirement("Slayer", 96))));
        slayerMonsters.add(new SlayerMonster("Adamant dragon", 655.6, "Adamant dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Airut", 800.2, "Airuts", Collections.singletonList(new Requirement("Slayer", 92))));
        slayerMonsters.add(new SlayerMonster("Ankou", 62, "Ankous", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Aquanite", 212.6, "Aquanites", Collections.singletonList(new Requirement("Slayer", 78))));
        slayerMonsters.add(new SlayerMonster("Rorarius", 140, "Ascension members", Collections.singletonList(new Requirement("Slayer", 81))));
        slayerMonsters.add(new SlayerMonster("Gladius", 220.2, "Ascension members", Collections.singletonList(new Requirement("Slayer", 81))));
        slayerMonsters.add(new SlayerMonster("Capsarius", 146.6, "Ascension members", Collections.singletonList(new Requirement("Slayer", 81))));
        slayerMonsters.add(new SlayerMonster("Scutarius", 390.2, "Ascension members", Collections.singletonList(new Requirement("Slayer", 81))));
        slayerMonsters.add(new SlayerMonster("Automaton Guardian", 624, "Automatons", Arrays.asList(new Requirement("Slayer", 67),
            new Requirement("The World Wakes", 1), new Requirement("The Void Stares Back", 1), new Requirement("Ritual of the Mahjarrat", 1),
            new Requirement("The Firemaker's Curse", 1), new Requirement("The Chosen Commander", 1), new Requirement("The Branches of Darkmeyer", 1))));
        slayerMonsters.add(new SlayerMonster("Automaton Generator", 624, "Automatons", Arrays.asList(new Requirement("Slayer", 67),
            new Requirement("The World Wakes", 1), new Requirement("The Void Stares Back", 1), new Requirement("Ritual of the Mahjarrat", 1),
            new Requirement("The Firemaker's Curse", 1), new Requirement("The Chosen Commander", 1), new Requirement("The Branches of Darkmeyer", 1))));
        slayerMonsters.add(new SlayerMonster("Automaton Tracer", 624, "Automatons", Arrays.asList(new Requirement("Slayer", 67),
            new Requirement("The World Wakes", 1), new Requirement("The Void Stares Back", 1), new Requirement("Ritual of the Mahjarrat", 1),
            new Requirement("The Firemaker's Curse", 1), new Requirement("The Chosen Commander", 1), new Requirement("The Branches of Darkmeyer", 1))));
        slayerMonsters.add(new SlayerMonster("Aviansie", 171, "Aviansies", Arrays.asList(new Requirement("Strength", 60), new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Spiritual warrior", 229, "Aviansies", Arrays.asList(new Requirement("Strength", 60),
            new Requirement("Ranged", 70), new Requirement("Slayer", 68), new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Spiritual ranger", 229, "Aviansies", Arrays.asList(new Requirement("Strength", 60),
            new Requirement("Ranged", 70), new Requirement("Slayer", 63), new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Spiritual mage", 229, "Aviansies", Arrays.asList(new Requirement("Strength", 60),
            new Requirement("Ranged", 70), new Requirement("Slayer", 83), new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Banshee", 15.2, "Banshees", Collections.singletonList(new Requirement("Slayer", 15))));
        slayerMonsters.add(new SlayerMonster("Mighty banshee", 89.4, "Banshees", Collections.singletonList(new Requirement("Smoking Kills", 1))));
        slayerMonsters.add(new SlayerMonster("Basilisk", 79.6, "Basilisks", Arrays.asList(new Requirement("Slayer", 40), new Requirement("Defence", 20))));
        slayerMonsters.add(new SlayerMonster("Bat", 8.2, "Bats", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Giant bat", 18.8, "Bats", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Warped bat", 9.2, "Bats", Collections.singletonList(new Requirement("The Blood Pact", 1))));
        slayerMonsters.add(new SlayerMonster("Albino bat", 18, "Bats", Collections.singletonList(new Requirement("Cabin Fever", 1))));
        slayerMonsters.add(new SlayerMonster("Angry bear", 14, "Bears", Collections.singletonList(new Requirement("A Soul's Bane", 1))));
        slayerMonsters.add(new SlayerMonster("Bear cub", 7.6, "Bears", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Black bear", 10.2, "Bears", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Grizzly bear", 13, "Bears", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Grizzly bear cub", 12, "Bears", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Bird", 6.8, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Chicken", 6.4, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Duck", 6.4, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Mounted terrorbird gnome", 19.6, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Oomlie bird", 85.2, "Birds", Collections.singletonList(new Requirement("Legends' Quest", 1))));
        slayerMonsters.add(new SlayerMonster("Rooster", 6.4, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Pernicious parrot", 34.2, "Birds", Collections.singletonList(new Requirement("Back to my Roots", 1))));
        slayerMonsters.add(new SlayerMonster("Seagull", 6.4, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Tenacious toucan", 70, "Birds", Collections.singletonList(new Requirement("Back to my Roots", 1))));
        slayerMonsters.add(new SlayerMonster("Terrorbird", 17.2, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Black demon", 294.4, "Black demons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Baby black dragon", 45, "Black dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Black dragon", 245, "Black dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("King Black Dragon", 1050.6, "Black dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Queen Black Dragon", 1693.5, "Black dragons", Arrays.asList(new Requirement("Summoning", 60), new Requirement("Song from the Depths", 1))));
        slayerMonsters.add(new SlayerMonster("Bloodveld", 84.4, "Bloodvelds", Collections.singletonList(new Requirement("Slayer", 50))));
        slayerMonsters.add(new SlayerMonster("Mutated bloodveld", 205.8, "Bloodvelds", Arrays.asList(new Requirement("Slayer", 50), new Requirement("Legacy of Seergaze", 1))));
        slayerMonsters.add(new SlayerMonster("Baby blue dragon", 18.8, "Blue dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Blue dragon", 93.8, "Blue dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Brine rat", 43.2, "Brine rats", Arrays.asList(new Requirement("Slayer", 47), new Requirement("Olaf's Quest", 1))));
        slayerMonsters.add(new SlayerMonster("Bronze dragon", 124.5, "Bronze dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Camel warrior", 4768.8, "Camel Warriors", Collections.singletonList(new Requirement("Slayer", 96))));
        slayerMonsters.add(new SlayerMonster("Catablepon", 49, "Catablepons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Cave bug", 7, "Cave bugs", Collections.singletonList(new Requirement("Slayer", 7))));
        slayerMonsters.add(new SlayerMonster("Cave crawler", 24.5, "Cave crawlers", Collections.singletonList(new Requirement("Slayer", 10))));
        slayerMonsters.add(new SlayerMonster("Cave horror", 99.2, "Cave horrors", Arrays.asList(new Requirement("Cabin Fever", 1), new Requirement("Slayer", 58))));
        slayerMonsters.add(new SlayerMonster("Unspeakable horror", 440, "Cave horrors", Arrays.asList(new Requirement("Cabin Fever", 1), new Requirement("Slayer", 58))));
        slayerMonsters.add(new SlayerMonster("Cave slime", 11, "Cave slimes", Collections.singletonList(new Requirement("Slayer", 17))));
        slayerMonsters.add(new SlayerMonster("Celestial dragon", 976.3, "Celestial dragons", Collections.singletonList(new Requirement("One of a Kind", 1))));
        slayerMonsters.add(new SlayerMonster("Chaos Giant", 929.3, "Chaos Giants", Collections.singletonList(new Requirement("Birthright of the Dwarves", 1))));
        slayerMonsters.add(new SlayerMonster("Cockatrice", 23.4, "Cockatrices", Collections.singletonList(new Requirement("Slayer", 25))));
        slayerMonsters.add(new SlayerMonster("Corrupted scorpion", 353.2, "Corrupted creatures", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Slayer", 88))));
        slayerMonsters.add(new SlayerMonster("Corrupted scarab", 389, "Corrupted creatures", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Slayer", 91))));
        slayerMonsters.add(new SlayerMonster("Corrupted lizard", 560, "Corrupted creatures", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Slayer", 94))));
        slayerMonsters.add(new SlayerMonster("Corrupted dust devil", 679.8, "Corrupted creatures", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Slayer", 97))));
        slayerMonsters.add(new SlayerMonster("Corrupted kalphite marauder", 494, "Corrupted creatures", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Slayer", 100))));
        slayerMonsters.add(new SlayerMonster("Corrupted kalphite guardian", 494, "Corrupted creatures", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Slayer", 100))));
        slayerMonsters.add(new SlayerMonster("Corrupted worker", 653, "Corrupted creatures", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Slayer", 103))));
        slayerMonsters.add(new SlayerMonster("Cow", 6.4, "Cows", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Cow calf", 3.2, "Cows", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Undead cow", 6.6, "Cows", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Crawling hand", 7.6, "Crawling hands", Collections.singletonList(new Requirement("Slayer", 5))));
        slayerMonsters.add(new SlayerMonster("Skeletal hand", 60.6, "Crawling hands", Collections.singletonList(new Requirement("Legacy of Seergaze", 1))));
        slayerMonsters.add(new SlayerMonster("Zombie hand", 73.2, "Crawling hands", Collections.singletonList(new Requirement("Legacy of Seergaze", 1))));
        slayerMonsters.add(new SlayerMonster("Crocodile", 44.4, "Crocodiles", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Crystal shapeshifter", 1269.8, "Crystal shapeshifters", Collections.singletonList(new Requirement("The Light Within", 1))));
        slayerMonsters.add(new SlayerMonster("Cyclops", 59.4, "Cyclopes", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dagannoth", 56, "Dagannoths", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dagannoth spawn", 39.4, "Dagannoths", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dagannoth Prime", 1068, "Dagannoths", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dagannoth Rex", 1068, "Dagannoths", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dagannoth Supreme", 1068, "Dagannoths", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dagannoth guardian", 326.6, "Dagannoths", Collections.singletonList(new Requirement("Blood Runs Deep", 1))));
        slayerMonsters.add(new SlayerMonster("Dark beast", 331.4, "Dark beasts", Collections.singletonList(new Requirement("Slayer", 90))));
        slayerMonsters.add(new SlayerMonster("Desert Lizard", 34.2, "Desert lizards", Collections.singletonList(new Requirement("Slayer", 22))));
        slayerMonsters.add(new SlayerMonster("Lizard", 54.8, "Desert lizards", Collections.singletonList(new Requirement("Slayer", 22))));
        slayerMonsters.add(new SlayerMonster("Small Lizard", 9.6, "Desert lizards", Collections.singletonList(new Requirement("Slayer", 22))));
        slayerMonsters.add(new SlayerMonster("Corrupted lizard", 533, "Desert lizards", Collections.singletonList(new Requirement("Slayer", 94))));
        slayerMonsters.add(new SlayerMonster("Desert strykewyrm", 376.5, "Desert strykewyrms", Collections.singletonList(new Requirement("Slayer", 77))));
        slayerMonsters.add(new SlayerMonster("Guard dog", 13.4, "Dogs", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Jackal", 43.2, "Dogs", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Shadow Hound", 39.4, "Dogs", Collections.singletonList(new Requirement("Desert Treasure", 1))));
        slayerMonsters.add(new SlayerMonster("Wild dog", 14, "Dogs", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dust devil", 192.8, "Dust devils", Collections.singletonList(new Requirement("Slayer", 65))));
        slayerMonsters.add(new SlayerMonster("Corrupted dust devil", 679.8, "Dust devils", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Slayer", 97))));
        slayerMonsters.add(new SlayerMonster("Dwarf", 7, "Dwarves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Black Guard", 20.6, "Dwarves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Chaos dwarf", 20.6, "Dwarves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Trade floor guard", 43.2, "Dwarves", Collections.singletonList(new Requirement("The Giant Dwarf", 1))));
        slayerMonsters.add(new SlayerMonster("Black Guard Berserker", 24.8, "Dwarves", Collections.singletonList(new Requirement("The Giant Dwarf", 1))));
        slayerMonsters.add(new SlayerMonster("Chaos dwarf hand cannoneer", 43.2, "Dwarves", Collections.singletonList(new Requirement("Forgiveness of a Chaos Dwarf", 1))));
        slayerMonsters.add(new SlayerMonster("Earth warrior", 57.5, "Earth warriors", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Edimmu", 880.2, "Edimmus", Arrays.asList(new Requirement("Dungeoneering", 115), new Requirement("Slayer", 90), new Requirement("Plague's End", 1))));
        slayerMonsters.add(new SlayerMonster("Elf warrior", 73.6, "Elves", Collections.singletonList(new Requirement("Regicide", 1))));
        slayerMonsters.add(new SlayerMonster("Fever spider", 86.6, "Fever spiders", Collections.singletonList(new Requirement("Rum Deal", 1))));
        slayerMonsters.add(new SlayerMonster("Fire giant", 161.2, "Fire giants", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Flesh crawler", 50, "Flesh crawlers", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Fungal mage", 63.6, "Fungal mages", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ganodermic runt", 565, "Ganodermic creatures", Collections.singletonList(new Requirement("Slayer", 95))));
        slayerMonsters.add(new SlayerMonster("Ganodermic beast", 565, "Ganodermic creatures", Collections.singletonList(new Requirement("Slayer", 95))));
        slayerMonsters.add(new SlayerMonster("Gargoyle", 197.4, "Gargoyles", Collections.singletonList(new Requirement("Slayer", 75))));
        slayerMonsters.add(new SlayerMonster("Gelatinous abomination", 6.6, "Gelatinous abominations", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dragonstone dragon", 1448.4, "Gemstone dragons", Collections.singletonList(new Requirement("Slayer", 95))));
        slayerMonsters.add(new SlayerMonster("Onyx dragon", 1858.8, "Gemstone dragons", Collections.singletonList(new Requirement("Slayer", 98))));
        slayerMonsters.add(new SlayerMonster("Hydrix dragon", 4768.8, "Gemstone dragons", Collections.singletonList(new Requirement("Slayer", 101))));
        slayerMonsters.add(new SlayerMonster("Ghoul", 35.8, "Ghouls", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ravenous ghoul", 440, "Ghouls", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ghost", 10.6, "Ghosts", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Tortured soul", 38.8, "Ghosts", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ghostly warrior", 32.6, "Ghosts", Collections.singletonList(new Requirement("Spirit of Summer", 1))));
        slayerMonsters.add(new SlayerMonster("Glacor", 1881, "Glacors", Collections.singletonList(new Requirement("Ritual of the Mahjarrat", 1))));
        slayerMonsters.add(new SlayerMonster("Goblin", 6.6, "Goblins", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Skoblin", 9.4, "Goblins", Collections.singletonList(new Requirement("The Blood Pact", 1))));
        slayerMonsters.add(new SlayerMonster("Gorak", 49.8, "Goraks", Collections.singletonList(new Requirement("Fairy Tale II - Cure a Queen", 1))));
        slayerMonsters.add(new SlayerMonster("Greater demon", 135.4, "Greater demons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("K'ril Tsutsaroth", 2151.5, "Greater demons", Arrays.asList(new Requirement("Constitution", 70), new Requirement("Strength", 60),
            new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Green dragon", 68.6, "Green dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Brutal green dragon", 440, "Green dragons", Collections.singletonList(new Requirement("Barbarian Firemaking", 1))));
        slayerMonsters.add(new SlayerMonster("Grifolapine", 279, "Grifolapines", Collections.singletonList(new Requirement("Slayer", 88))));
        slayerMonsters.add(new SlayerMonster("Grifolaroo", 323.2, "Grifolaroos", Collections.singletonList(new Requirement("Slayer", 82))));
        slayerMonsters.add(new SlayerMonster("Young grotworm", 11.4, "Grotworms", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Grotworm", 102.8, "Grotworms", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Mature grotworm", 343.6, "Grotworms", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Harpie Bug Swarm", 34, "Harpie Bug Swarms", Collections.singletonList(new Requirement("Slayer", 33))));
        slayerMonsters.add(new SlayerMonster("Hellhound", 93.8, "Hellhounds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Hill giant", 37.6, "Hill giants", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Hobgoblin", 11.5, "Hobgoblins", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ice giant", 47, "Ice giants", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ice strykewyrm", 693.2, "Ice strykewyrms", Arrays.asList(new Requirement("TzTok-Jad", 1), new Requirement("Slayer", 93))));
        slayerMonsters.add(new SlayerMonster("Ice warrior", 25.8, "Ice warriors", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Icelord", 60, "Ice warriors", Collections.singletonList(new Requirement("Cold War", 1))));
        slayerMonsters.add(new SlayerMonster("Icefiend", 7, "Icefiends", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Infernal mage", 91, "Infernal mages", Collections.singletonList(new Requirement("Slayer", 45))));
        slayerMonsters.add(new SlayerMonster("Iron dragon", 245, "Iron dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Jelly", 75.5, "Jellies", Collections.singletonList(new Requirement("Slayer", 52))));
        slayerMonsters.add(new SlayerMonster("Jungle horror", 41.5, "Jungle horrors", Collections.singletonList(new Requirement("Cabin Fever", 1))));
        slayerMonsters.add(new SlayerMonster("Jungle strykewyrm", 250, "Jungle strykewyrms", Collections.singletonList(new Requirement("Slayer", 73))));
        slayerMonsters.add(new SlayerMonster("Kalphite Worker", 59.3, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Kalphite Soldier", 78.8, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Kalphite guardian", 95, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Exiled kalphite worker", 109.8, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Exiled kalphite paragon", 140, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Exiled kalphite soldier", 147, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Exiled kalphite guardian", 229, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Exiled kalphite marauder", 240.4, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Kalphite Queen (Phase 1)", 1309.4, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Exiled Kalphite Queen", 2055, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Kalphite King", 3963, "Kalphites", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Killerwatt", 32.6, "Killerwatts", Collections.singletonList(new Requirement("Slayer", 37))));
        slayerMonsters.add(new SlayerMonster("Kurask", 115.2, "Kurasks", Collections.singletonList(new Requirement("Slayer", 70))));
        slayerMonsters.add(new SlayerMonster("Lava strykewyrm", 1872, "Lava strykewyrms", Collections.singletonList(new Requirement("Slayer", 94))));
        slayerMonsters.add(new SlayerMonster("Living rock protector", 156, "Living rock creatures", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Living rock striker", 156, "Living rock creatures", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Vinecrawler", 2086, "Lost Grove creatures", Collections.singletonList(new Requirement("Slayer", 104))));
        slayerMonsters.add(new SlayerMonster("Bulbous crawler", 2360, "Lost Grove creatures", Collections.singletonList(new Requirement("Slayer", 106))));
        slayerMonsters.add(new SlayerMonster("Moss golem", 2408.8, "Lost Grove creatures", Collections.singletonList(new Requirement("Slayer", 108))));
        slayerMonsters.add(new SlayerMonster("Minotaur", 16.6, "Minotaurs", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Mithril dragon", 564.4, "Mithril dragons", Collections.singletonList(new Requirement("Barbarian Firemaking", 1))));
        slayerMonsters.add(new SlayerMonster("Mogre", 27, "Mogres", Arrays.asList(new Requirement("Mogre miniquest", 1), new Requirement("Slayer", 32))));
        slayerMonsters.add(new SlayerMonster("Molanisk", 52, "Molanisks", Arrays.asList(new Requirement("Slayer", 39), new Requirement("Death to the Dorgeshuun", 1))));
        slayerMonsters.add(new SlayerMonster("Monkey", 7, "Monkeys", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Monkey Archer", 61, "Monkeys", Collections.singletonList(new Requirement("Monkey Madness", 1))));
        slayerMonsters.add(new SlayerMonster("Monkey Guard", 85, "Monkeys", Collections.singletonList(new Requirement("Monkey Madness", 1))));
        slayerMonsters.add(new SlayerMonster("Monkey Zombie", 47.4, "Monkeys", Collections.singletonList(new Requirement("Monkey Madness", 1))));
        slayerMonsters.add(new SlayerMonster("Moss giant", 49.5, "Moss giants", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Bladed muspah", 469, "Muspah", Collections.singletonList(new Requirement("Fate of the Gods", 1))));
        slayerMonsters.add(new SlayerMonster("Throwing muspah", 469, "Muspah", Collections.singletonList(new Requirement("Fate of the Gods", 1))));
        slayerMonsters.add(new SlayerMonster("Force muspah", 469, "Muspah", Collections.singletonList(new Requirement("Fate of the Gods", 1))));
        slayerMonsters.add(new SlayerMonster("Mutated jadinko baby", 98.6, "Mutated jadinkos", Collections.singletonList(new Requirement("Slayer", 80))));
        slayerMonsters.add(new SlayerMonster("Mutated jadinko guard", 188.4, "Mutated jadinkos", Collections.singletonList(new Requirement("Slayer", 86))));
        slayerMonsters.add(new SlayerMonster("Mutated jadinko male", 209.6, "Mutated jadinkos", Collections.singletonList(new Requirement("Slayer", 91))));
        slayerMonsters.add(new SlayerMonster("Mutated zygomite", 31, "Mutated zygomites", Arrays.asList(new Requirement("Lost City", 1), new Requirement("Slayer", 57))));
        slayerMonsters.add(new SlayerMonster("Nechryael", 251.6, "Nechryaels", Collections.singletonList(new Requirement("Slayer", 80))));
        slayerMonsters.add(new SlayerMonster("Nightmare", 1540, "Nightmares", Collections.singletonList(new Requirement("Children of Mah", 1))));
        slayerMonsters.add(new SlayerMonster("Smoke nihil", 564, "Nihil", Collections.singletonList(new Requirement("Fate of the Gods", 1))));
        slayerMonsters.add(new SlayerMonster("Shadow nihil", 423, "Nihil", Collections.singletonList(new Requirement("Fate of the Gods", 1))));
        slayerMonsters.add(new SlayerMonster("Blood nihil", 705.4, "Nihil", Collections.singletonList(new Requirement("Fate of the Gods", 1))));
        slayerMonsters.add(new SlayerMonster("Ice nihil", 564, "Nihil", Collections.singletonList(new Requirement("Fate of the Gods", 1))));
        slayerMonsters.add(new SlayerMonster("Ogre", 88.4, "Ogres", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ogress warrior", 38.2, "Ogres", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ogress champion", 44, "Ogres", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Zogre", 28, "Ogres", Collections.singletonList(new Requirement("Zogre Flesh Eaters", 1))));
        slayerMonsters.add(new SlayerMonster("Skogre", 26.8, "Ogres", Collections.singletonList(new Requirement("Zogre Flesh Eaters", 1))));
        slayerMonsters.add(new SlayerMonster("Otherworldly being", 34, "Otherworldly beings", Collections.singletonList(new Requirement("Lost City", 1))));
        slayerMonsters.add(new SlayerMonster("Pig", 6.6, "Pigs", Collections.singletonList(new Requirement("Bringing Home the Bacon", 1))));
        slayerMonsters.add(new SlayerMonster("Pyrefiend", 32.6, "Pyrefiends", Collections.singletonList(new Requirement("Slayer", 30))));
        slayerMonsters.add(new SlayerMonster("Baby red dragon", 50, "Red dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Red dragon", 220.8, "Red dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Rockslug", 20, "Rockslugs", Collections.singletonList(new Requirement("Slayer", 20))));
        slayerMonsters.add(new SlayerMonster("Rune dragon", 2051, "Rune dragons", Arrays.asList(new Requirement("Ritual of the Mahjarrat", 1), new Requirement("Fate of the Gods", 1))));
        slayerMonsters.add(new SlayerMonster("Scabaras lancer", 55, "Scabarites", Collections.singletonList(new Requirement("Dealing with Scabaras", 1))));
        slayerMonsters.add(new SlayerMonster("Scabaras mage", 55, "Scabarites", Collections.singletonList(new Requirement("Dealing with Scabaras", 1))));
        slayerMonsters.add(new SlayerMonster("Scabaras ranger", 109.5, "Scabarites", Collections.singletonList(new Requirement("Dealing with Scabaras", 1))));
        slayerMonsters.add(new SlayerMonster("Scarab mage", 55, "Scabarites", Collections.singletonList(new Requirement("Contact!", 1))));
        slayerMonsters.add(new SlayerMonster("Small scarab", 17, "Scarabites", Collections.singletonList(new Requirement("Missing My Mummy", 1))));
        slayerMonsters.add(new SlayerMonster("Locust lancer", 91, "Scabarites", Collections.singletonList(new Requirement("Dealing with Scabaras", 1))));
        slayerMonsters.add(new SlayerMonster("Locust ranger", 100, "Scabarites", Collections.singletonList(new Requirement("Dealing with Scabaras", 1))));
        slayerMonsters.add(new SlayerMonster("Scorpion", 8.2, "Scorpions", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Grave scorpion", 7.2, "Scorpions", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("King Scorpion", 15.8, "Scorpions", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Pit Scorpion", 26.8, "Scorpions", Collections.singletonList(new Requirement("Legends' Quest", 1))));
        slayerMonsters.add(new SlayerMonster("Poison Scorpion", 21.6, "Scorpions", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Sea Snake Hatchling", 50, "Sea snakes", Collections.singletonList(new Requirement("Royal Trouble", 1))));
        slayerMonsters.add(new SlayerMonster("Sea Snake Young", 85, "Sea snakes", Collections.singletonList(new Requirement("Royal Trouble", 1))));
        slayerMonsters.add(new SlayerMonster("Shade", 32.5, "Shades", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Loar Shade", 38, "Shades", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Truthful shadow", 343, "Shadow creatures", Collections.singletonList(new Requirement("Plague's End", 1))));
        slayerMonsters.add(new SlayerMonster("Blissful shadow", 565, "Shadow creatures", Collections.singletonList(new Requirement("Plague's End", 1))));
        slayerMonsters.add(new SlayerMonster("Manifest shadow", 930, "Shadow creatures", Collections.singletonList(new Requirement("Plague's End", 1))));
        slayerMonsters.add(new SlayerMonster("Shadow warrior", 39, "Shadow warriors", Collections.singletonList(new Requirement("Legends' Quest", 1))));
        slayerMonsters.add(new SlayerMonster("Skeletal wyvern", 510.8, "Skeletal wyverns", Collections.singletonList(new Requirement("Slayer", 72))));
        slayerMonsters.add(new SlayerMonster("Skeleton", 8.8, "Skeletons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Giant skeleton", 70, "Skeletons", Collections.singletonList(new Requirement("Haunted Mine", 1))));
        slayerMonsters.add(new SlayerMonster("Skeletal hand", 60.6, "Skeletons", Collections.singletonList(new Requirement("Legacy of Seergaze", 1))));
        slayerMonsters.add(new SlayerMonster("Skeletal miner", 21.6, "Skeletons", Collections.singletonList(new Requirement("Haunted Mine", 1))));
        slayerMonsters.add(new SlayerMonster("Skeleton Mage", 16, "Skeletons", Collections.singletonList(new Requirement("Waterfall Quest", 1))));
        slayerMonsters.add(new SlayerMonster("Skoblin", 9.4, "Skeletons", Collections.singletonList(new Requirement("The Blood Pact", 1))));
        slayerMonsters.add(new SlayerMonster("Skogre", 53, "Skeletons", Collections.singletonList(new Requirement("Zogre Flesh Eaters", 1))));
        slayerMonsters.add(new SlayerMonster("Undead one", 18.8, "Skeletons", Collections.singletonList(new Requirement("Shilo Village", 1))));
        slayerMonsters.add(new SlayerMonster("Salawa akh", 504, "Soul devourers", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Slayer", 105))));
        slayerMonsters.add(new SlayerMonster("Feline akh", 536.2, "Soul devourers", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Slayer", 107))));
        slayerMonsters.add(new SlayerMonster("Scarab akh", 714.8, "Soul devourers", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Slayer", 109))));
        slayerMonsters.add(new SlayerMonster("Crocodile akh", 761, "Soul devourers", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Slayer", 111))));
        slayerMonsters.add(new SlayerMonster("Gorilla akh", 705, "Soul devourers", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Slayer", 113))));
        slayerMonsters.add(new SlayerMonster("Imperial mage akh", 1780.6, "Soul devourers", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Slayer", 117))));
        slayerMonsters.add(new SlayerMonster("Imperial warrior akh", 1780.6, "Soul devourers", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Slayer", 117))));
        slayerMonsters.add(new SlayerMonster("Imperial ranger akh", 1780.6, "Soul devourers", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Slayer", 117))));
        slayerMonsters.add(new SlayerMonster("Spider", 6.4, "Spiders", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Blessed spider", 17.2, "Spiders", Collections.singletonList(new Requirement("Underground Pass", 1))));
        slayerMonsters.add(new SlayerMonster("Corpse Spider", 6.6, "Spiders", Collections.singletonList(new Requirement("The Blood Pact", 1))));
        slayerMonsters.add(new SlayerMonster("Crypt spider", 34.2, "Spiders", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Deadly red spider", 103.6, "Spiders", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Fever spider", 86.6, "Spiders", Collections.singletonList(new Requirement("Rum Deal", 1))));
        slayerMonsters.add(new SlayerMonster("Giant crypt spider", 70, "Spiders", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ice spider", 17.2, "Spiders", Collections.singletonList(new Requirement("Mining", 50))));
        slayerMonsters.add(new SlayerMonster("Poison spider", 34.2, "Spiders", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Shadow spider", 19.6, "Spiders", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Spiritual ranger", 229, "Spiritual rangers", Arrays.asList(new Requirement("Strength", 60), new Requirement("Slayer", 63),
            new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Spiritual warrior", 229, "Spiritual warriors", Arrays.asList(new Requirement("Strength", 60), new Requirement("Slayer", 68),
            new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Spiritual mage", 229, "Spiritual mages", Arrays.asList(new Requirement("Strength", 60), new Requirement("Slayer", 83),
            new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Seeker", 440.6, "Stalker creatures", Arrays.asList(new Requirement("Slayer", 71), new Requirement("Dishonour among Thieves", 1))));
        slayerMonsters.add(new SlayerMonster("Soulgazer", 1950, "Stalker creatures", Arrays.asList(new Requirement("Slayer", 99), new Requirement("Dishonour among Thieves", 1))));
        slayerMonsters.add(new SlayerMonster("Steel dragon", 350, "Steel dragons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Suqah", 47.4, "Suqahs", Collections.singletonList(new Requirement("Lunar Diplomacy", 1))));
        slayerMonsters.add(new SlayerMonster("Terror dog", 75.4, "Terror dogs", Collections.singletonList(new Requirement("The Lair of Tarn Razorlor", 1))));
        slayerMonsters.add(new SlayerMonster("Tormented demon", 1136, "Tormented demons", Collections.singletonList(new Requirement("While Guthix Sleeps", 1))));
        slayerMonsters.add(new SlayerMonster("Mountain troll", 55, "Trolls", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Troll general", 89.4, "Trolls", Collections.singletonList(new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Ice troll runt", 24.8, "Trolls", Collections.singletonList(new Requirement("The Fremennik Isles", 1))));
        slayerMonsters.add(new SlayerMonster("Ice troll male", 41.5, "Trolls", Collections.singletonList(new Requirement("The Fremennik Isles", 1))));
        slayerMonsters.add(new SlayerMonster("Ice troll female", 41.5, "Trolls", Collections.singletonList(new Requirement("The Fremennik Isles", 1))));
        slayerMonsters.add(new SlayerMonster("River troll", 89.4, "Trolls", Collections.singletonList(new Requirement("Fairy Tale II - Cure a Queen", 1))));
        slayerMonsters.add(new SlayerMonster("Turoth", 41.4, "Turoths", Collections.singletonList(new Requirement("Slayer", 55))));
        slayerMonsters.add(new SlayerMonster("Feral vampyre", 32.6, "Vampyres", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Vyrewatch", 43.2, "Vyrewatches", Collections.singletonList(new Requirement("Legacy of Seergaze", 1))));
        slayerMonsters.add(new SlayerMonster("Vyrelord", 340, "Vyrewatches", Collections.singletonList(new Requirement("The Branches of Darkmeyer", 1))));
        slayerMonsters.add(new SlayerMonster("Wall beast", 20.6, "Wall beasts", Collections.singletonList(new Requirement("Slayer", 35))));
        slayerMonsters.add(new SlayerMonster("Warped terrorbird", 133.4, "Warped terrorbirds", Collections.singletonList(new Requirement("The Path of Glouphrie", 1))));
        slayerMonsters.add(new SlayerMonster("Warped tortoise", 95, "Warped tortoises", Collections.singletonList(new Requirement("The Path of Glouphrie", 1))));
        slayerMonsters.add(new SlayerMonster("Waterfiend", 335, "Waterfiends", Collections.singletonList(new Requirement("Barbarian Firemaking", 1))));
        slayerMonsters.add(new SlayerMonster("Werewolf", 34.5, "Werewolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Wolf", 17.2, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Adolescent White wolf", 7, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Big Wolf", 18, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Desert wolf", 8.8, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dire Wolf", 19.6, "Wolves", Collections.singletonList(new Requirement("Regicide", 1))));
        slayerMonsters.add(new SlayerMonster("Fenris wolf", 21.6, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ice wolf", 45.4, "Wolves", Collections.singletonList(new Requirement("Troll Romance", 1))));
        slayerMonsters.add(new SlayerMonster("Jungle Wolf", 81, "Wolves", Collections.singletonList(new Requirement("Legends' Quest", 1))));
        slayerMonsters.add(new SlayerMonster("White wolf", 12.6, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Wyvern", 1878.8, "Wyverns", Collections.singletonList(new Requirement("Slayer", 96))));
        slayerMonsters.add(new SlayerMonster("Zombie", 8, "Zombies", new ArrayList<>()));
    }

    public static SlayerMonsterDatabase getSlayerMonsterDatabase() {
        if (slayerMonsterDatabase == null) {
            slayerMonsterDatabase = new SlayerMonsterDatabase();
        }
        return slayerMonsterDatabase;
    }

    public List<SlayerMonster> getSlayerMonsters() {
        return slayerMonsters;
    }
}