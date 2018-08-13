package data.databases;

import data.dataobjects.SlayerMaster;
import logic.*;
import data.dataobjects.Enemy;
import data.dataobjects.Action;

import java.util.*;

public class ActionDatabase {
    
    private static ActionDatabase actionDatabase;

    private static final int TICKS_PER_HOUR = 6000;
    private List<Action> database = new ArrayList<>();
    private Map<Action, Boolean> usedFlags = new HashMap<Action, Boolean>();

    private ActionDatabase() {
    }

    private void addActionsToDatabase(Player player) {
        //Placeholder for skills that have not yet been implemented
        database.add(new Action("Quacking", new ArrayList<>(), new HashMap<>(), Map.of("Invention", 1), true, true));

        //Placeholder for dailies/spawns/shops/etc (move when applicable feature is fully implemented)
        database.add(new Action("Rosie's daily supplies", Collections.singletonList(new Requirement("Impressing the Locals", 1)),
            new HashMap(), Map.of("Supplies", 60), true, true));
        database.add(new Action("Collecting planks", new ArrayList(), new HashMap(), Map.of("Plank", 240), true, true));
        database.add(new Action("Buying cleansing crystals", Collections.singletonList(new Requirement("Plague's End", 1)),
            Map.of("Coins", 39600000), Map.of("Cleansing crystal", 360), true, true));

        //Player-owned-ports
        database.add(new Action("POP - Arc region voyages", Collections.singletonList(new Requirement("Ports unlocked", 1)), new HashMap(),
            Map.of("Port distance", 5000, "Port chimes", 1600, "Port bamboo", 1600), true, true));
        database.add(new Action("POP - Skull region voyages", Collections.singletonList(new Requirement("Port distance", 5000)), new HashMap(),
            Map.of("Port distance", 12000, "Port chimes", 6000, "Port gunpowder", 3000), true, true));
        database.add(new Action("POP - Hook region voyages", Collections.singletonList(new Requirement("Port distance", 40000)), new HashMap(),
            Map.of("Port distance", 24000, "Port chimes", 10000, "Port slate", 3000), true, true));
        database.add(new Action("POP - Scythe region voyages", Collections.singletonList(new Requirement("Port distance", 140000)), new HashMap(),
            Map.of("Port distance", 48000, "Port chimes", 13000, "Port cherrywood", 4000), true, true));
        database.add(new Action("POP - Bowl region voyages", Collections.singletonList(new Requirement("Port distance", 450000)), new HashMap(),
            Map.of("Port distance", 96000, "Port chimes", 20000, "Port jade", 7200), true, true));

        //XP-less gathering
        database.add(new Action("Picking potatoes", new ArrayList<>(), new HashMap<>(), Map.of("Raw potato", 690),
            true, true));
        database.add(new Action("Voyaging for items", Collections.singletonList(new Requirement("Impressing the Locals", 1)),
            Map.of("Supplies", 300), Map.ofEntries(Map.entry("Taijitu", 26), Map.entry("Sea shell", 9), Map.entry("Driftwood", 9), Map.entry("Sea salt", 9),
            Map.entry("Bamboo", 9), Map.entry("Shell chippings", 9), Map.entry("Spirit dragon charm", 9), Map.entry("Raw tarpon", 9), Map.entry("Bundle of bamboo", 9),
            Map.entry("Fish oil", 9), Map.entry("Stoneberry seed", 1), Map.entry("Stormberry seed", 1)), true, true));
        database.add(new Action("Winning Castle Wars games", new ArrayList(), new HashMap(), Map.of("Gold Castle Wars ticket", 6), true,
            true));
        database.add(new Action("Opening prawn balls", new ArrayList(), Map.of("Prawn balls", 3000), Map.of("Golden fish egg", 15), true, true));

        //Agility
        database.add(new Action("Burthorpe Agility Course", new ArrayList<>(), new HashMap<>(), Map.of("Agility", 11955, "Dojo Mojo points",
            17312*player.getLevel("Agility")), true, true));
        database.add(new Action("Gnome Stronghold Agility Course", new ArrayList<>(), new HashMap<>(), Map.of("Agility", 8650),
            true, true));
        database.add(new Action("Agility Pyramid", Collections.singletonList(new Requirement("Agility", 30)), Map.of("Waterskin (4)", 10),
            Map.of("Waterskin (0)", 10, "Agility", 26708, "Pyramid top", 22), true, true));
        database.add(new Action("Hefin Agility Course (77-81 Agility)", Arrays.asList(new Requirement("Plague's End", 1),
            new Requirement("Agility", 77)), new HashMap(), Map.of("Agility", 56320, "Hefin Agility Course laps", 80), true, true));
        database.add(new Action("Advanced Gnome Stronghold Agility Course", Collections.singletonList(new Requirement("Agility", 85)),
            new HashMap(), Map.of("Agility", 68150, "Advanced Gnome Stronghold laps", 94), true, true));
        database.add(new Action("Advanced Barbarian Outpost Agility Course", Arrays.asList(new Requirement("Bar Crawl", 1),
            new Requirement("Agility", 90)), new HashMap(), Map.of("Agility", 72355, "Advanced Barbarian Outpost laps", 96), true, true));


        //Construction
        database.add(new Action("Building crude wooden chairs with bronze nails", new ArrayList(), Map.of("Plank", 490, "Bronze nails", 1470),
            Map.of("Construction", 16170), true, true));

        //Cooking
        database.add(new Action("Cooking raw beef", new ArrayList<>(),
            Map.of("Raw beef", 1250), Map.of("Cooked meat", (int) Math.floor(1250 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
            "Cooking", (int) Math.floor(37500 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))), true, true));

        database.add(new Action("Cooking shrimps", new ArrayList<>(), Map.of("Raw shrimps", 1250),
            Map.of("Shrimps", (int) Math.floor(1250 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(37500 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))), true, true));

        database.add(new Action("Cooking crayfish", new ArrayList<>(), Map.of("Raw crayfish", 1250),
            Map.of("Crayfish", (int) Math.floor(1250 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(37500 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))), true, true));

        database.add(new Action("Cooking chicken", new ArrayList<>(), Map.of("Raw chicken", 1250),
            Map.of("Cooked chicken", (int) Math.floor(1250 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(37500 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))), true, true));

        database.add(new Action("Making uncooked arc gumbo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 94)),
            Map.of("Bundle of bamboo", 1250, "Tortle shell bowl", 1250, "Rumberry", 1250, "Fish oil", 1250, "Sea salt", 1250), Map.of("Uncooked arc gumbo", 1250,
            "Cooking", 12500), true, true));

        database.add(new Action("Cooking arc gumbo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 94)),
            Map.of("Uncooked arc gumbo", 1250), Map.of("Arc gumbo", 1250, "Cooking", 162500, "Azure Parrot", 21), true, true));

        //Crafting
        database.add(new Action("Crafting molten glass", new ArrayList<>(), Map.of("Soda ash", 1050, "Bucket of sand", 1050),
            Map.of("Molten glass", 1050, "Crafting", 21000), true, true));

        database.add(new Action("Ithell harps (w/o VoS)", Collections.singletonList(new Requirement("Plague's End", 1)), new HashMap(),
            Map.of("Crafting", 560*player.getLevel("Crafting"), "Harmonic dust", 7*player.getLevel("Crafting"), "Construction", 10000),
            true, true));

        database.add(new Action("Making tortle shell bowls", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Crafting", 91)),
            Map.of("Shell chippings", 6800), Map.of("Tortle shell bowl", 1700, "Crafting", 127500), true, true));

        //Divination
        database.add(new Action("Pale wisps (no bought energy)", new ArrayList<>(), new HashMap<>(),
            Map.of("Divination", 4000, "Pale energy", 1600), true, true));
        database.add(new Action("Luminous wisps (no bought energy)", Collections.singletonList(new Requirement("Divination", 90)),
            new HashMap(), Map.of("Divination", 71000, "Luminous energy", 1600, "Fly dragon", 1, "Fruit fly", 1), true, true));
        database.add(new Action("Positive springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 90)), new HashMap(), Map.of("Divination", 60300, "Positive energy", 600), true, true));
        database.add(new Action("Ancestral springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 95)), new HashMap(), Map.of("Divination", 96300, "Ancestral energy", 600, "Cyansoul Kakapo", 1), true, true));

        //Dungeoneering (major approximation, assumes 7.5 minute floors)
        int dungXP = (int) Math.floor(4000 * Math.pow((player.getLevel("Dungeoneering") + 9.0) / 10.0, 2));
        database.add(new Action("Solo dungeoneering", new ArrayList(), new HashMap(), Map.of("Dungeoneering", dungXP, "Dungeoneering token",
            dungXP/10, "Dungeoneering floors completed", 8), true, true));

        //Farming
        database.add(new Action("Farming potatoes", new ArrayList(), Map.of("Potato seed", 270), Map.of("Raw potato", 675, "Farming", 6795),
            true, true));

        database.add(new Action("Foraging rumberries (keep)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Rumberry", 300, "Rumberry seed", 6, "Pumpkin Limpkin", 1),
            true, true));

        database.add(new Action("Foraging rumberries (sell)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Chimes", 618), true, true));

        database.add(new Action("Foraging exuberries (keep)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Exuberry", 300, "Exuberry seed", 6),
            true, true));

        database.add(new Action("Foraging mushrooms on named islands", Arrays.asList(new Requirement("Farming", 90),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Named mushrooms", 10), true, true));

        database.add(new Action("Foraging mushrooms on Uncharted Isles", Arrays.asList(new Requirement("Farming", 94),
            new Requirement("Impressing the Locals", 1)), Map.of("Supplies", 60), Map.of("Farming", 50000, "Uncharted mushrooms", 7), true, true));

        //Firemaking
        database.add(new Action("Burning normal logs on bonfire", new ArrayList(), Map.of("Logs", 950), Map.of("Firemaking", 49500), true,
            true));
        database.add(new Action("Burning acadia logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 46)), Map.of("Acadia logs", 950),
            Map.of("Firemaking", 171000, "Menaphite honey bee", 1, "Fruit fly in amber", 1), true, true));

        //Fishinng
        database.add(new Action("Fishing raw crayfish", new ArrayList<>(), new HashMap<>(), Map.of("Raw crayfish", resourcesGained(1, 5.0, player, 50.0, "Fishing"),
            "Fishing", 10 * resourcesGained(1, 5.0, player, 50.0, "Fishing"), "Prawn balls", resourcesGained(1, 5.0, player, 50.0, "Fishing")/175), true, true));


        database.add(new Action("Fishing raw shrimps", new ArrayList<>(), new HashMap<>(), Map.of("Raw shrimps", resourcesGained(20, 5.0, player, 50.0, "Fishing"),
            "Fishing", 10 * resourcesGained(20, 5.0, player, 50.0, "Fishing"), "Prawn balls", resourcesGained(20, 5.0, player, 50.0, "Fishing")/175), true, true));

        database.add(new Action("Fishing/dropping desert sole", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Fishing", 52)),
            new HashMap(), Map.of("Fishing", 60 * resourcesGained(70, 5.0, player, 0.0, "Fishing"), "Menaphos reputation",
            3 * resourcesGained(70, 5.0, player, 0.0, "Fishing"), "Prawn balls", 1450*resourcesGained(70, 5.0, player, 0.0, "Fishing")/35000,
            "Clicker kalphite in amber", 1, "Desert locust in amber", 1), true, true));

        //Fletching
        database.add(new Action("Fletching arrow shafts with normal logs", new ArrayList(), Map.of("Logs", 1800), Map.of("Arrow shaft", 27000,
            "Fletching", 9000), true, true));

        //Herblore
        database.add(new Action("Cleaning grimy guams", new ArrayList(), Map.of("Grimy guam", 5090), Map.of("Clean guam", 5090,
            "Herblore", 12725), true, true));

        //Hunter
        database.add(new Action("Feeding ogleroots to rabbits", new ArrayList(), Map.of("Coins", 3000), Map.of("Hunter", 10000),
            true, true));
        database.add(new Action("Catching charm sprites", Collections.singletonList(new Requirement("Hunter", 72)), new HashMap(),
            Map.of("Hunter", 60000, "Crimson charm", 40, "Blue charm", 28, "Green charm", 17, "Gold charm", 6, "Charm sprites", 435), true,
            true));
        database.add(new Action("Catching plover birds", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Hunter", 73)),
            Map.of("Logs", 200), Map.of("Plover bird", 68+player.getLevel("Hunter"), "Hunter", 510*(68+player.getLevel("Hunter")),
            "Menaphos reputaton", 30*(68+player.getLevel("Hunter")), "Pygmy giant scarab", 1, "Clicker kalphite", 1), true, true));
        database.add(new Action("Hunting tortles", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Hunter", 90)),
            new HashMap(), Map.of("Hunter", 258000, "Tortoiseshell Plover", 2, "Shell chippings", 400), true, true));

        //Mining
        database.add(new Action("Mining and dropping essence", new ArrayList<>(), new HashMap<>(), Map.of("Mining", 26250),
            true, true));
        database.add(new Action("Mining pure essence", Collections.singletonList(new Requirement("Mining", 30)), new HashMap(),
            Map.of("Mining", 10220, "Pure essence", 2044), true, true));

        database.add(new Action("Mining copper ore with bronze pickaxe", new ArrayList(), new HashMap(), Map.of("Copper ore",
            resourcesGained(25, 6.0, player, 100.0, "Mining"), "Mining", (int) Math.floor(17.5 * resourcesGained(25, 6.0, player, 100.0, "Mining"))), true, true));
        database.add(new Action("Mining tin ore with bronze pickaxe", new ArrayList(), new HashMap(), Map.of("Tin ore",
            resourcesGained(25, 6.0, player, 100.0, "Mining"), "Mining", (int) Math.floor(17.5 * resourcesGained(25, 6.0, player, 100.0, "Mining"))), true, true));
        database.add(new Action("Mining coal with bronze pickaxe", Collections.singletonList(new Requirement("Mining", 30)), new HashMap(),
            Map.of("Coal", resourcesGained(70, 6.0, player, 30.0, "Mining"), "Mining", 50*resourcesGained(70, 6.0, player, 30.0, "Mining")), true, true));
        database.add(new Action("Mining/dropping concentrated sandstone with bronze pickaxe", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Mining", 50)), new HashMap(), Map.of("Mining", resourcesGained(100, 6.0, player, 0.0, "Mining"),
            "Menaphos reputation", (int)(2.7*resourcesGained(100, 6.0, player, 0.0, "Mining")), "Menaphite honey bee in amber", 1,
            "Pygmy giant scarab in amber", 1), true, true));

        database.add(new Action("Mining salty crablets", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Mining", 91)),
            new HashMap(), Map.of("Sea salt", 3*player.getLevel("Mining")-60, "Mining", (int)507.5*(3*player.getLevel("Mining") - 60), "Awah Guan", 1), true, true));

        //Prayer
        database.add(new Action("Offering bones to Chaos Altar", new ArrayList<>(), Map.of("Bones", 1400),
            Map.of("Prayer", 22050), true, false));
        database.add(new Action("Offering bones to Ectofuntus", new ArrayList(), Map.of("Bones", 390), Map.of("Prayer", 7020, "Ecto-token",
            1890), true, true));
        database.add(new Action("Burying bones", new ArrayList<>(), Map.of("Bones", 3600), Map.of("Prayer", 16200),
            true, true));

        //Runecrafting
        database.add(new Action("Low-level Runespan (island 1)", new ArrayList(), new HashMap(), Map.of("Runecrafting", 16500),
            true, true));

        //Slayer
        database.add(new Action("Slayer tasks from Turael", new ArrayList(), new HashMap(), Map.of("Slayer", (int)SlayerMaster.TURAEL.calculateAvgXpPerHour(player)),
            true, true));

        //Smithing
        database.add(new Action("Smithing bronze bars", new ArrayList(), Map.of("Copper ore", 1050, "Tin ore", 1050),
            Map.of("Bronze bar", 1050, "Smithing", 6510), true, true));
        database.add(new Action("Smithing bronze nails", Collections.singletonList(new Requirement("Smithing", 4)),
            Map.of("Bronze bar", 1232), Map.of("Smithing", 15400, "Bronze nails", 18480), true, true));

        //Summoning
        database.add(new Action("Making spirit wolf pouches", new ArrayList(), Map.of("Spirit shards", 10500, "Pouch", 1500,
            "Wolf bones", 1500, "Gold charm", 1500), Map.of("Spirit wolf pouch", 1500, "Summoning", 7200),
            true, true));

        //Thieving
        database.add(new Action("Pickpocketing men/women", new ArrayList(), new HashMap(), Map.of("Coins", 3 * pocketsPicked(1, player),
            "Thieving", 8 * pocketsPicked(1, player)), true, true));
        database.add(new Action("Menaphos silk stall (drop silk)", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Thieving", 20)),
            new HashMap(), Map.of("Thieving", 9600, "Menaphos reputation", 2400, "Fly dragon in amber", 1), true, true));
        database.add(new Action("Pickpocketing Menaphite marketeers", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Thieving", 46)), new HashMap(), Map.of("Thieving", (int)(29.5 * pocketsPicked(46, player)), "Menaphos reputation",
            (int)(1.3 * pocketsPicked(46, player)), "Coins", 30*pocketsPicked(46, player), "Kalphite wanderer in amber", 1, "Hornless unicornfly in amber", 1), true, true));

        //Woodcutting
        database.add(new Action("Cutting regular trees with bronze hatchet", new ArrayList(), new HashMap(), Map.of("Logs", resourcesGained(40, 4.0, player, 75.0, "Woodcutting"),
            "Woodcutting", resourcesGained(40, 4.0, player, 75.0, "Woodcutting")*25), true, true));

        //CHOP RATE CALIBRATION: ~40% at 47, ~67% at 99 (unknown hatchet bonus, rune is assumed)
        database.add(new Action("Cutting/dropping acadia logs with bronze hatchet in VIP skilling area", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Menaphos reputation", 141900), new Requirement("Woodcutting", 47)), new HashMap(), Map.of("Woodcutting", 92*logsCut(player, 0, 230),
            "Menaphos reputation", (int)4.5*logsCut(player, 0, 230), "Desert locust", 1, "Hornless unicornfly", 1, "Kalphite wanderer", 1), true, true));

        database.add(new Action("Cutting bamboo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Woodcutting", 90)),
            new HashMap(), Map.of("Bamboo", 3*player.getLevel("Woodcutting") + 60, "Woodcutting", (int)202.5*(3*player.getLevel("Woodcutting") + 60), "Great Pecker", 1), true, true));

