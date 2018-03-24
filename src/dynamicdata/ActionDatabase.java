package dynamicdata;

import staticdata.Enemy;

import java.util.*;

public class ActionDatabase {
    
    private static ActionDatabase actionDatabase;

    private static final int TICKS_PER_HOUR = 6000;
    private List<Action> database = new ArrayList<>();

    private ActionDatabase(Player player) {
        //Placeholder for skills that have not yet been implemented
        database.add(new Action("Quacking", new ArrayList<>(), new HashMap<>(), Map.of("Slayer", 1, "Woodcutting", 1, "Fletching", 1,
            "Construction", 1, "Firemaking", 1, "Invention", 1, "Hunter", 1, "Farming", 1), true, true, false));

        //XP-less gathering
        database.add(new Action("Picking potatoes", new ArrayList<>(), new HashMap<>(), Map.of("Raw potato", 690),
            true, true, false));
        database.add(new Action("Collecting planks", new ArrayList(), new HashMap(), Map.of("Plank", 240), true, true, false));
        database.add(new Action("Buying cleansing crystals", Collections.singletonList(new Requirement("Plague's End", 1)),
            Map.of("Coins", 39600000), Map.of("Cleansing crystal", 360), true, true, false));

        //Agility
        database.add(new Action("Burthorpe Agility Course", new ArrayList<>(), new HashMap<>(), Map.of("Agility", 7580),
            true, true, true));

        database.add(new Action("Gnome Stronghold Agility Course", new ArrayList<>(), new HashMap<>(), Map.of("Agility", 8650),
            true, true, true));

        //Construction
        /*database.add(new Action("Building crude wooden chairs with bronze nails", Collections.singletonList(new Requirement("Parlour", 1)),
            Map.of("Plank", 490, "Bronze nails", 1470), Map.of("Construction", 16170), true, true, false));*/

        //Cooking
        database.add(new Action("Cooking raw beef", new ArrayList<>(),
            Map.of("Raw beef", 1250), Map.of("Cooked meat", (int) Math.floor(1250 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
            "Cooking", (int) Math.floor(37500 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))), true,
            true, true));

        database.add(new Action("Cooking shrimps", new ArrayList<>(), Map.of("Raw shrimps", 1250),
            Map.of("Shrimps", (int) Math.floor(1250 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(37500 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))),
            true, true, true));

        database.add(new Action("Cooking crayfish", new ArrayList<>(), Map.of("Raw crayfish", 1250),
            Map.of("Crayfish", (int) Math.floor(1250 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(37500 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))),
            true, true, true));

        database.add(new Action("Cooking chicken", new ArrayList<>(), Map.of("Raw chicken", 1250),
            Map.of("Cooked chicken", (int) Math.floor(1250 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0)),
                "Cooking", (int) Math.floor(37500 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0))),
            true, true, true));

        //Crafting
        database.add(new Action("Crafting molten glass", new ArrayList<>(), Map.of("Soda ash", 1050, "Bucket of sand", 1050),
            Map.of("Molten glass", 1050, "Crafting", 21000), true, true, false));

        database.add(new Action("Ithell harps (w/o VoS)", Collections.singletonList(new Requirement("Plague's End", 1)), new HashMap(),
            Map.of("Crafting", 560*player.getLevel("Crafting"), "Harmonic dust", 7*player.getLevel("Crafting"), "Construction", 10000),
            true, true, true));

        //Divination
        database.add(new Action("Pale wisps (no bought energy)", new ArrayList<>(), new HashMap<>(),
            Map.of("Divination", 4000, "Pale energy", 1600), true, true, false));

        //Dungeoneering (major approximation)
        int dungXP = (int) Math.floor(4000 * Math.pow((player.getLevel("Dungeoneering") + 9.0) / 10.0, 2));
        database.add(new Action("Solo dungeoneering", new ArrayList(), new HashMap(), Map.of("Dungeoneering", dungXP),
            true, true, false));

        //Fishing
        int shrimpFished = resourcesGained(10, 5.0, player, 50.0, "Fishing");
        database.add(new Action("Fishing raw shrimps", new ArrayList<>(), new HashMap<>(), Map.of("Raw shrimps", shrimpFished, "Fishing", 10 * shrimpFished),
            true, true, true));

        int crayfishFished = resourcesGained(1, 5.0, player, 50.0, "Fishing");
        database.add(new Action("Fishing raw crayfish", new ArrayList<>(), new HashMap<>(), Map.of("Raw crayfish", crayfishFished, "Fishing", 10 * crayfishFished),
            true, true, true));

        //Herblore
        database.add(new Action("Cleaning grimy guams", new ArrayList(), Map.of("Grimy guam", 5090), Map.of("Clean guam", 5090,
            "Herblore", 12725), true, true, false));

        //Mining
        database.add(new Action("Mining and dropping essence", new ArrayList<>(), new HashMap<>(), Map.of("Mining", 26250),
            true, true, false));
        database.add(new Action("Mining pure essence", Collections.singletonList(new Requirement("Mining", 30)), new HashMap(),
            Map.of("Mining", 10220, "Pure essence", 2044), true, true, false));

        int copperMined = resourcesGained(40, 6.0, player, 100.0, "Mining");
        int coalMined = resourcesGained(70, 6.0, player, 30.0, "Mining");
        database.add(new Action("Mining copper ore with bronze pickaxe", new ArrayList(), new HashMap(), Map.of("Copper ore", copperMined,
            "Mining", (int) Math.floor(17.5 * copperMined)), true, true, true));
        database.add(new Action("Mining tin ore with bronze pickaxe", new ArrayList(), new HashMap(), Map.of("Tin ore", copperMined,
            "Mining", (int) Math.floor(17.5 * copperMined)), true, true, true));
        database.add(new Action("Mining coal with bronze pickaxe", Collections.singletonList(new Requirement("Mining", 30)), new HashMap(),
            Map.of("Coal", coalMined, "Mining", 50*coalMined), true, true, true));

        //Prayer
        database.add(new Action("Offering bones to Chaos Altar", new ArrayList<>(), Map.of("Bones", 1400),
            Map.of("Prayer", 22050), true, false, false));
        database.add(new Action("Offering bones to Ectofuntus", new ArrayList(), Map.of("Bones", 390), Map.of("Prayer", 7020, "Ecto-token",
            1890), true, true, false));
        database.add(new Action("Burying bones", new ArrayList<>(), Map.of("Bones", 3600), Map.of("Prayer", 16200),
            true, true, false));

        //Runecrafting
        database.add(new Action("Low-level Runespan (island 1)", new ArrayList(), new HashMap(), Map.of("Runecrafting", 16500),
            true, true, false));

        //Smithing
        database.add(new Action("Smithing bronze bars", new ArrayList(), Map.of("Copper ore", 1050, "Tin ore", 1050),
            Map.of("Bronze bar", 1050, "Smithing", 6510), true, true, false));
        database.add(new Action("Smithing bronze nails", Collections.singletonList(new Requirement("Smithing", 4)),
            Map.of("Bronze bar", 1232), Map.of("Smithing", 15400, "Bronze nails", 18480), true, true, false));

        //Summoning
        database.add(new Action("Making spirit wolf pouches", new ArrayList(), Map.of("Spirit shards", 10500, "Pouch", 1500,
            "Wolf bones", 1500, "Gold charm", 1500), Map.of("Spirit wolf pouch", 1500, "Summoning", 7200),
            true, true, false));

        //Thieving
        int menPocketsPicked = pocketsPicked(1, player);
        database.add(new Action("Pickpocketing men/women", new ArrayList(), new HashMap(), Map.of("Coins", 3 * menPocketsPicked,
            "Thieving", 8 * menPocketsPicked), true, true, true));

        //Combat for drops
        int cowKillsMelee = combatKills(Enemy.COW, player, 0, "Melee", 1, false);
        int cowKillsRanged = combatKills(Enemy.COW, player, 0, "Ranged", 1, false);
        int cowKillsMagic = combatKills(Enemy.COW, player, 0, "Magic", 1, false);
        int cowKillsMeleeGoldCharms = combatKills(Enemy.COW, player, 0, "Melee", 0.008, true);
        int cowKillsRangedGoldCharms = combatKills(Enemy.COW, player, 0, "Ranged", 0.008, true);
        int cowKillsMagicGoldCharms = combatKills(Enemy.COW, player, 0, "Magic", 0.008, true);
        database.add(new Action("Killing cows for raw beef with melee", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw beef", cowKillsMelee, "mCombat", (int) Enemy.COW.getCbxp() * cowKillsMelee, "Constitution", (int) Enemy.COW.getHpxp() * cowKillsMelee),
            true, true, true));
        database.add(new Action("Killing cows for bones with melee", new ArrayList<>(), new HashMap<>(),
            Map.of("Bones", cowKillsMelee, "mCombat", (int) Enemy.COW.getCbxp() * cowKillsMelee, "Constitution", (int) Enemy.COW.getHpxp() * cowKillsMelee),
            true, true, true));
        database.add(new Action("Killing cows for gold charms with melee", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (cowKillsMeleeGoldCharms * 0.008),
            "mCombat", (int) Enemy.COW.getCbxp() * cowKillsMeleeGoldCharms, "Constitution", (int) Enemy.COW.getHpxp() * cowKillsMeleeGoldCharms),
            true, true, true));
        database.add(new Action("Killing cows for raw beef with ranged", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw beef", cowKillsRanged, "rCombat", (int) Enemy.COW.getCbxp() * cowKillsRanged, "Constitution", (int) Enemy.COW.getHpxp() * cowKillsRanged),
            true, true, true));
        database.add(new Action("Killing cows for bones with ranged", new ArrayList<>(), new HashMap<>(),
            Map.of("Bones", cowKillsRanged, "rCombat", (int) Enemy.COW.getCbxp() * cowKillsRanged, "Constitution", (int) Enemy.COW.getHpxp() * cowKillsRanged),
            true, true, true));
        database.add(new Action("Killing cows for gold charms with ranged", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (cowKillsRangedGoldCharms * 0.008),
            "rCombat", (int) Enemy.COW.getCbxp() * cowKillsRangedGoldCharms, "Constitution", (int) Enemy.COW.getHpxp() * cowKillsRangedGoldCharms),
            true, true, true));
        database.add(new Action("Killing cows for raw beef with magic", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw beef", cowKillsMagic, "aCombat", (int) Enemy.COW.getCbxp() * cowKillsMagic, "Constitution", (int) Enemy.COW.getHpxp() * cowKillsMagic),
            true, true, true));
        database.add(new Action("Killing cows for bones with magic", new ArrayList<>(), new HashMap<>(),
            Map.of("Bones", cowKillsMagic, "aCombat", (int) Enemy.COW.getCbxp() * cowKillsMagic, "Constitution", (int) Enemy.COW.getHpxp() * cowKillsMagic),
            true, true, true));
        database.add(new Action("Killing cows for gold charms with magic", new ArrayList(), new HashMap(), Map.of("Gold charm", (int) (cowKillsMagicGoldCharms * 0.008),
            "aCombat", (int) Enemy.COW.getCbxp() * cowKillsMagicGoldCharms, "Constitution", (int) Enemy.COW.getHpxp() * cowKillsMagicGoldCharms),
            true, true, true));

        int chickenKillsMelee = combatKills(Enemy.CHICKEN, player, 0, "Melee", 1, false);
        int chickenKillsRanged = combatKills(Enemy.CHICKEN, player, 0, "Ranged", 1, false);
        int chickenKillsMagic = combatKills(Enemy.CHICKEN, player, 0, "Magic", 1, false);
        database.add(new Action("Killing chickens for raw chicken with melee", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw chicken", chickenKillsMelee, "mCombat", (int) Enemy.CHICKEN.getCbxp() * chickenKillsMelee, "Constitution",
                (int) Enemy.CHICKEN.getHpxp() * chickenKillsMelee), true, true, true));
        database.add(new Action("Killing chickens for raw chicken with ranged", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw chicken", chickenKillsRanged, "rCombat", (int) Enemy.CHICKEN.getCbxp() * chickenKillsRanged, "Constitution",
                (int) Enemy.CHICKEN.getHpxp() * chickenKillsRanged), true, true, true));
        database.add(new Action("Killing chickens for raw chicken with magic", new ArrayList<>(), new HashMap<>(),
            Map.of("Raw chicken", chickenKillsMagic, "aCombat", (int) Enemy.CHICKEN.getCbxp() * chickenKillsMagic, "Constitution",
                (int) Enemy.CHICKEN.getHpxp() * chickenKillsMagic), true, true, true));

        //Other repeatables
        database.add(new Action("Completing Shifting Tombs", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 50), new Requirement("The Jack of Spades", 1)),
            new HashMap<>(), Map.of("Shifting Tombs", 12), true, true, true));
    }

    public List<Action> getDatabase() {
        return database;
    }

    public int combatKills(Enemy enemy, Player player, int invenSpaces, String combatStyle, double dropRateOfItem, boolean stackable) {
        CombatResults combatResults = new Encounter(Collections.singletonList(Collections.singletonList(enemy)), new ArrayList<>()).calculateCombat(player, invenSpaces, combatStyle);
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