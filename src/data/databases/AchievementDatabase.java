package data.databases;

import logic.Encounter;
import logic.Player;
import data.dataobjects.Achievement;
import data.dataobjects.Achievement.AchievementBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*This class lists not only achievements, but all non-repeatables.*/
public class AchievementDatabase {

    private static AchievementDatabase achievementDatabase;

    private List<Achievement> achievements = new ArrayList<>();
    private Map<String, Achievement> namedAchievements = new LinkedHashMap<>();

    private AchievementDatabase() {
        addAchievementsPhase1();
        addAchievementsPhase2();
        addAchievementsPhase3();
        addAchievementsPhase4();
        AchievementBuilder allAchievements = new AchievementBuilder("All Achievements", 0);
        for (Achievement achievement : achievements) {
            allAchievements.requirement(achievement.getName(), 1);
        }
        achievements.add(allAchievements.build());
        for (Achievement achievement : achievements) {
            namedAchievements.put(achievement.getName(), achievement);
        }
    }

    private void addAchievementsPhase1() {
        achievements.add(new AchievementBuilder("Invention tutorial", 0.5).requirement("Smithing", 80).requirement("Crafting", 80)
            .requirement("Divination", 80).reward("Invention", 1861).reward("Divination", 100).build());
        achievements.add(new AchievementBuilder("1001 Kharidian Spikes", 0.05).requirement("Farming", 55).requirement("Cactus seed", 1)
            .reward("Farming", 465).reward("Cactus spines", 1).build());
        achievements.add(new AchievementBuilder("Three's Company", 0.75).requirement("Dungeoneering", 6)
            .requirement("Attack", 30).requirement("Ranged", 30).requirement("Magic", 30).reward("Dungeoneering", 750)
            .reward("Dungeoneering token", 75).lamp(Arrays.asList("Attack", "Ranged", "Magic"), 3750, 1).build());
        achievements.add(new AchievementBuilder("300", 0).requirement("Three's Company", 1).build());
        achievements.add(new AchievementBuilder("The Dig Site", 1.5).requirement("Thieving", 25).requirement("Agility", 10)
            .requirement("Herblore", 10).requirement("Cup of tea", 1).requirement("Vial", 1).requirement("Rope", 2)
            .requirement("Uncut opal", 1).reward("Quest points", 2).reward("Mining", 15300).reward("Herblore", 2000).reward("Gold bar", 2)
            .build());
        achievements.add(new AchievementBuilder("One Piercing Note", 1).reward("Quest points", 2).reward("Prayer", 250).build());
        achievements.add(new AchievementBuilder("Priest in Peril", 0.75).requirement("Pure essence", 25).requirement("Bucket", 0)
            .encounter(new Encounter("Cerberus")).encounter(new Encounter("Monk of Zamorak")).reward("Quest points", 1)
            .lamp(Collections.singletonList("Prayer"), 1406, 10).build());
        achievements.add(new AchievementBuilder("Temple of Ikov", 0.75).requirement("Thieving", 42).requirement("Ranged", 40)
            .requirement("Limpwurt root", 20).requirement("White candle", 0).encounter(new Encounter("Fire Warrior of Lesarkus"))
            .reward("Quest points", 1).reward("Ranged", 10500).reward("Fletching", 8000).build());
        achievements.add(new AchievementBuilder("The Tourist Trap", 1).requirement("Fletching", 10).requirement("Smithing", 20)
            .requirement("Desert shirt", 1).requirement("Desert robe", 1).requirement("Desert boots", 1).requirement("Waterskin (4)", 3)
            .requirement("Feather", 30).requirement("Coins", 200).requirement("Bronze bar", 1).reward("Quest points", 2)
            .lamp(Arrays.asList("Agility", "Fletching", "Smithing", "Thieving"), 4650, 1)
            .lamp(Arrays.asList("Agility", "Fletching", "Smithing", "Thieving"), 4650, 1).build());
        achievements.add(new AchievementBuilder("Death Plateau", 0.25).encounter(new Encounter("The Map")).reward("Quest points", 1)
            .reward("Rabbit sandwich", 4).reward("Agility", 48).lamp(Player.ALL_SKILLS, 100, 1).lamp(Player.ALL_SKILLS, 100, 1)
            .lamp(Player.ALL_SKILLS, 100, 1).build());
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
            .encounter(new Encounter("Ice troll")).encounter(new Encounter("Kamil")).encounter(new Encounter("Fareed"))
            .encounter(new Encounter("Damis (form 1)")).encounter(new Encounter("Damis (form 2)")).reward("Quest points", 3)
            .reward("Magic", 20000).build());
        achievements.add(new AchievementBuilder("The Restless Ghost", 0.25).reward("Quest points", 1).reward("Prayer", 1125)
            .build());
        achievements.add(new AchievementBuilder("Mage Arena minigame", 0).requirement("Magic", 60)
            .encounter(new Encounter("Kolodion (Ogre)")).encounter(new Encounter("Kolodion (Troll)"))
            .encounter(new Encounter("Kolodion (Dark beast)")).encounter(new Encounter("Kolodion (Black demon)")).build());
        achievements.add(new AchievementBuilder("A, B, Cithara", 0).requirement("One Piercing Note", 1).requirement("Desert Treasure", 1)
            .requirement("The Restless Ghost", 1).requirement("Mage Arena minigame", 1).requirement("Saradomin arrows", 0).build());
        achievements.add(new AchievementBuilder("A-Voiding Conflict", 0.05).requirement("Combat", 35).build());
        achievements.add(new AchievementBuilder("A Barrel of Staffs", 0).requirement("Mage Arena minigame", 1)
            .requirement("Coins", 80000).build());
        achievements.add(new AchievementBuilder("A Body in the Sewers", 0).requirement("Mithril bar", 5).requirement("Smithing", 68)
            .reward("Mithril platebody", 1).reward("Smithing", 250).build());
        achievements.add(new AchievementBuilder("A Bolt from the Blue", 0).requirement("Rune bar", 1).requirement("Feather", 10)
            .requirement("Smithing", 50).requirement("Fletching", 69).reward("Smithing", 250).reward("Fletching", 100)
            .reward("Rune bolts (unf)", 40).reward("Rune bolts", 10).build());
        achievements.add(new AchievementBuilder("A Bridge Not Far", 0).requirement("Agility", 8).requirement("Strength", 19)
            .requirement("Ranged", 37).build());
        achievements.add(new AchievementBuilder("Plague City", 0.5).requirement("Dwellberries", 1).requirement("Rope", 1)
            .requirement("Chocolate dust", 1).requirement("Snape grass", 1).requirement("Bucket of milk", 1).reward("Quest points", 1)
            .reward("Mining", 2425).build());
        achievements.add(new AchievementBuilder("Gertrude's Cat", 0.75).requirement("Raw sardine", 1).requirement("Coins", 100)
            .requirement("Bucket of milk", 1).reward("Quest points", 1).lamp(Collections.singletonList("Cooking"), 1525, 14)
            .reward("Chocolate cake", 1).reward("Stew", 1).build());
        achievements.add(new AchievementBuilder("A Cat is for Life...", 0).requirement("Plague City", 1)
            .requirement("Gertrude's Cat", 1).build());
        achievements.add(new AchievementBuilder("Making History", 0.75).requirement("Priest in Peril", 1)
            .requirement("The Restless Ghost", 1).requirement("Spade", 0).requirement("Coins", 2600).requirement("Sapphire amulet", 1)
            .reward("Quest points", 3).reward("Crafting", 1000).reward("Prayer", 1000).reward("Coins", 750).build());
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
            .encounter(new Encounter("Chompy bird")).reward("Quest points", 2).reward("Fletching", 262).reward("Cooking", 1470)
            .reward("Ranged", 735).build());
        achievements.add(new AchievementBuilder("Sheep Herder", 0.75).requirement("Coins", 100).reward("Coins", 3100)
            .reward("Quest points", 4).build());
        achievements.add(new AchievementBuilder("Roving Elves", 1).requirement("Waterfall Quest", 1).requirement("Regicide", 1)
            .requirement("Rope", 0).encounter(new Encounter("Moss giant (Glarial's Tomb)")).reward("Quest points", 1)
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
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Constitution", "Defence", "Ranged", "Prayer"), 250, 1).build());
        achievements.add(new AchievementBuilder("Diamond in the Rough", 1).requirement("Stolen Hearts", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Bandit", "Bandit", "Bandit king"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Apep", "Heru")))).reward("Quest points", 1)
            .reward("Agility", 250).reward("Thieving", 250).reward("Constitution", 250).reward("Sapphire", 1).reward("Emerald", 1)
            .reward("Ruby", 1).lamp(Arrays.asList("Attack", "Strength", "Magic", "Constitution", "Defence", "Ranged", "Prayer"), 250, 1)
            .build());
        achievements.add(new AchievementBuilder("The Jack of Spades", 0.5).requirement("Diamond in the Rough", 1)
            .reward("Agility", 500).reward("Quest points", 1).reward("Construction", 500).reward("Dungeoneering", 500)
            .reward("Thieving", 500).build());
        achievements.add(new AchievementBuilder("A Brief History of Telescopes", 0.05).requirement("Port jade", 3000)
            .requirement("Port cherrywood", 2000).requirement("Construction", 44).requirement("Oak plank", 2).requirement("Molten glass", 1)
            .reward("Construction", 121).build());
        achievements.add(new AchievementBuilder("Game of Tombs I", 0).requirement("Shifting Tombs", 1).build());
        achievements.add(new AchievementBuilder("Game of Tombs II", 0).requirement("Shifting Tombs", 10).build());
        achievements.add(new AchievementBuilder("Game of Tombs III", 0).requirement("Shifting Tombs", 50).build());
        achievements.add(new AchievementBuilder("Game of Tombs IV", 0).requirement("Shifting Tombs", 100).build());
        achievements.add(new AchievementBuilder("Game of Tombs V", 0).requirement("Shifting Tombs", 200).build());
        achievements.add(new AchievementBuilder("A Gift from Khazard", 0).build());
        achievements.add(new AchievementBuilder("A Grave Consideration", 0).requirement("The Restless Ghost", 1).build());
        achievements.add(new AchievementBuilder("Sea Slug", 0.5).requirement("Firemaking", 30).requirement("Swamp paste", 1)
            .reward("Quest points", 1).reward("Fishing", 7175).reward("Oyster pearls", 1).build());
        achievements.add(new AchievementBuilder("Recruitment Drive", 0.75).requirement("Herblore", 3).encounter(new Encounter(
            "Sir Leye")).reward("Quest points", 1).reward("Prayer", 1000).reward("Herblore", 1000).reward("Agility", 1000)
            .reward("Initiate sallet", 1).build());
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
        achievements.add(new AchievementBuilder("Chef's Assistant", 0.5).requirement("Cook's Assistant", 1).requirement("Cooking", 32)
            .requirement("Chef's hat", 0).requirement("Logs", 1).requirement("Steel bar", 1).requirement("Bucket of milk", 1)
            .requirement("Pot of flour", 1).requirement("Pat of butter", 1).requirement("Pot of cream", 1).reward("Quest points", 1)
            .reward("Cooking", 1500).build());
        achievements.add(new AchievementBuilder("Family Crest", 0.75).requirement("Crafting", 40).requirement("Smithing", 40)
            .requirement("Mining", 40).requirement("Magic", 59).requirement("Shrimps", 1).requirement("Salmon", 1).requirement("Tuna", 1)
            .requirement("Bass", 1).requirement("Swordfish", 1).requirement("Ruby", 2).requirement("Antipoison (4)", 1)
            .requirement("Air rune", 12).requirement("Water rune", 3).requirement("Fire rune", 3).requirement("Earth rune", 3)
            .encounter(new Encounter("Chronozon")).reward("Quest points", 1).build());
        achievements.add(new AchievementBuilder("Jungle Potion", 0.25).requirement("Herblore", 3).reward("Quest points", 1)
            .reward("Herblore", 775).build());
        achievements.add(new AchievementBuilder("Shilo Village", 1).requirement("Jungle Potion", 1).requirement("Crafting", 20)
            .requirement("Agility", 32).requirement("Bronze wire", 1).requirement("Bones", 3).requirement("Spade", 0).requirement("Rope", 1)
            .requirement("Chisel", 0).requirement("Unlit torch", 1).encounter(new Encounter("Nazastarool (phase 1)"))
            .encounter(new Encounter("Nazastarool (phase 2)")).encounter(new Encounter("Nazastarool (phase 3)")).reward("Quest points", 2)
            .reward("Crafting", 3875).reward("Coins", 2000).build());
        achievements.add(new AchievementBuilder("Lost City", 0.75).requirement("Crafting", 31).requirement("Woodcutting", 36)
            .encounter(new Encounter("Dramen tree spirit")).reward("Quest points", 3).build());
        achievements.add(new AchievementBuilder("Merlin's Crystal", 0.75).requirement("Bread", 1).requirement("Bucket", 1)
            .requirement("Bat bones", 1).encounter(new Encounter("Sir Mordred")).reward("Quest points", 6).reward("Excalibur", 1).build());
        achievements.add(new AchievementBuilder("Merlin's Crystal post-quest lamp", 0).requirement("Merlin's Crystal", 1)
            .lamp(Player.ALL_SKILLS, 1000, 20).build());
        achievements.add(new AchievementBuilder("Druidic Ritual", 0.25).requirement("Coins", 1).requirement("Vial", 1)
            .reward("Quest points", 4).reward("Herblore", 250).reward("Grimy guam", 15).reward("Eye of newt", 15).build());
        achievements.add(new AchievementBuilder("Shield of Arrav", 0.75).requirement("Coins", 20)
            .encounter(new Encounter("Jonny the beard")).reward("Quest points", 1).reward("Coins", 1200).build());
        achievements.add(new AchievementBuilder("The Fremennik Trials", 1.5).requirement("Crafting", 40).requirement("Fletching", 25)
            .requirement("Woodcutting", 40).requirement("Raw shark", 1).requirement("Coins", 5250).encounter(new Encounter("The Draugen"))
            .encounter(new Encounter("Koschei the Deathless")).reward("Quest points", 3).reward("Agility", 2812).reward("Attack", 2812)
            .reward("Constitution", 2812).reward("Crafting", 2812).reward("Defence", 2812).reward("Fishing", 2812).reward("Fletching", 2812)
            .reward("Strength", 2812).reward("Thieving", 2812).reward("Woodcutting", 2812).build());
        achievements.add(new AchievementBuilder("Rune Mysteries", 1).reward("Quest points", 1).reward("Magic", 250)
            .reward("Runecrafting", 250).reward("Air talisman", 1).reward("First tower hat", 1).reward("Tower mindspike", 1)
            .reward("Mind rune", 70).build());
        achievements.add(new AchievementBuilder("Lunar Diplomacy", 1.5).requirement("Lost City", 1).requirement("Rune Mysteries", 1)
            .requirement("The Fremennik Trials", 1).requirement("Shilo Village", 1).requirement("Crafting", 61).requirement("Defence", 40)
            .requirement("Firemaking", 49).requirement("Mining", 60).requirement("Herblore", 5).requirement("Runecrafting", 14)
            .requirement("Magic", 65).requirement("Woodcutting", 55).requirement("Coins", 1000).requirement("Nature rune", 1)
            .requirement("Fire rune", 4).requirement("Spade", 0).requirement("Air talisman", 0).requirement("Water talisman", 0)
            .requirement("Earth talisman", 0).requirement("Fire talisman", 0).requirement("Thread", 2).requirement("Clean guam", 1)
            .requirement("Clean marrentill", 1).encounter(new Encounter("Suqah")).encounter(new Encounter("Suqah"))
            .encounter(new Encounter("Suqah")).encounter(new Encounter("Suqah")).encounter(new Encounter("Suqah"))
            .encounter(new Encounter("Me")).reward("Quest points", 2).reward("Magic", 5000).reward("Runecrafting", 5000)
            .reward("Astral rune", 50).build());
        achievements.add(new AchievementBuilder("Nature Spirit", 0.5).requirement("Priest in Peril", 1)
            .requirement("The Restless Ghost", 1).requirement("Silver sickle", 1).encounter(new Encounter("Ghast"))
            .encounter(new Encounter("Ghast")).encounter(new Encounter("Ghast")).reward("Quest points", 2).reward("Apple pie", 3)
            .reward("Meat pie", 3).reward("Constitution", 2000).reward("Prayer", 90).lamp(Collections.singletonList("Defence"), 2000, 3)
            .lamp(Collections.singletonList("Crafting"), 3000, 4).build());
        achievements.add(new AchievementBuilder("A Fairy Tale I - Growing Pains", 0.75).requirement("Lost City", 1)
            .requirement("Nature Spirit", 1).requirement("Secateurs", 1).encounter(new Encounter("Tanglefoot")).reward("Quest points", 2)
            .reward("Farming", 3500).reward("Attack", 2000).reward("Magic", 1000).build());
        achievements.add(new AchievementBuilder("A Fairy Tale II - Cure a Queen", 0.75).requirement("A Fairy Tale I - Growing Pains", 1)
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
            .encounter(new Encounter("Black Knight Titan")).reward("Quest points", 2).reward("Defence", 15300).reward("Prayer", 11000)
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
            .requirement("One Small Favour", 1).requirement("Magic", 45).requirement("Defence", 65).requirement("Granite (500g)", 1)
            .requirement("Law rune", 1).requirement("Air rune", 1).requirement("Iron chainbody", 1).requirement("Bronze med helm", 1)
            .reward("Quest points", 1).reward("Defence", 33000).reward("Magic", 5000).lamp(Player.ALL_SKILLS, 5000, 50).build());
        achievements.add(new AchievementBuilder("Shades of Mort'ton", 0.75).requirement("Crafting", 20).requirement("Firemaking", 5)
            .requirement("Herblore", 15).requirement("Vial of water", 2).requirement("Ashes", 2).requirement("Clean tarromin", 2)
            .requirement("Logs", 1).requirement("Coins", 1000).encounter(new Encounter("Loar Shade")).encounter(new Encounter("Loar Shade"))
            .encounter(new Encounter("Loar Shade")).encounter(new Encounter("Loar Shade")).encounter(new Encounter("Loar Shade"))
            .reward("Quest points", 3).reward("Herblore", 2000).reward("Crafting", 2000).build());
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
            .encounter(new Encounter("Fever spider")).reward("Quest points", 2).reward("Farming", 7000).reward("Fishing", 7000)
            .reward("Prayer", 7000).build());
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
            .requirement("Charcoal", 1).requirement("Hammer", 1).requirement("Coins", 20).encounter(new Encounter("Customs Officer"))
            .encounter(new Encounter("Customs Officer")).reward("Quest points", 2).reward("Thieving", 25000).reward("Smithing", 25000)
            .reward("Agility", 25000).reward("Crafting", 25000).build());
        achievements.add(new AchievementBuilder("A Clockwork Syringe", 1.5).requirement("Rocking Out", 1).requirement("Dungeoneering", 50)
            .requirement("Slayer", 61).requirement("Construction", 62).requirement("Summoning", 65).requirement("Smithing", 74)
            .requirement("Thieving", 74).requirement("Defence", 76).encounter(new Encounter("Grimtern"))
            .encounter(new Encounter("Grimtern")).encounter(new Encounter("Grimtern")).encounter(new Encounter("Barrelchest Mk II"))
            .reward("Quest points", 1).reward("Defence", 19000).reward("Smithing", 18000).reward("Thieving", 18000)
            .reward("Summoning", 15000).reward("Construction", 11250).reward("Slayer", 11000).reward("Dungeoneering", 5000).build());
        achievements.add(new AchievementBuilder("The Feud", 0.75).requirement("Thieving", 30).requirement("Coins", 1002)
            .requirement("Leather gloves", 0).requirement("Beer", 3).encounter(new Encounter("Bandit champion"))
            .encounter(new Encounter("Tough Guy")).reward("Quest points", 1).reward("Thieving", 15000).reward("Coins", 500)
            .reward("Adamant scimitar", 1).reward("Beer", 1).build());
        achievements.add(new AchievementBuilder("Icthlarin's Little Helper", 1.5).requirement("Diamond in the Rough", 1)
            .requirement("Gertrude's Cat", 1).requirement("The Restless Ghost", 1).requirement("Tinderbox", 1)
            .requirement("Waterskin (4)", 1).requirement("Coins", 30).requirement("Bucket", 1).encounter(new Encounter("Apmeken"))
            .encounter(new Encounter("Possessed Priest")).reward("Quest points", 2).reward("Thieving", 4500).reward("Agility", 4000)
            .reward("Woodcutting", 4000).build());
        achievements.add(new AchievementBuilder("What's Mine is Yours", 0.75).requirement("Smithing", 5)
            .encounter(new Encounter("Living rock brawler")).encounter(new Encounter("Living rock brawler"))
            .encounter(new Encounter("Living rock brawler")).encounter(new Encounter("Living rock brawler")).reward("Quest points", 1)
            .reward("Mining", 1000).reward("Smithing", 400).reward("Coins", 180).build());
        achievements.add(new AchievementBuilder("Demon Slayer", 0.25).encounter(new Encounter(Collections.singletonList(Arrays.asList(
            "Skeleton (Demon Slayer)", "Skeleton (Demon Slayer)", "Skeleton (Demon Slayer)", "Skeleton (Demon Slayer)",
            "Skeleton (Demon Slayer)", "Skeleton (Demon Slayer)", "Skeleton (Demon Slayer)", "Skeleton (Demon Slayer)",
            "Skeleton (Demon Slayer)", "Skeleton (Demon Slayer)")))).encounter(new Encounter("Delrith")).reward("Quest points", 3)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Magic", "Ranged"), 100, 1)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Magic", "Ranged"), 100, 1)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Magic", "Ranged"), 100, 1).build());
        achievements.add(new AchievementBuilder("The Knight's Sword", 0.25).requirement("Mining", 10).requirement("Iron bar", 2)
            .requirement("Redberry pie", 1).requirement("Iron pickaxe", 0).reward("Quest points", 1).reward("Mining", 42).build());
        achievements.add(new AchievementBuilder("Granny Knows Best", 0.1).requirement("Farming", 17).requirement("Construction", 20)
            .reward("POF bean", 480).reward("Farming", 600).reward("Construction", 600).build());
        achievements.add(new AchievementBuilder("Abyss (miniquest)", 0.25).requirement("Rune Mysteries", 1).reward("Runecrafting", 1000)
            .build());
        achievements.add(new AchievementBuilder("What Lies Below", 0.5).requirement("Rune Mysteries", 1)
            .requirement("Abyss (miniquest)", 1).requirement("Runecrafting", 35).requirement("Bowl", 1).requirement("Chaos rune", 15)
            .encounter(new Encounter("Outlaw")).encounter(new Encounter("Outlaw")).encounter(new Encounter("Outlaw"))
            .encounter(new Encounter("Outlaw")).encounter(new Encounter("Outlaw")).encounter(new Encounter("King Roald"))
            .reward("Quest points", 1).reward("Defence", 2000).reward("Runecrafting", 8000).build());
        achievements.add(new AchievementBuilder("Defender of Varrock", 1).requirement("Demon Slayer", 1).requirement("Family Crest", 1)
            .requirement("Garden of Tranquility", 1).requirement("The Knight's Sword", 1).requirement("Shield of Arrav", 1)
            .requirement("Temple of Ikov", 1).requirement("What Lies Below", 1).requirement("Agility", 51).requirement("Hunter", 51)
            .requirement("Smithing", 54).requirement("Mining", 59).requirement("Spade", 0).encounter(new Encounter(Arrays.asList(
                Collections.singletonList("Armoured zombie"), Collections.singletonList("Armoured zombie"),
                Collections.singletonList("Armoured zombie"), Collections.singletonList("Armoured zombie"),
                Collections.singletonList("Armoured zombie"), Collections.singletonList("Armoured zombie")))).reward("Quest points", 2)
            .reward("Hunter", 15000).reward("Smithing", 10000).reward("Mining", 10000).reward("Defence", 10000).reward("Agility", 2000)
            .lamp(Player.ALL_SKILLS, 1000, 1).build());
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
        achievements.add(new AchievementBuilder("The Tale of the Muspah", 0.75).requirement("Firemaking", 6).requirement("Mining", 8)
            .requirement("Magic", 10).requirement("Woodcutting", 10).requirement("Cosmic rune", 8).requirement("Water rune", 8)
            .reward("Quest points", 1).reward("Magic", 1000).reward("Mining", 800).reward("Woodcutting", 800).reward("Firemaking", 500)
            .build());
        achievements.add(new AchievementBuilder("Troll Romance", 0.75).requirement("Troll Stronghold", 1).requirement("Agility", 28)
            .requirement("Iron bar", 1).requirement("Maple logs", 1).requirement("Rope", 1).requirement("Cake tin", 0)
            .requirement("Swamp tar", 1).encounter(new Encounter("Arrg")).reward("Quest points", 2).reward("Agility", 8000)
            .reward("Strength", 4000).reward("Uncut diamond", 1).reward("Uncut ruby", 2).reward("Uncut emerald", 4).build());
        achievements.add(new AchievementBuilder("The Curse of Arrav", 1).requirement("Defender of Varrock", 1)
            .requirement("Missing My Mummy", 1).requirement("Shades of Mort'ton", 1).requirement("The Tale of the Muspah", 1)
            .requirement("Troll Romance", 1).requirement("Slayer", 37).requirement("Summoning", 41).requirement("Agility", 61)
            .requirement("Ranged", 64).requirement("Strength", 64).requirement("Mining", 64).requirement("Thieving", 66)
            .requirement("Dwellberries", 3).requirement("Sacred oil (1)", 1).requirement("Ring of life", 1)
            .requirement("Mithril grapple", 0).requirement("Insulated boots", 0).requirement("Macaw pouch", 1)
            .encounter(new Encounter("Arrav")).reward("Quest points", 1).reward("Mining", 30000).reward("Thieving", 14000)
            .reward("Ranged", 9000).reward("Agility", 9000).reward("Strength", 9000).reward("Summoning", 4000).reward("Slayer", 2500)
            .build());
        achievements.add(new AchievementBuilder("Hazeel Cult", 0.25).reward("Quest points", 1).reward("Thieving", 1500)
            .reward("Coins", 2005).build());
        achievements.add(new AchievementBuilder("Missing, Presumed Death", 1).encounter(new Encounter(Collections.singletonList(
            Arrays.asList("Wight", "Wight", "Wight", "Wight")))).encounter(new Encounter(Arrays.asList(
            Collections.singletonList("Wight footsoldier"), Arrays.asList("Wight ranger", "Wight ranger"),
            Arrays.asList("Wight footsoldier", "Wight footsoldier", "Wight footsoldier", "Wight footsoldier")))).reward("Quest points", 2)
            .reward("Prayer", 500).reward("Agility", 1000).lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Magic",
                "Ranged"), 1500, 1).build());
        achievements.add(new AchievementBuilder("Fate of the Gods", 2).requirement("Missing, Presumed Death", 1).requirement("Agility", 73)
            .requirement("Summoning", 67).requirement("Divination", 75).requirement("Slayer", 76).requirement("Magic", 79)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Smoke nihil"), Collections.singletonList("Shadow nihil"),
                Collections.singletonList("Blood nihil"), Collections.singletonList("Ice nihil")))).reward("Quest points", 2)
            .reward("Magic", 125000).reward("Divination", 100000).reward("Slayer", 100000).reward("Agility", 75000)
            .reward("Summoning", 50000).build());
        achievements.add(new AchievementBuilder("Meeting History", 0.75).requirement("Making History", 1)
            .requirement("Druidic Ritual", 1).reward("Quest points", 1).lamp(Player.ALL_SKILLS, 1000, 25).lamp(Player.ALL_SKILLS, 1000, 25)
            .lamp(Player.ALL_SKILLS, 500, 25).build());
        achievements.add(new AchievementBuilder("The World Wakes", 2).encounter(new Encounter(Collections.singletonList(Arrays.asList(
            "Automaton Tracer (TWW)", "Automaton Guardian (TWW)", "Automaton Generator (TWW)"))))
            .encounter(new Encounter("Kree'arra (TWW)")).encounter(new Encounter("General Graardor (TWW)"))
            .encounter(new Encounter("Zemouregal")).encounter(new Encounter("K'ril Tsutsaroth (TWW)")).encounter(new Encounter("Enakhra"))
            .reward("Quest points", 3).lamp(Player.ALL_SKILLS, 100000, 75).lamp(Player.ALL_SKILLS, 100000, 75)
            .lamp(Player.ALL_SKILLS, 100000, 75).lamp(Arrays.asList("Attack", "Strength", "Defence", "Ranged", "Magic", "Summoning",
                "Constitution"), 50000, 65).lamp(Arrays.asList("Attack", "Strength", "Defence", "Ranged", "Magic", "Summoning",
                "Constitution"), 50000, 65).lamp(Arrays.asList("Attack", "Strength", "Defence", "Ranged", "Magic", "Summoning",
                "Constitution"), 50000, 65).build());
        achievements.add(new AchievementBuilder("TWW Slayer lamp", 0).requirement("The World Wakes", 1).requirement("Slayer", 70)
            .reward("Slayer", 110000).build());
        achievements.add(new AchievementBuilder("TWW Prayer lamp", 0).requirement("The World Wakes", 1).requirement("Prayer", 80)
            .reward("Prayer", 250000).build());
        achievements.add(new AchievementBuilder("Ernest the Chicken", 0.25).reward("Quest points", 4).reward("Coins", 3000)
            .reward("Egg", 10).reward("Feather", 300).build());
        achievements.add(new AchievementBuilder("Animal Magnetism", 0.75).requirement("Ernest the Chicken", 1)
            .requirement("Priest in Peril", 1).requirement("The Restless Ghost", 1).requirement("Slayer", 18).requirement("Crafting", 19)
            .requirement("Ranged", 30).requirement("Woodcutting", 35).requirement("Mithril hatchet", 1).requirement("Iron bar", 5)
            .requirement("Holy symbol", 1).requirement("Hard leather", 1).reward("Quest points", 1)
            .reward("Crafting", 1050).reward("Fletching", 1000).reward("Slayer", 1000).reward("Woodcutting", 2500).build());
        achievements.add(new AchievementBuilder("Contact!", 0.75).requirement("Icthlarin's Little Helper", 1)
            .encounter(new Encounter("Giant scarab (Contact!)")).reward("Quest points", 1).reward("Thieving", 7000)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Ranged", "Magic", "Summoning"), 7000, 30)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Ranged", "Magic", "Summoning"), 7000, 30).build());
        achievements.add(new AchievementBuilder("Dealing with Scabaras", 1.5).requirement("Contact!", 1).requirement("The Feud", 1)
            .requirement("Zogre Flesh Eaters", 1).requirement("Firemaking", 21).requirement("Agility", 50).requirement("Thieving", 60)
            .requirement("Strength", 60).requirement("Bucket", 0).requirement("Gold seal", 10).requirement("Bronze bar", 18)
            .encounter(new Encounter("Giant scarab")).encounter(new Encounter("Mummy")).encounter(new Encounter("Mummy"))
            .encounter(new Encounter("Mummy")).encounter(new Encounter("Mummy")).reward("Quest points", 1).reward("Agility", 8214)
            .reward("Thieving", 7000).reward("Strength", 7000).reward("Prayer", 7000).build());
        achievements.add(new AchievementBuilder("Shadow of the Storm", 0.75).requirement("Demon Slayer", 1).requirement("The Golem", 1)
            .requirement("Crafting", 30).requirement("Silver bar", 1).requirement("Vial", 0).requirement("Desert shirt", 1)
            .requirement("Desert robe", 1).requirement("Black wizard hat", 0).encounter(new Encounter("Agrith Naar"))
            .reward("Quest points", 1).reward("Sapphire", 2).reward("Emerald", 2).reward("Ruby", 2).lamp(Arrays.asList("Attack", "Strength",
                "Defence", "Constitution", "Ranged", "Magic"), 10000, 1).build());
        achievements.add(new AchievementBuilder("The Grand Tree", 1.5).encounter(new Encounter("Black demon (The Grand Tree)"))
            .reward("Quest points", 5).reward("Agility", 7900).reward("Attack", 18400).reward("Magic", 2150).build());
        achievements.add(new AchievementBuilder("Tree Gnome Village", 0.75).requirement("Logs", 6)
            .encounter(new Encounter("Khazard warlord")).reward("Quest points", 2).reward("Attack", 11450).build());
        achievements.add(new AchievementBuilder("Monkey Madness", 2.5).requirement("The Grand Tree", 1)
            .requirement("Tree Gnome Village", 1).requirement("Gold bar", 1).requirement("Ball of wool", 1).requirement("Banana", 5)
            .encounter(new Encounter("Monkey")).encounter(new Encounter("Jungle demon")).reward("Quest points", 3).reward("Coins", 10000)
            .reward("Diamond", 3).build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Freeing King Awowogei", 1).requirement("Monkey Madness", 1)
            .requirement("Recipe for Disaster: Another Cook's Quest", 1).requirement("Cooking", 70).requirement("Agility", 48)
            .requirement("Coins", 10).encounter(new Encounter("Big Snake")).reward("Quest points", 1).reward("Cooking", 10000)
            .reward("Agility", 10000).build());
        achievements.add(new AchievementBuilder("Smoking Kills", 0.25).requirement("Icthlarin's Little Helper", 1).requirement("Slayer", 35)
            .requirement("Crafting", 25).requirement("Earmuffs", 1).requirement("Face mask", 1).encounter(new Encounter(Arrays.asList(
                Arrays.asList("Skeleton", "Skeleton", "Zombie", "Zombie"), Collections.singletonList("Mummy warrior"),
                Arrays.asList("Skeleton", "Skeleton", "Zombie", "Zombie"), Collections.singletonList("Mummy warrior"))))
            .encounter(new Encounter("Mighty banshee")).encounter(new Encounter("Banshee mistress")).reward("Quest points", 1)
            .reward("Slayer", 5000).build());
        achievements.add(new AchievementBuilder("Do No Evil", 2.5).requirement("Animal Magnetism", 1).requirement("Desert Treasure", 1)
            .requirement("Dealing with Scabaras", 1).requirement("Missing My Mummy", 1).requirement("Shadow of the Storm", 1)
            .requirement("Recipe for Disaster: Freeing King Awowogei", 1).requirement("Smoking Kills", 1).requirement("Ranged", 50)
            .requirement("Construction", 64).requirement("Crafting", 68).requirement("Magic", 70).requirement("Thieving", 70)
            .requirement("Banana", 10).requirement("Teak plank", 6).requirement("Bolt of cloth", 10).requirement("Rope", 3)
            .requirement("Knife", 3).requirement("Desert shirt", 1).requirement("Desert robe", 1).requirement("Desert boots", 1)
            .requirement("Death rune", 40).requirement("Coins", 1000).encounter(new Encounter("Small scarab"))
            .encounter(new Encounter("Leeuni")).encounter(new Encounter("Ayuni"))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Lesser demon"),
                Arrays.asList("Lesser demon", "Lesser demon"),  Arrays.asList("Lesser demon", "Lesser demon", "Lesser demon"),
                Arrays.asList("Lesser demon", "Lesser demon", "Lesser demon", "Lesser demon"), Collections.singletonList("Eruni"))))
            .reward("Quest points", 1).reward("Magic", 50000).reward("Thieving", 50000).reward("Crafting", 40000)
            .reward("Construction", 30000).build());
        achievements.add(new AchievementBuilder("A Fairy Tale III - Battle at Ork's Rift", 1.5).requirement("A Fairy Tale II - Cure a Queen", 1)
            .requirement("Magic", 59).requirement("Farming", 54).requirement("Thieving", 51).requirement("Summoning", 37)
            .requirement("Crafting", 36).encounter(new Encounter(Collections.singletonList(Arrays.asList("Ork warrior", "Ork warrior",
                "Ork warrior", "Ork warrior", "Ork warrior", "Ork warrior", "Ork warrior", "Ork warrior", "General Gromblod",
                "General Shredflesh", "General Bre'egth", "Fairy Godfather")))).reward("Quest points", 2).reward("Farming", 11000)
            .reward("Thieving", 11000).reward("Magic", 11000).reward("Summoning", 1000).reward("Crafting", 1000).build());
        achievements.add(new AchievementBuilder("Impressing the Locals", 0.25).requirement("Coins", 1000).reward("Quest points", 1)
            .build());
        achievements.add(new AchievementBuilder("Tower of Life", 1).requirement("Construction", 10).requirement("Coins", 2)
            .reward("Quest points", 2).reward("Construction", 1000).reward("Crafting", 500).reward("Thieving", 500).build());
        achievements.add(new AchievementBuilder("Monk's Friend", 0.25).requirement("Jug of water", 1).requirement("Logs", 1)
            .reward("Quest points", 1).reward("Law rune", 8).reward("Woodcutting", 2000).build());
        achievements.add(new AchievementBuilder("Watchtower", 1.5).requirement("Herblore", 14).requirement("Magic", 14)
            .requirement("Thieving", 15).requirement("Agility", 25).requirement("Mining", 40).requirement("Coins", 20)
            .requirement("Dragon bones", 1).requirement("Bat bones", 1).requirement("Vial of water", 1).requirement("Rope", 1)
            .requirement("Clean guam", 1).requirement("Gold bar", 1).encounter(new Encounter("Gorad")).reward("Quest points", 4)
            .reward("Magic", 15250).reward("Coins", 5000).build());
        achievements.add(new AchievementBuilder("The Hand in the Sand", 0.75).requirement("Thieving", 17).requirement("Crafting", 49)
            .requirement("Coins", 2).requirement("Bucket", 1).requirement("Lantern lens", 1).requirement("Earth rune", 5)
            .requirement("Vial", 1).requirement("Redberries", 1).requirement("White berries", 1).reward("Quest points", 1)
            .reward("Thieving", 1000).reward("Crafting", 9000).build());
        achievements.add(new AchievementBuilder("Tribal Totem", 0.25).requirement("Thieving", 21).reward("Quest points", 1)
            .reward("Thieving", 1775).reward("Swordfish", 5).build());
        achievements.add(new AchievementBuilder("Back to my Roots", 0.75).requirement("A Fairy Tale I - Growing Pains", 1)
            .requirement("The Hand in the Sand", 1).requirement("One Small Favour", 1).requirement("Tribal Totem", 1)
            .requirement("Agility", 55).requirement("Farming", 53).requirement("Slayer", 59).requirement("Woodcutting", 72)
            .requirement("Plant pot", 1).requirement("Soft clay", 1).requirement("Empty pot", 1).encounter(new Encounter("Wild jade vine"))
            .reward("Quest points", 1).reward("Farming", 24000).reward("Woodcutting", 40000).reward("Slayer", 23000)
            .reward("Agility", 15000).build());
        achievements.add(new AchievementBuilder("In Pyre Need", 0.5).requirement("Firemaking", 55).requirement("Crafting", 52)
            .requirement("Fletching", 53).reward("Quest points", 1).reward("Firemaking", 14400).reward("Fletching", 12500)
            .reward("Crafting", 11556).reward("Phoenix quill", 5).build());
        achievements.add(new AchievementBuilder("The Fremennik Isles", 1.5).requirement("The Fremennik Trials", 1)
            .requirement("Construction", 20).requirement("Crafting", 46).requirement("Agility", 40).requirement("Woodcutting", 56)
            .requirement("Tin ore", 8).requirement("Rope", 8).encounter(new Encounter("Ice troll runt"))
            .encounter(new Encounter("Ice troll runt")).encounter(new Encounter("Ice troll runt"))
            .encounter(new Encounter("Ice troll runt")).encounter(new Encounter("Ice troll runt"))
            .encounter(new Encounter("Ice troll runt")).encounter(new Encounter("Ice troll runt"))
            .encounter(new Encounter("Ice troll runt")).encounter(new Encounter("Ice troll runt"))
            .encounter(new Encounter("Ice troll runt")).encounter(new Encounter("Ice Troll King")).reward("Quest points", 1)
            .reward("Construction", 5000).reward("Crafting", 5000).reward("Woodcutting", 10000).reward("Coins", 14000)
            .reward("Helm of neitiznot", 1).lamp(Arrays.asList("Strength", "Defence", "Attack", "Constitution"), 10000, 1)
            .lamp(Arrays.asList("Strength", "Defence", "Attack", "Constitution"), 10000, 1).build());
        achievements.add(new AchievementBuilder("In Search of the Myreque", 0.25).requirement("Nature Spirit", 1)
            .requirement("Agility", 25).requirement("Steel longsword", 1).requirement("Steel sword", 2).requirement("Steel mace", 1)
            .requirement("Steel warhammer", 1).requirement("Steel dagger", 1).requirement("Steel nails", 75).requirement("Plank", 6)
            .requirement("Mort myre stem", 3).encounter(new Encounter("Skeleton Hellhound")).reward("Quest points", 2)
            .reward("Uncut ruby", 2).reward("Big bones", 4).lamp(Collections.singletonList("Attack"), 600, 4)
            .lamp(Collections.singletonList("Defence"), 600, 4).lamp(Collections.singletonList("Strength"), 600, 4)
            .lamp(Collections.singletonList("Constitution"), 600, 4).lamp(Collections.singletonList("Crafting"), 600, 4).build());
        achievements.add(new AchievementBuilder("In Aid of the Myreque", 1.5).requirement("In Search of the Myreque", 1)
            .requirement("Crafting", 25).requirement("Magic", 7).requirement("Mining", 15).requirement("Sardine", 1)
            .requirement("Bucket", 0).requirement("Plank", 11).requirement("Bronze nails", 44).requirement("Bronze hatchet", 10)
            .requirement("Raw mackerel", 10).requirement("Tinderbox", 3).requirement("Steel bar", 2).requirement("Coal", 1)
            .requirement("Soft clay", 1).requirement("Silver bar", 1).requirement("Mithril bar", 1).requirement("Sapphire", 1)
            .requirement("Cosmic rune", 1).requirement("Water rune", 1).requirement("Rope", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Gadderanks"),
                Arrays.asList("Vampyre Juvinate (In Aid of the Myreque A)", "Vampyre Juvinate (In Aid of the Myreque B)"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Vampyre Juvinate (In Aid of the Myreque C)",
                "Vampyre Juvinate (In Aid of the Myreque C)")))).reward("Quest points", 2)
            .lamp(Collections.singletonList("Attack"), 2000, 12).lamp(Collections.singletonList("Strength"), 2000, 12)
            .lamp(Collections.singletonList("Crafting"), 2000, 12).lamp(Collections.singletonList("Defence"), 2000, 12).build());
        achievements.add(new AchievementBuilder("Darkness of Hallowvale", 2.5).requirement("In Aid of the Myreque", 1)
            .requirement("Construction", 5).requirement("Mining", 20).requirement("Thieving", 22).requirement("Agility", 26)
            .requirement("Crafting", 32).requirement("Magic", 33).requirement("Strength", 40).requirement("Bronze nails", 8)
            .requirement("Plank", 2).reward("Quest points", 2).reward("Agility", 7000).reward("Thieving", 6000).reward("Construction", 2000)
            .lamp(Player.ALL_SKILLS, 2000, 30).lamp(Player.ALL_SKILLS, 2000, 30).lamp(Player.ALL_SKILLS, 2000, 30).build());
        achievements.add(new AchievementBuilder("Legacy of Seergaze", 2).requirement("Darkness of Hallowvale", 1)
            .requirement("Construction", 20).requirement("Agility", 29).requirement("Slayer", 31).requirement("Mining", 35)
            .requirement("Firemaking", 40).requirement("Crafting", 47).requirement("Magic", 49).requirement("Teak pyre logs", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Fistandantilus", "Zaromark Sliver"))))
            .encounter(new Encounter("Vyrewatch")).reward("Quest points", 2).reward("Magic", 3000).reward("Agility", 2000)
            .reward("Crafting", 4000).reward("Mining", 2000).reward("Construction", 1000).reward("Slayer", 2000).reward("Blood talisman", 1)
            .lamp(Player.ALL_SKILLS, 2500, 35).lamp(Player.ALL_SKILLS, 2500, 35).lamp(Player.ALL_SKILLS, 2500, 35).build());
        achievements.add(new AchievementBuilder("Eadgar's Ruse", 1.5).requirement("Druidic Ritual", 1)
            .requirement("Troll Stronghold", 1).requirement("Herblore", 31).requirement("Agility", 15).requirement("Vodka", 1)
            .requirement("Pineapple chunks", 1).requirement("Wheat", 10).requirement("Raw chicken", 5).requirement("Logs", 2)
            .requirement("Ranarr potion (unf)", 1).reward("Quest points", 1).reward("Herblore", 11000).build());
        achievements.add(new AchievementBuilder("Dream Mentor", 0.55).requirement("Lunar Diplomacy", 1)
            .requirement("Eadgar's Ruse", 1).requirement("Astral rune", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("The Inadequacy", "The Everlasting",
                "The Untouchable", "The Illusive")))).reward("Quest points", 2).reward("Magic", 10000).reward("Constitution", 15000)
            .lamp(Arrays.asList("Strength", "Ranged", "Magic", "Constitution", "Defence"), 15000, 1).build());
        achievements.add(new AchievementBuilder("Mountain Daughter", 1).requirement("Agility", 20).requirement("Rope", 0)
            .requirement("Leather gloves", 0).encounter(new Encounter("The Kendal")).reward("Quest points", 2).reward("Prayer", 2000)
            .reward("Attack", 1000).build());
        achievements.add(new AchievementBuilder("Bar Crawl (miniquest)", 0.5).requirement("Coins", 208).build());
        achievements.add(new AchievementBuilder("Horror from the Deep", 0.75).requirement("Bar Crawl (miniquest)", 1)
            .requirement("Agility", 35).requirement("Steel nails", 60).requirement("Molten glass", 1).requirement("Swamp tar", 1)
            .requirement("Tinderbox", 0).requirement("Fire rune", 1).requirement("Earth rune", 1).requirement("Air rune", 1)
            .requirement("Water rune", 1).requirement("Bronze sword", 1).requirement("Bronze arrow", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Dagannoth"), Collections.singletonList("Dagannoth mother"))))
            .reward("Quest points", 2).reward("Magic", 4662).reward("Ranged", 4662).reward("Strength", 4662).build());
        achievements.add(new AchievementBuilder("Rune Memories", 1.5).reward("Quest points", 1).reward("Magic", 300)
            .reward("Runecrafting", 300).build());
        achievements.add(new AchievementBuilder("The Giant Dwarf", 1).requirement("Crafting", 12).requirement("Firemaking", 16)
            .requirement("Magic", 33).requirement("Thieving", 14).requirement("Coins", 10000).requirement("Logs", 1).requirement("Coal", 1)
            .requirement("Iron bar", 1).requirement("Law rune", 1).requirement("Air rune", 1).requirement("Sapphire", 3)
            .requirement("Redberry pie", 1).reward("Quest points", 2).reward("Crafting", 2500).reward("Mining", 2500)
            .reward("Smithing", 2500).reward("Firemaking", 1500).reward("Magic", 1500).reward("Thieving", 1500).build());
        achievements.add(new AchievementBuilder("Fishing Contest", 0.25).requirement("Fishing", 10).requirement("Coins", 5)
            .reward("Quest points", 1).reward("Fishing", 2437).build());
        achievements.add(new AchievementBuilder("Forgettable Tale...", 1.5).requirement("The Giant Dwarf", 1)
            .requirement("Fishing Contest", 1).requirement("Cooking", 22).requirement("Farming", 17).requirement("Coins", 400)
            .requirement("Barley malt", 2).requirement("Bucket of water", 2).requirement("Beer", 4).requirement("Kebab", 1)
            .reward("Quest points", 2).reward("Cooking", 5000).reward("Farming", 5000).reward("Dwarven stout (m)", 2).build());
        achievements.add(new AchievementBuilder("Dwarf Cannon", 0.75).reward("Quest points", 1).reward("Crafting", 750).build());
        achievements.add(new AchievementBuilder("Between a Rock...", 0.75).requirement("Dwarf Cannon", 1).requirement("Fishing Contest", 1)
            .requirement("Defence", 30).requirement("Mining", 40).requirement("Smithing", 50).requirement("Gold bar", 4)
            .requirement("Coins", 50).encounter(new Encounter("Scorpion")).encounter(new Encounter("Arzinian Avatar"))
            .reward("Quest points", 2).reward("Defence", 5000).reward("Mining", 5000).reward("Smithing", 5000).reward("Rune pickaxe", 1)
            .build());
        achievements.add(new AchievementBuilder("Forgiveness of a Chaos Dwarf", 1).requirement("Forgettable Tale...", 1)
            .requirement("Between a Rock...", 1).requirement("Hunter", 61).requirement("Firemaking", 61).requirement("Strength", 69)
            .encounter(new Encounter("Chaos dwarf hand cannoneer")).reward("Quest points", 2).reward("Firemaking", 30000)
            .reward("Hunter", 30000).reward("Strength", 30000).build());
        achievements.add(new AchievementBuilder("My Arm's Big Adventure", 1).requirement("Eadgar's Ruse", 1).requirement("The Feud", 1)
            .requirement("Jungle Potion", 1).requirement("Woodcutting", 10).requirement("Farming", 29).requirement("Coins", 10)
            .requirement("Supercompost", 7).encounter(new Encounter(Arrays.asList(Collections.singletonList("Baby Roc"),
                Collections.singletonList("Giant Roc")))).reward("Quest points", 1).reward("Herblore", 10000).reward("Farming", 5495)
            .build());
        achievements.add(new AchievementBuilder("King of the Dwarves", 1).requirement("Forgiveness of a Chaos Dwarf", 1)
            .requirement("My Arm's Big Adventure", 1).requirement("Mining", 68).requirement("Smithing", 70).requirement("Strength", 77)
            .requirement("Soft clay", 6).requirement("Mithril bar", 6).encounter(new Encounter("Colonel Grimsson (KOD)"))
            .reward("Quest points", 2).reward("Mining", 45000).reward("Smithing", 50000).reward("Strength", 55000).build());
        achievements.add(new AchievementBuilder("Birthright of the Dwarves", 2.5).requirement("King of the Dwarves", 1)
            .requirement("Mining", 80).requirement("Smithing", 82).requirement("Strength", 85).encounter(new Encounter("Chaos dwarf"))
            .encounter(new Encounter("Chaos dwarf")).encounter(new Encounter("Chaos dwarf")).encounter(new Encounter("Red Axe director"))
            .encounter(new Encounter("Red Axe director")).encounter(new Encounter("Red Axe director"))
            .encounter(new Encounter("Red Axe director")).encounter(new Encounter("Red Axe director"))
            .encounter(new Encounter("Red Axe director")).encounter(new Encounter("Red Axe director"))
            .encounter(new Encounter("Ikadia the Exile")).encounter(new Encounter("Colonel Grimsson"))
            .encounter(new Encounter("Chaos Grimsson")).encounter(new Encounter("Chaos Hreidmar")).reward("Quest points", 2)
            .reward("Mining", 100000).reward("Smithing", 100000).reward("Strength", 200000).reward("Mithril bar", 30)
            .reward("Adamant bar", 30).reward("Rune bar", 30).build());
        achievements.add(new AchievementBuilder("Death to the Dorgeshuun", 0.75).requirement("The Lost Tribe", 1)
            .requirement("Thieving", 23).requirement("Agility", 23).requirement("H.A.M. hood", 1).requirement("H.A.M. shirt", 1)
            .requirement("H.A.M. robe", 1).requirement("H.A.M. gloves", 1).requirement("H.A.M. boots", 1).requirement("H.A.M. cloak", 1)
            .requirement("H.A.M. logo", 1).requirement("H.A.M. hood", 0).requirement("H.A.M. shirt", 0).requirement("H.A.M. robe", 0)
            .requirement("H.A.M. gloves", 0).requirement("H.A.M. boots", 0).requirement("H.A.M. cloak", 0).requirement("H.A.M. logo", 0)
            .requirement("Bullseye lantern (oil)", 0)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Sigmund (DttD)", "Guard (DttD)", "Guard (DttD)",
                "Guard (DttD)")))).reward("Quest points", 1).reward("Thieving", 2000).reward("Ranged", 2000).build());
        achievements.add(new AchievementBuilder("Another Slice of H.A.M.", 0.75).requirement("Death to the Dorgeshuun", 1)
            .requirement("The Dig Site", 1).requirement("The Giant Dwarf", 1).requirement("Attack", 15).requirement("Prayer", 25)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("H.A.M Mage", "H.A.M Archer"))))
            .encounter(new Encounter("Sigmund (ASoH)")).reward("Quest points", 1).reward("Mining", 3000).reward("Prayer", 3000).build());
        achievements.add(new AchievementBuilder("Land of the Goblins", 1.5).requirement("Another Slice of H.A.M.", 1)
            .requirement("Fishing Contest", 1).requirement("Prayer", 30).requirement("Agility", 36).requirement("Fishing", 36)
            .requirement("Thieving", 36).requirement("Herblore", 37).requirement("Toadflax potion (unf)", 1).requirement("Goblin mail", 0)
            .requirement("Yellow dye", 1).requirement("Blue dye", 1).requirement("Orange dye", 1).requirement("Purple dye", 1)
            .requirement("Coins", 5).requirement("Slimy eel", 1).encounter(new Encounter(Arrays.asList(
                Collections.singletonList("Snothead"), Collections.singletonList("Snailfeet"), Collections.singletonList("Mosschin"),
                Collections.singletonList("Redeyes"), Collections.singletonList("Strongbones")))).reward("Quest points", 1)
            .reward("Agility", 3000).reward("Herblore", 3000).reward("Thieving", 3000).reward("Fishing", 3000).reward("Strength", 3000)
            .reward("Prayer", 2000).build());
        achievements.add(new AchievementBuilder("The Chosen Commander", 2).requirement("Land of the Goblins", 1).requirement("Agility", 46)
            .requirement("Strength", 46).requirement("Thieving", 46).encounter(new Encounter("H.A.M agent Walton"))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Sigmund (TCC)"), Collections.singletonList("Zanik"),
                Collections.singletonList("Zanik"), Collections.singletonList("Zanik"), Collections.singletonList("Zanik"),
                Collections.singletonList("Zanik")))).encounter(new Encounter(Arrays.asList(Collections.singletonList("Bandos avatar"),
                Collections.singletonList("Ogre statue"), Collections.singletonList("Ork statue"),
                Collections.singletonList("Goblin statue"), Collections.singletonList("Bandos avatar")))).reward("Quest points", 3)
            .reward("Agility", 20000).reward("Strength", 20000).reward("Thieving", 20000).build());
        achievements.add(new AchievementBuilder("The Hunt for Surok (miniquest)", 0.5).requirement("What Lies Below", 1)
            .requirement("Mining", 42).requirement("Chaos talisman", 0).encounter(new Encounter("Bork")).reward("Slayer", 5000)
            .reward("Crimson charm", 7).reward("Green charm", 2).reward("Blue charm", 5).reward("Big bones", 1).reward("Coins", 2000)
            .reward("Emerald", 3).reward("Ruby", 2).build());
        achievements.add(new AchievementBuilder("The Mighty Fall", 2).requirement("Missing, Presumed Death", 1)
            .requirement("The Chosen Commander", 1).requirement("My Arm's Big Adventure", 1)
            .requirement("The Hunt for Surok (miniquest)", 1).requirement("Slayer", 69).requirement("Defence", 72)
            .requirement("Constitution", 78).requirement("Attack", 79).requirement("Strength", 79)
            .encounter(new Encounter("Human infiltrator")).encounter(new Encounter("Human infiltrator"))
            .encounter(new Encounter("Human infiltrator")).encounter(new Encounter("Human infiltrator"))
            .encounter(new Encounter("Human infiltrator")).encounter(new Encounter("Human infiltrator"))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Yelps's bodyguard", "Yelps's bodyguard"),
                Arrays.asList("Yelps's bodyguard", "Yelps's bodyguard"), Arrays.asList("Yelps's bodyguard", "Yelps"))))
            .encounter(new Encounter("Lol")).encounter(new Encounter("General Graardor (TMF)")).reward("Quest points", 2)
            .reward("Attack", 80000).reward("Strength", 80000)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Magic", "Ranged", "Summoning", "Prayer", "Slayer"), 50000,
                69).lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Magic", "Ranged", "Summoning", "Prayer", "Slayer"),
                75000, 79).build());
        achievements.add(new AchievementBuilder("Enakhra's Lament", 0.75).requirement("Crafting", 50).requirement("Firemaking", 45)
            .requirement("Magic", 13).requirement("Granite (5kg)", 2).requirement("Sandstone (10kg)", 5).requirement("Sandstone (2kg)", 1)
            .requirement("Meat pizza", 1).requirement("Air rune", 2).requirement("Fire rune", 1).requirement("White candle", 1)
            .requirement("Logs", 1).requirement("Oak logs", 1).requirement("Willow logs", 1).requirement("Maple logs", 1)
            .requirement("Soft clay", 1).requirement("Coal", 1).reward("Quest points", 2).reward("Crafting", 7000).reward("Mining", 7000)
            .reward("Firemaking", 7000).reward("Magic", 7000).build());
        achievements.add(new AchievementBuilder("Fight Arena", 0.75).requirement("Coins", 5).encounter(new Encounter("Khazard ogre"))
            .encounter(new Encounter("Khazard scorpion")).encounter(new Encounter("Bouncer")).reward("Quest points", 2)
            .reward("Coins", 1000).reward("Attack", 12175).reward("Thieving", 2175).build());
        achievements.add(new AchievementBuilder("A Tail of Two Cats", 1.5).requirement("Icthlarin's Little Helper", 1)
            .requirement("Death rune", 5).requirement("Chocolate cake", 1).requirement("Bucket of milk", 1).requirement("Logs", 1)
            .requirement("Potato seed", 4).requirement("Vial of water", 1).requirement("Desert robe", 1).requirement("Desert shirt", 1)
            .reward("Quest points", 2).lamp(Player.ALL_SKILLS, 2500, 30).lamp(Player.ALL_SKILLS, 2500, 30).build());
        achievements.add(new AchievementBuilder("The Eyes of Glouphrie", 0.75).requirement("The Grand Tree", 1)
            .requirement("Construction", 5).requirement("Magic", 46).requirement("Mud rune", 1).requirement("Maple logs", 1)
            .requirement("Oak logs", 1).reward("Quest points", 2).reward("Herblore", 1).reward("Magic", 12000).reward("Woodcutting", 2500)
            .reward("Runecrafting", 6000).reward("Construction", 250).build());
        achievements.add(new AchievementBuilder("The Path of Glouphrie", 1.5).requirement("Waterfall Quest", 1)
            .requirement("The Eyes of Glouphrie", 1).requirement("Tree Gnome Village", 1).requirement("Strength", 60)
            .requirement("Thieving", 56).requirement("Slayer", 56).requirement("Ranged", 47).requirement("Agility", 45)
            .requirement("Mithril grapple", 0).encounter(new Encounter(Collections.singletonList(Arrays.asList("Warped terrorbird",
                "Warped terrorbird", "Warped terrorbird")))).reward("Quest points", 1).reward("Strength", 30000).reward("Slayer", 20000)
            .reward("Thieving", 5000).reward("Magic", 5000).build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Freeing Evil Dave", 1).requirement("Gertrude's Cat", 1)
            .requirement("Recipe for Disaster: Another Cook's Quest", 1).requirement("Shadow of the Storm", 1).requirement("Cooking", 25)
            .requirement("Stew", 9).reward("Quest points", 1).reward("Cooking", 7000).build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Freeing the Goblin generals", 0.25).requirement("Goblin Diplomacy", 1)
            .requirement("Recipe for Disaster: Another Cook's Quest", 1).requirement("Charcoal", 1).requirement("Spice", 1)
            .requirement("Fishing bait", 1).requirement("Bowl of water", 1).requirement("Bread", 1).requirement("Orange", 1)
            .requirement("Blue dye", 1).reward("Quest points", 1).reward("Cooking", 1000).reward("Farming", 1000).reward("Crafting", 1000)
            .build());
        achievements.add(new AchievementBuilder("Witch's House", 0.25).encounter(new Encounter(Arrays.asList(
            Collections.singletonList("Witch's experiment 1"), Collections.singletonList("Witch's experiment 2"),
            Collections.singletonList("Witch's experiment 3"), Collections.singletonList("Witch's experiment 4"))))
            .reward("Quest points", 4).reward("Constitution", 6325).build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Freeing the Lumbridge Sage", 0.25).requirement("Biohazard", 1)
            .requirement("Recipe for Disaster: Another Cook's Quest", 1).requirement("Big Chompy Bird Hunting", 1)
            .requirement("Demon Slayer", 1).requirement("Murder Mystery", 1).requirement("Nature Spirit", 1).requirement("Witch's House", 1)
            .requirement("Cooking", 40).requirement("Bucket of milk", 1).requirement("Egg", 1).requirement("Pot of flour", 1)
            .requirement("Cake tin", 0).reward("Quest points", 1).reward("Cooking", 2500).reward("Magic", 2500).build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Freeing the Mountain dwarf", 0.25).requirement("Fishing Contest", 1)
            .requirement("Recipe for Disaster: Another Cook's Quest", 1).requirement("Coins", 304).requirement("Pot of flour", 1)
            .requirement("Egg", 1).requirement("Bucket of milk", 1).requirement("Bowl of water", 1).requirement("Leather gloves", 0)
            .requirement("Asgarnian ale", 5).reward("Quest points", 1).reward("Cooking", 1000).reward("Slayer", 1000).build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Freeing Skrach Uglogwee", 0.75)
            .requirement("Big Chompy Bird Hunting", 1).requirement("Recipe for Disaster: Another Cook's Quest", 1)
            .requirement("Cooking", 41).requirement("Firemaking", 20).requirement("Bronze hatchet", 0).requirement("Raw chompy", 1)
            .requirement("Ball of wool", 1).requirement("Iron spit", 1).requirement("Logs", 1).requirement("Ogre arrow", 1)
            .reward("Quest points", 1).reward("Woodcutting", 1500).reward("Cooking", 1500).reward("Crafting", 1500).reward("Ranged", 1500)
            .build());
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
        achievements.add(new AchievementBuilder("Wolf Whistle", 0.5).reward("Quest points", 1).reward("Summoning", 276)
            .reward("Gold charm", 275).build());
        achievements.add(new AchievementBuilder("Dimension of Disaster: Coin of the Realm", 0.25).requirement("Coins", 1)
            .reward("Quest points", 1).build());
        achievements.add(new AchievementBuilder("Dimension of Disaster: Shield of Arrav", 0.25).requirement("Shield of Arrav", 1)
            .requirement("Dimension of Disaster: Coin of the Realm", 1).reward("Quest points", 1).reward("Thieving", 100).build());
        achievements.add(new AchievementBuilder("Dimension of Disaster: Demon Slayer", 0.75).requirement("Shadow of the Storm", 1)
            .requirement("Dimension of Disaster: Coin of the Realm", 1).reward("Quest points", 3).reward("Crafting", 5000)
            .reward("Magic", 5000).build());
        achievements.add(new AchievementBuilder("Dimension of Disaster: Defender of Varrock", 0.75).requirement("Defender of Varrock", 1)
            .requirement("Dimension of Disaster: Coin of the Realm", 1).reward("Quest points", 2).reward("Thieving", 10000)
            .reward("Magic", 10000).reward("Defence", 10000).reward("Construction", 2000).lamp(Arrays.asList("Attack", "Strength",
                "Defence", "Magic", "Ranged"), 15000, 1).build());
        achievements.add(new AchievementBuilder("Dimension of Disaster: Curse of Arrav", 0.75).requirement("The Curse of Arrav", 1)
            .requirement("Dimension of Disaster: Coin of the Realm", 1).requirement("Dimension of Disaster: Shield of Arrav", 1)
            .requirement("Dimension of Disaster: Demon Slayer", 1).requirement("Dimension of Disaster: Defender of Varrock", 1)
            .requirement("Agility", 61).requirement("Strength", 64).requirement("Ranged", 64).reward("Quest points", 3)
            .reward("Thieving", 14000).reward("Ranged", 9000).reward("Agility", 9000).reward("Crafting", 9000).reward("Farming", 4000)
            .reward("Magic", 2500).lamp(Arrays.asList("Attack", "Strength", "Defence", "Magic", "Ranged"), 30000, 1).build());
        achievements.add(new AchievementBuilder("Kindred Spirits", 1.5).requirement("Missing, Presumed Death", 1)
            .requirement("Agility", 60).requirement("Crafting", 60).requirement("Herblore", 60).requirement("Smithing", 60)
            .reward("Quest points", 1).reward("Herblore", 25000).reward("Crafting", 25000).reward("Smithing", 25000)
            .reward("Agility", 25000).build());
        achievements.add(new AchievementBuilder("All Fired Up", 0.5).requirement("Priest in Peril", 1).requirement("Firemaking", 43)
            .requirement("Logs", 45).reward("Quest points", 1).reward("Coins", 20000).reward("Firemaking", 5500).build());
        achievements.add(new AchievementBuilder("Rag and Bone Man", 1).requirement("Coins", 40).requirement("Empty pot", 8)
            .requirement("Logs", 8).requirement("Rope", 1).encounter(new Encounter("Goblin")).encounter(new Encounter("Big frog"))
            .encounter(new Encounter("Black bear")).encounter(new Encounter("Ram")).encounter(new Encounter("Unicorn"))
            .encounter(new Encounter("Monkey")).encounter(new Encounter("Giant rat")).encounter(new Encounter("Giant bat"))
            .reward("Quest points", 2).reward("Cooking", 500).reward("Prayer", 500).build());
        achievements.add(new AchievementBuilder("Fur 'n Seek", 0.75).requirement("Rag and Bone Man", 1).requirement("Slayer", 25)
            .requirement("Bag of salt", 9).requirement("Logs", 8).encounter(new Encounter("Rock crab"))
            .encounter(new Encounter("Fenris wolf")).encounter(new Encounter("Fox")).encounter(new Encounter("Hobgoblin"))
            .encounter(new Encounter("Cockatrice")).encounter(new Encounter("Cave crawler")).encounter(new Encounter("Grizzly bear"))
            .encounter(new Encounter("Black unicorn")).encounter(new Encounter("Unicorn")).reward("Quest points", 2)
            .reward("Constitution", 2500).reward("Slayer", 2500).reward("Prayer", 1500).reward("Crafting", 500).reward("Firemaking", 500)
            .build());
        achievements.add(new AchievementBuilder("Buyers and Cellars", 0.5).requirement("Thieving", 5).reward("Quest points", 1)
            .reward("Thieving", 525).build());
        achievements.add(new AchievementBuilder("Myths of the White Lands", 0.75).reward("Quest points", 2).reward("Coins", 5000)
            .lamp(Player.ALL_SKILLS, 500, 1).build());
        achievements.add(new AchievementBuilder("Broken Home", 1).reward("Quest points", 1).lamp(Player.ALL_SKILLS, -1, 1).build());
        achievements.add(new AchievementBuilder("The Firemaker's Curse", 2.5).requirement("Firemaking", 74).requirement("Constitution", 76)
            .requirement("Agility", 64).reward("Quest points", 2).reward("Firemaking", 80000).reward("Agility", 30000)
            .reward("Constitution", 76000).build());
        achievements.add(new AchievementBuilder("The Blood Pact", 0.25).encounter(new Encounter("Kayle"))
            .encounter(new Encounter("Caitlin")).encounter(new Encounter("Reese")).reward("Quest points", 1).reward("Attack", 100)
            .reward("Strength", 100).reward("Defence", 100).reward("Ranged", 100).reward("Magic", 100).build());
        achievements.add(new AchievementBuilder("Deadliest Catch", 0.5).requirement("Druidic Ritual", 1)
            .requirement("Tower of Life", 1).requirement("Hunter", 67).requirement("Fishing", 70).requirement("Thieving", 70)
            .reward("Quest points", 1).reward("Fishing", 70000).reward("Hunter", 26000).reward("Thieving", 8000).build());
        achievements.add(new AchievementBuilder("The Prisoner of Glouphrie", 0.75).requirement("The Path of Glouphrie", 1)
            .requirement("Roving Elves", 1).requirement("Agility", 64).requirement("Construction", 62).requirement("Thieving", 64)
            .requirement("Runecrafting", 61).reward("Quest points", 1).reward("Thieving", 60000).reward("Agility", 60000)
            .reward("Construction", 50000).reward("Runecrafting", 45000).build());
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
            .reward("Agility", 30000).lamp(Arrays.asList("Attack", "Strength", "Defence", "Magic", "Ranged"), 100000, 75).build());
        achievements.add(new AchievementBuilder("One of a Kind", 2).requirement("A Tail of Two Cats", 1)
            .requirement("The World Wakes", 1).requirement("King's Ransom", 1).requirement("Missing, Presumed Death", 1)
            .requirement("Divination", 40).requirement("Dungeoneering", 67).requirement("Summoning", 74).requirement("Magic", 81)
            .requirement("Emerald", 1).requirement("Coins", 875).encounter(new Encounter("Iron dragon"))
            .encounter(new Encounter("Iron dragon")).encounter(new Encounter("Iron dragon"))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Dragon-hunter warrior", "Dragon-hunter mage",
                "Dragon-hunter archer")))).encounter(new Encounter("Echo of Jas")).reward("Quest points", 1).reward("Magic", 90000)
            .reward("Summoning", 80000).reward("Dungeoneering", 45000).reward("Divination", 5000).build());
        achievements.add(new AchievementBuilder("Rat Catchers", 1.5).requirement("Icthlarin's Little Helper", 1)
            .requirement("Cheese", 4).requirement("Unicorn horn dust", 1).requirement("Clean marrentill", 1)
            .requirement("Bucket of milk", 10).requirement("Empty pot", 1).requirement("Coins", 600).reward("Quest points", 2)
            .reward("Farming", 4).reward("Thieving", 4500).build());
        achievements.add(new AchievementBuilder("Knight Waves training ground", 0).requirement("King's Ransom", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Knight Waves knight"),
                Collections.singletonList("Knight Waves knight"), Collections.singletonList("Knight Waves knight"),
                Collections.singletonList("Knight Waves knight"), Collections.singletonList("Knight Waves knight"),
                Collections.singletonList("Knight Waves knight"), Collections.singletonList("Knight Waves knight"),
                Collections.singletonList("Knight Waves knight")))).reward("Attack", 20000).reward("Strength", 20000).reward("Defence", 20000)
            .reward("Constitution", 20000).reward("Ranged", 20000).reward("Magic", 20000).build());
        achievements.add(new AchievementBuilder("Nomad's Requiem", 0.85).requirement("King's Ransom", 1)
            .requirement("Knight Waves training ground", 1).requirement("Magic", 75).requirement("Prayer", 70).requirement("Mining", 66)
            .requirement("Hunter", 65).requirement("Constitution", 60).encounter(new Encounter("Decaying avatar"))
            .encounter(new Encounter("Nomad")).reward("Quest points", 3).reward("Zeal", 70).build());
        achievements.add(new AchievementBuilder("Scorpion Catcher", 0.25).requirement("Bar Crawl (miniquest)", 1).requirement("Prayer", 31)
            .encounter(new Encounter("Jailer")).reward("Quest points", 1).reward("Strength", 6625).build());
        achievements.add(new AchievementBuilder("Ghosts Ahoy", 0.25).requirement("Priest in Peril", 1)
            .requirement("The Restless Ghost", 1).requirement("Agility", 25).requirement("Cooking", 20).requirement("Coins", 1000)
            .requirement("Thread", 1).requirement("Silk", 1).requirement("Spade", 0).requirement("Oak shieldbow", 1)
            .requirement("Bucket of milk", 1).requirement("Red dye", 1).requirement("Blue dye", 1).requirement("Yellow dye", 1)
            .requirement("Bowl of water", 1).encounter(new Encounter("Giant lobster")).reward("Cooking", 52).reward("Quest points", 2)
            .reward("Prayer", 2400).build());
        achievements.add(new AchievementBuilder("Haunted Mine", 1.5).requirement("Priest in Peril", 1)
            .requirement("Nature Spirit", 1).requirement("Agility", 15).requirement("Crafting", 35).encounter(new Encounter("Treus Dayth"))
            .reward("Quest points", 2).lamp(Collections.singletonList("Strength"), 22000, 35).build());
        achievements.add(new AchievementBuilder("Spirits of the Elid", 0.75).requirement("Magic", 33).requirement("Ranged", 37)
            .requirement("Mining", 37).requirement("Thieving", 37).requirement("Law rune", 1).requirement("Air rune", 1)
            .requirement("Rope", 1).encounter(new Encounter("White golem")).encounter(new Encounter("Black golem"))
            .encounter(new Encounter("Grey golem")).reward("Quest points", 2).reward("Prayer", 8000).reward("Thieving", 1000)
            .reward("Magic", 1000).build());
        achievements.add(new AchievementBuilder("Crocodile Tears", 0.5).requirement("Dealing with Scabaras", 1)
            .requirement("The Jack of Spades", 1).requirement("Missing My Mummy", 1).requirement("Spirits of the Elid", 1)
            .requirement("Menaphos reputation", 19800).requirement("Hunter", 73).requirement("Fishing", 72).requirement("Woodcutting", 47)
            .requirement("Agility", 30).requirement("Rope", 1).requirement("Fishing bait", 1).requirement("Coins", 21000)
            .encounter(new Encounter("Ukunduka")).reward("Fishing", 35092).reward("Menaphos reputation", 5754).reward("Woodcutting", 15094)
            .reward("Agility", 19856).reward("Hunter", 39080).reward("Quest points", 1).build());
        achievements.add(new AchievementBuilder("Tai Bwo Wannai Trio", 1.5).requirement("Jungle Potion", 1).requirement("Fishing", 5)
            .requirement("Agility", 15).requirement("Cooking", 30).requirement("Agility potion (4)", 1).requirement("Iron spear", 1)
            .requirement("Raw karambwan", 2).requirement("Coins", 30).requirement("Jogre bones", 1).encounter(new Encounter("Monkey"))
            .reward("Quest points", 2).reward("Coins", 2000).reward("Fishing", 1500).build());
        achievements.add(new AchievementBuilder("The Elemental Workshop I", 0.25).requirement("Mining", 20).requirement("Smithing", 20)
            .requirement("Crafting", 20).requirement("Thread", 1).requirement("Coal", 1).encounter(new Encounter("Earth elemental"))
            .reward("Quest points", 1).reward("Smithing", 5000).reward("Crafting", 5000).reward("Elemental shield", 1).build());
        achievements.add(new AchievementBuilder("The Elemental Workshop II", 0.75).requirement("The Elemental Workshop I", 1)
            .requirement("Magic", 20).requirement("Smithing", 30).requirement("Coal", 8).encounter(new Encounter("Earth elemental"))
            .encounter(new Encounter("Earth elemental")).reward("Quest points", 1).reward("Smithing", 7500).reward("Crafting", 7500)
            .build());
        achievements.add(new AchievementBuilder("The Elemental Workshop III", 1).requirement("The Elemental Workshop II", 1)
            .requirement("Defence", 33).requirement("Mining", 20).requirement("Smithing", 33).requirement("Coal", 12)
            .requirement("Soft clay", 1).encounter(new Encounter("Earth elemental")).encounter(new Encounter("Earth elemental"))
            .encounter(new Encounter("Earth elemental")).reward("Quest points", 1).reward("Smithing", 8500).reward("Defence", 8500)
            .reward("Coal", 50).build());
        achievements.add(new AchievementBuilder("The Elemental Workshop IV", 1.5).requirement("The Elemental Workshop III", 1)
            .requirement("Crafting", 41).requirement("Runecrafting", 39).requirement("Thieving", 39).requirement("Defence", 40)
            .requirement("Smithing", 42).requirement("Air rune", 5).requirement("Earth rune", 5).requirement("Fire rune", 5)
            .requirement("Water rune", 5).requirement("Coal", 8).encounter(new Encounter("Earth elemental"))
            .encounter(new Encounter("Earth elemental")).reward("Quest points", 2).reward("Crafting", 9000).reward("Runecrafting", 7500)
            .reward("Coal", 50).build());
        achievements.add(new AchievementBuilder("As A First Resort", 1.5).requirement("Zogre Flesh Eaters", 1)
            .requirement("Hunter", 48).requirement("Firemaking", 51).requirement("Woodcutting", 58).requirement("Eucalyptus logs", 26)
            .requirement("Achey tree logs", 8).requirement("Bronze spear", 4).requirement("Raw chompy", 2).requirement("Stripy feather", 8)
            .requirement("Tatty larupia fur", 8).requirement("Wolf bones", 4).requirement("Logs", 1).requirement("Box trap", 0)
            .requirement("Bird snare", 0).reward("Quest points", 1).reward("Firemaking", 15000).reward("Hunter", 15000)
            .reward("Woodcutting", 15000).build());
        achievements.add(new AchievementBuilder("Eagles' Peak", 0.75).requirement("Hunter", 27).requirement("Swamp tar", 1)
            .requirement("Coins", 50).requirement("Yellow dye", 1).encounter(new Encounter("Kebbit")).reward("Quest points", 2)
            .reward("Hunter", 2500).build());
        achievements.add(new AchievementBuilder("Beneath Cursed Tides", 0.75).requirement("Attack", 30).requirement("Strength", 30)
            .requirement("Magic", 30).requirement("Mining", 30).requirement("Smithing", 30).requirement("Woodcutting", 30)
            .requirement("Firemaking", 30).requirement("Cooking", 30).reward("Quest points", 1).reward("Cooking", 5000)
            .reward("Fishing", 5000).lamp(Arrays.asList("Attack", "Constitution", "Strength", "Defence", "Ranged", "Prayer", "Magic",
                "Herblore", "Slayer", "Summoning"), 10000, 10).build());
        achievements.add(new AchievementBuilder("The Brink of Extinction", 1).requirement("The Elder Kiln", 1).requirement("Defence", 80)
            .requirement("Smithing", 80).requirement("Mining", 72).requirement("Rune pickaxe", 0)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("TokHaar-Hur", "TokHaar-Xil", "TokHaar-Ket Champion"))))
            .encounter(new Encounter("TokHaar-Hok")).reward("Quest points", 3).reward("Mining", 100000).lamp(Arrays.asList("Attack",
                "Strength", "Defence", "Ranged", "Magic"), 275000, 80).build());
        achievements.add(new AchievementBuilder("Observatory Quest", 0.75).requirement("Plank", 3).requirement("Bronze bar", 1)
            .requirement("Molten glass", 1).reward("Quest points", 2).reward("Crafting", 2250).build());
        achievements.add(new AchievementBuilder("Song from the Depths", 0.5).reward("Quest points", 1).reward("Constitution", 700)
            .build());
        achievements.add(new AchievementBuilder("Gunnar's Ground", 0.5).requirement("Crafting", 5).reward("Quest points", 5)
            .reward("Crafting", 425).lamp(Player.ALL_SKILLS, 200, 5).build());
        achievements.add(new AchievementBuilder("Let Them Eat Pie", 0.5).reward("Quest points", 1).reward("Cooking", 100)
            .reward("Thieving", 150).reward("Meat pie", 5).build());
        achievements.add(new AchievementBuilder("You Are It", 0.25).requirement("Rope", 1).reward("Quest points", 1).build());
        achievements.add(new AchievementBuilder("Vampyre Slayer", 0.25).requirement("Coins", 2).encounter(new Encounter("Count Draynor"))
            .reward("Quest points", 3).lamp(Arrays.asList("Attack", "Strength", "Defence", "Ranged", "Magic", "Constitution"), 4825, 1)
            .build());
        achievements.add(new AchievementBuilder("Clock Tower", 0.25).reward("Quest points", 1).reward("Coins", 500).build());
        achievements.add(new AchievementBuilder("Dishonour among Thieves", 1.5).requirement("Hazeel Cult", 1)
            .requirement("Missing, Presumed Death", 1).requirement("Agility", 30).requirement("Thieving", 30)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Armoured zombie"),
                Collections.singletonList("Armoured zombie"), Collections.singletonList("Armoured zombie"),
                Collections.singletonList("Armoured zombie"), Collections.singletonList("Armoured zombie"),
                Collections.singletonList("Armoured zombie")))).encounter(new Encounter("Foreshadow")).reward("Quest points", 2)
            .reward("Thieving", 1500).reward("Agility", 1500).reward("Dungeoneering", 500).lamp(Arrays.asList("Attack", "Strength",
                "Defence", "Magic", "Ranged", "Constitution"), 1500, 1).build());
        achievements.add(new AchievementBuilder("Our Man in the North", 0.5).requirement("Do No Evil", 1).requirement("Crocodile Tears", 1)
            .requirement("Menaphos reputation", 99000).encounter(new Encounter("Ambassador Jabari")).reward("Quest points", 1)
            .reward("Menaphos reputation", 5500).build());
        achievements.add(new AchievementBuilder("'Phite Club", 0.25).requirement("Our Man in the North", 1)
            .requirement("Menaphos reputation", 254100).encounter(new Encounter(Collections.singletonList(
                Arrays.asList("Menaphite palace guard (melee)", "Menaphite palace guard (melee)", "Menaphite palace guard (magic)",
                    "Menaphite palace guard (magic)")))).encounter(new Encounter("Pharaoh")).reward("Quest points", 1)
            .reward("Menaphos reputation", 7500).build());
        achievements.add(new AchievementBuilder("Call of the Ancestors", 0.75).reward("Quest points", 1)
            .lamp(Collections.singletonList("Magic"), 1000, 10).build());
        achievements.add(new AchievementBuilder("Perils of Ice Mountain", 0.75).requirement("Farming", 5).requirement("Hunter", 5)
            .requirement("Thieving", 5).requirement("Watering can", 0).requirement("Compost", 1).requirement("Plank", 2)
            .requirement("Bronze nails", 2).reward("Quest points", 1).reward("Farming", 500).reward("Hunter", 500).reward("Thieving", 500)
            .build());
        achievements.add(new AchievementBuilder("The Needle Skips", 0.25).reward("Quest points", 1).lamp(Player.ALL_SKILLS, -1, 1).build());
        achievements.add(new AchievementBuilder("Desperate Times", 0.75).requirement("The Needle Skips", 1).requirement("You Are It", 1)
            .requirement("Mining", 50).requirement("Smithing", 50).requirement("Divination", 50).requirement("Rune bar", 3)
            .requirement("Runite stone spirit", 2).requirement("Mind rune", 10).requirement("Gleaming energy", 10).reward("Quest points", 3)
            .lamp(Player.ALL_SKILLS, -8, 1).build());
        achievements.add(new AchievementBuilder("Violet is Blue", 0.75).reward("Quest points", 1).reward("Construction", 24)
            .lamp(Player.ALL_SKILLS, 1000, 1).lamp(Player.ALL_SKILLS, 1000, 1).lamp(Player.ALL_SKILLS, 1000, 1).build());
        achievements.add(new AchievementBuilder("Imp Catcher", 0.25).requirement("Bowl of hot water", 1)
            .encounter(new Encounter("Choleric imp", 1)).reward("Quest points", 1).reward("Magic", 875).reward("Amulet of accuracy", 1)
            .build());
        achievements.add(new AchievementBuilder("A Shadow over Ashdale", 0.75).reward("Quest points", 1).reward("Attack", 300)
            .reward("Strength", 300).reward("Defence", 300).reward("Constitution", 300).lamp(Player.ALL_SKILLS, -4, 1)
            .lamp(Player.ALL_SKILLS, -4, 1).lamp(Player.ALL_SKILLS, -4, 1).build());
        achievements.add(new AchievementBuilder("Grim Tales", 0.75).requirement("Witch's House", 1).requirement("Farming", 45)
            .requirement("Herblore", 52).requirement("Thieving", 58).requirement("Agility", 59).requirement("Woodcutting", 71)
            .requirement("Vial of water", 2).requirement("Clean tarromin", 2).requirement("Leather gloves", 1)
            .requirement("Watering can", 1).encounter(new Encounter("Glod")).reward("Quest points", 1).reward("Farming", 4000)
            .reward("Herblore", 5000).reward("Constitution", 5000).reward("Woodcutting", 14000).reward("Agility", 6000)
            .reward("Thieving", 6000).build());
        achievements.add(new AchievementBuilder("TokTz-Ket-Dill", 2).requirement("Attack", 50).requirement("Construction", 50)
            .requirement("Crafting", 43).requirement("Mining", 41).requirement("Strength", 45).requirement("Rune pickaxe", 0)
            .requirement("Oak plank", 16).encounter(new Encounter(Collections.singletonList(Arrays.asList("Fire monster",
                "Fire monster")))).encounter(new Encounter(Collections.singletonList(Arrays.asList("Lava monster (TTKD)",
                "Lava monster (TTKD)")))).encounter(new Encounter("TokTz-Ket-Dill (TTKD)")).reward("Quest points", 1)
            .reward("Attack", 5000).reward("Strength", 5000).reward("Crafting", 10000).reward("Mining", 15000).reward("Construction", 20000)
            .build());
        achievements.add(new AchievementBuilder("Olaf's Quest", 0.5).requirement("The Fremennik Trials", 1).requirement("Firemaking", 40)
            .requirement("Woodcutting", 50).encounter(new Encounter("Skeleton fremennik")).encounter(new Encounter("Ulfric"))
            .reward("Quest points", 1).reward("Defence", 12000).reward("Coins", 20000).reward("Ruby", 4).build());
        achievements.add(new AchievementBuilder("Evil Dave's Big Day Out", 0.75).requirement("Recipe for Disaster: Freeing Evil Dave", 1)
            .requirement("Agility", 30).requirement("Cooking", 30).requirement("Herblore", 30).requirement("Magic", 30)
            .reward("Quest points", 2).reward("Magic", 50000).reward("Herblore", 20000).reward("Agility", 20000).reward("Cooking", 20000)
            .build());
        achievements.add(new AchievementBuilder("The Death of Chivalry", 1.5).encounter(new Encounter(Collections.singletonList(
            Arrays.asList("Black Knight", "Black Knight", "Black Knight")))).encounter(new Encounter("Fern"))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Sir Owen", "Black Knight", "Black Knight"))))
            .encounter(new Encounter("Dawn")).reward("Quest points", 3).reward("Magic", 250).reward("Strength", 250).reward("Coins", 500)
            .reward("Prayer", 250).lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Magic", "Ranged"), 500, 1).build());
        achievements.add(new AchievementBuilder("Cold War", 1.5).requirement("Hunter", 10).requirement("Construction", 34)
            .requirement("Crafting", 30).requirement("Agility", 30).requirement("Thieving", 15).requirement("Oak plank", 10)
            .requirement("Steel nails", 10).requirement("Plank", 1).requirement("Mahogany plank", 1).requirement("Silk", 1)
            .requirement("Clockwork", 1).requirement("Swamp tar", 1).requirement("Feather", 5).requirement("Leather", 1)
            .requirement("Raw cod", 1).encounter(new Encounter(Collections.singletonList(Arrays.asList("Icelord", "Icelord"))))
            .reward("Quest points", 1).reward("Crafting", 2000).reward("Agility", 5000).reward("Construction", 1500).build());
        achievements.add(new AchievementBuilder("Hunt for Red Raktuber", 1.5).requirement("Cold War", 1).requirement("Sea Slug", 1)
            .requirement("Thieving", 38).requirement("Construction", 45).requirement("Hunter", 45).requirement("Silk", 8)
            .requirement("Plank", 4).requirement("Thread", 1).reward("Quest points", 1).reward("Construction", 3000)
            .reward("Thieving", 2000).reward("Hunter", 1500).build());
        achievements.add(new AchievementBuilder("Some Like It Cold", 2).requirement("Hunt for Red Raktuber", 1).requirement("Fishing", 65)
            .requirement("Crafting", 56).requirement("Construction", 50).requirement("Thieving", 50).reward("Quest points", 1)
            .reward("Crafting", 40000).reward("Fishing", 40000).reward("Construction", 10000).reward("Thieving", 10000).build());
        achievements.add(new AchievementBuilder("Back to the Freezer", 1).requirement("Ernest the Chicken", 1)
            .requirement("Some Like It Cold", 1).requirement("Slayer", 37).requirement("Runecrafting", 45).requirement("Divination", 50)
            .requirement("Insulated boots", 0).requirement("Coins", 1).requirement("Flickering energy", 50).requirement("Bright energy", 50)
            .requirement("Sparkling energy", 50).requirement("Gleaming energy", 50).encounter(new Encounter("Killerwatt"))
            .encounter(new Encounter("Killerwatt")).encounter(new Encounter("Killerwatt")).encounter(new Encounter("Killerwatt"))
            .encounter(new Encounter("Killerwatt")).encounter(new Encounter("Killerwatt")).encounter(new Encounter("Killerwatt"))
            .encounter(new Encounter("Killerwatt")).encounter(new Encounter("Killerwatt")).encounter(new Encounter("Killerwatt"))
            .reward("Quest points", 1).reward("Divination", 25000).reward("Runecrafting", 25000).reward("Slayer", 15000)
            .reward("Agility", 15000).lamp(Player.ALL_SKILLS, 500, 1).build());
        achievements.add(new AchievementBuilder("A Soul's Bane", 0.5).encounter(new Encounter(Arrays.asList(
            Collections.singletonList("Fear reaper"), Collections.singletonList("Fear reaper"), Collections.singletonList("Fear reaper"),
            Collections.singletonList("Fear reaper"), Collections.singletonList("Fear reaper")))).encounter(new Encounter(Arrays.asList(
            Collections.singletonList("Confusion beast"), Collections.singletonList("Confusion beast"),
            Collections.singletonList("Confusion beast"), Collections.singletonList("Confusion beast"),
            Collections.singletonList("Confusion beast")))).encounter(new Encounter(Arrays.asList(
            Collections.singletonList("Hopeless creature"), Collections.singletonList("Hopeless creature"),
            Collections.singletonList("Hopeless creature"), Collections.singletonList("Hopeless creature"),
            Collections.singletonList("Hopeless creature")))).encounter(new Encounter(Collections.singletonList(Arrays.asList("Tolna",
            "Tolna", "Tolna")))).reward("Quest points", 1).reward("Defence", 500).reward("Constitution", 500).build());
        achievements.add(new AchievementBuilder("Barbarian Smithing", 0.05).requirement("Tai Bwo Wannai Trio", 1).requirement("Smithing", 5)
            .requirement("Bronze bar", 2).requirement("Logs", 2).reward("Bronze spear", 1).reward("Bronze hasta", 1).reward("Smithing", 50)
            .build());
        achievements.add(new AchievementBuilder("Barbarian Firemaking", 0).requirement("Firemaking", 35).build());
        achievements.add(new AchievementBuilder("Barbarian Fishing", 0.05).requirement("Barbarian Firemaking", 1)
            .requirement("Fishing", 55).requirement("Strength", 35).requirement("Agility", 15).build());
        achievements.add(new AchievementBuilder("Barbarian Herblore", 0).requirement("Barbarian Fishing", 1).requirement("Herblore", 4)
            .requirement("Attack potion (2)", 1).requirement("Roe", 1).reward("Attack mix (2)", 1).reward("Herblore", 8).build());
        achievements.add(new AchievementBuilder("Barbarian Training", 0).requirement("Barbarian Smithing", 1)
            .requirement("Barbarian Firemaking", 1).requirement("Barbarian Fishing", 1).requirement("Barbarian Herblore", 1).build());
        achievements.add(new AchievementBuilder("Hero's Welcome", 1).requirement("Lunar Diplomacy", 1).requirement("Tai Bwo Wannai Trio", 1)
            .requirement("Divination", 60).requirement("Mining", 67).requirement("Slayer", 62).requirement("Smithing", 67)
            .requirement("Barbarian Training", 1).requirement("Soft clay", 1).requirement("Mithril bar", 1).requirement("Coins", 875)
            .encounter(new Encounter("Adamant dragon")).encounter(new Encounter("Tarshak")).encounter(new Encounter("Abomination"))
            .reward("Quest points", 2).reward("Smithing", 10000).reward("Mining", 10000).reward("Slayer", 10000).reward("Divination", 10000)
            .build());
        achievements.add(new AchievementBuilder("Rune Mechanics", 0.25).requirement("Magic", 27).requirement("Runecrafting", 20)
            .requirement("Construction", 25).requirement("Steam rune", 4).requirement("Fire rune", 1).requirement("Mind rune", 5)
            .requirement("Body rune", 5).requirement("Emerald", 2).requirement("Cosmic rune", 2).reward("Air rune", 6)
            .requirement("Pure essence", 21).reward("Quest points", 1).reward("Construction", 900).reward("Magic", 2374)
            .reward("Runecrafting", 1850).reward("Water talisman", 1).build());
        achievements.add(new AchievementBuilder("Pieces of Hate", 1.5).requirement("Gertrude's Cat", 1)
            .requirement("A Clockwork Syringe", 1).requirement("Construction", 81).requirement("Firemaking", 82).requirement("Agility", 83)
            .requirement("Thieving", 85).requirement("Leather", 2).requirement("Gold bar", 1).requirement("Blurberry Special", 1)
            .requirement("Drunk Dragon", 1).requirement("Chocolate Saturday", 1).reward("Quest points", 2).reward("Agility", 50000)
            .reward("Construction", 50000).reward("Firemaking", 50000).reward("Thieving", 50000).lamp(Player.ALL_SKILLS, -2, 1)
            .lamp(Player.ALL_SKILLS, -2, 1).lamp(Player.ALL_SKILLS, -2, 1).lamp(Player.ALL_SKILLS, -2, 1).lamp(Player.ALL_SKILLS, -2, 1)
            .build());
        achievements.add(new AchievementBuilder("Curse of the Black Stone", 1.5).requirement("Impressing the Locals", 1)
            .requirement("Agility", 12).requirement("Woodcutting", 34).requirement("Uncut dragonstone", 1).requirement("Rope", 1)
            .requirement("Raw shrimps", 1).requirement("Law rune", 1).requirement("Bronze med helm", 0).requirement("Iron chainbody", 0)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Crassian warrior", "Crassian warrior", "Crassian warrior",
                "Crassian warrior", "Crassian warrior", "Crassian warrior", "Crassian scout", "Crassian scout", "Crassian scout",
                "Crassian scout", "Crassian scout", "Crassian scout")))).encounter(new Encounter("The Sanctum Guardian (story)"))
            .encounter(new Encounter("Masuta the Ascended (story)")).encounter(new Encounter("Seiryu (story)"))
            .encounter(new Encounter("Astellarn (story)")).encounter(new Encounter("Verak Lith (story)"))
            .encounter(new Encounter("Black Stone Dragon (story)")).encounter(new Encounter("The Crassian Leviathan (story)"))
            .encounter(new Encounter("Taraket the Necromancer (story)")).encounter(new Encounter("The Ambassador (story)"))
            .reward("Quest points", 4).lamp(Player.ALL_SKILLS, -8, 1).lamp(Player.ALL_SKILLS, -8, 1).lamp(Player.ALL_SKILLS, -8, 1)
            .build());
        achievements.add(new AchievementBuilder("Enlightened Journey", 0.75).requirement("Quest points", 21)
            .requirement("Firemaking", 20).requirement("Farming", 30).requirement("Crafting", 36).requirement("Logs", 10)
            .requirement("Papyrus", 3).requirement("Ball of wool", 1).requirement("White candle", 1).requirement("Yellow dye", 1)
            .requirement("Red dye", 1).requirement("Empty sack", 9).requirement("Silk", 10).requirement("Bowl", 1)
            .requirement("Willow branch", 12).reward("Quest points", 1).reward("Crafting", 2000).reward("Farming", 3000)
            .reward("Woodcutting", 1500).reward("Firemaking", 4000).build());
        achievements.add(new AchievementBuilder("Wanted!", 1).requirement("Quest points", 33).requirement("Recruitment Drive", 1)
            .requirement("The Lost Tribe", 1).requirement("Priest in Peril", 1).requirement("Abyss (miniquest)", 1).requirement("Coins", 1)
            .requirement("Molten glass", 1).requirement("Law rune", 1).requirement("Pure essence", -20)
            .encounter(new Encounter("Black Knight")).encounter(new Encounter("Black Knight")).encounter(new Encounter("Solus Dellagar"))
            .reward("Quest points", 1).reward("Slayer", 5000).reward("White Knight reward points", 100).build());
        achievements.add(new AchievementBuilder("Quiet Before the Swarm", 1).requirement("Imp Catcher", 1).requirement("Wanted!", 1)
            .requirement("Attack", 35).requirement("Strength", 42).reward("Quest points", 1).reward("Attack", 4000).reward("Strength", 4900)
            .build());
        achievements.add(new AchievementBuilder("A Void Dance", 1.5).requirement("Druidic Ritual", 1)
            .requirement("Quiet Before the Swarm", 1).requirement("Hunter", 46).requirement("Construction", 47).requirement("Mining", 47)
            .requirement("Summoning", 48).requirement("Herblore", 49).requirement("Woodcutting", 52).requirement("Thieving", 54)
            .requirement("Coins", 65).encounter(new Encounter("Black Knight guardian")).reward("Quest points", 1)
            .reward("Void Knight commendation points", 50).reward("Hunter", 10000).reward("Herblore", 10000).reward("Summoning", 8000)
            .reward("Woodcutting", 8000).reward("Thieving", 5000).reward("Construction", 5000).reward("Mining", 5000).build());
        achievements.add(new AchievementBuilder("The Void Stares Back", 1.5).requirement("A Void Dance", 1).requirement("Magic", 80)
            .requirement("Attack", 78).requirement("Strength", 78).requirement("Firemaking", 71).requirement("Construction", 70)
            .requirement("Crafting", 70).requirement("Smithing", 70).requirement("Summoning", 55).requirement("Defence", 25)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Torcher", "Brawler", "Shifter", "Spinner"))))
            .encounter(new Encounter("Pest Queen")).reward("Quest points", 1).reward("Crafting", 20000).reward("Construction", 20000)
            .reward("Firemaking", 20000).reward("Magic", 20000).reward("Summoning", 20000).reward("Smithing", 20000)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Ranged", "Magic", "Summoning", "Prayer"), 50000, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Ranged", "Magic", "Summoning", "Prayer"), 50000, 75).build());
        achievements.add(new AchievementBuilder("Devious Minds", 0.75).requirement("Troll Stronghold", 1).requirement("Wanted!", 1)
            .requirement("What's Mine is Yours", 1).requirement("Abyss (miniquest)", 1).requirement("Runecrafting", 50)
            .requirement("Fletching", 50).requirement("Smithing", 65).requirement("Mithril 2h sword", 1).requirement("Bowstring", 1)
            .requirement("Coins", 25000).reward("Quest points", 1).reward("Fletching", 5000).reward("Runecrafting", 5000)
            .reward("Smithing", 6500).build());
        achievements.add(new AchievementBuilder("Natural history quiz", 0.5).reward("Hunter", 1000).reward("Slayer", 1000).build());
        achievements.add(new AchievementBuilder("Cleaning finds", 0.5).requirement("The Dig Site", 1).build());
        achievements.add(new AchievementBuilder("The Curse of Zaros (miniquest)", 1).requirement("Desert Treasure", 1)
            .requirement("The Restless Ghost", 1).requirement("Prayer", 31).requirement("Agility", 15)
            .lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("The Temple at Senntisten", 1).requirement("Desert Treasure", 1)
            .requirement("Devious Minds", 1).requirement("The Curse of Arrav", 1).requirement("Natural history quiz", 1)
            .requirement("Cleaning finds", 1).requirement("The Curse of Zaros (miniquest)", 1).requirement("Rune Mysteries", 1)
            .requirement("Hazeel Cult", 1).requirement("Prayer", 50).requirement("Air rune", 1).requirement("Law rune", 1)
            .encounter(new Encounter("Dharok the Wretched")).encounter(new Encounter("Karil the Tainted"))
            .encounter(new Encounter("Verac the Defiled")).encounter(new Encounter("Ahrim the Blighted"))
            .encounter(new Encounter("Torag the Corrupted")).encounter(new Encounter("Guthan the Infested"))
            .encounter(new Encounter("Ice demon")).reward("Quest points", 2).reward("Prayer", 10000).lamp(Player.ALL_SKILLS, 23000, 50)
            .lamp(Arrays.asList("Attack", "Defence", "Strength", "Constitution", "Magic", "Ranged", "Summoning"), 20000, 50)
            .lamp(Arrays.asList("Attack", "Defence", "Strength", "Constitution", "Magic", "Ranged", "Summoning"), 20000, 50).build());
        achievements.add(new AchievementBuilder("The Light Within", 1.5).requirement("Fate of the Gods", 1)
            .requirement("Meeting History", 1).requirement("Plague's End", 1).requirement("The Temple at Senntisten", 1)
            .requirement("The World Wakes", 1).requirement("Agility", 80).requirement("Crafting", 80).requirement("Divination", 80)
            .requirement("Herblore", 80).requirement("Prayer", 80).requirement("Slayer", 80).requirement("Woodcutting", 80)
            .requirement("Grand defence potion (6)", 1).requirement("Truthful shadow core", 10).requirement("Rope", 0).reward("Quest points", 2)
            .reward("Agility", 90000).reward("Crafting", 90000).reward("Herblore", 90000).reward("Prayer", 90000).reward("SLayer", 90000)
            .reward("Woodcutting", 90000).reward("Divination", 93250).build());
        achievements.add(new AchievementBuilder("Children of Mah", 1).requirement("Dishonour among Thieves", 1)
            .requirement("The Light Within", 1).reward("Quest points", 2).reward("Agility", 100000).reward("Divination", 100000)
            .lamp(Player.ALL_SKILLS, 100000, 75).lamp(Player.ALL_SKILLS, 100000, 75).lamp(Player.ALL_SKILLS, 100000, 75).build());
        achievements.add(new AchievementBuilder("The Slug Menace", 1).requirement("Sea Slug", 1).requirement("Wanted!", 1)
            .requirement("Runecrafting", 30).requirement("Crafting", 30).requirement("Slayer", 30).requirement("Thieving", 30)
            .requirement("Swamp paste", 0).requirement("Pure essence", 5).requirement("Earth talisman", 0).requirement("Fire talisman", 0)
            .requirement("Water talisman", 0).requirement("Air talisman", 0).requirement("Mind talisman", 0)
            .encounter(new Encounter("Slug Prince")).reward("Quest points", 1).reward("Thieving", 3500).reward("Crafting", 3500)
            .reward("Runecrafting", 3500).build());
        achievements.add(new AchievementBuilder("Kennith's Concerns", 1).requirement("The Slug Menace", 1).requirement("Mining", 46)
            .reward("Quest points", 1).reward("Mining", 12000).reward("Agility", 5000).build());
        achievements.add(new AchievementBuilder("Salt in the Wound", 1.5).requirement("Kennith's Concerns", 1).requirement("Defence", 60)
            .requirement("Constitution", 50).requirement("Herblore", 47).requirement("Summoning", 45).requirement("Dungeoneering", 35)
            .reward("Quest points", 2).reward("Defence", 45000).reward("Constitution", 17500).reward("Herblore", 15000)
            .reward("Summoning", 12500).reward("Dungeoneering", 5000).build());
        achievements.add(new AchievementBuilder("A Knight in the Darkness", 0).requirement("Proselyte sallet", 0)
            .requirement("Proselyte hauberk", 0).requirement("Proselyte cuisse", 0).requirement("The Slug Menace", 1)
            .requirement("Defence", 30).requirement("Prayer", 20).build());
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
                Collections.singletonList("Melzar the Mad"), Collections.singletonList("Lesser demon (Melzar's Maze)"))))
            .encounter(new Encounter("Elvarg")).reward("Quest points", 2).reward("Anti-dragon shield", 1)
            .lamp(Collections.singletonList("Strength"), 18650, 40).lamp(Collections.singletonList("Defence"), 18650, 40).build());
        achievements.add(new AchievementBuilder("Gower Quest", 1).requirement("Quest points", 34).encounter(new Encounter(Arrays.asList(
            Collections.singletonList("Black Knight Titan"), Collections.singletonList("Black Knight Titan"),
            Collections.singletonList("Black Knight Titan"), Collections.singletonList("Black Knight Titan"),
            Collections.singletonList("Black Knight Titan"), Collections.singletonList("Black Knight Titan")))).reward("Quest points", 1)
            .reward("Coins", 15).build());
        achievements.add(new AchievementBuilder("Tears of Guthix", 0.25).requirement("Quest points", 44).requirement("Firemaking", 49)
            .requirement("Mining", 20).requirement("Crafting", 20).requirement("Bullseye lantern (oil)", 1).requirement("Sapphire", 1)
            .reward("Quest points", 1).reward("Crafting", 1000).build());
        achievements.add(new AchievementBuilder("Carnillean Rising", 1).requirement("The Blood Pact", 1).requirement("Hazeel Cult", 1)
            .requirement("Quest points", 50).requirement("Thieving", 33).requirement("Construction", 31).reward("Quest points", 1)
            .reward("Thieving", 2500).reward("Construction", 2500).reward("Coins", 5000).reward("Purple sweets", 5).reward("Oak plank", 100)
            .reward("Teak plank", 30).reward("Mahogany plank", 10).reward("Gold bar", 1).lamp(Player.ALL_SKILLS, 1500, 30)
            .lamp(Player.ALL_SKILLS, 1500, 30).build());
        achievements.add(new AchievementBuilder("Heart of Stone", 1.5).requirement("Carnillean Rising", 1).requirement("Rune Memories", 1)
            .requirement("Runecrafting", 25).requirement("Magic", 35).encounter(new Encounter("Prehistoric abyssal"))
            .reward("Quest points", 1).reward("Runecrafting", 1500).reward("Magic", 1500).lamp(Arrays.asList("Attack", "Strength",
                "Defence", "Ranged", "Magic", "Constitution", "Prayer", "Summoning"), 500, 1).build());
        achievements.add(new AchievementBuilder("Heroes' Quest", 0.75).requirement("Quest points", 56).requirement("Shield of Arrav", 1)
            .requirement("Lost City", 1).requirement("Dragon Slayer", 1).requirement("Merlin's Crystal", 1).requirement("Druidic Ritual", 1)
            .requirement("Cooking", 53).requirement("Fishing", 53).requirement("Herblore", 25).requirement("Mining", 50)
            .requirement("Ice gloves", 1).requirement("Harralander potion (unf)", 1).requirement("Fishing rod", 1)
            .requirement("Fishing bait", 1).requirement("Lockpick", 1).requirement("Coins", 1000)
            .encounter(new Encounter("Entranan firebird")).reward("Quest points", 1).reward("Attack", 3075).reward("Defence", 3075)
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
        achievements.add(new AchievementBuilder("Nomad's Elegy", 1.5).requirement("Dishonour among Thieves", 1)
            .requirement("Heart of Stone", 1).requirement("The Mighty Fall", 1).requirement("Throne of Miscellania", 1)
            .requirement("Nomad's Requiem", 1).requirement("The Void Stares Back", 1).requirement("Mining", 75)
            .requirement("Construction", 75).requirement("Woodcutting", 75).encounter(new Encounter("Shame"))
            .encounter(new Encounter("Shame")).encounter(new Encounter(Arrays.asList(Collections.singletonList("Ork Headhunter"),
                Collections.singletonList("Ogre Skulltaker"), Collections.singletonList("Bandosian golem"))))
            .encounter(new Encounter("Nomad (Elegy)")).encounter(new Encounter("Nomad (Elegy)")).encounter(new Encounter("Nomad (Elegy)"))
            .encounter(new Encounter("Nomad (Elegy)")).reward("Quest points", 1).reward("Construction", 75000).reward("Mining", 50000)
            .reward("Woodcutting", 50000).lamp(Arrays.asList("Constitution", "Attack", "Strength", "Defence", "Magic", "Ranged"), 50000, 1)
            .build());
        achievements.add(new AchievementBuilder("Glorious Memories", 0.75).requirement("Royal Trouble", 1)
            .requirement("The Fremennik Isles", 1).requirement("Mountain Daughter", 1).requirement("Lunar Diplomacy", 1)
            .requirement("Magic", 57).requirement("Agility", 50).requirement("Herblore", 43).requirement("Hunter", 41)
            .requirement("Clean irit", 1).requirement("Vial", 1).requirement("Earth rune", 10).requirement("Cosmic rune", 1)
            .encounter(new Encounter("Nial Swiftfling")).reward("Quest points", 1).reward("Magic", 10000).reward("Herblore", 5000)
            .lamp(Arrays.asList("Attack", "Strength", "Constitution", "Defence", "Ranged"), 5000, 1).lamp(Arrays.asList("Attack",
                "Strength", "Constitution", "Defence", "Ranged"), 5000, 1).lamp(Arrays.asList("Attack", "Strength", "Constitution",
                "Defence", "Ranged"), 5000, 1).lamp(Player.ALL_SKILLS, 2500, 35).build());
        achievements.add(new AchievementBuilder("The Graceful Barbarian", 0).requirement("Bar Crawl (miniquest)", 1)
            .requirement("Agility", 35).reward("Agility", 174).build());
        achievements.add(new AchievementBuilder("Runes on the Moon", 0).requirement("Lunar Diplomacy", 1).requirement("Mining", 60)
            .reward("Pure essence", 1).reward("Mining", 5).build());
        achievements.add(new AchievementBuilder("Pyre At Will", 0).requirement("Crafting", 52).requirement("Firemaking", 52)
            .requirement("Arctic pine logs", 1).requirement("Barbarian Firemaking", 1).reward("Crafting", 31).reward("Firemaking", 125)
            .build());
        achievements.add(new AchievementBuilder("How To Maim Your Dragon", 0).requirement("Barbarian Firemaking", 1)
            .encounter(new Encounter("Mithril dragon")).build());
        achievements.add(new AchievementBuilder("Fish Fingers", 0).requirement("Strength", 35).requirement("Fishing", 55)
            .requirement("Barbarian Fishing", 1).reward("Fishing", 80).reward("Raw tuna", 1).build());
        achievements.add(new AchievementBuilder("Easy As Pie", 0).requirement("Lunar Diplomacy", 1).requirement("Magic", 65)
            .requirement("Astral rune", 1).requirement("Fire rune", 5).requirement("Water rune", 1).requirement("Uncooked berry pie", 1)
            .requirement("Cooking", 10).reward("Redberry pie", 1).reward("Cooking", 78).reward("Magic", 60).build());
        achievements.add(new AchievementBuilder("Dress to Impress", 0).requirement("Rock-shell helm", 0)
            .requirement("Rock-shell plate", 0).requirement("Rock-shell legs", 0).requirement("Defence", 1)
            .requirement("The Fremennik Trials", 1).build());
        achievements.add(new AchievementBuilder("Defeating Deadly Dagannoths", 0).requirement("The Fremennik Trials", 1)
            .encounter(new Encounter("Dagannoth")).encounter(new Encounter("Dagannoth")).encounter(new Encounter("Dagannoth"))
            .build());
        achievements.add(new AchievementBuilder("A Periodic Table", 0).requirement("Royal Trouble", 1).requirement("Coins", 37500)
            .reward("Mahogany log", 1).build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Hard", 0).requirement("Pyre At Will", 1)
            .requirement("Defeating Deadly Dagannoths", 1).requirement("Dress to Impress", 1).requirement("The Graceful Barbarian", 1)
            .requirement("Runes on the Moon", 1).requirement("Fish Fingers", 1).requirement("Easy As Pie", 1)
            .requirement("How To Maim Your Dragon", 1).requirement("A Periodic Table", 1).lamp(Player.ALL_SKILLS, 15000, 50).build());
        achievements.add(new AchievementBuilder("You Really Don't Need Any More Shoes", 0).requirement("The Fremennik Trials", 1)
            .build());
        achievements.add(new AchievementBuilder("You Know You Want It!", 0).requirement("Raw bass", 1)
            .requirement("The Fremennik Trials", 1).requirement("Garden of Tranquility", 1).reward("Enchanted lyre", 1).build());
        achievements.add(new AchievementBuilder("Yak Attack", 0).requirement("Yak-hide armour (top)", 0)
            .requirement("Yak-hide armour (legs)", 0).requirement("The Fremennik Isles", 1).encounter(new Encounter("Ice troll male"))
            .build());
        achievements.add(new AchievementBuilder("Who's a Good Boy?", 0).requirement("The Fremennik Trials", 1).build());
        achievements.add(new AchievementBuilder("Only Takes a Little Vial", 0).requirement("Molten glass", 3).requirement("Crafting", 3)
            .requirement("The Fremennik Trials", 1).reward("Vial", 3).reward("Crafting", 105).build());
        achievements.add(new AchievementBuilder("Grand Theft Fish", 0).requirement("The Fremennik Trials", 1)
            .requirement("Thieving", 42).reward("Thieving", 42).build());
        achievements.add(new AchievementBuilder("Fremmental", 0).requirement("The Fremennik Trials", 1).requirement("Cooking", 48)
            .requirement("Bucket of milk", 1).build());
        achievements.add(new AchievementBuilder("Fremennik History 101", 0).requirement("The Fremennik Trials", 1).build());
        achievements.add(new AchievementBuilder("Fairy Mountaineering", 0).requirement("A Fairy Tale II - Cure a Queen", 1).build());
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
        achievements.add(new AchievementBuilder("Bring the Antipoisons", 0).requirement("Slayer", 10)
            .encounter(new Encounter("Cave crawler")).build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Easy", 0).requirement("King Conifer", 1)
            .requirement("Bring the Antipoisons", 1).requirement("Why Won't You Die?", 1).requirement("Assaulted Goodies", 1)
            .requirement("Oxymoron Incarnate", 1).requirement("Why Did the Lobster Blush?", 1).requirement("Hunting the Hunter", 1)
            .requirement("Peer Off the Pier", 1).requirement("A Familiar Feeling", 1).requirement("Endangered Species", 1)
            .lamp(Player.ALL_SKILLS, 5000, 30).build());
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
        achievements.add(new AchievementBuilder("Swan Song", 1).requirement("Quest points", 101).requirement("Garden of Tranquility", 1)
            .requirement("One Small Favour", 1).requirement("Magic", 66).requirement("Cooking", 62).requirement("Fishing", 62)
            .requirement("Smithing", 45).requirement("Firemaking", 42).requirement("Crafting", 40).requirement("Mist rune", 10)
            .requirement("Lava rune", 10).requirement("Blood rune", 5).requirement("Empty pot", 1).requirement("Pot lid", 1)
            .requirement("Bones", 7).requirement("Iron bar", 5).requirement("Logs", 1).encounter(new Encounter(Arrays.asList(
                Arrays.asList("Sea troll", "Sea troll", "Sea troll"), Arrays.asList("Sea troll", "Sea troll", "Sea troll"),
                Collections.singletonList("Sea troll")))).encounter(new Encounter("Sea Troll Queen")).reward("Quest points", 2)
            .reward("Magic", 15000).reward("Prayer", 10000).reward("Fishing", 10000).reward("Coins", 25000).build());
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
            .reward("Quest points", 4).lamp(Arrays.asList("Attack", "Defence", "Strength", "Constitution", "Prayer", "Magic",
                "Woodcutting", "Crafting", "Smithing", "Herblore", "Agility", "Thieving"), 7650, 1).lamp(Arrays.asList("Attack", "Defence",
                "Strength", "Constitution", "Prayer", "Magic", "Woodcutting", "Crafting", "Smithing", "Herblore", "Agility", "Thieving"),
                7650, 1).lamp(Arrays.asList("Attack", "Defence", "Strength", "Constitution", "Prayer", "Magic", "Woodcutting", "Crafting",
                "Smithing", "Herblore", "Agility", "Thieving"), 7650, 1).lamp(Arrays.asList("Attack", "Defence", "Strength", "Constitution",
                "Prayer", "Magic", "Woodcutting", "Crafting", "Smithing", "Herblore", "Agility", "Thieving"), 7650, 1).build());
        achievements.add(new AchievementBuilder("While Guthix Sleeps", 4).requirement("Defender of Varrock", 1)
            .requirement("Dream Mentor", 1).requirement("The Hand in the Sand", 1).requirement("King's Ransom", 1)
            .requirement("Legends' Quest", 1).requirement("The Path of Glouphrie", 1).requirement("Tears of Guthix", 1)
            .requirement("Wanted!", 1).requirement("Wolf Whistle", 1).requirement("The Hunt for Surok (miniquest)", 1)
            .requirement("Summoning", 23).requirement("Hunter", 55).requirement("Thieving", 60).requirement("Defence", 65)
            .requirement("Farming", 65).requirement("Herblore", 65).requirement("Attack", 65).requirement("Strength", 65)
            .requirement("Magic", 75).requirement("Air rune", 35).requirement("Earth rune", 1).requirement("Fire rune", 1)
            .requirement("Water rune", 1).requirement("Mind rune", 1).requirement("Law rune", 1).requirement("Death rune", 1)
            .requirement("Astral rune", 1).requirement("Cosmic rune", 4).requirement("Logs", 1).requirement("Lantern lens", 1)
            .requirement("Mort myre fungus", 1).requirement("Unpowered orb", 1).requirement("Elite black full helm", 0)
            .requirement("Elite black platebody", 0).requirement("Elite black platelegs", 1).requirement("Snapdragon seed", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Assassin", "Assassin"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Mercenary axeman", "Mercenary axeman"))))
            .encounter(new Encounter("Balance Elemental")).encounter(new Encounter(Collections.singletonList(Arrays.asList(
                "Tormented demon", "Tormented demon")))).reward("Quest points", 5).reward("Ruined dragon armour lump", 1)
            .reward("Dagon'hai hat", 1).reward("Dagon'hai robe top", 1).reward("Dagon'hai robe bottom", 1).reward("Coins", 5000).build());
        achievements.add(new AchievementBuilder("A Palm For Each Finger", 0).requirement("Legends' Quest", 1)
            .requirement("Woodcutting", 15).reward("Palm leaf", 1).build());
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
        achievements.add(new AchievementBuilder("A Visit to Charlie", 0).requirement("A Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("A Wizard Did It", 0).build());
        achievements.add(new AchievementBuilder("A World In Microcosm", 0).build());
        achievements.add(new AchievementBuilder("Abyssal Valet", 0).requirement("Abyssal titan pouch", 1).requirement("Summoning", 93)
            .requirement("Pure essence", 2).reward("Summoning", 2).build());
        achievements.add(new AchievementBuilder("Ace of Dungeons", 0.1).requirement("Plague's End", 1).requirement("Dungeoneering", 95)
            .build());
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
        achievements.add(new AchievementBuilder("Agile from Head to Toe", 0).requirement("Advanced Barbarian Outpost laps", 250)
            .requirement("Advanced Gnome Stronghold laps", 250).build());
        achievements.add(new AchievementBuilder("Agility - Dojo Mojo", 0).requirement("Agility level-ticks", 34657359).build());
        achievements.add(new AchievementBuilder("Agility 5", -1).requirement("Agility", 5).build());
        achievements.add(new AchievementBuilder("Agility 10", -1).requirement("Agility", 10).build());
        achievements.add(new AchievementBuilder("Agility 20", -1).requirement("Agility", 20).build());
        achievements.add(new AchievementBuilder("Agility 30", -1).requirement("Agility", 30).build());
        achievements.add(new AchievementBuilder("Agility 40", -1).requirement("Agility", 40).build());
        achievements.add(new AchievementBuilder("Agility 50", -1).requirement("Agility", 50).build());
        achievements.add(new AchievementBuilder("Agility 60", -1).requirement("Agility", 60).build());
        achievements.add(new AchievementBuilder("Agility 70", -1).requirement("Agility", 70).build());
        achievements.add(new AchievementBuilder("Agility 80", -1).requirement("Agility", 80).build());
        achievements.add(new AchievementBuilder("Agility 90", -1).requirement("Agility", 90).build());
        achievements.add(new AchievementBuilder("Agility 92 (Halfway There)", -1).requirement("Agility", 92).build());
        achievements.add(new AchievementBuilder("Agility 99", -1).requirement("Agility", 99).build());
        achievements.add(new AchievementBuilder("Ahrim Bobblehead", 0).requirement("Malevolent energy", 250).requirement("Ahrim's hood", 1)
            .requirement("Ahrim's robe top", 1).requirement("Ahrim's robe skirt", 1).requirement("Ahrim's staff", 1).build());
        achievements.add(new AchievementBuilder("Al Kharid", 0).build());
        achievements.add(new AchievementBuilder("Alch-aholic", 0).requirement("Magic", 55).requirement("Fire rune", 5)
            .requirement("Nature rune", 1).requirement("Magic shortbow", 1).reward("Coins", 960).reward("Magic", 65).build());
        achievements.add(new AchievementBuilder("Alcrabaholic", 0).requirement("A Clockwork Syringe", 1)
            .encounter(new Encounter("'Rum'-pumped crab")).build());
        achievements.add(new AchievementBuilder("Large rune casket", 0.05).requirement("The Feud", 1).build());
        achievements.add(new AchievementBuilder("Rogue Trader", 0.25).requirement("The Feud", 1).requirement("Icthlarin's Little Helper", 1)
            .requirement("Large rune casket", 1).requirement("Coins", 100).requirement("Blue dye", 3).build());
        achievements.add(new AchievementBuilder("From Tiny Acorns (miniquest)", 0.25).requirement("Buyers and Cellars", 1)
            .requirement("Thieving", 24).reward("Thieving", 1000).build());
        achievements.add(new AchievementBuilder("Lost Her Marbles (miniquest)", 0.75).requirement("From Tiny Acorns (miniquest)", 1)
            .requirement("Thieving", 41).reward("Thieving", 10527).reward("Coal", 46).reward("Gold ore", 38).reward("Teak logs", 126)
            .reward("Maple logs", 255).reward("Raw lobster", 37).reward("Raw swordfish", 19).reward("Nature rune", 43)
            .reward("Law rune", 45).build());
        achievements.add(new AchievementBuilder("A Guild of Our Own (miniquest)", 0.5).requirement("Lost Her Marbles (miniquest)", 1)
            .requirement("The Feud", 1).requirement("Thieving", 62).requirement("Agility", 40).requirement("Herblore", 46)
            .requirement("Lockpick", 0).requirement("Chopped onion", 1).requirement("Clean irit", 1).requirement("Vial of water", 1)
            .reward("Thieving", 30000).reward("Herblore", 4001).build());
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
            .lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning",
                "Herblore"), 2000, 1).build());
        achievements.add(new AchievementBuilder("River troll v. The People", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Shark", 20).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 3500, 1).build());
        achievements.add(new AchievementBuilder("Drunken Dwarf v. The People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 1).reward("Gold ore", 20).reward("Kebab", 1).lamp(Arrays.asList("Attack",
                "Defence", "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 5000, 1).build());
        achievements.add(new AchievementBuilder("Evil Twin v. Good Twin", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Uncut sapphire", 5).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 6500, 1).build());
        achievements.add(new AchievementBuilder("Rick Turpentine v. The (Rich) People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 1).reward("Uncut ruby", 3).lamp(Arrays.asList("Attack", "Defence",
                "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 8000, 1).build());
        achievements.add(new AchievementBuilder("The Frog Prince v. The People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 2).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("Sawmill Man v. The People", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Teak plank", 30).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("Party Pete v. His Neighbours", 0.75).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 1).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("Ernest v. Professor Oddenstein", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 1).reward("Feather", 100).reward("Red feather", 15)
            .reward("Yellow feather", 15).reward("Blue feather", 15).reward("Raw bird meat", 20).lamp(Arrays.asList("Attack", "Defence",
                "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 10000, 1).build());
        achievements.add(new AchievementBuilder("Miss Schism v. Draynor Village", 0.75).requirement("Casket", 17)
            .requirement("King's Ransom", 1).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged", "Constitution",
                "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).lamp(Player.ALL_SKILLS, -10, 1).build());
        achievements.add(new AchievementBuilder("EVIL DAVE v. The People", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged", "Constitution", "Slayer",
                "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("H.A.M v. Dorgeshuun", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Uncut ruby", 5).reward("Cave goblin wire", 100).lamp(Arrays.asList("Attack", "Defence",
                "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 15000, 1).build());
        achievements.add(new AchievementBuilder("The Sandwich Lady v. The People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 2).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged",
                "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("The Mime v. The People", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 2).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged", "Constitution", "Slayer",
                "Prayer", "Summoning", "Herblore"), 9000, 1).build());
        achievements.add(new AchievementBuilder("Barbarians v. Wizards", 0.25).requirement("Casket", 17).requirement("King's Ransom", 1)
            .reward("Mystery box", 1).reward("Dagannoth hide", 10).reward("Law rune", 50).lamp(Arrays.asList("Attack", "Defence",
                "Strength", "Magic", "Ranged", "Constitution", "Slayer", "Prayer", "Summoning", "Herblore"), 20000, 1).build());
        achievements.add(new AchievementBuilder("The Gravedigger v. The People", 0.25).requirement("Casket", 17)
            .requirement("King's Ransom", 1).reward("Mystery box", 2).lamp(Arrays.asList("Attack", "Defence", "Strength", "Magic", "Ranged",
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
        achievements.add(new AchievementBuilder("Almost as Perky as a Prawn", 0).requirement("Prawn balls", 200)
            .requirement("Golden fish egg", 11).requirement("Construction", 63).requirement("Coins", 200000).requirement("Teak plank", 8)
            .build());
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
        achievements.add(new AchievementBuilder("Amulet of Weedspeak", 0).requirement("Coins", 200).reward("Amulet of farming (8)", 1)
            .build());
        achievements.add(new AchievementBuilder("An Act of War", 0).requirement("Coins", 104).requirement("Regicide", 1)
            .encounter(new Encounter("Elf warrior")).reward("Bronze halberd", 1).build());
        achievements.add(new AchievementBuilder("An Teak", 0).requirement("Woodcutting", 35).build());
        achievements.add(new AchievementBuilder("And I Want It Now", 0.1).requirement("Dungeoneering floors completed", 5).build());
        achievements.add(new AchievementBuilder("And It Was THIS Big!", 0).requirement("Fishing", 25).reward("Raw pike", 1)
            .reward("Fishing", 60).build());
        achievements.add(new AchievementBuilder("Angs off my Ring", 0).requirement("The Light Within", 1)
            .requirement("Crystal shapeshifters", 222).build());
        achievements.add(new AchievementBuilder("Animal Cruelty", 0).encounter(new Encounter(Arrays.asList(Arrays.asList("Airut",
            "Airut", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Charger", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut",
                "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger",
                "Charger", "Cormes"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut",
                "Airut"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")), 10)).build());
        achievements.add(new AchievementBuilder("Ankle Support", 0).requirement("Do No Evil", 1).requirement("Agility", 80)
            .requirement("Mining", 80).build());
        achievements.add(new AchievementBuilder("Annihilator", 0).requirement("Fate of the Gods", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Smoke nihil", "Shadow nihil", "Blood nihil", "Ice nihil"))))
            .build());
        achievements.add(new AchievementBuilder("Another String to Your Bow", 0).requirement("Flax", 5).reward("Bowstring", 5)
            .reward("Crafting", 75).build());
        achievements.add(new AchievementBuilder("Any fin is Possible", 0).requirement("Cooking", 90)
            .requirement("Dungeoneering floors completed", 1).reward("Cooking", 1153).build());
        achievements.add(new AchievementBuilder("Any Odd Chicken", 0).requirement("Ernest the Chicken", 1).build());
        achievements.add(new AchievementBuilder("Ape A'hollow", 0.05).requirement("A Fairy Tale III - Battle at Ork's Rift", 1)
            .requirement("Monkey Madness", 1).requirement("Agility", 48).build());
        achievements.add(new AchievementBuilder("Arachnophagia", 0).requirement("Spider on stick (raw)", 1).requirement("Cooking", 16)
            .reward("Cooking", 80).reward("Spider on stick", 1).build());
        achievements.add(new AchievementBuilder("Arandar-bout Way", 0).requirement("Mourning's End Part I", 1).build());
        achievements.add(new AchievementBuilder("Arc - All Your Energies", 0).requirement("Chimes", 5000).requirement("Taijitu", 5)
            .requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Ancient Eastern Tortle Portals", 0.05).requirement("Divination", 90)
            .requirement("Ancestral energy", 100).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Bonecrusher", 0).requirement("Dungeoneering token", 34000).requirement("Dungeoneering", 21)
            .requirement("Prayer", 21).build());
        achievements.add(new AchievementBuilder("Arc - Bone to Pick with You", 0).requirement("Chimes", 25000).requirement("Bonecrusher", 1)
            .requirement("Taijitu", 25).requirement("Impressing the Locals", 1).build());
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
        achievements.add(new AchievementBuilder("Birds of the Arc", 0.2).requirement("Ports unlocked", 1)
            .requirement("Impressing the Locals", 1).requirement("Pumpkin Limpkin", 1).requirement("Cyansoul Kakapo", 1)
            .requirement("Tortoiseshell Plover", 1).requirement("Azure Parrot", 1).requirement("Awah Guan", 1)
            .requirement("Great Pecker", 1).requirement("Supplies", 70).build());
        achievements.add(new AchievementBuilder("Berries of the Arc", 0.75).requirement("Exuberry seed", 3).requirement("Rumberry seed", 3)
            .requirement("Stoneberry seed", 1).requirement("Stormberry seed", 1).reward("Farming", 164000).build());
        achievements.add(new AchievementBuilder("Kami Spirits of the Arc", 1).requirement("Impressing the Locals", 1)
            .requirement("Supplies", 540).requirement("Hunter", 95).reward("Hunter", 83750).build());
        achievements.add(new AchievementBuilder("Arc - Rewards", 0).requirement("Impressing the Locals", 1)
            .requirement("Birds of the Arc", 1).requirement("Berries of the Arc", 1).requirement("Kami Spirits of the Arc", 1).build());
        achievements.add(new AchievementBuilder("Arc - Unlocking More Waiko", 0).requirement("Chimes", 192600).requirement("Taijitu", 277)
            .requirement("Supplies", 100).requirement("Mining", 98).reward("Mining", 10500).build());
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
        achievements.add(new AchievementBuilder("Mushrooms of the Arc", 0).requirement("Named mushrooms", 10)
            .requirement("Uncharted mushrooms", 7).build());
        achievements.add(new AchievementBuilder("Spiritual Enlightenment (miniquest)", 0.75)
            .requirement("Impressing the Locals", 1).requirement("Slayer", 90).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna"))
            .encounter(new Encounter("Sotapanna")).encounter(new Encounter("Sotapanna")).reward("Chimes", 250).reward("Taijitu", 3)
            .lamp(Collections.singletonList("Slayer"), -3, 1).build());
        achievements.add(new AchievementBuilder("Castaways of the Arc", 0.1).requirement("Divination", 90)
            .requirement("Impressing the Locals", 1).requirement("Spiritual Enlightenment (miniquest)", 1).build());
        achievements.add(new AchievementBuilder("Flag Fall (miniquest)", 0.5).requirement("Impressing the Locals", 1)
            .reward("Chimes", 500).reward("Taijitu", 2).build());
        achievements.add(new AchievementBuilder("Head of the Family (miniquest)", 0.75).requirement("Impressing the Locals", 1)
            .requirement("Fish oil", 15).requirement("Woodcutting", 90).requirement("Fishing", 90).requirement("Cooking", 91)
            .requirement("Chimes", 450).requirement("Bamboo", 5)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Cap'n Ekahi", "Cyclops labourer", "Cyclops labourer"))))
            .reward("Chimes", 1300).reward("Fish oil", 30).reward("Bundle of bamboo", 4).reward("Taijitu", 5)
            .lamp(Collections.singletonList("Agility"), -3, 1).build());
        achievements.add(new AchievementBuilder("Jed Hunter (miniquest)", 0.25).requirement("Flag Fall (miniquest)", 1)
            .requirement("Spiritual Enlightenment (miniquest)", 1).requirement("Head of the Family (miniquest)", 1).requirement("Hunter", 90)
            .requirement("Crafting", 91).requirement("Driftwood", 10).requirement("Sea shell", 5).requirement("Shell chippings", 8)
            .requirement("Taijitu", 1).requirement("Chimes", 200).encounter(new Encounter("Gu ronin")).encounter(new Encounter("Gu ronin"))
            .encounter(new Encounter("Gu ronin")).reward("Chimes", 2000).reward("Taijitu", 10).reward("Crafting", 150)
            .lamp(Collections.singletonList("Hunter"), -3, 1).build());
        achievements.add(new AchievementBuilder("Eye for an Eye (miniquest)", 0.25).requirement("Jed Hunter (miniquest)", 1)
            .requirement("Mining", 90).requirement("Sea salt", 30)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops"),
                Arrays.asList("Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops",
                    "Zyclops"), Arrays.asList("Zyclops", "Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops", "Zyclops", "Zyclops"),
                Arrays.asList("Zyclops", "Zyclops", "Zyclops", "Zyclops"), Arrays.asList("Zyclops", "Zyclops", "Zyclops", "Zyclops"))))
            .reward("Chimes", 250).reward("Taijitu", 1).reward("Alalea sea salt", 25).lamp(Collections.singletonList("Prayer"), -3, 1)
            .build());
        achievements.add(new AchievementBuilder("Harbinger (miniquest)", 0.25).requirement("Eye for an Eye (miniquest)", 1)
            .reward("Chimes", 250).reward("Taijitu", 2).lamp(Collections.singletonList("Construction"), -3, 1).build());
        achievements.add(new AchievementBuilder("Tuai Leit's Own (miniquest)", 0.5).requirement("Harbinger (miniquest)", 1)
            .requirement("Farming", 86).requirement("Divination", 90).requirement("Rumberry", 30).requirement("Positive energy", 30)
            .requirement("Spirit dragon charm", 1).reward("Chimes", 500).reward("Taijitu", 2).reward("Rumberry", 50)
            .reward("Ancestral energy", 50).build());
        achievements.add(new AchievementBuilder("Ghosts from the Past (miniquest)", 0.25).requirement("Harbinger (miniquest)", 1)
            .reward("Chimes", 500).reward("Taijitu", 2).lamp(Arrays.asList("Agility", "Herblore", "Fishing", "Thieving", "Cooking",
                "Prayer", "Runecrafting", "Slayer", "Construction", "Hunter", "Dungeoneering", "Divination"), -3, 1).build());
        achievements.add(new AchievementBuilder("Damage Control (miniquest)", 0.25).requirement("Harbinger (miniquest)", 1)
            .requirement("Chimes", 2500).reward("Chimes", 3000).reward("Taijitu", 2).lamp(Collections.singletonList("Thieving"), -3, 1)
            .build());
        achievements.add(new AchievementBuilder("Final Destination (miniquest)", 0.25).requirement("Tuai Leit's Own (miniquest)", 1)
            .requirement("Damage Control (miniquest)", 1).requirement("Ghosts from the Past (miniquest)", 1)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Zyclops cannoneer", "Zyclops cannoneer", "Zyclops cannoneer"),
                Arrays.asList("Zombie (Uncharted Isles)", "Zombie (Uncharted Isles)", "Zombie (Uncharted Isles)",
                    "Zombie (Uncharted Isles)", "Zombie (Uncharted Isles)", "Zombie (Uncharted Isles)"),
                Arrays.asList("Skeleton (Uncharted Isles)", "Skeleton (Uncharted Isles)"), Arrays.asList("Zyclops (Final Destination)",
                    "Zyclops (Final Destination)")))).reward("Chimes", 2000).reward("Taijitu", 10)
            .lamp(Arrays.asList("Attack", "Constitution", "Defence", "Strength", "Ranged", "Prayer", "Magic", "Summoning"), -4, 1).build());
        achievements.add(new AchievementBuilder("Wushanko Isles: The Arc", 0).requirement("Birds of the Arc", 1)
            .requirement("Mushrooms of the Arc", 1).requirement("Berries of the Arc", 1).requirement("Kami Spirits of the Arc", 1)
            .requirement("Castaways of the Arc", 1).requirement("Flag Fall (miniquest)", 1).requirement("Head of the Family (miniquest)", 1)
            .requirement("Spiritual Enlightenment (miniquest)", 1).requirement("Jed Hunter (miniquest)", 1)
            .requirement("Eye for an Eye (miniquest)", 1).requirement("Harbinger (miniquest)", 1)
            .requirement("Tuai Leit's Own (miniquest)", 1).requirement("Ghosts from the Past (miniquest)", 1)
            .requirement("Damage Control (miniquest)", 1).requirement("Final Destination (miniquest)", 1).build());
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
        achievements.add(new AchievementBuilder("Creator and Destroyer", 0).requirement("Tower of Life", 1).requirement("Cowhide", 1)
            .requirement("Unicorn horn", 1).encounter(new Encounter("Unicow")).build());
        achievements.add(new AchievementBuilder("Yoink!", 0).requirement("Thieving", 5).build());
        achievements.add(new AchievementBuilder("Vial Deeds", 0).requirement("Coins", 10).reward("Vial of water", 1).build());
        achievements.add(new AchievementBuilder("They're Long and Pointy", 0).build());
        achievements.add(new AchievementBuilder("The Essence of Magic", 0).build());
        achievements.add(new AchievementBuilder("Star Seeker", 0).build());
        achievements.add(new AchievementBuilder("Silky Smooth", 0).requirement("Silk", 1).reward("Coins", 60).build());
        achievements.add(new AchievementBuilder("Red Revolution", 0).requirement("Plague City", 1).build());
        achievements.add(new AchievementBuilder("Preaching to the Infected", 0).requirement("Plague City", 1).build());
        achievements.add(new AchievementBuilder("Playing the Waiting Game", 0).build());
        achievements.add(new AchievementBuilder("Party Pooper", 0).requirement("Monk's Friend", 1).build());
        achievements.add(new AchievementBuilder("P-P-P-Pick Up Some Prizes", 0.1).lamp(Player.ALL_SKILLS, -25, 1).build());
        achievements.add(new AchievementBuilder("No Time to Lose", 0).requirement("Ring of duelling (8)", 1)
            .reward("Ring of duelling (1)", 1).build());
        achievements.add(new AchievementBuilder("Gone Fishing", 0).requirement("Fishing", 15).build());
        achievements.add(new AchievementBuilder("Going on a Summer Holiday", 0).requirement("Coins", 30).build());
        achievements.add(new AchievementBuilder("Dukes of Khazard", 0).encounter(new Encounter("Gnome troop")).build());
        achievements.add(new AchievementBuilder("Don't Eat the Pointy Bit", 0).requirement("Coins", 25).reward("Skewered kebab", 1)
            .build());
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
        achievements.add(new AchievementBuilder("Honestly, It's Not a Purse", 0).requirement("Runecrafting", 75).requirement("Coins", 50000)
            .requirement("Abyss (miniquest)", 1).requirement("Pure essence", 1).build());
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
        achievements.add(new AchievementBuilder("Living on a Prayer", 1).build());
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
        achievements.add(new AchievementBuilder("Meeting History, Again", 0).requirement("Meeting History", 1).build());
        achievements.add(new AchievementBuilder("I Wonder What This Does", 0).build());
        achievements.add(new AchievementBuilder("I Know a Shortcut", 0).requirement("Pure essence", 1).reward("Air rune", 1)
            .reward("Runecrafting", 10).build());
        achievements.add(new AchievementBuilder("Green Fingers", 0).requirement("Thieving", 38).reward("Thieving", 43).build());
        achievements.add(new AchievementBuilder("Fearless Fishing", 0).requirement("Sea Slug", 1).build());
        achievements.add(new AchievementBuilder("By the Bucketload", 0).requirement("The Hand in the Sand", 1)
            .reward("Bucket of sand", 84).build());
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
        achievements.add(new AchievementBuilder("Arise from the Ash", 0.05).requirement("In Pyre Need", 1)
            .encounter(new Encounter("Phoenix")).reward("Firemaking", 7500).reward("Fletching", 3000).reward("Crafting", 1000)
            .reward("Slayer", 5000).reward("Phoenix quill", 5).build());
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
        achievements.add(new AchievementBuilder("Attack - Sifu", 0).requirement("Attack pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Attack 5", -1).requirement("Attack", 5).build());
        achievements.add(new AchievementBuilder("Attack 10", -1).requirement("Attack", 10).build());
        achievements.add(new AchievementBuilder("Attack 20", -1).requirement("Attack", 20).build());
        achievements.add(new AchievementBuilder("Attack 30", -1).requirement("Attack", 30).build());
        achievements.add(new AchievementBuilder("Attack 40", -1).requirement("Attack", 40).build());
        achievements.add(new AchievementBuilder("Attack 50", -1).requirement("Attack", 50).build());
        achievements.add(new AchievementBuilder("Attack 60", -1).requirement("Attack", 60).build());
        achievements.add(new AchievementBuilder("Attack 70", -1).requirement("Attack", 70).build());
        achievements.add(new AchievementBuilder("Attack 80", -1).requirement("Attack", 80).build());
        achievements.add(new AchievementBuilder("Attack 90", -1).requirement("Attack", 90).build());
        achievements.add(new AchievementBuilder("Attack 92 (Halfway There)", -1).requirement("Attack", 92).build());
        achievements.add(new AchievementBuilder("Attack 99 (A Good Offense)", -1).requirement("Attack", 99).build());
        achievements.add(new AchievementBuilder("Ava", 0).requirement("Twin Furies", 862).build());
        achievements.add(new AchievementBuilder("Avast Ardougne!", 0).requirement("Coins", 30).build());
        achievements.add(new AchievementBuilder("Away with the Kalphites", 0).requirement("A Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("Axe'll Grease", 0).requirement("Blood Runs Deep", 1)
            .encounter(new Encounter("Dagannoth")).build());
        achievements.add(new AchievementBuilder("Azacorax's Rewards", 0).requirement("Rune Memories", 1).requirement("Magic", 50)
            .requirement("Prayer", 50).lamp(Arrays.asList("Magic", "Prayer"), 10000, 50).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 1", 0).requirement("Birthright of the Dwarves", 1)
            .requirement("Mining", 81).reward("Mining", 20000).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 2", 0).requirement("Azdaran fragment 1", 1).requirement("Mining", 83)
            .reward("Mining", 21000).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 3", 0).requirement("Azdaran fragment 2", 1).requirement("Mining", 85)
            .reward("Mining", 22000).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 4", 0).requirement("Azdaran fragment 3", 1).requirement("Mining", 87)
            .reward("Mining", 23000).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 5", 0).requirement("Azdaran fragment 4", 1).requirement("Mining", 89)
            .reward("Mining", 24000).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 6", 0).requirement("Azdaran fragment 5", 1).requirement("Mining", 91)
            .reward("Mining", 25000).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 7", 0).requirement("Azdaran fragment 6", 1).requirement("Mining", 92)
            .reward("Mining", 26000).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 8", 0).requirement("Azdaran fragment 7", 1).requirement("Mining", 93)
            .reward("Mining", 27000).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 9", 0).requirement("Azdaran fragment 8", 1).requirement("Mining", 94)
            .reward("Mining", 29000).build());
        achievements.add(new AchievementBuilder("Azdaran fragment 10", 0).requirement("Azdaran fragment 9", 1).requirement("Mining", 95)
            .reward("Mining", 33000).build());
        achievements.add(new AchievementBuilder("Azdaran Birthright", 0).requirement("Azdaran fragment 10", 1).build());
        achievements.add(new AchievementBuilder("B Sharp, Not Flat", 0.05).requirement("Plague's End", 1).reward("Crafting", 300)
            .reward("Construction", 200).reward("Harmonic dust", 4).build());
        achievements.add(new AchievementBuilder("Back Cran-door", 0).requirement("Dragon Slayer", 1).build());
        achievements.add(new AchievementBuilder("Balanced Combat Triangle", 0).requirement("Desperate Times", 1).build());
        achievements.add(new AchievementBuilder("Bandit Camp", 0).requirement("Desert Treasure", 1).build());
        achievements.add(new AchievementBuilder("Bandos's Memories", 0.05).requirement("The Mighty Fall", 1).reward("Divination", 130)
            .build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Freeing Sir Amik Varze", 0.5).requirement("Lost City", 1)
            .requirement("Recipe for Disaster: Another Cook's Quest", 1).requirement("Legends' Quest", 1).requirement("Bucket of milk", 1)
            .requirement("Pot of cream", 1).requirement("Sweetcorn", 1).requirement("Empty pot", 1).requirement("Raw chicken", 1)
            .encounter(new Encounter("Evil Chicken")).encounter(new Encounter("Black dragon")).reward("Quest points", 1)
            .reward("Cooking", 4000).reward("Constitution", 4000).build());
        achievements.add(new AchievementBuilder("Love Story", 1).requirement("Swan Song", 1)
            .requirement("Recipe for Disaster: Freeing Sir Amik Varze", 1).requirement("Magic", 77).requirement("Construction", 68)
            .requirement("Smithing", 68).requirement("Crafting", 67).requirement("Steel bar", 1).requirement("Mithril bar", 1)
            .requirement("Oak plank", 2).encounter(new Encounter(Arrays.asList(Collections.singletonList("Pit dog"),
                Collections.singletonList("Pit ogre"), Collections.singletonList("Pit rock protector"),
                Collections.singletonList("Pit scabarite"), Collections.singletonList("Pit black demon"),
                Collections.singletonList("Pit iron dragon")))).encounter(new Encounter("Zenevivia")).reward("Quest points", 2)
            .reward("Construction", 60000).reward("Magic", 50000).reward("Smithing", 40000).reward("Crafting", 40000).reward("Coins", 30000)
            .build());
        achievements.add(new AchievementBuilder("The Branches of Darkmeyer", 1.5).requirement("Legacy of Seergaze", 1)
            .requirement("Legends' Quest", 1).requirement("Woodcutting", 76).requirement("Fletching", 70).requirement("Magic", 70)
            .requirement("Slayer", 67).requirement("Crafting", 64).requirement("Farming", 63).requirement("Agility", 63)
            .encounter(new Encounter("Harold")).encounter(new Encounter("Vanstrom Klause")).reward("Quest points", 2)
            .reward("Agility", 20000).reward("Woodcutting", 50000).reward("Farming", 20000).reward("Fletching", 40000)
            .reward("Crafting", 20000).reward("Slayer", 25000).reward("Magic", 35000).lamp(Player.ALL_SKILLS, 50000, 60)
            .lamp(Player.ALL_SKILLS, 50000, 60).lamp(Player.ALL_SKILLS, 50000, 60).build());
        achievements.add(new AchievementBuilder("The Lord of Vampyrium", 2).requirement("The Branches of Darkmeyer", 1)
            .requirement("Attack", 75).requirement("Defence", 75).requirement("Strength", 75).requirement("Constitution", 75)
            .requirement("Construction", 79).requirement("Slayer", 78).requirement("Hunter", 76).encounter(new Encounter("Venator"))
            .encounter(new Encounter("Venator")).encounter(new Encounter("Venator")).encounter(new Encounter("Venator"))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Venator", "Venator", "Venator"))))
            .encounter(new Encounter("Lowernial Drakan")).encounter(new Encounter("Lowernial Drakan"))
            .encounter(new Encounter("Lowernial Drakan")).reward("Quest points", 2).reward("Construction", 75000).reward("Slayer", 50000)
            .reward("Hunter", 50000).reward("Sunspear (melee)", 1).reward("Sunspear (ranged)", 1).reward("Sunspear (magic)", 1)
            .lamp(Player.ALL_SKILLS, 75000, 75).lamp(Player.ALL_SKILLS, 75000, 75).lamp(Player.ALL_SKILLS, 75000, 75).build());
        achievements.add(new AchievementBuilder("River of Blood", 2).requirement("The Lord of Vampyrium", 1)
            .requirement("Defender of Varrock", 1).requirement("All Fired Up", 1).requirement("Herblore", 80).requirement("Attack", 78)
            .requirement("Constitution", 80).requirement("Ranged", 78).requirement("Magic", 78).requirement("Firemaking", 76)
            .requirement("Fletching", 75).requirement("Mining", 72).requirement("Guthix balance (4)", 1).requirement("Super restore (3)", 1)
            .requirement("Steel med helm", 3).requirement("Steel platebody", 3).requirement("Steel platelegs", 3)
            .requirement("Silver sickle", 4).encounter(new Encounter(Collections.singletonList(Arrays.asList("Vyrewatch", "Vyrewatch",
                "Vyrewatch")))).encounter(new Encounter(Arrays.asList(Collections.singletonList("Monk of Zamorak"),
                Collections.singletonList("Monk of Zamorak"), Collections.singletonList("Monk of Zamorak"),
                Collections.singletonList("Monk of Zamorak"), Collections.singletonList("Monk of Zamorak"),
                Collections.singletonList("Monk of Zamorak"), Collections.singletonList("Monk of Zamorak"),
                Collections.singletonList("Monk of Zamorak"), Collections.singletonList("Monk of Zamorak"),
                Collections.singletonList("Monk of Zamorak"), Arrays.asList("Zamorakian leader", "Zamorakian bodyguard"))))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Feral vampyre (RoB)", "Feral vampyre (RoB)",
                "Feral vampyre (RoB)"), Collections.singletonList("Wyrd")))).encounter(new Encounter(Collections.singletonList(
                Arrays.asList("Vampyre juvinate (RoB)", "Vampyre juvinate (RoB)", "Vampyre juvinate (RoB)"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Skeleton Hellhound", "Skeleton Hellhound",
                "Skeleton Hellhound", "Skeleton Hellhound", "Skeleton Hellhound", "Skeleton Hellhound", "Skeleton Hellhound"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Wyrd"),
                Collections.singletonList("Wyrd"), Collections.singletonList("Wyrd"), Collections.singletonList("Wyrd"),
                Collections.singletonList("Wyrd")))).reward("Quest points", 3).reward("Woodcutting", 800).reward("Herblore", 75000)
            .reward("Firemaking", 50000).reward("Fletching", 50000).reward("Mining", 50000).lamp(Player.ALL_SKILLS, 75000, 75)
            .lamp(Player.ALL_SKILLS, 75000, 75).lamp(Player.ALL_SKILLS, 75000, 75).build());
        achievements.add(new AchievementBuilder("Recipe for Disaster: Defeating the Culinaromancer", 0.25)
            .requirement("Recipe for Disaster: Freeing Evil Dave", 1).requirement("Recipe for Disaster: Freeing the Goblin generals", 1)
            .requirement("Recipe for Disaster: Freeing King Awowogei", 1).requirement("Recipe for Disaster: Freeing the Lumbridge Sage", 1)
            .requirement("Recipe for Disaster: Freeing the Mountain dwarf", 1).requirement("Recipe for Disaster: Freeing Pirate Pete", 1)
            .requirement("Recipe for Disaster: Freeing Sir Amik Varze", 1).requirement("Recipe for Disaster: Freeing Skrach Uglogwee", 1)
            .requirement("Desert Treasure", 1).requirement("Horror from the Deep", 1).requirement("Quest points", 176)
            .encounter(new Encounter("Agrith-Na-Na")).encounter(new Encounter("Flambeed")).encounter(new Encounter("Karamel"))
            .encounter(new Encounter("Dessourt")).encounter(new Encounter("Gelatinnoth Mother")).encounter(new Encounter("Culinaromancer"))
            .reward("Quest points", 1).lamp(Player.ALL_SKILLS, 20000, 50).build());
        achievements.add(new AchievementBuilder("Ritual of the Mahjarrat", 4).requirement("Enakhra's Lament", 1)
            .requirement("A Fairy Tale III - Battle at Ork's Rift", 1).requirement("Fight Arena", 1).requirement("Hazeel Cult", 1)
            .requirement("Rocking Out", 1).requirement("The Slug Menace", 1).requirement("A Tail of Two Cats", 1)
            .requirement("The Temple at Senntisten", 1).requirement("While Guthix Sleeps", 1).requirement("Crafting", 76)
            .requirement("Agility", 77).requirement("Mining", 76).requirement("Rope", 1).encounter(new Encounter("Armoured zombie"))
            .encounter(new Encounter("General Khazard")).encounter(new Encounter(Collections.singletonList(Arrays.asList(
                "Enhanced ice titan", "Enhanced ice titan")))).encounter(new Encounter(Collections.singletonList(Arrays.asList(
                    "Ice demon (ROTM)", "Ice demon (ROTM)")))).encounter(new Encounter(Collections.singletonList(Arrays.asList(
                        "Armoured zombie", "Armoured zombie", "Armoured zombie", "Armoured zombie")))).reward("Quest points", 3)
            .reward("Agility", 110000).reward("Crafting", 40000).reward("Mining", 40000).lamp(Player.ALL_SKILLS, 80000, 72)
            .lamp(Player.ALL_SKILLS, 80000, 72).lamp(Player.ALL_SKILLS, 80000, 72).build());
        achievements.add(new AchievementBuilder("Bane Tuner", 0).requirement("Ritual of the Mahjarrat", 1).build());
        achievements.add(new AchievementBuilder("Bank-Z", 0).requirement("Dimension of Disaster: Curse of Arrav", 1).build());
        achievements.add(new AchievementBuilder("Enchanted key miniquest", 0.25).requirement("Meeting History", 1).reward("Iron ore", 60)
            .reward("Mithril ore", 30).reward("Pure essence", 323).reward("Air rune", 15).reward("Mind rune", 20).reward("Earth rune", 5)
            .reward("Fire rune", 20).reward("Water rune", 30).reward("Law rune", 45).reward("Death rune", 30).reward("Iron arrow", 20)
            .reward("Steel arrow", 40).reward("Mithril arrow", 80).reward("Iron arrowhead", 40).reward("Guthix mjolnir", 1)
            .reward("Saradomin mjolnir", 1).reward("Zamorak mjolnir", 1).reward("Cosmic rune", 15).reward("Nature rune", 15)
            .reward("Chaos rune", 15).reward("Blood rune", 10).reward("Gold charm", 36).reward("Green charm", 4).reward("Crimson charm", 4)
            .reward("Blue charm", 4).reward("Uncut sapphire", 3).reward("Uncut emerald", 5).reward("Uncut ruby", 3).reward("Gold bar", 20)
            .reward("Coins", 8640).build());
        achievements.add(new AchievementBuilder("Banking History", 0).requirement("Enchanted key miniquest", 1).build());
        achievements.add(new AchievementBuilder("Banned For Life", 0).requirement("Ibis pouch", 1).requirement("Summoning", 56)
            .reward("Summoning", 1).build());
        achievements.add(new AchievementBuilder("Barbarian Scavenger", 5).requirement("Barbarian Firemaking", 1).build());
        achievements.add(new AchievementBuilder("Barking Up the Wrong Tree", 0).requirement("Woodcutting", 45).reward("Bark", 1)
            .reward("Woodcutting", 357).build());
        achievements.add(new AchievementBuilder("Baroo Quality", 0).requirement("Yak-hide armour (top)", 1)
            .requirement("Yak-hide armour (legs)", 1).requirement("Fremennik round shield", 1)
            .encounter(new Encounter("Dagannoth Supreme")).build());
        achievements.add(new AchievementBuilder("Barrowed Power I", 0).requirement("Rise of the Six", 5).build());
        achievements.add(new AchievementBuilder("Barrowed Power II", 0).requirement("Rise of the Six", 10).build());
        achievements.add(new AchievementBuilder("Barrowed Power III", 0).requirement("Rise of the Six", 25).build());
        achievements.add(new AchievementBuilder("Barrowed Power IV", 0).requirement("Rise of the Six", 50).build());
        achievements.add(new AchievementBuilder("Barrowed Power V", 0).requirement("Rise of the Six", 75).build());
        achievements.add(new AchievementBuilder("Barrowed Power VI", 0).requirement("Rise of the Six", 100).build());
        achievements.add(new AchievementBuilder("Dragon defender", 4).requirement("Attack", 65).requirement("Strength", 65).build());
        achievements.add(new AchievementBuilder("Barrowed Time", 0).requirement("Dragon defender", 1).requirement("Linza", 281)
            .requirement("Barrows", 1386).build());
        achievements.add(new AchievementBuilder("Barry", 0).requirement("Araxxi", 557).build());
        achievements.add(new AchievementBuilder("Battle of the Elements", 0).requirement("Crafting", 66).requirement("Air orb", 1)
            .requirement("Battlestaff", 1).reward("Crafting", 137).build());
        achievements.add(new AchievementBuilder("Beachcomber", 0).reward("Seaweed", 5).build());
        achievements.add(new AchievementBuilder("Because You're Iorwerth It", 0).requirement("Plague's End", 1)
            .encounter(new Encounter("Iorwerth scout")).build());
        achievements.add(new AchievementBuilder("Beggars Can't Be Choosers", 0.05).requirement("In Aid of the Myreque", 1)
            .requirement("Great maki", 1).build());
        achievements.add(new AchievementBuilder("Behemoth Notes", 0.5).requirement("Dungeoneering", 101).build());
        achievements.add(new AchievementBuilder("Belter of a Smelter", 0).requirement("Iron ore", 1).requirement("Coal", 2)
            .requirement("Smithing", 20).reward("Steel bar", 1).reward("Smithing", 3).build());
        achievements.add(new AchievementBuilder("Best Offence", 0).encounter(new Encounter(Collections.singletonList(
            Collections.singletonList("Kalphite King")), 2)).build());
        achievements.add(new AchievementBuilder("Better Not Touch", 0).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru")), 10)).build());
        achievements.add(new AchievementBuilder("Ring of fire", 0.1).requirement("All Fired Up", 1).requirement("Firemaking", 62)
            .requirement("Logs", 120).reward("Firemaking", 12137).build());
        achievements.add(new AchievementBuilder("Better Than Cursing The Darkness", 0).requirement("Bark", 1)
            .requirement("Ring of fire", 1).reward("Firemaking", 102).build());
        achievements.add(new AchievementBuilder("Beware of Pigzilla", 0).build());
        achievements.add(new AchievementBuilder("Beware of the Dog", 0).requirement("A Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("Big Chinchompa", 0.25).requirement("Hunter", 78).reward("Competence points", 1111)
            .build());
        achievements.add(new AchievementBuilder("Bipedal Mask", 0).requirement("Airuts", 102)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Ranged", "Magic", "Slayer"), 43680, 90).build());
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
        achievements.add(new AchievementBuilder("Blackout", 0).requirement("Queen Black Dragon", 1078).build());
        achievements.add(new AchievementBuilder("Blast and Hellfire", 0).requirement("Magic", 59).requirement("Fire rune", 3)
            .requirement("Air rune", 3).build());
        achievements.add(new AchievementBuilder("Bless is More", 0).requirement("Clay ring", 1).build());
        achievements.add(new AchievementBuilder("Blinded by Ramarno's Teaching", 0).requirement("Defender of Varrock", 1)
            .requirement("Redberry pie", 1).reward("Smithing", 1000).build());
        achievements.add(new AchievementBuilder("Blinded with Science", 0).requirement("Firemaking", 49)
            .requirement("Bullseye lantern (oil)", 1).reward("Bullseye lantern", 1).build());
        achievements.add(new AchievementBuilder("Blood Stained Treasure", 0.05).requirement("Legacy of Seergaze", 1)
            .reward("Blood rune", 100).build());
        achievements.add(new AchievementBuilder("Blooming Marvellous", 0).requirement("Nature Spirit", 1)
            .reward("Mort myre fungus", 1).build());
        achievements.add(new AchievementBuilder("Blowing Your Own Trumpet", 0).requirement("Mourning's End Part I", 1).build());
        achievements.add(new AchievementBuilder("Bombi", 0).requirement("Vorago (HM)", 6).requirement("Vorago", 69).build());
        achievements.add(new AchievementBuilder("Mogre miniquest", 0.25).requirement("Cooking", 20).requirement("Bucket of water", 1)
            .requirement("Bowl of water", 1).requirement("Bucket of milk", 1).requirement("Snape grass", 1).requirement("Chocolate dust", 1)
            .reward("Cooking", 53).build());
        achievements.add(new AchievementBuilder("Rag and Bone Man wish list", 2.5).requirement("Rag and Bone Man", 1)
            .requirement("Mogre miniquest", 1).requirement("Zogre Flesh Eaters", 1).requirement("Creature of Fenkenstrain", 1)
            .requirement("Slayer", 40).requirement("Coins", 196).requirement("Empty pot", 27).requirement("Logs", 27)
            .requirement("Mirror shield", 0).requirement("Spiny helmet", 0).encounter(new Encounter("Wolf")).encounter(new Encounter("Bat"))
            .encounter(new Encounter("Rat")).encounter(new Encounter("Baby blue dragon")).encounter(new Encounter("Ogre"))
            .encounter(new Encounter("Jogre")).encounter(new Encounter("Zogre")).encounter(new Encounter("Mogre"))
            .encounter(new Encounter("Dagannoth")).encounter(new Encounter("Desert snake")).encounter(new Encounter("Zombie"))
            .encounter(new Encounter("Werewolf")).encounter(new Encounter("Moss giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Ice giant")).encounter(new Encounter("Terrorbird")).encounter(new Encounter("Ghoul"))
            .encounter(new Encounter("Troll spectator")).encounter(new Encounter("Seagull")).encounter(new Encounter("Experiment"))
            .encounter(new Encounter("Rabbit")).encounter(new Encounter("Basilisk")).encounter(new Encounter("Lizard"))
            .encounter(new Encounter("Cave goblin")).encounter(new Encounter("Vulture")).encounter(new Encounter("Jackal"))
            .encounter(new Encounter("Undead cow")).reward("Prayer", 5000).build());
        achievements.add(new AchievementBuilder("Fur 'n' Seek wish list", 2.5).requirement("Fur 'n Seek", 1)
            .requirement("The Hunt for Surok (miniquest)", 1).requirement("Recipe for Disaster: Freeing King Awowogei", 1)
            .requirement("Barbarian Firemaking", 1).requirement("Slayer", 78).requirement("Elemental shield", 0).requirement("Coins", 2775)
            .requirement("Leaf-bladed sword", 0).requirement("Teasing stick", 0).requirement("Empty pot", 20).requirement("Logs", 21)
            .encounter(new Encounter("Turoth")).encounter(new Encounter("Crawling hand")).encounter(new Encounter("Ugthanki"))
            .encounter(new Encounter("Tortoise")).encounter(new Encounter("Wallasalki")).encounter(new Encounter("Bork"))
            .encounter(new Encounter("Monkey Guard")).encounter(new Encounter("Green dragon")).encounter(new Encounter("Blue dragon"))
            .encounter(new Encounter("Red dragon")).encounter(new Encounter("Black dragon")).encounter(new Encounter("Skeletal wyvern"))
            .encounter(new Encounter("Bronze dragon")).encounter(new Encounter("Iron dragon")).encounter(new Encounter("Steel dragon"))
            .encounter(new Encounter("Mithril dragon")).encounter(new Encounter("Big Snake")).encounter(new Encounter("Ice giant"))
            .encounter(new Encounter("Gorak")).encounter(new Encounter("Aquanite"))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Skeletal horror (Phase 1)"),
                Collections.singletonList("Skeletal horror (Phase 2)"),Collections.singletonList("Skeletal horror (Phase 3)"),
                Collections.singletonList("Skeletal horror (Phase 4)")))).reward("Slayer", 10000).reward("Prayer", 7000).build());
        achievements.add(new AchievementBuilder("Bone I Fired", 0).requirement("The Chosen Commander", 1).requirement("Bone bolts", 2)
            .requirement("Rag and Bone Man wish list", 1).requirement("Fur 'n' Seek wish list", 1).requirement("Ranged", 48)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Skeletal horror (Phase 1)"),
                Collections.singletonList("Skeletal horror (Phase 2)"), Collections.singletonList("Skeletal horror (Phase 3)"),
                Collections.singletonList("Skeletal horror (Phase 4)")))).reward("Slayer", 10000).reward("Prayer", 7000).build());
        achievements.add(new AchievementBuilder("Boosted Animal", 0).requirement("Fishing", 68).build());
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
        achievements.add(new AchievementBuilder("Vengeance", 0.75).requirement("Dungeoneering", 23).requirement("Agility", 55)
            .requirement("Thieving", 55).reward("Dungeoneering", 2410).reward("Dungeoneering token", 241)
            .lamp(Arrays.asList("Agility", "Thieving"), 25415, 1).build());
        achievements.add(new AchievementBuilder("Nadir", 0.75).requirement("Dungeoneering", 55).requirement("Thieving", 45)
            .requirement("Attack", 60).reward("Dungeoneering", 25430).reward("Dungeoneering token", 2543).reward("Attack", 37080).build());
        achievements.add(new AchievementBuilder("Thok It To 'Em", 0.75).requirement("Dungeoneering", 59).requirement("Strength", 70)
            .reward("Dungeoneering", 37080).reward("Dungeoneering token", 3708).reward("Strength", 75765).build());
        achievements.add(new AchievementBuilder("Thok Your Block Off", 0.75).requirement("Thok It To 'Em", 1).requirement("Strength", 75)
            .requirement("Dungeoneering", 71).reward("Dungeoneering", 53440).reward("Dungeoneering token", 5344).reward("Strength", 105010)
            .build());
        achievements.add(new AchievementBuilder("Bridge over Fremmy Waters", 0).requirement("Three's Company", 1)
            .requirement("Vengeance", 1).requirement("Nadir", 1).requirement("Thok It To 'Em", 1).requirement("Thok Your Block Off", 1)
            .build());
        achievements.add(new AchievementBuilder("Bring It All Back", 0).requirement("Ranged", 80).requirement("Attack", 85)
            .encounter(new Encounter("Twin Furies")).build());
        achievements.add(new AchievementBuilder("Ian lamp", 0).requirement("Attack", 10).requirement("Strength", 10)
                .requirement("Defence", 10).requirement("Ranged", 10).requirement("Magic", 10).requirement("Prayer", 10)
                .requirement("Constitution", 10).requirement("Mining", 10).requirement("Crafting", 10).requirement("Smithing", 10)
                .requirement("Fishing", 10).requirement("Cooking", 10).requirement("Firemaking", 10).requirement("Runecrafting", 10)
                .requirement("Woodcutting", 10).requirement("Dungeoneering", 10).requirement("Fletching", 10)
                .lamp(Player.ALL_SKILLS, 250, 10).build());
        achievements.add(new AchievementBuilder("Paul lamp", 0).requirement("Attack", 30).requirement("Strength", 30)
            .requirement("Defence", 30).requirement("Ranged", 30).requirement("Magic", 30).requirement("Prayer", 30)
            .requirement("Constitution", 30).requirement("Mining", 30).requirement("Crafting", 30).requirement("Smithing", 30)
            .requirement("Fishing", 30).requirement("Cooking", 30).requirement("Firemaking", 30).requirement("Runecrafting", 30)
            .requirement("Woodcutting", 30).requirement("Dungeoneering", 30).requirement("Fletching", 30)
            .lamp(Player.ALL_SKILLS, 1500, 30).build());
        achievements.add(new AchievementBuilder("Andrew lamp", 0).requirement("Attack", 50).requirement("Strength", 50)
            .requirement("Defence", 50).requirement("Ranged", 50).requirement("Magic", 50).requirement("Prayer", 50)
            .requirement("Constitution", 50).requirement("Mining", 50).requirement("Crafting", 50).requirement("Smithing", 50)
            .requirement("Fishing", 50).requirement("Cooking", 50).requirement("Firemaking", 50).requirement("Runecrafting", 50)
            .requirement("Woodcutting", 50).requirement("Dungeoneering", 50).requirement("Fletching", 50)
            .lamp(Player.ALL_SKILLS, 12000, 50).build());
        achievements.add(new AchievementBuilder("Brothers Gower", 0).requirement("Ian lamp", 1).requirement("Paul lamp", 1)
            .requirement("Andrew lamp", 1).build());
        achievements.add(new AchievementBuilder("Brothers in Arms", 0).requirement("Ritual of the Mahjarrat", 1)
            .requirement("Kindred Spirits", 1).requirement("Ahrim's staff", 0).requirement("Akrisae's war mace", 0)
            .requirement("Dharok's greataxe", 0).requirement("Guthan's warspear", 0).requirement("Karil's crossbow", 0)
            .requirement("Linza's hammer", 0).requirement("Torag's hammer", 0).requirement("Verac's flail", 0).requirement("Magic", 70)
            .requirement("Attack", 80).requirement("Prayer", 70).requirement("Strength", 70).requirement("Ranged", 70)
            .encounter(new Encounter("Ahrim the Blighted")).encounter(new Encounter("Dharok the Wretched"))
            .encounter(new Encounter("Linza the Disgraced")).encounter(new Encounter("Karil the Tainted"))
            .encounter(new Encounter("Torag the Corrupted")).encounter(new Encounter("Guthan the Infested"))
            .encounter(new Encounter("Akrisae the Doomed")).encounter(new Encounter("Verac the Defiled")).build());
        achievements.add(new AchievementBuilder("Bros Before Barrows", 0).requirement("Ritual of the Mahjarrat", 1)
            .encounter(new Encounter("Ahrim the Blighted")).encounter(new Encounter("Dharok the Wretched"))
            .encounter(new Encounter("Karil the Tainted")).encounter(new Encounter("Torag the Corrupted"))
            .encounter(new Encounter("Guthan the Infested")).encounter(new Encounter("Akrisae the Doomed"))
            .encounter(new Encounter("Verac the Defiled")).build());
        achievements.add(new AchievementBuilder("Brothers in More Arms", 0).requirement("Barrows totem", 6)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
                "Dharok the Wretched (ROTS)"), Arrays.asList("Guthan the Infested (ROTS)", "Ahrim the Blighted (ROTS)",
                "Verac the Defiled (ROTS)")), 4))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
                "Dharok the Wretched (ROTS)"), Arrays.asList("Guthan the Infested (ROTS)", "Verac the Defiled (ROTS)",
                "Ahrim the Blighted (ROTS)")), 4))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
                "Dharok the Wretched (ROTS)"), Arrays.asList("Ahrim the Blighted (ROTS)", "Verac the Defiled (ROTS)",
                "Guthan the Infested (ROTS)")), 4))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
                "Guthan the Infested (ROTS)"), Arrays.asList("Ahrim the Blighted (ROTS)", "Verac the Defiled (ROTS)",
                "Dharok the Wretched (ROTS)")), 4))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Dharok the Wretched (ROTS)",
                "Guthan the Infested (ROTS)"), Arrays.asList("Ahrim the Blighted (ROTS)", "Verac the Defiled (ROTS)",
                "Torag the Corrupted (ROTS)")), 4))
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Torag the Corrupted (ROTS)", "Dharok the Wretched (ROTS)",
                "Guthan the Infested (ROTS)"), Arrays.asList("Ahrim the Blighted (ROTS)", "Verac the Defiled (ROTS)",
                "Karil the Tainted (ROTS)")), 4)).build());
        achievements.add(new AchievementBuilder("Brutal Stuffies", 0).requirement("Zogre Flesh Eaters", 1)
            .requirement("Relicym's balm (4)", 1).build());
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
        achievements.add(new AchievementBuilder("Buy and Sell Some XP", 0).requirement("Thieving", 62)
            .requirement("Buyers and Cellars", 1).reward("Thieving", 2000).build());
        achievements.add(new AchievementBuilder("Buying Up Ancient Artefacts", 0).requirement("Desert Treasure", 1)
            .requirement("Coins", 80000).build());
        achievements.add(new AchievementBuilder("Cache Box", 0).requirement("Thieving", 40).requirement("Dungeoneering floors completed", 4)
            .build());
        achievements.add(new AchievementBuilder("Cadarn Tootin'", 0).requirement("Plague's End", 1).requirement("Desert Treasure", 1)
            .encounter(new Encounter("Cadarn magus")).build());
        achievements.add(new AchievementBuilder("Camping is in Tents", 0.05).build());
        achievements.add(new AchievementBuilder("Camping Trip", 0).requirement("Logs", 1).reward("Firemaking", 40).build());
        achievements.add(new AchievementBuilder("Can't Make an Omelette", 0).reward("Red spiders' eggs", 1).build());
        achievements.add(new AchievementBuilder("Can I Have Some Morvran", 1.5).requirement("Plague's End", 1)
            .requirement("Slayer", 85).requirement("Slayer point", 100).build());
        achievements.add(new AchievementBuilder("Can Opener", 0).requirement("Agility", 12).requirement("Woodcutting", 34)
            .requirement("Coins", 875).encounter(new Encounter("Bronze dragon")).build());
        achievements.add(new AchievementBuilder("Can You Dig It?", 0).requirement("Giant Mole", 1078).build());
        achievements.add(new AchievementBuilder("Canifis", 0).build());
        achievements.add(new AchievementBuilder("Careful, There Are Snakes", 0.05).requirement("Thieving", 31).build());
        achievements.add(new AchievementBuilder("Casting a Shadow", 0).requirement("Blissful shadow core", 1)
            .requirement("Divination", 81).requirement("Plague's End", 1).reward("Divination", 455).build());
        achievements.add(new AchievementBuilder("Casting Shadows", 0).requirement("Mourning's End Part II", 1)
            .requirement("Desert Treasure", 1).requirement("Magic", 52).requirement("Earth rune", 3).requirement("Death rune", 1)
            .encounter(new Encounter("Shadow")).build());
        achievements.add(new AchievementBuilder("Castles in the Sky", 0).build());
        achievements.add(new AchievementBuilder("Cat's Bane", 0.2).requirement("Dimension of Disaster: Coin of the Realm", 1).build());
        achievements.add(new AchievementBuilder("Catherby", 0).build());
        achievements.add(new AchievementBuilder("Myths of the White Lands cave painting 1", 0).requirement("Myths of the White Lands", 1)
            .requirement("Crafting", 30).reward("Crafting", 2000).build());
        achievements.add(new AchievementBuilder("Myths of the White Lands cave painting 2", 0).requirement("Myths of the White Lands", 1)
            .requirement("Agility", 55).reward("Agility", 10000).build());
        achievements.add(new AchievementBuilder("Myths of the White Lands cave painting 3", 0).requirement("Myths of the White Lands", 1)
            .requirement("Woodcutting", 80).reward("Woodcutting", 20000).build());
        achievements.add(new AchievementBuilder("Caving Into the Gains", 0).requirement("Myths of the White Lands", 1)
            .requirement("Myths of the White Lands cave painting 1", 1).requirement("Myths of the White Lands cave painting 2", 1)
            .requirement("Myths of the White Lands cave painting 3", 1).build());
        achievements.add(new AchievementBuilder("Cecilia, I'm Begging You, Please...", 0).requirement("One Piercing Note", 1)
            .build());
        achievements.add(new AchievementBuilder("Cement his Torment", 0).requirement("Black platelegs", 0)
            .requirement("Black platebody", 0).requirement("Black full helm", 0).requirement("Black 2h sword", 0)
            .requirement("Defence", 25).requirement("Summer's End", 1).encounter(new Encounter("Tormented wraith")).build());
        achievements.add(new AchievementBuilder("Chain Store", 0).requirement("Coins", 1440).requirement("Defence", 25)
            .reward("Black chainbody", 1).build());
        achievements.add(new AchievementBuilder("Broken Home lamp 1", 0).requirement("Broken Home", 1).requirement("Agility", 10)
            .requirement("Attack", 10).requirement("Strength", 10).requirement("Defence", 10).requirement("Ranged", 10)
            .requirement("Prayer", 10).requirement("Constitution", 10).requirement("Crafting", 10).requirement("Mining", 10)
            .requirement("Smithing", 10).requirement("Fishing", 10).requirement("Cooking", 10).requirement("Firemaking", 10)
            .requirement("Woodcutting", 10).requirement("Runecrafting", 10).requirement("Dungeoneering", 10).requirement("Fletching", 10)
            .requirement("Herblore", 10).requirement("Thieving", 10).requirement("Magic", 10).requirement("Slayer", 10)
            .requirement("Farming", 10).requirement("Construction", 10).requirement("Hunter", 10).requirement("Summoning", 10)
            .requirement("Divination", 10).lamp(Player.ALL_SKILLS, 1000, 10).build());
        achievements.add(new AchievementBuilder("Broken Home lamp 2", 0).requirement("Broken Home", 1).requirement("Agility", 20)
            .requirement("Attack", 20).requirement("Strength", 20).requirement("Defence", 20).requirement("Ranged", 20)
            .requirement("Prayer", 20).requirement("Constitution", 20).requirement("Crafting", 20).requirement("Mining", 20)
            .requirement("Smithing", 20).requirement("Fishing", 20).requirement("Cooking", 20).requirement("Firemaking", 20)
            .requirement("Woodcutting", 20).requirement("Runecrafting", 20).requirement("Dungeoneering", 20).requirement("Fletching", 20)
            .requirement("Herblore", 20).requirement("Thieving", 20).requirement("Magic", 20).requirement("Slayer", 20)
            .requirement("Farming", 20).requirement("Construction", 20).requirement("Hunter", 20).requirement("Summoning", 20)
            .requirement("Divination", 20).lamp(Player.ALL_SKILLS, 2000, 20).build());
        achievements.add(new AchievementBuilder("Broken Home lamp 3", 0).requirement("Broken Home", 1).requirement("Agility", 30)
            .requirement("Attack", 30).requirement("Strength", 30).requirement("Defence", 30).requirement("Ranged", 30)
            .requirement("Prayer", 30).requirement("Constitution", 30).requirement("Crafting", 30).requirement("Mining", 30)
            .requirement("Smithing", 30).requirement("Fishing", 30).requirement("Cooking", 30).requirement("Firemaking", 30)
            .requirement("Woodcutting", 30).requirement("Runecrafting", 30).requirement("Dungeoneering", 30).requirement("Fletching", 30)
            .requirement("Herblore", 30).requirement("Thieving", 30).requirement("Magic", 30).requirement("Slayer", 30)
            .requirement("Farming", 30).requirement("Construction", 30).requirement("Hunter", 30).requirement("Summoning", 30)
            .requirement("Divination", 30).lamp(Player.ALL_SKILLS, 4000, 30).build());
        achievements.add(new AchievementBuilder("Broken Home lamp 4", 0).requirement("Broken Home", 1).requirement("Agility", 40)
            .requirement("Attack", 40).requirement("Strength", 40).requirement("Defence", 40).requirement("Ranged", 40)
            .requirement("Prayer", 40).requirement("Constitution", 40).requirement("Crafting", 40).requirement("Mining", 40)
            .requirement("Smithing", 40).requirement("Fishing", 40).requirement("Cooking", 40).requirement("Firemaking", 40)
            .requirement("Woodcutting", 40).requirement("Runecrafting", 40).requirement("Dungeoneering", 40).requirement("Fletching", 40)
            .requirement("Herblore", 40).requirement("Thieving", 40).requirement("Magic", 40).requirement("Slayer", 40)
            .requirement("Farming", 40).requirement("Construction", 40).requirement("Hunter", 40).requirement("Summoning", 40)
            .requirement("Divination", 40).lamp(Player.ALL_SKILLS, 8000, 40).build());
        achievements.add(new AchievementBuilder("Broken Home lamp 5", 0).requirement("Broken Home", 1).requirement("Agility", 50)
            .requirement("Attack", 50).requirement("Strength", 50).requirement("Defence", 50).requirement("Ranged", 50)
            .requirement("Prayer", 50).requirement("Constitution", 50).requirement("Crafting", 50).requirement("Mining", 50)
            .requirement("Smithing", 50).requirement("Fishing", 50).requirement("Cooking", 50).requirement("Firemaking", 50)
            .requirement("Woodcutting", 50).requirement("Runecrafting", 50).requirement("Dungeoneering", 50).requirement("Fletching", 50)
            .requirement("Herblore", 50).requirement("Thieving", 50).requirement("Magic", 50).requirement("Slayer", 50)
            .requirement("Farming", 50).requirement("Construction", 50).requirement("Hunter", 50).requirement("Summoning", 50)
            .requirement("Divination", 50).lamp(Player.ALL_SKILLS, 16000, 50).build());
        achievements.add(new AchievementBuilder("Broken Home lamp 6", 0).requirement("Broken Home", 1).requirement("Agility", 60)
            .requirement("Attack", 60).requirement("Strength", 60).requirement("Defence", 60).requirement("Ranged", 60)
            .requirement("Prayer", 60).requirement("Constitution", 60).requirement("Crafting", 60).requirement("Mining", 60)
            .requirement("Smithing", 60).requirement("Fishing", 60).requirement("Cooking", 60).requirement("Firemaking", 60)
            .requirement("Woodcutting", 60).requirement("Runecrafting", 60).requirement("Dungeoneering", 60).requirement("Fletching", 60)
            .requirement("Herblore", 60).requirement("Thieving", 60).requirement("Magic", 60).requirement("Slayer", 60)
            .requirement("Farming", 60).requirement("Construction", 60).requirement("Hunter", 60).requirement("Summoning", 60)
            .requirement("Divination", 60).lamp(Player.ALL_SKILLS, 32000, 60).build());
        achievements.add(new AchievementBuilder("Broken Home lamp 7", 0).requirement("Broken Home", 1).requirement("Agility", 70)
            .requirement("Attack", 70).requirement("Strength", 70).requirement("Defence", 70).requirement("Ranged", 70)
            .requirement("Prayer", 70).requirement("Constitution", 70).requirement("Crafting", 70).requirement("Mining", 70)
            .requirement("Smithing", 70).requirement("Fishing", 70).requirement("Cooking", 70).requirement("Firemaking", 70)
            .requirement("Woodcutting", 70).requirement("Runecrafting", 70).requirement("Dungeoneering", 70).requirement("Fletching", 70)
            .requirement("Herblore", 70).requirement("Thieving", 70).requirement("Magic", 70).requirement("Slayer", 70)
            .requirement("Farming", 70).requirement("Construction", 70).requirement("Hunter", 70).requirement("Summoning", 70)
            .requirement("Divination", 70).lamp(Player.ALL_SKILLS, 48000, 70).build());
        achievements.add(new AchievementBuilder("Broken Home lamp 8", 0).requirement("Broken Home", 1).requirement("Agility", 80)
            .requirement("Attack", 80).requirement("Strength", 80).requirement("Defence", 80).requirement("Ranged", 80)
            .requirement("Prayer", 80).requirement("Constitution", 80).requirement("Crafting", 80).requirement("Mining", 80)
            .requirement("Smithing", 80).requirement("Fishing", 80).requirement("Cooking", 80).requirement("Firemaking", 80)
            .requirement("Woodcutting", 80).requirement("Runecrafting", 80).requirement("Dungeoneering", 80).requirement("Fletching", 80)
            .requirement("Herblore", 80).requirement("Thieving", 80).requirement("Magic", 80).requirement("Slayer", 80)
            .requirement("Farming", 80).requirement("Construction", 80).requirement("Hunter", 80).requirement("Summoning", 80)
            .requirement("Divination", 80).lamp(Player.ALL_SKILLS, 64000, 80).build());
        achievements.add(new AchievementBuilder("Broken Home lamp 9", 0).requirement("Broken Home", 1).requirement("Agility", 90)
            .requirement("Attack", 90).requirement("Strength", 90).requirement("Defence", 90).requirement("Ranged", 90)
            .requirement("Prayer", 90).requirement("Constitution", 90).requirement("Crafting", 90).requirement("Mining", 90)
            .requirement("Smithing", 90).requirement("Fishing", 90).requirement("Cooking", 90).requirement("Firemaking", 90)
            .requirement("Woodcutting", 90).requirement("Runecrafting", 90).requirement("Dungeoneering", 90).requirement("Fletching", 90)
            .requirement("Herblore", 90).requirement("Thieving", 90).requirement("Magic", 90).requirement("Slayer", 90)
            .requirement("Farming", 90).requirement("Construction", 90).requirement("Hunter", 90).requirement("Summoning", 90)
            .requirement("Divination", 90).lamp(Player.ALL_SKILLS, 96000, 90).build());
        achievements.add(new AchievementBuilder("Maria, You Gotta See Her", 0.6).requirement("Broken Home", 1)
            .lamp(Player.ALL_SKILLS, -8, 1).build());
        achievements.add(new AchievementBuilder("Challenge Maria", 0).requirement("Broken Home lamp 1", 1)
            .requirement("Broken Home lamp 2", 1).requirement("Broken Home lamp 3", 1).requirement("Broken Home lamp 4", 1)
            .requirement("Broken Home lamp 5", 1).requirement("Broken Home lamp 6", 1).requirement("Broken Home lamp 7", 1)
            .requirement("Broken Home lamp 8", 1).requirement("Broken Home lamp 9", 1).requirement("Maria, You Gotta See Her", 1).build());
        achievements.add(new AchievementBuilder("Challenge Vannaka", 0).requirement("Combat", 40).build());
        achievements.add(new AchievementBuilder("Challenging Chat", 0).build());
        achievements.add(new AchievementBuilder("Champion!", 0).requirement("Quest points", 33).build());
        achievements.add(new AchievementBuilder("Imp champion", 0).requirement("Champion!", 1).requirement("Imp", 3466)
            .encounter(new Encounter("Imp champion")).reward("Constitution", 385).reward("Slayer", 385).build());
        achievements.add(new AchievementBuilder("Goblin champion", 0).requirement("Champion!", 1).requirement("Goblin", 3466)
            .encounter(new Encounter("Goblin champion")).reward("Constitution", 532).reward("Slayer", 532).build());
        achievements.add(new AchievementBuilder("Skeleton champion", 0).requirement("Champion!", 1).requirement("Skeletons", 3466)
            .encounter(new Encounter("Skeleton champion")).reward("Constitution", 648).reward("Slayer", 648).build());
        achievements.add(new AchievementBuilder("Zombie champion", 0).requirement("Champion!", 1).requirement("Zombies", 3466)
            .encounter(new Encounter("Zombie champion")).reward("Constitution", 802).reward("Slayer", 802).build());
        achievements.add(new AchievementBuilder("Hobgoblin champion", 0).requirement("Champion!", 1).requirement("Hobgoblins", 3466)
            .encounter(new Encounter("Hobgoblin champion")).reward("Constitution", 997).reward("Slayer", 997).build());
        achievements.add(new AchievementBuilder("Giant champion", 0).requirement("Champion!", 1).requirement("Giant", 3466)
            .encounter(new Encounter("Giant champion")).reward("Constitution", 1245).reward("Slayer", 1245).build());
        achievements.add(new AchievementBuilder("Banshee champion", 0).requirement("Champion!", 1).requirement("Banshees", 3466)
            .encounter(new Encounter("Banshee champion")).reward("Constitution", 1584).reward("Slayer", 1584).build());
        achievements.add(new AchievementBuilder("Ghoul champion", 0).requirement("Champion!", 1).requirement("Ghoul", 3466)
            .encounter(new Encounter("Ghoul champion")).reward("Constitution", 2001).reward("Slayer", 2001).build());
        achievements.add(new AchievementBuilder("Earth warrior champion", 0).requirement("Champion!", 1)
            .requirement("Earth warrior", 3466).encounter(new Encounter("Earth warrior champion")).reward("Constitution", 2538)
            .reward("Slayer", 2538).build());
        achievements.add(new AchievementBuilder("Aberrant spectre champion", 0).requirement("Champion!", 1)
            .requirement("Aberrant spectres", 3466).encounter(new Encounter("Aberrant spectre champion")).reward("Constitution", 3232)
            .reward("Slayer", 3232).build());
        achievements.add(new AchievementBuilder("Jogre champion", 0).requirement("Champion!", 1).requirement("Jogre", 3466)
            .encounter(new Encounter("Jogre champion")).reward("Constitution", 5288).reward("Slayer", 5288).build());
        achievements.add(new AchievementBuilder("Mummy champion", 0).requirement("Champion!", 1).requirement("Mummy", 3466)
            .encounter(new Encounter("Mummy champion")).reward("Constitution", 6771).reward("Slayer", 6771).build());
        achievements.add(new AchievementBuilder("Lesser demon champion", 0).requirement("Champion!", 1).requirement("Lesser demon", 3466)
            .encounter(new Encounter("Lesser demon champion")).reward("Constitution", 8683).reward("Slayer", 8683).build());
        achievements.add(new AchievementBuilder("Leon d'Cour", 0).requirement("Imp champion", 1).requirement("Goblin champion", 1)
            .requirement("Skeleton champion", 1).requirement("Zombie champion", 1).requirement("Hobgoblin champion", 1)
            .requirement("Giant champion", 1).requirement("Banshee champion", 1).requirement("Ghoul champion", 1)
            .requirement("Earth warrior champion", 1).requirement("Aberrant spectre champion", 1).encounter(new Encounter("Leon d'Cour"))
            .reward("Constitution", 10845).reward("Slayer", 10845).build());
        achievements.add(new AchievementBuilder("Glophren", 0).requirement("Jogre champion", 1).requirement("Mummy champion", 1)
            .requirement("Lesser demon champion", 1).requirement("Leon d'Cour", 1).encounter(new Encounter("Glophren"))
            .reward("Constitution", 13927).reward("Slayer", 13927).build());
        achievements.add(new AchievementBuilder("Champions, What Champions?", 0).requirement("Glophren", 1).reward("Coins", 50000)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defence", "Constitution", "Prayer", "Summoning"), 10000, 50)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defence", "Constitution", "Prayer", "Summoning"), 10000, 50)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defence", "Constitution", "Prayer", "Summoning"), 10000, 50)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defence", "Constitution", "Prayer", "Summoning"), 10000, 50)
            .build());
        achievements.add(new AchievementBuilder("Change of a Dress", 0).requirement("Dungeoneering", 20).build());
        achievements.add(new AchievementBuilder("Changing of the Guard", 0).requirement("Defence", 60)
            .requirement("Black dragonhide coif", 0).requirement("Black dragonhide body", 0).requirement("Black dragonhide chaps", 0)
            .requirement("Black dragonhide boots", 0).requirement("Black dragonhide vambraces", 0).requirement("Black dragonhide shield", 0)
            .encounter(new Encounter("King Black Dragon")).build());
        achievements.add(new AchievementBuilder("Changing Rooms", 0).requirement("Construction", 40).requirement("Coins", 15000)
            .build());
        achievements.add(new AchievementBuilder("Ellie", 0).requirement("Chaos Elemental", 1078).build());
        achievements.add(new AchievementBuilder("Chaos Theory", 0).requirement("Revenant kills", 100000).requirement("Ellie", 1).build());
        achievements.add(new AchievementBuilder("Chaosteo", 0).reward("Prayer", 16).build());
        achievements.add(new AchievementBuilder("Gate Spectre-ations", 0).requirement("Impious ashes", 1).reward("Prayer", 16).build());
        achievements.add(new AchievementBuilder("Charter A Course", 0).requirement("Gate Spectre-ations", 1).requirement("Coins", 1300)
            .build());
        achievements.add(new AchievementBuilder("Checkmate", 0).requirement("Kalphite Queen", 1090).build());
        achievements.add(new AchievementBuilder("Chick'arra", 0).requirement("Kree'arra", 2156).build());
    }

    private void addAchievementsPhase2() {
        achievements.add(new AchievementBuilder("Child of Saradomin", 0).requirement("Prayer", 70).requirement("Construction", 16)
            .requirement("Coins", 5000).build());
        achievements.add(new AchievementBuilder("Chilling with Arrav", 0).requirement("Ritual of the Mahjarrat", 1)
            .reward("Prayer", 3000).build());
        achievements.add(new AchievementBuilder("Chinchompa Powered!", 0).requirement("Cheese", 1).build());
        achievements.add(new AchievementBuilder("Chippy Transport", 0).requirement("Love Story", 1).build());
        achievements.add(new AchievementBuilder("Chiselin' Conchiolin", 0).requirement("Blamish myre shell (round)", 1)
            .requirement("Crafting", 15).reward("Myre snelm (round)", 1).reward("Crafting", 32).build());
        achievements.add(new AchievementBuilder("Chivalry is Fed", 0).requirement("The Death of Chivalry", 1)
            .requirement("Cabbage seed", 12).requirement("Farming", 7).reward("Farming", 250).build());
        achievements.add(new AchievementBuilder("Chivalry is Threads", 0).requirement("The Death of Chivalry", 1)
            .encounter(new Encounter("Dawn")).build());
        achievements.add(new AchievementBuilder("The Death of Chivalry supply crate", 0).requirement("The Death of Chivalry", 1)
            .reward("Water rune", 200).reward("Fire rune", 100).build());
        achievements.add(new AchievementBuilder("Gilded cabbage", 0.05).requirement("The Death of Chivalry", 1).requirement("Strength", 60)
            .reward("Prayer", 10000).build());
        achievements.add(new AchievementBuilder("The Death of Chivalry ancient lamp", 0).requirement("The Death of Chivalry", 1)
            .requirement("Strength", 40).lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Ranged", "Magic", "Prayer",
                "Summoning"), 3500, 40).build());
        achievements.add(new AchievementBuilder("The Death of Chivalry prayer lamp", 0).requirement("The Death of Chivalry", 1)
            .requirement("Strength", 80).requirement("Prayer", 65).reward("Prayer", 60000).build());
        achievements.add(new AchievementBuilder("Chivalry is Dead", 0).requirement("The Death of Chivalry supply crate", 1)
            .requirement("Gilded cabbage", 1).requirement("The Death of Chivalry ancient lamp", 1)
            .requirement("The Death of Chivalry prayer lamp", 1).build());
        achievements.add(new AchievementBuilder("Circus of Fire", 0.25).requirement("The Firemaker's Curse", 1)
            .requirement("Some Like It Cold", 1).reward("Magic", 25006).reward("Ranged", 17710).reward("Agility", 13750)
            .reward("Firemaking", 19230).reward("Thieving", 14260).build());
        achievements.add(new AchievementBuilder("Citadelementary", 0).build());
        achievements.add(new AchievementBuilder("Claiming Azzanadra's Heart", 0).requirement("Heart of Stone", 1)
            .requirement("The Temple at Senntisten", 1).lamp(Player.ALL_SKILLS, -2, 1).build());
        achievements.add(new AchievementBuilder("Class Crown", 0).requirement("Menaphos reputation", 1200000).build());
        achievements.add(new AchievementBuilder("Classic Dragon Killing", 0).requirement("Attack", 80)
            .requirement("Dragonfire shield", 1).encounter(new Encounter("Vindicta")).build());
        achievements.add(new AchievementBuilder("Classic Rock", 0).encounter(new Encounter("Vorago", 7)).build());
        achievements.add(new AchievementBuilder("Claus Is Rising", 0).requirement("Carnillean Rising", 1)
            .encounter(new Encounter("Cave Wolf Matriarch")).reward("Flax", 3500).build());
        achievements.add(new AchievementBuilder("Clay More", 0).reward("Mining", 5).reward("Clay", 1).build());
        achievements.add(new AchievementBuilder("Claymation", 0.33).build());
        achievements.add(new AchievementBuilder("Climbing the Walls", 0).requirement("Agility", 11).requirement("Ranged", 19)
            .requirement("Strength", 37).requirement("Mithril grapple", 1).build());
        achievements.add(new AchievementBuilder("Clued-Up", 0).reward("Sealed clue scroll (easy)", 1).build());
        achievements.add(new AchievementBuilder("Clue's In The Monkey Drool", 0).requirement("Monkey Madness", 1).requirement("Banana", 178)
            .build());
        achievements.add(new AchievementBuilder("Collecting Memorabilia", 0).reward("Pale energy", 1).reward("Divination", 1).build());
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
        achievements.add(new AchievementBuilder("Commander Miniana", 0).requirement("Commander Zilyana", 2156).build());
        achievements.add(new AchievementBuilder("Commerce Break", 0).build());
        achievements.add(new AchievementBuilder("Complete History of Droalak", 0).requirement("Making History", 1).build());
        achievements.add(new AchievementBuilder("Ouroboros pouch", 2).requirement("In Aid of the Myreque", 1).build());
        achievements.add(new AchievementBuilder("Not Such a Rotten Idea", 7).requirement("Games necklace (8)", 1)
            .requirement("Darkness of Hallowvale", 1).requirement("Ouroboros pouch", 1).build());
        achievements.add(new AchievementBuilder("Complete Trekky", 3).requirement("Not Such a Rotten Idea", 1).build());
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
        achievements.add(new AchievementBuilder("Sing-Along-a-Seren Verse 6", 0.05).requirement("Plague's End", 1)
            .requirement("Harmony moss seed", 1).requirement("Herblore", 77).requirement("Farming", 75)
            .requirement("Juju farming potion (3)", 1).reward("Perfect juju farming potion (3)", 1).reward("Herblore", 109)
            .reward("Farming", 1133).build());
        achievements.add(new AchievementBuilder("Sing-Along-a-Seren Verse 7", 0).requirement("Plague's End", 1)
            .reward("Adamantite ore", 1).reward("Mining", 114).build());
        achievements.add(new AchievementBuilder("Long Way From Home", 0).requirement("Plague's End", 1).requirement("Agility", 77)
            .requirement("Summoning", 88).requirement("Light creature pouch", 1).reward("Agility", 704).reward("Summoning", 9).build());
        achievements.add(new AchievementBuilder("Hefin and Puffin'", 0).requirement("Plague's End", 1).requirement("Agility", 77)
            .build());
        achievements.add(new AchievementBuilder("Disco Impling", 0.5).requirement("Plague's End", 1).requirement("Hunter", 74)
            .reward("Hunter", 1746).build());
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
        achievements.add(new AchievementBuilder("Sharks are Good for the Elf", 0).requirement("Deadliest Catch", 1)
            .requirement("Regicide", 1).requirement("Fishing", 76).reward("Fishing", 110).reward("Raw shark", 1).build());
        achievements.add(new AchievementBuilder("Pretty and Witty and Dead", 0).requirement("Death tiara", 0)
            .requirement("Pure essence", 20).requirement("Runecrafting", 65).requirement("Mourning's End Part II", 1)
            .reward("Runecrafting", 200).reward("Death rune", 20).build());
        achievements.add(new AchievementBuilder("Papa Pawya", 0.05).requirement("Papaya tree seed", 1).requirement("Hunter", 66)
            .requirement("Farming", 57).requirement("Mourning's End Part I", 1).requirement("Box trap", 0).reward("Raw pawya meat", 1)
            .reward("Farming", 6173).reward("Hunter", 400).build());
        achievements.add(new AchievementBuilder("Mufflebirds", 0).requirement("Regicide", 1).requirement("Agility", 56).build());
        achievements.add(new AchievementBuilder("Light Transit", 0).requirement("Within the Light", 1).build());
        achievements.add(new AchievementBuilder("Iban You from Hurting Me!", 0).requirement("Underground Pass", 1)
            .requirement("Magic", 50).encounter(new Encounter("Disciple of Iban")).build());
        achievements.add(new AchievementBuilder("Driven, Underground", 0.1).requirement("Underground Pass", 1)
            .requirement("Thieving", 50).build());
        achievements.add(new AchievementBuilder("Tirannwn", 0).requirement("Regicide", 1).build());
        achievements.add(new AchievementBuilder("The Motherlode", 0).requirement("Tirannwn", 1).build());
        achievements.add(new AchievementBuilder("Tyrassed to Impress", 0).requirement("Regicide", 1).requirement("Tyras helm", 0)
            .build());
        achievements.add(new AchievementBuilder("Lime Ordeal", 0).requirement("Mining", 10).requirement("Regicide", 1)
            .reward("Mining", 26).reward("Limestone", 1).build());
        achievements.add(new AchievementBuilder("Fairy Liquid", 0).requirement("A Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("Leaf Me Alone", 0).requirement("Regicide", 1).build());
        achievements.add(new AchievementBuilder("Stand Still, Eluned!", 0).requirement("Mourning's End Part I", 1)
            .requirement("Coins", 2000).build());
        achievements.add(new AchievementBuilder("Sick and Twisted", 0).requirement("The Path of Glouphrie", 1)
            .encounter(new Encounter("Warped tortoise")).build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Easy", 0).requirement("Iban You from Hurting Me!", 1)
            .requirement("Driven, Underground", 1).requirement("Arandar-bout Way", 1).requirement("Blowing Your Own Trumpet", 1)
            .requirement("The Motherlode", 1).requirement("Tyrassed to Impress", 1).requirement("Lime Ordeal", 1)
            .requirement("Leaf Me Alone", 1).requirement("Fairy Liquid", 1).requirement("Stand Still, Eluned!", 1)
            .requirement("Casting Shadows", 1).requirement("Sick and Twisted", 1).lamp(Player.ALL_SKILLS, 10000, 47).build());
        achievements.add(new AchievementBuilder("Harrowed Lands", 0).requirement("Tirannwn Set Tasks - Easy", 1)
            .requirement("Clean harralander", 1).requirement("Herblore", 44).reward("Herblore", 72).reward("Harralander tar", 15)
            .build());
        achievements.add(new AchievementBuilder("Gnome Roaming", 0.05).requirement("The Prisoner of Glouphrie", 1).build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Medium", 0).requirement("Harrowed Lands", 1)
            .requirement("Bowing Out and About", 1).requirement("An Act of War", 1).requirement("Sharks are Good for the Elf", 1)
            .requirement("Gnome Roaming", 1).requirement("Mufflebirds", 1).requirement("The Circle of Life", 1).requirement("Papa Pawya", 1)
            .requirement("Pretty and Witty and Dead", 1).requirement("Light Transit", 1).requirement("Stranger and Stranger", 1)
            .lamp(Player.ALL_SKILLS, 30000, 68).build());
        achievements.add(new AchievementBuilder("Xena-Phile", 0).requirement("Smithing", 90).requirement("Plague's End", 1)
            .requirement("Harmonic dust", 1000).requirement("The Eyes of Glouphrie", 1).reward("Smithing", 1500)
            .reward("Attuned crystal dagger", 1).build());
        achievements.add(new AchievementBuilder("Weave Come A Long Way", 0).requirement("Plague's End", 1)
            .requirement("Ball of wool", 9).requirement("Agility", 90).requirement("Attack", 90).requirement("Strength", 90)
            .requirement("Defence", 90).requirement("Ranged", 90).requirement("Prayer", 90).requirement("Constitution", 90)
            .requirement("Crafting", 90).requirement("Mining", 90).requirement("Smithing", 90).requirement("Fishing", 90)
            .requirement("Cooking", 90).requirement("Firemaking", 90).requirement("Woodcutting", 90).requirement("Runecrafting", 90)
            .requirement("Dungeoneering", 90).requirement("Fletching", 90).requirement("Herblore", 90).requirement("Thieving", 90)
            .requirement("Magic", 90).requirement("Slayer", 90).requirement("Farming", 90).requirement("Construction", 90)
            .requirement("Hunter", 90).requirement("Summoning", 90).requirement("Divination", 90).reward("Crafting", 90).build());
        achievements.add(new AchievementBuilder("The Expensive Range", 0.05).requirement("Crafting", 89).requirement("Mining", 81)
            .requirement("Herblore", 76).requirement("Coins", 100000).requirement("Ranging potion (4)", 1)
            .requirement("Super ranging potion (4)", 1).reward("Mining", 70).reward("Crafting", 150).reward("Herblore", 144)
            .reward("Grand ranging potion (6)", 1).build());
        achievements.add(new AchievementBuilder("Seren Memories", 0.1).requirement("Fate of the Gods", 1).build());
        achievements.add(new AchievementBuilder("The Crested Guest is Best", 0).requirement("Plague's End", 1)
            .requirement("Seren Memories", 1).build());
        achievements.add(new AchievementBuilder("Robot of Sherwood", 0).requirement("Plague's End", 1).requirement("Thieving", 95)
            .reward("Thieving", 145).reward("Coins", 135).build());
        achievements.add(new AchievementBuilder("Elder tree grown", 0.05).requirement("Elder seed", 1).requirement("Plague's End", 1)
            .requirement("Farming", 90).reward("Farming", 23463).build());
        achievements.add(new AchievementBuilder("Respect Your Elders", 0).requirement("Elder tree grown", 1).requirement("Woodcutting", 90)
            .requirement("Fletching", 90).reward("Woodcutting", 325).reward("Fletching", 101).reward("Elder shortbow (u)", 1).build());
        achievements.add(new AchievementBuilder("Properly Metal", 0.15).requirement("Slayer", 95).requirement("Plague's End", 1)
            .requirement("Blood Runs Deep", 1).requirement("The Branches of Darkmeyer", 1).requirement("The Elder Kiln", 1)
            .requirement("Ritual of the Mahjarrat", 1).requirement("The Chosen Commander", 1).requirement("The Firemaker's Curse", 1)
            .requirement("The Void Stares Back", 1).requirement("One of a Kind", 1).build());
        achievements.add(new AchievementBuilder("99 With a Flake", 0).requirement("Flags unfurled", 1).build());
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
        achievements.add(new AchievementBuilder("Repressed", 0.05).reward("Pale energy", 108).reward("Divination", 272).build());
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
        achievements.add(new AchievementBuilder("The Root of the Problem", 0.05).requirement("Summer's End", 1)
            .requirement("Limpwurt seed", 1).requirement("Farming", 26).reward("Limpwurt root", 3).reward("Farming", 160).build());
        achievements.add(new AchievementBuilder("pUrE a ChAoS oF cOrPsE!", 0).requirement("Chaos Elemental", 1).build());
        achievements.add(new AchievementBuilder("Nerves of Stele", 0.05).build());
        achievements.add(new AchievementBuilder("I'm the King of the Wild!", 0).requirement("King Black Dragon", 1).build());
        achievements.add(new AchievementBuilder("Contract Killer", 0).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant"))
            .encounter(new Encounter("Fire giant")).encounter(new Encounter("Fire giant")).reward("Slayer", 967)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Magic", "Ranged", "Constitution"), 2065, 1).build());
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
        achievements.add(new AchievementBuilder("With a Ten-foot Pole", 0.05).requirement("Rat Catchers", 1).build());
        achievements.add(new AchievementBuilder("What Lies Below?", 0).requirement("What Lies Below", 1).requirement("Mining", 42)
            .requirement("Runecrafting", 35).requirement("Chaos talisman", 0).build());
        achievements.add(new AchievementBuilder("Making Learning Fun!", 0).reward("Coins", 2000).build());
        achievements.add(new AchievementBuilder("Stay Secure", 0.05).requirement("Making Learning Fun!", 1).reward("Coins", 8000)
            .reward("Fancy boots", 1).build());
        achievements.add(new AchievementBuilder("Unlocking Your Emotions", 0).requirement("Stay Secure", 1).build());
        achievements.add(new AchievementBuilder("The Body Shop", 0).requirement("Dragon Slayer", 1).build());
        achievements.add(new AchievementBuilder("Royale With Thieve", 0).requirement("Thieving", 40).reward("Coins", 30)
            .reward("Thieving", 46).build());
        achievements.add(new AchievementBuilder("Digsite pendant unlock", 0.5).requirement("The Dig Site", 1).build());
        achievements.add(new AchievementBuilder("Return to Senntisten", 0).requirement("Digsite pendant unlock", 1)
            .requirement("Ruby necklace", 1).requirement("Fire rune", 5).requirement("Cosmic rune", 1).reward("Magic", 59).build());
        achievements.add(new AchievementBuilder("Promised the Earth", 0).requirement("Tiara", 1).requirement("Earth talisman", 1)
            .reward("Earth tiara", 1).reward("Runecrafting", 32).build());
        achievements.add(new AchievementBuilder("Point of En-tree", 0).requirement("Tree Gnome Village", 1).build());
        achievements.add(new AchievementBuilder("Master Scrumper", 0).requirement("Garden of Tranquility", 1).reward("Farming", 12)
            .build());
        achievements.add(new AchievementBuilder("Like a Varrocket", 0).requirement("Air rune", 3).requirement("Fire rune", 1)
            .requirement("Law rune", 1).requirement("Magic", 25).reward("Magic", 35).build());
        achievements.add(new AchievementBuilder("For Fast Transactions", 0).requirement("Agility", 21).build());
        achievements.add(new AchievementBuilder("Flatpack Backpack", 0).requirement("Mahogany logs", 20).requirement("Coins", 30000)
            .reward("Mahogany plank", 20).build());
        achievements.add(new AchievementBuilder("Faster, Pussycat! Kill! Kill!", 2).requirement("Gertrude's Cat", 1).build());
        achievements.add(new AchievementBuilder("Engage", 0).requirement("Varrock balloon route", 1).requirement("Logs", 1).build());
        achievements.add(new AchievementBuilder("Double-strength Weaksauce", 0).requirement("Limpwurt root", 1)
            .requirement("Red spiders' eggs", 1).requirement("Coins", 5).reward("Strength potion (4)", 1).build());
        achievements.add(new AchievementBuilder("Dial V for Varrock", 0).requirement("A Fairy Tale II - Cure a Queen", 1).build());
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
            .requirement("Adamant bar", 1).reward("Adamant med helm", 1).reward("Smithing", 62).build());
        achievements.add(new AchievementBuilder("Living on the Edge", 0).requirement("Desert Treasure", 1).build());
        achievements.add(new AchievementBuilder("Lighten Up", 0).requirement("Dashing kebbit fur", 2).requirement("Coins", 800)
            .reward("Spottier cape", 1).build());
        achievements.add(new AchievementBuilder("It Belongs in a Museum", 0).requirement("Cleaning finds", 1).build());
        achievements.add(new AchievementBuilder("Kudos on the Kudos!", 0).reward("It Belongs in a Museum", 1)
            .requirement("Natural history quiz", 1).requirement("Defender of Varrock", 1).requirement("The Grand Tree", 1)
            .requirement("Hazeel Cult", 1).requirement("In Aid of the Myreque", 1).requirement("Meeting History", 1)
            .requirement("Merlin's Crystal", 1).requirement("Observatory Quest", 1).requirement("Rune Mysteries", 1)
            .requirement("A Tail of Two Cats", 1).build());
        achievements.add(new AchievementBuilder("Keeping Tabs on Varrock", 0).requirement("Fire rune", 1).requirement("Air rune", 3)
            .requirement("Law rune", 1).requirement("Soft clay", 1).requirement("Magic", 25).requirement("Mahogany plank", 2)
            .requirement("Gold leaf", 1).requirement("Construction", 67).reward("Magic", 35).reward("Varrock teleport tablet", 1)
            .reward("Construction", 580).build());
        achievements.add(new AchievementBuilder("Intersceptre", 0).encounter(new Encounter("Minotaur")).encounter(new Encounter("Minotaur"))
            .encounter(new Encounter("Minotaur")).encounter(new Encounter("Minotaur")).encounter(new Encounter("Minotaur"))
            .encounter(new Encounter("Minotaur")).encounter(new Encounter("Minotaur")).encounter(new Encounter("Minotaur"))
            .encounter(new Encounter("Minotaur")).encounter(new Encounter("Minotaur")).encounter(new Encounter("Minotaur"))
            .encounter(new Encounter("Minotaur")).encounter(new Encounter("Minotaur")).encounter(new Encounter("Minotaur"))
            .encounter(new Encounter("Minotaur")).encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler"))
            .encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler"))
            .encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler"))
            .encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler"))
            .encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler"))
            .encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Flesh crawler"))
            .encounter(new Encounter("Flesh crawler")).encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon"))
            .encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon"))
            .encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon"))
            .encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon"))
            .encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon"))
            .encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon"))
            .encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon"))
            .encounter(new Encounter("Catablepon")).encounter(new Encounter("Catablepon")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou"))
            .encounter(new Encounter("Ankou")).encounter(new Encounter("Ankou")).build());
        achievements.add(new AchievementBuilder("Hand-Me-Downs", 0).requirement("Family Crest", 1).build());
        achievements.add(new AchievementBuilder("Varrock Set Tasks - Hard", 0).requirement("Burning Bush", 1)
            .requirement("But It Won't Warp You Anywhere", 1).requirement("Lighten Up", 1).requirement("Put Your Smithing Hat On", 1)
            .requirement("Kudos on the Kudos!", 1).requirement("Who Ate All the Pie?", 1).requirement("Battle of the Elements", 1)
            .requirement("Intersceptre", 1).requirement("Changing Rooms", 1).requirement("Keeping Tabs on Varrock", 1)
            .requirement("Hand-Me-Downs", 1).requirement("Waka-Waka-Waka", 1).requirement("Living on the Edge", 1)
            .lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("Stick a Bork In Him, He's Done", 0).requirement("The Hunt for Surok (miniquest)", 1)
            .build());
        achievements.add(new AchievementBuilder("Splitting Headache", 0).requirement("The Temple at Senntisten", 1)
            .requirement("Prayer", 92).build());
        achievements.add(new AchievementBuilder("Red, Red Pies of Summer", 0).requirement("Cooking", 95).requirement("Strawberry", 1)
            .requirement("Watermelon", 1).requirement("Pot of flour", 1).reward("Summer pie", 1).reward("Cooking", 265).build());
        achievements.add(new AchievementBuilder("Nomadness", 0).requirement("Nomad's Requiem", 1).build());
        achievements.add(new AchievementBuilder("Mind Your Back", 0).requirement("What Lies Below", 1).requirement("Magic", 80)
            .build());
        achievements.add(new AchievementBuilder("Varrock Calls For Aid!", 0.2).requirement("Firemaking", 92)
            .requirement("Construction", 59).requirement("Smithing", 56).requirement("Crafting", 60).requirement("Agility", 64)
            .requirement("Prayer", 31).requirement("Strength", 60).requirement("All Fired Up", 1).requirement("Land of the Goblins", 1)
            .requirement("Troll Stronghold", 1).requirement("Logs", 280).requirement("Iron bar", 2).requirement("Plank", 4)
            .requirement("Bronze nails", 8).requirement("Jute fibre", 3).reward("Firemaking", 41579).build());
        achievements.add(new AchievementBuilder("It All Adze Up", 0.05).requirement("Varrock Calls For Aid!", 0).requirement("Acorn", 1)
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
        achievements.add(new AchievementBuilder("Lumbering Around", 0).reward("Logs", 1).reward("Woodcutting", 25).build());
        achievements.add(new AchievementBuilder("Limey", 0).requirement("Mining", 10).reward("Mining", 26).reward("Limestone", 1)
            .build());
        achievements.add(new AchievementBuilder("King of the Castle", 0).build());
        achievements.add(new AchievementBuilder("Jumping-off Point", 0).requirement("Agility", 13).build());
        achievements.add(new AchievementBuilder("Journey to the Centre of the Earth Altar", 0).requirement("Earth talisman", 0)
            .build());
        achievements.add(new AchievementBuilder("Jackanory", 0).requirement("Cup of tea", 1).build());
        achievements.add(new AchievementBuilder("Essential Facilitator", 0).build());
        achievements.add(new AchievementBuilder("Doing the Ironing", 0).requirement("Mining", 10).reward("Iron ore", 1).reward("Mining", 32)
            .build());
        achievements.add(new AchievementBuilder("Dog and Bone", 0).requirement("Bones", 1).build());
        achievements.add(new AchievementBuilder("Varrock Set Tasks - Easy", 0).requirement("Strike a Pose", 1)
            .requirement("Essential Facilitator", 1).requirement("Doing the Ironing", 1).requirement("Plank You Very Much", 1)
            .requirement("Making Learning Fun!", 1).requirement("Jumping-off Point", 1).requirement("Lumbering Around", 1)
            .requirement("Read All About It", 1).requirement("Dog and Bone", 1).requirement("Pot Stop", 1)
            .requirement("On the Ragged Edge", 1).requirement("Relocation, Relocation, Relocation", 1)
            .requirement("It Belongs in a Museum", 1).requirement("Journey to the Centre of the Earth Altar", 1)
            .requirement("Jackanory", 1).requirement("Limey", 1).requirement("Sherpa's Delight", 1).requirement("King of the Castle", 1)
            .requirement("Stick the Knife In", 1).lamp(Player.ALL_SKILLS, 1000, 30).build());
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
        achievements.add(new AchievementBuilder("Grand Candle", 0).requirement("Coins", 3).reward("White candle", 1).build());
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
        achievements.add(new AchievementBuilder("Water Palaver", 0.05).requirement("Water rune", 150).requirement("Cosmic rune", 15)
            .requirement("Unpowered orb", 5).requirement("Magic", 56).reward("Magic", 330).reward("Water orb", 5).build());
        achievements.add(new AchievementBuilder("Twisted Fire Starter", 0).requirement("Magic logs", 1).requirement("Firemaking", 75)
            .reward("Firemaking", 303).build());
        achievements.add(new AchievementBuilder("The Short of It", 0).requirement("Magic shortbow (u)", 1)
            .requirement("Fletching", 80).requirement("Bowstring", 1).reward("Magic shortbow", 1).reward("Fletching", 83).build());
        achievements.add(new AchievementBuilder("See Yew at Five", 0).requirement("Woodcutting", 60).reward("Yew logs", 5)
            .reward("Woodcutting", 875).build());
        achievements.add(new AchievementBuilder("Prayer of Attorney", 0).requirement("Knight Waves training ground", 1)
            .requirement("Prayer", 70).requirement("Defence", 70).build());
        achievements.add(new AchievementBuilder("Island Hopper", 0).requirement("Iron crossbow", 0).requirement("Mithril grapple", 1)
            .requirement("Agility", 36).requirement("Ranged", 39).requirement("Strength", 22).build());
        achievements.add(new AchievementBuilder("Gonna Need a Bigger Boat", 0).requirement("Fishing", 76).reward("Raw shark", 5)
            .reward("Fishing", 550).build());
        achievements.add(new AchievementBuilder("Gonna Need a Bigger Range", 0).requirement("Raw shark", 5).requirement("Cooking", 80)
            .requirement("Family Crest", 1).reward("Shark", 5).reward("Cooking", 1050).build());
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
                Collections.singletonList("Tower Archer (west)")))).build());
        achievements.add(new AchievementBuilder("Mastering the Elements", 0).requirement("The Elemental Workshop I", 1)
            .encounter(new Encounter("Fire elemental")).encounter(new Encounter("Water elemental"))
            .encounter(new Encounter("Earth elemental")).encounter(new Encounter("Air elemental")).build());
        achievements.add(new AchievementBuilder("King Coal", 0.1).requirement("Coal", -224).build());
        achievements.add(new AchievementBuilder("It's Only a Model", 0).requirement("Law rune", 1).requirement("Air rune", 5)
            .requirement("Magic", 45).reward("Magic", 55).build());
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
            .encounter(new Encounter("Human werewolf")).build());
        achievements.add(new AchievementBuilder("Cranius Lupus", 0.05).requirement("Agility", 25)
            .requirement("Creature of Fenkenstrain", 1).reward("Agility", 750).build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Easy", 0).requirement("Chiselin' Conchiolin", 1)
            .requirement("It's Only Wafer Thin", 1).requirement("Dislike-Anthrope", 1).requirement("Cranius Lupus", 1)
            .requirement("Lab Clean-Up Assistant", 1).requirement("Fortified Spirit", 1).requirement("Struck A-Ghast", 1)
            .requirement("Blooming Marvellous", 1).requirement("Only Going Forward, We Can't Find Reverse", 1)
            .requirement("If It Bleeds...", 1).requirement("Wurt A Bundle", 1).lamp(Player.ALL_SKILLS, 4000, 25).build());
        achievements.add(new AchievementBuilder("Whip: It Good", 0).requirement("Slayer", 85)
            .encounter(new Encounter("Abyssal demon")).build());
        achievements.add(new AchievementBuilder("Thoroughly A-Ghast", 0).requirement("Complete Trekky", 1).requirement("Coins", 50000)
            .requirement("Summoning", 87).reward("Summoning", 1).build());
        achievements.add(new AchievementBuilder("Set It On Fiyr", 0).requirement("Fiyr remains", 1).requirement("Firemaking", 80)
            .requirement("Magic pyre logs", 1).requirement("Shades of Mort'ton", 1).reward("Firemaking", 404).build());
        achievements.add(new AchievementBuilder("On Wings of Bling", 0).requirement("The Branches of Darkmeyer", 1).build());
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
            .requirement("Runespan points", 2000).build());
        achievements.add(new AchievementBuilder("Raising The Stakes", 0).requirement("The Branches of Darkmeyer", 1)
            .requirement("Silver sickle", 1).reward("Fletching", 100).reward("Woodcutting", 200).reward("Blisterwood polearm", 1)
            .build());
        achievements.add(new AchievementBuilder("Just One More Key...", 0).requirement("Columbarium key", 1).build());
        achievements.add(new AchievementBuilder("I Brought Your Stuff Back", 0).requirement("Karil's coif", 0).requirement("Karil's top", 0)
            .requirement("Karil's skirt", 0).requirement("Karil's crossbow", 0).requirement("Defence", 70).requirement("Ranged", 70)
            .build());
        achievements.add(new AchievementBuilder("Huge Success", 0).requirement("Desert Treasure", 1).requirement("Construction", 50)
            .requirement("Coins", 100000).requirement("Magic", 66).requirement("Law rune", 200).requirement("Blood rune", 100)
            .reward("Magic", 380).build());
        achievements.add(new AchievementBuilder("Lair of Tarn Razorlor (miniquest)", 0.75).requirement("Haunted Mine", 1)
            .requirement("Slayer", 40).encounter(new Encounter("Tarn Razorlor")).reward("Slayer", 5000).build());
        achievements.add(new AchievementBuilder("Detarnation", 0).requirement("Lair of Tarn Razorlor (miniquest)", 1).build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Hard", 0).requirement("Detarnation", 1)
            .requirement("Runecraft Carrier", 1).requirement("Shade-Shattering Ka-Bloom", 1)
            .requirement("They'll Just Throw It Away Again", 1).requirement("Time Salver", 1).requirement("Huge Success", 1)
            .requirement("I Brought Your Stuff Back", 1).requirement("Just One More Key...", 1).requirement("Raising The Stakes", 1)
            .requirement("Trekkin' Ain't Easy", 1).requirement("Better Than Cursing The Darkness", 1).lamp(Player.ALL_SKILLS, 20000, 65)
            .build());
        achievements.add(new AchievementBuilder("Who You Gonna Ring?", 0).requirement("A Fairy Tale II - Cure a Queen", 1).build());
        achievements.add(new AchievementBuilder("Travelling on the Slime Trail", 0).requirement("Ghosts Ahoy", 1).build());
        achievements.add(new AchievementBuilder("The Yeast They Can Do", 0).requirement("Empty pot", 1)
            .requirement("The Restless Ghost", 1).reward("Ale yeast", 1).build());
        achievements.add(new AchievementBuilder("The Higher, The Better", 0).requirement("Slayer", 45)
            .encounter(new Encounter("Infernal mage")).build());
        achievements.add(new AchievementBuilder("The Beer Inn-spectre", 0).requirement("Cooking", 14).requirement("Bucket of water", 2)
            .requirement("Apple mush", 4).requirement("Barley malt", 2).requirement("Ale yeast", 1).build());
        achievements.add(new AchievementBuilder("Ready? Trek!", 0.05).requirement("In Aid of the Myreque", 1).build());
        achievements.add(new AchievementBuilder("Polterheist", 0).requirement("Mining", 55).requirement("Haunted Mine", 1)
            .reward("Mithril ore", 1).reward("Mining", 80).build());
        achievements.add(new AchievementBuilder("Plenty Mort Where That Came From", 0).requirement("Shade key", 1).build());
        achievements.add(new AchievementBuilder("Obvious Forgery", 0).requirement("Dwarf Cannon", 1).requirement("Steel bar", 1)
            .requirement("Smithing", 35).reward("Cannonball", 4).reward("Smithing", 25).build());
        achievements.add(new AchievementBuilder("Izzy Wizzy Let's Get Lizzy", 0).requirement("Rope", 0)
            .requirement("Small fishing net", 0).requirement("Hunter", 29).reward("Hunter", 152).reward("Green salamander", 1).build());
        achievements.add(new AchievementBuilder("I Wonder How Far It Ghost?", 0).requirement("In Search of the Myreque", 1).build());
        achievements.add(new AchievementBuilder("Fun Guy But Bitter", 0.05).requirement("Farming", 53)
            .requirement("Bittercap mushroom spore", 1).reward("Farming", 413).reward("Bittercap mushroom", 6).build());
        achievements.add(new AchievementBuilder("Flamtaer Will Get You Everywhere", 0).requirement("Shades of Mort'ton", 1)
            .requirement("Coins", 13000).build());
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
        achievements.add(new AchievementBuilder("Take Your Pick", 0).reward("Mining", 10).reward("Copper ore", 1).build());
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
        achievements.add(new AchievementBuilder("Grinding My Gears", 0).requirement("Empty pot", 1).reward("Pot of flour", 1)
            .reward("Cooking", 1).build());
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
        achievements.add(new AchievementBuilder("Ratatouille", 0).requirement("Raw rat meat", 1).requirement("Logs", 1)
            .reward("Cooked meat", 1).reward("Cooking", 30).reward("Firemaking", 40).build());
        achievements.add(new AchievementBuilder("Nowt Tool Look At", 0).build());
        achievements.add(new AchievementBuilder("Morgan the Merrier", 0).requirement("Clay ring", 1).reward("Coins", 10).build());
        achievements.add(new AchievementBuilder("Money Down the Drayn", 0).build());
        achievements.add(new AchievementBuilder("Klept-Old-Man-ia", 0).build());
        achievements.add(new AchievementBuilder("It Was Dead Already!", 0).reward("Logs", 1).reward("Woodcutting", 25).build());
        achievements.add(new AchievementBuilder("Iron On", 0).requirement("Mining", 10).reward("Iron ore", 1).reward("Mining", 32)
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
            .requirement("Runecrafting", 57).requirement("Water talisman", 0).reward("Runecrafting", 162).reward("Water rune", 100)
            .build());
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
        achievements.add(new AchievementBuilder("Where's The Beef?", 0).requirement("Pot of flour", 1).build());
        achievements.add(new AchievementBuilder("Weeping Willow", 0).requirement("Woodcutting", 30).reward("Willow logs", 1)
            .reward("Woodcutting", 67).build());
        achievements.add(new AchievementBuilder("Steel Justice", 0).requirement("Steel bar", 2).requirement("Smithing", 36)
            .reward("Smithing", 75).reward("Steel longsword", 1).build());
        achievements.add(new AchievementBuilder("One Day, You Shall Be a Fork", 0).requirement("Silver ore", 1)
            .requirement("Smithing", 20).reward("Smithing", 3).reward("Silver bar", 1).build());
        achievements.add(new AchievementBuilder("Made to Order", 0).requirement("Silver bar", 1).requirement("Crafting", 16)
            .reward("Unstrung symbol", 1).reward("Crafting", 50).build());
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
        achievements.add(new AchievementBuilder("Fruity Catch", 0).reward("Fishing", 10).reward("Raw shrimps", 1).build());
        achievements.add(new AchievementBuilder("Five a Day", 0).reward("Banana", 5).build());
        achievements.add(new AchievementBuilder("Karamja Set Tasks - Easy", 0).requirement("Five a Day", 1)
            .requirement("I'm Lichen This!", 1).requirement("Golden Shores", 1).requirement("Put to Port in Port Sarim", 1)
            .requirement("Avast Ardougne!", 1).requirement("Show That You Cairn", 1).requirement("Fruity Catch", 1)
            .requirement("Beachcomber", 1).requirement("TzHaar Wars", 1).requirement("It's a Jungle Ogre", 1)
            .lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("Walkies!", 0.05).requirement("Summoning", 90).requirement("Agility", 15).build());
        achievements.add(new AchievementBuilder("Tread Carefully", 0).requirement("Agility", 74).requirement("Shilo Village", 1)
            .build());
        achievements.add(new AchievementBuilder("The Power of Lava", 0).requirement("TzTok-Jad", 1).build());
        achievements.add(new AchievementBuilder("Ten in a Row", 1).requirement("Combat", 100).requirement("Slayer", 50)
            .requirement("Shilo Village", 1).requirement("While Guthix Sleeps", 1).requirement("Slayer task streak", 9).build());
        achievements.add(new AchievementBuilder("It's a Snap", 0).requirement("Herblore", 63).requirement("Vial of water", 1)
            .requirement("Red spiders' eggs", 1).requirement("Agility arena ticket", 10).reward("Super restore (3)", 1)
            .reward("Herblore", 142).build());
        achievements.add(new AchievementBuilder("Crunchy Coating", 0).requirement("Cooking", 80).requirement("Raw shark", 1)
            .reward("Shark", 1).reward("Cooking", 210).build());
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
        achievements.add(new AchievementBuilder("They Like Me! They Really Like Me!", 0.4).requirement("Jungle Potion", 1)
            .requirement("Woodcutting", 10).reward("Woodcutting", 3000).build());
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
        achievements.add(new AchievementBuilder("The Good Stuff", 0).requirement("Coins", 3).reward("Wizard's mind bomb", 1).build());
        achievements.add(new AchievementBuilder("Stand and Deliver", 0).encounter(new Encounter("Highwayman")).build());
        achievements.add(new AchievementBuilder("Sniffing Out the Mole", 0).build());
        achievements.add(new AchievementBuilder("Sir Mitt", 0).build());
        achievements.add(new AchievementBuilder("Mudskip the Light Fantastic", 0).build());
        achievements.add(new AchievementBuilder("Making My Mind Up", 0).requirement("Mind talisman", 1).requirement("Tiara", 1)
            .reward("Mind tiara", 1).reward("Runecrafting", 27).build());
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
        achievements.add(new AchievementBuilder("...You'd Best Come A-cookin'", 0).requirement("Raw rocktail", 1)
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
            .requirement("...You'd Best Come A-cookin'", 1).requirement("Concentration is Key", 1).requirement("I Swear I Heard It Scream", 1)
            .requirement("I've Changed My Mind!", 1).requirement("A String and a Flare", 1).requirement("Altar-ed State", 1)
            .lamp(Player.ALL_SKILLS, 30000, 90).lamp(Player.ALL_SKILLS, 30000, 90).lamp(Player.ALL_SKILLS, 50000, 84)
            .lamp(Player.ALL_SKILLS, 50000, 72).build());
        achievements.add(new AchievementBuilder("Why Oh Wyvern", 0).requirement("The Elemental Workshop I", 1).requirement("Slayer", 72)
            .encounter(new Encounter("Skeletal wyvern")).build());
        achievements.add(new AchievementBuilder("The Stonemasons", 0).requirement("Mining", 60).build());
        achievements.add(new AchievementBuilder("The Mogre Mash", 0).requirement("Mogre miniquest", 1).requirement("Coins", 60)
            .requirement("Slayer", 32).encounter(new Encounter("Mogre")).build());
        achievements.add(new AchievementBuilder("Mass Production", 0).requirement("Pure essence", 28).requirement("Runecrafting", 56)
            .requirement("Mind tiara", 0).reward("Mind rune", 140).reward("Runecrafting", 154).build());
        achievements.add(new AchievementBuilder("It Spoiled My View", 0).requirement("Yew seed", 1).requirement("Farming", 60)
            .requirement("Woodcutting", 60).reward("Farming", 7151).reward("Woodcutting", 175).reward("Yew logs", 1).build());
        achievements.add(new AchievementBuilder("It Matches My Eyes", 0).requirement("The Hand in the Sand", 1)
            .requirement("Coins", 20).requirement("Cape (black)", 1).build());
        achievements.add(new AchievementBuilder("I Heard You Like Mudskips", 0).requirement("A Fairy Tale II - Cure a Queen", 1)
            .build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Hard", 0).requirement("It Matches My Eyes", 1)
            .requirement("Child of Saradomin", 1).requirement("Mass Production", 1).requirement("It Spoiled My View", 1)
            .requirement("The Stonemasons", 1).requirement("I Heard You Like Mudskips", 1).requirement("The Mogre Mash", 1)
            .requirement("Why Oh Wyvern", 1).requirement("Banned For Life", 1).requirement("A Knight in the Darkness", 1)
            .lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("They Have Families to Feed", 0).requirement("Thieving", 40).reward("Thieving", 46)
            .reward("Coins", 30).build());
        achievements.add(new AchievementBuilder("These Aren't the Coins You're Looking For", 0).requirement("Garden of Tranquility", 1)
            .build());
        achievements.add(new AchievementBuilder("Stoic Sweetcorn Guardian", 0).requirement("Farming", 23).requirement("Sweetcorn seed", 3)
            .requirement("Empty sack", 1).requirement("Watermelon", 1).requirement("Bronze spear", 1).reward("Farming", 17).build());
        achievements.add(new AchievementBuilder("Look Spiffy For Tiffy", 0).requirement("Initiate hauberk", 0)
            .requirement("Initiate sallet", 1).requirement("Initiate cuisse", 1).requirement("Prayer", 10).requirement("Defence", 25)
            .requirement("Recruitment Drive", 1).build());
        achievements.add(new AchievementBuilder("Kitty Litter", 0).requirement("Rat Catchers", 1).build());
        achievements.add(new AchievementBuilder("It's Nothing Personal", 0).requirement("White Knight rank points", 101).build());
        achievements.add(new AchievementBuilder("Is It So Hard to Walk Round?", 0).requirement("Agility", 26).build());
        achievements.add(new AchievementBuilder("Ice the Icy", 0).encounter(new Encounter("Ice giant")).build());
        achievements.add(new AchievementBuilder("Fruit of the Loom", 0).requirement("Willow branch", 6).requirement("Crafting", 36)
            .reward("Basket", 1).reward("Crafting", 56).build());
        achievements.add(new AchievementBuilder("Do They Come in Other Colours?", 0.05).requirement("The Knight's Sword", 1)
            .requirement("Smithing", 13).reward("Mining", 17).reward("Blurite limbs", 1).reward("Smithing", 25).build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Medium", 0).requirement("Fruit of the Loom", 1)
            .requirement("Is It So Hard to Walk Round?", 1).requirement("Climbing the Walls", 1).requirement("It's Nothing Personal", 1)
            .requirement("Ice the Icy", 1).requirement("Blinded with Science", 1).requirement("They Have Families to Feed", 1)
            .requirement("Stoic Sweetcorn Guardian", 1).requirement("Look Spiffy For Tiffy", 1)
            .requirement("Do They Come in Other Colours?", 1).requirement("These Aren't the Coins You're Looking For", 1)
            .requirement("Kitty Litter", 1).lamp(Player.ALL_SKILLS, 5000, 40).build());
        achievements.add(new AchievementBuilder("Wiggle Room", 0).requirement("One Piercing Note", 1).build());
        achievements.add(new AchievementBuilder("Touring Gear", 0).requirement("Desert shirt", 0).requirement("Desert robe", 0)
            .requirement("Desert boots", 0).build());
        achievements.add(new AchievementBuilder("Slash Fund", 0).requirement("Waterskin (4)", 0).reward("Woodcutting", 10).build());
        achievements.add(new AchievementBuilder("Seems Legit", 0.05).requirement("Icthlarin's Little Helper", 1).requirement("Thieving", 21)
            .reward("Thieving", 600).reward("Coins", 250).build());
        achievements.add(new AchievementBuilder("Memento Mori", 0).build());
        achievements.add(new AchievementBuilder("Kookookachat", 0).requirement("Stolen Hearts", 1).build());
        achievements.add(new AchievementBuilder("I Like to Watch", 0).build());
        achievements.add(new AchievementBuilder("Fool's Gold", 0).requirement("Bird snare", 1).requirement("Hunter", 5)
            .reward("Hunter", 48).reward("Bird snare", 1).build());
        achievements.add(new AchievementBuilder("Fire at Will", 0).requirement("Runecrafting", 14).requirement("Pure essence", 1)
            .reward("Fire rune", 1).reward("Runecrafting", 7).build());
        achievements.add(new AchievementBuilder("Extra Cheese", 0).requirement("Magic", 7).requirement("Cosmic rune", 3)
            .requirement("Water rune", 3).reward("Magic", 52).reward("Cosmic rune", 1).build());
        achievements.add(new AchievementBuilder("Don't You Dare Close Your Eyes", 0).requirement("Coins", 1000).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Easy", 0).requirement("Assassin's Feed", 1)
            .requirement("Touring Gear", 1).requirement("Memento Mori", 1).requirement("Fool's Gold", 1)
            .requirement("Don't You Dare Close Your Eyes", 1).requirement("Slash Fund", 1).requirement("Kookookachat", 1)
            .requirement("Fire at Will", 1).requirement("Seems Legit", 1).requirement("Extra Cheese", 1).requirement("I Like to Watch", 1)
            .requirement("Wiggle Room", 1).lamp(Player.ALL_SKILLS, 2000, 29).build());
        achievements.add(new AchievementBuilder("Dominion Tower unlocked", 0).requirement("Diamond in the Rough", 1)
            .requirement("The Death of Chivalry", 1).requirement("Vampyre Slayer", 1).requirement("Demon Slayer", 1)
            .requirement("Wanted!", 1).requirement("Dragon Slayer", 1).requirement("Mountain Daughter", 1)
            .requirement("The Fremennik Trials", 1).requirement("Troll Stronghold", 1).requirement("Lost City", 1)
            .requirement("Holy Grail", 1).requirement("Shadow of the Storm", 1).requirement("Fight Arena", 1)
            .requirement("Spirits of the Elid", 1).requirement("Troll Romance", 1).requirement("Between a Rock...", 1)
            .requirement("Contact!", 1).requirement("Family Crest", 1).requirement("Haunted Mine", 1).requirement("Horror from the Deep", 1)
            .build());
        achievements.add(new AchievementBuilder("No More Nomad...No More!", 0).requirement("Nomad's Requiem", 1)
            .requirement("Dominion Tower unlocked", 1).encounter(new Encounter(Arrays.asList(Collections.singletonList("Nomad"),
                Collections.singletonList("Nomad")))).build());
        achievements.add(new AchievementBuilder("I Eat Dagannoths For Breakfast", 0).requirement("Blood Runs Deep", 1)
            .requirement("Dominion Tower unlocked", 1).encounter(new Encounter(Collections.singletonList(Arrays.asList("Dagannoth mother",
                "Dagannoth Mother (BRD)", "Dagannoth sentinel", "Dagannoth sentinel")))).build());
        achievements.add(new AchievementBuilder("Revenge of the Evil Chickens", 0).requirement("Dominion Tower unlocked", 1)
            .requirement("Recipe for Disaster: Freeing Sir Amik Varze", 1).encounter(new Encounter(Collections.singletonList(Arrays.asList(
                "Evil Chicken", "Evil Chicken", "Evil Chicken", "Evil Chicken", "Evil Chicken", "Evil Chicken", "Evil Chicken",
                "Evil Chicken", "Evil Chicken", "Evil Chicken", "Evil Chicken", "Evil Chicken", "Evil Chicken", "Evil Chicken",
                "Evil Chicken")))).build());
        achievements.add(new AchievementBuilder("The Fire! It Burns! (easy version)", 0).encounter(new Encounter("Sunfreet (easy)"))
            .build());
        achievements.add(new AchievementBuilder("The Fire! It Burns!", 0).requirement("Dominion Tower unlocked", 1)
            .encounter(new Encounter("Sunfreet")).build());
        achievements.add(new AchievementBuilder("You'll Never Defeat Me", 0).requirement("Dominion Tower unlocked", 1)
            .requirement("Dream Mentor", 1).encounter(new Encounter(Collections.singletonList(Arrays.asList("The Inadequacy",
                "The Everlasting", "The Untouchable", "The Illusive")))).build());
        achievements.add(new AchievementBuilder("Indigestion", 0).requirement("Recipe for Disaster: Defeating the Culinaromancer", 1)
            .requirement("Dominion Tower unlocked", 1).encounter(new Encounter(Collections.singletonList(Arrays.asList("Agrith-Na-Na",
                "Flambeed", "Karamel", "Dessourt", "Gelatinnoth Mother", "Culinaromancer")))).build());
        achievements.add(new AchievementBuilder("Just Die Already", 0).requirement("Blood Runs Deep", 1)
            .requirement("Dominion Tower unlocked", 1).encounter(new Encounter(Collections.singletonList(Arrays.asList("Dagannoth sentinel",
                "Dagannoth sentinel", "Dagannoth sentinel", "Dagannoth sentinel", "Dagannoth sentinel", "Dagannoth sentinel")))).build());
        achievements.add(new AchievementBuilder("Do a Minion, Take Notes", 0).requirement("Dominion page", 20).build());
        achievements.add(new AchievementBuilder("Finish Him! (DT)", 0).requirement("Dominion Tower unlocked", 1)
            .requirement("The Curse of Arrav", 1).requirement("The Fremennik Trials", 1).requirement("Fight Arena", 1)
            .requirement("A Void Dance", 1).requirement("Mountain Daughter", 1).requirement("Spirits of the Elid", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Arrav", "Koschei the Deathless", "General Khazard",
                "Black Knight guardian", "The Kendal", "Black golem", "White golem", "Grey golem")))).build());
        achievements.add(new AchievementBuilder("Hey! Eat Power-up", 0).requirement("Dominion Tower unlocked", 1)
            .requirement("The Chosen Commander", 1).requirement("Lair of Tarn Razorlor (miniquest)", 1).requirement("Missing My Mummy", 1)
            .requirement("Recipe for Disaster: Defeating the Culinaromancer", 1).encounter(new Encounter(Collections.singletonList(
                Arrays.asList("Solus Dellagar", "Delrith", "Count Draynor", "Melzar the Mad", "Sigmund (TCC)", "Tarn Razorlor",
                    "The Draugen", "The Kendal", "Tumeken's shadow 5", "Culinaromancer", "Elvarg", "Treus Dayth"))))
            .reward("Dominion tower bosses", 2).build());
        achievements.add(new AchievementBuilder("Sun Shade", 0.35).requirement("Do No Evil", 1).requirement("Dream Mentor", 1)
            .requirement("While Guthix Sleeps", 1).requirement("The Temple at Senntisten", 1).requirement("Legends' Quest", 1)
            .requirement("The Curse of Arrav", 1).requirement("My Arm's Big Adventure", 1).requirement("The Void Stares Back", 1)
            .requirement("Love Story", 1).requirement("Desert Treasure", 1)
            .requirement("Recipe for Disaster: Defeating the Culinaromancer", 1).requirement("Monkey Madness", 1)
            .requirement("Dominion tower bosses", 500).requirement("Do a Minion, Take Notes", 1)
            .requirement("Revenge of the Evil Chickens", 1).requirement("Finish Him! (DT)", 1).requirement("Just Die Already", 1)
            .requirement("No More Nomad...No More!", 1).requirement("I Eat Dagannoths For Breakfast", 1).requirement("Indigestion", 1)
            .requirement("You'll Never Defeat Me", 1).requirement("Hey! Eat Power-up", 1).requirement("The Fire! It Burns!", 1)
            .requirement("The Fire! It Burns! (easy version)", 1).build());
        achievements.add(new AchievementBuilder("Staff on Stryke", 0).requirement("Slayer", 77)
            .encounter(new Encounter("Desert strykewyrm")).build());
        achievements.add(new AchievementBuilder("Room Service", 0).requirement("Thieving", 91).reward("Strength", 275).build());
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
        achievements.add(new AchievementBuilder("Nipped in the Bug", 0).requirement("Dominion tower bosses", 450).build());
        achievements.add(new AchievementBuilder("Ability to fletch broads", 0).requirement("Slayer point", 300).build());
        achievements.add(new AchievementBuilder("More Fletcher than Sumona", 0).requirement("Smoking Kills", 1)
            .requirement("Ability to fletch broads", 1).requirement("Fletching", 52).requirement("Headless arrow", 15)
            .requirement("Broad arrowheads", 15).reward("Fletching", 225).reward("Broad arrows", 15).build());
        achievements.add(new AchievementBuilder("Ludikeris", 0).requirement("Contact!", 1).encounter(new Encounter("Kalphite guardian"))
            .build());
        achievements.add(new AchievementBuilder("Ice-Cold Killer", 0).requirement("Desert Treasure", 1).requirement("Magic", 70)
            .requirement("Death rune", 2).requirement("Water rune", 4).build());
        achievements.add(new AchievementBuilder("Enaqua", 0).requirement("Enakhra's Lament", 1).requirement("Waterskin (0)", 1)
            .reward("Waterskin (4)", 1).build());
        achievements.add(new AchievementBuilder("Drafty in Here", 0).requirement("Smoking Kills", 1).requirement("Slayer", 65)
            .encounter(new Encounter("Dust devil")).build());
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
        achievements.add(new AchievementBuilder("Faster than a Speeding Bullet", 0).requirement("Eagles' Peak", 1)
            .requirement("Rope", 1).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Medium", 0).requirement("So Su Me", 1)
            .requirement("Faster than a Speeding Bullet", 1).requirement("A Bridge Not Far", 1).requirement("Heathen Idle", 1)
            .requirement("Away with the Kalphites", 1).requirement("All Square", 1).requirement("Goat Harralander?", 1)
            .requirement("Taken for Granite", 1).requirement("Unbeetleable", 1).requirement("An Teak", 1).requirement("Overcut", 1)
            .lamp(Player.ALL_SKILLS, 8000, 43).build());
        achievements.add(new AchievementBuilder("You're Not the Boss of Me", 0.05).build());
        achievements.add(new AchievementBuilder("Untouchable", 0.05).build());
        achievements.add(new AchievementBuilder("The Lone Dungeoneer", 0.05).build());
        achievements.add(new AchievementBuilder("Tales of Old", 0).requirement("Three's Company", 1).build());
        achievements.add(new AchievementBuilder("Take It From the Top", 0).requirement("Dungeoneering floors completed", 1).build());
        achievements.add(new AchievementBuilder("Sinking Fast", 0.1).build());
        achievements.add(new AchievementBuilder("Setting Up", 0.05).requirement("Smithing", 7)
            .requirement("Dungeoneering floors completed", 2).reward("Smithing", 125).build());
        achievements.add(new AchievementBuilder("Kitchen Aid", 0).build());
        achievements.add(new AchievementBuilder("It's Dangerous to go Alone", 0.05).build());
        achievements.add(new AchievementBuilder("Invisible Ink", 0).reward("Firemaking", 25).build());
        achievements.add(new AchievementBuilder("Gorajo Fandango", 0.05).requirement("Dungeoneering floors completed", 4).build());
        achievements.add(new AchievementBuilder("Fashion Victim", 0).requirement("Setting Up", 1).build());
        achievements.add(new AchievementBuilder("Dere-licked", 0.05).requirement("Dungeoneering", 23).build());
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
        achievements.add(new AchievementBuilder("Gulega-d to Rest", 0.1).requirement("Dungeoneering", 95).build());
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Elite", 0).requirement("Any fin is Possible", 1)
            .requirement("Orbful", 1).requirement("Top Hat", 1).requirement("In the Darkness Bind Them", 1).requirement("Pass the Port", 1)
            .requirement("Gulega-d to Rest", 1).lamp(Player.ALL_SKILLS, 60000, 98).lamp(Player.ALL_SKILLS, 50000, 90)
            .lamp(Player.ALL_SKILLS, 50000, 90).lamp(Player.ALL_SKILLS, 50000, 90).build());
        achievements.add(new AchievementBuilder("The Wanderer", 0).requirement("Runecrafting", 50).requirement("Fletching", 48)
            .requirement("Dungeoneering floors completed", 2).reward("Fletching", 59).reward("Runecrafting", 39)
            .reward("Magic", 39).build());
        achievements.add(new AchievementBuilder("Thanks for the Memories", 0).requirement("Dungeoneering floors completed", 5)
            .requirement("Divination", 70).reward("Divination", 8).build());
        achievements.add(new AchievementBuilder("Stacked", 0).requirement("Salt in the Wound", 1).build());
        achievements.add(new AchievementBuilder("Occult Classic", 0.1).requirement("Dungeoneering", 71).build());
        achievements.add(new AchievementBuilder("Lawful Crafting", 0).requirement("Runecrafting", 54)
            .requirement("Dungeoneering floors completed", 2).build());
        achievements.add(new AchievementBuilder("Kinprovements", 0).requirement("Dungeoneering token", 323215).build());
        achievements.add(new AchievementBuilder("Hoof Rot", 0.1).requirement("Dungeoneering", 65).build());
        achievements.add(new AchievementBuilder("Rapid Renewal", 0).requirement("Prayer", 65).requirement("Dungeoneering", 65)
            .requirement("Dungeoneering token", 38000).build());
        achievements.add(new AchievementBuilder("Healing Factor", 0).requirement("Rapid Renewal", 1).build());
        achievements.add(new AchievementBuilder("Get Stuffed", 0.05).requirement("Cooking", 69).requirement("Farming", 68)
            .requirement("Dungeoneering floors completed", 4).reward("Cooking", 242).reward("Farming", 6).build());
        achievements.add(new AchievementBuilder("Epic Epic", 0).requirement("Bridge over Fremmy Waters", 1).build());
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Hard", 0).requirement("Occult Classic", 1)
            .requirement("Stacked", 1).requirement("Kinprovements", 1).requirement("Lawful Crafting", 1)
            .requirement("Thanks for the Memories", 1).requirement("Healing Factor", 1).requirement("Alcrabaholic", 1)
            .requirement("Hoof Rot", 1).requirement("A Prayer Opportunity", 1).requirement("The Wanderer", 1).requirement("Get Stuffed", 1)
            .requirement("Epic Epic", 1).reward("Dungeoneering token", 38000).lamp(Player.ALL_SKILLS, 20000, 74).build());
        achievements.add(new AchievementBuilder("You Got Some Nice Drapes There", 0.1).requirement("Dungeoneering", 32).build());
        achievements.add(new AchievementBuilder("Up to the Gods", 0.05).reward("Prayer", 640).build());
        achievements.add(new AchievementBuilder("Totem Pole Position", 0.1).build());
        achievements.add(new AchievementBuilder("Tactical Retreat", 0).requirement("Magic", 32).build());
        achievements.add(new AchievementBuilder("Spinal Trap", 0.05).requirement("Fletching", 43).requirement("Hunter", 40)
            .requirement("Dungeoneering floors completed", 3).reward("Fletching", 79).build());
        achievements.add(new AchievementBuilder("Port Enter", 0).requirement("Dungeoneering floors completed", 5)
            .requirement("Divination", 45).build());
        achievements.add(new AchievementBuilder("Nice to meet you, Wall", 0.1).requirement("Dungeoneering", 35).build());
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
        achievements.add(new AchievementBuilder("Stay Safe", 0.05).reward("Coins", 10000).reward("Safety gloves", 1)
            .lamp(Player.ALL_SKILLS, 500, 1).lamp(Player.ALL_SKILLS, 500, 1).build());
        achievements.add(new AchievementBuilder("Zarosian Memories", 0.25).requirement("Fate of the Gods", 1).build());
        achievements.add(new AchievementBuilder("Hopespear's Will (miniquest)", 0.25).requirement("Land of the Goblins", 1)
            .requirement("A Fairy Tale II - Cure a Queen", 1).requirement("Desert Treasure", 1).requirement("Prayer", 40)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Snothead"), Collections.singletonList("Snailfeet"),
                Collections.singletonList("Mosschin"), Collections.singletonList("Redeyes"), Collections.singletonList("Strongbones"))))
            .reward("Prayer", 13750).build());
        achievements.add(new AchievementBuilder("Yaktwee's a Charm", 0).requirement("Charm sprites", 1000).build());
        achievements.add(new AchievementBuilder("Boric's Task I (miniquest)", 0.1).requirement("What's Mine is Yours", 1)
            .requirement("Mining", 30).requirement("Coal", 30).reward("Mining", 30).lamp(Arrays.asList("Mining", "Smithing"), 4500, 1)
            .build());
        achievements.add(new AchievementBuilder("Boric's Task II (miniquest)", 0.1).requirement("Boric's Task I (miniquest)", 1)
            .requirement("Mining", 40).encounter(new Encounter("Living rock brawler")).encounter(new Encounter("Living rock brawler"))
            .encounter(new Encounter("Living rock brawler")).encounter(new Encounter("Living rock brawler"))
            .encounter(new Encounter("Living rock brawler")).reward("Mining", 3500).lamp(Arrays.asList("Mining", "Smithing"), 10500, 1)
            .build());
        achievements.add(new AchievementBuilder("Boric's Task III (miniquest)", 0.25).requirement("Boric's Task II (miniquest)", 1)
            .requirement("Mining", 60).reward("Mining", 16376).lamp(Arrays.asList("Mining", "Smithing"), 24000, 1).build());
        achievements.add(new AchievementBuilder("Doric's Task I (miniquest)", 0.1).requirement("What's Mine is Yours", 1)
            .requirement("Smithing", 10).requirement("Iron bar", 4).reward("Smithing", 410)
            .lamp(Arrays.asList("Mining", "Smithing"), 750, 1).build());
        achievements.add(new AchievementBuilder("Doric's Task II (miniquest)", 0.1).requirement("Doric's Task I (miniquest)", 1)
            .requirement("Death Plateau", 1).requirement("Smithing", 20).requirement("Steel bar", 10)
            .requirement("Bronze bar", 2).reward("Smithing", 1275).lamp(Arrays.asList("Mining", "Smithing"), 1500, 1).build());
        achievements.add(new AchievementBuilder("Doric's Task III (miniquest)", 0.25).requirement("Doric's Task II (miniquest)", 1)
            .requirement("Smithing", 30).requirement("Mithril bar", 8).reward("Smithing", 1710)
            .lamp(Arrays.asList("Mining", "Smithing"), 2250, 1).build());
        achievements.add(new AchievementBuilder("Doric's Task IV (miniquest)", 0.75).requirement("Doric's Task III (miniquest)", 1)
            .requirement("Smithing", 40).requirement("Adamant bar", 48).reward("Smithing", 13944)
            .lamp(Arrays.asList("Mining", "Smithing"), 4500, 1).build());
        achievements.add(new AchievementBuilder("Doric's Task V (miniquest)", 0.25).requirement("Doric's Task IV (miniquest)", 1)
            .requirement("Smithing", 50).requirement("Rune bar", 12).requirement("Steel platebody", 4).reward("Smithing", 8080)
            .lamp(Arrays.asList("Mining", "Smithing"), 15000, 1).build());
        achievements.add(new AchievementBuilder("Doric's Task VI (miniquest)", 0.25).requirement("Doric's Task V (miniquest)", 1)
            .requirement("Smithing", 60).requirement("Orikalkum bar", 16).reward("Smithing", 13600)
            .lamp(Arrays.asList("Mining", "Smithing"), 24000, 1).build());
        achievements.add(new AchievementBuilder("Doric's Task VII (miniquest)", 0.25).requirement("Doric's Task VI (miniquest)", 1)
            .requirement("Smithing", 65).reward("Smithing", 12000).lamp(Arrays.asList("Mining", "Smithing"), 36000, 1).build());
        achievements.add(new AchievementBuilder("Doric's Task VIII (miniquest)", 0.1).requirement("Doric's Task VII (miniquest)", 1)
            .requirement("Smithing", 70).requirement("Necronium bar", 20).reward("Smithing", 30000)
            .lamp(Arrays.asList("Mining", "Smithing"), 60000, 1).build());
        achievements.add(new AchievementBuilder("What's Mine Is Also Doric's", 0).requirement("Doric's Task VIII (miniquest)", 1)
            .requirement("Boric's Task III (miniquest)", 1).build());
        achievements.add(new AchievementBuilder("Walking the Reef", 0.2).requirement("Port distance", 5000).build());
        achievements.add(new AchievementBuilder("Uncorrupted Ore", 0.1).requirement("Corrupted ore", 100).requirement("Smithing", 89)
            .requirement("Plague's End", 1).reward("Smithing", 65000).build());
        achievements.add(new AchievementBuilder("Troublesome Crystals", 0.1).requirement("Plague's End", 1).build());
        achievements.add(new AchievementBuilder("Slayer Master", 0).requirement("Slayer", 99).requirement("Dungeoneering", 90)
            .requirement("TzTok-Jad", 1).requirement("The Branches of Darkmeyer", 1).requirement("The Chosen Commander", 1)
            .requirement("Fate of the Gods", 1).requirement("The Firemaker's Curse", 1).requirement("One of a Kind", 1)
            .requirement("Ritual of the Mahjarrat", 1).requirement("The World Wakes", 1).requirement("The Void Stares Back", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Adamant dragon"), Collections.singletonList("Adamant dragon"),
                Arrays.asList("Airut", "Airut"), Arrays.asList("Airut", "Airut"),
                Arrays.asList("Automaton Generator", "Automaton Generator"), Arrays.asList("Automaton Generator", "Automaton Generator"),
                Arrays.asList("Throwing muspah", "Throwing muspah"),  Arrays.asList("Throwing muspah", "Throwing muspah"),
                Collections.singletonList("Celestial dragon"), Collections.singletonList("Celestial dragon"),
                Arrays.asList("Ice strykewyrm", "Ice strykewyrm", "Ice strykewyrm"),
                Arrays.asList("Ice strykewyrm", "Ice strykewyrm", "Ice strykewyrm"),
                Arrays.asList("Ganodermic beast", "Ganodermic runt", "Ganodermic runt"),
                Arrays.asList("Ganodermic beast", "Ganodermic runt", "Ganodermic runt"), Collections.singletonList("Kal'gerion demon"),
                Collections.singletonList("Kal'gerion demon"), Arrays.asList("Mutated jadinko male", "Mutated jadinko male",
                    "Mutated jadinko male", "Mutated jadinko male", "Mutated jadinko male"), Arrays.asList("Mutated jadinko male",
                    "Mutated jadinko male", "Mutated jadinko male", "Mutated jadinko male", "Mutated jadinko male"),
                Collections.singletonList("Tormented demon"), Collections.singletonList("Tormented demon")))).build());
        achievements.add(new AchievementBuilder("Sing for the Lady", 0).requirement("Plague's End", 1).requirement("Crystal wand", 1)
            .requirement("Crystal orb", 1).requirement("Crystal staff", 1).requirement("Crystal ward", 1).reward("Magic", 50000).build());
        achievements.add(new AchievementBuilder("Rhian in Gold - The Original", 5).requirement("Plague's End", 1).requirement("Agility", 75)
            .requirement("Construction", 75).requirement("Crafting", 75).requirement("Divination", 75).requirement("Dungeoneering", 75)
            .requirement("Farming", 75).requirement("Herblore", 75).requirement("Magic", 75).requirement("Attack", 75)
            .requirement("Mining", 75).requirement("Prayer", 75).requirement("Ranged", 75).requirement("Slayer", 75)
            .requirement("Smithing", 75).requirement("Summoning", 75).requirement("Woodcutting", 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75).build());
        achievements.add(new AchievementBuilder("50% Telos defeated", 0).requirement("Vindicta", 1).requirement("Gregorovic", 1)
            .requirement("Helwyr", 1).requirement("Twin Furies", 1).encounter(new Encounter("Telos (0% enrage)"))
            .encounter(new Encounter("Telos (5% enrage)")).encounter(new Encounter("Telos (10% enrage)"))
            .encounter(new Encounter("Telos (15% enrage)")).encounter(new Encounter("Telos (20% enrage)"))
            .encounter(new Encounter("Telos (25% enrage)")).encounter(new Encounter("Telos (30% enrage)"))
            .encounter(new Encounter("Telos (35% enrage)")).encounter(new Encounter("Telos (40% enrage)"))
            .encounter(new Encounter("Telos (45% enrage)")).encounter(new Encounter("Telos (50% enrage)")).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry I", 0).requirement("50% Telos defeated", 1).build());
        achievements.add(new AchievementBuilder("100% Telos defeated", 0).requirement("50% Telos defeated", 1)
            .encounter(new Encounter("Telos (55% enrage)")).encounter(new Encounter("Telos (60% enrage)"))
            .encounter(new Encounter("Telos (65% enrage)")).encounter(new Encounter("Telos (70% enrage)"))
            .encounter(new Encounter("Telos (75% enrage)")).encounter(new Encounter("Telos (80% enrage)"))
            .encounter(new Encounter("Telos (85% enrage)")).encounter(new Encounter("Telos (90% enrage)"))
            .encounter(new Encounter("Telos (95% enrage)")).encounter(new Encounter("Telos (100% enrage)")).build());
        achievements.add(new AchievementBuilder("Reaper Crew", 0).requirement("Giant Mole", 1).requirement("Chaos Elemental", 1)
            .requirement("Dagannoth Kings", 1).requirement("Corporeal Beast", 1).requirement("Barrows", 1).requirement("Rise of the Six", 1)
            .requirement("Kalphite King", 1).requirement("Kalphite Queen", 1).requirement("King Black Dragon", 1)
            .requirement("Queen Black Dragon", 1).requirement("TzTok-Jad", 1).requirement("Har-Aken", 1).requirement("Legiones", 1)
            .requirement("The Magister", 1).requirement("Araxxi", 1).requirement("Vorago", 1).requirement("General Graardor", 1)
            .requirement("Vindicta", 1).requirement("K'ril Tsutsaroth", 1).requirement("Twin Furies", 1).requirement("Kree'arra", 1)
            .requirement("Gregorovic", 1).requirement("Commander Zilyana", 1).requirement("Helwyr", 1).requirement("Nex", 1)
            .requirement("Telos", 1).requirement("Nex: Angel of Death", 1).requirement("Solak", 1).requirement("Beastmaster Durzag", 1)
            .requirement("Yakamaru", 1).requirement("The Sanctum Guardian", 1).requirement("Astellarn", 1).requirement("Masuta", 1)
            .requirement("Verak Lith", 1).requirement("Seiryu", 1).requirement("Black Stone Dragon", 1).build());
        achievements.add(new AchievementBuilder("Port Life", 0.05).requirement("Ports unlocked", 1).build());
        achievements.add(new AchievementBuilder("Pious Prayers", 0).requirement("Knight Waves training ground", 1).build());
        achievements.add(new AchievementBuilder("Peachy Bones", 0).requirement("Telekinetic pizazz points", 200)
            .requirement("Alchemist pizazz points", 300).requirement("Enchantment pizazz points", 2000)
            .requirement("Graveyard pizazz points", 200).build());
        achievements.add(new AchievementBuilder("Out into the Ourania", 0).requirement("Lunar Diplomacy", 1).build());
        achievements.add(new AchievementBuilder("One Foot in the Grave (miniquest)", 0.5).requirement("Back to my Roots", 1)
            .encounter(new Encounter("Giant ant worker")).encounter(new Encounter("Giant ant worker"))
            .encounter(new Encounter("Giant ant worker")).encounter(new Encounter("Giant ant worker"))
            .encounter(new Encounter("Giant ant worker")).encounter(new Encounter("Giant ant worker")).reward("Magic", 10000)
            .reward("Blood rune", 200).reward("Law rune", 100).build());
        achievements.add(new AchievementBuilder("In Memory of the Myreque (miniquest)", 1.5).requirement("The Lord of Vampyrium", 1)
            .requirement("Silver sickle", 11).requirement("Granite (5kg)", 20).requirement("Blamish blue shell (pointed)", 1)
            .requirement("Nail beast nails", 1).requirement("Snakeskin body", 1).requirement("Silver bar", 3).requirement("Mithril bar", 3)
            .requirement("Air rune", 3).requirement("Cosmic rune", 2).requirement("Water rune", 1).requirement("Sapphire", 1)
            .requirement("Emerald", 1).requirement("Rune armoured boots", 1).requirement("Mort myre pear", 1)
            .requirement("Moonlight mead", 1).requirement("Crossbow string", 1).reward("Woodcutting", 2200).reward("Fletching", 1100)
            .reward("Crafting", 275).reward("Magic", 54).build());
        achievements.add(new AchievementBuilder("Myreque in Memoriam", 1.5).requirement("In Memory of the Myreque (miniquest)", 1).build());
        achievements.add(new AchievementBuilder("Memories of Guthix", 0.5).requirement("Memory strand", 2280)
            .requirement("Pale energy", 500).requirement("Flickering energy", 400).requirement("Bright energy", 450)
            .requirement("Glowing energy", 500).requirement("Sparkling energy", 400).requirement("Gleaming energy", 350)
            .requirement("Vibrant energy", 500).requirement("Lustrous energy", 300).requirement("Brilliant energy", 250)
            .requirement("Radiant energy", 300).requirement("Luminous energy", 250).requirement("Incandescent energy", 150)
            .requirement("Divination", 70).reward("Memory strand", 1000).reward("Divination", 206304).build());
        achievements.add(new AchievementBuilder("Master Skiller", 0).requirement("Attack", 99).requirement("Strength", 99)
            .requirement("Ranged", 99).requirement("Magic", 99).requirement("Defence", 99).requirement("Constitution", 99)
            .requirement("Prayer", 99).requirement("Agility", 99).requirement("Herblore", 99).requirement("Thieving", 99)
            .requirement("Crafting", 99).requirement("Runecrafting", 99).requirement("Mining", 99).requirement("Smithing", 99)
            .requirement("Fishing", 99).requirement("Cooking", 99).requirement("Firemaking", 99).requirement("Woodcutting", 99)
            .requirement("Fletching", 99).requirement("Slayer", 120).requirement("Farming", 99).requirement("Construction", 99)
            .requirement("Hunter", 99).requirement("Summoning", 99).requirement("Dungeoneering", 120).requirement("Divination", 99)
            .requirement("Invention", 120).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Koschei's Troubles (miniquest)", 0.25).requirement("Blood Runs Deep", 1)
            .requirement("Ritual of the Mahjarrat", 1).lamp(Player.ALL_SKILLS, 30000, 75).build());
        achievements.add(new AchievementBuilder("Sliske's Endgame", 2.5).requirement("The Death of Chivalry", 1)
            .requirement("Children of Mah", 1).requirement("Hero's Welcome", 1).requirement("Kindred Spirits", 1)
            .requirement("Nomad's Elegy", 1).requirement("One of a Kind", 1).encounter(new Encounter(Arrays.asList(Arrays.asList(
                "Wight footsoldier (SE)",  "Wight footsoldier (SE)", "Wight footsoldier (SE)", "Wight footsoldier (SE)",
                "Wight footsoldier (SE)", "Wight footsoldier (SE)", "Wight footsoldier (SE)", "Wight footsoldier (SE)",
                "Wight footsoldier (SE)", "Wight footsoldier (SE)"), Arrays.asList("Wight ranger (SE)", "Wight ranger (SE)",
                "Wight ranger (SE)", "Wight ranger (SE)", "Wight ranger (SE)", "Wight ranger (SE)", "Wight ranger (SE)",
                "Wight ranger (SE)", "Wight ranger (SE)", "Wight ranger (SE)"), Arrays.asList("Imbued wight footsolder",
                "Imbued wight footsolder", "Imbued wight footsolder", "Imbued wight footsolder", "Imbued wight footsolder",
                "Imbued wight footsolder", "Imbued wight footsolder", "Imbued wight footsolder", "Imbued wight footsolder",
                "Imbued wight footsolder"), Arrays.asList("Unstable wight footsolder", "Unstable wight footsolder",
                "Unstable wight footsolder", "Unstable wight footsolder", "Unstable wight footsolder", "Unstable wight footsolder",
                "Unstable wight footsolder", "Unstable wight footsolder", "Unstable wight footsolder", "Unstable wight footsolder"))))
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Nomad (Elegy)", "Linza the Disgraced", "Gregorovic"))))
            .encounter(new Encounter("Sliske")).reward("Quest points", 3).lamp(Player.ALL_SKILLS, 250000, 85)
            .lamp(Player.ALL_SKILLS, 250000, 85).lamp(Player.ALL_SKILLS, 250000, 85).lamp(Player.ALL_SKILLS, 250000, 85)
            .lamp(Player.ALL_SKILLS, 250000, 85).build());
        achievements.add(new AchievementBuilder("Master Quester", 0).requirement("Beneath Cursed Tides", 1)
            .requirement("Sliske's Endgame", 1).requirement("Broken Home", 1).requirement("River of Blood", 1).requirement("'Phite Club", 1)
            .requirement("As A First Resort", 1).requirement("Back to my Roots", 1).requirement("Back to the Freezer", 1)
            .requirement("Birthright of the Dwarves", 1).requirement("Pieces of Hate", 1).requirement("The Prisoner of Glouphrie", 1)
            .requirement("Bringing Home the Bacon", 1).requirement("The Brink of Extinction", 1).requirement("Buyers and Cellars", 1)
            .requirement("Call of the Ancestors", 1).requirement("Clock Tower", 1).requirement("Dimension of Disaster: Curse of Arrav", 1)
            .requirement("Love Story", 1).requirement("Deadliest Catch", 1).requirement("Rat Catchers", 1)
            .requirement("Eagles' Peak", 1).requirement("The Elemental Workshop IV", 1).requirement("Enlightened Journey", 1)
            .requirement("Evil Dave's Big Day Out", 1).requirement("The Firemaker's Curse", 1).requirement("Olaf's Quest", 1)
            .requirement("Fur 'n Seek", 1).requirement("Ghosts Ahoy", 1).requirement("Salt in the Wound", 1).requirement("Gower Quest", 1)
            .requirement("Grim Tales", 1).requirement("Gunnar's Ground", 1).requirement("Haunted Mine", 1)
            .requirement("Curse of the Black Stone", 1).requirement("In Pyre Need", 1).requirement("Let Them Eat Pie", 1)
            .requirement("Monk's Friend", 1).requirement("Myths of the White Lands", 1).requirement("Observatory Quest", 1)
            .requirement("One Piercing Note", 1).requirement("Perils of Ice Mountain", 1).requirement("Rune Mechanics", 1)
            .requirement("Scorpion Catcher", 1).requirement("A Shadow over Ashdale", 1).requirement("Song from the Depths", 1)
            .requirement("A Soul's Bane", 1).requirement("Swept Away", 1).requirement("TokTz-Ket-Dill", 1).requirement("Vampyre Slayer", 1)
            .requirement("Watchtower", 1).requirement("Desperate Times", 1).requirement("Violet is Blue", 1)
            .requirement("Chef's Assistant", 1).requirement("Summer's End", 1)
            .requirement("Recipe for Disaster: Defeating the Culinaromancer", 1).requirement("Ritual of the Mahjarrat", 1).build());
        achievements.add(new AchievementBuilder("Music Maestro", 1).requirement("Master Quester", 1).requirement("Attack", 80)
            .requirement("Dungeoneering", 113).requirement("Ranged", 80).requirement("Runecrafting", 66).requirement("Slayer", 115)
            .requirement("Thieving", 75).build());
        achievements.add(new AchievementBuilder("Make Them Bleed", 0).requirement("Slayer", 85).requirement("Plague's End", 1)
            .requirement("Legacy of Seergaze", 1).encounter(new Encounter(Arrays.asList(Arrays.asList("Abyssal demon", "Abyssal demon",
                "Abyssal demon"), Arrays.asList("Baby black dragon", "Baby black dragon", "Baby black dragon", "Baby black dragon",
                "Baby black dragon", "Baby black dragon"), Arrays.asList("Dagannoth", "Dagannoth", "Dagannoth"),
                Arrays.asList("Exiled kalphite paragon", "Exiled kalphite paragon", "Exiled kalphite soldier", "Exiled kalphite soldier"),
                Arrays.asList("Exiled kalphite worker", "Exiled kalphite worker", "Exiled kalphite worker"), Arrays.asList("Greater demon",
                    "Greater demon", "Greater demon", "Greater demon", "Greater demon"), Arrays.asList("Grotworm", "Grotworm", "Grotworm",
                    "Grotworm"), Arrays.asList("Rorarius", "Rorarius", "Rorarius", "Rorarius"), Arrays.asList("TzHaar-Hur", "TzHaar-Hur",
                    "TzHaar-Hur", "TzHaar-Hur", "TzHaar-Hur"), Arrays.asList("Vyrewatch", "Vyrewatch", "Vyrewatch", "Vyrewatch"),
                Arrays.asList("Aquanite", "Aquanite", "Aquanite", "Aquanite", "Aquanite"), Arrays.asList("Aviansie", "Aviansie",
                    "Aviansie", "Aviansie"), Arrays.asList("Black demon", "Black demon", "Black demon", "Black demon"),
                Arrays.asList("Capsarius", "Gladius", "Gladius"), Arrays.asList("Dagannoth sentinel", "Dagannoth sentinel",
                    "Dagannoth sentinel"), Arrays.asList("Death spawn", "Death spawn", "Death spawn", "Nechryael", "Nechryael",
                    "Nechryael"), Arrays.asList("Exiled kalphite guardian", "Exiled kalphite guardian", "Exiled kalphite marauder"),
                Arrays.asList("Iron dragon", "Iron dragon", "Iron dragon"), Arrays.asList("Mutated jadinko baby", "Mutated jadinko baby",
                    "Mutated jadinko baby", "Mutated jadinko baby", "Mutated jadinko baby"), Arrays.asList("Vyrelord", "Vyrelord"))))
            .reward("Slayer", 50000).build());
        achievements.add(new AchievementBuilder("Lunar Master", 0).requirement("Produce points", 430000).build());
        achievements.add(new AchievementBuilder("The Lost Toys (miniquest)", 0.5).requirement("The Lord of Vampyrium", 1).build());
        achievements.add(new AchievementBuilder("Dahmaroc statue 1", 5).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1).build());
        achievements.add(new AchievementBuilder("Kudos to You", 0).requirement("Kudos on the Kudos!", 1)
            .requirement("The Curse of Zaros (miniquest)", 1).requirement("Ritual of the Mahjarrat", 1).requirement("Glorious Memories", 1)
            .requirement("King Black Dragon", 1).requirement("Queen Black Dragon", 1).requirement("Dahmaroc statue 1", 1)
            .reward("Slayer", 25000).build());
        achievements.add(new AchievementBuilder("Kiln Fighter", 0).requirement("Har-Aken", 1).build());
        achievements.add(new AchievementBuilder("Mahjarrat Memories (miniquest)", 6).requirement("Koschei's Troubles (miniquest)", 1)
            .requirement("Divination", 60).requirement("Insulated boots", 0).requirement("Macaw pouch", 1)
            .requirement("Missing, Presumed Death", 1).reward("Divination", 577500).build());
        achievements.add(new AchievementBuilder("Invention Gives Me the Blues", 0).requirement("Invention", 70)
            .requirement("The Giant Dwarf", 1).requirement("Death to the Dorgeshuun", 1).requirement("Vial", 4)
            .requirement("Decorated fishing urn (nr)", 2).requirement("Water rune", 2).requirement("Rune bar", 3)
            .requirement("Dextrous components", 14).requirement("Direct components", 9).requirement("Enhancing components", 9)
            .requirement("Ethereal components", 9).requirement("Evasive components", 9).requirement("Healthy components", 9)
            .requirement("Heavy components", 9).requirement("Imbued components", 9).requirement("Light components", 9)
            .requirement("Living components", 9).requirement("Pious components", 9).requirement("Powerful components", 11)
            .requirement("Precious components", 14).requirement("Precise components", 9).requirement("Protective components", 9)
            .requirement("Refined components", 9).requirement("Sharp components", 9).requirement("Strong components", 17)
            .requirement("Stunning components", 9).requirement("Subtle components", 9).requirement("Swift components", 9)
            .requirement("Variable components", 9).requirement("Base parts", 170).requirement("Blade parts", 130)
            .requirement("Clear parts", 230).requirement("Connector parts", 90).requirement("Cover parts", 160)
            .requirement("Crafted parts", 260).requirement("Deflecting parts", 90).requirement("Delicate parts", 160)
            .requirement("Flexible parts", 90).requirement("Head parts", 90).requirement("Magic parts", 90)
            .requirement("Metallic parts", 90).requirement("Organic parts", 230).requirement("Padded parts", 90)
            .requirement("Plated parts", 90).requirement("Simple parts", 140).requirement("Smooth parts", 90)
            .requirement("Spiked parts", 90).requirement("Spiritual parts", 130).requirement("Stave parts", 90)
            .requirement("Tensile parts", 90).requirement("Junk", 600).requirement("Invention tutorial", 1).reward("Invention", 8598)
            .reward("Crafting", 500).reward("Smithing", 300).build());
        achievements.add(new AchievementBuilder("Imping Around", 0.3).requirement("Disco Impling", 1).requirement("Rocking Out", 1)
            .requirement("Hunter", 95).reward("Hunter", 52486).build());
        achievements.add(new AchievementBuilder("I'm Forever Washing Shadows", 0).requirement("Blissful shadow core", 15)
            .requirement("Truthful shadow core", 15).requirement("Manifest shadow core", 15).reward("Divination", 50000).build());
        achievements.add(new AchievementBuilder("Heal, Quickly", 0).requirement("Rapid Renewal", 1).build());
        achievements.add(new AchievementBuilder("Famous", 0).requirement("Plague's End", 1).requirement("Slayer", 85)
            .requirement("Combat", 120).requirement("Constitution", 70).requirement("Strength", 70).requirement("Troll Stronghold", 1)
            .requirement("Summoning", 60).encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor"),
                Collections.singletonList("Araxxi")))).encounter(new Encounter("Giant Mole (hard)"))
            .encounter(new Encounter("Dagannoth Prime")).encounter(new Encounter("Dagannoth Rex"))
            .encounter(new Encounter("Dagannoth Supreme")).encounter(new Encounter("Queen Black Dragon"))
            .encounter(new Encounter("Commander Zilyana")).encounter(new Encounter("Kree'arra"))
            .encounter(new Encounter("K'ril Tsutsaroth")).encounter(new Encounter("General Graardor"))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Kalphite Queen (Phase 1)"),
                Collections.singletonList("Kalphite Queen (Phase 2)")))).encounter(new Encounter("King Black Dragon"))
            .reward("Slayer", 50000).reward("Slayer point", 45).reward("Araxxi", 1).reward("Giant Mole (hard)", 1)
            .reward("Dagannoth Kings", 3).reward("Dagannoth Prime", 1).reward("Dagannoth Rex", 1).reward("Dagannoth Supreme", 1)
            .reward("Commander Zilyana", 1).reward("Kree'arra", 1).reward("K'ril Tsutsaroth", 1).reward("General Graardor", 1)
            .reward("Kalphite Queen", 1).reward("King Black Dragon", 1).build());
        achievements.add(new AchievementBuilder("Family Spirit Tree", 0.15).requirement("Bird's nest", 123).requirement("Plague's End", 1)
            .requirement("The Prisoner of Glouphrie", 1).requirement("Farming", 89).reward("Farming", 108503).build());
        achievements.add(new AchievementBuilder("Elven Titles", 8.75).requirement("Hefin Agility Course laps", 200)
            .requirement("Corrupted ore", 100).requirement("Combat", 120).requirement("Slayer", 90).requirement("Cadarn magus", 1000)
            .requirement("Elder tree grown", 1).requirement("Light creature pouch", 1).requirement("Enlightenment scroll", 1)
            .requirement("As A First Resort", 1).requirement("Mining", 81).requirement("Crafting", 89).requirement("Farming", 75)
            .requirement("Harmony moss seed", 15).reward("Farming", 59140).reward("Mining", 3280).reward("Crafting", 15000).build());
        achievements.add(new AchievementBuilder("Diaries of the Clans", 0).requirement("Hefin Agility Course laps", 160).build());
        achievements.add(new AchievementBuilder("Desert-ed Ghosts", 0).requirement("The Curse of Zaros (miniquest)", 1).build());
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
        achievements.add(new AchievementBuilder("Potion for a Lady", 3).requirement("Plague's End", 1).requirement("Coins", 150000)
            .reward("Dungeoneering", 750000).reward("Dungeoneering token", 75000).reward("Dungeoneering floors completed", 24)
            .lamp(Arrays.asList("Attack", "Strength"), 50000, 1).build());
        achievements.add(new AchievementBuilder("Potion Mixer Master", 20).requirement("Potion for a Lady", 1)
            .requirement("Coins", 12350000).reward("Dungeoneering", 7000000).reward("Dungeoneering token", 700000)
            .reward("Dungeoneering floors completed", 160).build());
        achievements.add(new AchievementBuilder("Everything Is Oresome", 0).requirement("Copper mined", 100).requirement("Tin mined", 100)
            .requirement("Iron mined", 100).requirement("Coal mined", 100).requirement("Mithril mined", 100)
            .requirement("Adamantite mined", 100).requirement("Luminite mined", 100).requirement("Runite mined", 100)
            .requirement("Orichalcite mined", 100).requirement("Drakolith mined", 100).requirement("Necrite mined", 100)
            .requirement("Phasmatite mined", 100).requirement("Banite mined", 100).requirement("Light animica mined", 100)
            .requirement("Dark animica mined", 100).build());
        achievements.add(new AchievementBuilder("It Should Have Been Called Aetherium", 1.55).requirement("Smithing", 90)
            .requirement("Elder rune bar", 384).reward("Smithing", 384000).reward("Elder rune full helm +5 ", 1)
            .reward("Elder rune platebody + 5", 1).reward("Elder rune platelegs + 5", 1).reward("Elder rune armoured boots + 5", 1)
            .reward("Elder rune gauntlets + 5", 1).build());
        achievements.add(new AchievementBuilder("Assassin storyline", 0.3).requirement("Slayer", 90).requirement("Port distance", 1200000)
            .reward("Lacquer", 25).build());
        achievements.add(new AchievementBuilder("Occultist storyline", 0.3).requirement("Runecrafting", 90)
            .requirement("Port distance", 1200000).reward("Chi", 25).build());
        achievements.add(new AchievementBuilder("Whaler storyline", 0.3).requirement("Fishing", 90).requirement("Port distance", 1200000)
            .reward("Spices", 100).build());
        achievements.add(new AchievementBuilder("Quin storyline", 0.15).requirement("Assassin storyline", 1)
            .requirement("Occultist storyline", 1).requirement("Whaler storyline", 1).reward("Chi", 50).reward("Ancient bones", 50)
            .build());
        achievements.add(new AchievementBuilder("Trip to the East", 0).requirement("Quin storyline", 1).build());
        achievements.add(new AchievementBuilder("Long Live the Queen", 0).requirement("Queen Black Dragon", 1).build());
        achievements.add(new AchievementBuilder("Four Seasons", 0).requirement("POF bean", 5000).build());
        achievements.add(new AchievementBuilder("Farm totems", 0).requirement("Granny Knows Best", 1).requirement("POF bean", 1200)
            .build());
        achievements.add(new AchievementBuilder("Bean There, Done That", 0).requirement("Four Seasons", 1).requirement("Farm totems", 1)
            .requirement("Granny Knows Best", 1).requirement("Farming", 71).requirement("POF bean", 31100).build());
        achievements.add(new AchievementBuilder("Bag of Herbs", 0.6).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).build());
        achievements.add(new AchievementBuilder("Dinosaur Hunter", 0.75).requirement("Raw shark", 1).requirement("Raw sailfish", 1)
            .requirement("Raw manta ray", 1).requirement("Raw bagrada rex meat", 1).requirement("Raw arcane apoterrasaur meat", 1)
            .requirement("Raw scimitops meat", 1).requirement("Raw asciatops meat", 0).requirement("Raw corbicula rex meat", 1)
            .requirement("Raw spicati apoterrasaur meat", 1).requirement("Hunter", 96).requirement("Slayer", 76).reward("Hunter", 135000)
            .reward("Slayer", 25350).reward("Fletching", 450).reward("Big game hunted", 9)
            .lamp(Collections.singletonList("Woodcutting"), -108, 1).lamp(Collections.singletonList("Herblore"), -45, 1).build());
        achievements.add(new AchievementBuilder("Stacks on Stacks", 0.35).requirement("Anachronia sections", 200)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).build());
        achievements.add(new AchievementBuilder("Setting The Foundation", 0.05).build());
        achievements.add(new AchievementBuilder("Top Town Hall", 0.25).requirement("Setting The Foundation", 1).build());
        achievements.add(new AchievementBuilder("Completionist Cape", 0).requirement("Abyss (miniquest)", 1)
            .requirement("Almost as Perky as a Prawn", 1).requirement("Annihilator", 1)
            .requirement("Arc - Ancient Eastern Tortle Portals", 1).requirement("Arc - Unlocking Waiko", 1)
            .requirement("Arc - Upgrading Waiko", 1).requirement("Spiritual Enlightenment (miniquest)", 1)
            .requirement("Head of the Family (miniquest)", 1).requirement("Jed Hunter (miniquest)", 1)
            .requirement("Damage Control (miniquest)", 1).requirement("Flag Fall (miniquest)", 1)
            .requirement("Ghosts from the Past (miniquest)", 1).requirement("Bean There, Done That", 1)
            .requirement("Tuai Leit's Own (miniquest)", 1).requirement("Harbinger (miniquest)", 1)
            .requirement("Eye for an Eye (miniquest)", 1).requirement("Final Destination (miniquest)", 1)
            .requirement("Bandos's Memories", 1).requirement("Bane Tuner", 1).requirement("Big Chinchompa", 1)
            .requirement("Bipedal Mask", 1).requirement("Bridge over Fremmy Waters", 1).requirement("Claus Is Rising", 1)
            .requirement("Deadlier Catch", 1).requirement("Desert-ed Ghosts", 1).requirement("Diaries of the Clans", 1)
            .requirement("Elven Titles", 1).requirement("Family Spirit Tree", 1).requirement("Famous", 1).requirement("Heal, Quickly", 1)
            .requirement("I'm Forever Washing Shadows", 1).requirement("Imping Around", 1).requirement("Invention Gives Me the Blues", 1)
            .requirement("Mahjarrat Memories (miniquest)", 1).requirement("Kiln Fighter", 1).requirement("Kudos to You", 1)
            .requirement("Long Live the Queen", 1).requirement("The Lost Toys (miniquest)", 1).requirement("Lunar Master", 1)
            .requirement("Make Them Bleed", 1).requirement("Master Quester", 1).requirement("Master Skiller", 1)
            .requirement("Memories of Guthix", 1).requirement("Music Maestro", 1).requirement("Myreque in Memoriam", 1)
            .requirement("One Foot in the Grave (miniquest)", 1).requirement("Out into the Ourania", 1).requirement("Peachy Bones", 1)
            .requirement("Pious Prayers", 1).requirement("Port Life", 1).requirement("Potion Mixer Master", 1)
            .requirement("Potion for a Lady", 1).requirement("Rhian in Gold - The Original", 1).requirement("Seren Memories", 1)
            .requirement("Sing for the Lady", 1).requirement("Slayer Master", 1).requirement("Stay Safe", 1).requirement("Stay Secure", 1)
            .requirement("Task Master", 1).requirement("Lair of Tarn Razorlor (miniquest)", 1).requirement("Trip to the East", 1)
            .requirement("Troublesome Crystals", 1).requirement("Uncorrupted Ore", 1).requirement("Walking the Reef", 1)
            .requirement("What's Mine Is Also Doric's", 1).requirement("Yaktwee's a Charm", 1)
            .requirement("Hopespear's Will (miniquest)", 1).requirement("Zarosian Memories", 1).requirement("Everything Is Oresome", 1)
            .requirement("It Should Have Been Called Aetherium", 1).requirement("Bag of Herbs", 1).requirement("Dinosaur Hunter", 1)
            .requirement("Stacks on Stacks", 1).requirement("Top Town Hall", 1).build());
        achievements.add(new AchievementBuilder("Conquest Adore", 6).requirement("Combat", 55)
            .reward("Void Knight commendation points", 240).build());
        achievements.add(new AchievementBuilder("Constitution - Morty", 0).requirement("Constitution pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Constitution 15", -1).requirement("Constitution", 15).build());
        achievements.add(new AchievementBuilder("Constitution 20", -1).requirement("Constitution", 20).build());
        achievements.add(new AchievementBuilder("Constitution 30", -1).requirement("Constitution", 30).build());
        achievements.add(new AchievementBuilder("Constitution 40", -1).requirement("Constitution", 40).build());
        achievements.add(new AchievementBuilder("Constitution 50", -1).requirement("Constitution", 50).build());
        achievements.add(new AchievementBuilder("Constitution 60", -1).requirement("Constitution", 60).build());
        achievements.add(new AchievementBuilder("Constitution 70", -1).requirement("Constitution", 70).build());
        achievements.add(new AchievementBuilder("Constitution 80", -1).requirement("Constitution", 80).build());
        achievements.add(new AchievementBuilder("Constitution 90", -1).requirement("Constitution", 90).build());
        achievements.add(new AchievementBuilder("Constitution 92 (Halfway There)", -1).requirement("Constitution", 92).build());
        achievements.add(new AchievementBuilder("Constitution 99", -1).requirement("Constitution", 99).build());
        achievements.add(new AchievementBuilder("Construction - Baba Yaga's House", 0).requirement("Construction pet points", 1039720685)
            .build());
        achievements.add(new AchievementBuilder("Construction 5", -1).requirement("Construction", 5).build());
        achievements.add(new AchievementBuilder("Construction 10", -1).requirement("Construction", 10).build());
        achievements.add(new AchievementBuilder("Construction 20", -1).requirement("Construction", 20).build());
        achievements.add(new AchievementBuilder("Construction 30", -1).requirement("Construction", 30).build());
        achievements.add(new AchievementBuilder("Construction 40", -1).requirement("Construction", 40).build());
        achievements.add(new AchievementBuilder("Construction 50", -1).requirement("Construction", 50).build());
        achievements.add(new AchievementBuilder("Construction 60", -1).requirement("Construction", 60).build());
        achievements.add(new AchievementBuilder("Construction 70", -1).requirement("Construction", 70).build());
        achievements.add(new AchievementBuilder("Construction 80", -1).requirement("Construction", 80).build());
        achievements.add(new AchievementBuilder("Construction 90", -1).requirement("Construction", 90).build());
        achievements.add(new AchievementBuilder("Construction 92 (Halfway There)", -1).requirement("Construction", 92).build());
        achievements.add(new AchievementBuilder("Construction 99", -1).requirement("Construction", 99).build());
        achievements.add(new AchievementBuilder("Cook's Delights", 0).requirement("Cook's Assistant", 1).build());
        achievements.add(new AchievementBuilder("Cooking - Ramsay", 0).requirement("Cooking pet points", 866434024).build());
        achievements.add(new AchievementBuilder("Cooking 5", -1).requirement("Cooking", 5).build());
        achievements.add(new AchievementBuilder("Cooking 10", -1).requirement("Cooking", 10).build());
        achievements.add(new AchievementBuilder("Cooking 20", -1).requirement("Cooking", 20).build());
        achievements.add(new AchievementBuilder("Cooking 30", -1).requirement("Cooking", 30).build());
        achievements.add(new AchievementBuilder("Cooking 40", -1).requirement("Cooking", 40).build());
        achievements.add(new AchievementBuilder("Cooking 50", -1).requirement("Cooking", 50).build());
        achievements.add(new AchievementBuilder("Cooking 60", -1).requirement("Cooking", 60).build());
        achievements.add(new AchievementBuilder("Cooking 70", -1).requirement("Cooking", 70).build());
        achievements.add(new AchievementBuilder("Cooking 80", -1).requirement("Cooking", 80).build());
        achievements.add(new AchievementBuilder("Cooking 90", -1).requirement("Cooking", 90).build());
        achievements.add(new AchievementBuilder("Cooking 92 (Halfway There)", -1).requirement("Cooking", 92).build());
        achievements.add(new AchievementBuilder("Cooking 99", -1).requirement("Cooking", 99).build());
        achievements.add(new AchievementBuilder("Cormes and Goes", 0).encounter(new Encounter(Arrays.asList(Arrays.asList("Airut",
            "Airut", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Charger", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut",
                "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger",
                "Charger"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")), 10)).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment I", 0).requirement("Corporeal Beast", 5).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment II", 0).requirement("Corporeal Beast", 10).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment III", 0).requirement("Corporeal Beast", 25).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment IV", 0).requirement("Corporeal Beast", 50).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment V", 0).requirement("Corporeal Beast", 75).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment VI", 0).requirement("Corporeal Beast", 100).build());
        achievements.add(new AchievementBuilder("Corporeal Puppy", 0).requirement("Corporeal Beast", 1078).build());
        achievements.add(new AchievementBuilder("Count All Light Fingers", 0).requirement("A Guild of Our Own (miniquest)", 1).build());
        achievements.add(new AchievementBuilder("Coursing Through You", 0).requirement("100% Telos defeated", 1)
            .encounter(new Encounter("Telos (100% enrage)")).build());
        achievements.add(new AchievementBuilder("Cower Behind the Chosen Commander", 0)
            .requirement("The Chosen Commander", 1).lamp(Arrays.asList("Constitution", "Attack", "Defence"), 1000, 1).build());
        achievements.add(new AchievementBuilder("Crafting - Gemi", 0).requirement("Crafting pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Crafting 5", -1).requirement("Crafting", 5).build());
        achievements.add(new AchievementBuilder("Crafting 10", -1).requirement("Crafting", 10).build());
        achievements.add(new AchievementBuilder("Crafting 20", -1).requirement("Crafting", 20).build());
        achievements.add(new AchievementBuilder("Crafting 30", -1).requirement("Crafting", 30).build());
        achievements.add(new AchievementBuilder("Crafting 40", -1).requirement("Crafting", 40).build());
        achievements.add(new AchievementBuilder("Crafting 50", -1).requirement("Crafting", 50).build());
        achievements.add(new AchievementBuilder("Crafting 60", -1).requirement("Crafting", 60).build());
        achievements.add(new AchievementBuilder("Crafting 70", -1).requirement("Crafting", 70).build());
        achievements.add(new AchievementBuilder("Crafting 80", -1).requirement("Crafting", 80).build());
        achievements.add(new AchievementBuilder("Crafting 90", -1).requirement("Crafting", 90).build());
        achievements.add(new AchievementBuilder("Crafting 92 (Halfway There)", -1).requirement("Crafting", 92).build());
        achievements.add(new AchievementBuilder("Crafting 99", -1).requirement("Crafting", 99).build());
        achievements.add(new AchievementBuilder("Cran Door's Secret", 0).requirement("Dragon Slayer", 1).build());
        achievements.add(new AchievementBuilder("Crayfish Roasting On An Open Fire", 0).requirement("Raw crayfish", 1)
            .reward("Crayfish", 1).reward("Cooking", 30).build());
        achievements.add(new AchievementBuilder("Crossing Over I", 0).requirement("The Magister", 5).build());
        achievements.add(new AchievementBuilder("Crossing Over II", 0).requirement("The Magister", 10).build());
        achievements.add(new AchievementBuilder("Crossing Over III", 0).requirement("The Magister", 25).build());
        achievements.add(new AchievementBuilder("Crossing Over IV", 0).requirement("The Magister", 50).build());
        achievements.add(new AchievementBuilder("Crossing Over V", 0).requirement("The Magister", 75).build());
        achievements.add(new AchievementBuilder("Crossing Over VI", 0).requirement("The Magister", 100).build());
        achievements.add(new AchievementBuilder("Daemonology of Celerity", 0.1).build());
        achievements.add(new AchievementBuilder("Daero Take This Experience?", 0).requirement("Monkey Madness", 1)
            .reward("Attack", 20000).reward("Strength", 20000).reward("Defence", 20000).reward("Constitution", 20000)
            .lamp(Arrays.asList("Attack", "Strength"), 15000, 1).lamp(Arrays.asList("Constitution", "Defence"), 15000, 1).build());
        achievements.add(new AchievementBuilder("Dagannoth Traffic Wardens", 0).requirement("Koschei's Troubles (miniquest)", 1)
            .encounter(new Encounter("Dagannoth Supreme")).encounter(new Encounter("Dagannoth Supreme"))
            .encounter(new Encounter("Dagannoth Supreme")).encounter(new Encounter("Dagannoth Supreme")).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone I", 0).requirement("Dagannoth Kings", 5).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone II", 0).requirement("Dagannoth Kings", 10).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone III", 0).requirement("Dagannoth Kings", 25).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone IV", 0).requirement("Dagannoth Kings", 50).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone V", 0).requirement("Dagannoth Kings", 75).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone VI", 0).requirement("Dagannoth Kings", 100).build());
        achievements.add(new AchievementBuilder("Dark Imperator-ment", 0).requirement("Constitution", 91).requirement("Attack", 75)
            .requirement("Magic", 75).requirement("Ranged", 75).requirement("Dimension of Disaster: Coin of the Realm", 1).build());
        achievements.add(new AchievementBuilder("Day at the Aquarium", 0).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru")), 10)).build());
        achievements.add(new AchievementBuilder("Day at the Pound", 0)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"), Arrays.asList("Airut", "Airut",
                "Charger", "Charger"), Arrays.asList("Airut", "Charger", "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut",
                "Charger", "Charger"), Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"), Arrays.asList("Airut", "Airut", "Airut", "Airut", 
                    "Airut", "Airut", "Airut"), Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")), 10)).build());
        achievements.add(new AchievementBuilder("Death Effect", 100).requirement("Combat", 50).build());
        achievements.add(new AchievementBuilder("Death to the Mahjarrat", 0.1).requirement("Children of Mah", 1).build());
        achievements.add(new AchievementBuilder("Deep and Bloody Experience", 0).requirement("Blood Runs Deep", 1)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75).build());
        achievements.add(new AchievementBuilder("Defence - Wallace", 0).requirement("Defence pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Defence 5", -1).requirement("Defence", 5).build());
        achievements.add(new AchievementBuilder("Defence 10", -1).requirement("Defence", 10).build());
        achievements.add(new AchievementBuilder("Defence 20", -1).requirement("Defence", 20).build());
        achievements.add(new AchievementBuilder("Defence 30", -1).requirement("Defence", 30).build());
        achievements.add(new AchievementBuilder("Defence 40", -1).requirement("Defence", 40).build());
        achievements.add(new AchievementBuilder("Defence 50", -1).requirement("Defence", 50).build());
        achievements.add(new AchievementBuilder("Defence 60", -1).requirement("Defence", 60).build());
        achievements.add(new AchievementBuilder("Defence 70", -1).requirement("Defence", 70).build());
        achievements.add(new AchievementBuilder("Defence 80", -1).requirement("Defence", 80).build());
        achievements.add(new AchievementBuilder("Defence 90", -1).requirement("Defence", 90).build());
        achievements.add(new AchievementBuilder("Defence 92 (Halfway There)", -1).requirement("Defence", 92).build());
        achievements.add(new AchievementBuilder("Defence 99 (The Best Defence)", -1).requirement("Defence", 99).build());
        achievements.add(new AchievementBuilder("Descension I", 0).requirement("Legiones", 5).build());
        achievements.add(new AchievementBuilder("Descension II", 0).requirement("Legiones", 10).build());
        achievements.add(new AchievementBuilder("Descension III", 0).requirement("Legiones", 25).build());
        achievements.add(new AchievementBuilder("Descension IV", 0).requirement("Legiones", 50).build());
        achievements.add(new AchievementBuilder("Descension V", 0).requirement("Legiones", 75).build());
        achievements.add(new AchievementBuilder("Descension VI", 0).requirement("Legiones", 100).build());
        achievements.add(new AchievementBuilder("Dharok Bobblehead", 0).requirement("Malevolent energy", 250)
            .requirement("Dharok's helm", 1).requirement("Dharok's platebody", 1).requirement("Dharok's platelegs", 1)
            .requirement("Dharok's greataxe", 1).build());
        achievements.add(new AchievementBuilder("Diary of Oreb", 0).requirement("The Magister", 35).build());
        achievements.add(new AchievementBuilder("Diary of the Gods", 0).requirement("Commander Zilyana", 40)
            .requirement("General Graardor", 40).requirement("Kree'arra", 40).requirement("K'ril Tsutsaroth", 45).requirement("Nex", 15)
            .build());
        achievements.add(new AchievementBuilder("Diddyzag", 0).requirement("Beastmaster Durzag", 130).build());
        achievements.add(new AchievementBuilder("Digging for Treasure", 0).requirement("Meerkats pouch", 1)
            .requirement("Fetch Casket scroll", 1).requirement("Summoning", 4).requirement("Sealed clue scroll (hard)", 1)
            .reward("Summoning", 1).build());
        achievements.add(new AchievementBuilder("Zamorak hideout XP chest 1", 0).requirement("Dishonour among Thieves", 1)
            .requirement("Agility", 50).requirement("Attack", 50).requirement("Strength", 50).requirement("Defence", 50)
            .requirement("Ranged", 50).requirement("Prayer", 50).requirement("Constitution", 50).requirement("Crafting", 50)
            .requirement("Mining", 50).requirement("Smithing", 50).requirement("Fishing", 50).requirement("Cooking", 50)
            .requirement("Firemaking", 50).requirement("Woodcutting", 50).requirement("Runecrafting", 50).requirement("Dungeoneering", 50)
            .requirement("Fletching", 50).requirement("Herblore", 50).requirement("Thieving", 50).requirement("Magic", 50)
            .requirement("Slayer", 50).requirement("Farming", 50).requirement("Construction", 50).requirement("Hunter", 50)
            .requirement("Summoning", 50).requirement("Divination", 50).lamp(Player.ALL_SKILLS, 7000, 50).build());
        achievements.add(new AchievementBuilder("Zamorak hideout XP chest 2", 0).requirement("Zamorak hideout XP chest 1", 1)
            .requirement("Agility", 70).requirement("Attack", 70).requirement("Strength", 70).requirement("Defence", 70)
            .requirement("Ranged", 70).requirement("Prayer", 70).requirement("Constitution", 70).requirement("Crafting", 70)
            .requirement("Mining", 70).requirement("Smithing", 70).requirement("Fishing", 70).requirement("Cooking", 70)
            .requirement("Firemaking", 70).requirement("Woodcutting", 70).requirement("Runecrafting", 70).requirement("Dungeoneering", 70)
            .requirement("Fletching", 70).requirement("Herblore", 70).requirement("Thieving", 70).requirement("Magic", 70)
            .requirement("Slayer", 70).requirement("Farming", 70).requirement("Construction", 70).requirement("Hunter", 70)
            .requirement("Summoning", 70).requirement("Divination", 70).lamp(Player.ALL_SKILLS, 50000, 70).build());
        achievements.add(new AchievementBuilder("Zamorak hideout XP chest 3", 0).requirement("Zamorak hideout XP chest 2", 1)
            .requirement("Agility", 90).requirement("Attack", 90).requirement("Strength", 90).requirement("Defence", 90)
            .requirement("Ranged", 90).requirement("Prayer", 90).requirement("Constitution", 90).requirement("Crafting", 90)
            .requirement("Mining", 90).requirement("Smithing", 90).requirement("Fishing", 90).requirement("Cooking", 90)
            .requirement("Firemaking", 90).requirement("Woodcutting", 90).requirement("Runecrafting", 90).requirement("Dungeoneering", 90)
            .requirement("Fletching", 90).requirement("Herblore", 90).requirement("Thieving", 90).requirement("Magic", 90)
            .requirement("Slayer", 90).requirement("Farming", 90).requirement("Construction", 90).requirement("Hunter", 90)
            .requirement("Summoning", 90).requirement("Divination", 90).lamp(Player.ALL_SKILLS, 96000, 90).build());
        achievements.add(new AchievementBuilder("Dishonourable Gains", 0).requirement("Zamorak hideout XP chest 3", 1).build());
        achievements.add(new AchievementBuilder("Dishonourable Loot", 0).requirement("Dishonour among Thieves", 1).reward("Coins", 30000)
            .reward("Dungeoneering token", 1500).reward("Sapphire", 9).reward("Emerald", 6).reward("Ruby", 3).build());
        achievements.add(new AchievementBuilder("Disowned", 0).requirement("The Lord of Vampyrium", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Vanstrom Klause"),
                Collections.singletonList("Vanstrom Klause")))).build());
        achievements.add(new AchievementBuilder("Distorted Div", 0).requirement("Mahjarrat Memories (miniquest)", 1)
            .requirement("Fate of the Gods", 1).reward("Divination", 25000).build());
        achievements.add(new AchievementBuilder("Divination - Willow", 0).requirement("Divination level-ticks", 34657359).build());
        achievements.add(new AchievementBuilder("Divination 5", -1).requirement("Divination", 5).build());
        achievements.add(new AchievementBuilder("Divination 10", -1).requirement("Divination", 10).build());
        achievements.add(new AchievementBuilder("Divination 20", -1).requirement("Divination", 20).build());
        achievements.add(new AchievementBuilder("Divination 30", -1).requirement("Divination", 30).build());
        achievements.add(new AchievementBuilder("Divination 40", -1).requirement("Divination", 40).build());
        achievements.add(new AchievementBuilder("Divination 50", -1).requirement("Divination", 50).build());
        achievements.add(new AchievementBuilder("Divination 60", -1).requirement("Divination", 60).build());
        achievements.add(new AchievementBuilder("Divination 70", -1).requirement("Divination", 70).build());
        achievements.add(new AchievementBuilder("Divination 80", -1).requirement("Divination", 80).build());
        achievements.add(new AchievementBuilder("Divination 90", -1).requirement("Divination", 90).build());
        achievements.add(new AchievementBuilder("Divination 92 (Halfway There)", -1).requirement("Divination", 92).build());
        achievements.add(new AchievementBuilder("Divination 99", -1).requirement("Divination", 99).build());
        achievements.add(new AchievementBuilder("What an Experience", 0).reward("Divination", 3).build());
        achievements.add(new AchievementBuilder("Simply Divine", 0).requirement("Pale energy", 5).requirement("Raw crayfish", 20)
            .reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Portentially Hazardous", 0).requirement("Divination", 2).requirement("Pale energy", 30)
            .requirement("Sardine", 1).reward("Portent of restoration I", 1).reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Mighty Morphing", 0).requirement("Divination", 13).requirement("Logs", 3)
            .requirement("Flickering energy", 2).reward("Oak logs", 1).reward("Divination", 3).build());
        achievements.add(new AchievementBuilder("Let's Enhance", 0).requirement("Pale energy", 5).reward("Divination", 3).build());
        achievements.add(new AchievementBuilder("Just Give Me a Sign", 0).requirement("Divination", 6).requirement("Pale energy", 30)
            .requirement("Sapphire necklace", 1).reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Enrichment Programme", 0).requirement("Divination", 10).reward("Divination", 4)
            .reward("Flickering energy", 1).build());
        achievements.add(new AchievementBuilder("Energy Generator", 0).reward("Pale energy", 1).reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Divine Retribution", 0).requirement("Business Is Booning!", 1)
            .requirement("Collecting Memorabilia", 1).requirement("Energy Generator", 1).requirement("Enrichment Programme", 1)
            .requirement("Just Give Me a Sign", 1).requirement("Let's Enhance", 1).requirement("Mighty Morphing", 1)
            .requirement("Portentially Hazardous", 1).requirement("Simply Divine", 1).requirement("What an Experience", 1)
            .reward("Flickering energy", 500).build());
        achievements.add(new AchievementBuilder("Diving For Clues", 0).requirement("Treasure chest decoration", 1)
            .requirement("Construction", 80).requirement("Telescope lenses", 1).requirement("Bronze bar", 5).requirement("Fishbowl", 1)
            .reward("Sealed clue scroll (elite)", 1).reward("Construction", 17).build());
        achievements.add(new AchievementBuilder("Do No Elite", 0.1).requirement("Do No Evil", 1).reward("Sealed clue scroll (elite)", 1)
            .build());
        achievements.add(new AchievementBuilder("Don't Fear the Ripper", 0).requirement("Ripper demons", 414).build());
        achievements.add(new AchievementBuilder("Double Swoop", 0).requirement("Ranged", 70)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Flight Kilisa", "Wingman Skree", "Flockleader Geerin"),
                Arrays.asList("Flight Kilisa", "Wingman Skree", "Flockleader Geerin", "Kree'arra")))).build());
        achievements.add(new AchievementBuilder("Dragonkin Logs", 0).requirement("Adamant dragons", 800).build());
        achievements.add(new AchievementBuilder("Draynor", 0).build());
        achievements.add(new AchievementBuilder("Dungeoneering - Gordie", 0).requirement("Dungeoneering pet points", 866434024).build());
        achievements.add(new AchievementBuilder("Dungeoneering 5", -1).requirement("Dungeoneering", 5).build());
        achievements.add(new AchievementBuilder("Dungeoneering 10", -1).requirement("Dungeoneering", 10).build());
        achievements.add(new AchievementBuilder("Dungeoneering 20", -1).requirement("Dungeoneering", 20).build());
        achievements.add(new AchievementBuilder("Dungeoneering 30", -1).requirement("Dungeoneering", 30).build());
        achievements.add(new AchievementBuilder("Dungeoneering 40", -1).requirement("Dungeoneering", 40).build());
        achievements.add(new AchievementBuilder("Dungeoneering 50", -1).requirement("Dungeoneering", 50).build());
        achievements.add(new AchievementBuilder("Dungeoneering 60", -1).requirement("Dungeoneering", 60).build());
        achievements.add(new AchievementBuilder("Dungeoneering 70", -1).requirement("Dungeoneering", 70).build());
        achievements.add(new AchievementBuilder("Dungeoneering 80", -1).requirement("Dungeoneering", 80).build());
        achievements.add(new AchievementBuilder("Dungeoneering 90", -1).requirement("Dungeoneering", 90).build());
        achievements.add(new AchievementBuilder("Dungeoneering 99", -1).requirement("Dungeoneering", 99).build());
        achievements.add(new AchievementBuilder("Dungeoneering 110", -1).requirement("Dungeoneering", 110).build());
        achievements.add(new AchievementBuilder("Dungeoneering 113 (Halfway to Paradise", -1).requirement("Dungeoneering", 113).build());
        achievements.add(new AchievementBuilder("Dungeoneering 120", -1).requirement("Dungeoneering", 120).build());
        achievements.add(new AchievementBuilder("Adamant dragon dungeon mural", 0).requirement("One of a Kind", 1)
            .requirement("Dragonfire shield", 0).reward("Firemaking", 10000).build());
        achievements.add(new AchievementBuilder("Mount Firewake mural", 1).requirement("One of a Kind", 1)
            .requirement("Ritual of the Mahjarrat", 1).requirement("Fate of the Gods", 1).requirement("Firemaking", 80)
            .requirement("Dragonfire shield", 0).reward("Firemaking", 80000).build());
        achievements.add(new AchievementBuilder("Dusting Murial", 0).requirement("Adamant dragon dungeon mural", 1)
            .requirement("Mount Firewake mural", 1).build());
        achievements.add(new AchievementBuilder("Eagles' Peak (lodestone)", 0).build());
        achievements.add(new AchievementBuilder("Architect storyline", 0.3).requirement("Construction", 90)
            .requirement("Port distance", 1200000).reward("Pearls", 12).reward("Koi Scales", 12).build());
        achievements.add(new AchievementBuilder("Chef storyline", 0.3).requirement("Cooking", 90).requirement("Port distance", 1200000)
            .reward("Pearls", 18).reward("Spices", 28).build());
        achievements.add(new AchievementBuilder("Trapper storyline", 0.3).requirement("Hunter", 90).requirement("Port distance", 1200000)
            .reward("Pearls", 18).reward("Koi Scales", 7).build());
        achievements.add(new AchievementBuilder("Eastern Curiosities storyline", 0.15).requirement("Trapper storyline", 1)
            .requirement("Chef storyline", 1).requirement("Architect storyline", 1).reward("Koi Scales", 50).reward("Pearls", 50).build());
        achievements.add(new AchievementBuilder("Biologist storyline", 0.3).requirement("Herblore", 90)
            .requirement("Port distance", 1200000).reward("Ancient bones", 25).build());
        achievements.add(new AchievementBuilder("Convict storyline", 0.3).requirement("Thieving", 90)
            .requirement("Port distance", 1200000).reward("Plate", 25).build());
        achievements.add(new AchievementBuilder("Missionary storyline", 0.3).requirement("Prayer", 90).requirement("Port distance", 1200000)
            .reward("Plate", 25).build());
        achievements.add(new AchievementBuilder("Hyu-Ji storyline", 0.15).requirement("Biologist storyline", 1)
            .requirement("Convict storyline", 1).requirement("Missionary storyline", 1).reward("Plate", 50).reward("Lacquer", 50).build());
        achievements.add(new AchievementBuilder("Tengu storyline", 0.3).requirement("Agility", 90).requirement("Port distance", 1200000)
            .reward("Plate", 20).reward("Pearls", 10).build());
        achievements.add(new AchievementBuilder("Memory storyline", 0.3).requirement("Divination", 90).requirement("Port distance", 1200000)
            .reward("Chi", 20).reward("Koi Scales", 10).build());
        achievements.add(new AchievementBuilder("Exile storyline", 0.3).requirement("Dungeoneering", 90)
            .requirement("Port distance", 1200000).reward("Lacquer", 15).reward("Ancient bones", 10).build());
        achievements.add(new AchievementBuilder("Guardians of the World storyline", 0.15).requirement("Tengu storyline", 1)
            .requirement("Memory storyline", 1).requirement("Exile storyline", 1).requirement("Port distance", 6000000).reward("Plate", 50)
            .reward("Chi", 50).build());
        achievements.add(new AchievementBuilder("Eastern Adventurer", 0).requirement("Quin storyline", 1)
            .requirement("Hyu-Ji storyline", 1).requirement("Eastern Curiosities storyline", 1)
            .requirement("Guardians of the World storyline", 1).build());
        achievements.add(new AchievementBuilder("Eastern Explorer", 0).requirement("Port distance", 4100000).build());
        achievements.add(new AchievementBuilder("Eat to Live", 0).requirement("Trout", 1).build());
        achievements.add(new AchievementBuilder("Edgeville", 0).build());
        achievements.add(new AchievementBuilder("Eeeeagle!", 0).requirement("Agility", 35).requirement("Strength", 45)
            .requirement("Eagles' Peak", 1).requirement("Back to my Roots", 1).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos I", 0).requirement("Chaos Elemental", 5).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos II", 0).requirement("Chaos Elemental", 10).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos III", 0).requirement("Chaos Elemental", 25).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos IV", 0).requirement("Chaos Elemental", 50).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos V", 0).requirement("Chaos Elemental", 75).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos VI", 0).requirement("Chaos Elemental", 100).build());
        achievements.add(new AchievementBuilder("Enough of the Crazy Walking", 0).requirement("Honour Points", 50).build());
        achievements.add(new AchievementBuilder("Epi Logueque Experience", 0).requirement("While Guthix Sleeps", 1)
            .lamp(Player.ALL_SKILLS, 100000, 65).lamp(Player.ALL_SKILLS, 100000, 65).lamp(Player.ALL_SKILLS, 100000, 65)
            .lamp(Player.ALL_SKILLS, 100000, 65).build());
        achievements.add(new AchievementBuilder("Barrows defender", 0).requirement("Dragon defender", 1).requirement("Barrows", 35)
            .requirement("Verac's flail", 1).build());
        achievements.add(new AchievementBuilder("Ancient defender", 0).requirement("Barrows defender", 1).requirement("Nex", 35)
            .requirement("Dungeoneering token", 150000).build());
        achievements.add(new AchievementBuilder("Exiled", 0).requirement("Ancient defender", 1).requirement("Kalphite King", 968).build());
        achievements.add(new AchievementBuilder("Survivor's lamp", 0).requirement("Fate of the Gods", 1)
            .requirement("The Temple at Senntisten", 1)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defence", "Constitution"), 75000, 80)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defence", "Constitution"), 75000, 80)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defence", "Constitution"), 75000, 80).build());
        achievements.add(new AchievementBuilder("Wahisietel's lamp", 0).requirement("Fate of the Gods", 1)
            .requirement("Ritual of the Mahjarrat", 1).lamp(Player.ALL_SKILLS, -4, 1).build());
        achievements.add(new AchievementBuilder("Experience the Fate of the Gods", 0).requirement("Survivor's lamp", 1)
            .requirement("Wahisietel's lamp", 1).build());
        achievements.add(new AchievementBuilder("Explore for Nestor", 0).build());
        achievements.add(new AchievementBuilder("Faceless And Ready", 0).build());
        achievements.add(new AchievementBuilder("Falador", 0).build());
        achievements.add(new AchievementBuilder("Fallen Angel", 0).requirement("Nex: Angel of Death", 3804).build());
        achievements.add(new AchievementBuilder("Guthan Bobblehead", 0).requirement("Malevolent energy", 250)
            .requirement("Guthan's chainskirt", 1).requirement("Guthan's warspear", 1).requirement("Guthan's platebody", 1)
            .requirement("Guthan's helm", 1).build());
        achievements.add(new AchievementBuilder("Karil Bobblehead", 0).requirement("Malevolent energy", 250).requirement("Karil's coif", 1)
            .requirement("Karil's top", 1).requirement("Karil's skirt", 1).requirement("Karil's crossbow", 1).build());
        achievements.add(new AchievementBuilder("Torag Bobblehead", 0).requirement("Malevolent energy", 250).requirement("Torag's helm", 1)
            .requirement("Torag's platebody", 1).requirement("Torag's platelegs", 1).requirement("Torag's hammer", 1).build());
        achievements.add(new AchievementBuilder("Verac Bobblehead", 0).requirement("Malevolent energy", 250).build());
        achievements.add(new AchievementBuilder("Family Affair", 0).requirement("Ahrim Bobblehead", 1).requirement("Dharok Bobblehead", 1)
            .requirement("Torag Bobblehead", 1).requirement("Guthan Bobblehead", 1).requirement("Verac Bobblehead", 1)
            .requirement("Karil Bobblehead", 1).requirement("Rise of the Six", 378).build());
        achievements.add(new AchievementBuilder("Fancy turtle-back", 0).requirement("Fishing", 68).build());
        achievements.add(new AchievementBuilder("Farming - Brains", 0).requirement("Farming pet points", 415888301).build());
        achievements.add(new AchievementBuilder("Farming 5", -1).requirement("Farming", 5).build());
        achievements.add(new AchievementBuilder("Farming 10", -1).requirement("Farming", 10).build());
        achievements.add(new AchievementBuilder("Farming 20", -1).requirement("Farming", 20).build());
        achievements.add(new AchievementBuilder("Farming 30", -1).requirement("Farming", 30).build());
        achievements.add(new AchievementBuilder("Farming 40", -1).requirement("Farming", 40).build());
        achievements.add(new AchievementBuilder("Farming 50", -1).requirement("Farming", 50).build());
        achievements.add(new AchievementBuilder("Farming 60", -1).requirement("Farming", 60).build());
        achievements.add(new AchievementBuilder("Farming 70", -1).requirement("Farming", 70).build());
        achievements.add(new AchievementBuilder("Farming 80", -1).requirement("Farming", 80).build());
        achievements.add(new AchievementBuilder("Farming 90", -1).requirement("Farming", 90).build());
        achievements.add(new AchievementBuilder("Farming 92", -1).requirement("Farming", 92).build());
        achievements.add(new AchievementBuilder("Farming 99", -1).requirement("Farming", 99).build());
        achievements.add(new AchievementBuilder("Fast and Furious I", 0).requirement("Twin Furies", 5).reward("Zaros reputation", 50)
            .build());
        achievements.add(new AchievementBuilder("Fast and Furious II", 0).requirement("Twin Furies", 10).build());
        achievements.add(new AchievementBuilder("Fast and Furious III", 0).requirement("Twin Furies", 25).build());
        achievements.add(new AchievementBuilder("Fast and Furious IV", 0).requirement("Twin Furies", 50).build());
        achievements.add(new AchievementBuilder("Fast and Furious V", 0).requirement("Twin Furies", 75).build());
        achievements.add(new AchievementBuilder("Fast and Furious VI", 0).requirement("Twin Furies", 100).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring I", 0).requirement("Corrupted creatures", 500).build());
        achievements.add(new AchievementBuilder("Feline Good", 0.75).requirement("Shifting Tombs", 1).requirement("'Phite Club", 1)
            .requirement("Slay Bells Ring I", 1).requirement("Jenifurr", 1).build());
        achievements.add(new AchievementBuilder("Ferocious Upgrade", 0).requirement("Slayer", 90).requirement("Slayer point", 100)
            .build());
        achievements.add(new AchievementBuilder("What's In the Hole", 0).requirement("Construction", 27).requirement("Plank", 4)
            .requirement("Bronze nails", 10).requirement("Bronze dagger", 1).requirement("Iron full helm", 1).requirement("Gold ring", 1)
            .reward("Construction", 500).build());
        achievements.add(new AchievementBuilder("Here Was a Scabaras Mask", 0.05).requirement("Mining", 80)
            .requirement("Diamond in the Rough", 1).reward("Mining", 20000).build());
        achievements.add(new AchievementBuilder("Fill Them All!", 3).requirement("What's In the Hole", 1).requirement("TzTok-Jad", 1)
            .requirement("Maria, You Gotta See Her", 1).requirement("Legends' Quest", 1).requirement("One of a Kind", 1)
            .requirement("Recipe for Disaster: Defeating the Culinaromancer", 1).requirement("Dragon defender", 1)
            .requirement("The Curse of Zaros (miniquest)", 1).requirement("Yaktwee's a Charm", 1).requirement("A, B, Cithara", 1)
            .requirement("Bless is More", 1).requirement("Here Was a Scabaras Mask", 1).requirement("Underground Pass", 1)
            .requirement("Prifddinian musician's robe pieces", 2).requirement("Invention", 69).requirement("Cover parts", 410)
            .requirement("Deflecting parts", 190).requirement("Dextrous components", 25).requirement("Padded parts", 220)
            .requirement("Protective components", 25).requirement("Construction", 88).requirement("Plank", 96).requirement("Oak plank", 52)
            .requirement("Teak plank", 36).requirement("Mahogany plank", 44).requirement("Gold leaf", 11).requirement("Bronze nails", 570)
            .requirement("Adamant 2h sword", 1).requirement("Adamant med helm", 1).requirement("Air tiara", 1).requirement("Amulet of glory", 1)
            .requirement("Amulet of magic", 1).requirement("Amulet of ranging", 1).requirement("Amulet of strength", 1)
            .requirement("Ancient staff", 1).requirement("Berserker ring", 1).requirement("Black cavalier", 1)
            .requirement("Blue dragonhide body", 1).requirement("Blue dragonhide chaps", 2).requirement("Blue dragonhide vambraces", 3)
            .requirement("Blue flowers", 1).requirement("Blood'n'tar snelm (pointed)", 1).requirement("Blood'n'tar snelm (round)", 1)
            .requirement("Bronze 2h sword", 1).requirement("Bronze armoured boots", 1).requirement("Bronze chainbody", 1)
            .requirement("Bronze full helm", 1).requirement("Bronze hatchet", 1).requirement("Bronze platelegs", 3)
            .requirement("Bronze spear", 1).requirement("Bruise blue snelm (pointed)", 1).requirement("Coins", 100450)
            .requirement("Dagon'hai hat", 1).requirement("Dark bow", 1).requirement("Demon slayer gloves", 1).requirement("Diamond ring", 1)
            .requirement("Elemental shield", 1).requirement("Emerald amulet", 1).requirement("Emerald ring", 3).requirement("Fine cloth", 4)
            .requirement("Fire battlestaff", 1).requirement("Gold amulet", 1).requirement("Gold necklace", 1).requirement("Gold ring", 2)
            .requirement("Green dragon mask", 1).requirement("Green dragonhide body", 1).requirement("Green dragonhide chaps", 4)
            .requirement("Hard leather body", 2).requirement("Holy symbol", 1).requirement("Iron 2h sword", 1)
            .requirement("Iron armoured boots", 1).requirement("Iron chainbody", 2).requirement("Iron crossbow", 1)
            .requirement("Iron hatchet", 1).requirement("Iron med helm", 1).requirement("Iron kiteshield", 1).requirement("Iron pickaxe", 2)
            .requirement("Iron platebody", 3).requirement("Iron platelegs", 1).requirement("Iron plateskirt", 1)
            .requirement("Iron scimitar", 1).requirement("Iron square shield", 2).requirement("Iron warhammer", 1)
            .requirement("Imphide hood", 1).requirement("Infinity boots", 1).requirement("Leather boots", 1).requirement("Leather chaps", 4)
            .requirement("Leather cowl", 1).requirement("Leather gloves", 4).requirement("Leather vambraces", 1)
            .requirement("Maple shieldbow", 1).requirement("Maple shortbow", 1).requirement("Mithril chainbody", 1)
            .requirement("Mithril full helm", 1).requirement("Mithril med helm", 1).requirement("Mithril platelegs", 2)
            .requirement("Mithril plateskirt", 1).requirement("Mithril scimitar", 1).requirement("Mud pie", 2)
            .requirement("Oak shieldbow", 1).requirement("Oak shortbow", 1).requirement("Polar camo legs", 1)
            .requirement("Polar camo top", 1).requirement("Red boater", 1).requirement("Ring of duelling (8)", 1)
            .requirement("Ring of forging", 1).requirement("Ring of life", 2).requirement("Ruby amulet", 3).requirement("Rune full helm", 1)
            .requirement("Rune hatchet", 1).requirement("Rune platebody", 1).requirement("Rune warhammer", 1)
            .requirement("Saradomin's murmur", 1).requirement("Sapphire amulet", 1).requirement("Sapphire necklace", 2)
            .requirement("Sapphire ring", 2).requirement("Shieldbow", 1).requirement("Silver sickle", 1).requirement("Snakeskin boots", 1)
            .requirement("Snakeskin chaps", 1).requirement("Spiny helmet", 1).requirement("Splitbark helm", 1).requirement("Spork", 1)
            .requirement("Staff of air", 1).requirement("Staff of light", 1).requirement("Steel full helm", 1)
            .requirement("Steel hatchet", 1).requirement("Steel med helm", 1).requirement("Steel kiteshield", 2)
            .requirement("Steel longsword", 1).requirement("Steel mace", 1).requirement("Steel pickaxe", 1)
            .requirement("Steel platebody", 2).requirement("Steel plateskirt", 1).requirement("Steel square shield", 1)
            .requirement("Studded body", 1).requirement("Studded chaps", 2).requirement("Studded leather coif", 3).requirement("Tiara", 1)
            .requirement("Toktz-ket-xil", 1).requirement("Unholy symbol", 1).requirement("Wood camo top", 1)
            .requirement("Yellow flowers", 1).requirement("Invention tutorial", 1).reward("Construction", 66000).build());
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
            .requirement("Mole Removal VI", 1).requirement("Along Came A Spider VI", 1).requirement("Bug Swatter VI", 1)
            .requirement("Vindictive and Vexatious VI", 1).requirement("Fast and Furious VI", 1).requirement("Elemental Kill Chaos VI", 1)
            .requirement("Hardly a Challenge VI", 1).requirement("Barrowed Power VI", 1).requirement("Come and Have Vorago VI", 1)
            .requirement("Nex Pls VI", 1).requirement("Yak and Ruin VI", 1).requirement("Bird is the Word VI", 1)
            .requirement("Kill K'ril VI", 1).requirement("Corporeal Punishment VI", 1).requirement("Loot Pinata VI", 1)
            .requirement("Descension VI", 1).requirement("Dagannoth For Everyone VI", 1).requirement("Telos Where it Hurts VI", 1)
            .requirement("This Helwyr in VI", 1).requirement("Gregorgeous VI", 1).requirement("Living on a Prayer Switch VI", 1)
            .requirement("Something Barrowed VI", 1).requirement("Bug Zapper VI", 1).requirement("Brass Nex VI", 1)
            .requirement("Master of Beatings VI", 1).build());
        achievements.add(new AchievementBuilder("Firemaking - Bernie", 0).requirement("Firemaking level-ticks", 34657359).build());
        achievements.add(new AchievementBuilder("Firemaking 5", -1).requirement("Firemaking", 5).build());
        achievements.add(new AchievementBuilder("Firemaking 10", -1).requirement("Firemaking", 10).build());
        achievements.add(new AchievementBuilder("Firemaking 20", -1).requirement("Firemaking", 20).build());
        achievements.add(new AchievementBuilder("Firemaking 30", -1).requirement("Firemaking", 30).build());
        achievements.add(new AchievementBuilder("Firemaking 40", -1).requirement("Firemaking", 40).build());
        achievements.add(new AchievementBuilder("Firemaking 50", -1).requirement("Firemaking", 50).build());
        achievements.add(new AchievementBuilder("Firemaking 60", -1).requirement("Firemaking", 60).build());
        achievements.add(new AchievementBuilder("Firemaking 70", -1).requirement("Firemaking", 70).build());
        achievements.add(new AchievementBuilder("Firemaking 80", -1).requirement("Firemaking", 80).build());
        achievements.add(new AchievementBuilder("Firemaking 90", -1).requirement("Firemaking", 90).build());
        achievements.add(new AchievementBuilder("Firemaking 92", -1).requirement("Firemaking", 92).build());
        achievements.add(new AchievementBuilder("Firemaking 99", -1).requirement("Firemaking", 99).build());
        achievements.add(new AchievementBuilder("Fairy Tale III fire", 0).requirement("A Fairy Tale III - Battle at Ork's Rift", 1)
            .requirement("Firemaking", 85).requirement("Willow logs", 8).reward("Firemaking", 10000).build());
        achievements.add(new AchievementBuilder("Fairy Tale III herbs", 0).requirement("A Fairy Tale III - Battle at Ork's Rift", 1)
            .requirement("Herblore", 85).reward("Clean ranarr", 7).reward("Clean cadantine", 7).reward("Clean dwarf weed", 7)
            .reward("Ranarr seed", 2).reward("Dwarf weed seed", 2).reward("Cadantine seed", 3).build());
        achievements.add(new AchievementBuilder("Fires are Mostly Harmless", 0).requirement("Fairy Tale III fire", 1)
            .requirement("Fairy Tale III herbs", 1).build());
        achievements.add(new AchievementBuilder("First Rule of Fight Caves", 0).requirement("Har-Aken", 86).build());
        achievements.add(new AchievementBuilder("Fishing - Bubbles", 0).requirement("Fishing level-ticks", 34657359).build());
        achievements.add(new AchievementBuilder("Fishing 5", -1).requirement("Fishing", 5).build());
        achievements.add(new AchievementBuilder("Fishing 10", -1).requirement("Fishing", 10).build());
        achievements.add(new AchievementBuilder("Fishing 20", -1).requirement("Fishing", 20).build());
        achievements.add(new AchievementBuilder("Fishing 30", -1).requirement("Fishing", 30).build());
        achievements.add(new AchievementBuilder("Fishing 40", -1).requirement("Fishing", 40).build());
        achievements.add(new AchievementBuilder("Fishing 50", -1).requirement("Fishing", 50).build());
        achievements.add(new AchievementBuilder("Fishing 60", -1).requirement("Fishing", 60).build());
        achievements.add(new AchievementBuilder("Fishing 70", -1).requirement("Fishing", 70).build());
        achievements.add(new AchievementBuilder("Fishing 80", -1).requirement("Fishing", 80).build());
        achievements.add(new AchievementBuilder("Fishing 90", -1).requirement("Fishing", 90).build());
        achievements.add(new AchievementBuilder("Fishing 92", -1).requirement("Fishing", 92).build());
        achievements.add(new AchievementBuilder("Fishing 99", -1).requirement("Fishing", 99).build());
        achievements.add(new AchievementBuilder("Fist Contact", 0).requirement("Strength", 70)
            .encounter(new Encounter("General Graardor")).build());
        achievements.add(new AchievementBuilder("Five-Star General", 0).requirement("General Graardor", 2441).build());
        achievements.add(new AchievementBuilder("Fletching - Flo", 0).requirement("Fletching pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Fletching 5", -1).requirement("Fletching", 5).build());
        achievements.add(new AchievementBuilder("Fletching 10", -1).requirement("Fletching", 10).build());
        achievements.add(new AchievementBuilder("Fletching 20", -1).requirement("Fletching", 20).build());
        achievements.add(new AchievementBuilder("Fletching 30", -1).requirement("Fletching", 30).build());
        achievements.add(new AchievementBuilder("Fletching 40", -1).requirement("Fletching", 40).build());
        achievements.add(new AchievementBuilder("Fletching 50", -1).requirement("Fletching", 50).build());
        achievements.add(new AchievementBuilder("Fletching 60", -1).requirement("Fletching", 60).build());
        achievements.add(new AchievementBuilder("Fletching 70", -1).requirement("Fletching", 70).build());
        achievements.add(new AchievementBuilder("Fletching 80", -1).requirement("Fletching", 80).build());
        achievements.add(new AchievementBuilder("Fletching 90", -1).requirement("Fletching", 90).build());
        achievements.add(new AchievementBuilder("Fletching 92", -1).requirement("Fletching", 92).build());
        achievements.add(new AchievementBuilder("Fletching 99", -1).requirement("Fletching", 99).build());
        achievements.add(new AchievementBuilder("Floor is Larval", 0).requirement("Summoning", 60)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm",
                "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm"), Arrays.asList("Giant worm", "Giant worm",
                "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm"),
                Arrays.asList("Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm", "Giant worm",
                    "Giant worm", "Giant worm", "Giant worm"), Collections.singletonList("Queen Black Dragon")))).build());
        achievements.add(new AchievementBuilder("For the Love of Mabel", 0.05).requirement("Love Story", 1).reward("Coins", 5000)
            .lamp(Player.ALL_SKILLS, 10000, 60).build());
        achievements.add(new AchievementBuilder("Forcae's Mettle", 0).requirement("Adamant dragons", 140).build());
        achievements.add(new AchievementBuilder("Sheep Shearer (miniquest)", 0.25).reward("Coins", 2000).reward("Crafting", 150).build());
        achievements.add(new AchievementBuilder("Fred's Shearings", 0).requirement("Sheep Shearer (miniquest)", 1).build());
        achievements.add(new AchievementBuilder("Fremennik Province", 0).build());
        achievements.add(new AchievementBuilder("Frenzied", 0.2).requirement("Fishing", 94).build());
        achievements.add(new AchievementBuilder("Friendly Neighbour", 0).requirement("Araxxi", 651).build());
        achievements.add(new AchievementBuilder("Friends with Max", 0).requirement("Agility", 99).requirement("Attack", 99)
            .requirement("Strength", 99).requirement("Defence", 99).requirement("Ranged", 99).requirement("Prayer", 99)
            .requirement("Invention", 99).requirement("Constitution", 99).requirement("Crafting", 99).requirement("Mining", 99)
            .requirement("Smithing", 99).requirement("Fishing", 99).requirement("Cooking", 99).requirement("Firemaking", 99)
            .requirement("Woodcutting", 99).requirement("Runecrafting", 99).requirement("Dungeoneering", 99).requirement("Fletching", 99)
            .requirement("Herblore", 99).requirement("Thieving", 99).requirement("Magic", 99).requirement("Slayer", 99)
            .requirement("Farming", 99).requirement("Construction", 99).requirement("Hunter", 99).requirement("Summoning", 99)
            .requirement("Divination", 99).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Game Over", 0).requirement("Gregorovic", 1353).build());
        achievements.add(new AchievementBuilder("General Awwdor", 0).requirement("General Graardor", 2156).build());
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
        achievements.add(new AchievementBuilder("MPD Constitution lamp", 0).requirement("Missing, Presumed Death", 1)
            .requirement("Constitution", 75).reward("Constitution", 50000).build());
        achievements.add(new AchievementBuilder("MPD Antique lamp", 0).requirement("Missing, Presumed Death", 1)
            .lamp(Player.ALL_SKILLS, 30000, 75).build());
        achievements.add(new AchievementBuilder("MPD Thieving lamp", 0).requirement("Missing, Presumed Death", 1)
            .requirement("Thieving", 75).reward("Thieving", 50000).build());
        achievements.add(new AchievementBuilder("MPD Barrows amulets", 0).requirement("Missing, Presumed Death", 1)
            .requirement("Combat", 80).reward("Barrows amulet", 30).build());
        achievements.add(new AchievementBuilder("I Presume These Rewards Are Mine, Death?", 0)
            .requirement("MPD Constitution lamp", 1).requirement("MPD Antique lamp", 1).requirement("MPD Thieving lamp", 1)
            .requirement("MPD Barrows amulets", 1).build());
        achievements.add(new AchievementBuilder("The General's Shadow (miniquest)", 0.25).requirement("The Curse of Zaros (miniquest)", 1)
            .requirement("Fight Arena", 1).requirement("Coins", 40).encounter(new Encounter("Ghost of Bouncer")).reward("Slayer", 2000)
            .build());
        achievements.add(new AchievementBuilder("Gift from Sliske", 0.05).requirement("I Presume These Rewards Are Mine, Death?", 1)
            .requirement("The General's Shadow (miniquest)", 1).requirement("The World Wakes", 1).requirement("Fate of the Gods", 1)
            .requirement("Ritual of the Mahjarrat", 1).build());
        achievements.add(new AchievementBuilder("Globetrotter", 0).requirement("Treasure Trail reward points", 4950).build());
        achievements.add(new AchievementBuilder("Glutton for Punishment", 0).requirement("Dreadfowl pouch", 1)
            .requirement("Thorny snail pouch", 1).requirement("Gold charm", 1).requirement("Spirit shards", 6)
            .requirement("Pig tooth", 1).requirement("Evil turnip pouch", 1).requirement("War tortoise pouch", 1)
            .requirement("Fruit bat pouch", 1).requirement("Granite lobster pouch", 1).requirement("Bringing Home the Bacon", 1)
            .requirement("Summer's End", 1).requirement("Summoning", 74).reward("Summoning", 14).build());
        achievements.add(new AchievementBuilder("God Wars Dungeon Teleport", 0).requirement("Law rune", 2)
            .requirement("The Mighty Fall", 1).requirement("Fire rune", 2).requirement("Magic", 61).reward("Magic", 68).build());
        achievements.add(new AchievementBuilder("Goebie Relics", 0.1).build());
        achievements.add(new AchievementBuilder("Going Down with the Ship", 0.2).requirement("Fishing", 15).build());
        achievements.add(new AchievementBuilder("Going For A Punt", 0).requirement("Red boater", 1).requirement("Woodcutting", 57)
            .reward("Woodcutting", 150).build());
        achievements.add(new AchievementBuilder("Gong Maintenance Expert", 0)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Charger", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
                Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")), 10)).build());
        achievements.add(new AchievementBuilder("Good Enough for a Goblin", 0).requirement("Summer's End", 1)
            .encounter(new Encounter("Corporeal Beast")).build());
        achievements.add(new AchievementBuilder("Got a Vyre Reputation", 0).requirement("The Branches of Darkmeyer", 1).build());
        achievements.add(new AchievementBuilder("Graardone", 0).requirement("Strength", 70).encounter(new Encounter("General Graardor"))
            .build());
        achievements.add(new AchievementBuilder("Great Gielinor Run", 0.25).requirement("The Branches of Darkmeyer", 1)
            .requirement("Regicide", 1).build());
        achievements.add(new AchievementBuilder("Greg", 0).requirement("Gregorovic", 862).build());
        achievements.add(new AchievementBuilder("Gregore-Y I", 0).requirement("Gregorovic (hard)", 5).reward("Zamorak reputation", 100)
            .build());
        achievements.add(new AchievementBuilder("Gregore-Y II", 0).requirement("Gregorovic (hard)", 10).build());
        achievements.add(new AchievementBuilder("Gregore-Y III", 0).requirement("Gregorovic (hard)", 25).build());
        achievements.add(new AchievementBuilder("Gregore-Y IV", 0).requirement("Gregorovic (hard)", 50).build());
        achievements.add(new AchievementBuilder("Gregore-Y V", 0).requirement("Gregorovic (hard)", 75).build());
        achievements.add(new AchievementBuilder("Gregore-Y VI", 0).requirement("Gregorovic (hard)", 100).build());
        achievements.add(new AchievementBuilder("Gregorgeous I", 0).requirement("Gregorovic", 5).reward("Zamorak reputation", 50).build());
        achievements.add(new AchievementBuilder("Gregorgeous II", 0).requirement("Gregorovic", 10).build());
        achievements.add(new AchievementBuilder("Gregorgeous III", 0).requirement("Gregorovic", 25).build());
        achievements.add(new AchievementBuilder("Gregorgeous IV", 0).requirement("Gregorovic", 50).build());
        achievements.add(new AchievementBuilder("Gregorgeous V", 0).requirement("Gregorovic", 75).build());
        achievements.add(new AchievementBuilder("Grondaban's legacy", 0).requirement("Dishonour among Thieves", 1).build());
        achievements.add(new AchievementBuilder("Guard is Dead", 0).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .encounter(new Encounter("New Varrock guard")).build());
        achievements.add(new AchievementBuilder("Dororan's jewellery 1", 0).requirement("Gunnar's Ground", 1).requirement("Crafting", 42)
            .reward("Crafting", 2000).build());
        achievements.add(new AchievementBuilder("Dororan's jewellery 2", 0).requirement("Dororan's jewellery 1", 1)
            .requirement("Crafting", 72).reward("Crafting", 10000).build());
        achievements.add(new AchievementBuilder("Dororan's jewellery 3", 0).requirement("Dororan's jewellery 2", 1)
            .requirement("Crafting", 90).reward("Crafting", 20000).build());
        achievements.add(new AchievementBuilder("Gunning for Jewellery", 0).requirement("Dororan's jewellery 3", 1).build());
        achievements.add(new AchievementBuilder("Hail to the Queen", 0)
        .encounter(new Encounter(Arrays.asList(Arrays.asList("Kalphite guardian", "Kalphite guardian",
            "Kalphite Queen (Phase 1)"), Collections.singletonList("Kalphite Queen (Phase 2)")))).build());
        achievements.add(new AchievementBuilder("Hand Exchange", 0).requirement("Dimension of Disaster: Coin of the Realm", 1).build());
        achievements.add(new AchievementBuilder("Handicrafts", 0).requirement("Thread", 1).requirement("Leather", 1)
            .reward("Crafting", 13).reward("Leather gloves", 1).build());
        achievements.add(new AchievementBuilder("Hang on to Something", 0).build());
        achievements.add(new AchievementBuilder("Hard as Daemons", 15).requirement("Daemonheim Set Tasks - Elite", 1)
            .requirement("Attack", 90).requirement("Strength", 90).requirement("Ranged", 90).requirement("Magic", 90)
            .requirement("Defence", 90).requirement("Constitution", 90).requirement("Prayer", 90).requirement("Agility", 90)
            .requirement("Herblore", 90).requirement("Thieving", 90).requirement("Crafting", 90).requirement("Runecrafting", 90)
            .requirement("Mining", 90).requirement("Smithing", 90).requirement("Fishing", 90).requirement("Cooking", 90)
            .requirement("Firemaking", 90).requirement("Woodcutting", 90).requirement("Fletching", 90).requirement("Slayer", 90)
            .requirement("Farming", 90).requirement("Construction", 90).requirement("Hunter", 90).requirement("Summoning", 90)
            .requirement("Dungeoneering", 119).requirement("Divination", 90).build());
        achievements.add(new AchievementBuilder("Vitalis", 0).requirement("Vorago", 2156).build());
        achievements.add(new AchievementBuilder("Hard as a Rock", 0).requirement("Bombi", 1).requirement("Vitalis", 1).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge I", 0).requirement("Har-Aken", 5).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge II", 0).requirement("Har-Aken", 10).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge III", 0).requirement("Har-Aken", 25).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge IV", 0).requirement("Har-Aken", 50).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge V", 0).requirement("Har-Aken", 75).build());
        achievements.add(new AchievementBuilder("Haul Comes to Templeton", 0.05).requirement("Dealing with Scabaras", 1).build());
        achievements.add(new AchievementBuilder("Heart to Heart", 0).requirement("Twin Furies", 1498).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket I", 0).requirement("Helwyr (hard)", 5).reward("Sliske reputation", 100)
            .build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket II", 0).requirement("Helwyr (hard)", 10).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket III", 0).requirement("Helwyr (hard)", 25).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket IV", 0).requirement("Helwyr (hard)", 50).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket V", 0).requirement("Helwyr (hard)", 75).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket VI", 0).requirement("Helwyr (hard)", 100).build());
        achievements.add(new AchievementBuilder("Herbi's Flax", 0).requirement("Shades of Mort'ton", 1).reward("Herblore", 335)
            .build());
        achievements.add(new AchievementBuilder("Herblore - Herbert", 0).requirement("Herblore pet points", 1559581027).build());
        achievements.add(new AchievementBuilder("Herblore 5", -1).requirement("Herblore", 5).build());
        achievements.add(new AchievementBuilder("Herblore 10", -1).requirement("Herblore", 10).build());
        achievements.add(new AchievementBuilder("Herblore 20", -1).requirement("Herblore", 20).build());
        achievements.add(new AchievementBuilder("Herblore 30", -1).requirement("Herblore", 30).build());
        achievements.add(new AchievementBuilder("Herblore 40", -1).requirement("Herblore", 40).build());
        achievements.add(new AchievementBuilder("Herblore 50", -1).requirement("Herblore", 50).build());
        achievements.add(new AchievementBuilder("Herblore 60", -1).requirement("Herblore", 60).build());
        achievements.add(new AchievementBuilder("Herblore 70", -1).requirement("Herblore", 70).build());
        achievements.add(new AchievementBuilder("Herblore 80", -1).requirement("Herblore", 80).build());
        achievements.add(new AchievementBuilder("Herblore 90", -1).requirement("Herblore", 90).build());
        achievements.add(new AchievementBuilder("Herblore 92", -1).requirement("Herblore", 92).build());
        achievements.add(new AchievementBuilder("Herblore 99", -1).requirement("Herblore", 99).build());
        achievements.add(new AchievementBuilder("Here We Rago Again I", 0).requirement("Vorago (HM)", 5).build());
        achievements.add(new AchievementBuilder("Here We Rago Again II", 0).requirement("Vorago (HM)", 10).build());
        achievements.add(new AchievementBuilder("Here We Rago Again III", 0).requirement("Vorago (HM)", 25).build());
        achievements.add(new AchievementBuilder("Here We Rago Again IV", 0).requirement("Vorago (HM)", 50).build());
        achievements.add(new AchievementBuilder("Here We Rago Again V", 0).requirement("Vorago (HM)", 75).build());
        achievements.add(new AchievementBuilder("Here We Rago Again VI", 0).requirement("Vorago (HM)", 100).build());
        achievements.add(new AchievementBuilder("Rewind", 0).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru")), 10)).build());
        achievements.add(new AchievementBuilder("Prison Break", 0)
            .encounter(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Charger", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Airut", "Charger", "Charger"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
                Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
                Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")), 10)).build());
        achievements.add(new AchievementBuilder("Make Friends and Influence People", 0)
            .requirement("Beastmaster Durzag", 1).encounter(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
                Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru")), 10)).build());
        achievements.add(new AchievementBuilder("Hero of the Goebies", 0).requirement("All Together Now", 1)
            .requirement("Animal Cruelty", 1).requirement("Better Not Touch", 1).requirement("Cormes and Goes", 1)
            .requirement("Day at the Aquarium", 1).requirement("Day at the Pound", 1).requirement("Gong Maintenance Expert", 1)
            .requirement("Make Friends and Influence People", 1).requirement("Prison Break", 1).requirement("Rewind", 1).build());
        achievements.add(new AchievementBuilder("Hide and Seek", 0.05).requirement("Dimension of Disaster: Coin of the Realm", 1).build());
        achievements.add(new AchievementBuilder("History of Bilrach", 0.15).requirement("Dungeoneering", 117)
            .reward("Dungeoneering", 100000).build());
        achievements.add(new AchievementBuilder("How Many Games?", 0).requirement("Gold Castle Wars ticket", 4150).build());
        achievements.add(new AchievementBuilder("How to Shame Your Dragon", 0).requirement("King Black Dragon", 5400).build());
        achievements.add(new AchievementBuilder("Hungry Hungry Reavers", 0).requirement("General Graardor", 1)
            .requirement("K'ril Tsutsaroth", 1).requirement("Commander Zilyana", 1).requirement("Kree'arra", 1)
            .encounter(new Encounter("Nex: Angel of Death", 7)).build());
        achievements.add(new AchievementBuilder("Hunter - Ace", 0).requirement("Hunter level-ticks", 34657359).build());
        achievements.add(new AchievementBuilder("Hunter 5", -1).requirement("Hunter", 5).build());
        achievements.add(new AchievementBuilder("Hunter 10", -1).requirement("Hunter", 10).build());
        achievements.add(new AchievementBuilder("Hunter 20", -1).requirement("Hunter", 20).build());
        achievements.add(new AchievementBuilder("Hunter 30", -1).requirement("Hunter", 30).build());
        achievements.add(new AchievementBuilder("Hunter 40", -1).requirement("Hunter", 40).build());
        achievements.add(new AchievementBuilder("Hunter 50", -1).requirement("Hunter", 50).build());
        achievements.add(new AchievementBuilder("Hunter 60", -1).requirement("Hunter", 60).build());
        achievements.add(new AchievementBuilder("Hunter 70", -1).requirement("Hunter", 70).build());
        achievements.add(new AchievementBuilder("Hunter 80", -1).requirement("Hunter", 80).build());
        achievements.add(new AchievementBuilder("Hunter 90", -1).requirement("Hunter", 90).build());
        achievements.add(new AchievementBuilder("Hunter 92", -1).requirement("Hunter", 92).build());
        achievements.add(new AchievementBuilder("Hunter 99", -1).requirement("Hunter", 99).build());
        achievements.add(new AchievementBuilder("I Can See For Miles and Miles", 0.25).requirement("Family Crest", 1)
            .requirement("Garden of Tranquility", 1).requirement("Stay Secure", 1).requirement("A Tail of Two Cats", 1)
            .requirement("Heroes' Quest", 1).requirement("Troll Romance", 1).requirement("My Arm's Big Adventure", 1)
            .requirement("Prayer", 53).requirement("Summoning", 81).requirement("Macaw pouch", 12).requirement("Davy kebbit hat", 1)
            .build());
        achievements.add(new AchievementBuilder("I Dig This Transportation", 0).requirement("Digsite pendant unlock", 1).build());
        achievements.add(new AchievementBuilder("I Got This", 0).requirement("Slayer", 95).requirement("Ascension Keystone Primus", 1)
            .requirement("Ascension Keystone Secundus", 1).requirement("Ascension Keystone Tertius", 1)
            .requirement("Ascension Keystone Quartus", 1).requirement("Ascension Keystone Quintus", 1)
            .requirement("Ascension Keystone Sextus", 1).encounter(new Encounter(Arrays.asList(Collections.singletonList("Legio"),
                Collections.singletonList("Legio"), Collections.singletonList("Legio"), Collections.singletonList("Legio"),
                Collections.singletonList("Legio"), Collections.singletonList("Legio")))).build());
        achievements.add(new AchievementBuilder("Ice Ice Chimpy", 2).requirement("Do No Evil", 1).requirement("Coins", 25000).build());
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
        achievements.add(new AchievementBuilder("K'ril Tinyroth", 0).requirement("K'ril Tsutsaroth", 2156).build());
        achievements.add(new AchievementBuilder("Kalphite Grublet (Flying)", 0).requirement("Kalphite Queen", 1068).build());
        achievements.add(new AchievementBuilder("Kalphite Grublet", 0).requirement("Kalphite Queen", 1068).build());
        achievements.add(new AchievementBuilder("Kalphite Grubling", 0).requirement("Kalphite King", 862).build());
        achievements.add(new AchievementBuilder("King Black Dragonling", 0).requirement("King Black Dragon", 1068)
            .requirement("Summoning", 99).build());
        achievements.add(new AchievementBuilder("Legio Primulus", 0).requirement("Legio Primus", 431).build());
        achievements.add(new AchievementBuilder("Legio Quartulus", 0).requirement("Legio Quartus", 431).build());
        achievements.add(new AchievementBuilder("Legio Quintulus", 0).requirement("Legio Quintus", 431).build());
        achievements.add(new AchievementBuilder("Legio Secundulus", 0).requirement("Legio Secundus", 431).build());
        achievements.add(new AchievementBuilder("Legio Sextulus", 0).requirement("Legio Sextus", 431).build());
        achievements.add(new AchievementBuilder("Legio Tertiolus", 0).requirement("Legio Tertius", 431).build());
        achievements.add(new AchievementBuilder("Lilwyr", 0).requirement("Helwyr", 862).build());
        achievements.add(new AchievementBuilder("Mallory", 0).requirement("Araxxi", 644).build());
        achievements.add(new AchievementBuilder("Mega Ducklings", 3.5).build());
        achievements.add(new AchievementBuilder("Minister", 0).requirement("The Magister", 431).build());
        achievements.add(new AchievementBuilder("Molly", 0).requirement("Giant Mole", 1078).build());
        achievements.add(new AchievementBuilder("Nexterminator", 0).requirement("Nex", 862).build());
        achievements.add(new AchievementBuilder("Nylessa", 0).requirement("Twin Furies", 862).build());
        achievements.add(new AchievementBuilder("Prime Hatchling", 0).requirement("Dagannoth Prime", 1078).build());
        achievements.add(new AchievementBuilder("Queen Black Dragonling", 0).requirement("Queen Black Dragon", 1078)
            .requirement("Summoning", 99).build());
        achievements.add(new AchievementBuilder("Rawrvek", 0).requirement("Vindicta", 862).build());
        achievements.add(new AchievementBuilder("Reeves", 0).requirement("Nex: Angel of Death", 1293).build());
        achievements.add(new AchievementBuilder("Rex Hatchling", 0).requirement("Dagannoth Rex", 1078).build());
        achievements.add(new AchievementBuilder("Shrimpy", 0).requirement("Har-Aken", 86).build());
        achievements.add(new AchievementBuilder("Supreme Hatchling", 0).requirement("Dagannoth Supreme", 1078).build());
        achievements.add(new AchievementBuilder("Tess", 0).requirement("Telos", 393).build());
        achievements.add(new AchievementBuilder("TzRek-Jad", 0).requirement("Slayer", 99).requirement("Summoning", 99)
            .requirement("TzTok-Jad", 1).requirement("Zeal", 100).build());
        achievements.add(new AchievementBuilder("Vindiddy", 0).requirement("Vindicta", 862).build());
        achievements.add(new AchievementBuilder("Yakaminu", 0).requirement("Yakamaru", 130).build());
        achievements.add(new AchievementBuilder("Kuroryu", 0).requirement("Seiryu solo kills", 130).build());
        achievements.add(new AchievementBuilder("Solly", 0).requirement("Solak", 518).build());
        achievements.add(new AchievementBuilder("Insane Final Boss", 0).requirement("Final Boss", 1).requirement("Birdstrike VI", 1)
            .requirement("General Disaster VI", 1).requirement("Gregore-Y VI", 1).requirement("Hel in a Handbasket VI", 1)
            .requirement("Here We Rago Again VI", 1).requirement("Kill K'ril Vol 2 VI", 1).requirement("More Fast More Furious VI", 1)
            .requirement("Vindictive VI", 1).requirement("Whack a Mole VI", 1).requirement("Zillier Way to Die VI", 1)
            .requirement("Ahrim Bobblehead", 1).requirement("Ava", 1).requirement("Barry", 1).requirement("Bombi", 1)
            .requirement("Chick'arra", 1).requirement("Commander Miniana", 1).requirement("Corporeal Puppy", 1)
            .requirement("Dharok Bobblehead", 1).requirement("Diddyzag", 1).requirement("Ellie", 1).requirement("General Awwdor", 1)
            .requirement("Greg", 1).requirement("Guthan Bobblehead", 1).requirement("K'ril Tinyroth", 1)
            .requirement("Kalphite Grublet (Flying)", 1).requirement("Kalphite Grublet", 1).requirement("Kalphite Grubling", 1)
            .requirement("Karil Bobblehead", 1).requirement("King Black Dragonling", 1).requirement("Kuroryu", 1)
            .requirement("Legio Primulus", 1).requirement("Legio Quartulus", 1).requirement("Legio Quintulus", 1)
            .requirement("Legio Secundulus", 1).requirement("Legio Sextulus", 1).requirement("Legio Tertiolus", 1).requirement("Lilwyr", 1)
            .requirement("Mallory", 1).requirement("Mega Ducklings", 1).requirement("Minister", 1).requirement("Molly", 1)
            .requirement("Nexterminator", 1).requirement("Nylessa", 1).requirement("Prime Hatchling", 1)
            .requirement("Queen Black Dragonling", 1).requirement("Rawrvek", 1).requirement("Reeves", 1).requirement("Rex Hatchling", 1)
            .requirement("Shrimpy", 1).requirement("Solly", 1).requirement("Supreme Hatchling", 1).requirement("Tess", 1)
            .requirement("Torag Bobblehead", 1).requirement("TzRek-Jad", 1).requirement("Verac Bobblehead", 1).requirement("Vindiddy", 1)
            .requirement("Vitalis", 1).requirement("Yakaminu", 1).build());
        achievements.add(new AchievementBuilder("Invention - Malcolm", 0).requirement("Invention pet points", 623832411).build());
        achievements.add(new AchievementBuilder("Invention 5", -1).requirement("Invention", 5).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 10", -1).requirement("Invention", 10).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 20", -1).requirement("Invention", 20).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 30", -1).requirement("Invention", 30).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 40", -1).requirement("Invention", 40).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 50", -1).requirement("Invention", 50).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 60", -1).requirement("Invention", 60).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 70", -1).requirement("Invention", 70).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 80", -1).requirement("Invention", 80).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 84", -1).requirement("Invention", 84).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 90", -1).requirement("Invention", 90).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 99", -1).requirement("Invention", 99).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 102", -1).requirement("Invention", 102).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 110", -1).requirement("Invention", 110).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Invention 120", -1).requirement("Invention", 120).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("It's Not Called Surging Tombs", 0.05).requirement("The Jack of Spades", 1)
            .reward("Shifting Tombs", 1).build());
        achievements.add(new AchievementBuilder("Ivan is Flailing", 0).requirement("Vyre corpses burned", 500).build());
        achievements.add(new AchievementBuilder("Jack of the Circus", 1.15).requirement("Circus of Fire", 1).requirement("Magic", 90)
            .requirement("Ranged", 90).requirement("Agility", 90).requirement("Firemaking", 90).requirement("Thieving", 90)
            .reward("Magic", 125030).reward("Ranged", 88550).reward("Agility", 68750).reward("Firemaking", 76920)
            .reward("Thieving", 57040).build());
        achievements.add(new AchievementBuilder("K'ril Will Be Done", 0).requirement("Constitution", 70)
            .encounter(new Encounter("K'ril Tsutsaroth")).build());
        achievements.add(new AchievementBuilder("K'rilow", 0).requirement("Constitution", 70).requirement("Willow shieldbow", 1)
            .encounter(new Encounter("K'ril Tsutsaroth")).build());
        achievements.add(new AchievementBuilder("Kaiki's Tusks", 0).requirement("Airuts", 102).build());
        achievements.add(new AchievementBuilder("Kal'gerion Commander", 0).requirement("Kal'gerion demon", 2093)
            .requirement("Dungeoneering", 113).build());
        achievements.add(new AchievementBuilder("Kal'gerion Notes", 0.1).requirement("Dungeoneering", 113).build());
        achievements.add(new AchievementBuilder("Karamja", 0).build());
        achievements.add(new AchievementBuilder("Keeper of the Faith", 0).requirement("Commander Zilyana", 2438).build());
        achievements.add(new AchievementBuilder("Carnillean lamp 1", 0).requirement("Carnillean Rising", 1).requirement("Quest points", 50)
            .lamp(Player.ALL_SKILLS, 2000, 1).build());
        achievements.add(new AchievementBuilder("Carnillean lamp 2", 0).requirement("Carnillean lamp 1", 1).requirement("Quest points", 100)
            .lamp(Player.ALL_SKILLS, 5000, 1).build());
        achievements.add(new AchievementBuilder("Carnillean lamp 3", 0).requirement("Carnillean lamp 2", 1).requirement("Quest points", 150)
            .lamp(Player.ALL_SKILLS, 5000, 1).build());
        achievements.add(new AchievementBuilder("Carnillean lamp 4", 0).requirement("Carnillean lamp 3", 1).requirement("Quest points", 200)
            .lamp(Player.ALL_SKILLS, 10000, 1).build());
        achievements.add(new AchievementBuilder("Carnillean lamp 5", 0).requirement("Carnillean lamp 4", 1).requirement("Quest points", 250)
            .lamp(Player.ALL_SKILLS, 10000, 1).build());
        achievements.add(new AchievementBuilder("Carnillean lamp 6", 0).requirement("Carnillean lamp 5", 1).requirement("Quest points", 300)
            .lamp(Player.ALL_SKILLS, 10000, 1).build());
        achievements.add(new AchievementBuilder("Carnillean lamp 7", 0).requirement("Carnillean lamp 6", 1).requirement("Quest points", 350)
            .lamp(Player.ALL_SKILLS, 10000, 1).build());
        achievements.add(new AchievementBuilder("Keeping Up with the Carnilleans", 0).requirement("Carnillean lamp 7", 1).build());
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
        achievements.add(new AchievementBuilder("Koschei's Cache", 0).requirement("Koschei's Troubles (miniquest)", 1)
            .requirement("Strength", 90).requirement("Prayer", 90).build());
        achievements.add(new AchievementBuilder("Krar Jnr", 0.05).build());
        achievements.add(new AchievementBuilder("Pig creation machine 2", 0).requirement("Bringing Home the Bacon", 1)
            .requirement("Construction", 44).requirement("Crafting", 44).requirement("Summoning", 44).requirement("Oak plank", 3)
            .requirement("Steel bar", 2).requirement("Steel nails", 3).reward("Construction", 100).reward("Crafting", 100).build());
        achievements.add(new AchievementBuilder("Pig creation machine 3", 0).requirement("Pig creation machine 2", 1)
            .requirement("Construction", 84).requirement("Crafting", 84).requirement("Summoning", 84).requirement("Teak plank", 3)
            .requirement("Mithril bar", 2).requirement("Steel nails", 3).reward("Construction", 1000).reward("Crafting", 1000).build());
        achievements.add(new AchievementBuilder("Last of the Summer Swine", 0).requirement("Pig creation machine 3", 1).build());
        achievements.add(new AchievementBuilder("Learning from Mr. Mordaut", 0).requirement("One of a Kind", 1)
            .reward("Divination", 5000).build());
        achievements.add(new AchievementBuilder("Let us Give Ugthanks", 0).requirement("Camel warrior", 17).build());
        achievements.add(new AchievementBuilder("Liberated", 0).requirement("Liberation of Mazcab", 570).requirement("Yakamaru", 130)
            .requirement("Beastmaster Durzag", 355).build());
        achievements.add(new AchievementBuilder("Library of Nex", 0).requirement("Nex: Angel of Death", 1).build());
        achievements.add(new AchievementBuilder("Light as a Feather", 0).requirement("Kree'arra", 2441).build());
        achievements.add(new AchievementBuilder("Lighter Log", 0).requirement("Logs", 1).reward("Firemaking", 40).build());
        achievements.add(new AchievementBuilder("Like a Boss", 0).encounter(new Encounter(Arrays.asList(
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Goblin"), Collections.singletonList("Goblin"), Collections.singletonList("Goblin"),
            Collections.singletonList("Brokeface")))).build());
        achievements.add(new AchievementBuilder("Lil' Tuzzy", 0).requirement("Beastmaster Durzag", 355).build());
        achievements.add(new AchievementBuilder("Little Leaguer", 0).reward("Agility", 4).reward("Ranged", 4).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch I", 0).requirement("TzTok-Jad", 5).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch II", 0).requirement("TzTok-Jad", 10).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch III", 0).requirement("TzTok-Jad", 25).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch IV", 0).requirement("TzTok-Jad", 50).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch V", 0).requirement("TzTok-Jad", 75).build());
        achievements.add(new AchievementBuilder("Load of Bakulla", 0.1).requirement("The Fremennik Trials", 1).build());
        achievements.add(new AchievementBuilder("Lock, Stock and Barrel", 0).requirement("Menaphos reputation", 1200000).build());
        achievements.add(new AchievementBuilder("Lumbridge", 0).build());
        achievements.add(new AchievementBuilder("Port Sarim", 0).build());
        achievements.add(new AchievementBuilder("Taverley", 0).build());
        achievements.add(new AchievementBuilder("Varrock", 0).build());
        achievements.add(new AchievementBuilder("Lodestone Network Free Area", 0).requirement("Al Kharid", 1).requirement("Ashdale", 1)
            .requirement("Burthorpe", 1).requirement("Draynor", 1).requirement("Edgeville", 1).requirement("Falador", 1)
            .requirement("Lumbridge", 1).requirement("Port Sarim", 1).requirement("Taverley", 1).requirement("Varrock", 1)
            .requirement("Wilderness Volcano", 1).build());
        achievements.add(new AchievementBuilder("Lunar Isle", 0).requirement("Lunar Diplomacy", 1).build());
        achievements.add(new AchievementBuilder("Menaphos", 0).requirement("The Jack of Spades", 1).build());
        achievements.add(new AchievementBuilder("Oo'glog", 0).build());
        achievements.add(new AchievementBuilder("Prifddinas", 0).requirement("Plague's End", 1).build());
        achievements.add(new AchievementBuilder("Seers' Village", 0).build());
        achievements.add(new AchievementBuilder("Yanille", 0).build());
        achievements.add(new AchievementBuilder("Lodestone Network Members Area", 0).requirement("Ardougne", 1)
            .requirement("Bandit Camp", 1).requirement("Canifis", 1).requirement("Catherby", 1).requirement("Eagles' Peak (lodestone)", 1)
            .requirement("Fremennik Province", 1).requirement("Karamja", 1).requirement("Lunar Isle", 1).requirement("Menaphos", 1)
            .requirement("Oo'glog", 1).requirement("Prifddinas", 1).requirement("Seers' Village", 1).requirement("Tirannwn", 1)
            .requirement("Yanille", 1).build());
        achievements.add(new AchievementBuilder("Lodestone Network", 0).requirement("Lodestone Network Free Area", 1)
            .requirement("Lodestone Network Members Area", 1).build());
        achievements.add(new AchievementBuilder("Loot Pinata I", 0).requirement("Queen Black Dragon", 5).build());
        achievements.add(new AchievementBuilder("Loot Pinata II", 0).requirement("Queen Black Dragon", 10).build());
        achievements.add(new AchievementBuilder("Loot Pinata III", 0).requirement("Queen Black Dragon", 25).build());
        achievements.add(new AchievementBuilder("Loot Pinata IV", 0).requirement("Queen Black Dragon", 50).build());
        achievements.add(new AchievementBuilder("Loot Pinata V", 0).requirement("Queen Black Dragon", 75).build());
        achievements.add(new AchievementBuilder("Looting the Demon Throne", 0).requirement("The Golem", 1).reward("Sapphire", 2)
            .reward("Emerald", 2).reward("Ruby", 2).build());
        achievements.add(new AchievementBuilder("Long Live the Kings!", 0).requirement("Prime Hatchling", 1).requirement("Rex Hatchling", 1)
            .requirement("Supreme Hatchling", 1).build());
        achievements.add(new AchievementBuilder("Loyal Subject", 0.35).requirement("Anti-dragon shield", 0).requirement("Clingy mole", 1)
            .requirement("Crafting", 45).requirement("Defence", 55).build());
        achievements.add(new AchievementBuilder("Lumbridge Catacombs", 0).requirement("The Blood Pact", 1).build());
        achievements.add(new AchievementBuilder("Lumbridge Strikes Back", 0).requirement("Bronze full helm", 1)
            .requirement("Bronze platebody", 1).requirement("Bronze platelegs", 1).requirement("Bronze 2h sword", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor"), Collections.singletonList("Araxxi")))).build());
        achievements.add(new AchievementBuilder("Lurgon's Run", 0.05).requirement("Death to the Dorgeshuun", 1).build());
        achievements.add(new AchievementBuilder("Magic - Newton", 0).requirement("Magic pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Magic 5", -1).requirement("Magic", 5).build());
        achievements.add(new AchievementBuilder("Magic 10", -1).requirement("Magic", 10).build());
        achievements.add(new AchievementBuilder("Magic 20", -1).requirement("Magic", 20).build());
        achievements.add(new AchievementBuilder("Magic 30", -1).requirement("Magic", 30).build());
        achievements.add(new AchievementBuilder("Magic 40", -1).requirement("Magic", 40).build());
        achievements.add(new AchievementBuilder("Magic 50", -1).requirement("Magic", 50).build());
        achievements.add(new AchievementBuilder("Magic 60", -1).requirement("Magic", 60).build());
        achievements.add(new AchievementBuilder("Magic 70", -1).requirement("Magic", 70).build());
        achievements.add(new AchievementBuilder("Magic 80", -1).requirement("Magic", 80).build());
        achievements.add(new AchievementBuilder("Magic 90", -1).requirement("Magic", 90).build());
        achievements.add(new AchievementBuilder("Magic 92", -1).requirement("Magic", 92).build());
        achievements.add(new AchievementBuilder("Magic 99", -1).requirement("Magic", 99).build());
        achievements.add(new AchievementBuilder("Magister Smagister", 0.35).build());
        achievements.add(new AchievementBuilder("Make A Wish", 0).requirement("Fishing", 68).requirement("Coins", 1).build());
        achievements.add(new AchievementBuilder("Many Shades of a Cure", 0).requirement("Shades of Mort'ton", 1)
            .reward("Coins", 391).build());
        achievements.add(new AchievementBuilder("Marmaros and Thok Letters", 0.1).requirement("Dungeoneering", 107).build());
        achievements.add(new AchievementBuilder("Fish Flingers (first run)", 0.15).lamp(Collections.singletonList("Fishing"), -150, 1)
            .build());
        achievements.add(new AchievementBuilder("Master Angler", 20).requirement("Fish Flingers (first run)", 1)
            .lamp(Collections.singletonList("Fishing"), -20000, 1).build());
        achievements.add(new AchievementBuilder("Master Bogreman", 0).requirement("Big Chompy Bird Hunting", 1)
            .requirement("Chompy kills", 30).build());
        achievements.add(new AchievementBuilder("Chompy Massacre", 0).requirement("Master Bogreman", 1).requirement("Chompy kills", 4000)
            .reward("Ranged", 30000).build());
        achievements.add(new AchievementBuilder("Master Otto", 0).requirement("Barbarian Training", 1).build());
        achievements.add(new AchievementBuilder("White Knight Rises", 0).requirement("White Knight rank points", 1300).build());
        achievements.add(new AchievementBuilder("Witch's Potion (miniquest)", 0.25).requirement("Cooked meat", 1)
            .requirement("Eye of newt", 1).requirement("Onion", 1).encounter(new Encounter("Rat")).reward("Magic", 325).build());
        achievements.add(new AchievementBuilder("You're Not My Real Mah", 0).requirement("Elder chronicle fragment", 100)
            .reward("Divination", 45270).build());
        achievements.add(new AchievementBuilder("You Mistag This Brooch", 0).requirement("The Lost Tribe", 1)
            .reward("Mining helmet", 1).build());
    }

    private void addAchievementsPhase3() {
        achievements.add(new AchievementBuilder("Work for Idol Hands", 0.05).requirement("The Blood Pact", 1).reward("Coins", 2500)
                .build());
        achievements.add(new AchievementBuilder("Uzer Master", 0).requirement("Missing My Mummy", 1).build());
        achievements.add(new AchievementBuilder("Unholy Crafting", 0).requirement("Observatory Quest", 1).build());
        achievements.add(new AchievementBuilder("Under Croc and Key", 0).requirement("Crocodile Tears", 1)
            .requirement("Constitution", 80).reward("Constitution", 20000).build());
        achievements.add(new AchievementBuilder("Ultimate Codex", 0).requirement("The Dig Site", 1).requirement("Magic", 75).build());
        achievements.add(new AchievementBuilder("Triple Trouble", 0.05).requirement("Tai Bwo Wannai Trio", 1).reward("Attack", 2500)
            .reward("Strength", 2500).reward("Rune spear", 1).reward("Cooking", 5000).reward("Fishing", 5000).build());
        achievements.add(new AchievementBuilder("Trials of the Heart", 0).requirement("Quest points", 300).build());
        achievements.add(new AchievementBuilder("Wandering Ga'al (miniquest)", 1.3).requirement("The Brink of Extinction", 1)
            .requirement("Desert Treasure", 1).requirement("TzTok-Jad", 1).requirement("Ring of stone", 0).reward("Smithing", 750).build());
        achievements.add(new AchievementBuilder("Three's a Kiln", 0).requirement("Har-Aken", 3).build());
        achievements.add(new AchievementBuilder("Slayer Codex unlock", 0).requirement("Slayer", 99).requirement("The Jack of Spades", 1)
            .build());
        achievements.add(new AchievementBuilder("Monkey soul", 0).requirement("Slayer Codex unlock", 1).requirement("Monkeys", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Goblin soul", 0).requirement("Slayer Codex unlock", 1).requirement("Goblins", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Rat soul", 0).requirement("Slayer Codex unlock", 1).encounter(new Encounter("Rat"))
            .encounter(new Encounter("Rat")).encounter(new Encounter("Rat")).encounter(new Encounter("Rat")).encounter(new Encounter("Rat"))
            .encounter(new Encounter("Rat")).encounter(new Encounter("Rat")).reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Am I a Slayer Master Yet?", 0).requirement("Monkey soul", 1).requirement("Goblin soul", 1)
            .requirement("Rat soul", 1).build());
        achievements.add(new AchievementBuilder("Spider soul", 0).requirement("Slayer Codex unlock", 1).requirement("Spiders", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Bird soul", 0).requirement("Slayer Codex unlock", 1).requirement("Birds", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Cow soul", 0).requirement("Slayer Codex unlock", 1).requirement("Cows", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Scorpion soul", 0).requirement("Slayer Codex unlock", 1).requirement("Scorpions", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Bat soul", 0).requirement("Slayer Codex unlock", 1).requirement("Bats", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Wolf soul", 0).requirement("Slayer Codex unlock", 1).requirement("Wolves", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Zombie soul", 0).requirement("Slayer Codex unlock", 1).requirement("Zombies", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Skeleton soul", 0).requirement("Slayer Codex unlock", 1).requirement("Skeletons", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Ghost soul", 0).requirement("Slayer Codex unlock", 1).requirement("Ghosts", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Bear soul", 0).requirement("Slayer Codex unlock", 1).requirement("Bears", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Troll soul", 0).requirement("Slayer Codex unlock", 1).requirement("Trolls", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Dog soul", 0).requirement("Slayer Codex unlock", 1).requirement("Trolls", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Gelatinous abomination soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Gelatinous abominations", 7).reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Pig soul", 0).requirement("Slayer Codex unlock", 1).requirement("Pigs", 7)
            .reward("Slayer", 250).build());
        achievements.add(new AchievementBuilder("Hill giant soul", 0).requirement("Slayer Codex unlock", 1).requirement("Hill giants", 14)
            .reward("Slayer", 500).build());
        achievements.add(new AchievementBuilder("Ice warrior soul", 0).requirement("Slayer Codex unlock", 1).requirement("Ice warriors", 14)
            .reward("Slayer", 500).build());
        achievements.add(new AchievementBuilder("Hobgoblin soul", 0).requirement("Slayer Codex unlock", 1).requirement("Hobgoblins", 14)
            .reward("Slayer", 500).build());
        achievements.add(new AchievementBuilder("Crocodile soul", 0).requirement("Slayer Codex unlock", 1).requirement("Crocodiles", 14)
            .reward("Slayer", 500).build());
        achievements.add(new AchievementBuilder("Ice giant soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Ice giants", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Fire giant soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Fire giants", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Moss giant soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Moss giants", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Ogre soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Ogres", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Ghoul soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Ghouls", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Crawling hand soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Crawling hands", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Icefiend soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Icefiends", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Minotaur soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Minotaurs", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Flesh Crawler soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Flesh crawlers", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Catablepon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Catablepon", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Ankou soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Ankous", 35).reward("Slayer", 1250).build());
        achievements.add(new AchievementBuilder("Cave bug soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Cave bugs", 49).reward("Slayer", 1750).build());
        achievements.add(new AchievementBuilder("Shadow warrior soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Shadow warriors", 69).reward("Slayer", 2500).build());
        achievements.add(new AchievementBuilder("Cave crawler soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Cave crawlers", 69).reward("Slayer", 2500).build());
        achievements.add(new AchievementBuilder("Earth warrior soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Earth warrior", 69).reward("Slayer", 2500).build());
        achievements.add(new AchievementBuilder("Otherworldly being soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Otherworldly beings", 69).reward("Slayer", 2500).build());
        achievements.add(new AchievementBuilder("Dwarf soul", 0).requirement("Slayer Codex unlock", 1).requirement("Dwarves", 69)
            .reward("Slayer", 2500).build());
        achievements.add(new AchievementBuilder("Cyclops soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Cyclopes", 69).reward("Slayer", 2500).build());
        achievements.add(new AchievementBuilder("Lesser demon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Lesser demon", 104).reward("Slayer", 3750).build());
        achievements.add(new AchievementBuilder("Werewolf soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Werewolves", 104).reward("Slayer", 3750).build());
        achievements.add(new AchievementBuilder("Banshee soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Banshees", 104).reward("Slayer", 3750).build());
        achievements.add(new AchievementBuilder("Cave slime soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Cave slimes", 118).reward("Slayer", 4250).build());
        achievements.add(new AchievementBuilder("Green dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Green dragons", 139).reward("Slayer", 5000).build());
        achievements.add(new AchievementBuilder("Greater demon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Greater demons", 139).reward("Slayer", 5000).build());
        achievements.add(new AchievementBuilder("Rockslug soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Rockslugs", 139).reward("Slayer", 5000).build());
        achievements.add(new AchievementBuilder("Sea snake soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Sea snakes", 139).reward("Slayer", 5000).build());
        achievements.add(new AchievementBuilder("Desert lizard soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Desert lizards", 153).reward("Slayer", 5500).build());
        achievements.add(new AchievementBuilder("Black demon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Black demons", 173).reward("Slayer", 6250).build());
        achievements.add(new AchievementBuilder("Hellhound soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Hellhounds", 173).reward("Slayer", 6250).build());
        achievements.add(new AchievementBuilder("Dagannoth soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Dagannoth", 173).reward("Slayer", 6250).build());
        achievements.add(new AchievementBuilder("Cockatrice soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Cockatrices", 173).reward("Slayer", 6250).build());
        achievements.add(new AchievementBuilder("Kalphite soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Kalphites", 173).reward("Slayer", 6250).build());
        achievements.add(new AchievementBuilder("Shade soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Shades", 173).reward("Slayer", 6250).build());
        achievements.add(new AchievementBuilder("Blue dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Blue dragons", 208).reward("Slayer", 7500).build());
        achievements.add(new AchievementBuilder("Vampyre soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Vampyres", 208).reward("Slayer", 7500).build());
        achievements.add(new AchievementBuilder("Pyrefiend soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Pyrefiends", 208).reward("Slayer", 7500).build());
        achievements.add(new AchievementBuilder("Bronze dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Bronze dragons", 208).reward("Slayer", 7500).build());
        achievements.add(new AchievementBuilder("Grotworm soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Grotworms", 208).reward("Slayer", 7500).build());
        achievements.add(new AchievementBuilder("Vyrewatch soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Vyrewatches", 215).reward("Slayer", 7750).build());
        achievements.add(new AchievementBuilder("Mogre soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Mogre", 222).reward("Slayer", 8000).build());
        achievements.add(new AchievementBuilder("Harpie Bug Swarm soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Harpie Bug Swarms", 229).reward("Slayer", 8250).build());
        achievements.add(new AchievementBuilder("Elf soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Elves", 243).reward("Slayer", 8750).build());
        achievements.add(new AchievementBuilder("Wall beast soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Wall beasts", 243).reward("Slayer", 8750).build());
        achievements.add(new AchievementBuilder("Scabarite soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Scabarites", 243).reward("Slayer", 8750).build());
        achievements.add(new AchievementBuilder("Killerwatt soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Killerwatts", 257).reward("Slayer", 9250).build());
        achievements.add(new AchievementBuilder("Molanisk soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Molanisks", 270).reward("Slayer", 9750).build());
        achievements.add(new AchievementBuilder("Red dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Red dragons", 277).reward("Slayer", 10000).build());
        achievements.add(new AchievementBuilder("Basilisk soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Basilisks", 277).reward("Slayer", 10000).build());
        achievements.add(new AchievementBuilder("Iron dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Iron dragons", 277).reward("Slayer", 10000).build());
        achievements.add(new AchievementBuilder("Jungle horror soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Jungle horrors", 277).reward("Slayer", 10000).build());
        achievements.add(new AchievementBuilder("Terror dog soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Terror dogs", 277).reward("Slayer", 10000).build());
        achievements.add(new AchievementBuilder("Fever spider soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Fever spiders", 291).reward("Slayer", 10500).build());
        achievements.add(new AchievementBuilder("Infernal mage soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Infernal mages", 312).reward("Slayer", 11250).build());
        achievements.add(new AchievementBuilder("Brine rat soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Brine rats", 326).reward("Slayer", 11750).build());
        achievements.add(new AchievementBuilder("Black dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Black dragons", 347).reward("Slayer", 12500).build());
        achievements.add(new AchievementBuilder("Bloodveld soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Bloodveld", 347).reward("Slayer", 12500).build());
        achievements.add(new AchievementBuilder("Steel dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Steel dragons", 347).reward("Slayer", 12500).build());
        achievements.add(new AchievementBuilder("Gorak soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Gorak", 347).reward("Slayer", 12500).build());
        achievements.add(new AchievementBuilder("Suqah soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Suqah", 347).reward("Slayer", 12500).build());
        achievements.add(new AchievementBuilder("Waterfiend soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Waterfiends", 347).reward("Slayer", 12500).build());
        achievements.add(new AchievementBuilder("Fungal mage soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Fungal mages", 347).reward("Slayer", 12500).build());
        achievements.add(new AchievementBuilder("Jelly soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Jellies", 361).reward("Slayer", 13000).build());
        achievements.add(new AchievementBuilder("Turoth soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Turoths", 381).reward("Slayer", 13750).build());
        achievements.add(new AchievementBuilder("Warped tortoise soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Warped tortoises", 388).reward("Slayer", 14000).build());
        achievements.add(new AchievementBuilder("Warped terrorbird soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Warped terrorbirds", 388).reward("Slayer", 14000).build());
        achievements.add(new AchievementBuilder("Mutated zygomite soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Mutated zygomites", 395).reward("Slayer", 14250).build());
        achievements.add(new AchievementBuilder("Cave horror soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Cave horrors", 402).reward("Slayer", 14500).build());
        achievements.add(new AchievementBuilder("Aberrant spectre soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Aberrant spectres", 416).reward("Slayer", 15000).build());
        achievements.add(new AchievementBuilder("Mithril dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Mithril dragons", 416).reward("Slayer", 15000).build());
        achievements.add(new AchievementBuilder("Aviansie soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Aviansies", 416).reward("Slayer", 15000).build());
        achievements.add(new AchievementBuilder("Spiritual ranger soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Spiritual rangers", 437).reward("Slayer", 15750).build());
        achievements.add(new AchievementBuilder("Dust devil soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Dust devils", 451).reward("Slayer", 16250).build());
        achievements.add(new AchievementBuilder("Spiritual warrior soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Spiritual warriors", 471).reward("Slayer", 17000).build());
        achievements.add(new AchievementBuilder("Kurask soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Kurasks", 485).reward("Slayer", 17500).build());
        achievements.add(new AchievementBuilder("Automaton soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Automatons", 485).reward("Slayer", 17500).build());
        achievements.add(new AchievementBuilder("Celestial dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Celestial dragons", 485).reward("Slayer", 17500).build());
        achievements.add(new AchievementBuilder("Chaos Giant soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Chaos Giants", 485).reward("Slayer", 17500).build());
        achievements.add(new AchievementBuilder("Seeker soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Seeker", 492).reward("Slayer", 17750).build());
        achievements.add(new AchievementBuilder("Skeletal wyvern soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Skeletal wyverns", 499).reward("Slayer", 18000).build());
        achievements.add(new AchievementBuilder("The History of Slayer", 0).requirement("Am I a Slayer Master Yet?", 1)
            .requirement("Spider soul", 1).requirement("Bird soul", 1).requirement("Cow soul", 1).requirement("Scorpion soul", 1)
            .requirement("Bat soul", 1).requirement("Wolf soul", 1).requirement("Zombie soul", 1).requirement("Skeleton soul", 1)
            .requirement("Ghost soul", 1).requirement("Bear soul", 1).requirement("Troll soul", 1).requirement("Dog soul", 1)
            .requirement("Gelatinous abomination soul", 1).requirement("Pig soul", 1).requirement("Hill giant soul", 1)
            .requirement("Ice warrior soul", 1).requirement("Hobgoblin soul", 1).requirement("Crocodile soul", 1)
            .requirement("Ice giant soul", 1).requirement("Fire giant soul", 1).requirement("Moss giant soul", 1)
            .requirement("Ogre soul", 1).requirement("Ghoul soul", 1).requirement("Crawling hand soul", 1).requirement("Icefiend soul", 1)
            .requirement("Minotaur soul", 1).requirement("Flesh Crawler soul", 1).requirement("Catablepon soul", 1)
            .requirement("Ankou soul", 1).requirement("Cave bug soul", 1).requirement("Shadow warrior soul", 1)
            .requirement("Cave crawler soul", 1).requirement("Earth warrior soul", 1).requirement("Otherworldly being soul", 1)
            .requirement("Dwarf soul", 1).requirement("Cyclops soul", 1).requirement("Lesser demon soul", 1)
            .requirement("Werewolf soul", 1).requirement("Banshee soul", 1).requirement("Cave slime soul", 1)
            .requirement("Green dragon soul", 1).requirement("Greater demon soul", 1).requirement("Rockslug soul", 1)
            .requirement("Sea snake soul", 1).requirement("Desert lizard soul", 1).requirement("Black demon soul", 1)
            .requirement("Hellhound soul", 1).requirement("Dagannoth soul", 1).requirement("Cockatrice soul", 1)
            .requirement("Kalphite soul", 1).requirement("Shade soul", 1).requirement("Blue dragon soul", 1)
            .requirement("Vampyre soul", 1).requirement("Pyrefiend soul", 1).requirement("Bronze dragon soul", 1)
            .requirement("Grotworm soul", 1).requirement("Vyrewatch soul", 1).requirement("Mogre soul", 1)
            .requirement("Harpie Bug Swarm soul", 1).requirement("Elf soul", 1).requirement("Wall beast soul", 1)
            .requirement("Scabarite soul", 1).requirement("Killerwatt soul", 1).requirement("Molanisk soul", 1)
            .requirement("Red dragon soul", 1).requirement("Basilisk soul", 1).requirement("Iron dragon soul", 1)
            .requirement("Jungle horror soul", 1).requirement("Terror dog soul", 1).requirement("Fever spider soul", 1)
            .requirement("Infernal mage soul", 1).requirement("Brine rat soul", 1).requirement("Black dragon soul", 1)
            .requirement("Bloodveld soul", 1).requirement("Steel dragon soul", 1).requirement("Gorak soul", 1).requirement("Suqah soul", 1)
            .requirement("Waterfiend soul", 1).requirement("Fungal mage soul", 1).requirement("Jelly soul", 1).requirement("Turoth soul", 1)
            .requirement("Warped tortoise soul", 1).requirement("Warped terrorbird soul", 1).requirement("Mutated zygomite soul", 1)
            .requirement("Cave horror soul", 1).requirement("Aberrant spectre soul", 1).requirement("Mithril dragon soul", 1)
            .requirement("Aviansie soul", 1).requirement("Spiritual ranger soul", 1).requirement("Dust devil soul", 1)
            .requirement("Spiritual warrior soul", 1).requirement("Kurask soul", 1).requirement("Automaton soul", 1)
            .requirement("Celestial dragon soul", 1).requirement("Chaos Giant soul", 1).requirement("Seeker soul", 1)
            .requirement("Skeletal wyvern soul", 1).build());
        achievements.add(new AchievementBuilder("That'll Teach Bill", 0).requirement("Cabin Fever", 1).reward("Coins", 10000)
            .build());
        achievements.add(new AchievementBuilder("Tasty Bobbles", 0).requirement("Gower Quest", 1).build());
        achievements.add(new AchievementBuilder("Death Plateau supply run 1", 0.05).requirement("Death Plateau", 1)
            .requirement("Combat", 10).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1)
            .build());
        achievements.add(new AchievementBuilder("Death Plateau supply run 2", 0.05).requirement("Death Plateau supply run 1", 1)
            .requirement("Combat", 12).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1)
            .build());
        achievements.add(new AchievementBuilder("Death Plateau supply run 3", 0.05).requirement("Death Plateau supply run 2", 1)
            .requirement("Combat", 14).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1)
            .build());
        achievements.add(new AchievementBuilder("Death Plateau supply run 4", 0.05).requirement("Death Plateau supply run 3", 1)
            .requirement("Combat", 16).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1)
            .build());
        achievements.add(new AchievementBuilder("Death Plateau supply run 5", 0.05).requirement("Death Plateau supply run 4", 1)
            .requirement("Combat", 18).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1).lamp(Player.ALL_SKILLS, 180, 1)
            .build());
        achievements.add(new AchievementBuilder("Supply and Demand", 0).requirement("Death Plateau supply run 5", 1).build());
        achievements.add(new AchievementBuilder("Wilderness spirit portal - Attack", 0).requirement("Summer's End", 1)
            .requirement("Attack", 50).reward("Attack", 11250).build());
        achievements.add(new AchievementBuilder("Wilderness spirit portal - Prayer A", 0).requirement("Summer's End", 1)
            .requirement("Prayer", 50).reward("Prayer", 7500).build());
        achievements.add(new AchievementBuilder("Wilderness spirit portal - Prayer B", 0).requirement("Summer's End", 1)
            .requirement("Prayer", 50).reward("Prayer", 15000).build());
        achievements.add(new AchievementBuilder("Wilderness spirit portal - Farming A", 0).requirement("Summer's End", 1)
            .requirement("Farming", 46).reward("Farming", 7500).build());
        achievements.add(new AchievementBuilder("Wilderness spirit portal - Farming B", 0).requirement("Summer's End", 1)
            .requirement("Farming", 50).reward("Farming", 15000).build());
        achievements.add(new AchievementBuilder("Wilderness spirit portal - Smithing", 0).requirement("Summer's End", 1)
            .requirement("Smithing", 50).reward("Smithing", 7500).build());
        achievements.add(new AchievementBuilder("Wilderness spirit portal - Defence", 0).requirement("Summer's End", 1)
            .requirement("Defence", 80).reward("Defence", 15000).build());
        achievements.add(new AchievementBuilder("Wilderness spirit portal - Thieving", 0).requirement("Summer's End", 1)
            .requirement("Thieving", 60).reward("Thieving", 15000).build());
        achievements.add(new AchievementBuilder("Summary Spirits", 0).requirement("Wilderness spirit portal - Attack", 1)
            .requirement("Wilderness spirit portal - Prayer A", 1).requirement("Wilderness spirit portal - Prayer B", 1)
            .requirement("Wilderness spirit portal - Farming A", 1).requirement("Wilderness spirit portal - Farming B", 1)
            .requirement("Wilderness spirit portal - Smithing", 1).requirement("Wilderness spirit portal - Defence", 1)
            .requirement("Wilderness spirit portal - Thieving", 1).build());
        achievements.add(new AchievementBuilder("Stealing Sedridor's Stones", 0).requirement("Runecrafting", 99)
            .requirement("Rune Memories", 1).reward("Pure essence", 24750).build());
        achievements.add(new AchievementBuilder("Stalker Notes", 0.1).requirement("Dungeoneering", 107).build());
        achievements.add(new AchievementBuilder("Squeal for Coins", 0).requirement("The Mighty Fall", 1).reward("Coins", 73105)
            .build());
        achievements.add(new AchievementBuilder("Some Old Dusty Journals", 0.05).requirement("The Light Within", 1).build());
        achievements.add(new AchievementBuilder("Purple Cat (miniquest)", 0.25).requirement("Gertrude's Cat", 1)
            .requirement("Swept Away", 1).build());
        achievements.add(new AchievementBuilder("Tales of the God Wars (miniquest)", 0).requirement("Constitution", 70)
            .requirement("Strength", 60).requirement("Troll Stronghold", 1).encounter(new Encounter("K'ril Tsutsaroth"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm"))
            .encounter(new Encounter("Young grotworm")).encounter(new Encounter("Young grotworm")).encounter(new Encounter("Grotworm"))
            .encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm"))
            .encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm"))
            .encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm"))
            .encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm"))
            .encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm"))
            .encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm")).encounter(new Encounter("Grotworm"))
            .encounter(new Encounter("Grotworm")).encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm"))
            .encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm"))
            .encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm"))
            .encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm"))
            .encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm"))
            .encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm"))
            .encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm"))
            .encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm"))
            .encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm"))
            .encounter(new Encounter("Mature grotworm")).encounter(new Encounter("Mature grotworm")).reward("K'ril Tsutsaroth", 1)
            .reward("Zamorak reputation", 500).lamp(Arrays.asList("Attack", "Constitution", "Strength", "Defence", "Ranged", "Prayer",
                "Magic", "Slayer", "Summoning", "Divination"), 30000, 1).build());
        achievements.add(new AchievementBuilder("Skeletal Wishes", 0).requirement("Fur 'n' Seek wish list", 1).build());
        achievements.add(new AchievementBuilder("Shadow Hanging Over Me", 0).requirement("A Shadow over Ashdale", 1)
            .reward("Coins", 757).reward("Uncut sapphire", 4).reward("Uncut emerald", 1).build());
        achievements.add(new AchievementBuilder("Sentient Letters", 0).requirement("Senntisten scroll", 4).build());
        achievements.add(new AchievementBuilder("Scribblings of a Dragonkin", 0).requirement("Plague's End", 1)
            .requirement("Dungeoneering", 115).build());
        achievements.add(new AchievementBuilder("Scribbling in the Depths", 0).requirement("Song from the Depths", 1)
            .requirement("Constitution", 80).build());
        achievements.add(new AchievementBuilder("Scabigail", 0).requirement("Mummy", 850).reward("Coins", 10000).build());
        achievements.add(new AchievementBuilder("Rusty Reward", 0).requirement("Rocking Out", 1).reward("Coins", 20).build());
        achievements.add(new AchievementBuilder("Rogue Down", 0.05).requirement("Summer's End", 1).build());
        achievements.add(new AchievementBuilder("Guthix torches", 0).requirement("The World Wakes", 1).requirement("Firemaking", 74)
            .reward("Firemaking", 50000).build());
        achievements.add(new AchievementBuilder("Pay respects to Guthix", 0).requirement("The World Wakes", 1).requirement("Prayer", 90)
            .reward("Prayer", 100000).build());
        achievements.add(new AchievementBuilder("Respect the Balance", 0).requirement("Guthix torches", 1)
            .requirement("Pay respects to Guthix", 1).build());
        achievements.add(new AchievementBuilder("Reliquary of Cithara", 0).requirement("A, B, Cithara", 1).reward("Prayer", 50000)
            .build());
        achievements.add(new AchievementBuilder("Relight my Fire", 0.05).requirement("While Guthix Sleeps", 1).requirement("Magic", 75)
            .requirement("Air rune", 12).requirement("Fire rune", 12).build());
        achievements.add(new AchievementBuilder("Quiet but Deadly Lore", 0).requirement("Queen Black Dragon", 40).build());
        achievements.add(new AchievementBuilder("Power of Three Spirits", 0).requirement("Plague's End", 1)
            .requirement("The Prisoner of Glouphrie", 1).requirement("Farming", 89).build());
        achievements.add(new AchievementBuilder("Monstrous cave crawler", 0).requirement("Smoking Kills", 1)
            .encounter(new Encounter("Monstrous cave crawler")).reward("Slayer", 1000).build());
        achievements.add(new AchievementBuilder("Basilisk boss", 0).requirement("Smoking Kills", 1).requirement("Slayer", 40)
            .encounter(new Encounter("Basilisk boss")).reward("Slayer", 1000).build());
        achievements.add(new AchievementBuilder("Mightiest turoth", 0).requirement("Smoking Kills", 1).requirement("Slayer", 55)
            .encounter(new Encounter("Mightiest turoth")).reward("Slayer", 1000).build());
        achievements.add(new AchievementBuilder("Kurask overlord", 0).requirement("Smoking Kills", 1).requirement("Slayer", 70)
            .encounter(new Encounter("Kurask overlord")).reward("Slayer", 1000).build());
        achievements.add(new AchievementBuilder("Desert Slayer Dungeon (miniquest)", 0).requirement("Monstrous cave crawler", 1)
            .requirement("Basilisk boss", 1).requirement("Mightiest turoth", 1).requirement("Kurask overlord", 1).build());
        achievements.add(new AchievementBuilder("Penny for Your Life", 11).requirement("Dimension of Disaster: Curse of Arrav", 1).build());
        achievements.add(new AchievementBuilder("Paint it Red", 0.05).requirement("River of Blood", 1).build());
        achievements.add(new AchievementBuilder("Oyster Mash", 0.05).requirement("Beneath Cursed Tides", 1).build());
        achievements.add(new AchievementBuilder("Otto the Ancient", 0).requirement("Barbarian Scavenger", 1).build());
        achievements.add(new AchievementBuilder("Ornate Crockery", 0).requirement("Tears of Guthix", 1).requirement("Mining", 80)
            .requirement("Crafting", 80).build());
        achievements.add(new AchievementBuilder("One Man's Junk...Is Mine", 0.1).requirement("While Guthix Sleeps", 1).reward("Coal", 100)
            .reward("Death rune", 100).reward("Fire rune", 100).reward("Magic logs", 100).build());
        achievements.add(new AchievementBuilder("One Final Ride", 0).requirement("King Black Dragon", 693).build());
        achievements.add(new AchievementBuilder("God Emissaries exploration task 1", 0.1).reward("Agility", 500).build());
        achievements.add(new AchievementBuilder("God Emissaries exploration task 2", 0.1).requirement("Agility", 20)
            .requirement("God Emissaries exploration task 1", 1).reward("Agility", 2000).build());
        achievements.add(new AchievementBuilder("God Emissaries exploration task 3", 0.05).requirement("Agility", 30)
            .requirement("God Emissaries exploration task 2", 1).reward("Agility", 3000).build());
        achievements.add(new AchievementBuilder("God Emissaries exploration task 4", 0.1).requirement("Agility", 50)
            .requirement("God Emissaries exploration task 3", 1).reward("Agility", 7500).build());
        achievements.add(new AchievementBuilder("God Emissaries skilling task 1", 0.05).requirement("Bronze bar", 12)
            .reward("Smithing", 180).reward("Bronze 2h sword", 3).lamp(Arrays.asList("Cooking", "Smithing"), 750, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries skilling task 2", 0.1).requirement("Mining", 30)
            .requirement("God Emissaries skilling task 1", 1).lamp(Arrays.asList("Woodcutting", "Mining", "Fishing"), 4000, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries skilling task 3", 0.1).requirement("Firemaking", 40).requirement("Logs", 16)
            .requirement("God Emissaries skilling task 2", 1).lamp(Arrays.asList("Firemaking", "Crafting"), 7500, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries skilling task 4", 0.1).requirement("Thieving", 50)
            .requirement("God Emissaries skilling task 3", 1).lamp(Arrays.asList("Thieving", "Hunter"), 10000, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries skilling task 5", 0.1).requirement("Summoning", 50).requirement("Magic", 50)
            .requirement("Prayer", 50).requirement("Runecrafting", 50).requirement("Crafting", 50).requirement("Smithing", 50)
            .requirement("Mining", 60).requirement("Woodcutting", 30).requirement("Fishing", 30).requirement("Fire rune", 1)
            .requirement("Air rune", 1).requirement("Water rune", 1).requirement("Earth rune", 1).requirement("Body rune", 1)
            .requirement("Mind rune", 1).requirement("God Emissaries skilling task 4", 1)
            .lamp(Arrays.asList("Woodcutting", "Mining", "Fishing"), 10000, 1).lamp(Arrays.asList("Crafting", "Smithing"), 10000, 1)
            .lamp(Arrays.asList("Magic", "Runecrafting", "Prayer", "Summoning"), 10000, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries combat task 1", 0).encounter(new Encounter("Goblin"))
            .encounter(new Encounter("Goblin")).encounter(new Encounter("Goblin")).encounter(new Encounter("Goblin"))
            .encounter(new Encounter("Goblin")).encounter(new Encounter("Goblin")).encounter(new Encounter("Goblin"))
            .encounter(new Encounter("Goblin")).encounter(new Encounter("Goblin")).encounter(new Encounter("Goblin"))
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Constitution", "Defence"), 500, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries combat task 2", 0).requirement("Magic", 25)
            .requirement("God Emissaries combat task 1", 1).encounter(new Encounter("Black Knight"))
            .encounter(new Encounter("Black Knight")).encounter(new Encounter("Black Knight")).encounter(new Encounter("Black Knight"))
            .encounter(new Encounter("Black Knight"))
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Constitution", "Defence"), 2000, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries combat task 3", 0.05).requirement("Magic", 30)
            .requirement("God Emissaries combat task 2", 1)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Constitution", "Defence"), 4000, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries combat task 4", 0).requirement("Magic", 40)
            .requirement("God Emissaries combat task 3", 1).encounter(new Encounter("Kalphite Worker"))
            .encounter(new Encounter("Kalphite Worker")).encounter(new Encounter("Kalphite Worker"))
            .encounter(new Encounter("Kalphite Worker")).encounter(new Encounter("Kalphite Worker"))
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Constitution", "Defence"), 7500, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries combat task 5", 0.05).requirement("Magic", 50)
            .requirement("God Emissaries combat task 4", 1).encounter(new Encounter("Jogre")).encounter(new Encounter("Jogre"))
            .encounter(new Encounter("Jogre")).encounter(new Encounter("Jogre")).encounter(new Encounter("Jogre"))
            .encounter(new Encounter("Jogre")).encounter(new Encounter("Jogre")).encounter(new Encounter("Jogre"))
            .encounter(new Encounter("Jogre")).encounter(new Encounter("Jogre")).encounter(new Encounter("Lesser demon"))
            .encounter(new Encounter("Lesser demon")).encounter(new Encounter("Lesser demon")).encounter(new Encounter("Lesser demon"))
            .encounter(new Encounter("Lesser demon")).encounter(new Encounter("Baby blue dragon"))
            .encounter(new Encounter("Baby blue dragon")).encounter(new Encounter("Baby blue dragon"))
            .encounter(new Encounter("Baby blue dragon")).encounter(new Encounter("Baby blue dragon"))
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Constitution", "Defence"), 10000, 1).build());
        achievements.add(new AchievementBuilder("God Emissaries combat task 6", 0).requirement("Magic", 55)
            .requirement("God Emissaries combat task 5", 1).encounter(new Encounter("Black demon"))
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Constitution", "Defence"), 10000, 1)
            .lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Constitution", "Defence"), 10000, 1).build());
        achievements.add(new AchievementBuilder("On a Mission From... The Gods", 0).requirement("God Emissaries combat task 6", 1)
            .requirement("God Emissaries skilling task 5", 1).requirement("God Emissaries exploration task 4", 1).build());
        achievements.add(new AchievementBuilder("Ocellus Virius Notus", 0).requirement("Legiones", 884).build());
        achievements.add(new AchievementBuilder("Tales of Nomad (miniquest)", 0.25).requirement("Nomad's Elegy", 1)
            .lamp(Player.ALL_SKILLS, 1500, 1).lamp(Player.ALL_SKILLS, 1500, 1).lamp(Player.ALL_SKILLS, 1500, 1).build());
        achievements.add(new AchievementBuilder("Naturally Muspah", 0).requirement("The Tale of the Muspah", 1)
            .lamp(Player.ALL_SKILLS, 200, 10).build());
        achievements.add(new AchievementBuilder("Nano To Kipple, Come In Kipple", 0).requirement("Heart of Stone", 1).build());
        achievements.add(new AchievementBuilder("Mysterious statues", 0.15).requirement("One of a Kind", 1)
            .lamp(Player.ALL_SKILLS, 10000, 1).build());
        achievements.add(new AchievementBuilder("Submerged statue", 0).requirement("One of a Kind", 1)
            .requirement("Ritual of the Mahjarrat", 1).lamp(Player.ALL_SKILLS, 25000, 1).build());
        achievements.add(new AchievementBuilder("Mysteries of the TokHaar", 0).requirement("Mysterious statues", 1)
            .requirement("Submerged statue", 1).build());
        achievements.add(new AchievementBuilder("My Adze is Bigger than Yours", 0).requirement("Varrock Calls For Aid!", 1).build());
        achievements.add(new AchievementBuilder("Mixing in Ancient Circles", 0).requirement("Barbarian Firemaking", 1)
            .requirement("Bittercap mushroom", 5).build());
        achievements.add(new AchievementBuilder("Miscellaneous Notes", 0.1).requirement("Dungeoneering", 95).build());
        achievements.add(new AchievementBuilder("Milky Teeth", 0).requirement("Hunter", 51).requirement("Lunar Diplomacy", 1)
            .requirement("The Dig Site", 1).requirement("Monkey Madness", 1).requirement("A Fairy Tale III - Battle at Ork's Rift", 1)
            .encounter(new Encounter("Suqah")).reward("Hunter", 200).build());
        achievements.add(new AchievementBuilder("Met Het Yet?", 0).requirement("Our Man in the North", 1).requirement("Strength", 80)
            .reward("Strength", 20000).build());
        achievements.add(new AchievementBuilder("Memoirs of a Mahjarrat", 0).requirement("Mahjarrat Memories (miniquest)", 1).build());
        achievements.add(new AchievementBuilder("Measure of Old", 0.15).requirement("Fate of the Gods", 1).reward("Divination", 200000)
            .build());
        achievements.add(new AchievementBuilder("Pieces of Hate thieving mural", 0).requirement("Pieces of Hate", 1)
            .requirement("Thieving", 85).reward("Thieving", 50000).build());
        achievements.add(new AchievementBuilder("Pieces of Hate agility mural", 0).requirement("Pieces of Hate", 1)
            .requirement("Agility", 85).reward("Agility", 50000).build());
        achievements.add(new AchievementBuilder("Pieces of Hate firemaking mural", 0).requirement("Pieces of Hate", 1)
            .requirement("Firemaking", 85).reward("Firemaking", 50000).build());
        achievements.add(new AchievementBuilder("Pieces of Hate construction mural", 0).requirement("Pieces of Hate", 1)
            .requirement("Construction", 85).reward("Construction", 50000).build());
        achievements.add(new AchievementBuilder("Roake Kal", 0).requirement("Pieces of Hate thieving mural", 1)
            .requirement("Pieces of Hate agility mural", 1).requirement("Pieces of Hate firemaking mural", 1)
            .requirement("Pieces of Hate construction mural", 1).build());
        achievements.add(new AchievementBuilder("Lovingly Crafted", 0.2).requirement("Fur 'n' Seek wish list", 1)
            .requirement("Cabin Fever", 1).encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).encounter(new Encounter("Unspeakable horror"))
            .encounter(new Encounter("Unspeakable horror")).build());
        achievements.add(new AchievementBuilder("Rebuilding Edgeville (miniquest)", 0.25).requirement("Ritual of the Mahjarrat", 1)
            .requirement("Bittercap mushroom", 5).requirement("Plank", 20).requirement("Oak plank", 10).requirement("Mahogany plank", 10)
            .requirement("Molten glass", 1).requirement("Marble block", 1).requirement("Water rune", 100).reward("Magic", 50000)
            .reward("Construction", 45000).reward("Farming", 20000).reward("Mining", 10000).reward("Prayer", 5000)
            .lamp(Player.ALL_SKILLS, -9, 1).build());
        achievements.add(new AchievementBuilder("Necklace trinket 1", 0).requirement("You Are It", 1).requirement("Dungeoneering", 50)
            .requirement("The Branches of Darkmeyer", 1).reward("Dungeoneering", 10000).build());
        achievements.add(new AchievementBuilder("Necklace trinkets 2-5", 0.15).requirement("You Are It", 1).requirement("Dungeoneering", 50)
            .reward("Dungeoneering", 40000).build());
        achievements.add(new AchievementBuilder("Trickster's Trinkets", 0).requirement("Necklace trinket 1", 1)
            .requirement("Necklace trinkets 2-5", 1).build());
        achievements.add(new AchievementBuilder("A Mini Shipment", 0.05).requirement("Curse of the Black Stone", 1).build());
        achievements.add(new AchievementBuilder("Umbral Diplomacy", 0.15).encounter(new Encounter("The Crassian Leviathan (story)", 3))
            .encounter(new Encounter("Taraket the Necromancer (story)", 3)).build());
        achievements.add(new AchievementBuilder("Master Quest Cape", 0).requirement("Abyss (miniquest)", 1)
            .requirement("Advanced Sweeping", 1).requirement("Aereck's Old Bones", 1).requirement("Ali The Trader", 1)
            .requirement("All Rise", 1).requirement("Angs off my Ring", 1).requirement("Annihilator", 1).requirement("Any Odd Chicken", 1)
            .requirement("Ape A'hollow", 1).requirement("Spiritual Enlightenment (miniquest)", 1)
            .requirement("Head of the Family (miniquest)", 1).requirement("Jed Hunter (miniquest)", 1)
            .requirement("Damage Control (miniquest)", 1).requirement("Flag Fall (miniquest)", 1)
            .requirement("Ghosts from the Past (miniquest)", 1).requirement("Tuai Leit's Own (miniquest)", 1)
            .requirement("Harbinger (miniquest)", 1).requirement("Eye for an Eye (miniquest)", 1)
            .requirement("Final Destination (miniquest)", 1).requirement("Are You Needing Access?", 1).requirement("Arise from the Ash", 1)
            .requirement("Around the World in Six Ways", 1).requirement("As Taxed as a Yak", 1).requirement("As Clear as a Crystal Seed", 1)
            .requirement("Azacorax's Rewards", 1).requirement("Azdaran Birthright", 1).requirement("Bandos's Memories", 1)
            .requirement("Bane Tuner", 1).requirement("Banking History", 1).requirement("Behemoth Notes", 1)
            .requirement("Blinded by Ramarno's Teaching", 1).requirement("Blood Stained Treasure", 1)
            .requirement("Bridge over Fremmy Waters", 1).requirement("Brothers Gower", 1).requirement("Brutal Stuffies", 1)
            .requirement("Buy and Sell Some XP", 1).requirement("Buying Up Ancient Artefacts", 1).requirement("Caving Into the Gains", 1)
            .requirement("Cecilia, I'm Begging You, Please...", 1).requirement("Challenge Maria", 1).requirement("Challenging Chat", 1)
            .requirement("Chilling with Arrav", 1).requirement("Chippy Transport", 1).requirement("Chivalry is Fed", 1)
            .requirement("Chivalry is Threads", 1).requirement("Chivalry is Dead", 1).requirement("Circus of Fire", 1)
            .requirement("Claiming Azzanadra's Heart", 1).requirement("Claus Is Rising", 1).requirement("Clue's In The Monkey Drool", 1)
            .requirement("Complete History of Droalak", 1).requirement("Complete Trekky", 1).requirement("Cook's Delights", 1)
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
            .requirement("Memories of Guthix", 1).requirement("Memoirs of a Mahjarrat", 1).requirement("Met Het Yet?", 1)
            .requirement("Milky Teeth", 1).requirement("Miscellaneous Notes", 1).requirement("Mixing in Ancient Circles", 1)
            .requirement("My Adze is Bigger than Yours", 1).requirement("Myreque in Memoriam", 1).requirement("Mysteries of the TokHaar", 1)
            .requirement("Nano To Kipple, Come In Kipple", 1).requirement("Naturally Muspah", 1)
            .requirement("Tales of Nomad (miniquest)", 1).requirement("Ocellus Virius Notus", 1)
            .requirement("On a Mission From... The Gods", 1).requirement("One Final Ride", 1)
            .requirement("One Foot in the Grave (miniquest)", 1).requirement("One Man's Junk...Is Mine", 1)
            .requirement("Ornate Crockery", 1).requirement("Otto the Ancient", 1).requirement("Out into the Ourania", 1)
            .requirement("Oyster Mash", 1).requirement("Paint it Red", 1).requirement("Penny for Your Life", 1)
            .requirement("Desert Slayer Dungeon (miniquest)", 1).requirement("Potion for a Lady", 1)
            .requirement("Power of Three Spirits", 1).requirement("Quiet but Deadly Lore", 1).requirement("Relight my Fire", 1)
            .requirement("Reliquary of Cithara", 1).requirement("Respect the Balance", 1).requirement("Roake Kal", 1)
            .requirement("Rogue Down", 1).requirement("Rusty Reward", 1).requirement("Scabigail", 1)
            .requirement("Scribbling in the Depths", 1).requirement("Scribblings of a Dragonkin", 1).requirement("Sentient Letters", 1)
            .requirement("Seren Memories", 1).requirement("Shadow Hanging Over Me", 1).requirement("Sheep Shearer (miniquest)", 1)
            .requirement("Sing for the Lady", 1).requirement("Skeletal Wishes", 1).requirement("Tales of the God Wars (miniquest)", 1)
            .requirement("Purple Cat (miniquest)", 1).requirement("Some Old Dusty Journals", 1).requirement("Squeal for Coins", 1)
            .requirement("Stalker Notes", 1).requirement("Stay Safe", 1).requirement("Stay Secure", 1)
            .requirement("Stealing Sedridor's Stones", 1).requirement("Summary Spirits", 1).requirement("Supply and Demand", 1)
            .requirement("Tasty Bobbles", 1).requirement("Lair of Tarn Razorlor (miniquest)", 1).requirement("That'll Teach Bill", 1)
            .requirement("The History of Slayer", 1).requirement("Three's a Kiln", 1).requirement("Wandering Ga'al (miniquest)", 1)
            .requirement("Trials of the Heart", 1).requirement("Trickster's Trinkets", 1).requirement("Triple Trouble", 1)
            .requirement("Troublesome Crystals", 1).requirement("Ultimate Codex", 1).requirement("Uncorrupted Ore", 1)
            .requirement("Under Croc and Key", 1).requirement("Unholy Crafting", 1).requirement("Uzer Master", 1)
            .requirement("What's Mine Is Also Doric's", 1).requirement("White Knight Rises", 1).requirement("Witch's Potion (miniquest)", 1)
            .requirement("Work for Idol Hands", 1).requirement("You're Not My Real Mah", 1).requirement("Hopespear's Will (miniquest)", 1)
            .requirement("You Mistag This Brooch", 1).requirement("Zarosian Memories", 1).requirement("Lovingly Crafted", 1)
            .requirement("Rebuilding Edgeville (miniquest)", 1).requirement("A Mini Shipment", 1).requirement("Umbral Diplomacy", 1)
            .build());
        achievements.add(new AchievementBuilder("Mining - Rocky", 0).requirement("Mining level-ticks", 34657359).build());
        achievements.add(new AchievementBuilder("Prayer - Ghostly", 0).requirement("Prayer pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Ranged - Sparky", 0).requirement("Ranged pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Runecrafting - Rue", 0).requirement("Runecrafting pet points", 970406176).build());
        achievements.add(new AchievementBuilder("Slayer - Crabbe", 0).requirement("Slayer pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Summoning - Shamini", 0).requirement("Summoning pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Smithing - Smithy", 0).requirement("Smithing pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Strength - Kangali", 0).requirement("Strength pet points", 693147200).build());
        achievements.add(new AchievementBuilder("Thieving - Ralph", 0).requirement("Thieving level-ticks", 34657359).build());
        achievements.add(new AchievementBuilder("Woodcutting - Woody", 0).requirement("Woodcutting level-ticks", 34657359).build());
        achievements.add(new AchievementBuilder("Jack of All Blades", 0).requirement("Attack - Sifu", 1)
            .requirement("Constitution - Morty", 1).requirement("Defence - Wallace", 1).requirement("Magic - Newton", 1)
            .requirement("Prayer - Ghostly", 1).requirement("Ranged - Sparky", 1).requirement("Slayer - Crabbe", 1)
            .requirement("Summoning - Shamini", 1).requirement("Strength - Kangali", 1).build());
        achievements.add(new AchievementBuilder("Jack of All Trades", 0).requirement("Agility - Dojo Mojo", 1)
            .requirement("Construction - Baba Yaga's House", 1).requirement("Cooking - Ramsay", 1).requirement("Crafting - Gemi", 1)
            .requirement("Divination - Willow", 1).requirement("Dungeoneering - Gordie", 1).requirement("Farming - Brains", 1)
            .requirement("Firemaking - Bernie", 1).requirement("Fishing - Bubbles", 1).requirement("Fletching - Flo", 1)
            .requirement("Herblore - Herbert", 1).requirement("Hunter - Ace", 1).requirement("Invention - Malcolm", 1)
            .requirement("Mining - Rocky", 1).requirement("Runecrafting - Rue", 1).requirement("Smithing - Smithy", 1)
            .requirement("Thieving - Ralph", 1).requirement("Woodcutting - Woody", 1).build());
        achievements.add(new AchievementBuilder("Jack of Blades", 0).requirement("Defence - Wallace", 1).requirement("Magic - Newton", 1)
            .requirement("Prayer - Ghostly", 1).build());
        achievements.add(new AchievementBuilder("Jack of Trades", 0).requirement("Agility - Dojo Mojo", 1)
            .requirement("Construction - Baba Yaga's House", 1).requirement("Cooking - Ramsay", 1).requirement("Crafting - Gemi", 1)
            .requirement("Divination - Willow", 1).build());
        achievements.add(new AchievementBuilder("Master of All", 0).requirement("Jack of All Blades", 1)
            .requirement("Jack of All Trades", 1).build());
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
        achievements.add(new AchievementBuilder("Matricide", 0).requirement("General Graardor", 1).requirement("K'ril Tsutsaroth", 1)
            .requirement("Commander Zilyana", 1).requirement("Kree'arra", 1).requirement("Blood nihil pouch", 1)
            .requirement("Shadow nihil pouch", 1).requirement("Ice nihil pouch", 1).requirement("Smoke nihil pouch", 1)
            .encounter(new Encounter("Nex")).encounter(new Encounter("Nex")).encounter(new Encounter("Nex")).encounter(new Encounter("Nex"))
            .build());
        achievements.add(new AchievementBuilder("Mazcab Teleport", 0).requirement("Teci", 2000).build());
        achievements.add(new AchievementBuilder("Memorialised More Than Once", 1).requirement("Memories of Guthix", 1)
            .requirement("Memory strand", 7296).requirement("Pale energy", 1600).requirement("Flickering energy", 1280)
            .requirement("Bright energy", 1440).requirement("Glowing energy", 1600).requirement("Sparkling energy", 1280)
            .requirement("Gleaming energy", 1120).requirement("Vibrant energy", 1600).requirement("Lustrous energy", 960)
            .requirement("Brilliant energy", 800).requirement("Radiant energy", 960).requirement("Luminous energy", 800)
            .requirement("Incandescent energy", 480).reward("Divination", 412608).build());
        achievements.add(new AchievementBuilder("Micro Brew", 0).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .requirement("Herblore", 65).build());
        achievements.add(new AchievementBuilder("Milk of Chocolate, Snape of Grass", 0).requirement("Cooking", 20)
            .requirement("Bucket of water", 1).requirement("Bowl of water", 1).requirement("Chocolate dust", 1).requirement("Bucket of milk", 1)
            .requirement("Snape grass", 1).reward("Cooking", 53).build());
        achievements.add(new AchievementBuilder("Mining 5", -1).requirement("Mining", 5).build());
        achievements.add(new AchievementBuilder("Mining 10", -1).requirement("Mining", 10).build());
        achievements.add(new AchievementBuilder("Mining 20", -1).requirement("Mining", 20).build());
        achievements.add(new AchievementBuilder("Mining 30", -1).requirement("Mining", 30).build());
        achievements.add(new AchievementBuilder("Mining 40", -1).requirement("Mining", 40).build());
        achievements.add(new AchievementBuilder("Mining 50", -1).requirement("Mining", 50).build());
        achievements.add(new AchievementBuilder("Mining 60", -1).requirement("Mining", 60).build());
        achievements.add(new AchievementBuilder("Mining 70", -1).requirement("Mining", 70).build());
        achievements.add(new AchievementBuilder("Mining 80", -1).requirement("Mining", 80).build());
        achievements.add(new AchievementBuilder("Mining 90", -1).requirement("Mining", 90).build());
        achievements.add(new AchievementBuilder("Mining 92", -1).requirement("Mining", 92).build());
        achievements.add(new AchievementBuilder("Mining 99", -1).requirement("Mining", 99).build());
        achievements.add(new AchievementBuilder("Mole Removal I", 0).requirement("Giant Mole", 5).build());
        achievements.add(new AchievementBuilder("Mole Removal II", 0).requirement("Giant Mole", 10).build());
        achievements.add(new AchievementBuilder("Mole Removal III", 0).requirement("Giant Mole", 25).build());
        achievements.add(new AchievementBuilder("Mole Removal IV", 0).requirement("Giant Mole", 50).build());
        achievements.add(new AchievementBuilder("Mole Removal V", 0).requirement("Giant Mole", 75).build());
        achievements.add(new AchievementBuilder("Moo-er of All Bombs", 0).requirement("Dimension of Disaster: Curse of Arrav", 1)
            .build());
        achievements.add(new AchievementBuilder("More Fast More Furious I", 0).requirement("Twin Furies (CM)", 5)
            .reward("Zaros reputation", 100).build());
        achievements.add(new AchievementBuilder("More Fast More Furious II", 0).requirement("Twin Furies (CM)", 10).build());
        achievements.add(new AchievementBuilder("More Fast More Furious III", 0).requirement("Twin Furies (CM)", 25).build());
        achievements.add(new AchievementBuilder("More Fast More Furious IV", 0).requirement("Twin Furies (CM)", 50).build());
        achievements.add(new AchievementBuilder("More Fast More Furious V", 0).requirement("Twin Furies (CM)", 75).build());
        achievements.add(new AchievementBuilder("Mummy Returns", 0).requirement("Cat's Bane", 1).build());
        achievements.add(new AchievementBuilder("My precious!", 0.5).requirement("Fishing", 68).build());
        achievements.add(new AchievementBuilder("Naturist", 0.05).build());
        achievements.add(new AchievementBuilder("Never Eat Silk Worms", 0).encounter(new Encounter(Collections.singletonList(
            Collections.singletonList("Kalphite King")), 2)).build());
        achievements.add(new AchievementBuilder("Trade Parade", 0).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .build());
        achievements.add(new AchievementBuilder("Ready, Deady, Cook", 0.05).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .build());
        achievements.add(new AchievementBuilder("Pick One", 0).requirement("Dimension of Disaster: Shield of Arrav", 1)
            .build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Easy", 0).requirement("Hand Exchange", 1)
            .requirement("Trade Parade", 1).requirement("Hide and Seek", 1).requirement("Ready, Deady, Cook", 1).requirement("Pick One", 1)
            .build());
        achievements.add(new AchievementBuilder("Top Pick", 0).requirement("Dimension of Disaster: Curse of Arrav", 1)
            .requirement("Thieving", 90).build());
        achievements.add(new AchievementBuilder("Steel, Stud, or Silk Salute", 0).requirement("Dimension of Disaster: Curse of Arrav", 1)
            .build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Elite", 1).requirement("Dark Imperator-ment", 1)
            .requirement("Guard is Dead", 1).requirement("Steel, Stud, or Silk Salute", 1).requirement("Moo-er of All Bombs", 1)
            .requirement("Top Pick", 1).build());
        achievements.add(new AchievementBuilder("South AND West Side Story", 0).requirement("Dimension of Disaster: Curse of Arrav", 1)
            .build());
        achievements.add(new AchievementBuilder("Pick Half", 0.4).requirement("Pick One", 1).requirement("Thieving", 50)
            .build());
        achievements.add(new AchievementBuilder("Pick All", 0.4).requirement("Pick Half", 1).requirement("Thieving", 70)
            .requirement("Dimension of Disaster: Demon Slayer", 1).build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Hard", 0).requirement("Bank-Z", 1)
            .requirement("Micro Brew", 1).requirement("Pick All", 1).requirement("South AND West Side Story", 1)
            .requirement("Mummy Returns", 1).build());
        achievements.add(new AchievementBuilder("Tier Gear", 0.05).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .requirement("Crafting", 10).build());
        achievements.add(new AchievementBuilder("They Had a Gudrun", 0.05).requirement("Dimension of Disaster: Curse of Arrav", 1).build());
        achievements.add(new AchievementBuilder("Scrying Game", 0).requirement("Dimension of Disaster: Defender of Varrock", 1).build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Medium", 0).requirement("Cat's Bane", 1)
            .requirement("They Had a Gudrun", 1).requirement("Pick Half", 1).requirement("Scrying Game", 1).requirement("Tier Gear", 1)
            .build());
        achievements.add(new AchievementBuilder("Nex Pls I", 0).requirement("Nex: Angel of Death", 5).build());
        achievements.add(new AchievementBuilder("Nex Pls II", 0).requirement("Nex: Angel of Death", 10).build());
        achievements.add(new AchievementBuilder("Nex Pls III", 0).requirement("Nex: Angel of Death", 25).build());
        achievements.add(new AchievementBuilder("Nex Pls IV", 0).requirement("Nex: Angel of Death", 50).build());
        achievements.add(new AchievementBuilder("Nex Pls V", 0).requirement("Nex: Angel of Death", 75).build());
        achievements.add(new AchievementBuilder("Next to No Power", 0).requirement("General Graardor", 1)
            .requirement("K'ril Tsutsaroth", 1).requirement("Commander Zilyana", 1).requirement("Kree'arra", 1)
            .encounter(new Encounter("Nex")).build());
        achievements.add(new AchievementBuilder("Nomad's Mirage", 0).requirement("Nomad's Elegy", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Nomad (Elegy)"), Collections.singletonList("Nomad (Elegy)"),
                Collections.singletonList("Nomad (Elegy)"), Collections.singletonList("Nomad (Elegy)"),
                Collections.singletonList("Nomad (Elegy)"), Collections.singletonList("Nomad (Elegy)"),
                Collections.singletonList("Nomad (Elegy)"), Collections.singletonList("Nomad (Elegy)")))).build());
        achievements.add(new AchievementBuilder("On a Rune High", 0).requirement("Large rune casket", 1).build());
        achievements.add(new AchievementBuilder("On the Run", 0).build());
        achievements.add(new AchievementBuilder("Once the hunter, now the hunted", 0).requirement("Helwyr", 1353).build());
        achievements.add(new AchievementBuilder("Open Bar", 0).requirement("Recipe for Disaster: Freeing the Mountain dwarf", 1)
            .requirement("Asgarnian ale", 0).requirement("Asgarnian ale (m)", 0).requirement("Coins", 1).requirement("Asgarnian ale", 1)
            .requirement("Axeman's folly", 0).requirement("Axeman's folly (m)", 0).requirement("Beer", 0).requirement("Bandit's brew", 0)
            .requirement("Beer (tankard)", 0).requirement("Chef's delight", 0).requirement("Cider", 0).requirement("Mature cider", 0)
            .requirement("Dragon bitter", 0).requirement("Dragon bitter (m)", 0).requirement("Dwarven stout", 0)
            .requirement("Dwarven stout (m)", 0).requirement("Greenman's ale", 0).requirement("Grog", 0).requirement("Moonlight mead", 0)
            .requirement("Moonlight mead (m)", 0).requirement("Pigswill", 0).requirement("Mature pigswill", 0)
            .requirement("Ranger's aid", 0).requirement("Ranger's aid (m)", 0).requirement("Slayer's respite", 0)
            .requirement("Slayer's respite (m)", 0).requirement("Squeck juice", 0).requirement("Wizard's mind bomb", 0
            ).requirement("Mature wmb", 0).build());
        achievements.add(new AchievementBuilder("Order of Slayers", 8).requirement("While Guthix Sleeps", 1)
            .requirement("Smoking Kills", 1).requirement("Plague's End", 1).requirement("Barbarian Training", 1).requirement("Slayer", 85)
            .requirement("Combat", 120).build());
        achievements.add(new AchievementBuilder("Out of Body Experience", 0).requirement("Corporeal Beast", 4174).build());
        achievements.add(new AchievementBuilder("Party Anima", 0).requirement("Telos", 1475).build());
        achievements.add(new AchievementBuilder("Penance to the King", 1).requirement("Penance Queen", 1).build());
        achievements.add(new AchievementBuilder("Perky Like a Prawn", 0).requirement("Almost as Perky as a Prawn", 1)
            .requirement("Golden fish egg", 14).build());
        achievements.add(new AchievementBuilder("'Phite For Your Right I", 0).requirement("City quest", 1).build());
        achievements.add(new AchievementBuilder("'Phite For Your Right II", 0).requirement("City quest", 10).build());
        achievements.add(new AchievementBuilder("'Phite For Your Right III", 0).requirement("City quest", 50).build());
        achievements.add(new AchievementBuilder("'Phite For Your Right IV", 0).requirement("City quest", 100).build());
        achievements.add(new AchievementBuilder("'Phite For Your Right V", 0).requirement("City quest", 200).build());
        achievements.add(new AchievementBuilder("Prayer 5", -1).requirement("Prayer", 5).build());
        achievements.add(new AchievementBuilder("Prayer 10", -1).requirement("Prayer", 10).build());
        achievements.add(new AchievementBuilder("Prayer 20", -1).requirement("Prayer", 20).build());
        achievements.add(new AchievementBuilder("Prayer 30", -1).requirement("Prayer", 30).build());
        achievements.add(new AchievementBuilder("Prayer 40", -1).requirement("Prayer", 40).build());
        achievements.add(new AchievementBuilder("Prayer 50", -1).requirement("Prayer", 50).build());
        achievements.add(new AchievementBuilder("Prayer 60", -1).requirement("Prayer", 60).build());
        achievements.add(new AchievementBuilder("Prayer 70", -1).requirement("Prayer", 70).build());
        achievements.add(new AchievementBuilder("Prayer 80", -1).requirement("Prayer", 80).build());
        achievements.add(new AchievementBuilder("Prayer 90", -1).requirement("Prayer", 90).build());
        achievements.add(new AchievementBuilder("(Living on a) Prayer 92", -1).requirement("Prayer", 92).build());
        achievements.add(new AchievementBuilder("Prayer 99", -1).requirement("Prayer", 99).build());
        achievements.add(new AchievementBuilder("Prison Break (feat)", 0).requirement("Barrows defender", 1).requirement("Nex", 1404)
            .build());
        achievements.add(new AchievementBuilder("Ranged 5", -1).requirement("Ranged", 5).build());
        achievements.add(new AchievementBuilder("Ranged 10", -1).requirement("Ranged", 10).build());
        achievements.add(new AchievementBuilder("Ranged 20", -1).requirement("Ranged", 20).build());
        achievements.add(new AchievementBuilder("Ranged 30", -1).requirement("Ranged", 30).build());
        achievements.add(new AchievementBuilder("Ranged 40", -1).requirement("Ranged", 40).build());
        achievements.add(new AchievementBuilder("Ranged 50", -1).requirement("Ranged", 50).build());
        achievements.add(new AchievementBuilder("Ranged 60", -1).requirement("Ranged", 60).build());
        achievements.add(new AchievementBuilder("Ranged 70", -1).requirement("Ranged", 70).build());
        achievements.add(new AchievementBuilder("Ranged 80", -1).requirement("Ranged", 80).build());
        achievements.add(new AchievementBuilder("Ranged 90", -1).requirement("Ranged", 90).build());
        achievements.add(new AchievementBuilder("Ranged 92", -1).requirement("Ranged", 92).build());
        achievements.add(new AchievementBuilder("Ranged 99", -1).requirement("Ranged", 99).build());
        achievements.add(new AchievementBuilder("Rank: Master Finix", 0).requirement("Runespan points", 211860).build());
        achievements.add(new AchievementBuilder("Revenge is Sweet", 0).requirement("Vindicta", 1459).build());
        achievements.add(new AchievementBuilder("Rock and Roll", 0.1).requirement("'Phite For Your Right I", 1).requirement("Bamboo", 5)
            .requirement("Spices", 1).requirement("Slayer", 88).requirement("Phenakite", 1).requirement("Menaphyrite", 1)
            .requirement("Waikonite", 1).requirement("Corundum", 1).requirement("Wavecrest opal", 1).requirement("Maw coral", 1)
            .requirement("Crondite", 1).requirement("Umesco arpos", 1).build());
        achievements.add(new AchievementBuilder("Ruler of the Sea", 0.1).requirement("Fishing", 68).build());
        achievements.add(new AchievementBuilder("Runecrafting 5", -1).requirement("Runecrafting", 5).build());
        achievements.add(new AchievementBuilder("Runecrafting 10", -1).requirement("Runecrafting", 10).build());
        achievements.add(new AchievementBuilder("Runecrafting 20", -1).requirement("Runecrafting", 20).build());
        achievements.add(new AchievementBuilder("Runecrafting 30", -1).requirement("Runecrafting", 30).build());
        achievements.add(new AchievementBuilder("Runecrafting 40", -1).requirement("Runecrafting", 40).build());
        achievements.add(new AchievementBuilder("Runecrafting 50", -1).requirement("Runecrafting", 50).build());
        achievements.add(new AchievementBuilder("Runecrafting 60", -1).requirement("Runecrafting", 60).build());
        achievements.add(new AchievementBuilder("Runecrafting 70", -1).requirement("Runecrafting", 70).build());
        achievements.add(new AchievementBuilder("Runecrafting 80", -1).requirement("Runecrafting", 80).build());
        achievements.add(new AchievementBuilder("Runecrafting 90", -1).requirement("Runecrafting", 90).build());
        achievements.add(new AchievementBuilder("Runecrafting 92", -1).requirement("Runecrafting", 92).build());
        achievements.add(new AchievementBuilder("Runecrafting 99", -1).requirement("Runecrafting", 99).build());
        achievements.add(new AchievementBuilder("Safety Dance", 0).requirement("Summoning", 60)
            .encounter(new Encounter("Queen Black Dragon")).build());
        achievements.add(new AchievementBuilder("Scrolling with Power", 0).requirement("Dungeoneering", 70).requirement("Farming", 25)
            .requirement("Herblore", 49).requirement("Construction", 60).requirement("Smithing", 55).requirement("Crafting", 60)
            .requirement("Dungeoneering token", 190000).build());
        achievements.add(new AchievementBuilder("Seagullible", 0).requirement("Menaphos reputation", 1200000).build());
        achievements.add(new AchievementBuilder("Second Shrubbery", 0).requirement("Herring", 0).build());
        achievements.add(new AchievementBuilder("Seeing Lava", 0).requirement("TzTok-Jad", 1)
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
                Arrays.asList("TzTok-Jad", "Yt-HurKot", "Yt-HurKot", "Yt-HurKot", "Yt-HurKot")), true)).build());
        achievements.add(new AchievementBuilder("Seven Colours In Their Hat", 3).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .build());
        achievements.add(new AchievementBuilder("Shadows Below", 0).requirement("Rise of the Six", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 5 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1"),
            Arrays.asList("Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1"),
            Arrays.asList("Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1"),
            Arrays.asList("Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1"),
            Arrays.asList("Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1"),
            Arrays.asList("Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1"),
            Arrays.asList("Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1"),
            Arrays.asList("Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1", "Shattered Worlds 1"),
            Arrays.asList("Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2"),
            Arrays.asList("Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2"),
            Arrays.asList("Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2"),
            Arrays.asList("Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2"),
            Arrays.asList("Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2"),
            Arrays.asList("Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2"),
            Arrays.asList("Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2"),
            Arrays.asList("Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2", "Shattered Worlds 2"),
            Arrays.asList("Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3"),
            Arrays.asList("Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3"),
            Arrays.asList("Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3"),
            Arrays.asList("Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3"),
            Arrays.asList("Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3"),
            Arrays.asList("Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3"),
            Arrays.asList("Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3"),
            Arrays.asList("Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3", "Shattered Worlds 3"),
            Arrays.asList("Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4"),
            Arrays.asList("Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4"),
            Arrays.asList("Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4"),
            Arrays.asList("Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4"),
            Arrays.asList("Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4"),
            Arrays.asList("Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4"),
            Arrays.asList("Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4"),
            Arrays.asList("Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4", "Shattered Worlds 4"),
            Arrays.asList("Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5"),
            Arrays.asList("Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5"),
            Arrays.asList("Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5"),
            Arrays.asList("Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5"),
            Arrays.asList("Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5"),
            Arrays.asList("Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5"),
            Arrays.asList("Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5"),
            Arrays.asList("Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5", "Shattered Worlds 5"))))
            .build());
        achievements.add(new AchievementBuilder("Shattering Worlds I", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6"),
            Arrays.asList("Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6"),
            Arrays.asList("Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6"),
            Arrays.asList("Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6"),
            Arrays.asList("Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6"),
            Arrays.asList("Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6"),
            Arrays.asList("Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6"),
            Arrays.asList("Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6", "Shattered Worlds 6"),
            Arrays.asList("Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7"),
            Arrays.asList("Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7"),
            Arrays.asList("Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7"),
            Arrays.asList("Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7"),
            Arrays.asList("Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7"),
            Arrays.asList("Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7"),
            Arrays.asList("Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7"),
            Arrays.asList("Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7", "Shattered Worlds 7"),
            Arrays.asList("Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8"),
            Arrays.asList("Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8"),
            Arrays.asList("Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8"),
            Arrays.asList("Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8"),
            Arrays.asList("Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8"),
            Arrays.asList("Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8"),
            Arrays.asList("Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8"),
            Arrays.asList("Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8", "Shattered Worlds 8"),
            Arrays.asList("Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9"),
            Arrays.asList("Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9"),
            Arrays.asList("Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9"),
            Arrays.asList("Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9"),
            Arrays.asList("Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9"),
            Arrays.asList("Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9"),
            Arrays.asList("Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9"),
            Arrays.asList("Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9", "Shattered Worlds 9"),
            Arrays.asList("Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10"),
            Arrays.asList("Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10"),
            Arrays.asList("Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10"),
            Arrays.asList("Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10"),
            Arrays.asList("Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10"),
            Arrays.asList("Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10"),
            Arrays.asList("Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10"),
            Arrays.asList("Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10", "Shattered Worlds 10"))))
            .requirement("Shattered Worlds 5 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 15 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11"),
            Arrays.asList("Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11"),
            Arrays.asList("Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11"),
            Arrays.asList("Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11"),
            Arrays.asList("Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11"),
            Arrays.asList("Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11"),
            Arrays.asList("Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11"),
            Arrays.asList("Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11", "Shattered Worlds 11"),
            Arrays.asList("Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12"),
            Arrays.asList("Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12"),
            Arrays.asList("Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12"),
            Arrays.asList("Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12"),
            Arrays.asList("Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12"),
            Arrays.asList("Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12"),
            Arrays.asList("Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12"),
            Arrays.asList("Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12", "Shattered Worlds 12"),
            Arrays.asList("Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13"),
            Arrays.asList("Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13"),
            Arrays.asList("Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13"),
            Arrays.asList("Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13"),
            Arrays.asList("Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13"),
            Arrays.asList("Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13"),
            Arrays.asList("Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13"),
            Arrays.asList("Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13", "Shattered Worlds 13"),
            Arrays.asList("Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14"),
            Arrays.asList("Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14"),
            Arrays.asList("Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14"),
            Arrays.asList("Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14"),
            Arrays.asList("Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14"),
            Arrays.asList("Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14"),
            Arrays.asList("Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14"),
            Arrays.asList("Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14", "Shattered Worlds 14"),
            Arrays.asList("Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15"),
            Arrays.asList("Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15"),
            Arrays.asList("Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15"),
            Arrays.asList("Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15"),
            Arrays.asList("Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15"),
            Arrays.asList("Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15"),
            Arrays.asList("Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15"),
            Arrays.asList("Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15", "Shattered Worlds 15"))))
            .requirement("Shattering Worlds I", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 20 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16"),
            Arrays.asList("Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16"),
            Arrays.asList("Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16"),
            Arrays.asList("Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16"),
            Arrays.asList("Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16"),
            Arrays.asList("Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16"),
            Arrays.asList("Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16"),
            Arrays.asList("Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16", "Shattered Worlds 16"),
            Arrays.asList("Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17"),
            Arrays.asList("Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17"),
            Arrays.asList("Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17"),
            Arrays.asList("Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17"),
            Arrays.asList("Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17"),
            Arrays.asList("Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17"),
            Arrays.asList("Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17"),
            Arrays.asList("Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17", "Shattered Worlds 17"),
            Arrays.asList("Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18"),
            Arrays.asList("Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18"),
            Arrays.asList("Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18"),
            Arrays.asList("Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18"),
            Arrays.asList("Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18"),
            Arrays.asList("Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18"),
            Arrays.asList("Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18"),
            Arrays.asList("Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18", "Shattered Worlds 18"),
            Arrays.asList("Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19"),
            Arrays.asList("Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19"),
            Arrays.asList("Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19"),
            Arrays.asList("Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19"),
            Arrays.asList("Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19"),
            Arrays.asList("Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19"),
            Arrays.asList("Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19"),
            Arrays.asList("Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19", "Shattered Worlds 19"),
            Arrays.asList("Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20"),
            Arrays.asList("Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20"),
            Arrays.asList("Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20"),
            Arrays.asList("Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20"),
            Arrays.asList("Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20"),
            Arrays.asList("Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20"),
            Arrays.asList("Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20"),
            Arrays.asList("Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20", "Shattered Worlds 20"))))
            .requirement("Shattered Worlds 15 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattering Worlds II", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21"),
            Arrays.asList("Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21"),
            Arrays.asList("Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21"),
            Arrays.asList("Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21"),
            Arrays.asList("Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21"),
            Arrays.asList("Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21"),
            Arrays.asList("Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21"),
            Arrays.asList("Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21", "Shattered Worlds 21"),
            Arrays.asList("Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22"),
            Arrays.asList("Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22"),
            Arrays.asList("Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22"),
            Arrays.asList("Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22"),
            Arrays.asList("Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22"),
            Arrays.asList("Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22"),
            Arrays.asList("Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22"),
            Arrays.asList("Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22", "Shattered Worlds 22"),
            Arrays.asList("Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23"),
            Arrays.asList("Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23"),
            Arrays.asList("Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23"),
            Arrays.asList("Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23"),
            Arrays.asList("Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23"),
            Arrays.asList("Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23"),
            Arrays.asList("Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23"),
            Arrays.asList("Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23", "Shattered Worlds 23"),
            Arrays.asList("Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24"),
            Arrays.asList("Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24"),
            Arrays.asList("Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24"),
            Arrays.asList("Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24"),
            Arrays.asList("Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24"),
            Arrays.asList("Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24"),
            Arrays.asList("Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24"),
            Arrays.asList("Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24", "Shattered Worlds 24"),
            Arrays.asList("Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25"),
            Arrays.asList("Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25"),
            Arrays.asList("Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25"),
            Arrays.asList("Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25"),
            Arrays.asList("Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25"),
            Arrays.asList("Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25"),
            Arrays.asList("Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25"),
            Arrays.asList("Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25", "Shattered Worlds 25"))))
            .requirement("Shattered Worlds 20 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 30 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26"),
            Arrays.asList("Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26"),
            Arrays.asList("Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26"),
            Arrays.asList("Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26"),
            Arrays.asList("Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26"),
            Arrays.asList("Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26"),
            Arrays.asList("Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26"),
            Arrays.asList("Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26", "Shattered Worlds 26"),
            Arrays.asList("Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27"),
            Arrays.asList("Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27"),
            Arrays.asList("Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27"),
            Arrays.asList("Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27"),
            Arrays.asList("Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27"),
            Arrays.asList("Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27"),
            Arrays.asList("Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27"),
            Arrays.asList("Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27", "Shattered Worlds 27"),
            Arrays.asList("Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28"),
            Arrays.asList("Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28"),
            Arrays.asList("Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28"),
            Arrays.asList("Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28"),
            Arrays.asList("Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28"),
            Arrays.asList("Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28"),
            Arrays.asList("Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28"),
            Arrays.asList("Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28", "Shattered Worlds 28"),
            Arrays.asList("Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29"),
            Arrays.asList("Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29"),
            Arrays.asList("Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29"),
            Arrays.asList("Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29"),
            Arrays.asList("Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29"),
            Arrays.asList("Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29"),
            Arrays.asList("Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29"),
            Arrays.asList("Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29", "Shattered Worlds 29"),
            Arrays.asList("Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30"),
            Arrays.asList("Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30"),
            Arrays.asList("Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30"),
            Arrays.asList("Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30"),
            Arrays.asList("Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30"),
            Arrays.asList("Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30"),
            Arrays.asList("Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30"),
            Arrays.asList("Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30", "Shattered Worlds 30"))))
            .requirement("Shattering Worlds II", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 35 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31"),
            Arrays.asList("Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31"),
            Arrays.asList("Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31"),
            Arrays.asList("Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31"),
            Arrays.asList("Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31"),
            Arrays.asList("Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31"),
            Arrays.asList("Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31"),
            Arrays.asList("Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31", "Shattered Worlds 31"),
            Arrays.asList("Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32"),
            Arrays.asList("Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32"),
            Arrays.asList("Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32"),
            Arrays.asList("Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32"),
            Arrays.asList("Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32"),
            Arrays.asList("Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32"),
            Arrays.asList("Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32"),
            Arrays.asList("Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32", "Shattered Worlds 32"),
            Arrays.asList("Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33"),
            Arrays.asList("Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33"),
            Arrays.asList("Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33"),
            Arrays.asList("Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33"),
            Arrays.asList("Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33"),
            Arrays.asList("Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33"),
            Arrays.asList("Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33"),
            Arrays.asList("Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33", "Shattered Worlds 33"),
            Arrays.asList("Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34"),
            Arrays.asList("Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34"),
            Arrays.asList("Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34"),
            Arrays.asList("Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34"),
            Arrays.asList("Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34"),
            Arrays.asList("Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34"),
            Arrays.asList("Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34"),
            Arrays.asList("Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34", "Shattered Worlds 34"),
            Arrays.asList("Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35"),
            Arrays.asList("Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35"),
            Arrays.asList("Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35"),
            Arrays.asList("Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35"),
            Arrays.asList("Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35"),
            Arrays.asList("Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35"),
            Arrays.asList("Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35"),
            Arrays.asList("Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35", "Shattered Worlds 35"))))
            .requirement("Shattered Worlds 30 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 40 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36"),
            Arrays.asList("Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36"),
            Arrays.asList("Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36"),
            Arrays.asList("Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36"),
            Arrays.asList("Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36"),
            Arrays.asList("Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36"),
            Arrays.asList("Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36"),
            Arrays.asList("Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36", "Shattered Worlds 36"),
            Arrays.asList("Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37"),
            Arrays.asList("Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37"),
            Arrays.asList("Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37"),
            Arrays.asList("Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37"),
            Arrays.asList("Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37"),
            Arrays.asList("Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37"),
            Arrays.asList("Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37"),
            Arrays.asList("Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37", "Shattered Worlds 37"),
            Arrays.asList("Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38"),
            Arrays.asList("Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38"),
            Arrays.asList("Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38"),
            Arrays.asList("Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38"),
            Arrays.asList("Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38"),
            Arrays.asList("Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38"),
            Arrays.asList("Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38"),
            Arrays.asList("Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38", "Shattered Worlds 38"),
            Arrays.asList("Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39"),
            Arrays.asList("Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39"),
            Arrays.asList("Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39"),
            Arrays.asList("Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39"),
            Arrays.asList("Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39"),
            Arrays.asList("Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39"),
            Arrays.asList("Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39"),
            Arrays.asList("Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39", "Shattered Worlds 39"),
            Arrays.asList("Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40"),
            Arrays.asList("Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40"),
            Arrays.asList("Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40"),
            Arrays.asList("Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40"),
            Arrays.asList("Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40"),
            Arrays.asList("Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40"),
            Arrays.asList("Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40"),
            Arrays.asList("Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40", "Shattered Worlds 40"))))
            .requirement("Shattered Worlds 35 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 45 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41"),
            Arrays.asList("Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41"),
            Arrays.asList("Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41"),
            Arrays.asList("Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41"),
            Arrays.asList("Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41"),
            Arrays.asList("Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41"),
            Arrays.asList("Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41"),
            Arrays.asList("Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41", "Shattered Worlds 41"),
            Arrays.asList("Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42"),
            Arrays.asList("Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42"),
            Arrays.asList("Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42"),
            Arrays.asList("Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42"),
            Arrays.asList("Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42"),
            Arrays.asList("Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42"),
            Arrays.asList("Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42"),
            Arrays.asList("Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42", "Shattered Worlds 42"),
            Arrays.asList("Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43"),
            Arrays.asList("Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43"),
            Arrays.asList("Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43"),
            Arrays.asList("Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43"),
            Arrays.asList("Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43"),
            Arrays.asList("Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43"),
            Arrays.asList("Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43"),
            Arrays.asList("Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43", "Shattered Worlds 43"),
            Arrays.asList("Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44"),
            Arrays.asList("Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44"),
            Arrays.asList("Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44"),
            Arrays.asList("Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44"),
            Arrays.asList("Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44"),
            Arrays.asList("Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44"),
            Arrays.asList("Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44"),
            Arrays.asList("Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44", "Shattered Worlds 44"),
            Arrays.asList("Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45"),
            Arrays.asList("Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45"),
            Arrays.asList("Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45"),
            Arrays.asList("Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45"),
            Arrays.asList("Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45"),
            Arrays.asList("Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45"),
            Arrays.asList("Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45"),
            Arrays.asList("Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45", "Shattered Worlds 45"))))
            .requirement("Shattered Worlds 40 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattering Worlds III", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46"),
            Arrays.asList("Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46"),
            Arrays.asList("Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46"),
            Arrays.asList("Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46"),
            Arrays.asList("Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46"),
            Arrays.asList("Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46"),
            Arrays.asList("Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46"),
            Arrays.asList("Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46", "Shattered Worlds 46"),
            Arrays.asList("Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47"),
            Arrays.asList("Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47"),
            Arrays.asList("Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47"),
            Arrays.asList("Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47"),
            Arrays.asList("Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47"),
            Arrays.asList("Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47"),
            Arrays.asList("Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47"),
            Arrays.asList("Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47", "Shattered Worlds 47"),
            Arrays.asList("Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48"),
            Arrays.asList("Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48"),
            Arrays.asList("Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48"),
            Arrays.asList("Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48"),
            Arrays.asList("Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48"),
            Arrays.asList("Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48"),
            Arrays.asList("Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48"),
            Arrays.asList("Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48", "Shattered Worlds 48"),
            Arrays.asList("Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49"),
            Arrays.asList("Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49"),
            Arrays.asList("Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49"),
            Arrays.asList("Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49"),
            Arrays.asList("Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49"),
            Arrays.asList("Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49"),
            Arrays.asList("Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49"),
            Arrays.asList("Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49", "Shattered Worlds 49"),
            Arrays.asList("Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50"),
            Arrays.asList("Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50"),
            Arrays.asList("Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50"),
            Arrays.asList("Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50"),
            Arrays.asList("Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50"),
            Arrays.asList("Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50"),
            Arrays.asList("Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50"),
            Arrays.asList("Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50", "Shattered Worlds 50"))))
            .requirement("Shattered Worlds 45 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 55 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51"),
            Arrays.asList("Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51"),
            Arrays.asList("Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51"),
            Arrays.asList("Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51"),
            Arrays.asList("Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51"),
            Arrays.asList("Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51"),
            Arrays.asList("Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51"),
            Arrays.asList("Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51", "Shattered Worlds 51"),
            Arrays.asList("Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52"),
            Arrays.asList("Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52"),
            Arrays.asList("Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52"),
            Arrays.asList("Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52"),
            Arrays.asList("Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52"),
            Arrays.asList("Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52"),
            Arrays.asList("Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52"),
            Arrays.asList("Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52", "Shattered Worlds 52"),
            Arrays.asList("Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53"),
            Arrays.asList("Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53"),
            Arrays.asList("Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53"),
            Arrays.asList("Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53"),
            Arrays.asList("Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53"),
            Arrays.asList("Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53"),
            Arrays.asList("Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53"),
            Arrays.asList("Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53", "Shattered Worlds 53"),
            Arrays.asList("Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54"),
            Arrays.asList("Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54"),
            Arrays.asList("Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54"),
            Arrays.asList("Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54"),
            Arrays.asList("Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54"),
            Arrays.asList("Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54"),
            Arrays.asList("Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54"),
            Arrays.asList("Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54", "Shattered Worlds 54"),
            Arrays.asList("Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55"),
            Arrays.asList("Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55"),
            Arrays.asList("Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55"),
            Arrays.asList("Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55"),
            Arrays.asList("Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55"),
            Arrays.asList("Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55"),
            Arrays.asList("Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55"),
            Arrays.asList("Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55", "Shattered Worlds 55"))))
            .requirement("Shattering Worlds III", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 60 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56"),
            Arrays.asList("Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56"),
            Arrays.asList("Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56"),
            Arrays.asList("Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56"),
            Arrays.asList("Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56"),
            Arrays.asList("Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56"),
            Arrays.asList("Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56"),
            Arrays.asList("Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56", "Shattered Worlds 56"),
            Arrays.asList("Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57"),
            Arrays.asList("Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57"),
            Arrays.asList("Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57"),
            Arrays.asList("Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57"),
            Arrays.asList("Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57"),
            Arrays.asList("Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57"),
            Arrays.asList("Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57"),
            Arrays.asList("Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57", "Shattered Worlds 57"),
            Arrays.asList("Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58"),
            Arrays.asList("Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58"),
            Arrays.asList("Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58"),
            Arrays.asList("Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58"),
            Arrays.asList("Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58"),
            Arrays.asList("Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58"),
            Arrays.asList("Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58"),
            Arrays.asList("Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58", "Shattered Worlds 58"),
            Arrays.asList("Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59"),
            Arrays.asList("Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59"),
            Arrays.asList("Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59"),
            Arrays.asList("Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59"),
            Arrays.asList("Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59"),
            Arrays.asList("Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59"),
            Arrays.asList("Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59"),
            Arrays.asList("Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59", "Shattered Worlds 59"),
            Arrays.asList("Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60"),
            Arrays.asList("Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60"),
            Arrays.asList("Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60"),
            Arrays.asList("Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60"),
            Arrays.asList("Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60"),
            Arrays.asList("Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60"),
            Arrays.asList("Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60"),
            Arrays.asList("Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60", "Shattered Worlds 60"))))
            .requirement("Shattered Worlds 55 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 65 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61"),
            Arrays.asList("Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61"),
            Arrays.asList("Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61"),
            Arrays.asList("Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61"),
            Arrays.asList("Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61"),
            Arrays.asList("Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61"),
            Arrays.asList("Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61"),
            Arrays.asList("Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61", "Shattered Worlds 61"),
            Arrays.asList("Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62"),
            Arrays.asList("Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62"),
            Arrays.asList("Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62"),
            Arrays.asList("Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62"),
            Arrays.asList("Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62"),
            Arrays.asList("Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62"),
            Arrays.asList("Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62"),
            Arrays.asList("Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62", "Shattered Worlds 62"),
            Arrays.asList("Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63"),
            Arrays.asList("Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63"),
            Arrays.asList("Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63"),
            Arrays.asList("Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63"),
            Arrays.asList("Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63"),
            Arrays.asList("Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63"),
            Arrays.asList("Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63"),
            Arrays.asList("Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63", "Shattered Worlds 63"),
            Arrays.asList("Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64"),
            Arrays.asList("Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64"),
            Arrays.asList("Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64"),
            Arrays.asList("Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64"),
            Arrays.asList("Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64"),
            Arrays.asList("Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64"),
            Arrays.asList("Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64"),
            Arrays.asList("Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64", "Shattered Worlds 64"),
            Arrays.asList("Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65"),
            Arrays.asList("Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65"),
            Arrays.asList("Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65"),
            Arrays.asList("Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65"),
            Arrays.asList("Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65"),
            Arrays.asList("Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65"),
            Arrays.asList("Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65"),
            Arrays.asList("Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65", "Shattered Worlds 65"))))
            .requirement("Shattered Worlds 60 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 70 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66"),
            Arrays.asList("Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66"),
            Arrays.asList("Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66"),
            Arrays.asList("Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66"),
            Arrays.asList("Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66"),
            Arrays.asList("Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66"),
            Arrays.asList("Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66"),
            Arrays.asList("Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66", "Shattered Worlds 66"),
            Arrays.asList("Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67"),
            Arrays.asList("Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67"),
            Arrays.asList("Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67"),
            Arrays.asList("Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67"),
            Arrays.asList("Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67"),
            Arrays.asList("Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67"),
            Arrays.asList("Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67"),
            Arrays.asList("Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67", "Shattered Worlds 67"),
            Arrays.asList("Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68"),
            Arrays.asList("Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68"),
            Arrays.asList("Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68"),
            Arrays.asList("Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68"),
            Arrays.asList("Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68"),
            Arrays.asList("Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68"),
            Arrays.asList("Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68"),
            Arrays.asList("Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68", "Shattered Worlds 68"),
            Arrays.asList("Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69"),
            Arrays.asList("Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69"),
            Arrays.asList("Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69"),
            Arrays.asList("Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69"),
            Arrays.asList("Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69"),
            Arrays.asList("Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69"),
            Arrays.asList("Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69"),
            Arrays.asList("Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69", "Shattered Worlds 69"),
            Arrays.asList("Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70"),
            Arrays.asList("Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70"),
            Arrays.asList("Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70"),
            Arrays.asList("Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70"),
            Arrays.asList("Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70"),
            Arrays.asList("Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70"),
            Arrays.asList("Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70"),
            Arrays.asList("Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70", "Shattered Worlds 70"))))
            .requirement("Shattered Worlds 65 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 75 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71"),
            Arrays.asList("Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71"),
            Arrays.asList("Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71"),
            Arrays.asList("Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71"),
            Arrays.asList("Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71"),
            Arrays.asList("Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71"),
            Arrays.asList("Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71"),
            Arrays.asList("Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71", "Shattered Worlds 71"),
            Arrays.asList("Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72"),
            Arrays.asList("Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72"),
            Arrays.asList("Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72"),
            Arrays.asList("Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72"),
            Arrays.asList("Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72"),
            Arrays.asList("Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72"),
            Arrays.asList("Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72"),
            Arrays.asList("Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72", "Shattered Worlds 72"),
            Arrays.asList("Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73"),
            Arrays.asList("Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73"),
            Arrays.asList("Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73"),
            Arrays.asList("Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73"),
            Arrays.asList("Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73"),
            Arrays.asList("Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73"),
            Arrays.asList("Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73"),
            Arrays.asList("Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73", "Shattered Worlds 73"),
            Arrays.asList("Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74"),
            Arrays.asList("Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74"),
            Arrays.asList("Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74"),
            Arrays.asList("Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74"),
            Arrays.asList("Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74"),
            Arrays.asList("Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74"),
            Arrays.asList("Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74"),
            Arrays.asList("Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74", "Shattered Worlds 74"),
            Arrays.asList("Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75"),
            Arrays.asList("Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75"),
            Arrays.asList("Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75"),
            Arrays.asList("Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75"),
            Arrays.asList("Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75"),
            Arrays.asList("Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75"),
            Arrays.asList("Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75"),
            Arrays.asList("Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75", "Shattered Worlds 75"))))
            .requirement("Shattered Worlds 70 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 80 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76"),
            Arrays.asList("Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76"),
            Arrays.asList("Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76"),
            Arrays.asList("Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76"),
            Arrays.asList("Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76"),
            Arrays.asList("Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76"),
            Arrays.asList("Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76"),
            Arrays.asList("Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76", "Shattered Worlds 76"),
            Arrays.asList("Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77"),
            Arrays.asList("Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77"),
            Arrays.asList("Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77"),
            Arrays.asList("Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77"),
            Arrays.asList("Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77"),
            Arrays.asList("Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77"),
            Arrays.asList("Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77"),
            Arrays.asList("Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77", "Shattered Worlds 77"),
            Arrays.asList("Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78"),
            Arrays.asList("Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78"),
            Arrays.asList("Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78"),
            Arrays.asList("Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78"),
            Arrays.asList("Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78"),
            Arrays.asList("Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78"),
            Arrays.asList("Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78"),
            Arrays.asList("Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78", "Shattered Worlds 78"),
            Arrays.asList("Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79"),
            Arrays.asList("Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79"),
            Arrays.asList("Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79"),
            Arrays.asList("Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79"),
            Arrays.asList("Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79"),
            Arrays.asList("Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79"),
            Arrays.asList("Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79"),
            Arrays.asList("Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79", "Shattered Worlds 79"),
            Arrays.asList("Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80"),
            Arrays.asList("Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80"),
            Arrays.asList("Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80"),
            Arrays.asList("Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80"),
            Arrays.asList("Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80"),
            Arrays.asList("Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80"),
            Arrays.asList("Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80"),
            Arrays.asList("Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80", "Shattered Worlds 80"))))
            .requirement("Shattered Worlds 75 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 85 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81"),
            Arrays.asList("Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81"),
            Arrays.asList("Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81"),
            Arrays.asList("Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81"),
            Arrays.asList("Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81"),
            Arrays.asList("Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81"),
            Arrays.asList("Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81"),
            Arrays.asList("Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81", "Shattered Worlds 81"),
            Arrays.asList("Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82"),
            Arrays.asList("Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82"),
            Arrays.asList("Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82"),
            Arrays.asList("Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82"),
            Arrays.asList("Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82"),
            Arrays.asList("Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82"),
            Arrays.asList("Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82"),
            Arrays.asList("Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82", "Shattered Worlds 82"),
            Arrays.asList("Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83"),
            Arrays.asList("Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83"),
            Arrays.asList("Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83"),
            Arrays.asList("Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83"),
            Arrays.asList("Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83"),
            Arrays.asList("Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83"),
            Arrays.asList("Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83"),
            Arrays.asList("Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83", "Shattered Worlds 83"),
            Arrays.asList("Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84"),
            Arrays.asList("Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84"),
            Arrays.asList("Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84"),
            Arrays.asList("Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84"),
            Arrays.asList("Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84"),
            Arrays.asList("Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84"),
            Arrays.asList("Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84"),
            Arrays.asList("Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84", "Shattered Worlds 84"),
            Arrays.asList("Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85"),
            Arrays.asList("Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85"),
            Arrays.asList("Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85"),
            Arrays.asList("Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85"),
            Arrays.asList("Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85"),
            Arrays.asList("Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85"),
            Arrays.asList("Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85"),
            Arrays.asList("Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85", "Shattered Worlds 85"))))
            .requirement("Shattered Worlds 80 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 90 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86"),
            Arrays.asList("Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86"),
            Arrays.asList("Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86"),
            Arrays.asList("Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86"),
            Arrays.asList("Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86"),
            Arrays.asList("Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86"),
            Arrays.asList("Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86"),
            Arrays.asList("Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86", "Shattered Worlds 86"),
            Arrays.asList("Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87"),
            Arrays.asList("Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87"),
            Arrays.asList("Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87"),
            Arrays.asList("Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87"),
            Arrays.asList("Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87"),
            Arrays.asList("Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87"),
            Arrays.asList("Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87"),
            Arrays.asList("Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87", "Shattered Worlds 87"),
            Arrays.asList("Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88"),
            Arrays.asList("Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88"),
            Arrays.asList("Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88"),
            Arrays.asList("Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88"),
            Arrays.asList("Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88"),
            Arrays.asList("Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88"),
            Arrays.asList("Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88"),
            Arrays.asList("Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88", "Shattered Worlds 88"),
            Arrays.asList("Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89"),
            Arrays.asList("Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89"),
            Arrays.asList("Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89"),
            Arrays.asList("Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89"),
            Arrays.asList("Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89"),
            Arrays.asList("Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89"),
            Arrays.asList("Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89"),
            Arrays.asList("Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89", "Shattered Worlds 89"),
            Arrays.asList("Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90"),
            Arrays.asList("Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90"),
            Arrays.asList("Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90"),
            Arrays.asList("Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90"),
            Arrays.asList("Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90"),
            Arrays.asList("Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90"),
            Arrays.asList("Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90"),
            Arrays.asList("Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90", "Shattered Worlds 90"))))
            .requirement("Shattered Worlds 85 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattered Worlds 95 clear", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91"),
            Arrays.asList("Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91"),
            Arrays.asList("Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91"),
            Arrays.asList("Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91"),
            Arrays.asList("Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91"),
            Arrays.asList("Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91"),
            Arrays.asList("Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91"),
            Arrays.asList("Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91", "Shattered Worlds 91"),
            Arrays.asList("Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92"),
            Arrays.asList("Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92"),
            Arrays.asList("Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92"),
            Arrays.asList("Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92"),
            Arrays.asList("Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92"),
            Arrays.asList("Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92"),
            Arrays.asList("Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92"),
            Arrays.asList("Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92", "Shattered Worlds 92"),
            Arrays.asList("Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93"),
            Arrays.asList("Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93"),
            Arrays.asList("Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93"),
            Arrays.asList("Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93"),
            Arrays.asList("Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93"),
            Arrays.asList("Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93"),
            Arrays.asList("Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93"),
            Arrays.asList("Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93", "Shattered Worlds 93"),
            Arrays.asList("Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94"),
            Arrays.asList("Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94"),
            Arrays.asList("Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94"),
            Arrays.asList("Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94"),
            Arrays.asList("Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94"),
            Arrays.asList("Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94"),
            Arrays.asList("Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94"),
            Arrays.asList("Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94", "Shattered Worlds 94"),
            Arrays.asList("Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95"),
            Arrays.asList("Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95"),
            Arrays.asList("Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95"),
            Arrays.asList("Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95"),
            Arrays.asList("Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95"),
            Arrays.asList("Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95"),
            Arrays.asList("Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95"),
            Arrays.asList("Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95", "Shattered Worlds 95"))))
            .requirement("Shattered Worlds 90 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattering Worlds IV", 0).encounter(new Encounter(Arrays.asList(Arrays.asList(
            "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96"),
            Arrays.asList("Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96"),
            Arrays.asList("Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96"),
            Arrays.asList("Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96"),
            Arrays.asList("Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96"),
            Arrays.asList("Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96"),
            Arrays.asList("Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96"),
            Arrays.asList("Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96", "Shattered Worlds 96"),
            Arrays.asList("Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97"),
            Arrays.asList("Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97"),
            Arrays.asList("Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97"),
            Arrays.asList("Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97"),
            Arrays.asList("Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97"),
            Arrays.asList("Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97"),
            Arrays.asList("Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97"),
            Arrays.asList("Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97", "Shattered Worlds 97"),
            Arrays.asList("Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98"),
            Arrays.asList("Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98"),
            Arrays.asList("Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98"),
            Arrays.asList("Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98"),
            Arrays.asList("Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98"),
            Arrays.asList("Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98"),
            Arrays.asList("Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98"),
            Arrays.asList("Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98", "Shattered Worlds 98"),
            Arrays.asList("Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99"),
            Arrays.asList("Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99"),
            Arrays.asList("Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99"),
            Arrays.asList("Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99"),
            Arrays.asList("Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99"),
            Arrays.asList("Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99"),
            Arrays.asList("Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99"),
            Arrays.asList("Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99", "Shattered Worlds 99"),
            Arrays.asList("Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100"),
            Arrays.asList("Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100"),
            Arrays.asList("Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100"),
            Arrays.asList("Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100"),
            Arrays.asList("Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100"),
            Arrays.asList("Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100"),
            Arrays.asList("Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100"),
            Arrays.asList("Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100", "Shattered Worlds 100"))))
            .requirement("Shattered Worlds 95 clear", 1).build());
        achievements.add(new AchievementBuilder("Shattering Worlds V", 50).requirement("Shattering Worlds IV", 1).build());
        achievements.add(new AchievementBuilder("Shattering Worlds VI", 100).requirement("Shattering Worlds V", 1).build());
    }

    private void addAchievementsPhase4() {
        achievements.add(new AchievementBuilder("Skeletrail Horror", 0).requirement("Fur 'n' Seek wish list", 1).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring II", 0).requirement("Corrupted creatures", 1000).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring III", 0).requirement("Corrupted creatures", 2500).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring IV", 0).requirement("Corrupted creatures", 5000).build());
        achievements.add(new AchievementBuilder("Slay Bells Ring V", 0).requirement("Corrupted creatures", 10000).build());
        achievements.add(new AchievementBuilder("Slayer 5", -1).requirement("Slayer", 5).build());
        achievements.add(new AchievementBuilder("Slayer 10", -1).requirement("Slayer", 10).build());
        achievements.add(new AchievementBuilder("Slayer 20", -1).requirement("Slayer", 20).build());
        achievements.add(new AchievementBuilder("Slayer 30", -1).requirement("Slayer", 30).build());
        achievements.add(new AchievementBuilder("Slayer 40", -1).requirement("Slayer", 40).build());
        achievements.add(new AchievementBuilder("Slayer 50", -1).requirement("Slayer", 50).build());
        achievements.add(new AchievementBuilder("Slayer 60", -1).requirement("Slayer", 60).build());
        achievements.add(new AchievementBuilder("Slayer 70", -1).requirement("Slayer", 70).build());
        achievements.add(new AchievementBuilder("Slayer 80", -1).requirement("Slayer", 80).build());
        achievements.add(new AchievementBuilder("Slayer 90", -1).requirement("Slayer", 90).build());
        achievements.add(new AchievementBuilder("Slayer 99", -1).requirement("Slayer", 99).build());
        achievements.add(new AchievementBuilder("Slayer 110", -1).requirement("Slayer", 110).build());
        achievements.add(new AchievementBuilder("Slayer 120", -1).requirement("Slayer", 120).build());
        achievements.add(new AchievementBuilder("Slide to the Left", 0).requirement("Sealed clue scroll (hard)", 1).build());
        achievements.add(new AchievementBuilder("Smithing 5", -1).requirement("Smithing", 5).build());
        achievements.add(new AchievementBuilder("Smithing 10", -1).requirement("Smithing", 10).build());
        achievements.add(new AchievementBuilder("Smithing 20", -1).requirement("Smithing", 20).build());
        achievements.add(new AchievementBuilder("Smithing 30", -1).requirement("Smithing", 30).build());
        achievements.add(new AchievementBuilder("Smithing 40", -1).requirement("Smithing", 40).build());
        achievements.add(new AchievementBuilder("Smithing 50", -1).requirement("Smithing", 50).build());
        achievements.add(new AchievementBuilder("Smithing 60", -1).requirement("Smithing", 60).build());
        achievements.add(new AchievementBuilder("Smithing 70", -1).requirement("Smithing", 70).build());
        achievements.add(new AchievementBuilder("Smithing 80", -1).requirement("Smithing", 80).build());
        achievements.add(new AchievementBuilder("Smithing 90", -1).requirement("Smithing", 90).build());
        achievements.add(new AchievementBuilder("Smithing 92", -1).requirement("Smithing", 92).build());
        achievements.add(new AchievementBuilder("Smithing 99", -1).requirement("Smithing", 99).build());
        achievements.add(new AchievementBuilder("Something Barrowed I", 0).requirement("Barrows", 5).build());
        achievements.add(new AchievementBuilder("Something Barrowed II", 0).requirement("Barrows", 10).build());
        achievements.add(new AchievementBuilder("Something Barrowed III", 0).requirement("Barrows", 25).build());
        achievements.add(new AchievementBuilder("Something Barrowed IV", 0).requirement("Barrows", 50).build());
        achievements.add(new AchievementBuilder("Something Barrowed V", 0).requirement("Barrows", 75).build());
        achievements.add(new AchievementBuilder("Source of Denial", 0).requirement("Diamond in the Rough", 1)
            .reward("Winter sq'irk", 1).reward("Farming", 30).build());
        achievements.add(new AchievementBuilder("Special Slayer Delivery", 0).requirement("Slayer point", 1000).build());
        achievements.add(new AchievementBuilder("Squishing Level I", 0).requirement("The Jack of Spades", 1)
            .reward("Menaphos reputation", 50).build());
        achievements.add(new AchievementBuilder("Squishing Level II", 0.05).requirement("Squishing Level I", 1)
            .reward("Menaphos reputation", 450).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).build());
        achievements.add(new AchievementBuilder("Squishing Level III", 0.2).requirement("Squishing Level II", 1)
            .reward("Menaphos reputation", 2000).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).build());
        achievements.add(new AchievementBuilder("Squishing Level IV", 0.25).requirement("Squishing Level III", 1)
            .reward("Menaphos reputation", 2500).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).build());
        achievements.add(new AchievementBuilder("Squishing Level V", 0.5).requirement("Squishing Level IV", 1)
            .reward("Menaphos reputation", 5000).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).lamp(Collections.singletonList("Slayer"), -1, 1)
            .lamp(Collections.singletonList("Slayer"), -1, 1).build());
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
        achievements.add(new AchievementBuilder("Stone's Throw Away", 145).requirement("Dahmaroc statue 1", 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).lamp(Collections.singletonList("Agility"), -6, 1)
            .lamp(Collections.singletonList("Construction"), -6, 1).lamp(Collections.singletonList("Cooking"), -6, 1)
            .lamp(Collections.singletonList("Crafting"), -6, 1).lamp(Collections.singletonList("Farming"), -6, 1)
            .lamp(Collections.singletonList("Firemaking"), -6, 1).lamp(Collections.singletonList("Fishing"), -6, 1)
            .lamp(Collections.singletonList("Fletching"), -6, 1).lamp(Collections.singletonList("Herblore"), -6, 1)
            .lamp(Collections.singletonList("Hunter"), -6, 1).lamp(Collections.singletonList("Mining"), -6, 1)
            .lamp(Collections.singletonList("Runecrafting"), -6, 1).lamp(Collections.singletonList("Smithing"), -6, 1)
            .lamp(Collections.singletonList("Thieving"), -6, 1).lamp(Collections.singletonList("Woodcutting"), -6, 1)
            .lamp(Collections.singletonList("Agility"), -6, 1).lamp(Collections.singletonList("Construction"), -6, 1)
            .lamp(Collections.singletonList("Cooking"), -6, 1).lamp(Collections.singletonList("Crafting"), -6, 1)
            .lamp(Collections.singletonList("Farming"), -6, 1).lamp(Collections.singletonList("Firemaking"), -6, 1)
            .lamp(Collections.singletonList("Fishing"), -6, 1).lamp(Collections.singletonList("Fletching"), -6, 1)
            .lamp(Collections.singletonList("Herblore"), -6, 1).lamp(Collections.singletonList("Hunter"), -6, 1)
            .lamp(Collections.singletonList("Mining"), -6, 1).lamp(Collections.singletonList("Runecrafting"), -6, 1)
            .lamp(Collections.singletonList("Smithing"), -6, 1).lamp(Collections.singletonList("Thieving"), -6, 1)
            .lamp(Collections.singletonList("Woodcutting"), -6, 1).build());
        achievements.add(new AchievementBuilder("Strength 5", -1).requirement("Strength", 5).build());
        achievements.add(new AchievementBuilder("Strength 10", -1).requirement("Strength", 10).build());
        achievements.add(new AchievementBuilder("Strength 20", -1).requirement("Strength", 20).build());
        achievements.add(new AchievementBuilder("Strength 30", -1).requirement("Strength", 30).build());
        achievements.add(new AchievementBuilder("Strength 40", -1).requirement("Strength", 40).build());
        achievements.add(new AchievementBuilder("Strength 50", -1).requirement("Strength", 50).build());
        achievements.add(new AchievementBuilder("Strength 60", -1).requirement("Strength", 60).build());
        achievements.add(new AchievementBuilder("Strength 70", -1).requirement("Strength", 70).build());
        achievements.add(new AchievementBuilder("Strength 80", -1).requirement("Strength", 80).build());
        achievements.add(new AchievementBuilder("Strength 90", -1).requirement("Strength", 90).build());
        achievements.add(new AchievementBuilder("Strength 92", -1).requirement("Strength", 92).build());
        achievements.add(new AchievementBuilder("Strength 99", -1).requirement("Strength", 99).build());
        achievements.add(new AchievementBuilder("Stuffed With Anima", 0).requirement("100% Telos defeated", 1)
            .encounter(new Encounter("Telos (100% enrage)")).build());
        achievements.add(new AchievementBuilder("Summoning 5", -1).requirement("Summoning", 5).build());
        achievements.add(new AchievementBuilder("Summoning 10", -1).requirement("Summoning", 10).build());
        achievements.add(new AchievementBuilder("Summoning 20", -1).requirement("Summoning", 20).build());
        achievements.add(new AchievementBuilder("Summoning 30", -1).requirement("Summoning", 30).build());
        achievements.add(new AchievementBuilder("Summoning 40", -1).requirement("Summoning", 40).build());
        achievements.add(new AchievementBuilder("Summoning 50", -1).requirement("Summoning", 50).build());
        achievements.add(new AchievementBuilder("Summoning 60", -1).requirement("Summoning", 60).build());
        achievements.add(new AchievementBuilder("Summoning 70", -1).requirement("Summoning", 70).build());
        achievements.add(new AchievementBuilder("Summoning 80", -1).requirement("Summoning", 80).build());
        achievements.add(new AchievementBuilder("Summoning 90", -1).requirement("Summoning", 90).build());
        achievements.add(new AchievementBuilder("Summoning 92", -1).requirement("Summoning", 92).build());
        achievements.add(new AchievementBuilder("Summoning 99", -1).requirement("Summoning", 99).build());
        achievements.add(new AchievementBuilder("Sunshine Through the Rain", 0).requirement("Agility", 70)
            .encounter(new Encounter("Commander Zilyana (hard)")).build());
        achievements.add(new AchievementBuilder("Superior Successor", 0).requirement("The Magister", 609).build());
        achievements.add(new AchievementBuilder("Talk to Explorer Jack", 0).build());
        achievements.add(new AchievementBuilder("Tan Your Hide", 0).requirement("Cowhide", 1).reward("Leather", 1).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry II", 0).requirement("100% Telos defeated", 1).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry III", 0).requirement("Telos If You're Angry II", 1)
            .encounter(new Encounter("Telos (105% enrage)")).encounter(new Encounter("Telos (110% enrage)"))
            .encounter(new Encounter("Telos (115% enrage)")).encounter(new Encounter("Telos (120% enrage)"))
            .encounter(new Encounter("Telos (125% enrage)")).encounter(new Encounter("Telos (130% enrage)"))
            .encounter(new Encounter("Telos (135% enrage)")).encounter(new Encounter("Telos (140% enrage)"))
            .encounter(new Encounter("Telos (145% enrage)")).encounter(new Encounter("Telos (150% enrage)"))
            .encounter(new Encounter("Telos (155% enrage)")).encounter(new Encounter("Telos (160% enrage)"))
            .encounter(new Encounter("Telos (165% enrage)")).encounter(new Encounter("Telos (170% enrage)"))
            .encounter(new Encounter("Telos (175% enrage)")).encounter(new Encounter("Telos (180% enrage)"))
            .encounter(new Encounter("Telos (185% enrage)")).encounter(new Encounter("Telos (190% enrage)"))
            .encounter(new Encounter("Telos (195% enrage)")).encounter(new Encounter("Telos (200% enrage)"))
            .encounter(new Encounter("Telos (205% enrage)")).encounter(new Encounter("Telos (210% enrage)"))
            .encounter(new Encounter("Telos (215% enrage)")).encounter(new Encounter("Telos (220% enrage)"))
            .encounter(new Encounter("Telos (225% enrage)")).encounter(new Encounter("Telos (230% enrage)"))
            .encounter(new Encounter("Telos (235% enrage)")).encounter(new Encounter("Telos (240% enrage)"))
            .encounter(new Encounter("Telos (245% enrage)")).encounter(new Encounter("Telos (250% enrage)")).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry IV", 0).requirement("Telos If You're Angry III", 1)
            .encounter(new Encounter("Telos (255% enrage)")).encounter(new Encounter("Telos (260% enrage)"))
            .encounter(new Encounter("Telos (265% enrage)")).encounter(new Encounter("Telos (270% enrage)"))
            .encounter(new Encounter("Telos (275% enrage)")).encounter(new Encounter("Telos (280% enrage)"))
            .encounter(new Encounter("Telos (285% enrage)")).encounter(new Encounter("Telos (290% enrage)"))
            .encounter(new Encounter("Telos (295% enrage)")).encounter(new Encounter("Telos (300% enrage)"))
            .encounter(new Encounter("Telos (305% enrage)")).encounter(new Encounter("Telos (310% enrage)"))
            .encounter(new Encounter("Telos (315% enrage)")).encounter(new Encounter("Telos (320% enrage)"))
            .encounter(new Encounter("Telos (325% enrage)")).encounter(new Encounter("Telos (330% enrage)"))
            .encounter(new Encounter("Telos (335% enrage)")).encounter(new Encounter("Telos (340% enrage)"))
            .encounter(new Encounter("Telos (345% enrage)")).encounter(new Encounter("Telos (350% enrage)"))
            .encounter(new Encounter("Telos (355% enrage)")).encounter(new Encounter("Telos (360% enrage)"))
            .encounter(new Encounter("Telos (365% enrage)")).encounter(new Encounter("Telos (370% enrage)"))
            .encounter(new Encounter("Telos (375% enrage)")).encounter(new Encounter("Telos (380% enrage)"))
            .encounter(new Encounter("Telos (385% enrage)")).encounter(new Encounter("Telos (390% enrage)"))
            .encounter(new Encounter("Telos (395% enrage)")).encounter(new Encounter("Telos (400% enrage)"))
            .encounter(new Encounter("Telos (405% enrage)")).encounter(new Encounter("Telos (410% enrage)"))
            .encounter(new Encounter("Telos (415% enrage)")).encounter(new Encounter("Telos (420% enrage)"))
            .encounter(new Encounter("Telos (425% enrage)")).encounter(new Encounter("Telos (430% enrage)"))
            .encounter(new Encounter("Telos (435% enrage)")).encounter(new Encounter("Telos (440% enrage)"))
            .encounter(new Encounter("Telos (445% enrage)")).encounter(new Encounter("Telos (450% enrage)"))
            .encounter(new Encounter("Telos (455% enrage)")).encounter(new Encounter("Telos (460% enrage)"))
            .encounter(new Encounter("Telos (465% enrage)")).encounter(new Encounter("Telos (470% enrage)"))
            .encounter(new Encounter("Telos (475% enrage)")).encounter(new Encounter("Telos (480% enrage)"))
            .encounter(new Encounter("Telos (485% enrage)")).encounter(new Encounter("Telos (490% enrage)"))
            .encounter(new Encounter("Telos (495% enrage)")).encounter(new Encounter("Telos (500% enrage)")).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry V", 0).requirement("Telos If You're Angry IV", 1)
            .encounter(new Encounter("Telos (505% enrage)")).encounter(new Encounter("Telos (510% enrage)"))
            .encounter(new Encounter("Telos (515% enrage)")).encounter(new Encounter("Telos (520% enrage)"))
            .encounter(new Encounter("Telos (525% enrage)")).encounter(new Encounter("Telos (530% enrage)"))
            .encounter(new Encounter("Telos (535% enrage)")).encounter(new Encounter("Telos (540% enrage)"))
            .encounter(new Encounter("Telos (545% enrage)")).encounter(new Encounter("Telos (550% enrage)"))
            .encounter(new Encounter("Telos (555% enrage)")).encounter(new Encounter("Telos (560% enrage)"))
            .encounter(new Encounter("Telos (565% enrage)")).encounter(new Encounter("Telos (570% enrage)"))
            .encounter(new Encounter("Telos (575% enrage)")).encounter(new Encounter("Telos (580% enrage)"))
            .encounter(new Encounter("Telos (585% enrage)")).encounter(new Encounter("Telos (590% enrage)"))
            .encounter(new Encounter("Telos (595% enrage)")).encounter(new Encounter("Telos (600% enrage)"))
            .encounter(new Encounter("Telos (605% enrage)")).encounter(new Encounter("Telos (610% enrage)"))
            .encounter(new Encounter("Telos (615% enrage)")).encounter(new Encounter("Telos (620% enrage)"))
            .encounter(new Encounter("Telos (625% enrage)")).encounter(new Encounter("Telos (630% enrage)"))
            .encounter(new Encounter("Telos (635% enrage)")).encounter(new Encounter("Telos (640% enrage)"))
            .encounter(new Encounter("Telos (645% enrage)")).encounter(new Encounter("Telos (650% enrage)"))
            .encounter(new Encounter("Telos (655% enrage)")).encounter(new Encounter("Telos (660% enrage)"))
            .encounter(new Encounter("Telos (665% enrage)")).encounter(new Encounter("Telos (670% enrage)"))
            .encounter(new Encounter("Telos (675% enrage)")).encounter(new Encounter("Telos (680% enrage)"))
            .encounter(new Encounter("Telos (685% enrage)")).encounter(new Encounter("Telos (690% enrage)"))
            .encounter(new Encounter("Telos (695% enrage)")).encounter(new Encounter("Telos (700% enrage)"))
            .encounter(new Encounter("Telos (705% enrage)")).encounter(new Encounter("Telos (710% enrage)"))
            .encounter(new Encounter("Telos (715% enrage)")).encounter(new Encounter("Telos (720% enrage)"))
            .encounter(new Encounter("Telos (725% enrage)")).encounter(new Encounter("Telos (730% enrage)"))
            .encounter(new Encounter("Telos (735% enrage)")).encounter(new Encounter("Telos (740% enrage)"))
            .encounter(new Encounter("Telos (745% enrage)")).encounter(new Encounter("Telos (750% enrage)")).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry VI", 0).requirement("Telos If You're Angry V", 1)
            .encounter(new Encounter("Telos (755% enrage)")).encounter(new Encounter("Telos (760% enrage)"))
            .encounter(new Encounter("Telos (765% enrage)")).encounter(new Encounter("Telos (770% enrage)"))
            .encounter(new Encounter("Telos (775% enrage)")).encounter(new Encounter("Telos (780% enrage)"))
            .encounter(new Encounter("Telos (785% enrage)")).encounter(new Encounter("Telos (790% enrage)"))
            .encounter(new Encounter("Telos (795% enrage)")).encounter(new Encounter("Telos (800% enrage)"))
            .encounter(new Encounter("Telos (805% enrage)")).encounter(new Encounter("Telos (810% enrage)"))
            .encounter(new Encounter("Telos (815% enrage)")).encounter(new Encounter("Telos (820% enrage)"))
            .encounter(new Encounter("Telos (825% enrage)")).encounter(new Encounter("Telos (830% enrage)"))
            .encounter(new Encounter("Telos (835% enrage)")).encounter(new Encounter("Telos (840% enrage)"))
            .encounter(new Encounter("Telos (845% enrage)")).encounter(new Encounter("Telos (850% enrage)"))
            .encounter(new Encounter("Telos (855% enrage)")).encounter(new Encounter("Telos (860% enrage)"))
            .encounter(new Encounter("Telos (865% enrage)")).encounter(new Encounter("Telos (870% enrage)"))
            .encounter(new Encounter("Telos (875% enrage)")).encounter(new Encounter("Telos (880% enrage)"))
            .encounter(new Encounter("Telos (885% enrage)")).encounter(new Encounter("Telos (890% enrage)"))
            .encounter(new Encounter("Telos (895% enrage)")).encounter(new Encounter("Telos (900% enrage)"))
            .encounter(new Encounter("Telos (905% enrage)")).encounter(new Encounter("Telos (910% enrage)"))
            .encounter(new Encounter("Telos (915% enrage)")).encounter(new Encounter("Telos (920% enrage)"))
            .encounter(new Encounter("Telos (925% enrage)")).encounter(new Encounter("Telos (930% enrage)"))
            .encounter(new Encounter("Telos (935% enrage)")).encounter(new Encounter("Telos (940% enrage)"))
            .encounter(new Encounter("Telos (945% enrage)")).encounter(new Encounter("Telos (950% enrage)"))
            .encounter(new Encounter("Telos (955% enrage)")).encounter(new Encounter("Telos (960% enrage)"))
            .encounter(new Encounter("Telos (965% enrage)")).encounter(new Encounter("Telos (970% enrage)"))
            .encounter(new Encounter("Telos (975% enrage)")).encounter(new Encounter("Telos (980% enrage)"))
            .encounter(new Encounter("Telos (985% enrage)")).encounter(new Encounter("Telos (990% enrage)"))
            .encounter(new Encounter("Telos (995% enrage)")).encounter(new Encounter("Telos (1000% enrage)")).build());
        achievements.add(new AchievementBuilder("So You Think You Can Guard?", 35).requirement("Telos If You're Angry VI", 1).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts I", 0).requirement("Telos", 5).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts II", 0).requirement("Telos", 10).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts III", 0).requirement("Telos", 25).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts IV", 0).requirement("Telos", 50).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts V", 0).requirement("Telos", 75).build());
        achievements.add(new AchievementBuilder("The True Warden", 100).requirement("So You Think You Can Guard?", 1).build());
        achievements.add(new AchievementBuilder("There's No Place Like Burthorpe", 0).requirement("Burthorpe", 1).build());
        achievements.add(new AchievementBuilder("There's No Place Like Home", 0).build());
        achievements.add(new AchievementBuilder("They All Fell Down", 0).encounter(new Encounter("Dagannoth Rex"))
            .encounter(new Encounter("Dagannoth Supreme")).encounter(new Encounter("Dagannoth Prime")).build());
        achievements.add(new AchievementBuilder("Thieving 5", -1).requirement("Thieving", 5).build());
        achievements.add(new AchievementBuilder("Thieving 10", -1).requirement("Thieving", 10).build());
        achievements.add(new AchievementBuilder("Thieving 20", -1).requirement("Thieving", 20).build());
        achievements.add(new AchievementBuilder("Thieving 30", -1).requirement("Thieving", 30).build());
        achievements.add(new AchievementBuilder("Thieving 40", -1).requirement("Thieving", 40).build());
        achievements.add(new AchievementBuilder("Thieving 50", -1).requirement("Thieving", 50).build());
        achievements.add(new AchievementBuilder("Thieving 60", -1).requirement("Thieving", 60).build());
        achievements.add(new AchievementBuilder("Thieving 70", -1).requirement("Thieving", 70).build());
        achievements.add(new AchievementBuilder("Thieving 80", -1).requirement("Thieving", 80).build());
        achievements.add(new AchievementBuilder("Thieving 90", -1).requirement("Thieving", 90).build());
        achievements.add(new AchievementBuilder("Thieving 92", -1).requirement("Thieving", 92).build());
        achievements.add(new AchievementBuilder("Thieving 99", -1).requirement("Thieving", 99).build());
        achievements.add(new AchievementBuilder("This Helwyr in I", 0).requirement("Helwyr", 5).reward("Sliske reputation", 50).build());
        achievements.add(new AchievementBuilder("This Helwyr in II", 0).requirement("Helwyr", 10).build());
        achievements.add(new AchievementBuilder("This Helwyr in III", 0).requirement("Helwyr", 25).build());
        achievements.add(new AchievementBuilder("This Helwyr in IV", 0).requirement("Helwyr", 50).build());
        achievements.add(new AchievementBuilder("This Helwyr in V", 0).requirement("Helwyr", 75).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One I", 0).requirement("King Black Dragon", 5).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One II", 0).requirement("King Black Dragon", 10).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One III", 0).requirement("King Black Dragon", 25).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One IV", 0).requirement("King Black Dragon", 50).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One V", 0).requirement("King Black Dragon", 75).build());
        achievements.add(new AchievementBuilder("Through the Fire and Flames", 0).encounter(new Encounter("Queen Black Dragon")).build());
        achievements.add(new AchievementBuilder("Jungle strykewyrm soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Jungle strykewyrms", 506).reward("Slayer", 18250).build());
        achievements.add(new AchievementBuilder("Gargoyle soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Gargoyles", 520).reward("Slayer", 18750).build());
        achievements.add(new AchievementBuilder("Living rock creature soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Living rock creatures", 520).reward("Slayer", 18750).build());
        achievements.add(new AchievementBuilder("Muspah soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Muspah", 520).reward("Slayer", 18750).build());
        achievements.add(new AchievementBuilder("Nihil soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Nihil", 520).reward("Slayer", 18750).build());
        achievements.add(new AchievementBuilder("Tormented demon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Tormented demons", 520).reward("Slayer", 18750).build());
        achievements.add(new AchievementBuilder("Shadow creature soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Shadow creatures", 520).reward("Slayer", 18750).build());
        achievements.add(new AchievementBuilder("Crystal shapeshifter soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Crystal shapeshifters", 520).reward("Slayer", 18750).build());
        achievements.add(new AchievementBuilder("Desert strykewyrm soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Desert strykewyrms", 534).reward("Slayer", 19250).build());
        achievements.add(new AchievementBuilder("Aquanite soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Aquanites", 541).reward("Slayer", 19500).build());
        achievements.add(new AchievementBuilder("Nechryael soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Nechryaels", 555).reward("Slayer", 20000).build());
        achievements.add(new AchievementBuilder("Kal'gerion demon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Kal'gerion demon", 555).reward("Slayer", 20000).build());
        achievements.add(new AchievementBuilder("Glacor soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Glacors", 555).reward("Slayer", 20000).build());
        achievements.add(new AchievementBuilder("Adamant dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Adamant dragons", 555).reward("Slayer", 20000).build());
        achievements.add(new AchievementBuilder("Nightmare soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Nightmares", 555).reward("Slayer", 20000).build());
        achievements.add(new AchievementBuilder("Revenant soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Revenant kills", 555).reward("Slayer", 20000).build());
        achievements.add(new AchievementBuilder("Ascension member soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Ascension members", 562).reward("Slayer", 20250).build());
        achievements.add(new AchievementBuilder("Grifolaroo soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Grifolaroos", 569).reward("Slayer", 20500).build());
        achievements.add(new AchievementBuilder("Spiritual mage soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Spiritual mages", 575).reward("Slayer", 20750).build());
        achievements.add(new AchievementBuilder("Abyssal demon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Abyssal demons", 589).reward("Slayer", 21250).build());
        achievements.add(new AchievementBuilder("Mutated jadinko soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Mutated jadinkos", 596).reward("Slayer", 21500).build());
        achievements.add(new AchievementBuilder("Grifolapine soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Grifolapines", 610).reward("Slayer", 22000).build());
        achievements.add(new AchievementBuilder("Corrupted scorpion soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Corrupted scorpion", 610).reward("Slayer", 22000).build());
        achievements.add(new AchievementBuilder("Dark beast soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Dark beasts", 624).reward("Slayer", 22500).build());
        achievements.add(new AchievementBuilder("Edimmu soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Edimmus", 624).reward("Slayer", 22500).build());
        achievements.add(new AchievementBuilder("Rune dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Rune dragons", 624).reward("Slayer", 22500).build());
        achievements.add(new AchievementBuilder("Feral Dinosaur soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Feral Dinosaur", 624).reward("Slayer", 22500).build());
        achievements.add(new AchievementBuilder("Devil's snare soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Devil's snare", 624).reward("Slayer", 22500).build());
        achievements.add(new AchievementBuilder("Corrupted scarab soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Corrupted scarab", 631).reward("Slayer", 22750).build());
        achievements.add(new AchievementBuilder("Airut soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Airuts", 638).reward("Slayer", 23000).build());
        achievements.add(new AchievementBuilder("Ice strykewyrm soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Ice strykewyrms", 645).reward("Slayer", 23250).build());
        achievements.add(new AchievementBuilder("Lava strykewyrm soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Lava strykewyrms", 652).reward("Slayer", 23500).build());
        achievements.add(new AchievementBuilder("Corrupted lizard soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Corrupted lizard", 652).reward("Slayer", 23500).build());
        achievements.add(new AchievementBuilder("Ganodermic creature soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Ganodermic creatures", 659).reward("Slayer", 23750).build());
        achievements.add(new AchievementBuilder("Dragonstone dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Dragonstone dragon", 659).reward("Slayer", 23750).build());
        achievements.add(new AchievementBuilder("Luminous snaggler soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Luminous snaggler", 659).reward("Slayer", 23750).build());
        achievements.add(new AchievementBuilder("Wyvern soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Wyverns", 666).reward("Slayer", 24000).build());
        achievements.add(new AchievementBuilder("Ripper demon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Ripper demons", 666).reward("Slayer", 24000).build());
        achievements.add(new AchievementBuilder("Camel Warrior soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Camel Warriors", 666).reward("Slayer", 24000).build());
        achievements.add(new AchievementBuilder("Acheron mammoth soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Acheron mammoths", 666).reward("Slayer", 24000).build());
        achievements.add(new AchievementBuilder("Corrupted dust devil soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Corrupted dust devil", 673).reward("Slayer", 24250).build());
        achievements.add(new AchievementBuilder("Onyx dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Onyx dragon", 679).reward("Slayer", 24500).build());
        achievements.add(new AchievementBuilder("Soulgazer soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Soulgazer", 686).reward("Slayer", 24750).build());
        achievements.add(new AchievementBuilder("Brutish dinosaur soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Brutish dinosaur", 686).reward("Slayer", 24750).build());
        achievements.add(new AchievementBuilder("Corrupted kalphite soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Corrupted kalphite marauder", 693).reward("Slayer", 25000).build());
        achievements.add(new AchievementBuilder("Hydrix dragon soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Hydrix dragon", 700).reward("Slayer", 25250).build());
        achievements.add(new AchievementBuilder("Lampenflora soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Lampenflora", 707).reward("Slayer", 25500).build());
        achievements.add(new AchievementBuilder("Corrupted worker soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Corrupted worker", 714).reward("Slayer", 25750).build());
        achievements.add(new AchievementBuilder("Vinecrawler soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Vinecrawler", 721).reward("Slayer", 26000).build());
        achievements.add(new AchievementBuilder("Salawa akh soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Salawa akh", 728).reward("Slayer", 26250).build());
        achievements.add(new AchievementBuilder("Venomous dinosaur soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Venomous dinosaur", 728).reward("Slayer", 26250).build());
        achievements.add(new AchievementBuilder("Bulbous crawler soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Bulbous crawler", 735).reward("Slayer", 26500).build());
        achievements.add(new AchievementBuilder("Feline akh soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Feline akh", 742).reward("Slayer", 26750).build());
        achievements.add(new AchievementBuilder("Moss golem soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Moss golem", 749).reward("Slayer", 27000).build());
        achievements.add(new AchievementBuilder("Scarab akh soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Scarab akh", 756).reward("Slayer", 27250).build());
        achievements.add(new AchievementBuilder("Liverworts soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Liverworts", 763).reward("Slayer", 27500).build());
        achievements.add(new AchievementBuilder("Crocodile akh soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Crocodile akh", 770).reward("Slayer", 27750).build());
        achievements.add(new AchievementBuilder("Gorilla akh soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Gorilla akh", 783).reward("Slayer", 28250).build());
        achievements.add(new AchievementBuilder("Ripper dinosaur soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Ripper dinosaur", 790).reward("Slayer", 28500).build());
        achievements.add(new AchievementBuilder("Imperial guard akh soul", 0).requirement("Slayer Codex unlock", 1)
            .requirement("Imperial ranger akh", 811).reward("Slayer", 29250).build());
        achievements.add(new AchievementBuilder("To Be a Master", 0).requirement("The History of Slayer", 1)
            .requirement("Jungle strykewyrm soul", 1).requirement("Gargoyle soul", 1).requirement("Living rock creature soul", 1)
            .requirement("Muspah soul", 1).requirement("Nihil soul", 1).requirement("Tormented demon soul", 1)
            .requirement("Shadow creature soul", 1).requirement("Crystal shapeshifter soul", 1).requirement("Desert strykewyrm soul", 1)
            .requirement("Aquanite soul", 1).requirement("Nechryael soul", 1).requirement("Kal'gerion demon soul", 1)
            .requirement("Glacor soul", 1).requirement("Adamant dragon soul", 1).requirement("Nightmare soul", 1)
            .requirement("Revenant soul", 1).requirement("Ascension member soul", 1).requirement("Grifolaroo soul", 1)
            .requirement("Spiritual mage soul", 1).requirement("Abyssal demon soul", 1).requirement("Mutated jadinko soul", 1)
            .requirement("Grifolapine soul", 1).requirement("Corrupted scorpion soul", 1).requirement("Dark beast soul", 1)
            .requirement("Edimmu soul", 1).requirement("Rune dragon soul", 1).requirement("Corrupted scarab soul", 1)
            .requirement("Airut soul", 1).requirement("Ice strykewyrm soul", 1).requirement("Lava strykewyrm soul", 1)
            .requirement("Corrupted lizard soul", 1).requirement("Ganodermic creature soul", 1).requirement("Dragonstone dragon soul", 1)
            .requirement("Wyvern soul", 1).requirement("Ripper demon soul", 1).requirement("Camel Warrior soul", 1)
            .requirement("Acheron mammoth soul", 1).requirement("Corrupted dust devil soul", 1).requirement("Onyx dragon soul", 1)
            .requirement("Soulgazer soul", 1).requirement("Corrupted kalphite soul", 1).requirement("Hydrix dragon soul", 1)
            .requirement("Corrupted worker soul", 1).requirement("Vinecrawler soul", 1).requirement("Salawa akh soul", 1)
            .requirement("Bulbous crawler soul", 1).requirement("Feline akh soul", 1).requirement("Moss golem soul", 1)
            .requirement("Scarab akh soul", 1).requirement("Crocodile akh soul", 1).requirement("Gorilla akh soul", 1)
            .requirement("Imperial guard akh soul", 1).requirement("Feral Dinosaur soul", 1).requirement("Brutish dinosaur soul", 1)
            .requirement("Venomous dinosaur soul", 1).requirement("Ripper dinosaur soul", 1).requirement("Lampenflora soul", 1)
            .requirement("Devil's snare soul", 1).requirement("Luminous snaggler soul", 1).requirement("Liverworts soul", 1).build());
        achievements.add(new AchievementBuilder("To the Bone", 0).requirement("Menaphos reputation", 1200000).build());
        achievements.add(new AchievementBuilder("TokHaar-Mok", 0).requirement("The Brink of Extinction", 1).requirement("Smithing", 85)
            .encounter(new Encounter("TokHaar-Hok")).reward("Obsidian shard", 16)
            .lamp(Arrays.asList("Attack", "Strength", "Defence", "Constitution", "Magic", "Ranged", "Summoning", "Prayer", "Herblore",
                "Slayer"), 20000, 80).build());
        achievements.add(new AchievementBuilder("Towering Over Us All", 0).requirement("Desperate Times", 1).build());
        achievements.add(new AchievementBuilder("Traitorous", 0).requirement("Agility", 70).encounter(new Encounter("Commander Zilyana"))
            .build());
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
        achievements.add(new AchievementBuilder("Who Will Be Her Lover?", 155).requirement("Rhian in Gold - The Original", 1)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75)
            .lamp(Collections.singletonList("Agility"), -5, 75).lamp(Collections.singletonList("Construction"), -5, 75)
            .lamp(Collections.singletonList("Crafting"), -5, 75).lamp(Collections.singletonList("Divination"), -5, 75)
            .lamp(Collections.singletonList("Dungeoneering"), -5, 75).lamp(Collections.singletonList("Farming"), -5, 75)
            .lamp(Collections.singletonList("Herblore"), -5, 75).lamp(Collections.singletonList("Magic"), -5, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defence"), -5, 75).lamp(Collections.singletonList("Mining"), -5, 75)
            .lamp(Collections.singletonList("Prayer"), -5, 75).lamp(Collections.singletonList("Ranged"), -5, 75)
            .lamp(Collections.singletonList("Slayer"), -5, 75).lamp(Collections.singletonList("Smithing"), -5, 75)
            .lamp(Collections.singletonList("Summoning"), -5, 75).lamp(Collections.singletonList("Woodcutting"), -5, 75).build());
        achievements.add(new AchievementBuilder("Work On Your Artisan", 0).requirement("Smithing", 98).build());
        achievements.add(new AchievementBuilder("Finish Him!", 0).encounter(new Encounter(Collections.singletonList(
            Collections.singletonList("Vorago")), 7)).build());
        achievements.add(new AchievementBuilder("You Had A Chicken", 1.2).requirement("Granny Knows Best", 1).requirement("Farming", 28)
            .requirement("Chicken egg (unchecked)", 8).requirement("POF bean", 6000).reward("Farming", 10000).build());
        achievements.add(new AchievementBuilder("You Had A Rabbit", 0.5).requirement("Granny Knows Best", 1)
            .requirement("Rellekkan cream rabbit (unchecked)", 2).requirement("Common brown rabbit (unchecked)", 2)
            .requirement("Piscatorian cottontail rabbit (unchecked)", 2).requirement("POF bean", 6000).reward("Farming", 1650).build());
        achievements.add(new AchievementBuilder("You Had A Chinchompa", 1.05).requirement("Granny Knows Best", 1).requirement("Farming", 54)
            .requirement("Grey chinchompa (unchecked)", 2).requirement("Carnivorous chinchompa (unchecked)", 2)
            .requirement("Cobalt chinchompa (unchecked)", 2).requirement("Viridian chinchompa (unchecked)", 2)
            .requirement("Azure chinchompa (unchecked)", 2).requirement("Crimson chinchompa (unchecked)", 2)
            .requirement("Crystal chinchompa (unchecked)", 2).requirement("POF bean", 6000).reward("Farming", 231000).build());
        achievements.add(new AchievementBuilder("You Had A Sheep", 0.7).requirement("Granny Knows Best", 1).requirement("Farming", 35)
            .requirement("White ewe (unchecked)", 7).requirement("White ram (unchecked)", 7).requirement("POF bean", 6000)
            .reward("Farming", 9625).build());
        achievements.add(new AchievementBuilder("You Had A Spider", 0.7).requirement("Granny Knows Best", 1).requirement("Farming", 64)
            .requirement("Spider egg (unchecked)", 12).requirement("Araxxi", 710).reward("Farming", 154000).build());
        achievements.add(new AchievementBuilder("You Had A Zygomite", 0.5).requirement("Granny Knows Best", 1).requirement("Farming", 81)
            .requirement("Gloomshroom zygomite (unchecked)", 10).requirement("POF bean", 6000).reward("Farming", 440000).build());
        achievements.add(new AchievementBuilder("You Had A Cow", 0.5).requirement("Granny Knows Best", 1).requirement("Farming", 49)
            .requirement("Kandarin cow (unchecked)", 5).requirement("Bull (unchecked)", 5).requirement("POF bean", 6000)
            .reward("Farming", 27500).build());
        achievements.add(new AchievementBuilder("You Had A Yak", 0.3).requirement("Granny Knows Best", 1).requirement("Farming", 71)
            .requirement("Fremennik yak (unchecked)", 4).requirement("Spirit yak (unchecked)", 2).requirement("POF bean", 6000)
            .reward("Farming", 214500).build());
        achievements.add(new AchievementBuilder("Honourary Dragonkin", 0.3).requirement("Granny Knows Best", 1).requirement("Farming", 92)
            .requirement("Black dragon egg (unchecked)", 2).requirement("POF bean", 6000).reward("Farming", 110000)
            .reward("Black dragonhide", 4).build());
        achievements.add(new AchievementBuilder("You Had A Dragon", 0.9).requirement("Granny Knows Best", 1).requirement("Farming", 92)
            .requirement("Green dragon egg (unchecked)", 2).requirement("Blue dragon egg (unchecked)", 2)
            .requirement("Red dragon egg (unchecked)", 2).requirement("Honourary Dragonkin", 1).reward("Farming", 330000)
            .reward("Green dragonhide", 4).reward("Blue dragonhide", 4).reward("Red dragonhide", 4).build());
        achievements.add(new AchievementBuilder("E-I-E-I-O", 0).requirement("You Had A Chicken", 1).requirement("You Had A Rabbit", 1)
            .requirement("You Had A Chinchompa", 1).requirement("You Had A Sheep", 1).requirement("You Had A Spider", 1)
            .requirement("You Had A Zygomite", 1).requirement("You Had A Cow", 1).requirement("You Had A Yak", 1)
            .requirement("You Had A Dragon", 1).build());
        achievements.add(new AchievementBuilder("Golden Path Challenge", 0.1).requirement("The Jack of Spades", 1).build());
        achievements.add(new AchievementBuilder("Meta-phos", 0).requirement("All Abuzz", 1).requirement("Rock and Roll", 1)
            .requirement("Feline Good", 1).requirement("Golden Path Challenge", 1).requirement("Menaphos Pyramid Scheme", 1).build());
        achievements.add(new AchievementBuilder("Home Away From Home", 0.1).requirement("Setting The Foundation", 1)
            .requirement("Construction", 40).build());
        achievements.add(new AchievementBuilder("Master Builder", 0.75).requirement("Top Town Hall", 1)
            .requirement("Home Away From Home", 1).requirement("Agility", 90).requirement("Anachronia sections", 800)
            .requirement("Hunter", 90).requirement("Big game hunted", 300).requirement("Slayer", 90).requirement("Construction", 90)
            .build());
        achievements.add(new AchievementBuilder("Helping Laniakea", 0.75).build());
        achievements.add(new AchievementBuilder("Leave No Zygomite Buried", 1).requirement("Agility", 85).build());
        achievements.add(new AchievementBuilder("Jurassic Perk", 0.45).requirement("Stacks on Stacks", 1)
            .requirement("Leave No Zygomite Buried", 1).requirement("Anachronia sections", 800).requirement("Big game hunted", 300)
            .requirement("Feral Dinosaur", 404).requirement("Woodcutting", 81).requirement("Helping Laniakea", 1).reward("Woodcutting", 383)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1)
            .lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).lamp(Arrays.asList("Herblore", "Firemaking"), -50, 1).build());
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
            .requirement("Ice Ice Chimpy", 1).requirement("Impressing Char", 1).requirement("Arc - Salty", 1).requirement("E-I-E-I-O", 1)
            .requirement("Ivan is Flailing", 1).requirement("Jack of the Circus", 1).requirement("Kal'gerion Commander", 1)
            .requirement("Lock, Stock and Barrel", 1).requirement("Maria, You Gotta See Her", 1).requirement("Master Angler", 1)
            .requirement("Master Otto", 1).requirement("Master of Assault", 1).requirement("Mazcab Teleport", 1)
            .requirement("Memorialised More Than Once", 1).requirement("Milk of Chocolate, Snape of Grass", 1)
            .requirement("Tales of Nomad (miniquest)", 1).requirement("Nomad's Mirage", 1).requirement("On a Rune High", 1)
            .requirement("Penance to the King", 1).requirement("Perky Like a Prawn", 1).requirement("Desert Slayer Dungeon (miniquest)", 1)
            .requirement("Quiet but Deadly Lore", 1).requirement("Rank: Master Finix", 1).requirement("Scabigail", 1)
            .requirement("Scribbling in the Depths", 1).requirement("Scrolling with Power", 1).requirement("Seagullible", 1)
            .requirement("Shadows Below", 1).requirement("Sheep Shearer (miniquest)", 1)
            .requirement("Tales of the God Wars (miniquest)", 1).requirement("Special Slayer Delivery", 1)
            .requirement("Stone's Throw Away", 1).requirement("Telos If You're Angry II", 1).requirement("To Be a Master", 1)
            .requirement("To the Bone", 1).requirement("White Knight Rises", 1).requirement("Who Will Be Her Lover?", 1)
            .requirement("Witch's Potion (miniquest)", 1).requirement("Work On Your Artisan", 1).requirement("You're Not My Real Mah", 1)
            .requirement("Meta-phos", 1).requirement("Master Builder", 1).requirement("Jurassic Perk", 1).build());
        achievements.add(new AchievementBuilder("Trollheim Teleport", 0).requirement("Law rune", 2).requirement("Fire rune", 2)
            .requirement("Eadgar's Ruse", 1).requirement("Magic", 61).reward("Magic", 68).build());
        achievements.add(new AchievementBuilder("Unionised", 0).requirement("Magic", 80).requirement("Hefin Agility Course laps", 100)
            .encounter(new Encounter("Helwyr")).build());
        achievements.add(new AchievementBuilder("Unlucky for Some", 0.05).build());
        achievements.add(new AchievementBuilder("Untangled", 0).requirement("Sealed clue scroll (elite)", 1).build());
        achievements.add(new AchievementBuilder("Up for Sail", 0).requirement("Coins", 50000).requirement("Fishing", 68).build());
        achievements.add(new AchievementBuilder("Vindictive I", 0).requirement("Vindicta (hard)", 5).reward("Seren reputation", 100)
            .build());
        achievements.add(new AchievementBuilder("Vindictive II", 0).requirement("Vindicta (hard)", 10).build());
        achievements.add(new AchievementBuilder("Vindictive III", 0).requirement("Vindicta (hard)", 25).build());
        achievements.add(new AchievementBuilder("Vindictive IV", 0).requirement("Vindicta (hard)", 50).build());
        achievements.add(new AchievementBuilder("Vindictive V", 0).requirement("Vindicta (hard)", 75).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious I", 0).requirement("Vindicta", 5).reward("Seren reputation", 50)
            .build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious II", 0).requirement("Vindicta", 10).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious III", 0).requirement("Vindicta", 25).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious IV", 0).requirement("Vindicta", 50).build());
        achievements.add(new AchievementBuilder("Vindictive and Vexatious V", 0).requirement("Vindicta", 75).build());
        achievements.add(new AchievementBuilder("We Are Legion", 0).requirement("Legio Primulus", 1).requirement("Legio Quartulus", 1)
            .requirement("Legio Quintulus", 1).requirement("Legio Secundulus", 1).requirement("Legio Sextulus", 1)
            .requirement("Legio Tertiolus", 1).build());
        achievements.add(new AchievementBuilder("Whack a Mole I", 0).requirement("Giant Mole (hard)", 5).build());
        achievements.add(new AchievementBuilder("Whack a Mole II", 0).requirement("Giant Mole (hard)", 10).build());
        achievements.add(new AchievementBuilder("Whack a Mole III", 0).requirement("Giant Mole (hard)", 25).build());
        achievements.add(new AchievementBuilder("Whack a Mole IV", 0).requirement("Giant Mole (hard)", 50).build());
        achievements.add(new AchievementBuilder("Whack a Mole V", 0).requirement("Giant Mole (hard)", 75).build());
        achievements.add(new AchievementBuilder("Whale Food", 0).requirement("K'ril Tsutsaroth", 2521).build());
        achievements.add(new AchievementBuilder("What Year Is It?", 0.1).requirement("Desert Treasure", 1).requirement("Magic", 94)
            .requirement("Blood rune", 198).requirement("Water rune", 495).build());
        achievements.add(new AchievementBuilder("Wheels of Commerce", 0).requirement("Copper ore", 1).reward("Coins", 5).build());
        achievements.add(new AchievementBuilder("Who's Your Daddy?", 0).requirement("The Fremennik Trials", 1)
            .encounter(new Encounter("Vorago", 7)).build());
        achievements.add(new AchievementBuilder("Who's the Boss? I", 0).requirement("Boss kills", 500).build());
        achievements.add(new AchievementBuilder("Who's the Boss? II", 0).requirement("Boss kills", 1000).build());
        achievements.add(new AchievementBuilder("Who's the Boss? III", 0).requirement("Boss kills", 2000).build());
        achievements.add(new AchievementBuilder("Who's the Boss? IV", 0).requirement("Boss kills", 3000).build());
        achievements.add(new AchievementBuilder("Who's the Boss? V", 0).requirement("Boss kills", 4000).build());
        achievements.add(new AchievementBuilder("Who Do Broodoo?", 0.15).encounter(new Encounter("Broodoo victim"))
            .encounter(new Encounter("Broodoo victim")).encounter(new Encounter("Broodoo victim")).build());
        achievements.add(new AchievementBuilder("Wolf Pack", 0).requirement("Magic", 80)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList("Helwyr", "Cywir Alpha", "Cywir Alpha", "Cywir Alpha",
                "Cywir Alpha")))).build());
        achievements.add(new AchievementBuilder("Woodcutting 5", -1).requirement("Woodcutting", 5).build());
        achievements.add(new AchievementBuilder("Woodcutting 10", -1).requirement("Woodcutting", 10).build());
        achievements.add(new AchievementBuilder("Woodcutting 20", -1).requirement("Woodcutting", 20).build());
        achievements.add(new AchievementBuilder("Woodcutting 30", -1).requirement("Woodcutting", 30).build());
        achievements.add(new AchievementBuilder("Woodcutting 40", -1).requirement("Woodcutting", 40).build());
        achievements.add(new AchievementBuilder("Woodcutting 50", -1).requirement("Woodcutting", 50).build());
        achievements.add(new AchievementBuilder("Woodcutting 60", -1).requirement("Woodcutting", 60).build());
        achievements.add(new AchievementBuilder("Woodcutting 70", -1).requirement("Woodcutting", 70).build());
        achievements.add(new AchievementBuilder("Woodcutting 80", -1).requirement("Woodcutting", 80).build());
        achievements.add(new AchievementBuilder("Woodcutting 90", -1).requirement("Woodcutting", 90).build());
        achievements.add(new AchievementBuilder("Woodcutting 92", -1).requirement("Woodcutting", 92).build());
        achievements.add(new AchievementBuilder("Woodcutting 99", -1).requirement("Woodcutting", 99).build());
        achievements.add(new AchievementBuilder("Yak and Ruin I", 0).requirement("Yakamaru", 5).build());
        achievements.add(new AchievementBuilder("Yak and Ruin II", 0).requirement("Yakamaru", 10).build());
        achievements.add(new AchievementBuilder("Yak and Ruin III", 0).requirement("Yakamaru", 25).build());
        achievements.add(new AchievementBuilder("Yak and Ruin IV", 0).requirement("Yakamaru", 50).build());
        achievements.add(new AchievementBuilder("Yak and Ruin V", 0).requirement("Yakamaru", 75).build());
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
        achievements.add(new AchievementBuilder("A Quest for Understanding", 0).requirement("Seiryu", 1)
            .encounter(new Encounter("Astellarn")).build());
        achievements.add(new AchievementBuilder("Aminishi? Completed it, mate.", 0).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("Ahoeitu the Chef (story)")).encounter(new Encounter("Olivia the Chronicler (story)"))
            .encounter(new Encounter("Goku the Unrelenting (story)")).encounter(new Encounter("Sarkhan the Serpentspeaker (story)"))
            .encounter(new Encounter("Xiang the Water-shaper (story)")).encounter(new Encounter("Jade the Unruly (story)"))
            .encounter(new Encounter("Ol' Sawtooth (story)")).encounter(new Encounter("Menaphite Guard Captain (story)"))
            .encounter(new Encounter("Horrific Crassian (story)")).encounter(new Encounter("The Violet Lotus (story)"))
            .encounter(new Encounter("Yukimura of Hanto (story)")).encounter(new Encounter("Arhat Paragon (story)"))
            .encounter(new Encounter("Oyu the Quietest (story)")).build());
        achievements.add(new AchievementBuilder("Crassian en Masse", 0.1).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian")).build());
        achievements.add(new AchievementBuilder("Swift as the Coursing River", 0.2).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian", 3)).encounter(new Encounter("Masuta the Ascended")).build());
        achievements.add(new AchievementBuilder("Malignant Enigmas", 0.3).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian", 3)).encounter(new Encounter("Masuta the Ascended", 3)).build());
        achievements.add(new AchievementBuilder("What Does Monster Examine Say About His Combat Level?", 0.1)
            .requirement("Impressing the Locals", 1).encounter(new Encounter("The Sanctum Guardian (story)", 3))
            .encounter(new Encounter("Goku the Unrelenting (story)")).build());
        achievements.add(new AchievementBuilder("Force of a Great Typhoon", 0.2).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian", 3)).encounter(new Encounter("Masuta the Ascended")).build());
        achievements.add(new AchievementBuilder("Bless You, Seiryu", 0.15).requirement("Impressing the Locals", 1).requirement("Feather", 0)
            .encounter(new Encounter("The Sanctum Guardian (story)", 3)).encounter(new Encounter("Masuta the Ascended (story)", 3))
            .encounter(new Encounter("Seiryu (story)", 3)).build());
        achievements.add(new AchievementBuilder("I'll Pulverise You!", 0.1).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian (story)", 3)).encounter(new Encounter("Masuta the Ascended (story)")).build());
        achievements.add(new AchievementBuilder("The Many Hands That Write", 0.6).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian (story)", 3)).encounter(new Encounter("Masuta the Ascended (story)"))
            .encounter(new Encounter("The Sanctum Guardian (story)", 3)).encounter(new Encounter("Masuta the Ascended (story)"))
            .encounter(new Encounter("The Sanctum Guardian (story)", 3)).encounter(new Encounter("Masuta the Ascended (story)"))
            .encounter(new Encounter("The Sanctum Guardian (story)", 3)).encounter(new Encounter("Masuta the Ascended (story)"))
            .encounter(new Encounter("The Sanctum Guardian (story)", 3)).encounter(new Encounter("Masuta the Ascended (story)"))
            .encounter(new Encounter("The Sanctum Guardian (story)", 3)).encounter(new Encounter("Masuta the Ascended (story)")).build());
        achievements.add(new AchievementBuilder("The Book of Elei", 0.15).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian (story)", 3)).build());
        achievements.add(new AchievementBuilder("Strength of a Raging Fire", 0.2).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian", 3)).encounter(new Encounter("Masuta the Ascended")).build());
        achievements.add(new AchievementBuilder("Arc Reactor", 0.3).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian", 3)).encounter(new Encounter("Masuta the Ascended", 3))
            .encounter(new Encounter("Seiryu")).build());
        achievements.add(new AchievementBuilder("Outflanked 'em in the Sanctum", 0.1).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian")).build());
        achievements.add(new AchievementBuilder("Oops! Wrong Cult!", 0).requirement("Impressing the Locals", 1)
            .requirement("H.A.M. boots", 0).requirement("H.A.M. cloak", 0).requirement("H.A.M. gloves", 0).requirement("H.A.M. hood", 0)
            .requirement("H.A.M. robe", 0).requirement("H.A.M. shirt", 0).build());
        achievements.add(new AchievementBuilder("Here Is My Handle", 0.1).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian")).build());
        achievements.add(new AchievementBuilder("The Purple Dart", 0.2).requirement("Impressing the Locals", 1).requirement("Ranged", 88)
            .requirement("Fletching", 92).requirement("Ancient bones", 1).requirement("Death lotus extract", 1).requirement("Lacquer", 2)
            .requirement("Ascension shard", 25).encounter(new Encounter("The Sanctum Guardian"))
            .encounter(new Encounter("The Violet Lotus")).reward("Fletching", 2750).build());
        achievements.add(new AchievementBuilder("Temple of Aminishi", 0).requirement("Aminishi? Completed it, mate.", 1)
            .requirement("The Many Hands That Write", 1).requirement("The Book of Elei", 1).requirement("Here Is My Handle", 1)
            .requirement("Outflanked 'em in the Sanctum", 1).requirement("Crassian en Masse", 1).requirement("I'll Pulverise You!", 1)
            .requirement("Force of a Great Typhoon", 1).requirement("Swift as the Coursing River", 1).requirement("Arc Reactor", 1)
            .requirement("Strength of a Raging Fire", 1).requirement("Malignant Enigmas", 1).requirement("Bless You, Seiryu", 1)
            .requirement("The Purple Dart", 1).requirement("What Does Monster Examine Say About His Combat Level?", 1)
            .requirement("Oops! Wrong Cult!", 1).build());
        achievements.add(new AchievementBuilder("You Won't Like Me When I'm Sangri", 0).requirement("Strength", 42)
            .encounter(new Encounter("Sangri the Red")).build());
        achievements.add(new AchievementBuilder("Smoulders and Skully", 0.1).requirement("Coins", 550000)
            .requirement("Abyss (miniquest)", 1).encounter(new Encounter("Astellarn", 3)).encounter(new Encounter("Smoulders")).build());
        achievements.add(new AchievementBuilder("Elder Souls", 0.1).requirement("The Light Within", 1).requirement("Prayer", 87)
            .encounter(new Encounter("Astellarn", 3)).encounter(new Encounter("Emberbound Soul")).build());
        achievements.add(new AchievementBuilder("Four in Hand", 0.3).encounter(new Encounter("Astellarn", 3))
            .encounter(new Encounter("Verak Lith", 3)).encounter(new Encounter("Black Stone Dragon")).build());
        achievements.add(new AchievementBuilder("Spiderlogical Warfare", 0).requirement("Spider leg", 0)
            .encounter(new Encounter("Spyndra")).build());
        achievements.add(new AchievementBuilder("Dragon Ink", 0.7).encounter(new Encounter("Astellarn (story)"))
            .encounter(new Encounter("Astellarn (story)")).encounter(new Encounter("Astellarn (story)"))
            .encounter(new Encounter("Astellarn (story)")).encounter(new Encounter("Astellarn (story)"))
            .encounter(new Encounter("Astellarn (story)")).encounter(new Encounter("Astellarn (story)"))
            .encounter(new Encounter("Verak Lith (story)")).encounter(new Encounter("Verak Lith (story)"))
            .encounter(new Encounter("Verak Lith (story)")).encounter(new Encounter("Verak Lith (story)"))
            .encounter(new Encounter("Verak Lith (story)")).encounter(new Encounter("Verak Lith (story)"))
            .encounter(new Encounter("Verak Lith (story)")).build());
        achievements.add(new AchievementBuilder("Get Back, Hand!", 0.15).requirement("Attack", 15)
            .encounter(new Encounter("Astellarn (story)", 3)).encounter(new Encounter("Verak Lith (story)", 3))
            .encounter(new Encounter("Black Stone Dragon (story)", 3)).build());
        achievements.add(new AchievementBuilder("Chill Out, Bro!", 0.05).requirement("Magic", 81).build());
        achievements.add(new AchievementBuilder("Shadow Wave", 0.15).encounter(new Encounter("Astellarn (story)", 3))
            .encounter(new Encounter("Verak Lith (story)", 3)).encounter(new Encounter("Black Stone Dragon (story)", 3)).build());
        achievements.add(new AchievementBuilder("We Will Fight in the Shade", 0.1).encounter(new Encounter("Astellarn", 3)).build());
        achievements.add(new AchievementBuilder("Dragonhide Infanticide", 0.2).encounter(new Encounter("Astellarn", 3))
            .encounter(new Encounter("Verak Lith")).build());
        achievements.add(new AchievementBuilder("Not a Moth", 0.3).encounter(new Encounter("Astellarn", 3))
            .encounter(new Encounter("Verak Lith", 3)).encounter(new Encounter("Black Stone Dragon")).build());
        achievements.add(new AchievementBuilder("Psychedelic Relics", 0).requirement("Seiryu", 10).requirement("Black Stone Dragon", 10)
            .build());
        achievements.add(new AchievementBuilder("Tactless Analysis", 0.15).requirement("Magic", 33).requirement("Law rune", 1)
            .requirement("Air rune", 1).encounter(new Encounter("Astellarn (story)", 3)).encounter(new Encounter("Verak Lith (story)", 3))
            .build());
        achievements.add(new AchievementBuilder("Goopy Bloop Boop", 0).requirement("Strength", 3).build());
        achievements.add(new AchievementBuilder("Broodmother", 0.2).encounter(new Encounter("Astellarn", 3))
            .encounter(new Encounter("Verak Lith")).build());
        achievements.add(new AchievementBuilder("Elite Dungeons and Dragons", 0.15).encounter(new Encounter("Spyndra (story)"))
            .encounter(new Encounter("Dragon wolf alpha (story)")).encounter(new Encounter("Giant slime (story)"))
            .encounter(new Encounter("Shul the Molten (story)")).encounter(new Encounter("Smoulders (story)"))
            .encounter(new Encounter("Deathbreath (story)")).encounter(new Encounter("Firebelly (story)"))
            .encounter(new Encounter("Elegorn the Celestial (story)")).encounter(new Encounter("Emberbound Soul (story)"))
            .encounter(new Encounter("Alanogard the Black (story)")).encounter(new Encounter("Engorged lava strykewyrm (story)"))
            .encounter(new Encounter("Sangri the Red (story)")).encounter(new Encounter("Verak Little (story)")).build());
        achievements.add(new AchievementBuilder("Ebony and Irony", 0.1).requirement("Defence", 60).requirement("Black dragonhide shield", 1)
            .encounter(new Encounter("Astellarn (story)")).encounter(new Encounter("Alanogard the Black (story)")).build());
        achievements.add(new AchievementBuilder("Dragonkin Laboratory", 0).requirement("Elite Dungeons and Dragons", 1)
            .requirement("Dragon Ink", 1).requirement("Tactless Analysis", 1).requirement("We Will Fight in the Shade", 1)
            .requirement("A Quest for Understanding", 1).requirement("Broodmother", 1).requirement("Dragonhide Infanticide", 1)
            .requirement("Get Back, Hand!", 1).requirement("Shadow Wave", 1).requirement("Not a Moth", 1).requirement("Four in Hand", 1)
            .requirement("Goopy Bloop Boop", 1).requirement("You Won't Like Me When I'm Sangri", 1).requirement("Smoulders and Skully", 1)
            .requirement("Psychedelic Relics", 1).requirement("Chill Out, Bro!", 1).requirement("Spiderlogical Warfare", 1)
            .requirement("Elder Souls", 1).requirement("Ebony and Irony", 1).build());
        achievements.add(new AchievementBuilder("Hail Hydra", 0.05).requirement("Magic", 94).requirement("Desert Treasure", 1)
            .requirement("Blood rune", 2).requirement("Water rune", 5).build());
        achievements.add(new AchievementBuilder("I've Got Your Face", 0.1).encounter(new Encounter("The Crassian Leviathan (story)", 3))
            .encounter(new Encounter("Quetzathog")).requirement("Black mask (10)", 0).build());
        achievements.add(new AchievementBuilder("Harassing the Crassian", 0.1).encounter(new Encounter("The Crassian Leviathan")).build());
        achievements.add(new AchievementBuilder("Clenched", 0.3).encounter(new Encounter("The Crassian Leviathan", 3))
            .encounter(new Encounter("Taraket the Necromancer", 3)).encounter(new Encounter("The Ambassador")).build());
        achievements.add(new AchievementBuilder("Happy Trails", 0.3).encounter(new Encounter("The Crassian Leviathan", 3))
            .encounter(new Encounter("Taraket the Necromancer", 3)).encounter(new Encounter("The Ambassador")).build());
        achievements.add(new AchievementBuilder("Get Shredded", 0.1).encounter(new Encounter("The Crassian Leviathan")).build());
        achievements.add(new AchievementBuilder("She Smells Sea Smells by the Sea Floor", 0.1).requirement("Great maki", 0)
            .encounter(new Encounter("The Crassian Leviathan (story)", 3)).build());
        achievements.add(new AchievementBuilder("I'm the Masuta Now", 0.15).encounter(new Encounter("The Crassian Leviathan", 3))
            .encounter(new Encounter("Masuta the Descended")).requirement("Masuta's warspear", 0).requirement("Attack", 82).build());
        achievements.add(new AchievementBuilder("Tank and Spank", 0.2).encounter(new Encounter("The Crassian Leviathan", 3))
            .encounter(new Encounter("Taraket the Necromancer", 3)).build());
        achievements.add(new AchievementBuilder("Instability Never Phased Me", 0.3).encounter(new Encounter("The Crassian Leviathan", 3))
            .encounter(new Encounter("Taraket the Necromancer", 3)).encounter(new Encounter("The Ambassador", 3)).build());
        achievements.add(new AchievementBuilder("Monkey Sadness", 0).encounter(new Encounter(Collections.singletonList(Arrays.asList(
            "Bossy McBossFace", "Bossy McBossFace's First mate")))).build());
        achievements.add(new AchievementBuilder("Crawfish Boil", 0.15).encounter(new Encounter("The Crassian Leviathan (story)", 3))
            .encounter(new Encounter("Taraket the Necromancer (story)", 3)).encounter(new Encounter("The Ambassador (story)")).build());
        achievements.add(new AchievementBuilder("Hydra Halitosis", 0.1).encounter(new Encounter("The Crassian Leviathan")).build());
        achievements.add(new AchievementBuilder("Kraken the Whip", 0.1).encounter(new Encounter("The Crassian Leviathan (story)", 3))
            .encounter(new Encounter("Taraket the Necromancer (story)", 3)).encounter(new Encounter("Boggoth (story)"))
            .requirement("Abyssal whip", 1).requirement("Wyrm spike", 0).build());
        achievements.add(new AchievementBuilder("Dextrous Crystal", 0.2).encounter(new Encounter("The Crassian Leviathan", 3))
            .encounter(new Encounter("Taraket the Necromancer")).build());
        achievements.add(new AchievementBuilder("Sinister Crystal", 0.2).encounter(new Encounter("The Crassian Leviathan", 3))
            .encounter(new Encounter("Taraket the Necromancer")).build());
        achievements.add(new AchievementBuilder("The Black Stone Trilogy", 0.9).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian", 3)).encounter(new Encounter("Masuta the Ascended", 3))
            .encounter(new Encounter("Seiryu", 3)).encounter(new Encounter("Astellarn", 3))
            .encounter(new Encounter("Verak Lith", 3)).encounter(new Encounter("Black Stone Dragon", 3))
            .encounter(new Encounter("The Crassian Leviathan", 3)).encounter(new Encounter("Taraket the Necromancer", 3))
            .encounter(new Encounter("The Ambassador", 3)).build());
        achievements.add(new AchievementBuilder("Demon Duty", 0.2).requirement("Slayer", 90).requirement("Combat", 110)
            .encounter(new Encounter("The Crassian Leviathan", 3)).encounter(new Encounter("Yor'Ger the Deceiver")).build());
        achievements.add(new AchievementBuilder("Of Kraken Ink", 0.7).encounter(new Encounter("The Crassian Leviathan (story)"))
            .encounter(new Encounter("The Crassian Leviathan (story)")).encounter(new Encounter("The Crassian Leviathan (story)"))
            .encounter(new Encounter("The Crassian Leviathan (story)")).encounter(new Encounter("The Crassian Leviathan (story)"))
            .encounter(new Encounter("The Crassian Leviathan (story)")).encounter(new Encounter("The Crassian Leviathan (story)"))
            .encounter(new Encounter("Taraket the Necromancer (story)")).encounter(new Encounter("Taraket the Necromancer (story)"))
            .encounter(new Encounter("Taraket the Necromancer (story)")).encounter(new Encounter("Taraket the Necromancer (story)"))
            .encounter(new Encounter("Taraket the Necromancer (story)")).encounter(new Encounter("Taraket the Necromancer (story)"))
            .encounter(new Encounter("Taraket the Necromancer (story)")).build());
        achievements.add(new AchievementBuilder("Island Getaway", 0).requirement("Strength", 3).encounter(new Encounter("Hanto")).build());
        achievements.add(new AchievementBuilder("Unworthy Dead", 0.1).encounter(new Encounter("The Crassian Leviathan (story)", 3))
            .encounter(new Encounter("Taraket the Necromancer (story)")).build());
        achievements.add(new AchievementBuilder("Griefing the Reef", 0).encounter(new Encounter("Hanto (story)"))
            .encounter(new Encounter("Boggoth (story)")).encounter(new Encounter("Ulthven Keith (story)"))
            .encounter(new Encounter("Bossy McBossFace (story)")).encounter(new Encounter("Cooper (story)"))
            .encounter(new Encounter("Lady Himiko (story)")).encounter(new Encounter("Shrine Maiden Elei (story)"))
            .encounter(new Encounter("Quetzathog (story)")).encounter(new Encounter("Tombi, Khan of Thalassia (story)"))
            .encounter(new Encounter("Yor'Ger the Deceiver (story)")).encounter(new Encounter("Oreb, the Magister (story)"))
            .encounter(new Encounter("Black Stone Scuttler (story)")).encounter(new Encounter("Masuta the Descended (story)"))
            .encounter(new Encounter("Maw of Kolthregar (story)")).encounter(new Encounter("Hand of Dagnath (story)"))
            .encounter(new Encounter("Eye of Cythan (story)")).build());
        achievements.add(new AchievementBuilder("Shadow Reef", 0).requirement("Griefing the Reef", 1).requirement("Of Kraken Ink", 1)
            .requirement("Umbral Diplomacy", 1).requirement("Hail Hydra", 1).requirement("Hydra Halitosis", 1)
            .requirement("Get Shredded", 1).requirement("Harassing the Crassian", 1).requirement("Sinister Crystal", 1)
            .requirement("Dextrous Crystal", 1).requirement("Tank and Spank", 1).requirement("Unworthy Dead", 1).requirement("Clenched", 1)
            .requirement("Happy Trails", 1).requirement("Instability Never Phased Me", 1).requirement("Crawfish Boil", 1)
            .requirement("Island Getaway", 1).requirement("Kraken the Whip", 1).requirement("She Smells Sea Smells by the Sea Floor", 1)
            .requirement("I've Got Your Face", 1).requirement("Demon Duty", 1).requirement("I'm the Masuta Now", 1)
            .requirement("Monkey Sadness", 1).requirement("The Black Stone Trilogy", 1).requirement("A Mini Shipment", 1).build());
        achievements.add(new AchievementBuilder("The Elite", 0).requirement("Temple of Aminishi", 1).requirement("Dragonkin Laboratory", 1)
            .requirement("Shadow Reef", 1).build());
        achievements.add(new AchievementBuilder("Animal Whisperer", 2).requirement("Granny Knows Best", 1).reward("Farming", 500).build());
        achievements.add(new AchievementBuilder("If your colours were like my dreams", 0.3).requirement("Summoning", 89)
            .requirement("Combat", 35).requirement("Spirit shards", 3292).requirement("Blue charm", 24).requirement("Pouch", 24)
            .requirement("Raw rat meat", 1).requirement("Potato cactus", 1).requirement("Chinchompa", 1).requirement("Bronze bar", 1)
            .requirement("Iron bar", 1).requirement("Jug of water", 1).requirement("Steel bar", 1).requirement("Graahk fur", 1)
            .requirement("Kyatt fur", 1).requirement("Larupia fur", 1).requirement("Fishbowl", 1).requirement("Mithril bar", 1)
            .requirement("Obsidian charm", 2).requirement("Adamant bar", 1).requirement("Fire talisman", 1).requirement("Water talisman", 2)
            .requirement("Air talisman", 1).requirement("Rune bar", 1).requirement("Earth talisman", 1)
            .requirement("Truthful shadow core", 4).reward("Summoning", 11589).reward("Albino rat pouch", 1)
            .reward("Spirit kalphite pouch", 1).reward("Giant chinchompa pouch", 1).reward("Void shifter pouch", 1)
            .reward("Void spinner pouch", 1).reward("Void torcher pouch", 1).reward("Bronze minotaur pouch", 1)
            .reward("Iron minotaur pouch", 1).reward("Spirit jelly pouch", 1).reward("Steel minotaur pouch", 1)
            .reward("Spirit graahk pouch", 1).reward("Spirit kyatt pouch", 1).reward("Spirit larupia pouch", 1)
            .reward("Karam. overlord pouch", 1).reward("Mithril minotaur pouch", 1).reward("Obsidian golem pouch", 1)
            .reward("Adamant minotaur pouch", 1).reward("Fire titan pouch", 1).reward("Ice titan pouch", 1).reward("Moss titan pouch", 1)
            .reward("Lava titan pouch", 1).reward("Rune minotaur pouch", 1).reward("Light creature pouch", 1)
            .reward("Geyser titan pouch", 1).build());
        achievements.add(new AchievementBuilder("Pulling on the Threads", 0.5).requirement("The Needle Skips", 1)
            .lamp(Player.ALL_SKILLS, -2, 1).lamp(Player.ALL_SKILLS, -4, 1).build());
        achievements.add(new AchievementBuilder("Bad Egg", 0.3).requirement("Granny Knows Best", 1).requirement("Farming", 28)
            .requirement("Chicken egg (unchecked)", 2).requirement("POF bean", 6000).reward("Farming", 2500).build());
        achievements.add(new AchievementBuilder("Barooooo!", 0).requirement("Granny Knows Best", 1).requirement("The Fremennik Trials", 1)
            .requirement("Yak", 2080).reward("Fremennik yak (unchecked)", 1).build());
        achievements.add(new AchievementBuilder("Bean Counter I", 0).requirement("POF bean", 1000).build());
        achievements.add(new AchievementBuilder("Bean Counter II", 0).requirement("POF bean", 10000).build());
        achievements.add(new AchievementBuilder("Bean Counter III", 0).requirement("POF bean", 100000).build());
        achievements.add(new AchievementBuilder("Bean Counter IV", 0).requirement("POF bean", 1000000).build());
        achievements.add(new AchievementBuilder("Benedict's World Tour, part 1", 0.15).requirement("Stolen Hearts", 1)
            .lamp(Player.ALL_SKILLS, -1, 1).lamp(Player.ALL_SKILLS, -1, 1).lamp(Player.ALL_SKILLS, -4, 1).build());
        achievements.add(new AchievementBuilder("Benedict's World Tour, part 2", 0.1).requirement("Benedict's World Tour, part 1", 1)
            .lamp(Player.ALL_SKILLS, -1, 1).lamp(Player.ALL_SKILLS, -1, 1).lamp(Player.ALL_SKILLS, -4, 1).build());
        achievements.add(new AchievementBuilder("Benedict's World Tour (miniquest)", 0).requirement("Benedict's World Tour, part 2", 1)
            .build());
        achievements.add(new AchievementBuilder("Besting the Celestial I", 0).requirement("Astellarn group kills", 5).build());
        achievements.add(new AchievementBuilder("Besting the Celestial II", 0).requirement("Astellarn group kills", 10).build());
        achievements.add(new AchievementBuilder("Besting the Celestial III", 0).requirement("Astellarn group kills", 25).build());
        achievements.add(new AchievementBuilder("Besting the Celestial IV", 0).requirement("Astellarn group kills", 50).build());
        achievements.add(new AchievementBuilder("Besting the Celestial V", 0).requirement("Astellarn group kills", 75).build());
        achievements.add(new AchievementBuilder("Besting the Celestial VI", 0).requirement("Astellarn group kills", 100).build());
        achievements.add(new AchievementBuilder("Besting the Celestial Solo Kills I", 0).requirement("Astellarn solo kills", 5).build());
        achievements.add(new AchievementBuilder("Besting the Celestial Solo Kills II", 0).requirement("Astellarn solo kills", 10).build());
        achievements.add(new AchievementBuilder("Besting the Celestial Solo Kills III", 0).requirement("Astellarn solo kills", 25).build());
        achievements.add(new AchievementBuilder("Besting the Celestial Solo Kills IV", 0).requirement("Astellarn solo kills", 50).build());
        achievements.add(new AchievementBuilder("Besting the Celestial Solo Kills V", 0).requirement("Astellarn solo kills", 75).build());
        achievements.add(new AchievementBuilder("Besting the Celestial Solo Kills VI", 0).requirement("Astellarn solo kills", 100).build());
        achievements.add(new AchievementBuilder("Blow Out the Cobwebs", 0).requirement("Super invention (1)", 1).reward("Vial", 1).build());
        achievements.add(new AchievementBuilder("The Ravensworn", 0.5).requirement("Plague's End", 1).build());
        achievements.add(new AchievementBuilder("Chickensworn", 0.1).requirement("The Ravensworn", 1).requirement("Granny Knows Best", 1)
            .requirement("Farming", 28).requirement("Chicken egg (unchecked)", 2).requirement("POF bean", 6000).reward("Farming", 2750)
            .build());
        achievements.add(new AchievementBuilder("Chinchompasworn", 0.1).requirement("The Ravensworn", 1).requirement("Granny Knows Best", 1)
            .requirement("Grey chinchompa (unchecked)", 2).requirement("POF bean", 6000).requirement("Farming", 54).reward("Farming", 33000)
            .build());
        achievements.add(new AchievementBuilder("Claiming the Knight's Experience", 0).requirement("The Knight's Sword", 1)
            .reward("Smithing", 12725).build());
        achievements.add(new AchievementBuilder("Cowsworn", 0.2).requirement("The Ravensworn", 1).requirement("Granny Knows Best", 1)
            .requirement("Kandarin cow (unchecked)", 1).requirement("Bull (unchecked)", 1).requirement("POF bean", 6000)
            .requirement("Farming", 49).reward("Farming", 5500).build());
        achievements.add(new AchievementBuilder("Crabtivating I", 0).requirement("The Sanctum Guardian group kills", 5).build());
        achievements.add(new AchievementBuilder("Crabtivating II", 0).requirement("The Sanctum Guardian group kills", 10).build());
        achievements.add(new AchievementBuilder("Crabtivating III", 0).requirement("The Sanctum Guardian group kills", 25).build());
        achievements.add(new AchievementBuilder("Crabtivating IV", 0).requirement("The Sanctum Guardian group kills", 50).build());
        achievements.add(new AchievementBuilder("Crabtivating V", 0).requirement("The Sanctum Guardian group kills", 75).build());
        achievements.add(new AchievementBuilder("Crabtivating VI", 0).requirement("The Sanctum Guardian group kills", 100).build());
        achievements.add(new AchievementBuilder("Crabtivating Solo Kills I", 0).requirement("The Sanctum Guardian solo kills", 5).build());
        achievements.add(new AchievementBuilder("Crabtivating Solo Kills II", 0).requirement("The Sanctum Guardian solo kills", 10)
            .build());
        achievements.add(new AchievementBuilder("Crabtivating Solo Kills III", 0).requirement("The Sanctum Guardian solo kills", 25)
            .build());
        achievements.add(new AchievementBuilder("Crabtivating Solo Kills IV", 0).requirement("The Sanctum Guardian solo kills", 50)
            .build());
        achievements.add(new AchievementBuilder("Crabtivating Solo Kills V", 0).requirement("The Sanctum Guardian solo kills", 75).build());
        achievements.add(new AchievementBuilder("Crabtivating Solo Kills VI", 0).requirement("The Sanctum Guardian solo kills", 100)
            .build());
        achievements.add(new AchievementBuilder("Memory-storage bot (Aagi)", 0).requirement("Lustrous hall memories", 250)
            .reward("Divination", 10000).build());
        achievements.add(new AchievementBuilder("Memory-storage bot (Seren)", 0).requirement("Brilliant hall memories", 250)
            .requirement("Memory-storage bot (Aagi)", 1).reward("Divination", 20000).build());
        achievements.add(new AchievementBuilder("Memory-storage bot (Juna)", 0).requirement("Radiant hall memories", 250)
            .requirement("Memory-storage bot (Seren)", 1).reward("Divination", 30000).build());
        achievements.add(new AchievementBuilder("Memory-storage bot (Edicts)", 0).requirement("Luminous hall memories", 250)
            .requirement("Memory-storage bot (Juna)", 1).reward("Divination", 40000).build());
        achievements.add(new AchievementBuilder("Data Recovery", 0).requirement("Incandescent hall memories", 250)
            .requirement("Memory-storage bot (Edicts)", 1).reward("Divination", 50000).build());
        achievements.add(new AchievementBuilder("Died by the Blade", 0.1).requirement("Impressing the Locals", 1)
            .encounter(new Encounter("The Sanctum Guardian", 3)).build());
        achievements.add(new AchievementBuilder("Bisdi", 0).requirement("Black Stone Dragon solo kills", 130)
            .requirement("Ambassador group kills", 1).build());
        achievements.add(new AchievementBuilder("Dragonkin Swag", 0).requirement("Dragon Ink", 1).requirement("Bisdi", 1)
            .requirement("Verak Lith group kills", 173).requirement("Astellarn group kills", 173)
            .requirement("Black Stone Dragon group kills", 173).build());
        achievements.add(new AchievementBuilder("Dragonsworn", 0.1).requirement("The Ravensworn", 1).requirement("Granny Knows Best", 1)
            .requirement("Green dragon egg (unchecked)", 2).requirement("POF bean", 6000).requirement("Farming", 92)
            .reward("Farming", 220000).build());
        achievements.add(new AchievementBuilder("Ever So Clever", 0.1).requirement("Gloomshroom zygomite (unchecked)", 2)
            .requirement("Farming", 81).requirement("POF bean", 13000).reward("Farming", 88000).build());
        achievements.add(new AchievementBuilder("Guthix and the Chamber of Secrets", 0).requirement("Data Recovery", 1).build());
        achievements.add(new AchievementBuilder("I Hardly Manure", 0.05).requirement("Granny Knows Best", 1).requirement("Farming", 49)
            .requirement("Construction", 60).requirement("Bull (unchecked)", 1).reward("Farming", 1000).build());
        achievements.add(new AchievementBuilder("I know, I was there...", 0).requirement("Ritual of the Mahjarrat", 1).build());
        achievements.add(new AchievementBuilder("In a Pickle", 0).requirement("Icthlarin's Little Helper", 1).build());
        achievements.add(new AchievementBuilder("Life, Uh, Found a Way", 0.3).requirement("Granny Knows Best", 1)
            .requirement("Farming", 28).requirement("Chicken egg (unchecked)", 2).requirement("POF bean", 6500).reward("Farming", 2500)
            .build());
        achievements.add(new AchievementBuilder("Masuta Master I", 0).requirement("Masuta the Ascended group kills", 5).build());
        achievements.add(new AchievementBuilder("Masuta Master II", 0).requirement("Masuta the Ascended group kills", 10).build());
        achievements.add(new AchievementBuilder("Masuta Master III", 0).requirement("Masuta the Ascended group kills", 25).build());
        achievements.add(new AchievementBuilder("Masuta Master IV", 0).requirement("Masuta the Ascended group kills", 50).build());
        achievements.add(new AchievementBuilder("Masuta Master V", 0).requirement("Masuta the Ascended group kills", 75).build());
        achievements.add(new AchievementBuilder("Masuta Master VI", 0).requirement("Masuta the Ascended group kills", 100).build());
        achievements.add(new AchievementBuilder("Masuta Master Solo Kills I", 0).requirement("Masuta the Ascended solo kills", 5).build());
        achievements.add(new AchievementBuilder("Masuta Master Solo Kills II", 0).requirement("Masuta the Ascended solo kills", 10)
            .build());
        achievements.add(new AchievementBuilder("Masuta Master Solo Kills III", 0).requirement("Masuta the Ascended solo kills", 25)
            .build());
        achievements.add(new AchievementBuilder("Masuta Master Solo Kills IV", 0).requirement("Masuta the Ascended solo kills", 50)
            .build());
        achievements.add(new AchievementBuilder("Masuta Master Solo Kills V", 0).requirement("Masuta the Ascended solo kills", 75).build());
        achievements.add(new AchievementBuilder("Masuta Master Solo Kills VI", 0).requirement("Masuta the Ascended solo kills", 100)
            .build());
        achievements.add(new AchievementBuilder("Meeting your Idols", 0.25).requirement("Woodcutting", 81).reward("Woodcutting", 20000)
            .build());
        achievements.add(new AchievementBuilder("Perk Out!", 0.45).requirement("Farm totems", 1).requirement("Farming", 71)
            .requirement("Construction", 60).requirement("Chicken egg (unchecked)", 2).requirement("Common brown rabbit (unchecked)", 1)
            .requirement("White ram (unchecked)", 1).requirement("White ewe (unchecked)", 1).requirement("Spider egg (unchecked)", 1)
            .requirement("Kandarin cow (unchecked)", 1).requirement("Bull (unchecked)", 1).requirement("Fremennik yak (unchecked)", 1)
            .reward("Farming", 98000).build());
        achievements.add(new AchievementBuilder("Perk Up!", 1.8).requirement("Farm totems", 1).requirement("Farming", 71)
            .requirement("Construction", 60).requirement("Chicken egg (unchecked)", 4).requirement("White ram (unchecked)", 2)
            .requirement("White ewe (unchecked)", 2).requirement("Kandarin cow (unchecked)", 2).requirement("Bull (unchecked)", 2)
            .reward("Farming", 35000).build());
        achievements.add(new AchievementBuilder("Pilferin' in Asgarnia", 0.25).requirement("Count All Light Fingers", 1)
            .requirement("The Death of Chivalry", 1).requirement("Thieving", 76).reward("Thieving", 71000).build());
        achievements.add(new AchievementBuilder("Pilferin' in Kandarin", 0.2).requirement("Count All Light Fingers", 1)
            .requirement("Thieving", 83).reward("Thieving", 80000).build());
        achievements.add(new AchievementBuilder("Pilferin' in Kharidian Desert", 0.3).requirement("Count All Light Fingers", 1)
            .requirement("Thieving", 69).requirement("Menaphos reputation", 240000).reward("Thieving", 53000).build());
        achievements.add(new AchievementBuilder("Pilferin' in Misthalin", 0.25).requirement("Count All Light Fingers", 1)
            .requirement("Thieving", 65).requirement("Lockpick", 0).reward("Thieving", 32000).build());
        achievements.add(new AchievementBuilder("Pilferin' the hidden ones", 0.3).requirement("Count All Light Fingers", 1)
            .requirement("The Curse of Arrav", 1).requirement("Lost City", 1).requirement("Thieving", 96).reward("Thieving", 128000)
            .build());
        achievements.add(new AchievementBuilder("Rabbit, Rabbit, Rabbit", 0).requirement("Granny Knows Best", 1)
            .requirement("Common brown rabbit (unchecked)", 9).build());
        achievements.add(new AchievementBuilder("Rabbitsworn", 0.1).requirement("The Ravensworn", 1).requirement("Granny Knows Best", 1)
            .requirement("Common brown rabbit (unchecked)", 2).requirement("POF bean", 6000).reward("Farming", 550).build());
        achievements.add(new AchievementBuilder("Raiders of the Lost Arc", 0).requirement("The Many Hands That Write", 1)
            .requirement("Kuroryu", 1).build());
        achievements.add(new AchievementBuilder("Ram-bow", 0.25).requirement("Granny Knows Best", 1).requirement("Farming", 35)
            .requirement("White ewe (unchecked)", 1).requirement("White ram (unchecked)", 1).requirement("Four Seasons", 1)
            .reward("Farming", 1375).build());
        achievements.add(new AchievementBuilder("Sheepsworn", 0.1).requirement("The Ravensworn", 1).requirement("Granny Knows Best", 1)
            .requirement("White ewe (unchecked)", 1).requirement("White ram (unchecked)", 1).requirement("POF bean", 6000)
            .requirement("Farming", 35).reward("Farming", 1375).build());
        achievements.add(new AchievementBuilder("Slay-ryu I", 0).requirement("Seiryu group kills", 5).build());
        achievements.add(new AchievementBuilder("Slay-ryu II", 0).requirement("Seiryu group kills", 10).build());
        achievements.add(new AchievementBuilder("Slay-ryu III", 0).requirement("Seiryu group kills", 25).build());
        achievements.add(new AchievementBuilder("Slay-ryu IV", 0).requirement("Seiryu group kills", 50).build());
        achievements.add(new AchievementBuilder("Slay-ryu V", 0).requirement("Seiryu group kills", 75).build());
        achievements.add(new AchievementBuilder("Slay-ryu VI", 0).requirement("Seiryu group kills", 100).build());
        achievements.add(new AchievementBuilder("Slay-ryu Solo Kills I", 0).requirement("Seiryu solo kills", 5).build());
        achievements.add(new AchievementBuilder("Slay-ryu Solo Kills II", 0).requirement("Seiryu solo kills", 10).build());
        achievements.add(new AchievementBuilder("Slay-ryu Solo Kills III", 0).requirement("Seiryu solo kills", 25).build());
        achievements.add(new AchievementBuilder("Slay-ryu Solo Kills IV", 0).requirement("Seiryu solo kills", 50).build());
        achievements.add(new AchievementBuilder("Slay-ryu Solo Kills V", 0).requirement("Seiryu solo kills", 75).build());
        achievements.add(new AchievementBuilder("Slay-ryu Solo Kills VI", 0).requirement("Seiryu solo kills", 100).build());
        achievements.add(new AchievementBuilder("So-lacking in drops", 0).requirement("Solak", 943).build());
        achievements.add(new AchievementBuilder("Spidersworn", 0.1).requirement("The Ravensworn", 1).requirement("Granny Knows Best", 1)
            .requirement("Spider egg (unchecked)", 2).requirement("POF bean", 6000).requirement("Farming", 64).reward("Farming", 22000)
            .build());
        achievements.add(new AchievementBuilder("Superiority Complex I", 0).requirement("Verak Lith group kills", 5).build());
        achievements.add(new AchievementBuilder("Superiority Complex II", 0).requirement("Verak Lith group kills", 10).build());
        achievements.add(new AchievementBuilder("Superiority Complex III", 0).requirement("Verak Lith group kills", 25).build());
        achievements.add(new AchievementBuilder("Superiority Complex IV", 0).requirement("Verak Lith group kills", 50).build());
        achievements.add(new AchievementBuilder("Superiority Complex V", 0).requirement("Verak Lith group kills", 75).build());
        achievements.add(new AchievementBuilder("Superiority Complex VI", 0).requirement("Verak Lith group kills", 100).build());
        achievements.add(new AchievementBuilder("Superiority Complex Solo Kills I", 0).requirement("Verak Lith solo kills", 5).build());
        achievements.add(new AchievementBuilder("Superiority Complex Solo Kills II", 0).requirement("Verak Lith solo kills", 10).build());
        achievements.add(new AchievementBuilder("Superiority Complex Solo Kills III", 0).requirement("Verak Lith solo kills", 25).build());
        achievements.add(new AchievementBuilder("Superiority Complex Solo Kills IV", 0).requirement("Verak Lith solo kills", 50).build());
        achievements.add(new AchievementBuilder("Superiority Complex Solo Kills V", 0).requirement("Verak Lith solo kills", 75).build());
        achievements.add(new AchievementBuilder("Superiority Complex Solo Kills VI", 0).requirement("Verak Lith solo kills", 100).build());
        achievements.add(new AchievementBuilder("The Archivist", 0).requirement("Data Recovery", 1)
            .requirement("Lustrous hall memories", 2500).requirement("Brilliant hall memories", 2500)
            .requirement("Radiant hall memories", 2500).requirement("Luminous hall memories", 2500)
            .requirement("Incandescent hall memories", 2500).reward("Divination", 500000).build());
        achievements.add(new AchievementBuilder("The world is a safe place", 0).requirement("Pilferin' in Asgarnia", 1)
            .requirement("Pilferin' in Kandarin", 1).requirement("Pilferin' in Kharidian Desert", 1)
            .requirement("Pilferin' in Misthalin", 1).requirement("Pilferin' the hidden ones", 1).build());
        achievements.add(new AchievementBuilder("Tickety Boom!", 0.05).requirement("Farming", 64).requirement("Construction", 20)
            .requirement("Grey chinchompa (unchecked)", 1).requirement("POF bean", 6000).build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon I", 0).requirement("Black Stone Dragon group kills", 5).build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon II", 0).requirement("Black Stone Dragon group kills", 10).build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon III", 0).requirement("Black Stone Dragon group kills", 25).build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon IV", 0).requirement("Black Stone Dragon group kills", 50).build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon V", 0).requirement("Black Stone Dragon group kills", 75).build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon VI", 0).requirement("Black Stone Dragon group kills", 100).build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon Solo Kills I", 0).requirement("Black Stone Dragon solo kills", 5)
            .build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon Solo Kills II", 0).requirement("Black Stone Dragon solo kills", 10)
            .build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon Solo Kills III", 0).requirement("Black Stone Dragon solo kills", 25)
            .build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon Solo Kills IV", 0).requirement("Black Stone Dragon solo kills", 50)
            .build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon Solo Kills V", 0).requirement("Black Stone Dragon solo kills", 75)
            .build());
        achievements.add(new AchievementBuilder("Whack Stone Dragon Solo Kills VI", 0).requirement("Black Stone Dragon solo kills", 100)
            .build());
        achievements.add(new AchievementBuilder("Wood Kill Again I", 0).requirement("Solak", 5).build());
        achievements.add(new AchievementBuilder("Wood Kill Again II", 0).requirement("Solak", 10).build());
        achievements.add(new AchievementBuilder("Wood Kill Again III", 0).requirement("Solak", 25).build());
        achievements.add(new AchievementBuilder("Wood Kill Again IV", 0).requirement("Solak", 50).build());
        achievements.add(new AchievementBuilder("Wood Kill Again V", 0).requirement("Solak", 75).build());
        achievements.add(new AchievementBuilder("Wood Kill Again VI", 0).requirement("Solak", 100).build());
        achievements.add(new AchievementBuilder("Yaksworn", 0.1).requirement("The Ravensworn", 1).requirement("Granny Knows Best", 1)
            .requirement("Fremennik yak (unchecked)", 2).requirement("POF bean", 6000).requirement("Farming", 71).reward("Farming", 71500)
            .build());
        achievements.add(new AchievementBuilder("Zygomitesworn", 0).requirement("The Ravensworn", 1).requirement("Granny Knows Best", 1)
            .requirement("Gloomshroom zygomite (unchecked)", 2).requirement("POF bean", 6000).requirement("Farming", 81)
            .reward("Farming", 88000).build());
        achievements.add(new AchievementBuilder("Gaps, Traps, and Laps", 0.75).requirement("Agility", 90)
            .requirement("Creature of Fenkenstrain", 1).requirement("Cold War", 1).requirement("Bar Crawl (miniquest)", 1)
            .requirement("Monkey Madness", 1).requirement("The Chosen Commander", 1).requirement("Plague's End", 1).reward("Agility", 9850)
            .reward("Ranged", 125).reward("Strength", 125).reward("Agility arena ticket", 1).reward("Hefin Agility Course laps", 1)
            .reward("Advanced Barbarian Outpost laps", 1).reward("Advanced Gnome Stronghold laps", 1).build());
        achievements.add(new AchievementBuilder("Perfectly Balanced I", 0.2).requirement("Agility", 75).requirement("Plague's End", 1)
            .reward("Agility", 20000).build());
        achievements.add(new AchievementBuilder("Perfectly Balanced II", 0.8).requirement("Perfectly Balanced I", 1)
            .reward("Agility", 80000).build());
        achievements.add(new AchievementBuilder("Perfectly Balanced III", 1).requirement("Perfectly Balanced II", 1)
            .reward("Agility", 100000).build());
        achievements.add(new AchievementBuilder("Perfectly Balanced IV", 3).requirement("Perfectly Balanced III", 1)
            .reward("Agility", 300000).build());
        achievements.add(new AchievementBuilder("God Statues (first statue)", 0).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).build());
        achievements.add(new AchievementBuilder("Reverent Sculptor", 1).requirement("God Statues (first statue)", 1)
            .requirement("Plague's End", 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).lamp(Collections.singletonList("Construction"), -4, 1)
            .lamp(Arrays.asList("Prayer", "Slayer"), -2, 1).build());
        achievements.add(new AchievementBuilder("Wen Mah Aquarium Jas Got a Bik Too Ful", 0).requirement("Golden fish egg", 26).build());
        achievements.add(new AchievementBuilder("The Great Gnomish Shake Off", 0).requirement("Cooking", 37).requirement("Pineapple", 3)
            .requirement("Pineapple chunks", 3).requirement("Lemon", 5).requirement("Lemon slices", 1).requirement("Lemon chunks", 1)
            .requirement("Orange", 4).requirement("Orange chunks", 1).requirement("Orange slices", 1).requirement("Lime", 4)
            .requirement("Lime chunks", 1).requirement("Lime slices", 3).requirement("Vodka", 5).requirement("Gin", 3)
            .requirement("Whisky", 1).requirement("Brandy", 1).requirement("Equa leaves", 3).requirement("Dwellberries", 1)
            .requirement("Pot of cream", 2).requirement("Chocolate bar", 1).requirement("Bucket of milk", 1)
            .requirement("Chocolate dust", 1).requirement("Coins", 9).reward("Fruit Blast", 1).reward("Pineapple Punch", 1)
            .reward("Wizard Blizzard", 1).reward("Short Green Guy", 1).reward("Drunk Dragon", 1).reward("Chocolate Saturday", 1)
            .reward("Blurberry Special", 1).reward("Cooking", 830).build());
        achievements.add(new AchievementBuilder("The School of Jewels", 0).requirement("Crafting", 79).requirement("Uncut opal", 1)
            .requirement("Uncut jade", 1).requirement("Uncut red topaz", 1).requirement("Uncut sapphire", 1).requirement("Uncut emerald", 1)
            .requirement("Uncut ruby", 1).requirement("Uncut diamond", 1).requirement("Uncut dragonstone", 1).requirement("Uncut onyx", 1)
            .requirement("Uncut hydrix", 1).reward("Opal", 1).reward("Jade", 1).reward("Red topaz", 1).reward("Sapphire", 1)
            .reward("Emerald", 1).reward("Ruby", 1).reward("Diamond", 1).reward("Dragonstone", 1).reward("Onyx", 1).reward("Hydrix", 1)
            .reward("Crafting", 872).build());
        achievements.add(new AchievementBuilder("The Home of Daemons", 0.1).requirement("Dungeoneering", 113).build());
        achievements.add(new AchievementBuilder("Dungeon Mage", 0).requirement("Dungeoneering token", 969645).build());
        achievements.add(new AchievementBuilder("Dungeon Ranger", 0).requirement("Dungeoneering token", 969645).build());
        achievements.add(new AchievementBuilder("Dungeon Warrior", 0).requirement("Dungeoneering token", 969645).build());
        achievements.add(new AchievementBuilder("Dungeon Skiller", 0).requirement("Dungeoneering token", 969645).build());
        achievements.add(new AchievementBuilder("Dungeoneer Ring", 0).requirement("Dungeon Mage", 1).requirement("Dungeon Ranger", 1)
            .requirement("Dungeon Warrior", 1).requirement("Dungeon Skiller", 1).build());
        achievements.add(new AchievementBuilder("Without Blinking an Eye", 0.1).requirement("Dungeoneering", 95).build());
        achievements.add(new AchievementBuilder("The Riches Wythien the Maw I", 0).requirement("Attack", 95).requirement("Strength", 95)
            .requirement("Ranged", 95).requirement("Magic", 95).requirement("Defence", 95).requirement("Constitution", 95)
            .requirement("Prayer", 95).requirement("Agility", 95).requirement("Herblore", 95).requirement("Thieving", 95)
            .requirement("Crafting", 95).requirement("Runecrafting", 95).requirement("Mining", 95).requirement("Smithing", 95)
            .requirement("Fishing", 95).requirement("Cooking", 95).requirement("Firemaking", 95).requirement("Woodcutting", 95)
            .requirement("Fletching", 95).requirement("Slayer", 95).requirement("Farming", 95).requirement("Construction", 95)
            .requirement("Hunter", 95).requirement("Summoning", 95).requirement("Dungeoneering", 115).requirement("Divination", 95)
            .build());
        achievements.add(new AchievementBuilder("The Riches Wythien the Maw II", 0.05).requirement("The Riches Wythien the Maw I", 1)
            .build());
        achievements.add(new AchievementBuilder("The Riches Wythien the Maw III", 0.05).requirement("The Riches Wythien the Maw II", 1)
            .build());
        achievements.add(new AchievementBuilder("The Riches Wythien the Maw IV", 0.15).requirement("The Riches Wythien the Maw III", 1)
            .build());
        achievements.add(new AchievementBuilder("Scraps of the Gorajo", 0).requirement("Dungeoneering token", 200000)
            .requirement("Dungeoneering fragment", 72000).requirement("Dungeoneering", 80).requirement("Invention", 20)
            .requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("A Firemaker's Log", 0).requirement("Firemaking", 92).requirement("Logs", 1)
            .requirement("Achey tree logs", 1).requirement("Oak logs", 1).requirement("Willow logs", 1).requirement("Teak logs", 1)
            .requirement("Arctic pine logs", 1).requirement("Maple logs", 1).requirement("Acadia logs", 1).requirement("Mahogany logs", 1)
            .requirement("Eucalyptus logs", 1).requirement("Yew logs", 1).requirement("Magic logs", 1)
            .requirement("Corrupted magic logs", 1).requirement("The Branches of Darkmeyer", 1).requirement("Spirit of Summer", 1)
            .requirement("Woodcutting", 83).requirement("Elder logs", 1).requirement("Driftwood", 1).reward("Firemaking", 3795)
            .reward("Woodcutting", 636).build());
        achievements.add(new AchievementBuilder("Bakriminiel Minds", 0.05).requirement("The Knight's Sword", 1).requirement("Fletching", 97)
            .requirement("Smithing", 10).requirement("Bronze bolts", 10).requirement("Opal bolt tips", 20).requirement("Iron bolts", 10)
            .requirement("Pearl bolt tips", 20).requirement("Feather", 10).requirement("Jade bolt tips", 20).requirement("Steel bolts", 10)
            .requirement("Topaz bolt tips", 20).requirement("Mithril bolts", 20).requirement("Sapphire bolt tips", 20)
            .requirement("Emerald bolt tips", 20).requirement("Adamant bolts", 20).requirement("Ruby bolt tips", 20)
            .requirement("Diamond bolt tips", 20).requirement("Runite bolts", 20).requirement("Dragon bolt tips", 20)
            .requirement("Onyx bolt tips", 20).requirement("Ascension bolts", 10).requirement("Hydrix bolt tips", 20)
            .requirement("Bakriminel bolts", 110).reward("Fletching", 1837).reward("Mining", 17).reward("Smithing", 48)
            .reward("Opal bolts", 10).reward("Pearl bolts", 10).reward("Topaz bolts", 10).reward("Sapphire bolts", 10)
            .reward("Emerald bolts", 10).reward("Ruby bolts", 10).reward("Diamond bolts", 10).reward("Dragon bolts", 10)
            .reward("Onyx bolts", 10).reward("Ascendri bolts", 10).reward("Opal bakriminel bolts", 10).reward("Pearl bakriminel bolts", 10)
            .reward("Jade bakriminel bolts", 10).reward("Red topaz bakriminel bolts", 10).reward("Sapphire bakriminel bolts", 10)
            .reward("Emerald bakriminel bolts", 10).reward("Ruby bakriminel bolts", 10).reward("Diamond bakriminel bolts", 10)
            .reward("Dragonstone bakriminel bolts", 10).reward("Onyx bakriminel bolts", 10).reward("Hydrix bakriminel bolts", 10).build());
        achievements.add(new AchievementBuilder("Popoca", 0).requirement("Hunter", 55).reward("Hunter", 1000).build());
        achievements.add(new AchievementBuilder("Choloa", 0).requirement("Hunter", 60).reward("Hunter", 1000).build());
        achievements.add(new AchievementBuilder("Kerrit", 0).requirement("Hunter", 65).reward("Hunter", 1000).build());
        achievements.add(new AchievementBuilder("Snuffle", 0).requirement("Hunter", 70).reward("Hunter", 1000).build());
        achievements.add(new AchievementBuilder("Goebie One with the Wildlife", 0).requirement("Popoca", 1).requirement("Choloa", 1)
            .reward("Kerrit", 1).requirement("Snuffle", 1).reward("Hunter", 15000).build());
        achievements.add(new AchievementBuilder("Sonic Crystal", 0).requirement("The Light Within", 1).requirement("Hunter", 77)
            .requirement("Magic", 88).requirement("Soul rune", 6).requirement("Chaos rune", 6).requirement("Fire rune", 6)
            .requirement("Water rune", 6).requirement("Raw pawya meat", 1).reward("Magic", 95).reward("Hunter", 1650)
            .reward("Grenwall spikes", 20).build());
        achievements.add(new AchievementBuilder("Jadinko Bingo", 0.65).requirement("Hunter", 81).requirement("Green blossom seed", 1)
            .requirement("Blue blossom seed", 1).requirement("Red blossom seed", 1).requirement("Lergberry seed", 1)
            .requirement("Kalferberry seed", 1).requirement("Banana tree seed", 1).requirement("Apple tree seed", 1)
            .requirement("Orange tree seed", 1).requirement("Juju hunter potion (2)", 1).requirement("Farming", 77)
            .requirement("Construction", 80).reward("Hunter", 6735).reward("Farming", 607).build());
        achievements.add(new AchievementBuilder("Great Responsibility", 0).requirement("Invention", 102)
            .requirement("Powerful components", 15).requirement("Precious components", 80).requirement("Magic parts", 80)
            .requirement("Metallic parts", 80).requirement("Smooth parts", 100).requirement("Connector parts", 30)
            .requirement("Simple parts", 100).requirement("Delicate parts", 100).requirement("Base parts", 100)
            .requirement("Clear parts", 100).requirement("Divine charge", 163).requirement("Invention tutorial", 1)
            .reward("Invention", 15850).build());
        achievements.add(new AchievementBuilder("I Said Disassemble, Not Dismember", 0).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Back to the Freezer Invention XP", 0).requirement("Back to the Freezer", 1)
            .requirement("Invention tutorial", 1).reward("Invention", 10000).build());
        achievements.add(new AchievementBuilder("Light 'em up!", 0).requirement("Invention tutorial", 1)
            .requirement("Hand cannon", 1).requirement("Logs", 15).reward("Firemaking", 600).build());
        achievements.add(new AchievementBuilder("Imcando Attitude", 0).requirement("Dragon pickaxe", 1)
            .requirement("Birthright of the Dwarves", 1).requirement("Coins", 1000000).requirement("Redberry pie", 1)
            .requirement("Imcando pickaxe fragment", 4).requirement("Lava Flow Mine damage", 1200000).build());
        achievements.add(new AchievementBuilder("Shards of the Earth", 0).requirement("Gemstone golem fragments", 54000).build());
        achievements.add(new AchievementBuilder("Portnight", 0.7).requirement("Ports unlocked", 1).build());
        achievements.add(new AchievementBuilder("Tetsu Warrior", 0.1).requirement("Port distance", 6000000).requirement("Plate", 390)
            .requirement("Smithing", 92).requirement("Pearls", 75).requirement("Arc - Mitts and Waders - Tetsu", 1)
            .reward("Smithing", 115000).reward("Crafting", 7500).build());
        achievements.add(new AchievementBuilder("Seasinger", 0.1).requirement("Port distance", 6000000).requirement("Chi", 390)
            .requirement("Runecrafting", 92).requirement("Koi scales", 75).requirement("Arc - Mitts and Waders - Seasinger", 1)
            .reward("Runecrafting", 115000).reward("Crafting", 7500).build());
        achievements.add(new AchievementBuilder("Death Lotus Assassin", 0).requirement("Port distance", 450000).requirement("Lacquer", 240)
            .requirement("Crafting", 90).requirement("Ancient bones", 2).requirement("Ascension shard", 50).requirement("Fletching", 92)
            .requirement("Arc - Mitts and Waders - Death Lotus", 1).reward("Fletching", 500).reward("Crafting", 70000).build());
        achievements.add(new AchievementBuilder("A little green around the gills", 0).requirement("Ports unlocked", 1).build());
        achievements.add(new AchievementBuilder("From landlubber to deck scrubber", 0).requirement("A little green around the gills", 1)
            .requirement("Port distance", 45000).requirement("Walking the Reef", 1).build());
        achievements.add(new AchievementBuilder("Best Mate ever", 0).requirement("From landlubber to deck scrubber", 1)
            .requirement("Port distance", 445000).build());
        achievements.add(new AchievementBuilder("Oh captain, my captain", 0).requirement("Best Mate ever", 1)
            .requirement("Assassin storyline", 1).build());
        achievements.add(new AchievementBuilder("A Commodore to adore", 0).requirement("Oh captain, my captain", 1)
            .requirement("Quin storyline", 1).build());
        achievements.add(new AchievementBuilder("Admirable", 0).requirement("A Commodore to adore", 1)
            .requirement("Hyu-Ji storyline", 1).build());
        achievements.add(new AchievementBuilder("Fleeting Admiration", 0).requirement("Admirable", 1).requirement("Port distance", 3500000)
            .requirement("Eastern Curiosities storyline", 1).build());
        achievements.add(new AchievementBuilder("VIP - Very Important Portmaster", 0).requirement("Fleeting Admiration", 1)
            .requirement("Guardians of the World storyline", 1).build());
        achievements.add(new AchievementBuilder("Last Rites", 0).requirement("Bones", 1).reward("Prayer", 4).build());
        achievements.add(new AchievementBuilder("Bury All", 0).requirement("Last Rites", 1).requirement("Wolf bones", 1)
            .requirement("Burnt bones", 1).requirement("Monkey bones", 1).requirement("Bat bones", 1).requirement("Big bones", 1)
            .requirement("Jogre bones", 1).requirement("Zogre bones", 1).requirement("Shaikahan bones", 1)
            .requirement("Baby dragon bones", 1).requirement("Wyvern bones", 1).requirement("Dragon bones", 1).requirement("Fayrg bones", 1)
            .requirement("Raurg bones", 1).requirement("Dagannoth bones", 1).requirement("Airut bones", 1)
            .requirement("Ourg bones (General Graardor)", 1).requirement("Hardened dragon bones", 1).requirement("Frost dragon bones", 1)
            .requirement("Reinforced dragon bones", 1).requirement("Impious ashes", 1).requirement("Accursed ashes", 1)
            .requirement("Infernal ashes", 1).requirement("Tortured ashes", 1).requirement("Searing ashes", 1).reward("Prayer", 1709)
            .build());
        achievements.add(new AchievementBuilder("Curses!", 0).requirement("The Temple at Senntisten", 1).build());
        achievements.add(new AchievementBuilder("Zaros's Per-faction-ist", 0).requirement("Zaros reputation", 5000).build());
        achievements.add(new AchievementBuilder("Zamorak's Per-faction-ist", 0).requirement("Zamorak reputation", 5000).build());
        achievements.add(new AchievementBuilder("Seren's Per-faction-ist", 0).requirement("Seren reputation", 5000).build());
        achievements.add(new AchievementBuilder("Sliske's Per-faction-ist", 0).requirement("Sliske reputation", 5000).build());
        achievements.add(new AchievementBuilder("Conquered Everyone's Heart", 0).requirement("Zaros's Per-faction-ist", 1)
            .requirement("Seren's Per-faction-ist", 1).requirement("Zamorak's Per-faction-ist", 1)
            .requirement("Sliske's Per-faction-ist", 1).build());
        achievements.add(new AchievementBuilder("My Goebie Homies", 8.5).requirement("Yakamaru", 1)
            .requirement("Goebie One with the Wildlife", 1).build());
        achievements.add(new AchievementBuilder("Altar Native", 0.5).requirement("Runecrafting", 90).requirement("Abyss (miniquest)", 1)
            .requirement("Pure essence", 18).requirement("Lost City", 1).requirement("Lunar Diplomacy", 1)
            .requirement("Mourning's End Part II", 1).requirement("Legacy of Seergaze", 1).requirement("'Phite Club", 1)
            .requirement("Air talisman", 1).requirement("Earth talisman", 2).requirement("Water talisman", 2)
            .requirement("Fire talisman", 1).requirement("Water rune", 1).requirement("Earth rune", 1)
            .requirement("Ritual of the Mahjarrat", 1).requirement("Dust of Armadyl", 1).reward("Runecrafting", 433).reward("Mist rune", 1)
            .reward("Mind rune", 1).reward("Mud rune", 1).reward("Dust rune", 1).reward("Smoke rune", 1).reward("Body rune", 1)
            .reward("Cosmic rune", 1).reward("Chaos rune", 1).reward("Astral rune", 1).reward("Nature rune", 1).reward("Law rune", 1)
            .reward("Death rune", 1).reward("Blood rune", 1).reward("Soul rune", 1).reward("Armadyl rune", 7).build());
        achievements.add(new AchievementBuilder("All Good", 0).requirement("Elemental talisman", 1).requirement("Air talisman", 1)
            .requirement("Mind talisman", 1).requirement("Water talisman", 1).requirement("Earth talisman", 1)
            .requirement("Fire talisman", 1).requirement("Body talisman", 1).requirement("Cosmic talisman", 1)
            .requirement("Chaos talisman", 1).requirement("Nature talisman", 1).requirement("Law talisman", 1)
            .requirement("Death talisman", 1).requirement("Blood talisman", 1).requirement("Soul talisman", 1)
            .requirement("Runecrafting", 50).reward("Runecrafting", 13605).build());
        achievements.add(new AchievementBuilder("Energy Aficionado", 0.1).requirement("Runecrafting", 95).reward("Runecrafing", 1314)
            .reward("Runespan points", 21).build());
        achievements.add(new AchievementBuilder("Y'all Got Any More of that Rune Dust? I", 0.25).requirement("Runecrafting", 29)
            .reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Runesphere 2", 0.25).requirement("Y'all Got Any More of that Rune Dust? I", 1)
            .reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Runesphere 3", 0.25).requirement("Runesphere 2", 1).reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Runesphere 4", 0.25).requirement("Runesphere 3", 1).reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Y'all Got Any More of that Rune Dust? II", 0.25).requirement("Runesphere 4", 1)
            .reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Runesphere 6", 0.25).requirement("Y'all Got Any More of that Rune Dust? II", 1)
            .reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Runesphere 7", 0.25).requirement("Runesphere 6", 1).reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Runesphere 8", 0.25).requirement("Runesphere 7", 1).reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Runesphere 9", 0.25).requirement("Runesphere 8", 1).reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Y'all Got Any More of that Rune Dust? III", 0.25).requirement("Runesphere 9", 1)
            .reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Runesphere 11", 0.25).requirement("Y'all Got Any More of that Rune Dust? III", 1)
            .reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Runesphere 12", 0.25).requirement("Runesphere 11", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 13", 0.25).requirement("Runesphere 12", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 14", 0.25).requirement("Runesphere 13", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 15", 0.25).requirement("Runesphere 14", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 16", 0.25).requirement("Runesphere 15", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 17", 0.25).requirement("Runesphere 16", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 18", 0.25).requirement("Runesphere 17", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 19", 0.25).requirement("Runesphere 18", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 20", 0.25).requirement("Runesphere 19", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 21", 0.25).requirement("Runesphere 20", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 22", 0.25).requirement("Runesphere 21", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 23", 0.25).requirement("Runesphere 22", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Runesphere 24", 0.25).requirement("Runesphere 23", 1).reward("Runecrafting", 28000)
            .build());
        achievements.add(new AchievementBuilder("Y'all Got Any More of that Rune Dust? IV", 0.25).requirement("Runesphere 24", 1)
            .reward("Runecrafting", 28000).build());
        achievements.add(new AchievementBuilder("Splinters of Power", 0).requirement("Rune ethereal fragments", 54000).build());
        achievements.add(new AchievementBuilder("Rinsit Transit", 0).requirement("Runespan points", 1000).build());
        achievements.add(new AchievementBuilder("Loving would be easy", 0).requirement("Fate of the Gods", 1).requirement("Summoning", 87)
            .requirement("Pouch", 5).requirement("Elder energy", 750).encounter(new Encounter("Throwing muspah"))
            .encounter(new Encounter("Throwing muspah")).encounter(new Encounter("Throwing muspah"))
            .encounter(new Encounter("Throwing muspah")).encounter(new Encounter("Throwing muspah")).encounter(new Encounter("Smoke nihil"))
            .encounter(new Encounter("Smoke nihil")).encounter(new Encounter("Smoke nihil")).encounter(new Encounter("Smoke nihil"))
            .encounter(new Encounter("Smoke nihil")).encounter(new Encounter("Shadow nihil")).encounter(new Encounter("Shadow nihil"))
            .encounter(new Encounter("Shadow nihil")).encounter(new Encounter("Shadow nihil")).encounter(new Encounter("Shadow nihil"))
            .encounter(new Encounter("Blood nihil")).encounter(new Encounter("Blood nihil")).encounter(new Encounter("Blood nihil"))
            .encounter(new Encounter("Blood nihil")).encounter(new Encounter("Blood nihil")).encounter(new Encounter("Ice nihil"))
            .encounter(new Encounter("Ice nihil")).encounter(new Encounter("Ice nihil")).encounter(new Encounter("Ice nihil"))
            .encounter(new Encounter("Ice nihil")).reward("Summoning", 1465).reward("Nightmare muspah pouch", 1)
            .reward("Smoke nihil pouch", 1).reward("Shadow nihil pouch", 1).reward("Blood nihil pouch", 1).reward("Ice nihil pouch", 1)
            .build());
        achievements.add(new AchievementBuilder("Gold", 0).requirement("Spirit shards", 107).requirement("Gold charm", 14)
            .requirement("Pouch", 14).requirement("Wolf bones", 1).requirement("Raw chicken", 1).requirement("Spider carcass", 1)
            .requirement("Thin snail", 1).requirement("Iron ore", 1).requirement("Proboscis", 1).requirement("Marigolds", 1)
            .requirement("Raw bird meat", 1).requirement("Swamp toad", 1).requirement("Tortoise shell", 1)
            .requirement("Polar kebbit fur", 1).requirement("Pig tooth", 3).requirement("Summoning", 71)
            .requirement("Bringing Home the Bacon", 1).reward("Summoning", 514).reward("Spirit wolf pouch", 1).reward("Dreadfowl pouch", 1)
            .reward("Spirit spider pouch", 1).reward("Thorny snail pouch", 1).reward("Granite crab pouch", 1)
            .reward("Spirit mosquito pouch", 1).reward("Bull ant pouch", 1).reward("Spirit terrorbird pouch", 1)
            .reward("Barker toad pouch", 1).reward("War tortoise pouch", 1).reward("Arctic bear pouch", 1).build());
        achievements.add(new AchievementBuilder("Red", 0).requirement("Summoning", 99).requirement("Spirit shards", 3499)
            .requirement("Crimson charm", 26).requirement("Pouch", 26).requirement("Bronze claws", 1).requirement("Obsidian charm", 1)
            .requirement("Vampyre dust", 1).requirement("Honeycomb", 1).requirement("Carved evil turnip", 1).requirement("Tinderbox", 1)
            .requirement("Raw beef", 1).requirement("Goat horn dust", 1).requirement("Snake hide", 1).requirement("Bagged plant 1", 1)
            .requirement("Pot of flour", 1).requirement("Phoenix quill", 3).requirement("Granite (500g)", 1).requirement("Red flowers", 1)
            .requirement("Demon claw", 3).requirement("Dagannoth hide", 1).requirement("Green salamander", 1).requirement("Raw rabbit", 1)
            .requirement("Wolf bones", 1).requirement("Iron ingot", 1).requirement("Yak-hide", 1).requirement("Steel ingot", 1)
            .requirement("Mammoth tusk", 1).requirement("In Aid of the Myreque", 1).encounter(new Encounter("Nail beast"))
            .reward("Summoning", 8259).reward("Spirit scorpion pouch", 1).reward("Spirit tz-kih pouch", 1).reward("Vampyre bat pouch", 1)
            .reward("Honey badger pouch", 1).reward("Evil turnip pouch", 1).reward("Pyrelord pouch", 1).reward("Bloated leech pouch", 1)
            .reward("Smoke devil pouch", 1).reward("Spirit cobra pouch", 1).reward("Stranger plant pouch", 1)
            .reward("Ravenous locust pouch", 1).reward("Phoenix pouch", 1).reward("Granite lobster pouch", 1)
            .reward("Praying mantis pouch", 1).reward("Talon beast pouch", 1).reward("Brawler demon pouch", 1)
            .reward("Executioner demon pouch", 1).reward("Deacon demon pouch", 1).reward("Spirit dagannoth pouch", 1)
            .reward("Reborn phoenix pouch", 1).reward("Swamp titan pouch", 1).reward("Wolpertinger pouch", 1).reward("Iron titan pouch", 1)
            .reward("Pack yak pouch", 1).reward("Steel titan pouch", 1).reward("Pack mammoth pouch", 1).build());
        achievements.add(new AchievementBuilder("And Green", 0.1).requirement("Summoning", 93).requirement("Pouch", 23)
            .requirement("Spirit shards", 2240).requirement("Green charm", 23).requirement("Bucket of sand", 1).requirement("Compost", 1)
            .requirement("Willow logs", 1).requirement("Clean guam", 1).requirement("Cockatrice egg", 1).requirement("Guthatrice egg", 1)
            .requirement("Saratrice egg", 1).requirement("Zamatrice egg", 1).requirement("Pengatrice egg", 1)
            .requirement("Coraxatrice egg", 1).requirement("Vulatrice egg", 1).requirement("Gold ring", 1).requirement("Harpoon", 1)
            .requirement("Raw shark", 1).requirement("Banana", 1).requirement("Ruby harvest", 1).requirement("Willow branch", 1)
            .requirement("Water orb", 1).requirement("Unicorn horn", 1).encounter(new Encounter("Abyssal walker"))
            .encounter(new Encounter("Abyssal walker")).encounter(new Encounter("Abyssal walker"))
            .encounter(new Encounter("Abyssal walker")).encounter(new Encounter("Abyssal walker")).reward("Summoning", 2067)
            .reward("Desert wyrm pouch", 1).reward("Compost mound pouch", 1).reward("Beaver pouch", 1).reward("Void ravager pouch", 1)
            .reward("Macaw pouch", 1).reward("Spirit cockatrice pouch", 1).reward("Spirit guthatrice pouch", 1)
            .reward("Spirit zamatrice pouch", 1).reward("Spirit pengatrice pouch", 1).reward("Spirit coraxatrice pouch", 1)
            .reward("Spirit vulatrice pouch", 1).reward("Magpie pouch", 1).reward("Abyssal parasite pouch", 1).reward("Ibis pouch", 1)
            .reward("Abyssal lurker pouch", 1).reward("Bunyip pouch", 1).reward("Fruit bat pouch", 1).reward("Forge regent pouch", 1)
            .reward("Giant ent pouch", 1).reward("Hydra pouch", 1).reward("Unicorn stallion", 1).reward("Abyssal titan pouch", 1).build());
        achievements.add(new AchievementBuilder("Charmer Chameleon", 0).requirement("Loving would be easy", 1)
            .requirement("If your colours were like my dreams", 1).requirement("Gold", 1).requirement("Red", 1).requirement("And Green", 1)
            .build());
        achievements.add(new AchievementBuilder("A Bit TOO Familiar", 5).build());
        achievements.add(new AchievementBuilder("A Charm Saved is a Charm Earned", 0).requirement("Spirit sapphire", 2).build());
        achievements.add(new AchievementBuilder("A Hidden Gem I", 0).requirement("Crystal geode", 1).build());
        achievements.add(new AchievementBuilder("A Hidden Gem II", 0).requirement("Crystal geode", 5).build());
        achievements.add(new AchievementBuilder("A Hidden Gem III", 0).requirement("Crystal geode", 10).build());
        achievements.add(new AchievementBuilder("A Hidden Gem IV", 0).requirement("Crystal geode", 25).build());
        achievements.add(new AchievementBuilder("Snippets of Memory", 0).requirement("Divination fragments", 54000)
            .requirement("Divination", 80).requirement("Invention", 20).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Catch and Release", 0).requirement("Raw shrimps", 1).build());
        achievements.add(new AchievementBuilder("Scales of the Sea", 0).requirement("Fishing", 80).requirement("Invention", 20)
            .requirement("Shark fragment", 54000).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Slivers of Camouflage", 0).requirement("Thieving", 80).requirement("Invention", 20)
            .requirement("Camouflage fragment", 54000).requirement("Invention tutorial", 1).reward("Invention", 1198).build());
        achievements.add(new AchievementBuilder("A Thief Beyond Belief", 0.25).requirement("Thieving", 75)
            .requirement("The Jack of Spades", 1).requirement("Monkey Madness", 1).reward("Thieving", 861).build());
        achievements.add(new AchievementBuilder("The Ominous Sarcophagus Metropolis I", 0)
            .requirement("Perfect Shifting Tombs runs with enhancers", 1).build());
        achievements.add(new AchievementBuilder("The Ominous Sarcophagus Metropolis II", 0)
            .requirement("Perfect Shifting Tombs runs with enhancers", 5).build());
        achievements.add(new AchievementBuilder("The Ominous Sarcophagus Metropolis III", 0)
            .requirement("Perfect Shifting Tombs runs with enhancers", 10).build());
        achievements.add(new AchievementBuilder("The Ominous Sarcophagus Metropolis IV", 0)
            .requirement("Perfect Shifting Tombs runs with enhancers", 25).build());
        achievements.add(new AchievementBuilder("Crying over Foraged Milk", 0).requirement("Impressing the Locals", 1)
            .requirement("Farming", 90).reward("Farming", 25).build());
        achievements.add(new AchievementBuilder("Gumbo Jumbo", 0).requirement("Shark soup", 1).requirement("Arc gumbo", 1).build());
        achievements.add(new AchievementBuilder("Uncharted I", 0).requirement("Uncharted Isles visited", 1).build());
        achievements.add(new AchievementBuilder("Uncharted II", 0).requirement("Uncharted Isles visited", 5).build());
        achievements.add(new AchievementBuilder("Uncharted III", 0).requirement("Uncharted Isles visited", 10).build());
        achievements.add(new AchievementBuilder("Uncharted IV", 0).requirement("Uncharted Isles visited", 25).build());
        achievements.add(new AchievementBuilder("Uncharted V", 0).requirement("Uncharted Isles visited", 50).build());
        achievements.add(new AchievementBuilder("Uncharted VI", 0).requirement("Uncharted Isles visited", 100).build());
        achievements.add(new AchievementBuilder("Race for the soul: 20 minutes", 0).requirement("Nomad's Mirage", 1).build());
        achievements.add(new AchievementBuilder("Race for the soul: 16 minutes", 0).requirement("Nomad's Mirage", 1).build());
        achievements.add(new AchievementBuilder("Race for the soul: 14 minutes", 0).requirement("Nomad's Mirage", 1).build());
        achievements.add(new AchievementBuilder("Race for the soul: 12 minutes", 0).requirement("Nomad's Mirage", 1).build());
        achievements.add(new AchievementBuilder("Race for the soul: 10 minutes", 0).requirement("Nomad's Mirage", 1).build());
        achievements.add(new AchievementBuilder("Race for the soul: 8 minutes", 0).requirement("Nomad's Mirage", 1).build());
        achievements.add(new AchievementBuilder("Race for the soul: 6 minutes", 0).requirement("Nomad's Mirage", 1).build());
        achievements.add(new AchievementBuilder("I Know You Are But What Am I", 0).requirement("Dragonfire shield", 0)
            .requirement("Defence", 70).build());
        achievements.add(new AchievementBuilder("Dragonstone Dragonstone Dragonstone", 0).requirement("Slayer", 95)
            .requirement("Karamja Set Tasks - Hard", 1).requirement("Dragonstone helm", 0).requirement("Dragonstone hauberk", 0)
            .requirement("Dragonstone gauntlets", 0).requirement("Dragonstone greaves", 0).requirement("Dragonstone boots", 0)
            .requirement("Dragonstone ring", 0).requirement("Dragonstone necklace", 0).requirement("Dragonstone bakriminel bolts", 1)
            .requirement("Dragonstone", -28).encounter(new Encounter("Dragonstone dragon")).build());
        achievements.add(new AchievementBuilder("Unlocking Expertise", 0).requirement("Ultimate Codex", 1).requirement("The World Wakes", 1)
            .requirement("Scare Tactics", 1).requirement("Reprisal Ability Codex", 1).requirement("Mazcab ability codex", 4)
            .requirement("Greater Fury ability codex", 1).requirement("Greater Flurry ability codex", 1)
            .requirement("Greater Barge ability codex", 1).requirement("Shattering Worlds V", 1)
            .requirement("Anima Islands Reward Currency", 14500).build());
        achievements.add(new AchievementBuilder("Don't Choke", 0).requirement("Shrimps", 1).requirement("Saradomin brew (1)", 1)
            .reward("Vial", 1).build());
        achievements.add(new AchievementBuilder("Kill Count Still Counts", 0).requirement("Commander Zilyana (hard)", 17)
            .requirement("General Graardor (hard)", 17).requirement("K'ril Tsutsaroth (hard)", 17).requirement("Kree'arra (HM)", 17)
            .build());
        achievements.add(new AchievementBuilder("Weave Come a Long Way 100", 0)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor"), Collections.singletonList("Araxxi"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 20"), Collections.singletonList("Araxxi 20"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 40"), Collections.singletonList("Araxxi 40"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 60"), Collections.singletonList("Araxxi 60"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 80"), Collections.singletonList("Araxxi 80"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 100"), Collections.singletonList("Araxxi 100"))))
            .build());
        achievements.add(new AchievementBuilder("Weave Come a Long Way 200", 0).requirement("Weave Come a Long Way 100", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 120"), Collections.singletonList("Araxxi 120"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 140"), Collections.singletonList("Araxxi 140"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 160"), Collections.singletonList("Araxxi 160"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 180"), Collections.singletonList("Araxxi 180"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 200"), Collections.singletonList("Araxxi 200"))))
            .build());
        achievements.add(new AchievementBuilder("Weave Come a Long Way 300", 0).requirement("Weave Come a Long Way 200", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 220"), Collections.singletonList("Araxxi 220"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 240"), Collections.singletonList("Araxxi 240"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 260"), Collections.singletonList("Araxxi 260"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 280"), Collections.singletonList("Araxxi 280"))))
            .encounter(new Encounter(Arrays.asList(Collections.singletonList("Araxxor 300"), Collections.singletonList("Araxxi 300"))))
            .build());
        achievements.add(new AchievementBuilder("A Swift Two Fifty", 0.1).requirement("Master Quester", 1).requirement("Summoning", 88)
            .requirement("Light creature pouch", 1).requirement("Enlightenment scroll", 1).reward("Farming", 45000).build());
        achievements.add(new AchievementBuilder("Ultimate Birdwatcher", 5).lamp(Player.ALL_SKILLS, -1250, 1).build());
        achievements.add(new AchievementBuilder("I C U K G P", 1).requirement("Back to the Freezer", 1).lamp(Player.ALL_SKILLS, -840, 1)
            .build());
        achievements.add(new AchievementBuilder("Cops and Robbers", 8).build());
        achievements.add(new AchievementBuilder("Something 'bout that Sq'irk, Sq'irk, Sq'irk, Sq'irk, Sq'irk", 0.25)
            .requirement("Thieving", 65).requirement("Diamond in the Rough", 1).reward("Farming", 580).reward("Thieving", 7050).build());
        achievements.add(new AchievementBuilder("Troll Invasion (first run)", 0.25).lamp(Player.ALL_SKILLS, -7, 1).build());
        achievements.add(new AchievementBuilder("Agoroth", 0.05).requirement("A Shadow over Ashdale", 1).lamp(Player.ALL_SKILLS, -2, 1)
            .build());
        achievements.add(new AchievementBuilder("Regard my Shards", 0.3).build());
        achievements.add(new AchievementBuilder("Hacks", 0.5).reward("Woodcutting", 4525).reward("Firemaking", 1600).reward("Logs", 12)
            .reward("Coins", 253).build());
        achievements.add(new AchievementBuilder("Rune Goldberg machine (one wax)", 0.05).requirement("Runecrafting", 50)
            .requirement("Air rune", 5).requirement("Water rune", 5).requirement("Earth rune", 5).reward("Vis wax", 1).build());
        achievements.add(new AchievementBuilder("It's Late and I'm Awake", 0.15).reward("Mining", 400).reward("Cosmic rune", 152)
            .reward("Astral rune", 52).reward("Gold ore", 20).reward("Coins", 50002).lamp(Collections.singletonList("Mining"), -80, 1)
            .build());
        achievements.add(new AchievementBuilder("Guthixian Cache (first run)", 0.15).lamp(Collections.singletonList("Divination"), -11, 1)
            .build());
        achievements.add(new AchievementBuilder("Tears of Guthix (first run)", 0.05).requirement("Tears of Guthix", 1)
            .lamp(Player.ALL_SKILLS, 300, 1).build());
        achievements.add(new AchievementBuilder("Big Chinchompa (first run)", 0.25).reward("Hunter", 1500).build());
        achievements.add(new AchievementBuilder("The Distracted", 0.1).requirement("God Statues (first statue)", 1)
            .requirement("Troll Invasion (first run)", 1).requirement("Agoroth", 1).requirement("Fur 'n' Seek wish list", 1)
            .requirement("Treasure Seeker I", 1).requirement("The Hunt for Surok (miniquest)", 1).requirement("Regard my Shards", 1)
            .requirement("Arise from the Ash", 1).requirement("Mugger v. Roger Murray", 1).requirement("Goblin champion", 1)
            .requirement("Hacks", 1).requirement("Fish Flingers (first run)", 1).requirement("Make Them Bleed", 1)
            .requirement("Rune Goldberg machine (one wax)", 1).requirement("It's Late and I'm Awake", 1).requirement("Sinking Fast", 1)
            .requirement("Camping is in Tents", 1).requirement("P-P-P-Pick Up Some Prizes", 1).requirement("Guthixian Cache (first run)", 1)
            .requirement("Tears of Guthix (first run)", 1).requirement("Big Chinchompa (first run)", 1).build());
        achievements.add(new AchievementBuilder("Panic at the Disco", 0).build());
        achievements.add(new AchievementBuilder("Well, Would You Look At That", 0).reward("Needle", 1).build());
        achievements.add(new AchievementBuilder("Beating Your Meat", 0).requirement("Meat tenderiser", 0).requirement("Cow kills", 693)
            .build());
        achievements.add(new AchievementBuilder("Stand and Deliver (misc)", 0).requirement("Cooking", 85).requirement("Sliced banana", 1)
            .requirement("Nuts", 1).requirement("Curry leaf", 1).requirement("Cooked chicken", 1).requirement("Plain pizza", 1)
            .reward("Cooking", 89).build());
        achievements.add(new AchievementBuilder("Calm Down, Dear", 0).requirement("Aggression potion (1)", 1).requirement("Cup of tea", 1)
            .reward("Vial", 1).build());
        achievements.add(new AchievementBuilder("Questioning Your Sanity", 1).build());
        achievements.add(new AchievementBuilder("Handles for Forks", 0).build());
        achievements.add(new AchievementBuilder("I Meant To Do that", 0).requirement("Magic", 30).build());
        achievements.add(new AchievementBuilder("Life Saver", 2.5).requirement("Sign of life", 50).build());
        achievements.add(new AchievementBuilder("Get Tooled Up", 0.05).requirement("Bronze pickaxe", 1).requirement("Bronze hatchet", 1)
            .requirement("Hammer", 1).requirement("Chisel", 1).requirement("Knife", 1).requirement("Tinderbox", 1).requirement("Saw", 1)
            .requirement("Pestle and mortar", 1).requirement("Machete", 1).requirement("Shears", 1).requirement("Noose wand", 1)
            .requirement("Mithril grapple", 1).requirement("Mithril crossbow", 1).requirement("Mithril bar", 5).requirement("Fletching", 54)
            .requirement("Pilfer Points", 5000).requirement("One Small Favour", 1).requirement("Crayfish cage", 1)
            .requirement("Fishing rod", 1).requirement("Small fishing net", 1).requirement("Big fishing net", 1)
            .requirement("Fly fishing rod", 1).requirement("Harpoon", 1).requirement("Lobster pot", 1).requirement("Barbarian Fishing", 1)
            .requirement("Needle", 1).requirement("Glassblowing pipe", 1).requirement("Amulet mould", 1).requirement("Bracelet mould", 1)
            .requirement("Necklace mould", 1).requirement("Ring mould", 1).requirement("Tiara mould", 1).requirement("Dwarf Cannon", 1)
            .requirement("Bolt mould", 1).requirement("Holy mould", 1).requirement("Observatory Quest", 1).requirement("Sickle mould", 1)
            .requirement("Legacy of Seergaze", 1).requirement("Rake", 1).requirement("Seed dibber", 1).requirement("Spade", 1)
            .requirement("Gardening trowel", 1).requirement("A Fairy Tale III - Battle at Ork's Rift", 1).requirement("Secateurs", 1)
            .requirement("Rock hammer", 1).requirement("Coins", 180000).requirement("Slayer bell", 1)
            .requirement("The Path of Glouphrie", 1).requirement("Ouroboros pouch", 1).requirement("Slayer point", 2500)
            .requirement("Bonecrusher", 1).requirement("POF bean", 10000).requirement("Summoning", 21).requirement("Dungeoneering", 21)
            .requirement("Herblore", 21).requirement("Dungeoneering token", 1634000).requirement("Invention tutorial", 1).build());
        achievements.add(new AchievementBuilder("Fruitful Labour", 0).reward("Coins", 30).build());
        achievements.add(new AchievementBuilder("Is This a Bad Time?", 0.05).requirement("Dream Mentor", 1).requirement("Magic", 67)
            .requirement("Cosmic rune", 10).requirement("Astral rune", 10).requirement("Air rune", 20).reward("Magic", 630).build());
        achievements.add(new AchievementBuilder("This is Not a Dating Site", 0).build());
        achievements.add(new AchievementBuilder("Herald of Light", 0).requirement("Coins", 1000000).requirement("Plague's End", 1)
            .requirement("Amlodd symbol piece", 1).requirement("Cadarn symbol piece", 1).requirement("Crwys symbol piece", 1)
            .requirement("Hefin symbol piece", 1).requirement("Iorwerth symbol piece", 1).requirement("Ithell symbol piece", 1)
            .requirement("Meilyr symbol piece", 1).requirement("Trahearn symbol piece", 1).reward("Agility", 15000).reward("Attack", 15000)
            .reward("Crafting", 15000).reward("Construction", 15000).reward("Divination", 15000).reward("Dungeoneering", 15000)
            .reward("Defence", 15000).reward("Farming", 15000).reward("Herblore", 15000).reward("Magic", 15000).reward("Mining", 15000)
            .reward("Prayer", 15000).reward("Ranged", 15000).reward("Slayer", 15000).reward("Smithing", 15000).reward("Strength", 15000)
            .reward("Summoning", 15000).reward("Woodcutting", 15000).build());
        achievements.add(new AchievementBuilder("Dailyscape", 2).build());
        achievements.add(new AchievementBuilder("Livid", 0).requirement("Lunar Master", 1)
            .requirement("Dimension of Disaster: Coin of the Realm", 1).build());
        achievements.add(new AchievementBuilder("Gnome More, I'm Full", 0).requirement("Toad crunchies", 1)
            .requirement("Spicy crunchies", 1).requirement("Worm crunchies", 1).requirement("Chocchip crunchies", 1)
            .requirement("Fruit batta", 1).requirement("Toad batta", 1).requirement("Worm batta", 1).requirement("Vegetable batta", 1)
            .requirement("Cheese+tom batta", 1).requirement("Worm hole", 1).requirement("Veg ball", 1).requirement("Tangled toads' legs", 1)
            .requirement("Chocolate bomb", 1).requirement("Fruit Blast", 1).requirement("Pineapple Punch", 1)
            .requirement("Wizard Blizzard", 1).requirement("Short Green Guy", 1).requirement("Drunk Dragon", 1)
            .requirement("Chocolate Saturday", 1).requirement("Blurberry Special", 1).build());
        achievements.add(new AchievementBuilder("A Flood of Spuds", 0).requirement("Baked potato", 1).requirement("Potato with butter", 1)
            .requirement("Potato with cheese", 1).requirement("Chilli potato", 1).requirement("Egg potato", 1)
            .requirement("Mushroom potato", 1).requirement("Tuna potato", 1).build());
        achievements.add(new AchievementBuilder("You Wanna Pizza Me?", 0).requirement("Plain pizza", 2).requirement("Meat pizza", 1)
            .requirement("Anchovy pizza", 1).requirement("Pineapple pizza", 1).requirement("Cooking", 85).requirement("Sliced banana", 1)
            .requirement("Nuts", 1).requirement("Curry leaf", 1).requirement("Cooked chicken", 1).reward("Half plain pizza", 1)
            .reward("Half meat pizza", 1).reward("Half anchovy pizza", 1).reward("Half pineapple pizza", 1).reward("Cooking", 89).build());
        achievements.add(new AchievementBuilder("Who Ate All the Pies?", 0).requirement("Redberry pie", 1).requirement("Meat pie", 1)
            .requirement("Mud pie", 0).requirement("Apple pie", 1).requirement("Garden pie", 1).requirement("Fish pie", 1)
            .requirement("Admiral pie", 1).requirement("Pork pie", 1).requirement("Wild pie", 1).requirement("Wilder pie", 1)
            .requirement("Summer pie", 1).reward("Half a redberry pie", 1).reward("Half a meat pie", 1).reward("Half an apple pie", 1)
            .reward("Half a garden pie", 1).reward("Half a fish pie", 1).reward("Half an admiral pie", 1).reward("Half a wild pie", 1)
            .reward("Half a wilder pie", 1).reward("Half a summer pie", 1).build());
        achievements.add(new AchievementBuilder("Fishy Dishes", 0).requirement("Crayfish", 1).requirement("Shrimps", 1)
            .requirement("Sardine", 1).requirement("Anchovies", 1).requirement("Herring", 1).requirement("Mackerel", 1)
            .requirement("Trout", 1).requirement("Cod", 1).requirement("Pike", 1).requirement("Salmon", 1).requirement("Tuna", 1)
            .requirement("Rainbow fish", 1).requirement("Cave eel", 1).requirement("Lobster", 1).requirement("Bass", 1)
            .requirement("Swordfish", 1).requirement("Desert sole", 1).requirement("Heroes' Quest", 1).requirement("Catfish", 1)
            .requirement("Monkfish", 1).requirement("Beltfish", 1).requirement("Green blubber jellyfish", 1).requirement("Shark", 1)
            .requirement("Sea turtle", 1).requirement("Cavefish", 1).requirement("Manta ray", 1).requirement("Rocktail soup", 1)
            .requirement("Fishing", 95).requirement("Cooking", 95).requirement("Blue blubber jellyfish", 1).requirement("Sailfish soup", 1)
            .reward("Fishing", 140).reward("Cooking", 260).reward("2/3 green blubber jellyfish", 1).reward("2/3 blue blubber jellyfish", 1)
            .build());
        achievements.add(new AchievementBuilder("Nice to Meat You", 0).requirement("Cooked meat", 1).requirement("Cooked chicken", 1)
            .requirement("Ugthanki meat", 1).requirement("Cooked rabbit", 1).requirement("Bacon", 1).requirement("Roast rabbit", 1)
            .requirement("Spider on stick", 1).requirement("Spider on shaft", 1).requirement("Cooked crab meat", 1)
            .requirement("Roast beast meat", 1).requirement("Bacon stack", 1).requirement("Cooked chompy", 1).requirement("Bacon pile", 1)
            .requirement("Cooked jubbly", 1).requirement("Bacon heap", 1).requirement("Cooked oomlie wrap", 1).requirement("Bacon mound", 1)
            .requirement("Impressing the Locals", 1).requirement("Cooking", 91).encounter(new Encounter("Pekin")).build());
        achievements.add(new AchievementBuilder("Gielinorian Cuisine", 0).requirement("Who Ate All the Pies?", 1)
            .requirement("You Wanna Pizza Me?", 1).requirement("Fishy Dishes", 1).requirement("Nice to Meat You", 1)
            .requirement("A Flood of Spuds", 1).requirement("Gnome More, I'm Full", 1).build());
        achievements.add(new AchievementBuilder("Smartest Harvest", 0.1).requirement("Plague's End", 1).requirement("Farming", 27)
            .requirement("Summoning", 78).requirement("Giant ent pouch", 1).requirement("Apple tree seed", 7).reward("Farming", 8907)
            .reward("Cooking apple", 63).build());
        achievements.add(new AchievementBuilder("Menaphos cactus patch", 0.15).requirement("The Jack of Spades", 1)
            .requirement("Acadia logs", 12).lamp(Collections.singletonList("Mining"), -8, 1)
            .lamp(Collections.singletonList("Construction"), -1, 1).build());
        achievements.add(new AchievementBuilder("Gotta Patch 'Em All", 0.5).requirement("Potato seed", 30).requirement("Marigold seed", 4)
            .requirement("Guam seed", 7).requirement("Limpwurt seed", 1).requirement("The Great Brain Robbery", 1)
            .requirement("My Arm's Big Adventure", 1).requirement("Plague's End", 1).requirement("Barley seed", 16)
            .requirement("Redberry seed", 5).requirement("Acorn", 6).requirement("Apple tree seed", 7)
            .requirement("Tirannwn Set Tasks - Medium", 1).requirement("Bittercap mushroom spore", 2)
            .requirement("Menaphos cactus patch", 1).requirement("Cactus seed", 2).requirement("The Prisoner of Glouphrie", 1)
            .requirement("Farming", 94).requirement("Royal Trouble", 1).requirement("Evil turnip seed", 1).requirement("Belladonna seed", 1)
            .requirement("Calquat tree seed", 1).requirement("Elder seed", 1).requirement("Crystal acorn points", 5)
            .requirement("Back to my Roots", 1).reward("Farming", 51632).build());
        achievements.add(new AchievementBuilder("Herb Your Enthusiasm", 1.2).requirement("Farming", 91).requirement("Guam seed", 1)
            .requirement("Marrentill seed", 1).requirement("Tarromin seed", 1).requirement("Harralander seed", 1)
            .requirement("Ranarr seed", 1).requirement("Spirit weed seed", 1).requirement("Toadflax seed", 1).requirement("Irit seed", 1)
            .requirement("Wergali seed", 1).requirement("Avantoe seed", 1).requirement("Kwuarm seed", 1).requirement("Bloodweed seed", 1)
            .requirement("Snapdragon seed", 1).requirement("Cadantine seed", 1).requirement("Lantadyme seed", 1)
            .requirement("Dwarf weed seed", 1).requirement("Torstol seed", 1).requirement("Fellstalk seed", 1).requirement("Hunter", 70)
            .reward("Grimy guam", 1).reward("Grimy marrentill", 1).reward("Grimy tarromin", 1).reward("Grimy harralander", 1)
            .reward("Grimy ranarr", 1).reward("Grimy spirit weed", 1).reward("Grimy toadflax", 1).reward("Grimy irit", 1)
            .reward("Grimy wergali", 1).reward("Grimy avantoe", 1).reward("Grimy kwuarm", 1).reward("Grimy bloodweed", 1)
            .reward("Grimy snapdragon", 1).reward("Grimy cadantine", 1).reward("Grimy lantadyme", 1).reward("Grimy dwarf weed", 1)
            .reward("Grimy torstol", 1).reward("Grimy fellstalk", 1).reward("Farming", 4327).reward("Hunter", 1750).build());
        achievements.add(new AchievementBuilder("Frozen snow impling 1", 0).requirement("Violet is Blue", 1).requirement("Agility", 20)
            .requirement("Attack", 20).requirement("Strength", 20).requirement("Defence", 20).requirement("Ranged", 20)
            .requirement("Prayer", 20).requirement("Constitution", 20).requirement("Crafting", 20).requirement("Mining", 20)
            .requirement("Smithing", 20).requirement("Fishing", 20).requirement("Cooking", 20).requirement("Firemaking", 20)
            .requirement("Woodcutting", 20).requirement("Runecrafting", 20).requirement("Dungeoneering", 20).requirement("Fletching", 20)
            .requirement("Herblore", 20).requirement("Thieving", 20).requirement("Magic", 20).requirement("Slayer", 20)
            .requirement("Farming", 20).requirement("Construction", 20).requirement("Hunter", 20).requirement("Summoning", 20)
            .requirement("Divination", 20).lamp(Player.ALL_SKILLS, 2000, 1).build());
        achievements.add(new AchievementBuilder("Frozen snow impling 2", 0).requirement("Violet is Blue", 1).requirement("Agility", 40)
            .requirement("Attack", 40).requirement("Strength", 40).requirement("Defence", 40).requirement("Ranged", 40)
            .requirement("Prayer", 40).requirement("Constitution", 40).requirement("Crafting", 40).requirement("Mining", 40)
            .requirement("Smithing", 40).requirement("Fishing", 40).requirement("Cooking", 40).requirement("Firemaking", 40)
            .requirement("Woodcutting", 40).requirement("Runecrafting", 40).requirement("Dungeoneering", 40).requirement("Fletching", 40)
            .requirement("Herblore", 40).requirement("Thieving", 40).requirement("Magic", 40).requirement("Slayer", 40)
            .requirement("Farming", 40).requirement("Construction", 40).requirement("Hunter", 40).requirement("Summoning", 40)
            .requirement("Divination", 40).lamp(Player.ALL_SKILLS, 8000, 1).build());
        achievements.add(new AchievementBuilder("Frozen snow impling 3", 0).requirement("Violet is Blue", 1).requirement("Agility", 60)
            .requirement("Attack", 60).requirement("Strength", 60).requirement("Defence", 60).requirement("Ranged", 60)
            .requirement("Prayer", 60).requirement("Constitution", 60).requirement("Crafting", 60).requirement("Mining", 60)
            .requirement("Smithing", 60).requirement("Fishing", 60).requirement("Cooking", 60).requirement("Firemaking", 60)
            .requirement("Woodcutting", 60).requirement("Runecrafting", 60).requirement("Dungeoneering", 60).requirement("Fletching", 60)
            .requirement("Herblore", 60).requirement("Thieving", 60).requirement("Magic", 60).requirement("Slayer", 60)
            .requirement("Farming", 60).requirement("Construction", 60).requirement("Hunter", 60).requirement("Summoning", 60)
            .requirement("Divination", 60).lamp(Player.ALL_SKILLS, 30000, 1).build());
        achievements.add(new AchievementBuilder("Frozen snow impling 4", 0).requirement("Violet is Blue", 1).requirement("Agility", 80)
            .requirement("Attack", 80).requirement("Strength", 80).requirement("Defence", 80).requirement("Ranged", 80)
            .requirement("Prayer", 80).requirement("Constitution", 80).requirement("Crafting", 80).requirement("Mining", 80)
            .requirement("Smithing", 80).requirement("Fishing", 80).requirement("Cooking", 80).requirement("Firemaking", 80)
            .requirement("Woodcutting", 80).requirement("Runecrafting", 80).requirement("Dungeoneering", 80).requirement("Fletching", 80)
            .requirement("Herblore", 80).requirement("Thieving", 80).requirement("Magic", 80).requirement("Slayer", 80)
            .requirement("Farming", 80).requirement("Construction", 80).requirement("Hunter", 80).requirement("Summoning", 80)
            .requirement("Divination", 80).lamp(Player.ALL_SKILLS, 50000, 1).build());
        achievements.add(new AchievementBuilder("To Thaw a Frozen Heart", 0).requirement("Frozen snow impling 1", 1)
            .requirement("Frozen snow impling 2", 1).requirement("Frozen snow impling 3", 1).requirement("Frozen snow impling 4", 1)
            .build());
        achievements.add(new AchievementBuilder("Banebane", 0).requirement("Defence", 80).requirement("Mining", 40)
            .requirement("Summer's End", 1).requirement("Bane pickaxe + 4", 0).requirement("Bane full helm + 4", 1)
            .requirement("Bane platebody + 4", 1).requirement("Bane platelegs + 4", 1).requirement("Bane gauntlets + 4", 1)
            .requirement("Bane armoured boots + 4", 1).reward("Mining", 557).build());
        achievements.add(new AchievementBuilder("I Love Dailyscape", 0.15).requirement("Mining", 81)
            .requirement("Desert Set Tasks - Elite", 1).requirement("Plague's End", 1).requirement("As A First Resort", 1)
            .requirement("Dungeoneering", 115).reward("Red sandstone", 75).reward("Crystal-flecked sandstone", 75).reward("Mining", 4920)
            .build());
        achievements.add(new AchievementBuilder("It's Mine! All Mine", 0.1).requirement("Copper mined", 1).requirement("Tin mined", 1)
            .requirement("Iron mined", 1).requirement("Coal mined", 1).requirement("Mithril mined", 1)
            .requirement("Adamantite mined", 1).requirement("Luminite mined", 1).requirement("Runite mined", 1)
            .requirement("Orichalcite mined", 1).requirement("Drakolith mined", 1).requirement("Necrite mined", 1)
            .requirement("Phasmatite mined", 1).requirement("Banite mined", 1).requirement("Light animica mined", 1)
            .requirement("Dark animica mined", 1).reward("Mining", 177).reward("Clay", 1).reward("Sandstone (2kg)", 1)
            .reward("Pure essence", 1).reward("Silver ore", 1).reward("Limestone", 1).reward("Granite (500g)", 1).build());
        achievements.add(new AchievementBuilder("My Sick Four Tick Trick", 0).reward("Mining", 30)
            .lamp(Collections.singletonList("Mining"), -10, 1).build());
        achievements.add(new AchievementBuilder("Purple Reign", 0).requirement("Fate of the Gods", 1).build());
        achievements.add(new AchievementBuilder("Shine On You Crazy Diamond", 0.05).requirement("Plague's End", 1).reward("Mining", 3200)
            .reward("Uncut diamond", 1).build());
        achievements.add(new AchievementBuilder("Suity Level Maximum", 0).requirement("Shards of the Earth", 1).requirement("Mining", 77)
            .requirement("Crystal skillchompa", 1).requirement("Necronium pickaxe", 0).reward("Mining", 792).build());
        achievements.add(new AchievementBuilder("The Light Begins To Shine", 0).requirement("Plague's End", 1).requirement("Mining", 90)
            .build());
        achievements.add(new AchievementBuilder("We Will Bury Them", 0.05).requirement("Smithing", 40)
            .requirement("Adamant full helm + 2", 1).requirement("Adamant platebody + 2", 1).requirement("Adamant armoured boots + 2", 1)
            .requirement("Adamant gauntlets + 2", 1).requirement("Adamant platelegs + 2", 1).reward("Smithing", 4080).build());
        achievements.add(new AchievementBuilder("Come Together", 0).requirement("Luminite injector", 1).build());
        achievements.add(new AchievementBuilder("Hot In Here", 0).requirement("Smithing", 60).requirement("Orikalkum bar", 1)
            .reward("Smithing", 350).reward("Orikalkum gauntlets", 1).build());
        achievements.add(new AchievementBuilder("The Knight Begins to Shine", 0).requirement("Defence", 70).requirement("Smithing", 70)
            .requirement("Necronium armoured boots", 0).requirement("Necronium bar", 1).build());
        achievements.add(new AchievementBuilder("Ritual of the Murderbat", 0.05).requirement("Bane longsword + 4", 1)
            .requirement("Abyssal whip", 1).requirement("Smithing", 80).reward("Smithing", 4000).reward("Abyssal bane longsword", 1)
            .build());
        achievements.add(new AchievementBuilder("Imcando Magic Can't Melt Elder Rune Boots", 0).requirement("Smithing", 90)
            .requirement("Magic", 43).requirement("Elder rune bar", 1).requirement("Nature rune", 3).requirement("Fire rune", 3)
            .reward("Magic", 159).build());
        achievements.add(new AchievementBuilder("Cheese and Biscuits", 0).requirement("Chef's Assistant", 1)
            .requirement("Bringing Home the Bacon", 1).requirement("Cooking", 57).requirement("Pot of cream", 5)
            .requirement("Vanilla cream cheese", 1).requirement("Chocolate cream cheese", 1).requirement("Strawberry cream cheese", 1)
            .requirement("Cream cheese", 2).requirement("Lemon", 1).requirement("Bacon", 1).requirement("Biscuits", 5)
            .reward("Cooking", 9000).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw I", 0).requirement("Ambassador group kills", 5).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw II", 0).requirement("Ambassador group kills", 10).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw III", 0).requirement("Ambassador group kills", 25).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw IV", 0).requirement("Ambassador group kills", 50).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw V", 0).requirement("Ambassador group kills", 75).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw VI", 0).requirement("Ambassador group kills", 100).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw Solo Kills I", 0).requirement("Ambassador solo kills", 5).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw Solo Kills II", 0).requirement("Ambassador solo kills", 10).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw Solo Kills III", 0).requirement("Ambassador solo kills", 25).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw Solo Kills IV", 0).requirement("Ambassador solo kills", 50).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw Solo Kills V", 0).requirement("Ambassador solo kills", 75).build());
        achievements.add(new AchievementBuilder("Ambassador No Maw Solo Kills VI", 0).requirement("Ambassador solo kills", 100).build());
        achievements.add(new AchievementBuilder("Denied the Hydra I", 0).requirement("Crassian Leviathan group kills", 5).build());
        achievements.add(new AchievementBuilder("Denied the Hydra II", 0).requirement("Crassian Leviathan group kills", 10).build());
        achievements.add(new AchievementBuilder("Denied the Hydra III", 0).requirement("Crassian Leviathan group kills", 25).build());
        achievements.add(new AchievementBuilder("Denied the Hydra IV", 0).requirement("Crassian Leviathan group kills", 50).build());
        achievements.add(new AchievementBuilder("Denied the Hydra V", 0).requirement("Crassian Leviathan group kills", 75).build());
        achievements.add(new AchievementBuilder("Denied the Hydra VI", 0).requirement("Crassian Leviathan group kills", 100).build());
        achievements.add(new AchievementBuilder("Denied the Hydra Solo Kills I", 0).requirement("Crassian Leviathan solo kills", 5)
            .build());
        achievements.add(new AchievementBuilder("Denied the Hydra Solo Kills II", 0).requirement("Crassian Leviathan solo kills", 10)
            .build());
        achievements.add(new AchievementBuilder("Denied the Hydra Solo Kills III", 0).requirement("Crassian Leviathan solo kills", 25)
            .build());
        achievements.add(new AchievementBuilder("Denied the Hydra Solo Kills IV", 0).requirement("Crassian Leviathan solo kills", 50)
            .build());
        achievements.add(new AchievementBuilder("Denied the Hydra Solo Kills V", 0).requirement("Crassian Leviathan solo kills", 75)
            .build());
        achievements.add(new AchievementBuilder("Denied the Hydra Solo Kills VI", 0).requirement("Crassian Leviathan solo kills", 100)
            .build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings I", 0).requirement("Taraket the Necromancer group kills", 5)
            .build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings II", 0).requirement("Taraket the Necromancer group kills", 10)
            .build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings III", 0)
            .requirement("Taraket the Necromancer group kills", 25).build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings IV", 0).requirement("Taraket the Necromancer group kills", 50)
            .build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings V", 0).requirement("Taraket the Necromancer group kills", 75)
            .build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings VI", 0)
            .requirement("Taraket the Necromancer group kills", 100).build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings Solo Kills I", 0)
            .requirement("Taraket the Necromancer solo kills", 5)
            .build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings Solo Kills II", 0)
            .requirement("Taraket the Necromancer solo kills", 10).build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings Solo Kills III", 0)
            .requirement("Taraket the Necromancer solo kills", 25).build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings Solo Kills IV", 0)
            .requirement("Taraket the Necromancer solo kills", 50).build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings Solo Kills V", 0)
            .requirement("Taraket the Necromancer solo kills", 75).build());
        achievements.add(new AchievementBuilder("Reset to Phylactery Settings Solo Kills VI", 0)
            .requirement("Taraket the Necromancer solo kills", 100).build());
        achievements.add(new AchievementBuilder("Ambi", 0).requirement("Ambassador solo kills", 130).build());
        achievements.add(new AchievementBuilder("Spinal Surgery", 0).requirement("Magic", 30).build());
        achievements.add(new AchievementBuilder("Spud That", 0).requirement("Raw potato", 0).build());
        achievements.add(new AchievementBuilder("Swings Both Ways", 0.25).requirement("Agility", 85).reward("Agility", 41080)
            .reward("Codex page", 20).build());
        achievements.add(new AchievementBuilder("In A Flash", 0.1).requirement("Agility", 85).reward("Agility", 21040)
            .reward("Codex page", 10).build());
        achievements.add(new AchievementBuilder("End Of The World", 0.05).requirement("Attack", 81).requirement("Slayer", 114).build());
        achievements.add(new AchievementBuilder("Father And Son", 0.05).build());
        achievements.add(new AchievementBuilder("Stone Cold Observers", 0.1).build());
        achievements.add(new AchievementBuilder("Gotta Go Fast", 0).requirement("Double Surge codex (tradeable)", 1)
            .requirement("Double Escape codex (tradeable)", 1).build());
        achievements.add(new AchievementBuilder("Do You Think He Saw Us?", 0.2).requirement("Raw shark", 0).requirement("Raw sailfish", 0)
            .requirement("Raw manta ray", 0).requirement("Raw bagrada rex meat", 0).requirement("Raw arcane apoterrasaur meat", 0)
            .requirement("Raw scimitops meat", 0).requirement("Raw asciatops meat", 0).requirement("Raw corbicula rex meat", 0)
            .requirement("Raw spicati apoterrasaur meat", 0).requirement("Hunter", 96).requirement("Slayer", 76).build());
        achievements.add(new AchievementBuilder("Three in a Bed", 0.1).requirement("Hunter", 75).requirement("Slayer", 55)
            .requirement("Raw shark", 1).reward("Hunter", 24000).reward("Slayer", 8400).reward("Fletching", 150)
            .reward("Big game hunted", 3).lamp(Collections.singletonList("Woodcutting"), -36, 1)
            .lamp(Collections.singletonList("Herblore"), -15, 1).build());
        achievements.add(new AchievementBuilder("A New Direction", 0.05).requirement("Big game hunted", 1).build());
        achievements.add(new AchievementBuilder("A Fresh Batch", 0).requirement("Eye of newt", 1).requirement("Guam potion (unf)", 1)
            .reward("Herblore", 25).reward("Attack potion (3)", 1).build());
        achievements.add(new AchievementBuilder("Bottoms Up", 0).requirement("Attack potion (3)", 1).reward("Attack potion (2)", 1)
            .build());
        achievements.add(new AchievementBuilder("Guam Fly With Me", 0).requirement("Grimy guam", 1).reward("Clean guam", 1)
            .reward("Herblore", 2).build());
        achievements.add(new AchievementBuilder("Crystal pickaxe", 0).requirement("Plague's End", 1).requirement("Dragon pickaxe", 1)
            .requirement("Harmonic dust", 4000).build());
        achievements.add(new AchievementBuilder("A Song of Earth and Pickaxes", 0).requirement("Smithing", 90)
            .requirement("Imcando Attitude", 1).requirement("Crystal pickaxe", 1).requirement("While Guthix Sleeps", 1)
            .requirement("Coins", 1000000).build());
        achievements.add(new AchievementBuilder("Got To Go Around It", 0.1).requirement("Hunter", 75).requirement("Slayer", 55)
            .requirement("Raw shark", 1).reward("Hunter", 8000).reward("Slayer", 2800).reward("Fletching", 50).reward("Herblore", 5)
            .reward("Big game hunted", 1).lamp(Collections.singletonList("Woodcutting"), -12, 1).build());
        achievements.add(new AchievementBuilder("In and Out, Nice and Slow", 0.1).requirement("Hunter", 75).requirement("Slayer", 55)
            .requirement("Raw shark", 1).reward("Hunter", 8000).reward("Slayer", 2800).reward("Fletching", 50).reward("Herblore", 5)
            .reward("Big game hunted", 1).lamp(Collections.singletonList("Woodcutting"), -12, 1).build());
        achievements.add(new AchievementBuilder("Not What We Mean By Irony", 0).requirement("Iron pickaxe", 0).build());
        achievements.add(new AchievementBuilder("All's Ferrous in Love and War", 0).requirement("Iron platelegs", 0)
            .requirement("Defence", 10).build());
    }

    public static AchievementDatabase getAchievementDatabase() {
        if (achievementDatabase == null) {
            achievementDatabase = new AchievementDatabase();
        }
        return achievementDatabase;
    }

    public Map<String, Achievement> getAchievements() {
        return namedAchievements;
    }
}
