package data.databases;

import logic.*;
import data.dataobjects.Enemy;
import data.dataobjects.Action;

import java.util.*;

public class ActionDatabase {
    
    private static ActionDatabase actionDatabase;

    private static final int TICKS_PER_HOUR = 6000;
    private List<Action> database = new ArrayList<>();

    private ActionDatabase(Player player) {
        //Placeholder for skills that have not yet been implemented
        database.add(new Action("Quacking", new ArrayList<>(), new HashMap<>(), Map.of("Slayer", 1, "Invention", 1), true, true));

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
            Map.of("Supplies", 300), Map.of("Taijitu", 26, "Sea shell", 9, "Driftwood", 9, "Sea salt", 9, "Bamboo", 9, "Shell chippings", 9,
            "Spirit dragon charm", 9), true, true));
        database.add(new Action("Winning Castle Wars games", new ArrayList(), new HashMap(), Map.of("Gold Castle Wars ticket", 6), true,
            true));

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

        //Crafting
        database.add(new Action("Crafting molten glass", new ArrayList<>(), Map.of("Soda ash", 1050, "Bucket of sand", 1050),
            Map.of("Molten glass", 1050, "Crafting", 21000), true, true));

        database.add(new Action("Ithell harps (w/o VoS)", Collections.singletonList(new Requirement("Plague's End", 1)), new HashMap(),
            Map.of("Crafting", 560*player.getLevel("Crafting"), "Harmonic dust", 7*player.getLevel("Crafting"), "Construction", 10000),
            true, true));

        //Divination
        database.add(new Action("Pale wisps (no bought energy)", new ArrayList<>(), new HashMap<>(),
            Map.of("Divination", 4000, "Pale energy", 1600), true, true));

        //Dungeoneering (major approximation, assumes 7.5 minute floors)
        int dungXP = (int) Math.floor(4000 * Math.pow((player.getLevel("Dungeoneering") + 9.0) / 10.0, 2));
        database.add(new Action("Solo dungeoneering", new ArrayList(), new HashMap(), Map.of("Dungeoneering", dungXP, "Dungeoneering token",
            dungXP/10, "Dungeoneering floors completed", 8), true, true));

        //Farming
        database.add(new Action("Foraging rumberries (keep)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Rumberry", 300, "Rumberry seed", 6),
            true, true));

        database.add(new Action("Foraging rumberries (sell)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), Map.of("Farming", 30000, "Chimes", 618), true, true));

        //Firemaking
        database.add(new Action("Burning normal logs on bonfire", new ArrayList(), Map.of("Logs", 950), Map.of("Firemaking", 49500), true,
            true));

        //Fishing
        int shrimpFished = resourcesGained(10, 5.0, player, 50.0, "Fishing");
        database.add(new Action("Fishing raw shrimps", new ArrayList<>(), new HashMap<>(), Map.of("Raw shrimps", shrimpFished, "Fishing", 10 * shrimpFished),
            true, true));

        int crayfishFished = resourcesGained(1, 5.0, player, 50.0, "Fishing");
        database.add(new Action("Fishing raw crayfish", new ArrayList<>(), new HashMap<>(), Map.of("Raw crayfish", crayfishFished, "Fishing", 10 * crayfishFished),
            true, true));

        //Farming
        database.add(new Action("Farming potatoes", new ArrayList(), Map.of("Potato seed", 270), Map.of("Raw potato", 675, "Farming", 6795),
            true, true));

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

        //Mining
        database.add(new Action("Mining and dropping essence", new ArrayList<>(), new HashMap<>(), Map.of("Mining", 26250),
            true, true));
        database.add(new Action("Mining pure essence", Collections.singletonList(new Requirement("Mining", 30)), new HashMap(),
            Map.of("Mining", 10220, "Pure essence", 2044), true, true));

        int copperMined = resourcesGained(40, 6.0, player, 100.0, "Mining");
        int coalMined = resourcesGained(70, 6.0, player, 30.0, "Mining");
        database.add(new Action("Mining copper ore with bronze pickaxe", new ArrayList(), new HashMap(), Map.of("Copper ore", copperMined,
            "Mining", (int) Math.floor(17.5 * copperMined)), true, true));
        database.add(new Action("Mining tin ore with bronze pickaxe", new ArrayList(), new HashMap(), Map.of("Tin ore", copperMined,
            "Mining", (int) Math.floor(17.5 * copperMined)), true, true));
        database.add(new Action("Mining coal with bronze pickaxe", Collections.singletonList(new Requirement("Mining", 30)), new HashMap(),
            Map.of("Coal", coalMined, "Mining", 50*coalMined), true, true));

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
        int menPocketsPicked = pocketsPicked(1, player);
        database.add(new Action("Pickpocketing men/women", new ArrayList(), new HashMap(), Map.of("Coins", 3 * menPocketsPicked,
            "Thieving", 8 * menPocketsPicked), true, true));

        //Woodcutting
        int logsCut = resourcesGained(40, 4.0, player, 75.0, "Woodcutting");
        database.add(new Action("Cutting regular trees with bronze hatchet", new ArrayList(), new HashMap(), Map.of("Logs", logsCut, "Woodcutting",
            logsCut*25), true, true));

        //Multi-skill
        database.add(new Action("Cremating vyre corpses", Arrays.asList(new Requirement("Legacy of Seergaze", 1),
            new Requirement("Firemaking", 40)), Map.of("Vyre corpse", 500, "Teak pyre logs", 500), Map.of("Firemaking", 60000,
            "Prayer", 39350, "Vyre corpses burned", 500, "Columbarium key", 500), true, true));
        database.add(new Action("Cremating loar shades", Arrays.asList(new Requirement("Shades of Mort'ton", 1),
            new Requirement("Firemaking", 40)), Map.of("Loar remains", 500, "Pyre logs", 500), Map.of("Firemaking", 25000,
            "Prayer", 12500, "Coins", 100000, "Shade key", 250), true, true));

        //Combat for drops
        int cowKillsMelee = combatKills("Cow",  new ArrayList<>(), player, 0, "Melee", 1, false);
        int cowKillsRanged = combatKills("Cow",  new ArrayList<>(), player, 0, "Ranged", 1, false);
        int cowKillsMagic = combatKills("Cow",  new ArrayList<>(), player, 0, "Magic", 1, false);
        int cowKillsMeleeGoldCharms = combatKills("Cow", new ArrayList<>(), player, 0, "Melee", 0.008, true);
        int cowKillsRangedGoldCharms = combatKills("Cow", new ArrayList<>(), player, 0, "Ranged", 0.008, true);
        int cowKillsMagicGoldCharms = combatKills("Cow", new ArrayList<>(), player, 0, "Magic", 0.008, true);
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

        int chickenKillsMelee = combatKills("Chicken", new ArrayList<>(), player, 0, "Melee", 1, false);
        int chickenKillsRanged = combatKills("Chicken",  new ArrayList<>(), player, 0, "Ranged", 1, false);
        int chickenKillsMagic = combatKills("Chicken", new ArrayList<>(), player, 0, "Magic", 1, false);
        database.add(new Action("Killing chickens for raw chicken with melee", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw chicken", chickenKillsMelee, "mCombat", (int) Enemy.getEnemyByName("Chicken").getCbxp() * chickenKillsMelee, "Constitution",
                (int) Enemy.getEnemyByName("Chicken").getHpxp() * chickenKillsMelee), true, true));
        database.add(new Action("Killing chickens for raw chicken with ranged", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw chicken", chickenKillsRanged, "rCombat", (int) Enemy.getEnemyByName("Chicken").getCbxp() * chickenKillsRanged, "Constitution",
                (int) Enemy.getEnemyByName("Chicken").getHpxp() * chickenKillsRanged), true, true));
        database.add(new Action("Killing chickens for raw chicken with magic", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw chicken", chickenKillsMagic, "aCombat", (int) Enemy.getEnemyByName("Chicken").getCbxp() * chickenKillsMagic, "Constitution",
                (int) Enemy.getEnemyByName("Chicken").getHpxp() * chickenKillsMagic), true, true));

        int gelatinousAbominationKillsMelee = combatKills("Gelatinous abomination", new ArrayList<>(), player, 0, "Melee", 0.4, true);
        int gelatinousAbominationKillsRanged = combatKills("Gelatinous abomination",  new ArrayList<>(), player, 0, "Ranged", 0.4, true);
        int gelatinousAbominationKillsMagic = combatKills("Gelatinous abomination", new ArrayList<>(), player, 0, "Magic", 0.4, true);
        database.add(new Action("Killing gelatinous abominations for gold charms with melee", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (gelatinousAbominationKillsMelee * 0.4),
            "mCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() * gelatinousAbominationKillsMelee, "Constitution",
            (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() * gelatinousAbominationKillsMelee), true, true));
        database.add(new Action("Killing gelatinous abominations for gold charms with ranged", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (gelatinousAbominationKillsRanged * 0.4),
            "rCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() * gelatinousAbominationKillsRanged, "Constitution",
            (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() * gelatinousAbominationKillsRanged), true, true));
        database.add(new Action("Killing gelatinous abominations for gold charms with magic", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (gelatinousAbominationKillsMagic * 0.4),
            "aCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() * gelatinousAbominationKillsMagic, "Constitution",
            (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() * gelatinousAbominationKillsMagic), true, true));

        int vyreKills = combatKills("Vyrewatch", Collections.singletonList(new Restriction("Vampyric weapon", 1)), player, 0, "Melee", 1, false);
        database.add(new Action("Killing vyres for corpses", Collections.singletonList(new Requirement("Legacy of Seergaze", 1)), new HashMap(),
            Map.of("Vyre corpse", vyreKills, "mCombat", (int)Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills, "Constitution",
                (int) Enemy.getEnemyByName("Vyrewatch").getHpxp() * vyreKills), true, true));

        //Bossing
        int kbdKills = combatKills("King Black Dragon", Collections.singletonList(new Restriction("Dragonfire protection", 1)), player, 28, "Melee", 0, false);
        database.add(new Action("Killing the King Black Dragon", new ArrayList(), new HashMap(), Map.of("King Black Dragon", kbdKills,
            "mCombat", (int)Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills, "Constitution",
            (int)Enemy.getEnemyByName("King Black Dragon").getHpxp() * kbdKills), true, true));

        int qbdKills = combatKills("Queen Black Dragon", Collections.singletonList(new Restriction("Dragonfire protection", 1)), player, 28, "Melee", 0, false);
        database.add(new Action("Killing the Queen Black Dragon", Collections.singletonList(new Requirement("Summoning", 60)), new HashMap(),
            Map.of("Queen Black Dragon", qbdKills, "mCombat", (int)Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills, "Constitution",
            (int)Enemy.getEnemyByName("Queen Black Dragon").getHpxp() * qbdKills), true, true));

        //Other repeatables
        database.add(new Action("Completing Shifting Tombs", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 50), new Requirement("The Jack of Spades", 1)),
            new HashMap<>(), Map.of("Shifting Tombs", 12), true, true));
    }

    public List<Action> getDatabase() {
        return database;
    }

    public int combatKills(String enemyName, List<Restriction> restrictions, Player player, int invenSpaces, String combatStyle, double dropRateOfItem, boolean stackable) {
        CombatResults combatResults = new Encounter(enemyName, restrictions).calculateCombat(player, invenSpaces, combatStyle);
        if (combatResults.getHpLost() == 1000000000) {
            return 0;
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
        return kills;
    }

    public int resourcesGained(int levelAtMaxRate, double minTicks, Player player, double ticksToBank, String skill) {
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
            } else
                break;
        }
        return resources;
    }

    public int pocketsPicked(int effectiveLevel, Player player) {
        int playerLevel = player.getLevel("Thieving");
        double successRate = Math.min(1.0, (145.0 + (playerLevel - effectiveLevel)) / 255.0);
        double timePerSuccess = (2 * successRate + 8 * (1 - successRate)) / successRate;
        return (int) Math.floor(TICKS_PER_HOUR / timePerSuccess);
    }

    public static ActionDatabase getActionDatabase(Player player) {
        if (actionDatabase == null) {
            actionDatabase = new ActionDatabase(player);
        }
        return actionDatabase;
    }
}