        //Multi-skill
        database.add(new Action("Cremating vyre corpses", Arrays.asList(new Requirement("Legacy of Seergaze", 1),
            new Requirement("Firemaking", 40)), Map.of("Vyre corpse", 500, "Teak pyre logs", 500), Map.of("Firemaking", 60000,
            "Prayer", 39350, "Vyre corpses burned", 500, "Columbarium key", 500), true, true));
        database.add(new Action("Cremating loar shades", Arrays.asList(new Requirement("Shades of Mort'ton", 1),
            new Requirement("Firemaking", 40)), Map.of("Loar remains", 500, "Pyre logs", 500), Map.of("Firemaking", 25000,
            "Prayer", 12500, "Coins", 100000, "Shade key", 250), true, true));

        //Combat for drops
        int cowKillsMelee = combatKills(new Encounter("Cow"), player, 0, "Melee", 1, false).keySet().iterator().next();
        int cowKillsRanged = combatKills(new Encounter("Cow"), player, 0, "Ranged", 1, false).keySet().iterator().next();
        int cowKillsMagic = combatKills(new Encounter("Cow"), player, 0, "Magic", 1, false).keySet().iterator().next();
        int cowKillsMeleeGoldCharms = combatKills(new Encounter("Cow"), player, 0, "Melee", 0.008, true).keySet().iterator().next();
        int cowKillsRangedGoldCharms = combatKills(new Encounter("Cow"), player, 0, "Ranged", 0.008, true).keySet().iterator().next();
        int cowKillsMagicGoldCharms = combatKills(new Encounter("Cow"), player, 0, "Magic", 0.008, true).keySet().iterator().next();
        database.add(new Action("Killing cows for raw beef with melee", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw beef", cowKillsMelee, "mCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKillsMelee, "Constitution", 
                (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKillsMelee), true, true));
        database.add(new Action("Killing cows for bones with melee", new ArrayList<>(), new HashMap<>(),
            Map.of("Bones", cowKillsMelee, "mCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKillsMelee, "Constitution", 
                (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKillsMelee), true, true));
        database.add(new Action("Killing cows for gold charms with melee", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (cowKillsMeleeGoldCharms * 0.008),
            "mCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKillsMeleeGoldCharms, "Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKillsMeleeGoldCharms),
            true, true));
        database.add(new Action("Killing cows for raw beef with ranged", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw beef", cowKillsRanged, "rCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKillsRanged, "Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKillsRanged),
            true, true));
        database.add(new Action("Killing cows for bones with ranged", new ArrayList<>(), new HashMap<>(),
            Map.of("Bones", cowKillsRanged, "rCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKillsRanged, "Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKillsRanged),
            true, true));
        database.add(new Action("Killing cows for gold charms with ranged", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (cowKillsRangedGoldCharms * 0.008),
            "rCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKillsRangedGoldCharms, "Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKillsRangedGoldCharms),
            true, true));
        database.add(new Action("Killing cows for raw beef with magic", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw beef", cowKillsMagic, "aCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKillsMagic, "Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKillsMagic),
            true, true));
        database.add(new Action("Killing cows for bones with magic", new ArrayList<>(), new HashMap<>(),
            Map.of("Bones", cowKillsMagic, "aCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKillsMagic, "Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKillsMagic),
            true, true));
        database.add(new Action("Killing cows for gold charms with magic", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (cowKillsMagicGoldCharms * 0.008),
            "aCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKillsMagicGoldCharms, "Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKillsMagicGoldCharms),
            true, true));

        int chickenKillsMelee = combatKills(new Encounter("Chicken"), player, 0, "Melee", 1, false).keySet().iterator().next();
        int chickenKillsRanged = combatKills(new Encounter("Chicken"), player, 0, "Ranged", 1, false).keySet().iterator().next();
        int chickenKillsMagic = combatKills(new Encounter("Chicken"), player, 0, "Magic", 1, false).keySet().iterator().next();
        database.add(new Action("Killing chickens for raw chicken with melee", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw chicken", chickenKillsMelee, "mCombat", (int) Enemy.getEnemyByName("Chicken").getCbxp() * chickenKillsMelee, "Constitution",
                (int) Enemy.getEnemyByName("Chicken").getHpxp() * chickenKillsMelee), true, true));
        database.add(new Action("Killing chickens for raw chicken with ranged", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw chicken", chickenKillsRanged, "rCombat", (int) Enemy.getEnemyByName("Chicken").getCbxp() * chickenKillsRanged, "Constitution",
                (int) Enemy.getEnemyByName("Chicken").getHpxp() * chickenKillsRanged), true, true));
        database.add(new Action("Killing chickens for raw chicken with magic", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw chicken", chickenKillsMagic, "aCombat", (int) Enemy.getEnemyByName("Chicken").getCbxp() * chickenKillsMagic, "Constitution",
                (int) Enemy.getEnemyByName("Chicken").getHpxp() * chickenKillsMagic), true, true));

        int gelatinousAbominationKillsMelee = combatKills(new Encounter("Gelatinous abomination"), player, 0, "Melee", 0.4, true).keySet().iterator().next();
        int gelatinousAbominationKillsRanged = combatKills(new Encounter("Gelatinous abomination"), player, 0, "Ranged", 0.4, true).keySet().iterator().next();
        int gelatinousAbominationKillsMagic = combatKills(new Encounter("Gelatinous abomination"), player, 0, "Magic", 0.4, true).keySet().iterator().next();
        database.add(new Action("Killing gelatinous abominations for gold charms with melee", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (gelatinousAbominationKillsMelee * 0.4),
            "mCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() * gelatinousAbominationKillsMelee, "Constitution",
            (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() * gelatinousAbominationKillsMelee), true, true));
        database.add(new Action("Killing gelatinous abominations for gold charms with ranged", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (gelatinousAbominationKillsRanged * 0.4),
            "rCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() * gelatinousAbominationKillsRanged, "Constitution",
            (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() * gelatinousAbominationKillsRanged), true, true));
        database.add(new Action("Killing gelatinous abominations for gold charms with magic", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (gelatinousAbominationKillsMagic * 0.4),
            "aCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() * gelatinousAbominationKillsMagic, "Constitution",
            (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() * gelatinousAbominationKillsMagic), true, true));

        int vyreKills = combatKills(new Encounter("Vyrewatch", Collections.singletonList(new Restriction("Vampyric weapon", 1))), player, 0, "Melee", 1, false).keySet().iterator().next();
        database.add(new Action("Killing vyres for corpses", Collections.singletonList(new Requirement("Legacy of Seergaze", 1)), new HashMap(),
            Map.of("Vyre corpse", vyreKills, "mCombat", (int)Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills, "Constitution",
                (int) Enemy.getEnemyByName("Vyrewatch").getHpxp() * vyreKills), true, true));

        int truthfulshadowKills = combatKills(new Encounter("Truthful shadow"), player, 0, "Melee", 1, false).keySet().iterator().next();
        database.add(new Action("Killing truthful shadows for cores", Collections.singletonList(new Requirement("Plague's End", 1)), new HashMap(),
            Map.of("Truthful shadow core", truthfulshadowKills/5, "mCombat", (int)Enemy.getEnemyByName("Truthful shadow").getCbxp() * truthfulshadowKills, "Constitution",
                (int) Enemy.getEnemyByName("Truthful shadow").getHpxp() * truthfulshadowKills), true, true));

        int crystalShapeshifterKills = combatKills(new Encounter("Crystal shapeshifter"), player, 0, "Melee", 1, false).keySet().iterator().next();
        database.add(new Action("Killing crystal shapeshifters", Collections.singletonList(new Requirement("The Light Within", 1)), new HashMap(),
            Map.of("Crystal shapeshifter", crystalShapeshifterKills, "mCombat", (int)Enemy.getEnemyByName("Crystal shapeshifter").getCbxp() * crystalShapeshifterKills,
                "Constitution", (int) Enemy.getEnemyByName("Crystal shapeshifter").getHpxp() * crystalShapeshifterKills), true, true));

        //Bossing
        int kbdKills = combatKills(new Encounter("King Black Dragon", Collections.singletonList(new Restriction("Dragonfire protection", 1))), player, 28, "Melee", 0, false).keySet().iterator().next();
        database.add(new Action("Killing the King Black Dragon", new ArrayList(), new HashMap(), Map.of("King Black Dragon", kbdKills,
            "mCombat", (int)Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills, "Constitution",
            (int)Enemy.getEnemyByName("King Black Dragon").getHpxp() * kbdKills), true, true));

        int qbdKills = combatKills(new Encounter("Queen Black Dragon", Collections.singletonList(new Restriction("Dragonfire protection", 1))), player, 28, "Melee", 0, false).keySet().iterator().next();
        database.add(new Action("Killing the Queen Black Dragon", Collections.singletonList(new Requirement("Summoning", 60)), new HashMap(),
            Map.of("Queen Black Dragon", qbdKills, "mCombat", (int)Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills, "Constitution",
            (int)Enemy.getEnemyByName("Queen Black Dragon").getHpxp() * qbdKills), true, true));

        Map<Integer, List<Requirement>> durzagKills = combatKills(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Charger", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")), 10), player, 28, "Melee", 0, false);
        database.add(new Action("Killing Beastmaster Durzag", durzagKills.values().iterator().next(), new HashMap(), Map.of("Beastmaster Durzag", durzagKills.keySet().iterator().next()), true, true));

        Map<Integer, List<Requirement>> raxKills = combatKills(new Encounter(Arrays.asList(Collections.singletonList("Araxxor"), Collections.singletonList("Araxxi"))), player, 28, "Melee", 0, false);
        database.add(new Action("Killing Araxxor", raxKills.values().iterator().next(), new HashMap(), Map.of("Araxxi", raxKills.keySet().iterator().next()), true, true));

        //Other repeatables
        database.add(new Action("Completing Shifting Tombs", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 50), new Requirement("The Jack of Spades", 1)),
            new HashMap<>(), Map.of("Shifting Tombs", 12), true, true));
    }

    private void addFlagsToDatabase() {
        for (Action action : database) {
            usedFlags.put(action, true);
        }
    }

    public List<Action> getDatabase() {
        return database;
    }

    public Map<Action, Boolean> getUsedFlags() {
        return usedFlags;
    }

    private List<Requirement> getRequirementsForCombat(Encounter combatEncounter, Player player, int invenSpaces, String combatStyle) {
        Map<String, Double> initialXP = new HashMap<>(player.getXp());
        CombatResults combatResults;
        do {
            combatResults = combatEncounter.calculateCombat(player, invenSpaces, combatStyle);
            if (combatResults.getHpLost() > 1000000) {
                if (combatStyle.equals("Melee")) {
                    player.getXp().put("Attack", player.getXp().get("Attack") + player.getXpToLevel("Attack", player.getLevel("Attack") + 1));
                    player.getXp().put("Strength", player.getXp().get("Strength") + player.getXpToLevel("Strength", player.getLevel("Strength") + 1));
                }
                if (combatStyle.equals("Ranged")) {
                    player.getXp().put("Ranged", player.getXp().get("Ranged") + player.getXpToLevel("Ranged", player.getLevel("Ranged") + 1));
                }
                if (combatStyle.equals("Magic")) {
                    player.getXp().put("Magic", player.getXp().get("Magic") + player.getXpToLevel("Magic", player.getLevel("Magic") + 1));
                }
                player.getXp().put("Defense", player.getXp().get("Defense") + player.getXpToLevel("Defense", player.getLevel("Defense")+1));
                player.getXp().put("Constitution", player.getXp().get("Constitution") + player.getXpToLevel("Constitution", player.getLevel("Constitution") + 1));
                player.getXp().put("Prayer", player.getXp().get("Prayer") + player.getXpToLevel("Prayer", player.getLevel("Prayer") + 1));
            }
            else {
                List<Requirement> requirements = new ArrayList<>();
                if (player.getXp().get("Defense") > initialXP.get("Defense")) {
                    requirements.add(new Requirement("Defense", player.getLevel("Defense")));
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
                player.setXp(initialXP);
                return requirements;
            }
        }
        while (player.getLevel("Constitution") < 99 || player.getLevel("Defense") < 99 || player.getLevel("Prayer") < 99);
        player.setXp(initialXP);
        return new ArrayList<>(); //fight is impossble if it reaches this point
    }

    private Map<Integer, List<Requirement>> combatKills(Encounter combatEncounter, Player player, int invenSpaces, String combatStyle, double dropRateOfItem, boolean stackable) {
        Map<String, Double> initialXP = new HashMap<>(player.getXp());
        CombatResults combatResults = combatEncounter.calculateCombat(player, invenSpaces, combatStyle);
        List<Requirement> combatReqs = new ArrayList<>();
        if (combatResults.getHpLost() == 1000000000) {
            combatReqs = getRequirementsForCombat(combatEncounter, player, invenSpaces, combatStyle);
            for (Requirement requirement : combatReqs) {
                player.getXp().put(requirement.getQualifier(), player.getXp().get(requirement.getQualifier()) + player.getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
            }
            combatResults = combatEncounter.calculateCombat(player, invenSpaces, combatStyle);
            if (combatResults.getHpLost() == 1000000000) {
                return Map.of(0, Collections.singletonList(new Requirement("Impossible", 1)));
            }
        }
        int time = TICKS_PER_HOUR;
        double currentHp = player.getLevel("Constitution") * 100;
        int kills = 0;
        int spaceInInv = 28 - invenSpaces;
        double nextDrop = 0;
        while (true) {
            int ticksThisKill = combatResults.getTicksTaken();
            nextDrop += dropRateOfItem;
            if (nextDrop >= 1) {
                ticksThisKill += 5;
                nextDrop -= 1;
            }
            ticksThisKill = Math.max(3, ticksThisKill);
            if (currentHp < combatResults.getHpLost() || spaceInInv == 0) {
                ticksThisKill += 50;
                currentHp = player.getLevel("Constitution") * 100;
                spaceInInv = 28 - invenSpaces;
            }
            if (time > ticksThisKill) {
                kills++;
                time -= ticksThisKill;
                currentHp -= combatResults.getHpLost();
                if (!stackable) {
                    spaceInInv--;
                }
            } else
                break;
        }
        player.setXp(initialXP);
        return Map.of(kills, combatReqs);
    }

    private int logsCut(Player player, int hatchetRank, int perfectRateFactor) {
        return (int)Math.floor(((34 + player.getLevel("Woodcutting") * Math.pow(1.035, hatchetRank)) * 1500) / perfectRateFactor);
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
            actionDatabase.addFlagsToDatabase();
        }
        return actionDatabase;
    }
}