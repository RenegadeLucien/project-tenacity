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
        slayerMonsters.add(new SlayerMonster("Banshee", 15.2, "Banshees", Collections.singletonList(new Requirement("Slayer", 15))));
        slayerMonsters.add(new SlayerMonster("Mighty banshee", 89.4, "Banshees", Collections.singletonList(new Requirement("Smoking Kills", 1))));
        slayerMonsters.add(new SlayerMonster("Bat", 8.2, "Bats", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Giant bat", 18.8, "Bats", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Warped bat", 9.2, "Bats", Collections.singletonList(new Requirement("The Blood Pact", 1))));
        slayerMonsters.add(new SlayerMonster("Angry bear", 14, "Bears", Collections.singletonList(new Requirement("A Soul's Bane", 1))));
        slayerMonsters.add(new SlayerMonster("Bear cub", 7.6, "Bears", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Black bear", 10.2, "Bears", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Grizzly bear", 13, "Bears", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Grizzly bear cub", 12, "Bears", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Bird", 6.8, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Chicken", 1, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Mounted terrorbird gnome", 19.6, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Rooster", 6.4, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Tenacious toucan", 70, "Birds", Collections.singletonList(new Requirement("Back to my Roots", 1))));
        slayerMonsters.add(new SlayerMonster("Terrorbird", 17.2, "Birds", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Catablepon", 49, "Catablepon", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Cave bug", 7, "Cave bugs", Collections.singletonList(new Requirement("Slayer", 7))));
        slayerMonsters.add(new SlayerMonster("Cave crawler", 24.5, "Cave crawlers", Collections.singletonList(new Requirement("Slayer", 10))));
        slayerMonsters.add(new SlayerMonster("Cave slime", 11, "Cave slimes", Collections.singletonList(new Requirement("Slayer", 17))));
        slayerMonsters.add(new SlayerMonster("Cockatrice", 23.4, "Cockatrices", Collections.singletonList(new Requirement("Slayer", 25))));
        slayerMonsters.add(new SlayerMonster("Cow", 6.4, "Cows", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Cow calf", 3.2, "Cows", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Undead cow", 6.6, "Cows", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Crawling hand", 7.6, "Crawling hands", Collections.singletonList(new Requirement("Slayer", 5))));
        slayerMonsters.add(new SlayerMonster("Skeletal hand", 60.6, "Crawling hands", Collections.singletonList(new Requirement("Legacy of Seergaze", 1))));
        slayerMonsters.add(new SlayerMonster("Zombie hand", 73.2, "Crawling hands", Collections.singletonList(new Requirement("Legacy of Seergaze", 1))));
        slayerMonsters.add(new SlayerMonster("Cyclops", 59.4, "Cyclopes", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Desert Lizard", 34.2, "Desert lizards", Collections.singletonList(new Requirement("Slayer", 22))));
        slayerMonsters.add(new SlayerMonster("Lizard", 54.8, "Desert lizards", Collections.singletonList(new Requirement("Slayer", 22))));
        slayerMonsters.add(new SlayerMonster("Small Lizard", 9.6, "Desert lizards", Collections.singletonList(new Requirement("Slayer", 22))));
        slayerMonsters.add(new SlayerMonster("Corrupted lizard", 533, "Desert lizards", Collections.singletonList(new Requirement("Slayer", 94))));
        slayerMonsters.add(new SlayerMonster("Guard dog", 13.4, "Dogs", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Jackal", 43.2, "Dogs", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Shadow Hound", 39.4, "Dogs", Collections.singletonList(new Requirement("Desert Treasure", 1))));
        slayerMonsters.add(new SlayerMonster("Wild dog", 14, "Dogs", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dwarf", 7, "Dwarves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Black Guard", 20.6, "Dwarves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Chaos dwarf", 20.6, "Dwarves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Trade floor guard", 43.2, "Dwarves", Collections.singletonList(new Requirement("The Giant Dwarf", 1))));
        slayerMonsters.add(new SlayerMonster("Flesh crawler", 50, "Flesh crawlers", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Gelatinous abomination", 6.6, "Gelatinous abominations", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ghoul", 35.8, "Ghouls", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ravenous ghoul", 440, "Ghouls", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ghost", 10.6, "Ghosts", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Tortured soul", 38.8, "Ghosts", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ghostly warrior", 32.6, "Ghosts", Collections.singletonList(new Requirement("Spirit of Summer", 1))));
        slayerMonsters.add(new SlayerMonster("Goblin", 6.6, "Goblins", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Skoblin", 9.4, "Goblins", Collections.singletonList(new Requirement("The Blood Pact", 1))));
        slayerMonsters.add(new SlayerMonster("Young grotworm", 11.4, "Grotworms", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Grotworm", 102.8, "Grotworms", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Mature grotworm", 343.6, "Grotworms", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Hill giant", 37.6, "Hill giants", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Hobgoblin", 11.5, "Hobgoblins", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Icefiend", 7, "Icefiends", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ice warrior", 25.8, "Ice warriors", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Icelord", 60, "Ice warriors", Collections.singletonList(new Requirement("Cold War", 1))));
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
        slayerMonsters.add(new SlayerMonster("Minotaur", 16.6, "Minotaurs", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Mogre", 27, "Mogres", Arrays.asList(new Requirement("Mogre miniquest", 1), new Requirement("Slayer", 32))));
        slayerMonsters.add(new SlayerMonster("Monkey", 7, "Monkeys", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Monkey Archer", 61, "Monkeys", Collections.singletonList(new Requirement("Monkey Madness", 1))));
        slayerMonsters.add(new SlayerMonster("Monkey Guard", 85, "Monkeys", Collections.singletonList(new Requirement("Monkey Madness", 1))));
        slayerMonsters.add(new SlayerMonster("Monkey Zombie", 47.4, "Monkeys", Collections.singletonList(new Requirement("Monkey Madness", 1))));
        slayerMonsters.add(new SlayerMonster("Pig", 6.6, "Pigs", Collections.singletonList(new Requirement("Bringing Home the Bacon", 1))));
        slayerMonsters.add(new SlayerMonster("Pyrefiend", 32.6, "Pyrefiends", Collections.singletonList(new Requirement("Slayer", 30))));
        slayerMonsters.add(new SlayerMonster("Rockslug", 20, "Rock slugs", Collections.singletonList(new Requirement("Slayer", 20))));
        slayerMonsters.add(new SlayerMonster("Scorpion", 8.2, "Scorpions", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Grave scorpion", 7.2, "Scorpions", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("King Scorpion", 15.8, "Scorpions", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Pit Scorpion", 26.8, "Scorpions", Collections.singletonList(new Requirement("Legends' Guild", 1))));
        slayerMonsters.add(new SlayerMonster("Poison Scorpion", 21.6, "Scorpions", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Skeleton", 8.8, "Skeletons", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Giant skeleton", 70, "Skeletons", Collections.singletonList(new Requirement("Haunted Mine", 1))));
        slayerMonsters.add(new SlayerMonster("Skeletal hand", 60.6, "Skeletons", Collections.singletonList(new Requirement("Legacy of Seergaze", 1))));
        slayerMonsters.add(new SlayerMonster("Skeletal miner", 21.6, "Skeletons", Collections.singletonList(new Requirement("Haunted Mine", 1))));
        slayerMonsters.add(new SlayerMonster("Skeleton Mage", 16, "Skeletons", Collections.singletonList(new Requirement("Waterfall Quest", 1))));
        slayerMonsters.add(new SlayerMonster("Skoblin", 9.4, "Skeletons", Collections.singletonList(new Requirement("The Blood Pact", 1))));
        slayerMonsters.add(new SlayerMonster("Skogre", 53, "Skeletons", Collections.singletonList(new Requirement("Zogre Flesh Eaters", 1))));
        slayerMonsters.add(new SlayerMonster("Undead one", 18.8, "Skeletons", Collections.singletonList(new Requirement("Shilo Village", 1))));
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
        slayerMonsters.add(new SlayerMonster("Mountain troll", 55, "Trolls", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Troll general", 89.4, "Trolls", Collections.singletonList(new Requirement("Troll Stronghold", 1))));
        slayerMonsters.add(new SlayerMonster("Ice troll runt", 24.8, "Trolls", Collections.singletonList(new Requirement("The Fremennik Isles", 1))));
        slayerMonsters.add(new SlayerMonster("Ice troll male", 41.5, "Trolls", Collections.singletonList(new Requirement("The Fremennik Isles", 1))));
        slayerMonsters.add(new SlayerMonster("Ice troll female", 41.5, "Trolls", Collections.singletonList(new Requirement("The Fremennik Isles", 1))));
        slayerMonsters.add(new SlayerMonster("River troll", 89.4, "Trolls", Collections.singletonList(new Requirement("Fairy Tale II - Cure a Queen", 1))));
        slayerMonsters.add(new SlayerMonster("Feral vampyre", 32.6, "Vampyres", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Wall beasts", 20.6, "Wall beasts", Collections.singletonList(new Requirement("Slayer", 35))));
        slayerMonsters.add(new SlayerMonster("Wolf", 17.2, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Adolescent White wolf", 7, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Big Wolf", 18, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Desert wolf", 8.8, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Dire Wolf", 19.6, "Wolves", Collections.singletonList(new Requirement("Regicide", 1))));
        slayerMonsters.add(new SlayerMonster("Fenris wolf", 21.6, "Wolves", new ArrayList<>()));
        slayerMonsters.add(new SlayerMonster("Ice wolf", 45.4, "Wolves", Collections.singletonList(new Requirement("Troll Romance", 1))));
        slayerMonsters.add(new SlayerMonster("Jungle Wolf", 81, "Wolves", Collections.singletonList(new Requirement("Legends' Quest", 1))));
        slayerMonsters.add(new SlayerMonster("White wolf", 12.6, "Wolves", new ArrayList<>()));
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