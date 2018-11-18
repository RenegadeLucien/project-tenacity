package data.databases;

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
            new HashMap(), Map.of("Supplies", 60), 12, true, true));
        database.add(new Action("Collecting planks", new ArrayList(), new HashMap(), Map.of("Plank", 240), 240, true, true));
        database.add(new Action("Buying cleansing crystals", Collections.singletonList(new Requirement("Plague's End", 1)),
            Map.of("Coins", 39600000), Map.of("Cleansing crystal", 360), 360, true, true));

        //Player-owned-ports
        database.add(new Action("POP - Arc region voyages", Collections.singletonList(new Requirement("Ports unlocked", 1)), new HashMap(),
            Map.of("Port distance", 5000, "Port chimes", 1600, "Port bamboo", 1600), 20, true, true));
        database.add(new Action("POP - Skull region voyages", Collections.singletonList(new Requirement("Port distance", 5000)), new HashMap(),
            Map.of("Port distance", 12000, "Port chimes", 6000, "Port gunpowder", 3000), 20, true, true));
        database.add(new Action("POP - Hook region voyages", Collections.singletonList(new Requirement("Port distance", 40000)), new HashMap(),
            Map.of("Port distance", 24000, "Port chimes", 10000, "Port slate", 3000), 20, true, true));
        database.add(new Action("POP - Scythe region voyages", Collections.singletonList(new Requirement("Port distance", 140000)), new HashMap(),
            Map.of("Port distance", 48000, "Port chimes", 13000, "Port cherrywood", 4000), 20, true, true));
        database.add(new Action("POP - Bowl region voyages", Collections.singletonList(new Requirement("Port distance", 450000)), new HashMap(),
            Map.of("Port distance", 96000, "Port chimes", 20000, "Port jade", 7200), 20, true, true));

        //Gathering (low or no XP)
        database.add(new Action("Picking potatoes", new ArrayList<>(), new HashMap<>(), Map.of("Raw potato", 690), 690, true, true));
        database.add(new Action("Voyaging for items", Collections.singletonList(new Requirement("Impressing the Locals", 1)),
            Map.of("Supplies", 300), Map.ofEntries(Map.entry("Taijitu", 26), Map.entry("Sea shell", 9), Map.entry("Driftwood", 9), Map.entry("Sea salt", 9),
            Map.entry("Bamboo", 9), Map.entry("Shell chippings", 9), Map.entry("Spirit dragon charm", 9), Map.entry("Raw tarpon", 9), Map.entry("Bundle of bamboo", 9),
            Map.entry("Fish oil", 9), Map.entry("Stoneberry seed", 1), Map.entry("Stormberry seed", 1)), 60, true, true));
        database.add(new Action("Winning Castle Wars games", new ArrayList(), new HashMap(), Map.of("Gold Castle Wars ticket", 6), 3, true,
            true));
        database.add(new Action("Opening prawn balls", new ArrayList(), Map.of("Prawn balls", 3000), Map.of("Golden fish egg", 15), 3000, true, true));
        database.add(new Action("Picking bananas", new ArrayList(), Map.of("Basket", 552), Map.of("Bananas (5)", 552, "Banana", 120), 552, true, true));
        database.add(new Action("Casting egg spawn", Collections.singletonList(new Requirement("Summoning", 10)), Map.of("Egg spawn scroll", 520, "Spirit spider pouch", 4,
            "Summoning potion (4)", 18), Map.of("Red spiders' eggs", 936, "Summoning", 105), 520, true, true));

        //Agility (WHEN ADDING TO THIS, UPDATE PET)
        database.add(new Action("Burthorpe Agility Course", new ArrayList<>(), new HashMap<>(), Map.of("Agility", 11955), 150, true, true));
        database.add(new Action("Gnome Stronghold Agility Course", new ArrayList<>(), new HashMap<>(), Map.of("Agility", 8650), 100, true, true));
        database.add(new Action("Agility Pyramid", Collections.singletonList(new Requirement("Agility", 30)), Map.of("Waterskin (4)", 10),
            Map.of("Waterskin (0)", 10, "Agility", 26708, "Pyramid top", 22), 22, true, true));
        database.add(new Action("Empty Throne Room agility", Arrays.asList(new Requirement("Agility", 65), new Requirement("The Dig Site", 1)),
            new HashMap(), Map.of("Agility", 68760), 1800, true, true));
        database.add(new Action("Hefin Agility Course (77-81 Agility)", Arrays.asList(new Requirement("Plague's End", 1),
            new Requirement("Agility", 77)), new HashMap(), Map.of("Agility", 56320, "Hefin Agility Course laps", 80), 80, true, true));
        database.add(new Action("Advanced Gnome Stronghold Agility Course", Collections.singletonList(new Requirement("Agility", 85)),
            new HashMap(), Map.of("Agility", 68150, "Advanced Gnome Stronghold laps", 94), 34, true, true));
        database.add(new Action("Advanced Barbarian Outpost Agility Course", Arrays.asList(new Requirement("Bar Crawl", 1),
            new Requirement("Agility", 90)), new HashMap(), Map.of("Agility", 72355, "Advanced Barbarian Outpost laps", 96), 96, true, true));


        //Construction
        database.add(new Action("Building crude wooden chairs with bronze nails", new ArrayList(), Map.of("Plank", 490, "Bronze nails", 1470),
            Map.of("Construction", 16170), 490, true, true));

        //Cooking (done to lv5)
        database.add(new Action("Cooking raw beef", new ArrayList<>(),
            Map.of("Raw beef", 1300), Map.of("Cooked meat", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
            "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking shrimps", new ArrayList<>(), Map.of("Raw shrimps", 1300),
            Map.of("Shrimps", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking crayfish", new ArrayList<>(), Map.of("Raw crayfish", 1300),
            Map.of("Crayfish", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking chicken", new ArrayList<>(), Map.of("Raw chicken", 1300),
            Map.of("Cooked chicken", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking sardines", new ArrayList<>(), Map.of("Raw sardine", 1300),
            Map.of("Sardine", (int) Math.floor(1300 * Math.min(1, 1 - (38 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(52000 * Math.min(1, 1 - (38 - player.getLevel("Cooking")) / 100.0))),
            (int) Math.floor(1300 * Math.min(1, 1 - (38 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Cooking anchovies", new ArrayList<>(), Map.of("Raw anchovies", 1300),
            Map.of("Anchovies", (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(39000 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))),
            (int) Math.floor(1300 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)), true, true));

        database.add(new Action("Making uncooked arc gumbo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 94)),
            Map.of("Bundle of bamboo", 1300, "Tortle shell bowl", 1300, "Rumberry", 1300, "Fish oil", 1300, "Sea salt", 1300), Map.of("Uncooked arc gumbo", 1300,
            "Cooking", 13000), 1300, true, true));

        database.add(new Action("Cooking arc gumbo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 94)),
            Map.of("Uncooked arc gumbo", 1300), Map.of("Arc gumbo", 1300, "Cooking", 169000, "Azure Parrot", 21), 1300, true, true));

        //Crafting (done to lv3)
        database.add(new Action("Crafting molten glass", new ArrayList<>(), Map.of("Soda ash", 1250, "Bucket of sand", 1250), Map.of("Molten glass", 1250, "Crafting", 25000), 1250, true, true));
        database.add(new Action("Spinning flax", new ArrayList(), Map.of("Flax", 1400), Map.of("Bowstring", 1400, "Crafting", 21000), 1400, true, true));
        database.add(new Action("Making cracked mining urns (nr)", new ArrayList(), Map.of("Soft clay", 1120), Map.of("Cracked mining urn (nr)", 560, "Crafting", 16016), 560, true, true));
        database.add(new Action("Making cracked cooking urns (nr)", Collections.singletonList(new Requirement("Crafting", 2)), Map.of("Soft clay", 1120),
            Map.of("Cracked cooking urn (nr)", 560, "Crafting", 16800), 560, true, true));

        database.add(new Action("Ithell harps (w/o VoS)", Collections.singletonList(new Requirement("Plague's End", 1)), new HashMap(),
            Map.of("Crafting", 560*player.getLevel("Crafting"), "Harmonic dust", 7*player.getLevel("Crafting"), "Construction", 10000), 7*player.getLevel("Crafting"), true, true));

        database.add(new Action("Making tortle shell bowls", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Crafting", 91)),
            Map.of("Shell chippings", 6800), Map.of("Tortle shell bowl", 1700, "Crafting", 127500), 1700, true, true));

        //Divination (1300 harvests, 900 + enr conversions) (done to lv9)
        database.add(new Action("Pale wisps (no bought energy)", new ArrayList<>(), new HashMap<>(),
            Map.of("Divination", 4000, "Pale energy", 1300), 1300, true, true));

        database.add(new Action("Pale wisps (with bought energy)", new ArrayList<>(), Map.of("Pale energy", 3200),
            Map.of("Divination", 4630), 1300, true, true));

        database.add(new Action("Cursed wisps (level 1-9)", new ArrayList(), new HashMap<>(), Map.of("Divination", 6850, "Pale energy", 1950), 1300, true, false));

        database.add(new Action("Luminous wisps (no bought energy)", Collections.singletonList(new Requirement("Divination", 90)),
            new HashMap(), Map.of("Divination", 71000, "Luminous energy", 1600, "Fly dragon", 1, "Fruit fly", 1), 1300, true, true));
        database.add(new Action("Positive springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 90)), new HashMap(), Map.of("Divination", 60300, "Positive energy", 600), 600, true, true));
        database.add(new Action("Ancestral springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 95)), new HashMap(), Map.of("Divination", 96300, "Ancestral energy", 600, "Cyansoul Kakapo", 1), 600, true, true));

        //Dungeoneering (major approximation, assumes 7.5 minute floors)
        int dungXP = (int) Math.floor(4000 * Math.pow((player.getLevel("Dungeoneering") + 9.0) / 10.0, 2));
        database.add(new Action("Solo dungeoneering", new ArrayList(), new HashMap(), Map.of("Dungeoneering", dungXP, "Dungeoneering token",
            dungXP/10, "Dungeoneering floors completed", 8), 8, true, true));

        //Farming
        database.add(new Action("Farming potatoes (w/o payments)", new ArrayList(), Map.of("Potato seed", 162, "Supercompost", 54), Map.of("Raw potato", 464, "Farming", 5758), 6, true, true));
        database.add(new Action("Farming potatoes (w/ payments)", new ArrayList(), Map.of("Potato seed", 162, "Supercompost", 54, "Compost", 60), Map.of("Raw potato", 540, "Farming", 6696), 6, true, true));

        database.add(new Action("Foraging rumberries (keep)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Rumberry", 300, "Rumberry seed", 6, "Pumpkin Limpkin", 1),
            300, true, true));

        database.add(new Action("Foraging rumberries (sell)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Chimes", 618), 300, true, true));

        database.add(new Action("Foraging exuberries (keep)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Exuberry", 300, "Exuberry seed", 6),
            300, true, true));

        database.add(new Action("Foraging mushrooms on named islands", Arrays.asList(new Requirement("Farming", 90),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Named mushrooms", 10), 300, true, true));

        database.add(new Action("Foraging mushrooms on Uncharted Isles", Arrays.asList(new Requirement("Farming", 94),
            new Requirement("Impressing the Locals", 1)), Map.of("Supplies", 60), Map.of("Farming", 50000, "Uncharted mushrooms", 7), 1200, true, true));

        //Firemaking
        database.add(new Action("Burning normal logs on bonfire", new ArrayList(), Map.of("Logs", 950), Map.of("Firemaking", 47500), 950, true, true));
        database.add(new Action("Burning normal logs in lines", new ArrayList(), Map.of("Logs", 1200), Map.of("Firemaking", 48000), 1200, true, true));
        database.add(new Action("Burning acadia logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 46)), Map.of("Acadia logs", 950),
            Map.of("Firemaking", 171000, "Menaphite honey bee", 1, "Fruit fly in amber", 1), 950, true, true));

        //Fishinng
        database.add(new Action("Fishing raw crayfish", new ArrayList<>(), new HashMap<>(), Map.of("Fishing", 10 * fishCaught(player, 1), "Prawn balls", fishCaught(player, 1)/175),
            fishCaught(player, 1), true, true));

        database.add(new Action("Fishing/dropping desert sole", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Fishing", 52)),
            new HashMap(), Map.of("Fishing", 60 * resourcesGained(70, 5.0, player, 0.0, "Fishing"), "Menaphos reputation",
            3 * resourcesGained(70, 5.0, player, 0.0, "Fishing"), "Prawn balls", 1450*resourcesGained(70, 5.0, player, 0.0, "Fishing")/35000,
            "Clicker kalphite in amber", 1, "Desert locust in amber", 1), resourcesGained(70, 5.0, player, 0.0, "Fishing"), true, true));

        //Fletching
        database.add(new Action("Fletching arrow shafts with normal logs", new ArrayList(), Map.of("Logs", 1800), Map.of("Arrow shaft", 27000,
            "Fletching", 9000), 1800, true, true));

        //Herblore
        database.add(new Action("Cleaning grimy guams", new ArrayList(), Map.of("Grimy guam", 5090), Map.of("Clean guam", 5090,
            "Herblore", 12725), 5090, true, true));

        //Hunter (done to lv20)
        database.add(new Action("Feeding ogleroots to rabbits", new ArrayList(), Map.of("Coins", 3000), Map.of("Hunter", 9000), 300, true, true));
        database.add(new Action("Catching charm sprites", Collections.singletonList(new Requirement("Hunter", 72)), new HashMap(),
            Map.of("Hunter", 60000, "Crimson charm", 40, "Blue charm", 28, "Green charm", 17, "Gold charm", 6, "Charm sprites", 435), 435, true, true));
        database.add(new Action("Catching plover birds", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Hunter", 73)),
            Map.of("Logs", 200), Map.of("Plover bird", 68+player.getLevel("Hunter"), "Hunter", 510*(68+player.getLevel("Hunter")),
            "Menaphos reputaton", 30*(68+player.getLevel("Hunter")), "Pygmy giant scarab", 1, "Clicker kalphite", 1), 68+player.getLevel("Hunter"), true, true));
        database.add(new Action("Hunting tortles", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Hunter", 90)),
            new HashMap(), Map.of("Hunter", 258000, "Tortoiseshell Plover", 2, "Shell chippings", 400), 400, true, true));

        //Invention (temporary placeholder action, to be revamped)
        database.add(new Action("Disassembling bones", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), Map.of("Bones", 2800), Map.of("Invention", 280), 2800, true, true));

        //Combat (the combat encounters expected to be used for combat training)
        Map<Integer, List<Requirement>> trollBruteKills = combatKills(new Encounter("Troll brute"), player, 0, "Magic", 0, false);
        database.add(new Action("Killing troll brutes", trollBruteKills.values().iterator().next(), new HashMap(), Map.of("aCombat", (int)Enemy.getEnemyByName("Troll brute").getCbxp()
                * trollBruteKills.keySet().iterator().next(), "Constitution", (int) Enemy.getEnemyByName("Troll brute").getHpxp() * trollBruteKills.keySet().iterator().next()),
            trollBruteKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> trollChuckerKillsAndReqs = combatKills(new Encounter("Troll chucker"), player, 0, "Melee", 0, false);
        int trollChuckerKills = trollChuckerKillsAndReqs.keySet().iterator().next();
        List<Requirement> trollChuckerReqs = trollChuckerKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing troll chuckers", trollChuckerReqs, new HashMap(), Map.of("mCombat", (int)Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills,
            "Constitution", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getHpxp() * trollChuckerKills)), trollChuckerKills, true, true));

        Map<Integer, List<Requirement>> trollShamanKillsAndReqs = combatKills(new Encounter("Troll shaman"), player, 0, "Ranged", 0, false);
        int trollShamanKills = trollShamanKillsAndReqs.keySet().iterator().next();
        List<Requirement> trollShamanReqs = trollShamanKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing troll shamans", trollShamanReqs, new HashMap(), Map.of("rCombat", (int)Enemy.getEnemyByName("Troll shaman").getCbxp() * trollShamanKills,
            "Constitution", (int) Enemy.getEnemyByName("Troll shaman").getHpxp() * trollShamanKills), trollShamanKills, true, true));


        //Mining (WHEN ADDING TO THIS, UPDATE PET)
        database.add(new Action("Mining and dropping essence", new ArrayList<>(), new HashMap<>(), Map.of("Mining", 26250), 5250, true, true));
        database.add(new Action("Mining pure essence", Collections.singletonList(new Requirement("Mining", 30)), new HashMap(), Map.of("Mining", 10220, "Pure essence", 2044), 2044, true, true));

        database.add(new Action("Mining coal with bronze pickaxe", Collections.singletonList(new Requirement("Mining", 30)), new HashMap(),
            Map.of("Coal", resourcesGained(70, 6.0, player, 30.0, "Mining"), "Mining", 50*resourcesGained(70, 6.0, player, 30.0, "Mining")),
            resourcesGained(70, 6.0, player, 30.0, "Mining"), true, true));
        database.add(new Action("Mining/dropping concentrated sandstone with bronze pickaxe", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Mining", 50)), new HashMap(), Map.of("Mining", resourcesGained(100, 6.0, player, 0.0, "Mining"),
            "Menaphos reputation", (int)(2.7*resourcesGained(100, 6.0, player, 0.0, "Mining")), "Menaphite honey bee in amber", 1,
            "Pygmy giant scarab in amber", 1), resourcesGained(100, 6.0, player, 0.0, "Mining"), true, true));

        database.add(new Action("Mining salty crablets", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Mining", 91)),
            new HashMap(), Map.of("Sea salt", 3*(Math.max(91, player.getLevel("Mining"))-60), "Mining", (int)507.5*(3*(Math.max(91, player.getLevel("Mining")) - 60)), "Awah Guan", 1),
            3*(Math.max(91, player.getLevel("Mining"))-60), true, true));

        //Prayer
        database.add(new Action("Offering impious ashes to Chaos Altar", new ArrayList<>(), Map.of("Impious ashes", 1400), Map.of("Prayer", 19600), 1400, true, false));
        database.add(new Action("Offering bones to Chaos Altar", new ArrayList<>(), Map.of("Bones", 1400), Map.of("Prayer", 22050), 1400, true, false));
        database.add(new Action("Offering accursed ashes to Chaos Altar", new ArrayList<>(), Map.of("Accursed ashes", 1400), Map.of("Prayer", 61250), 1400, true, false));
        database.add(new Action("Offering big bones to Chaos Altar", new ArrayList<>(), Map.of("Big bones", 1400), Map.of("Prayer", 73500), 1400, true, false));
        database.add(new Action("Offering baby dragon bones to Chaos Altar", new ArrayList<>(), Map.of("Baby dragon bones", 1400), Map.of("Prayer", 147000), 1400, true, false));
        database.add(new Action("Offering wyvern bones to Chaos Altar", new ArrayList<>(), Map.of("Wyvern bones", 1400), Map.of("Prayer", 245000), 1400, true, false));
        database.add(new Action("Offering infernal ashes to Chaos Altar", new ArrayList<>(), Map.of("Infernal ashes", 1400), Map.of("Prayer", 306250), 1400, true, false));
        database.add(new Action("Offering dragon bones to Chaos Altar", new ArrayList<>(), Map.of("Dragon bones", 1400), Map.of("Prayer", 352800), 1400, true, false));
        database.add(new Action("Offering dagannoth bones to Chaos Altar", new ArrayList(), Map.of("Dagannoth bones", 1400), Map.of("Prayer", 612500), 1400, true, false));
        database.add(new Action("Offering airut bones to Chaos Altar", new ArrayList(), Map.of("Airut bones", 1400), Map.of("Prayer", 649250), 1400, true, false));
        database.add(new Action("Offering ourg bones to Chaos Altar", new ArrayList(), Map.of("Ourg bones", 1400), Map.of("Prayer", 686000), 1400, true, false));
        database.add(new Action("Offering hardened dragon bones to Chaos Altar", new ArrayList(), Map.of("Hardened dragon bones", 1400), Map.of("Prayer", 705600), 1400, true, false));
        database.add(new Action("Offering frost dragon bones to Chaos Altar", new ArrayList(), Map.of("Frost dragon bones", 1400), Map.of("Prayer", 882000), 1400, true, false));
        database.add(new Action("Offering reinforced dragon bones to Chaos Altar", new ArrayList(), Map.of("Reinforced dragon bones", 1400), Map.of("Prayer", 931000), 1400, true, false));
        database.add(new Action("Offering searing ashes to Chaos Altar", new ArrayList(), Map.of("Searing ashes", 1400), Map.of("Prayer", 980000), 1400, true, false));

        //Runecrafting (done to lv9)
        database.add(new Action("Low-level Runespan (island 1)", new ArrayList(), new HashMap(), Map.of("Runecrafting", 16500), 1500, true, true));

        //Slayer
        database.add(new Action("Slayer tasks from Turael", new ArrayList(), new HashMap(), Map.of("Slayer", SlayerMaster.TURAEL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue()),
            6000, true, true));

        database.add(new Action("Slayer tasks from Mazchna", Collections.singletonList(new Requirement("Combat", 20)), new HashMap(),
            Map.of("Slayer", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
            "Slayer point", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue()), 6000, true, true));

        //Smithing
        database.add(new Action("Smithing bronze bars", new ArrayList(), Map.of("Copper ore", 1050, "Tin ore", 1050), Map.of("Bronze bar", 1050, "Smithing", 6510), 1050, true, true));
        database.add(new Action("Smithing bronze nails", Collections.singletonList(new Requirement("Smithing", 4)), Map.of("Bronze bar", 1232), Map.of("Smithing", 15400, "Bronze nails", 18480), 1232, true, true));

        //Summoning
        database.add(new Action("Making spirit wolf pouches", new ArrayList(), Map.of("Spirit shards", 10500, "Pouch", 1500,
            "Wolf bones", 1500, "Gold charm", 1500), Map.of("Spirit wolf pouch", 1500, "Summoning", 7200), 1500, true, true));
        database.add(new Action("Making dreadfowl pouches", Collections.singletonList(new Requirement("Summoning", 4)), Map.of("Spirit shards", 12000,
            "Pouch", 1500, "Raw chicken", 1500, "Gold charm", 1500), Map.of("Dreadfowl pouch", 1500, "Summoning", 13950), 1500, true, true));
        database.add(new Action("Making spirit spider pouches", Collections.singletonList(new Requirement("Summoning", 10)), Map.of("Spirit shards", 12000,
            "Pouch", 1500, "Spider carcass", 1500, "Gold charm", 1500), Map.of("Spirit spider pouch", 1500, "Summoning", 18900), 1500, true, true));
        database.add(new Action("Making thorny snail pouches", Collections.singletonList(new Requirement("Summoning", 13)), Map.of("Spirit shards", 13500,
            "Pouch", 1500, "Thin snail", 1500, "Gold charm", 1500), Map.of("Thorny snail pouch", 1500, "Summoning", 18900), 1500, true, true));
        database.add(new Action("Making granite crab pouches", Collections.singletonList(new Requirement("Summoning", 16)), Map.of("Spirit shards", 10500,
            "Pouch", 1500, "Iron ore", 1500, "Gold charm", 1500), Map.of("Granite crab pouch", 1500, "Summoning", 32400), 1500, true, true));

        //Thieving
        database.add(new Action("Pickpocketing men/women", new ArrayList(), new HashMap(), Map.of("Coins", 3 * pocketsPicked(1, player),
            "Thieving", 8 * pocketsPicked(1, player)), pocketsPicked(1, player), true, true));
        database.add(new Action("Bakery stalls", Collections.singletonList(new Requirement("Thieving", 5)), new HashMap(), Map.of("Thieving", 10500), 656, true, true));
        database.add(new Action("Menaphos silk stall (drop silk)", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Thieving", 20)),
            new HashMap(), Map.of("Thieving", 9600, "Menaphos reputation", 2400, "Fly dragon in amber", 1), 400, true, true));
        database.add(new Action("Pickpocketing Menaphite marketeers", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Thieving", 46)), new HashMap(), Map.of("Thieving", (int)(29.5 * pocketsPicked(46, player)), "Menaphos reputation",
            (int)(1.3 * pocketsPicked(46, player)), "Coins", 30*pocketsPicked(46, player), "Kalphite wanderer in amber", 1, "Hornless unicornfly in amber", 1), pocketsPicked(46, player), true, true));
        database.add(new Action("Iorwerth workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 91)), new HashMap(),
            Map.of("Thieving", 250000, "Master clue scroll points", 1), 2000, true, true));

        //Woodcutting
        database.add(new Action("Cutting regular trees with dwarven army axe", new ArrayList(), new HashMap(), Map.of("Woodcutting", logsCut(player, 2, 110)*28), logsCut(player, 2, 110), true, true));

        //CHOP RATE CALIBRATION: ~40% at 47, ~67% at 99 (unknown hatchet bonus, rune is assumed)
        database.add(new Action("Cutting/dropping acadia logs with bronze hatchet in VIP skilling area", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Menaphos reputation", 141900), new Requirement("Woodcutting", 47)), new HashMap(), Map.of("Woodcutting", 92*logsCut(player, 0, 230),
            "Menaphos reputation", (int)4.5*logsCut(player, 0, 230), "Desert locust", 1, "Hornless unicornfly", 1, "Kalphite wanderer", 1), logsCut(player, 0, 230), true, true));

        database.add(new Action("Cutting bamboo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Woodcutting", 90)),
            new HashMap(), Map.of("Bamboo", 3*player.getLevel("Woodcutting") + 60, "Woodcutting", (int)202.5*(3*player.getLevel("Woodcutting") + 60), "Great Pecker", 1),
            3*player.getLevel("Woodcutting") + 60, true, true));

        //Multi-skill
        database.add(new Action("Cremating vyre corpses", Arrays.asList(new Requirement("Legacy of Seergaze", 1),
            new Requirement("Firemaking", 40)), Map.of("Vyre corpse", 500, "Teak pyre logs", 500), Map.of("Firemaking", 60000,
            "Prayer", 39350, "Vyre corpses burned", 500, "Columbarium key", 500), 500, true, true));
        database.add(new Action("Cremating loar shades", Arrays.asList(new Requirement("Shades of Mort'ton", 1),
            new Requirement("Firemaking", 40)), Map.of("Loar remains", 500, "Pyre logs", 500), Map.of("Firemaking", 25000,
            "Prayer", 12500, "Coins", 100000, "Shade key", 250), 500, true, true));

        //Combat
        Map<Integer, List<Requirement>> gelatinousAbominationKills = combatKills(new Encounter("Gelatinous abomination"), player, 0, "Ranged", 0.4, true);
        database.add(new Action("Killing gelatinous abominations for gold charms with ranged", gelatinousAbominationKills.values().iterator().next(), new HashMap(), Map.of("Gold charm",
            (int) (gelatinousAbominationKills.keySet().iterator().next() * 0.4), "rCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() *
                gelatinousAbominationKills.keySet().iterator().next(), "Constitution", (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() *
                gelatinousAbominationKills.keySet().iterator().next()), gelatinousAbominationKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> giantRockCrabKillsAndReqs = combatKills(new Encounter("Giant rock crab"), player, 0, "Magic", 0.79, true);
        int giantRockCrabKills = giantRockCrabKillsAndReqs.keySet().iterator().next();
        List<Requirement> giantRockCrabReqs = giantRockCrabKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing giant rock crabs for gold charms with magic", giantRockCrabReqs, new HashMap(), Map.of("Gold charm", (int) (giantRockCrabKills * 2.37),
            "aCombat", (int) Enemy.getEnemyByName("Giant rock crab").getCbxp() * giantRockCrabKills, "Constitution",
            (int) Enemy.getEnemyByName("Giant rock crab").getHpxp() * giantRockCrabKills), giantRockCrabKills, true, true));

        Map<Integer, List<Requirement>> vyreKillsAndReqs = combatKills(new Encounter("Vyrewatch"), player, 0, "Melee", 1, false);
        int vyreKills = vyreKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> vyreReqs = new ArrayList<>(vyreKillsAndReqs.values().iterator().next());
        vyreReqs.add(new Requirement("Legacy of Seergaze", 1));
        database.add(new Action("Killing vyres for corpses", vyreReqs, new HashMap(),
            Map.of("Vyre corpse", vyreKills, "mCombat", (int)Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills, "Constitution",
                (int) Enemy.getEnemyByName("Vyrewatch").getHpxp() * vyreKills), vyreKills, true, true));

        Map<Integer, List<Requirement>> truthfulShadowKillsAndReqs = combatKills(new Encounter("Truthful shadow"), player, 0, "Magic", 0.2, false);
        int truthfulShadowKills = truthfulShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> truthfulShadowReqs = new ArrayList<>(truthfulShadowKillsAndReqs.values().iterator().next());
        truthfulShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing truthful shadows for cores", truthfulShadowReqs, new HashMap(),
            Map.of("Truthful shadow core", truthfulShadowKills/5, "aCombat", (int)Enemy.getEnemyByName("Truthful shadow").getCbxp() * truthfulShadowKills, "Constitution",
                (int) Enemy.getEnemyByName("Truthful shadow").getHpxp() * truthfulShadowKills), truthfulShadowKills, true, true));

        Map<Integer, List<Requirement>> blissfulShadowKillsAndReqs = combatKills(new Encounter("Blissful shadow"), player, 0, "Magic", 0.2, false);
        int blissfulShadowKills = blissfulShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> blissfulShadowReqs = new ArrayList<>(blissfulShadowKillsAndReqs.values().iterator().next());
        blissfulShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing blissful shadows for cores", blissfulShadowReqs, new HashMap(),
            Map.of("Blissful shadow core", blissfulShadowKills/5, "aCombat", (int)Enemy.getEnemyByName("Blissful shadow").getCbxp() * blissfulShadowKills, "Constitution",
                (int) Enemy.getEnemyByName("Blissful shadow").getHpxp() * blissfulShadowKills), blissfulShadowKills, true, true));

        Map<Integer, List<Requirement>> manifestShadowKillsAndReqs = combatKills(new Encounter("Manifest shadow"), player, 0, "Magic", 0.2, false);
        int manifestShadowKills = manifestShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> manifestShadowReqs = new ArrayList<>(manifestShadowKillsAndReqs.values().iterator().next());
        manifestShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing manifest shadows for cores", manifestShadowReqs, new HashMap(),
            Map.of("Manifest shadow core", manifestShadowKills/5, "aCombat", (int)Enemy.getEnemyByName("Manifest shadow").getCbxp() * manifestShadowKills, "Constitution",
                (int) Enemy.getEnemyByName("Manifest shadow").getHpxp() * manifestShadowKills), manifestShadowKills, true, true));

        Map<Integer, List<Requirement>> crystalShapeshifterKillsAndReqs = combatKills(new Encounter("Crystal shapeshifter"), player, 0, "Melee", 1, false);
        int crystalShapeshifterKills = crystalShapeshifterKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> crystalShapeshifterReqs = new ArrayList<>(crystalShapeshifterKillsAndReqs.values().iterator().next());
        crystalShapeshifterReqs.add(new Requirement("The Light Within", 1));
        database.add(new Action("Killing crystal shapeshifters", crystalShapeshifterReqs, new HashMap(),
            Map.of("Crystal shapeshifter", crystalShapeshifterKills, "mCombat", (int)Enemy.getEnemyByName("Crystal shapeshifter").getCbxp() * crystalShapeshifterKills,
                "Constitution", (int) Enemy.getEnemyByName("Crystal shapeshifter").getHpxp() * crystalShapeshifterKills), crystalShapeshifterKills, true, true));

        Map<Integer, List<Requirement>> airutKillsAndReqs = combatKills(new Encounter("Airut"), player, 0, "Melee", 0, false);
        int airutKills = airutKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> airutReqs = new ArrayList<>(airutKillsAndReqs.values().iterator().next());
        airutReqs.add(new Requirement("Slayer", 92));
        database.add(new Action("Killing airut", airutReqs, new HashMap(), Map.of("Airut", airutKills, "mCombat", (int)Enemy.getEnemyByName("Airut").getCbxp() * airutKills,
                "Constitution", (int) Enemy.getEnemyByName("Airut").getHpxp() * airutKills), airutKills, true, true));

        Map<Integer, List<Requirement>> camelWarriorKillsAndReqs = combatKills(new Encounter("Camel warrior"), player, 0, "Melee", 0, false);
        int camelWarriorKills = camelWarriorKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> camelWarriorReqs = new ArrayList<>(camelWarriorKillsAndReqs.values().iterator().next());
        camelWarriorReqs.add(new Requirement("Slayer", 96));
        database.add(new Action("Killing camel warriors", camelWarriorReqs, new HashMap(),
            Map.of("Camel warrior", camelWarriorKills, "mCombat", (int)Enemy.getEnemyByName("Camel warrior").getCbxp() * camelWarriorKills,
                "Constitution", (int) Enemy.getEnemyByName("Camel warrior").getHpxp() * camelWarriorKills), camelWarriorKills, true, true));

        Map<Integer, List<Requirement>> impKillsAndReqs = combatKills(new Encounter("Imp"), player, 0, "Magic", 0, false);
        int impKills = impKillsAndReqs.keySet().iterator().next();
        List<Requirement> impReqs = impKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing imps", impReqs, new HashMap(), Map.of("Imp", impKills, "aCombat", (int)Enemy.getEnemyByName("Imp").getCbxp() * impKills,
            "Constitution", (int) Enemy.getEnemyByName("Imp").getHpxp() * impKills), impKills, true, true));

        Map<Integer, List<Requirement>> goblinKillsAndReqs = combatKills(new Encounter("Goblin"), player, 0, "Magic", 0, false);
        int goblinKills = goblinKillsAndReqs.keySet().iterator().next();
        List<Requirement> goblinReqs = goblinKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing goblins", goblinReqs, new HashMap(), Map.of("Goblin", goblinKills, "aCombat", (int)Enemy.getEnemyByName("Goblin").getCbxp() * goblinKills,
            "Constitution", (int) Enemy.getEnemyByName("Goblin").getHpxp() * goblinKills), goblinKills, true, true));

        Map<Integer, List<Requirement>> skeletonKillsAndReqs = combatKills(new Encounter("Skeleton"), player, 0, "Magic", 0, false);
        int skeletonKills = skeletonKillsAndReqs.keySet().iterator().next();
        List<Requirement> skeletonReqs = skeletonKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing skeletons", skeletonReqs, new HashMap(), Map.of("Skeleton", skeletonKills, "aCombat", (int)Enemy.getEnemyByName("Skeleton").getCbxp() * skeletonKills,
            "Constitution", (int) Enemy.getEnemyByName("Skeleton").getHpxp() * skeletonKills), skeletonKills, true, true));

        Map<Integer, List<Requirement>> zombieKillsAndReqs = combatKills(new Encounter("Zombie"), player, 0, "Magic", 0, false);
        int zombieKills = zombieKillsAndReqs.keySet().iterator().next();
        List<Requirement> zombieReqs = zombieKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing zombies", zombieReqs, new HashMap(), Map.of("Zombie", zombieKills, "aCombat", (int)Enemy.getEnemyByName("Zombie").getCbxp() * zombieKills,
            "Constitution", (int) Enemy.getEnemyByName("Zombie").getHpxp() * zombieKills), zombieKills, true, true));

        Map<Integer, List<Requirement>> hobgoblinKillsAndReqs = combatKills(new Encounter("Hobgoblin"), player, 0, "Magic", 0, false);
        int hobgoblinKills = hobgoblinKillsAndReqs.keySet().iterator().next();
        List<Requirement> hobgoblinReqs = hobgoblinKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing hobgoblins", hobgoblinReqs, new HashMap(), Map.of("Hobgoblin", hobgoblinKills, "aCombat", (int)Enemy.getEnemyByName("Hobgoblin").getCbxp() * hobgoblinKills,
            "Constitution", (int) Enemy.getEnemyByName("Hobgoblin").getHpxp() * hobgoblinKills), hobgoblinKills, true, true));

        Map<Integer, List<Requirement>> hillGiantKillsAndReqs = combatKills(new Encounter("Hill giant"), player, 0, "Magic", 0, false);
        int hillGiantKills = hillGiantKillsAndReqs.keySet().iterator().next();
        List<Requirement> hillGiantReqs = hillGiantKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing hill giants", hillGiantReqs, new HashMap(), Map.of("Giant", hillGiantKills, "aCombat", (int)Enemy.getEnemyByName("Hill giant").getCbxp() * hillGiantKills,
            "Constitution", (int) Enemy.getEnemyByName("Hill giant").getHpxp() * hillGiantKills), hillGiantKills, true, true));

        Map<Integer, List<Requirement>> bansheeKillsAndReqs = combatKills(new Encounter("Banshee"), player, 0, "Ranged", 0, false);
        int bansheeKills = bansheeKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> bansheeReqs = new ArrayList<>(bansheeKillsAndReqs.values().iterator().next());
        bansheeReqs.add(new Requirement("Slayer", 15));
        database.add(new Action("Killing banshees", bansheeReqs, new HashMap(), Map.of("Banshee", bansheeKills, "rCombat",
            (int)Enemy.getEnemyByName("Banshee").getCbxp() * bansheeKills, "Constitution", (int) Enemy.getEnemyByName("Banshee").getHpxp() * bansheeKills), bansheeKills, true, true));

        Map<Integer, List<Requirement>> ghoulKillsAndReqs = combatKills(new Encounter("Ghoul"), player, 0, "Magic", 0, false);
        int ghoulKills = ghoulKillsAndReqs.keySet().iterator().next();
        List<Requirement> ghoulReqs = ghoulKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing ghouls", ghoulReqs, new HashMap(), Map.of("Ghoul", ghoulKills, "aCombat", (int)Enemy.getEnemyByName("Ghoul").getCbxp() * ghoulKills,
            "Constitution", (int) Enemy.getEnemyByName("Ghoul").getHpxp() * ghoulKills), ghoulKills, true, true));

        Map<Integer, List<Requirement>> earthWarriorKillsAndReqs = combatKills(new Encounter("Earth warrior"), player, 0, "Magic", 0, false);
        int earthWarriorKills = earthWarriorKillsAndReqs.keySet().iterator().next();
        List<Requirement> earthWarriorReqs = earthWarriorKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing earth warriors", earthWarriorReqs, new HashMap(), Map.of("Earth warrior", earthWarriorKills,
            "aCombat", (int)Enemy.getEnemyByName("Earth warrior").getCbxp() * earthWarriorKills, "Constitution", (int) Enemy.getEnemyByName("Earth warrior").getHpxp() * earthWarriorKills),
            earthWarriorKills, true, true));

        Map<Integer, List<Requirement>> aberrantSpectreKillsAndReqs = combatKills(new Encounter("Aberrant spectre"), player, 0, "Ranged", 0, false);
        int aberrantSpectreKills = aberrantSpectreKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> aberrantSpectreReqs = new ArrayList<>(aberrantSpectreKillsAndReqs.values().iterator().next());
        aberrantSpectreReqs.add(new Requirement("Slayer", 60));
        database.add(new Action("Killing aberrant spectres", aberrantSpectreReqs, new HashMap(), Map.of("Aberrant spectre", aberrantSpectreKills, "rCombat",
            (int)Enemy.getEnemyByName("Aberrant spectre").getCbxp() * aberrantSpectreKills, "Constitution", (int) Enemy.getEnemyByName("Aberrant spectre").getHpxp() * aberrantSpectreKills),
            aberrantSpectreKills, true, true));

        Map<Integer, List<Requirement>> jogreKillsAndReqs = combatKills(new Encounter("Jogre"), player, 0, "Magic", 0, false);
        int jogreKills = jogreKillsAndReqs.keySet().iterator().next();
        List<Requirement> jogreReqs = jogreKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing jogres", jogreReqs, new HashMap(), Map.of("Jogre", jogreKills, "aCombat", (int)Enemy.getEnemyByName("Jogre").getCbxp() * jogreKills,
            "Constitution", (int) Enemy.getEnemyByName("Jogre").getHpxp() * jogreKills), jogreKills, true, true));

        Map<Integer, List<Requirement>> mummyKillsAndReqs = combatKills(new Encounter("Mummy"), player, 0, "Magic", 0, false);
        int mummyKills = mummyKillsAndReqs.keySet().iterator().next();
        List<Requirement> mummyReqs = mummyKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing mummys", mummyReqs, new HashMap(), Map.of("Mummy", mummyKills, "aCombat", (int)Enemy.getEnemyByName("Mummy").getCbxp() * mummyKills,
            "Constitution", (int) Enemy.getEnemyByName("Mummy").getHpxp() * mummyKills), mummyKills, true, true));

        Map<Integer, List<Requirement>> lesserDemonKillsAndReqs = combatKills(new Encounter("Lesser demon"), player, 0, "Ranged", 0, false);
        int lesserDemonKills = lesserDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> lesserDemonReqs = lesserDemonKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing lesser demons", lesserDemonReqs, new HashMap(), Map.of("Lesser demon", lesserDemonKills,
            "rCombat", (int)Enemy.getEnemyByName("Lesser demon").getCbxp() * lesserDemonKills,
            "Constitution", (int) Enemy.getEnemyByName("Lesser demon").getHpxp() * lesserDemonKills), lesserDemonKills, true, true));

        //Bossing
        Map<Integer, List<Requirement>> kbdKillsAndReqs = combatKills(new Encounter("King Black Dragon"), player, 28, "Melee", 0, false);
        int kbdKills = kbdKillsAndReqs.keySet().iterator().next();
        List<Requirement> kbdReqs = kbdKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing the King Black Dragon", kbdReqs, new HashMap(), Map.of("King Black Dragon", kbdKills, "Boss kills", kbdKills,
            "mCombat", (int)Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills, "Constitution",
            (int)Enemy.getEnemyByName("King Black Dragon").getHpxp() * kbdKills), kbdKills, true, true));

        Map<Integer, List<Requirement>> qbdKillsAndReqs = combatKills(new Encounter("Queen Black Dragon"), player, 28, "Melee", 0, false);
        int qbdKills = qbdKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> qbdReqs = new ArrayList<>(qbdKillsAndReqs.values().iterator().next());
        qbdReqs.add(new Requirement("Summoning", 60));
        database.add(new Action("Killing the Queen Black Dragon", qbdReqs, new HashMap(),
            Map.of("Queen Black Dragon", qbdKills, "Boss kills", qbdKills, "mCombat", (int)Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills, "Constitution",
            (int)Enemy.getEnemyByName("Queen Black Dragon").getHpxp() * qbdKills), qbdKills, true, true));

        Map<Integer, List<Requirement>> durzagKills = combatKills(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Charger", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")), 10), player, 28, "Melee", 0, false);
        database.add(new Action("Killing Beastmaster Durzag (10 man)", durzagKills.values().iterator().next(), new HashMap(), Map.of("Beastmaster Durzag", durzagKills.keySet().iterator().next(),
            "Boss kills", durzagKills.keySet().iterator().next(), "Liberation of Mazcab", durzagKills.keySet().iterator().next(), "Teci", durzagKills.keySet().iterator().next()*1000),
            durzagKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> raxKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Araxxor"), Collections.singletonList("Araxxi"))), player, 28, "Melee", 0, false);
        database.add(new Action("Killing Araxxor", raxKills.values().iterator().next(), new HashMap(), Map.of("Araxxi", raxKills.keySet().iterator().next(),
            "Boss kills", durzagKills.keySet().iterator().next()), durzagKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kqKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Kalphite Queen (Phase 1)"), Collections.singletonList("Kalphite Queen (Phase 2)"))),
            player, 28, "Melee", 0, false);
        database.add(new Action("Killing the Kalphite Queen", kqKills.values().iterator().next(), new HashMap(), Map.of("Kalphite Queen", kqKills.keySet().iterator().next(),
            "Boss kills", kqKills.keySet().iterator().next()), kqKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kkKills = combatKills(new Encounter(Collections.singletonList(Collections.singletonList("Kalphite King")), 2), player, 28, "Melee", 0, false);
        database.add(new Action("Killing the Kalphite King (duo)", kkKills.values().iterator().next(), new HashMap(), Map.of("Kalphite King", kkKills.keySet().iterator().next(),
            "Boss kills", kkKills.keySet().iterator().next()), kkKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> voragoKills = combatKills(new Encounter(Collections.singletonList(Collections.singletonList("Vorago")), 7), player, 28, "Melee", 0, false);
        database.add(new Action("Killing Vorago (7 man)", voragoKills.values().iterator().next(), new HashMap(), Map.of("Vorago", voragoKills.keySet().iterator().next(),
            "Boss kills", voragoKills.keySet().iterator().next()), voragoKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> nexAODKills = combatKills(new Encounter(Collections.singletonList(Collections.singletonList("Nex: Angel of Death")), 7), player, 28, "Melee", 0, false);
        ArrayList<Requirement> nexAODReqs = new ArrayList<>(nexAODKills.values().iterator().next());
        nexAODReqs.add(new Requirement("Ranged", 70));
        nexAODReqs.add(new Requirement("Strength", 70));
        nexAODReqs.add(new Requirement("Agility", 70));
        nexAODReqs.add(new Requirement("Constitution", 70));
        database.add(new Action("Killing Nex: Angel of Death (7 man)", nexAODReqs, new HashMap(), Map.of("Nex: Angel of Death", nexAODKills.keySet().iterator().next(),
            "Boss kills", nexAODKills.keySet().iterator().next()), nexAODKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> voragoHMKills = combatKills(new Encounter(Collections.singletonList(Collections.singletonList("Vorago (HM)")), 7), player, 28, "Melee", 0, false);
        database.add(new Action("Killing hard mode Vorago (7 man)", voragoHMKills.values().iterator().next(), new HashMap(), Map.of("Vorago (HM)", voragoHMKills.keySet().iterator().next(),
            "Boss kills", voragoHMKills.keySet().iterator().next()), voragoHMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> moleKills = combatKills(new Encounter("Giant Mole"), player, 28, "Magic", 0, false);
        database.add(new Action("Killing Giant Mole", moleKills.values().iterator().next(), new HashMap(), Map.of("Giant Mole", moleKills.keySet().iterator().next(),
            "Boss kills", moleKills.keySet().iterator().next()), moleKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> twinFuriesKills = combatKills(new Encounter("Twin Furies"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> twinFuriesReqs = new ArrayList(twinFuriesKills.values().iterator().next());
        twinFuriesReqs.add(new Requirement("Ranged", 80));
        database.add(new Action("Killing the Twin Furies", twinFuriesReqs, new HashMap(), Map.of("Twin Furies", twinFuriesKills.keySet().iterator().next(),
            "Boss kills", twinFuriesKills.keySet().iterator().next()), twinFuriesKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> vindictaKills = combatKills(new Encounter("Vindicta"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> vindictaReqs = new ArrayList(vindictaKills.values().iterator().next());
        vindictaReqs.add(new Requirement("Attack", 80));
        database.add(new Action("Killing Vindicta", vindictaReqs, new HashMap(), Map.of("Vindicta", vindictaKills.keySet().iterator().next(),
            "Boss kills", vindictaKills.keySet().iterator().next()), vindictaKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> gregCMKills = combatKills(new Encounter("Gregorovic (CM)"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> gregCMReqs = new ArrayList(gregCMKills.values().iterator().next());
        gregCMReqs.add(new Requirement("Prayer", 80));
        database.add(new Action("Killing Gregorovic (CM)", gregCMReqs, new HashMap(), Map.of("Gregorovic (hard)", gregCMKills.keySet().iterator().next(),
            "Boss kills", gregCMKills.keySet().iterator().next()), gregCMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kreeKills = combatKills(new Encounter("Kree'arra"), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> kreeReqs = new ArrayList<>(kreeKills.values().iterator().next());
        kreeReqs.add(new Requirement("Ranged", 70));
        database.add(new Action("Killing Kree'arra", kreeReqs, new HashMap(), Map.of("Kree'arra", kreeKills.keySet().iterator().next(),
            "Boss kills", kreeKills.keySet().iterator().next()), kreeKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> graardorKills = combatKills(new Encounter("General Graardor"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> graardorReqs = new ArrayList(graardorKills.values().iterator().next());
        graardorReqs.add(new Requirement("Strength", 70));
        database.add(new Action("Killing General Graardor", graardorReqs, new HashMap(), Map.of("General Graardor", graardorKills.keySet().iterator().next(),
            "Boss kills", graardorKills.keySet().iterator().next()), graardorKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> krilKills = combatKills(new Encounter("K'ril Tsutsaroth"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> krilReqs = new ArrayList(krilKills.values().iterator().next());
        krilReqs.add(new Requirement("Constitution", 70));
        database.add(new Action("Killing K'ril Tsutsaroth", krilReqs, new HashMap(), Map.of("K'ril Tsutsaroth", krilKills.keySet().iterator().next(),
            "Boss kills", krilKills.keySet().iterator().next()), krilKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kreeKillsHM = combatKills(new Encounter("Kree'arra (HM)"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> kreeReqsHM = new ArrayList(kreeKillsHM.values().iterator().next());
        kreeReqs.add(new Requirement("Ranged", 70));
        database.add(new Action("Killing Kree'arra in hard mode", kreeReqsHM, new HashMap(), Map.of("Kree'arra (HM)", kreeKillsHM.keySet().iterator().next(),
            "Boss kills", kreeKillsHM.keySet().iterator().next()), kreeKillsHM.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> legioKills = combatKills(new Encounter("Legio"), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> legioReqs = new ArrayList(legioKills.values().iterator().next());
        legioReqs.add(new Requirement("Slayer", 95));

        database.add(new Action("Killing Legio Primus", legioReqs, Map.of("Ascension Keystone Primus", legioKills.keySet().iterator().next()),
            Map.of("Legio Primus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Secundus", legioReqs, Map.of("Ascension Keystone Secundus", legioKills.keySet().iterator().next()),
            Map.of("Legio Secundus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Tertius", legioReqs, Map.of("Ascension Keystone Tertius", legioKills.keySet().iterator().next()),
            Map.of("Legio Tertius", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Quartus", legioReqs, Map.of("Ascension Keystone Quartus", legioKills.keySet().iterator().next()),
            Map.of("Legio Quartus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Quintus", legioReqs, Map.of("Ascension Keystone Quintus", legioKills.keySet().iterator().next()),
            Map.of("Legio Quintus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));
        database.add(new Action("Killing Legio Sextus", legioReqs, Map.of("Ascension Keystone Sextus", legioKills.keySet().iterator().next()),
            Map.of("Legio Sextus", legioKills.keySet().iterator().next(), "Legiones", legioKills.keySet().iterator().next(),
                "Boss kills", legioKills.keySet().iterator().next()), legioKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> nexKills = combatKills(new Encounter("Nex"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> nexReqs = new ArrayList(nexKills.values().iterator().next());
        nexReqs.add(new Requirement("Ranged", 70));
        nexReqs.add(new Requirement("Strength", 70));
        nexReqs.add(new Requirement("Agility", 70));
        nexReqs.add(new Requirement("Constitution", 70));
        database.add(new Action("Killing Nex", nexReqs, new HashMap(), Map.of("Nex", nexKills.keySet().iterator().next(), "Boss kills", nexKills.keySet().iterator().next()),
            nexKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> rotsKills = combatKills(new Encounter(Arrays.asList(Arrays.asList("Karil the Tainted (ROTS)", "Torag the Corrupted (ROTS)",
            "Dharok the Wretched (ROTS)"), Arrays.asList("Guthan the Infested (ROTS)", "Ahrim the Blighted (ROTS)",
            "Verac the Defiled (ROTS)")), 4), player, 28, "Ranged", 0, false);
        database.add(new Action("Killing ROTS (4 man)", rotsKills.values().iterator().next(), new HashMap(), Map.of("Rise of the Six", rotsKills.keySet().iterator().next(),
            "Boss kills", rotsKills.keySet().iterator().next()), rotsKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> barrowsKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Karil the Tainted"), Collections.singletonList("Ahrim the Blighted"),
            Collections.singletonList("Torag the Corrupted"), Collections.singletonList("Dharok the Wretched"), Collections.singletonList("Verac the Defiled"),
            Collections.singletonList("Guthan the Infested"), Collections.singletonList("Akrisae the Doomed"))), player, 28, "Magic", 0, false);
        ArrayList<Requirement> barrowsReqs = new ArrayList(barrowsKills.values().iterator().next());
        barrowsReqs.add(new Requirement("Ritual of the Mahjarrat", 1));
        database.add(new Action("Killing Barrows incl. Akrisae", barrowsReqs, new HashMap(), Map.of("Barrows", barrowsKills.keySet().iterator().next(),
            "Boss kills", barrowsKills.keySet().iterator().next()), barrowsKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> linzaKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Karil the Tainted"), Collections.singletonList("Ahrim the Blighted"),
            Collections.singletonList("Torag the Corrupted"), Collections.singletonList("Dharok the Wretched"), Collections.singletonList("Verac the Defiled"),
            Collections.singletonList("Guthan the Infested"), Collections.singletonList("Linza the Disgraced"))), player, 28, "Magic", 0, false);
        ArrayList<Requirement> linzaReqs = new ArrayList(barrowsKills.values().iterator().next());
        linzaReqs.add(new Requirement("Kindred Spirits", 1));
        database.add(new Action("Killing Barrows incl. Linza", linzaReqs, new HashMap(), Map.of("Linza", linzaKills.keySet().iterator().next(),
            "Boss kills", linzaKills.keySet().iterator().next()), linzaKills.keySet().iterator().next(), true, true));

        //Other repeatables
        database.add(new Action("Completing Shifting Tombs", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 50), new Requirement("The Jack of Spades", 1)),
            new HashMap<>(), Map.of("Shifting Tombs", 12), 12, true, true));

        database.add(new Action("Completing city quests", Collections.singletonList(new Requirement("The Jack of Spades", 1)), new HashMap(),
            Map.of("City quest", 4, "Menaphos reputation", 9400), 4, true, true));
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
            if (combatResults.getHpLost() > 1000000) {
                Map<String, Double> nextGear = player.nextGear(combatStyle);
                if (nextGear == null) {
                    break;
                }
                addGearToPlayer(player, nextGear.keySet().iterator().next());
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
                for (Weapon weapon : player.getWeapons()) {
                    if (!initialWeapons.contains(weapon)) {
                        requirements.add(new Requirement(weapon.getName(), 1));
                    }
                }
                for (Armour armour : player.getArmour()) {
                    if (!initialArmours.contains(armour)) {
                        requirements.add(new Requirement(armour.getName(), 1));
                    }
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
        CombatResults combatResults = combatEncounter.calculateCombat(player, new CombatParameters(invenSpaces, combatStyle, true, dropRateOfItem, stackable));
        List<Requirement> combatReqs = new ArrayList<>();
        if (combatResults.getHpLost() == 1000000000) {
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
            combatResults = combatEncounter.calculateCombat(player, new CombatParameters(invenSpaces, combatStyle, true, dropRateOfItem, stackable));
            if (combatResults.getHpLost() == 1000000000) {
                player.setXp(initialXP);
                player.setWeapons(initialWeapons);
                player.setArmour(initialArmours);
                return Map.of(0, Collections.singletonList(new Requirement("Impossible", 1)));
            }
        }
        player.setXp(initialXP);
        player.setWeapons(initialWeapons);
        player.setArmour(initialArmours);
        if (combatResults.getTicks() >= TICKS_PER_HOUR) {
            return Map.of(combatResults.getKills(), combatReqs);
        }
        else {
            return Map.of(combatResults.getKills()*TICKS_PER_HOUR/(combatResults.getTicks()+100), combatReqs);
        }

    }
    private void addGearToPlayer(Player player, String gear) {
        Weapon weapon = Weapon.getWeaponByName(gear);
        Armour armour = Armour.getArmourByName(gear);
        Food food = Food.getFoodByName(gear);
        Familiar familiar = Familiar.getFamiliarByName(gear);
        if (weapon != null) {
            for (Requirement requirement : weapon.getReqs()) {
                player.getXp().put(requirement.getQualifier(), player.getXp().get(requirement.getQualifier()) + player.getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
            }
            player.addWeapon(weapon);
        }
        else if (armour != null) {
            for (Requirement requirement : armour.getReqs()) {
                player.getXp().put(requirement.getQualifier(), player.getXp().get(requirement.getQualifier()) + player.getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
            }
            player.addArmour(armour);
        }
        else if (food != null) {
            player.getXp().put("Constitution", player.getXp().get("Constitution") + player.getXpToLevel("Constitution", Math.min(99, food.getAmountHealed()/25)));
        }
        else if (familiar != null) {
            player.getXp().put("Summoning", player.getXp().get("Summoning") + player.getXpToLevel("Summoning", familiar.getSummonReq()));
        }
        else {
            throw new RuntimeException(String.format("Attempted to equip gear that does not exist: %s. Please raise a T99 issue.", gear));
        }
    }


    private int logsCut(Player player, int hatchetRank, int perfectRateFactor) {
        return (int)Math.floor(((34 + player.getLevel("Woodcutting") * Math.pow(1.035, hatchetRank)) * 1500) / perfectRateFactor);
    }

    private int fishCaught(Player player, int levelAtMaxRate) {
        return (int)Math.floor(1200*Math.pow(0.96, 1+Math.max(0, levelAtMaxRate-player.getLevel("Fishing"))));
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