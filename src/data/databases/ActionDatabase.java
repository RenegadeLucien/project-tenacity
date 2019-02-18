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
            ImmutableMap.of("Port distance", 24000, "Port chimes", 10000, "Port slate", 3000), 20, true, true));
        database.add(new Action("POP - Scythe region voyages", Collections.singletonList(new Requirement("Port distance", 140000)), new HashMap(),
            ImmutableMap.of("Port distance", 48000, "Port chimes", 13000, "Port cherrywood", 4000), 20, true, true));
        database.add(new Action("POP - Bowl region voyages", Collections.singletonList(new Requirement("Port distance", 450000)), new HashMap(),
            ImmutableMap.of("Port distance", 96000, "Port chimes", 20000, "Port jade", 7200), 20, true, true));

        //Gathering (low or no XP)
        database.add(new Action("Picking potatoes", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Raw potato", 690), 690, true, true));
        database.add(new Action("Voyaging for items", Collections.singletonList(new Requirement("Impressing the Locals", 1)),
            ImmutableMap.of("Supplies", 300), ImmutableMap.builder().put("Taijitu", 26).put("Sea shell", 9).put("Driftwood", 9).put("Sea salt", 9)
            .put("Bamboo", 9).put("Shell chippings", 9).put("Spirit dragon charm", 9).put("Raw tarpon", 9).put("Bundle of bamboo", 9)
            .put("Fish oil", 9).put("Stoneberry seed", 1).put("Stormberry seed", 1).put("Uncharted Isles visited", 60).build(), 60, true, true));
        database.add(new Action("Winning Castle Wars games", new ArrayList(), new HashMap(), ImmutableMap.of("Gold Castle Wars ticket", 6), 3, true, true));
        database.add(new Action("Winning Soul Wars games", new ArrayList(), new HashMap(), ImmutableMap.of("Zeal", 9), 3, true, true));
        database.add(new Action("Playing Barbarian Assault", new ArrayList(), new HashMap(), ImmutableMap.of("Honour Points", 1000), 25, true, true));
        database.add(new Action("Opening prawn balls", new ArrayList(), ImmutableMap.of("Prawn balls", 3000), ImmutableMap.of("Golden fish egg", 15), 3000, true, true));
        database.add(new Action("Picking bananas", new ArrayList(), ImmutableMap.of("Basket", 552), ImmutableMap.of("Bananas (5)", 552, "Banana", 120), 552, true, true));
        database.add(new Action("Casting egg spawn", Collections.singletonList(new Requirement("Summoning", 10)), ImmutableMap.of("Egg spawn scroll", 520, "Spirit spider pouch", 4,
            "Summoning potion (4)", 18), ImmutableMap.of("Red spiders' eggs", 936, "Summoning", 105), 520, true, true));
        database.add(new Action("Managing Miscellania (Woodcutting)", Collections.singletonList(new Requirement("Throne of Miscellania", 1)), ImmutableMap.of("Coins", 1000000),
            ImmutableMap.of("Maple logs", 17840, "Bird's nest", 160), 20, true, true));

        //Agility (WHEN ADDING TO THIS, UPDATE PET)
        database.add(new Action("Burthorpe Agility Course", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Agility", 11955), 150, true, true));
        database.add(new Action("Gnome Stronghold Agility Course", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Agility", 8650), 100, true, true));
        database.add(new Action("Agility Pyramid", Collections.singletonList(new Requirement("Agility", 30)), ImmutableMap.of("Waterskin (4)", 10),
            ImmutableMap.of("Waterskin (0)", 10, "Agility", 26708, "Pyramid top", 22), 22, true, true));
        database.add(new Action("Brimhaven Agility Arena", Collections.singletonList(new Requirement("Agility", 40)), ImmutableMap.of("Coins", 200),
            ImmutableMap.of("Agility arena ticket", 60, "Agility", 3000), 60, true, true));
        database.add(new Action("Empty Throne Room agility", Arrays.asList(new Requirement("Agility", 65), new Requirement("The Dig Site", 1)),
            new HashMap(), ImmutableMap.of("Agility", 68760, "Senntisten scroll", 17), 1800, true, true));
        database.add(new Action("Hefin Agility Course (77-81 Agility)", Arrays.asList(new Requirement("Plague's End", 1),
            new Requirement("Agility", 77)), new HashMap(), ImmutableMap.of("Agility", 56320, "Hefin Agility Course laps", 80), 80, true, true));
        database.add(new Action("Advanced Gnome Stronghold Agility Course", Collections.singletonList(new Requirement("Agility", 85)),
            new HashMap(), ImmutableMap.of("Agility", 68150, "Advanced Gnome Stronghold laps", 94), 34, true, true));
        database.add(new Action("Advanced Barbarian Outpost Agility Course", Arrays.asList(new Requirement("Bar Crawl", 1),
            new Requirement("Agility", 90)), new HashMap(), ImmutableMap.of("Agility", 72355, "Advanced Barbarian Outpost laps", 96), 96, true, true));


        //Construction
        database.add(new Action("Building crude wooden chairs with bronze nails", new ArrayList(), ImmutableMap.of("Plank", 490, "Bronze nails", 1470),
            ImmutableMap.of("Construction", 16170), 490, true, true));

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
            ImmutableMap.of("Uncooked arc gumbo", 1300), ImmutableMap.of("Arc gumbo", 1300, "Cooking", 169000, "Cooking pet points", totalPetPoints(player, "Cooking", 169000), "Azure Parrot", 21), 1300, true, true));

        //Crafting (done to lv3)
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
                "Crafting pet points", totalPetPoints(player, "Crafting", 560*player.getLevel("Crafting"))), 7*player.getLevel("Crafting"), true, true));

        database.add(new Action("Making tortle shell bowls", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Crafting", 91)),
            ImmutableMap.of("Shell chippings", 6800), ImmutableMap.of("Tortle shell bowl", 1700, "Crafting", 127500, "Crafting pet points", totalPetPoints(player, "Crafting", 127500)), 1700, true, true));

        //Divination (1300 harvests, 900 + enr conversions) (done to lv9)
        database.add(new Action("Pale wisps (no bought energy)", new ArrayList<>(), new HashMap<>(),
            ImmutableMap.of("Divination", 4000, "Pale energy", 1300), 1300, true, true));

        database.add(new Action("Pale wisps (with bought energy)", new ArrayList<>(), ImmutableMap.of("Pale energy", 3200),
            ImmutableMap.of("Divination", 4630), 1300, true, true));

        database.add(new Action("Cursed wisps (level 1-9)", new ArrayList(), new HashMap<>(), ImmutableMap.of("Divination", 6850, "Pale energy", 1950), 1300, true, false));

        database.add(new Action("Luminous wisps (no bought energy)", Collections.singletonList(new Requirement("Divination", 90)),
            new HashMap(), ImmutableMap.of("Divination", 71000, "Luminous energy", 1600, "Fly dragon", 1, "Fruit fly", 1), 1300, true, true));
        database.add(new Action("Positive springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 90)), new HashMap(), ImmutableMap.of("Divination", 60300, "Positive energy", 600), 600, true, true));
        database.add(new Action("Ancestral springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 95)), new HashMap(), ImmutableMap.of("Divination", 96300, "Ancestral energy", 600, "Cyansoul Kakapo", 1), 600, true, true));

        //Dungeoneering (major approximation, assumes 7.5 minute floors)
        int dungXP = (int) Math.floor(4000 * Math.pow((player.getLevel("Dungeoneering") + 9.0) / 10.0, 2));
        database.add(new Action("Solo dungeoneering", new ArrayList(), new HashMap(), ImmutableMap.of("Dungeoneering", dungXP, "Dungeoneering token",
            dungXP/10, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", dungXP), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Solo dungeoneering (incl. fragments)", Collections.singletonList(new Requirement("Dungeoneering", 70)), new HashMap(),
            ImmutableMap.of("Dungeoneering", dungXP+1, "Dungeoneering token", dungXP/10, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", dungXP),
                "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800), 8, true, true));
        database.add(new Action("Solo dungeoneering (incl. unreadable pages)", Collections.singletonList(new Requirement("Plague's End", 1)),
            new HashMap(), ImmutableMap.builder().put("Dungeoneering", dungXP+2).put("Dungeoneering token", dungXP/10).put("Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", dungXP))
            .put("Dungeoneering floors completed", 8).put("Dungeoneering fragment", 800).put("Unreadable page points", (int)Math.floor(135305*Math.pow(1.0313, player.getLevel("Dungeoneering")-75)))
            .build(), 8, true, true));

        //Farming
        database.add(new Action("Farming potatoes (w/o payments)", new ArrayList(), ImmutableMap.of("Potato seed", 162, "Supercompost", 54), ImmutableMap.of("Raw potato", 464, "Farming", 5758), 6, true, true));
        database.add(new Action("Farming potatoes (w/ payments)", new ArrayList(), ImmutableMap.of("Potato seed", 162, "Supercompost", 54, "Compost", 60), ImmutableMap.of("Raw potato", 540, "Farming", 6696), 6, true, true));

        database.add(new Action("Foraging rumberries (keep)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), ImmutableMap.of("Farming", 30000, "Rumberry", 300, "Rumberry seed", 6, "Pumpkin Limpkin", 1),
            300, true, true));

        database.add(new Action("Foraging rumberries (sell)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), ImmutableMap.of("Farming", 30000, "Chimes", 618), 300, true, true));

        database.add(new Action("Foraging exuberries (keep)", Arrays.asList(new Requirement("Farming", 86),
            new Requirement("Impressing the Locals", 1)), new HashMap(), ImmutableMap.of("Farming", 30000, "Exuberry", 300, "Exuberry seed", 6),
            300, true, true));

        database.add(new Action("Foraging mushrooms on named islands", Arrays.asList(new Requirement("Farming", 90),
            new Requirement("Impressing the Locals", 1)), new HashMap(), ImmutableMap.of("Farming", 30000, "Named mushrooms", 10), 300, true, true));

        database.add(new Action("Foraging mushrooms on Uncharted Isles", Arrays.asList(new Requirement("Farming", 94),
            new Requirement("Impressing the Locals", 1)), ImmutableMap.of("Supplies", 60), ImmutableMap.of("Farming", 50000, "Uncharted mushrooms", 7), 1200, true, true));

        //Firemaking
        database.add(new Action("Burning normal logs on bonfire", new ArrayList(), ImmutableMap.of("Logs", 950), ImmutableMap.of("Firemaking", 47500), 950, true, true));
        database.add(new Action("Burning normal logs in lines", new ArrayList(), ImmutableMap.of("Logs", 1200), ImmutableMap.of("Firemaking", 48000), 1200, true, true));
        database.add(new Action("Burning acadia logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 46)), ImmutableMap.of("Acadia logs", 950),
            ImmutableMap.of("Firemaking", 171000, "Menaphite honey bee", 1, "Fruit fly in amber", 1), 950, true, true));

        //Fishinng
        database.add(new Action("Fishing raw crayfish", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Fishing", 10 * fishCaught(player, 1), "Prawn balls", fishCaught(player, 1)/175),
            fishCaught(player, 1), true, true));

        database.add(new Action("Fishing/dropping desert sole", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Fishing", 52)),
            new HashMap(), ImmutableMap.of("Fishing", 60 * resourcesGained(70, 5.0, player, 0.0, "Fishing"), "Menaphos reputation",
            3 * resourcesGained(70, 5.0, player, 0.0, "Fishing"), "Prawn balls", 1450*resourcesGained(70, 5.0, player, 0.0, "Fishing")/35000,
            "Clicker kalphite in amber", 1, "Desert locust in amber", 1), resourcesGained(70, 5.0, player, 0.0, "Fishing"), true, true));

        database.add(new Action("Barbarian fly fishing", Arrays.asList(new Requirement("Fishing", 70), new Requirement("Strength", 45), new Requirement("Agility", 45),
            new Requirement("Barbarian Fishing", 1)), new HashMap<>(), ImmutableMap.of("Fishing", 62 * (650+5*player.getLevel("Fishing")), "Strength", (int)Math.floor(4.9 * (650+5*player.getLevel("Fishing"))),
            "Agility", (int)Math.floor(4.9 * (650+5*player.getLevel("Fishing"))), "Shark fragment", 1200), (650+5*player.getLevel("Fishing")), true, true));

        //Fletching
        database.add(new Action("Fletching arrow shafts with normal logs", new ArrayList(), ImmutableMap.of("Logs", 1800), ImmutableMap.of("Arrow shaft", 27000,
            "Fletching", 9000), 1800, true, true));

        //Herblore
        database.add(new Action("Cleaning grimy guams", new ArrayList(), ImmutableMap.of("Grimy guam", 5090), ImmutableMap.of("Clean guam", 5090,
            "Herblore", 12725), 5090, true, true));

        //Hunter (done to lv20)
        database.add(new Action("Feeding ogleroots to rabbits", new ArrayList(), ImmutableMap.of("Coins", 3000), ImmutableMap.of("Hunter", 9000), 300, true, true));
        database.add(new Action("Catching charm sprites", Collections.singletonList(new Requirement("Hunter", 72)), new HashMap(),
            ImmutableMap.builder().put("Hunter", 60000).put("Crimson charm", 40).put("Blue charm", 28).put("Green charm", 17).put("Gold charm", 6).put("Charm sprites", 435).build(), 435, true, true));
        database.add(new Action("Catching plover birds", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Hunter", 73)),
            ImmutableMap.of("Logs", 200), ImmutableMap.of("Plover bird", 68+player.getLevel("Hunter"), "Hunter", 510*(68+player.getLevel("Hunter")),
            "Menaphos reputaton", 30*(68+player.getLevel("Hunter")), "Pygmy giant scarab", 1, "Clicker kalphite", 1), 68+player.getLevel("Hunter"), true, true));
        database.add(new Action("Hunting tortles", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Hunter", 90)),
            new HashMap(), ImmutableMap.of("Hunter", 258000, "Tortoiseshell Plover", 2, "Shell chippings", 400), 400, true, true));

        //Invention
        database.add(new Action("Disassembling lantern lenses", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Lantern lens", 2800), ImmutableMap.builder().put("Invention", 3920).put("Clear parts", 1056).put("Delicate parts", 965)
            .put("Smooth parts", 905).put("Enhancing components", 90).put("Junk", 2581).build(), 2800, true, true));
        database.add(new Action("Disassembling harralander tar", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Harralander tar", 2800), ImmutableMap.of("Invention", 5880, "Simple parts", 2134, "Variable components", 21,
            "Junk", 644), 2800, true, true));
        database.add(new Action("Disassembling super runecrafting (4)", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Super runecrafting (4)", 2800), ImmutableMap.builder().put("Invention", 6160).put("Delicate parts", 3755).put("Organic parts", 3326)
            .put("Crafted parts", 3218).put("Enhancing components", 321).put("Healthy components", 107).put("Junk", 470).build(), 2800, true, true));
        database.add(new Action("Disassembling rune bull rush scrolls", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Rune bull rush scroll", 28000), ImmutableMap.of("Invention", 7000, "Spiritual parts", 3333,
            "Crafted parts", 2055, "Powerful components", 166, "Junk", 44), 2800, true, true));
        database.add(new Action("Disassembling portents of restoration IX", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Portent of restoration IX", 2800), ImmutableMap.of("Invention", 7000, "Magic parts", 7082,
            "Crafted parts", 1083, "Ethereal components", 166, "Junk", 67), 2800, true, true));
        database.add(new Action("Disassembling tortured souls", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Tortured soul", 2800), ImmutableMap.of("Invention", 7560, "Organic parts", 2744, "Pious components", 56), 2800, true, true));
        database.add(new Action("Disassembling wishing well bush seeds", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Wishing well bush seed", 2800), ImmutableMap.of("Invention", 7840, "Organic parts", 2772, "Living components", 28),
            2800, true, true));
        database.add(new Action("Disassembling black 2h swords", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Black 2h sword", 2800), ImmutableMap.builder().put("Invention", 21000).put("Knightly components", 2800).put("Base parts", 3234)
            .put("Blade parts", 2772).put("Metallic parts", 2772).put("Sharp components", 277).put("Strong components", 184).put("Junk", 24360).build(), 2800, true, true));
        database.add(new Action("Disassembling carapace boots", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Carapace boots", 2800), ImmutableMap.builder().put("Invention", 25200).put("Cover parts", 1293).put("Tensile parts", 1108)
            .put("Padded parts", 1108).put("Evasive components", 110).put("Protective components", 73).put("Junk", 7504).build(), 2800, true, true));
        database.add(new Action("Disassembling Slayer's staves", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Slayer's staff", 2800), ImmutableMap.builder().put("Invention", 46200).put("Stave parts", 7114).put("Magic parts", 6098)
            .put("Padded parts", 6098).put("Powerful components", 609).put("Imbued components", 406).put("Junk", 13272).build(), 2800, true, true));
        database.add(new Action("Disassembling red salamanders", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Red salamander", 2800), ImmutableMap.builder().put("Invention", 50400).put("Connector parts", 7761).put("Tensile parts", 6652)
            .put("Crafted parts", 6652).put("Stunning components", 665).put("Dextrous components", 443).put("Junk", 11424).build(), 2800, true, true));

        //Combat (the combat encounters expected to be used for combat training)
        Map<Integer, List<Requirement>> trollBruteKills = combatKills(new Encounter("Troll brute"), player, 0, "Magic", 0, false);
        database.add(new Action("Killing troll brutes", trollBruteKills.values().iterator().next(), new HashMap(), ImmutableMap.of("aCombat", (int)Enemy.getEnemyByName("Troll brute").getCbxp()
                * trollBruteKills.keySet().iterator().next(), "Constitution", (int) Enemy.getEnemyByName("Troll brute").getHpxp() * trollBruteKills.keySet().iterator().next(),
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Troll brute").getHpxp() * trollBruteKills.keySet().iterator().next())),
            trollBruteKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> trollChuckerKillsAndReqs = combatKills(new Encounter("Troll chucker"), player, 0, "Melee", 0, false);
        int trollChuckerKills = trollChuckerKillsAndReqs.keySet().iterator().next();
        List<Requirement> trollChuckerReqs = trollChuckerKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing troll chuckers", trollChuckerReqs, new HashMap(), ImmutableMap.of("mCombat", (int)Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills,
            "Constitution", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getHpxp() * trollChuckerKills),
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getHpxp() * trollChuckerKills))), trollChuckerKills, true, true));

        Map<Integer, List<Requirement>> trollShamanKillsAndReqs = combatKills(new Encounter("Troll shaman"), player, 0, "Ranged", 0, false);
        int trollShamanKills = trollShamanKillsAndReqs.keySet().iterator().next();
        List<Requirement> trollShamanReqs = trollShamanKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing troll shamans", trollShamanReqs, new HashMap(), ImmutableMap.of("rCombat",
            (int)Enemy.getEnemyByName("Troll shaman").getCbxp() * trollShamanKills, "Ranged pet points",
            (player.getLevel("Ranged")*(int)Enemy.getEnemyByName("Troll shaman").getCbxp() * trollShamanKills)/2,
            "Constitution", (int) Enemy.getEnemyByName("Troll shaman").getHpxp() * trollShamanKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Troll shaman").getHpxp() * trollShamanKills)), trollShamanKills, true, true));


        //Mining
        database.add(new Action("Mining/dropping essence with bronze pickaxe", Collections.singletonList(new Requirement("Bronze pickaxe", 0)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 5, 0, 0, 0.66)), 1500, true, true));

        database.add(new Action("Mining/dropping concentrated sandstone with rune pickaxe", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Mining", 50), new Requirement("Rune pickaxe", 0)), new HashMap(), ImmutableMap.of("Mining", miningXP(player, 50, 75, 75, 0.76),
            "Menaphos reputation", (int)Math.floor(miningXP(player, 50, 75, 75, 0.76)/45.6), "Menaphite honey bee in amber", 1,
            "Pygmy giant scarab in amber", 1), 1500, true, true));

        database.add(new Action("Mining Seren stones with bane pickaxe", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Mining", 89),
            new Requirement("Bane pickaxe", 0)), new HashMap(), ImmutableMap.of("Corrupted ore", miningXP(player, 80, 185, 140, 1.2)/240,
            "Mining", miningXP(player, 80, 185, 140, 1.2)), 1500, true, true));

        database.add(new Action("Mining salty crablets with elder rune pickaxe", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Mining", 90),
            new Requirement("Elder rune pickaxe", 0)),
            new HashMap(), ImmutableMap.of("Sea salt", (int)Math.floor(miningXP(player, 90, 235, 185, 0.82)/393.6), "Mining", miningXP(player, 90, 235, 185, 0.82),
            "Awah Guan", 1), 1500, true, true));

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

        //Runecrafting (done to lv9)
        database.add(new Action("Low-level Runespan (island 1)", new ArrayList(), new HashMap(), ImmutableMap.of("Runecrafting", 16500, "Runespan points", 330), 1500, true, true));

        //Slayer
        database.add(new Action("Slayer tasks from Turael", new ArrayList(), new HashMap(), ImmutableMap.of("Slayer", SlayerMaster.TURAEL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue()),
            6000, true, true));

        database.add(new Action("Slayer tasks from Mazchna", Collections.singletonList(new Requirement("Combat", 20)), new HashMap(),
            ImmutableMap.of("Slayer", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
            "Slayer point", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue(), "Slayer task streak", 1),
            6000, true, true));

        //Smithing (Outdated due to MSRework)
        database.add(new Action("Smithing bronze bars", new ArrayList(), ImmutableMap.of("Copper ore", 1050, "Tin ore", 1050), ImmutableMap.of("Bronze bar", 1050, "Smithing", 6510,
            "Smithing pet points", 6510*player.getLevel("Smithing")), 1050, true, true));
        database.add(new Action("Smithing bronze nails", Collections.singletonList(new Requirement("Smithing", 4)), ImmutableMap.of("Bronze bar", 1232), ImmutableMap.of("Smithing", 15400,
            "Bronze nails", 18480, "Smithing pet points", 15400*player.getLevel("Smithing")), 1232, true, true));

        //Summoning
        database.add(new Action("Making spirit wolf pouches", new ArrayList(), ImmutableMap.of("Spirit shards", 10500, "Pouch", 1500,
            "Wolf bones", 1500, "Gold charm", 1500), ImmutableMap.of("Spirit wolf pouch", 1500, "Summoning", 7200), 1500, true, true));
        database.add(new Action("Making dreadfowl pouches", Collections.singletonList(new Requirement("Summoning", 4)), ImmutableMap.of("Spirit shards", 12000,
            "Pouch", 1500, "Raw chicken", 1500, "Gold charm", 1500), ImmutableMap.of("Dreadfowl pouch", 1500, "Summoning", 13950), 1500, true, true));
        database.add(new Action("Making spirit spider pouches", Collections.singletonList(new Requirement("Summoning", 10)), ImmutableMap.of("Spirit shards", 12000,
            "Pouch", 1500, "Spider carcass", 1500, "Gold charm", 1500), ImmutableMap.of("Spirit spider pouch", 1500, "Summoning", 18900), 1500, true, true));
        database.add(new Action("Making thorny snail pouches", Collections.singletonList(new Requirement("Summoning", 13)), ImmutableMap.of("Spirit shards", 13500,
            "Pouch", 1500, "Thin snail", 1500, "Gold charm", 1500), ImmutableMap.of("Thorny snail pouch", 1500, "Summoning", 18900), 1500, true, true));
        database.add(new Action("Making granite crab pouches", Collections.singletonList(new Requirement("Summoning", 16)), ImmutableMap.of("Spirit shards", 10500,
            "Pouch", 1500, "Iron ore", 1500, "Gold charm", 1500), ImmutableMap.of("Granite crab pouch", 1500, "Summoning", 32400), 1500, true, true));

        //Thieving
        database.add(new Action("Pickpocketing men/women", new ArrayList(), new HashMap(), ImmutableMap.of("Coins", 3 * pocketsPicked(1, player),
            "Thieving", 8 * pocketsPicked(1, player)), pocketsPicked(1, player), true, true));
        database.add(new Action("Bakery stalls", Collections.singletonList(new Requirement("Thieving", 5)), new HashMap(), ImmutableMap.of("Thieving", 10500), 656, true, true));
        database.add(new Action("Menaphos silk stall (drop silk)", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Thieving", 20)),
            new HashMap(), ImmutableMap.of("Thieving", 9600, "Menaphos reputation", 2400, "Fly dragon in amber", 1), 400, true, true));
        database.add(new Action("Pickpocketing Menaphite marketeers", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Thieving", 46)), new HashMap(), ImmutableMap.of("Thieving", (int)(29.5 * pocketsPicked(46, player)), "Menaphos reputation",
            (int)(1.3 * pocketsPicked(46, player)), "Coins", 30*pocketsPicked(46, player), "Kalphite wanderer in amber", 1, "Hornless unicornfly in amber", 1), pocketsPicked(46, player), true, true));
        database.add(new Action("Iorwerth workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 91)), new HashMap(),
            ImmutableMap.of("Thieving", 250000, "Master clue scroll points", 1, "Prifddinian musician's robe pieces", 1), 2000, true, true));

        //Woodcutting
        database.add(new Action("Cutting regular trees with dwarven army axe", new ArrayList(), new HashMap(), ImmutableMap.of("Woodcutting",
            Math.min(1500, itemsReceived(player, 510, 1.0165, "Woodcutting", 1))*28), Math.min(1500, itemsReceived(player, 510, 1.0165, "Woodcutting", 1)), true, true));

        database.add(new Action("Cutting/dropping acadia logs with rune hatchet in VIP skilling area", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Menaphos reputation", 141900), new Requirement("Woodcutting", 47)), new HashMap(), ImmutableMap.of("Woodcutting", 92*itemsReceived(player, 600, 1.01, "Woodcutting", 47),
            "Menaphos reputation", (int)4.5*itemsReceived(player, 600, 1.01, "Woodcutting", 47), "Desert locust", 1, "Hornless unicornfly", 1, "Kalphite wanderer", 1),
            itemsReceived(player, 600, 1.01, "Woodcutting", 47), true, true));

        database.add(new Action("Cutting bamboo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Woodcutting", 90)),
            new HashMap(), ImmutableMap.of("Bamboo", 3*player.getLevel("Woodcutting") + 60, "Woodcutting", (int)202.5*(3*player.getLevel("Woodcutting") + 60), "Great Pecker", 1),
            3*player.getLevel("Woodcutting") + 60, true, true));

        database.add(new Action("Cutting crystal trees with dragon hatchet", Collections.singletonList(new Requirement("Woodcutting", 94)), new HashMap(),
            ImmutableMap.of("Woodcutting", (int)434.5*itemsReceived(player, 180, 1.037, "Woodcutting", 94), "Crystal geode", 10), itemsReceived(player, 180, 1.037, "Woodcutting", 94), true, true));

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
            .put("Produce points", 18960).put("Crafting pet points", totalPetPoints(player, "Crafting", 12960)).build(), 60, true, true));

        //Combat
        Map<Integer, List<Requirement>> gelatinousAbominationKills = combatKills(new Encounter("Gelatinous abomination"), player, 0, "Ranged", 0.4, true);
        database.add(new Action("Killing gelatinous abominations for gold charms with ranged", gelatinousAbominationKills.values().iterator().next(), new HashMap(), ImmutableMap.builder()
        .put("Gold charm", (int) (gelatinousAbominationKills.keySet().iterator().next() * 0.4)).put("rCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() *
                gelatinousAbominationKills.keySet().iterator().next()).put("Constitution", (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() *
                gelatinousAbominationKills.keySet().iterator().next()).put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() *
                gelatinousAbominationKills.keySet().iterator().next())).put("Ranged pet points", ((int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() *
                gelatinousAbominationKills.keySet().iterator().next()*player.getLevel("Ranged"))/2).put("Spirit sapphire", gelatinousAbominationKills.keySet().iterator().next()/400).build(),
            gelatinousAbominationKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> giantRockCrabKillsAndReqs = combatKills(new Encounter("Giant rock crab"), player, 0, "Magic", 0.79, true);
        int giantRockCrabKills = giantRockCrabKillsAndReqs.keySet().iterator().next();
        List<Requirement> giantRockCrabReqs = giantRockCrabKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing giant rock crabs for gold charms with magic", giantRockCrabReqs, new HashMap(), ImmutableMap.of("Gold charm", (int) (giantRockCrabKills * 2.37),
            "aCombat", (int) Enemy.getEnemyByName("Giant rock crab").getCbxp() * giantRockCrabKills, "Constitution",
            (int) Enemy.getEnemyByName("Giant rock crab").getHpxp() * giantRockCrabKills, "Constitution pet points",
            totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Giant rock crab").getHpxp() * giantRockCrabKills)), giantRockCrabKills, true, true));

        Map<Integer, List<Requirement>> tzhaarKetKillsAndReqs = combatKills(new Encounter("TzHaar-Ket"), player, 0, "Magic", 0.2, true);
        int tzhaarKetKills = tzhaarKetKillsAndReqs.keySet().iterator().next();
        List<Requirement> tzhaarKetReqs = tzhaarKetKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing TzHaar-Kets for obsidian charms with magic", tzhaarKetReqs, new HashMap(), ImmutableMap.of("Obsidian charm", (int) (tzhaarKetKills * 2.37),
            "aCombat", (int) Enemy.getEnemyByName("TzHaar-Ket").getCbxp() * tzhaarKetKills, "Constitution",
            (int) Enemy.getEnemyByName("TzHaar-Ket").getHpxp() * tzhaarKetKills, "Constitution pet points",
            totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("TzHaar-Ket").getHpxp() * tzhaarKetKills)), tzhaarKetKills, true, true));

        database.add(new Action("Killing chompy birds", Collections.singletonList(new Requirement("Big Chompy Bird Hunting", 1)), new HashMap(),
            ImmutableMap.of("Chompy kills", 200, "rCombat", 12440, "Ranged pet points", 6220*player.getLevel("Ranged"), "Constitution", 4100), 200, true, true));

        Map<Integer, List<Requirement>> pigKills = combatKills(new Encounter("Pig"), player, 0, "Magic", 0.05, true);
        database.add(new Action("Killing pigs for teeth with magic", pigKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Pack pig tooth",
            (int) (pigKills.keySet().iterator().next() * 0.05), "aCombat", (int) Enemy.getEnemyByName("Pig").getCbxp() * pigKills.keySet().iterator().next(),
            "Constitution", (int) Enemy.getEnemyByName("Pig").getHpxp() * pigKills.keySet().iterator().next(),
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Pig").getHpxp() * pigKills.keySet().iterator().next())),
            pigKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> vyreKillsAndReqs = combatKills(new Encounter("Vyrewatch"), player, 0, "Melee", 1, false);
        int vyreKills = vyreKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> vyreReqs = new ArrayList<>(vyreKillsAndReqs.values().iterator().next());
        vyreReqs.add(new Requirement("Legacy of Seergaze", 1));
        database.add(new Action("Killing vyres for corpses", vyreReqs, new HashMap(),
            ImmutableMap.of("Vyre corpse", vyreKills, "mCombat", (int)Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills, "Constitution",
                (int) Enemy.getEnemyByName("Vyrewatch").getHpxp() * vyreKills, "Constitution pet points",
                totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Vyrewatch").getHpxp() * vyreKills)), vyreKills, true, true));

        Map<Integer, List<Requirement>> truthfulShadowKillsAndReqs = combatKills(new Encounter("Truthful shadow"), player, 0, "Magic", 0.2, false);
        int truthfulShadowKills = truthfulShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> truthfulShadowReqs = new ArrayList<>(truthfulShadowKillsAndReqs.values().iterator().next());
        truthfulShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing truthful shadows for cores", truthfulShadowReqs, new HashMap(),
            ImmutableMap.of("Truthful shadow core", truthfulShadowKills/5, "aCombat", (int)Enemy.getEnemyByName("Truthful shadow").getCbxp() * truthfulShadowKills, "Constitution",
                (int) Enemy.getEnemyByName("Truthful shadow").getHpxp() * truthfulShadowKills, "Constitution pet points",
                totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Truthful shadow").getHpxp() * truthfulShadowKills)), truthfulShadowKills, true, true));

        Map<Integer, List<Requirement>> blissfulShadowKillsAndReqs = combatKills(new Encounter("Blissful shadow"), player, 0, "Magic", 0.2, false);
        int blissfulShadowKills = blissfulShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> blissfulShadowReqs = new ArrayList<>(blissfulShadowKillsAndReqs.values().iterator().next());
        blissfulShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing blissful shadows for cores", blissfulShadowReqs, new HashMap(),
            ImmutableMap.of("Blissful shadow core", blissfulShadowKills/5, "aCombat", (int)Enemy.getEnemyByName("Blissful shadow").getCbxp() * blissfulShadowKills, "Constitution",
                (int) Enemy.getEnemyByName("Blissful shadow").getHpxp() * blissfulShadowKills, "Constitution pet points",
                totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Blissful shadow").getHpxp() * blissfulShadowKills)), blissfulShadowKills, true, true));

        Map<Integer, List<Requirement>> manifestShadowKillsAndReqs = combatKills(new Encounter("Manifest shadow"), player, 0, "Magic", 0.2, false);
        int manifestShadowKills = manifestShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> manifestShadowReqs = new ArrayList<>(manifestShadowKillsAndReqs.values().iterator().next());
        manifestShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing manifest shadows for cores", manifestShadowReqs, new HashMap(),
            ImmutableMap.of("Manifest shadow core", manifestShadowKills/5, "aCombat", (int)Enemy.getEnemyByName("Manifest shadow").getCbxp() * manifestShadowKills, "Constitution",
                (int) Enemy.getEnemyByName("Manifest shadow").getHpxp() * manifestShadowKills, "Constitution pet points",
                totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Manifest shadow").getHpxp() * manifestShadowKills)), manifestShadowKills, true, true));

        Map<Integer, List<Requirement>> crystalShapeshifterKillsAndReqs = combatKills(new Encounter("Crystal shapeshifter"), player, 0, "Melee", 1, false);
        int crystalShapeshifterKills = crystalShapeshifterKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> crystalShapeshifterReqs = new ArrayList<>(crystalShapeshifterKillsAndReqs.values().iterator().next());
        crystalShapeshifterReqs.add(new Requirement("The Light Within", 1));
        database.add(new Action("Killing crystal shapeshifters", crystalShapeshifterReqs, new HashMap(),
            ImmutableMap.of("Crystal shapeshifter", crystalShapeshifterKills, "mCombat", (int)Enemy.getEnemyByName("Crystal shapeshifter").getCbxp() * crystalShapeshifterKills,
                "Constitution", (int) Enemy.getEnemyByName("Crystal shapeshifter").getHpxp() * crystalShapeshifterKills,
                "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Crystal shapeshifter").getHpxp() * crystalShapeshifterKills)),
            crystalShapeshifterKills, true, true));

        Map<Integer, List<Requirement>> airutKillsAndReqs = combatKills(new Encounter("Airut"), player, 0, "Melee", 0, false);
        int airutKills = airutKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> airutReqs = new ArrayList<>(airutKillsAndReqs.values().iterator().next());
        airutReqs.add(new Requirement("Slayer", 92));
        database.add(new Action("Killing airut", airutReqs, new HashMap(), ImmutableMap.of("Airut", airutKills, "mCombat", (int)Enemy.getEnemyByName("Airut").getCbxp() * airutKills,
                "Constitution", (int) Enemy.getEnemyByName("Airut").getHpxp() * airutKills,
                "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Airut").getHpxp() * airutKills)), airutKills, true, true));

        Map<Integer, List<Requirement>> camelWarriorKillsAndReqs = combatKills(new Encounter("Camel warrior"), player, 0, "Melee", 0, false);
        int camelWarriorKills = camelWarriorKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> camelWarriorReqs = new ArrayList<>(camelWarriorKillsAndReqs.values().iterator().next());
        camelWarriorReqs.add(new Requirement("Slayer", 96));
        database.add(new Action("Killing camel warriors", camelWarriorReqs, new HashMap(),
            ImmutableMap.of("Camel warrior", camelWarriorKills, "mCombat", (int)Enemy.getEnemyByName("Camel warrior").getCbxp() * camelWarriorKills,
                "Constitution", (int) Enemy.getEnemyByName("Camel warrior").getHpxp() * camelWarriorKills,
                "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Camel warrior").getHpxp() * camelWarriorKills)), camelWarriorKills, true, true));

        Map<Integer, List<Requirement>> blackKnightKillsAndReqs = combatKills(new Encounter("Black Knight"), player, 0, "Magic", 0, false);
        int blackKnightKills = blackKnightKillsAndReqs.keySet().iterator().next();
        List<Requirement> blackKnightReqs = blackKnightKillsAndReqs.values().iterator().next();
        blackKnightReqs.add(new Requirement("Wanted!", 1));
        database.add(new Action("Killing Black Knights (post-Wanted)", blackKnightReqs, new HashMap(), ImmutableMap.of("Black Knight", blackKnightKills,
            "aCombat", (int)Enemy.getEnemyByName("Black Knight").getCbxp() * blackKnightKills, "Constitution", (int) Enemy.getEnemyByName("Black Knight").getHpxp() * blackKnightKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Black Knight").getHpxp() * blackKnightKills),
            "White Knight rank points", blackKnightKills), blackKnightKills, true, true));

        Map<Integer, List<Requirement>> goblinKillsAndReqs = combatKills(new Encounter("Goblin"), player, 0, "Magic", 0, false);
        int goblinKills = goblinKillsAndReqs.keySet().iterator().next();
        List<Requirement> goblinReqs = goblinKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing goblins", goblinReqs, new HashMap(), ImmutableMap.of("Goblin", goblinKills, "aCombat", (int)Enemy.getEnemyByName("Goblin").getCbxp() * goblinKills,
            "Constitution", (int) Enemy.getEnemyByName("Goblin").getHpxp() * goblinKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Goblin").getHpxp() * goblinKills),
            "Sealed clue scroll (easy)", goblinKills/128), goblinKills, true, true));

        Map<Integer, List<Requirement>> skeletonKillsAndReqs = combatKills(new Encounter("Skeleton"), player, 0, "Magic", 0, false);
        int skeletonKills = skeletonKillsAndReqs.keySet().iterator().next();
        List<Requirement> skeletonReqs = skeletonKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing skeletons", skeletonReqs, new HashMap(), ImmutableMap.of("Skeleton", skeletonKills, "aCombat", (int)Enemy.getEnemyByName("Skeleton").getCbxp() * skeletonKills,
            "Constitution", (int) Enemy.getEnemyByName("Skeleton").getHpxp() * skeletonKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Skeleton").getHpxp() * skeletonKills)), skeletonKills, true, true));

        Map<Integer, List<Requirement>> zombieKillsAndReqs = combatKills(new Encounter("Zombie"), player, 0, "Magic", 0, false);
        int zombieKills = zombieKillsAndReqs.keySet().iterator().next();
        List<Requirement> zombieReqs = zombieKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing zombies", zombieReqs, new HashMap(), ImmutableMap.of("Zombie", zombieKills, "aCombat", (int)Enemy.getEnemyByName("Zombie").getCbxp() * zombieKills,
            "Constitution", (int) Enemy.getEnemyByName("Zombie").getHpxp() * zombieKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Zombie").getHpxp() * zombieKills)), zombieKills, true, true));

        Map<Integer, List<Requirement>> hobgoblinKillsAndReqs = combatKills(new Encounter("Hobgoblin"), player, 0, "Magic", 0, false);
        int hobgoblinKills = hobgoblinKillsAndReqs.keySet().iterator().next();
        List<Requirement> hobgoblinReqs = hobgoblinKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing hobgoblins", hobgoblinReqs, new HashMap(), ImmutableMap.of("Hobgoblin", hobgoblinKills, "aCombat", (int)Enemy.getEnemyByName("Hobgoblin").getCbxp() * hobgoblinKills,
            "Constitution", (int) Enemy.getEnemyByName("Hobgoblin").getHpxp() * hobgoblinKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Hobgoblin").getHpxp() * hobgoblinKills)), hobgoblinKills, true, true));

        Map<Integer, List<Requirement>> hillGiantKillsAndReqs = combatKills(new Encounter("Hill giant"), player, 0, "Magic", 0, false);
        int hillGiantKills = hillGiantKillsAndReqs.keySet().iterator().next();
        List<Requirement> hillGiantReqs = hillGiantKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing hill giants", hillGiantReqs, new HashMap(), ImmutableMap.of("Giant", hillGiantKills, "aCombat", (int)Enemy.getEnemyByName("Hill giant").getCbxp() * hillGiantKills,
            "Constitution", (int) Enemy.getEnemyByName("Hill giant").getHpxp() * hillGiantKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Hill giant").getHpxp() * hillGiantKills)), hillGiantKills, true, true));

        Map<Integer, List<Requirement>> bansheeKillsAndReqs = combatKills(new Encounter("Banshee"), player, 0, "Ranged", 0, false);
        int bansheeKills = bansheeKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> bansheeReqs = new ArrayList<>(bansheeKillsAndReqs.values().iterator().next());
        bansheeReqs.add(new Requirement("Slayer", 15));
        database.add(new Action("Killing banshees", bansheeReqs, new HashMap(), ImmutableMap.of("Banshee", bansheeKills, "rCombat",
            (int)Enemy.getEnemyByName("Banshee").getCbxp() * bansheeKills, "Constitution", (int) Enemy.getEnemyByName("Banshee").getHpxp() * bansheeKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Banshee").getHpxp() * bansheeKills),
            "Ranged pet points", ((int)Enemy.getEnemyByName("Banshee").getCbxp() * bansheeKills * player.getLevel("Ranged"))/2), bansheeKills, true, true));

        Map<Integer, List<Requirement>> ghoulKillsAndReqs = combatKills(new Encounter("Ghoul"), player, 0, "Magic", 0, false);
        int ghoulKills = ghoulKillsAndReqs.keySet().iterator().next();
        List<Requirement> ghoulReqs = ghoulKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing ghouls", ghoulReqs, new HashMap(), ImmutableMap.of("Ghoul", ghoulKills, "aCombat", (int)Enemy.getEnemyByName("Ghoul").getCbxp() * ghoulKills,
            "Constitution", (int) Enemy.getEnemyByName("Ghoul").getHpxp() * ghoulKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Ghoul").getHpxp() * ghoulKills)), ghoulKills, true, true));

        Map<Integer, List<Requirement>> earthWarriorKillsAndReqs = combatKills(new Encounter("Earth warrior"), player, 0, "Magic", 0, false);
        int earthWarriorKills = earthWarriorKillsAndReqs.keySet().iterator().next();
        List<Requirement> earthWarriorReqs = earthWarriorKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing earth warriors", earthWarriorReqs, new HashMap(), ImmutableMap.of("Earth warrior", earthWarriorKills,
            "aCombat", (int)Enemy.getEnemyByName("Earth warrior").getCbxp() * earthWarriorKills, "Constitution", (int) Enemy.getEnemyByName("Earth warrior").getHpxp() * earthWarriorKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Earth warrior").getHpxp() * earthWarriorKills)), earthWarriorKills, true, true));

        Map<Integer, List<Requirement>> aberrantSpectreKillsAndReqs = combatKills(new Encounter("Aberrant spectre"), player, 0, "Ranged", 0, false);
        int aberrantSpectreKills = aberrantSpectreKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> aberrantSpectreReqs = new ArrayList<>(aberrantSpectreKillsAndReqs.values().iterator().next());
        aberrantSpectreReqs.add(new Requirement("Slayer", 60));
        database.add(new Action("Killing aberrant spectres", aberrantSpectreReqs, new HashMap(), ImmutableMap.of("Aberrant spectre", aberrantSpectreKills, "rCombat",
            (int)Enemy.getEnemyByName("Aberrant spectre").getCbxp() * aberrantSpectreKills, "Ranged pet points",
            ((int)Enemy.getEnemyByName("Aberrant spectre").getCbxp() * aberrantSpectreKills * player.getLevel("Ranged"))/2,
            "Constitution", (int) Enemy.getEnemyByName("Aberrant spectre").getHpxp() * aberrantSpectreKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Aberrant spectre").getHpxp() * aberrantSpectreKills)), aberrantSpectreKills, true, true));

        Map<Integer, List<Requirement>> jogreKillsAndReqs = combatKills(new Encounter("Jogre"), player, 0, "Magic", 0, false);
        int jogreKills = jogreKillsAndReqs.keySet().iterator().next();
        List<Requirement> jogreReqs = jogreKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing jogres", jogreReqs, new HashMap(), ImmutableMap.of("Jogre", jogreKills, "aCombat", (int)Enemy.getEnemyByName("Jogre").getCbxp() * jogreKills,
            "Constitution", (int) Enemy.getEnemyByName("Jogre").getHpxp() * jogreKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Jogre").getHpxp() * jogreKills)), jogreKills, true, true));

        Map<Integer, List<Requirement>> adamantDragonKillsAndReqs = combatKills(new Encounter("Adamant dragon"), player, 0, "Magic", 0, false);
        int adamantDragonKills = adamantDragonKillsAndReqs.keySet().iterator().next();
        List<Requirement> adamantDragonReqs = adamantDragonKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing adamant dragons", adamantDragonReqs, new HashMap(), ImmutableMap.of("Adamant dragon", adamantDragonKills, "aCombat",
            (int)Enemy.getEnemyByName("Adamant dragon").getCbxp() * adamantDragonKills, "Constitution",
            (int) Enemy.getEnemyByName("Adamant dragon").getHpxp() * adamantDragonKills, "Constitution pet points",
            totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Adamant dragon").getHpxp() * adamantDragonKills)), adamantDragonKills, true, true));

        Map<Integer, List<Requirement>> mummyKillsAndReqs = combatKills(new Encounter("Mummy"), player, 0, "Magic", 0, false);
        int mummyKills = mummyKillsAndReqs.keySet().iterator().next();
        List<Requirement> mummyReqs = mummyKillsAndReqs.values().iterator().next();
        mummyReqs.add(new Requirement("Dealing with Scabaras", 1));
        database.add(new Action("Killing mummies (post-Dealing With Scabaras)", mummyReqs, new HashMap(), ImmutableMap.of("Mummy", mummyKills,
            "aCombat", (int)Enemy.getEnemyByName("Mummy").getCbxp() * mummyKills, "Constitution", (int) Enemy.getEnemyByName("Mummy").getHpxp() * mummyKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Mummy").getHpxp() * mummyKills)), mummyKills, true, true));

        Map<Integer, List<Requirement>> lesserDemonKillsAndReqs = combatKills(new Encounter("Lesser demon"), player, 0, "Ranged", 0, false);
        int lesserDemonKills = lesserDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> lesserDemonReqs = lesserDemonKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing lesser demons", lesserDemonReqs, new HashMap(), ImmutableMap.of("Lesser demon", lesserDemonKills,
            "rCombat", (int)Enemy.getEnemyByName("Lesser demon").getCbxp() * lesserDemonKills,
            "Ranged pet points", ((int)Enemy.getEnemyByName("Lesser demon").getCbxp() * lesserDemonKills * player.getLevel("Ranged"))/2,
            "Constitution", (int) Enemy.getEnemyByName("Lesser demon").getHpxp() * lesserDemonKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Lesser demon").getHpxp() * lesserDemonKills)), lesserDemonKills, true, true));

        Map<Integer, List<Requirement>> corruptedScorpionKillsAndReqs = combatKills(new Encounter("Corrupted scorpion"), player, 0, "Magic", 0, false);
        int corruptedScorpionKills = corruptedScorpionKillsAndReqs.keySet().iterator().next();
        List<Requirement> corruptedScorpionReqs = corruptedScorpionKillsAndReqs.values().iterator().next();
        corruptedScorpionReqs.add(new Requirement("Slayer", 88));
        database.add(new Action("Killing corrupted scorpions", corruptedScorpionReqs, ImmutableMap.of("Feather of Ma'at", corruptedScorpionKills),
            ImmutableMap.of("Corrupted creatures", corruptedScorpionKills, "aCombat", (int)Enemy.getEnemyByName("Corrupted scorpion").getCbxp() * corruptedScorpionKills,
                "Constitution", (int) Enemy.getEnemyByName("Corrupted scorpion").getHpxp() * corruptedScorpionKills,
                "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Corrupted scorpion").getHpxp() * corruptedScorpionKills)), corruptedScorpionKills, true, true));

        Map<Integer, List<Requirement>> ripperDemonKillsAndReqs = combatKills(new Encounter("Ripper demon"), player, 0, "Magic", 0, false);
        int ripperDemonKills = ripperDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> ripperDemonReqs = ripperDemonKillsAndReqs.values().iterator().next();
        ripperDemonReqs.add(new Requirement("Slayer", 96));
        database.add(new Action("Killing ripper demons", ripperDemonReqs, new HashMap(), ImmutableMap.of("Ripper demons", ripperDemonKills,
            "aCombat", (int)Enemy.getEnemyByName("Ripper demon").getCbxp() * ripperDemonKills,
            "Constitution", (int) Enemy.getEnemyByName("Ripper demon").getHpxp() * ripperDemonKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Ripper demon").getHpxp() * ripperDemonKills)), ripperDemonKills, true, true));

        Map<Integer, List<Requirement>> impKillsAndReqs = combatKills(new Encounter("Imp"), player, 0, "Magic", 0, false);
        int impKills = impKillsAndReqs.keySet().iterator().next();
        List<Requirement> impReqs = impKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing imps", impReqs, new HashMap(), ImmutableMap.of("Imp", impKills, "aCombat", (int)Enemy.getEnemyByName("Imp").getCbxp() * impKills,
            "Constitution", (int) Enemy.getEnemyByName("Imp").getHpxp() * impKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Imp").getHpxp() * impKills)), impKills, true, true));

        //Bossing
        Map<Integer, List<Requirement>> kbdKillsAndReqs = combatKills(new Encounter("King Black Dragon"), player, 28, "Melee", 0, false);
        int kbdKills = kbdKillsAndReqs.keySet().iterator().next();
        List<Requirement> kbdReqs = kbdKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing the King Black Dragon", kbdReqs, new HashMap(), ImmutableMap.of("King Black Dragon", kbdKills, "Boss kills", kbdKills,
            "mCombat", (int)Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills, "Constitution",
            (int)Enemy.getEnemyByName("King Black Dragon").getHpxp() * kbdKills, "Constitution pet points",
            totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("King Black Dragon").getHpxp() * kbdKills)), kbdKills, true, true));

        Map<Integer, List<Requirement>> chaosElementalKillsAndReqs = combatKills(new Encounter("Chaos Elemental"), player, 28, "Ranged", 0, false);
        int chaosElementalKills = chaosElementalKillsAndReqs.keySet().iterator().next();
        List<Requirement> chaosElementalReqs = chaosElementalKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing the Chaos Elemental", chaosElementalReqs, new HashMap(), ImmutableMap.builder().put("Chaos Elemental", chaosElementalKills).put("Boss kills", chaosElementalKills)
            .put("rCombat", (int)Enemy.getEnemyByName("Chaos Elemental").getCbxp() * chaosElementalKills)
            .put("Ranged pet points", ((int)Enemy.getEnemyByName("Chaos Elemental").getCbxp() * chaosElementalKills * player.getLevel("Ranged"))/2)
            .put("Constitution", (int)Enemy.getEnemyByName("Chaos Elemental").getHpxp() * chaosElementalKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Chaos Elemental").getHpxp() * chaosElementalKills)).build(), chaosElementalKills, true, true));

        Map<Integer, List<Requirement>> dagannothRexKillsAndReqs = combatKills(new Encounter("Dagannoth Rex"), player, 28, "Magic", 0, false);
        int dagannothRexKills = dagannothRexKillsAndReqs.keySet().iterator().next();
        List<Requirement> dagannothRexReqs = dagannothRexKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing Dagannoth Rex", dagannothRexReqs, new HashMap(), ImmutableMap.builder().put("Dagannoth Rex", dagannothRexKills)
            .put("Dagannoth Kings", dagannothRexKills).put("Boss kills", dagannothRexKills).put("aCombat", (int)Enemy.getEnemyByName("Dagannoth Rex").getCbxp() * dagannothRexKills)
            .put("Constitution", (int)Enemy.getEnemyByName("Dagannoth Rex").getHpxp() * dagannothRexKills).put("Constitution pet points",
            totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Dagannoth Rex").getHpxp() * dagannothRexKills)).build(), dagannothRexKills, true, true));

        Map<Integer, List<Requirement>> dagannothPrimeKillsAndReqs = combatKills(new Encounter("Dagannoth Prime"), player, 28, "Ranged", 0, false);
        int dagannothPrimeKills = dagannothPrimeKillsAndReqs.keySet().iterator().next();
        List<Requirement> dagannothPrimeReqs = dagannothPrimeKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing Dagannoth Prime", dagannothPrimeReqs, new HashMap(), ImmutableMap.builder().put("Dagannoth Prime", dagannothPrimeKills)
            .put("Dagannoth Kings", dagannothPrimeKills).put("Boss kills", dagannothPrimeKills).put("rCombat", (int)Enemy.getEnemyByName("Dagannoth Prime").getCbxp() * dagannothPrimeKills)
            .put("Ranged pet points", ((int)Enemy.getEnemyByName("Dagannoth Prime").getCbxp() * dagannothPrimeKills * player.getLevel("Ranged"))/2)
            .put("Constitution", (int)Enemy.getEnemyByName("Dagannoth Prime").getHpxp() * dagannothPrimeKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Dagannoth Prime").getHpxp() * dagannothPrimeKills)).build(), dagannothPrimeKills, true, true));

        Map<Integer, List<Requirement>> dagannothSupremeKillsAndReqs = combatKills(new Encounter("Dagannoth Supreme"), player, 28, "Melee", 0, false);
        int dagannothSupremeKills = dagannothSupremeKillsAndReqs.keySet().iterator().next();
        List<Requirement> dagannothSupremeReqs = dagannothSupremeKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing Dagannoth Supreme", dagannothSupremeReqs, new HashMap(), ImmutableMap.builder().put("Dagannoth Supreme", dagannothSupremeKills)
            .put("Dagannoth Kings", dagannothSupremeKills).put("Boss kills", dagannothSupremeKills)
            .put("mCombat", (int)Enemy.getEnemyByName("Dagannoth Supreme").getCbxp() * dagannothSupremeKills)
            .put("Constitution", (int)Enemy.getEnemyByName("Dagannoth Supreme").getHpxp() * dagannothSupremeKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Dagannoth Supreme").getHpxp() * dagannothSupremeKills)).build(),
            dagannothSupremeKills, true, true));

        Map<Integer, List<Requirement>> qbdKillsAndReqs = combatKills(new Encounter("Queen Black Dragon"), player, 28, "Melee", 0, false);
        int qbdKills = qbdKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> qbdReqs = new ArrayList<>(qbdKillsAndReqs.values().iterator().next());
        qbdReqs.add(new Requirement("Summoning", 60));
        database.add(new Action("Killing the Queen Black Dragon", qbdReqs, new HashMap(),
            ImmutableMap.of("Queen Black Dragon", qbdKills, "Boss kills", qbdKills, "mCombat", (int)Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills, "Constitution",
            (int)Enemy.getEnemyByName("Queen Black Dragon").getHpxp() * qbdKills, "Constitution pet points",
                totalPetPoints(player, "Constitution", (int)Enemy.getEnemyByName("Queen Black Dragon").getHpxp() * qbdKills)), qbdKills, true, true));

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

        Map<Integer, List<Requirement>> telosKills = combatKills(new Encounter("Telos (0% enrage)"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> telosReqs = new ArrayList(telosKills.values().iterator().next());
        telosReqs.add(new Requirement("Vindicta", 1));
        telosReqs.add(new Requirement("Twin Furies", 1));
        telosReqs.add(new Requirement("Gregorovic", 1));
        telosReqs.add(new Requirement("Helwyr", 1));
        database.add(new Action("Killing Telos (0% enrage)", telosReqs, new HashMap(), ImmutableMap.of("Telos", telosKills.keySet().iterator().next(),
            "Boss kills", telosKills.keySet().iterator().next()), telosKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> solakKills = combatKills(new Encounter("Solak", 7), player, 28, "Melee", 0, false);
        ArrayList<Requirement> solakReqs = new ArrayList(solakKills.values().iterator().next());
        database.add(new Action("Killing Solak (7 man)", solakReqs, new HashMap(), ImmutableMap.of("Solak", solakKills.keySet().iterator().next(),
            "Boss kills", solakKills.keySet().iterator().next()), solakKills.keySet().iterator().next(), true, true));

        //Other repeatables
        database.add(new Action("Completing Shifting Tombs", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 50), new Requirement("The Jack of Spades", 1)),
            new HashMap<>(), ImmutableMap.of("Shifting Tombs", 12), 12, true, true));

        database.add(new Action("Completing Shifting Tombs (using reward enhancers)", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 50), new Requirement("The Jack of Spades", 1)),
            ImmutableMap.of("Dungeoneering token", 12000), ImmutableMap.of("Shifting Tombs", 12, "Perfect Shifting Tombs runs with enhancers", 12), 12, true, true));

        database.add(new Action("Completing Shifting Tombs (w/camo fragments)", Arrays.asList(new Requirement("Agility", 50),
            new Requirement("Construction", 50), new Requirement("Dungeoneering", 50),
            new Requirement("Thieving", 70), new Requirement("The Jack of Spades", 1)),
            new HashMap<>(), ImmutableMap.of("Shifting Tombs", 12, "Camouflage fragment", 3000), 12, true, true));

        Map<Integer, List<Requirement>> sanctumGuardianGroupKills = combatKills(new Encounter("The Sanctum Guardian", 3), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> masutaGroupKills = combatKills(new Encounter("Masuta the Ascended", 3), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> seiryuGroupKills = combatKills(new Encounter("Seiryu", 3), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> toaReqs = new ArrayList<>();
        toaReqs.add(new Requirement("Impressing the Locals", 1));
        toaReqs.addAll(sanctumGuardianGroupKills.values().iterator().next());
        toaReqs.addAll(masutaGroupKills.values().iterator().next());
        toaReqs.addAll(seiryuGroupKills.values().iterator().next());
        database.add(new Action("Completing the Temple of Aminishi (group)", toaReqs, new HashMap<>(), ImmutableMap.of("The Sanctum Guardian group kills", 2,
            "Masuta the Ascended group kills", 2, "Seiryu group kills", 2, "Seiryu", 2, "Boss kills", 6), 2, true, true));

        Map<Integer, List<Requirement>> sanctumGuardianSoloKills = combatKills(new Encounter("The Sanctum Guardian"), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> masutaSoloKills = combatKills(new Encounter("Masuta the Ascended"), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> seiryuSoloKills = combatKills(new Encounter("Seiryu"), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> toaSoloReqs = new ArrayList<>();
        toaSoloReqs.add(new Requirement("Impressing the Locals", 1));
        toaSoloReqs.addAll(sanctumGuardianSoloKills.values().iterator().next());
        toaSoloReqs.addAll(masutaSoloKills.values().iterator().next());
        toaSoloReqs.addAll(seiryuSoloKills.values().iterator().next());
        database.add(new Action("Completing the Temple of Aminishi (solo)", toaSoloReqs, new HashMap<>(), ImmutableMap.of("The Sanctum Guardian solo kills", 2,
            "Masuta the Ascended solo kills", 2, "Seiryu solo kills", 2, "Seiryu", 2, "Boss kills", 6), 2, true, true));

        Map<Integer, List<Requirement>> astellarnGroupKills = combatKills(new Encounter("Astellarn", 3), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> verakLithGroupKills = combatKills(new Encounter("Verak Lith", 3), player, 28, "Magic", 0, false);
        Map<Integer, List<Requirement>> blackStoneDragonGroupKills = combatKills(new Encounter("Black Stone Dragon", 3), player, 28, "Magic", 0, false);
        ArrayList<Requirement> dlReqs = new ArrayList<>();
        dlReqs.add(new Requirement("Seiryu", 1));
        dlReqs.addAll(astellarnGroupKills.values().iterator().next());
        dlReqs.addAll(verakLithGroupKills.values().iterator().next());
        dlReqs.addAll(blackStoneDragonGroupKills.values().iterator().next());
        database.add(new Action("Completing the Dragonkin Laboratory (group)", dlReqs, new HashMap<>(), ImmutableMap.of("Astellarn group kills", 2,
            "Verak Lith group kills", 2, "Black Stone Dragon group kills", 2, "Boss kills", 6), 2, true, true));

        Map<Integer, List<Requirement>> astellarnSoloKills = combatKills(new Encounter("Astellarn"), player, 28, "Melee", 0, false);
        Map<Integer, List<Requirement>> verakLithSoloKills = combatKills(new Encounter("Verak Lith"), player, 28, "Magic", 0, false);
        Map<Integer, List<Requirement>> blackStoneDragoSoloKills = combatKills(new Encounter("Black Stone Dragon"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> dlSoloReqs = new ArrayList<>();
        dlSoloReqs.add(new Requirement("Seiryu", 1));
        dlSoloReqs.addAll(astellarnGroupKills.values().iterator().next());
        dlSoloReqs.addAll(verakLithGroupKills.values().iterator().next());
        dlSoloReqs.addAll(blackStoneDragonGroupKills.values().iterator().next());
        database.add(new Action("Completing the Dragonkin Laboratory (solo)", dlSoloReqs, new HashMap<>(), ImmutableMap.of("Astellarn solo kills", 2,
            "Verak Lith solo kills", 2, "Black Stone Dragon solo kills", 2, "Boss kills", 6), 2, true, true));

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

        database.add(new Action("Completing easy clue scrolls", new ArrayList(), ImmutableMap.of("Sealed clue scroll (easy)", 6), ImmutableMap.of("Clue scrolls", 6), 6, true, true));
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
                if (player.getXp().get("Summoning") > initialXP.get("Summoning")) {
                    requirements.add(new Requirement("Summoning", player.getLevel("Summoning")));
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
        else if (Player.ALL_SKILLS.contains(gear)) {
            player.getXp().put(gear, player.getXp().get(gear) + player.getXpToLevel(gear, Math.min(99, player.getLevel(gear)+10)));
        }
        else {
            throw new RuntimeException(String.format("Attempted to equip gear that does not exist: %s. Please raise a T99 issue.", gear));
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

    private int miningXP(Player player, int pickDamage, int pickPenetration, int rockHardness, double rockXPFactor) {
        return (int)Math.floor(600*(player.getLevel("Mining") + player.getLevel("Strength")/10 + pickDamage + Math.min(pickPenetration - rockHardness, 0))*rockXPFactor);
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