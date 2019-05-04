package data.databases;

import com.google.common.collect.ImmutableMap;
import data.dataobjects.*;
import logic.*;

import java.util.*;
import java.util.stream.Collectors;

public class ActionDatabase {
    
    private static ActionDatabase actionDatabase;

    private static final int TICKS_PER_HOUR = 6000;
    private List<Action> database = new ArrayList<>();

    private ActionDatabase() {
    }

    private void addActionsToDatabase(Player player) {

        //Placeholder for dailies/spawns/shops/etc (move when applicable feature is fully implemented)
        database.add(new Action("Rosie's daily supplies", Collections.singletonList(new Requirement("Impressing the Locals", 1)),
            new HashMap(), ImmutableMap.of("Supplies", 60), 12, true, true));
        database.add(new Action("Collecting planks", new ArrayList(), new HashMap(), ImmutableMap.of("Plank", 240), 240, true, true));
        database.add(new Action("Buying cleansing crystals", Collections.singletonList(new Requirement("Plague's End", 1)),
            ImmutableMap.of("Coins", 39600000), ImmutableMap.of("Cleansing crystal", 360), 360, true, true));

        //Player-owned-ports
        database.add(new Action("POP - Arc region voyages", Collections.singletonList(new Requirement("Ports unlocked", 1)), new HashMap(),
            ImmutableMap.of("Port distance", 5000, "Port chimes", 1600, "Port bamboo", 1600), 20, true, true));
        database.add(new Action("POP - Skull region voyages", Collections.singletonList(new Requirement("Port distance", 5000)), new HashMap(),
            ImmutableMap.of("Port distance", 12000, "Port chimes", 6000, "Port gunpowder", 3000), 20, true, true));
        database.add(new Action("POP - Hook region voyages", Collections.singletonList(new Requirement("Port distance", 40000)), new HashMap(),
            ImmutableMap.builder().put("Port distance", 24000).put("Port chimes", 10000).put("Port slate", 3000).put("Lacquer", 1).put("Ancient bones", 1)
                .put("Plate", 1).put("Pearls", 1).put("Chi", 1).put("Koi scales", 1).put("Spices", 10).build(), 20, true, true));
        database.add(new Action("POP - Scythe region voyages", Collections.singletonList(new Requirement("Port distance", 140000)), new HashMap(),
            ImmutableMap.builder().put("Port distance", 48000).put("Port chimes", 13000).put("Port cherrywood", 4000).put("Lacquer", 2).put("Ancient bones", 2)
                .put("Plate", 2).put("Pearls", 2).put("Chi", 2).put("Koi scales", 2).put("Spices", 20).build(), 20, true, true));
        database.add(new Action("POP - Bowl region voyages", Collections.singletonList(new Requirement("Port distance", 450000)), new HashMap(),
            ImmutableMap.builder().put("Port distance", 96000).put("Port chimes", 20000).put("Port jade", 7200).put("Lacquer", 3).put("Ancient bones", 3)
                .put("Plate", 3).put("Pearls", 3).put("Chi", 3).put("Koi scales", 3).put("Spices", 30).build(), 20, true, true));

        //Gathering or money making
        database.add(new Action("Picking potatoes", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Raw potato", 690), 690, true, true));
        database.add(new Action("Anima Islands", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Anima Islands Reward Currency", 3000), 3, true, true));
        database.add(new Action("Voyaging for items", Collections.singletonList(new Requirement("Impressing the Locals", 1)),
            ImmutableMap.of("Supplies", 300), ImmutableMap.builder().put("Taijitu", 26).put("Sea shell", 9).put("Driftwood", 9).put("Sea salt", 9)
            .put("Bamboo", 9).put("Shell chippings", 9).put("Spirit dragon charm", 9).put("Raw tarpon", 9).put("Bundle of bamboo", 9)
            .put("Fish oil", 9).put("Stoneberry seed", 1).put("Stormberry seed", 1).put("Shiny shell chippings", 9).put("Wobbegong oil", 9)
            .put("Alaea sea salt", 9).put("Uncharted Isles visited", 60).build(), 60, true, true));
        database.add(new Action("Winning Castle Wars games", new ArrayList(), new HashMap(), ImmutableMap.of("Gold Castle Wars ticket", 6), 3, true, true));
        database.add(new Action("Winning Soul Wars games", new ArrayList(), new HashMap(), ImmutableMap.of("Zeal", 9), 3, true, true));
        database.add(new Action("Playing Barbarian Assault", new ArrayList(), new HashMap(), ImmutableMap.of("Honour Points", 1000, "Penance Queen", 1), 25, true, true));
        database.add(new Action("Opening prawn balls", new ArrayList(), ImmutableMap.of("Prawn balls", 3000), ImmutableMap.of("Golden fish egg", 15, "Treasure chest decoration", 90), 3000, true, true));
        database.add(new Action("Picking bananas", new ArrayList(), ImmutableMap.of("Basket", 552), ImmutableMap.of("Bananas (5)", 552, "Banana", 120), 552, true, true));
        database.add(new Action("Casting egg spawn", Collections.singletonList(new Requirement("Summoning", 10)), ImmutableMap.of("Egg spawn scroll", 520, "Spirit spider pouch", 4,
            "Summoning potion (4)", 18), ImmutableMap.of("Red spiders' eggs", 936, "Summoning", 105, "Summoning pet points", totalPetPoints(player, "Summoning", 105)), 520, true, true));
        database.add(new Action("Managing Miscellania (Woodcutting)", Collections.singletonList(new Requirement("Throne of Miscellania", 1)), ImmutableMap.of("Coins", 1000000),
            ImmutableMap.of("Maple logs", 17840, "Bird's nest", 160), 20, true, true));
        database.add(new Action("Dominion Tower", Collections.singletonList(new Requirement("Dominion Tower unlocked", 1)), new HashMap<>(),
            ImmutableMap.of("Dominion tower bosses", 60, "Dominion page", 6), 3, true, true));
        database.add(new Action("Buying bear fur", new ArrayList(), ImmutableMap.of("Coins", 15500), ImmutableMap.of("Bear fur", 775), 775, true, true));
        database.add(new Action("Buying dragon bitter", new ArrayList(), ImmutableMap.of("Coins", 672), ImmutableMap.of("Dragon bitter", 336), 336, true, true));
        database.add(new Action("Collecting swamp toads", new ArrayList(), new HashMap(), ImmutableMap.of("Swamp toad", 700), 700, true, true));
        database.add(new Action("Making oak planks", new ArrayList(), ImmutableMap.of("Oak logs", 9000, "Portable sawmill", 12, "Coins", 2025000),
            ImmutableMap.of("Oak plank", 9000), 12, false, false));
        database.add(new Action("Shearing sheep", new ArrayList(), new HashMap(), ImmutableMap.of("Wool", 630), 630, true, true));
        database.add(new Action("Tanning cowhides", new ArrayList(), ImmutableMap.of("Cowhide", 60000, "Portable crafter", 12), ImmutableMap.of("Leather", 60000), 12, false, false));
        database.add(new Action("Collecting honeycomb", new ArrayList(), new HashMap(), ImmutableMap.of("Honeycomb", 1296), 1296, true, true));
        database.add(new Action("Cutting granite", new ArrayList(), ImmutableMap.of("Granite (2kg)", 1800), ImmutableMap.of("Granite (500g)", 7200), 1800, true, true));
        database.add(new Action("Tanning red dragonhide", new ArrayList(), ImmutableMap.of("Red dragonhide", 60000, "Portable crafter", 12, "Coins", 200000),
            ImmutableMap.of("Red dragon leather", 60000), 12, false, false));
        database.add(new Action("Tanning black dragonhide", new ArrayList(), ImmutableMap.of("Black dragonhide", 60000, "Portable crafter", 12, "Coins", 200000),
            ImmutableMap.of("Black dragon leather", 60000), 12, false, false));
        database.add(new Action("Tanning royal dragonhide", new ArrayList(), ImmutableMap.of("Royal dragonhide", 60000, "Portable crafter", 12, "Coins", 200000),
            ImmutableMap.of("Royal dragon leather", 60000), 12, false, false));
        Map<Integer, List<Requirement>> chickenKillsAndReqs = combatKills(new Encounter("Chicken"), player, 28, "Magic", 1, true);
        int chickenKills = chickenKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> chickenReqs = new ArrayList<>(chickenKillsAndReqs.values().iterator().next());
        database.add(new Action("Killing chickens for money", chickenReqs, new HashMap(), ImmutableMap.builder()
            .put("aCombat", (int)Enemy.getEnemyByName("Chicken").getCbxp() * chickenKills)
            .put("Constitution", (int)Enemy.getEnemyByName("Chicken").getHpxp() * chickenKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Chicken").getHpxp() * chickenKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int)Enemy.getEnemyByName("Chicken").getCbxp() * chickenKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int)Enemy.getEnemyByName("Chicken").getCbxp() * chickenKills)/2))
            .put("Raw chicken", chickenKills).put("Egg", chickenKills).put("Feather", chickenKills*4).build(), chickenKills, true, true));

        //Agility
        database.add(new Action("Burthorpe Agility Course", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Agility", 11955, "Agility level-ticks", 6000*player.getLevel("Agility")), 150, true, true));
        database.add(new Action("Gnome Stronghold Agility Course", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Agility", 8650, "Agility level-ticks", 6000*player.getLevel("Agility")), 100, true, true));
        database.add(new Action("Agility Pyramid", Collections.singletonList(new Requirement("Agility", 30)), ImmutableMap.of("Waterskin (4)", 10),
            ImmutableMap.of("Waterskin (0)", 10, "Agility", 26708, "Pyramid top", 22, "Agility level-ticks", 6000*Math.max(30,player.getLevel("Agility"))), 22, true, true));
        database.add(new Action("Brimhaven Agility Arena", Collections.singletonList(new Requirement("Agility", 40)), ImmutableMap.of("Coins", 200),
            ImmutableMap.of("Agility arena ticket", 60, "Agility", 3000, "Agility level-ticks", 6000*Math.max(40,player.getLevel("Agility"))), 60, true, true));
        database.add(new Action("Empty Throne Room agility", Arrays.asList(new Requirement("Agility", 65), new Requirement("The Dig Site", 1)),
            new HashMap(), ImmutableMap.of("Agility", 68760, "Senntisten scroll", 17, "Agility level-ticks", 6000*Math.max(65,player.getLevel("Agility"))), 1800, true, true));
        database.add(new Action("Hefin Agility Course (77-81 Agility)", Arrays.asList(new Requirement("Plague's End", 1),
            new Requirement("Agility", 77)), new HashMap(), ImmutableMap.of("Agility", 56320, "Hefin Agility Course laps", 80, "Agility level-ticks", 6000*Math.max(77,player.getLevel("Agility"))), 80, true, true));
        database.add(new Action("Advanced Gnome Stronghold Agility Course", Collections.singletonList(new Requirement("Agility", 85)),
            new HashMap(), ImmutableMap.of("Agility", 68150, "Advanced Gnome Stronghold laps", 94, "Agility level-ticks", 6000*Math.max(85,player.getLevel("Agility"))), 34, true, true));
        database.add(new Action("Advanced Barbarian Outpost Agility Course", Arrays.asList(new Requirement("Bar Crawl", 1),
            new Requirement("Agility", 90)), new HashMap(), ImmutableMap.of("Agility", 72355, "Advanced Barbarian Outpost laps", 96, "Agility level-ticks", 6000*Math.max(90,player.getLevel("Agility"))),
            96, true, true));


        //Construction
        database.add(new Action("Building crude wooden chairs with bronze nails", new ArrayList(), ImmutableMap.of("Plank", 490, "Bronze nails", 1470),
            ImmutableMap.of("Construction", 16170, "Construction pet points", totalPetPoints(player, "Construction", 16170)), 490, true, true));

        //Cooking (done to lv5)
        database.add(new Action("Cooking raw beef", new ArrayList<>(),
            ImmutableMap.of("Raw beef", 1300), ImmutableMap.of("Cooked meat", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
            "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
            "Cooking pet points", totalPetPoints(player, "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking shrimps", new ArrayList<>(), ImmutableMap.of("Raw shrimps", 1300),
            ImmutableMap.of("Shrimps", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking pet points", totalPetPoints(player, "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking crayfish", new ArrayList<>(), ImmutableMap.of("Raw crayfish", 1300),
            ImmutableMap.of("Crayfish", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking pet points", totalPetPoints(player, "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking chicken", new ArrayList<>(), ImmutableMap.of("Raw chicken", 1300),
            ImmutableMap.of("Cooked chicken", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking pet points", totalPetPoints(player, "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking sardines", new ArrayList<>(), ImmutableMap.of("Raw sardine", 1300),
            ImmutableMap.of("Sardine", (int) Math.floor(1300 * Math.min(1, 1 - (38 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(52000 * Math.min(1, 1 - (38 - player.getLevel("Cooking")) / 100.0)),
                "Cooking pet points", totalPetPoints(player, "Cooking", (int) Math.floor(52000 * Math.min(1, 1 - (38 - player.getLevel("Cooking")) / 100.0)))),
            (int) Math.floor(1300 * Math.min(1, 1 - (38 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking anchovies", new ArrayList<>(), ImmutableMap.of("Raw anchovies", 1300),
            ImmutableMap.of("Anchovies", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking pet points", totalPetPoints(player, "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Making uncooked arc gumbo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 94)),
            ImmutableMap.of("Bundle of bamboo", 1300, "Tortle shell bowl", 1300, "Rumberry", 1300, "Fish oil", 1300, "Sea salt", 1300), ImmutableMap.of("Uncooked arc gumbo", 1300,
            "Cooking", 13000, "Cooking pet points", totalPetPoints(player, "Cooking", 13000)), 1300, true, true));

        database.add(new Action("Cooking arc gumbo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 94)),
            ImmutableMap.of("Uncooked arc gumbo", 1300), ImmutableMap.of("Arc gumbo", 1300, "Cooking", 169000, "Cooking pet points", totalPetPoints(player, "Cooking", 169000), "Azure Parrot", 21),
            1300, true, true));

        database.add(new Action("Making uncooked shark soup", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 96)),
            ImmutableMap.of("Bundle of bamboo", 1300, "Shiny tortle shell bowl", 1300, "Sliced mushrooms", 1300, "Wobbegong oil", 1300, "Alaea sea salt", 1300), ImmutableMap.of("Uncooked shark soup", 1300,
            "Cooking", 13000, "Cooking pet points", totalPetPoints(player, "Cooking", 13000)), 1300, true, true));

        database.add(new Action("Cooking shark soup", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 96)),
            ImmutableMap.of("Uncooked shark soup", 1300), ImmutableMap.of("Shark soup", 1300, "Cooking", 312000, "Cooking pet points", totalPetPoints(player, "Cooking", 312000), "Azure Parrot", 21),
            1300, true, true));


        //Crafting (done to lv3)
        database.add(new Action("Making soft clay", new ArrayList(), ImmutableMap.of("Clay", 2212), ImmutableMap.of("Soft clay", 2212, "Crafting", 2212,
            "Crafting pet points", totalPetPoints(player, "Crafting", 2212)), 2212, true, true));
        database.add(new Action("Spinning wool", new ArrayList(), ImmutableMap.of("Wool", 1400), ImmutableMap.of("Ball of wool", 1400, "Crafting", 3500,
            "Crafting pet points", totalPetPoints(player, "Crafting", 3500)), 1400, true, true));

        database.add(new Action("Crafting molten glass", new ArrayList<>(), ImmutableMap.of("Soda ash", 1250, "Bucket of sand", 1250), ImmutableMap.of("Molten glass", 1250, "Crafting", 25000,
            "Crafting pet points", totalPetPoints(player, "Crafting", 25000)), 1250, true, true));
        database.add(new Action("Spinning flax", new ArrayList(), ImmutableMap.of("Flax", 1400), ImmutableMap.of("Bowstring", 1400, "Crafting", 21000,
            "Crafting pet points", totalPetPoints(player, "Crafting", 21000)), 1400, true, true));
        database.add(new Action("Making cracked mining urns (nr)", new ArrayList(), ImmutableMap.of("Soft clay", 1120), ImmutableMap.of("Cracked mining urn (nr)", 560, "Crafting", 16016,
            "Crafting pet points", totalPetPoints(player, "Crafting", 16016)), 560, true, true));
        database.add(new Action("Making cracked cooking urns (nr)", Collections.singletonList(new Requirement("Crafting", 2)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Cracked cooking urn (nr)", 560, "Crafting", 16800, "Crafting pet points", totalPetPoints(player, "Crafting", 16800)), 560, true, true));

        database.add(new Action("Ithell harps (w/o VoS)", Collections.singletonList(new Requirement("Plague's End", 1)), new HashMap(),
            ImmutableMap.of("Crafting", 560*player.getLevel("Crafting"), "Harmonic dust", 7*player.getLevel("Crafting"), "Construction", 10000,
                "Crafting pet points", totalPetPoints(player, "Crafting", 560*player.getLevel("Crafting")),
                "Construction pet points", totalPetPoints(player, "Construction", 10000)), 7*player.getLevel("Crafting"), true, true));

        database.add(new Action("Making tortle shell bowls", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Crafting", 91)),
            ImmutableMap.of("Shell chippings", 6800), ImmutableMap.of("Tortle shell bowl", 1700, "Crafting", 127500, "Crafting pet points", totalPetPoints(player, "Crafting", 127500)), 1700, true, true));

        database.add(new Action("Making shiny tortle shell bowls", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Crafting", 92)),
            ImmutableMap.of("Shiny shell chippings", 6800), ImmutableMap.of("Shiny tortle shell bowl", 1700, "Crafting", 170000, "Crafting pet points", totalPetPoints(player, "Crafting", 170000)),
            1700, true, true));

        //Divination (1300 harvests, 900 + enr conversions) (done to lv9)
        database.add(new Action("Pale wisps (no bought energy)", new ArrayList<>(), new HashMap<>(),
            ImmutableMap.of("Divination", 4000, "Pale energy", 1300, "Memory strand", 288, "Divination level-ticks", 6000*player.getLevel("Divination")), 1300, true, true));

        database.add(new Action("Pale wisps (with bought energy)", new ArrayList<>(), ImmutableMap.of("Pale energy", 3200),
            ImmutableMap.of("Divination", 4630, "Memory strand", 288, "Divination level-ticks", 6000*player.getLevel("Divination")), 1300, true, true));

        database.add(new Action("Cursed wisps (level 1-9)", new ArrayList(), new HashMap<>(), ImmutableMap.of("Divination", 6850, "Pale energy", 1950, "Memory strand", 288,
            "Divination level-ticks", 6000*player.getLevel("Divination")), 1300, true, false));

        database.add(new Action("Elder wisps", Collections.singletonList(new Requirement("Fate of the Gods", 1)), new HashMap(), ImmutableMap.builder().put("Divination", 41200).put("Elder energy", 3900)
            .put("Elder chronicle fragment", 4).put("Hunter", player.getLevel("Hunter")*40).put("Memory strand", 288).put("Divination level-ticks", 6000*Math.max(75,player.getLevel("Divination")))
            .put("Divination fragments", 1200).build(), 1300, true, true));

        database.add(new Action("Luminous wisps (no bought energy)", Collections.singletonList(new Requirement("Divination", 90)),
            new HashMap(), ImmutableMap.builder().put("Divination", 71000).put("Luminous energy", 3900).put("Fly dragon", 1).put("Fruit fly", 1).put("Memory strand", 288)
            .put("Divination level-ticks", 6000*Math.max(90,player.getLevel("Divination"))).put("Divination fragments", 1200).build(), 1300, true, true));
        database.add(new Action("Positive springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 90)), new HashMap(), ImmutableMap.of("Divination", 60300, "Positive energy", 600, "Memory strand", 288,
            "Divination level-ticks", 6000*Math.max(90,player.getLevel("Divination")), "Divination fragments", 1200), 600, true, true));
        database.add(new Action("Ancestral springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 95)), new HashMap(), ImmutableMap.builder().put("Divination", 96300).put("Ancestral energy", 600).put("Cyansoul Kakapo", 1).put("Memory strand", 288)
            .put("Divination level-ticks", 6000*Math.max(95,player.getLevel("Divination"))).put("Divination fragments", 1200).build(), 600, true, true));

        database.add(new Action("Hall of Memories (lustrous)", Collections.singletonList(new Requirement("Divination", 70)), new HashMap(), ImmutableMap.of("Lustrous hall memories", 300,
            "Divination", 60000, "Divination level-ticks", 6000*Math.max(70,player.getLevel("Divination"))), 1500, true, true));

        database.add(new Action("Hall of Memories (brilliant)", Collections.singletonList(new Requirement("Divination", 80)), new HashMap(), ImmutableMap.of("Brilliant hall memories", 300,
            "Divination", 90000, "Divination level-ticks", 6000*Math.max(80,player.getLevel("Divination"))), 1500, true, true));

        database.add(new Action("Hall of Memories (radiant)", Collections.singletonList(new Requirement("Divination", 85)), new HashMap(), ImmutableMap.of("Radiant hall memories", 300,
            "Divination", 135000, "Divination level-ticks", 6000*Math.max(85,player.getLevel("Divination"))), 1500, true, true));

        database.add(new Action("Hall of Memories (luminous)", Collections.singletonList(new Requirement("Divination", 90)), new HashMap(), ImmutableMap.of("Luminous hall memories", 300,
            "Divination", 200000, "Divination level-ticks", 6000*Math.max(90,player.getLevel("Divination"))), 1500, true, true));

        database.add(new Action("Hall of Memories (incandescent)", Collections.singletonList(new Requirement("Divination", 95)), new HashMap(), ImmutableMap.of("Incandescent hall memories", 300,
            "Divination", 300000, "Divination level-ticks", 6000*Math.max(95,player.getLevel("Divination"))), 1500, true, true));

        //Dungeoneering (major approximation, assumes 7.5 minute floors)
        //4000 * Math.pow((player.getLevel("Dungeoneering") + 9.0) / 10.0, 2));
        database.add(new Action("Solo dungeoneering (floor 1 max)", new ArrayList(), new HashMap(), ImmutableMap.of("Dungeoneering", 4000, "Dungeoneering token",
            400, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 4000), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Solo dungeoneering (incl. fragments)", Collections.singletonList(new Requirement("Dungeoneering", 70)), new HashMap(),
            ImmutableMap.of("Dungeoneering", 250000, "Dungeoneering token", 25000, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 250000),
                "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800), 8, true, true));
        database.add(new Action("Solo dungeoneering (incl. unreadable pages)", Collections.singletonList(new Requirement("Plague's End", 1)),
            new HashMap(), ImmutableMap.builder().put("Dungeoneering", 280000).put("Dungeoneering token", 28000).put("Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 280000))
            .put("Dungeoneering floors completed", 8).put("Dungeoneering fragment", 800).put("Unreadable page points", (int)Math.floor(135305*Math.pow(1.0313, player.getLevel("Dungeoneering")-75)))
            .build(), 8, true, true));

        //Farming
        database.add(new Action("Farming potatoes (w/o payments)", new ArrayList(), ImmutableMap.of("Potato seed", 162, "Supercompost", 54),
            ImmutableMap.of("Raw potato", 464, "Farming", 5758, "Farming pet points", totalPetPoints(player, "Farming", 5758)), 6, true, true));
        database.add(new Action("Farming potatoes (w/ payments)", new ArrayList(), ImmutableMap.of("Potato seed", 162, "Supercompost", 54, "Compost", 60),
            ImmutableMap.of("Raw potato", 540, "Farming", 6696, "Farming pet points", totalPetPoints(player, "Farming", 6696)), 6, true, true));

        database.add(new Action("Farming/selling rabbits for beans", Collections.singletonList(new Requirement("Granny Knows Best", 1)), ImmutableMap.of("Common brown rabbit (unchecked)", 20),
            ImmutableMap.of("Farming", 2000, "POF bean", 500, "Rabbit teeth", 40, "Farming pet points", totalPetPoints(player, "Farming", 2000)), 20, true, true));

        database.add(new Action("Foraging rumberries (keep)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), ImmutableMap.of("Farming", 30000, "Rumberry", 300, "Rumberry seed", 6, "Pumpkin Limpkin", 1,
            "Farming pet points", totalPetPoints(player, "Farming", 30000)), 300, true, true));

        database.add(new Action("Foraging rumberries (sell)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), ImmutableMap.of("Farming", 30000, "Chimes", 618, "Farming pet points", totalPetPoints(player, "Farming", 30000)), 300, true, true));

        database.add(new Action("Foraging exuberries (keep)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), ImmutableMap.of("Farming", 30000, "Exuberry", 300, "Exuberry seed", 6, "Farming pet points", totalPetPoints(player, "Farming", 30000)),
            300, true, true));

        database.add(new Action("Foraging mushrooms on named islands", Arrays.asList(new Requirement("Farming", 90),
            new Requirement("Impressing the Locals", 1)), new HashMap(), ImmutableMap.of("Farming", 30000, "Named mushrooms", 10,
            "Farming pet points", totalPetPoints(player, "Farming", 30000)), 300, true, true));

        database.add(new Action("Foraging mushrooms on Uncharted Isles", Arrays.asList(new Requirement("Farming", 94),
            new Requirement("Impressing the Locals", 1)), ImmutableMap.of("Supplies", 60), ImmutableMap.of("Farming", 50000, "Uncharted mushrooms", 7, "Slicing mushrooms", 1200,
            "Farming pet points", totalPetPoints(player, "Farming", 50000)), 1200, true, true));

        //Firemaking
        database.add(new Action("Burning normal logs on bonfire", new ArrayList(), ImmutableMap.of("Logs", 950), ImmutableMap.of("Firemaking", 47500,
            "Firemaking level-ticks", 6000*player.getLevel("Firemaking")), 950, true, true));
        database.add(new Action("Burning normal logs in lines", new ArrayList(), ImmutableMap.of("Logs", 1200), ImmutableMap.of("Firemaking", 48000,
            "Firemaking level-ticks", 6000*player.getLevel("Firemaking")), 1200, true, true));
        database.add(new Action("Burning acadia logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 46)), ImmutableMap.of("Acadia logs", 950),
            ImmutableMap.of("Firemaking", 171000, "Menaphite honey bee", 1, "Fruit fly in amber", 1, "Firemaking level-ticks", 6000*Math.max(46,player.getLevel("Firemaking"))), 950, true, true));

        //Fishinng
        database.add(new Action("Fishing raw crayfish", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Fishing", 10 * fishCaught(player, 1), "Prawn balls", fishCaught(player, 1)/175,
            "Fishing level-ticks", 6000*player.getLevel("Fishing")), fishCaught(player, 1), true, true));

        database.add(new Action("Fishing/dropping desert sole", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Fishing", 52)),
            new HashMap(), ImmutableMap.builder().put("Fishing", 60 * resourcesGained(70, 5.0, player, 0.0, "Fishing")).put("Menaphos reputation",
            3 * resourcesGained(70, 5.0, player, 0.0, "Fishing")).put("Prawn balls", 1450*resourcesGained(70, 5.0, player, 0.0, "Fishing")/35000)
            .put("Clicker kalphite in amber", 1).put("Desert locust in amber", 1).put("Fishing level-ticks", 6000*Math.max(52,player.getLevel("Fishing")))
            .put("Wavecrest opal", 1).put("Maw coral", 1).build(), resourcesGained(70, 5.0, player, 0.0, "Fishing"), true, true));

        database.add(new Action("Barbarian fly fishing", Arrays.asList(new Requirement("Fishing", 70), new Requirement("Strength", 45), new Requirement("Agility", 45),
            new Requirement("Barbarian Fishing", 1)), new HashMap<>(), ImmutableMap.of("Fishing", 62 * (650+5*player.getLevel("Fishing")), "Strength", (int)Math.floor(4.9 * (650+5*player.getLevel("Fishing"))),
            "Agility", (int)Math.floor(4.9 * (650+5*player.getLevel("Fishing"))), "Shark fragment", 1200, "Fishing level-ticks", 6000*Math.max(70,player.getLevel("Fishing"))),
            (650+5*player.getLevel("Fishing")), true, true));

        //Fletching
        database.add(new Action("Fletching arrow shafts with normal logs", new ArrayList(), ImmutableMap.of("Logs", 1800), ImmutableMap.of("Arrow shaft", 27000,
            "Fletching", 9000, "Fletching pet points", totalPetPoints(player, "Fletching", 9000)), 1800, true, true));
        database.add(new Action("Stringing shortbows", new ArrayList(), ImmutableMap.of("Shortbow (u)", 2800, "Bowstring", 2800), ImmutableMap.of("Shortbow", 2800), 2800, true, true));
        database.add(new Action("Fletching headless arrows", new ArrayList(), ImmutableMap.of("Arrow shaft", 45630, "Feather", 45630),
            ImmutableMap.of("Headless arrow", 45630, "Fletching", 45630, "Fletching pet points", totalPetPoints(player, "Fletching", 45630)), 50, true, true));

        //Herblore
        database.add(new Action("Cleaning grimy guams", new ArrayList(), ImmutableMap.of("Grimy guam", 5090), ImmutableMap.of("Clean guam", 5090,
            "Herblore", 12725, "Herblore pet points", totalPetPoints(player, "Herblore", 12725)), 5090, true, true));

        database.add(new Action("Making unfinished guam potions", new ArrayList(), ImmutableMap.of("Clean guam", 2400, "Vial of water", 2400),
            ImmutableMap.of("Guam potion (unf)", 2400, "Herblore", 2400, "Herblore pet points", totalPetPoints(player, "Herblore", 2400)), 2400, true, true));

        //Hunter (done to lv20)
        database.add(new Action("Feeding ogleroots to rabbits", new ArrayList(), ImmutableMap.of("Coins", 3000), ImmutableMap.of("Hunter", 9000,
            "Hunter level-ticks", 6000*player.getLevel("Hunter")), 300, true, true));
        database.add(new Action("Hunting polar kebbits", new ArrayList(), new HashMap(), ImmutableMap.of("Hunter", 3150, "Prayer", 472, "Polar kebbit fur", 105,
            "Hunter level-ticks", 6000*player.getLevel("Hunter")), 105, true, true));
        database.add(new Action("Catching charm sprites", Collections.singletonList(new Requirement("Hunter", 72)), new HashMap(),
            ImmutableMap.builder().put("Hunter", 60000).put("Crimson charm", 40).put("Blue charm", 28).put("Green charm", 17).put("Gold charm", 6).put("Charm sprites", 435)
                .put("Hunter level-ticks", 6000*Math.max(72,player.getLevel("Hunter"))).build(), 435, true, true));
        database.add(new Action("Catching plover birds", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Hunter", 73)),
            ImmutableMap.of("Logs", 200), ImmutableMap.builder().put("Plover bird", 68+player.getLevel("Hunter")).put("Hunter", 510*(68+player.getLevel("Hunter")))
            .put("Menaphos reputaton", 30*(68+player.getLevel("Hunter"))).put("Pygmy giant scarab", 1).put("Clicker kalphite", 1).put("Hunter level-ticks", 6000*Math.max(73,player.getLevel("Hunter"))).build(),
            68+player.getLevel("Hunter"), true, true));
        database.add(new Action("Hunting common jadinkos", Arrays.asList(new Requirement("Hunter", 70), new Requirement("Farming", 54)), new HashMap(), ImmutableMap.of("Hunter", 38500,
            "Lergberry seed", 2, "Kalferberry seed", 2, "Hunter level-ticks", 6000*Math.max(70,player.getLevel("Hunter"))), 110, true, true));
        database.add(new Action("Hunting tortles", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Hunter", 90)),
            new HashMap(), ImmutableMap.of("Hunter", 258000, "Tortoiseshell Plover", 2, "Shell chippings", 400, "Hunter level-ticks", 6000*Math.max(90,player.getLevel("Hunter"))), 400, true, true));

        //Invention
        database.add(new Action("Refining junk", new ArrayList(), ImmutableMap.of("Junk refiner", 130, "Junk", 117000), ImmutableMap.of("Refined components", 1170, "Invention", 11700),
            1170, true, true));

        database.add(new Action("Disassembling huge spiky iron salvage", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Huge spiky iron salvage", 3000), ImmutableMap.builder().put("Invention", 900).put("Connector parts", 1757).put("Spiked parts", 1509)
            .put("Crafted parts", 1534).put("Swift components", 49).put("Precise components", 49).put("Light components", 49).put("Junk", 40050)
            .put("Invention pet points", totalPetPoints(player, "Invention", 900)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling huge plated steel salvage", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Huge plated steel salvage", 3000), ImmutableMap.builder().put("Invention", 1800).put("Cover parts", 3514).put("Plated parts", 3019)
            .put("Deflecting parts", 3068).put("Protective components", 99).put("Heavy components", 99).put("Strong components", 99).put("Junk", 35100)
            .put("Invention pet points", totalPetPoints(player, "Invention", 1800)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling lantern lenses", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Lantern lens", 3000), ImmutableMap.builder().put("Invention", 4200).put("Clear parts", 1131).put("Delicate parts", 1034)
            .put("Smooth parts", 970).put("Enhancing components", 97).put("Junk", 2766).put("Invention pet points", totalPetPoints(player, "Invention", 4200)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling harralander tar", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Harralander tar", 3000), ImmutableMap.of("Invention", 6300, "Simple parts", 2286, "Variable components", 23,
            "Junk", 690, "Invention pet points", totalPetPoints(player, "Invention", 6300)/10), 3000, true, true));
        database.add(new Action("Disassembling super runecrafting (4)", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Super runecrafting (4)", 3000), ImmutableMap.builder().put("Invention", 6600).put("Delicate parts", 4023).put("Organic parts", 3563)
            .put("Crafted parts", 3448).put("Enhancing components", 344).put("Healthy components", 114).put("Junk", 504).put("Invention pet points", totalPetPoints(player, "Invention", 6600)/10).build(),
            3000, true, true));
        database.add(new Action("Disassembling rune bull rush scrolls", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Rune bull rush scroll", 30000), ImmutableMap.builder().put("Invention", 7500).put("Spiritual parts", 3571)
            .put("Crafted parts", 2202).put("Powerful components", 178).put("Junk", 48).put("Invention pet points", totalPetPoints(player, "Invention", 7500)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling portents of restoration IX", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Portent of restoration IX", 3000), ImmutableMap.builder().put("Invention", 7500).put("Magic parts", 7588)
            .put("Crafted parts", 1160).put("Ethereal components", 178).put("Junk", 72).put("Invention pet points", totalPetPoints(player, "Invention", 7500)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling tortured souls", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Tortured soul", 3000), ImmutableMap.of("Invention", 8100, "Organic parts", 2940, "Pious components", 60,
            "Invention pet points", totalPetPoints(player, "Invention", 8100)/10), 3000, true, true));
        database.add(new Action("Disassembling fly trap seeds", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Fly trap seed", 3000), ImmutableMap.of("Invention", 8100, "Organic parts", 2970, "Living components", 30,
            "Invention pet points", totalPetPoints(player, "Invention", 8100)/10), 3000, true, true));
        database.add(new Action("Disassembling unpowered symbols", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Unpowered symbol", 3000), ImmutableMap.builder().put("Invention", 15300).put("Delicate parts", 981)
            .put("Connector parts", 841).put("Smooth parts", 841).put("Precious components", 84).put("Enhancing components", 56).put("Junk", 12194)
            .put("Invention pet points", totalPetPoints(player, "Invention", 15300)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling steel hastae", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Steel hasta", 3000), ImmutableMap.builder().put("Invention", 18000).put("Stave parts", 1848)
            .put("Blade parts", 1583).put("Crafted parts", 1583).put("Precise components", 158).put("Direct components", 105).put("Junk", 18720)
            .put("Invention pet points", totalPetPoints(player, "Invention", 18000)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling black 2h swords", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Black 2h sword", 3000), ImmutableMap.builder().put("Invention", 22500).put("Knightly components", 3000).put("Base parts", 3465)
            .put("Blade parts", 2970).put("Metallic parts", 2970).put("Sharp components", 297).put("Strong components", 198).put("Junk", 26099)
            .put("Invention pet points", totalPetPoints(player, "Invention", 22500)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling off-hand black scimitars", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Off-hand black scimitar", 3000), ImmutableMap.builder().put("Invention", 22500).put("Knightly components", 3000).put("Base parts", 2310)
            .put("Blade parts", 1980).put("Metallic parts", 1980).put("Sharp components", 198).put("Subtle components", 132).put("Junk", 17400)
            .put("Invention pet points", totalPetPoints(player, "Invention", 22500)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling white maces", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("White mace", 3000), ImmutableMap.builder().put("Invention", 22500).put("Knightly components", 3000).put("Base parts", 2310)
            .put("Head parts", 1980).put("Smooth parts", 1980).put("Heavy components", 198).put("Dextrous components", 132).put("Junk", 17400)
            .put("Invention pet points", totalPetPoints(player, "Invention", 22500)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling carapace boots", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Carapace boots", 3000), ImmutableMap.builder().put("Invention", 27000).put("Cover parts", 1386).put("Tensile parts", 1188)
            .put("Padded parts", 1188).put("Evasive components", 118).put("Protective components", 79).put("Junk", 8040)
            .put("Invention pet points", totalPetPoints(player, "Invention", 27000)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling yew shieldbows", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Yew shieldbow", 3000), ImmutableMap.builder().put("Invention", 36000).put("Stave parts", 5544).put("Tensile parts", 4752)
            .put("Flexible parts", 4752).put("Precise components", 475).put("Imbued components", 316).put("Junk", 20160)
            .put("Invention pet points", totalPetPoints(player, "Invention", 36000)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling Slayer's staves", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Slayer's staff", 3000), ImmutableMap.builder().put("Invention", 49500).put("Stave parts", 7623).put("Magic parts", 6534)
            .put("Padded parts", 6534).put("Powerful components", 653).put("Imbued components", 435).put("Junk", 14220)
            .put("Invention pet points", totalPetPoints(player, "Invention", 49500)/10).build(), 3000, true, true));
        database.add(new Action("Disassembling red salamanders", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Red salamander", 3000), ImmutableMap.builder().put("Invention", 54000).put("Connector parts", 8316).put("Tensile parts", 7127)
            .put("Crafted parts", 7127).put("Stunning components", 712).put("Dextrous components", 475).put("Junk", 12240)
            .put("Invention pet points", totalPetPoints(player, "Invention", 54000)/10).build(), 3000, true, true));

        //Magic (non-combat)
        database.add(new Action("Mage Training Arena (telekinetic)", Arrays.asList(new Requirement("Magic", 33), new Requirement("Staff of air", 0)), ImmutableMap.of("Law rune", 500),
            ImmutableMap.of("Telekinetic pizazz points", 160, "Magic", 31500, "Law rune", 100), 10, true, true));

        database.add(new Action("Mage Training Arena (alchemist)", Arrays.asList(new Requirement("Magic", 21), new Requirement("Staff of fire", 0)), ImmutableMap.of("Nature rune", 650),
            ImmutableMap.of("Alchemist pizazz points", 195, "Magic", 59650, "Coins", 1950), 65, true, true));

        database.add(new Action("Mage Training Arena (graveyard)", Arrays.asList(new Requirement("Magic", 15), new Requirement("Staff of earth", 0)), ImmutableMap.of("Nature rune", 220,
            "Water rune", 440), ImmutableMap.builder().put("Graveyard pizazz points", 275).put("Magic", 5500).put("Blood rune", 55).put("Death rune", 55)
            .put("Earth rune", 55).put("Water rune", 55).put("Nature rune", 55).build(), 40, true, true));

        database.add(new Action("Mage Training Arena (enchantment, lvl-1)", Arrays.asList(new Requirement("Magic", 7), new Requirement("Staff of water", 0)), ImmutableMap.of("Cosmic rune", 360),
            ImmutableMap.of("Enchantment pizazz points", 720, "Magic", 4725), 60, true, true));

        database.add(new Action("Mage Training Arena (enchantment, lvl-2)", Arrays.asList(new Requirement("Magic", 27), new Requirement("Staff of air", 0)), ImmutableMap.of("Cosmic rune", 360),
            ImmutableMap.of("Enchantment pizazz points", 1440, "Magic", 9990), 60, true, true));

        database.add(new Action("Mage Training Arena (enchantment, lvl-3)", Arrays.asList(new Requirement("Magic", 49), new Requirement("Staff of fire", 0)), ImmutableMap.of("Cosmic rune", 360),
            ImmutableMap.of("Enchantment pizazz points", 2160, "Magic", 15930), 60, true, true));

        database.add(new Action("Mage Training Arena (enchantment, lvl-4)", Arrays.asList(new Requirement("Magic", 57), new Requirement("Staff of earth", 0)), ImmutableMap.of("Cosmic rune", 360),
            ImmutableMap.of("Enchantment pizazz points", 2880, "Magic", 18090), 60, true, true));

        database.add(new Action("Mage Training Arena (enchantment, lvl-5)", Arrays.asList(new Requirement("Magic", 68), new Requirement("Mud battlestaff", 0)), ImmutableMap.of("Cosmic rune", 360),
            ImmutableMap.of("Enchantment pizazz points", 3600, "Magic", 21060), 60, true, true));

        database.add(new Action("Mage Training Arena (enchantment, lvl-6)", Arrays.asList(new Requirement("Magic", 87), new Requirement("Lava battlestaff", 0)), ImmutableMap.of("Cosmic rune", 360),
            ImmutableMap.of("Enchantment pizazz points", 4320, "Magic", 26190), 60, true, true));

        //Mining (done to lv90)
        database.add(new Action("Mining copper with bronze pickaxe", Collections.singletonList(new Requirement("Bronze pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 5, 0.66), "Copper ore", miningDamage(player, 5)/40,
            "Copper mined", miningDamage(player, 5)/40, "Mining level-ticks", 6000*player.getLevel("Mining")), 1500, true, true));

        database.add(new Action("Mining tin with bronze pickaxe", Collections.singletonList(new Requirement("Bronze pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 5, 0.66), "Tin ore", miningDamage(player, 5)/40,
            "Tin mined", miningDamage(player, 5)/40, "Mining level-ticks", 6000*player.getLevel("Mining")), 1500, true, true));

        database.add(new Action("Mining iron with iron pickaxe + 1", Arrays.asList(new Requirement("Mining", 10), new Requirement("Iron pickaxe + 1", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 11, 0.68), "Iron ore", miningDamage(player, 11)/120,
            "Iron mined", miningDamage(player, 11)/120, "Mining level-ticks", 6000*Math.max(10,player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining coal with steel pickaxe + 1", Arrays.asList(new Requirement("Mining", 20), new Requirement("Steel pickaxe + 1", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 21, 0.7), "Coal", miningDamage(player, 21)/140,
            "Coal mined", miningDamage(player, 21)/140, "Mining level-ticks", 6000*Math.max(20,player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining mithril with mithril pickaxe + 2", Arrays.asList(new Requirement("Mining", 30), new Requirement("Mithril pickaxe + 2", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 32, 0.72), "Mithril ore", miningDamage(player, 32)/240,
            "Mithril mined", miningDamage(player, 32)/240, "Mining level-ticks", 6000*Math.max(30,player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining adamantite with adamant pickaxe + 2", Arrays.asList(new Requirement("Mining", 40), new Requirement("Adamant pickaxe + 2", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 42, 0.74), "Adamantite ore", miningDamage(player, 42)/380,
            "Adamantite mined", miningDamage(player, 42)/380, "Mining level-ticks", 6000*Math.max(40,player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining luminite with adamant pickaxe + 2", Arrays.asList(new Requirement("Mining", 40), new Requirement("Adamant pickaxe + 2", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 42, 0.74), "Luminite", miningDamage(player, 42)/380,
            "Luminite mined", miningDamage(player, 42)/380, "Mining level-ticks", 6000*Math.max(40,player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining runite with rune pickaxe + 3", Arrays.asList(new Requirement("Mining", 50), new Requirement("Rune pickaxe + 3", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 53, 0.76), "Runite ore", miningDamage(player, 53)/600,
            "Runite mined", miningDamage(player, 53)/600, "Mining level-ticks", 6000*Math.max(50,player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining orichalcite with orikalkum pickaxe + 3", Arrays.asList(new Requirement("Mining", 60), new Requirement("Orikalkum pickaxe + 3", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 63, 0.78), "Orichalcite ore", miningDamage(player, 63)/1400,
            "Orichalcite mined", miningDamage(player, 63)/1400, "Mining level-ticks", 6000*Math.max(60,player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining drakolith with orikalkum pickaxe + 3", Arrays.asList(new Requirement("Mining", 60), new Requirement("Orikalkum pickaxe + 3", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 63, 0.78), "Drakolith", miningDamage(player, 63)/1400,
            "Drakolith mined", miningDamage(player, 63)/1400, "Mining level-ticks", 6000*Math.max(60,player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining necrite with necronium pickaxe", Arrays.asList(new Requirement("Mining", 70), new Requirement("Necronium pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 70, 0.8), "Necrite ore", miningDamage(player, 70)/1300,
            "Necrite mined", miningDamage(player, 70)/1300, "Mining level-ticks", 6000*Math.max(70,player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining phasmatite with necronium pickaxe", Arrays.asList(new Requirement("Mining", 70), new Requirement("Necronium pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 70, 0.8), "Phasmatite", miningDamage(player, 70)/1300,
            "Phasmatite mined", miningDamage(player, 70)/1300, "Mining level-ticks", 6000*Math.max(70,player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining banite with bane pickaxe", Arrays.asList(new Requirement("Mining", 80), new Requirement("Bane pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 80, 0.82), "Banite ore", miningDamage(player, 80)/1700,
            "Banite mined", miningDamage(player, 80)/1700, "Mining level-ticks", 6000*Math.max(80,player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining light animica with elder rune pickaxe", Arrays.asList(new Requirement("Mining", 90), new Requirement("Elder rune pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 90, 0.84), "Light animica", miningDamage(player, 90)/2000,
            "Light animica mined", miningDamage(player, 90)/2000, "Mining level-ticks", 6000*Math.max(90,player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining dark animica with elder rune pickaxe", Arrays.asList(new Requirement("Mining", 90), new Requirement("Elder rune pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 90, 0.84), "Dark animica", miningDamage(player, 90)/2000,
            "Dark animica mined", miningDamage(player, 90)/2000, "Mining level-ticks", 6000*Math.max(90,player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));


        database.add(new Action("Mining/dropping concentrated sandstone with rune pickaxe", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Mining", 50), new Requirement("Rune pickaxe", 1)), new HashMap(), ImmutableMap.builder().put("Mining", miningXP(player, 50, 0.76))
            .put("Menaphos reputation", (int)Math.floor(miningXP(player, 50, 0.76)/45.6)).put("Menaphite honey bee in amber", 1)
            .put("Pygmy giant scarab in amber", 1).put("Mining level-ticks", 6000*Math.max(50,player.getLevel("Mining"))).put("Umesco arpos", 1)
            .put("Crondite", 1).build(), 1500, true, true));

        database.add(new Action("Mining/dropping concentrated sandstone with rune pickaxe (VIP area)", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Mining", 50), new Requirement("Rune pickaxe", 1), new Requirement("Menaphos reputation", 141900)), new HashMap(), ImmutableMap.builder().put("Mining", miningXP(player, 50, 0.76))
            .put("Menaphos reputation", (int)Math.floor(miningXP(player, 50, 0.76)/45.6)).put("Menaphite honey bee in amber", 1)
            .put("Pygmy giant scarab in amber", 1).put("Mining level-ticks", 6000*Math.max(50,player.getLevel("Mining"))).put("Phenakite", 1)
            .put("Crondite", 1).put("Umesco arpos", 1).build(), 1500, true, true));

        database.add(new Action("Lava Flow Mine with necronium pickaxe", Arrays.asList(new Requirement("King of the Dwarves", 1), new Requirement("Necronium pickaxe", 1)),
            new HashMap(), ImmutableMap.of("Mining", miningXP(player, 70, 0.78), "Imcando pickaxe fragment", 1, "Lava Flow Mine damage", miningDamage(player, 70),
            "Mining level-ticks", 6000*Math.max(68,player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining Seren stones with bane pickaxe", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Mining", 89),
            new Requirement("Bane pickaxe", 1)), new HashMap(), ImmutableMap.of("Corrupted ore", miningDamage(player, 80)/240,
            "Mining", miningXP(player, 80, 1.2), "Mining level-ticks", 6000*Math.max(89,player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining salty crablets with elder rune pickaxe", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Mining", 90),
            new Requirement("Elder rune pickaxe", 1)), new HashMap(), ImmutableMap.of("Sea salt", (int)Math.floor(miningDamage(player, 90)/1200),
            "Mining", miningXP(player, 90, 0.82), "Awah Guan", 1, "Mining level-ticks", 6000*Math.max(90,player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        //Prayer (done to lv99)
        database.add(new Action("Offering impious ashes to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Impious ashes", 1400), ImmutableMap.of("Prayer", 19600,
            "Prayer pet points", 19600*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Bones", 1400), ImmutableMap.of("Prayer", 22050,
            "Prayer pet points", 22050*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering accursed ashes to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Accursed ashes", 1400), ImmutableMap.of("Prayer", 61250,
            "Prayer pet points", 61250*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering big bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Big bones", 1400), ImmutableMap.of("Prayer", 73500,
            "Prayer pet points", 73500*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering baby dragon bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Baby dragon bones", 1400), ImmutableMap.of("Prayer", 147000,
            "Prayer pet points", 147000*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering wyvern bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Wyvern bones", 1400), ImmutableMap.of("Prayer", 245000,
            "Prayer pet points", 245000*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering infernal ashes to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Infernal ashes", 1400), ImmutableMap.of("Prayer", 306250,
            "Prayer pet points", 306250*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering dragon bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Dragon bones", 1400), ImmutableMap.of("Prayer", 352800,
            "Prayer pet points", 352800*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering dagannoth bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Dagannoth bones", 1400), ImmutableMap.of("Prayer", 612500,
            "Prayer pet points", 612500*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering airut bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Airut bones", 1400), ImmutableMap.of("Prayer", 649250,
            "Prayer pet points", 649250*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering ourg bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Ourg bones (General Graardor)", 1400), ImmutableMap.of("Prayer", 686000,
            "Prayer pet points", 686000*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering hardened dragon bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Hardened dragon bones", 1400), ImmutableMap.of("Prayer", 705600,
            "Prayer pet points", 705600*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering frost dragon bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Frost dragon bones", 1400), ImmutableMap.of("Prayer", 882000,
            "Prayer pet points", 882000*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering reinforced dragon bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Reinforced dragon bones", 1400), ImmutableMap.of("Prayer", 931000,
            "Prayer pet points", 931000*player.getLevel("Prayer")), 1400, true, false));
        database.add(new Action("Offering searing ashes to Chaos Altar", new ArrayList(), ImmutableMap.of("Searing ashes", 1400), ImmutableMap.of("Prayer", 980000,
            "Prayer pet points", 980000*player.getLevel("Prayer")), 1400, true, false));

        //Runecrafting (done to lv70)
        database.add(new Action("Low-level Runespan (island 1)", new ArrayList(), new HashMap(), ImmutableMap.of("Runecrafting", 16500, "Runespan points", 330,
            "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 16500)), 1500, true, true));

        database.add(new Action("Low-level Runespan (island 16)", Collections.singletonList(new Requirement("Runecrafting", 9)), new HashMap(),
            ImmutableMap.of("Runecrafting", 26000, "Runespan points", 520, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 26000)), 1500, true, true));

        database.add(new Action("Crafting earth runes via Abyss (w/o skull)", Collections.singletonList(new Requirement("Abyssal Reach", 1)), ImmutableMap.of("Pure essence", 1800),
            ImmutableMap.of("Earth rune", 1800, "Runecrafting", 29250, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 29250)), 60, true, false));

        database.add(new Action("Crafting earth runes via Abyss (w/ skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1)),
            ImmutableMap.of("Pure essence", 1800), ImmutableMap.of("Earth rune", 1800, "Runecrafting", 40950, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 40950)),
            60, true, false));

        database.add(new Action("Crafting fire runes via Abyss (w/o skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 14)),
            ImmutableMap.of("Pure essence", 1800), ImmutableMap.of("Fire rune", 1800, "Runecrafting", 31500, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 31500)),
            60, true, false));

        database.add(new Action("Crafting fire runes via Abyss (w/ skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1), new Requirement("Runecrafting", 14)),
            ImmutableMap.of("Pure essence", 1800), ImmutableMap.of("Fire rune", 1800, "Runecrafting", 44100, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 44100)),
            60, true, false));

        database.add(new Action("Crafting body runes via Abyss (w/o skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 20)),
            ImmutableMap.of("Pure essence", 1800), ImmutableMap.of("Body rune", 1800, "Runecrafting", 33750, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 33750)),
            60, true, false));

        database.add(new Action("Crafting body runes via Abyss (w/ skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1), new Requirement("Runecrafting", 20)),
            ImmutableMap.of("Pure essence", 1800), ImmutableMap.of("Body rune", 1800, "Runecrafting", 47250, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 47250)),
            60, true, false));

        database.add(new Action("Crafting body runes via Abyss (w/o skull, w/med pouch)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 25)),
            ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Body rune", 2100, "Runecrafting", 39375, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 39375)),
            60, true, false));

        database.add(new Action("Crafting body runes via Abyss (w/ skull and med pouch)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1),
            new Requirement("Runecrafting", 25)), ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Body rune", 2100, "Runecrafting", 55125,
            "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 55125)), 60, true, false));

        database.add(new Action("Crafting cosmic runes via Abyss (w/o skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 27), new Requirement("Lost City", 1)),
            ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Cosmic rune", 2100, "Runecrafting", 42000, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 42000)),
            60, true, false));

        database.add(new Action("Crafting cosmic runes via Abyss (w/ skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1),
            new Requirement("Runecrafting", 27), new Requirement("Lost City", 1)), ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Cosmic rune", 2100, "Runecrafting", 58800,
            "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 58800)), 60, true, false));

        database.add(new Action("Mid-level Runespan (islands 5 & 6)", Collections.singletonList(new Requirement("Runecrafting", 33)), new HashMap(),
            ImmutableMap.of("Runecrafting", 36500, "Runespan points", 730, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 36500)), 1500, true, true));

        database.add(new Action("Crafting chaos runes via Abyss (w/o skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 35)),
            ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Chaos rune", 2100, "Runecrafting", 44625, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 44625)),
            60, true, false));

        database.add(new Action("Crafting chaos runes via Abyss (w/ skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1),
            new Requirement("Runecrafting", 35)), ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Chaos rune", 2100, "Runecrafting", 62475,
            "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 62475)), 60, true, false));

        database.add(new Action("Crafting astral runes via Abyss (w/o skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 40),
            new Requirement("Lunar Diplomacy", 1)), ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Astral rune", 2100, "Runecrafting", 45675, "Runecrafting pet points",
            totalPetPoints(player, "Runecrafting", 45675)), 60, true, false));

        database.add(new Action("Crafting astral runes via Abyss (w/ skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1),
            new Requirement("Runecrafting", 40), new Requirement("Lunar Diplomacy", 1)), ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Astral rune", 2100, "Runecrafting", 63945,
            "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 63945)), 60, true, false));

        database.add(new Action("Mid-level Runespan (NE islands)", Collections.singletonList(new Requirement("Runecrafting", 42)), new HashMap(),
            ImmutableMap.of("Runecrafting", 37000, "Runespan points", 740, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 37000)), 1500, true, true));

        database.add(new Action("Crafting nature runes via Abyss (w/o skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 44)),
            ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Nature rune", 2100, "Runecrafting", 47250, "Runecrafting pet points",
            totalPetPoints(player, "Runecrafting", 47250)), 60, true, false));

        database.add(new Action("Crafting nature runes via Abyss (w/ skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1),
            new Requirement("Runecrafting", 44)), ImmutableMap.of("Pure essence", 2100), ImmutableMap.of("Nature rune", 2100, "Runecrafting", 66150,
            "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 66150)), 60, true, false));

        database.add(new Action("Crafting nature runes via Abyss (w/o skull, w/large pouch)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 50)),
            ImmutableMap.of("Pure essence", 2580), ImmutableMap.of("Nature rune", 2580, "Runecrafting", 58050, "Runecrafting pet points",
            totalPetPoints(player, "Runecrafting", 58050)), 60, true, false));

        database.add(new Action("Crafting nature runes via Abyss (w/ skull and large pouch)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1),
            new Requirement("Runecrafting", 50)), ImmutableMap.of("Pure essence", 2580), ImmutableMap.of("Nature rune", 2580, "Runecrafting", 81270,
            "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 81270)), 60, true, false));

        database.add(new Action("Mid-level Runespan (NE islands)", Collections.singletonList(new Requirement("Runecrafting", 52)), new HashMap(),
            ImmutableMap.of("Runecrafting", 47000, "Runespan points", 940, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 47000)), 1500, true, true));

        database.add(new Action("Crafting law runes via Abyss (w/o skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 54)),
            ImmutableMap.of("Pure essence", 2580), ImmutableMap.of("Law rune", 2580, "Runecrafting", 61275, "Runecrafting pet points",
            totalPetPoints(player, "Runecrafting", 61275)), 60, true, false));

        database.add(new Action("Crafting law runes via Abyss (w/ skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1),
            new Requirement("Runecrafting", 54)), ImmutableMap.of("Pure essence", 2580), ImmutableMap.of("Law rune", 2580, "Runecrafting", 85785,
            "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 85785)), 60, true, false));

        database.add(new Action("Mid-level Runespan (NE islands)", Collections.singletonList(new Requirement("Runecrafting", 62)), new HashMap(),
            ImmutableMap.of("Runecrafting", 57000, "Runespan points", 1140, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 57000)), 1500, true, true));

        database.add(new Action("Crafting death runes via Abyss (w/o skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Runecrafting", 65),
            new Requirement("Mourning's End Part II", 1)), ImmutableMap.of("Pure essence", 2580), ImmutableMap.of("Death rune", 2580, "Runecrafting", 64500, "Runecrafting pet points",
            totalPetPoints(player, "Runecrafting", 64500)), 60, true, false));

        database.add(new Action("Crafting death runes via Abyss (w/ skull)", Arrays.asList(new Requirement("Abyssal Reach", 1), new Requirement("Demonic skull", 1),
            new Requirement("Runecrafting", 65), new Requirement("Mourning's End Part II", 1)), ImmutableMap.of("Pure essence", 2580), ImmutableMap.of("Death rune", 2580, "Runecrafting", 90300,
            "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 90300)), 60, true, false));

        database.add(new Action("High-level Runespan (SW islands)", Collections.singletonList(new Requirement("Runecrafting", 66)), new HashMap(),
            ImmutableMap.of("Runecrafting", 63000, "Runespan points", 1260, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 63000)), 1500, true, true));

        database.add(new Action("High-level Runespan (w/fragments)", Collections.singletonList(new Requirement("Runecrafting", 70)), new HashMap(),
            ImmutableMap.of("Runecrafting", 63000, "Runespan points", 1260, "Runecrafting pet points", totalPetPoints(player, "Runecrafting", 63000),
                "Rune ethereal fragments", 1200), 1500, true, true));

        //Slayer
        database.add(new Action("Slayer tasks from Turael", new ArrayList(), new HashMap(), ImmutableMap.of("Slayer",
            SlayerMaster.TURAEL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(), "Slayer pet points", totalPetPoints(player, "Slayer",
                SlayerMaster.TURAEL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        database.add(new Action("Slayer tasks from Mazchna", Collections.singletonList(new Requirement("Combat", 20)), new HashMap(),
            ImmutableMap.of("Slayer", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
            "Slayer point", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue(), "Slayer task streak", 1,
                "Slayer pet points", totalPetPoints(player, "Slayer", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        //Smithing (done to lv29)
        database.add(new Action("Smithing bronze wire", new ArrayList(), ImmutableMap.of("Bronze bar", 315), ImmutableMap.of("Bronze wire", 315, "Smithing", 4725,
            "Smithing pet points", totalPetPoints(player, "Smithing", 4725)), 315, true, true));
        database.add(new Action("Smithing bronze scimitars", new ArrayList(), ImmutableMap.of("Bronze bar", 412), ImmutableMap.of("Bronze scimitar", 206, "Smithing", 6180,
            "Smithing pet points", totalPetPoints(player, "Smithing", 6180)), 206, true, true));
        database.add(new Action("Smithing bronze platelegs", new ArrayList(), ImmutableMap.of("Bronze bar", 459), ImmutableMap.of("Bronze platelegs", 153, "Smithing", 6885,
            "Smithing pet points", totalPetPoints(player, "Smithing", 6885)), 153, true, true));
        database.add(new Action("Smithing bronze 2h swords", new ArrayList(), ImmutableMap.of("Bronze bar", 488), ImmutableMap.of("Bronze 2h sword", 122, "Smithing", 7320,
            "Smithing pet points", totalPetPoints(player, "Smithing", 7320)), 122, true, true));
        database.add(new Action("Smithing bronze platebodies", new ArrayList(), ImmutableMap.of("Bronze bar", 450), ImmutableMap.of("Bronze platebody", 90, "Smithing", 6750,
            "Smithing pet points", totalPetPoints(player, "Smithing", 6750)), 90, true, true));
        database.add(new Action("Smithing bronze wire (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 3)), ImmutableMap.of("Bronze bar", 352),
            ImmutableMap.of("Bronze wire", 352, "Smithing", 5280, "Smithing pet points", totalPetPoints(player, "Smithing", 5280)), 352, true, true));
        database.add(new Action("Smithing bronze scimitars (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 3)), ImmutableMap.of("Bronze bar", 444),
            ImmutableMap.of("Bronze scimitar", 222, "Smithing", 6660, "Smithing pet points", totalPetPoints(player, "Smithing", 6660)), 222, true, true));
        database.add(new Action("Smithing bronze platelegs (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 3)), ImmutableMap.of("Bronze bar", 486),
            ImmutableMap.of("Bronze platelegs", 162, "Smithing", 7290, "Smithing pet points", totalPetPoints(player, "Smithing", 7290)), 162, true, true));
        database.add(new Action("Smithing bronze 2h swords (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 3)), ImmutableMap.of("Bronze bar", 508),
            ImmutableMap.of("Bronze 2h sword", 127, "Smithing", 7620, "Smithing pet points", totalPetPoints(player, "Smithing", 7620)), 127, true, true));
        database.add(new Action("Smithing bronze platebodies (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 3)), ImmutableMap.of("Bronze bar", 475),
            ImmutableMap.of("Bronze platebody", 95, "Smithing", 7125, "Smithing pet points", totalPetPoints(player, "Smithing", 7125)), 95, true, true));
        database.add(new Action("Smithing bronze wire (max heat start)", Collections.singletonList(new Requirement("Smithing", 6)), ImmutableMap.of("Bronze bar", 545),
            ImmutableMap.of("Bronze wire", 545, "Smithing", 8175, "Smithing pet points", totalPetPoints(player, "Smithing", 8175)), 545, true, true));
        database.add(new Action("Smithing bronze scimitars (max heat start)", Collections.singletonList(new Requirement("Smithing", 6)), ImmutableMap.of("Bronze bar", 570),
            ImmutableMap.of("Bronze scimitar", 285, "Smithing", 8550, "Smithing pet points", totalPetPoints(player, "Smithing", 8550)), 285, true, true));
        database.add(new Action("Smithing bronze platelegs (max heat start)", Collections.singletonList(new Requirement("Smithing", 6)), ImmutableMap.of("Bronze bar", 579),
            ImmutableMap.of("Bronze platelegs", 193, "Smithing", 8685, "Smithing pet points", totalPetPoints(player, "Smithing", 8685)), 193, true, true));
        database.add(new Action("Smithing bronze 2h swords (max heat start)", Collections.singletonList(new Requirement("Smithing", 6)), ImmutableMap.of("Bronze bar", 584),
            ImmutableMap.of("Bronze 2h sword", 146, "Smithing", 8760, "Smithing pet points", totalPetPoints(player, "Smithing", 9760)), 146, true, true));
        database.add(new Action("Smithing bronze platebodies (max heat start)", Collections.singletonList(new Requirement("Smithing", 6)), ImmutableMap.of("Bronze bar", 525),
            ImmutableMap.of("Bronze platebody", 105, "Smithing", 7875, "Smithing pet points", totalPetPoints(player, "Smithing", 7875)), 105, true, true));
        database.add(new Action("Smithing bronze platebodies (2-tick max heating)", Collections.singletonList(new Requirement("Smithing", 7)), ImmutableMap.of("Bronze bar", 535),
            ImmutableMap.of("Bronze platebody", 107, "Smithing", 8025, "Smithing pet points", totalPetPoints(player, "Smithing", 8025)), 107, true, true));
        database.add(new Action("Smithing bronze platelegs (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 8)), ImmutableMap.of("Bronze bar", 618),
            ImmutableMap.of("Bronze platelegs", 206, "Smithing", 9270, "Smithing pet points", totalPetPoints(player, "Smithing", 9270)), 206, true, true));
        database.add(new Action("Smithing bronze 2h swords (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 8)), ImmutableMap.of("Bronze bar", 612),
            ImmutableMap.of("Bronze 2h sword", 153, "Smithing", 9180, "Smithing pet points", totalPetPoints(player, "Smithing", 9180)), 153, true, true));
        database.add(new Action("Smithing bronze platebodies (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 8)), ImmutableMap.of("Bronze bar", 635),
            ImmutableMap.of("Bronze platebody", 127, "Smithing", 9525, "Smithing pet points", totalPetPoints(player, "Smithing", 9525)), 127, true, true));
        database.add(new Action("Smithing iron hatchets", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 206),
            ImmutableMap.of("Iron hatchet", 206, "Smithing", 8240, "Smithing pet points", totalPetPoints(player, "Smithing", 8240)), 206, true, true));
        database.add(new Action("Smithing iron armoured boots + 1", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 240, "Iron armoured boots", 240),
            ImmutableMap.of("Iron armoured boots + 1", 240, "Smithing", 9600, "Smithing pet points", totalPetPoints(player, "Smithing", 9600)), 240, true, true));
        database.add(new Action("Smithing iron scimitars", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 244),
            ImmutableMap.of("Iron scimitar", 122, "Smithing", 9760, "Smithing pet points", totalPetPoints(player, "Smithing", 9760)), 122, true, true));
        database.add(new Action("Smithing iron full helms + 1", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 292, "Iron full helm", 146),
            ImmutableMap.of("Iron full helm + 1", 146, "Smithing", 11680, "Smithing pet points", totalPetPoints(player, "Smithing", 11680)), 146, true, true));
        database.add(new Action("Smithing iron platelegs", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 234),
            ImmutableMap.of("Iron platelegs", 78, "Smithing", 9360, "Smithing pet points", totalPetPoints(player, "Smithing", 9360)), 78, true, true));
        database.add(new Action("Smithing iron platelegs + 1", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 315, "Iron platelegs", 105),
            ImmutableMap.of("Iron platelegs + 1", 105, "Smithing", 12600, "Smithing pet points", totalPetPoints(player, "Smithing", 12600)), 105, true, true));
        database.add(new Action("Smithing iron 2h swords", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 248),
            ImmutableMap.of("Iron 2h sword", 62, "Smithing", 9920, "Smithing pet points", totalPetPoints(player, "Smithing", 9920)), 62, true, true));
        database.add(new Action("Smithing iron 2h swords + 1", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 300, "Iron 2h sword", 75),
            ImmutableMap.of("Iron 2h sword + 1", 75, "Smithing", 12000, "Smithing pet points", totalPetPoints(player, "Smithing", 12000)), 75, true, true));
        database.add(new Action("Smithing iron platebodies", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 240),
            ImmutableMap.of("Iron platebody", 48, "Smithing", 9600, "Smithing pet points", totalPetPoints(player, "Smithing", 9600)), 48, true, true));
        database.add(new Action("Smithing iron platebodies + 1", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 310, "Iron platebody", 62),
            ImmutableMap.of("Iron platebody + 1", 62, "Smithing", 12400, "Smithing pet points", totalPetPoints(player, "Smithing", 12400)), 62, true, true));
        database.add(new Action("Smithing iron hatchets (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 222),
            ImmutableMap.of("Iron hatchet", 222, "Smithing", 8880, "Smithing pet points", totalPetPoints(player, "Smithing", 8880)), 222, true, true));
        database.add(new Action("Smithing iron armoured boots + 1 (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 260,
            "Iron armoured boots", 260), ImmutableMap.of("Iron armoured boots + 1", 260, "Smithing", 10400, "Smithing pet points", totalPetPoints(player, "Smithing", 10400)), 260, true, true));
        database.add(new Action("Smithing iron scimitars (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 254),
            ImmutableMap.of("Iron scimitar", 127, "Smithing", 10160, "Smithing pet points", totalPetPoints(player, "Smithing", 10160)), 127, true, true));
        database.add(new Action("Smithing iron full helms + 1 (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 306, "Iron full helm", 153),
            ImmutableMap.of("Iron full helm + 1", 153, "Smithing", 12240, "Smithing pet points", totalPetPoints(player, "Smithing", 12240)), 153, true, true));
        database.add(new Action("Smithing iron platelegs (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 246),
            ImmutableMap.of("Iron platelegs", 82, "Smithing", 9840, "Smithing pet points", totalPetPoints(player, "Smithing", 9840)), 82, true, true));
        database.add(new Action("Smithing iron platelegs + 1 (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 327, "Iron platelegs", 109),
            ImmutableMap.of("Iron platelegs + 1", 109, "Smithing", 13080, "Smithing pet points", totalPetPoints(player, "Smithing", 13080)), 109, true, true));
        database.add(new Action("Smithing iron 2h swords (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 256),
            ImmutableMap.of("Iron 2h sword", 64, "Smithing", 10240, "Smithing pet points", totalPetPoints(player, "Smithing", 10240)), 64, true, true));
        database.add(new Action("Smithing iron 2h swords + 1 (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 308, "Iron 2h sword", 77),
            ImmutableMap.of("Iron 2h sword + 1", 77, "Smithing", 12320, "Smithing pet points", totalPetPoints(player, "Smithing", 12320)), 77, true, true));
        database.add(new Action("Smithing iron platebodies (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 250),
            ImmutableMap.of("Iron platebody", 50, "Smithing", 10000, "Smithing pet points", totalPetPoints(player, "Smithing", 10000)), 50, true, true));
        database.add(new Action("Smithing iron platebodies + 1 (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 320, "Iron platebody", 64),
            ImmutableMap.of("Iron platebody + 1", 64, "Smithing", 12800, "Smithing pet points", totalPetPoints(player, "Smithing", 12800)), 64, true, true));
        database.add(new Action("Smithing iron scimitars (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 266),
            ImmutableMap.of("Iron scimitar", 133, "Smithing", 10640, "Smithing pet points", totalPetPoints(player, "Smithing", 10640)), 133, true, true));
        database.add(new Action("Smithing iron full helms + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 324, "Iron full helm", 162),
            ImmutableMap.of("Iron full helm + 1", 162, "Smithing", 12960, "Smithing pet points", totalPetPoints(player, "Smithing", 12960)), 162, true, true));
        database.add(new Action("Smithing iron platelegs (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 258),
            ImmutableMap.of("Iron platelegs", 86, "Smithing", 10320, "Smithing pet points", totalPetPoints(player, "Smithing", 10320)), 86, true, true));
        database.add(new Action("Smithing iron platelegs + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 351, "Iron platelegs", 117),
            ImmutableMap.of("Iron platelegs + 1", 117, "Smithing", 14040, "Smithing pet points", totalPetPoints(player, "Smithing", 14040)), 117, true, true));
        database.add(new Action("Smithing iron 2h swords (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 272),
            ImmutableMap.of("Iron 2h sword", 68, "Smithing", 10880, "Smithing pet points", totalPetPoints(player, "Smithing", 10880)), 68, true, true));
        database.add(new Action("Smithing iron 2h swords + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 328, "Iron 2h sword", 82),
            ImmutableMap.of("Iron 2h sword + 1", 82, "Smithing", 13120, "Smithing pet points", totalPetPoints(player, "Smithing", 13120)), 82, true, true));
        database.add(new Action("Smithing iron platebodies (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 285),
            ImmutableMap.of("Iron platebody", 57, "Smithing", 11400, "Smithing pet points", totalPetPoints(player, "Smithing", 11400)), 57, true, true));
        database.add(new Action("Smithing iron platebodies + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 340, "Iron platebody", 68),
            ImmutableMap.of("Iron platebody + 1", 68, "Smithing", 13600, "Smithing pet points", totalPetPoints(player, "Smithing", 13600)), 68, true, true));
        database.add(new Action("Smithing iron hatchets (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 285),
            ImmutableMap.of("Iron hatchet", 285, "Smithing", 11400, "Smithing pet points", totalPetPoints(player, "Smithing", 11400)), 285, true, true));
        database.add(new Action("Smithing iron armoured boots + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 352,
            "Iron armoured boots", 352), ImmutableMap.of("Iron armoured boots + 1", 352, "Smithing", 14080, "Smithing pet points", totalPetPoints(player, "Smithing", 14080)), 352, true, true));
        database.add(new Action("Smithing iron scimitars (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 306),
            ImmutableMap.of("Iron scimitar", 153, "Smithing", 12240, "Smithing pet points", totalPetPoints(player, "Smithing", 12240)), 153, true, true));
        database.add(new Action("Smithing iron full helms + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 386, "Iron full helm", 193),
            ImmutableMap.of("Iron full helm + 1", 193, "Smithing", 15440, "Smithing pet points", totalPetPoints(player, "Smithing", 15440)), 193, true, true));
        database.add(new Action("Smithing iron platelegs (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 285),
            ImmutableMap.of("Iron platelegs", 95, "Smithing", 11400, "Smithing pet points", totalPetPoints(player, "Smithing", 11400)), 95, true, true));
        database.add(new Action("Smithing iron platelegs + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 399, "Iron platelegs", 133),
            ImmutableMap.of("Iron platelegs + 1", 133, "Smithing", 15960, "Smithing pet points", totalPetPoints(player, "Smithing", 15960)), 133, true, true));
        database.add(new Action("Smithing iron 2h swords (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 296),
            ImmutableMap.of("Iron 2h sword", 74, "Smithing", 11840, "Smithing pet points", totalPetPoints(player, "Smithing", 11840)), 74, true, true));
        database.add(new Action("Smithing iron 2h swords + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 356, "Iron 2h sword", 89),
            ImmutableMap.of("Iron 2h sword + 1", 89, "Smithing", 14240, "Smithing pet points", totalPetPoints(player, "Smithing", 14240)), 89, true, true));
        database.add(new Action("Smithing iron platebodies (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 300),
            ImmutableMap.of("Iron platebody", 60, "Smithing", 12000, "Smithing pet points", totalPetPoints(player, "Smithing", 12000)), 60, true, true));
        database.add(new Action("Smithing iron platebodies + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 370, "Iron platebody", 74),
            ImmutableMap.of("Iron platebody + 1", 74, "Smithing", 14800, "Smithing pet points", totalPetPoints(player, "Smithing", 14800)), 74, true, true));
        database.add(new Action("Smithing iron platelegs (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 18)), ImmutableMap.of("Iron bar", 288),
            ImmutableMap.of("Iron platelegs", 96, "Smithing", 11520, "Smithing pet points", totalPetPoints(player, "Smithing", 11520)), 96, true, true));
        database.add(new Action("Smithing iron 2h swords (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 18)), ImmutableMap.of("Iron bar", 300),
            ImmutableMap.of("Iron 2h sword", 75, "Smithing", 12000, "Smithing pet points", totalPetPoints(player, "Smithing", 12000)), 75, true, true));
        database.add(new Action("Smithing iron 2h swords + 1 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 18)), ImmutableMap.of("Iron bar", 360, "Iron 2h sword", 90),
            ImmutableMap.of("Iron 2h sword + 1", 90, "Smithing", 14400, "Smithing pet points", totalPetPoints(player, "Smithing", 14400)), 90, true, true));
        database.add(new Action("Smithing iron platebodies (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 18)), ImmutableMap.of("Iron bar", 305),
            ImmutableMap.of("Iron platebody", 61, "Smithing", 12200, "Smithing pet points", totalPetPoints(player, "Smithing", 12200)), 61, true, true));
        database.add(new Action("Smithing iron platebodies + 1 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 18)), ImmutableMap.of("Iron bar", 375, "Iron platebody", 75),
            ImmutableMap.of("Iron platebody + 1", 75, "Smithing", 15000, "Smithing pet points", totalPetPoints(player, "Smithing", 15000)), 75, true, true));
        database.add(new Action("Smithing steel armoured boots", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 153),
            ImmutableMap.of("Steel armoured boots", 153, "Smithing", 11475, "Smithing pet points", totalPetPoints(player, "Smithing", 11475)), 153, true, true));
        database.add(new Action("Smithing steel armoured boots + 1", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 181, "Steel armoured boots", 181),
            ImmutableMap.of("Steel armoured boots + 1", 181, "Smithing", 13575, "Smithing pet points", totalPetPoints(player, "Smithing", 13575)), 181, true, true));
        database.add(new Action("Smithing steel scimitars", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 156),
            ImmutableMap.of("Steel scimitar", 78, "Smithing", 11700, "Smithing pet points", totalPetPoints(player, "Smithing", 11700)), 78, true, true));
        database.add(new Action("Smithing steel scimitars + 1", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 210, "Steel scimitar", 105),
            ImmutableMap.of("Steel scimitar + 1", 105, "Smithing", 15750, "Smithing pet points", totalPetPoints(player, "Smithing", 15750)), 105, true, true));
        database.add(new Action("Smithing steel platelegs", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 168),
            ImmutableMap.of("Steel platelegs", 56, "Smithing", 12600, "Smithing pet points", totalPetPoints(player, "Smithing", 12600)), 56, true, true));
        database.add(new Action("Smithing steel platelegs + 1", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 204, "Steel platelegs", 68),
            ImmutableMap.of("Steel platelegs + 1", 68, "Smithing", 15300, "Smithing pet points", totalPetPoints(player, "Smithing", 15300)), 68, true, true));
        database.add(new Action("Smithing steel 2h swords", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 164),
            ImmutableMap.of("Steel 2h sword", 41, "Smithing", 12300, "Smithing pet points", totalPetPoints(player, "Smithing", 12300)), 41, true, true));
        database.add(new Action("Smithing steel 2h swords + 1", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 212, "Steel 2h sword", 53),
            ImmutableMap.of("Steel 2h sword + 1", 53, "Smithing", 15900, "Smithing pet points", totalPetPoints(player, "Smithing", 15900)), 53, true, true));
        database.add(new Action("Smithing steel platebodies", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 170),
            ImmutableMap.of("Steel platebody", 34, "Smithing", 12750, "Smithing pet points", totalPetPoints(player, "Smithing", 12750)), 34, true, true));
        database.add(new Action("Smithing steel platebodies + 1", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 205, "Steel platebody", 41),
            ImmutableMap.of("Steel platebody + 1", 41, "Smithing", 15375, "Smithing pet points", totalPetPoints(player, "Smithing", 15375)), 41, true, true));
        database.add(new Action("Smithing steel armoured boots (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 162),
            ImmutableMap.of("Steel armoured boots", 162, "Smithing", 12150, "Smithing pet points", totalPetPoints(player, "Smithing", 12150)), 162, true, true));
        database.add(new Action("Smithing steel armoured boots + 1 (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 193,
            "Steel armoured boots", 193), ImmutableMap.of("Steel armoured boots + 1", 193, "Smithing", 14475, "Smithing pet points", totalPetPoints(player, "Smithing", 14475)), 193, true, true));
        database.add(new Action("Smithing steel scimitars (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 164),
            ImmutableMap.of("Steel scimitar", 82, "Smithing", 12300, "Smithing pet points", totalPetPoints(player, "Smithing", 12300)), 82, true, true));
        database.add(new Action("Smithing steel scimitars + 1 (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 218, "Steel scimitar", 109),
            ImmutableMap.of("Steel scimitar + 1", 109, "Smithing", 16350, "Smithing pet points", totalPetPoints(player, "Smithing", 16350)), 109, true, true));
        database.add(new Action("Smithing steel platelegs (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 174),
            ImmutableMap.of("Steel platelegs", 58, "Smithing", 13050, "Smithing pet points", totalPetPoints(player, "Smithing", 13050)), 58, true, true));
        database.add(new Action("Smithing steel platelegs + 1 (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 210, "Steel platelegs", 70),
            ImmutableMap.of("Steel platelegs + 1", 70, "Smithing", 15750, "Smithing pet points", totalPetPoints(player, "Smithing", 15750)), 70, true, true));
        database.add(new Action("Smithing steel 2h swords (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 172),
            ImmutableMap.of("Steel 2h sword", 43, "Smithing", 12900, "Smithing pet points", totalPetPoints(player, "Smithing", 12900)), 43, true, true));
        database.add(new Action("Smithing steel 2h swords + 1 (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 220, "Steel 2h sword", 55),
            ImmutableMap.of("Steel 2h sword + 1", 55, "Smithing", 16500, "Smithing pet points", totalPetPoints(player, "Smithing", 16500)), 55, true, true));
        database.add(new Action("Smithing steel platebodies (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 175),
            ImmutableMap.of("Steel platebody", 35, "Smithing", 13125, "Smithing pet points", totalPetPoints(player, "Smithing", 13125)), 35, true, true));
        database.add(new Action("Smithing steel platebodies + 1 (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 215, "Steel platebody", 43),
            ImmutableMap.of("Steel platebody + 1", 43, "Smithing", 16125, "Smithing pet points", totalPetPoints(player, "Smithing", 16125)), 43, true, true));
        database.add(new Action("Smithing steel armoured boots (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 171),
            ImmutableMap.of("Steel armoured boots", 171, "Smithing", 12825, "Smithing pet points", totalPetPoints(player, "Smithing", 12825)), 171, true, true));
        database.add(new Action("Smithing steel armoured boots + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 206,
            "Steel armoured boots", 206), ImmutableMap.of("Steel armoured boots + 1", 206, "Smithing", 15450, "Smithing pet points", totalPetPoints(player, "Smithing", 15450)), 206, true, true));
        database.add(new Action("Smithing steel scimitars (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 172),
            ImmutableMap.of("Steel scimitar", 86, "Smithing", 12900, "Smithing pet points", totalPetPoints(player, "Smithing", 12900)), 86, true, true));
        database.add(new Action("Smithing steel scimitars + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 234, "Steel scimitar", 117),
            ImmutableMap.of("Steel scimitar + 1", 117, "Smithing", 17550, "Smithing pet points", totalPetPoints(player, "Smithing", 17550)), 117, true, true));
        database.add(new Action("Smithing steel platelegs (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 189),
            ImmutableMap.of("Steel platelegs", 63, "Smithing", 14175, "Smithing pet points", totalPetPoints(player, "Smithing", 14175)), 63, true, true));
        database.add(new Action("Smithing steel platelegs + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 225, "Steel platelegs", 75),
            ImmutableMap.of("Steel platelegs + 1", 75, "Smithing", 16875, "Smithing pet points", totalPetPoints(player, "Smithing", 16875)), 75, true, true));
        database.add(new Action("Smithing steel 2h swords (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 184),
            ImmutableMap.of("Steel 2h sword", 46, "Smithing", 13800, "Smithing pet points", totalPetPoints(player, "Smithing", 13800)), 46, true, true));
        database.add(new Action("Smithing steel 2h swords + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 236, "Steel 2h sword", 59),
            ImmutableMap.of("Steel 2h sword + 1", 59, "Smithing", 17700, "Smithing pet points", totalPetPoints(player, "Smithing", 17700)), 59, true, true));
        database.add(new Action("Smithing steel platebodies (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 190),
            ImmutableMap.of("Steel platebody", 38, "Smithing", 14250, "Smithing pet points", totalPetPoints(player, "Smithing", 14250)), 38, true, true));
        database.add(new Action("Smithing steel platebodies + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 230, "Steel platebody", 46),
            ImmutableMap.of("Steel platebody + 1", 46, "Smithing", 17250, "Smithing pet points", totalPetPoints(player, "Smithing", 17250)), 46, true, true));
        database.add(new Action("Smithing steel armoured boots (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 181),
            ImmutableMap.of("Steel armoured boots", 181, "Smithing", 13575, "Smithing pet points", totalPetPoints(player, "Smithing", 13575)), 181, true, true));
        database.add(new Action("Smithing steel armoured boots + 1 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 222,
            "Steel armoured boots", 222), ImmutableMap.of("Steel armoured boots + 1", 222, "Smithing", 16650, "Smithing pet points", totalPetPoints(player, "Smithing", 16650)), 222, true, true));
        database.add(new Action("Smithing steel scimitars (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 180),
            ImmutableMap.of("Steel scimitar", 90, "Smithing", 13500, "Smithing pet points", totalPetPoints(player, "Smithing", 13500)), 90, true, true));
        database.add(new Action("Smithing steel scimitars + 1 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 244, "Steel scimitar", 122),
            ImmutableMap.of("Steel scimitar + 1", 122, "Smithing", 18300, "Smithing pet points", totalPetPoints(player, "Smithing", 18300)), 122, true, true));
        database.add(new Action("Smithing steel platelegs (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 195),
            ImmutableMap.of("Steel platelegs", 65, "Smithing", 14625, "Smithing pet points", totalPetPoints(player, "Smithing", 14625)), 65, true, true));
        database.add(new Action("Smithing steel platelegs + 1 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 234, "Steel platelegs", 78),
            ImmutableMap.of("Steel platelegs + 1", 78, "Smithing", 17550, "Smithing pet points", totalPetPoints(player, "Smithing", 17550)), 78, true, true));
        database.add(new Action("Smithing steel 2h swords (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 192),
            ImmutableMap.of("Steel 2h sword", 48, "Smithing", 14400, "Smithing pet points", totalPetPoints(player, "Smithing", 14400)), 48, true, true));
        database.add(new Action("Smithing steel 2h swords + 1 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 244, "Steel 2h sword", 61),
            ImmutableMap.of("Steel 2h sword + 1", 61, "Smithing", 18300, "Smithing pet points", totalPetPoints(player, "Smithing", 18300)), 61, true, true));
        database.add(new Action("Smithing steel platebodies (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 195),
            ImmutableMap.of("Steel platebody", 39, "Smithing", 14625, "Smithing pet points", totalPetPoints(player, "Smithing", 14625)), 39, true, true));
        database.add(new Action("Smithing steel platebodies + 1 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 240, "Steel platebody", 48),
            ImmutableMap.of("Steel platebody + 1", 48, "Smithing", 18000, "Smithing pet points", totalPetPoints(player, "Smithing", 18000)), 48, true, true));
        database.add(new Action("Smithing steel armoured boots (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 206),
            ImmutableMap.of("Steel armoured boots", 206, "Smithing", 15450, "Smithing pet points", totalPetPoints(player, "Smithing", 15450)), 206, true, true));
        database.add(new Action("Smithing steel armoured boots + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 260,
            "Steel armoured boots", 260), ImmutableMap.of("Steel armoured boots + 1", 260, "Smithing", 19500, "Smithing pet points", totalPetPoints(player, "Smithing", 19500)), 260, true, true));
        database.add(new Action("Smithing steel scimitars (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 210),
            ImmutableMap.of("Steel scimitar", 105, "Smithing", 15750, "Smithing pet points", totalPetPoints(player, "Smithing", 15750)), 105, true, true));
        database.add(new Action("Smithing steel scimitars + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 266, "Steel scimitar", 133),
            ImmutableMap.of("Steel scimitar + 1", 133, "Smithing", 19950, "Smithing pet points", totalPetPoints(player, "Smithing", 19950)), 133, true, true));
        database.add(new Action("Smithing steel platelegs (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 204),
            ImmutableMap.of("Steel platelegs", 68, "Smithing", 15300, "Smithing pet points", totalPetPoints(player, "Smithing", 15300)), 68, true, true));
        database.add(new Action("Smithing steel platelegs + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 249, "Steel platelegs", 83),
            ImmutableMap.of("Steel platelegs + 1", 83, "Smithing", 18675, "Smithing pet points", totalPetPoints(player, "Smithing", 18675)), 83, true, true));
        database.add(new Action("Smithing steel 2h swords (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 204),
            ImmutableMap.of("Steel 2h sword", 51, "Smithing", 15300, "Smithing pet points", totalPetPoints(player, "Smithing", 15300)), 51, true, true));
        database.add(new Action("Smithing steel 2h swords + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 252, "Steel 2h sword", 63),
            ImmutableMap.of("Steel 2h sword + 1", 63, "Smithing", 18900, "Smithing pet points", totalPetPoints(player, "Smithing", 18900)), 63, true, true));
        database.add(new Action("Smithing steel platebodies (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 200),
            ImmutableMap.of("Steel platebody", 40, "Smithing", 15000, "Smithing pet points", totalPetPoints(player, "Smithing", 15000)), 40, true, true));
        database.add(new Action("Smithing steel platebodies + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 255, "Steel platebody", 51),
            ImmutableMap.of("Steel platebody + 1", 51, "Smithing", 19125, "Smithing pet points", totalPetPoints(player, "Smithing", 19125)), 51, true, true));

        //Summoning (done to lv16)
        database.add(new Action("Making spirit wolf pouches", new ArrayList(), ImmutableMap.of("Spirit shards", 10500, "Pouch", 1500,
            "Wolf bones", 1500, "Gold charm", 1500), ImmutableMap.of("Spirit wolf pouch", 1500, "Summoning", 7200,
            "Summoning pet points", totalPetPoints(player, "Summoning", 7200)), 1500, true, true));
        database.add(new Action("Making dreadfowl pouches", Collections.singletonList(new Requirement("Summoning", 4)), ImmutableMap.of("Spirit shards", 12000,
            "Pouch", 1500, "Raw chicken", 1500, "Gold charm", 1500), ImmutableMap.of("Dreadfowl pouch", 1500, "Summoning", 13950,
            "Summoning pet points", totalPetPoints(player, "Summoning", 13950)), 1500, true, true));
        database.add(new Action("Making spirit spider pouches", Collections.singletonList(new Requirement("Summoning", 10)), ImmutableMap.of("Spirit shards", 12000,
            "Pouch", 1500, "Spider carcass", 1500, "Gold charm", 1500), ImmutableMap.of("Spirit spider pouch", 1500, "Summoning", 18900,
            "Summoning pet points", totalPetPoints(player, "Summoning", 18900)), 1500, true, true));
        database.add(new Action("Making thorny snail pouches", Collections.singletonList(new Requirement("Summoning", 13)), ImmutableMap.of("Spirit shards", 13500,
            "Pouch", 1500, "Thin snail", 1500, "Gold charm", 1500), ImmutableMap.of("Thorny snail pouch", 1500, "Summoning", 18900,
            "Summoning pet points", totalPetPoints(player, "Summoning", 18900)), 1500, true, true));
        database.add(new Action("Making granite crab pouches", Collections.singletonList(new Requirement("Summoning", 16)), ImmutableMap.of("Spirit shards", 10500,
            "Pouch", 1500, "Iron ore", 1500, "Gold charm", 1500), ImmutableMap.of("Granite crab pouch", 1500, "Summoning", 32400,
            "Summoning pet points", totalPetPoints(player, "Summoning", 32400)), 1500, true, true));
        database.add(new Action("Making spirit mosquito pouches", Collections.singletonList(new Requirement("Summoning", 17)), ImmutableMap.of("Spirit shards", 1500,
            "Pouch", 1500, "Proboscis", 1500, "Gold charm", 1500), ImmutableMap.of("Spirit mosquito pouch", 1500, "Summoning", 69750,
            "Summoning pet points", totalPetPoints(player, "Summoning", 69750)), 1500, true, true));

        //Thieving
        database.add(new Action("Pickpocketing men/women", new ArrayList(), new HashMap(), ImmutableMap.of("Coins", 3 * pocketsPicked(1, player),
            "Thieving", 8 * pocketsPicked(1, player), "Thieving level-ticks", 6000*player.getLevel("Thieving")), pocketsPicked(1, player), true, true));
        database.add(new Action("Pickpocketing the Gullible tourist", Collections.singletonList(new Requirement("The Jack of Spades", 1)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 73750).put("Coins", 75000).put("Menaphos reputation", 3250).put("Hornless fly in amber", 1)
                .put("Kalphite wanderer in amber", 1).put("Waikonite", 1).build(), 3000, true, true));
        database.add(new Action("Bakery stalls", Collections.singletonList(new Requirement("Thieving", 5)), new HashMap(), ImmutableMap.of("Thieving", 10500,
            "Thieving level-ticks", 6000*Math.max(5,player.getLevel("Thieving"))), 656, true, true));
        database.add(new Action("Pyramid Plunder (to room 1)", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Thieving", 21)),
            new HashMap(), ImmutableMap.of("Thieving", 17000, "Jenifurr", 1, "Thieving level-ticks", 6000*Math.max(21,player.getLevel("Thieving")), "Menaphyrite", 1), 12, true, true));
        database.add(new Action("Menaphos silk stall (drop silk)", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Thieving", 20)),
            new HashMap(), ImmutableMap.of("Thieving", 9600, "Menaphos reputation", 2400, "Fly dragon in amber", 1, "Thieving level-ticks", 6000*Math.max(20,player.getLevel("Thieving"))), 400, true, true));
        database.add(new Action("Pickpocketing Menaphite marketeers", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Thieving", 46)), new HashMap(), ImmutableMap.builder().put("Thieving", (int)(29.5 * pocketsPicked(46, player))).put("Menaphos reputation",
            (int)(1.3 * pocketsPicked(46, player))).put("Coins", 30*pocketsPicked(46, player)).put("Kalphite wanderer in amber", 1).put("Hornless unicornfly in amber", 1)
            .put("Thieving level-ticks", 6000*Math.max(46,player.getLevel("Thieving"))).build(), pocketsPicked(46, player), true, true));
        database.add(new Action("Safecracking (Misthalin)", Arrays.asList(new Requirement("A Guild of Our Own", 1), new Requirement("Thieving", 62)), new HashMap(),
            ImmutableMap.of("Thieving", 300000, "Pilfer Points", 800, "Coins", 200000, "Thieving level-ticks", 6000*Math.max(62,player.getLevel("Thieving"))), 60, true, true));
        database.add(new Action("Iorwerth workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 91)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 250000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3).put("Master clue scroll points", 1)
            .put("Prifddinian musician's robe pieces", 1).put("Iorwerth symbol piece", 1).put("Thieving level-ticks", 6000*Math.max(91,player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Ithell workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 92)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 260000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3).put("Master clue scroll points", 1)
                .put("Prifddinian musician's robe pieces", 1).put("Ithell symbol piece", 1).put("Thieving level-ticks", 6000*Math.max(92,player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Cadarn workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 93)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 270000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3).put("Master clue scroll points", 1)
                .put("Prifddinian musician's robe pieces", 1).put("Cadarn symbol piece", 1).put("Thieving level-ticks", 6000*Math.max(93,player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Amlodd workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 94)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 280000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3).put("Master clue scroll points", 1)
                .put("Prifddinian musician's robe pieces", 1).put("Amlodd symbol piece", 1).put("Thieving level-ticks", 6000*Math.max(94,player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Trahearn workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 95)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 290000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3).put("Master clue scroll points", 1)
                .put("Prifddinian musician's robe pieces", 1).put("Trahearn symbol piece", 1).put("Thieving level-ticks", 6000*Math.max(95,player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Hefin workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 96)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 300000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3).put("Master clue scroll points", 1)
                .put("Prifddinian musician's robe pieces", 1).put("Hefin symbol piece", 1).put("Thieving level-ticks", 6000*Math.max(96,player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Crwys workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 97)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 310000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3).put("Master clue scroll points", 1)
                .put("Prifddinian musician's robe pieces", 1).put("Crwys symbol piece", 1).put("Thieving level-ticks", 6000*Math.max(97,player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Meilyr workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 98)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 320000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3).put("Master clue scroll points", 1)
                .put("Prifddinian musician's robe pieces", 1).put("Meilyr symbol piece", 1).put("Thieving level-ticks", 6000*Math.max(98,player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));

        //Woodcutting
        database.add(new Action("Cutting regular trees with dwarven army axe", new ArrayList(), new HashMap(), ImmutableMap.of("Woodcutting",
            Math.min(1500, itemsReceived(player, 510, 1.0165, "Woodcutting", 1))*28, "Woodcutting level-ticks", 6000*player.getLevel("Woodcutting")),
            Math.min(1500, itemsReceived(player, 510, 1.0165, "Woodcutting", 1)), true, true));

        database.add(new Action("Cutting/dropping acadia logs with rune hatchet in VIP skilling area", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Menaphos reputation", 141900), new Requirement("Woodcutting", 47)), new HashMap(), ImmutableMap.builder().put("Woodcutting", 92*itemsReceived(player, 600, 1.01, "Woodcutting", 47))
            .put("Menaphos reputation", (int)4.5*itemsReceived(player, 600, 1.01, "Woodcutting", 47)).put("Desert locust", 1).put("Hornless unicornfly", 1).put("Kalphite wanderer", 1)
            .put("Woodcutting level-ticks", 6000*Math.max(47,player.getLevel("Woodcutting"))).build(), itemsReceived(player, 600, 1.01, "Woodcutting", 47), true, true));

        database.add(new Action("Cutting bamboo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Woodcutting", 90)),
            new HashMap(), ImmutableMap.of("Bamboo", 3*player.getLevel("Woodcutting") + 60, "Woodcutting", (int)202.5*(3*player.getLevel("Woodcutting") + 60), "Great Pecker", 1,
            "Woodcutting level-ticks", 6000*Math.max(90,player.getLevel("Woodcutting"))), 3*player.getLevel("Woodcutting") + 60, true, true));

        database.add(new Action("Cutting crystal trees with dragon hatchet", Collections.singletonList(new Requirement("Woodcutting", 94)), new HashMap(),
            ImmutableMap.of("Woodcutting", (int)434.5*itemsReceived(player, 180, 1.037, "Woodcutting", 94), "Crystal geode", 10, "Woodcutting level-ticks", 6000*Math.max(94,player.getLevel("Woodcutting"))),
            itemsReceived(player, 180, 1.037, "Woodcutting", 94), true, true));

        //Multi-skill
        database.add(new Action("Cremating vyre corpses", Arrays.asList(new Requirement("Legacy of Seergaze", 1),
            new Requirement("Firemaking", 40)), ImmutableMap.of("Vyre corpse", 500, "Teak pyre logs", 500), ImmutableMap.of("Firemaking", 60000,
            "Prayer", 39350, "Vyre corpses burned", 500, "Columbarium key", 500), 500, true, true));
        database.add(new Action("Cremating loar shades", Arrays.asList(new Requirement("Shades of Mort'ton", 1),
            new Requirement("Firemaking", 40)), ImmutableMap.of("Loar remains", 500, "Pyre logs", 500), ImmutableMap.of("Firemaking", 25000,
            "Prayer", 12500, "Coins", 100000, "Shade key", 250), 500, true, true));
        database.add(new Action("Livid Farm", Arrays.asList(new Requirement("Lunar Diplomacy", 1), new Requirement("Magic", 91), new Requirement("Agility", 60),
            new Requirement("Crafting", 60), new Requirement("Farming", 60), new Requirement("Construction", 50)), ImmutableMap.of("Astral rune", 1056, "Nature rune", 480,
            "Earth rune", 6420, "Water rune", 240), ImmutableMap.builder().put("Farming", 33048).put("Crafting", 12960).put("Construction", 6552).put("Agility", 6109).put("Magic", 41244)
            .put("Produce points", 18960).put("Crafting pet points", totalPetPoints(player, "Crafting", 12960)).put("Construction pet points", totalPetPoints(player, "Construction", 6532))
            .put("Farming pet points", totalPetPoints(player, "Farming", 33048)).build(), 60, true, true));
        database.add(new Action("Slicing mushrooms", Arrays.asList(new Requirement("Farming", 90), new Requirement("Cooking", 86)), ImmutableMap.of("Slicing mushrooms", 2000),
            ImmutableMap.of("Sliced mushrooms", 1000, "Cooking", 85000, "Herblore", 15000), 1000, true, true));

        //Combat
        Map<Integer, List<Requirement>> trollBruteKills = combatKills(new Encounter("Troll brute"), player, 0, "Magic", 0, false);
        database.add(new Action("Killing troll brutes", trollBruteKills.values().iterator().next(), new HashMap(), ImmutableMap.of("aCombat", (int)Enemy.getEnemyByName("Troll brute").getCbxp()
                * trollBruteKills.keySet().iterator().next(), "Constitution", (int) Enemy.getEnemyByName("Troll brute").getHpxp() * trollBruteKills.keySet().iterator().next(),
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Troll brute").getHpxp() * trollBruteKills.keySet().iterator().next()),
            "Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Troll brute").getCbxp() * trollBruteKills.keySet().iterator().next())/2),
            "Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Troll brute").getCbxp() * trollBruteKills.keySet().iterator().next())/2)),
            trollBruteKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> trollChuckerKillsAndReqs = combatKills(new Encounter("Troll chucker"), player, 0, "Melee", 0, false);
        int trollChuckerKills = trollChuckerKillsAndReqs.keySet().iterator().next();
        List<Requirement> trollChuckerReqs = trollChuckerKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing troll chuckers", trollChuckerReqs, new HashMap(), ImmutableMap.builder().put("mCombat", (int)Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills)
            .put("Constitution", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getHpxp() * trollChuckerKills))
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getHpxp() * trollChuckerKills)))
            .put("Attack pet points", totalPetPoints(player, "Attack", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills)/3))
            .put("Strength pet points", totalPetPoints(player, "Strength", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills)/3))
            .put("Defence pet points", totalPetPoints(player, "Defence", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills)/3)).build(), trollChuckerKills, true, true));

        Map<Integer, List<Requirement>> trollShamanKillsAndReqs = combatKills(new Encounter("Troll shaman"), player, 0, "Ranged", 0, false);
        int trollShamanKills = trollShamanKillsAndReqs.keySet().iterator().next();
        List<Requirement> trollShamanReqs = trollShamanKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing troll shamans", trollShamanReqs, new HashMap(), ImmutableMap.of("rCombat", (int)Enemy.getEnemyByName("Troll shaman").getCbxp() * trollShamanKills,
            "Ranged pet points", totalPetPoints(player, "Ranged", (int) Enemy.getEnemyByName("Troll shaman").getCbxp() * trollShamanKills)/2,
            "Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Troll shaman").getCbxp() * trollShamanKills)/2,
            "Constitution", (int) Enemy.getEnemyByName("Troll shaman").getHpxp() * trollShamanKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Troll shaman").getHpxp() * trollShamanKills)), trollShamanKills, true, true));


        Map<Integer, List<Requirement>> gelatinousAbominationKills = combatKills(new Encounter("Gelatinous abomination"), player, 0, "Ranged", 0.4, true);
        database.add(new Action("Killing gelatinous abominations for gold charms", gelatinousAbominationKills.values().iterator().next(), new HashMap(), ImmutableMap.builder()
            .put("Gold charm", (int) (gelatinousAbominationKills.keySet().iterator().next() * 0.4)).put("rCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() *
                gelatinousAbominationKills.keySet().iterator().next()).put("Constitution", (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() *
                gelatinousAbominationKills.keySet().iterator().next()).put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() *
                gelatinousAbominationKills.keySet().iterator().next())).put("Ranged pet points", totalPetPoints(player, "Ranged", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() *
                gelatinousAbominationKills.keySet().iterator().next()/2)).put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() *
                gelatinousAbominationKills.keySet().iterator().next()/2)).put("Spirit sapphire", gelatinousAbominationKills.keySet().iterator().next()/400).build(),
            gelatinousAbominationKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> giantRockCrabKillsAndReqs = combatKills(new Encounter("Giant rock crab"), player, 0, "Magic", 0.79, true);
        int giantRockCrabKills = giantRockCrabKillsAndReqs.keySet().iterator().next();
        List<Requirement> giantRockCrabReqs = giantRockCrabKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing giant rock crabs for gold charms", giantRockCrabReqs, new HashMap(), ImmutableMap.builder().put("Gold charm", (int) (giantRockCrabKills * 2.37))
            .put("aCombat", (int) Enemy.getEnemyByName("Giant rock crab").getCbxp() * giantRockCrabKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Giant rock crab").getHpxp() * giantRockCrabKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Giant rock crab").getHpxp() * giantRockCrabKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Giant rock crab").getCbxp() * giantRockCrabKills))/2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Giant rock crab").getCbxp() * giantRockCrabKills))/2).build(), giantRockCrabKills, true, true));

        Map<Integer, List<Requirement>> tzhaarKetKillsAndReqs = combatKills(new Encounter("TzHaar-Ket"), player, 0, "Magic", 0.2, true);
        int tzhaarKetKills = tzhaarKetKillsAndReqs.keySet().iterator().next();
        List<Requirement> tzhaarKetReqs = tzhaarKetKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing TzHaar-Kets for obsidian charms", tzhaarKetReqs, new HashMap(), ImmutableMap.builder().put("Obsidian charm", (int) (tzhaarKetKills * 0.4))
            .put("aCombat", (int) Enemy.getEnemyByName("TzHaar-Ket").getCbxp() * tzhaarKetKills)
            .put("Constitution", (int) Enemy.getEnemyByName("TzHaar-Ket").getHpxp() * tzhaarKetKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("TzHaar-Ket").getHpxp() * tzhaarKetKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("TzHaar-Ket").getCbxp() * tzhaarKetKills))/2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("TzHaar-Ket").getCbxp() * tzhaarKetKills))/2).build(), tzhaarKetKills, true, true));

        for (SlayerMonster slayerMonster : SlayerMonsterDatabase.getSlayerMonsterDatabase().getSlayerMonsters()) {
            Enemy enemy = Enemy.getEnemyByName(slayerMonster.getMonster());
            if (enemy.getAffmage() > enemy.getAccmelee() && enemy.getAffmage()> enemy.getAffranged()) {
                Map<Integer, List<Requirement>> monsterKillsAndReqs = combatKills(new Encounter(slayerMonster.getMonster()), player, 28, "Magic", 0, true);
                int monsterKills = monsterKillsAndReqs.keySet().iterator().next();
                ArrayList<Requirement> monsterReqs = new ArrayList<>(monsterKillsAndReqs.values().iterator().next());
                monsterReqs.addAll(slayerMonster.getReqs());
                database.add(new Action(String.format("Killing %s", slayerMonster.getMonster()), monsterReqs, new HashMap(), ImmutableMap.builder()
                    .put("aCombat", (int)enemy.getCbxp() * monsterKills)
                    .put("Constitution", (int)enemy.getHpxp() * monsterKills)
                    .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) enemy.getHpxp() * monsterKills))
                    .put("Magic pet points", totalPetPoints(player, "Magic", ((int) enemy.getCbxp() * monsterKills)/2))
                    .put("Defence pet points", totalPetPoints(player, "Defence", ((int) enemy.getCbxp() * monsterKills)/2))
                    .put(String.format("%s", slayerMonster.getCategory()), monsterKills)
                    .put(String.format("%s", slayerMonster.getMonster()), monsterKills).build(), monsterKills, true, true));
            } else if (enemy.getAffranged() > enemy.getAffmelee()) {
                Map<Integer, List<Requirement>> monsterKillsAndReqs = combatKills(new Encounter(slayerMonster.getMonster()), player, 28, "Ranged", 0, true);
                int monsterKills = monsterKillsAndReqs.keySet().iterator().next();
                ArrayList<Requirement> monsterReqs = new ArrayList<>(monsterKillsAndReqs.values().iterator().next());
                monsterReqs.addAll(slayerMonster.getReqs());
                database.add(new Action(String.format("Killing %s", slayerMonster.getMonster()), monsterReqs, new HashMap(), ImmutableMap.builder()
                    .put("rCombat", (int)enemy.getCbxp() * monsterKills)
                    .put("Constitution", (int)enemy.getHpxp() * monsterKills)
                    .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) enemy.getHpxp() * monsterKills))
                    .put("Ranged pet points", totalPetPoints(player, "Ranged", ((int) enemy.getCbxp() * monsterKills)/2))
                    .put("Defence pet points", totalPetPoints(player, "Defence", ((int) enemy.getCbxp() * monsterKills)/2))
                    .put(String.format("%s", slayerMonster.getCategory()), monsterKills)
                    .put(String.format("%s", slayerMonster.getMonster()), monsterKills).build(), monsterKills, true, true));
            } else {
                Map<Integer, List<Requirement>> monsterKillsAndReqs = combatKills(new Encounter(slayerMonster.getMonster()), player, 28, "Melee", 0, true);
                int monsterKills = monsterKillsAndReqs.keySet().iterator().next();
                ArrayList<Requirement> monsterReqs = new ArrayList<>(monsterKillsAndReqs.values().iterator().next());
                monsterReqs.addAll(slayerMonster.getReqs());
                database.add(new Action(String.format("Killing %s", slayerMonster.getMonster()), monsterReqs, new HashMap(), ImmutableMap.builder()
                    .put("mCombat", (int)enemy.getCbxp() * monsterKills)
                    .put("Constitution", (int)enemy.getHpxp() * monsterKills)
                    .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) enemy.getHpxp() * monsterKills))
                    .put("Attack pet points", totalPetPoints(player, "Attack", ((int) enemy.getCbxp() * monsterKills)/3))
                    .put("Strength pet points", totalPetPoints(player, "Strength", ((int) enemy.getCbxp() * monsterKills)/3))
                    .put("Defence pet points", totalPetPoints(player, "Defence", ((int) enemy.getCbxp() * monsterKills)/3))
                    .put(String.format("%s", slayerMonster.getCategory()), monsterKills)
                    .put(String.format("%s", slayerMonster.getMonster()), monsterKills).build(), monsterKills, true, true));
            }
        }

        database.add(new Action("Killing chompy birds", Collections.singletonList(new Requirement("Big Chompy Bird Hunting", 1)), new HashMap(),
            ImmutableMap.builder().put("Chompy kills", 200).put("rCombat", 12440).put("Ranged pet points", totalPetPoints(player, "Ranged", 6220))
            .put("Defence pet points", totalPetPoints(player, "Defence", 6220)).put("Constitution", 4100).put("Constitution pet points", totalPetPoints(player, "Constitution", 4100)).build(), 200, true, true));

        Map<Integer, List<Requirement>> pigKills = combatKills(new Encounter("Pig"), player, 0, "Magic", 0.05, true);
        database.add(new Action("Killing pigs for teeth", pigKills.values().iterator().next(), new HashMap(), ImmutableMap.builder().put("Pig tooth",
            (int) (pigKills.keySet().iterator().next() * 0.05)).put("aCombat", (int) Enemy.getEnemyByName("Pig").getCbxp() * pigKills.keySet().iterator().next())
            .put("Constitution", (int) Enemy.getEnemyByName("Pig").getHpxp() * pigKills.keySet().iterator().next())
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Pig").getHpxp() * pigKills.keySet().iterator().next()))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Pig").getCbxp() * pigKills.keySet().iterator().next())/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Pig").getCbxp() * pigKills.keySet().iterator().next())/2)).build(),
            pigKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> vyreKillsAndReqs = combatKills(new Encounter("Vyrewatch"), player, 0, "Melee", 1, false);
        int vyreKills = vyreKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> vyreReqs = new ArrayList<>(vyreKillsAndReqs.values().iterator().next());
        vyreReqs.add(new Requirement("Legacy of Seergaze", 1));
        database.add(new Action("Killing vyres for corpses", vyreReqs, new HashMap(),
            ImmutableMap.builder().put("Vyre corpse", vyreKills).put("mCombat", (int)Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Vyrewatch").getHpxp() * vyreKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Vyrewatch").getHpxp() * vyreKills))
                .put("Attack pet points", totalPetPoints(player, "Attack", (int) Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills)/3)
                .put("Strength pet points", totalPetPoints(player, "Strength", (int) Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills)/3)
                .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills)/3)
                .put("Vyrewatch kills", vyreKills).build(), vyreKills, true, true));

        Map<Integer, List<Requirement>> truthfulShadowKillsAndReqs = combatKills(new Encounter("Truthful shadow"), player, 0, "Magic", 0.2, false);
        int truthfulShadowKills = truthfulShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> truthfulShadowReqs = new ArrayList<>(truthfulShadowKillsAndReqs.values().iterator().next());
        truthfulShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing truthful shadows for cores", truthfulShadowReqs, new HashMap(),
            ImmutableMap.builder().put("Truthful shadow core", truthfulShadowKills/5).put("aCombat", (int)Enemy.getEnemyByName("Truthful shadow").getCbxp() * truthfulShadowKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Truthful shadow").getHpxp() * truthfulShadowKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Truthful shadow").getHpxp() * truthfulShadowKills))
                .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Truthful shadow").getCbxp() * truthfulShadowKills)/2))
                .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Truthful shadow").getCbxp() * truthfulShadowKills)/2)).build(), truthfulShadowKills, true, true));

        Map<Integer, List<Requirement>> blissfulShadowKillsAndReqs = combatKills(new Encounter("Blissful shadow"), player, 0, "Magic", 0.2, false);
        int blissfulShadowKills = blissfulShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> blissfulShadowReqs = new ArrayList<>(blissfulShadowKillsAndReqs.values().iterator().next());
        blissfulShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing blissful shadows for cores", blissfulShadowReqs, new HashMap(),
            ImmutableMap.builder().put("Blissful shadow core", blissfulShadowKills/5).put("aCombat", (int)Enemy.getEnemyByName("Blissful shadow").getCbxp() * blissfulShadowKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Blissful shadow").getHpxp() * blissfulShadowKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Blissful shadow").getHpxp() * blissfulShadowKills))
                .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Blissful shadow").getCbxp() * blissfulShadowKills)/2))
                .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Blissful shadow").getCbxp() * blissfulShadowKills)/2)).build(), blissfulShadowKills, true, true));

        Map<Integer, List<Requirement>> manifestShadowKillsAndReqs = combatKills(new Encounter("Manifest shadow"), player, 0, "Magic", 0.2, false);
        int manifestShadowKills = manifestShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> manifestShadowReqs = new ArrayList<>(manifestShadowKillsAndReqs.values().iterator().next());
        manifestShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing manifest shadows for cores", manifestShadowReqs, new HashMap(),
            ImmutableMap.builder().put("Manifest shadow core", manifestShadowKills/5).put("aCombat", (int)Enemy.getEnemyByName("Manifest shadow").getCbxp() * manifestShadowKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Manifest shadow").getHpxp() * manifestShadowKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Manifest shadow").getHpxp() * manifestShadowKills))
                .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Manifest shadow").getCbxp() * manifestShadowKills)/2))
                .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Manifest shadow").getCbxp() * manifestShadowKills)/2)).build(), manifestShadowKills, true, true));

        Map<Integer, List<Requirement>> camelWarriorKillsAndReqs = combatKills(new Encounter("Camel warrior"), player, 0, "Melee", 0, false);
        int camelWarriorKills = camelWarriorKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> camelWarriorReqs = new ArrayList<>(camelWarriorKillsAndReqs.values().iterator().next());
        camelWarriorReqs.add(new Requirement("Slayer", 96));
        database.add(new Action("Killing camel warriors", camelWarriorReqs, new HashMap(),
            ImmutableMap.builder().put("Camel warrior", camelWarriorKills).put("mCombat", (int)Enemy.getEnemyByName("Camel warrior").getCbxp() * camelWarriorKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Camel warrior").getHpxp() * camelWarriorKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Camel warrior").getHpxp() * camelWarriorKills))
                .put("Attack pet points", totalPetPoints(player, "Attack", (int) Enemy.getEnemyByName("Camel warrior").getCbxp() * camelWarriorKills)/3)
                .put("Strength pet points", totalPetPoints(player, "Strength", (int) Enemy.getEnemyByName("Camel warrior").getCbxp() * camelWarriorKills)/3)
                .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Camel warrior").getCbxp() * camelWarriorKills)/3).build(), camelWarriorKills, true, true));

        Map<Integer, List<Requirement>> blackKnightKillsAndReqs = combatKills(new Encounter("Black Knight"), player, 0, "Magic", 0, false);
        int blackKnightKills = blackKnightKillsAndReqs.keySet().iterator().next();
        List<Requirement> blackKnightReqs = blackKnightKillsAndReqs.values().iterator().next();
        blackKnightReqs.add(new Requirement("Wanted!", 1));
        database.add(new Action("Killing Black Knights for rank points", blackKnightReqs, new HashMap(), ImmutableMap.builder().put("Black Knight", blackKnightKills)
            .put("aCombat", (int)Enemy.getEnemyByName("Black Knight").getCbxp() * blackKnightKills).put("Constitution", (int) Enemy.getEnemyByName("Black Knight").getHpxp() * blackKnightKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Black Knight").getHpxp() * blackKnightKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Black Knight").getCbxp() * blackKnightKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Black Knight").getCbxp() * blackKnightKills)/2))
            .put("White Knight rank points", blackKnightKills).build(), blackKnightKills, true, true));

        Map<Integer, List<Requirement>> goblinKillsAndReqs = combatKills(new Encounter("Goblin"), player, 0, "Magic", 0, false);
        int goblinKills = goblinKillsAndReqs.keySet().iterator().next();
        List<Requirement> goblinReqs = goblinKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing goblins for easy clues", goblinReqs, new HashMap(), ImmutableMap.builder().put("Goblin", goblinKills)
            .put("aCombat", (int)Enemy.getEnemyByName("Goblin").getCbxp() * goblinKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Goblin").getHpxp() * goblinKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Goblin").getHpxp() * goblinKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Goblin").getCbxp() * goblinKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Goblin").getCbxp() * goblinKills)/2))
            .put("Sealed clue scroll (easy)", goblinKills/128).build(), goblinKills, true, true));

        Map<Integer, List<Requirement>> hillGiantKillsAndReqs = combatKills(new Encounter("Hill giant"), player, 0, "Magic", 0, false);
        int hillGiantKills = hillGiantKillsAndReqs.keySet().iterator().next();
        List<Requirement> hillGiantReqs = hillGiantKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing hill giants", hillGiantReqs, new HashMap(), ImmutableMap.builder().put("Giant", hillGiantKills)
            .put("aCombat", (int)Enemy.getEnemyByName("Hill giant").getCbxp() * hillGiantKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Hill giant").getHpxp() * hillGiantKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Hill giant").getHpxp() * hillGiantKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Hill giant").getCbxp() * hillGiantKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Hill giant").getCbxp() * hillGiantKills)/2)).build(), hillGiantKills, true, true));

        Map<Integer, List<Requirement>> ghoulKillsAndReqs = combatKills(new Encounter("Ghoul"), player, 0, "Magic", 0, false);
        int ghoulKills = ghoulKillsAndReqs.keySet().iterator().next();
        List<Requirement> ghoulReqs = ghoulKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing ghouls", ghoulReqs, new HashMap(), ImmutableMap.builder().put("Ghoul", ghoulKills).put("aCombat", (int)Enemy.getEnemyByName("Ghoul").getCbxp() * ghoulKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Ghoul").getHpxp() * ghoulKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Ghoul").getHpxp() * ghoulKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Ghoul").getCbxp() * ghoulKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Ghoul").getCbxp() * ghoulKills)/2)).build(), ghoulKills, true, true));

        Map<Integer, List<Requirement>> earthWarriorKillsAndReqs = combatKills(new Encounter("Earth warrior"), player, 0, "Magic", 0, false);
        int earthWarriorKills = earthWarriorKillsAndReqs.keySet().iterator().next();
        List<Requirement> earthWarriorReqs = earthWarriorKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing earth warriors", earthWarriorReqs, new HashMap(), ImmutableMap.builder().put("Earth warrior", earthWarriorKills)
            .put("aCombat", (int)Enemy.getEnemyByName("Earth warrior").getCbxp() * earthWarriorKills).put("Constitution", (int) Enemy.getEnemyByName("Earth warrior").getHpxp() * earthWarriorKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Earth warrior").getHpxp() * earthWarriorKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Earth warrior").getCbxp() * earthWarriorKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Earth warrior").getCbxp() * earthWarriorKills)/2)).build(), earthWarriorKills, true, true));

        Map<Integer, List<Requirement>> cadarnMagusKillsAndReqs = combatKills(new Encounter("Cadarn magus"), player, 0, "Ranged", 0, false);
        int cadarnMagusKills = cadarnMagusKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> cadarnMagusReqs = new ArrayList<>(cadarnMagusKillsAndReqs.values().iterator().next());
        cadarnMagusReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing Cadarn magi", cadarnMagusReqs, new HashMap(), ImmutableMap.builder().put("Cadarn magus", cadarnMagusKills).put("Elf kills", cadarnMagusKills)
            .put("rCombat", (int)Enemy.getEnemyByName("Cadarn magus").getCbxp() * cadarnMagusKills)
            .put("Ranged pet points", totalPetPoints(player, "Ranged", (int)Enemy.getEnemyByName("Cadarn magus").getCbxp() * cadarnMagusKills)/2)
            .put("Constitution", (int) Enemy.getEnemyByName("Cadarn magus").getHpxp() * cadarnMagusKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Cadarn magus").getHpxp() * cadarnMagusKills))
            .put("Defence pet points", totalPetPoints(player, "Defence", (int)Enemy.getEnemyByName("Cadarn magus").getCbxp() * cadarnMagusKills)/2).build(), cadarnMagusKills, true, true));

        Map<Integer, List<Requirement>> jogreKillsAndReqs = combatKills(new Encounter("Jogre"), player, 0, "Magic", 0, false);
        int jogreKills = jogreKillsAndReqs.keySet().iterator().next();
        List<Requirement> jogreReqs = jogreKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing jogres", jogreReqs, new HashMap(), ImmutableMap.builder().put("Jogre", jogreKills).put("aCombat", (int)Enemy.getEnemyByName("Jogre").getCbxp() * jogreKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Jogre").getHpxp() * jogreKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Jogre").getHpxp() * jogreKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Jogre").getCbxp() * jogreKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Jogre").getCbxp() * jogreKills)/2)).build(), jogreKills, true, true));

        Map<Integer, List<Requirement>> mogreKillsAndReqs = combatKills(new Encounter("Mogre"), player, 0, "Magic", 0, false);
        int mogreKills = mogreKillsAndReqs.keySet().iterator().next();
        List<Requirement> mogreReqs = mogreKillsAndReqs.values().iterator().next();
        mogreReqs.add(new Requirement("Mogre miniquest", 1));
        database.add(new Action("Killing mogres", mogreReqs, new HashMap(), ImmutableMap.builder().put("Mogre", mogreKills).put("aCombat", (int)Enemy.getEnemyByName("Mogre").getCbxp() * mogreKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Mogre").getHpxp() * mogreKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Mogre").getHpxp() * mogreKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Mogre").getCbxp() * mogreKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Mogre").getCbxp() * mogreKills)/2)).build(), mogreKills, true, true));

        Map<Integer, List<Requirement>> mummyKillsAndReqs = combatKills(new Encounter("Mummy"), player, 0, "Magic", 0, false);
        int mummyKills = mummyKillsAndReqs.keySet().iterator().next();
        List<Requirement> mummyReqs = mummyKillsAndReqs.values().iterator().next();
        mummyReqs.add(new Requirement("Dealing with Scabaras", 1));
        database.add(new Action("Killing mummies (post-Dealing With Scabaras)", mummyReqs, new HashMap(), ImmutableMap.builder().put("Mummy", mummyKills)
            .put("aCombat", (int)Enemy.getEnemyByName("Mummy").getCbxp() * mummyKills).put("Constitution", (int) Enemy.getEnemyByName("Mummy").getHpxp() * mummyKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Mummy").getHpxp() * mummyKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Mummy").getCbxp() * mummyKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Mummy").getCbxp() * mummyKills)/2)).build(), mummyKills, true, true));

        Map<Integer, List<Requirement>> lesserDemonKillsAndReqs = combatKills(new Encounter("Lesser demon"), player, 0, "Ranged", 0, false);
        int lesserDemonKills = lesserDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> lesserDemonReqs = lesserDemonKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing lesser demons", lesserDemonReqs, new HashMap(), ImmutableMap.builder().put("Lesser demon", lesserDemonKills)
            .put("rCombat", (int)Enemy.getEnemyByName("Lesser demon").getCbxp() * lesserDemonKills)
            .put("Ranged pet points", totalPetPoints(player, "Ranged", (int)Enemy.getEnemyByName("Lesser demon").getCbxp() * lesserDemonKills)/2)
            .put("Constitution", (int) Enemy.getEnemyByName("Lesser demon").getHpxp() * lesserDemonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Lesser demon").getHpxp() * lesserDemonKills))
            .put("Defence pet points", totalPetPoints(player, "Defence", (int)Enemy.getEnemyByName("Lesser demon").getCbxp() * lesserDemonKills)/2).build(), lesserDemonKills, true, true));

        Map<Integer, List<Requirement>> corruptedScorpionKillsAndReqs = combatKills(new Encounter("Corrupted scorpion"), player, 0, "Magic", 0, false);
        int corruptedScorpionKills = corruptedScorpionKillsAndReqs.keySet().iterator().next();
        List<Requirement> corruptedScorpionReqs = corruptedScorpionKillsAndReqs.values().iterator().next();
        corruptedScorpionReqs.add(new Requirement("Slayer", 88));
        database.add(new Action("Killing corrupted scorpions", corruptedScorpionReqs, ImmutableMap.of("Feather of Ma'at", corruptedScorpionKills),
            ImmutableMap.builder().put("Corrupted creatures", corruptedScorpionKills).put("aCombat", (int)Enemy.getEnemyByName("Corrupted scorpion").getCbxp() * corruptedScorpionKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Corrupted scorpion").getHpxp() * corruptedScorpionKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Corrupted scorpion").getHpxp() * corruptedScorpionKills))
                .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Corrupted scorpion").getCbxp() * corruptedScorpionKills)/2))
                .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Corrupted scorpion").getCbxp() * corruptedScorpionKills)/2)).build(),
            corruptedScorpionKills, true, true));

        Map<Integer, List<Requirement>> ripperDemonKillsAndReqs = combatKills(new Encounter("Ripper demon"), player, 0, "Magic", 0, false);
        int ripperDemonKills = ripperDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> ripperDemonReqs = ripperDemonKillsAndReqs.values().iterator().next();
        ripperDemonReqs.add(new Requirement("Slayer", 96));
        database.add(new Action("Killing ripper demons", ripperDemonReqs, new HashMap(), ImmutableMap.builder().put("Ripper demons", ripperDemonKills)
            .put("aCombat", (int)Enemy.getEnemyByName("Ripper demon").getCbxp() * ripperDemonKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Ripper demon").getHpxp() * ripperDemonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Ripper demon").getHpxp() * ripperDemonKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Ripper demon").getCbxp() * ripperDemonKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Ripper demon").getCbxp() * ripperDemonKills)/2)).build(), ripperDemonKills, true, true));
        
        Map<Integer, List<Requirement>> kalgerionDemonKillsAndReqs = combatKills(new Encounter("Kal'gerion demon"), player, 0, "Magic", 0, false);
        int kalgerionDemonKills = kalgerionDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> kalgerionDemonReqs = kalgerionDemonKillsAndReqs.values().iterator().next();
        kalgerionDemonReqs.add(new Requirement("Dungeoneering", 90));
        database.add(new Action("Killing Kal'gerion demons", kalgerionDemonReqs, new HashMap(), ImmutableMap.builder().put("Kal'gerion demon", kalgerionDemonKills)
            .put("aCombat", (int)Enemy.getEnemyByName("Kal'gerion demon").getCbxp() * kalgerionDemonKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Kal'gerion demon").getHpxp() * kalgerionDemonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Kal'gerion demon").getHpxp() * kalgerionDemonKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Kal'gerion demon").getCbxp() * kalgerionDemonKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Kal'gerion demon").getCbxp() * kalgerionDemonKills)/2)).build(), kalgerionDemonKills, true, true));

        Map<Integer, List<Requirement>> impKillsAndReqs = combatKills(new Encounter("Imp"), player, 0, "Magic", 0, false);
        int impKills = impKillsAndReqs.keySet().iterator().next();
        List<Requirement> impReqs = impKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing imps", impReqs, new HashMap(), ImmutableMap.builder().put("Imp", impKills).put("aCombat", (int)Enemy.getEnemyByName("Imp").getCbxp() * impKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Imp").getHpxp() * impKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Imp").getHpxp() * impKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Imp").getCbxp() * impKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Imp").getCbxp() * impKills)/2)).build(), impKills, true, true));

        Map<Integer, List<Requirement>> cowKills = combatKills(new Encounter("Cow"), player, 0, "Magic", 0, false);
        database.add(new Action("Killing cows", cowKills.values().iterator().next(), new HashMap(), ImmutableMap.builder()
            .put("aCombat", (int)Enemy.getEnemyByName("Cow").getCbxp() * cowKills.keySet().iterator().next())
            .put("Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKills.keySet().iterator().next())
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKills.keySet().iterator().next()))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Cow").getCbxp() * cowKills.keySet().iterator().next())/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Cow").getCbxp() * cowKills.keySet().iterator().next())/2))
            .put("Cow kills", cowKills.keySet().iterator().next()).build(), cowKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> revenantKills = combatKills(new Encounter("Revenant demon"), player, 0, "Ranged", 0, false);
        database.add(new Action("Killing revenants", revenantKills.values().iterator().next(), new HashMap(), ImmutableMap.builder()
            .put("rCombat", (int)Enemy.getEnemyByName("Revenant demon").getCbxp() * revenantKills.keySet().iterator().next())
            .put("Constitution", (int) Enemy.getEnemyByName("Revenant demon").getHpxp() * revenantKills.keySet().iterator().next())
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Revenant demon").getHpxp() * revenantKills.keySet().iterator().next()))
            .put("Ranged pet points", totalPetPoints(player, "Ranged", ((int) Enemy.getEnemyByName("Revenant demon").getCbxp() * revenantKills.keySet().iterator().next())/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Revenant demon").getCbxp() * revenantKills.keySet().iterator().next())/2))
            .put("Revenant kills", revenantKills.keySet().iterator().next()).build(), revenantKills.keySet().iterator().next(), true, true));


        Map<Integer, List<Requirement>> yakKillsAndReqs = combatKills(new Encounter("Yak"), player, 0, "Magic", 0, false);
        int yakKills = yakKillsAndReqs.keySet().iterator().next();
        List<Requirement> yakReqs = yakKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing yaks", yakReqs, new HashMap(), ImmutableMap.builder().put("Yak", yakKills).put("aCombat", (int)Enemy.getEnemyByName("Yak").getCbxp() * yakKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Yak").getHpxp() * yakKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Yak").getHpxp() * yakKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Yak").getCbxp() * yakKills)/2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Yak").getCbxp() * yakKills)/2)).build(), yakKills, true, true));


        //Bossing
        Map<Integer, List<Requirement>> kbdKillsAndReqs = combatKills(new Encounter("King Black Dragon"), player, 28, "Melee", 0, false);
        int kbdKills = kbdKillsAndReqs.keySet().iterator().next();
        List<Requirement> kbdReqs = kbdKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing the King Black Dragon", kbdReqs, new HashMap(), ImmutableMap.builder().put("King Black Dragon", kbdKills).put("Boss kills", kbdKills)
            .put("mCombat", (int)Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills).put("Constitution", (int)Enemy.getEnemyByName("King Black Dragon").getHpxp() * kbdKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("King Black Dragon").getHpxp() * kbdKills))
            .put("Attack pet points", totalPetPoints(player, "Attack", (int)Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills)/3)
            .put("Strength pet points", totalPetPoints(player, "Strength", (int)Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills)/3)
            .put("Defence pet points", totalPetPoints(player, "Defence", (int)Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills)/3).build(), kbdKills, true, true));

        Map<Integer, List<Requirement>> chaosElementalKillsAndReqs = combatKills(new Encounter("Chaos Elemental"), player, 28, "Ranged", 0, false);
        int chaosElementalKills = chaosElementalKillsAndReqs.keySet().iterator().next();
        List<Requirement> chaosElementalReqs = chaosElementalKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing the Chaos Elemental", chaosElementalReqs, new HashMap(), ImmutableMap.builder().put("Chaos Elemental", chaosElementalKills).put("Boss kills", chaosElementalKills)
            .put("rCombat", (int)Enemy.getEnemyByName("Chaos Elemental").getCbxp() * chaosElementalKills)
            .put("Ranged pet points", totalPetPoints(player, "Ranged", (int)Enemy.getEnemyByName("Chaos Elemental").getCbxp() * chaosElementalKills)/2)
            .put("Defence pet points", totalPetPoints(player, "Defence", (int)Enemy.getEnemyByName("Chaos Elemental").getCbxp() * chaosElementalKills)/2)
            .put("Constitution", (int)Enemy.getEnemyByName("Chaos Elemental").getHpxp() * chaosElementalKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Chaos Elemental").getHpxp() * chaosElementalKills)).build(), chaosElementalKills, true, true));

        Map<Integer, List<Requirement>> dagannothRexKillsAndReqs = combatKills(new Encounter("Dagannoth Rex"), player, 28, "Magic", 0, false);
        int dagannothRexKills = dagannothRexKillsAndReqs.keySet().iterator().next();
        List<Requirement> dagannothRexReqs = dagannothRexKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing Dagannoth Rex", dagannothRexReqs, new HashMap(), ImmutableMap.builder().put("Dagannoth Rex", dagannothRexKills)
            .put("Dagannoth Kings", dagannothRexKills).put("Boss kills", dagannothRexKills).put("aCombat", (int)Enemy.getEnemyByName("Dagannoth Rex").getCbxp() * dagannothRexKills)
            .put("Constitution", (int)Enemy.getEnemyByName("Dagannoth Rex").getHpxp() * dagannothRexKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Dagannoth Rex").getHpxp() * dagannothRexKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", (int)Enemy.getEnemyByName("Dagannoth Rex").getCbxp() * dagannothRexKills)/2)
            .put("Defence pet points", totalPetPoints(player, "Defence", (int)Enemy.getEnemyByName("Dagannoth Rex").getCbxp() * dagannothRexKills)/2).build(), dagannothRexKills, true, true));

        Map<Integer, List<Requirement>> dagannothPrimeKillsAndReqs = combatKills(new Encounter("Dagannoth Prime"), player, 28, "Ranged", 0, false);
        int dagannothPrimeKills = dagannothPrimeKillsAndReqs.keySet().iterator().next();
        List<Requirement> dagannothPrimeReqs = dagannothPrimeKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing Dagannoth Prime", dagannothPrimeReqs, new HashMap(), ImmutableMap.builder().put("Dagannoth Prime", dagannothPrimeKills)
            .put("Dagannoth Kings", dagannothPrimeKills).put("Boss kills", dagannothPrimeKills).put("rCombat", (int)Enemy.getEnemyByName("Dagannoth Prime").getCbxp() * dagannothPrimeKills)
            .put("Ranged pet points", totalPetPoints(player, "Ranged", (int)Enemy.getEnemyByName("Dagannoth Prime").getCbxp() * dagannothPrimeKills)/2)
            .put("Defence pet points", totalPetPoints(player, "Defence", (int)Enemy.getEnemyByName("Dagannoth Prime").getCbxp() * dagannothPrimeKills)/2)
            .put("Constitution", (int)Enemy.getEnemyByName("Dagannoth Prime").getHpxp() * dagannothPrimeKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Dagannoth Prime").getHpxp() * dagannothPrimeKills)).build(), dagannothPrimeKills, true, true));

        Map<Integer, List<Requirement>> dagannothSupremeKillsAndReqs = combatKills(new Encounter("Dagannoth Supreme"), player, 28, "Melee", 0, false);
        int dagannothSupremeKills = dagannothSupremeKillsAndReqs.keySet().iterator().next();
        List<Requirement> dagannothSupremeReqs = dagannothSupremeKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing Dagannoth Supreme", dagannothSupremeReqs, new HashMap(), ImmutableMap.builder().put("Dagannoth Supreme", dagannothSupremeKills)
            .put("Dagannoth Kings", dagannothSupremeKills).put("Boss kills", dagannothSupremeKills)
            .put("mCombat", (int)Enemy.getEnemyByName("Dagannoth Supreme").getCbxp() * dagannothSupremeKills)
            .put("Constitution", (int)Enemy.getEnemyByName("Dagannoth Supreme").getHpxp() * dagannothSupremeKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Dagannoth Supreme").getHpxp() * dagannothSupremeKills))
            .put("Attack pet points", totalPetPoints(player, "Attack", (int)Enemy.getEnemyByName("Dagannoth Supreme").getCbxp() * dagannothSupremeKills))
            .put("Strength pet points", totalPetPoints(player, "Strength", (int)Enemy.getEnemyByName("Dagannoth Supreme").getCbxp() * dagannothSupremeKills))
            .put("Defence pet points", totalPetPoints(player, "Defence", (int)Enemy.getEnemyByName("Dagannoth Supreme").getCbxp() * dagannothSupremeKills)).build(),
            dagannothSupremeKills, true, true));

        Map<Integer, List<Requirement>> qbdKillsAndReqs = combatKills(new Encounter("Queen Black Dragon"), player, 28, "Melee", 0, false);
        int qbdKills = qbdKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> qbdReqs = new ArrayList<>(qbdKillsAndReqs.values().iterator().next());
        qbdReqs.add(new Requirement("Summoning", 60));
        database.add(new Action("Killing the Queen Black Dragon", qbdReqs, new HashMap(),
            ImmutableMap.builder().put("Queen Black Dragon", qbdKills).put("Boss kills", qbdKills).put("mCombat", (int)Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills)
                .put("Constitution", (int)Enemy.getEnemyByName("Queen Black Dragon").getHpxp() * qbdKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Queen Black Dragon").getHpxp() * qbdKills))
                .put("Attack pet points", totalPetPoints(player, "Attack", (int)Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills)/3)
                .put("Strength pet points", totalPetPoints(player, "Strength", (int)Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills)/3)
                .put("Defence pet points", totalPetPoints(player, "Defence", (int)Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills)/3).build(), qbdKills, true, true));

        Map<Integer, List<Requirement>> durzagKills = combatKills(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Charger", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")), 10), player, 28, "Melee", 0, false);
        database.add(new Action("Killing Beastmaster Durzag (10 man)", durzagKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Beastmaster Durzag", durzagKills.keySet().iterator().next(),
            "Boss kills", durzagKills.keySet().iterator().next(), "Liberation of Mazcab", durzagKills.keySet().iterator().next(), "Teci", durzagKills.keySet().iterator().next()*1000),
            durzagKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> raxKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Araxxor"), Collections.singletonList("Araxxi"))), player, 28, "Melee", 0, false);
        database.add(new Action("Killing Araxxor", raxKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Araxxi", raxKills.keySet().iterator().next(),
            "Boss kills", durzagKills.keySet().iterator().next()), durzagKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kqKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Kalphite Queen (Phase 1)"), Collections.singletonList("Kalphite Queen (Phase 2)"))),
            player, 28, "Melee", 0, false);
        database.add(new Action("Killing the Kalphite Queen", kqKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Kalphite Queen", kqKills.keySet().iterator().next(),
            "Boss kills", kqKills.keySet().iterator().next()), kqKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kkKills = combatKills(new Encounter(Collections.singletonList(Collections.singletonList("Kalphite King")), 2), player, 28, "Melee", 0, false);
        database.add(new Action("Killing the Kalphite King (duo)", kkKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Kalphite King", kkKills.keySet().iterator().next(),
            "Boss kills", kkKills.keySet().iterator().next()), kkKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> corporealBeastKills = combatKills(new Encounter("Corporeal Beast"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> corporealBeastReqs = new ArrayList(corporealBeastKills.values().iterator().next());
        corporealBeastReqs.add(new Requirement("Summer's End", 1));
        database.add(new Action("Killing the Corporeal Beast", corporealBeastReqs, new HashMap(), ImmutableMap.of("Corporeal Beast", corporealBeastKills.keySet().iterator().next(),
            "Boss kills", corporealBeastKills.keySet().iterator().next()), corporealBeastKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> voragoKills = combatKills(new Encounter(Collections.singletonList(Collections.singletonList("Vorago")), 7), player, 28, "Melee", 0, false);
        database.add(new Action("Killing Vorago (7 man)", voragoKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Vorago", voragoKills.keySet().iterator().next(),
            "Boss kills", voragoKills.keySet().iterator().next()), voragoKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> jadKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Tz-Kih"), Arrays.asList("Tz-Kih", "Tz-Kih"),
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
        Arrays.asList("TzTok-Jad", "Yt-HurKot", "Yt-HurKot", "Yt-HurKot", "Yt-HurKot")), true), player, 28, "Magic", 0, false);
        database.add(new Action("Completing the Fight Caves", jadKills.values().iterator().next(), new HashMap(), ImmutableMap.of("TzTok-Jad", jadKills.keySet().iterator().next(),
            "Boss kills", jadKills.keySet().iterator().next()), jadKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kilnClearsAndReqs = combatKills(
            new Encounter(Arrays.asList(Arrays.asList("TokHaar-Hur", "TokHaar-Hur", "TokHaar-Xil", "TokHaar-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Hur", "TokHaar-Xil", "TokHaar-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Hur", "TokHaar-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Mej", "TokHaar-Mej", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Dill", "TokHaar-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Mej", "TokHaar-Mej", "TokHaar-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Mej", "TokHaar-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Jad", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Mej", "TokHaar-Mej", "TokHaar-Mej", "TokHaar-Mej"),
                Arrays.asList("TokHaar-Mej", "TokHaar-Mej", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Mej", "TokHaar-Mej"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Ket-Zek", "TokHaar-Mej", "TokHaar-Mej"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Ket-Zek", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Ket-Zek", "TokHaar-Mej", "TokHaar-Mej", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Ket-Zek", "TokHaar-Mej", "TokHaar-Yt-MejKot", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Ket-Zek", "TokHaar-Mej", "TokHaar-Yt-MejKot", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Dill", "TokHaar-Mej", "TokHaar-Mej", "TokHaar-Mej", "TokHaar-Mej", "TokHaar-Mej", "TokHaar-Mej", "TokHaar-Mej", "TokHaar-Mej"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Jad"),
                Arrays.asList("TokHaar-Hur", "TokHaar-Hur", "TokHaar-Hur", "TokHaar-Hur", "TokHaar-Hur", "TokHaar-Hur",
                    "TokHaar-Hur", "TokHaar-Hur", "TokHaar-Hur", "TokHaar-Hur", "TokHaar-Hur", "TokHaar-Hur"),
                Arrays.asList("TokHaar-Yt-MejKot", "TokHaar-Ket", "TokHaar-Ket", "TokHaar-Hur", "TokHaar-Hur"),
                Arrays.asList("TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Ket", "TokHaar-Hur", "TokHaar-Hur"),
                Arrays.asList("TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Ket-Zek", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Ket", "TokHaar-Ket", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Ket-Dill", "TokHaar-Ket-Dill", "TokHaar-Ket-Dill", "TokHaar-Ket-Dill", "TokHaar-Ket-Dill", "TokHaar-Ket-Dill"),
                Arrays.asList("TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot"),
                Arrays.asList("TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Jad"),
                Arrays.asList("TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot", "TokHaar-Yt-MejKot"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Ket-Zek", "TokHaar-Ket-Zek", "TokHaar-Ket-Zek"),
                Arrays.asList("TokHaar-Yt-MejKot", "TokHaar-Jad", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Ket-Zek", "TokHaar-Yt-MejKot", "TokHaar-Jad", "TokHaar-Tok-Xil"),
                Arrays.asList("TokHaar-Jad", "TokHaar-Jad"), Collections.singletonList("Har-Aken"))), player, 28, "Magic", 0, false);
        ArrayList<Requirement> kilnReqs = new ArrayList(kilnClearsAndReqs.values().iterator().next());
        kilnReqs.add(new Requirement("TzTok-Jad", 1));
        kilnReqs.add(new Requirement("The Elder Kiln", 1));
        database.add(new Action("Completing the Fight Kiln", kilnReqs, new HashMap(), ImmutableMap.of("Har-Aken", kilnClearsAndReqs.keySet().iterator().next(),
            "Boss kills", kilnClearsAndReqs.keySet().iterator().next()), kilnClearsAndReqs.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> voragoHMKills = combatKills(new Encounter(Collections.singletonList(Collections.singletonList("Vorago (HM)")), 7), player, 28, "Melee", 0, false);
        database.add(new Action("Killing hard mode Vorago (7 man)", voragoHMKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Vorago (HM)", voragoHMKills.keySet().iterator().next(),
            "Boss kills", voragoHMKills.keySet().iterator().next()), voragoHMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> moleKills = combatKills(new Encounter("Giant Mole"), player, 28, "Magic", 0, false);
        database.add(new Action("Killing Giant Mole", moleKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Giant Mole", moleKills.keySet().iterator().next(),
            "Boss kills", moleKills.keySet().iterator().next()), moleKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> hardMoleKills = combatKills(new Encounter("Giant Mole (hard)"), player, 28, "Magic", 0, false);
        database.add(new Action("Killing Giant Mole", hardMoleKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Giant Mole (hard)", hardMoleKills.keySet().iterator().next(),
            "Boss kills", hardMoleKills.keySet().iterator().next()), hardMoleKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> twinFuriesKills = combatKills(new Encounter("Twin Furies"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> twinFuriesReqs = new ArrayList(twinFuriesKills.values().iterator().next());
        twinFuriesReqs.add(new Requirement("Ranged", 80));
        database.add(new Action("Killing the Twin Furies", twinFuriesReqs, new HashMap(), ImmutableMap.of("Twin Furies", twinFuriesKills.keySet().iterator().next(),
            "Boss kills", twinFuriesKills.keySet().iterator().next(), "Zaros reputation", 5*twinFuriesKills.keySet().iterator().next()),
            twinFuriesKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> twinFuriesCMKills = combatKills(new Encounter("Twin Furies (CM)"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> twinFuriesCMReqs = new ArrayList(twinFuriesKills.values().iterator().next());
        twinFuriesReqs.add(new Requirement("Ranged", 80));
        database.add(new Action("Killing the Twin Furies (CM)", twinFuriesCMReqs, new HashMap(), ImmutableMap.of("Twin Furies (CM)", twinFuriesCMKills.keySet().iterator().next(),
            "Boss kills", twinFuriesCMKills.keySet().iterator().next(), "Zaros reputation", 15*twinFuriesCMKills.keySet().iterator().next()),
            twinFuriesCMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> vindictaKills = combatKills(new Encounter("Vindicta"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> vindictaReqs = new ArrayList(vindictaKills.values().iterator().next());
        vindictaReqs.add(new Requirement("Attack", 80));
        database.add(new Action("Killing Vindicta", vindictaReqs, new HashMap(), ImmutableMap.of("Vindicta", vindictaKills.keySet().iterator().next(),
            "Boss kills", vindictaKills.keySet().iterator().next(), "Seren reputation", 5*vindictaKills.keySet().iterator().next()),
            vindictaKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> vindictaHMKills = combatKills(new Encounter("Vindicta (hard)"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> vindictaHMReqs = new ArrayList(vindictaHMKills.values().iterator().next());
        vindictaHMReqs.add(new Requirement("Attack", 80));
        database.add(new Action("Killing Vindicta in hard mode", vindictaHMReqs, new HashMap(), ImmutableMap.of("Vindicta (hard)", vindictaHMKills.keySet().iterator().next(),
            "Boss kills", vindictaHMKills.keySet().iterator().next(), "Seren reputation", 15*vindictaHMKills.keySet().iterator().next()),
            vindictaHMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> helwyrKills = combatKills(new Encounter("Helwyr"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> helwyrReqs = new ArrayList(helwyrKills.values().iterator().next());
        helwyrReqs.add(new Requirement("Magic", 80));
        database.add(new Action("Killing Helwyr", helwyrReqs, new HashMap(), ImmutableMap.of("Helwyr", helwyrKills.keySet().iterator().next(),
            "Boss kills", helwyrKills.keySet().iterator().next(), "Sliske reputation", 5*helwyrKills.keySet().iterator().next()), helwyrKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> helwyrHMKills = combatKills(new Encounter("Helwyr (hard)"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> helwyrHMReqs = new ArrayList(helwyrHMKills.values().iterator().next());
        helwyrHMReqs.add(new Requirement("Magic", 80));
        database.add(new Action("Killing Helwyr in hard mode", helwyrHMReqs, new HashMap(), ImmutableMap.of("Helwyr (hard)", helwyrHMKills.keySet().iterator().next(),
            "Boss kills", helwyrHMKills.keySet().iterator().next(), "Sliske reputation", 15*helwyrHMKills.keySet().iterator().next()),
            helwyrHMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> gregKills = combatKills(new Encounter("Gregorovic"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> gregReqs = new ArrayList(gregKills.values().iterator().next());
        gregReqs.add(new Requirement("Prayer", 80));
        database.add(new Action("Killing Gregorovic", gregReqs, new HashMap(), ImmutableMap.of("Gregorovic", gregKills.keySet().iterator().next(),
            "Boss kills", gregKills.keySet().iterator().next(), "Zamorak reputation", 5*gregKills.keySet().iterator().next()), gregKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> gregCMKills = combatKills(new Encounter("Gregorovic (CM)"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> gregCMReqs = new ArrayList(gregCMKills.values().iterator().next());
        gregCMReqs.add(new Requirement("Prayer", 80));
        database.add(new Action("Killing Gregorovic (CM)", gregCMReqs, new HashMap(), ImmutableMap.of("Gregorovic (hard)", gregCMKills.keySet().iterator().next(),
            "Boss kills", gregCMKills.keySet().iterator().next(), "Zamorak reputation", 15*gregCMKills.keySet().iterator().next()),
            gregCMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kreeKills = combatKills(new Encounter("Kree'arra"), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> kreeReqs = new ArrayList<>(kreeKills.values().iterator().next());
        kreeReqs.add(new Requirement("Ranged", 70));
        database.add(new Action("Killing Kree'arra", kreeReqs, new HashMap(), ImmutableMap.of("Kree'arra", kreeKills.keySet().iterator().next(),
            "Boss kills", kreeKills.keySet().iterator().next()), kreeKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kreeKillsHM = combatKills(new Encounter("Kree'arra (HM)"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> kreeReqsHM = new ArrayList(kreeKillsHM.values().iterator().next());
        kreeReqs.add(new Requirement("Ranged", 70));
        database.add(new Action("Killing Kree'arra in hard mode", kreeReqsHM, new HashMap(), ImmutableMap.of("Kree'arra (HM)", kreeKillsHM.keySet().iterator().next(),
            "Boss kills", kreeKillsHM.keySet().iterator().next()), kreeKillsHM.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> graardorKills = combatKills(new Encounter("General Graardor"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> graardorReqs = new ArrayList(graardorKills.values().iterator().next());
        graardorReqs.add(new Requirement("Strength", 70));
        database.add(new Action("Killing General Graardor", graardorReqs, new HashMap(), ImmutableMap.of("General Graardor", graardorKills.keySet().iterator().next(),
            "Boss kills", graardorKills.keySet().iterator().next()), graardorKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> graardorHMKills = combatKills(new Encounter("General Graardor (hard)"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> graardorHMReqs = new ArrayList(graardorKills.values().iterator().next());
        graardorHMReqs.add(new Requirement("Strength", 70));
        database.add(new Action("Killing General Graardor (hard)", graardorHMReqs, new HashMap(), ImmutableMap.of("General Graardor (hard)", graardorHMKills.keySet().iterator().next(),
            "Boss kills", graardorHMKills.keySet().iterator().next()), graardorHMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> krilKills = combatKills(new Encounter("K'ril Tsutsaroth"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> krilReqs = new ArrayList(krilKills.values().iterator().next());
        krilReqs.add(new Requirement("Constitution", 70));
        database.add(new Action("Killing K'ril Tsutsaroth", krilReqs, new HashMap(), ImmutableMap.of("K'ril Tsutsaroth", krilKills.keySet().iterator().next(),
            "Boss kills", krilKills.keySet().iterator().next()), krilKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> krilKillsHM = combatKills(new Encounter("K'ril Tsutsaroth (hard)"), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> krilReqsHM = new ArrayList(krilKills.values().iterator().next());
        krilReqs.add(new Requirement("Constitution", 70));
        database.add(new Action("Killing K'ril Tsutsaroth in hard mode", krilReqsHM, new HashMap(), ImmutableMap.of("K'ril Tsutsaroth (hard)", krilKillsHM.keySet().iterator().next(),
            "Boss kills", krilKillsHM.keySet().iterator().next()), krilKillsHM.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> zilyanaKills = combatKills(new Encounter("Commander Zilyana"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> zilyanaReqs = new ArrayList(zilyanaKills.values().iterator().next());
        zilyanaReqs.add(new Requirement("Agility", 70));
        database.add(new Action("Killing Commander Zilyana", zilyanaReqs, new HashMap(), ImmutableMap.of("Commander Zilyana", zilyanaKills.keySet().iterator().next(),
            "Boss kills", zilyanaKills.keySet().iterator().next()), zilyanaKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> yakamaruKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Yakamaru"),
            Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru"),
            Collections.singletonList("Image of Yakamaru"), Collections.singletonList("Image of Yakamaru")), 10), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> yakamaruReqs = new ArrayList(yakamaruKills.values().iterator().next());
        zilyanaReqs.add(new Requirement("Beastmaster Durzag", 1));
        database.add(new Action("Killing Yakamaru (10 man)", yakamaruReqs, new HashMap(), ImmutableMap.of("Yakamaru", yakamaruKills.keySet().iterator().next(),
            "Boss kills", yakamaruKills.keySet().iterator().next(), "Liberation of Mazcab", yakamaruKills.keySet().iterator().next()),
            yakamaruKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> zilyanaHMKills = combatKills(new Encounter("Commander Zilyana (hard)"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> zilyanaHMReqs = new ArrayList(zilyanaKills.values().iterator().next());
        zilyanaReqs.add(new Requirement("Agility", 70));
        database.add(new Action("Killing Commander Zilyana (hard)", zilyanaHMReqs, new HashMap(), ImmutableMap.of("Commander Zilyana (hard)", zilyanaHMKills.keySet().iterator().next(),
            "Boss kills", zilyanaHMKills.keySet().iterator().next()), zilyanaHMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> magisterKills = combatKills(new Encounter("The Magister"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> magisterReqs = new ArrayList(magisterKills.values().iterator().next());
        magisterReqs.add(new Requirement("Slayer", 115));
        database.add(new Action("Killing The Magister", magisterReqs, ImmutableMap.of("Key to the Crossing", magisterKills.keySet().iterator().next()),
            ImmutableMap.of("The Magister", magisterKills.keySet().iterator().next(), "Boss kills", magisterKills.keySet().iterator().next()),
            magisterKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> legioKills = combatKills(new Encounter("Legio"), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> legioReqs = new ArrayList(legioKills.values().iterator().next());
        legioReqs.add(new Requirement("Slayer", 95));

        database.add(new Action("Killing Legio Primus", legioReqs, ImmutableMap.of("Ascension Keystone Primus", legioKills.keySet().iterator().next()),
            ImmutableMap.of("Legio Primus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Secundus", legioReqs, ImmutableMap.of("Ascension Keystone Secundus", legioKills.keySet().iterator().next()),
            ImmutableMap.of("Legio Secundus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Tertius", legioReqs, ImmutableMap.of("Ascension Keystone Tertius", legioKills.keySet().iterator().next()),
            ImmutableMap.of("Legio Tertius", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Quartus", legioReqs, ImmutableMap.of("Ascension Keystone Quartus", legioKills.keySet().iterator().next()),
            ImmutableMap.of("Legio Quartus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Quintus", legioReqs, ImmutableMap.of("Ascension Keystone Quintus", legioKills.keySet().iterator().next()),
            ImmutableMap.of("Legio Quintus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Sextus", legioReqs, ImmutableMap.of("Ascension Keystone Sextus", legioKills.keySet().iterator().next()),
            ImmutableMap.of("Legio Sextus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> nexKills = combatKills(new Encounter("Nex"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> nexReqs = new ArrayList(nexKills.values().iterator().next());
        nexReqs.add(new Requirement("General Graardor", 1));
        nexReqs.add(new Requirement("K'ril Tsutsaroth", 1));
        nexReqs.add(new Requirement("Commander Zilyana", 1));
        nexReqs.add(new Requirement("Kree'arra", 1));
        database.add(new Action("Killing Nex", nexReqs, new HashMap(), ImmutableMap.of("Nex", nexKills.keySet().iterator().next(), "Boss kills", nexKills.keySet().iterator().next()),
            nexKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> nexAODKills = combatKills(new Encounter(Collections.singletonList(Collections.singletonList("Nex: Angel of Death")), 7), player, 28, "Melee", 0, false);
        ArrayList<Requirement> nexAODReqs = new ArrayList<>(nexAODKills.values().iterator().next());
        nexAODReqs.add(new Requirement("General Graardor", 1));
        nexAODReqs.add(new Requirement("K'ril Tsutsaroth", 1));
        nexAODReqs.add(new Requirement("Commander Zilyana", 1));
        nexAODReqs.add(new Requirement("Kree'arra", 1));
        database.add(new Action("Killing Nex: Angel of Death (7 man)", nexAODReqs, new HashMap(), ImmutableMap.of("Nex: Angel of Death", nexAODKills.keySet().iterator().next(),
            "Boss kills", nexAODKills.keySet().iterator().next()), nexAODKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> rotsKills = combatKills(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
            "Dharok the Wretched (ROTS)"), Arrays.asList("Guthan the Infested (ROTS)", "Ahrim the Blighted (ROTS)",
            "Verac the Defiled (ROTS)")), 4), player, 28, "Ranged", 0, false);
        database.add(new Action("Killing ROTS (4 man)", rotsKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Rise of the Six", rotsKills.keySet().iterator().next(),
            "Boss kills", rotsKills.keySet().iterator().next()), rotsKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> barrowsKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Karil the Tainted"), Collections.singletonList("Ahrim the Blighted"),
            Collections.singletonList("Torag the Corrupted"), Collections.singletonList("Dharok the Wretched"), Collections.singletonList("Verac the Defiled"),
            Collections.singletonList("Guthan the Infested"), Collections.singletonList("Akrisae the Doomed"))), player, 28, "Magic", 0, false);
        ArrayList<Requirement> barrowsReqs = new ArrayList(barrowsKills.values().iterator().next());
        barrowsReqs.add(new Requirement("Ritual of the Mahjarrat", 1));
        database.add(new Action("Killing Barrows incl. Akrisae", barrowsReqs, new HashMap(), ImmutableMap.of("Barrows", barrowsKills.keySet().iterator().next(),
            "Boss kills", barrowsKills.keySet().iterator().next()), barrowsKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> linzaKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Karil the Tainted"), Collections.singletonList("Ahrim the Blighted"),
            Collections.singletonList("Torag the Corrupted"), Collections.singletonList("Dharok the Wretched"), Collections.singletonList("Verac the Defiled"),
            Collections.singletonList("Guthan the Infested"), Collections.singletonList("Linza the Disgraced"))), player, 28, "Magic", 0, false);
        ArrayList<Requirement> linzaReqs = new ArrayList(linzaKills.values().iterator().next());
        linzaReqs.add(new Requirement("Kindred Spirits", 1));
        database.add(new Action("Killing Barrows incl. Linza", linzaReqs, new HashMap(), ImmutableMap.of("Linza", linzaKills.keySet().iterator().next(),
            "Boss kills", linzaKills.keySet().iterator().next()), linzaKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> telosKills = combatKills(new Encounter("Telos (100% enrage)"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> telosReqs = new ArrayList(telosKills.values().iterator().next());
        telosReqs.add(new Requirement("Vindicta", 1));
        telosReqs.add(new Requirement("Twin Furies", 1));
        telosReqs.add(new Requirement("Gregorovic", 1));
        telosReqs.add(new Requirement("Helwyr", 1));
        telosReqs.add(new Requirement("100% Telos defeated", 1));
        database.add(new Action("Killing Telos (100% enrage)", telosReqs, new HashMap(), ImmutableMap.of("Telos", telosKills.keySet().iterator().next(),
            "Boss kills", telosKills.keySet().iterator().next()), telosKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> solakKills = combatKills(new Encounter("Solak", 7), player, 28, "Melee", 0, false);
        ArrayList<Requirement> solakReqs = new ArrayList(solakKills.values().iterator().next());
        database.add(new Action("Killing Solak (7 man)", solakReqs, new HashMap(), ImmutableMap.of("Solak", solakKills.keySet().iterator().next(),
            "Boss kills", solakKills.keySet().iterator().next()), solakKills.keySet().iterator().next(), true, true));

        //Other repeatables
        database.add(new Action("Completing Shifting Tombs", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 50), new Requirement("The Jack of Spades", 1)),
            new HashMap<>(), ImmutableMap.of("Shifting Tombs", 12, "Corundum", 1), 12, true, true));

        database.add(new Action("Completing Shifting Tombs (using reward enhancers)", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 50), new Requirement("The Jack of Spades", 1)),
            ImmutableMap.of("Dungeoneering token", 12000), ImmutableMap.of("Shifting Tombs", 12, "Perfect Shifting Tombs runs with enhancers", 12, "Corundum", 1), 12, true, true));

        database.add(new Action("Completing Shifting Tombs (w/camo fragments)", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 70), new Requirement("The Jack of Spades", 1)),
            new HashMap<>(), ImmutableMap.of("Shifting Tombs", 12, "Camouflage fragment", 3000, "Corundum", 1), 12, true, true));

        Map<Integer, List<Requirement>> sanctumGuardianGroupKills = combatKills(new Encounter("The Sanctum Guardian", 3), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> masutaGroupKills = combatKills(new Encounter("Masuta the Ascended", 3), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> seiryuGroupKills = combatKills(new Encounter("Seiryu", 3), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> toaReqs = new ArrayList<>();
        toaReqs.add(new Requirement("Curse of the Black Stone", 1));
        toaReqs.addAll(sanctumGuardianGroupKills.values().iterator().next());
        toaReqs.addAll(masutaGroupKills.values().iterator().next());
        toaReqs.addAll(seiryuGroupKills.values().iterator().next());
        database.add(new Action("Completing the Temple of Aminishi (group)", toaReqs, new HashMap<>(), ImmutableMap.builder().put("The Sanctum Guardian group kills", 2)
            .put("Masuta the Ascended group kills", 2).put("Seiryu group kills", 2).put("The Sanctum Guardian", 2).put("Masuta", 2).put("Seiryu", 2).put("Boss kills", 6).build(), 2, true, true));

        Map<Integer, List<Requirement>> sanctumGuardianSoloKills = combatKills(new Encounter("The Sanctum Guardian"), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> masutaSoloKills = combatKills(new Encounter("Masuta the Ascended"), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> seiryuSoloKills = combatKills(new Encounter("Seiryu"), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> toaSoloReqs = new ArrayList<>();
        toaSoloReqs.add(new Requirement("Curse of the Black Stone", 1));
        toaSoloReqs.addAll(sanctumGuardianSoloKills.values().iterator().next());
        toaSoloReqs.addAll(masutaSoloKills.values().iterator().next());
        toaSoloReqs.addAll(seiryuSoloKills.values().iterator().next());
        database.add(new Action("Completing the Temple of Aminishi (solo)", toaSoloReqs, new HashMap<>(), ImmutableMap.builder().put("The Sanctum Guardian solo kills", 2)
            .put("Masuta the Ascended solo kills", 2).put("Seiryu solo kills", 2).put("The Sanctum Guardian", 2).put("Masuta", 2).put("Seiryu", 2).put("Boss kills", 6).build(), 2, true, true));

        Map<Integer, List<Requirement>> astellarnGroupKills = combatKills(new Encounter("Astellarn", 3), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> verakLithGroupKills = combatKills(new Encounter("Verak Lith", 3), player, 28, "Magic", 0, false);
        Map<Integer, List<Requirement>> blackStoneDragonGroupKills = combatKills(new Encounter("Black Stone Dragon", 3), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> dlReqs = new ArrayList<>();
        dlReqs.add(new Requirement("Curse of the Black Stone", 1));
        dlReqs.addAll(astellarnGroupKills.values().iterator().next());
        dlReqs.addAll(verakLithGroupKills.values().iterator().next());
        dlReqs.addAll(blackStoneDragonGroupKills.values().iterator().next());
        database.add(new Action("Completing the Dragonkin Laboratory (group)", dlReqs, new HashMap<>(), ImmutableMap.builder().put("Astellarn group kills", 2)
            .put("Verak Lith group kills", 2).put("Black Stone Dragon group kills", 2).put("Astellarn", 2).put("Verak Lith", 2).put("Black Stone Dragon", 2).put("Boss kills", 6).build(), 2, true, true));

        Map<Integer, List<Requirement>> astellarnSoloKills = combatKills(new Encounter("Astellarn"), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> verakLithSoloKills = combatKills(new Encounter("Verak Lith"), player, 28, "Magic", 0, false);
        Map<Integer, List<Requirement>> blackStoneDragonSoloKills = combatKills(new Encounter("Black Stone Dragon"), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> dlSoloReqs = new ArrayList<>();
        dlSoloReqs.add(new Requirement("Curse of the Black Stone", 1));
        dlSoloReqs.add(new Requirement("Ritual of the Mahjarrat", 1));
        dlSoloReqs.addAll(astellarnSoloKills.values().iterator().next());
        dlSoloReqs.addAll(verakLithSoloKills.values().iterator().next());
        dlSoloReqs.addAll(blackStoneDragonSoloKills.values().iterator().next());
        database.add(new Action("Completing the Dragonkin Laboratory (solo)", dlSoloReqs, new HashMap<>(), ImmutableMap.builder().put("Astellarn solo kills", 2)
            .put("Verak Lith solo kills", 2).put("Black Stone Dragon solo kills", 2).put("Astellarn", 2).put("Verak Lith", 2).put("Black Stone Dragon", 2).put("Boss kills", 6).build(), 2, true, true));

        Map<Integer, List<Requirement>> crassianGroupKills = combatKills(new Encounter("The Crassian Leviathan", 3), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> taraketGroupKills = combatKills(new Encounter("Taraket the Necromancer", 3), player, 28, "Magic", 0, false);
        Map<Integer, List<Requirement>> ambassadorGroupKills = combatKills(new Encounter("The Ambassador", 3), player, 28, "Magic", 0, false);
        ArrayList<Requirement> tsrReqs = new ArrayList<>();
        tsrReqs.add(new Requirement("Curse of the Black Stone", 1));
        tsrReqs.addAll(crassianGroupKills.values().iterator().next());
        tsrReqs.addAll(taraketGroupKills.values().iterator().next());
        tsrReqs.addAll(ambassadorGroupKills.values().iterator().next());
        database.add(new Action("Completing the Shadow Reef (group)", tsrReqs, new HashMap<>(), ImmutableMap.builder().put("Crassian Leviathan group kills", 2)
            .put("Taraket the Necromancer group kills", 2).put("Ambassador group kills", 2).put("Boss kills", 6).build(), 2, true, true));

        Map<Integer, List<Requirement>> crassianSoloKills = combatKills(new Encounter("The Crassian Leviathan"), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> taraketSoloKills = combatKills(new Encounter("Taraket the Necromancer"), player, 28, "Magic", 0, false);
        Map<Integer, List<Requirement>> ambassadorSoloKills = combatKills(new Encounter("The Ambassador"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> tsrSoloReqs = new ArrayList<>();
        tsrSoloReqs.add(new Requirement("Curse of the Black Stone", 1));
        tsrSoloReqs.addAll(crassianSoloKills.values().iterator().next());
        tsrSoloReqs.addAll(taraketSoloKills.values().iterator().next());
        tsrSoloReqs.addAll(ambassadorSoloKills.values().iterator().next());
        database.add(new Action("Completing the Shadow Reef (solo)", tsrSoloReqs, new HashMap<>(), ImmutableMap.builder().put("Crassian Leviathan solo kills", 2)
            .put("Taraket the Necromancer solo kills", 2).put("Ambassador solo kills", 2).put("Boss kills", 6).build(), 2, true, true));

        //Reaper
        List<String> reaperBosses = getReaperAssignments(player);
        double reaperPointsPerHour = 0.0;
        double slayerFromReaper = 0.0;
        reaperPointsPerHour += (moleKills.keySet().iterator().next() / 5.5) * 8.0;
        slayerFromReaper += (moleKills.keySet().iterator().next() / 5.5) * 7000.0;
        reaperPointsPerHour += (kbdKills / 9.0) * 8.0;
        slayerFromReaper += (kbdKills / 9.0) * 7000.0;
        if (reaperBosses.contains("Barrows")) {
            reaperPointsPerHour += (barrowsKills.keySet().iterator().next() / 9.5) * 8.0;
            slayerFromReaper += (barrowsKills.keySet().iterator().next() / 9.5) * 7000.0;
            reaperPointsPerHour += chaosElementalKills * 4.0;
            slayerFromReaper += (chaosElementalKills / 3.0) * 10000.0;
            reaperPointsPerHour += (kqKills.keySet().iterator().next() / 7.0) * 12.0;
            slayerFromReaper += (kqKills.keySet().iterator().next() / 7.0) * 10000.0;
            reaperPointsPerHour += jadKills.keySet().iterator().next() * 8.0;
            slayerFromReaper += (jadKills.keySet().iterator().next() / 1.5) * 10000.0;
        }
        if (reaperBosses.contains("Dagannoth Kings")) {
            reaperPointsPerHour += (dagannothRexKills / 12.5) * 12.0;
            slayerFromReaper += dagannothRexKills * 800.0;
        }
        if (reaperBosses.contains("Corporeal Beast")) {
            reaperPointsPerHour += corporealBeastKills.keySet().iterator().next() * 2.0;
            slayerFromReaper += (corporealBeastKills.keySet().iterator().next() / 7.5) * 12000.0;
        }
        if (reaperBosses.contains("Queen Black Dragon")) {
            reaperPointsPerHour += (qbdKills / 7.5) * 12.0;
            slayerFromReaper += (qbdKills / 7.5) * 10000.0;
        }
        if (reaperBosses.contains("Commander Zilyana")) {
            reaperPointsPerHour += (zilyanaKills.keySet().iterator().next() / 12.5) * 15.0;
            slayerFromReaper += (zilyanaKills.keySet().iterator().next() / 12.5) * 12000.0;
        }
        if (reaperBosses.contains("K'ril Tsutsaroth")) {
            reaperPointsPerHour += (krilKills.keySet().iterator().next() / 12.5) * 15.0;
            slayerFromReaper += (kreeKills.keySet().iterator().next() / 12.5) * 12000.0;
        }
        if (reaperBosses.contains("Kree'arra")) {
            reaperPointsPerHour += (kreeKills.keySet().iterator().next() / 12.5) * 15.0;
            slayerFromReaper += (kreeKills.keySet().iterator().next() / 12.5) * 12000.0;
        }
        if (reaperBosses.contains("General Graardor")) {
            reaperPointsPerHour += (graardorKills.keySet().iterator().next() / 12.5) * 15.0;
            slayerFromReaper += (graardorKills.keySet().iterator().next() / 12.5) * 12000.0;
        }
        if (reaperBosses.contains("Har-Aken")) {
            reaperPointsPerHour += kilnClearsAndReqs.keySet().iterator().next() * 12.0;
            slayerFromReaper += kilnClearsAndReqs.keySet().iterator().next() * 10000.0;
        }
        if (reaperBosses.contains("Kalphite King")) {
            reaperPointsPerHour += (kkKills.keySet().iterator().next() / 12.5) * 18.0;
            slayerFromReaper += (kkKills.keySet().iterator().next() / 12.5) * 15000.0;
        }
        if (reaperBosses.contains("Legiones")) {
            reaperPointsPerHour += (legioKills.keySet().iterator().next() / 12.5) * 18.0;
            slayerFromReaper += (legioKills.keySet().iterator().next() / 12.5) * 15000.0;
        }
        if (reaperBosses.contains("Nex")) {
            reaperPointsPerHour += (nexKills.keySet().iterator().next() / 7.5) * 21.0;
            slayerFromReaper += (nexKills.keySet().iterator().next() / 7.5) * 17000.0;
        }
        if (reaperBosses.contains("Vindicta")) {
            reaperPointsPerHour += (vindictaKills.keySet().iterator().next() / 7.5) * 22.0;
            slayerFromReaper += (vindictaKills.keySet().iterator().next() / 7.5) * 17000.0;
        }
        if (reaperBosses.contains("Helwyr")) {
            reaperPointsPerHour += (helwyrKills.keySet().iterator().next() / 7.5) * 22.0;
            slayerFromReaper += (helwyrKills.keySet().iterator().next() / 7.5) * 17000.0;
        }
        if (reaperBosses.contains("Gregorovic")) {
            reaperPointsPerHour += (gregKills.keySet().iterator().next() / 7.5) * 22.0;
            slayerFromReaper += (gregKills.keySet().iterator().next() / 7.5) * 17000.0;
        }
        if (reaperBosses.contains("Twin Furies")) {
            reaperPointsPerHour += (twinFuriesKills.keySet().iterator().next() / 7.5) * 22.0;
            slayerFromReaper += (twinFuriesKills.keySet().iterator().next() / 7.5) * 17000.0;
        }
        if (reaperBosses.contains("Seiryu")) {
            reaperPointsPerHour += 12;
            slayerFromReaper += 12000;
        }
        if (reaperBosses.contains("Black Stone Dragon")) {
            reaperPointsPerHour += 12;
            slayerFromReaper += 12000;
        }
        if (reaperBosses.contains("Araxxi")) {
            reaperPointsPerHour += (raxKills.keySet().iterator().next() / 3.5) * 25.0;
            slayerFromReaper += (raxKills.keySet().iterator().next() / 3.5) * 20000.0;
            reaperPointsPerHour += (rotsKills.keySet().iterator().next() / 3.5) * 25.0;
            slayerFromReaper += (rotsKills.keySet().iterator().next() / 3.5) * 20000.0;
            reaperPointsPerHour += solakKills.keySet().iterator().next() * 11.0;
            slayerFromReaper += (solakKills.keySet().iterator().next() / 3.0) * 32000.0;
            reaperPointsPerHour += (voragoKills.keySet().iterator().next() / 3.5) * 25.0;
            slayerFromReaper += (voragoKills.keySet().iterator().next() / 3.5) * 20000.0;
        }
        if (reaperBosses.contains("The Magister")) {
            reaperPointsPerHour += (magisterKills.keySet().iterator().next() / 5.0) * 18.0;
            slayerFromReaper += magisterKills.keySet().iterator().next() * 3600.0;
        }
        if (reaperBosses.contains("Nex: Angel of Death")) {
            reaperPointsPerHour += (nexAODKills.keySet().iterator().next() / 4.5) * 31.0;
            slayerFromReaper += (nexAODKills.keySet().iterator().next() / 4.5) * 30000.0;
        }
        if (reaperBosses.contains("Telos")) {
            reaperPointsPerHour += (telosKills.keySet().iterator().next() / 3.0) * 28.0;
            slayerFromReaper += (telosKills.keySet().iterator().next() / 3.0) * 23000.0;
        }
        reaperPointsPerHour /= reaperBosses.size();
        slayerFromReaper /= reaperBosses.size();

        database.add(new Action("Soul Reaper", Collections.singletonList(new Requirement("Combat", 50)), new HashMap(),
            ImmutableMap.of("Reaper point", (int)(Math.floor(reaperPointsPerHour)), "Slayer", (int)(Math.floor(slayerFromReaper))), 2, true, true));

        database.add(new Action("Completing city quests", Collections.singletonList(new Requirement("The Jack of Spades", 1)), new HashMap(),
            ImmutableMap.of("City quest", 4, "Menaphos reputation", 9400), 4, true, true));

        database.add(new Action("Completing easy clue scrolls", new ArrayList(), ImmutableMap.of("Sealed clue scroll (easy)", 6), ImmutableMap.of("Clue scrolls", 6,
            "Treasure Trail reward points", 6), 6, true, true));
    }

    public List<Action> getDatabase() {
        return database;
    }

    private List<Requirement> getRequirementsForCombat(Encounter combatEncounter, Player player, int invenSpaces, String combatStyle) {
        Map<String, Double> initialXP = new HashMap<>(player.getXp());
        List<Weapon> initialWeapons = new ArrayList<>(player.getWeapons());
        List<Armour> initialArmours = new ArrayList<>(player.getArmour());
        CombatResults combatResults;
        while(true) {
            combatResults = combatEncounter.calculateCombat(player, new CombatParameters(invenSpaces, combatStyle, false, 0, false));
            if (combatResults.getHpLost() > 1000000 || combatResults.getKills() == 0) {
                Map<String, Double> nextGear = player.nextGear(combatStyle);
                if (nextGear == null) {
                    break;
                }
                player.addGearToPlayer(nextGear.keySet().iterator().next());
            }
            else {
                List<Requirement> requirements = new ArrayList<>();
                if (player.getXp().get("Defence") > initialXP.get("Defence")) {
                    requirements.add(new Requirement("Defence", player.getLevel("Defence")));
                }
                if (player.getXp().get("Constitution") > initialXP.get("Constitution")) {
                    requirements.add(new Requirement("Constitution", player.getLevel("Constitution")));
                }
                if (player.getXp().get("Prayer") > initialXP.get("Prayer")) {
                    requirements.add(new Requirement("Prayer", player.getLevel("Prayer")));
                }
                if (player.getXp().get("Attack") > initialXP.get("Attack")) {
                    requirements.add(new Requirement("Attack", player.getLevel("Attack")));
                }
                if (player.getXp().get("Strength") > initialXP.get("Strength")) {
                    requirements.add(new Requirement("Strength", player.getLevel("Strength")));
                }
                if (player.getXp().get("Ranged") > initialXP.get("Ranged")) {
                    requirements.add(new Requirement("Ranged", player.getLevel("Ranged")));
                }
                if (player.getXp().get("Magic") > initialXP.get("Magic")) {
                    requirements.add(new Requirement("Magic", player.getLevel("Magic")));
                }
                if (player.getXp().get("Summoning") > initialXP.get("Summoning")) {
                    requirements.add(new Requirement("Summoning", player.getLevel("Summoning")));
                }
                if (player.getXp().get("Herblore") > initialXP.get("Herblore")) {
                    requirements.add(new Requirement("Herblore", player.getLevel("Herblore")));
                }
                Loadout loadout = combatResults.getLoadoutUsed();
                if (!initialWeapons.contains(loadout.getMainWep())) {
                    requirements.add(new Requirement(loadout.getMainWep().getName(), 1));
                    requirements.addAll(loadout.getMainWep().getReqs());
                }
                if (!initialWeapons.contains(loadout.getOffWep()) && !loadout.getOffWep().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getOffWep().getName(), 1));
                    requirements.addAll(loadout.getOffWep().getReqs());
                }
                if (!initialArmours.contains(loadout.getHead()) && !loadout.getHead().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getHead().getName(), 1));
                    requirements.addAll(loadout.getHead().getReqs());
                }
                if (!initialArmours.contains(loadout.getTorso()) && !loadout.getTorso().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getTorso().getName(), 1));
                    requirements.addAll(loadout.getTorso().getReqs());
                }
                if (!initialArmours.contains(loadout.getLegs()) && !loadout.getLegs().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getLegs().getName(), 1));
                    requirements.addAll(loadout.getLegs().getReqs());
                }
                if (!initialArmours.contains(loadout.getHands()) && !loadout.getHands().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getHands().getName(), 1));
                    requirements.addAll(loadout.getHands().getReqs());
                }
                if (!initialArmours.contains(loadout.getFeet()) && !loadout.getFeet().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getFeet().getName(), 1));
                    requirements.addAll(loadout.getFeet().getReqs());
                }
                if (!initialArmours.contains(loadout.getRing()) && !loadout.getRing().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getRing().getName(), 1));
                    requirements.addAll(loadout.getRing().getReqs());
                }
                if (!initialArmours.contains(loadout.getCape()) && !loadout.getCape().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getCape().getName(), 1));
                    requirements.addAll(loadout.getCape().getReqs());
                }
                if (!initialArmours.contains(loadout.getNeck()) && !loadout.getNeck().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getNeck().getName(), 1));
                    requirements.addAll(loadout.getNeck().getReqs());
                }
                if (!initialArmours.contains(loadout.getShield()) && !loadout.getShield().getName().equals("None")) {
                    requirements.add(new Requirement(loadout.getShield().getName(), 1));
                    requirements.addAll(loadout.getShield().getReqs());
                }
                player.setXp(initialXP);
                player.setWeapons(initialWeapons);
                player.setArmour(initialArmours);
                return requirements;
            }
        }
        player.setXp(initialXP);
        player.setWeapons(initialWeapons);
        player.setArmour(initialArmours);
        return new ArrayList<>(); //fight is impossble if it reaches this point
    }

    private Map<Integer, List<Requirement>> combatKills(Encounter combatEncounter, Player player, int invenSpaces, String combatStyle, double dropRateOfItem, boolean stackable) {
        Map<String, Double> initialXP = new HashMap<>(player.getXp());
        List<Weapon> initialWeapons = new ArrayList<>(player.getWeapons());
        List<Armour> initialArmours = new ArrayList<>(player.getArmour());
        CombatParameters parameters = new CombatParameters(invenSpaces, combatStyle, true, dropRateOfItem, stackable);
        CombatResults combatResults = combatEncounter.calculateCombat(player, parameters);
        List<Requirement> combatReqs = new ArrayList<>();
        if (combatResults.getHpLost() == 1000000000 || combatResults.getKills() == 0) {
            combatReqs = getRequirementsForCombat(combatEncounter, player, invenSpaces, combatStyle);
            for (Requirement requirement : combatReqs) {
                if (Player.ALL_SKILLS.contains(requirement.getQualifier())) {
                    player.getXp().put(requirement.getQualifier(), player.getXp().get(requirement.getQualifier()) + player.getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
                }
                else if (WeaponDatabase.getWeaponDatabase().getWeapons().stream().map(Weapon::getName).collect(Collectors.toList()).contains(requirement.getQualifier())) {
                    player.getWeapons().add(Weapon.getWeaponByName(requirement.getQualifier()));
                }
                else if (ArmourDatabase.getArmourDatabase().getArmours().stream().map(Armour::getName).collect(Collectors.toList()).contains(requirement.getQualifier())) {
                    player.getArmour().add(Armour.getArmourByName(requirement.getQualifier()));
                }
            }
            combatResults = combatEncounter.calculateCombat(player, parameters);
            if (combatResults.getHpLost() == 1000000000) {
                player.setXp(initialXP);
                player.setWeapons(initialWeapons);
                player.setArmour(initialArmours);
                return ImmutableMap.of(0, Collections.singletonList(new Requirement("Impossible", 1)));
            }
        }
        player.setXp(initialXP);
        player.setWeapons(initialWeapons);
        player.setArmour(initialArmours);
        if (combatResults.getTicks() >= TICKS_PER_HOUR) {
            return ImmutableMap.of(combatResults.getKills(), combatReqs);
        }
        else {
            return ImmutableMap.of(combatResults.getKills()*TICKS_PER_HOUR/(combatResults.getTicks()+100), combatReqs);
        }

    }

    private List<String> getReaperAssignments(Player player) {
        List<String> bosses = new ArrayList<>();
        bosses.add("Giant Mole");
        bosses.add("King Black Dragon");
        double combatLevel = player.calcCombatLevel();
        if (combatLevel > 60) {
            bosses.add("Barrows");
            bosses.add("Chaos Elemental");
            bosses.add("Kalphite Queen");
            bosses.add("TzTok-Jad");
        }
        if (combatLevel > 70) {
            bosses.add("Dagannoth Kings");
            if (player.getQualities().containsKey("Summer's End")) {
                bosses.add("Corporeal Beast");
            }
        }
        if (combatLevel > 80) {
            if (player.getQualities().containsKey("Song from the Depths") && player.getLevel("Summoning") > 60) {
                bosses.add("Queen Black Dragon");
            }
            if (player.getQualities().containsKey("Troll Stronghold") && player.getLevel("Strength") > 60) {
                if (player.getLevel("Agility") > 70) {
                    bosses.add("Commander Zilyana");
                }
                if (player.getLevel("Strength") > 70) {
                    bosses.add("General Graardor");
                }
                if (player.getLevel("Ranged") > 70) {
                    bosses.add("Kree'arra");
                }
                if (player.getLevel("Constitution") > 70) {
                    bosses.add("K'ril Tsutsaroth");
                }
            }
        }
        if (combatLevel > 90 && player.getQualities().containsKey("The Elder Kiln") && player.getQualities().containsKey("TzTok-Jad")) {
            bosses.add("Har-Aken");
        }
        if (combatLevel > 100) {
            bosses.add("Kalphite King");
            if (player.getLevel("Slayer") > 95) {
                bosses.add("Legiones");
            }
        }
        if (combatLevel > 110) {
            if (player.getLevel("Agility") > 70 && player.getLevel("Constitution") > 70 && player.getLevel("Strength") > 70 && player.getLevel("Ranged") > 70
                && player.getQualities().containsKey("Troll Stronghold")) {
                bosses.add("Nex");
            }
            if (player.getLevel("Attack") > 80) {
                bosses.add("Vindicta");
            }
            if (player.getLevel("Magic") > 80) {
                bosses.add("Helwyr");
            }
            if (player.getLevel("Prayer") > 80) {
                bosses.add("Gregorovic");
            }
            if (player.getLevel("Ranged") > 80) {
                bosses.add("Twin Furies");
            }
        }
        if (combatLevel > 120) {
            bosses.add("Araxxi");
            bosses.add("Rise of the Six");
            bosses.add("Solak");
            bosses.add("Vorago");
            if (player.getQualities().containsKey("Impressing the Locals")) {
                bosses.add("Seiryu");
            }
            if (player.getQualities().containsKey("Seiryu")) {
                bosses.add("Black Stone Dragon");
            }
            if (player.getLevel("Agility") > 70 && player.getLevel("Constitution") > 70 && player.getLevel("Strength") > 70 && player.getLevel("Ranged") > 70
                && player.getQualities().containsKey("Troll Stronghold")) {
                bosses.add("Nex: Angel of Death");
            }
            if (player.getLevel("Slayer") > 115 && player.getQualities().containsKey("Icthlarin's Little Helper")) {
                bosses.add("The Magister");
            }
            if (player.getLevel("Attack") > 80 && player.getLevel("Magic") > 80 && player.getLevel("Prayer") > 80 && player.getLevel("Ranged") > 80) {
                bosses.add("Telos");
            }
        }
        return bosses;
    }

    private int fishCaught(Player player, int levelAtMaxRate) {
        return (int)Math.floor(1200*Math.pow(0.96, 1+Math.max(0, levelAtMaxRate-player.getLevel("Fishing"))));
    }

    private int miningDamage(Player player, int pickDamage) {
        return (player.getLevel("Mining") + player.getLevel("Strength")/10 + pickDamage)*1500;
    }

    private int miningXP(Player player, int pickDamage, double rockXPFactor) {
        return (int)Math.floor(0.4*miningDamage(player, pickDamage)*rockXPFactor);
    }

    @Deprecated
    private int resourcesGained(int levelAtMaxRate, double minTicks, Player player, double ticksToBank, String skill) {
        double time = TICKS_PER_HOUR;
        int playerLevel = player.getLevel(skill);
        double timePerResource = (minTicks + 0.2) * Math.pow(1.04, Math.max(0, levelAtMaxRate - playerLevel));
        int resources = 0;
        int inv = 0;
        while (true) {
            double timeForThisResource = timePerResource;
            if (inv == 28) {
                timeForThisResource += ticksToBank;
                inv = 0;
            }
            if (timePerResource < time) {
                resources += 1;
                time -= timeForThisResource;
                inv++;
            } else
                break;
        }
        return resources;
    }

    private int pocketsPicked(int effectiveLevel, Player player) {
        int playerLevel = player.getLevel("Thieving");
        double successRate = Math.min(1.0, (145.0 + (playerLevel - effectiveLevel)) / 255.0);
        double timePerSuccess = (2 * successRate + 8 * (1 - successRate)) / successRate;
        return (int) Math.floor(TICKS_PER_HOUR / timePerSuccess);
    }

    private int itemsReceived(Player player, int base, double factor, String skill, int levelMin) {
        return (int)Math.floor(base*Math.pow(factor, player.getLevel(skill)-levelMin));
    }

    private int totalPetPoints(Player player, String skill, int xp) {
        int petPoints = 0;
        int currentLevel = player.getLevel(skill);
        int usedXp = 0;
        while (usedXp < xp) {
            if (currentLevel == 120) {
                return petPoints + (xp-usedXp)*120;
            }
            int xpToNextLevel = player.getXpToLevel(skill, currentLevel+1);
            if (xpToNextLevel > xp) {
                petPoints += (xp - usedXp) * currentLevel;
                usedXp = xp;
            } else {
                petPoints += (xpToNextLevel - usedXp) * currentLevel;
                currentLevel++;
                usedXp = xpToNextLevel;
            }
        }
        return petPoints;
    }

    public static ActionDatabase getActionDatabase(Player player) {
        if (actionDatabase == null) {
            actionDatabase = new ActionDatabase();
            actionDatabase.addActionsToDatabase(player);
        }
        return actionDatabase;
    }

    public static void reset() {
        actionDatabase = null;
    }
}