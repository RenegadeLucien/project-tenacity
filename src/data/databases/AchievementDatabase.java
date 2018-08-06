package data.databases;

import logic.Encounter;
import logic.Player;
import logic.Restriction;
import data.dataobjects.Achievement;
import data.dataobjects.Achievement.AchievementBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*This class lists not only achievements, but all non-repeatables.*/
public class AchievementDatabase {

    private static AchievementDatabase achievementDatabase;

    private List<Achievement> achievements = new ArrayList<>();

    private AchievementDatabase() {
        addAchievementsABC();
        addAchievementsDZ();
        AchievementBuilder allAchievements = new AchievementBuilder("All Achievements", 0);
        for (Achievement achievement : achievements) {
            allAchievements.requirement(achievement.getName(), 1);
        }
        achievements.add(allAchievements.build());
    }

    private void addAchievementsABC() {
        achievements.add(new AchievementBuilder("1001 Kharidian Spikes", 0.05).requirement("Cactus seed", 1).reward("Farming", 465)
            .reward("Cactus spines", 1).build());
        achievements.add(new AchievementBuilder("Three's Company (unabridged)", 0.75).requirement("Dungeoneering", 6)
            .requirement("Attack", 30).requirement("Ranged", 30).requirement("Magic", 30).reward("Dungeoneering", 750)
            .reward("Dungeoneering tokens", 75).lamp(Arrays.asList("Attack", "Ranged", "Magic"), 3750, 1).build());
        achievements.add(new AchievementBuilder("300", 0).requirement("Three's Company (unabridged)", 1).build());
        achievements.add(new AchievementBuilder("99 With a Flake", 0).requirement("Flags unfurled", 1).build());
        achievements.add(new AchievementBuilder("One Piercing Note", 1).reward("Quest points", 2).reward("Prayer", 250).build());
        achievements.add(new AchievementBuilder("The Dig Site", 1.5).requirement("Thieving", 25).requirement("Agility", 10)
            .requirement("Herblore", 10).requirement("Cup of tea", 1).requirement("Vial", 1).requirement("Rope", 2)
            .requirement("Uncut opal", 1).reward("Quest points", 2).reward("Mining", 15300).reward("Herblore", 2000).reward("Gold bar", 2)
            .build());
        achievements.add(new AchievementBuilder("Priest in Peril", 0.75).requirement("Pure essence", 25).requirement("Bucket", 0)
            .encounter(new Encounter("Cerberus")).encounter(new Encounter("Monk of Zamorak")).reward("Quest points", 1)
            .lamp(Collections.singletonList("Prayer"), 1406, 10).build());
        achievements.add(new AchievementBuilder("Temple of Ikov", 0.75).requirement("Thieving", 42).requirement("Ranged", 40)
            .requirement("Limpwurt root", 20).requirement("Candle", 0).encounter(new Encounter("Fire Warrior of Lesarkus",
                Collections.singletonList(new Restriction("Ice arrows", 1)))).reward("Quest points", 1).reward("Ranged", 10500)
            .reward("Fletching", 8000).build());
        achievements.add(new AchievementBuilder("The Tourist Trap", 1).requirement("Fletching", 10).requirement("Smithing", 20)
            .requirement("Desert shirt", 1).requirement("Desert robe", 1).requirement("Desert boots", 1).requirement("Waterskin (4)", 3)
            .requirement("Feather", 30).requirement("Coins", 200).requirement("Bronze bar", 1).reward("Quest points", 2)
            .lamp(Arrays.asList("Agility", "Fletching", "Smithing", "Thieving"), 4650, 1)
            .lamp(Arrays.asList("Agility", "Fletching", "Smithing", "Thieving"), 4650, 1).build());
        achievements.add(new AchievementBuilder("Death Plateau", 0.25).encounter(new Encounter("The Map")).reward("Quest points", 1)
            .reward("Rabbit sandwich", 4).lamp(Player.ALL_SKILLS, 100, 1).lamp(Player.ALL_SKILLS, 100, 1).lamp(Player.ALL_SKILLS, 100, 1)
            .build());
        achievements.add(new AchievementBuilder("Troll Stronghold", 0.5).requirement("Death Plateau", 1).requirement("Agility", 15)
            .requirement("Thieving", 30).requirement("Coins", 12).encounter(new Encounter("Dad")).encounter(new Encounter("Troll general"))
            .reward("Quest points", 1).lamp(Player.ALL_SKILLS, 10000, 30).lamp(Player.ALL_SKILLS, 10000, 30).build());
        achievements.add(new AchievementBuilder("Waterfall Quest", 0.75).requirement("Air rune", 6).requirement("Earth rune", 6)
            .requirement("Water rune", 6).requirement("Rope", 0).reward("Quest points", 1).reward("Diamond", 2).reward("Gold bar", 2)
            .reward("Mithril seeds", 40).reward("Attack", 13750).reward("Strength", 13750).build());
        achievements.add(new AchievementBuilder("Ice gloves", 0.05).requirement("Mining", 50).encounter(new Encounter("Ice Queen"))
            .build());
        achievements.add(new AchievementBuilder("Desert Treasure", 2.5).requirement("The Dig Site", 1)
            .requirement("Priest in Peril", 1).requirement("Temple of Ikov", 1).requirement("The Tourist Trap", 1)
            .requirement("Troll Stronghold", 1).requirement("Waterfall Quest", 1).requirement("Ice gloves", 1).requirement("Slayer", 10)
            .requirement("Firemaking", 50).requirement("Magic", 50).requirement("Thieving", 50).requirement("Ashes", 1)
            .requirement("Blood rune", 1).requirement("Bones", 1).requirement("Charcoal", 1).requirement("Coins", 650)
            .requirement("Molten glass", 6).requirement("Magic logs", 12).requirement("Steel bar", 6).requirement("Chocolate bar", 1)
            .requirement("Face mask", 0).requirement("Garlic", 1).requirement("Lockpick", 50).requirement("Silver bar", 1)
            .requirement("Iron bar", 1).encounter(new Encounter("Dessous")).encounter(new Encounter("Ice troll"))
            .encounter(new Encounter("Ice troll")).encounter(new Encounter("Ice troll")).encounter(new Encounter("Ice troll"))
            .encounter(new Encounter("Ice troll")).encounter(new Encounter("Kamil")).encounter(new Encounter("Fareed",
                Collections.singletonList(new Restriction("Ice gloves", 1)))).encounter(new Encounter("Damis (form 1)"))
            .encounter(new Encounter("Damis (form 2)")).reward("Quest points", 3).reward("Magic", 20000).build());
        achievements.add(new AchievementBuilder("The Restless Ghost", 0.25).reward("Quest points", 1).reward("Prayer", 1125)
            .build());
        achievements.add(new AchievementBuilder("Mage Arena minigame", 0).requirement("Magic", 60)
            .encounter(new Encounter("Kolodion (Ogre)", Collections.singletonList(new Restriction("Magic", 1))))
            .encounter(new Encounter("Kolodion (Troll)", Collections.singletonList(new Restriction("Magic", 1))))
            .encounter(new Encounter("Kolodion (Dark beast)", Collections.singletonList(new Restriction("Magic", 1))))
            .encounter(new Encounter("Kolodion (Black demon)", Collections.singletonList(new Restriction("Magic", 1)))).build());
        achievements.add(new AchievementBuilder("A, B, Cithara", 0).requirement("One Piercing Note", 1).requirement("Desert Treasure", 1)
            .requirement("The Restless Ghost", 1).requirement("Mage Arena minigame", 1).requirement("Saradomin arrows", 0).build());
        achievements.add(new AchievementBuilder("A-Voiding Conflict", 0.05).requirement("Combat", 35).build());
        achievements.add(new AchievementBuilder("A Barrel of Staffs", 0).requirement("Mage Arena minigame", 1)
            .requirement("Coins", 80000).build());
        achievements.add(new AchievementBuilder("A Body in the Sewers", 0).requirement("Mithril bar", 5).requirement("Smithing", 68)
            .reward("Mithril platebody", 1).reward("Smithing", 250).build());
        achievements.add(new AchievementBuilder("A Bolt from the Blue", 0).requirement("Rune bar", 1).requirement("Feather", 10)
            .requirement("Smithing", 88).requirement("Fletching", 69).reward("Smithing", 75).reward("Fletching", 100).build());
        achievements.add(new AchievementBuilder("A Bridge Not Far", 0).requirement("Agility", 8).requirement("Strength", 19)
            .requirement("Ranged", 37).build());
        achievements.add(new AchievementBuilder("A Brief History of Telescopes", 0.05).requirement("Port jade", 3000)
            .requirement("Port cherrywood", 2000).requirement("Construction", 44).requirement("Oak plank", 2).requirement("Molten glass", 1)
            .reward("Construction", 121).build());
        achievements.add(new AchievementBuilder("Plague City", 0.5).requirement("Dwellberries", 1).requirement("Rope", 1)
            .requirement("Chocolate dust", 1).requirement("Snape grass", 1).requirement("Bucket of milk", 1).reward("Quest points", 1)
            .reward("Mining", 2425).reward("Gas mask", 1).build());
        achievements.add(new AchievementBuilder("Gertrude's Cat", 0.75).requirement("Raw sardine", 1).requirement("Coins", 100)
            .requirement("Bucket of milk", 1).reward("Quest points", 1).lamp(Collections.singletonList("Cooking"), 1525, 14)
            .reward("Chocolate cake", 1).reward("Stew", 1).build());
        achievements.add(new AchievementBuilder("A Cat is for Life...", 0).requirement("Plague City", 1)
            .requirement("Gertrude's Cat", 1).build());
        achievements.add(new AchievementBuilder("Making History", 0.75).requirement("Priest in Peril", 1)
            .requirement("The Restless Ghost", 1).requirement("Spade", 0).requirement("Coins", 2600).requirement("Sapphire amulet", 1)
            .reward("Quest points", 3).reward("Crafting", 1000).reward("Prayer", 1000).reward("Coins", 750).reward("Kudos", 5)
            .reward("Enchanted key", 1).build());
        achievements.add(new AchievementBuilder("Biohazard", 0.75).requirement("Plague City", 1).requirement("Coins", 10)
            .encounter(new Encounter("Mourner (Ardougne)")).reward("Quest points", 3).reward("Thieving", 1250).build());
        achievements.add(new AchievementBuilder("Underground Pass", 2).requirement("Biohazard", 1).requirement("Ranged", 25)
            .requirement("Rope", 2).requirement("Shortbow", 0).requirement("Bronze arrow", 1).encounter(new Encounter("Kalrag"))
            .encounter(new Encounter("Paladin (Underground Pass)")).encounter(new Encounter("Paladin (Underground Pass)"))
            .encounter(new Encounter("Paladin (Underground Pass)")).encounter(new Encounter("Demon (Underground Pass)"))
            .encounter(new Encounter("Demon (Underground Pass)")).encounter(new Encounter("Demon (Underground Pass)"))
            .encounter(new Encounter("Disciple of Iban")).reward("Quest points", 5).reward("Agility", 3000).reward("Attack", 3000)
            .reward("Iban's staff", 1).reward("Fire rune", 15).reward("Death rune", 30).build());
        achievements.add(new AchievementBuilder("Regicide", 1.5).requirement("Agility", 56).requirement("Crafting", 10)
            .requirement("Underground Pass", 1).requirement("Shortbow", 0).requirement("Bronze arrow", 1).requirement("Rope", 1)
            .requirement("Limestone", 1).requirement("Coal", 20).requirement("Strip of cloth", 1).requirement("Cooked rabbit", 1)
            .encounter(new Encounter("Tyras guard")).reward("Quest points", 3).reward("Agility", 13750).reward("Coins", 15000).build());
        achievements.add(new AchievementBuilder("Catapult Construction", 0.5).requirement("Regicide", 1).requirement("Fletching", 42)
            .requirement("Construction", 44).requirement("Mithril nails", 90).requirement("Mahogany plank", 10).reward("Quest points", 2)
            .reward("Construction", 15000).reward("Fletching", 5000).reward("Teak plank", 30).reward("Coins", 2000).build());
        achievements.add(new AchievementBuilder("Big Chompy Bird Hunting", 0.75).requirement("Cooking", 30)
            .requirement("Ranged", 30).requirement("Fletching", 5).requirement("Feather", 100).requirement("Wolf bones", 5)
            .encounter(new Encounter("Chompy bird", Collections.singletonList(new Restriction("Ogre bow", 1))))
            .reward("Quest points", 2).reward("Fletching", 262).reward("Cooking", 1470).reward("Ranged", 735).build());
        achievements.add(new AchievementBuilder("Sheep Herder", 0.75).requirement("Coins", 100).reward("Coins", 3100)
            .reward("Quest points", 4).build());
        achievements.add(new AchievementBuilder("Roving Elves", 1).requirement("Waterfall Quest", 1).requirement("Regicide", 1)
            .requirement("Rope", 0).encounter(new Encounter("Moss giant (Glarial's Tomb)", Arrays.asList(new Restriction("Prayer", 0),
                new Restriction("Weapons", 0), new Restriction("Armour", 0), new Restriction("Prayer", 0)))).reward("Quest points", 1)
            .reward("Strength", 10000).reward("Crystal bow", 1).build());
        achievements.add(new AchievementBuilder("Mourning's End Part I", 2).requirement("Big Chompy Bird Hunting", 1)
            .requirement("Sheep Herder", 1).requirement("Roving Elves", 1).requirement("Ranged", 60).requirement("Thieving", 50)
            .requirement("Bear fur", 1).requirement("Silk", 2).requirement("Bucket of water", 1).requirement("Feather", 1)
            .requirement("Toad crunchies", 1).requirement("Leather", 1).requirement("Magic logs", 1).requirement("Coins", 24)
            .requirement("Coal", 20).encounter(new Encounter("Mourner")).reward("Quest points", 2).reward("Thieving", 25000)
            .reward("Constitution", 25000).build());
        achievements.add(new AchievementBuilder("Mourning's End Part II", 2.5).requirement("Mourning's End Part I", 1)
            .requirement("Rope", 1).requirement("Death talisman", 0).reward("Quest points", 2).reward("Agility", 20000).build());
        achievements.add(new AchievementBuilder("Within the Light", 1.5).requirement("Mourning's End Part II", 1)
            .requirement("Agility", 69).requirement("Fletching", 70).requirement("Ranged", 75).requirement("Woodcutting", 75)
            .requirement("Death talisman", 0).encounter(new Encounter("Mourner")).reward("Quest points", 2).reward("Agility", 35000)
            .reward("Fletching", 20000).reward("Ranged", 20000).reward("Woodcutting", 20000).build());
        achievements.add(new AchievementBuilder("Plague's End", 2).requirement("Making History", 1)
            .requirement("Catapult Construction", 1).requirement("Within the Light", 1).requirement("Agility", 75)
            .requirement("Construction", 75).requirement("Crafting", 75).requirement("Dungeoneering", 75).requirement("Herblore", 75)
            .requirement("Mining", 75).requirement("Prayer", 75).requirement("Ranged", 75).requirement("Summoning", 75)
            .requirement("Woodcutting", 75).requirement("Rune bar", 1).requirement("Plant cure", 1).requirement("Magic logs", 10)
            .requirement("Spirit shards", 200).requirement("Gold charm", 1).requirement("Green charm", 1).requirement("Crimson charm", 1)
            .requirement("Blue charm", 1).requirement("Pouch", 1).requirement("Super defence (3)", 1)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Mourner", "Mourner", "Mourner"), Arrays.asList("Mourner",
                "Mourner", "Head mourner")))).encounter(new Encounter("Sir Hugo"))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Trahaearn automaton", "Trahaearn automaton",
                "Trahaearn automaton")))).encounter(new Encounter(Collections.singletonList(Arrays.asList("Shadow (Plague's End)",
                "Shadow (Plague's End)")))).encounter(new Encounter(Collections.singletonList(Arrays.asList("Shadow (Plague's End)",
                "Shadow (Plague's End)", "Shadow (Plague's End)", "Greater shadow"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Dark Lord", "Greater shadow"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Dark Lord", "Greater shadow", "Greater shadow"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Dark Lord", "Greater shadow", "Greater shadow",
                "Greater shadow")))).encounter(new Encounter(Collections.singletonList(Arrays.asList("Dark Lord",
                "Greater shadow", "Greater shadow", "Greater shadow"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Dark Lord", "Greater shadow", "Greater shadow",
                "Greater shadow", "Greater shadow", "Shadow (Plague's End)", "Shadow (Plague's End)", "Shadow (Plague's End)",
                "Shadow (Plague's End)")))).reward("Quest points", 2).reward("Agility", 50000).reward("Construction", 50000)
            .reward("Crafting", 50000).reward("Dungeoneering", 50000).reward("Herblore", 50000)
            .reward("Mining", 50000).reward("Prayer", 50000).reward("Ranged", 50000).reward("Summoning", 50000).reward("Woodcutting", 50000)
            .build());
        achievements.add(new AchievementBuilder("A Clean Slate", 0.05).requirement("Plague's End", 1)
            .requirement("Cleansing crystal", 1).reward("Prayer", 9800).build());
        achievements.add(new AchievementBuilder("Bringing Home the Bacon", 1).requirement("Farming", 14).requirement("Summoning", 14)
            .requirement("Construction", 14).reward("Quest points", 1).reward("Farming", 350).reward("Summoning", 350)
            .reward("Construction", 350).build());
        achievements.add(new AchievementBuilder("A Face in the Clouds", 0).requirement("Plague's End", 1)
            .requirement("Bringing Home the Bacon", 1).requirement("Bacon mound", 1).requirement("Bread", 1).requirement("Chocolate bar", 1)
            .build());
        achievements.add(new AchievementBuilder("A Familiar Feeling", 0).build());
        achievements.add(new AchievementBuilder("A Flicker in Darkness", 0).requirement("Divination", 10)
            .requirement("Dungeoneering floors completed", 5).build());
        achievements.add(new AchievementBuilder("Stolen Hearts", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Skulls mercenary", "Skulls mercenary", "Skulls mercenary"))))
            .reward("Quest points", 3).reward("Coins", 2500).reward("Constitution", 250).reward("Agility", 250).reward("Thieving", 250)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Constitution", "Defense", "Ranged", "Prayer"), 250, 1).build());
        achievements.add(new AchievementBuilder("Diamond in the Rough", 1).requirement("Stolen Hearts", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Bandit", "Bandit", "Bandit king"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Apep", "Heru")))).reward("Quest points", 1)
            .reward("Agility", 250).reward("Thieving", 250).reward("Constitution", 250).reward("Sapphire", 1).reward("Emerald", 1)
            .reward("Ruby", 1).lamp(Arrays.asList("Attack", "Strength", "Magic", "Constitution", "Defense", "Ranged", "Prayer"), 250, 1)
            .build());
        achievements.add(new AchievementBuilder("The Jack of Spades", 0.5).requirement("Diamond in the Rough", 1)
            .reward("Agility", 500).reward("Quest points", 1).reward("Construction", 500).reward("Dungeoneering", 500)
            .reward("Thieving", 500).build());
        achievements.add(new AchievementBuilder("A Game of Tombs I", 0).requirement("Shifting Tombs", 1).build());
        achievements.add(new AchievementBuilder("A Game of Tombs II", 0).requirement("Shifting Tombs", 10).build());
        achievements.add(new AchievementBuilder("A Game of Tombs III", 0).requirement("Shifting Tombs", 50).build());
        achievements.add(new AchievementBuilder("A Game of Tombs IV", 0).requirement("Shifting Tombs", 100).build());
        achievements.add(new AchievementBuilder("A Game of Tombs V", 0).requirement("Shifting Tombs", 200).build());
        achievements.add(new AchievementBuilder("A Gift from Khazard", 0).build());
        achievements.add(new AchievementBuilder("A Grave Consideration", 0).requirement("The Restless Ghost", 1).build());
        achievements.add(new AchievementBuilder("Sea Slug", 0.5).requirement("Firemaking", 30).requirement("Swamp paste", 1)
            .reward("Quest points", 1).reward("Fishing", 7175).reward("Oyster pearls", 1).build());
        achievements.add(new AchievementBuilder("Recruitment Drive", 0.75).requirement("Herblore", 3).encounter(new Encounter(
            "Sir Leye", Collections.singletonList(new Restriction("Items", 0)))).reward("Quest points", 1).reward("Prayer", 1000)
            .reward("Herblore", 1000).reward("Agility", 1000).reward("Initiate sallet", 1).build());
        achievements.add(new AchievementBuilder("Goblin Diplomacy", 0.25).requirement("Blue dye", 1).requirement("Orange dye", 1)
            .reward("Quest points", 5).reward("Gold bar", 1).reward("Crafting", 200).build());
        achievements.add(new AchievementBuilder("The Lost Tribe", 0.75).requirement("Goblin Diplomacy", 1).requirement("Agility", 13)
            .requirement("Mining", 17).requirement("Thieving", 13).requirement("Bullseye lantern (oil)", 0).reward("Quest points", 1)
            .reward("Mining", 3000).reward("Ring of life", 1).build());
        achievements.add(new AchievementBuilder("Creature of Fenkenstrain", 0.75).requirement("Priest in Peril", 1)
            .requirement("The Restless Ghost", 1).requirement("Crafting", 20).requirement("Thieving", 25).requirement("Coins", 50)
            .requirement("Silver bar", 1).requirement("Bronze wire", 3).requirement("Needle", 1).requirement("Thread", 5)
            .encounter(new Encounter("Experiment")).reward("Quest points", 2).reward("Thieving", 1000).build());
        achievements.add(new AchievementBuilder("Garden of Tranquility", 1.5).requirement("Creature of Fenkenstrain", 1)
            .requirement("Farming", 25).requirement("Watering can", 0).requirement("Cabbage seed", 3).requirement("Onion seed", 3)
            .requirement("Marigold seed", 1).requirement("Compost", 2).requirement("Pure essence", 1).requirement("Plant cure", 2)
            .requirement("Fishing rod", 0).requirement("Plant pot", 1).reward("Quest points", 2).reward("Farming", 5097)
            .reward("Apple seed", 1).reward("Acorn", 1).reward("Guam seed", 5).reward("Compost potion (4)", 1).build());
        achievements.add(new AchievementBuilder("Cook's Assistant", 0.25).reward("Quest points", 1).reward("Cooking", 300)
            .reward("Coins", 500).reward("Sardine", 20).build());
        achievements.add(new AchievementBuilder("Family Crest", 0.75).requirement("Crafting", 40).requirement("Smithing", 40)
            .requirement("Mining", 40).requirement("Magic", 59).requirement("Shrimps", 1).requirement("Salmon", 1).requirement("Tuna", 1)
            .requirement("Bass", 1).requirement("Swordfish", 1).requirement("Ruby", 2).requirement("Antipoison (4)", 1)
            .requirement("Air rune", 12).requirement("Water rune", 3).requirement("Fire rune", 3).requirement("Earth rune", 3)
            .encounter(new Encounter("Chronozon", Collections.singletonList(new Restriction("Blast spells", 1)))).reward("Quest points", 1)
            .build());
        achievements.add(new AchievementBuilder("Jungle Potion", 0.25).requirement("Herblore", 3).reward("Quest points", 1)
            .reward("Herblore", 775).build());
        achievements.add(new AchievementBuilder("Shilo Village", 1).requirement("Jungle Potion", 1).requirement("Crafting", 20)
            .requirement("Agility", 32).requirement("Bronze wire", 1).requirement("Bones", 3).requirement("Spade", 0).requirement("Rope", 1)
            .requirement("Chisel", 0).requirement("Unlit torch", 1).encounter(new Encounter("Nazastarool (phase 1)"))
            .encounter(new Encounter("Nazastarool (phase 2)")).encounter(new Encounter("Nazastarool (phase 3)")).reward("Quest points", 2)
            .reward("Crafting", 3875).reward("Coins", 2000).build());
        achievements.add(new AchievementBuilder("Lost City", 0.75).requirement("Crafting", 31).requirement("Woodcutting", 36)
            .encounter(new Encounter("Dramen tree spirit", Collections.singletonList(new Restriction("Gear", 0)))).reward("Quest points", 3)
            .build());
        achievements.add(new AchievementBuilder("Merlin's Crystal", 0.75).requirement("Bread", 1).requirement("Bucket", 1)
            .requirement("Bat bones", 1).encounter(new Encounter("Sir Mordred")).reward("Quest points", 6).build());
        achievements.add(new AchievementBuilder("Druidic Ritual", 0.25).requirement("Coins", 1).requirement("Vial", 1)
            .reward("Quest points", 4).reward("Herblore", 250).reward("Grimy guam", 15).reward("Eye of newt", 15).build());
        achievements.add(new AchievementBuilder("Shield of Arrav", 0.75).requirement("Coins", 20)
            .encounter(new Encounter("Jonny the beard")).reward("Quest points", 1).reward("Coins", 1200).build());
        achievements.add(new AchievementBuilder("The Fremennik Trials", 1.5).requirement("Crafting", 40).requirement("Fletching", 25)
            .requirement("Woodcutting", 40).requirement("Raw shark", 1).requirement("Coins", 5250).encounter(new Encounter("The Draugen"))
            .encounter(new Encounter("Koschei the Deathless", Arrays.asList(new Restriction("Armour", 0), new Restriction("Weapon", 0))))
            .reward("Quest points", 3).reward("Agility", 2812).reward("Attack", 2812).reward("Constitution", 2812).reward("Crafting", 2812)
            .reward("Defence", 2812).reward("Fishing", 2812).reward("Fletching", 2812).reward("Strength", 2812).reward("Thieving", 2812)
            .reward("Woodcutting", 2812).build());
        achievements.add(new AchievementBuilder("Rune Mysteries", 1).reward("Quest points", 1).reward("Magic", 250)
            .reward("Runecrafting", 250).reward("Air talisman", 1).reward("First tower hat", 1).reward("Tower mindspike", 1)
            .reward("Mind rune", 70).build());
        achievements.add(new AchievementBuilder("Lunar Diplomacy", 1.5).requirement("Lost City", 1).requirement("Rune Mysteries", 1)
            .requirement("The Fremennik Trials", 1).requirement("Shilo Village", 1).requirement("Crafting", 61).requirement("Defense", 40)
            .requirement("Firemaking", 49).requirement("Mining", 60).requirement("Herblore", 5).requirement("Runecrafting", 14)
            .requirement("Magic", 65).requirement("Woodcutting", 55).requirement("Coins", 1000).requirement("Nature rune", 1)
            .requirement("Fire rune", 4).requirement("Spade", 0).requirement("Air talisman", 0).requirement("Water talisman", 0)
            .requirement("Earth talisman", 0).requirement("Fire talisman", 0).requirement("Thread", 2).requirement("Clean guam", 1)
            .requirement("Clean marrentill", 1).encounter(new Encounter("Suqah")).encounter(new Encounter("Suqah"))
            .encounter(new Encounter("Suqah")).encounter(new Encounter("Suqah")).encounter(new Encounter("Suqah"))
            .encounter(new Encounter("Me", Collections.singletonList(new Restriction("Lunar staff", 1)))).reward("Quest points", 2)
            .reward("Magic", 5000).reward("Runecrafting", 5000).reward("Astral rune", 50).build());
        achievements.add(new AchievementBuilder("Nature Spirit", 0.5).requirement("Priest in Peril", 1)
            .requirement("The Restless Ghost", 1).requirement("Silver sickle", 1).encounter(new Encounter("Ghast",
                Collections.singletonList(new Restriction("Silver sickle (b)", 1)))).encounter(new Encounter("Ghast",
                Collections.singletonList(new Restriction("Silver sickle (b)", 1)))).encounter(new Encounter("Ghast",
                Collections.singletonList(new Restriction("Silver sickle (b)", 1)))).reward("Quest points", 2).reward("Apple pie", 3)
            .reward("Meat pie", 3).reward("Constitution", 2000).reward("Prayer", 90).lamp(Collections.singletonList("Defense"), 2000, 3)
            .lamp(Collections.singletonList("Crafting"), 3000, 4).build());
        achievements.add(new AchievementBuilder("Fairy Tale I - Growing Pains", 0.75).requirement("Lost City", 1)
            .requirement("Nature Spirit", 1).requirement("Secateurs", 1).encounter(new Encounter("Tanglefoot",
                Collections.singletonList(new Restriction("Magic secateurs", 1)))).reward("Quest points", 2).reward("Farming", 3500)
            .reward("Attack", 2000).reward("Magic", 1000).build());
        achievements.add(new AchievementBuilder("Fairy Tale II - Cure a Queen", 0.75).requirement("Fairy Tale I - Growing Pains", 1)
            .requirement("Thieving", 40).requirement("Farming", 49).requirement("Herblore", 57).requirement("Vial of water", 1)
            .encounter(new Encounter("Gorak")).reward("Quest points", 2).reward("Herblore", 3500).reward("Thieving", 2500)
            .lamp(Player.ALL_SKILLS, 2500, 30).build());
        achievements.add(new AchievementBuilder("Swept Away", 0.5).reward("Quest points", 2).lamp(Player.ALL_SKILLS, -10, 1)
            .lamp(Player.ALL_SKILLS, -10, 1).lamp(Player.ALL_SKILLS, -10, 1).lamp(Player.ALL_SKILLS, -10, 1).lamp(Player.ALL_SKILLS, -10, 1)
            .lamp(Player.ALL_SKILLS, -10, 1).lamp(Player.ALL_SKILLS, -10, 1).lamp(Player.ALL_SKILLS, -10, 1).lamp(Player.ALL_SKILLS, -10, 1)
            .lamp(Player.ALL_SKILLS, -10, 1).build());
        achievements.add(new AchievementBuilder("Murder Mystery", 0.75).requirement("Empty pot", 1).reward("Quest points", 3)
            .reward("Coins", 2000).reward("Pot of flour", 1).reward("Crafting", 1406).build());
        achievements.add(new AchievementBuilder("Holy Grail", 0.5).requirement("Merlin's Crystal", 1).requirement("Attack", 30)
            .encounter(new Encounter("Black Knight Titan")).reward("Quest points", 2).reward("Defense", 15300).reward("Prayer", 11000)
            .build());
        achievements.add(new AchievementBuilder("One Small Favour", 1.5).requirement("Rune Mysteries", 1)
            .requirement("Shilo Village", 1).requirement("Herblore", 18).requirement("Crafting", 25).requirement("Smithing", 30)
            .requirement("Agility", 36).requirement("Steel bar", 4).requirement("Bronze bar", 1).requirement("Iron bar", 1)
            .requirement("Empty pot", 1).requirement("Coins", 2000).requirement("Clean marrentill", 1).requirement("Clean harralander", 1)
            .requirement("Vial of water", 1).encounter(new Encounter("Slagilith")).encounter(new Encounter(Collections.singletonList(
                Arrays.asList("Dwarf gang member", "Dwarf gang member", "Dwarf gang member")))).reward("Quest points", 2)
            .reward("Smithing", 1000).reward("Adamantite ore", 1).reward("Uncut ruby", 1).reward("Uncut diamond", 1)
            .lamp(Player.ALL_SKILLS, 10000, 30).lamp(Player.ALL_SKILLS, 10000, 30).build());
        achievements.add(new AchievementBuilder("King's Ransom", 1).requirement("Holy Grail", 1).requirement("Murder Mystery", 1)
            .requirement("One Small Favour", 1).requirement("Magic", 45).requirement("Defense", 65).requirement("Granite (500g)", 1)
            .requirement("Law rune", 1).requirement("Air rune", 1).requirement("Iron chainbody", 1).requirement("Bronze helm", 1)
            .reward("Quest points", 1).reward("Defense", 33000).reward("Magic", 5000).lamp(Player.ALL_SKILLS, 5000, 50).build());
        achievements.add(new AchievementBuilder("Wanted!", 1).requirement("Quest points", 33).requirement("Recruitment Drive", 1)
            .requirement("The Lost Tribe", 1).requirement("Priest in Peril", 1).requirement("Coins", 1).requirement("Molten glass", 1)
            .requirement("Law rune", 1).requirement("Pure essence", -20).encounter(new Encounter("Black Knight"))
            .encounter(new Encounter("Black Knight")).encounter(new Encounter("Solus Dellagar")).reward("Quest points", 1)
            .reward("Slayer", 5000).build());
        achievements.add(new AchievementBuilder("The Slug Menace", 1).requirement("Sea Slug", 1).requirement("Wanted!", 1)
            .requirement("Runecrafting", 30).requirement("Crafting", 30).requirement("Slayer", 30).requirement("Thieving", 30)
            .requirement("Swamp paste", 0).requirement("Pure essence", 5).requirement("Earth talisman", 0).requirement("Fire talisman", 0)
            .requirement("Water talisman", 0).requirement("Air talisman", 0).requirement("Mind talisman", 0)
            .encounter(new Encounter("Slug Prince")).reward("Quest points", 1).reward("Thieving", 3500).reward("Crafting", 3500)
            .reward("Runecrafting", 3500).build());
        achievements.add(new AchievementBuilder("A Knight in the Darkness", 0).requirement("Proselyte sallet", 0)
            .requirement("Proselyte hauberk", 0).requirement("Proselyte cuisse", 0).requirement("The Slug Menace", 1)
            .requirement("Defense", 30).requirement("Prayer", 20).build());
        achievements.add(new AchievementBuilder("A Lick of Paint", 0).requirement("Gertrude's Cat", 1)
            .requirement("Garden of Tranquility", 1).requirement("Coins", 100).build());
        achievements.add(new AchievementBuilder("A Meal Fit for a Duke", 0).requirement("Cook's Assistant", 1)
            .requirement("Cooking", 40).requirement("Raw lobster", 1).reward("Lobster", 1).reward("Cooking", 120).build());
        achievements.add(new AchievementBuilder("A Natural Thief", 0).requirement("Thieving", 28).build());
        achievements.add(new AchievementBuilder("Dragon Slayer", 1.5).requirement("Quest points", 33).requirement("Silk", 1)
            .requirement("Bowl (unfired)", 1).requirement("Wizard's mind bomb", 1).requirement("Crayfish cage", 1)
            .requirement("Coins", 12000).requirement("Plank", 3).requirement("Steel nails", 90).encounter(new Encounter(Arrays.asList(
                Collections.singletonList("Zombie rat"), Collections.singletonList("Ghost (Melzar's Maze)"),
                Collections.singletonList("Skeleton (Melzar's Maze)"), Collections.singletonList("Zombie"),
                Collections.singletonList("Melzar the Mad"), Collections.singletonList("Lesser demon")))).encounter(new Encounter("Elvarg",
                Collections.singletonList(new Restriction("Dragonfire protection", 1)))).reward("Quest points", 2)
            .reward("Anti-dragon shield", 1).lamp(Collections.singletonList("Strength"), 18650, 40)
            .lamp(Collections.singletonList("Defense"), 18650, 40).build());
        achievements.add(new AchievementBuilder("Heroes' Quest", 0.75).requirement("Quest points", 56).requirement("Shield of Arrav", 1)
            .requirement("Lost City", 1).requirement("Dragon Slayer", 1).requirement("Merlin's Crystal", 1).requirement("Druidic Ritual", 1)
            .requirement("Cooking", 53).requirement("Fishing", 53).requirement("Herblore", 25).requirement("Mining", 50)
            .requirement("Ice gloves", 1).requirement("Harralander potion (unf)", 1).requirement("Fishing rod", 1)
            .requirement("Fishing bait", 1).requirement("Lockpick", 1).requirement("Coins", 1000)
            .encounter(new Encounter("Entranan firebird")).reward("Quest points", 1).reward("Attack", 3075).reward("Defense", 3075)
            .reward("Strength", 3075).reward("Constitution", 3075).reward("Ranged", 2075).reward("Fishing", 2725).reward("Cooking", 2825)
            .reward("Woodcutting", 1575).reward("Firemaking", 1575).reward("Smithing", 2257).reward("Mining", 2575).reward("Herblore", 1325)
            .build());
        achievements.add(new AchievementBuilder("Throne of Miscellania", 0.75).requirement("Heroes' Quest", 1)
            .requirement("The Fremennik Trials", 1).requirement("Iron bar", 1).requirement("Logs", 1).requirement("Gold ring", 1)
            .requirement("Coins", 15).requirement("Shortbow", 1).reward("Quest points", 1).build());
        achievements.add(new AchievementBuilder("Royal Trouble", 1).requirement("Throne of Miscellania", 1)
            .requirement("Agility", 40).requirement("Slayer", 40).requirement("Coal", 5).encounter(new Encounter("Giant Sea Snake"))
            .reward("Quest points", 1).reward("Coins", 20000).reward("Agility", 5000).reward("Slayer", 5000).reward("Constitution", 5000)
            .build());
        achievements.add(new AchievementBuilder("Legends' Quest", 2).requirement("Quest points", 107).requirement("Family Crest", 1)
            .requirement("Heroes' Quest", 1).requirement("Shilo Village", 1).requirement("Underground Pass", 1)
            .requirement("Waterfall Quest", 1).requirement("Agility", 50).requirement("Crafting", 50).requirement("Herblore", 45)
            .requirement("Magic", 56).requirement("Mining", 52).requirement("Prayer", 42).requirement("Smithing", 50)
            .requirement("Strength", 50).requirement("Thieving", 50).requirement("Woodcutting", 50).requirement("Rope", 1)
            .requirement("Vial of water", 1).requirement("Papyrus", 3).requirement("Charcoal", 1).requirement("Unpowered orb", 1)
            .requirement("Gold bar", 2).requirement("Opal", 1).requirement("Jade", 1).requirement("Red topaz", 1)
            .requirement("Sapphire", 1).requirement("Emerald", 1).requirement("Ruby", 1).requirement("Diamond", 1)
            .requirement("Cosmic rune", 6).requirement("Water rune", 60).requirement("Lockpick", 5).requirement("Rune hatchet", 0)
            .requirement("Soul rune", 1).requirement("Mind rune", 1).requirement("Earth rune", 1).requirement("Law rune", 1)
            .encounter(new Encounter("Ranalph Devere")).encounter(new Encounter("San Tojalon")).encounter(new Encounter("Irvig Senay"))
            .encounter(new Encounter("Nezikchened")).encounter(new Encounter("Nezikchened")).encounter(new Encounter("Nezikchened"))
            .reward("Quest points", 4).lamp(Arrays.asList("Attack", "Defense", "Strength", "Constitution", "Prayer", "Magic",
                "Woodcutting", "Crafting", "Smithing", "Herblore", "Agility", "Thieving"), 7650, 1).lamp(Arrays.asList("Attack", "Defense",
                "Strength", "Constitution", "Prayer", "Magic", "Woodcutting", "Crafting", "Smithing", "Herblore", "Agility", "Thieving"),
                7650, 1).lamp(Arrays.asList("Attack", "Defense", "Strength", "Constitution", "Prayer", "Magic", "Woodcutting", "Crafting",
                "Smithing", "Herblore", "Agility", "Thieving"), 7650, 1).lamp(Arrays.asList("Attack", "Defense", "Strength", "Constitution",
                "Prayer", "Magic", "Woodcutting", "Crafting", "Smithing", "Herblore", "Agility", "Thieving"), 7650, 1).build());
        achievements.add(new AchievementBuilder("A Palm For Each Finger", 0).requirement("Legends' Quest", 1)
            .requirement("Woodcutting", 15).reward("Palm leaf", 1).build());
        achievements.add(new AchievementBuilder("A Periodic Table", 0).requirement("Royal Trouble", 1).requirement("Coins", 37500)
            .reward("Mahogany log", 1).build());
        achievements.add(new AchievementBuilder("A Pizza the Loot", 0.05).requirement("Raw anchovies", 1).requirement("Coins", 4)
            .requirement("Cooking", 55).reward("Cooking", 213).build());
        achievements.add(new AchievementBuilder("A Prayer Opportunity", 0.1).requirement("Construction", 75)
            .requirement("Smithing", 50).requirement("Dungeoneering floors completed", 4).build());
        achievements.add(new AchievementBuilder("A Road Less Travelled", 0).build());
        achievements.add(new AchievementBuilder("A Screwball Scramble", 0).requirement("Regicide", 1).requirement("Agility", 85)
            .build());
        achievements.add(new AchievementBuilder("A Seer-ing Light", 0).build());
        achievements.add(new AchievementBuilder("A String and a Flare", 0).requirement("Lunar Diplomacy", 1).requirement("Magic", 80)
            .requirement("Astral rune", 2).requirement("Earth rune", 10).requirement("Water rune", 5)
            .requirement("Gold amulet (unstrung)", 1).reward("Gold amulet", 1).reward("Magic", 83).reward("Crafting", 4).build());
        achievements.add(new AchievementBuilder("A Taste of the Exotic", 0.05).requirement("Papaya tree seed", 1)
            .requirement("Farming", 57).reward("Farming", 6173).reward("Papaya", 1).build());
        achievements.add(new AchievementBuilder("A Ton of Earth", 0).requirement("Pure essence", 28).requirement("Earth tiara", 0)
            .requirement("Runecrafting", 75).reward("Earth rune", 100).reward("Runecrafting", 182).build());
        achievements.add(new AchievementBuilder("A Visit to Charlie", 0).requirement("Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("A Wizard Did It", 0).build());
        achievements.add(new AchievementBuilder("A World In Microcosm", 0).build());
        achievements.add(new AchievementBuilder("Abyssal Reach", 0.25).requirement("Rune Mysteries", 1).reward("Runecrafting", 1000)
            .build());
        achievements.add(new AchievementBuilder("Abyssal Valet", 0).requirement("Abyssal titan pouch", 1).requirement("Summoning", 93)
            .requirement("Pure essence", 2).reward("Summoning", 2).build());
        achievements.add(new AchievementBuilder("Ace of Dungeons", 0.1).requirement("Plague's End", 1).requirement("Dungeoneering", 95)
            .build());
        achievements.add(new AchievementBuilder("Shades of Mort'ton", 0.75).requirement("Crafting", 20).requirement("Firemaking", 5)
            .requirement("Herblore", 15).requirement("Vial of water", 2).requirement("Ashes", 2).requirement("Clean tarromin", 2)
            .requirement("Logs", 1).requirement("Coins", 1000).encounter(new Encounter("Loar Shade")).encounter(new Encounter("Loar Shade"))
            .encounter(new Encounter("Loar Shade")).encounter(new Encounter("Loar Shade")).encounter(new Encounter("Loar Shade"))
            .reward("Quest points", 3).reward("Herblore", 2000).reward("Crafting", 2000).build());
        achievements.add(new AchievementBuilder("Ad-Myre The Goods", 0).requirement("Shades of Mort'ton", 1).build());
        achievements.add(new AchievementBuilder("Broomstick enchantment 1", 0).requirement("Swept Away", 1)
            .requirement("Diamond in the Rough", 1).build());
        achievements.add(new AchievementBuilder("Broomstick enchantment 2", 0).requirement("Broomstick enchantment 1", 1)
            .requirement("Magic", 33).reward("Magic", 1997).build());
        achievements.add(new AchievementBuilder("Broomstick enchantment 3", 0).requirement("Broomstick enchantment 2", 1)
            .requirement("Magic", 53).reward("Magic", 7139).build());
        achievements.add(new AchievementBuilder("Broomstick enchantment 4", 0).requirement("Broomstick enchantment 3", 1)
            .requirement("Lunar Diplomacy", 1).requirement("Magic", 73).reward("Magic", 10338).build());
        achievements.add(new AchievementBuilder("Broomstick enchantment 5", 0).requirement("Broomstick enchantment 4", 1)
            .requirement("Magic", 93).requirement("Underground Pass", 1).reward("Magic", 14979).build());
        achievements.add(new AchievementBuilder("Advanced Sweeping", 0).requirement("Broomstick enchantment 5", 1).build());
        achievements.add(new AchievementBuilder("Adventurer's Log", 0).reward("Logs", 1).reward("Woodcutting", 25).build());
        achievements.add(new AchievementBuilder("Aereck's Old Bones", 0).requirement("The Restless Ghost", 1).build());
        achievements.add(new AchievementBuilder("Bar Crawl", 0.5).requirement("Coins", 208).build());
        achievements.add(new AchievementBuilder("Agile from Head to Toe", 0).requirement("Advanced Barbarian Outpost laps", 250)
            .requirement("Advanced Gnome Stronghold laps", 250).build());
        achievements.add(new AchievementBuilder("Agility - Dojo Mojo", 0).requirement("Dojo Mojo points", 100000000).build());
        achievements.add(new AchievementBuilder("Agility 5", 0).requirement("Agility", 5).build());
        achievements.add(new AchievementBuilder("Agility 10", 0).requirement("Agility", 10).build());
        achievements.add(new AchievementBuilder("Agility 20", 0).requirement("Agility", 20).build());
        achievements.add(new AchievementBuilder("Agility 30", 0).requirement("Agility", 30).build());
        achievements.add(new AchievementBuilder("Agility 40", 0).requirement("Agility", 40).build());
        achievements.add(new AchievementBuilder("Agility 50", 0).requirement("Agility", 50).build());
        achievements.add(new AchievementBuilder("Agility 60", 0).requirement("Agility", 60).build());
        achievements.add(new AchievementBuilder("Agility 70", 0).requirement("Agility", 70).build());
        achievements.add(new AchievementBuilder("Agility 80", 0).requirement("Agility", 80).build());
        achievements.add(new AchievementBuilder("Agility 90", 0).requirement("Agility", 90).build());
        achievements.add(new AchievementBuilder("Agility 92", 0).requirement("Agility", 92).build());
        achievements.add(new AchievementBuilder("Agility 99", 0).requirement("Agility", 99).build());
        achievements.add(new AchievementBuilder("Ahrim Bobblehead", 0).requirement("Malevolent energy", 250).requirement("Ahrim's hood", 1)
            .requirement("Ahrim's robe top", 1).requirement("Ahrim's robe skirt", 1).requirement("Ahrim's staff", 1).build());
        achievements.add(new AchievementBuilder("Al Kharid", 0).build());
        achievements.add(new AchievementBuilder("Alch-aholic", 0).requirement("Magic", 55).requirement("Fire rune", 5)
            .requirement("Nature rune", 1).requirement("Magic shortbow", 1).reward("Coins", 960).reward("Magic", 65).build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Another Cook's Quest", 0.25).requirement("Cook's Assistant", 1)
            .requirement("Cooking", 10).requirement("Eye of newt", 1).requirement("Greenman's ale", 1).requirement("Coins", 1)
            .requirement("Ashes", 1).requirement("Fruit Blast", 1).reward("Quest points", 1).build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Freeing Pirate Pete", 0.25)
            .requirement("Recipe for Disaster: Another Cook's Quest", 1).requirement("Cooking", 31).requirement("Raw cod", 1)
            .requirement("Bread", 1).requirement("Fishbowl", 1).requirement("Needle", 1).requirement("Bronze wire", 3)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Mudskipper"), Collections.singletonList("Mudskipper"),
                Collections.singletonList("Mudskipper"), Collections.singletonList("Mudskipper"), Collections.singletonList("Mudskipper"))))
            .encounter(new Encounter("Crab")).reward("Quest points", 1).reward("Cooking", 1000).reward("Crafting", 1000)
            .reward("Fishing", 1000).reward("Smithing", 1000).build());
        achievements.add(new AchievementBuilder("Pirate's Treasure", 0.25).requirement("Coins", 60).reward("Quest points", 2)
            .reward("Coins", 450).reward("Emerald", 1).reward("Gold ring", 1).build());
        achievements.add(new AchievementBuilder("Zogre Flesh Eaters", 0.75).requirement("Big Chompy Bird Hunting", 1)
            .requirement("Jungle Potion", 1).requirement("Smithing", 4).requirement("Herblore", 8).requirement("Strength", 20)
            .requirement("Ranged", 30).requirement("Fletching", 30).encounter(new Encounter("Zombie (Uncharted Isles)"))
            .encounter(new Encounter("Slash Bash")).reward("Quest points", 1).reward("Ourg bones", 3).reward("Zogre bones", 2)
            .reward("Fletching", 2000).reward("Ranged", 2000).reward("Herblore", 2000).build());
        achievements.add(new AchievementBuilder("Rum Deal", 0.75).requirement("Priest in Peril", 1).requirement("Zogre Flesh Eaters", 1)
            .requirement("Farming", 40).requirement("Crafting", 42).requirement("Prayer", 47).requirement("Fishing", 50)
            .requirement("Slayer", 42).requirement("Coins", 200).encounter(new Encounter("Evil spirit"))
            .encounter(new Encounter("Fever spider", Collections.singletonList(new Restriction("Slayer gloves", 1))))
            .reward("Quest points", 2).reward("Farming", 7000).reward("Fishing", 7000).reward("Prayer", 7000).build());
        achievements.add(new AchievementBuilder("Cabin Fever", 0.75).requirement("Pirate's Treasure", 1).requirement("Rum Deal", 1)
            .requirement("Agility", 42).requirement("Crafting", 45).requirement("Smithing", 50).requirement("Ranged", 40)
            .reward("Quest points", 2).reward("Smithing", 7000).reward("Crafting", 7000).reward("Agility", 7000).reward("Coins", 10000)
            .build());
        achievements.add(new AchievementBuilder("The Great Brain Robbery", 1).requirement("Garden of Tranquility", 1)
            .requirement("Cabin Fever", 1).requirement("Recipe for Disaster: Freeing Pirate Pete", 1).requirement("Crafting", 16)
            .requirement("Construction", 30).requirement("Prayer", 50).requirement("Hammer", 1).requirement("Holy symbol", 1)
            .requirement("Bronze nails", 38).requirement("Plank", 8).requirement("Wooden cat", 10).encounter(new Encounter("Sorebones"))
            .encounter(new Encounter("Sorebones")).encounter(new Encounter("Sorebones")).encounter(new Encounter("Sorebones"))
            .encounter(new Encounter("Sorebones")).encounter(new Encounter("Barrelchest")).reward("Quest points", 2).reward("Prayer", 6000)
            .reward("Crafting", 3000).reward("Construction", 2000).lamp(Player.ALL_SKILLS, 5000, 30).build());
        achievements.add(new AchievementBuilder("Rocking Out", 2).requirement("The Great Brain Robbery", 1).requirement("Agility", 60)
            .requirement("Thieving", 63).requirement("Crafting", 66).requirement("Smithing", 69).requirement("Pirate bandana (white)", 0)
            .requirement("Pirate shirt (white)", 0).requirement("Pirate leggings (white)", 0).requirement("Bronze wire", 2)
            .requirement("Charcoal", 1).requirement("Hammer", 1).requirement("Coins", 20).encounter(new Encounter("Customs Officer",
                Collections.singletonList(new Restriction("Items", 0)))).encounter(new Encounter("Customs Officer",
                Collections.singletonList(new Restriction("Items", 0)))).reward("Quest points", 2).reward("Thieving", 25000)
            .reward("Smithing", 25000).reward("Agility", 25000).reward("Crafting", 25000).build());
        achievements.add(new AchievementBuilder("A Clockwork Syringe", 1.5).requirement("Rocking Out", 1).requirement("Dungeoneering", 50)
            .requirement("Slayer", 61).requirement("Construction", 62).requirement("Summoning", 65).requirement("Smithing", 74)
            .requirement("Thieving", 74).requirement("Defense", 76).encounter(new Encounter("Grimtern"))
            .encounter(new Encounter("Grimtern")).encounter(new Encounter("Grimtern")).encounter(new Encounter("Barrelchest Mk II"))
            .reward("Quest points", 1).reward("Defense", 19000).reward("Smithing", 18000).reward("Thieving", 18000)
            .reward("Summoning", 15000).reward("Construction", 11250).reward("Slayer", 11000).reward("Dungeoneering", 5000).build());
        achievements.add(new AchievementBuilder("Alcrabaholic", 0).requirement("A Clockwork Syringe", 1)
            .encounter(new Encounter("'Rum'-pumped crab", Arrays.asList(new Restriction("Diving apparatus", 1),
                new Restriction("Fishbowl helmet", 1)))).build());
        achievements.add(new AchievementBuilder("The Feud", 0.75).requirement("Thieving", 30).requirement("Coins", 1002)
            .requirement("Leather gloves", 0).requirement("Beer", 3).encounter(new Encounter("Bandit champion"))
            .encounter(new Encounter("Tough Guy")).reward("Quest points", 1).reward("Thieving", 15000).reward("Coins", 500)
            .reward("Adamant scimitar", 1).reward("Beer", 1).build());
        achievements.add(new AchievementBuilder("Icthlarin's Little Helper", 1.5).requirement("Diamond in the Rough", 1)
            .requirement("Gertrude's Cat", 1).requirement("The Restless Ghost", 1).requirement("Tinderbox", 1)
            .requirement("Waterskin (4)", 1).requirement("Coins", 30).requirement("Bucket", 1).encounter(new Encounter("Apmeken"))
            .encounter(new Encounter("Possessed Priest")).reward("Quest points", 2).reward("Thieving", 4500).reward("Agility", 4000)
            .reward("Woodcutting", 4000).build());
        achievements.add(new AchievementBuilder("Rogue Trader", 0.25).requirement("The Feud", 1).requirement("Icthlarin's Little Helper", 1)
            .requirement("Coins", 100).requirement("Blue dye", 3).build());
        achievements.add(new AchievementBuilder("Ali The Trader", 0).requirement("Rogue Trader", 1).build());
        achievements.add(new AchievementBuilder("All Aboard", 0).requirement("Ranged", 70)
            .encounter(new Encounter("Kree'arra")).build());
        achievements.add(new AchievementBuilder("All Abuzz", 0).requirement("Menaphite honey bee in amber", 1)
            .requirement("Pygmy giant scarab in amber", 1).requirement("Clicker kalphite in amber", 1).requirement("Fruit fly", 1)
            .requirement("Desert locust in amber", 1).requirement("Kalphite wanderer in amber", 1).requirement("Fly dragon", 1)
            .requirement("Hornless unicornfly in amber", 1).requirement("Fly dragon in amber", 1).requirement("Fruit fly in amber", 1)
            .requirement("Menaphite honey bee", 1).requirement("Pygmy giant scarab", 1).requirement("Clicker kalphite", 1)
            .requirement("Desert locust", 1).requirement("Kalphite wanderer", 1).requirement("Hornless unicornfly", 1).build());
        achievements.add(new AchievementBuilder("Mugger v. Roger Murray", 0.25).requirement("King's Ransom", 1)
            .lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning",
                "Herblore"), 2000, 1).build());
        achievements.add(new AchievementBuilder("River troll v. The People", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Shark", 20).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 3500, 1).build());
        achievements.add(new AchievementBuilder("Drunken Dwarf v. The People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 1).reward("Gold ore", 20).reward("Kebab", 1).lamp(Arrays.asList("Attack",
                "Defense", "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 5000, 1).build());
        achievements.add(new AchievementBuilder("Evil Twin v. Good Twin", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Uncut sapphire", 5).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 6500, 1).build());
        achievements.add(new AchievementBuilder("Rick Turpentine v. The (Rich) People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 1).reward("Uncut ruby", 3).lamp(Arrays.asList("Attack", "Defense",
                "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 8000, 1).build());
        achievements.add(new AchievementBuilder("The Frog Prince v. The People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 2).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("Sawmill Man v. The People", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Teak plank", 30).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("Party Pete v. His Neighbours", 0.75).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 1).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("Ernest v. Professor Oddenstein", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 1).reward("Feather", 100).reward("Red feather", 15)
            .reward("Yellow feather", 15).reward("Blue feather", 15).reward("Raw bird meat", 20).lamp(Arrays.asList("Attack", "Defense",
                "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 10000, 1).build());
        achievements.add(new AchievementBuilder("Miss Schism v. Draynor Village", 0.75).requirement("Casket", 17)
            .requirement("King's Ransom", 1).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged", "Constitution",
                "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).lamp(Player.ALL_SKILLS, -10, 1).build());
        achievements.add(new AchievementBuilder("EVIL DAVE v. The People", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged", "Constitution", "Slayer",
                "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("H.A.M v. Dorgeshuun", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Uncut ruby", 5).reward("Cave goblin wire", 100).lamp(Arrays.asList("Attack", "Defense",
                "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 15000, 1).build());
        achievements.add(new AchievementBuilder("The Sandwich Lady v. The People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 2).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("The Mime v. The People", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 2).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged", "Constitution", "Slayer",
                "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("Barbarians v. Wizards", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Dagannoth hide", 10).reward("Law rune", 50).lamp(Arrays.asList("Attack", "Defense",
                "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 20000, 1).build());
        achievements.add(new AchievementBuilder("The Gravedigger v. The People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 2).lamp(Arrays.asList("Attack", "Defense", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("All Rise", 0).requirement("Mugger v. Roger Murray", 1)
            .requirement("River troll v. The People", 1).requirement("Drunken Dwarf v. The People", 1)
            .requirement("Evil Twin v. Good Twin", 1).requirement("Rick Turpentine v. The (Rich) People", 1)
            .requirement("The Frog Prince v. The People", 1).requirement("Sawmill Man v. The People", 1)
            .requirement("Party Pete v. His Neighbours", 1).requirement("Ernest v. Professor Oddenstein", 1)
            .requirement("Miss Schism v. Draynor Village", 1).requirement("EVIL DAVE v. The People", 1)
            .requirement("H.A.M v. Dorgeshuun", 1).requirement("The Sandwich Lady v. The People", 1)
            .requirement("The Mime v. The People", 1).requirement("Barbarians v. Wizards", 1)
            .requirement("The Gravedigger v. The People", 1).build());
        achievements.add(new AchievementBuilder("All Square", 0).requirement("Pyramid top", 1).reward("Coins", 1000).build());
        achievements.add(new AchievementBuilder("All Together Now", 0).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"), Arrays.asList("Image of Yakamaru",
                "Image of Yakamaru", "Image of Yakamaru", "Image of Yakamaru")), 10)).build());
        achievements.add(new AchievementBuilder("All Your Bass...", 0).requirement("Fishing", 46).requirement("Cooking", 43)
            .reward("Bass", 1).reward("Fishing", 100).reward("Cooking", 130).build());
        achievements.add(new AchievementBuilder("Almost Made In Ardougne", 0).requirement("Yew logs", 1).requirement("Raw beef", 1)
            .requirement("Rune bar", 1).requirement("Smithing", 91).requirement("Fletching", 69).requirement("Crafting", 10)
            .reward("Rune crossbow", 1).reward("Cooking", 3).reward("Fletching", 100).reward("Smithing", 75).reward("Crafting", 15)
            .build());
        achievements.add(new AchievementBuilder("Almost as Perky as a Prawn", 0).requirement("Prawn perk", 15).build());
        achievements.add(new AchievementBuilder("Along Came A Spider I", 0).requirement("Araxxi", 5).build());
        achievements.add(new AchievementBuilder("Along Came A Spider II", 0).requirement("Araxxi", 10).build());
        achievements.add(new AchievementBuilder("Along Came A Spider III", 0).requirement("Araxxi", 25).build());
        achievements.add(new AchievementBuilder("Along Came A Spider IV", 0).requirement("Araxxi", 50).build());
        achievements.add(new AchievementBuilder("Along Came A Spider V", 0).requirement("Araxxi", 75).build());
        achievements.add(new AchievementBuilder("Along Came A Spider VI", 0).requirement("Araxxi", 100).build());
        achievements.add(new AchievementBuilder("Altar Explorer", 0.3).requirement("Runecrafting", 50).build());
        achievements.add(new AchievementBuilder("Altar-ed State", 0).requirement("The Temple at Senntisten", 1)
            .requirement("Prayer", 95).build());
        achievements.add(new AchievementBuilder("Always Be Prepared", 0).requirement("Dragon Slayer", 1).build());
        achievements.add(new AchievementBuilder("Amulet of Weedspeak", 0).requirement("Coins", 200).build());
        achievements.add(new AchievementBuilder("An Act of War", 0).requirement("Coins", 104).requirement("Regicide", 1)
            .encounter(new Encounter("Elf warrior")).reward("Bronze halberd", 1).build());
        achievements.add(new AchievementBuilder("An Teak", 0).requirement("Woodcutting", 35).build());
        achievements.add(new AchievementBuilder("And I Want It Now", 0.1).requirement("Dungeoneering floors completed", 5).build());
        achievements.add(new AchievementBuilder("And It Was THIS Big!", 0).requirement("Fishing", 25).reward("Raw pike", 1)
            .reward("Fishing", 60).build());
        achievements.add(new AchievementBuilder("Angs off my Ring", 0).requirement("Ancient elven wedding ring", 1).build());
        achievements.add(new AchievementBuilder("Animal Cruelty", 0).encounter(new Encounter(Arrays.asList(Arrays.asList("Airut",
            "Airut", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Charger", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut",
                "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger",
                "Charger", "Cormes"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut",
                "Airut"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")))).build());
        achievements.add(new AchievementBuilder("Ankle Support", 0).requirement("Do No Evil", 1).build());
        achievements.add(new AchievementBuilder("Annihilator", 0).requirement("Fate of the Gods", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Smoke nihil", "Shadow nihil", "Blood nihil", "Ice nihil"))))
            .build());
        achievements.add(new AchievementBuilder("Another String to Your Bow", 0).requirement("Flax", 5).reward("Bowstring", 5)
            .reward("Crafting", 75).build());
        achievements.add(new AchievementBuilder("Any fin is Possible", 0).requirement("Cooking", 90)
            .requirement("Dungeoneering floors completed", 1).reward("Cooking", 1153).build());
        achievements.add(new AchievementBuilder("Any Odd Chicken", 0).requirement("Ernest the Chicken", 1).build());
        achievements.add(new AchievementBuilder("The Grand Tree", 1.5).encounter(new Encounter("Black demon (The Grand Tree)"))
            .reward("Quest points", 5).reward("Agility", 7900).reward("Attack", 18400).reward("Magic", 2150).build());
        achievements.add(new AchievementBuilder("Tree Gnome Village", 0.75).requirement("Logs", 6)
            .encounter(new Encounter("Khazard warlord")).reward("Quest points", 2).reward("Attack", 11450).build());
        achievements.add(new AchievementBuilder("Monkey Madness", 2.5).requirement("The Grand Tree", 1)
            .requirement("Tree Gnome Village", 1).requirement("Gold bar", 1).requirement("Ball of wool", 1).requirement("Banana", 5)
            .encounter(new Encounter("Monkey")).encounter(new Encounter("Jungle demon")).reward("Quest points", 3).reward("Coins", 10000)
            .reward("Diamond", 3).build());
        achievements.add(new AchievementBuilder("Ape A'hollow", 0.05).requirement("Fairy Tale Part III", 1)
            .requirement("Monkey Madness", 1).requirement("Agility", 48).build());
        achievements.add(new AchievementBuilder("Arachnophagia", 0).requirement("Spider on stick (raw)", 1).requirement("Cooking", 16)
            .reward("Cooking", 80).reward("Spider on stick", 1).build());
        achievements.add(new AchievementBuilder("Arandar-bout Way", 0).requirement("Gas mask", 0).requirement("Mourner top", 0)
            .requirement("Mourner trousers", 0).requirement("Mourner boots", 0).requirement("Mourner gloves", 0)
            .requirement("Mourner cloak", 0).requirement("Regicide", 1).build());
        achievements.add(new AchievementBuilder("Impressing the Locals", 0.25).requirement("Coins", 1000).reward("Quest points", 1)
            .build());
        achievements.add(new AchievementBuilder("Arc - All Your Energies", 0).requirement("Chimes", 5000).requirement("Taijitu", 5)
            .requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Ancient Eastern Tortle Portals", 0.05).requirement("Divination", 90)
            .requirement("Ancestral energy", 100).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Bone to Pick with You", 0).requirement("Chimes", 25000)
            .requirement("Taijitu", 25).requirement("Impressing the Locals", 1).requirement("Dungeoneering token", 34000)
            .requirement("Dungeoneering", 21).requirement("Prayer", 21).build());
        achievements.add(new AchievementBuilder("Arc - Don't Crush My Memories", 0).requirement("Chimes", 5000)
            .requirement("Taijitu", 5).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Flippers", 0).requirement("Impressing the Locals", 1)
            .requirement("Raw tarpon", 1).build());
        achievements.add(new AchievementBuilder("Arc - Mitts and Waders - Death Lotus", 0).requirement("Chimes", 5000)
            .requirement("Taijitu", 6).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Mitts and Waders - Seasinger", 0).requirement("Chimes", 5000)
            .requirement("Taijitu", 6).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Mitts and Waders - Tetsu", 0).requirement("Chimes", 5000)
            .requirement("Taijitu", 6).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Birds of the Arc", 0).requirement("Arc birds", 16).build());
        achievements.add(new AchievementBuilder("Berries of the Arc", 0).requirement("Arc berries", 16).reward("Farming", 50000)
            .build());
        achievements.add(new AchievementBuilder("Arc - Rewards", 0).requirement("Impressing the Locals", 1)
            .requirement("Birds of the Arc", 1).requirement("Berries of the Arc", 1).requirement("Kami", 16).reward("Hunter", 50000)
            .build());
        achievements.add(new AchievementBuilder("Arc - Unlocking More Waiko", 0).requirement("Sojobo contract guru", 1)
            .requirement("Ancestral Divination I", 1).requirement("Ancestral Divination II", 1).requirement("Ancestral Conversion", 1)
            .requirement("Spirit dragon pet", 1).requirement("Idol crabletine pet", 1).requirement("Gu ronin outfit", 1)
            .requirement("Death lotus rogue outfit", 1).requirement("Seasinger acolyte outfit", 1).requirement("Hunter outfit", 1)
            .requirement("Hanto outfit", 1).requirement("Thalassia's Revenge", 1).requirement("Chimes", 25000).requirement("Taijitu", 50)
            .requirement("Rage of Hyu-ji", 1).build());
        achievements.add(new AchievementBuilder("Whale's Maw Camp Fire", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 500).build());
        achievements.add(new AchievementBuilder("Whale's Maw Deposit Box", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 750).build());
        achievements.add(new AchievementBuilder("Arc journal teletabs", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 1000).build());
        achievements.add(new AchievementBuilder("Crystal tool siphon blueprint", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 5000).requirement("Taijitu", 5).build());
        achievements.add(new AchievementBuilder("Waiko Grill", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 500).build());
        achievements.add(new AchievementBuilder("Arc - Unlocking Waiko", 0).requirement("Waiko Grill", 1)
            .requirement("Whale's Maw Camp Fire", 1).requirement("Whale's Maw Deposit Box", 1).requirement("Arc journal teletabs", 1)
            .requirement("Crystal tool siphon blueprint", 1).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Supplies cost reduction 1", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 3000).requirement("Taijitu", 3).build());
        achievements.add(new AchievementBuilder("Supplies cost reduction 2", 0).requirement("Chimes", 3000).requirement("Taijitu", 3)
            .requirement("Supplies cost reduction 1", 1).build());
        achievements.add(new AchievementBuilder("Supplies cost reduction 3", 0).requirement("Chimes", 3000).requirement("Taijitu", 3)
            .requirement("Supplies cost reduction 2", 1).build());
        achievements.add(new AchievementBuilder("Supplies cost reduction 4", 0).requirement("Chimes", 3000).requirement("Taijitu", 3)
            .requirement("Supplies cost reduction 3", 1).build());
        achievements.add(new AchievementBuilder("Supplies cost reduction 5", 0).requirement("Chimes", 3000).requirement("Taijitu", 3)
            .requirement("Supplies cost reduction 4", 1).build());
        achievements.add(new AchievementBuilder("Supplies cap increase 1", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 2000).requirement("Taijitu", 2).build());
        achievements.add(new AchievementBuilder("Supplies cap increase 2", 0).requirement("Chimes", 2000).requirement("Taijitu", 2)
            .requirement("Supplies cap increase 1", 1).build());
        achievements.add(new AchievementBuilder("Supplies cap increase 3", 0).requirement("Chimes", 2000).requirement("Taijitu", 2)
            .requirement("Supplies cap increase 2", 1).build());
        achievements.add(new AchievementBuilder("Supplies cap increase 4", 0).requirement("Chimes", 2000).requirement("Taijitu", 2)
            .requirement("Supplies cap increase 3", 1).build());
        achievements.add(new AchievementBuilder("Contracts per day increase 1", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 2500).requirement("Taijitu", 2).build());
        achievements.add(new AchievementBuilder("Contracts per day increase 2", 0).requirement("Chimes", 2500)
            .requirement("Taijitu", 2).requirement("Contracts per day increase 1", 1).build());
        achievements.add(new AchievementBuilder("Contracts per day increase 3", 0).requirement("Chimes", 2500)
            .requirement("Taijitu", 2).requirement("Contracts per day increase 2", 1).build());
        achievements.add(new AchievementBuilder("Contracts per day increase 4", 0).requirement("Chimes", 2500)
            .requirement("Taijitu", 2).requirement("Contracts per day increase 3", 1).build());
        achievements.add(new AchievementBuilder("Commodity sell per day increase 1", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 1500).requirement("Taijitu", 1).build());
        achievements.add(new AchievementBuilder("Commodity sell per day increase 2", 0).requirement("Chimes", 1500)
            .requirement("Taijitu", 1).requirement("Commodity sell per day increase 1", 1).build());
        achievements.add(new AchievementBuilder("Commodity sell price increase 1", 0).requirement("Impressing the Locals", 1)
            .requirement("Chimes", 8000).requirement("Taijitu", 8).build());
        achievements.add(new AchievementBuilder("Commodity sell price increase 2", 0).requirement("Chimes", 8000)
            .requirement("Taijitu", 8).requirement("Commodity sell price increase 1", 1).build());
        achievements.add(new AchievementBuilder("Arc - Upgrading All of the Waiko", 0)
            .requirement("Commodity sell per day increase 2", 1).requirement("Supplies cap increase 4", 1)
            .requirement("Contracts per day increase 4", 1).requirement("Supplies cost reduction 5", 1)
            .requirement("Commodity sell price increase 2", 1).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Upgrading Waiko", 0).requirement("Commodity sell per day increase 1", 1)
            .requirement("Supplies cap increase 1", 1).requirement("Contracts per day increase 1", 1)
            .requirement("Supplies cost reduction 1", 1).requirement("Commodity sell price increase 1", 1)
            .requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Mushrooms of the Arc", 0).requirement("Arc mushrooms", 17).build());
        achievements.add(new AchievementBuilder("Kami Spirits of the Arc", 0).requirement("Kami", 16).reward("Hunter", 50000)
            .build());
        achievements.add(new AchievementBuilder("Castaways of the Arc", 0).requirement("Arc castaways", 10).build());
        achievements.add(new AchievementBuilder("Arc I - Flag Fall", 0.5).requirement("Impressing the Locals", 1)
            .reward("Chimes", 500).reward("Taijitu", 2).build());
        achievements.add(new AchievementBuilder("Arc II - Head of the Family", 0.75).requirement("Impressing the Locals", 1)
            .requirement("Fish oil", 15).requirement("Woodcutting", 90).requirement("Fishing", 90).requirement("Cooking", 91)
            .requirement("Chimes", 450).requirement("Bamboo", 5)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Cap'n Ekahi", "Cyclops labourer", "Cyclops labourer"))))
            .reward("Chimes", 1300).reward("Fish oil", 30).reward("Bundle of bamboo", 4).reward("Taijitu", 5)
            .lamp(Collections.singletonList("Agility"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc III - Spiritual Enlightenment", 0.75)
            .requirement("Impressing the Locals", 1).requirement("Meet the Assassin", 1).requirement("Slayer", 90)
            .requirement("The Path of the Monk", 1).requirement("The Path of the Elemental", 1).requirement("The Path of the Dragon", 1)
            .reward("Chimes", 250).reward("Taijitu", 3).lamp(Collections.singletonList("Slayer"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc IV - Jed Hunter", 0.25).requirement("Arc I - Flag Fall", 1)
            .requirement("Arc III - Spiritual Enlightenment", 1).requirement("Arc II - Head of the Family", 1).requirement("Hunter", 90)
            .requirement("Crafting", 91).requirement("Driftwood", 10).requirement("Sea shell", 5).requirement("Shell chippings", 8)
            .requirement("Taijitu", 1).requirement("Chimes", 200).encounter(new Encounter("Gu ronin")).encounter(new Encounter("Gu ronin"))
            .encounter(new Encounter("Gu ronin")).reward("Chimes", 2000).reward("Taijitu", 10).reward("Crafting", 150)
            .lamp(Collections.singletonList("Hunter"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc V - Eye for an Eye", 0.25).requirement("Arc IV - Jed Hunter", 1)
            .requirement("Mining", 90).requirement("Sea salt", 30)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops"),
                Arrays.asList("Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops",
                    "Zyclops"), Arrays.asList("Zyclops", "Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops", "Zyclops", "Zyclops"),
                Arrays.asList("Zyclops", "Zyclops", "Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops", "Zyclops", "Zyclops"))))
            .reward("Chimes", 250).reward("Taijitu", 1).reward("Alalea sea salt", 25).lamp(Collections.singletonList("Prayer"), -3, 1)
            .build());
        achievements.add(new AchievementBuilder("Arc VI - Harbinger of Doom", 0.25).requirement("Arc V - Eye for an Eye", 1)
            .reward("Chimes", 250).reward("Taijitu", 2).lamp(Collections.singletonList("Construction"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc VII - Tuai Leit's Own", 0.5).requirement("Arc VI - Harbinger of Doom", 1)
            .requirement("Farming", 86).requirement("Divination", 90).requirement("Rumberry", 30).requirement("Positive energy", 30)
            .requirement("Spirit dragon charm", 1).reward("Chimes", 500).reward("Taijitu", 2).reward("Rumberry", 50)
            .reward("Ancestral energy", 50).build());
        achievements.add(new AchievementBuilder("Arc VIII - Ghosts from the Past", 0.25).requirement("Arc VI - Harbinger of Doom", 1)
            .reward("Chimes", 500).reward("Taijitu", 2).lamp(Arrays.asList("Agility", "Herblore", "Fishing", "Thieving", "Cooking",
                "Prayer", "Runecrafting", "Slayer", "Construction", "Hunter", "Dungeoneering", "Divination"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc IX - Damage Control", 0.25).requirement("Arc VI - Harbinger of Doom", 1)
            .requirement("Chimes", 2500).reward("Chimes", 3000).reward("Taijitu", 2).lamp(Collections.singletonList("Thieving"), -3, 1)
            .build());
        achievements.add(new AchievementBuilder("Arc X - Final Destination", 0.25).requirement("Arc VII - Tuai Leit's Own", 1)
            .requirement("Arc IX - Damage Control", 1).requirement("Arc VIII - Ghosts from the Past", 1)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Zyclops cannoneer", "Zyclops cannoneer", "Zyclops cannoneer"),
                Arrays.asList("Zombie (Uncharted Isles)", "Zombie (Uncharted Isles)", "Zombie (Uncharted Isles)",
                    "Zombie (Uncharted Isles)", "Zombie (Uncharted Isles)", "Zombie (Uncharted Isles)"),
                Arrays.asList("Skeleton (Uncharted Isles)", "Skeleton (Uncharted Isles)"), Arrays.asList("Zyclops (Final Destination)",
                    "Zyclops (Final Destination)")))).reward("Chimes", 2000).reward("Taijitu", 10)
            .lamp(Arrays.asList("Attack", "Constitution", "Defense", "Strength", "Ranged", "Prayer", "Magic", "Summoning"), -4, 1).build());
        achievements.add(new AchievementBuilder("Wushanko Isles: The Arc", 0).requirement("Birds of the Arc", 1)
            .requirement("Mushrooms of the Arc", 1).requirement("Berries of the Arc", 1).requirement("Kami Spirits of the Arc", 1)
            .requirement("Castaways of the Arc", 1).requirement("Arc I - Flag Fall", 1).requirement("Arc II - Head of the Family", 1)
            .requirement("Arc III - Spiritual Enlightenment", 1).requirement("Arc IV - Jed Hunter", 1)
            .requirement("Arc V - Eye for an Eye", 1).requirement("Arc VI - Harbinger of Doom", 1)
            .requirement("Arc VII - Tuai Leit's Own", 1).requirement("Arc VIII - Ghosts from the Past", 1)
            .requirement("Arc IX - Damage Control", 1).requirement("Arc X - Final Destination", 1).build());
        achievements.add(new AchievementBuilder("Arc - Salty", 0).requirement("Wushanko Isles: The Arc", 1)
            .requirement("Arc - Unlocking More Waiko", 1).requirement("Arc - Upgrading All of the Waiko", 1)
            .requirement("Arc - Ancient Eastern Tortle Portals", 1).requirement("Arc - Flippers", 1)
            .requirement("Arc - Mitts and Waders - Death Lotus", 1).requirement("Arc - All Your Energies", 1)
            .requirement("Arc - Mitts and Waders - Tetsu", 1).requirement("Arc - Unlocking Waiko", 1)
            .requirement("Arc - Mitts and Waders - Seasinger", 1).requirement("Arc - Rewards", 1)
            .requirement("Arc - Don't Crush My Memories", 1).requirement("Arc - Bone to Pick with You", 1).build());
        achievements.add(new AchievementBuilder("Arch Archer", 0).requirement("Archery ticket", -1000).requirement("Ranged", 40)
            .build());
        achievements.add(new AchievementBuilder("Ardougne", 0).build());
        achievements.add(new AchievementBuilder("Ardougne Express", 0).requirement("Plague City", 1).requirement("Magic", 51)
            .requirement("Law rune", 2).requirement("Water rune", 2).reward("Magic", 61).build());
        achievements.add(new AchievementBuilder("Tower of Life", 1).requirement("Construction", 10).requirement("Coins", 2)
            .reward("Quest points", 2).reward("Construction", 1000).reward("Crafting", 500).reward("Thieving", 500).build());
        achievements.add(new AchievementBuilder("Creator and Destroyer", 0).requirement("Tower of Life", 1).requirement("Cowhide", 1)
            .requirement("Unicorn horn", 1).encounter(new Encounter("Unicow")).build());
        achievements.add(new AchievementBuilder("Yoink!", 0).requirement("Thieving", 5).build());
        achievements.add(new AchievementBuilder("Vial Deeds", 0).requirement("Coins", 10).reward("Vial of water", 1).build());
        achievements.add(new AchievementBuilder("They're Long and Pointy", 0).build());
        achievements.add(new AchievementBuilder("The Essence of Magic", 0).build());
        achievements.add(new AchievementBuilder("Star Seeker", 0).build());
        achievements.add(new AchievementBuilder("Silky Smooth", 0).requirement("Silk", 1).build());
        achievements.add(new AchievementBuilder("Red Revolution", 0).requirement("Plague City", 1).build());
        achievements.add(new AchievementBuilder("Preaching to the Infected", 0).requirement("Plague City", 1).build());
        achievements.add(new AchievementBuilder("Playing the Waiting Game", 0).build());
        achievements.add(new AchievementBuilder("Monk's Friend", 0.25).requirement("Jug of water", 1).requirement("Logs", 1)
            .reward("Quest points", 1).reward("Law rune", 8).reward("Woodcutting", 2000).build());
        achievements.add(new AchievementBuilder("Party Pooper", 0).requirement("Monk's Friend", 1).build());
        achievements.add(new AchievementBuilder("P-P-P-Pick Up Some Prizes", 0).requirement("Penguin point", 1).build());
        achievements.add(new AchievementBuilder("No Time to Lose", 0).requirement("Ring of duelling (8)", 1).build());
        achievements.add(new AchievementBuilder("Gone Fishing", 0).requirement("Fishing", 15).build());
        achievements.add(new AchievementBuilder("Going on a Summer Holiday", 0).requirement("Coins", 30).build());
        achievements.add(new AchievementBuilder("Dukes of Khazard", 0).encounter(new Encounter("Gnome troop")).build());
        achievements.add(new AchievementBuilder("Don't Eat the Pointy Bit", 0).requirement("Coins", 25)
            .reward("Skewered kebab", 1).build());
        achievements.add(new AchievementBuilder("Breaking and Entering", 0).requirement("Thieving", 16).build());
        achievements.add(new AchievementBuilder("Boot Camp", 0).requirement("Biohazard", 1).build());
        achievements.add(new AchievementBuilder("Bargain Hunter", 0).build());
        achievements.add(new AchievementBuilder("Are You Being Served?", 0).build());
        achievements.add(new AchievementBuilder("Ardougne Set Tasks - Easy", 0).requirement("Yoink!", 1)
            .requirement("The Essence of Magic", 1).requirement("Silky Smooth", 1).requirement("Preaching to the Infected", 1)
            .requirement("Playing the Waiting Game", 1).requirement("Gone Fishing", 1).requirement("Boot Camp", 1)
            .requirement("A Cat is for Life...", 1).requirement("Creator and Destroyer", 1).requirement("Red Revolution", 1)
            .requirement("Going on a Summer Holiday", 1).requirement("Breaking and Entering", 1).requirement("P-P-P-Pick Up Some Prizes", 1)
            .requirement("A Gift from Khazard", 1).requirement("Party Pooper", 1).requirement("Vial Deeds", 1).requirement("Star Seeker", 1)
            .requirement("Dukes of Khazard", 1).requirement("Don't Eat the Pointy Bit", 1).requirement("Bargain Hunter", 1)
            .requirement("Are You Being Served?", 1).requirement("No Time to Lose", 1).requirement("They're Long and Pointy", 1)
            .lamp(Player.ALL_SKILLS, 1000, 25).build());
        achievements.add(new AchievementBuilder("You Could Just Knock", 0).requirement("Thieving", 82).build());
        achievements.add(new AchievementBuilder("Honestly, It's Not a Purse", 0).requirement("Giant pouch", 1)
            .requirement("Pure essence", 1).build());
        achievements.add(new AchievementBuilder("Catching Some Rays", 0.2).requirement("Fishing", 81).requirement("Swamp paste", 200)
            .requirement("Bucket", 10).requirement("Rope", 10).reward("Raw manta ray", 1).reward("Fishing", 40).build());
        achievements.add(new AchievementBuilder("Ardougne Set Tasks - Elite", 0).requirement("Catching Some Rays", 1)
            .requirement("Abyssal Valet", 1).requirement("You Could Just Knock", 1).requirement("Honestly, It's Not a Purse", 1)
            .requirement("Almost Made In Ardougne", 1).lamp(Player.ALL_SKILLS, 50000, 85).lamp(Player.ALL_SKILLS, 50000, 85)
            .lamp(Player.ALL_SKILLS, 50000, 85).lamp(Player.ALL_SKILLS, 50000, 85).build());
        achievements.add(new AchievementBuilder("You're the Dirty Rascal", 0.35).build());
        achievements.add(new AchievementBuilder("Who Wants to Watch the Watchtower?", 0).requirement("Watchtower", 1)
            .requirement("Magic", 58).requirement("Law rune", 2).requirement("Earth rune", 2).reward("Magic", 68).build());
        achievements.add(new AchievementBuilder("Vine-detta", 0.05).requirement("Back to my Roots", 1)
            .encounter(new Encounter("Wild jade vine")).build());
        achievements.add(new AchievementBuilder("Shadow Boxing", 0).requirement("Legends' Quest", 1)
            .encounter(new Encounter("Shadow warrior")).build());
        achievements.add(new AchievementBuilder("Ourania Mania", 0).requirement("Lunar Diplomacy", 1).requirement("Law rune", 1)
            .requirement("Earth rune", 6).requirement("Astral rune", 2).reward("Magic", 69).build());
        achievements.add(new AchievementBuilder("Not on My Watch", 0).requirement("Thieving", 65).requirement("Hunter", 54)
            .requirement("Gloves of silence", 1).reward("Coins", 60).reward("Bread", 1).reward("Thieving", 138).build());
        achievements.add(new AchievementBuilder("Nice View", 0).requirement("Magic", 66).build());
        achievements.add(new AchievementBuilder("Monkey Business", 0).requirement("Agility", 57).build());
        achievements.add(new AchievementBuilder("Living on a Prayer", 0).requirement("Music tracks", 500).build());
        achievements.add(new AchievementBuilder("Just Like That", 0).requirement("Magic", 66).build());
        achievements.add(new AchievementBuilder("It's My Newt", 0).requirement("Hunter", 59).requirement("Small fishing net", 1)
            .requirement("Rope", 1).reward("Rope", 1).reward("Small fishing net", 1).reward("Red salamander", 1).reward("Hunter", 272)
            .build());
        achievements.add(new AchievementBuilder("It Just Croaked", 0).requirement("Tower of Life", 1).requirement("Raw cave eel", 1)
            .requirement("Giant frog legs", 1).encounter(new Encounter("Frogeel")).build());
        achievements.add(new AchievementBuilder("Get Your Stinking Hands Off Me", 0).requirement("Monkey Madness", 1).build());
        achievements.add(new AchievementBuilder("Brace Yourself", 0).requirement("Legends' Quest", 1)
            .requirement("Combat bracelet", 1).build());
        achievements.add(new AchievementBuilder("Blood Bank Withdrawal", 0).requirement("Thieving", 59).build());
        achievements.add(new AchievementBuilder("Artillery Strike", 0).requirement("Catapult Construction", 1).build());
        achievements.add(new AchievementBuilder("Ardougne Set Tasks - Hard", 0).requirement("Brace Yourself", 1)
            .requirement("Shadow Boxing", 1).requirement("Just Like That", 1).requirement("Nice View", 1)
            .requirement("You're the Dirty Rascal", 1).requirement("Ourania Mania", 1).requirement("Not on My Watch", 1)
            .requirement("It Just Croaked", 1).requirement("Get Your Stinking Hands Off Me", 1).requirement("Vine-detta", 1)
            .requirement("Living on a Prayer", 1).requirement("Who Wants to Watch the Watchtower?", 1).requirement("Monkey Business", 1)
            .requirement("It's My Newt", 1).requirement("A Taste of the Exotic", 1).requirement("Blood Bank Withdrawal", 1)
            .requirement("Artillery Strike", 1).lamp(Player.ALL_SKILLS, 28000, 60).build());
        achievements.add(new AchievementBuilder("What, a Melon?", 0.05).requirement("Watermelon seed", 3).requirement("Farming", 47)
            .reward("Watermelon", 3).reward("Farming", 212).build());
        achievements.add(new AchievementBuilder("Water Logged", 0).requirement("Agility", 33).build());
        achievements.add(new AchievementBuilder("Volatile Valuables", 0.05).requirement("Kennith's Concerns", 1)
            .reward("Coins", 10).reward("Mining", 17).build());
        achievements.add(new AchievementBuilder("The Coal Train", 0).requirement("Mining", 30).reward("Mining", 50)
            .reward("Coal", 1).build());
        achievements.add(new AchievementBuilder("Sandy's Secret Getaway", 0).requirement("Agility", 39).requirement("Ranged", 21)
            .requirement("Strength", 38).requirement("Mithril grapple", 1).build());
        achievements.add(new AchievementBuilder("Meeting History", 0.75).requirement("Making History", 1)
            .requirement("Druidic Ritual", 1).reward("Quest points", 1).lamp(Player.ALL_SKILLS, 1000, 25).lamp(Player.ALL_SKILLS, 1000, 25)
            .lamp(Player.ALL_SKILLS, 500, 25).build());
        achievements.add(new AchievementBuilder("Meeting History, Again", 0).requirement("Meeting History", 1).build());
        achievements.add(new AchievementBuilder("I Wonder What This Does", 0).build());
        achievements.add(new AchievementBuilder("I Know a Shortcut", 0).requirement("Pure essence", 1).build());
        achievements.add(new AchievementBuilder("Green Fingers", 0).requirement("Thieving", 38).reward("Thieving", 43).build());
        achievements.add(new AchievementBuilder("Fearless Fishing", 0).requirement("Sea Slug", 1).build());
        achievements.add(new AchievementBuilder("The Hand in the Sand", 0.75).requirement("Thieving", 17).requirement("Crafting", 49)
            .requirement("Coins", 2).requirement("Bucket", 1).requirement("Lantern lens", 1).requirement("Earth rune", 5)
            .requirement("Vial", 1).requirement("Redberries", 1).requirement("White berries", 1).reward("Quest points", 1)
            .reward("Thieving", 1000).reward("Crafting", 9000).build());
        achievements.add(new AchievementBuilder("By the Bucketload", 0).requirement("The Hand in the Sand", 1)
            .reward("Bucket of sand", 84).build());
        achievements.add(new AchievementBuilder("Enlightened Journey", 0.75).requirement("Quest points", 21)
            .requirement("Firemaking", 20).requirement("Farming", 30).requirement("Crafting", 36).requirement("Logs", 10)
            .requirement("Papyrus", 3).requirement("Ball of wool", 1).requirement("Candle", 1).requirement("Yellow dye", 1)
            .requirement("Red dye", 1).requirement("Empty sack", 9).requirement("Silk", 10).requirement("Bowl", 1)
            .requirement("Willow branch", 12).reward("Quest points", 1).reward("Crafting", 2000).reward("Farming", 3000)
            .reward("Woodcutting", 1500).reward("Firemaking", 4000).build());
        achievements.add(new AchievementBuilder("Castle Wars balloon route", 0.05).requirement("Enlightened Journey", 1)
            .requirement("Firemaking", 50).requirement("Yew logs", 10).reward("Firemaking", 2000).build());
        achievements.add(new AchievementBuilder("Arriving in Style", 0).requirement("Castle Wars balloon route", 1)
            .requirement("Yew logs", 1).build());
        achievements.add(new AchievementBuilder("Are You Chicken?", 0).requirement("Tower of Life", 1).requirement("Raw chicken", 1)
            .requirement("Raw swordfish", 1).encounter(new Encounter("Swordchick")).build());
        achievements.add(new AchievementBuilder("Ardougne Set Tasks - Medium", 0).requirement("A Visit to Charlie", 1)
            .requirement("I Wonder What This Does", 1).requirement("Sandy's Secret Getaway", 1).requirement("I Know a Shortcut", 1)
            .requirement("Volatile Valuables", 1).requirement("What, a Melon?", 1).requirement("Ardougne Express", 1)
            .requirement("Arriving in Style", 1).requirement("By the Bucketload", 1).requirement("Meeting History, Again", 1)
            .requirement("Fearless Fishing", 1).requirement("Water Logged", 1).requirement("Green Fingers", 1)
            .requirement("A Natural Thief", 1).requirement("The Coal Train", 1).requirement("Are You Chicken?", 1)
            .lamp(Player.ALL_SKILLS, 7500, 45).build());
        achievements.add(new AchievementBuilder("Are Yew As Fired Up As I Am?", 0).requirement("Yew logs", 1)
            .requirement("Firemaking", 60).reward("Firemaking", 202).build());
        achievements.add(new AchievementBuilder("Are You Needing Access?", 0).requirement("Do No Evil", 1)
            .requirement("Agility", 80).reward("Agility", 20000).build());
        achievements.add(new AchievementBuilder("Arise from the Ash", 0).requirement("In Pyre Need", 1).requirement("Phoenix Lair", 1)
            .build());
        achievements.add(new AchievementBuilder("Crafting Guild balloon route", 0.05).requirement("Enlightened Journey", 1)
            .requirement("Firemaking", 30).requirement("Oak logs", 10).reward("Firemaking", 2000).build());
        achievements.add(new AchievementBuilder("Varrock balloon route", 0.05).requirement("Enlightened Journey", 1)
            .requirement("Firemaking", 40).requirement("Willow logs", 10).reward("Firemaking", 2000).build());
        achievements.add(new AchievementBuilder("Grand Tree balloon route", 0.05).requirement("Enlightened Journey", 1)
            .requirement("Firemaking", 60).requirement("Magic logs", 3).reward("Firemaking", 2000).build());
        achievements.add(new AchievementBuilder("Around the World in Six Ways", 0).requirement("Crafting Guild balloon route", 1)
            .requirement("Varrock balloon route", 1).requirement("Castle Wars balloon route", 1).requirement("Grand Tree balloon route", 1)
            .build());
        achievements.add(new AchievementBuilder("Artisan Crafting", 0).requirement("Clay ring (unfired)", 1)
            .requirement("Crafting", 4).reward("Clay ring", 1).reward("Crafting", 11).build());
        achievements.add(new AchievementBuilder("As Good As Renew", 0.1).requirement("Farming", 91).requirement("Herblore", 94)
            .requirement("Fellstalk seed", 1).requirement("Morchella mushroom spore", 1).reward("Farming", 1400).reward("Herblore", 190)
            .reward("Prayer renewal (3)", 1).build());
        achievements.add(new AchievementBuilder("As Taxed as a Yak", 0).requirement("The Fremennik Isles", 1)
            .requirement("Coins", 5000).build());
        achievements.add(new AchievementBuilder("As Clear as a Crystal Seed", 0).requirement("Within the Light", 1).build());
        achievements.add(new AchievementBuilder("In Search of the Myreque", 0.25).requirement("Nature Spirit", 1)
            .requirement("Agility", 25).requirement("Steel longsword", 1).requirement("Steel sword", 2).requirement("Steel mace", 1)
            .requirement("Steel warhammer", 1).requirement("Steel dagger", 1).requirement("Steel nails", 75).requirement("Plank", 6)
            .requirement("Mort myre stem", 3).encounter(new Encounter("Skeleton Hellhound")).reward("Quest points", 2)
            .reward("Uncut ruby", 2).reward("Big bones", 4).lamp(Collections.singletonList("Attack"), 600, 4)
            .lamp(Collections.singletonList("Defense"), 600, 4).lamp(Collections.singletonList("Strength"), 600, 4)
            .lamp(Collections.singletonList("Constitution"), 600, 4).lamp(Collections.singletonList("Crafting"), 600, 4).build());
        achievements.add(new AchievementBuilder("In Aid of the Myreque", 1.5).requirement("In Search of the Myreque", 1)
            .requirement("Crafting", 25).requirement("Magic", 7).requirement("Mining", 15).requirement("Sardine", 1)
            .requirement("Bucket", 0).requirement("Plank", 11).requirement("Bronze nails", 44).requirement("Bronze hatchet", 10)
            .requirement("Raw mackerel", 10).requirement("Tinderbox", 3).requirement("Steel bar", 2).requirement("Coal", 1)
            .requirement("Soft clay", 1).requirement("Silver bar", 1).requirement("Mithril bar", 1).requirement("Sapphire", 1)
            .requirement("Cosmic rune", 1).requirement("Water rune", 1).requirement("Rope", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Gadderanks"),
                Arrays.asList("Vampyre Juvinate (In Aid of the Myreque A)", "Vampyre Juvinate (In Aid of the Myreque B)")),
                Collections.singletonList(new Restriction("Wolfbane", 1))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Vampyre Juvinate (In Aid of the Myreque C)",
                "Vampyre Juvinate (In Aid of the Myreque C)")), Collections.singletonList(new Restriction("Wolfbane", 1))))
            .reward("Quest points", 2).lamp(Collections.singletonList("Attack"), 2000, 12)
            .lamp(Collections.singletonList("Strength"), 2000, 12).lamp(Collections.singletonList("Crafting"), 2000, 12)
            .lamp(Collections.singletonList("Defense"), 2000, 12).build());
        achievements.add(new AchievementBuilder("Darkness of Hallowvale", 2.5).requirement("In Aid of the Myreque", 1)
            .requirement("Construction", 5).requirement("Mining", 20).requirement("Thieving", 22).requirement("Agility", 26)
            .requirement("Crafting", 32).requirement("Magic", 33).requirement("Strength", 40).requirement("Bronze nails", 8)
            .requirement("Plank", 2).reward("Quest points", 2).reward("Agility", 7000).reward("Thieving", 6000).reward("Construction", 2000)
            .lamp(Player.ALL_SKILLS, 2000, 30).lamp(Player.ALL_SKILLS, 2000, 30).lamp(Player.ALL_SKILLS, 2000, 30).build());
        achievements.add(new AchievementBuilder("Legacy of Seergaze", 2).requirement("Darkness of Hallowvale", 1)
            .requirement("Construction", 20).requirement("Agility", 29).requirement("Slayer", 31).requirement("Mining", 35)
            .requirement("Firemaking", 40).requirement("Crafting", 47).requirement("Magic", 49).requirement("Teak pyre logs", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Fistandantilus", "Zaromark Sliver"))))
            .encounter(new Encounter("Vyrewatch", Collections.singletonList(new Restriction("Ivandis flail", 1))))
            .reward("Quest points", 2).reward("Magic", 3000).reward("Agility", 2000).reward("Crafting", 4000).reward("Mining", 2000)
            .reward("Construction", 1000).reward("Slayer", 2000).reward("Blood talisman", 1).lamp(Player.ALL_SKILLS, 2500, 35)
            .lamp(Player.ALL_SKILLS, 2500, 35).lamp(Player.ALL_SKILLS, 2500, 35).build());
        achievements.add(new AchievementBuilder("As You Might Expect", 0).requirement("Pure essence", 1)
            .requirement("Runecrafting", 77).requirement("Blood talisman", 0).requirement("Legacy of Seergaze", 1).reward("Blood rune", 1)
            .reward("Runecrafting", 10).build());
        achievements.add(new AchievementBuilder("Ashdale", 0).build());
        achievements.add(new AchievementBuilder("Assassin's Feed", 0).requirement("Diamond in the Rough", 1).build());
        achievements.add(new AchievementBuilder("Astronomical!", 0).requirement("Pure essence", 28).requirement("Runecrafting", 82)
            .reward("Astral rune", 56).reward("Runecrafting", 243).build());
        achievements.add(new AchievementBuilder("At Home on the Range", 0).requirement("Combat bracelet (4)", 1)
            .reward("Combat bracelet", 1).build());
        achievements.add(new AchievementBuilder("At Least It Doesn't Need Walking", 0).requirement("Fishing", 10)
            .requirement("Fishbowl", 1).requirement("Seaweed", 1).requirement("Coins", 10).reward("Fishing", 1).build());
        achievements.add(new AchievementBuilder("At One With Nature", 0).requirement("Runecrafting", 44)
            .requirement("Nature talisman", 0).requirement("Pure essence", 1).reward("Runecrafting", 9).reward("Nature rune", 1).build());
        achievements.add(new AchievementBuilder("At One Plus Fifty-Five With Nature", 0).requirement("Runecrafting", 91)
            .requirement("Nature talisman", 0).requirement("Pure essence", 28).reward("Runecrafting", 252).reward("Nature rune", 56)
            .build());
        achievements.add(new AchievementBuilder("Attack - Sifu", 0).requirement("Sifu", 1).build());
        achievements.add(new AchievementBuilder("Attack 5", 0).requirement("Attack", 5).build());
        achievements.add(new AchievementBuilder("Attack 10", 0).requirement("Attack", 10).build());
        achievements.add(new AchievementBuilder("Attack 20", 0).requirement("Attack", 20).build());
        achievements.add(new AchievementBuilder("Attack 30", 0).requirement("Attack", 30).build());
        achievements.add(new AchievementBuilder("Attack 40", 0).requirement("Attack", 40).build());
        achievements.add(new AchievementBuilder("Attack 50", 0).requirement("Attack", 50).build());
        achievements.add(new AchievementBuilder("Attack 60", 0).requirement("Attack", 60).build());
        achievements.add(new AchievementBuilder("Attack 70", 0).requirement("Attack", 70).build());
        achievements.add(new AchievementBuilder("Attack 80", 0).requirement("Attack", 80).build());
        achievements.add(new AchievementBuilder("Attack 90", 0).requirement("Attack", 90).build());
        achievements.add(new AchievementBuilder("Attack 92", 0).requirement("Attack", 92).build());
        achievements.add(new AchievementBuilder("Attack 99", 0).requirement("Attack", 99).build());
        achievements.add(new AchievementBuilder("Ava", 0).requirement("Avaryss' braid", 1).build());
        achievements.add(new AchievementBuilder("Avast Ardougne!", 0).requirement("Coins", 30).build());
        achievements.add(new AchievementBuilder("Away with the Kalphites", 0).requirement("Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("The Graceful Barbarian", 0).requirement("Bar Crawl", 1).requirement("Agility", 35)
            .reward("Agility", 174).build());
        achievements.add(new AchievementBuilder("Runes on the Moon", 0).requirement("Lunar Diplomacy", 1).requirement("Mining", 60)
            .reward("Pure essence", 1).reward("Mining", 5).build());
        achievements.add(new AchievementBuilder("Pyre At Will", 0).requirement("Crafting", 52).requirement("Firemaking", 52)
            .requirement("Arctic pine logs", 1).requirement("Barbarian Firemaking", 1).reward("Crafting", 31).reward("Firemaking", 125)
            .build());
        achievements.add(new AchievementBuilder("How To Maim Your Dragon", 0).requirement("Barbarian Firemaking", 1)
            .encounter(new Encounter("Mithril dragon")).build());
        achievements.add(new AchievementBuilder("Barbarian Fishing", 0.05).requirement("Barbarian Firemaking", 1)
            .requirement("Fishing", 55).requirement("Strength", 35).requirement("Agility", 15).build());
        achievements.add(new AchievementBuilder("Fish Fingers", 0).requirement("Strength", 35).requirement("Fishing", 55)
            .requirement("Barbarian Fishing", 1).reward("Fishing", 80).reward("Raw tuna", 1).build());
        achievements.add(new AchievementBuilder("Easy As Pie", 0).requirement("Lunar Diplomacy", 1).requirement("Magic", 65)
            .requirement("Astral rune", 1).requirement("Fire rune", 5).requirement("Water rune", 1).requirement("Uncooked berry pie", 1)
            .requirement("Cooking", 10).reward("Redberry pie", 1).reward("Cooking", 78).reward("Magic", 60).build());
        achievements.add(new AchievementBuilder("Dress to Impress", 0).requirement("Rock-shell helm", 0)
            .requirement("Rock-shell plate", 0).requirement("Rock-shell legs", 0).requirement("Defense", 1)
            .requirement("The Fremennik Trials", 1).build());
        achievements.add(new AchievementBuilder("Defeating Deadly Dagannoths", 0).requirement("The Fremennik Trials", 1)
            .encounter(new Encounter("Dagannoth")).encounter(new Encounter("Dagannoth")).encounter(new Encounter("Dagannoth"))
            .build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Hard", 0).requirement("Pyre At Will", 1)
            .requirement("Defeating Deadly Dagannoths", 1).requirement("Dress to Impress", 1).requirement("The Graceful Barbarian", 1)
            .requirement("Runes on the Moon", 1).requirement("Fish Fingers", 1).requirement("Easy As Pie", 1)
            .requirement("How To Maim Your Dragon", 1).requirement("A Periodic Table", 1).lamp(Player.ALL_SKILLS, 15000, 50).build());
        achievements.add(new AchievementBuilder("You Really Don't Need Any More Shoes", 0).requirement("The Fremennik Trials", 1)
            .build());
        achievements.add(new AchievementBuilder("You Know You Want It!", 0).requirement("Raw bass", 1)
            .requirement("The Fremennik Trials", 1).requirement("Garden of Tranquility", 1).reward("Enchanted lyre", 1).build());
        achievements.add(new AchievementBuilder("Yak Attack", 0).requirement("Yak-hide body armour", 0)
            .requirement("Yak-hide leg armour", 0).requirement("The Fremennik Isles", 1).encounter(new Encounter("Ice troll male",
                Arrays.asList(new Restriction("Yak-hide body armour", 1), new Restriction("Yak-hide leg armour", 1)))).build());
        achievements.add(new AchievementBuilder("Who's a Good Boy?", 0).requirement("Pet rock", 0).build());
        achievements.add(new AchievementBuilder("Only Takes a Little Vial", 0).requirement("Molten glass", 3)
            .requirement("Crafting", 33).reward("Vial", 3).reward("Crafting", 105).build());
        achievements.add(new AchievementBuilder("Grand Theft Fish", 0).requirement("The Fremennik Trials", 1)
            .requirement("Thieving", 42).reward("Thieving", 42).build());
        achievements.add(new AchievementBuilder("Fremmental", 0).requirement("The Fremennik Trials", 1).requirement("Cooking", 48)
            .requirement("Bucket of milk", 1).build());
        achievements.add(new AchievementBuilder("Fremennik History 101", 0).requirement("The Fremennik Trials", 1).build());
        achievements.add(new AchievementBuilder("Fairy Mountaineering", 0).requirement("Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("Cool Story, Bro", 0).requirement("The Fremennik Trials", 1).build());
        achievements.add(new AchievementBuilder("Big Game Hunter", 0).requirement("Hunter", 55).requirement("Teasing stick", 0)
            .reward("Hunter", 300).build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Medium", 0).requirement("Yak Attack", 1)
            .requirement("Fremennik History 101", 1).requirement("Cool Story, Bro", 1).requirement("Who's a Good Boy?", 1)
            .requirement("Only Takes a Little Vial", 1).requirement("You Know You Want It!", 1).requirement("Fremmental", 1)
            .requirement("Fairy Mountaineering", 1).requirement("You Really Don't Need Any More Shoes", 1).requirement("Big Game Hunter", 1)
            .requirement("Grand Theft Fish", 1).lamp(Player.ALL_SKILLS, 10000, 40).build());
        achievements.add(new AchievementBuilder("Why Won't You Die?", 0).encounter(new Encounter("Rock crab"))
            .encounter(new Encounter("Rock crab")).encounter(new Encounter("Rock crab")).encounter(new Encounter("Rock crab"))
            .encounter(new Encounter("Rock crab")).build());
        achievements.add(new AchievementBuilder("Why Did the Lobster Blush?", 0).reward("Seaweed", 3).build());
        achievements.add(new AchievementBuilder("Peer Off the Pier", 0).reward("Raw shrimps", 1).reward("Fishing", 10).build());
        achievements.add(new AchievementBuilder("Oxymoron Incarnate", 0).build());
        achievements.add(new AchievementBuilder("King Conifer", 0).build());
        achievements.add(new AchievementBuilder("Hunting the Hunter", 0).build());
        achievements.add(new AchievementBuilder("Endangered Species", 0).encounter(new Encounter("Black unicorn")).build());
        achievements.add(new AchievementBuilder("Assaulted Goodies", 0).build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Easy", 0).requirement("King Conifer", 1)
            .requirement("Bring the Antipoisons", 1).requirement("Why Won't You Die?", 1).requirement("Assaulted Goodies", 1)
            .requirement("Oxymoron Incarnate", 1).requirement("Why Did the Lobster Blush?", 1).requirement("Hunting the Hunter", 1)
            .requirement("Peer Off the Pier", 1).requirement("A Familiar Feeling", 1).requirement("Endangered Species", 1)
            .lamp(Player.ALL_SKILLS, 5000, 30).build());
        achievements.add(new AchievementBuilder("Eadgar's Ruse", 1.5).requirement("Druidic Ritual", 1)
            .requirement("Troll Stronghold", 1).requirement("Herblore", 31).requirement("Agility", 15).requirement("Vodka", 1)
            .requirement("Pineapple chunks", 1).requirement("Wheat", 10).requirement("Raw chicken", 5).requirement("Logs", 2)
            .requirement("Ranarr potion (unf)", 1).reward("Quest points", 1).reward("Herblore", 11000).build());
        achievements.add(new AchievementBuilder("Dream Mentor", 0.55).requirement("Lunar Diplomacy", 1)
            .requirement("Eadgar's Ruse", 1).requirement("Astral rune", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("The Inadequacy", "The Everlasting",
                "The Untouchable", "The Illusive")))).reward("Quest points", 2).reward("Magic", 10000).reward("Constitution", 15000)
            .lamp(Arrays.asList("Strength", "Ranged", "Magic", "Constitution", "Defense"), 15000, 1).build());
        achievements.add(new AchievementBuilder("Blood Runs Deep", 1.5).requirement("Dream Mentor", 1)
            .requirement("Glorious Memories", 1).requirement("Horror from the Deep", 1).requirement("Fremennik Set Tasks - Easy", 1)
            .requirement("Fremennik Set Tasks - Medium", 1).requirement("Fremennik Set Tasks - Hard", 1).requirement("Attack", 75)
            .requirement("Strength", 75).requirement("Slayer", 65)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"),
                Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Dagannoth sentinel", "Dagannoth sentinel"))))
            .encounter(new Encounter("Dagannoth Mother (BRD)")).reward("Quest points", 2).build());
        achievements.add(new AchievementBuilder("Axe'll Grease", 0).requirement("Blood Runs Deep", 1)
            .encounter(new Encounter("Dagannoth", Collections.singletonList(new Restriction("Balmung", 1)))).build());
        achievements.add(new AchievementBuilder("Azacorax's Rewards", 0).requirement("Rune Memories", 1).requirement("Magic", 50)
            .requirement("Prayer", 50).lamp(Arrays.asList("Magic", "Prayer"), 10000, 50).build());
        achievements.add(new AchievementBuilder("Azdaran Birthright", 0).requirement("Azdaran fragment", 10).build());
        achievements.add(new AchievementBuilder("B Sharp, Not Flat", 0.05).requirement("Plague's End", 1).reward("Crafting", 300)
            .reward("Construction", 200).reward("Harmonic dust", 4).build());
        achievements.add(new AchievementBuilder("Back Cran-door", 0).requirement("Dragon Slayer", 1).build());
        achievements.add(new AchievementBuilder("Balanced Combat Triangle", 0).requirement("Lockbox puzzle", 1).build());
        achievements.add(new AchievementBuilder("Bandit Camp", 0).requirement("Desert Treasure", 1).build());
        achievements.add(new AchievementBuilder("Bandos's Memories", 0).requirement("Bandos chronicles", 13).build());
        achievements.add(new AchievementBuilder("Bane Tuner", 0).requirement("Tune Bane Ore", 1).build());
        achievements.add(new AchievementBuilder("Bank-Z", 0).requirement("Dimension of Disaster: Curse of Arrav", 1)
            .reward("Zemomark", 30).build());
        achievements.add(new AchievementBuilder("Banking History", 0).requirement("Enchanted key miniquest", 2).build());
        achievements.add(new AchievementBuilder("Banned For Life", 0).requirement("Ibis pouch", 1).requirement("Summoning", 56)
            .reward("Summoning", 1).build());
        achievements.add(new AchievementBuilder("Barbarian Scavenger", 0).requirement("Ancient page", 26).build());
        achievements.add(new AchievementBuilder("Barking Up the Wrong Tree", 0).requirement("Woodcutting", 45).reward("Bark", 1)
            .reward("Woodcutting", 357).build());
        achievements.add(new AchievementBuilder("Baroo Quality", 0).requirement("Yak-hide armour (top)", 1)
            .requirement("Yak-hide armour (legs)", 1).requirement("Fremennik round shield", 1)
            .encounter(new Encounter("Dagannoth Supreme", Arrays.asList(new Restriction("Yak-hide armour (top)", 1),
                new Restriction("Yak-hide armour (legs)", 1), new Restriction("Fremennik round shield", 1)))).build());
        achievements.add(new AchievementBuilder("Barrowed Power I", 0).requirement("Rise of the Six", 5).build());
        achievements.add(new AchievementBuilder("Barrowed Power II", 0).requirement("Rise of the Six", 10).build());
        achievements.add(new AchievementBuilder("Barrowed Power III", 0).requirement("Rise of the Six", 25).build());
        achievements.add(new AchievementBuilder("Barrowed Power IV", 0).requirement("Rise of the Six", 50).build());
        achievements.add(new AchievementBuilder("Barrowed Power V", 0).requirement("Rise of the Six", 75).build());
        achievements.add(new AchievementBuilder("Barrowed Power VI", 0).requirement("Rise of the Six", 100).build());
        achievements.add(new AchievementBuilder("Barrowed Time", 0).requirement("Barrows uniques", 38).build());
        achievements.add(new AchievementBuilder("Barry", 0).requirement("Araxyte egg", 1).build());
        achievements.add(new AchievementBuilder("Battle of the Elements", 0).requirement("Crafting", 66).requirement("Air orb", 1)
            .requirement("Battlestaff", 1).reward("Crafting", 137).build());
        achievements.add(new AchievementBuilder("Beachcomber", 0).reward("Seaweed", 5).build());
        achievements.add(new AchievementBuilder("Because You're Iorwerth It", 0).requirement("Plague's End", 1)
            .encounter(new Encounter("Iorwerth scout")).build());
        achievements.add(new AchievementBuilder("Beggars Can't Be Choosers", 0.05).requirement("In Aid of the Myreque", 1)
            .requirement("Great maki", 1).build());
        achievements.add(new AchievementBuilder("Behemoth Notes", 0).requirement("Behemoth notes", 5).build());
        achievements.add(new AchievementBuilder("Belter of a Smelter", 0).requirement("Iron ore", 1).requirement("Coal", 2)
            .requirement("Smithing", 30).reward("Steel bar", 1).reward("Smithing", 17).build());
        achievements.add(new AchievementBuilder("Best Offence", 0).encounter(new Encounter("Kalphite King")).build());
        achievements.add(new AchievementBuilder("Better Not Touch", 0).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru")))).build());
        achievements.add(new AchievementBuilder("Better Than Cursing The Darkness", 0).requirement("Bark", 1)
            .requirement("Ring of fire", 0).reward("Firemaking", 102).build());
        achievements.add(new AchievementBuilder("Beware of Pigzilla", 0).build());
        achievements.add(new AchievementBuilder("Beware of the Dog", 0).requirement("Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("Big Chinchompa", 0.25).requirement("Hunter", 78).reward("Competence points", 1111)
            .build());
        achievements.add(new AchievementBuilder("Bipedal Mask", 0).requirement("Tuska mask headpiece", 1)
            .requirement("Tuska mask lower tusks", 1).requirement("Tuska mask plate", 1).requirement("Tuska mask top", 1)
            .requirement("Tuska mask upper tusks", 1).lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged",
                "Magic", "Slayer"), 43680, 90).build());
        achievements.add(new AchievementBuilder("Bird is the Word I", 0).requirement("Kree'arra", 5).build());
        achievements.add(new AchievementBuilder("Bird is the Word II", 0).requirement("Kree'arra", 10).build());
        achievements.add(new AchievementBuilder("Bird is the Word III", 0).requirement("Kree'arra", 25).build());
        achievements.add(new AchievementBuilder("Bird is the Word IV", 0).requirement("Kree'arra", 50).build());
        achievements.add(new AchievementBuilder("Bird is the Word V", 0).requirement("Kree'arra", 75).build());
        achievements.add(new AchievementBuilder("Bird is the Word VI", 0).requirement("Kree'arra", 100).build());
        achievements.add(new AchievementBuilder("Birdstrike I", 0).requirement("Kree'arra (HM)", 5).build());
        achievements.add(new AchievementBuilder("Birdstrike II", 0).requirement("Kree'arra (HM)", 10).build());
        achievements.add(new AchievementBuilder("Birdstrike III", 0).requirement("Kree'arra (HM)", 25).build());
        achievements.add(new AchievementBuilder("Birdstrike IV", 0).requirement("Kree'arra (HM)", 50).build());
        achievements.add(new AchievementBuilder("Birdstrike V", 0).requirement("Kree'arra (HM)", 75).build());
        achievements.add(new AchievementBuilder("Birdstrike VI", 0).requirement("Kree'arra (HM)", 100).build());
        achievements.add(new AchievementBuilder("Blackout", 0).requirement("Queen Black Dragon uniques", 12).build());
        achievements.add(new AchievementBuilder("Blast and Hellfire", 0).requirement("Magic", 59).requirement("Fire rune", 3)
            .requirement("Air rune", 3).build());
        achievements.add(new AchievementBuilder("Bless is More", 0).requirement("Clay ring", 1).reward("Ring of devotion", 1)
            .build());
        achievements.add(new AchievementBuilder("Blinded by Ramarno's Teaching", 0).requirement("Defender of Varrock", 1)
            .requirement("Redberry pie", 1).reward("Smithing", 1000).build());
        achievements.add(new AchievementBuilder("Blinded with Science", 0).requirement("Firemaking", 49)
            .requirement("Bullseye lantern (oil)", 1).reward("Bullseye lantern", 1).build());
        achievements.add(new AchievementBuilder("Blood Stained Treasure", 0.05).requirement("Legacy of Seergaze", 1)
            .reward("Blood rune", 100).build());
        achievements.add(new AchievementBuilder("Blooming Marvellous", 0).requirement("Nature Spirit", 1)
            .reward("Mort myre fungus", 1).build());
        achievements.add(new AchievementBuilder("Blowing Your Own Trumpet", 0).requirement("Mourning's End Part I", 1).build());
        achievements.add(new AchievementBuilder("Bombi", 0).requirement("Ancient artifact", 1).build());
        achievements.add(new AchievementBuilder("Bone I Fired", 0).requirement("Zanik's crossbow", 1).requirement("Bone bolt", 2)
            .requirement("Rag and Bone Man wish list", 1).requirement("Fur'n'Seek wish list", 1).requirement("Ranged", 48)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Skeletal horror (Phase 1)"),
                Collections.singletonList("Skeletal horror (Phase 2)"), Collections.singletonList("Skeletal horror (Phase 3)"),
                Collections.singletonList("Skeletal horror (Phase 4)")), Arrays.asList(new Restriction("Zanik's crossbow", 1),
                new Restriction("Bone bolt", 1)))).reward("Slayer", 10000).reward("Prayer", 7000).build());
        achievements.add(new AchievementBuilder("Boosted Animal", 0).requirement("Barrel of bait", 1)
            .requirement("Tangled fishbowl", 1).requirement("Broken fishing rod", 1).build());
        achievements.add(new AchievementBuilder("Bovine Intervention", 0).encounter(new Encounter("Cow")).build());
        achievements.add(new AchievementBuilder("Bowing Out and About", 0.05).requirement("Mourning's End Part I", 1)
            .requirement("Woodcutting", 60).requirement("Fletching", 70).reward("Woodcutting", 175).reward("Fletching", 150)
            .reward("Farming", 1).reward("Crafting", 15).reward("Yew shieldbow", 1).build());
        achievements.add(new AchievementBuilder("Boxing Clever", 0).requirement("Summoning", 95).requirement("Hunter", 27)
            .requirement("Box trap", 0).requirement("Banana", 1).reward("Hunter", 100).build());
        achievements.add(new AchievementBuilder("Boys to Menaphites", 0).requirement("Menaphos reputation", 330000).build());
        achievements.add(new AchievementBuilder("Brace for Additional Impact", 0).requirement("Plague's End", 1)
            .requirement("Bracelet of clay", 0).build());
        achievements.add(new AchievementBuilder("Brain Bending", 0).requirement("Magic", 33).requirement("Law rune", 1)
            .requirement("Air rune", 1).reward("Magic", 43).build());
        achievements.add(new AchievementBuilder("Brass Nex I", 0).requirement("Nex", 5).build());
        achievements.add(new AchievementBuilder("Brass Nex II", 0).requirement("Nex", 10).build());
        achievements.add(new AchievementBuilder("Brass Nex III", 0).requirement("Nex", 25).build());
        achievements.add(new AchievementBuilder("Brass Nex IV", 0).requirement("Nex", 50).build());
        achievements.add(new AchievementBuilder("Brass Nex V", 0).requirement("Nex", 75).build());
        achievements.add(new AchievementBuilder("Brass Nex VI", 0).requirement("Nex", 100).build());
        achievements.add(new AchievementBuilder("Bridge over Fremmy Waters", 0).requirement("Fremennik sagas", 5).build());
        achievements.add(new AchievementBuilder("Bring It All Back", 0).requirement("Ranged", 80).requirement("Attack", 85)
            .encounter(new Encounter("Twin Furies", Arrays.asList(new Restriction("Blade of Avaryss", 1),
                new Restriction("Blade of Nymora", 1)))).build());
        achievements.add(new AchievementBuilder("Bring the Antipoisons", 0).requirement("Slayer", 10)
            .encounter(new Encounter("Cave crawler")).build());
        achievements.add(new AchievementBuilder("Brothers Gower", 0).requirement("Gower lamp", 3).build());
        achievements.add(new AchievementBuilder("Brothers in Arms", 0).requirement("Ritual of the Mahjarrat", 1)
            .requirement("Kindred Spirits", 1).requirement("Ahrim's staff", 0).requirement("Akrisae's war mace", 0)
            .requirement("Dharok's greataxe", 0).requirement("Guthan's warspear", 0).requirement("Karil's crossbow", 0)
            .requirement("Linza's hammer", 0).requirement("Torag's hammer", 0).requirement("Verac's flail", 0).requirement("Magic", 70)
            .requirement("Attack", 80).requirement("Prayer", 70).requirement("Strength", 70).requirement("Ranged", 70)
            .encounter(new Encounter("Ahrim the Blighted", Collections.singletonList(new Restriction("Ahrim's staff", 1))))
            .encounter(new Encounter("Dharok the Wretched", Collections.singletonList(new Restriction("Dharok's greataxe", 1))))
            .encounter(new Encounter("Linza the Disgraced", Collections.singletonList(new Restriction("Linza's hammer", 1))))
            .encounter(new Encounter("Karil the Tainted", Collections.singletonList(new Restriction("Karil's crossbow", 1))))
            .encounter(new Encounter("Torag the Corrupted", Collections.singletonList(new Restriction("Torag's hammer", 1))))
            .encounter(new Encounter("Guthan the Infested", Collections.singletonList(new Restriction("Guthan's warspear", 1))))
            .encounter(new Encounter("Akrisae the Doomed", Collections.singletonList(new Restriction("Akrisae's war mace", 1))))
            .encounter(new Encounter("Verac the Defiled", Collections.singletonList(new Restriction("Verac's flail", 1)))).build());
        achievements.add(new AchievementBuilder("Bros Before Barrows", 0).requirement("Ritual of the Mahjarrat", 1)
            .encounter(new Encounter("Ahrim the Blighted")).encounter(new Encounter("Dharok the Wretched"))
            .encounter(new Encounter("Karil the Tainted")).encounter(new Encounter("Torag the Corrupted"))
            .encounter(new Encounter("Guthan the Infested")).encounter(new Encounter("Akrisae the Doomed"))
            .encounter(new Encounter("Verac the Defiled")).build());
        achievements.add(new AchievementBuilder("Brothers in More Arms", 0).requirement("Barrows totem", 6)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
                "Dharok the Wretched (ROTS)"), Arrays.asList("Guthan the Infested (ROTS)", "Ahrim the Blighted (ROTS)",
                "Verac the Defiled (ROTS)"))))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
                "Dharok the Wretched (ROTS)"), Arrays.asList("Guthan the Infested (ROTS)", "Verac the Defiled (ROTS)",
                "Ahrim the Blighted (ROTS)"))))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
                "Dharok the Wretched (ROTS)"), Arrays.asList("Ahrim the Blighted (ROTS)", "Verac the Defiled (ROTS)",
                "Guthan the Infested (ROTS)"))))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
                "Guthan the Infested (ROTS)"), Arrays.asList("Ahrim the Blighted (ROTS)", "Verac the Defiled (ROTS)",
                "Dharok the Wretched (ROTS)"))))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Dharok the Wretched (ROTS)",
                "Guthan the Infested (ROTS)"), Arrays.asList("Ahrim the Blighted (ROTS)", "Verac the Defiled (ROTS)",
                "Torag the Corrupted (ROTS)"))))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Torag the Corrupted (ROTS)", "Dharok the Wretched (ROTS)",
                "Guthan the Infested (ROTS)"), Arrays.asList("Ahrim the Blighted (ROTS)", "Verac the Defiled (ROTS)",
                "Karil the Tainted (ROTS)")))).build());
        achievements.add(new AchievementBuilder("Brutal Stuffies", 0).requirement("Zogre Flesh Eaters", 1)
            .requirement("Relicym's balm", 1).build());
        achievements.add(new AchievementBuilder("Bug Swatter I", 0).requirement("Kalphite Queen", 5).build());
        achievements.add(new AchievementBuilder("Bug Swatter II", 0).requirement("Kalphite Queen", 10).build());
        achievements.add(new AchievementBuilder("Bug Swatter III", 0).requirement("Kalphite Queen", 25).build());
        achievements.add(new AchievementBuilder("Bug Swatter IV", 0).requirement("Kalphite Queen", 50).build());
        achievements.add(new AchievementBuilder("Bug Swatter V", 0).requirement("Kalphite Queen", 75).build());
        achievements.add(new AchievementBuilder("Bug Swatter VI", 0).requirement("Kalphite Queen", 100).build());
        achievements.add(new AchievementBuilder("Bug Zapper I", 0).requirement("Kalphite King", 5).build());
        achievements.add(new AchievementBuilder("Bug Zapper II", 0).requirement("Kalphite King", 10).build());
        achievements.add(new AchievementBuilder("Bug Zapper III", 0).requirement("Kalphite King", 25).build());
        achievements.add(new AchievementBuilder("Bug Zapper IV", 0).requirement("Kalphite King", 50).build());
        achievements.add(new AchievementBuilder("Bug Zapper V", 0).requirement("Kalphite King", 75).build());
        achievements.add(new AchievementBuilder("Bug Zapper VI", 0).requirement("Kalphite King", 100).build());
        achievements.add(new AchievementBuilder("Building Up Strength", 0.05).requirement("Gold ore", 1).requirement("Uncut ruby", 1)
            .requirement("Smithing", 40).requirement("Crafting", 50).requirement("Magic", 49).requirement("Fire rune", 5)
            .requirement("Cosmic rune", 1).reward("Smithing", 22).reward("Crafting", 176).reward("Magic", 59)
            .reward("Amulet of strength", 1).build());
        achievements.add(new AchievementBuilder("Bunch of Flours", 0).requirement("Murder Mystery", 1).requirement("Empty pot", 1)
            .reward("Pot of flour", 1).build());
        achievements.add(new AchievementBuilder("Burning Bush", 0).requirement("Poison ivy seed", 1).requirement("Farming", 70)
            .reward("Farming", 840).reward("Poison ivy berries", 1).build());
        achievements.add(new AchievementBuilder("Burn, Fury, Burn", 0).requirement("Ranged", 80)
            .encounter(new Encounter("Twin Furies")).build());
        achievements.add(new AchievementBuilder("Burthorpe", 0).build());
        achievements.add(new AchievementBuilder("Burthorpe Trolls", 0).build());
        achievements.add(new AchievementBuilder("Business Is Booning!", 0).requirement("Divination", 10)
            .requirement("Pale energy", 100).reward("Divination", 3).build());
        achievements.add(new AchievementBuilder("But It Won't Warp You Anywhere", 0).requirement("Agility", 51).build());
        achievements.add(new AchievementBuilder("Buyers and Cellars", 0.5).requirement("Thieving", 5).reward("Quest points", 1)
            .reward("Thieving", 525).build());
        achievements.add(new AchievementBuilder("Buy and Sell Some XP", 0).requirement("Thieving", 62)
            .requirement("Buyers and Cellars", 1).reward("Thieving", 2000).build());
        achievements.add(new AchievementBuilder("Buying Up Ancient Artefacts", 0).requirement("Desert Treasure", 1)
            .requirement("Coins", 80000).build());
        achievements.add(new AchievementBuilder("Cache Box", 0).requirement("Thieving", 40).requirement("Dungeoneering floors completed", 4)
            .build());
        achievements.add(new AchievementBuilder("Cadarn Tootin'", 0).requirement("Plague's End", 1).requirement("Desert Treasure", 1)
            .encounter(new Encounter("Cadarn magus")).build());
        achievements.add(new AchievementBuilder("Camping is in Tents", 0).build());
        achievements.add(new AchievementBuilder("Camping Trip", 0).requirement("Logs", 1).reward("Firemaking", 40).build());
        achievements.add(new AchievementBuilder("Can't Make an Omelette", 0).reward("Red spider eggs", 1).build());
        achievements.add(new AchievementBuilder("Can I Have Some Morvran", 1.5).requirement("Plague's End", 1)
            .requirement("Slayer", 85).requirement("Slayer point", 100).build());
        achievements.add(new AchievementBuilder("Can Opener", 0).requirement("Agility", 12).requirement("Woodcutting", 34)
            .requirement("Coins", 875).encounter(new Encounter("Bronze dragon",
                Collections.singletonList(new Restriction("Dragonfire protection", 1)))).build());
        achievements.add(new AchievementBuilder("Can You Dig It?", 0).requirement("Giant Mole uniques", 3).build());
        achievements.add(new AchievementBuilder("Canifis", 0).build());
        achievements.add(new AchievementBuilder("Careful, There Are Snakes", 0.05).requirement("Thieving", 31).build());
        achievements.add(new AchievementBuilder("Casting a Shadow", 0).requirement("Blissful shadow core", 1)
            .requirement("Divination", 81).requirement("Plague's End", 1).reward("Divination", 455).build());
        achievements.add(new AchievementBuilder("Casting Shadows", 0).requirement("Mourning's End Part II", 1)
            .requirement("Desert Treasure", 1).requirement("Magic", 52).requirement("Earth rune", 3).requirement("Death rune", 1)
            .encounter(new Encounter("Shadow", Collections.singletonList(new Restriction("Shadow spells", 1)))).build());
        achievements.add(new AchievementBuilder("Castles in the Sky", 0).build());
        achievements.add(new AchievementBuilder("Cat's Bane", 0).requirement("New Varrock stray cats", 4).reward("Zemomark", 20)
            .build());
        achievements.add(new AchievementBuilder("Catherby", 0).build());
        achievements.add(new AchievementBuilder("Caving Into the Gains", 0)
            .requirement("Myths of the White Lands post-quest rewards", 4).build());
        achievements.add(new AchievementBuilder("Cecilia, I'm Begging You, Please...", 0).requirement("One Piercing Note", 1)
            .build());
        achievements.add(new AchievementBuilder("Cement his Torment", 0).requirement("Black platelegs", 0)
            .requirement("Black platebody", 0).requirement("Black full helm", 0).requirement("Black 2h sword", 0)
            .encounter(new Encounter("Tormented wraith", Arrays.asList(new Restriction("Black platelegs", 0),
                new Restriction("Black platebody", 0), new Restriction("Black full helm", 0), new Restriction("Black 2h sword", 0))))
            .build());
        achievements.add(new AchievementBuilder("Chain Store", 0).requirement("Coins", 1440).requirement("Defense", 25)
            .reward("Black chainbody", 1).build());
        achievements.add(new AchievementBuilder("Challenge Maria", 0).requirement("Broken Home bonus lamps", 9)
            .requirement("Broken Home replay challenges", 3).build());
        achievements.add(new AchievementBuilder("Challenge Vannaka", 0).requirement("Combat", 40).build());
        achievements.add(new AchievementBuilder("Challenging Chat", 0).build());
        achievements.add(new AchievementBuilder("Champion!", 0).requirement("Quest points", 33).build());
        achievements.add(new AchievementBuilder("Champions, What Champions?", 0).requirement("Champions", 15)
            .reward("Coins", 50000).lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defense", "Constitution",
                "Prayer", "Summoning"), 10000, 50).lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defense",
                "Constitution", "Prayer", "Summoning"), 10000, 50).lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged",
                "Defense", "Constitution", "Prayer", "Summoning"), 10000, 50).lamp(Arrays.asList("Attack", "Strength", "Magic",
                "Ranged", "Defense", "Constitution", "Prayer", "Summoning"), 10000, 50).build());
        achievements.add(new AchievementBuilder("Change of a Dress", 0).requirement("Dungeoneering", 20).build());
        achievements.add(new AchievementBuilder("Changing of the Guard", 0).requirement("Defense", 60)
            .requirement("Black dragonhide coif", 0).requirement("Black dragonhide body", 0).requirement("Black dragonhide chaps", 0)
            .requirement("Black dragonhide boots", 0).requirement("Black dragonhide vambraces", 0).requirement("Black dragonhide shield", 0)
            .encounter(new Encounter("King Black Dragon", Arrays.asList(new Restriction("Black dragonhide coif", 1),
                new Restriction("Black dragonhide body", 1), new Restriction("Black dragonhide chaps", 1),
                new Restriction("Black dragonhide boots", 1), new Restriction("Black dragonhide vambraces", 1),
                new Restriction("Black dragonhide shield", 1)))).build());
        achievements.add(new AchievementBuilder("Changing Rooms", 0).requirement("Construction", 40).requirement("Coins", 15000)
            .build());
        achievements.add(new AchievementBuilder("Chaos Theory", 0).requirement("Chaos Elemental uniques", 30).build());
        achievements.add(new AchievementBuilder("Chaosteo", 0).reward("Prayer", 15).build());
        achievements.add(new AchievementBuilder("Charter A Course", 0).requirement("Coins", 550).build());
        achievements.add(new AchievementBuilder("Checkmate", 0).requirement("Kalphite Queen uniques", 4).build());
        achievements.add(new AchievementBuilder("Chick'arra", 0).requirement("Giant feather", 1).build());
        achievements.add(new AchievementBuilder("Child of Saradomin", 0).requirement("Prayer", 70).requirement("Construction", 16)
            .requirement("Coins", 5000).build());
        achievements.add(new AchievementBuilder("Chilling with Arrav", 0).requirement("Ritual of the Mahjarrat", 1)
            .reward("Prayer", 3000).build());
        achievements.add(new AchievementBuilder("Chinchompa Powered!", 0).requirement("Cheese", 1).build());
        achievements.add(new AchievementBuilder("Chippy Transport", 0).requirement("Love Story", 1).build());
        achievements.add(new AchievementBuilder("Chiselin' Conchiolin", 0).requirement("Blamish myre shell (round)", 1)
            .requirement("Crafting", 15).reward("Snelm", 1).reward("Crafting", 32).build());
        achievements.add(new AchievementBuilder("Chivalry is Fed", 0).requirement("The Death of Chivalry", 1)
            .requirement("Cabbage seeds", 12).requirement("Farming", 7).reward("Farming", 250).build());
        achievements.add(new AchievementBuilder("Chivalry is Threads", 0).requirement("Templar armour", 1)
            .requirement("Dulcin armour", 1).build());
        achievements.add(new AchievementBuilder("Chivalry is Dead", 0).requirement("The Death of Chivalry post-quest rewards", 4)
            .build());
        achievements.add(new AchievementBuilder("Chompy Massacre", 0).requirement("Chompy kills", 4000).reward("Ranged", 30000)
            .build());
        achievements.add(new AchievementBuilder("Circus of Fire", 0.05).requirement("The Firemaker's Curse", 1).build());
        achievements.add(new AchievementBuilder("Citadelementary", 0).build());
        achievements.add(new AchievementBuilder("Claiming Azzanadra's Heart", 0).requirement("Heart of Stone", 1)
            .requirement("The Temple at Senntisten", 1).lamp(Player.ALL_SKILLS, -2, 1).build());
        achievements.add(new AchievementBuilder("Class Crown", 0).requirement("Imperial reputation", 300000).build());
        achievements.add(new AchievementBuilder("Classic Dragon Killing", 0).requirement("Attack", 80)
            .requirement("Dragonfire shield", 1).encounter(new Encounter("Vindicta",
                Collections.singletonList(new Restriction("Dragonfire shield", 1)))).build());
        achievements.add(new AchievementBuilder("Classic Rock", 0).encounter(new Encounter("Vorago",
            Collections.singletonList(new Restriction("Defensive abilities", 0)))).build());
        achievements.add(new AchievementBuilder("Claus Is Rising", 0).requirement("Claus the chef reward", 1).build());
        achievements.add(new AchievementBuilder("Clay More", 0).reward("Mining", 5).reward("Clay", 1).build());
        achievements.add(new AchievementBuilder("Claymation", 0.33).build());
        achievements.add(new AchievementBuilder("Climbing the Walls", 0).requirement("Agility", 11).requirement("Ranged", 19)
            .requirement("Strength", 37).requirement("Mithril grapple", 1).build());
        achievements.add(new AchievementBuilder("Clued-Up", 0).reward("Sealed clue scroll (easy)", 1).build());
        achievements.add(new AchievementBuilder("Clue's In The Monkey Drool", 0).requirement("Monkey clue scroll", 1).build());
        achievements.add(new AchievementBuilder("Collecting Memorabilia", 0).reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Come At Me, Bro!", 0.05).requirement("Bloodweed seed", 1).requirement("Farming", 57)
            .requirement("Vial of water", 1).requirement("Searing ashes", 1).requirement("Herblore", 82).reward("Farming", 153)
            .reward("Herblore", 197).reward("Aggression potion (3)", 1).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago I", 0).requirement("Vorago", 5).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago II", 0).requirement("Vorago", 10).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago III", 0).requirement("Vorago", 25).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago IV", 0).requirement("Vorago", 50).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago V", 0).requirement("Vorago", 75).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago VI", 0).requirement("Vorago", 100).build());
        achievements.add(new AchievementBuilder("Come In Here and Say That", 0).build());
        achievements.add(new AchievementBuilder("Commander Miniana", 0).requirement("Auburn lock", 1).build());
        achievements.add(new AchievementBuilder("Commerce Break", 0).build());
        achievements.add(new AchievementBuilder("Complete History of Droalak", 0).requirement("Making History", 1).build());
        achievements.add(new AchievementBuilder("Complete Trekky", 0).requirement("Temple Trekking total level", 594).build());
        achievements.add(new AchievementBuilder("What A Rush", 0).requirement("Plague's End", 1).requirement("Slayer", 85)
            .requirement("Legacy of Seergaze", 1).build());
        achievements.add(new AchievementBuilder("The Diplomatic Approach", 0.1).requirement("Plague's End", 1).build());
        achievements.add(new AchievementBuilder("Thank You, Deer", 0).requirement("Plague's End", 1)
            .requirement("Spirit wolf pouch", 1).reward("Spirit shards", 5).build());
        achievements.add(new AchievementBuilder("Sing-Along-a-Seren Verse 1", 0).requirement("Plague's End", 1)
            .requirement("Summoning", 79).requirement("Moss titan pouch", 1).reward("Titan's constitution scroll", 12).build());
        achievements.add(new AchievementBuilder("Sing-Along-a-Seren Verse 2", 0).requirement("Plague's End", 1)
            .requirement("Crystal bow", 0).build());
        achievements.add(new AchievementBuilder("Sing-Along-a-Seren Verse 3", 0).requirement("Plague's End", 1)
            .reward("Magic logs", 1).reward("Woodcutting", 300).build());
        achievements.add(new AchievementBuilder("Sing-Along-a-Seren Verse 4", 0).requirement("Plague's End", 1)
            .requirement("Agility", 77).reward("Agility", 844).build());
        achievements.add(new AchievementBuilder("Sing-Along-a-Seren Verse 5", 0).requirement("Plague's End", 1)
            .requirement("Crystal dagger", 0).build());
        achievements.add(new AchievementBuilder("Sing-Along-a-Seren Verse 6", 0).requirement("Plague's End", 1)
            .requirement("Grown harmony moss", 1).requirement("Herblore", 77).reward("Perfect juju farming potion (3)", 1)
            .reward("Herblore", 109).reward("Farming", 1133).build());
        achievements.add(new AchievementBuilder("Sing-Along-a-Seren Verse 7", 0).requirement("Plague's End", 1)
            .reward("Adamantite ore", 1).reward("Mining", 114).build());
        achievements.add(new AchievementBuilder("Long Way From Home", 0).requirement("Plague's End", 1).requirement("Agility", 77)
            .requirement("Summoning", 88).requirement("Light creature pouch", 1).reward("Agility", 704).reward("Summoning", 9).build());
        achievements.add(new AchievementBuilder("Hefin and Puffin'", 0).requirement("Plague's End", 1).requirement("Agility", 77)
            .build());
        achievements.add(new AchievementBuilder("Disco Impling", 0).requirement("Plague's End", 1).requirement("Daffyd implings", 10)
            .build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Hard", 0).requirement("Sing-Along-a-Seren Verse 1", 1)
            .requirement("Sing-Along-a-Seren Verse 2", 1).requirement("Sing-Along-a-Seren Verse 3", 1)
            .requirement("Sing-Along-a-Seren Verse 4", 1).requirement("Sing-Along-a-Seren Verse 5", 1)
            .requirement("Sing-Along-a-Seren Verse 6", 1).requirement("Sing-Along-a-Seren Verse 7", 1).requirement("What A Rush", 1)
            .requirement("The Diplomatic Approach", 1).requirement("Hefin and Puffin'", 1).requirement("Long Way From Home", 1)
            .requirement("Because You're Iorwerth It", 1).requirement("Cadarn Tootin'", 1).requirement("A Face in the Clouds", 1)
            .requirement("Brace for Additional Impact", 1).requirement("Thank You, Deer", 1).requirement("Disco Impling", 1)
            .requirement("Can I Have Some Morvran", 1).requirement("B Sharp, Not Flat", 1).requirement("Casting a Shadow", 1)
            .requirement("A Clean Slate", 1).lamp(Player.ALL_SKILLS, 40000, 78).build());
        achievements.add(new AchievementBuilder("The Circle of Life", 0).requirement("Underground Pass", 1)
            .requirement("Raw pawya meat", 1).requirement("Box trap", 0).requirement("Hunter", 77).build());
        achievements.add(new AchievementBuilder("Stranger and Stranger", 0).requirement("Underground Pass", 1)
            .requirement("Summoning", 64).requirement("Crimson charm", 1).requirement("Bagged plant 1", 1).requirement("Pouch", 1)
            .requirement("Spirit shards", 128).reward("Stranger plant pouch", 1).reward("Summoning", 281).build());
        achievements.add(new AchievementBuilder("Deadliest Catch", 0.5).requirement("Druidic Ritual", 1)
            .requirement("Tower of Life", 1).requirement("Hunter", 67).requirement("Fishing", 70).requirement("Thieving", 70)
            .reward("Quest points", 1).reward("Fishing", 70000).reward("Hunter", 26000).reward("Thieving", 8000).build());
        achievements.add(new AchievementBuilder("Sharks are Good for the Elf", 0).requirement("Deadliest Catch", 1)
            .requirement("Regicide", 1).requirement("Fishing", 76).reward("Fishing", 110).reward("Raw shark", 1).build());
        achievements.add(new AchievementBuilder("Pretty and Witty and Dead", 0).requirement("Death tiara", 0)
            .requirement("Pure essence", 20).requirement("Runecrafting", 65).requirement("Mourning's End Part II", 1)
            .reward("Runecrafting", 200).reward("Death rune", 20).build());
        achievements.add(new AchievementBuilder("Papa Pawya", 0.05).requirement("Papaya tree seed", 1).requirement("Hunter", 66)
            .requirement("Farming", 57).requirement("Mourning's End Part I", 1).requirement("Box trap", 0).reward("Raw pawya meat", 1)
            .reward("Farming", 6173).reward("Hunter", 400).build());
        achievements.add(new AchievementBuilder("Mufflebirds", 0).requirement("Regicide", 1).requirement("Agility", 56).build());
        achievements.add(new AchievementBuilder("Light Transit", 0).requirement("Within the Light", 1)
            .requirement("Crystal teleport charge", 1).build());
        achievements.add(new AchievementBuilder("Harrowed Lands", 0).requirement("Tirannwn Set Tasks - Easy", 1)
            .requirement("Clean harralander", 1).requirement("Herblore", 44).reward("Herblore", 72).reward("Harralander tar", 15)
            .build());
        achievements.add(new AchievementBuilder("The Prisoner of Glouphrie", 0.75).requirement("The Path of Glouphrie", 1)
            .requirement("Roving Elves", 1).requirement("Agility", 64).requirement("Construction", 62).requirement("Thieving", 64)
            .requirement("Runecrafting", 61).reward("Quest points", 1).reward("Thieving", 60000).reward("Agility", 60000)
            .reward("Construction", 50000).reward("Runecrafting", 45000).build());
        achievements.add(new AchievementBuilder("Gnome Roaming", 0.05).requirement("The Prisoner of Glouphrie", 1).build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Medium", 0).requirement("Harrowed Lands", 1)
            .requirement("Bowing Out and About", 1).requirement("An Act of War", 1).requirement("Sharks are Good for the Elf", 1)
            .requirement("Gnome Roaming", 1).requirement("Mufflebirds", 1).requirement("The Circle of Life", 1).requirement("Papa Pawya", 1)
            .requirement("Pretty and Witty and Dead", 1).requirement("Light Transit", 1).requirement("Stranger and Stranger", 1)
            .lamp(Player.ALL_SKILLS, 30000, 68).build());
        achievements.add(new AchievementBuilder("The Eyes of Glouphrie", 0.75).requirement("The Grand Tree", 1)
            .requirement("Construction", 5).requirement("Magic", 46).requirement("Mud rune", 1).requirement("Maple logs", 1)
            .requirement("Oak logs", 1).reward("Quest points", 2).reward("Herblore", 1).reward("Magic", 12000).reward("Woodcutting", 2500)
            .reward("Runecrafting", 6000).reward("Construction", 250).build());
        achievements.add(new AchievementBuilder("Xena-Phile", 0).requirement("Smithing", 90).requirement("Plague's End", 1)
            .requirement("Harmonic dust", 1000).requirement("The Eyes of Glouphrie", 1).reward("Smithing", 1500)
            .reward("Attuned crystal dagger", 1).build());
        achievements.add(new AchievementBuilder("Weave Come A Long Way", 0).requirement("Plague's End", 1)
            .requirement("Ball of wool", 9).requirement("Agility", 90).requirement("Attack", 90).requirement("Strength", 90)
            .requirement("Defense", 90).requirement("Ranged", 90).requirement("Prayer", 90).requirement("Constitution", 90)
            .requirement("Crafting", 90).requirement("Mining", 90).requirement("Smithing", 90).requirement("Fishing", 90)
            .requirement("Cooking", 90).requirement("Firemaking", 90).requirement("Woodcutting", 90).requirement("Runecrafting", 90)
            .requirement("Dungeoneering", 90).requirement("Fletching", 90).requirement("Herblore", 90).requirement("Thieving", 90)
            .requirement("Magic", 90).requirement("Slayer", 90).requirement("Farming", 90).requirement("Construction", 90)
            .requirement("Hunter", 90).requirement("Summoning", 90).requirement("Divination", 90).reward("Crafting", 90).build());
        achievements.add(new AchievementBuilder("The Expensive Range", 0.05).requirement("Crafting", 89).requirement("Mining", 81)
            .requirement("Herblore", 76).requirement("Coins", 100000).requirement("Ranging potion (4)", 1)
            .requirement("Super ranging potion (4)", 1).reward("Mining", 70).reward("Crafting", 150).reward("Herblore", 144)
            .reward("Grand ranging potion (6)", 1).build());
        achievements.add(new AchievementBuilder("The Crested Guest is Best", 0).requirement("Plague's End", 1)
            .requirement("Crest of Seren override", 1).build());
        achievements.add(new AchievementBuilder("Robot of Sherwood", 0).requirement("Plague's End", 1).requirement("Thieving", 95)
            .reward("Thieving", 145).reward("Coins", 135).build());
        achievements.add(new AchievementBuilder("Respect Your Elders", 0.05).requirement("Elder seed", 1)
            .requirement("Woodcutting", 90).requirement("Fletching", 90).reward("Woodcutting", 325).reward("Fletching", 101)
            .reward("Elder shortbow (u)", 1).reward("Farming", 23463).build());
        achievements.add(new AchievementBuilder("The Elder Kiln", 1.5).requirement("Magic", 75).requirement("Agility", 60)
            .requirement("Mining", 41).requirement("Rune pickaxe", 0)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Player spoof A"),
                Collections.singletonList("Hardened TzHaar"), Collections.singletonList("Hardened TzHaar"),
                Collections.singletonList("Hardened TzHaar"), Collections.singletonList("Player spoof C"),
                Collections.singletonList("Player spoof B"), Collections.singletonList("Hardened TzHaar"))))
            .encounter(new Encounter("TzHaar-Ket-Yit'tal")).encounter(new Encounter(Collections.singletonList(Arrays.asList("Lava monster",
                "Lava monster", "Lava monster", "TokTz-Ket-Dill"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Lava monster", "Lava monster", "Ket-Zek (TEK)",
                "Ket-Zek (TEK)")))).encounter(new Encounter(Collections.singletonList(Arrays.asList("Lava monster", "Lava monster",
                "Lava monster", "Lava monster", "TokTz-Ket-Dill")))).encounter(new Encounter("TokTz-Ket-Dill"))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Lava monster", "Lava monster", "Lava monster",
                "Yt-MejKot (TEK)")))).encounter(new Encounter(Arrays.asList(Arrays.asList("TokHaar-Hur", "TokHaar-Hur", "TokHaar-Xil"),
                Arrays.asList("TokHaar-Ket", "TokHaar-Xil", "TokHaar-Mej"), Arrays.asList("TokHaar-Xil", "TokHaar-Xil", "TokHaar-Mej"),
                Arrays.asList("TokHaar-Hur", "TokHaar-Hur", "TokHaar-Xil", "TokHaar-Mej"), Arrays.asList("TokHaar-Hur", "TokHaar-Ket",
                    "TokHaar-Xil", "TokHaar-Mej"), Arrays.asList("TokHaar-Mej", "TokHaar-Ket", "TokHaar-Xil", "TokHaar-Mej"),
                Arrays.asList("TokHaar-Ket Champion", "TokHaar-Xil", "TokHaar-Mej")))).reward("Quest points", 2).reward("Magic", 50000)
            .reward("Agility", 30000).lamp(Arrays.asList("Attack", "Strength", "Defense", "Magic", "Ranged"), 100000, 75).build());
        achievements.add(new AchievementBuilder("A Tail of Two Cats", 1.5).requirement("Icthlarin's Little Helper", 1)
            .requirement("Death rune", 5).requirement("Chocolate cake", 1).requirement("Bucket of milk", 1).requirement("Logs", 1)
            .requirement("Potato seed", 4).requirement("Vial of water", 1).requirement("Desert robe", 1).requirement("Desert shirt", 1)
            .reward("Quest points", 2).lamp(Player.ALL_SKILLS, 2500, 30).lamp(Player.ALL_SKILLS, 2500, 30).build());
        achievements.add(new AchievementBuilder("Missing, Presumed Death", 1).encounter(new Encounter(Collections.singletonList(
            Arrays.asList("Wight", "Wight", "Wight", "Wight")))).encounter(new Encounter(Arrays.asList(
            Collections.singletonList("Wight footsoldier"), Arrays.asList("Wight ranger", "Wight ranger"),
            Arrays.asList("Wight footsoldier", "Wight footsoldier", "Wight footsoldier", "Wight footsoldier")))).reward("Quest points", 2)
            .reward("Prayer", 500).reward("Agility", 1000).lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Magic",
                "Ranged"), 1500, 1).build());
        achievements.add(new AchievementBuilder("One of a Kind", 2).requirement("A Tail of Two Cats", 1)
            .requirement("The World Wakes", 1).requirement("King's Ransom", 1).requirement("Missing, Presumed Death", 1)
            .requirement("Divination", 40).requirement("Dungeoneering", 67).requirement("Summoning", 74).requirement("Magic", 81)
            .requirement("Emerald", 1).requirement("Coins", 875).encounter(new Encounter("Iron dragon",
                Collections.singletonList(new Restriction("Dragonfire protection", 1)))).encounter(new Encounter("Iron dragon",
                Collections.singletonList(new Restriction("Dragonfire protection", 1)))).encounter(new Encounter("Iron dragon",
                Collections.singletonList(new Restriction("Dragonfire protection", 1))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Dragon-hunter warrior", "Dragon-hunter mage",
                "Dragon-hunter archer")))).encounter(new Encounter("Echo of Jas")).reward("Quest points", 1).reward("Magic", 90000)
            .reward("Summoning", 80000).reward("Dungeoneering", 45000).reward("Divination", 5000).build());
        achievements.add(new AchievementBuilder("The Branches of Darkmeyer", 1.5).requirement("Legacy of Seergaze", 1)
            .requirement("Legends' Quest", 1).requirement("Woodcutting", 76).requirement("Fletching", 70).requirement("Magic", 70)
            .requirement("Slayer", 67).requirement("Crafting", 64).requirement("Farming", 63).requirement("Agility", 63)
            .encounter(new Encounter("Harold")).encounter(new Encounter("Vanstrom Klause",
                Collections.singletonList(new Restriction("Blisterwood weapon", 1)))).reward("Quest points", 2).reward("Agility", 20000)
            .reward("Woodcutting", 50000).reward("Farming", 20000).reward("Fletching", 40000).reward("Crafting", 20000)
            .reward("Slayer", 25000).reward("Magic", 35000).lamp(Player.ALL_SKILLS, 50000, 60).lamp(Player.ALL_SKILLS, 50000, 60)
            .lamp(Player.ALL_SKILLS, 50000, 60).build());
        achievements.add(new AchievementBuilder("Properly Metal", 0.15).requirement("Slayer", 95).requirement("Plague's End", 1)
            .requirement("Blood Runs Deep", 1).requirement("The Branches of Darkmeyer", 1).requirement("The Elder Kiln", 1)
            .requirement("Ritual of the Mahjarrat", 1).requirement("The Chosen Commander", 1).requirement("The Firemaker's Curse", 1)
            .requirement("The Void Stares Back", 1).requirement("One of a Kind", 1).build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Elite", 0).requirement("99 With a Flake", 1)
            .requirement("Robot of Sherwood", 1).requirement("The Crested Guest is Best", 1).requirement("Ace of Dungeons", 1)
            .requirement("Weave Come A Long Way", 1).requirement("Properly Metal", 1).requirement("Respect Your Elders", 1)
            .requirement("Xena-Phile", 1).requirement("A Screwball Scramble", 1).requirement("The Expensive Range", 1)
            .reward("Crystal motherload shard", 50).reward("Corrupted ore", 100).reward("Cleansing crystal", 10)
            .reward("Harmonic dust", 1000).reward("Crystal weapon", 1).lamp(Player.ALL_SKILLS, 60000, 95).lamp(Player.ALL_SKILLS, 60000, 95)
            .lamp(Player.ALL_SKILLS, 40000, 87).build());
        achievements.add(new AchievementBuilder("Wilderness Volcano", 0).build());
        achievements.add(new AchievementBuilder("Unlocked and Loded", 0).requirement("Wilderness Volcano", 1).build());
        achievements.add(new AchievementBuilder("Ten-uous Link", 0.05).build());
        achievements.add(new AchievementBuilder("Taking the Subway", 0).build());
        achievements.add(new AchievementBuilder("Take a Potato Chip...and Eat It!", 0).build());
        achievements.add(new AchievementBuilder("Repressed", 0.05).reward("Divination", 250).build());
        achievements.add(new AchievementBuilder("Hold my Beer While I PK This Guy", 0).build());
        achievements.add(new AchievementBuilder("Highway to the Danger Zone!", 0).build());
        achievements.add(new AchievementBuilder("Ex-posing Yourself", 0).build());
        achievements.add(new AchievementBuilder("Wilderness Set Tasks - Easy", 0).requirement("Highway to the Danger Zone!", 1)
            .requirement("Chaosteo", 1).requirement("Taking the Subway", 1).requirement("Take a Potato Chip...and Eat It!", 1)
            .requirement("Hold my Beer While I PK This Guy", 1).requirement("Repressed", 1).requirement("Ten-uous Link", 1)
            .requirement("Unlocked and Loded", 1).requirement("Ex-posing Yourself", 1).lamp(Player.ALL_SKILLS, 10000, 30)
            .lamp(Player.ALL_SKILLS, 10000, 30).build());
        achievements.add(new AchievementBuilder("Wet and Wildy", 0).requirement("Woodcutting", 57).build());
        achievements.add(new AchievementBuilder("Notatrivialtask", 0).build());
        achievements.add(new AchievementBuilder("Liquid Luck", 0.05).requirement("Farming", 57).requirement("Bloodweed seed", 1)
            .requirement("Herblore", 57).requirement("Vial of water", 1).requirement("Uncut dragonstone", 1).requirement("Crafting", 55)
            .reward("Farming", 153).reward("Herblore", 138).reward("Crafting", 137).build());
        achievements.add(new AchievementBuilder("I'm Just Bor-rogue-ing it", 0).requirement("Thieving", 32).reward("Coins", 20)
            .reward("Thieving", 12).build());
        achievements.add(new AchievementBuilder("Hardcore Parkour", 0).requirement("Agility", 52).reward("Agility", 571).build());
        achievements.add(new AchievementBuilder("Filthy Rich", 0).requirement("Muddy key", 1).reward("Coins", 5000).build());
        achievements.add(new AchievementBuilder("Doyouthinkhesaurus", 0).requirement("Hunter", 67).requirement("Small fishing net", 0)
            .requirement("Rope", 0).reward("Black salamander", 1).reward("Hunter", 304).build());
        achievements.add(new AchievementBuilder("Don't Axe for Permission", 0).requirement("Thieving", 23).reward("Thieving", 7)
            .requirement("Lockpick", 0).build());
        achievements.add(new AchievementBuilder("Wilderness Set Tasks - Medium", 0).requirement("Don't Axe for Permission", 1)
            .requirement("Filthy Rich", 1).requirement("Hardcore Parkour", 1).requirement("Liquid Luck", 1)
            .requirement("Notatrivialtask", 1).requirement("A Barrel of Staffs", 1).requirement("A Pizza the Loot", 1)
            .requirement("Wet and Wildy", 1).requirement("I'm Just Bor-rogue-ing it", 1).requirement("Doyouthinkhesaurus", 1)
            .lamp(Player.ALL_SKILLS, 40000, 52).lamp(Player.ALL_SKILLS, 40000, 52).build());
        achievements.add(new AchievementBuilder("What Potion?", 0.05).requirement("Bloodweed seed", 1).requirement("Farming", 57)
            .requirement("Vial of water", 1).requirement("Black salamander", 1).requirement("Herblore", 65).reward("Farming", 153)
            .reward("Herblore", 162).build());
        achievements.add(new AchievementBuilder("There's Magic in the Air", 0).requirement("Magic", 66).requirement("Cosmic rune", 3)
            .requirement("Air rune", 30).requirement("Unpowered orb", 1).reward("Air orb", 1).reward("Magic", 76).build());
        achievements.add(new AchievementBuilder("Spirit of Summer", 1.5).requirement("The Restless Ghost", 1)
            .requirement("Summoning", 19).requirement("Farming", 26).requirement("Prayer", 35).requirement("Construction", 40)
            .requirement("Spirit wolf pouch", 1).requirement("Desert wyrm pouch", 1).requirement("Spirit scorpion pouch", 1)
            .reward("Quest points", 1).reward("Construction", 7500).reward("Prayer", 5000).reward("Farming", 2000).reward("Summoning", 1000)
            .build());
        achievements.add(new AchievementBuilder("Summer's End", 1).requirement("Spirit of Summer", 1).requirement("Summoning", 23)
            .requirement("Hunter", 35).requirement("Woodcutting", 37).requirement("Mining", 45).requirement("Firemaking", 47)
            .requirement("Prayer", 55).requirement("Albino rat pouch", 1).reward("Quest points", 1).reward("Summoning", 1500)
            .reward("Hunter", 5000).reward("Mining", 5000).reward("Woodcutting", 5000).reward("Prayer", 10000).reward("Firemaking", 15000)
            .build());
        achievements.add(new AchievementBuilder("The Root of the Problem", 0.05).requirement("Summer's End", 1)
            .requirement("Limpwurt seed", 1).requirement("Farming", 26).reward("Limpwurt root", 3).reward("Farming", 160).build());
        achievements.add(new AchievementBuilder("pUrE a ChAoS oF cOrPsE!", 0).requirement("Chaos Elemental", 1).build());
        achievements.add(new AchievementBuilder("Nerves of Stele", 0.05).build());
        achievements.add(new AchievementBuilder("I'm the King of the Wild!", 0).requirement("King Black Dragon", 1).build());
        achievements.add(new AchievementBuilder("Contract Killer", 0).requirement("Wilderness slayer contract", 1).build());
        achievements.add(new AchievementBuilder("Wilderness Set Tasks - Hard", 0).requirement("Nerves of Stele", 1)
            .requirement("Contract Killer", 1).requirement("pUrE a ChAoS oF cOrPsE!", 1).requirement("What Potion?", 1)
            .requirement("There's Magic in the Air", 1).requirement("I'm the King of the Wild!", 1)
            .requirement("The Root of the Problem", 1).requirement("Cement his Torment", 1).lamp(Player.ALL_SKILLS, 77000, 67)
            .lamp(Player.ALL_SKILLS, 77000, 67).build());
        achievements.add(new AchievementBuilder("Smooth Bakriminel", 0).requirement("Coins", 2000).requirement("Woodcutting", 85)
            .requirement("Fletching", 93).reward("Woodcutting", 320).reward("Fletching", 130).reward("Bakriminel bolts", 10).build());
        achievements.add(new AchievementBuilder("Rev-enge!", 0).encounter(new Encounter("Revenant imp"))
            .encounter(new Encounter("Revenant goblin")).encounter(new Encounter("Revenant icefiend"))
            .encounter(new Encounter("Revenant pyrefiend")).encounter(new Encounter("Revenant hobgoblin"))
            .encounter(new Encounter("Revenant vampyre")).encounter(new Encounter("Revenant werewolf"))
            .encounter(new Encounter("Revenant cyclops")).encounter(new Encounter("Revenant hellhound"))
            .encounter(new Encounter("Revenant demon")).encounter(new Encounter("Revenant ork"))
            .encounter(new Encounter("Revenant dark beast")).encounter(new Encounter("Revenant knight"))
            .encounter(new Encounter("Revenant dragon")).build());
        achievements.add(new AchievementBuilder("Lava Palava", 0).requirement("Slayer", 94)
            .encounter(new Encounter("Lava strykewyrm")).build());
        achievements.add(new AchievementBuilder("Harming Moths", 0).requirement("Hunter", 88).requirement("Agility", 83)
            .reward("Hunter", 650).reward("Agility", 125).build());
        achievements.add(new AchievementBuilder("Wilderness Set Tasks - Elite", 0).requirement("Camping is in Tents", 1)
            .requirement("Lava Palava", 1).requirement("Rev-enge!", 1).requirement("Harming Moths", 1).requirement("Come At Me, Bro!", 1)
            .requirement("Smooth Bakriminel", 1).lamp(Player.ALL_SKILLS, 95000, 85).lamp(Player.ALL_SKILLS, 95000, 85).build());
        achievements.add(new AchievementBuilder("You Wouldn't Like Me When I'm Angry", 0).requirement("A Soul's Bane", 1).build());
        achievements.add(new AchievementBuilder("Ratcatchers", 1.5).requirement("Icthlarin's Little Helper", 1)
            .requirement("Cheese", 4).requirement("Unicorn horn dust", 1).requirement("Clean marrentill", 1)
            .requirement("Bucket of milk", 10).requirement("Empty pot", 1).requirement("Coins", 600).reward("Quest points", 2)
            .reward("Farming", 4).reward("Thieving", 4500).build());
        achievements.add(new AchievementBuilder("With a Ten-foot Pole", 0.05).requirement("Ratcatchers", 1).build());
        achievements.add(new AchievementBuilder("What Lies Below", 0.5).requirement("Rune Mysteries", 1)
            .requirement("Abyssal Reach", 1).requirement("Runecrafting", 35).requirement("Bowl", 1).requirement("Chaos rune", 15)
            .encounter(new Encounter("Outlaw")).encounter(new Encounter("Outlaw")).encounter(new Encounter("Outlaw"))
            .encounter(new Encounter("Outlaw")).encounter(new Encounter("Outlaw")).encounter(new Encounter("King Roald"))
            .reward("Quest points", 1).reward("Defense", 2000).reward("Runecrafting", 8000).build());
        achievements.add(new AchievementBuilder("What Lies Below?", 0).requirement("What Lies Below", 1).requirement("Mining", 42)
            .requirement("Runecrafting", 35).requirement("Chaos talisman", 0).build());
        achievements.add(new AchievementBuilder("Stay Secure", 0.05).reward("Coins", 10000).build());
        achievements.add(new AchievementBuilder("Unlocking Your Emotions", 0).requirement("Stay Secure", 1).build());
        achievements.add(new AchievementBuilder("The Body Shop", 0).requirement("Dragon Slayer", 1).build());
        achievements.add(new AchievementBuilder("Royale With Thieve", 0).requirement("Thieving", 40).reward("Coins", 30)
            .reward("Thieving", 46).build());
        achievements.add(new AchievementBuilder("Digsite pendant unlock", 0.5).requirement("The Dig Site", 1).build());
        achievements.add(new AchievementBuilder("Return to Senntisten", 0).requirement("Digsite pendant unlock", 1)
            .requirement("Ruby necklace", 1).requirement("Fire rune", 5).requirement("Cosmic rune", 1).reward("Magic", 59).build());
        achievements.add(new AchievementBuilder("Promised the Earth", 0).requirement("Runecrafting", 9).requirement("Tiara", 1)
            .requirement("Earth talisman", 1).reward("Earth tiara", 1).reward("Runecrafting", 32).build());
        achievements.add(new AchievementBuilder("Point of En-tree", 0).requirement("Tree Gnome Village", 1).build());
        achievements.add(new AchievementBuilder("Master Scrumper", 0).requirement("Garden of Tranquility", 1).reward("Farming", 12)
            .build());
        achievements.add(new AchievementBuilder("Like a Varrocket", 0).requirement("Air rune", 3).requirement("Fire rune", 1)
            .requirement("Law rune", 3).requirement("Magic", 25).reward("Magic", 35).build());
        achievements.add(new AchievementBuilder("For Fast Transactions", 0).requirement("Agility", 21).build());
        achievements.add(new AchievementBuilder("Flatpack Backpack", 0).requirement("Mahogany logs", 20).requirement("Coins", 30000)
            .reward("Mahogany plank", 20).build());
        achievements.add(new AchievementBuilder("Faster, Pussycat! Kill! Kill!", 0).requirement("Cat training medal", 1).build());
        achievements.add(new AchievementBuilder("Engage", 0).requirement("Varrock balloon route", 1).requirement("Logs", 1).build());
        achievements.add(new AchievementBuilder("Double-strength Weaksauce", 0).requirement("Limpwurt root", 1)
            .requirement("Red spider eggs", 1).requirement("Coins", 5).reward("Strength potion (4)", 1).build());
        achievements.add(new AchievementBuilder("Dial V for Varrock", 0).requirement("Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("Varrock Set Tasks - Medium", 0).requirement("Double-strength Weaksauce", 1)
            .requirement("Champion!", 1).requirement("What Lies Below?", 1).requirement("With a Ten-foot Pole", 1)
            .requirement("Can't Make an Omelette", 1).requirement("Point of En-tree", 1).requirement("Unlocking Your Emotions", 1)
            .requirement("A Lick of Paint", 1).requirement("For Fast Transactions", 1).requirement("You Wouldn't Like Me When I'm Angry", 1)
            .requirement("Return to Senntisten", 1).requirement("Promised the Earth", 1).requirement("Royale With Thieve", 1)
            .requirement("Like a Varrocket", 1).requirement("Challenge Vannaka", 1).requirement("Flatpack Backpack", 1)
            .requirement("Master Scrumper", 1).requirement("Engage", 1).requirement("Faster, Pussycat! Kill! Kill!", 1)
            .requirement("Dial V for Varrock", 1).requirement("The Body Shop", 1).lamp(Player.ALL_SKILLS, 5000, 40).build());
        achievements.add(new AchievementBuilder("Who Ate All the Pie?", 0).requirement("Cooking", 32).requirement("Wild pie", 1)
            .requirement("Chef's hat", 0).build());
        achievements.add(new AchievementBuilder("Waka-Waka-Waka", 0).requirement("Woodcutting", 57).build());
        achievements.add(new AchievementBuilder("Put Your Smithing Hat On", 0).requirement("Smithing", 73)
            .requirement("Adamant bar", 1).reward("Adamant helm", 1).reward("Smithing", 62).build());
        achievements.add(new AchievementBuilder("Living on the Edge", 0).requirement("Desert Treasure", 1).build());
        achievements.add(new AchievementBuilder("Lighten Up", 0).requirement("Dashing kebbit fur", 2).requirement("Coins", 800)
            .reward("Spottier cape", 1).build());
        achievements.add(new AchievementBuilder("Kudos on the Kudos!", 0).requirement("Kudos", 153).build());
        achievements.add(new AchievementBuilder("Keeping Tabs on Varrock", 0).requirement("Fire rune", 1).requirement("Air rune", 3)
            .requirement("Law rune", 1).requirement("Soft clay", 1).requirement("Magic", 25).requirement("Mahogany lectern", 0)
            .reward("Magic", 35).reward("Varrock teleport tablet", 1).build());
        achievements.add(new AchievementBuilder("Intersceptre", 0).requirement("Skull sceptre", 0).build());
        achievements.add(new AchievementBuilder("Hand-Me-Downs", 0).requirement("Family Crest", 1).build());
        achievements.add(new AchievementBuilder("Varrock Set Tasks - Hard", 0).requirement("Burning Bush", 1)
            .requirement("But It Won't Warp You Anywhere", 1).requirement("Lighten Up", 1).requirement("Put Your Smithing Hat On", 1)
            .requirement("Kudos on the Kudos!", 1).requirement("Who Ate All the Pie?", 1).requirement("Battle of the Elements", 1)
            .requirement("Intersceptre", 1).requirement("Changing Rooms", 1).requirement("Keeping Tabs on Varrock", 1)
            .requirement("Hand-Me-Downs", 1).requirement("Waka-Waka-Waka", 1).requirement("Living on the Edge", 1)
            .lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("Stick a Bork In Him, He's Done", 0).requirement("The Hunt for Surok", 1).build());
        achievements.add(new AchievementBuilder("Splitting Headache", 0).requirement("The Temple at Senntisten", 1)
            .requirement("Prayer", 92).build());
        achievements.add(new AchievementBuilder("Red, Red Pies of Summer", 0).requirement("Cooking", 95).requirement("Strawberry", 1)
            .requirement("Watermelon", 1).requirement("Pot of flour", 1).reward("Summer pie", 1).reward("Cooking", 265).build());
        achievements.add(new AchievementBuilder("Nomad's Requiem", 0.85).requirement("King's Ransom", 1)
            .requirement("Knight Waves training ground", 1).requirement("Magic", 75).requirement("Prayer", 70).requirement("Mining", 66)
            .requirement("Hunter", 65).requirement("Constitution", 60).encounter(new Encounter("Decaying avatar"))
            .encounter(new Encounter("Nomad")).reward("Quest points", 3).reward("Zeal", 70).build());
        achievements.add(new AchievementBuilder("Nomadness", 0).requirement("Nomad's Requiem", 1).build());
        achievements.add(new AchievementBuilder("Mind Your Back", 0).requirement("What Lies Below", 1).requirement("Magic", 80)
            .build());
        achievements.add(new AchievementBuilder("It All Adze Up", 0.05).requirement("Inferno adze", 0).requirement("Acorn", 1)
            .reward("Farming", 481).reward("Woodcutting", 37).reward("Firemaking", 60).build());
        achievements.add(new AchievementBuilder("Double Jointed", 0.1).requirement("Woodcutting", 80).reward("Woodcutting", 8580)
            .build());
        achievements.add(new AchievementBuilder("Varrock Set Tasks - Elite", 0).requirement("Stick a Bork In Him, He's Done", 1)
            .requirement("Nomadness", 1).requirement("Double Jointed", 1).requirement("It All Adze Up", 1).requirement("Mind Your Back", 1)
            .requirement("Red, Red Pies of Summer", 1).requirement("Splitting Headache", 1).requirement("A Bolt from the Blue", 1)
            .requirement("A Ton of Earth", 1).lamp(Player.ALL_SKILLS, 40000, 88).lamp(Player.ALL_SKILLS, 40000, 88)
            .lamp(Player.ALL_SKILLS, 40000, 88).lamp(Player.ALL_SKILLS, 30000, 65).build());
        achievements.add(new AchievementBuilder("Strike a Pose", 0).build());
        achievements.add(new AchievementBuilder("Stick the Knife In", 0).build());
        achievements.add(new AchievementBuilder("Sherpa's Delight", 0).requirement("Feather", 1).requirement("Fishing", 20)
            .reward("Raw trout", 1).reward("Fishing", 50).build());
        achievements.add(new AchievementBuilder("Relocation, Relocation, Relocation", 0).requirement("Coins", 5000).build());
        achievements.add(new AchievementBuilder("Read All About It", 0).requirement("Coins", 50).build());
        achievements.add(new AchievementBuilder("Pot Stop", 0).requirement("Soft clay", 1).requirement("Crafting", 8)
            .reward("Bowl", 1).reward("Crafting", 33).build());
        achievements.add(new AchievementBuilder("Plank You Very Much", 0).requirement("Logs", 1).requirement("Coins", 100)
            .reward("Plank", 1).build());
        achievements.add(new AchievementBuilder("On the Ragged Edge", 0).build());
        achievements.add(new AchievementBuilder("Making Learning Fun!", 0).build());
        achievements.add(new AchievementBuilder("Lumbering Around", 0).reward("Logs", 1).reward("Woodcutting", 40).build());
        achievements.add(new AchievementBuilder("Limey", 0).requirement("Mining", 10).reward("Mining", 26).reward("Limestone", 1)
            .build());
        achievements.add(new AchievementBuilder("King of the Castle", 0).build());
        achievements.add(new AchievementBuilder("Jumping-off Point", 0).requirement("Agility", 13).build());
        achievements.add(new AchievementBuilder("Journey to the Centre of the Earth Altar", 0).requirement("Earth talisman", 0)
            .build());
        achievements.add(new AchievementBuilder("Jackanory", 0).requirement("Cup of tea", 1).build());
        achievements.add(new AchievementBuilder("It Belongs in a Museum", 0).requirement("Kudos", 50).build());
        achievements.add(new AchievementBuilder("Essential Facilitator", 0).build());
        achievements.add(new AchievementBuilder("Doing the Ironing", 0).requirement("Mining", 15).reward("Iron ore", 1).build());
        achievements.add(new AchievementBuilder("Dog and Bone", 0).requirement("Bones", 1).build());
        achievements.add(new AchievementBuilder("Varrock Set Tasks - Easy", 0).requirement("Strike a Pose", 1)
            .requirement("Essential Facilitator", 1).requirement("Doing the Ironing", 1).requirement("Plank You Very Much", 1)
            .requirement("Making Learning Fun!", 1).requirement("Jumping-off Point", 1).requirement("Lumbering Around", 1)
            .requirement("Read All About It", 1).requirement("Dog and Bone", 1).requirement("Pot Stop", 1)
            .requirement("On the Ragged Edge", 1).requirement("Relocation, Relocation, Relocation", 1)
            .requirement("It Belongs in a Museum", 1).requirement("Journey to the Centre of the Earth Altar", 1)
            .requirement("Jackanory", 1).requirement("Limey", 1).requirement("Sherpa's Delight", 1).requirement("King of the Castle", 1)
            .requirement("Stick the Knife In", 1).lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("Tyrassed to Impress", 0).requirement("Regicide", 1).requirement("Tyras helm", 0)
            .build());
        achievements.add(new AchievementBuilder("Tirannwn", 0).requirement("Regicide", 1).build());
        achievements.add(new AchievementBuilder("The Motherlode", 0).requirement("Tirannwn", 1).build());
        achievements.add(new AchievementBuilder("Stand Still, Eluned!", 0).requirement("Mourning's End Part I", 1)
            .requirement("Crystal teleport seed", 0).requirement("Coins", 2000).reward("Crystal teleport seed (8)", 1).build());
        achievements.add(new AchievementBuilder("Sick and Twisted", 0).requirement("The Path of Glouphrie", 1)
            .encounter(new Encounter("Warped tortoise")).build());
        achievements.add(new AchievementBuilder("Lime Ordeal", 0).requirement("Mining", 10).requirement("Regicide", 1)
            .reward("Mining", 26).reward("Limestone", 1).build());
        achievements.add(new AchievementBuilder("Leaf Me Alone", 0).requirement("Regicide", 1).build());
        achievements.add(new AchievementBuilder("Iban You from Hurting Me!", 0).requirement("Iban's staff", 1)
            .requirement("Magic", 50).encounter(new Encounter("Disciple of Iban",
                Collections.singletonList(new Restriction("Iban's staff", 1)))).build());
        achievements.add(new AchievementBuilder("Fairy Liquid", 0).requirement("Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("Driven, Underground", 0.1).requirement("Underground Pass", 1)
            .requirement("Thieving", 50).build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Easy", 0).requirement("Iban You from Hurting Me!", 1)
            .requirement("Driven, Underground", 1).requirement("Arandar-bout Way", 1).requirement("Blowing Your Own Trumpet", 1)
            .requirement("The Motherlode", 1).requirement("Tyrassed to Impress", 1).requirement("Lime Ordeal", 1)
            .requirement("Leaf Me Alone", 1).requirement("Fairy Liquid", 1).requirement("Stand Still, Eluned!", 1)
            .requirement("Casting Shadows", 1).requirement("Sick and Twisted", 1).lamp(Player.ALL_SKILLS, 10000, 47).build());
        achievements.add(new AchievementBuilder("Why?", 0).build());
        achievements.add(new AchievementBuilder("Stir, Galahad", 0).reward("Cup of tea", 1).build());
        achievements.add(new AchievementBuilder("Sinclair Swirling", 0).requirement("Murder Mystery", 1).requirement("Cooking", 21)
            .requirement("Bucket of milk", 1).reward("Pat of butter", 1).reward("Cooking", 40).build());
        achievements.add(new AchievementBuilder("Reflax Actions", 0).reward("Flax", 5).reward("Farming", 5).build());
        achievements.add(new AchievementBuilder("Mack Rolled", 0).requirement("Fishing", 16).reward("Fishing", 20)
            .reward("Raw mackerel", 1).build());
        achievements.add(new AchievementBuilder("La Morte D'Arthur", 0).requirement("Poison chalice", 1).build());
        achievements.add(new AchievementBuilder("Jute Alors!", 0).requirement("Farming", 13).requirement("Jute seed", 3)
            .reward("Farming", 13).build());
        achievements.add(new AchievementBuilder("Happy Hour", 0).requirement("Cider", 5).build());
        achievements.add(new AchievementBuilder("Grand Candle", 0).requirement("Coins", 3).build());
        achievements.add(new AchievementBuilder("Seers' Village Set Tasks - Easy", 0).requirement("Reflax Actions", 1)
            .requirement("Why?", 1).requirement("Stir, Galahad", 1).requirement("La Morte D'Arthur", 1)
            .requirement("Another String to Your Bow", 1).requirement("Bunch of Flours", 1).requirement("Happy Hour", 1)
            .requirement("Jute Alors!", 1).requirement("Sinclair Swirling", 1).requirement("Grand Candle", 1)
            .requirement("A Seer-ing Light", 1).requirement("Mack Rolled", 1).lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("The Long of It", 0).requirement("Magic logs", 1).requirement("Fletching", 85)
            .reward("Fletching", 183).reward("Farming", 1).reward("Crafting", 15).reward("Magic shieldbow", 1).build());
        achievements.add(new AchievementBuilder("Plenty-potion-entiary", 0).requirement("Ranged", 40).requirement("Vial of water", 1)
            .requirement("Clean dwarf weed", 1).requirement("Wine of Zamorak", 1).requirement("Herblore", 92)
            .requirement("Grenwall spikes", 5).reward("Herblore", 422).reward("Extreme ranging potion (2)", 1).build());
        achievements.add(new AchievementBuilder("Moon Raker", 0).requirement("Lunar Diplomacy", 1).requirement("Earth rune", 15)
            .requirement("Nature rune", 2).requirement("Astral rune", 3).requirement("Magic", 83).reward("Magic", 87).reward("Farming", 18)
            .build());
        achievements.add(new AchievementBuilder("Make a Bolt For It", 0).requirement("Smithing", 73).requirement("Adamant bar", 1)
            .requirement("Diamond", 1).requirement("Fletching", 65).requirement("Feather", 10).requirement("Magic", 57)
            .requirement("Earth rune", 10).requirement("Cosmic rune", 1).requirement("Law rune", 2).reward("Fletching", 147)
            .reward("Smithing", 62).reward("Magic", 67).reward("Diamond bolts (e)", 10).reward("Diamond bolt tips", 2).build());
        achievements.add(new AchievementBuilder("It's a Trap, No, Wait, It's a Pie!", 0.05).requirement("Potato seed", 3)
            .requirement("Pot of flour", 1).requirement("Bucket of water", 1).requirement("Pie dish", 1).requirement("Cooking", 70)
            .requirement("Fishing", 35).reward("Farming", 17).reward("Fishing", 150).reward("Cooking", 401).reward("Admiral pie", 1)
            .build());
        achievements.add(new AchievementBuilder("Seers' Village Set Tasks - Elite", 0)
            .requirement("It's a Trap, No, Wait, It's a Pie!", 1).requirement("Make a Bolt For It", 1).requirement("The Long of It", 1)
            .requirement("Plenty-potion-entiary", 1).requirement("Moon Raker", 1).lamp(Player.ALL_SKILLS, 30000, 83)
            .lamp(Player.ALL_SKILLS, 30000, 83).lamp(Player.ALL_SKILLS, 30000, 83).lamp(Player.ALL_SKILLS, 30000, 83)
            .lamp(Player.ALL_SKILLS, 25000, 70).build());
        achievements.add(new AchievementBuilder("Water Palaver", 0).requirement("Water rune", 150).requirement("Cosmic rune", 15)
            .requirement("Unpowered orb", 5).requirement("Magic", 56).requirement("Dusty key", 0).reward("Magic", 330)
            .reward("Water orb", 5).build());
        achievements.add(new AchievementBuilder("Twisted Fire Starter", 0).requirement("Magic logs", 1).requirement("Firemaking", 75)
            .reward("Firemaking", 303).build());
        achievements.add(new AchievementBuilder("The Short of It", 0).requirement("Magic shortbow (u)", 1)
            .requirement("Fletching", 80).requirement("Bowstring", 1).reward("Magic shortbow", 1).reward("Fletching", 83).build());
        achievements.add(new AchievementBuilder("See Yew at Five", 0).requirement("Woodcutting", 60).reward("Yew logs", 5)
            .reward("Woodcutting", 875).build());
        achievements.add(new AchievementBuilder("Prayer of Attorney", 0).requirement("Knight Waves training grounds", 1)
            .requirement("Prayer", 70).requirement("Defense", 70).build());
        achievements.add(new AchievementBuilder("Island Hopper", 0).requirement("Iron crossbow", 0).requirement("Mithril grapple", 1)
            .requirement("Agility", 36).requirement("Ranged", 39).requirement("Strength", 22).build());
        achievements.add(new AchievementBuilder("Gonna Need a Bigger Boat", 0).requirement("Fishing", 76).reward("Raw shark", 5)
            .reward("Fishing", 550).build());
        achievements.add(new AchievementBuilder("Gonna Need a Bigger Range", 0).requirement("Raw shark", 5).requirement("Cooking", 80)
            .requirement("Cooking gauntlets", 0).reward("Shark", 5).reward("Cooking", 1050).build());
        achievements.add(new AchievementBuilder("Seers' Village Set Tasks - Hard", 0).requirement("At Home on the Range", 1)
            .requirement("See Yew at Five", 1).requirement("The Short of It", 1).requirement("Prayer of Attorney", 1)
            .requirement("Beware of the Dog", 1).requirement("Twisted Fire Starter", 1).requirement("Alch-aholic", 1)
            .requirement("Gonna Need a Bigger Boat", 1).requirement("Gonna Need a Bigger Range", 1).requirement("Water Palaver", 1)
            .requirement("Island Hopper", 1).lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("What, No Cuddly Toy?", 0).requirement("Ranged", 40).requirement("Archery ticket", 12)
            .reward("Coif", 1).build());
        achievements.add(new AchievementBuilder("Sniper Training", 0).requirement("Ranged", 40).requirement("Shieldbow", 0)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Tower Archer (north)"),
                Collections.singletonList("Tower Archer (east)"), Collections.singletonList("Tower Archer (south)"),
                Collections.singletonList("Tower Archer (west)")), Collections.singletonList(new Restriction("Shieldbow", 1)))).build());
        achievements.add(new AchievementBuilder("Mastering the Elements", 0).requirement("Battered key", 0)
            .encounter(new Encounter("Fire elemental")).encounter(new Encounter("Water elemental"))
            .encounter(new Encounter("Earth elemental")).encounter(new Encounter("Air elemental")).build());
        achievements.add(new AchievementBuilder("King Coal", 0.1).requirement("Coal", -224).build());
        achievements.add(new AchievementBuilder("It's Only a Model", 0).requirement("Law rune", 1).requirement("Air rune", 5)
            .requirement("Magic", 45).reward("Magic", 55).build());
        achievements.add(new AchievementBuilder("Scorpion Catcher", 0.25).requirement("Bar Crawl", 1).requirement("Prayer", 31)
            .encounter(new Encounter("Jailer")).reward("Quest points", 1).reward("Strength", 6625).build());
        achievements.add(new AchievementBuilder("It's a Slightly Magical Stick", 0).requirement("Scorpion Catcher", 1).build());
        achievements.add(new AchievementBuilder("I Can Seer My House From Here", 0).requirement("One Small Favour", 1).build());
        achievements.add(new AchievementBuilder("Fleeing the Scene", 0).requirement("Agility", 48).build());
        achievements.add(new AchievementBuilder("Familiar Fire Familiarity", 0).requirement("Pyrelord pouch", 1)
            .requirement("Maple logs", 1).requirement("Firemaking", 45).requirement("Summoning", 46).reward("Summoning", 2)
            .reward("Firemaking", 145).build());
        achievements.add(new AchievementBuilder("Seers' Village Set Tasks - Medium", 0).requirement("Fleeing the Scene", 1)
            .requirement("It's a Slightly Magical Stick", 1).requirement("King Coal", 1).requirement("I Can Seer My House From Here", 1)
            .requirement("Mastering the Elements", 1).requirement("It's Only a Model", 1).requirement("Sniper Training", 1)
            .requirement("Arch Archer", 1).requirement("What, No Cuddly Toy?", 1).requirement("Familiar Fire Familiarity", 1)
            .requirement("At Least It Doesn't Need Walking", 1).requirement("All Your Bass...", 1).lamp(Player.ALL_SKILLS, 5000, 40)
            .build());
        achievements.add(new AchievementBuilder("Wurt A Bundle", 0.05).requirement("Farming", 26).requirement("Limpwurt seed", 0)
            .reward("Limpwurt root", 3).reward("Farming", 400).build());
        achievements.add(new AchievementBuilder("Struck A-Ghast", 0).requirement("Nature Spirit", 1)
            .encounter(new Encounter("Ghast")).build());
        achievements.add(new AchievementBuilder("Only Going Forward, We Can't Find Reverse", 0.05)
            .requirement("In Aid of the Myreque", 1).build());
        achievements.add(new AchievementBuilder("Lab Clean-Up Assistant", 0).requirement("Creature of Fenkenstrain", 1)
            .encounter(new Encounter("Experiment")).build());
        achievements.add(new AchievementBuilder("It's Only Wafer Thin", 0).requirement("Thin snail", 1).requirement("Cooking", 12)
            .reward("Thin snail meat", 1).reward("Cooking", 70).build());
        achievements.add(new AchievementBuilder("If It Bleeds...", 0).encounter(new Encounter("Bat")).build());
        achievements.add(new AchievementBuilder("Fortified Spirit", 0).requirement("Nature Spirit", 1).build());
        achievements.add(new AchievementBuilder("Dislike-Anthrope", 0).requirement("Priest in Peril", 1)
            .encounter(new Encounter("Human werewolf", Collections.singletonList(new Restriction("Wolfbane dagger", 1)))).build());
        achievements.add(new AchievementBuilder("Cranius Lupus", 0.05).requirement("Agility", 25)
            .requirement("Creature of Fenkenstrain", 1).reward("Agility", 750).build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Easy", 0).requirement("Chiselin' Conchiolin", 1)
            .requirement("It's Only Wafer Thin", 1).requirement("Dislike-Anthrope", 1).requirement("Cranius Lupus", 1)
            .requirement("Lab Clean-Up Assistant", 1).requirement("Fortified Spirit", 1).requirement("Struck A-Ghast", 1)
            .requirement("Blooming Marvellous", 1).requirement("Only Going Forward, We Can't Find Reverse", 1)
            .requirement("If It Bleeds...", 1).requirement("Wurt A Bundle", 1).lamp(Player.ALL_SKILLS, 4000, 25).build());
        achievements.add(new AchievementBuilder("Whip: It Good", 0).requirement("Slayer", 85)
            .encounter(new Encounter("Abyssal demon")).build());
        achievements.add(new AchievementBuilder("Thoroughly A-Ghast", 0).requirement("Temple Trekking total level", 594)
            .requirement("Coins", 50000).requirement("Summoning", 87).reward("Summoning", 1).build());
        achievements.add(new AchievementBuilder("Set It On Fiyr", 0).requirement("Fiyr remains", 1).requirement("Firemaking", 80)
            .requirement("Magic pyre logs", 1).requirement("Shades of Mort'ton", 1).reward("Firemaking", 404).build());
        achievements.add(new AchievementBuilder("On Wings of Bling", 0).requirement("The Branches of Darkmeyer", 1).build());
        achievements.add(new AchievementBuilder("Not Such a Rotten Idea", 0).requirement("Games necklace (8)", 1)
            .requirement("Temple Trekking total level", 500).build());
        achievements.add(new AchievementBuilder("Fremennik Export", 0).requirement("Barbarian Fishing", 1).requirement("Fishing", 96)
            .requirement("Strength", 76).reward("Raw shark", 1).reward("Fishing", 110).reward("Strength", 11).build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Elite", 0).requirement("Whip: It Good", 1)
            .requirement("As You Might Expect", 1).requirement("Thoroughly A-Ghast", 1).requirement("As Good As Renew", 1)
            .requirement("Fremennik Export", 1).requirement("Not Such a Rotten Idea", 1).requirement("Set It On Fiyr", 1)
            .requirement("Bros Before Barrows", 1).requirement("On Wings of Bling", 1).lamp(Player.ALL_SKILLS, 40000, 75)
            .lamp(Player.ALL_SKILLS, 50000, 80).lamp(Player.ALL_SKILLS, 50000, 80).build());
        achievements.add(new AchievementBuilder("Trekkin' Ain't Easy", 0.05).requirement("In Aid of the Myreque", 1).build());
        achievements.add(new AchievementBuilder("Time Salver", 0).requirement("Agility", 65).build());
        achievements.add(new AchievementBuilder("They'll Just Throw It Away Again", 0).requirement("Creature of Fenkenstrain", 1)
            .requirement("Agility", 60).reward("Agility", 540).build());
        achievements.add(new AchievementBuilder("Shade-Shattering Ka-Bloom", 0).requirement("Legacy of Seergaze", 1)
            .requirement("Vyre corpses burned", 200).build());
        achievements.add(new AchievementBuilder("Runecraft Carrier", 0).requirement("Legacy of Seergaze", 1)
            .requirement("Blood altar teleport", 1).build());
        achievements.add(new AchievementBuilder("Raising The Stakes", 0).requirement("The Branches of Darkmeyer", 1)
            .requirement("Silver sickle", 1).reward("Fletching", 100).reward("Woodcutting", 200).reward("Blisterwood polearm", 1)
            .build());
        achievements.add(new AchievementBuilder("Just One More Key...", 0).requirement("Columbarium key", 1).build());
        achievements.add(new AchievementBuilder("I Brought Your Stuff Back", 0).requirement("Barrows set", 0)
            .requirement("Defense", 70).requirement("Attack", 70).build());
        achievements.add(new AchievementBuilder("Huge Success", 0).requirement("Desert Treasure", 1).requirement("Construction", 50)
            .requirement("Coins", 100000).requirement("Magic", 66).requirement("Law rune", 200).requirement("Blood rune", 100)
            .reward("Magic", 380).build());
        achievements.add(new AchievementBuilder("Detarnation", 0).requirement("The Lair of Tarn Razorlor", 1).build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Hard", 0).requirement("Detarnation", 1)
            .requirement("Runecraft Carrier", 1).requirement("Shade-Shattering Ka-Bloom", 1)
            .requirement("They'll Just Throw It Away Again", 1).requirement("Time Salver", 1).requirement("Huge Success", 1)
            .requirement("I Brought Your Stuff Back", 1).requirement("Just One More Key...", 1).requirement("Raising The Stakes", 1)
            .requirement("Trekkin' Ain't Easy", 1).requirement("Better Than Cursing The Darkness", 1).lamp(Player.ALL_SKILLS, 20000, 65)
            .build());
        achievements.add(new AchievementBuilder("Who You Gonna Ring?", 0).requirement("Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("Ghosts Ahoy", 0.25).requirement("Priest in Peril", 1)
            .requirement("The Restless Ghost", 1).requirement("Agility", 25).requirement("Cooking", 20).requirement("Coins", 1000)
            .requirement("Thread", 1).requirement("Silk", 1).requirement("Spade", 0).requirement("Oak shieldbow", 1)
            .requirement("Bucket of milk", 1).requirement("Red dye", 1).requirement("Blue dye", 1).requirement("Yellow dye", 1)
            .requirement("Ecto-token", 6).requirement("Bowl of water", 1)
            .encounter(new Encounter("Giant lobster")).reward("Cooking", 52).reward("Quest points", 2).reward("Prayer", 2400).build());
        achievements.add(new AchievementBuilder("Travelling on the Slime Trail", 0).requirement("Ghosts Ahoy", 1).build());
        achievements.add(new AchievementBuilder("The Yeast They Can Do", 0).requirement("Ecto-token", 5).requirement("Empty pot", 1)
            .requirement("The Restless Ghost", 1).reward("Ale yeast", 1).build());
        achievements.add(new AchievementBuilder("The Higher, The Better", 0).requirement("Slayer", 45)
            .encounter(new Encounter("Infernal mage")).build());
        achievements.add(new AchievementBuilder("The Beer Inn-spectre", 0).requirement("Cooking", 14).requirement("Cooking apple", 16)
            .requirement("Ale yeast", 1).requirement("Bucket", 0).build());
        achievements.add(new AchievementBuilder("Ready? Trek!", 0.05).requirement("In Aid of the Myreque", 1).build());
        achievements.add(new AchievementBuilder("Haunted Mine", 1.5).requirement("Priest in Peril", 1)
            .requirement("Nature Spirit", 1).requirement("Agility", 15).requirement("Crafting", 35).encounter(new Encounter("Treus Dayth"))
            .reward("Quest points", 2).lamp(Collections.singletonList("Strength"), 22000, 35).build());
        achievements.add(new AchievementBuilder("Polterheist", 0).requirement("Mining", 55).requirement("Haunted Mine", 1)
            .reward("Mithril ore", 1).reward("Mining", 80).build());
        achievements.add(new AchievementBuilder("Plenty Mort Where That Came From", 0).requirement("Shade key", 1).build());
        achievements.add(new AchievementBuilder("Dwarf Cannon", 0.75).reward("Quest points", 1).reward("Crafting", 750).build());
        achievements.add(new AchievementBuilder("Obvious Forgery", 0).requirement("Dwarf Cannon", 1).requirement("Steel bar", 1)
            .requirement("Smithing", 35).reward("Cannonball", 4).reward("Smithing", 25).build());
        achievements.add(new AchievementBuilder("Izzy Wizzy Let's Get Lizzy", 0).requirement("Rope", 0)
            .requirement("Small fishing net", 0).requirement("Hunter", 29).reward("Hunter", 152).reward("Swamp lizard", 1).build());
        achievements.add(new AchievementBuilder("I Wonder How Far It Ghost?", 0).requirement("In Search of the Myreque", 1).build());
        achievements.add(new AchievementBuilder("Gate Spectre-ations", 0).requirement("Ecto-token", 2).build());
        achievements.add(new AchievementBuilder("Fun Guy But Bitter", 0.05).requirement("Farming", 53)
            .requirement("Bittercap mushroom spore", 1).reward("Farming", 413).reward("Bittercap mushroom", 6).build());
        achievements.add(new AchievementBuilder("Flamtaer Will Get You Everywhere", 0).requirement("Shades of Mort'ton", 1)
            .requirement("Flamtaer hammer", 0).build());
        achievements.add(new AchievementBuilder("Finding Your Balance", 0).requirement("Restore potion (3)", 1)
            .requirement("Garlic", 1).requirement("Silver dust", 1).requirement("In Aid of the Myreque", 1).requirement("Herblore", 22)
            .reward("Guthix balance (3)", 1).reward("Herblore", 50).build());
        achievements.add(new AchievementBuilder("Don't Stop Me If I Start To Ramble", 0.05).requirement("Darkness of Hallowvale", 1)
            .build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Medium", 0).requirement("Charter A Course", 1)
            .requirement("Travelling on the Slime Trail", 1).requirement("The Yeast They Can Do", 1)
            .requirement("Flamtaer Will Get You Everywhere", 1).requirement("Who You Gonna Ring?", 1)
            .requirement("Barking Up the Wrong Tree", 1).requirement("Gate Spectre-ations", 1).requirement("Ready? Trek!", 1)
            .requirement("Don't Stop Me If I Start To Ramble", 1).requirement("Plenty Mort Where That Came From", 1)
            .requirement("Izzy Wizzy Let's Get Lizzy", 1).requirement("Finding Your Balance", 1).requirement("The Beer Inn-spectre", 1)
            .requirement("Brain Bending", 1).requirement("I Wonder How Far It Ghost?", 1).requirement("Obvious Forgery", 1)
            .requirement("The Higher, The Better", 1).requirement("Fun Guy But Bitter", 1).requirement("Polterheist", 1)
            .requirement("Ad-Myre The Goods", 1).lamp(Player.ALL_SKILLS, 10000, 46).build());
        achievements.add(new AchievementBuilder("'Phite Club", 0).requirement("'Phite Club (quest)", 1).build());
        achievements.add(new AchievementBuilder("Our Man in the North", 0).requirement("Our Man in the North (quest)", 1).build());
        achievements.add(new AchievementBuilder("The Golem", 0.75).requirement("Crafting", 20).requirement("Thieving", 25)
            .requirement("Vial", 1).requirement("Soft clay", 4).requirement("Papyrus", 1).reward("Quest points", 1).reward("Thieving", 1000)
            .reward("Crafting", 1000).build());
        achievements.add(new AchievementBuilder("Missing My Mummy", 1).requirement("The Golem", 1)
            .requirement("Icthlarin's Little Helper", 1).requirement("Garden of Tranquility", 1).requirement("Construction", 35)
            .requirement("Cooking", 35).requirement("Crafting", 45).requirement("Magic", 50).requirement("Prayer", 45)
            .requirement("Thieving", 25).requirement("Willow logs", 1).requirement("Fire rune", 20).requirement("Jug of wine", 1)
            .requirement("Spice", 1).requirement("Wheat", 1).requirement("Empty pot", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Skeleton looter"),
                Collections.singletonList("Skeleton looter"), Collections.singletonList("Skeleton looter"),
                Collections.singletonList("Skeleton looter")))).encounter(new Encounter("Golem Guard"))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Tumeken's shadow 1"),
                Collections.singletonList("Tumeken's shadow 2"), Collections.singletonList("Tumeken's shadow 3"),
                Collections.singletonList("Tumeken's shadow 4"), Collections.singletonList("Tumeken's shadow 5"))))
            .reward("Quest points", 1).reward("Coins", 5000).reward("Constitution", 7000).reward("Cooking", 2100)
            .reward("Construction", 2100).reward("Magic", 5000).reward("Prayer", 6500).reward("Crafting", 3350).reward("Thieving", 3000)
            .build());
        achievements.add(new AchievementBuilder("Crocodile Tears", 0.5).requirement("Dealing with Scabaras", 1)
            .requirement("The Jack of Spades", 1).requirement("Missing My Mummy", 1).requirement("Spirits of the Elid", 1)
            .requirement("Menaphos reputation", 19800).requirement("Hunter", 73).requirement("Fishing", 72).requirement("Woodcutting", 47)
            .requirement("Agility", 30).requirement("Rope", 1).requirement("Fishing bait", 1).requirement("Coins", 21000)
            .encounter(new Encounter("Ukunduka")).reward("Fishing", 35092).reward("Menaphos reputation", 5754).reward("Woodcutting", 15094)
            .reward("Agility", 19856).reward("Hunter", 39080).reward("Quest points", 1).build());
        achievements.add(new AchievementBuilder("Menaphos Pyramid Scheme", 0).requirement("The Jack of Spades", 1)
            .requirement("Our Man in the North", 1).requirement("Crocodile Tears", 1).requirement("'Phite Club", 1)
            .requirement("Boys to Menaphites", 1).build());
        achievements.add(new AchievementBuilder("Window Shopping", 0).build());
        achievements.add(new AchievementBuilder("Wait, That's Not a Sheep", 0).build());
        achievements.add(new AchievementBuilder("Very Potter", 0).requirement("Soft clay", 1).reward("Pot (unfired)", 1)
            .reward("Crafting", 6).build());
        achievements.add(new AchievementBuilder("Tower Power", 0).build());
        achievements.add(new AchievementBuilder("Tinkle the Ivories", 0).build());
        achievements.add(new AchievementBuilder("The Rules of Engagement", 0).build());
        achievements.add(new AchievementBuilder("The Nexus Has You", 0).build());
        achievements.add(new AchievementBuilder("The Fruit of the Sea", 0).requirement("Raw shrimps", 1).reward("Coins", 1).build());
        achievements.add(new AchievementBuilder("Take Your Pick", 0).reward("Mining", 17).reward("Copper ore", 1).build());
        achievements.add(new AchievementBuilder("Shrimpin' Ain't Easy", 0).reward("Raw shrimps", 1).reward("Fishing", 10).build());
        achievements.add(new AchievementBuilder("Sage Advice", 0).build());
        achievements.add(new AchievementBuilder("Ring My Bell", 0).build());
        achievements.add(new AchievementBuilder("Raise the Roof", 0).build());
        achievements.add(new AchievementBuilder("Master of All I Survey", 0).build());
        achievements.add(new AchievementBuilder("Just Add Water", 0).requirement("Clay", 1).reward("Soft clay", 1)
            .reward("Crafting", 1).build());
        achievements.add(new AchievementBuilder("In the Countyard", 0).build());
        achievements.add(new AchievementBuilder("Hotpot", 0).requirement("Pot (unfired)", 1).reward("Empty pot", 1)
            .reward("Crafting", 6).build());
        achievements.add(new AchievementBuilder("Hail to the Duke, Baby", 0).build());
        achievements.add(new AchievementBuilder("Grinding My Gears", 0).requirement("Wheat", 1).requirement("Empty pot", 1)
            .reward("Pot of flour", 1).build());
        achievements.add(new AchievementBuilder("Doom!", 0).build());
        achievements.add(new AchievementBuilder("Docking Out", 0).build());
        achievements.add(new AchievementBuilder("Lumbridge Set Tasks - Beginner", 0).requirement("Master of All I Survey", 1)
            .requirement("Raise the Roof", 1).requirement("Hail to the Duke, Baby", 1).requirement("Doom!", 1).requirement("Sage Advice", 1)
            .requirement("Window Shopping", 1).requirement("Wait, That's Not a Sheep", 1).requirement("The Nexus Has You", 1)
            .requirement("Clay More", 1).requirement("Just Add Water", 1).requirement("Very Potter", 1).requirement("Hotpot", 1)
            .requirement("In the Countyard", 1).requirement("Grinding My Gears", 1).requirement("Beware of Pigzilla", 1)
            .requirement("The Rules of Engagement", 1).requirement("Tower Power", 1).requirement("Take Your Pick", 1)
            .requirement("Shrimpin' Ain't Easy", 1).requirement("The Fruit of the Sea", 1).requirement("A Grave Consideration", 1)
            .requirement("Tinkle the Ivories", 1).requirement("Ring My Bell", 1).requirement("Docking Out", 1)
            .lamp(Player.ALL_SKILLS, 500, 1).build());
        achievements.add(new AchievementBuilder("You Doity Rat", 0).encounter(new Encounter("Giant rat")).build());
        achievements.add(new AchievementBuilder("What Is This Place?", 0).build());
        achievements.add(new AchievementBuilder("Slippery When Wet", 0).requirement("Pure essence", 1).requirement("Runecrafting", 5)
            .requirement("Water talisman", 0).reward("Water rune", 1).reward("Runecrafting", 6).build());
        achievements.add(new AchievementBuilder("Ratatouille", 0).requirement("Raw rat meat", 1).build());
        achievements.add(new AchievementBuilder("Nowt Tool Look At", 0).build());
        achievements.add(new AchievementBuilder("Morgan the Merrier", 0).requirement("Clay ring", 1).reward("Coins", 10).build());
        achievements.add(new AchievementBuilder("Money Down the Drayn", 0).build());
        achievements.add(new AchievementBuilder("Klept-Old-Man-ia", 0).build());
        achievements.add(new AchievementBuilder("It Was Dead Already!", 0).reward("Logs", 1).reward("Woodcutting", 25).build());
        achievements.add(new AchievementBuilder("Iron On", 0).requirement("Mining", 15).reward("Iron ore", 1).reward("Mining", 35)
            .build());
        achievements.add(new AchievementBuilder("I Can't Hear Dead People", 0).requirement("The Restless Ghost", 1).build());
        achievements.add(new AchievementBuilder("Eye on the Prize", 0).build());
        achievements.add(new AchievementBuilder("Draaaaaiiiiiins...", 0).encounter(new Encounter("Zombie")).build());
        achievements.add(new AchievementBuilder("Lumbridge Set Tasks - Easy", 0).requirement("Artisan Crafting", 1)
            .requirement("Bless is More", 1).requirement("Morgan the Merrier", 1).requirement("Iron On", 1)
            .requirement("And It Was THIS Big!", 1).requirement("Belter of a Smelter", 1).requirement("Nowt Tool Look At", 1)
            .requirement("You Doity Rat", 1).requirement("It Was Dead Already!", 1).requirement("Camping Trip", 1)
            .requirement("Ratatouille", 1).requirement("Slippery When Wet", 1).requirement("I Can't Hear Dead People", 1)
            .requirement("Come In Here and Say That", 1).requirement("What Is This Place?", 1).requirement("Money Down the Drayn", 1)
            .requirement("Klept-Old-Man-ia", 1).requirement("Eye on the Prize", 1).requirement("Draaaaaiiiiiins...", 1)
            .lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("Not Waving, But Drowning", 0).requirement("Pure essence", 27)
            .requirement("Water talisman", 0).reward("Runecrafting", 162).reward("Water rune", 100).build());
        achievements.add(new AchievementBuilder("Have your Cake and Eat It", 0).requirement("Egg", 1).requirement("Pot of flour", 1)
            .requirement("Bucket of milk", 1).requirement("Cooking", 50).requirement("Cook's Assistant", 1).requirement("Chocolate bar", 1)
            .reward("Cooking", 210).reward("Chocolate cake", 1).build());
        achievements.add(new AchievementBuilder("Gods, Give Me Strength", 0).requirement("Prayer", 45).build());
        achievements.add(new AchievementBuilder("Lumbridge Set Tasks - Hard", 0).requirement("A Body in the Sewers", 1)
            .requirement("Building Up Strength", 1).requirement("Have your Cake and Eat It", 1).requirement("Blast and Hellfire", 1)
            .requirement("Gods, Give Me Strength", 1).requirement("Not Waving, But Drowning", 1)
            .requirement("Are Yew As Fired Up As I Am?", 1).lamp(Player.ALL_SKILLS, 9000, 49).build());
        achievements.add(new AchievementBuilder("Willow the Wisp of Smoke", 0).requirement("Willow logs", 1)
            .requirement("Firemaking", 30).reward("Firemaking", 90).build());
        achievements.add(new AchievementBuilder("Where's The Beef?", 0).requirement("Raw beef", 1).build());
        achievements.add(new AchievementBuilder("Weeping Willow", 0).requirement("Woodcutting", 30).reward("Willow logs", 1)
            .reward("Woodcutting", 67).build());
        achievements.add(new AchievementBuilder("Steel Justice", 0).requirement("Steel bar", 2).requirement("Smithing", 36)
            .reward("Smithing", 75).reward("Steel longsword", 1).build());
        achievements.add(new AchievementBuilder("One Day, You Shall Be a Fork", 0).requirement("Silver ore", 1)
            .requirement("Smithing", 20).reward("Smithing", 14).reward("Silver bar", 1).build());
        achievements.add(new AchievementBuilder("Made to Order", 0).requirement("Silver bar", 1).requirement("Crafting", 16)
            .reward("Unstrung symbol", 1).reward("Crafting", 54).build());
        achievements.add(new AchievementBuilder("Lovely With a Squeeze of Lemon", 0).requirement("Fishing", 30)
            .requirement("Feather", 1).reward("Raw salmon", 1).reward("Fishing", 70).build());
        achievements.add(new AchievementBuilder("Hi Ho, Silver", 0).requirement("Mining", 20).reward("Silver ore", 1)
            .reward("Mining", 40).build());
        achievements.add(new AchievementBuilder("Everybody Loves Coal!", 0).requirement("Mining", 30).reward("Coal", 1)
            .reward("Mining", 50).build());
        achievements.add(new AchievementBuilder("Ease of Access", 0).requirement("Magic", 31).requirement("Law rune", 1)
            .requirement("Earth rune", 1).requirement("Air rune", 3).reward("Magic", 41).build());
        achievements.add(new AchievementBuilder("Lumbridge Set Tasks - Medium", 0).requirement("Steel Justice", 1)
            .requirement("Ease of Access", 1).requirement("Everybody Loves Coal!", 1).requirement("Weeping Willow", 1)
            .requirement("Willow the Wisp of Smoke", 1).requirement("A Meal Fit for a Duke", 1).requirement("Always Be Prepared", 1)
            .requirement("Hi Ho, Silver", 1).requirement("Lovely With a Squeeze of Lemon", 1).requirement("One Day, You Shall Be a Fork", 1)
            .requirement("Made to Order", 1).requirement("Where's The Beef?", 1).lamp(Player.ALL_SKILLS, 1500, 35).build());
        achievements.add(new AchievementBuilder("TzHaar Wars", 0).build());
        achievements.add(new AchievementBuilder("Show That You Cairn", 0).requirement("Agility", 15).build());
        achievements.add(new AchievementBuilder("Put to Port in Port Sarim", 0).requirement("Coins", 30).build());
        achievements.add(new AchievementBuilder("It's a Jungle Ogre", 0).encounter(new Encounter("Jogre")).build());
        achievements.add(new AchievementBuilder("I'm Lichen This!", 0).requirement("Agility", 10).build());
        achievements.add(new AchievementBuilder("Golden Shores", 0).requirement("Mining", 40).reward("Gold ore", 1)
            .reward("Mining", 65).build());
        achievements.add(new AchievementBuilder("Fruity Catch", 0).requirement("Fishing", 5).build());
        achievements.add(new AchievementBuilder("Five a Day", 0).reward("Banana", 5).build());
        achievements.add(new AchievementBuilder("Karamja Set Tasks - Easy", 0).requirement("Five a Day", 1)
            .requirement("I'm Lichen This!", 1).requirement("Golden Shores", 1).requirement("Put to Port in Port Sarim", 1)
            .requirement("Avast Ardougne!", 1).requirement("Show That You Cairn", 1).requirement("Fruity Catch", 1)
            .requirement("Beachcomber", 1).requirement("TzHaar Wars", 1).requirement("It's a Jungle Ogre", 1)
            .lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("Walkies!", 0).requirement("Chameleon", 0).build());
        achievements.add(new AchievementBuilder("Tread Carefully", 0).requirement("Agility", 74).requirement("Shilo Village", 1)
            .build());
        achievements.add(new AchievementBuilder("The Power of Lava", 0).requirement("Fire cape", 1).build());
        achievements.add(new AchievementBuilder("Ten in a Row", 1).requirement("Combat", 100).requirement("Slayer", 50)
            .requirement("Shilo Village", 1).requirement("While Guthix Sleeps", 1).requirement("Slayer task streak", 9).build());
        achievements.add(new AchievementBuilder("It's a Snap", 0).requirement("Herblore", 63).requirement("Vial of water", 1)
            .requirement("Red spiders' eggs", 1).requirement("Agility arena ticket", 10).reward("Super restore (3)", 1)
            .reward("Herblore", 142).build());
        achievements.add(new AchievementBuilder("Crunchy Coating", 0).requirement("Raw shark", 1).reward("Shark", 1)
            .reward("Cooking", 210).build());
        achievements.add(new AchievementBuilder("Karamja Set Tasks - Elite", 0).requirement("The Power of Lava", 1)
            .requirement("At One Plus Fifty-Five With Nature", 1).requirement("Boxing Clever", 1).requirement("It's a Snap", 1)
            .requirement("Crunchy Coating", 1).requirement("Walkies!", 1).requirement("Tread Carefully", 1).requirement("Ten in a Row", 1)
            .lamp(Player.ALL_SKILLS, 55000, 87).lamp(Player.ALL_SKILLS, 55000, 87).lamp(Player.ALL_SKILLS, 30000, 64).build());
        achievements.add(new AchievementBuilder("Yes, My Master", 0).requirement("Combat", 100).requirement("Slayer", 50)
            .requirement("Shilo Village", 1).build());
        achievements.add(new AchievementBuilder("Quick As a Shot", 0).requirement("Mithril grapple", 1)
            .requirement("Iron crossbow", 0).requirement("Agility", 53).requirement("Ranged", 42).requirement("Strength", 21).build());
        achievements.add(new AchievementBuilder("Play Dead, Doggy", 0)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Tz-Kih"), Arrays.asList("Tz-Kih", "Tz-Kih"),
                Collections.singletonList("Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kih", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"),
                Collections.singletonList("Tok-Xil"), Arrays.asList("Tok-Xil", "Tz-Kih"), Arrays.asList("Tok-Xil", "Tz-Kih", "Tz-Kih"),
                Arrays.asList("Tok-Xil", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tok-Xil", "Tz-Kek", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tok-Xil", "Tz-Kek", "Tz-Kih", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tok-Xil", "Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek",
                    "Tz-Kek"), Arrays.asList("Tok-Xil", "Tok-Xil"), Collections.singletonList("Yt-MejKot"),
                Arrays.asList("Yt-MejKot", "Tz-Kih"), Arrays.asList("Yt-MejKot", "Tz-Kih", "Tz-Kih"), Arrays.asList("Yt-MejKot", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tz-Kek", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Yt-MejKot", "Tz-Kek", "Tz-Kih", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Yt-MejKot", "Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"),
                Arrays.asList("Yt-MejKot", "Tok-Xil"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kih"),
                Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kih", "Tz-Kih"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kek", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kek", "Tz-Kih", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kek", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tok-Xil"),
                Arrays.asList("Yt-MejKot", "Yt-MejKot"), Collections.singletonList("Ket-Zek")))).build());
        achievements.add(new AchievementBuilder("I'd Be Kharazi to Eat This", 0).requirement("Cooked oomlie wrap", 1).build());
        achievements.add(new AchievementBuilder("Flawless Victory", 0).build());
        achievements.add(new AchievementBuilder("Tai Bwo Wannai Trio", 1.5).requirement("Jungle Potion", 1).requirement("Fishing", 5)
            .requirement("Agility", 15).requirement("Cooking", 30).requirement("Agility potion (4)", 1).requirement("Iron spear", 1)
            .requirement("Raw karambwan", 2).requirement("Coins", 30).requirement("Jogre bones", 1).encounter(new Encounter("Monkey"))
            .reward("Quest points", 2).reward("Coins", 2000).reward("Fishing", 1500).build());
        achievements.add(new AchievementBuilder("Drop It Like It's Hot", 0).requirement("Raw karambwan", 1).requirement("Cooking", 30)
            .requirement("Tai Bwo Wannai Trio", 1).reward("Cooking", 190).reward("Cooked karambwan", 1).build());
        achievements.add(new AchievementBuilder("Deadwing", 0).requirement("Legends' Quest", 1)
            .encounter(new Encounter("Death wing")).build());
        achievements.add(new AchievementBuilder("Karamja Set Tasks - Hard", 0).requirement("Flawless Victory", 1)
            .requirement("Play Dead, Doggy", 1).requirement("I'd Be Kharazi to Eat This", 1).requirement("At One With Nature", 1)
            .requirement("Drop It Like It's Hot", 1).requirement("Deadwing", 1).requirement("Quick As a Shot", 1)
            .requirement("Can Opener", 1).requirement("Yes, My Master", 1).requirement("A Palm For Each Finger", 1)
            .lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("To Catch a Karambwan", 0).requirement("Tai Bwo Wannai Trio", 1)
            .requirement("Fishing", 65).reward("Fishing", 110).reward("Raw karambwan", 1).build());
        achievements.add(new AchievementBuilder("They Like Me! They Really Like Me!", 0).requirement("Tai Bwo Wannai favour", 100)
            .build());
        achievements.add(new AchievementBuilder("The Roots of All Evil", 0).requirement("Coins", 875).requirement("Woodcutting", 10)
            .build());
        achievements.add(new AchievementBuilder("That's Not a Knife...", 0).requirement("Jungle Potion", 1)
            .requirement("Trading sticks", 300).requirement("Gout tuber", 1).requirement("Uncut opal", 3).reward("Opal machete", 1)
            .build());
        achievements.add(new AchievementBuilder("Thank You, Madam", 0).requirement("Shilo Village", 1).requirement("Coins", 50)
            .build());
        achievements.add(new AchievementBuilder("Stairway to Haven", 0).requirement("Coins", 875).requirement("Woodcutting", 10)
            .build());
        achievements.add(new AchievementBuilder("Shipping Out From the Shipyard", 0).requirement("The Grand Tree", 1)
            .requirement("Coins", 200).build());
        achievements.add(new AchievementBuilder("Scourge of Scurvy", 0.05).requirement("Farming", 27)
            .requirement("Apple tree seed", 1).reward("Farming", 1221).build());
        achievements.add(new AchievementBuilder("Romancing the Stone", 0).requirement("Mining", 40).requirement("Jungle Potion", 1)
            .reward("Uncut red topaz", 1).reward("Mining", 65).build());
        achievements.add(new AchievementBuilder("Points of No Return", 0).requirement("Agility", 12).requirement("Coins", 875)
            .build());
        achievements.add(new AchievementBuilder("Just the Ticket", 0).requirement("Agility arena ticket", 1).build());
        achievements.add(new AchievementBuilder("I Sleep All Night and I Work All Day", 0).requirement("Tai Bwo Wannai Trio", 1)
            .requirement("Woodcutting", 50).reward("Woodcutting", 125).reward("Mahogany logs", 1).build());
        achievements.add(new AchievementBuilder("I'm a Lumberjack and I'm Okay", 0).requirement("Tai Bwo Wannai Trio", 1)
            .requirement("Woodcutting", 35).reward("Woodcutting", 85).reward("Teak logs", 1).build());
        achievements.add(new AchievementBuilder("Hunters of the Horned Graahk", 0).requirement("Hunter", 41)
            .requirement("Teasing stick", 0).requirement("Logs", 1).reward("Hunter", 240).build());
        achievements.add(new AchievementBuilder("Horseless Carriage", 0).requirement("Shilo Village", 1).requirement("Coins", 10)
            .build());
        achievements.add(new AchievementBuilder("Falling With Style", 0).requirement("The Grand Tree", 1).build());
        achievements.add(new AchievementBuilder("Dungeons and Dragons", 0).requirement("Dragon Slayer", 1).build());
        achievements.add(new AchievementBuilder("Karamja Set Tasks - Medium", 0).requirement("Just the Ticket", 1)
            .requirement("Back Cran-door", 1).requirement("Dungeons and Dragons", 1).requirement("Horseless Carriage", 1)
            .requirement("They Like Me! They Really Like Me!", 1).requirement("Arachnophagia", 1).requirement("Romancing the Stone", 1)
            .requirement("I'm a Lumberjack and I'm Okay", 1).requirement("I Sleep All Night and I Work All Day", 1)
            .requirement("To Catch a Karambwan", 1).requirement("That's Not a Knife...", 1).requirement("Falling With Style", 1)
            .requirement("Scourge of Scurvy", 1).requirement("Hunters of the Horned Graahk", 1).requirement("The Roots of All Evil", 1)
            .requirement("Points of No Return", 1).requirement("Stairway to Haven", 1).requirement("Thank You, Madam", 1)
            .requirement("Shipping Out From the Shipyard", 1).lamp(Player.ALL_SKILLS, 5000, 40).build());
        achievements.add(new AchievementBuilder("This Hasta Work", 0).requirement("Rune bar", 1).requirement("Magic logs", 1)
            .requirement("Smithing", 90).requirement("Tai Bwo Wannai Trio", 1).requirement("Barbarian Smithing", 1).reward("Smithing", 150)
            .reward("Rune hasta", 1).build());
        achievements.add(new AchievementBuilder("Potting With Otto", 0).requirement("Herblore", 80).requirement("Caviar", 1)
            .requirement("Super ranging potion (2)", 1).reward("Herblore", 54).reward("Super ranging mix (2)", 1).build());
        achievements.add(new AchievementBuilder("No Smoke Without Pyre", 0).requirement("Firemaking", 85).requirement("Crafting", 85)
            .requirement("Barbarian Firemaking", 1).requirement("Magic logs", 1).reward("Crafting", 75).reward("Firemaking", 303).build());
        achievements.add(new AchievementBuilder("Limber Lumber Jumper", 0).requirement("Advanced Barbarian Outpost laps", 250)
            .reward("Agility", 753).build());
        achievements.add(new AchievementBuilder("Leap of Faith", 0).requirement("Agility", 81).build());
        achievements.add(new AchievementBuilder("Jaws Breaker", 0).requirement("Fishing", 96).requirement("Strength", 76)
            .reward("Shark", 1).reward("Fishing", 110).reward("Strength", 11).build());
        achievements.add(new AchievementBuilder("First Stryke", 0).requirement("Slayer", 93)
            .encounter(new Encounter("Ice strykewyrm")).build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Elite", 0).requirement("Jaws Breaker", 1)
            .requirement("Limber Lumber Jumper", 1).requirement("Astronomical!", 1).requirement("First Stryke", 1)
            .requirement("Leap of Faith", 1).requirement("No Smoke Without Pyre", 1).requirement("This Hasta Work", 1)
            .requirement("Potting With Otto", 1).requirement("Axe'll Grease", 1).lamp(Player.ALL_SKILLS, 40000, 89)
            .lamp(Player.ALL_SKILLS, 30000, 86).lamp(Player.ALL_SKILLS, 30000, 86).lamp(Player.ALL_SKILLS, 30000, 86)
            .lamp(Player.ALL_SKILLS, 30000, 86).build());
        achievements.add(new AchievementBuilder("The Good Stuff", 0).requirement("Coins", 3).build());
        achievements.add(new AchievementBuilder("Stand and Deliver", 0).encounter(new Encounter("Highwayman")).build());
        achievements.add(new AchievementBuilder("Sniffing Out the Mole", 0).build());
        achievements.add(new AchievementBuilder("Sir Mitt", 0).build());
        achievements.add(new AchievementBuilder("Mudskip the Light Fantastic", 0).build());
        achievements.add(new AchievementBuilder("Making My Mind Up", 0).requirement("Mind talisman", 1).requirement("Tiara", 1)
            .build());
        achievements.add(new AchievementBuilder("It's Not Wabbit Season", 0).encounter(new Encounter("Duck")).build());
        achievements.add(new AchievementBuilder("Going Along with the 'Fro", 0).build());
        achievements.add(new AchievementBuilder("Fill Yer Bucket", 0).requirement("Bucket", 1).reward("Bucket of water", 1).build());
        achievements.add(new AchievementBuilder("Family Values", 0).requirement("Construction", 16).build());
        achievements.add(new AchievementBuilder("Elementary Medicine", 0).requirement("Air rune", 1).build());
        achievements.add(new AchievementBuilder("Disarm and Embark", 0).build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Easy", 0).requirement("The Good Stuff", 1)
            .requirement("Amulet of Weedspeak", 1).requirement("Chain Store", 1).requirement("Sir Mitt", 1).requirement("Family Values", 1)
            .requirement("Sniffing Out the Mole", 1).requirement("Chinchompa Powered!", 1).requirement("Fill Yer Bucket", 1)
            .requirement("Elementary Medicine", 1).requirement("It's Not Wabbit Season", 1).requirement("Stand and Deliver", 1)
            .requirement("Making My Mind Up", 1).requirement("Mudskip the Light Fantastic", 1).requirement("Disarm and Embark", 1)
            .requirement("Going Along with the 'Fro", 1).lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("You'd Best Come A-cookin'", 0).requirement("Raw rocktail", 1)
            .requirement("Cooking", 93).reward("Rocktail", 1).reward("Cooking", 225).build());
        achievements.add(new AchievementBuilder("When This Cavern's Rockin'...", 0).requirement("Fishing", 90)
            .requirement("Living minerals", 1).reward("Raw rocktail", 1).reward("Fishing", 380).build());
        achievements.add(new AchievementBuilder("I Swear I Heard It Scream", 0.05).requirement("Magic seed", 1)
            .requirement("Woodcutting", 75).requirement("Farming", 75).reward("Farming", 13914).reward("Woodcutting", 250)
            .reward("Magic logs", 1).build());
        achievements.add(new AchievementBuilder("I've Changed My Mind!", 0).requirement("Summoning", 80).requirement("Farming", 15)
            .requirement("Hydra pouch", 1).requirement("Regrowth scroll", 1).reward("Summoning", 3).build());
        achievements.add(new AchievementBuilder("Concentration is Key", 0).requirement("Mining", 80).reward("Gold ore", 1)
            .reward("Mining", 65).build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Elite", 0).requirement("When This Cavern's Rockin'...", 1)
            .requirement("You'd Best Come A-cookin'", 1).requirement("Concentration is Key", 1).requirement("I Swear I Heard It Scream", 1)
            .requirement("I've Changed My Mind!", 1).requirement("A String and a Flare", 1).requirement("Altar-ed State", 1)
            .lamp(Player.ALL_SKILLS, 30000, 90).lamp(Player.ALL_SKILLS, 30000, 90).lamp(Player.ALL_SKILLS, 50000, 84)
            .lamp(Player.ALL_SKILLS, 50000, 72).build());
        achievements.add(new AchievementBuilder("Elemental Workshop I", 0.25).requirement("Mining", 20).requirement("Smithing", 20)
            .requirement("Crafting", 20).requirement("Thread", 1).requirement("Coal", 1).encounter(new Encounter("Earth elemental"))
            .reward("Quest points", 1).reward("Smithing", 5000).reward("Crafting", 5000).reward("Elemental shield", 1).build());
        achievements.add(new AchievementBuilder("Why Oh Wyvern", 0).requirement("Elemental Workshop I", 1).requirement("Slayer", 72)
            .encounter(new Encounter("Skeletal wyvern", Collections.singletonList(new Restriction("Elemental shield", 1)))).build());
        achievements.add(new AchievementBuilder("The Stonemasons", 0).requirement("Mining", 60).build());
        achievements.add(new AchievementBuilder("Mogre miniquest", 0.25).requirement("Cooking", 20).requirement("Bucket of water", 1)
            .requirement("Bowl of water", 1).requirement("Bucket of milk", 1).requirement("Snape grass", 1).requirement("Chocolate dust", 1)
            .reward("Cooking", 53).build());
        achievements.add(new AchievementBuilder("The Mogre Mash", 0).requirement("Mogre miniquest", 1).requirement("Coins", 60)
            .requirement("Slayer", 32).encounter(new Encounter("Mogre")).build());
        achievements.add(new AchievementBuilder("Mass Production", 0).requirement("Pure essence", 28).requirement("Runecrafting", 56)
            .reward("Mind rune", 140).build());
        achievements.add(new AchievementBuilder("It Spoiled My View", 0).requirement("Yew seed", 1).requirement("Farming", 60)
            .requirement("Woodcutting", 60).reward("Farming", 7151).reward("Woodcutting", 175).reward("Yew logs", 1).build());
        achievements.add(new AchievementBuilder("It Matches My Eyes", 0).requirement("The Hand in the Sand", 1)
            .requirement("Coins", 20).requirement("Cape (black)", 1).build());
        achievements.add(new AchievementBuilder("I Heard You Like Mudskips", 0).requirement("Fairy Tale II - Cure a Queen", 1)
            .build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Hard", 0).requirement("It Matches My Eyes", 1)
            .requirement("Child of Saradomin", 1).requirement("Mass Production", 1).requirement("It Spoiled My View", 1)
            .requirement("The Stonemasons", 1).requirement("I Heard You Like Mudskips", 1).requirement("The Mogre Mash", 1)
            .requirement("Why Oh Wyvern", 1).requirement("Banned For Life", 1).requirement("A Knight in the Darkness", 1)
            .lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("They Have Families to Feed", 0).requirement("Thieving", 40).reward("Thieving", 46)
            .reward("Coins", 30).build());
        achievements.add(new AchievementBuilder("These Aren't the Coins You're Looking For", 0).requirement("Ring of Charos (a)", 0)
            .build());
        achievements.add(new AchievementBuilder("Stoic Sweetcorn Guardian", 0).requirement("Sweetcorn seed", 3)
            .requirement("Empty sack", 1).requirement("Watermelon", 1).requirement("Bronze spear", 1).reward("Farming", 17).build());
        achievements.add(new AchievementBuilder("Look Spiffy For Tiffy", 0).requirement("Initiate hauberk", 0)
            .requirement("Initiate sallet", 1).requirement("Initiate cuisse", 1).requirement("Prayer", 10).requirement("Defense", 25)
            .requirement("Recruitment Drive", 1).build());
        achievements.add(new AchievementBuilder("Kitty Litter", 0).requirement("Ratcatchers", 1).build());
        achievements.add(new AchievementBuilder("It's Nothing Personal", 0).requirement("White Knight rank points", 101).build());
        achievements.add(new AchievementBuilder("Is It So Hard to Walk Round?", 0).requirement("Agility", 26).build());
        achievements.add(new AchievementBuilder("Ice the Icy", 0).encounter(new Encounter("Ice giant")).build());
        achievements.add(new AchievementBuilder("Fruit of the Loom", 0).requirement("Willow branch", 6).requirement("Crafting", 36)
            .reward("Basket", 1).reward("Crafting", 56).build());
        achievements.add(new AchievementBuilder("The Knight's Sword", 0.25).requirement("Mining", 10).requirement("Iron bar", 2)
            .requirement("Redberry pie", 1).reward("Quest points", 1).lamp(Collections.singletonList("Smithing"), 12725, 28).build());
        achievements.add(new AchievementBuilder("Do They Come in Other Colours?", 0.05).requirement("The Knight's Sword", 1)
            .requirement("Smithing", 13).reward("Mining", 17).reward("Blurite limbs", 1).reward("Smithing", 25).build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Medium", 0).requirement("Fruit of the Loom", 1)
            .requirement("Is It So Hard to Walk Round?", 1).requirement("Climbing the Walls", 1).requirement("It's Nothing Personal", 1)
            .requirement("Ice the Icy", 1).requirement("Blinded with Science", 1).requirement("They Have Families to Feed", 1)
            .requirement("Stoic Sweetcorn Guardian", 1).requirement("Look Spiffy For Tiffy", 1)
            .requirement("Do They Come in Other Colours?", 1).requirement("These Aren't the Coins You're Looking For", 1)
            .requirement("Kitty Litter", 1).lamp(Player.ALL_SKILLS, 5000, 40).build());
        achievements.add(new AchievementBuilder("Wiggle Room", 0).requirement("One Piercing Note", 1).build());
        achievements.add(new AchievementBuilder("Touring Gear", 0).requirement("Desert shirt", 1).requirement("Desert robe", 1)
            .requirement("Desert boots", 1).reward("Desert shirt", 1).reward("Desert robe", 1).reward("Desert boots", 1).build());
        achievements.add(new AchievementBuilder("Slash Fund", 0).requirement("Waterskin (0)", 1).reward("Waterskin (4)", 1).build());
        achievements.add(new AchievementBuilder("Seems Legit", 0).requirement("Pyramid Plunder artifacts", 5).build());
        achievements.add(new AchievementBuilder("Memento Mori", 0).build());
        achievements.add(new AchievementBuilder("Kookookachat", 0).requirement("Stolen Hearts", 1).build());
        achievements.add(new AchievementBuilder("I Like to Watch", 0).build());
        achievements.add(new AchievementBuilder("Fool's Gold", 0).requirement("Bird snare", 1).requirement("Hunter", 5)
            .reward("Hunter", 48).reward("Bird snare", 1).build());
        achievements.add(new AchievementBuilder("Fire at Will", 0).requirement("Runecrafting", 14).requirement("Pure essence", 1)
            .reward("Fire rune", 1).build());
        achievements.add(new AchievementBuilder("Extra Cheese", 0).requirement("Pizzazz Points", 2).build());
        achievements.add(new AchievementBuilder("Don't You Dare Close Your Eyes", 0).requirement("Coins", 1000).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Easy", 0).requirement("Assassin's Feed", 1)
            .requirement("Touring Gear", 1).requirement("Memento Mori", 1).requirement("Fool's Gold", 1)
            .requirement("Don't You Dare Close Your Eyes", 1).requirement("Slash Fund", 1).requirement("Kookookachat", 1)
            .requirement("Fire at Will", 1).requirement("Seems Legit", 1).requirement("Extra Cheese", 1).requirement("I Like to Watch", 1)
            .requirement("Wiggle Room", 1).lamp(Player.ALL_SKILLS, 2000, 29).build());
        achievements.add(new AchievementBuilder("Sun Shade", 0.35).requirement("Nomad's Requiem", 1).requirement("Do No Evil", 1)
            .requirement("Dream Mentor", 1).requirement("Blood Runs Deep", 1).requirement("While Guthix Sleeps", 1)
            .requirement("The Temple at Senntisten", 1).requirement("Legends' Quest", 1).requirement("The Curse of Arrav", 1)
            .requirement("My Arm's Big Adventure", 1).requirement("The Void Stares Back", 1).requirement("Love Story", 1)
            .requirement("Desert Treasure", 1).requirement("Recipe for Disaster", 1).requirement("Monkey Madness", 1)
            .requirement("Dominion tower bosses", 500).requirement("Dominion page", 20).requirement("Revenge of the Evil Chickens", 1)
            .requirement("Finish Him!", 1).requirement("Just Die Already", 1).requirement("No More Nomad...No More!", 1)
            .requirement("I Eat Dagannoths For Breakfast", 1).requirement("Indigestion", 1).requirement("You'll Never Defeat Me", 1)
            .requirement("Hey! Eat Power-up", 1).requirement("The Fire! It Burns!", 1).requirement("The Fire! It Burns! (easy version)", 1)
            .build());
        achievements.add(new AchievementBuilder("Staff on Stryke", 0).requirement("Slayer", 77)
            .encounter(new Encounter("Desert strykewyrm", Arrays.asList(new Restriction("Fully charged full slayer helmet", 1),
                new Restriction("Ancient staff", 1)))).build());
        achievements.add(new AchievementBuilder("Room Service", 0).requirement("Thieving", 91).reward("Strength", 275).build());
        achievements.add(new AchievementBuilder("As A First Resort", 1.5).requirement("Zogre Flesh Eaters", 1)
            .requirement("Hunter", 48).requirement("Firemaking", 51).requirement("Woodcutting", 58).requirement("Eucalyptus logs", 26)
            .requirement("Achey tree logs", 8).requirement("Bronze spear", 4).requirement("Raw chompy", 2).requirement("Stripy feather", 8)
            .requirement("Tatty larupia fur", 8).requirement("Wolf bones", 4).requirement("Logs", 1).requirement("Box trap", 0)
            .requirement("Bird snare", 0).reward("Quest points", 1).reward("Firemaking", 15000).reward("Hunter", 15000)
            .reward("Woodcutting", 15000).build());
        achievements.add(new AchievementBuilder("I'm Super", 0).requirement("Mining", 81).requirement("Antifire (3)", 2)
            .requirement("Herblore", 85).requirement("Crafting", 89).requirement("As A First Resort", 1).reward("Thieving", 52)
            .reward("Mining", 70).reward("Crafting", 100).reward("Herblore", 420).reward("Super antifire flask", 1).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Elite", 0).requirement("Staff on Stryke", 1)
            .requirement("Room Service", 1).requirement("Sun Shade", 1).requirement("A, B, Cithara", 1).requirement("Ankle Support", 1)
            .requirement("I'm Super", 1).lamp(Player.ALL_SKILLS, 30000, 77).lamp(Player.ALL_SKILLS, 30000, 77)
            .lamp(Player.ALL_SKILLS, 50000, 93).lamp(Player.ALL_SKILLS, 50000, 93).build());
        achievements.add(new AchievementBuilder("Water on the Brain", 0).requirement("Dealing with Scabaras", 1)
            .requirement("Water rune", 3).build());
        achievements.add(new AchievementBuilder("Wake-Up Call", 0).requirement("Thieving", 61).reward("Strength", 100).build());
        achievements.add(new AchievementBuilder("Ug Thankee Kindly", 0).requirement("Onion", 1).requirement("Tomato", 1)
            .requirement("Bowl", 1).requirement("Raw ugthanki meat", 1).requirement("Pot of flour", 1)
            .requirement("Bucket of water", 1).requirement("Spirits of the Elid", 1).requirement("Cooking", 58).reward("Ugthanki kebab", 1)
            .reward("Cooking", 40).build());
        achievements.add(new AchievementBuilder("Skinful", 0).requirement("Dream Mentor", 1).requirement("Magic", 68)
            .requirement("Astral rune", 1).requirement("Fire rune", 1).requirement("Water rune", 1).requirement("Waterskin (0)", 1)
            .reward("Magic", 65).reward("Waterskin(4)", 1).build());
        achievements.add(new AchievementBuilder("Security through Obscurity", 0).requirement("Deadliest Catch", 1).build());
        achievements.add(new AchievementBuilder("Say It, Don't Spray It", 0).requirement("Do No Evil", 1).build());
        achievements.add(new AchievementBuilder("Open Sesame", 0).requirement("Dungeoneering", 75).reward("Dungeoneering", 11400)
            .build());
        achievements.add(new AchievementBuilder("Nipped in the Bug", 0).requirement("Dreadnip", 1).build());
        achievements.add(new AchievementBuilder("Ability to fletch broads", 0).requirement("Slayer point", 300).build());
        achievements.add(new AchievementBuilder("More Fletcher than Sumona", 0).requirement("Smoking Kills", 1)
            .requirement("Ability to fletch broads", 1).requirement("Fletching", 52).requirement("Headless arrow", 15)
            .requirement("Broad arrowheads", 15).reward("Fletching", 225).reward("Broad arrows", 15).build());
        achievements.add(new AchievementBuilder("Ludikeris", 0).requirement("Contact!", 1)
            .encounter(new Encounter("Kalphite guardian", Collections.singletonList(new Restriction("Keris", 1)))).build());
        achievements.add(new AchievementBuilder("Ice-Cold Killer", 0).requirement("Desert Treasure", 1).requirement("Magic", 70)
            .requirement("Death rune", 2).requirement("Water rune", 4).build());
        achievements.add(new AchievementBuilder("Enakhra's Lament", 0.75).requirement("Crafting", 50).requirement("Firemaking", 45)
            .requirement("Magic", 13).requirement("Granite (5kg)", 2).requirement("Sandstone (10kg)", 5).requirement("Sandstone (2kg)", 1)
            .requirement("Meat pizza", 1).requirement("Air rune", 2).requirement("Fire rune", 1).requirement("Candle", 1)
            .requirement("Logs", 1).requirement("Oak logs", 1).requirement("Willow logs", 1).requirement("Maple logs", 1)
            .requirement("Soft clay", 1).requirement("Coal", 1).reward("Quest points", 2).reward("Crafting", 7000).reward("Mining", 7000)
            .reward("Firemaking", 7000).reward("Magic", 7000).build());
        achievements.add(new AchievementBuilder("Enaqua", 0).requirement("Enakhra's Lament", 1).requirement("Waterskin (0)", 1)
            .reward("Waterskin (4)", 1).build());
        achievements.add(new AchievementBuilder("Drafty in Here", 0).requirement("Smoking Kills", 1).requirement("Slayer", 65)
            .encounter(new Encounter("Dust devil", Collections.singletonList(new Restriction("Face dust protection", 1)))).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Hard", 0).requirement("Skinful", 1)
            .requirement("Water on the Brain", 1).requirement("More Fletcher than Sumona", 1).requirement("Ug Thankee Kindly", 1)
            .requirement("Nipped in the Bug", 1).requirement("Drafty in Here", 1).requirement("Enaqua", 1)
            .requirement("Say It, Don't Spray It", 1).requirement("1001 Kharidian Spikes", 1).requirement("Ice-Cold Killer", 1)
            .requirement("Ludikeris", 1).requirement("Security through Obscurity", 1).requirement("Wake-Up Call", 1)
            .requirement("Open Sesame", 1).lamp(Player.ALL_SKILLS, 20000, 1).build());
        achievements.add(new AchievementBuilder("Unbeetleable", 0).requirement("Pouch", 1).requirement("Blue charm", 1)
            .requirement("Spirit shards", 51).requirement("Potato cactus", 1).requirement("Summoning", 25).reward("Summoning", 220)
            .reward("Spirit kalphite pouch", 1).build());
        achievements.add(new AchievementBuilder("Taken for Granite", 0).requirement("Mining", 45).build());
        achievements.add(new AchievementBuilder("So Su Me", 0.05).requirement("The Feud", 1).build());
        achievements.add(new AchievementBuilder("Overcut", 0).requirement("Missing My Mummy", 1).requirement("Prayer", 45).build());
        achievements.add(new AchievementBuilder("Heathen Idle", 0).requirement("Spirits of the Elid", 1).build());
        achievements.add(new AchievementBuilder("Goat Harralander?", 0.05).requirement("Herblore", 36).requirement("Crafting", 33)
            .requirement("Spirits of the Elid", 1).requirement("Molten glass", 1).requirement("Clean harralander", 1)
            .reward("Combat potion (3)", 1).reward("Herblore", 84).reward("Crafting", 35).build());
        achievements.add(new AchievementBuilder("Eagles' Peak (quest)", 0.75).requirement("Hunter", 27).requirement("Swamp tar", 1)
            .requirement("Coins", 50).requirement("Yellow dye", 1).encounter(new Encounter("Kebbit")).reward("Quest points", 2)
            .reward("Hunter", 2500).build());
        achievements.add(new AchievementBuilder("Faster than a Speeding Bullet", 0).requirement("Eagles' Peak (quest)", 1)
            .requirement("Rope", 1).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Medium", 0).requirement("So Su Me", 1)
            .requirement("Faster than a Speeding Bullet", 1).requirement("A Bridge Not Far", 1).requirement("Heathen Idle", 1)
            .requirement("Away with the Kalphites", 1).requirement("All Square", 1).requirement("Goat Harralander?", 1)
            .requirement("Taken for Granite", 1).requirement("Unbeetleable", 1).requirement("An Teak", 1).requirement("Overcut", 1)
            .lamp(Player.ALL_SKILLS, 8000, 43).build());
        achievements.add(new AchievementBuilder("You're Not the Boss of Me", 0.05).build());
        achievements.add(new AchievementBuilder("Untouchable", 0.05).build());
        achievements.add(new AchievementBuilder("The Lone Dungeoneer", 0.05).build());
        achievements.add(new AchievementBuilder("Tales of Old", 0).requirement("Fremennik sagas", 1).build());
        achievements.add(new AchievementBuilder("Take It From the Top", 0).requirement("Max floor completed", 1).build());
        achievements.add(new AchievementBuilder("Sinking Fast", 0.1).build());
        achievements.add(new AchievementBuilder("Setting Up", 0.05).requirement("Smithing", 7)
            .requirement("Dungeoneering floors completed", 2).reward("Smithing", 125).build());
        achievements.add(new AchievementBuilder("Kitchen Aid", 0).build());
        achievements.add(new AchievementBuilder("It's Dangerous to go Alone", 0.05).build());
        achievements.add(new AchievementBuilder("Invisible Ink", 0).build());
        achievements.add(new AchievementBuilder("Gorajo Fandango", 0.05).requirement("Dungeoneering floors completed", 4).build());
        achievements.add(new AchievementBuilder("Fashion Victim", 0).requirement("Setting Up", 1).build());
        achievements.add(new AchievementBuilder("Dere-licked", 0.05).requirement("Max floor complete", 11).build());
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Easy", 0).requirement("Setting Up", 1)
            .requirement("It's Dangerous to go Alone", 1).requirement("Kitchen Aid", 1).requirement("The Lone Dungeoneer", 1)
            .requirement("Dere-licked", 1).requirement("Take It From the Top", 1).requirement("Change of a Dress", 1)
            .requirement("Gorajo Fandango", 1).requirement("You're Not the Boss of Me", 1).requirement("A Road Less Travelled", 1)
            .requirement("Invisible Ink", 1).requirement("Untouchable", 1).requirement("Fashion Victim", 1).requirement("Sinking Fast", 1)
            .requirement("Tales of Old", 1).requirement("A Flicker in Darkness", 1).lamp(Player.ALL_SKILLS, 2000, 23).build());
        achievements.add(new AchievementBuilder("Top Hat", 0.05).requirement("Smithing", 95).build());
        achievements.add(new AchievementBuilder("Pass the Port", 0).requirement("Dungeoneering floors completed", 5)
            .requirement("Divination", 86).reward("Divination", 90).build());
        achievements.add(new AchievementBuilder("Orbful", 0.1).requirement("Crafting", 98).requirement("Magic", 90)
            .requirement("Dungeoneering floors completed", 3).reward("Crafting", 95).build());
        achievements.add(new AchievementBuilder("In the Darkness Bind Them", 0).requirement("Dungeoneering", 90).build());
        achievements.add(new AchievementBuilder("Gulega-d to Rest", 0.05).requirement("Max floor completed", 47).build());
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Elite", 0).requirement("Any fin is Possible", 1)
            .requirement("Orbful", 1).requirement("Top Hat", 1).requirement("In the Darkness Bind Them", 1).requirement("Pass the Port", 1)
            .requirement("Gulega-d to Rest", 1).lamp(Player.ALL_SKILLS, 60000, 98).lamp(Player.ALL_SKILLS, 50000, 90)
            .lamp(Player.ALL_SKILLS, 50000, 90).lamp(Player.ALL_SKILLS, 50000, 90).build());
        achievements.add(new AchievementBuilder("The Wanderer", 0).requirement("Runecrafting", 50)
            .requirement("Dungeoneering floors completed", 2).requirement("Spinebeam wand", 1).reward("Runecrafting", 39)
            .reward("Magic", 39).build());
        achievements.add(new AchievementBuilder("Thanks for the Memories", 0).requirement("Dungeoneering floors completed", 5)
            .requirement("Divination", 70).reward("Divination", 8).build());
        achievements.add(new AchievementBuilder("Stacked", 0).requirement("Salt in the Wound", 1).build());
        achievements.add(new AchievementBuilder("Occult Classic", 0.05).requirement("Max floor completed", 35).build());
        achievements.add(new AchievementBuilder("Lawful Crafting", 0).requirement("Runecrafting", 54)
            .requirement("Dungeoneering floors completed", 2).build());
        achievements.add(new AchievementBuilder("Kinprovements", 0).requirement("Dungeoneering token", 323215).build());
        achievements.add(new AchievementBuilder("Hoof Rot", 0.05).requirement("Max floor completed", 32).build());
        achievements.add(new AchievementBuilder("Rapid Renewal", 0).requirement("Prayer", 65).requirement("Dungeoneering", 65)
            .requirement("Dungeoneering token", 38000).build());
        achievements.add(new AchievementBuilder("Healing Factor", 0).requirement("Rapid Renewal", 1).build());
        achievements.add(new AchievementBuilder("Get Stuffed", 0.05).requirement("Cooking", 69).requirement("Farming", 68)
            .requirement("Dungeoneering floors completed", 4).reward("Cooking", 242).reward("Farming", 6).build());
        achievements.add(new AchievementBuilder("Epic Epic", 0).requirement("Fremennik sagas", 5).build());
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Hard", 0).requirement("Occult Classic", 1)
            .requirement("Stacked", 1).requirement("Kinprovements", 1).requirement("Lawful Crafting", 1)
            .requirement("Thanks for the Memories", 1).requirement("Healing Factor", 1).requirement("Alcrabaholic", 1)
            .requirement("Hoof Rot", 1).requirement("A Prayer Opportunity", 1).requirement("The Wanderer", 1).requirement("Get Stuffed", 1)
            .requirement("Epic Epic", 1).reward("Dungeoneering token", 38000).lamp(Player.ALL_SKILLS, 20000, 74).build());
        achievements.add(new AchievementBuilder("You Got Some Nice Drapes There", 0.05).requirement("Max floor completed", 17)
            .build());
        achievements.add(new AchievementBuilder("Up to the Gods", 0.05).reward("Prayer", 640).build());
        achievements.add(new AchievementBuilder("Totem Pole Position", 0.1).build());
        achievements.add(new AchievementBuilder("Tactical Retreat", 0).requirement("Magic", 32).build());
        achievements.add(new AchievementBuilder("Spinal Trap", 0.05).requirement("Fletching", 43).requirement("Hunter", 40)
            .requirement("Dungeoneering floors completed", 3).reward("Fletching", 79).build());
        achievements.add(new AchievementBuilder("Port Enter", 0).requirement("Dungeoneering floors completed", 5)
            .requirement("Divination", 45).build());
        achievements.add(new AchievementBuilder("Nice to meet you, Wall", 0.05).requirement("Max floor completed", 17).build());
        achievements.add(new AchievementBuilder("Marm's Armoury", 0).requirement("Crafting", 25)
            .requirement("Dungeoneering token", 2000).build());
        achievements.add(new AchievementBuilder("I want it All", 0.1).requirement("Dungeoneering floors completed", 5).build());
        achievements.add(new AchievementBuilder("Drink Me", 0.1).requirement("Herblore", 36).requirement("Farming", 40)
            .requirement("Dungeoneering floors completed", 4).reward("Herblore", 79).reward("Farming", 27).build());
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Medium", 0)
            .requirement("You Got Some Nice Drapes There", 1).requirement("I want it All", 1).requirement("And I Want It Now", 1)
            .requirement("Marm's Armoury", 1).requirement("Tactical Retreat", 1).requirement("Port Enter", 1)
            .requirement("Totem Pole Position", 1).requirement("Nice to meet you, Wall", 1).requirement("300", 1).requirement("Drink Me", 1)
            .requirement("Spinal Trap", 1).requirement("Cache Box", 1).requirement("Up to the Gods", 1).reward("Dungeoneering token", 2000)
            .lamp(Player.ALL_SKILLS, 8000, 41).build());
        achievements.add(new AchievementBuilder("Task Master", 0).requirement("Ardougne Set Tasks - Easy", 1)
            .requirement("Ardougne Set Tasks - Medium", 1).requirement("Ardougne Set Tasks - Hard", 1)
            .requirement("Ardougne Set Tasks - Elite", 1).requirement("Desert Set Tasks - Easy", 1)
            .requirement("Desert Set Tasks - Medium", 1).requirement("Desert Set Tasks - Hard", 1)
            .requirement("Desert Set Tasks - Elite", 1).requirement("Daemonheim Set Tasks - Easy", 1)
            .requirement("Daemonheim Set Tasks - Medium", 1).requirement("Daemonheim Set Tasks - Hard", 1)
            .requirement("Daemonheim Set Tasks - Elite", 1).requirement("Falador Set Tasks - Easy", 1)
            .requirement("Falador Set Tasks - Medium", 1).requirement("Falador Set Tasks - Hard", 1)
            .requirement("Falador Set Tasks - Elite", 1).requirement("Fremennik Set Tasks - Easy", 1)
            .requirement("Fremennik Set Tasks - Medium", 1).requirement("Fremennik Set Tasks - Hard", 1)
            .requirement("Fremennik Set Tasks - Elite", 1).requirement("Karamja Set Tasks - Easy", 1)
            .requirement("Karamja Set Tasks - Medium", 1).requirement("Karamja Set Tasks - Hard", 1)
            .requirement("Karamja Set Tasks - Elite", 1).requirement("Lumbridge Set Tasks - Easy", 1)
            .requirement("Lumbridge Set Tasks - Medium", 1).requirement("Lumbridge Set Tasks - Hard", 1)
            .requirement("Lumbridge Set Tasks - Beginner", 1).requirement("Menaphos Pyramid Scheme", 1)
            .requirement("Morytania Set Tasks - Easy", 1).requirement("Morytania Set Tasks - Medium", 1)
            .requirement("Morytania Set Tasks - Hard", 1).requirement("Morytania Set Tasks - Elite", 1)
            .requirement("Seers' Village Set Tasks - Easy", 1).requirement("Seers' Village Set Tasks - Medium", 1)
            .requirement("Seers' Village Set Tasks - Hard", 1).requirement("Seers' Village Set Tasks - Elite", 1)
            .requirement("Tirannwn Set Tasks - Easy", 1).requirement("Tirannwn Set Tasks - Medium", 1)
            .requirement("Tirannwn Set Tasks - Hard", 1).requirement("Tirannwn Set Tasks - Elite", 1)
            .requirement("Varrock Set Tasks - Easy", 1).requirement("Varrock Set Tasks - Medium", 1)
            .requirement("Varrock Set Tasks - Hard", 1).requirement("Varrock Set Tasks - Elite", 1)
            .requirement("Wilderness Set Tasks - Easy", 1).requirement("Wilderness Set Tasks - Medium", 1)
            .requirement("Wilderness Set Tasks - Hard", 1).requirement("Wilderness Set Tasks - Elite", 1).build());
        achievements.add(new AchievementBuilder("Stay Safe", 0).reward("Coins", 10000).reward("Safety gloves", 1)
            .lamp(Player.ALL_SKILLS, 500, 1).lamp(Player.ALL_SKILLS, 500, 1).build());
        achievements.add(new AchievementBuilder("Zarosian Memories", 0.25).requirement("Fate of the Gods", 1).build());
        achievements.add(new AchievementBuilder("You Be Dead", 0).requirement("Goblin priests buried", 5).build());
        achievements.add(new AchievementBuilder("Yaktwee's a Charm", 0).requirement("Charm sprites", 1000).build());
    }

    private void addAchievementsDZ() {
        achievements.add(new AchievementBuilder("What's Mine is Yours", 0.75).requirement("Smithing", 5)
            .encounter(new Encounter("Living rock brawler")).encounter(new Encounter("Living rock brawler"))
            .encounter(new Encounter("Living rock brawler")).encounter(new Encounter("Living rock brawler")).reward("Quest points", 1)
            .reward("Mining", 1000).reward("Smithing", 400).reward("Coins", 180).build());
        achievements.add(new AchievementBuilder("Boric task 1", 0.05).requirement("What's Mine is Yours", 1)
            .requirement("Mining", 30).requirement("Coal", 30).reward("Mining", 30).lamp(Arrays.asList("Mining", "Smithing"), 4500, 1)
            .build());
        achievements.add(new AchievementBuilder("Boric task 2", 0.1).requirement("Boric task 1", 1).requirement("Mining", 40)
            .encounter(new Encounter("Living rock brawler")).encounter(new Encounter("Living rock brawler"))
            .encounter(new Encounter("Living rock brawler")).encounter(new Encounter("Living rock brawler"))
            .encounter(new Encounter("Living rock brawler")).reward("Mining", 3500).lamp(Arrays.asList("Mining", "Smithing"), 10500, 1)
            .build());
        achievements.add(new AchievementBuilder("Boric task 3", 0.1).requirement("Boric task 2", 1).requirement("Mining", 60)
            .reward("Mining", 9550).lamp(Arrays.asList("Mining", "Smithing"), 24000, 1).build());
        achievements.add(new AchievementBuilder("Doric task 1", 0.1).requirement("What's Mine is Yours", 1)
            .requirement("Smithing", 12).requirement("Bronze bar", 10).reward("Smithing", 620)
            .lamp(Arrays.asList("Mining", "Smithing"), 750, 1).build());
        achievements.add(new AchievementBuilder("Doric task 2", 0.1).requirement("Doric task 1", 1).requirement("Death Plateau", 1)
            .requirement("Smithing", 18).requirement("Bronze bar", 26).reward("Smithing", 825)
            .lamp(Arrays.asList("Mining", "Smithing"), 1500, 1).build());
        achievements.add(new AchievementBuilder("Doric task 3", 0.1).requirement("Doric task 2", 1).requirement("Smithing", 24)
            .requirement("Iron bar", 25).reward("Smithing", 1375).lamp(Arrays.asList("Mining", "Smithing"), 2250, 1).build());
        achievements.add(new AchievementBuilder("Doric task 4", 0.1).requirement("Doric task 3", 1).requirement("Smithing", 30)
            .requirement("Iron ore", 20).reward("Smithing", 3520).lamp(Arrays.asList("Mining", "Smithing"), 4500, 1).build());
        achievements.add(new AchievementBuilder("Doric task 5", 0.1).requirement("Doric task 4", 1).requirement("Smithing", 48)
            .requirement("Steel bar", 10).requirement("Steel platebody", 8).reward("Smithing", 5375)
            .lamp(Arrays.asList("Mining", "Smithing"), 15000, 1).build());
        achievements.add(new AchievementBuilder("Doric task 6", 0.1).requirement("Doric task 5", 1).requirement("Smithing", 59)
            .requirement("Mithril bar", 60).reward("Smithing", 11000).lamp(Arrays.asList("Mining", "Smithing"), 24000, 1).build());
        achievements.add(new AchievementBuilder("Doric task 7", 0.1).requirement("Doric task 6", 1).requirement("Smithing", 64)
            .reward("Smithing", 12000).lamp(Arrays.asList("Mining", "Smithing"), 36000, 1).build());
        achievements.add(new AchievementBuilder("Doric task 8", 0.1).requirement("Doric task 7", 1).requirement("Smithing", 75)
            .requirement("Adamant bar", 50).reward("Smithing", 23125).lamp(Arrays.asList("Mining", "Smithing"), 60000, 1).build());
        achievements.add(new AchievementBuilder("What's Mine Is Also Doric's", 0).requirement("Doric task 8", 1)
            .requirement("Boric task 3", 1).build());
        achievements.add(new AchievementBuilder("Walking the Reef", 0).requirement("Reefwalker cape scroll pieces", 4).build());
        achievements.add(new AchievementBuilder("Uncorrupted Ore", 0).requirement("Corrupted ores smelted", 100)
            .reward("Smithing", 50000).build());
        achievements.add(new AchievementBuilder("Troublesome Crystals", 0.1).requirement("Plague's End", 1).build());
        achievements.add(new AchievementBuilder("Trip to the East", 0).requirement("Trio voyage", 1).build());
        achievements.add(new AchievementBuilder("Tell Tale Tarn", 0).requirement("The Lair of Tarn Razorlor", 1).build());
        achievements.add(new AchievementBuilder("Slayer Master", 0).requirement("Rush of Blood platinum wave max", 20).build());
        achievements.add(new AchievementBuilder("Sing for the Lady", 0).requirement("Crystal items given to Lady Ithell", 4)
            .reward("Magic", 50000).build());
        achievements.add(new AchievementBuilder("Seren Memories", 0).requirement("Crest of Seren override", 1).build());
        achievements.add(new AchievementBuilder("Rhian in Gold - The Original", 0).requirement("Statue of Rhiannon", 1).build());
        achievements.add(new AchievementBuilder("Reaper Crew", 0).requirement("Bosses defeated", 29).build());
        achievements.add(new AchievementBuilder("Potion Mixer Master", 0).requirement("Combination potion recipes", 26).build());
        achievements.add(new AchievementBuilder("Port Life", 0).requirement("Player-owned port tutorial", 1).build());
        achievements.add(new AchievementBuilder("Pious Prayers", 0).requirement("Knight Waves training ground", 1).build());
        achievements.add(new AchievementBuilder("Peachy Bones", 0).requirement("Bones to Peaches", 1).build());
        achievements.add(new AchievementBuilder("Out into the Ourania", 0).requirement("Lunar Diplomacy", 1).build());
        achievements.add(new AchievementBuilder("One Foot in the Grave", 0).requirement("Returning Clarence", 1).build());
        achievements.add(new AchievementBuilder("Myreque in Memoriam", 0).requirement("In Memory of the Myreque", 1).build());
        achievements.add(new AchievementBuilder("Music Maestro", 0).requirement("Music tracks", 1203).build());
        achievements.add(new AchievementBuilder("Memories of Guthix", 0).requirement("Memorial to Guthix", 1).build());
        achievements.add(new AchievementBuilder("Master Skiller", 0).requirement("Attack", 99).requirement("Strength", 99)
            .requirement("Ranged", 99).requirement("Magic", 99).requirement("Defense", 99).requirement("Constitution", 99)
            .requirement("Prayer", 99).requirement("Agility", 99).requirement("Herblore", 99).requirement("Thieving", 99)
            .requirement("Crafting", 99).requirement("Runecrafting", 99).requirement("Mining", 99).requirement("Smithing", 99)
            .requirement("Fishing", 99).requirement("Cooking", 99).requirement("Firemaking", 99).requirement("Woodcutting", 99)
            .requirement("Fletching", 99).requirement("Slayer", 120).requirement("Farming", 99).requirement("Construction", 99)
            .requirement("Hunter", 99).requirement("Summoning", 99).requirement("Dungeoneering", 120).requirement("Divination", 99)
            .requirement("Invention", 120).build());
        achievements.add(new AchievementBuilder("Master Quester", 0).requirement("Quest points", 399).build());
        achievements.add(new AchievementBuilder("Make Them Bleed", 0).requirement("Rush of Blood maximum waves", 20)
            .reward("Slayer", 50000).build());
        achievements.add(new AchievementBuilder("Lunar Master", 0).requirement("Produce points", 430000).build());
        achievements.add(new AchievementBuilder("Lost Toys", 0).requirement("Morytania plushes", 14).build());
        achievements.add(new AchievementBuilder("Kudos to You", 0).requirement("Kudos", 198).build());
        achievements.add(new AchievementBuilder("Kiln Fighter", 0).requirement("Har-Aken", 1).build());
        achievements.add(new AchievementBuilder("Kharshai's Memories", 0).requirement("Mahjarrat memories", 15)
            .reward("Divination", 150000).build());
        achievements.add(new AchievementBuilder("The Giant Dwarf", 1).requirement("Crafting", 12).requirement("Firemaking", 16)
            .requirement("Magic", 33).requirement("Thieving", 14).requirement("Coins", 10000).requirement("Logs", 1).requirement("Coal", 1)
            .requirement("Iron bar", 1).requirement("Law rune", 1).requirement("Air rune", 1).requirement("Sapphire", 3)
            .requirement("Redberry pie", 1).reward("Quest points", 2).reward("Crafting", 2500).reward("Mining", 2500)
            .reward("Smithing", 2500).reward("Firemaking", 1500).reward("Magic", 1500).reward("Thieving", 1500).build());
        achievements.add(new AchievementBuilder("Unlock corporeal components", 0).requirement("The Giant Dwarf", 1)
            .requirement("Invention", 40).requirement("Dwarven currency", 10).build());
        achievements.add(new AchievementBuilder("Unlock Sprinkler MK1", 0).requirement("The Giant Dwarf", 1)
            .requirement("Invention", 50).requirement("Dwarven currency", 25).build());
        achievements.add(new AchievementBuilder("Unlock Mining accumulator", 0).requirement("The Giant Dwarf", 1)
            .requirement("Invention", 50).requirement("Dwarven currency", 25).build());
        achievements.add(new AchievementBuilder("Unlock Book switcher", 0).requirement("The Giant Dwarf", 1)
            .requirement("Invention", 60).requirement("Dwarven currency", 35).build());
        achievements.add(new AchievementBuilder("Unlock Calorie bomb", 0).requirement("The Giant Dwarf", 1)
            .requirement("Invention", 60).requirement("Dwarven currency", 35).build());
        achievements.add(new AchievementBuilder("Unlock Auto sanctifier", 0).requirement("The Giant Dwarf", 1)
            .requirement("Invention", 70).requirement("Dwarven currency", 55).build());
        achievements.add(new AchievementBuilder("Unlock Kinetic cyclone", 0).requirement("The Giant Dwarf", 1)
            .requirement("Invention", 70).requirement("Dwarven currency", 55).build());
        achievements.add(new AchievementBuilder("Unlock Dungeoneering lock melter", 0).requirement("The Giant Dwarf", 1)
            .requirement("Invention", 70).requirement("Dwarven currency", 55).build());
        achievements.add(new AchievementBuilder("Death to the Dorgeshuun", 0.75).requirement("The Lost Tribe", 1)
            .requirement("Thieving", 23).requirement("Agility", 23).requirement("H.a.m. hood", 1).requirement("H.a.m. shirt", 1)
            .requirement("H.a.m. robe", 1).requirement("H.a.m. gloves", 1).requirement("H.a.m. boots", 1).requirement("H.a.m. cloak", 1)
            .requirement("H.a.m. logo", 1).requirement("H.a.m. hood", 0).requirement("H.a.m. shirt", 0).requirement("H.a.m. robe", 0)
            .requirement("H.a.m. gloves", 0).requirement("H.a.m. boots", 0).requirement("H.a.m. cloak", 0).requirement("H.a.m. logo", 0)
            .requirement("Bullseye lantern (oil)", 0)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Sigmund (DttD)", "Guard (DttD)", "Guard (DttD)",
                "Guard (DttD)")), Collections.singletonList(new Restriction("Melee or Magic", 1)))).reward("Quest points", 1)
            .reward("Thieving", 2000).reward("Ranged", 2000).build());
        achievements.add(new AchievementBuilder("Unlock pestiferous components", 0).requirement("Death to the Dorgeshuun", 1)
            .requirement("Invention", 40).requirement("Cave goblin currency", 10).build());
        achievements.add(new AchievementBuilder("Unlock Mechanised chinchompa", 0).requirement("Death to the Dorgeshuun", 1)
            .requirement("Invention", 50).requirement("Cave goblin currency", 25).build());
        achievements.add(new AchievementBuilder("Unlock Woodcutting accumulator", 0).requirement("Death to the Dorgeshuun", 1)
            .requirement("Invention", 50).requirement("Cave goblin currency", 25).build());
        achievements.add(new AchievementBuilder("Unlock B.A.N.K Stander", 0).requirement("Death to the Dorgeshuun", 1)
            .requirement("Invention", 60).requirement("Cave goblin currency", 35).build());
        achievements.add(new AchievementBuilder("Unlock Monkey mind-control helmet", 0).requirement("Death to the Dorgeshuun", 1)
            .requirement("Invention", 60).requirement("Cave goblin currency", 35).build());
        achievements.add(new AchievementBuilder("Unlock Dungeoneering party simulator", 0).requirement("Death to the Dorgeshuun", 1)
            .requirement("Invention", 70).requirement("Cave goblin currency", 55).build());
        achievements.add(new AchievementBuilder("Unlock Electrified box trap", 0).requirement("Death to the Dorgeshuun", 1)
            .requirement("Invention", 70).requirement("Cave goblin currency", 55).build());
        achievements.add(new AchievementBuilder("Unlock Oldak coil", 0).requirement("Death to the Dorgeshuun", 1)
            .requirement("Invention", 70).requirement("Cave goblin currency", 55).build());
        achievements.add(new AchievementBuilder("Invention Gives Me the Blues", 0).requirement("Unlock corporeal components", 1)
            .requirement("Unlock Sprinkler MK1", 1).requirement("Unlock Mining accumulator", 1).requirement("Unlock Book switcher", 1)
            .requirement("Unlock Calorie bomb", 1).requirement("Unlock Auto sanctifier", 1).requirement("Unlock Kinetic cyclone", 1)
            .requirement("Unlock Dungeoneering lock melter", 1).requirement("Unlock pestiferous components", 1)
            .requirement("Unlock Mechanised chinchompa", 1).requirement("Unlock Woodcutting accumulator", 1)
            .requirement("Unlock B.A.N.K Stander", 1).requirement("Unlock Monkey mind-control helmet", 1)
            .requirement("Unlock Dungeoneering party simulator", 1).requirement("Unlock Electrified box trap", 1)
            .requirement("Unlock Oldak coil", 1).build());
        achievements.add(new AchievementBuilder("Imping Around", 0).requirement("Daffyd implings", 16).reward("Hunter", 50000)
            .build());
        achievements.add(new AchievementBuilder("I'm Forever Washing Shadows", 0).requirement("Blissful shadow core drops", 15)
            .requirement("Truthful shadow core drops", 15).requirement("Manifest shadow core drops", 15).reward("Divination", 50000)
            .build());
        achievements.add(new AchievementBuilder("Heal, Quickly", 0).requirement("Rapid Renewal", 1).build());
        achievements.add(new AchievementBuilder("Famous", 0).requirement("Morvran Slayer challenge", 1).reward("Slayer", 50000)
            .reward("Slayer point", 45).build());
        achievements.add(new AchievementBuilder("Family Spirit Tree", 0).requirement("Grown spirit trees", 3).reward("Farming", 50000)
            .build());
        achievements.add(new AchievementBuilder("Elven Titles", 0).requirement("Elf City titles", 8).build());
        achievements.add(new AchievementBuilder("Diaries of the Clans", 0).requirement("Hefin Agility Course laps", 160).build());
        achievements.add(new AchievementBuilder("The Curse of Zaros", 1).requirement("Desert Treasure", 1)
            .requirement("The Restless Ghost", 1).requirement("Prayer", 31).requirement("Agility", 15).reward("Kudos", 10)
            .lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("Desert-ed Ghosts", 0).requirement("The Curse of Zaros", 1).build());
        achievements.add(new AchievementBuilder("Thalassus hunt 1", 0.05).requirement("Deadliest Catch", 1).reward("Hunter", 2510)
            .build());
        achievements.add(new AchievementBuilder("Thalassus hunt 2", 0.05).requirement("Thalassus hunt 1", 1).reward("Hunter", 2990)
            .build());
        achievements.add(new AchievementBuilder("Thalassus hunt 3", 0.05).requirement("Thalassus hunt 2", 1).reward("Hunter", 3470)
            .build());
        achievements.add(new AchievementBuilder("Thalassus hunt 4", 0.05).requirement("Thalassus hunt 3", 1).reward("Hunter", 3950)
            .build());
        achievements.add(new AchievementBuilder("Thalassus hunt 5", 0.05).requirement("Thalassus hunt 4", 1).reward("Hunter", 4430)
            .build());
        achievements.add(new AchievementBuilder("Thalassus hunt 6", 0.05).requirement("Thalassus hunt 5", 1).reward("Hunter", 4910)
            .build());
        achievements.add(new AchievementBuilder("Thalassus hunt 7", 0.05).requirement("Thalassus hunt 6", 1).reward("Hunter", 5380)
            .build());
        achievements.add(new AchievementBuilder("Thalassus hunt 8", 0.05).requirement("Thalassus hunt 7", 1).reward("Hunter", 5860)
            .build());
        achievements.add(new AchievementBuilder("Thalassus hunt 9", 0.05).requirement("Thalassus hunt 8", 1).reward("Hunter", 6340)
            .build());
        achievements.add(new AchievementBuilder("Thalassus hunt 10", 0.05).requirement("Thalassus hunt 9", 1).reward("Hunter", 6820)
            .build());
        achievements.add(new AchievementBuilder("Deadlier Catch", 0).requirement("Thalassus hunt 10", 1).build());
        achievements.add(new AchievementBuilder("Completionist Cape", 0).requirement("Abyssal Reach", 1)
            .requirement("Almost as Perky as a Prawn", 1).requirement("Annihilator", 1)
            .requirement("Arc - Ancient Eastern Tortle Portals", 1).requirement("Arc - Unlocking Waiko", 1)
            .requirement("Arc - Upgrading Waiko", 1).requirement("Arc III - Spiritual Enlightenment", 1)
            .requirement("Arc II - Head of the Family", 1).requirement("Arc IV - Jed Hunter", 1).requirement("Arc IX - Damage Control", 1)
            .requirement("Arc I - Flag Fall", 1).requirement("Arc VIII - Ghosts from the Past", 1)
            .requirement("Arc VII - Tuai Leit's Own", 1).requirement("Arc VI - Harbinger of Doom", 1)
            .requirement("Arc V - Eye for an Eye", 1).requirement("Arc X - Final Destination", 1).requirement("Bandos's Memories", 1)
            .requirement("Bane Tuner", 1).requirement("Big Chinchompa", 1).requirement("Bipedal Mask", 1)
            .requirement("Bridge over Fremmy Waters", 1).requirement("Claus Is Rising", 1).requirement("Deadlier Catch", 1)
            .requirement("Desert-ed Ghosts", 1).requirement("Diaries of the Clans", 1).requirement("Elven Titles", 1)
            .requirement("Family Spirit Tree", 1).requirement("Famous", 1).requirement("Heal, Quickly", 1)
            .requirement("I'm Forever Washing Shadows", 1).requirement("Imping Around", 1).requirement("Invention Gives Me the Blues", 1)
            .requirement("Kharshai's Memories", 1).requirement("Kiln Fighter", 1).requirement("Kudos to You", 1)
            .requirement("Long Live the Queen", 1).requirement("Lost Toys", 1).requirement("Lunar Master", 1)
            .requirement("Make Them Bleed", 1).requirement("Master Quester", 1).requirement("Master Skiller", 1)
            .requirement("Memories of Guthix", 1).requirement("Music Maestro", 1).requirement("Myreque in Memoriam", 1)
            .requirement("One Foot in the Grave", 1).requirement("Out into the Ourania", 1).requirement("Peachy Bones", 1)
            .requirement("Pious Prayers", 1).requirement("Port Life", 1).requirement("Potion Mixer Master", 1)
            .requirement("Potion for a Lady", 1).requirement("Reaper Crew", 1).requirement("Rhian in Gold - The Original", 1)
            .requirement("Seren Memories", 1).requirement("Sing for the Lady", 1).requirement("Slayer Master", 1)
            .requirement("Stay Safe", 1).requirement("Stay Secure", 1).requirement("Task Master", 1).requirement("Tell Tale Tarn", 1)
            .requirement("Trip to the East", 1).requirement("Troublesome Crystals", 1).requirement("Uncorrupted Ore", 1)
            .requirement("Walking the Reef", 1).requirement("What's Mine Is Also Doric's", 1).requirement("Yaktwee's a Charm", 1)
            .requirement("You Be Dead", 1).requirement("Zarosian Memories", 1).build());
        achievements.add(new AchievementBuilder("Conquest Adore", 0).requirement("Conquest rank", 1250).build());
        achievements.add(new AchievementBuilder("Constitution - Morty", 0).requirement("Morty", 1).build());
        achievements.add(new AchievementBuilder("Constitution 15", 0).requirement("Constitution", 15).build());
        achievements.add(new AchievementBuilder("Constitution 20", 0).requirement("Constitution", 20).build());
        achievements.add(new AchievementBuilder("Constitution 30", 0).requirement("Constitution", 30).build());
        achievements.add(new AchievementBuilder("Constitution 40", 0).requirement("Constitution", 40).build());
        achievements.add(new AchievementBuilder("Constitution 50", 0).requirement("Constitution", 50).build());
        achievements.add(new AchievementBuilder("Constitution 60", 0).requirement("Constitution", 60).build());
        achievements.add(new AchievementBuilder("Constitution 70", 0).requirement("Constitution", 70).build());
        achievements.add(new AchievementBuilder("Constitution 80", 0).requirement("Constitution", 80).build());
        achievements.add(new AchievementBuilder("Constitution 90", 0).requirement("Constitution", 90).build());
        achievements.add(new AchievementBuilder("Constitution 92", 0).requirement("Constitution", 92).build());
        achievements.add(new AchievementBuilder("Constitution 99", 0).requirement("Constitution", 99).build());
        achievements.add(new AchievementBuilder("Construction - Baba Yaga's House", 0).requirement("Baby Yaga's House'", 1).build());
        achievements.add(new AchievementBuilder("Construction 5", 0).requirement("Construction", 5).build());
        achievements.add(new AchievementBuilder("Construction 10", 0).requirement("Construction", 10).build());
        achievements.add(new AchievementBuilder("Construction 20", 0).requirement("Construction", 20).build());
        achievements.add(new AchievementBuilder("Construction 30", 0).requirement("Construction", 30).build());
        achievements.add(new AchievementBuilder("Construction 40", 0).requirement("Construction", 40).build());
        achievements.add(new AchievementBuilder("Construction 50", 0).requirement("Construction", 50).build());
        achievements.add(new AchievementBuilder("Construction 60", 0).requirement("Construction", 60).build());
        achievements.add(new AchievementBuilder("Construction 70", 0).requirement("Construction", 70).build());
        achievements.add(new AchievementBuilder("Construction 80", 0).requirement("Construction", 80).build());
        achievements.add(new AchievementBuilder("Construction 90", 0).requirement("Construction", 90).build());
        achievements.add(new AchievementBuilder("Construction 92", 0).requirement("Construction", 92).build());
        achievements.add(new AchievementBuilder("Construction 99", 0).requirement("Construction", 99).build());
        achievements.add(new AchievementBuilder("Cook's Delight", 0).requirement("Cook's Assistant", 1).build());
        achievements.add(new AchievementBuilder("Cooking - Ramsay", 0).requirement("Ramsay", 1).build());
        achievements.add(new AchievementBuilder("Cooking 5", 0).requirement("Cooking", 5).build());
        achievements.add(new AchievementBuilder("Cooking 10", 0).requirement("Cooking", 10).build());
        achievements.add(new AchievementBuilder("Cooking 20", 0).requirement("Cooking", 20).build());
        achievements.add(new AchievementBuilder("Cooking 30", 0).requirement("Cooking", 30).build());
        achievements.add(new AchievementBuilder("Cooking 40", 0).requirement("Cooking", 40).build());
        achievements.add(new AchievementBuilder("Cooking 50", 0).requirement("Cooking", 50).build());
        achievements.add(new AchievementBuilder("Cooking 60", 0).requirement("Cooking", 60).build());
        achievements.add(new AchievementBuilder("Cooking 70", 0).requirement("Cooking", 70).build());
        achievements.add(new AchievementBuilder("Cooking 80", 0).requirement("Cooking", 80).build());
        achievements.add(new AchievementBuilder("Cooking 90", 0).requirement("Cooking", 90).build());
        achievements.add(new AchievementBuilder("Cooking 92", 0).requirement("Cooking", 92).build());
        achievements.add(new AchievementBuilder("Cooking 99", 0).requirement("Cooking", 99).build());
        achievements.add(new AchievementBuilder("Cormes and Goes", 0).encounter(new Encounter(Arrays.asList(Arrays.asList("Airut",
            "Airut", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Charger", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut",
                "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger",
                "Charger"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")))).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment I", 0).requirement("Corporeal Beast", 5).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment II", 0).requirement("Corporeal Beast", 10).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment III", 0).requirement("Corporeal Beast", 25).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment IV", 0).requirement("Corporeal Beast", 50).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment V", 0).requirement("Corporeal Beast", 75).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment VI", 0).requirement("Corporeal Beast", 100).build());
        achievements.add(new AchievementBuilder("Corporeal Puppy", 0).requirement("Corporeal bone", 1).build());
        achievements.add(new AchievementBuilder("From Tiny Acorns", 0.25).requirement("Buyers and Cellars", 1)
            .requirement("Thieving", 24).reward("Thieving", 1000).build());
        achievements.add(new AchievementBuilder("Lost Her Marbles", 0.75).requirement("From Tiny Acorns", 1)
            .requirement("Thieving", 41).reward("Thieving", 10527).reward("Coal", 46).reward("Gold ore", 38).reward("Teak logs", 126)
            .reward("Maple logs", 255).reward("Raw lobster", 37).reward("Raw swordfish", 19).reward("Nature rune", 43)
            .reward("Law rune", 45).build());
        achievements.add(new AchievementBuilder("A Guild of Our Own", 0.5).requirement("Lost Her Marbles", 1)
            .requirement("The Feud", 1).requirement("Thieving", 62).requirement("Agility", 40).requirement("Herblore", 46)
            .requirement("Lockpick", 0).requirement("Chopped onion", 1).requirement("Clean irit", 1).requirement("Vial of water", 1)
            .reward("Thieving", 30000).reward("Herblore", 4001).build());
        achievements.add(new AchievementBuilder("Count All Light Fingers", 0).requirement("A Guild of Our Own", 1).build());
        achievements.add(new AchievementBuilder("Coursing Through You", 0).requirement("Max Telos enrage", 95)
            .encounter(new Encounter("Telos (100% enrage)")).build());
        achievements.add(new AchievementBuilder("Cower Behind the Chosen Commander", 0)
            .requirement("The Chosen Commander", 1).lamp(Arrays.asList("Constitution", "Attack", "Defense"), 1000, 1).build());
        achievements.add(new AchievementBuilder("Crafting - Gemi", 0).requirement("Gemi", 1).build());
        achievements.add(new AchievementBuilder("Crafting 5", 0).requirement("Crafting", 5).build());
        achievements.add(new AchievementBuilder("Crafting 10", 0).requirement("Crafting", 10).build());
        achievements.add(new AchievementBuilder("Crafting 20", 0).requirement("Crafting", 20).build());
        achievements.add(new AchievementBuilder("Crafting 30", 0).requirement("Crafting", 30).build());
        achievements.add(new AchievementBuilder("Crafting 40", 0).requirement("Crafting", 40).build());
        achievements.add(new AchievementBuilder("Crafting 50", 0).requirement("Crafting", 50).build());
        achievements.add(new AchievementBuilder("Crafting 60", 0).requirement("Crafting", 60).build());
        achievements.add(new AchievementBuilder("Crafting 70", 0).requirement("Crafting", 70).build());
        achievements.add(new AchievementBuilder("Crafting 80", 0).requirement("Crafting", 80).build());
        achievements.add(new AchievementBuilder("Crafting 90", 0).requirement("Crafting", 90).build());
        achievements.add(new AchievementBuilder("Crafting 92", 0).requirement("Crafting", 92).build());
        achievements.add(new AchievementBuilder("Crafting 99", 0).requirement("Crafting", 99).build());
        achievements.add(new AchievementBuilder("Cran Door's Secret", 0).requirement("Dragon Slayer", 1).build());
        achievements.add(new AchievementBuilder("Crayfish Roasting On An Open Fire", 0).requirement("Raw crayfish", 1)
            .reward("Crayfish", 1).reward("Cooking", 30).build());
        achievements.add(new AchievementBuilder("Crossing Over I", 0).requirement("The Magister", 5).build());
        achievements.add(new AchievementBuilder("Crossing Over II", 0).requirement("The Magister", 10).build());
        achievements.add(new AchievementBuilder("Crossing Over III", 0).requirement("The Magister", 25).build());
        achievements.add(new AchievementBuilder("Crossing Over IV", 0).requirement("The Magister", 50).build());
        achievements.add(new AchievementBuilder("Crossing Over V", 0).requirement("The Magister", 75).build());
        achievements.add(new AchievementBuilder("Crossing Over VI", 0).requirement("The Magister", 100).build());
        achievements.add(new AchievementBuilder("Daemonology of Celerity", 0).requirement("Demon flash mob", 1).build());
        achievements.add(new AchievementBuilder("Daero Take This Experience?", 0).requirement("Monkey Madness", 1)
            .reward("Attack", 20000).reward("Strength", 20000).reward("Defense", 20000).reward("Constitution", 20000)
            .lamp(Arrays.asList("Attack", "Strength"), 15000, 1).lamp(Arrays.asList("Constitution", "Defense"), 15000, 1).build());
        achievements.add(new AchievementBuilder("Dagannoth Traffic Wardens", 0).requirement("Koschei's Troubles", 1)
            .encounter(new Encounter("Dagannoth Supreme", Collections.singletonList(new Restriction("Achromatic Balmung", 1))))
            .encounter(new Encounter("Dagannoth Supreme", Collections.singletonList(new Restriction("Cobalt Balmung", 1))))
            .encounter(new Encounter("Dagannoth Supreme", Collections.singletonList(new Restriction("Crimson Balmung", 1))))
            .encounter(new Encounter("Dagannoth Supreme", Collections.singletonList(new Restriction("Viridian Balmung", 1)))).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone I", 0).requirement("Dagannoth Kings", 5).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone II", 0).requirement("Dagannoth Kings", 10).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone III", 0).requirement("Dagannoth Kings", 25).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone IV", 0).requirement("Dagannoth Kings", 50).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone V", 0).requirement("Dagannoth Kings", 75).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone VI", 0).requirement("Dagannoth Kings", 100).build());
        achievements.add(new AchievementBuilder("Dark Imperator-ment", 0).requirement("Constitution", 91).requirement("Attack", 75)
            .requirement("Magic", 75).requirement("Ranged", 75).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .reward("Zemomark", 40).build());
        achievements.add(new AchievementBuilder("Day at the Aquarium", 0).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru")))).build());
        achievements.add(new AchievementBuilder("Day at the Pound", 0)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"), Arrays.asList("Airut", "Airut",
                "Charger", "Charger"), Arrays.asList("Airut", "Charger", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut",
                "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"), Arrays.asList("Airut", "Airut", "Airut", "Airut", 
                    "Airut", "Airut", "Airut"), Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")))).build());
        achievements.add(new AchievementBuilder("Book of death", 0).requirement("Reaper point", 500).build());
        achievements.add(new AchievementBuilder("Reaper's choice", 0).requirement("Reaper point", 250).build());
        achievements.add(new AchievementBuilder("Rainbow loot beam", 0).requirement("Reaper point", 75).build());
        achievements.add(new AchievementBuilder("Grave loot beam", 0).requirement("Reaper point", 75).build());
        achievements.add(new AchievementBuilder("Bonfire booster", 0).requirement("Reaper point", 250).build());
        achievements.add(new AchievementBuilder("Instance cost", 0).requirement("Reaper point", 250).build());
        achievements.add(new AchievementBuilder("Additional tasks", 0).requirement("Reaper point", 150).build());
        achievements.add(new AchievementBuilder("Reaper scroll", 0).requirement("Reaper point", 250).build());
        achievements.add(new AchievementBuilder("Death's support", 0).requirement("Reaper point", 250).build());
        achievements.add(new AchievementBuilder("Death Effect", 0).requirement("Book of death", 1).requirement("Reaper's choice", 1)
            .requirement("Rainbow loot beam", 1).requirement("Grave loot beam", 1).requirement("Bonfire booster", 1)
            .requirement("Instance cost", 1).requirement("Additional tasks", 1).requirement("Reaper scroll", 1)
            .requirement("Death's support", 1).build());
        achievements.add(new AchievementBuilder("Death to the Mahjarrat", 0).requirement("Mahjarrat deathstone", 4).build());
        achievements.add(new AchievementBuilder("Deep and Bloody Experience", 0).requirement("Blood Runs Deep", 1)
            .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75).build());
        achievements.add(new AchievementBuilder("Defence - Wallace", 0).requirement("Wallace", 1).build());
        achievements.add(new AchievementBuilder("Defense 5", 0).requirement("Defense", 5).build());
        achievements.add(new AchievementBuilder("Defense 10", 0).requirement("Defense", 10).build());
        achievements.add(new AchievementBuilder("Defense 20", 0).requirement("Defense", 20).build());
        achievements.add(new AchievementBuilder("Defense 30", 0).requirement("Defense", 30).build());
        achievements.add(new AchievementBuilder("Defense 40", 0).requirement("Defense", 40).build());
        achievements.add(new AchievementBuilder("Defense 50", 0).requirement("Defense", 50).build());
        achievements.add(new AchievementBuilder("Defense 60", 0).requirement("Defense", 60).build());
        achievements.add(new AchievementBuilder("Defense 70", 0).requirement("Defense", 70).build());
        achievements.add(new AchievementBuilder("Defense 80", 0).requirement("Defense", 80).build());
        achievements.add(new AchievementBuilder("Defense 90", 0).requirement("Defense", 90).build());
        achievements.add(new AchievementBuilder("Defense 92", 0).requirement("Defense", 92).build());
        achievements.add(new AchievementBuilder("Defense 99", 0).requirement("Defense", 99).build());
        achievements.add(new AchievementBuilder("Descension I", 0).requirement("Legiones", 5).build());
        achievements.add(new AchievementBuilder("Descension II", 0).requirement("Legiones", 10).build());
        achievements.add(new AchievementBuilder("Descension III", 0).requirement("Legiones", 25).build());
        achievements.add(new AchievementBuilder("Descension IV", 0).requirement("Legiones", 50).build());
        achievements.add(new AchievementBuilder("Descension V", 0).requirement("Legiones", 75).build());
        achievements.add(new AchievementBuilder("Descension VI", 0).requirement("Legiones", 100).build());
        achievements.add(new AchievementBuilder("Dharok Bobblehead", 0).requirement("Dharok the Bobbled", 1).build());
        achievements.add(new AchievementBuilder("Diary of Oreb", 0).requirement("The Magister's Journals", 5).build());
        achievements.add(new AchievementBuilder("Diary of the Gods", 0).requirement("God journals", 5).build());
        achievements.add(new AchievementBuilder("Diddyzag", 0).requirement("Durzag's helmet", 1).build());
        achievements.add(new AchievementBuilder("Digging for Treasure", 0).requirement("Meerkat pouch", 1)
            .requirement("Fetch casket scroll", 1).requirement("Summoning", 4).requirement("Clue scroll", 1).reward("Summoning", 1)
            .build());
        achievements.add(new AchievementBuilder("Dishonourable Gains", 0).requirement("Zamorak hideout XP chests", 3).build());
        achievements.add(new AchievementBuilder("Dishonourable Loot", 0).requirement("Zamorak hideout loot chests", 6).build());
        achievements.add(new AchievementBuilder("Disowned", 0).requirement("The Lord of Vampyrium", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Vanstrom Klause"),
                Collections.singletonList("Vanstrom Klause")), Arrays.asList(new Restriction("Sunspear", 1),
                new Restriction("House Drakan hood", 1), new Restriction("House Drakan top", 1),
                new Restriction("House Drakan trousers", 1), new Restriction("House Drakan boots", 1)))).build());
        achievements.add(new AchievementBuilder("Distorted Div", 0).requirement("Distorted engrammeter", 1)
            .reward("Divination", 25000).build());
        achievements.add(new AchievementBuilder("Divination - Willow", 0).requirement("Willow", 1).build());
        achievements.add(new AchievementBuilder("Divination 5", 0).requirement("Divination", 5).build());
        achievements.add(new AchievementBuilder("Divination 10", 0).requirement("Divination", 10).build());
        achievements.add(new AchievementBuilder("Divination 20", 0).requirement("Divination", 20).build());
        achievements.add(new AchievementBuilder("Divination 30", 0).requirement("Divination", 30).build());
        achievements.add(new AchievementBuilder("Divination 40", 0).requirement("Divination", 40).build());
        achievements.add(new AchievementBuilder("Divination 50", 0).requirement("Divination", 50).build());
        achievements.add(new AchievementBuilder("Divination 60", 0).requirement("Divination", 60).build());
        achievements.add(new AchievementBuilder("Divination 70", 0).requirement("Divination", 70).build());
        achievements.add(new AchievementBuilder("Divination 80", 0).requirement("Divination", 80).build());
        achievements.add(new AchievementBuilder("Divination 90", 0).requirement("Divination", 90).build());
        achievements.add(new AchievementBuilder("Divination 92", 0).requirement("Divination", 92).build());
        achievements.add(new AchievementBuilder("Divination 99", 0).requirement("Divination", 99).build());
        achievements.add(new AchievementBuilder("What an Experience", 0).reward("Divination", 3).build());
        achievements.add(new AchievementBuilder("Simply Divine", 0).requirement("Pale energy", 5).requirement("Raw crayfish", 20)
            .build());
        achievements.add(new AchievementBuilder("Portentially Hazardous", 0).requirement("Pale energy", 30)
            .requirement("Sardine", 1).reward("Portent of restoration I", 1).reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Mighty Morphing", 0).requirement("Divination", 13).requirement("Logs", 3)
            .requirement("Flickering energy", 2).reward("Oak logs", 1).requirement("Divination", 3).build());
        achievements.add(new AchievementBuilder("Let's Enhance", 0).requirement("Pale energy", 5).reward("Divination", 4).build());
        achievements.add(new AchievementBuilder("Just Give Me a Sign", 0).requirement("Divination", 6).requirement("Pale energy", 30)
            .requirement("Sapphire necklace", 1).reward("Sign of the porter I", 1).reward("Divination", 2).build());
        achievements.add(new AchievementBuilder("Enrichment Programme", 0).reward("Divination", 2).build());
        achievements.add(new AchievementBuilder("Energy Generator", 0).reward("Pale energy", 1).reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Divine Retribution", 0).requirement("Business Is Booning!", 1)
            .requirement("Collecting Memorabilia", 1).requirement("Energy Generator", 1).requirement("Enrichment Programme", 1)
            .requirement("Just Give Me a Sign", 1).requirement("Let's Enhance", 1).requirement("Mighty Morphing", 1)
            .requirement("Portentially Hazardous", 1).requirement("Simply Divine", 1).requirement("What an Experience", 1)
            .reward("Flickering energy", 500).build());
        achievements.add(new AchievementBuilder("Diving For Clues", 0).requirement("Treasure chest decoration", 1)
            .reward("Elite clue scroll", 1).build());
        achievements.add(new AchievementBuilder("Do No Elite", 0).requirement("Do No Evil elite clue", 1).build());
        achievements.add(new AchievementBuilder("Do a Minion, Take Notes", 0).requirement("Dominion page", 20).build());
        achievements.add(new AchievementBuilder("Don't Fear the Ripper", 0).requirement("Miner's journals", 6).build());
        achievements.add(new AchievementBuilder("Double Swoop", 0).requirement("Ranged", 70)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Flight Kilisa", "Wingman Skree", "Flockleader Geerin"),
                Arrays.asList("Flight Kilisa", "Wingman Skree", "Flockleader Geerin", "Kree'arra")))).build());
        achievements.add(new AchievementBuilder("Dragonkin Logs", 0).requirement("Dragonkin journals", 4).build());
        achievements.add(new AchievementBuilder("Draynor", 0).build());
        achievements.add(new AchievementBuilder("Dungeoneering - Gordie", 0).requirement("Gordie", 1).build());
        achievements.add(new AchievementBuilder("Dungeoneering 5", 0).requirement("Dungeoneering", 5).build());
        achievements.add(new AchievementBuilder("Dungeoneering 10", 0).requirement("Dungeoneering", 10).build());
        achievements.add(new AchievementBuilder("Dungeoneering 20", 0).requirement("Dungeoneering", 20).build());
        achievements.add(new AchievementBuilder("Dungeoneering 30", 0).requirement("Dungeoneering", 30).build());
        achievements.add(new AchievementBuilder("Dungeoneering 40", 0).requirement("Dungeoneering", 40).build());
        achievements.add(new AchievementBuilder("Dungeoneering 50", 0).requirement("Dungeoneering", 50).build());
        achievements.add(new AchievementBuilder("Dungeoneering 60", 0).requirement("Dungeoneering", 60).build());
        achievements.add(new AchievementBuilder("Dungeoneering 70", 0).requirement("Dungeoneering", 70).build());
        achievements.add(new AchievementBuilder("Dungeoneering 80", 0).requirement("Dungeoneering", 80).build());
        achievements.add(new AchievementBuilder("Dungeoneering 90", 0).requirement("Dungeoneering", 90).build());
        achievements.add(new AchievementBuilder("Dungeoneering 99", 0).requirement("Dungeoneering", 99).build());
        achievements.add(new AchievementBuilder("Dungeoneering 110", 0).requirement("Dungeoneering", 110).build());
        achievements.add(new AchievementBuilder("Dungeoneering 120", 0).requirement("Dungeoneering", 120).build());
        achievements.add(new AchievementBuilder("Dusting Murial", 0).requirement("Dusted murals", 2).build());
        achievements.add(new AchievementBuilder("Eagles' Peak", 0).build());
        achievements.add(new AchievementBuilder("Architect storyline", 0.3).requirement("Construction", 90)
            .requirement("Port distance", 1200000).reward("Pearls", 12).reward("Koi Scales", 12).build());
        achievements.add(new AchievementBuilder("Eastern Curiosities storyline", 0.15).requirement("Trapper storyline", 1)
            .requirement("Chef storyline", 1).requirement("Architect storyline", 1).build());
        achievements.add(new AchievementBuilder("Eastern Adventurer", 0).requirement("Quin storyline", 1)
            .requirement("Hyu-Ji storyline", 1).requirement("Eastern Curiosities storyline", 1)
            .requirement("Guardians of the World storyline", 1).build());
        achievements.add(new AchievementBuilder("Eastern Explorer", 0).requirement("The Shield region", 1).build());
        achievements.add(new AchievementBuilder("Eat to Live", 0).requirement("Sardine", 1).build());
        achievements.add(new AchievementBuilder("Edgeville", 0).build());
        achievements.add(new AchievementBuilder("Eeeeagle!", 0).requirement("Agility", 35).requirement("Strength", 45)
            .requirement("Eagles' Peak (quest)", 1).requirement("Back to my Roots", 1).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos I", 0).requirement("Chaos Elemental", 5).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos II", 0).requirement("Chaos Elemental", 10).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos III", 0).requirement("Chaos Elemental", 25).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos IV", 0).requirement("Chaos Elemental", 50).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos V", 0).requirement("Chaos Elemental", 75).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos VI", 0).requirement("Chaos Elemental", 100).build());
        achievements.add(new AchievementBuilder("Ellie", 0).requirement("Ribs of chaos", 1).build());
        achievements.add(new AchievementBuilder("Enough of the Crazy Walking", 0).requirement("Mad Ramblings", 2).build());
        achievements.add(new AchievementBuilder("Epi Logueque Experience", 0).requirement("While Guthix Sleeps", 1)
            .lamp(Player.ALL_SKILLS, 100000, 65).lamp(Player.ALL_SKILLS, 100000, 65).lamp(Player.ALL_SKILLS, 100000, 65)
            .lamp(Player.ALL_SKILLS, 100000, 65).build());
        achievements.add(new AchievementBuilder("Exiled", 0).requirement("Kalphite King uniques", 8).build());
        achievements.add(new AchievementBuilder("Experience the Fate of the Gods", 0)
            .requirement("Post-Fate of the Gods lamps", 4).build());
        achievements.add(new AchievementBuilder("Explore for Nestor", 0).build());
        achievements.add(new AchievementBuilder("Faceless And Ready", 0).build());
        achievements.add(new AchievementBuilder("Falador", 0).build());
        achievements.add(new AchievementBuilder("Fallen Angel", 0).requirement("Angel of Death uniques", 10).build());
        achievements.add(new AchievementBuilder("Family Affair", 0).requirement("Rise of the Six uniques", 10).build());
        achievements.add(new AchievementBuilder("Fancy turtle-back", 0).requirement("Fishing", 68).build());
        achievements.add(new AchievementBuilder("Farming - Brains", 0).requirement("Brains", 1).build());
        achievements.add(new AchievementBuilder("Farming 5", 0).requirement("Farming", 5).build());
        achievements.add(new AchievementBuilder("Farming 10", 0).requirement("Farming", 10).build());
        achievements.add(new AchievementBuilder("Farming 20", 0).requirement("Farming", 20).build());
        achievements.add(new AchievementBuilder("Farming 30", 0).requirement("Farming", 30).build());
        achievements.add(new AchievementBuilder("Farming 40", 0).requirement("Farming", 40).build());
        achievements.add(new AchievementBuilder("Farming 50", 0).requirement("Farming", 50).build());
        achievements.add(new AchievementBuilder("Farming 60", 0).requirement("Farming", 60).build());
        achievements.add(new AchievementBuilder("Farming 70", 0).requirement("Farming", 70).build());
        achievements.add(new AchievementBuilder("Farming 80", 0).requirement("Farming", 80).build());
        achievements.add(new AchievementBuilder("Farming 90", 0).requirement("Farming", 90).build());
        achievements.add(new AchievementBuilder("Farming 92", 0).requirement("Farming", 92).build());
        achievements.add(new AchievementBuilder("Farming 99", 0).requirement("Farming", 99).build());
        achievements.add(new AchievementBuilder("Fast and Furious I", 0).requirement("Twin Furies", 5).build());
        achievements.add(new AchievementBuilder("Fast and Furious II", 0).requirement("Twin Furies", 10).build());
        achievements.add(new AchievementBuilder("Fast and Furious III", 0).requirement("Twin Furies", 25).build());
        achievements.add(new AchievementBuilder("Fast and Furious IV", 0).requirement("Twin Furies", 50).build());
        achievements.add(new AchievementBuilder("Fast and Furious V", 0).requirement("Twin Furies", 75).build());
        achievements.add(new AchievementBuilder("Fast and Furious VI", 0).requirement("Twin Furies", 100).build());
        achievements.add(new AchievementBuilder("Feline Good", 0).requirement("Menaphos cats", 1).build());
        achievements.add(new AchievementBuilder("Ferocious Upgrade", 0).requirement("Slayer", 90).requirement("Slayer point", 100)
            .build());
        achievements.add(new AchievementBuilder("Fill Them All!", 0).requirement("Treasure Trail hidey-holes", 58).build());
        achievements.add(new AchievementBuilder("Zilly Way to Die VI", 0).requirement("Commander Zilyana", 100).build());
        achievements.add(new AchievementBuilder("Yak and Ruin VI", 0).requirement("Yakamaru", 100).build());
        achievements.add(new AchievementBuilder("Who's the Boss? VI", 0).requirement("Boss kills", 5000).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious VI", 0).requirement("Vindicta", 100).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One VI", 0)
            .requirement("King Black Dragon", 100).build());
        achievements.add(new AchievementBuilder("This Helwyr in VI", 0).requirement("Helwyr", 100).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts VI", 0).requirement("Telos", 100).build());
        achievements.add(new AchievementBuilder("Something Barrowed VI", 0).requirement("Barrows", 100).build());
        achievements.add(new AchievementBuilder("Nex Pls VI", 0).requirement("Nex: Angel of Death", 100).build());
        achievements.add(new AchievementBuilder("Mole Removal VI", 0).requirement("Giant Mole", 100).build());
        achievements.add(new AchievementBuilder("Master of Beatings VI", 0).requirement("Beastmaster Durzag", 100).build());
        achievements.add(new AchievementBuilder("Loot Pinata VI", 0).requirement("Queen Black Dragon", 100).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch VI", 0).requirement("TzTok-Jad", 100).build());
        achievements.add(new AchievementBuilder("Kill K'ril VI", 0).requirement("K'ril Tsutsaroth", 100).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge VI", 0).requirement("Har-Aken", 100).build());
        achievements.add(new AchievementBuilder("Gregorgeous VI", 0).requirement("Gregorovic", 100).build());
        achievements.add(new AchievementBuilder("General Mayhem VI", 0).requirement("General Graardor", 100).build());
        achievements.add(new AchievementBuilder("Final Boss", 0).requirement("Who's the Boss? VI", 1)
            .requirement("General Mayhem VI", 1).requirement("Zilly Way to Die VI", 1).requirement("Three Heads are Deader than One VI", 1)
            .requirement("Mole Removal VI", 1).requirement("Along Came a Spider VI", 1).requirement("Bug Swatter VI", 1)
            .requirement("Vindictive and Vexatious VI", 1).requirement("Fast and Furious VI", 1).requirement("Elemental Kill Chaos VI", 1)
            .requirement("Hardly a Challenge VI", 1).requirement("Barrowed Power VI", 1).requirement("Come and Have Vorago VI", 1)
            .requirement("Nex Pls VI", 1).requirement("Yak and Ruin VI", 1).requirement("Bird is the Word VI", 1)
            .requirement("Kill K'ril VI", 1).requirement("Corporeal Punishment VI", 1).requirement("Loot Pinata VI", 1)
            .requirement("Descension VI", 1).requirement("Dagannoth For Everyone VI", 1).requirement("Telos Where it Hurts VI", 1)
            .requirement("This Helwyr in VI", 1).requirement("Gregorgeous VI", 1).requirement("Living on a Prayer Switch VI", 1)
            .requirement("Something Barrowed VI", 1).requirement("Bug Zapper VI", 1).requirement("Brass Nex VI", 1)
            .requirement("Master of Beatings VI", 1).build());
        achievements.add(new AchievementBuilder("Finish Him!", 0).encounter(new Encounter("Vorago")).build());
        achievements.add(new AchievementBuilder("Firemaking - Bernie", 0).requirement("Bernie", 1).build());
        achievements.add(new AchievementBuilder("Firemaking 5", 0).requirement("Firemaking", 5).build());
        achievements.add(new AchievementBuilder("Firemaking 10", 0).requirement("Firemaking", 10).build());
        achievements.add(new AchievementBuilder("Firemaking 20", 0).requirement("Firemaking", 20).build());
        achievements.add(new AchievementBuilder("Firemaking 30", 0).requirement("Firemaking", 30).build());
        achievements.add(new AchievementBuilder("Firemaking 40", 0).requirement("Firemaking", 40).build());
        achievements.add(new AchievementBuilder("Firemaking 50", 0).requirement("Firemaking", 50).build());
        achievements.add(new AchievementBuilder("Firemaking 60", 0).requirement("Firemaking", 60).build());
        achievements.add(new AchievementBuilder("Firemaking 70", 0).requirement("Firemaking", 70).build());
        achievements.add(new AchievementBuilder("Firemaking 80", 0).requirement("Firemaking", 80).build());
        achievements.add(new AchievementBuilder("Firemaking 90", 0).requirement("Firemaking", 90).build());
        achievements.add(new AchievementBuilder("Firemaking 92", 0).requirement("Firemaking", 92).build());
        achievements.add(new AchievementBuilder("Firemaking 99", 0).requirement("Firemaking", 99).build());
        achievements.add(new AchievementBuilder("Fires are Mostly Harmless", 0)
            .requirement("Fairy Tale III post-quest rewards", 2).build());
        achievements.add(new AchievementBuilder("First Rule of Fight Caves", 0).requirement("TzHaar uniques", 1).build());
        achievements.add(new AchievementBuilder("Fishing - Bubbles", 0).requirement("Bubbles", 1).build());
        achievements.add(new AchievementBuilder("Fishing 5", 0).requirement("Fishing", 5).build());
        achievements.add(new AchievementBuilder("Fishing 10", 0).requirement("Fishing", 10).build());
        achievements.add(new AchievementBuilder("Fishing 20", 0).requirement("Fishing", 20).build());
        achievements.add(new AchievementBuilder("Fishing 30", 0).requirement("Fishing", 30).build());
        achievements.add(new AchievementBuilder("Fishing 40", 0).requirement("Fishing", 40).build());
        achievements.add(new AchievementBuilder("Fishing 50", 0).requirement("Fishing", 50).build());
        achievements.add(new AchievementBuilder("Fishing 60", 0).requirement("Fishing", 60).build());
        achievements.add(new AchievementBuilder("Fishing 70", 0).requirement("Fishing", 70).build());
        achievements.add(new AchievementBuilder("Fishing 80", 0).requirement("Fishing", 80).build());
        achievements.add(new AchievementBuilder("Fishing 90", 0).requirement("Fishing", 90).build());
        achievements.add(new AchievementBuilder("Fishing 92", 0).requirement("Fishing", 92).build());
        achievements.add(new AchievementBuilder("Fishing 99", 0).requirement("Fishing", 99).build());
        achievements.add(new AchievementBuilder("Fist Contact", 0).requirement("Strength", 70)
            .encounter(new Encounter("General Graardor", Arrays.asList(new Restriction("Main-hand", 0),
                new Restriction("Off-hand", 0)))).build());
        achievements.add(new AchievementBuilder("Five-Star General", 0).requirement("General Graardor uniques", 18).build());
        achievements.add(new AchievementBuilder("Fletching - Flo", 0).requirement("Flo", 1).build());
        achievements.add(new AchievementBuilder("Fletching 5", 0).requirement("Fletching", 5).build());
        achievements.add(new AchievementBuilder("Fletching 10", 0).requirement("Fletching", 10).build());
        achievements.add(new AchievementBuilder("Fletching 20", 0).requirement("Fletching", 20).build());
        achievements.add(new AchievementBuilder("Fletching 30", 0).requirement("Fletching", 30).build());
        achievements.add(new AchievementBuilder("Fletching 40", 0).requirement("Fletching", 40).build());
        achievements.add(new AchievementBuilder("Fletching 50", 0).requirement("Fletching", 50).build());
        achievements.add(new AchievementBuilder("Fletching 60", 0).requirement("Fletching", 60).build());
        achievements.add(new AchievementBuilder("Fletching 70", 0).requirement("Fletching", 70).build());
        achievements.add(new AchievementBuilder("Fletching 80", 0).requirement("Fletching", 80).build());
        achievements.add(new AchievementBuilder("Fletching 90", 0).requirement("Fletching", 90).build());
        achievements.add(new AchievementBuilder("Fletching 92", 0).requirement("Fletching", 92).build());
        achievements.add(new AchievementBuilder("Fletching 99", 0).requirement("Fletching", 99).build());
        achievements.add(new AchievementBuilder("Floor is Larval", 0).requirement("Summoning", 60)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm",
                "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm"), Arrays.asList("Giant worm", "Giant worm",
                "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm"),
                Arrays.asList("Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm",
                    "Giant worm", "Giant worm", "Giant worm"), Collections.singletonList("Queen Black Dragon")))).build());
        achievements.add(new AchievementBuilder("For the Love of Mabel", 0).requirement("Love Story post-quest rewards", 1).build());
        achievements.add(new AchievementBuilder("Forcae's Mettle", 0).requirement("Forcae's journal page", 10).build());
        achievements.add(new AchievementBuilder("Sheep Shearer", 0.25).reward("Coins", 2000).reward("Crafting", 150).build());
        achievements.add(new AchievementBuilder("Fred's Shearings", 0).requirement("Sheep Shearer", 1).build());
        achievements.add(new AchievementBuilder("Fremennik Province", 0).build());
        achievements.add(new AchievementBuilder("Frenzied", 0.2).requirement("Fishing", 94).build());
        achievements.add(new AchievementBuilder("Friendly Neighbour", 0).requirement("Araxxor uniques", 15).build());
        achievements.add(new AchievementBuilder("Friends with Max", 0).requirement("Agility", 99).requirement("Attack", 99)
            .requirement("Strength", 99).requirement("Defense", 99).requirement("Ranged", 99).requirement("Prayer", 99)
            .requirement("Invention", 99).requirement("Constitution", 99).requirement("Crafting", 99).requirement("Mining", 99)
            .requirement("Smithing", 99).requirement("Fishing", 99).requirement("Cooking", 99).requirement("Firemaking", 99)
            .requirement("Woodcutting", 99).requirement("Runecrafting", 99).requirement("Dungeoneering", 99).requirement("Fletching", 99)
            .requirement("Herblore", 99).requirement("Thieving", 99).requirement("Magic", 99).requirement("Slayer", 99)
            .requirement("Farming", 99).requirement("Construction", 99).requirement("Hunter", 99).requirement("Summoning", 99)
            .requirement("Divination", 99).build());
        achievements.add(new AchievementBuilder("Game Over", 0).requirement("Gregorovic uniques", 8).build());
        achievements.add(new AchievementBuilder("General Awwdor", 0).requirement("Decaying tooth", 1).build());
        achievements.add(new AchievementBuilder("General Disaster I", 0).requirement("General Graardor (hard)", 5).build());
        achievements.add(new AchievementBuilder("General Disaster II", 0).requirement("General Graardor (hard)", 10).build());
        achievements.add(new AchievementBuilder("General Disaster III", 0).requirement("General Graardor (hard)", 25).build());
        achievements.add(new AchievementBuilder("General Disaster IV", 0).requirement("General Graardor (hard)", 50).build());
        achievements.add(new AchievementBuilder("General Disaster V", 0).requirement("General Graardor (hard)", 75).build());
        achievements.add(new AchievementBuilder("General Disaster VI", 0).requirement("General Graardor (hard)", 100).build());
        achievements.add(new AchievementBuilder("General Mayhem I", 0).requirement("General Graardor", 5).build());
        achievements.add(new AchievementBuilder("General Mayhem II", 0).requirement("General Graardor", 10).build());
        achievements.add(new AchievementBuilder("General Mayhem III", 0).requirement("General Graardor", 25).build());
        achievements.add(new AchievementBuilder("General Mayhem IV", 0).requirement("General Graardor", 50).build());
        achievements.add(new AchievementBuilder("General Mayhem V", 0).requirement("General Graardor", 75).build());
        achievements.add(new AchievementBuilder("Gift from Sliske", 0).requirement("Sliske after-quest tasks", 2).build());
        achievements.add(new AchievementBuilder("Globetrotter", 0).requirement("Globetrotter outfit pieces", 5).build());
        achievements.add(new AchievementBuilder("Glutton for Punishment", 0).requirement("Dreadfowl pouch", 1)
            .requirement("Thorny snail pouch", 1).requirement("Pack pig pouch", 1).requirement("Evil turnip pouch", 1)
            .requirement("War tortoise pouch", 1).requirement("Fruit bat pouch", 1).requirement("Granite lobster pouch", 1)
            .requirement("Bringing Home the Bacon", 1).requirement("Summer's End", 1).requirement("Summoning", 74).build());
        achievements.add(new AchievementBuilder("God Wars Dungeon Teleport", 0).requirement("Law rune", 2)
            .requirement("The Mighty Fall", 1).requirement("Fire rune", 2).requirement("Magic", 61).reward("Magic", 68).build());
        achievements.add(new AchievementBuilder("Goebie Relics", 0).requirement("Stone fragments", 5).build());
        achievements.add(new AchievementBuilder("Going Down with the Ship", 0.2).requirement("Fishing", 15).build());
        achievements.add(new AchievementBuilder("Going For A Punt", 0).requirement("Boater", 1).requirement("Woodcutting", 57)
            .reward("Woodcutting", 150).build());
        achievements.add(new AchievementBuilder("Gong Maintenance Expert", 0)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Charger", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
                Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")))).build());
        achievements.add(new AchievementBuilder("Good Enough for a Goblin", 0).requirement("Summer's End", 1)
            .encounter(new Encounter("Corporeal Beast", Collections.singletonList(new Restriction("Bronze spear", 1)))).build());
        achievements.add(new AchievementBuilder("Got a Vyre Reputation", 0).requirement("Maximum vyre reputation", 1).build());
        achievements.add(new AchievementBuilder("Graardone", 0).requirement("Strength", 70)
            .encounter(new Encounter("General Graardor", Collections.singletonList(new Restriction("Ticks", 25)))).build());
        achievements.add(new AchievementBuilder("Great Gielinor Run", 0.25).requirement("The Branches of Darkmeyer", 1)
            .requirement("Regicide", 1).build());
        achievements.add(new AchievementBuilder("Greg", 0).requirement("Faceless mask", 1).build());
        achievements.add(new AchievementBuilder("Gregore-Y I", 0).requirement("Gregorovic (hard)", 5).build());
        achievements.add(new AchievementBuilder("Gregore-Y II", 0).requirement("Gregorovic (hard)", 10).build());
        achievements.add(new AchievementBuilder("Gregore-Y III", 0).requirement("Gregorovic (hard)", 25).build());
        achievements.add(new AchievementBuilder("Gregore-Y IV", 0).requirement("Gregorovic (hard)", 50).build());
        achievements.add(new AchievementBuilder("Gregore-Y V", 0).requirement("Gregorovic (hard)", 75).build());
        achievements.add(new AchievementBuilder("Gregore-Y VI", 0).requirement("Gregorovic (hard)", 100).build());
        achievements.add(new AchievementBuilder("Gregorgeous I", 0).requirement("Gregorovic", 5).build());
        achievements.add(new AchievementBuilder("Gregorgeous II", 0).requirement("Gregorovic", 10).build());
        achievements.add(new AchievementBuilder("Gregorgeous III", 0).requirement("Gregorovic", 25).build());
        achievements.add(new AchievementBuilder("Gregorgeous IV", 0).requirement("Gregorovic", 50).build());
        achievements.add(new AchievementBuilder("Gregorgeous V", 0).requirement("Gregorovic", 75).build());
        achievements.add(new AchievementBuilder("Grondaban's legacy", 0).requirement("Dishonour among Thieves", 1).build());
        achievements.add(new AchievementBuilder("Guard is Dead", 0).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .encounter(new Encounter("New Varrock guard")).reward("Zemomark", 80).build());
        achievements.add(new AchievementBuilder("Gunning for Jewellery", 0).requirement("Dororan's jewellery", 3).build());
        achievements.add(new AchievementBuilder("Guthan Bobblehead", 0).requirement("Guthan the Bobbled", 1).build());
        achievements.add(new AchievementBuilder("Hail to the Queen", 0)
        .encounter(new Encounter(Arrays.asList(Arrays.asList("Kalphite guardian", "Kalphite guardian",
            "Kalphite Queen (Phase 1)"), Collections.singletonList("Kalphite Queen (Phase 2)")))).build());
        achievements.add(new AchievementBuilder("Hand Exchange", 0).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .reward("Zemomark", 20).build());
        achievements.add(new AchievementBuilder("Handicrafts", 0).requirement("Thread", 1).requirement("Leather", 1)
            .reward("Crafting", 14).reward("Leather gloves", 1).build());
        achievements.add(new AchievementBuilder("Hang on to Something", 0).build());
        achievements.add(new AchievementBuilder("Hard as Daemons", 0).requirement("Hard mode floors", 60).build());
        achievements.add(new AchievementBuilder("Hard as a Rock", 0).requirement("Vorago uniques", 11).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge I", 0).requirement("Har-Aken", 5).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge II", 0).requirement("Har-Aken", 10).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge III", 0).requirement("Har-Aken", 25).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge IV", 0).requirement("Har-Aken", 50).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge V", 0).requirement("Har-Aken", 75).build());
        achievements.add(new AchievementBuilder("Haul Comes to Templeton", 0.05).requirement("Dealing with Scabaras", 1).build());
        achievements.add(new AchievementBuilder("Heart to Heart", 0).requirement("Twin Furies uniques", 9).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket I", 0).requirement("Helwyr (hard)", 5).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket II", 0).requirement("Helwyr (hard)", 10).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket III", 0).requirement("Helwyr (hard)", 25).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket IV", 0).requirement("Helwyr (hard)", 50).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket V", 0).requirement("Helwyr (hard)", 75).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket VI", 0).requirement("Helwyr (hard)", 100).build());
        achievements.add(new AchievementBuilder("Herbi's Flax", 0).requirement("Shades of Mort'ton", 1).reward("Herblore", 335)
            .build());
        achievements.add(new AchievementBuilder("Herblore - Herbert", 0).requirement("Herbert", 1).build());
        achievements.add(new AchievementBuilder("Herblore 5", 0).requirement("Herblore", 5).build());
        achievements.add(new AchievementBuilder("Herblore 10", 0).requirement("Herblore", 10).build());
        achievements.add(new AchievementBuilder("Herblore 20", 0).requirement("Herblore", 20).build());
        achievements.add(new AchievementBuilder("Herblore 30", 0).requirement("Herblore", 30).build());
        achievements.add(new AchievementBuilder("Herblore 40", 0).requirement("Herblore", 40).build());
        achievements.add(new AchievementBuilder("Herblore 50", 0).requirement("Herblore", 50).build());
        achievements.add(new AchievementBuilder("Herblore 60", 0).requirement("Herblore", 60).build());
        achievements.add(new AchievementBuilder("Herblore 70", 0).requirement("Herblore", 70).build());
        achievements.add(new AchievementBuilder("Herblore 80", 0).requirement("Herblore", 80).build());
        achievements.add(new AchievementBuilder("Herblore 90", 0).requirement("Herblore", 90).build());
        achievements.add(new AchievementBuilder("Herblore 92", 0).requirement("Herblore", 92).build());
        achievements.add(new AchievementBuilder("Herblore 99", 0).requirement("Herblore", 99).build());
        achievements.add(new AchievementBuilder("Here Was a Scabaras Mask", 0.05).requirement("Mining", 80)
            .requirement("Diamond in the Rough", 1).reward("Mining", 20000).reward("Scabaras mask", 1).reward("Was", 1).build());
        achievements.add(new AchievementBuilder("Here We Rago Again I", 0).requirement("Vorago (hard)", 5).build());
        achievements.add(new AchievementBuilder("Here We Rago Again II", 0).requirement("Vorago (hard)", 10).build());
        achievements.add(new AchievementBuilder("Here We Rago Again III", 0).requirement("Vorago (hard)", 25).build());
        achievements.add(new AchievementBuilder("Here We Rago Again IV", 0).requirement("Vorago (hard)", 50).build());
        achievements.add(new AchievementBuilder("Here We Rago Again V", 0).requirement("Vorago (hard)", 75).build());
        achievements.add(new AchievementBuilder("Here We Rago Again VI", 0).requirement("Vorago (hard)", 100).build());
        achievements.add(new AchievementBuilder("Rewind", 0).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru")))).build());
        achievements.add(new AchievementBuilder("Prison Break", 0)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Charger", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
                Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")))).build());
        achievements.add(new AchievementBuilder("Make Friends and Influence People", 0)
            .requirement("Beastmaster Durzag", 1).encounter(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru")))).build());
        achievements.add(new AchievementBuilder("Hero of the Goebies", 0).requirement("All Together Now", 1)
            .requirement("Animal Cruelty", 1).requirement("Better Not Touch", 1).requirement("Cormes and Goes", 1)
            .requirement("Day at the Aquarium", 1).requirement("Day at the Pound", 1).requirement("Gong Maintenance Expert", 1)
            .requirement("Make Friends and Influence People", 1).requirement("Prison Break", 1).requirement("Rewind", 1).build());
        achievements.add(new AchievementBuilder("Hide and Seek", 0).requirement("Zombie cowhide", 1)
            .requirement("Dimension of Disaster: Coin of the Realm", 1).reward("Leather", 1).reward("Zemomark", 20).build());
        achievements.add(new AchievementBuilder("History of Bilrach", 0).requirement("Mysterious chronicle", 30).build());
        achievements.add(new AchievementBuilder("How Many Games?", 0).requirement("Gold Castle Wars ticket", 4150).build());
        achievements.add(new AchievementBuilder("How to Shame Your Dragon", 0).requirement("King Black Dragon uniques", 1).build());
        achievements.add(new AchievementBuilder("Hungry Hungry Reavers", 0).requirement("Frozen key", 1)
            .encounter(new Encounter("Nex: Angel of Death")).build());
        achievements.add(new AchievementBuilder("Hunter - Ace", 0).requirement("Ace", 1).build());
        achievements.add(new AchievementBuilder("Hunter 5", 0).requirement("Hunter", 5).build());
        achievements.add(new AchievementBuilder("Hunter 10", 0).requirement("Hunter", 10).build());
        achievements.add(new AchievementBuilder("Hunter 20", 0).requirement("Hunter", 20).build());
        achievements.add(new AchievementBuilder("Hunter 30", 0).requirement("Hunter", 30).build());
        achievements.add(new AchievementBuilder("Hunter 40", 0).requirement("Hunter", 40).build());
        achievements.add(new AchievementBuilder("Hunter 50", 0).requirement("Hunter", 50).build());
        achievements.add(new AchievementBuilder("Hunter 60", 0).requirement("Hunter", 60).build());
        achievements.add(new AchievementBuilder("Hunter 70", 0).requirement("Hunter", 70).build());
        achievements.add(new AchievementBuilder("Hunter 80", 0).requirement("Hunter", 80).build());
        achievements.add(new AchievementBuilder("Hunter 90", 0).requirement("Hunter", 90).build());
        achievements.add(new AchievementBuilder("Hunter 92", 0).requirement("Hunter", 92).build());
        achievements.add(new AchievementBuilder("Hunter 99", 0).requirement("Hunter", 99).build());
        achievements.add(new AchievementBuilder("I Can See For Miles and Miles", 0)
            .requirement("Beacon keepers with macaws", 12).build());
        achievements.add(new AchievementBuilder("I Dig This Transportation", 0).requirement("Digsite pendant unlock", 1).build());
        achievements.add(new AchievementBuilder("I Got This", 0).requirement("Slayer", 95).requirement("Ascension Keystone Primus", 1)
            .requirement("Ascension Keystone Secundus", 1).requirement("Ascension Keystone Tertius", 1)
            .requirement("Ascension Keystone Quartus", 1).requirement("Ascension Keystone Quintus", 1)
            .requirement("Ascension Keystone Sextus", 1).encounter(new Encounter(Arrays.asList(Collections.singletonList("Legio"),
                Collections.singletonList("Legio"), Collections.singletonList("Legio"), Collections.singletonList("Legio"),
                Collections.singletonList("Legio"), Collections.singletonList("Legio")))).build());
        achievements.add(new AchievementBuilder("I Presume These Rewards Are Mine, Death?", 0)
            .requirement("Missing, Presumed Death post-quest rewards", 4).build());
        achievements.add(new AchievementBuilder("Ice Ice Chimpy", 0).requirement("Chimp ice deliveries", 25).build());
        achievements.add(new AchievementBuilder("Icthlarin's Little Chest", 0).requirement("Icthlarin's Little Helper", 1)
            .reward("Coins", 50).build());
        achievements.add(new AchievementBuilder("Impressing Char", 0).requirement("The Firemaker's Curse", 1)
            .requirement("Firemaking", 91).reward("Firemaking", 7387).build());
        achievements.add(new AchievementBuilder("In the Spirit of Things", 0).requirement("Prayer", 80)
            .encounter(new Encounter("Gregorovic")).build());
        achievements.add(new AchievementBuilder("Zillier Way to Die VI", 0).requirement("Commander Zilyana (hard)", 100).build());
        achievements.add(new AchievementBuilder("Whack a Mole VI", 0).requirement("Giant Mole (hard)", 100).build());
        achievements.add(new AchievementBuilder("Vindictive VI", 0).requirement("Vindicta (hard)", 100).build());
        achievements.add(new AchievementBuilder("More Fast More Furious VI", 0).requirement("Twin Furies (CM)", 100).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 VI", 0).requirement("K'ril Tsutsaroth (hard)", 100).build());
        achievements.add(new AchievementBuilder("Insane Final Boss", 0).requirement("Final Boss", 1).requirement("Birdstrike VI", 1)
            .requirement("General Disaster VI", 1).requirement("Gregore-Y VI", 1).requirement("Hel in a Handbasket VI", 1)
            .requirement("Here We Rago Again VI", 1).requirement("Kill K'ril Vol 2 VI", 1).requirement("More Fast More Furious VI", 1)
            .requirement("Vindictive VI", 1).requirement("Whack a Mole VI", 1).requirement("Zillier Way to Die VI", 1)
            .requirement("Boss pets", 46).build());
        achievements.add(new AchievementBuilder("Invention - Malcolm", 0).requirement("Malcolm", 1).build());
        achievements.add(new AchievementBuilder("Invention 5", 0).requirement("Invention", 5).build());
        achievements.add(new AchievementBuilder("Invention 10", 0).requirement("Invention", 10).build());
        achievements.add(new AchievementBuilder("Invention 20", 0).requirement("Invention", 20).build());
        achievements.add(new AchievementBuilder("Invention 30", 0).requirement("Invention", 30).build());
        achievements.add(new AchievementBuilder("Invention 40", 0).requirement("Invention", 40).build());
        achievements.add(new AchievementBuilder("Invention 50", 0).requirement("Invention", 50).build());
        achievements.add(new AchievementBuilder("Invention 60", 0).requirement("Invention", 60).build());
        achievements.add(new AchievementBuilder("Invention 70", 0).requirement("Invention", 70).build());
        achievements.add(new AchievementBuilder("Invention 80", 0).requirement("Invention", 80).build());
        achievements.add(new AchievementBuilder("Invention 90", 0).requirement("Invention", 90).build());
        achievements.add(new AchievementBuilder("Invention 99", 0).requirement("Invention", 99).build());
        achievements.add(new AchievementBuilder("Invention 102", 0).requirement("Invention", 102).build());
        achievements.add(new AchievementBuilder("Invention 110", 0).requirement("Invention", 110).build());
        achievements.add(new AchievementBuilder("Invention 120", 0).requirement("Invention", 120).build());
        achievements.add(new AchievementBuilder("It's Not Called Surging Tombs", 0.05).requirement("The Jack of Spades", 1)
            .reward("Shifting Tombs", 1).build());
        achievements.add(new AchievementBuilder("Ivan is Flailing", 0).requirement("Vyre corpses burned", 500).build());
        achievements.add(new AchievementBuilder("Jack of All Blades", 0).requirement("Combat skilling pets", 9).build());
        achievements.add(new AchievementBuilder("Jack of All Trades", 0).requirement("Non-combat skilling pets", 18).build());
        achievements.add(new AchievementBuilder("Jack of Blades", 0).requirement("Combat skilling pets", 3).build());
        achievements.add(new AchievementBuilder("Jack of Trades", 0).requirement("Non-combat skilling pets", 5).build());
        achievements.add(new AchievementBuilder("Jack of the Circus", 0).requirement("Circus clothing", 26).build());
        achievements.add(new AchievementBuilder("K'ril Tinyroth", 0).requirement("Severed hoof", 1).build());
        achievements.add(new AchievementBuilder("K'ril Will Be Done", 0).requirement("Constitution", 70)
            .encounter(new Encounter("K'ril Tsutsaroth")).build());
        achievements.add(new AchievementBuilder("K'rilow", 0).requirement("Constitution", 70).requirement("Willow shieldbow", 1)
            .encounter(new Encounter("K'ril Tsutsaroth", Collections.singletonList(new Restriction("Willow shieldbow", 1)))).build());
        achievements.add(new AchievementBuilder("Kaiki's Tusks", 0).requirement("Kaigi's journal", 1)
            .requirement("Kaigi's journal pages", 4).build());
        achievements.add(new AchievementBuilder("Kal'gerion Commander", 0).requirement("Kal'gerion battle commendation", 5).build());
        achievements.add(new AchievementBuilder("Kal'gerion Notes", 0).requirement("Kal'gerion notes", 5).build());
        achievements.add(new AchievementBuilder("Kalphite Grublet (Flying)", 0).requirement("Kalphite egg", 1).build());
        achievements.add(new AchievementBuilder("Kalphite Grublet", 0).requirement("Kalphite egg", 1).build());
        achievements.add(new AchievementBuilder("Kalphite Grubling", 0).requirement("Kalphite claw", 1).build());
        achievements.add(new AchievementBuilder("Karamja", 0).build());
        achievements.add(new AchievementBuilder("Karil Bobblehead", 0).requirement("Karil the Bobbled", 1).build());
        achievements.add(new AchievementBuilder("Keeper of the Faith", 0).requirement("Commander Zilyana uniques", 17).build());
        achievements.add(new AchievementBuilder("Keeping Up with the Carnilleans", 0).requirement("Carnillean lamps", 7).build());
        achievements.add(new AchievementBuilder("Kill K'ril I", 0).requirement("K'ril Tsutsaroth", 5).build());
        achievements.add(new AchievementBuilder("Kill K'ril II", 0).requirement("K'ril Tsutsaroth", 10).build());
        achievements.add(new AchievementBuilder("Kill K'ril III", 0).requirement("K'ril Tsutsaroth", 25).build());
        achievements.add(new AchievementBuilder("Kill K'ril IV", 0).requirement("K'ril Tsutsaroth", 50).build());
        achievements.add(new AchievementBuilder("Kill K'ril V", 0).requirement("K'ril Tsutsaroth", 75).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 I", 0).requirement("K'ril Tsutsaroth (hard)", 5).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 II", 0).requirement("K'ril Tsutsaroth (hard)", 10).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 III", 0).requirement("K'ril Tsutsaroth (hard)", 25).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 IV", 0).requirement("K'ril Tsutsaroth (hard)", 50).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 V", 0).requirement("K'ril Tsutsaroth (hard)", 75).build());
        achievements.add(new AchievementBuilder("King Black Dragonling", 0).requirement("King black dragon scale", 1).build());
        achievements.add(new AchievementBuilder("Koschei's Cache", 0).requirement("Koschei gem colors", 1).build());
        achievements.add(new AchievementBuilder("Krar Jnr", 0).requirement("Krar Jnr (pet)", 1).build());
        achievements.add(new AchievementBuilder("Last of the Summer Swine", 0).requirement("Pig creation machine", 3).build());
        achievements.add(new AchievementBuilder("Learning from Mr. Mordaut", 0).requirement("One of a Kind", 1)
            .reward("Divination", 5000).build());
        achievements.add(new AchievementBuilder("Legio Primulus", 0).requirement("Corrupted Ascention signet I", 1).build());
        achievements.add(new AchievementBuilder("Legio Quartulus", 0).requirement("Corrupted Ascention signet IV", 1).build());
        achievements.add(new AchievementBuilder("Legio Quintulus", 0).requirement("Corrupted Ascention signet V", 1).build());
        achievements.add(new AchievementBuilder("Legio Secundulus", 0).requirement("Corrupted Ascention signet II", 1).build());
        achievements.add(new AchievementBuilder("Legio Sextulus", 0).requirement("Corrupted Ascention signet VI", 1).build());
        achievements.add(new AchievementBuilder("Legio Tertiolus", 0).requirement("Corrupted Ascention signet III", 1).build());
        achievements.add(new AchievementBuilder("Let us Give Ugthanks", 0).requirement("Ugthanatos journal", 1).build());
        achievements.add(new AchievementBuilder("Liberated", 0).requirement("Mazcab uniques", 19).build());
        achievements.add(new AchievementBuilder("Library of Nex", 0).requirement("Nex: Angel of Death", 1).build());
        achievements.add(new AchievementBuilder("Light as a Feather", 0).requirement("Kree'arra uniques", 18).build());
        achievements.add(new AchievementBuilder("Lighter Log", 0).requirement("Logs", 1).reward("Firemaking", 40).build());
        achievements.add(new AchievementBuilder("Like a Boss", 0).encounter(new Encounter(Arrays.asList(
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Brokeface")))).build());
        achievements.add(new AchievementBuilder("Lil' Tuzzy", 0).requirement("Lil' Tuzzy (pet)", 1).build());
        achievements.add(new AchievementBuilder("Lilwyr", 0).requirement("Twisted antler", 1).build());
        achievements.add(new AchievementBuilder("Little Leaguer", 0).reward("Agility", 4).reward("Ranged", 4).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch I", 0).requirement("TzTok-Jad", 5).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch II", 0).requirement("TzTok-Jad", 10).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch III", 0).requirement("TzTok-Jad", 25).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch IV", 0).requirement("TzTok-Jad", 50).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch V", 0).requirement("TzTok-Jad", 75).build());
        achievements.add(new AchievementBuilder("Load of Bakulla", 0.1).requirement("The Fremennik Trials", 1).build());
        achievements.add(new AchievementBuilder("Lock, Stock and Barrel", 0).requirement("Merchant district reputation", 300000)
            .build());
        achievements.add(new AchievementBuilder("Lodestone Network", 0).requirement("Lodestones", 25).build());
        achievements.add(new AchievementBuilder("Lodestone Network Free Area", 0).requirement("F2P Lodestones", 11).build());
        achievements.add(new AchievementBuilder("Lodestone Network Members Area", 0).requirement("P2P Lodestones", 14).build());
        achievements.add(new AchievementBuilder("Long Live the Queen", 0).requirement("Queen Black Dragon", 1).build());
        achievements.add(new AchievementBuilder("Loot Pinata I", 0).requirement("Queen Black Dragon", 5).build());
        achievements.add(new AchievementBuilder("Loot Pinata II", 0).requirement("Queen Black Dragon", 10).build());
        achievements.add(new AchievementBuilder("Loot Pinata III", 0).requirement("Queen Black Dragon", 25).build());
        achievements.add(new AchievementBuilder("Loot Pinata IV", 0).requirement("Queen Black Dragon", 50).build());
        achievements.add(new AchievementBuilder("Loot Pinata V", 0).requirement("Queen Black Dragon", 75).build());
        achievements.add(new AchievementBuilder("Looting the Demon Throne", 0).requirement("The Golem", 1).reward("Sapphire", 2)
            .reward("Emerald", 2).reward("Ruby", 2).build());
        achievements.add(new AchievementBuilder("Long Live the Kings!", 0).requirement("Dagannoth Kings uniques", 10).build());
        achievements.add(new AchievementBuilder("Loyal Subject", 0.35).requirement("Anti-dragon shield (mole)", 1)
            .reward("Anti-dragon shield", 1).build());
        achievements.add(new AchievementBuilder("Lumbridge", 0).build());
        achievements.add(new AchievementBuilder("Lumbridge Catacombs", 0).requirement("The Blood Pact", 1).build());
        achievements.add(new AchievementBuilder("Lumbridge Strikes Back", 0).requirement("Bronze full helm", 1)
            .requirement("Bronze platebody", 1).requirement("Bronze platelegs", 1).requirement("Bronze 2h sword", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor"), Collections.singletonList("Araxxi")),
                Arrays.asList(new Restriction("Bronze full helm", 1), new Restriction("Bronze platebody", 1),
                    new Restriction("Bronze platelegs", 1), new Restriction("Bronze 2h sword", 1)))).build());
        achievements.add(new AchievementBuilder("Lunar Isle", 0).requirement("Lunar Diplomacy", 1).build());
        achievements.add(new AchievementBuilder("Lurgon's Run", 0.05).requirement("Death to the Dorgeshuun", 1).build());
        achievements.add(new AchievementBuilder("Magic - Newton", 0).requirement("Newton", 1).build());
        achievements.add(new AchievementBuilder("Magic 5", 0).requirement("Magic", 5).build());
        achievements.add(new AchievementBuilder("Magic 10", 0).requirement("Magic", 10).build());
        achievements.add(new AchievementBuilder("Magic 20", 0).requirement("Magic", 20).build());
        achievements.add(new AchievementBuilder("Magic 30", 0).requirement("Magic", 30).build());
        achievements.add(new AchievementBuilder("Magic 40", 0).requirement("Magic", 40).build());
        achievements.add(new AchievementBuilder("Magic 50", 0).requirement("Magic", 50).build());
        achievements.add(new AchievementBuilder("Magic 60", 0).requirement("Magic", 60).build());
        achievements.add(new AchievementBuilder("Magic 70", 0).requirement("Magic", 70).build());
        achievements.add(new AchievementBuilder("Magic 80", 0).requirement("Magic", 80).build());
        achievements.add(new AchievementBuilder("Magic 90", 0).requirement("Magic", 90).build());
        achievements.add(new AchievementBuilder("Magic 92", 0).requirement("Magic", 92).build());
        achievements.add(new AchievementBuilder("Magic 99", 0).requirement("Magic", 99).build());
        achievements.add(new AchievementBuilder("Magister Smagister", 0.35).build());
        achievements.add(new AchievementBuilder("Make A Wish", 0).requirement("Fishing", 68).requirement("Coins", 1).build());
        achievements.add(new AchievementBuilder("Mallory", 0).requirement("Araxyte egg", 1).build());
        achievements.add(new AchievementBuilder("Many Shades of a Cure", 0).requirement("Shades of Mort'ton", 1)
            .requirement("Serum 208", 2).reward("Coins", 391).build());
        achievements.add(new AchievementBuilder("Maria, You Gotta See Her", 0).requirement("Broken Home challenge 1", 1)
            .requirement("Broken Home challenge 2", 1).requirement("Broken Home challenge 3", 1).build());
        achievements.add(new AchievementBuilder("Marmaros and Thok Letters", 0).requirement("M. and thok letters", 10).build());
        achievements.add(new AchievementBuilder("Master Angler", 0).requirement("Champion's tackle box", 1).build());
        achievements.add(new AchievementBuilder("Master Bogreman", 0).requirement("Chompy kills", 30).build());
        achievements.add(new AchievementBuilder("Master Otto", 0).requirement("Barbarian Training", 1).build());
        achievements.add(new AchievementBuilder("White Knight Rises", 0).requirement("White Knight rank points", 1300).build());
        achievements.add(new AchievementBuilder("Witch's Potion", 0.25).requirement("Cooked meat", 1).requirement("Eye of newt", 1)
            .requirement("Onion", 1).encounter(new Encounter("Rat")).reward("Magic", 325).build());
        achievements.add(new AchievementBuilder("You're Not My Real Mah", 0).requirement("Elder memories", 10).build());
        achievements.add(new AchievementBuilder("You Mistag This Brooch", 0).requirement("Mistag's brooch", 1)
            .reward("Mining helmet", 1).build());
        achievements.add(new AchievementBuilder("Work for Idol Hands", 0).requirement("Demon statuettes", 6).build());
        achievements.add(new AchievementBuilder("Uzer Master", 0).requirement("Missing My Mummy", 1).build());
        achievements.add(new AchievementBuilder("Unholy Crafting", 0).requirement("Observatory Quest", 1).build());
        achievements.add(new AchievementBuilder("Under Croc and Key", 0).requirement("Crocodile Tears", 1)
            .requirement("Constitution", 80).reward("Constitution", 20000).build());
        achievements.add(new AchievementBuilder("Ultimate Codex", 0).requirement("Codex Ultimatus", 1).build());
        achievements.add(new AchievementBuilder("Triple Trouble", 0).requirement("Tai Bwo Wannai Trio rewards", 3).build());
        achievements.add(new AchievementBuilder("Trials of the Heart", 0).requirement("Quest points", 300).build());
        achievements.add(new AchievementBuilder("To Ga'al or Not to Ga'al", 0).requirement("TzHaar-Ga'al-Kot", 1).build());
        achievements.add(new AchievementBuilder("Three's a Kiln", 0).requirement("TokHaar-Kal-Ket", 1)
            .requirement("TokHaar-Kal-Xil", 1).requirement("TokHaar-Kal-Mej", 1).build());
        achievements.add(new AchievementBuilder("The History of Slayer", 0).requirement("Souls captured", 110).build());
        achievements.add(new AchievementBuilder("That'll Teach Bill", 0).requirement("Cabin Fever", 1).reward("Coins", 10000)
            .build());
        achievements.add(new AchievementBuilder("Tasty Bobbles", 0).requirement("Gower Quest", 1).build());
        achievements.add(new AchievementBuilder("Supply and Demand", 0).requirement("Death Plateau supply runs", 5).build());
        achievements.add(new AchievementBuilder("Summary Spirits", 0).requirement("Wilderness spirit portals", 8).build());
        achievements.add(new AchievementBuilder("Stealing Sedridor's Stones", 0).requirement("Sedridor chest rewards", 99).build());
        achievements.add(new AchievementBuilder("Stalker Notes", 0).requirement("Stalker notes", 5).build());
        achievements.add(new AchievementBuilder("Squeal for Coins", 0).requirement("The Mighty Fall", 1).reward("Coins", 73105)
            .build());
        achievements.add(new AchievementBuilder("Some Old Dusty Journals", 0).requirement("Tarddian journals", 3).build());
        achievements.add(new AchievementBuilder("Soft Kitty, Purple Kitty", 0).requirement("Purple Cat", 1).build());
        achievements.add(new AchievementBuilder("Slime and Snails and God Wars Tales", 0)
            .requirement("Tales of the God Wars", 1).build());
        achievements.add(new AchievementBuilder("Skeletal Wishes", 0).requirement("Skeletal horror", 1).build());
        achievements.add(new AchievementBuilder("Shadow Hanging Over Me", 0).requirement("A Shadow over Ashdale", 1)
            .reward("Coins", 757).reward("Uncut sapphire", 4).reward("Uncut emerald", 1).build());
        achievements.add(new AchievementBuilder("Sentient Letters", 0).requirement("Empty Throne Room letters", 4).build());
        achievements.add(new AchievementBuilder("Scribblings of a Dragonkin", 0).requirement("Vicendithas' Scribblings", 1).build());
        achievements.add(new AchievementBuilder("Song from the Depths", 0.5).reward("Quest points", 1).reward("Constitution", 700)
            .build());
        achievements.add(new AchievementBuilder("Scribbling in the Depths", 0).requirement("Song from the Depths", 1)
            .requirement("Constitution", 80).build());
        achievements.add(new AchievementBuilder("Scabigail", 0).requirement("Scabaras page", 19).build());
        achievements.add(new AchievementBuilder("Rusty Reward", 0).requirement("Rocking Out", 1).reward("Coins", 20).build());
        achievements.add(new AchievementBuilder("Rogue Down", 0).requirement("Wilderness portal rogue trader freed", 1).build());
        achievements.add(new AchievementBuilder("Respect the Balance", 0).requirement("Respects paid", 6).build());
        achievements.add(new AchievementBuilder("Reliquary of Cithara", 0).requirement("A, B, Cithara", 1).reward("Prayer", 50000)
            .build());
        achievements.add(new AchievementBuilder("Relight my Fire", 0).requirement("Dragon Forge tasks", 4).build());
        achievements.add(new AchievementBuilder("Quiet but Deadly Lore", 0).requirement("Dragonkin journals", 4).build());
        achievements.add(new AchievementBuilder("Power of Three Spirits", 0).requirement("Plague's End", 1)
            .requirement("The Prisoner of Glouphrie", 1).requirement("Farming", 89).build());
        achievements.add(new AchievementBuilder("Potion for a Lady", 0).requirement("Super melee potion", 1)
            .lamp(Arrays.asList("Attack", "Strength"), 50000, 1).build());
        achievements.add(new AchievementBuilder("Post Fume", 0).requirement("Desert Slayer Dungeon bosses", 4).build());
        achievements.add(new AchievementBuilder("Penny for Your Life", 0).requirement("Dimension of Disaster post-quest rewards", 12)
            .build());
        achievements.add(new AchievementBuilder("Paint it Red", 0).requirement("Secrets of haemalchemy", 2).build());
        achievements.add(new AchievementBuilder("Oyster Mash", 0).requirement("Giant Oyster", 1).build());
        achievements.add(new AchievementBuilder("Otto the Ancient", 0).requirement("Ancient page", 26).build());
        achievements.add(new AchievementBuilder("Ornate Crockery", 0).requirement("Ornate bowl", 1).build());
        achievements.add(new AchievementBuilder("One Man's Junk...Is Mine", 0).requirement("Movario's base looting tasks", 5)
            .build());
        achievements.add(new AchievementBuilder("One Final Ride", 0).requirement("Last riders", 1).build());
        achievements.add(new AchievementBuilder("On a Mission From...The Gods", 0).requirement("God Emissaries tasks", 15).build());
        achievements.add(new AchievementBuilder("Ocellus Virius Notus", 0).requirement("Order journal page", 22).build());
        achievements.add(new AchievementBuilder("Nomad's Genesis", 0).requirement("Tales of Nomad", 1).build());
        achievements.add(new AchievementBuilder("Naturally Muspah", 0).requirement("The Tale of the Muspah", 1)
            .lamp(Player.ALL_SKILLS, 200, 10).build());
        achievements.add(new AchievementBuilder("Nano To Kipple, Come In Kipple", 0).requirement("Nano Kipple", 1).build());
        achievements.add(new AchievementBuilder("Mysteries of the TokHaar", 0).requirement("One of a Kind statues", 5).build());
        achievements.add(new AchievementBuilder("My Adze is Bigger than Yours", 0).requirement("Inferno adze", 1).build());
        achievements.add(new AchievementBuilder("Mixing in Ancient Circles", 0).requirement("Barbarian Firemaking", 1)
            .requirement("Bittercap mushroom", 5).build());
        achievements.add(new AchievementBuilder("Miscellaneous Notes", 0).requirement("Miscellaneous journals", 15).build());
        achievements.add(new AchievementBuilder("Milky Teeth", 0).requirement("Tooth creatrue", 1).build());
        achievements.add(new AchievementBuilder("Met Het Yet?", 0).requirement("Our Man in the North", 1).requirement("Strength", 80)
            .reward("Strength", 20000).build());
        achievements.add(new AchievementBuilder("Memories of a Mahjarrat", 0).requirement("Mahjarrat Memories", 1).build());
        achievements.add(new AchievementBuilder("Measure of Old", 0).requirement("Elder chronicle", 4).build());
        achievements.add(new AchievementBuilder("Roake Kal", 0).requirement("Sunken temple murals", 4).build());
        achievements.add(new AchievementBuilder("Lovingly Crafted", 0).requirement("Horror journals", 5).build());
        achievements.add(new AchievementBuilder("About 'Kin Time", 0).requirement("Rebuilding Edgeville", 1).build());
        achievements.add(new AchievementBuilder("Master Quest Cape", 0).requirement("Abyssal Reach", 1)
            .requirement("Advanced Sweeping", 1).requirement("Aereck's Old Bones", 1).requirement("Ali The Trader", 1)
            .requirement("All Rise", 1).requirement("Angs off my Ring", 1).requirement("Annihilator", 1).requirement("Any Odd Chicken", 1)
            .requirement("Ape A'hollow", 1).requirement("Arc III - Spiritual Enlightenment", 1)
            .requirement("Arc II - Head of the Family", 1).requirement("Arc IV - Jed Hunter", 1).requirement("Arc IX - Damage Control", 1)
            .requirement("Arc I - Flag Fall", 1).requirement("Arc VIII - Ghosts from the Past", 1)
            .requirement("Arc VII - Tuai Leit's Own", 1).requirement("Arc VI - Harbinger of Doom", 1)
            .requirement("Arc V - Eye for an Eye", 1).requirement("Arc X - Final Destination", 1).requirement("Are You Needing Access?", 1)
            .requirement("Arise from the Ash", 1).requirement("Around the World in Six Ways", 1).requirement("As Taxed as a Yak", 1)
            .requirement("As Clear as a Crystal Seed", 1).requirement("Azacorax's Rewards", 1).requirement("Azdaran Birthright", 1)
            .requirement("Bandos's Memories", 1).requirement("Bane Tuner", 1).requirement("Banking History", 1)
            .requirement("Behemoth Notes", 1).requirement("Blinded by Ramarno's Teaching", 1).requirement("Blood Stained Treasure", 1)
            .requirement("Bridge over Fremmy Waters", 1).requirement("Brothers Gower", 1).requirement("Brutal Stuffies", 1)
            .requirement("Buy and Sell Some XP", 1).requirement("Buying Up Ancient Artefacts", 1).requirement("Caving Into the Gains", 1)
            .requirement("Cecilia, I'm Begging You, Please...", 1).requirement("Challenge Maria", 1).requirement("Challenging Chat", 1)
            .requirement("Chilling with Arrav", 1).requirement("Chippy Transport", 1).requirement("Chivalry is Fed", 1)
            .requirement("Chivalry is Threads", 1).requirement("Chivalry is Dead", 1).requirement("Circus of Fire", 1)
            .requirement("Claiming Azzanadra's Heart", 1).requirement("Claus is Risng", 1).requirement("Clue's In The Monkey Drool", 1)
            .requirement("Complete History of Droalak", 1).requirement("Complete Trekky", 1).requirement("Cook's Delight", 1)
            .requirement("Count All Light Fingers", 1).requirement("Cower Behind the Chosen Commander", 1)
            .requirement("Cran Door's Secret", 1).requirement("Daemonology of Celerity", 1).requirement("Daero Take This Experience?", 1)
            .requirement("Deadlier Catch", 1).requirement("Death to the Mahjarrat", 1).requirement("Deep and Bloody Experience", 1)
            .requirement("Diaries of the Clans", 1).requirement("Diary of Oreb", 1).requirement("Diary of the Gods", 1)
            .requirement("Dishonourable Gains", 1).requirement("Dishonourable Loot", 1).requirement("Distorted Div", 1)
            .requirement("Do No Elite", 1).requirement("Do a Minion, Take Notes", 1).requirement("Don't Fear the Ripper", 1)
            .requirement("Dragonkin Logs", 1).requirement("Dusting Murial", 1).requirement("Eastern Adventurer", 1)
            .requirement("Eeeeagle!", 1).requirement("Enough of the Crazy Walking", 1).requirement("Epi Logueque Experience", 1)
            .requirement("Experience the Fate of the Gods", 1).requirement("Explore for Nestor", 1).requirement("Family Spirit Tree", 1)
            .requirement("Fires are Mostly Harmless", 1).requirement("For the Love of Mabel", 1).requirement("Forcae's Mettle", 1)
            .requirement("Fred's Shearings", 1).requirement("Gift from Sliske", 1).requirement("Goebie Relics", 1)
            .requirement("Got a Vyre Reputation", 1).requirement("Grondaban's legacy", 1).requirement("Gunning for Jewellery", 1)
            .requirement("Haul Comes to Templeton", 1).requirement("Herbi's Flax", 1).requirement("Here Was a Scabaras Mask", 1)
            .requirement("History of Bilrach", 1).requirement("I'm Forever Washing Shadows", 1)
            .requirement("I Can See For Miles and Miles", 1).requirement("I Dig This Transportation", 1)
            .requirement("I Presume These Rewards Are Mine, Death?", 1).requirement("Ice Ice Chimpy", 1)
            .requirement("Icthlarin's Little Chest", 1).requirement("Impressing Char", 1).requirement("Ivan is Flailing", 1)
            .requirement("Kaiki's Tusks", 1).requirement("Kal'gerion Notes", 1).requirement("Keeping Up with the Carnilleans", 1)
            .requirement("Koschei's Cache", 1).requirement("Kudos to You", 1).requirement("Last of the Summer Swine", 1)
            .requirement("Learning from Mr. Mordaut", 1).requirement("Let us Give Ugthanks", 1).requirement("Library of Nex", 1)
            .requirement("Load of Bakulla", 1).requirement("Looting the Demon Throne", 1).requirement("Lurgon's Run", 1)
            .requirement("Make Them Bleed", 1).requirement("Many Shades of a Cure", 1).requirement("Marmaros and Thok Letters", 1)
            .requirement("Master Bogreman", 1).requirement("Master Quester", 1).requirement("Measure of Old", 1)
            .requirement("Memories of Guthix", 1).requirement("Memories of a Mahjarrat", 1).requirement("Met Het Yet?", 1)
            .requirement("Milky Teeth", 1).requirement("Miscellaneous Notes", 1).requirement("Mixing in Ancient Circles", 1)
            .requirement("My Adze is Bigger than Yours", 1).requirement("Myreque in Memoriam", 1).requirement("Mysteries of the TokHaar", 1)
            .requirement("Nano To Kipple, Come In Kipple", 1).requirement("Naturally Muspah", 1).requirement("Nomad's Genesis", 1)
            .requirement("Ocellus Virius Notus", 1).requirement("On a Mission From... The Gods", 1).requirement("One Final Ride", 1)
            .requirement("One Foot in the Grave", 1).requirement("One Man's Junk...Is Mine", 1).requirement("Ornate Crockery", 1)
            .requirement("Otto the Ancient", 1).requirement("Out into the Ourania", 1).requirement("Oyster Mash", 1)
            .requirement("Paint it Red", 1).requirement("Penny for Your Life", 1).requirement("Post Fume", 1)
            .requirement("Potion for a Lady", 1).requirement("Power of Three Spirits", 1).requirement("Quiet but Deadly Lore", 1)
            .requirement("Relight my Fire", 1).requirement("Reliquary of Cithara", 1).requirement("Respect the Balance", 1)
            .requirement("Roake Kal", 1).requirement("Rogue Down", 1).requirement("Rusty Reward", 1).requirement("Scabigail", 1)
            .requirement("Scribbling in the Depths", 1).requirement("Scribblings of a Dragonkin", 1).requirement("Sentient Letters", 1)
            .requirement("Seren Memories", 1).requirement("Shadow Hanging Over Me", 1).requirement("Sheep Shearer", 1)
            .requirement("Sing for the Lady", 1).requirement("Skeletal Wishes", 1).requirement("Slime and Snails and God Wars Tales", 1)
            .requirement("Soft Kitty, Purple Kitty", 1).requirement("Some Old Dusty Journals", 1).requirement("Squeal for Coins", 1)
            .requirement("Stalker Notes", 1).requirement("Stay Safe", 1).requirement("Stay Secure", 1)
            .requirement("Stealing Sedridor's Stones", 1).requirement("Summary Spirits", 1).requirement("Supply and Demand", 1)
            .requirement("Tasty Bobbles", 1).requirement("Tell Tale Tarn", 1).requirement("That'll Teach Bill", 1)
            .requirement("The History of Slayer", 1).requirement("Three's A Kiln", 1).requirement("To Ga'al or Not to Ga'al", 1)
            .requirement("Trials of the Heart", 1).requirement("Triple Trouble", 1).requirement("Troublesome Crystal", 1)
            .requirement("Ultimate Codex", 1).requirement("Uncorrupted Ore", 1).requirement("Under Croc and Key", 1)
            .requirement("Unholy Crafting", 1).requirement("Uzer Master", 1).requirement("What's Mine Is Also Doric's", 1)
            .requirement("White Knight Rises", 1).requirement("Witch's Potion", 1).requirement("Work for Idol Hands", 1)
            .requirement("You're Not My Real Mah", 1).requirement("You Be Dead", 1).requirement("You Mistag This Brooch", 1)
            .requirement("Zarosian Memories", 1).requirement("Lovingly Crafted", 1).requirement("About 'Kin Time", 1).build());
        achievements.add(new AchievementBuilder("Master of All", 0).requirement("Skilling pets", 27).build());
        achievements.add(new AchievementBuilder("Barbarian Assault attacker rank 2", 0).requirement("Honour Points", 200).build());
        achievements.add(new AchievementBuilder("Barbarian Assault attacker rank 3", 0)
            .requirement("Barbarian Assault attacker rank 2", 1).requirement("Honour Points", 300).build());
        achievements.add(new AchievementBuilder("Barbarian Assault attacker rank 4", 0)
            .requirement("Barbarian Assault attacker rank 3", 1).requirement("Honour Points", 400).build());
        achievements.add(new AchievementBuilder("Barbarian Assault attacker rank 5", 0)
            .requirement("Barbarian Assault attacker rank 4", 1).requirement("Honour Points", 400).build());
        achievements.add(new AchievementBuilder("Barbarian Assault defender rank 2", 0).requirement("Honour Points", 200).build());
        achievements.add(new AchievementBuilder("Barbarian Assault defender rank 3", 0)
            .requirement("Barbarian Assault defender rank 2", 1).requirement("Honour Points", 300).build());
        achievements.add(new AchievementBuilder("Barbarian Assault defender rank 4", 0)
            .requirement("Barbarian Assault defender rank 3", 1).requirement("Honour Points", 400).build());
        achievements.add(new AchievementBuilder("Barbarian Assault defender rank 5", 0)
            .requirement("Barbarian Assault defender rank 4", 1).requirement("Honour Points", 400).build());
        achievements.add(new AchievementBuilder("Barbarian Assault collector rank 2", 0).requirement("Honour Points", 200).build());
        achievements.add(new AchievementBuilder("Barbarian Assault collector rank 3", 0)
            .requirement("Barbarian Assault collector rank 2", 1).requirement("Honour Points", 300).build());
        achievements.add(new AchievementBuilder("Barbarian Assault collector rank 4", 0)
            .requirement("Barbarian Assault collector rank 3", 1).requirement("Honour Points", 400).build());
        achievements.add(new AchievementBuilder("Barbarian Assault collector rank 5", 0)
            .requirement("Barbarian Assault collector rank 4", 1).requirement("Honour Points", 400).build());
        achievements.add(new AchievementBuilder("Barbarian Assault healer rank 2", 0).requirement("Honour Points", 200).build());
        achievements.add(new AchievementBuilder("Barbarian Assault healer rank 3", 0)
            .requirement("Barbarian Assault healer rank 2", 1).requirement("Honour Points", 300).build());
        achievements.add(new AchievementBuilder("Barbarian Assault healer rank 4", 0)
            .requirement("Barbarian Assault healer rank 3", 1).requirement("Honour Points", 400).build());
        achievements.add(new AchievementBuilder("Barbarian Assault healer rank 5", 0)
            .requirement("Barbarian Assault healer rank 4", 1).requirement("Honour Points", 400).build());
        achievements.add(new AchievementBuilder("Master of Assault", 0).requirement("Barbarian Assault attacker rank 5", 1)
            .requirement("Barbarian Assault collector rank 5", 1).requirement("Barbarian Assault defender rank 5", 1)
            .requirement("Barbarian Assault healer rank 5", 1).build());
        achievements.add(new AchievementBuilder("Master of Beatings I", 0).requirement("Beastmaster Durzag", 5).build());
        achievements.add(new AchievementBuilder("Master of Beatings II", 0).requirement("Beastmaster Durzag", 10).build());
        achievements.add(new AchievementBuilder("Master of Beatings III", 0).requirement("Beastmaster Durzag", 25).build());
        achievements.add(new AchievementBuilder("Master of Beatings IV", 0).requirement("Beastmaster Durzag", 50).build());
        achievements.add(new AchievementBuilder("Master of Beatings V", 0).requirement("Beastmaster Durzag", 75).build());
        achievements.add(new AchievementBuilder("Matricide", 0).requirement("Frozen key", 4).requirement("Blood nihil pouch", 1)
            .requirement("Shadow nihil pouch", 1).requirement("Ice nihil pouch", 1).requirement("Smoke nihil pouch", 1)
            .encounter(new Encounter("Nex", Collections.singletonList(new Restriction("Blood nihil", 1))))
            .encounter(new Encounter("Nex", Collections.singletonList(new Restriction("Shadow nihil", 1))))
            .encounter(new Encounter("Nex", Collections.singletonList(new Restriction("Ice nihil", 1))))
            .encounter(new Encounter("Nex", Collections.singletonList(new Restriction("Smoke nihil", 1)))).build());
        achievements.add(new AchievementBuilder("Mazcab Teleport", 0).requirement("Teci", 2000).build());
        achievements.add(new AchievementBuilder("Mega Ducklings", 0).requirement("Mega ducklings", 1).build());
        achievements.add(new AchievementBuilder("Memorialised More Than Once", 0).requirement("Memorial to Guthix", 3).build());
        achievements.add(new AchievementBuilder("Menaphos", 0).requirement("The Jack of Spades", 1).build());
        achievements.add(new AchievementBuilder("Micro Brew", 0).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .requirement("Herblore", 65).requirement("Zemomark", 100).reward("Zemomark", 30).build());
        achievements.add(new AchievementBuilder("Milk of Chocolate, Snape of Grass", 0).requirement("Cooking", 20)
            .requirement("Bucket of water", 1).requirement("Chocolate dust", 1).requirement("Bucket of milk", 1)
            .requirement("Snape grass", 1).reward("Cooking", 53).build());
        achievements.add(new AchievementBuilder("Mining - Rocky", 0).requirement("Rocky", 1).build());
        achievements.add(new AchievementBuilder("Mining 5", 0).requirement("Mining", 5).build());
        achievements.add(new AchievementBuilder("Mining 10", 0).requirement("Mining", 10).build());
        achievements.add(new AchievementBuilder("Mining 20", 0).requirement("Mining", 20).build());
        achievements.add(new AchievementBuilder("Mining 30", 0).requirement("Mining", 30).build());
        achievements.add(new AchievementBuilder("Mining 40", 0).requirement("Mining", 40).build());
        achievements.add(new AchievementBuilder("Mining 50", 0).requirement("Mining", 50).build());
        achievements.add(new AchievementBuilder("Mining 60", 0).requirement("Mining", 60).build());
        achievements.add(new AchievementBuilder("Mining 70", 0).requirement("Mining", 70).build());
        achievements.add(new AchievementBuilder("Mining 80", 0).requirement("Mining", 80).build());
        achievements.add(new AchievementBuilder("Mining 90", 0).requirement("Mining", 90).build());
        achievements.add(new AchievementBuilder("Mining 92", 0).requirement("Mining", 92).build());
        achievements.add(new AchievementBuilder("Mining 99", 0).requirement("Mining", 99).build());
        achievements.add(new AchievementBuilder("Minister", 0).requirement("Soul fragment", 1).build());
        achievements.add(new AchievementBuilder("Mobilise This", 0).requirement("Mobilising Armies rank", 401).build());
        achievements.add(new AchievementBuilder("Mole Removal I", 0).requirement("Giant Mole", 5).build());
        achievements.add(new AchievementBuilder("Mole Removal II", 0).requirement("Giant Mole", 10).build());
        achievements.add(new AchievementBuilder("Mole Removal III", 0).requirement("Giant Mole", 25).build());
        achievements.add(new AchievementBuilder("Mole Removal IV", 0).requirement("Giant Mole", 50).build());
        achievements.add(new AchievementBuilder("Mole Removal V", 0).requirement("Giant Mole", 75).build());
        achievements.add(new AchievementBuilder("Molly", 0).requirement("Rotten fang", 1).build());
        achievements.add(new AchievementBuilder("Moo-er of All Bombs", 0).requirement("Dimension of Disaster: The Curse of Arrav", 1)
            .build());
        achievements.add(new AchievementBuilder("More Fast More Furious I", 0).requirement("Twin Furies (CM)", 5).build());
        achievements.add(new AchievementBuilder("More Fast More Furious II", 0).requirement("Twin Furies (CM)", 10).build());
        achievements.add(new AchievementBuilder("More Fast More Furious III", 0).requirement("Twin Furies (CM)", 25).build());
        achievements.add(new AchievementBuilder("More Fast More Furious IV", 0).requirement("Twin Furies (CM)", 50).build());
        achievements.add(new AchievementBuilder("More Fast More Furious V", 0).requirement("Twin Furies (CM)", 75).build());
        achievements.add(new AchievementBuilder("Mummy Returns", 0).requirement("Cat's Bane", 1).build());
        achievements.add(new AchievementBuilder("My precious!", 0).requirement("Gregg 'groggy' herring's ring", 1).build());
        achievements.add(new AchievementBuilder("Naturist", 0).encounter(new Encounter("Chaos Elemental")).build());
        achievements.add(new AchievementBuilder("Never Eat Silk Worms", 0).encounter(new Encounter("Kalphite King")).build());
        achievements.add(new AchievementBuilder("Trade Parade", 0).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .build());
        achievements.add(new AchievementBuilder("Ready, Deady, Cook", 0).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .requirement("New Varrock raw undead meat", 1).reward("Zemomark", 20).build());
        achievements.add(new AchievementBuilder("Pick One", 0).requirement("New Varrock chests", 1).reward("Zemomark", 20).build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Easy", 0).requirement("Hand Exchange", 1)
            .requirement("Trade Parade", 1).requirement("Hide and Seek", 1).requirement("Ready, Deady, Cook", 1).requirement("Pick One", 1)
            .build());
        achievements.add(new AchievementBuilder("Top Pick", 0).requirement("Dimension of Disaster: The Curse of Arrav", 1)
            .requirement("Thieving", 90).reward("Zemomark", 80).build());
        achievements.add(new AchievementBuilder("Steel, Stud, or Silk Salute", 0).requirement("New Varrock spider silk hood", 1)
            .requirement("New Varrock spider silk robe top", 1).requirement("New Varrock spider silk robe bottoms", 1).build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Elite", 1).requirement("Dark Imperator-ment", 1)
            .requirement("Guard is Dead", 1).requirement("Steel, Stud, or Silk Salute", 1).requirement("Moo-er of All Bombs", 1)
            .requirement("Top Pick", 1).build());
        achievements.add(new AchievementBuilder("South AND West Side Story", 0).requirement("Dimension of Disaster", 1)
            .reward("Zemomark", 60).build());
        achievements.add(new AchievementBuilder("Pick All", 0).requirement("New Varrock chests", 49).reward("Zemomark", 60).build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Hard", 0).requirement("Bank-Z", 1)
            .requirement("Micro Brew", 1).requirement("Pick All", 1).requirement("South AND West Side Story", 1)
            .requirement("Mummy Returns", 1).build());
        achievements.add(new AchievementBuilder("Tier Gear", 0).requirement("NV imphider", 1).requirement("Crafting", 10)
            .reward("NV imphide gloves", 1).reward("Zemomark", 40).build());
        achievements.add(new AchievementBuilder("They Had a Gudrun", 0).requirement("NV Cadava potion", 1)
            .requirement("NV Vial of orange mist", 1).reward("Zemomark", 40).build());
        achievements.add(new AchievementBuilder("Scrying Game", 0).requirement("Dimension of Disaster: Defender of Varrock", 1)
            .requirement("Zemomark", 60).build());
        achievements.add(new AchievementBuilder("Pick Half", 0).requirement("New Varrock chests", 25).reward("Zemomark", 40).build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Medium", 0).requirement("Cat's Bane", 1)
            .requirement("They Had a Gudrun", 1).requirement("Pick Half", 1).requirement("Scrying Game", 1).requirement("Tier Gear", 1)
            .build());
        achievements.add(new AchievementBuilder("Nex Pls I", 0).requirement("Nex: Angel of Death", 5).build());
        achievements.add(new AchievementBuilder("Nex Pls II", 0).requirement("Nex: Angel of Death", 10).build());
        achievements.add(new AchievementBuilder("Nex Pls III", 0).requirement("Nex: Angel of Death", 25).build());
        achievements.add(new AchievementBuilder("Nex Pls IV", 0).requirement("Nex: Angel of Death", 50).build());
        achievements.add(new AchievementBuilder("Nex Pls V", 0).requirement("Nex: Angel of Death", 75).build());
        achievements.add(new AchievementBuilder("Next to No Power", 0).requirement("Frozen key", 1).encounter(new Encounter("Nex",
            Collections.singletonList(new Restriction("Prayer", 0)))).build());
        achievements.add(new AchievementBuilder("Nexterminator", 0).requirement("Blood-soaked feather", 1).build());
        achievements.add(new AchievementBuilder("Nomad's Mirage", 0).requirement("Memory of Nomad", 1).build());
        achievements.add(new AchievementBuilder("Nylessa", 0).requirement("Nymora's braid", 1).build());
        achievements.add(new AchievementBuilder("On a Rune High", 0).requirement("Large rune casket", 1).build());
        achievements.add(new AchievementBuilder("On the Run", 0).build());
        achievements.add(new AchievementBuilder("Once the hunter, now the hunted", 0).requirement("Helwyr uniques", 8).build());
        achievements.add(new AchievementBuilder("Oo'glog", 0).build());
        achievements.add(new AchievementBuilder("Open Bar", 0).requirement("Asgarnian ale", 0).requirement("Asgarnian ale (m)", 0)
            .requirement("Asgoldian ale", 0).requirement("Axeman's folly", 0).requirement("Axeman's folly (m)", 0).requirement("Beer", 0)
            .requirement("Bandit's brew", 0).requirement("Beer (tankard)", 0).requirement("Chef's delight", 0).requirement("Cider", 0)
            .requirement("Mature cider", 0).requirement("Dragon bitter", 0).requirement("Dragon bitter (m)", 0)
            .requirement("Dwarven stout", 0).requirement("Dwarven stout (m)", 0).requirement("Greenman's ale", 0).requirement("Grog", 0)
            .requirement("Moonlight mead", 0).requirement("Moonlight mead (m)", 0).requirement("Pigswill", 0)
            .requirement("Mature pigswill", 0).requirement("Ranger's aid", 0).requirement("Ranger's aid (m)", 0)
            .requirement("Slayer's respite", 0).requirement("Slayer's respite (m)", 0).requirement("Squeck juice", 0)
            .requirement("Wizard's mind bomb", 0).requirement("Mature wmb", 0).build());
        achievements.add(new AchievementBuilder("Order of Slayers", 8).requirement("While Guthix Sleeps", 1)
            .requirement("Smoking Kills", 1).requirement("Plague's End", 1).requirement("Barbarian Training", 1).requirement("Slayer", 85)
            .requirement("Combat", 120).build());
        achievements.add(new AchievementBuilder("Out of Body Experience", 0).requirement("Corporeal Beast uniques", 7).build());
        achievements.add(new AchievementBuilder("Party Anima", 0).requirement("Telos uniques", 8).build());
        achievements.add(new AchievementBuilder("Penance to the King", 0).requirement("Penance King", 1).build());
        achievements.add(new AchievementBuilder("Perky Like a Prawn", 0).requirement("Prawn perks", 15).build());
        achievements.add(new AchievementBuilder("Phite For Your Right I", 0).requirement("City quest", 1).build());
        achievements.add(new AchievementBuilder("Phite For Your Right II", 0).requirement("City quest", 10).build());
        achievements.add(new AchievementBuilder("Phite For Your Right III", 0).requirement("City quest", 50).build());
        achievements.add(new AchievementBuilder("Phite For Your Right IV", 0).requirement("City quest", 100).build());
        achievements.add(new AchievementBuilder("Phite For Your Right V", 0).requirement("City quest", 200).build());
        achievements.add(new AchievementBuilder("Port Sarim", 0).build());
        achievements.add(new AchievementBuilder("Prayer - Ghostly", 0).requirement("Ghostly", 1).build());
        achievements.add(new AchievementBuilder("Prayer 5", 0).requirement("Prayer", 5).build());
        achievements.add(new AchievementBuilder("Prayer 10", 0).requirement("Prayer", 10).build());
        achievements.add(new AchievementBuilder("Prayer 20", 0).requirement("Prayer", 20).build());
        achievements.add(new AchievementBuilder("Prayer 30", 0).requirement("Prayer", 30).build());
        achievements.add(new AchievementBuilder("Prayer 40", 0).requirement("Prayer", 40).build());
        achievements.add(new AchievementBuilder("Prayer 50", 0).requirement("Prayer", 50).build());
        achievements.add(new AchievementBuilder("Prayer 60", 0).requirement("Prayer", 60).build());
        achievements.add(new AchievementBuilder("Prayer 70", 0).requirement("Prayer", 70).build());
        achievements.add(new AchievementBuilder("Prayer 80", 0).requirement("Prayer", 80).build());
        achievements.add(new AchievementBuilder("Prayer 90", 0).requirement("Prayer", 90).build());
        achievements.add(new AchievementBuilder("Prayer 92", 0).requirement("Prayer", 92).build());
        achievements.add(new AchievementBuilder("Prayer 99", 0).requirement("Prayer", 99).build());
        achievements.add(new AchievementBuilder("Prifddinas", 0).requirement("Plague's End", 1).build());
        achievements.add(new AchievementBuilder("Prime Hatchling", 0).requirement("Dagannoth egg", 1).build());
        achievements.add(new AchievementBuilder("Prison Break (feat)", 0).requirement("Nex uniques", 21).build());
        achievements.add(new AchievementBuilder("Queen Black Dragonling", 0).requirement("Queen black dragon scale", 1)
            .requirement("Summoning", 99).build());
        achievements.add(new AchievementBuilder("Ranged - Sparky", 0).requirement("Sparky", 1).build());
        achievements.add(new AchievementBuilder("Ranged 5", 0).requirement("Ranged", 5).build());
        achievements.add(new AchievementBuilder("Ranged 10", 0).requirement("Ranged", 10).build());
        achievements.add(new AchievementBuilder("Ranged 20", 0).requirement("Ranged", 20).build());
        achievements.add(new AchievementBuilder("Ranged 30", 0).requirement("Ranged", 30).build());
        achievements.add(new AchievementBuilder("Ranged 40", 0).requirement("Ranged", 40).build());
        achievements.add(new AchievementBuilder("Ranged 50", 0).requirement("Ranged", 50).build());
        achievements.add(new AchievementBuilder("Ranged 60", 0).requirement("Ranged", 60).build());
        achievements.add(new AchievementBuilder("Ranged 70", 0).requirement("Ranged", 70).build());
        achievements.add(new AchievementBuilder("Ranged 80", 0).requirement("Ranged", 80).build());
        achievements.add(new AchievementBuilder("Ranged 90", 0).requirement("Ranged", 90).build());
        achievements.add(new AchievementBuilder("Ranged 92", 0).requirement("Ranged", 92).build());
        achievements.add(new AchievementBuilder("Ranged 99", 0).requirement("Ranged", 99).build());
        achievements.add(new AchievementBuilder("Rank: Master Finix", 0).requirement("Esteem rank", 10).build());
        achievements.add(new AchievementBuilder("Rawrvek", 0).requirement("Glimmering scale", 1).build());
        achievements.add(new AchievementBuilder("Reeves", 0).requirement("Blood tentacle", 1).build());
        achievements.add(new AchievementBuilder("Revenge is Sweet", 0).requirement("Vindicta uniques", 8).build());
        achievements.add(new AchievementBuilder("Rex Hatchling", 0).requirement("Shrivelled dragon claw", 1).build());
        achievements.add(new AchievementBuilder("Rock & Roll", 0).requirement("Menaphos gemstones", 16).build());
        achievements.add(new AchievementBuilder("Ruler of the Sea", 0).requirement("Deep Sea Fishing encounters", 3).build());
        achievements.add(new AchievementBuilder("Runecrafting - Rue", 0).requirement("Rue", 1).build());
        achievements.add(new AchievementBuilder("Runecrafting 5", 0).requirement("Runecrafting", 5).build());
        achievements.add(new AchievementBuilder("Runecrafting 10", 0).requirement("Runecrafting", 10).build());
        achievements.add(new AchievementBuilder("Runecrafting 20", 0).requirement("Runecrafting", 20).build());
        achievements.add(new AchievementBuilder("Runecrafting 30", 0).requirement("Runecrafting", 30).build());
        achievements.add(new AchievementBuilder("Runecrafting 40", 0).requirement("Runecrafting", 40).build());
        achievements.add(new AchievementBuilder("Runecrafting 50", 0).requirement("Runecrafting", 50).build());
        achievements.add(new AchievementBuilder("Runecrafting 60", 0).requirement("Runecrafting", 60).build());
        achievements.add(new AchievementBuilder("Runecrafting 70", 0).requirement("Runecrafting", 70).build());
        achievements.add(new AchievementBuilder("Runecrafting 80", 0).requirement("Runecrafting", 80).build());
        achievements.add(new AchievementBuilder("Runecrafting 90", 0).requirement("Runecrafting", 90).build());
        achievements.add(new AchievementBuilder("Runecrafting 92", 0).requirement("Runecrafting", 92).build());
        achievements.add(new AchievementBuilder("Runecrafting 99", 0).requirement("Runecrafting", 99).build());
        achievements.add(new AchievementBuilder("Safety Dance", 0).requirement("Summoning", 60)
            .encounter(new Encounter("Queen Black Dragon")).build());
        achievements.add(new AchievementBuilder("Scrolling with Power", 0).requirement("Dungeoneering scrolls", 8).build());
        achievements.add(new AchievementBuilder("Seagullible", 0).requirement("Ports reputation", 300000).build());
        achievements.add(new AchievementBuilder("Second Shrubbery", 0).requirement("Herring", 1).build());
        achievements.add(new AchievementBuilder("Seeing Lava", 0).requirement("Fire cape", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Tz-Kih"), Arrays.asList("Tz-Kih", "Tz-Kih"),
                Collections.singletonList("Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kih", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"),
                Collections.singletonList("Tok-Xil"), Arrays.asList("Tok-Xil", "Tz-Kih"), Arrays.asList("Tok-Xil", "Tz-Kih", "Tz-Kih"),
                Arrays.asList("Tok-Xil", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tok-Xil", "Tz-Kek", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tok-Xil", "Tz-Kek", "Tz-Kih", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Tok-Xil", "Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek",
                    "Tz-Kek"), Arrays.asList("Tok-Xil", "Tok-Xil"), Collections.singletonList("Yt-MejKot"),
                Arrays.asList("Yt-MejKot", "Tz-Kih"), Arrays.asList("Yt-MejKot", "Tz-Kih", "Tz-Kih"), Arrays.asList("Yt-MejKot", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tz-Kek", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Yt-MejKot", "Tz-Kek", "Tz-Kih", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Yt-MejKot", "Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"),
                Arrays.asList("Yt-MejKot", "Tok-Xil"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kih"),
                Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kih", "Tz-Kih"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kek", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kek", "Tz-Kih", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tz-Kek", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"), Arrays.asList("Yt-MejKot", "Tok-Xil", "Tok-Xil"),
                Arrays.asList("Yt-MejKot", "Yt-MejKot"), Collections.singletonList("Ket-Zek"), Arrays.asList("Ket-Zek", "Tz-Kih"),
                Arrays.asList("Ket-Zek", "Tz-Kih", "Tz-Kih"), Arrays.asList("Ket-Zek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Ket-Zek", "Tz-Kek", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Ket-Zek", "Tz-Kek", "Tz-Kih", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Ket-Zek", "Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"),
                Arrays.asList("Ket-Zek", "Tok-Xil"), Arrays.asList("Ket-Zek", "Tok-Xil", "Tz-Kih"),
                Arrays.asList("Ket-Zek", "Tok-Xil", "Tz-Kih", "Tz-Kih"), Arrays.asList("Ket-Zek", "Tok-Xil", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Ket-Zek", "Tok-Xil", "Tz-Kek", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Ket-Zek", "Tok-Xil", "Tz-Kek", "Tz-Kih", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Ket-Zek", "Tok-Xil", "Tz-Kek", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"), Arrays.asList("Ket-Zek", "Tok-Xil", "Tok-Xil"),
                Arrays.asList("Ket-Zek", "Yt-MejKot"), Arrays.asList("Ket-Zek", "Yt-MejKot", "Tz-Kih"),
                Arrays.asList("Ket-Zek", "Yt-MejKot", "Tz-Kih", "Tz-Kih"), Arrays.asList("Ket-Zek", "Yt-MejKot", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Ket-Zek", "Yt-MejKot", "Tz-Kek", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Ket-Zek", "Yt-MejKot", "Tz-Kek", "Tz-Kih", "Tz-Kih"),
                Arrays.asList("Tz-Kek", "Tz-Kek"), Arrays.asList("Ket-Zek", "Yt-MejKot", "Tz-Kek", "Tz-Kek"),
                Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"), Arrays.asList("Ket-Zek", "Yt-MejKot", "Tok-Xil"),
                Arrays.asList("Ket-Zek", "Yt-MejKot", "Tok-Xil", "Tz-Kih"),
                Arrays.asList("Ket-Zek", "Yt-MejKot", "Tok-Xil", "Tz-Kih", "Tz-Kih"),
                Arrays.asList("Ket-Zek", "Yt-MejKot", "Tok-Xil", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Ket-Zek", "Yt-MejKot", "Tok-Xil", "Tz-Kek", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Ket-Zek", "Yt-MejKot", "Tok-Xil", "Tz-Kek", "Tz-Kih", "Tz-Kih"), Arrays.asList("Tz-Kek", "Tz-Kek"),
                Arrays.asList("Ket-Zek", "Yt-MejKot", "Tok-Xil", "Tz-Kek", "Tz-Kek"), Arrays.asList("Tz-Kek", "Tz-Kek", "Tz-Kek", "Tz-Kek"),
                Arrays.asList("Ket-Zek", "Yt-MejKot", "Tok-Xil", "Tok-Xil"),
                Arrays.asList("Ket-Zek", "Yt-MejKot", "Yt-MejKot"), Arrays.asList("Ket-Zek", "Ket-Zek"),
                Arrays.asList("TzTok-Jad", "Yt-HurKot", "Yt-HurKot", "Yt-HurKot", "Yt-HurKot")),
                Arrays.asList(new Restriction("Inventory spaces", 27), new Restriction("Summoning", 0)), true)).build());
        achievements.add(new AchievementBuilder("Seers' Village", 0).build());
        achievements.add(new AchievementBuilder("Seven Colours In Their Hat", 0).requirement("Chromatic partyhat", 1).build());
        achievements.add(new AchievementBuilder("Shadows Below", 0).requirement("Barrows: Rise of the Six", 1).build());
        achievements.add(new AchievementBuilder("Shattering Worlds I", 0).requirement("Shattered Worlds max world", 10).build());
        achievements.add(new AchievementBuilder("Shattering Worlds II", 0).requirement("Shattered Worlds max world", 25).build());
        achievements.add(new AchievementBuilder("Shattering Worlds III", 0).requirement("Shattered Worlds max world", 50).build());
        achievements.add(new AchievementBuilder("Shattering Worlds IV", 0).requirement("Shattered Worlds max world", 100).build());
        achievements.add(new AchievementBuilder("Shattering Worlds V", 0).requirement("Shattered Worlds max world", 150).build());
        achievements.add(new AchievementBuilder("Shattering Worlds VI", 0).requirement("Shattered Worlds max world", 200).build());
        achievements.add(new AchievementBuilder("Shrimpy", 0).requirement("Volcanic shard", 1).build());
        achievements.add(new AchievementBuilder("Skeletrail Horror", 0).requirement("Skeletal horror", 1).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring I", 0).requirement("Corrupted creature kills", 500).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring II", 0).requirement("Corrupted creature kills", 1000).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring III", 0).requirement("Corrupted creature kills", 2500).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring IV", 0).requirement("Corrupted creature kills", 5000).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring V", 0).requirement("Corrupted creature kills", 10000).build());
        achievements.add(new AchievementBuilder("Slayer - Crabbe", 0).requirement("Crabbe", 1).build());
        achievements.add(new AchievementBuilder("Slayer 5", 0).requirement("Slayer", 5).build());
        achievements.add(new AchievementBuilder("Slayer 10", 0).requirement("Slayer", 10).build());
        achievements.add(new AchievementBuilder("Slayer 20", 0).requirement("Slayer", 20).build());
        achievements.add(new AchievementBuilder("Slayer 30", 0).requirement("Slayer", 30).build());
        achievements.add(new AchievementBuilder("Slayer 40", 0).requirement("Slayer", 40).build());
        achievements.add(new AchievementBuilder("Slayer 50", 0).requirement("Slayer", 50).build());
        achievements.add(new AchievementBuilder("Slayer 60", 0).requirement("Slayer", 60).build());
        achievements.add(new AchievementBuilder("Slayer 70", 0).requirement("Slayer", 70).build());
        achievements.add(new AchievementBuilder("Slayer 80", 0).requirement("Slayer", 80).build());
        achievements.add(new AchievementBuilder("Slayer 90", 0).requirement("Slayer", 90).build());
        achievements.add(new AchievementBuilder("Slayer 99", 0).requirement("Slayer", 99).build());
        achievements.add(new AchievementBuilder("Slayer 110", 0).requirement("Slayer", 110).build());
        achievements.add(new AchievementBuilder("Slayer 120", 0).requirement("Slayer", 120).build());
        achievements.add(new AchievementBuilder("Slide to the Left", 0).requirement("Puzzle box solved", 1).build());
        achievements.add(new AchievementBuilder("Smithing - Smithy", 0).requirement("Smithy", 1).build());
        achievements.add(new AchievementBuilder("Smithing 5", 0).requirement("Smithing", 5).build());
        achievements.add(new AchievementBuilder("Smithing 10", 0).requirement("Smithing", 10).build());
        achievements.add(new AchievementBuilder("Smithing 20", 0).requirement("Smithing", 20).build());
        achievements.add(new AchievementBuilder("Smithing 30", 0).requirement("Smithing", 30).build());
        achievements.add(new AchievementBuilder("Smithing 40", 0).requirement("Smithing", 40).build());
        achievements.add(new AchievementBuilder("Smithing 50", 0).requirement("Smithing", 50).build());
        achievements.add(new AchievementBuilder("Smithing 60", 0).requirement("Smithing", 60).build());
        achievements.add(new AchievementBuilder("Smithing 70", 0).requirement("Smithing", 70).build());
        achievements.add(new AchievementBuilder("Smithing 80", 0).requirement("Smithing", 80).build());
        achievements.add(new AchievementBuilder("Smithing 90", 0).requirement("Smithing", 90).build());
        achievements.add(new AchievementBuilder("Smithing 92", 0).requirement("Smithing", 92).build());
        achievements.add(new AchievementBuilder("Smithing 99", 0).requirement("Smithing", 99).build());
        achievements.add(new AchievementBuilder("So You Think You Can Guard?", 0).requirement("Max Telos enrage", 2000).build());
        achievements.add(new AchievementBuilder("Something Barrowed I", 0).requirement("Barrows", 5).build());
        achievements.add(new AchievementBuilder("Something Barrowed II", 0).requirement("Barrows", 10).build());
        achievements.add(new AchievementBuilder("Something Barrowed III", 0).requirement("Barrows", 25).build());
        achievements.add(new AchievementBuilder("Something Barrowed IV", 0).requirement("Barrows", 50).build());
        achievements.add(new AchievementBuilder("Something Barrowed V", 0).requirement("Barrows", 75).build());
        achievements.add(new AchievementBuilder("Source of Denial", 0).requirement("Diamond in the Rough", 1)
            .reward("Winter sq'irk", 1).reward("Farming", 30).build());
        achievements.add(new AchievementBuilder("Special Slayer Delivery", 0).requirement("Slayer crafting abilities", 3).build());
        achievements.add(new AchievementBuilder("Squishing Level I", 0).requirement("Corrupted scarab", 1).build());
        achievements.add(new AchievementBuilder("Squishing Level II", 0).requirement("Corrupted scarab", 10).build());
        achievements.add(new AchievementBuilder("Squishing Level III", 0).requirement("Corrupted scarab", 50).build());
        achievements.add(new AchievementBuilder("Squishing Level IV", 0).requirement("Corrupted scarab", 100).build());
        achievements.add(new AchievementBuilder("Squishing Level V", 0).requirement("Corrupted scarab", 200).build());
        achievements.add(new AchievementBuilder("Stand Your Ground", 0).requirement("Slayer", 95)
            .requirement("Ascension Keystone Primus", 1).requirement("Ascension Keystone Secundus", 1)
            .requirement("Ascension Keystone Tertius", 1).requirement("Ascension Keystone Quartus", 1)
            .requirement("Ascension Keystone Quintus", 1).requirement("Ascension Keystone Sextus", 1)
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList("Legio"))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList("Legio"))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList("Legio"))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList("Legio"))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList("Legio"))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList("Legio")))).build());
        achievements.add(new AchievementBuilder("Stone's Throw Away", 0).requirement("Replica statue", 30).build());
        achievements.add(new AchievementBuilder("Strength - Kangali", 0).requirement("Kangali", 1).build());
        achievements.add(new AchievementBuilder("Strength 5", 0).requirement("Strength", 5).build());
        achievements.add(new AchievementBuilder("Strength 10", 0).requirement("Strength", 10).build());
        achievements.add(new AchievementBuilder("Strength 20", 0).requirement("Strength", 20).build());
        achievements.add(new AchievementBuilder("Strength 30", 0).requirement("Strength", 30).build());
        achievements.add(new AchievementBuilder("Strength 40", 0).requirement("Strength", 40).build());
        achievements.add(new AchievementBuilder("Strength 50", 0).requirement("Strength", 50).build());
        achievements.add(new AchievementBuilder("Strength 60", 0).requirement("Strength", 60).build());
        achievements.add(new AchievementBuilder("Strength 70", 0).requirement("Strength", 70).build());
        achievements.add(new AchievementBuilder("Strength 80", 0).requirement("Strength", 80).build());
        achievements.add(new AchievementBuilder("Strength 90", 0).requirement("Strength", 90).build());
        achievements.add(new AchievementBuilder("Strength 92", 0).requirement("Strength", 92).build());
        achievements.add(new AchievementBuilder("Strength 99", 0).requirement("Strength", 99).build());
        achievements.add(new AchievementBuilder("Stuffed With Anima", 0).requirement("Max Telos enrage", 95)
            .encounter(new Encounter("Telos (100% enrage)")).build());
        achievements.add(new AchievementBuilder("Summoning - Shamini", 0).requirement("Shamini", 1).build());
        achievements.add(new AchievementBuilder("Summoning 5", 0).requirement("Summoning", 5).build());
        achievements.add(new AchievementBuilder("Summoning 10", 0).requirement("Summoning", 10).build());
        achievements.add(new AchievementBuilder("Summoning 20", 0).requirement("Summoning", 20).build());
        achievements.add(new AchievementBuilder("Summoning 30", 0).requirement("Summoning", 30).build());
        achievements.add(new AchievementBuilder("Summoning 40", 0).requirement("Summoning", 40).build());
        achievements.add(new AchievementBuilder("Summoning 50", 0).requirement("Summoning", 50).build());
        achievements.add(new AchievementBuilder("Summoning 60", 0).requirement("Summoning", 60).build());
        achievements.add(new AchievementBuilder("Summoning 70", 0).requirement("Summoning", 70).build());
        achievements.add(new AchievementBuilder("Summoning 80", 0).requirement("Summoning", 80).build());
        achievements.add(new AchievementBuilder("Summoning 90", 0).requirement("Summoning", 90).build());
        achievements.add(new AchievementBuilder("Summoning 92", 0).requirement("Summoning", 92).build());
        achievements.add(new AchievementBuilder("Summoning 99", 0).requirement("Summoning", 99).build());
        achievements.add(new AchievementBuilder("Sunshine Through the Rain", 0).requirement("Agility", 70)
            .encounter(new Encounter("Commander Zilyana (hard)", Collections.singletonList(new Restriction("Sunshine", 1)))).build());
        achievements.add(new AchievementBuilder("Superior Successor", 0).requirement("Magister uniques", 8).build());
        achievements.add(new AchievementBuilder("Supreme Hatchling", 0).requirement("Dagannoth scale", 1).build());
        achievements.add(new AchievementBuilder("Talk to Explorer Jack", 0).build());
        achievements.add(new AchievementBuilder("Tan Your Hide", 0).requirement("Cowhide", 1).reward("Leather", 1).build());
        achievements.add(new AchievementBuilder("Taverley", 0).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry I", 0).requirement("Max Telos enrage", 50).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry II", 0).requirement("Max Telos enrage", 100).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry III", 0).requirement("Max Telos enrage", 250).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry IV", 0).requirement("Max Telos enrage", 500).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry V", 0).requirement("Max Telos enrage", 750).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry VI", 0).requirement("Max Telos enrage", 1000).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts I", 0).requirement("Telos", 5).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts II", 0).requirement("Telos", 10).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts III", 0).requirement("Telos", 25).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts IV", 0).requirement("Telos", 50).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts V", 0).requirement("Telos", 75).build());
        achievements.add(new AchievementBuilder("Tess", 0).requirement("Telos' tendril", 1).build());
        achievements.add(new AchievementBuilder("The True Warden", 0).requirement("Max Telos enrage", 4000).build());
        achievements.add(new AchievementBuilder("There's No Place Like Burthorpe", 0).requirement("Burthorpe", 1).build());
        achievements.add(new AchievementBuilder("There's No Place Like Home", 0).build());
        achievements.add(new AchievementBuilder("They All Fell Down", 0)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Dagannoth Supreme", "Dagannoth Prime", "Dagannoth Rex"))))
            .build());
        achievements.add(new AchievementBuilder("Thieving - Ralph", 0).requirement("Ralph", 1).build());
        achievements.add(new AchievementBuilder("Thieving 5", 0).requirement("Thieving", 5).build());
        achievements.add(new AchievementBuilder("Thieving 10", 0).requirement("Thieving", 10).build());
        achievements.add(new AchievementBuilder("Thieving 20", 0).requirement("Thieving", 20).build());
        achievements.add(new AchievementBuilder("Thieving 30", 0).requirement("Thieving", 30).build());
        achievements.add(new AchievementBuilder("Thieving 40", 0).requirement("Thieving", 40).build());
        achievements.add(new AchievementBuilder("Thieving 50", 0).requirement("Thieving", 50).build());
        achievements.add(new AchievementBuilder("Thieving 60", 0).requirement("Thieving", 60).build());
        achievements.add(new AchievementBuilder("Thieving 70", 0).requirement("Thieving", 70).build());
        achievements.add(new AchievementBuilder("Thieving 80", 0).requirement("Thieving", 80).build());
        achievements.add(new AchievementBuilder("Thieving 90", 0).requirement("Thieving", 90).build());
        achievements.add(new AchievementBuilder("Thieving 92", 0).requirement("Thieving", 92).build());
        achievements.add(new AchievementBuilder("Thieving 99", 0).requirement("Thieving", 99).build());
        achievements.add(new AchievementBuilder("This Helwyr in I", 0).requirement("Helwyr", 5).build());
        achievements.add(new AchievementBuilder("This Helwyr in II", 0).requirement("Helwyr", 10).build());
        achievements.add(new AchievementBuilder("This Helwyr in III", 0).requirement("Helwyr", 25).build());
        achievements.add(new AchievementBuilder("This Helwyr in IV", 0).requirement("Helwyr", 50).build());
        achievements.add(new AchievementBuilder("This Helwyr in V", 0).requirement("Helwyr", 75).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One I", 0).requirement("King Black Dragon", 5).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One II", 0)
            .requirement("King Black Dragon", 10).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One III", 0)
            .requirement("King Black Dragon", 25).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One IV", 0)
            .requirement("King Black Dragon", 50).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One V", 0)
            .requirement("King Black Dragon", 75).build());
        achievements.add(new AchievementBuilder("Through the Fire and Flames", 0)
            .encounter(new Encounter("Queen Black Dragon", Collections.singletonList(new Restriction("Royal crossbow", 1)))).build());
        achievements.add(new AchievementBuilder("To Be a Master", 0).requirement("Souls captured", 151).build());
        achievements.add(new AchievementBuilder("To the Bone", 0).requirement("Worker district reputation", 300000).build());
        achievements.add(new AchievementBuilder("TokHaar-Mok", 0).requirement("The Brink of Extinction", 1)
            .encounter(new Encounter("TokHaar-Hok")).reward("Obsidian shard", 16)
            .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Magic", "Ranged", "Summoning", "Prayer", "Herblore",
                "Slayer"), 20000, 80).build());
        achievements.add(new AchievementBuilder("Torag Bobblehead", 0).requirement("Torag the Bobbled", 1).build());
        achievements.add(new AchievementBuilder("Towering Over Us All", 0).requirement("Master clue scroll", 1).build());
        achievements.add(new AchievementBuilder("Traitorous", 0).requirement("Agility", 70)
            .encounter(new Encounter("Commander Zilyana", Arrays.asList(new Restriction("Proselyte hauberk", 1),
                new Restriction("Proselyte sallet", 1), new Restriction("Proselyte tasset", 1)))).build());
        achievements.add(new AchievementBuilder("Treasure Seeker I", 0).requirement("Clue scrolls", 1).build());
        achievements.add(new AchievementBuilder("Treasure Seeker II", 0).requirement("Clue scrolls", 5).build());
        achievements.add(new AchievementBuilder("Treasure Seeker III", 0).requirement("Clue scrolls", 10).build());
        achievements.add(new AchievementBuilder("Treasure Seeker IV", 0).requirement("Clue scrolls", 25).build());
        achievements.add(new AchievementBuilder("Treasure Seeker V", 0).requirement("Clue scrolls", 50).build());
        achievements.add(new AchievementBuilder("Treasure Seeker VI", 0).requirement("Clue scrolls", 100).build());
        achievements.add(new AchievementBuilder("Treasure Seeker VII", 0).requirement("Clue scrolls", 250).build());
        achievements.add(new AchievementBuilder("Treasure Seeker VIII", 0).requirement("Clue scrolls", 500).build());
        achievements.add(new AchievementBuilder("Treasure Seeker IX", 0).requirement("Clue scrolls", 750).build());
        achievements.add(new AchievementBuilder("Treasure Seeker X", 0).requirement("Clue scrolls", 1000).build());
        achievements.add(new AchievementBuilder("Who Will Be Her Lover?", 0).requirement("Statue of Rhiannon", 32).build());
        achievements.add(new AchievementBuilder("Work On Your Artisan", 0).requirement("Artisans Workshop rewards", 14).build());
        achievements.add(new AchievementBuilder("Trimmed Completionist Cape", 0).requirement("Advanced Sweeping", 1)
            .requirement("Agile from Head to Toe", 1).requirement("All Rise", 1).requirement("Arc - All Your Energies", 1)
            .requirement("Arc - Bone to Pick with You", 1).requirement("Arc - Don't Crush My Memories", 1)
            .requirement("Arc - Mitts and Waders - Death Lotus", 1).requirement("Arc - Mitts and Waders - Seasinger", 1)
            .requirement("Arc - Mitts and Waders - Tetsu", 1).requirement("Around the World in Six Ways", 1)
            .requirement("Banking History", 1).requirement("Barbarian Scavenger", 1).requirement("Champions, What Champions?", 1)
            .requirement("Chompy Massacre", 1).requirement("Class Crown", 1).requirement("Complete Trekky", 1)
            .requirement("Completionist Cape", 1).requirement("Conquest Adore", 1).requirement("Count All Light Fingers", 1)
            .requirement("Death Effect", 1).requirement("Eastern Adventurer", 1).requirement("Eastern Explorer", 1)
            .requirement("Eeeeagle!", 1).requirement("Ferocious Upgrade", 1).requirement("Finish Him!", 1).requirement("Hard as Daemons", 1)
            .requirement("How Many Games?", 1).requirement("Ice Ice Chimpy", 1).requirement("Impressing Char", 1)
            .requirement("Ivan is Flailing", 1).requirement("Jack of the Circus", 1).requirement("Kal'gerion Commander", 1)
            .requirement("Lock, Stock and Barrel", 1).requirement("Maria, You Gotta See Her", 1).requirement("Master Angler", 1)
            .requirement("Master Otto", 1).requirement("Master of Assault", 1).requirement("Mazcab Teleport", 1)
            .requirement("Memorialised More Than Once", 1).requirement("Milk of Chocolate, Snape of Grass", 1)
            .requirement("Mobilise This", 1).requirement("Nomad's Genesis", 1).requirement("Nomad's Mirage", 1)
            .requirement("On a Rune High", 1).requirement("Penance to the King", 1).requirement("Perky Like a Prawn", 1)
            .requirement("Post Fume", 1).requirement("Quiet but Deadly Lore", 1).requirement("Rank: Master Finix", 1)
            .requirement("Scabigail", 1).requirement("Scribbling in the Depths", 1).requirement("Scrolling with Power", 1)
            .requirement("Seagullible", 1).requirement("Shadows Below", 1).requirement("Sheep Shearer", 1)
            .requirement("Slime and Snails and God Wars Tales", 1).requirement("Special Slayer Delivery", 1)
            .requirement("Stone's Throw Away", 1).requirement("Telos If You're Angry II", 1).requirement("To Be a Master", 1)
            .requirement("To the Bone", 1).requirement("White Knight Rises", 1).requirement("Who Will Be Her Lover?", 1)
            .requirement("Witch's Potion", 1).requirement("Work On Your Artisan", 1).requirement("You're Not My Real Mah", 1).build());
        achievements.add(new AchievementBuilder("Trollheim Teleport", 0).requirement("Law rune", 2).requirement("Fire rune", 2)
            .requirement("Eadgar's Ruse", 1).requirement("Magic", 61).reward("Magic", 68).build());
        achievements.add(new AchievementBuilder("TzRek-Jad", 0).requirement("TzRek-Jad (pet)", 1).build());
        achievements.add(new AchievementBuilder("Unionised", 0).requirement("Prifddinian worker's robes", 1).requirement("Magic", 80)
            .requirement("Prifddinian worker's trousers", 1).requirement("Prifddinian worker's gloves", 1)
            .requirement("Prifddinian worker's boots", 1).encounter(new Encounter("Helwyr", Arrays.asList(new Restriction("Torso", 0),
                new Restriction("Hands", 0), new Restriction("Feet", 0), new Restriction("Legs", 0)))).build());
        achievements.add(new AchievementBuilder("Unlucky for Some", 0.05).build());
        achievements.add(new AchievementBuilder("Untangled", 0).requirement("Elite clue scroll", 1).build());
        achievements.add(new AchievementBuilder("Up for Sail", 0).requirement("Coins", 50000).requirement("Fishing", 68).build());
        achievements.add(new AchievementBuilder("Varrock", 0).build());
        achievements.add(new AchievementBuilder("Varrock Calls for Aid!", 0.2).requirement("Firemaking", 92)
            .requirement("Construction", 59).requirement("Smithing", 56).requirement("Crafting", 60).requirement("Agility", 64)
            .requirement("Prayer", 31).requirement("Strength", 60).requirement("All Fired Up", 1).requirement("Land of the Goblins", 1)
            .requirement("Troll Stronghold", 1).requirement("Logs", 280).reward("Firemaking", 41579).build());
        achievements.add(new AchievementBuilder("Verac Bobblehead", 0).requirement("Verac the Bobbled", 1).build());
        achievements.add(new AchievementBuilder("Vindictive I", 0).requirement("Vindicta (hard)", 5).build());
        achievements.add(new AchievementBuilder("Vindictive II", 0).requirement("Vindicta (hard)", 10).build());
        achievements.add(new AchievementBuilder("Vindictive III", 0).requirement("Vindicta (hard)", 25).build());
        achievements.add(new AchievementBuilder("Vindictive IV", 0).requirement("Vindicta (hard)", 50).build());
        achievements.add(new AchievementBuilder("Vindictive V", 0).requirement("Vindicta (hard)", 75).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious I", 0).requirement("Vindicta", 5).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious II", 0).requirement("Vindicta", 10).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious III", 0).requirement("Vindicta", 25).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious IV", 0).requirement("Vindicta", 50).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious V", 0).requirement("Vindicta", 75).build());
        achievements.add(new AchievementBuilder("Vindiddy", 0).requirement("Imbued blade slice", 1).build());
        achievements.add(new AchievementBuilder("Vitalis", 0).requirement("Ancient summoning stone", 1).build());
        achievements.add(new AchievementBuilder("We Are Legion", 0).requirement("Legiones uniques", 12).build());
        achievements.add(new AchievementBuilder("Whack a Mole I", 0).requirement("Giant Mole (hard)", 5).build());
        achievements.add(new AchievementBuilder("Whack a Mole II", 0).requirement("Giant Mole (hard)", 10).build());
        achievements.add(new AchievementBuilder("Whack a Mole III", 0).requirement("Giant Mole (hard)", 25).build());
        achievements.add(new AchievementBuilder("Whack a Mole IV", 0).requirement("Giant Mole (hard)", 50).build());
        achievements.add(new AchievementBuilder("Whack a Mole V", 0).requirement("Giant Mole (hard)", 75).build());
        achievements.add(new AchievementBuilder("Whale Food", 0).requirement("K'ril Tsutsaroth uniques", 20).build());
        achievements.add(new AchievementBuilder("What's In the Hole", 0).requirement("Treasure Trail hidey-holes", 1).build());
        achievements.add(new AchievementBuilder("What Year Is It?", 0.1).requirement("Desert Treasure", 1).requirement("Magic", 94)
            .requirement("Blood rune", 198).requirement("Water rune", 495).build());
        achievements.add(new AchievementBuilder("Wheels of Commerce", 0).build());
        achievements.add(new AchievementBuilder("Who's Your Daddy?", 0).requirement("The Fremennik Trials", 1)
            .encounter(new Encounter("Vorago", Collections.singletonList(new Restriction("Weapon", 0)))).build());
        achievements.add(new AchievementBuilder("Who's the Boss? I", 0).requirement("Boss kills", 500).build());
        achievements.add(new AchievementBuilder("Who's the Boss? II", 0).requirement("Boss kills", 1000).build());
        achievements.add(new AchievementBuilder("Who's the Boss? III", 0).requirement("Boss kills", 2000).build());
        achievements.add(new AchievementBuilder("Who's the Boss? IV", 0).requirement("Boss kills", 3000).build());
        achievements.add(new AchievementBuilder("Who's the Boss? V", 0).requirement("Boss kills", 4000).build());
        achievements.add(new AchievementBuilder("Who Do Broodoo?", 0.15).encounter(new Encounter("Broodoo victim",
            Collections.singletonList(new Restriction("Tribal mask (blue)", 1)))).encounter(new Encounter("Broodoo victim",
                Collections.singletonList(new Restriction("Tribal mask (green)", 1)))).encounter(new Encounter("Broodoo victim",
                Collections.singletonList(new Restriction("Tribal mask (orange)", 1)))).build());
        achievements.add(new AchievementBuilder("Wolf Pack", 0).requirement("Magic", 80)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Helwyr", "Cywir Alpha", "Cywir Alpha", "Cywir Alpha",
                "Cywir Alpha")))).build());
        achievements.add(new AchievementBuilder("Woodcutting - Woody", 0).requirement("Woody", 1).build());
        achievements.add(new AchievementBuilder("Woodcutting 5", 0).requirement("Woodcutting", 5).build());
        achievements.add(new AchievementBuilder("Woodcutting 10", 0).requirement("Woodcutting", 10).build());
        achievements.add(new AchievementBuilder("Woodcutting 20", 0).requirement("Woodcutting", 20).build());
        achievements.add(new AchievementBuilder("Woodcutting 30", 0).requirement("Woodcutting", 30).build());
        achievements.add(new AchievementBuilder("Woodcutting 40", 0).requirement("Woodcutting", 40).build());
        achievements.add(new AchievementBuilder("Woodcutting 50", 0).requirement("Woodcutting", 50).build());
        achievements.add(new AchievementBuilder("Woodcutting 60", 0).requirement("Woodcutting", 60).build());
        achievements.add(new AchievementBuilder("Woodcutting 70", 0).requirement("Woodcutting", 70).build());
        achievements.add(new AchievementBuilder("Woodcutting 80", 0).requirement("Woodcutting", 80).build());
        achievements.add(new AchievementBuilder("Woodcutting 90", 0).requirement("Woodcutting", 90).build());
        achievements.add(new AchievementBuilder("Woodcutting 92", 0).requirement("Woodcutting", 92).build());
        achievements.add(new AchievementBuilder("Woodcutting 99", 0).requirement("Woodcutting", 99).build());
        achievements.add(new AchievementBuilder("Yak and Ruin I", 0).requirement("Yakamaru", 5).build());
        achievements.add(new AchievementBuilder("Yak and Ruin II", 0).requirement("Yakamaru", 10).build());
        achievements.add(new AchievementBuilder("Yak and Ruin III", 0).requirement("Yakamaru", 25).build());
        achievements.add(new AchievementBuilder("Yak and Ruin IV", 0).requirement("Yakamaru", 50).build());
        achievements.add(new AchievementBuilder("Yak and Ruin V", 0).requirement("Yakamaru", 75).build());
        achievements.add(new AchievementBuilder("Yakaminu", 0).requirement("Yakamaru's helmet", 1).build());
        achievements.add(new AchievementBuilder("Yanille", 0).build());
        achievements.add(new AchievementBuilder("You're It", 0.5).requirement("Coins", 200).requirement("Agility", 40)
            .reward("Agility arena ticket", 30).build());
        achievements.add(new AchievementBuilder("Zillier Way to Die I", 0).requirement("Commander Zilyana (hard)", 5).build());
        achievements.add(new AchievementBuilder("Zillier Way to Die II", 0).requirement("Commander Zilyana (hard)", 10).build());
        achievements.add(new AchievementBuilder("Zillier Way to Die III", 0).requirement("Commander Zilyana (hard)", 25).build());
        achievements.add(new AchievementBuilder("Zillier Way to Die IV", 0).requirement("Commander Zilyana (hard)", 50).build());
        achievements.add(new AchievementBuilder("Zillier Way to Die V", 0).requirement("Commander Zilyana (hard)", 75).build());
        achievements.add(new AchievementBuilder("Zilly Way to Die I", 0).requirement("Commander Zilyana", 5).build());
        achievements.add(new AchievementBuilder("Zilly Way to Die II", 0).requirement("Commander Zilyana", 10).build());
        achievements.add(new AchievementBuilder("Zilly Way to Die III", 0).requirement("Commander Zilyana", 25).build());
        achievements.add(new AchievementBuilder("Zilly Way to Die IV", 0).requirement("Commander Zilyana", 50).build());
        achievements.add(new AchievementBuilder("Zilly Way to Die V", 0).requirement("Commander Zilyana", 75).build());
    }

    public static AchievementDatabase getAchievementDatabase() {
        if (achievementDatabase == null) {
            achievementDatabase = new AchievementDatabase();
        }
        return achievementDatabase;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }
}