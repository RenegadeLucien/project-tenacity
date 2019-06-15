package data.databases;

import com.google.common.collect.ImmutableMap;
import data.dataobjects.Action;
import data.dataobjects.Armour;
import data.dataobjects.Enemy;
import data.dataobjects.SlayerMaster;
import data.dataobjects.SlayerMonster;
import data.dataobjects.Weapon;
import logic.CombatParameters;
import logic.CombatResults;
import logic.Encounter;
import logic.Loadout;
import logic.Player;
import logic.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActionDatabase {

    private static ActionDatabase actionDatabase;

    private static final int TICKS_PER_HOUR = 6000;
    private List<Action> database = new ArrayList<>();

    private ActionDatabase() {
    }

    private void addSkillingActionsToDatabase(Player player) {

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

        //Gathering or money making (not viable for skill training)
        database.add(new Action("Picking potatoes", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Raw potato", 690), 690, true, true));
        database.add(new Action("Anima Islands", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Anima Islands Reward Currency", 3000), 3, true, true));
        database.add(new Action("Voyaging for items", Collections.singletonList(new Requirement("Impressing the Locals", 1)),
            ImmutableMap.of("Supplies", 300), ImmutableMap.builder().put("Taijitu", 26).put("Sea shell", 9).put("Driftwood", 9).put("Sea salt", 9)
            .put("Bamboo", 9).put("Shell chippings", 9).put("Spirit dragon charm", 9).put("Raw tarpon", 9).put("Bundle of bamboo", 9)
            .put("Fish oil", 9).put("Stoneberry seed", 1).put("Stormberry seed", 1).put("Shiny shell chippings", 9).put("Wobbegong oil", 9)
            .put("Alaea sea salt", 9).put("Uncharted Isles visited", 60).build(), 60, true, true));
        database.add(new Action("Winning Castle Wars games", new ArrayList(), new HashMap(), ImmutableMap.of("Gold Castle Wars ticket", 6, "Thaler", 12), 3, true, true));
        database.add(new Action("Winning Soul Wars games", new ArrayList(), new HashMap(), ImmutableMap.of("Zeal", 9, "Thaler", 12), 3, true, true));
        database.add(new Action("Playing Barbarian Assault", new ArrayList(), new HashMap(), ImmutableMap.of("Honour Points", 1000, "Penance Queen", 1, "Thaler", 12), 25, true, true));
        database.add(new Action("Playing spotlighted minigame", new ArrayList(), new HashMap(), ImmutableMap.of("Thaler", 60), 60, true, true));
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

        //Agility (done)
        database.add(new Action("Burthorpe Agility Course", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Agility", 7632, "Agility level-ticks", 6000 * player.getLevel("Agility")),
            96, true, true));
        database.add(new Action("Gnome Stronghold Agility Course", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Agility", 7266, "Agility level-ticks", 6000 * player.getLevel("Agility")),
            84, true, true));
        database.add(new Action("Watchtower shortcut", Collections.singletonList(new Requirement("Agility", 18)), new HashMap(),
            ImmutableMap.of("Agility", 9300, "Agility level-ticks", 6000 * Math.max(18, player.getLevel("Agility"))), 300, true, true));
        database.add(new Action("Werewolf Skullball", Arrays.asList(new Requirement("Agility", 25), new Requirement("Creature of Fenkenstrain", 1)), new HashMap(),
            ImmutableMap.of("Agility", 21600, "Agility level-ticks", 6000 * Math.max(25, player.getLevel("Agility"))), 24, true, true));
        database.add(new Action("Agility Pyramid", Collections.singletonList(new Requirement("Agility", 30)), ImmutableMap.of("Waterskin (4)", 10),
            ImmutableMap.of("Waterskin (0)", 10, "Agility", 26708, "Pyramid top", 22, "Agility level-ticks", 6000 * Math.max(30, player.getLevel("Agility"))), 22, true, true));
        database.add(new Action("Clockwork suits", Arrays.asList(new Requirement("Agility", 30), new Requirement("Cold War", 1)), new HashMap(),
            ImmutableMap.of("Agility", 37500, "Agility level-ticks", 6000 * Math.max(30, player.getLevel("Agility"))), 3000, true, true));
        database.add(new Action("Barbarian Outpost Agility Course", Collections.singletonList(new Requirement("Agility", 35)), new HashMap(),
            ImmutableMap.of("Agility", 20880, "Agility level-ticks", 6000 * Math.max(35, player.getLevel("Agility"))), 120, true, true));
        database.add(new Action("Brimhaven Agility Arena", Collections.singletonList(new Requirement("Agility", 40)), ImmutableMap.of("Coins", 200),
            ImmutableMap.of("Agility arena ticket", 60, "Agility", 3000, "Agility level-ticks", 6000 * Math.max(40, player.getLevel("Agility"))), 60, true, true));
        database.add(new Action("Ape Atoll Agility Course", Arrays.asList(new Requirement("Agility", 48), new Requirement("Monkey Madness", 1)), new HashMap(),
            ImmutableMap.of("Agility", 46400, "Agility level-ticks", 6000 * Math.max(48, player.getLevel("Agility"))), 80, true, true));
        database.add(new Action("Wilderness Agility Course", Collections.singletonList(new Requirement("Agility", 52)), new HashMap(),
            ImmutableMap.of("Agility", 45720, "Agility level-ticks", 6000 * Math.max(52, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv52 xp rates)", Arrays.asList(new Requirement("Agility", 52), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 49377, "Agility level-ticks", 6000 * Math.max(52, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv53 xp rates)", Arrays.asList(new Requirement("Agility", 53), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 51206, "Agility level-ticks", 6000 * Math.max(53, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv54 xp rates)", Arrays.asList(new Requirement("Agility", 54), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 53035, "Agility level-ticks", 6000 * Math.max(54, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv55 xp rates)", Arrays.asList(new Requirement("Agility", 55), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 54864, "Agility level-ticks", 6000 * Math.max(55, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv56 xp rates)", Arrays.asList(new Requirement("Agility", 56), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 56692, "Agility level-ticks", 6000 * Math.max(56, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv57 xp rates)", Arrays.asList(new Requirement("Agility", 57), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 58521, "Agility level-ticks", 6000 * Math.max(57, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv58 xp rates)", Arrays.asList(new Requirement("Agility", 58), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 60350, "Agility level-ticks", 6000 * Math.max(58, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv59 xp rates)", Arrays.asList(new Requirement("Agility", 59), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 62179, "Agility level-ticks", 6000 * Math.max(59, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv60 xp rates)", Arrays.asList(new Requirement("Agility", 60), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 64008, "Agility level-ticks", 6000 * Math.max(60, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Bandos Agility Course", Arrays.asList(new Requirement("Agility", 60), new Requirement("The Chosen Commander", 1)), new HashMap(),
            ImmutableMap.of("Agility", 38000, "Ranged", 12500, "Strength", 12500, "Agility level-ticks", 6000 * Math.max(60, player.getLevel("Agility"))), 100, true, true));
        database.add(new Action("Werewolf Agility Course", Arrays.asList(new Requirement("Agility", 60), new Requirement("Creature of Fenkenstrain", 1)), new HashMap(),
            ImmutableMap.of("Agility", 43200, "Agility level-ticks", 6000 * Math.max(60, player.getLevel("Agility"))), 80, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv61 xp rates)", Arrays.asList(new Requirement("Agility", 61), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 65836, "Agility level-ticks", 6000 * Math.max(61, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv62 xp rates)", Arrays.asList(new Requirement("Agility", 62), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 67665, "Agility level-ticks", 6000 * Math.max(62, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv63 xp rates)", Arrays.asList(new Requirement("Agility", 63), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 69494, "Agility level-ticks", 6000 * Math.max(63, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv64 xp rates)", Arrays.asList(new Requirement("Agility", 64), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 71323, "Agility level-ticks", 6000 * Math.max(64, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv65 xp rates)", Arrays.asList(new Requirement("Agility", 65), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 73152, "Agility level-ticks", 6000 * Math.max(65, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Empty Throne Room agility", Arrays.asList(new Requirement("Agility", 65), new Requirement("The Dig Site", 1)),
            new HashMap(), ImmutableMap.of("Agility", 68760, "Senntisten scroll", 17, "Agility level-ticks", 6000 * Math.max(65, player.getLevel("Agility"))), 1800, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv66 xp rates)", Arrays.asList(new Requirement("Agility", 66), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 74980, "Agility level-ticks", 6000 * Math.max(66, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv67 xp rates)", Arrays.asList(new Requirement("Agility", 67), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 76809, "Agility level-ticks", 6000 * Math.max(67, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv68 xp rates)", Arrays.asList(new Requirement("Agility", 68), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 78638, "Agility level-ticks", 6000 * Math.max(68, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv69 xp rates)", Arrays.asList(new Requirement("Agility", 69), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 80467, "Agility level-ticks", 6000 * Math.max(69, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv70 xp rates)", Arrays.asList(new Requirement("Agility", 70), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 82296, "Agility level-ticks", 6000 * Math.max(70, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv71 xp rates)", Arrays.asList(new Requirement("Agility", 71), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 84124, "Agility level-ticks", 6000 * Math.max(71, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv72 xp rates)", Arrays.asList(new Requirement("Agility", 72), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 85953, "Agility level-ticks", 6000 * Math.max(72, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv73 xp rates)", Arrays.asList(new Requirement("Agility", 73), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 87782, "Agility level-ticks", 6000 * Math.max(73, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv74 xp rates)", Arrays.asList(new Requirement("Agility", 74), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 89611, "Agility level-ticks", 6000 * Math.max(74, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv75 xp rates)", Arrays.asList(new Requirement("Agility", 75), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 91440, "Agility level-ticks", 6000 * Math.max(75, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv76 xp rates)", Arrays.asList(new Requirement("Agility", 76), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 93268, "Agility level-ticks", 6000 * Math.max(76, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv77 xp rates)", Arrays.asList(new Requirement("Agility", 77), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 95097, "Agility level-ticks", 6000 * Math.max(77, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Hefin Agility Course (77-81 Agility)", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Agility", 77)),
            new HashMap(), ImmutableMap.of("Agility", 56320, "Hefin Agility Course laps", 80, "Agility level-ticks", 6000 * Math.max(77, player.getLevel("Agility"))), 80, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv78 xp rates)", Arrays.asList(new Requirement("Agility", 78), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 96926, "Agility level-ticks", 6000 * Math.max(78, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv79 xp rates)", Arrays.asList(new Requirement("Agility", 79), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 98755, "Agility level-ticks", 6000 * Math.max(79, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv80 xp rates)", Arrays.asList(new Requirement("Agility", 80), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 100584, "Agility level-ticks", 6000 * Math.max(80, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Dorgesh-Kaan Agility Course", Arrays.asList(new Requirement("Agility", 80), new Requirement("Death to the Dorgeshuun", 1)), new HashMap(),
            ImmutableMap.of("Agility", 52250, "Agility level-ticks", 6000 * Math.max(80, player.getLevel("Agility"))), 80, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv81 xp rates)", Arrays.asList(new Requirement("Agility", 81), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 102412, "Agility level-ticks", 6000 * Math.max(81, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv82 xp rates)", Arrays.asList(new Requirement("Agility", 82), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 104241, "Agility level-ticks", 6000 * Math.max(82, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Hefin Agility Course (82-86 Agility)", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Agility", 82)),
            new HashMap(), ImmutableMap.of("Agility", 70800, "Hefin Agility Course laps", 80, "Agility level-ticks", 6000 * Math.max(82, player.getLevel("Agility"))), 80, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv83 xp rates)", Arrays.asList(new Requirement("Agility", 83), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 106070, "Agility level-ticks", 6000 * Math.max(83, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv84 xp rates)", Arrays.asList(new Requirement("Agility", 84), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 107899, "Agility level-ticks", 6000 * Math.max(84, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv85 xp rates)", Arrays.asList(new Requirement("Agility", 85), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 109728, "Agility level-ticks", 6000 * Math.max(85, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Advanced Gnome Stronghold Agility Course", Collections.singletonList(new Requirement("Agility", 85)),
            new HashMap(), ImmutableMap.of("Agility", 68150, "Advanced Gnome Stronghold laps", 94, "Agility level-ticks", 6000 * Math.max(85, player.getLevel("Agility"))), 34, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv86 xp rates)", Arrays.asList(new Requirement("Agility", 86), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 111556, "Agility level-ticks", 6000 * Math.max(86, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv87 xp rates)", Arrays.asList(new Requirement("Agility", 87), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 113385, "Agility level-ticks", 6000 * Math.max(87, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Hefin Agility Course (87-91 Agility)", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Agility", 87)),
            new HashMap(), ImmutableMap.of("Agility", 84480, "Hefin Agility Course laps", 80, "Agility level-ticks", 6000 * Math.max(87, player.getLevel("Agility"))), 80, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv88 xp rates)", Arrays.asList(new Requirement("Agility", 88), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 115214, "Agility level-ticks", 6000 * Math.max(88, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv89 xp rates)", Arrays.asList(new Requirement("Agility", 89), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 117043, "Agility level-ticks", 6000 * Math.max(89, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv90 xp rates)", Arrays.asList(new Requirement("Agility", 90), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 118872, "Agility level-ticks", 6000 * Math.max(90, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Advanced Barbarian Outpost Agility Course", Arrays.asList(new Requirement("Bar Crawl", 1), new Requirement("Agility", 90)),
            new HashMap(), ImmutableMap.of("Agility", 72355, "Advanced Barbarian Outpost laps", 96, "Agility level-ticks", 6000 * Math.max(90, player.getLevel("Agility"))), 96, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv91 xp rates)", Arrays.asList(new Requirement("Agility", 91), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 120700, "Agility level-ticks", 6000 * Math.max(91, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv92 xp rates)", Arrays.asList(new Requirement("Agility", 92), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 122529, "Agility level-ticks", 6000 * Math.max(92, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Hefin Agility Course (92-96 Agility)", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Agility", 92)),
            new HashMap(), ImmutableMap.of("Agility", 94720, "Hefin Agility Course laps", 80, "Agility level-ticks", 6000 * Math.max(792, player.getLevel("Agility"))), 80, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv93 xp rates)", Arrays.asList(new Requirement("Agility", 93), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 124358, "Agility level-ticks", 6000 * Math.max(93, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv94 xp rates)", Arrays.asList(new Requirement("Agility", 94), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 126187, "Agility level-ticks", 6000 * Math.max(94, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv95 xp rates)", Arrays.asList(new Requirement("Agility", 95), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 128016, "Agility level-ticks", 6000 * Math.max(95, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv96 xp rates)", Arrays.asList(new Requirement("Agility", 96), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 129844, "Agility level-ticks", 6000 * Math.max(96, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv97 xp rates)", Arrays.asList(new Requirement("Agility", 97), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 131673, "Agility level-ticks", 6000 * Math.max(97, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Hefin Agility Course (97+ Agility)", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Agility", 97)),
            new HashMap(), ImmutableMap.of("Agility", 106240, "Hefin Agility Course laps", 80, "Agility level-ticks", 6000 * Math.max(97, player.getLevel("Agility"))), 80, true, true));
        database.add(new Action("Wilderness Agility Course (w/skull, lv98 xp rates)", Arrays.asList(new Requirement("Agility", 98), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 133502, "Agility level-ticks", 6000 * Math.max(98, player.getLevel("Agility"))), 80, true, false));
        database.add(new Action("Wilderness Agility Course (w/skull, lv99 xp rates)", Arrays.asList(new Requirement("Agility", 99), new Requirement("Demonic skull", 1)), new HashMap(),
            ImmutableMap.of("Agility", 135331, "Agility level-ticks", 594000), 80, true, false));


        //Construction (done)
        database.add(new Action("Building garden plants 1", new ArrayList(), ImmutableMap.of("Bagged plant 1", 504), ImmutableMap.of("Construction", 15624, "Farming", 15624,
            "Construction pet points", totalPetPoints(player, "Construction", 15624)), 504, true, true));
        database.add(new Action("Building crude wooden chairs", new ArrayList(), ImmutableMap.of("Plank", 676, "Bronze nails", 3380), ImmutableMap.of("Construction", 22308,
            "Construction pet points", totalPetPoints(player, "Construction", 22308)), 338, true, true));
        database.add(new Action("Building decorative rocks", Collections.singletonList(new Requirement("Construction", 5)), ImmutableMap.of("Limestone brick", 1050),
            ImmutableMap.of("Construction", 21000, "Construction pet points", totalPetPoints(player, "Construction", 21000)), 210, true, true));
        database.add(new Action("Building dead trees", Collections.singletonList(new Requirement("Construction", 5)), ImmutableMap.of("Coins", 504000),
            ImmutableMap.of("Construction", 15624, "Farming", 15624, "Construction pet points", totalPetPoints(player, "Construction", 15624)), 504, true, true));
        database.add(new Action("Building garden plants 2", Collections.singletonList(new Requirement("Construction", 6)), ImmutableMap.of("Coins", 2520000),
            ImmutableMap.of("Construction", 35280, "Farming", 35280, "Construction pet points", totalPetPoints(player, "Construction", 35820)), 504, true, true));
        database.add(new Action("Building garden plants 3", Collections.singletonList(new Requirement("Construction", 12)), ImmutableMap.of("Coins", 5040000),
            ImmutableMap.of("Construction", 50400, "Farming", 50400, "Construction pet points", totalPetPoints(player, "Construction", 50400)), 504, true, true));
        database.add(new Action("Building repair benches 1", Collections.singletonList(new Requirement("Construction", 15)), ImmutableMap.of("Oak plank", 792),
            ImmutableMap.of("Construction", 47520, "Construction pet points", totalPetPoints(player, "Construction", 47520)), 396, true, true));
        database.add(new Action("Building crafting tables 1", Collections.singletonList(new Requirement("Construction", 16)), ImmutableMap.of("Oak plank", 1064),
            ImmutableMap.of("Construction", 63840, "Construction pet points", totalPetPoints(player, "Construction", 63840)), 266, true, true));
        database.add(new Action("Building crude wooden chairs (w/maid)", Collections.singletonList(new Requirement("Construction", 25)), ImmutableMap.of("Plank", 1090, "Bronze nails", 5450,
            "Coins", 14000), ImmutableMap.of("Construction", 35970, "Construction pet points", totalPetPoints(player, "Construction", 35970)), 545, true, true));
        database.add(new Action("Building decorative rocks (w/maid)", Collections.singletonList(new Requirement("Construction", 25)), ImmutableMap.of("Limestone brick", 1090, "Coins", 14000),
            ImmutableMap.of("Construction", 21800, "Construction pet points", totalPetPoints(player, "Construction", 21800)), 218, true, true));
        database.add(new Action("Building repair benches 1 (w/maid)", Collections.singletonList(new Requirement("Construction", 25)), ImmutableMap.of("Oak plank", 1090, "Coins", 14000),
            ImmutableMap.of("Construction", 65400, "Construction pet points", totalPetPoints(player, "Construction", 65400)), 545, true, true));
        database.add(new Action("Building decorative rocks (w/cook)", Collections.singletonList(new Requirement("Construction", 30)), ImmutableMap.of("Limestone brick", 2880, "Coins", 69000),
            ImmutableMap.of("Construction", 57600, "Construction pet points", totalPetPoints(player, "Construction", 57600)), 576, true, true));
        database.add(new Action("Building crafting tables 1 (w/cook)", Collections.singletonList(new Requirement("Construction", 30)), ImmutableMap.of("Oak plank", 2880, "Coins", 69000),
            ImmutableMap.of("Construction", 172800, "Construction pet points", totalPetPoints(player, "Construction", 172800)), 720, true, true));
        database.add(new Action("Building teak tables (w/cook)", Collections.singletonList(new Requirement("Construction", 38)), ImmutableMap.of("Teak plank", 2880, "Coins", 69000),
            ImmutableMap.of("Construction", 259200, "Construction pet points", totalPetPoints(player, "Construction", 259200)), 750, true, true));
        database.add(new Action("Building mahogany bookcases (w/cook)", Collections.singletonList(new Requirement("Construction", 40)), ImmutableMap.of("Mahogany plank", 2250, "Coins", 54000),
            ImmutableMap.of("Construction", 315000, "Construction pet points", totalPetPoints(player, "Construction", 315000)), 750, true, true));
        database.add(new Action("Building decorative rocks (w/butler)", Collections.singletonList(new Requirement("Construction", 40)), ImmutableMap.of("Limestone brick", 3750, "Coins", 120000),
            ImmutableMap.of("Construction", 75000, "Construction pet points", totalPetPoints(player, "Construction", 75000)), 750, true, true));
        database.add(new Action("Building oak larders (w/butler)", Collections.singletonList(new Requirement("Construction", 40)), ImmutableMap.of("Oak plank", 4800, "Coins", 150000),
            ImmutableMap.of("Construction", 280000, "Construction pet points", totalPetPoints(player, "Construction", 280000)), 600, true, true));
        database.add(new Action("Building teak tables (w/butler)", Collections.singletonList(new Requirement("Construction", 40)), ImmutableMap.of("Teak plank", 3000, "Coins", 95000),
            ImmutableMap.of("Construction", 270000, "Construction pet points", totalPetPoints(player, "Construction", 270000)), 750, true, true));
        database.add(new Action("Building teak prize chests (w/butler)", Collections.singletonList(new Requirement("Construction", 44)), ImmutableMap.of("Teak plank", 3000, "Gold leaf", 750,
            "Coins", 120000), ImmutableMap.of("Construction", 495000, "Construction pet points", totalPetPoints(player, "Construction", 495000)), 750, true, true));
        database.add(new Action("Building maple trees", Collections.singletonList(new Requirement("Construction", 45)), ImmutableMap.of("Coins", 7560000),
            ImmutableMap.of("Construction", 61488, "Farming", 61488, "Construction pet points", totalPetPoints(player, "Construction", 61488)), 504, true, true));
        database.add(new Action("Building oak larders (w/demon)", Collections.singletonList(new Requirement("Construction", 50)), ImmutableMap.of("Oak plank", 6000, "Coins", 290000),
            ImmutableMap.of("Construction", 360000, "Construction pet points", totalPetPoints(player, "Construction", 360000)), 750, true, true));
        database.add(new Action("Building mahogany tables (w/butler)", Collections.singletonList(new Requirement("Construction", 52)), ImmutableMap.of("Mahogany plank", 4500, "Coins", 145000),
            ImmutableMap.of("Construction", 630000, "Construction pet points", totalPetPoints(player, "Construction", 151200)), 750, true, true));
        database.add(new Action("Building mahogany prize chests (w/butler)", Collections.singletonList(new Requirement("Construction", 54)), ImmutableMap.of("Mahogany plank", 3000, "Gold leaf", 750,
            "Coins", 120000), ImmutableMap.of("Construction", 645000, "Construction pet points", totalPetPoints(player, "Construction", 645000)), 750, true, true));
        database.add(new Action("Building armour stands (w/demon)", Collections.singletonList(new Requirement("Construction", 55)), ImmutableMap.of("Oak plank", 6000, "Limestone brick", 750,
            "Coins", 330000), ImmutableMap.of("Construction", 375000, "Construction pet points", totalPetPoints(player, "Construction", 375000)), 750, true, true));
        database.add(new Action("Building gilded benches (w/butler)", Collections.singletonList(new Requirement("Construction", 56)), ImmutableMap.of("Mahogany plank", 2250, "Gold leaf", 1500,
            "Coins", 120000), ImmutableMap.of("Construction", 765000, "Construction pet points", totalPetPoints(player, "Construction", 765000)), 750, true, true));
        database.add(new Action("Building god icons (w/butler)", Collections.singletonList(new Requirement("Construction", 59)), ImmutableMap.of("Teak plank", 3000, "Gold leaf", 1500,
            "Coins", 145000), ImmutableMap.of("Construction", 720000, "Construction pet points", totalPetPoints(player, "Construction", 720000)), 750, true, true));
        database.add(new Action("Building yew trees", Collections.singletonList(new Requirement("Construction", 60)), ImmutableMap.of("Coins", 10080000),
            ImmutableMap.of("Construction", 71064, "Farming", 71064, "Construction pet points", totalPetPoints(player, "Construction", 71064)), 504, true, true));
        database.add(new Action("Building oak thrones (w/butler)", Collections.singletonList(new Requirement("Construction", 60)), ImmutableMap.of("Oak plank", 3750, "Marble block", 750,
            "Coins", 145000), ImmutableMap.of("Construction", 600000, "Construction pet points", totalPetPoints(player, "Construction", 600000)), 750, true, true));
        database.add(new Action("Building gilded benches (w/demon)", Collections.singletonList(new Requirement("Construction", 61)), ImmutableMap.of("Mahogany plank", 3000, "Gold leaf", 3000,
            "Coins", 290000), ImmutableMap.of("Construction", 1320000, "Construction pet points", totalPetPoints(player, "Construction", 1320000)), 750, true, true));
        database.add(new Action("Building driftwood prawnbrokers (w/demon)", Collections.singletonList(new Requirement("Construction", 63)), ImmutableMap.of("Teak plank", 6000, "Coins", 290000),
            ImmutableMap.of("Construction", 540000, "Construction pet points", totalPetPoints(player, "Construction", 540000)), 750, true, true));
        database.add(new Action("Building spiral staircases (w/demon)", Collections.singletonList(new Requirement("Construction", 67)), ImmutableMap.of("Teak plank", 6240, "Limestone brick", 3120,
            "Coins", 450000), ImmutableMap.of("Construction", 624000, "Construction pet points", totalPetPoints(player, "Construction", 624000)), 624, true, true));
        database.add(new Action("Building teak thrones (w/demon)", Collections.singletonList(new Requirement("Construction", 67)), ImmutableMap.of("Teak plank", 3750, "Marble block", 1500,
            "Coins", 260000), ImmutableMap.of("Construction", 1087500, "Construction pet points", totalPetPoints(player, "Construction", 1087500)), 750, true, true));
        database.add(new Action("Building skeleton guards", Collections.singletonList(new Requirement("Construction", 70)), ImmutableMap.of("Coins", 37500000),
            ImmutableMap.of("Construction", 167250, "Construction pet points", totalPetPoints(player, "Construction", 167250)), 750, true, true));
        database.add(new Action("Building flotsam prawnbrokers (w/demon)", Collections.singletonList(new Requirement("Construction", 73)), ImmutableMap.of("Mahogany plank", 6000, "Coins", 290000),
            ImmutableMap.of("Construction", 840000, "Construction pet points", totalPetPoints(player, "Construction", 840000)), 750, true, true));
        database.add(new Action("Building pit ogres", Collections.singletonList(new Requirement("Construction", 73)), ImmutableMap.of("Coins", 41250000),
            ImmutableMap.of("Construction", 175500, "Construction pet points", totalPetPoints(player, "Construction", 175500)), 750, true, true));
        database.add(new Action("Building mahogany thrones (w/demon)", Collections.singletonList(new Requirement("Construction", 74)), ImmutableMap.of("Mahogany plank", 3750, "Marble block", 2250,
            "Coins", 290000), ImmutableMap.of("Construction", 1650000, "Construction pet points", totalPetPoints(player, "Construction", 1650000)), 750, true, true));
        database.add(new Action("Building guard dogs", Collections.singletonList(new Requirement("Construction", 74)), ImmutableMap.of("Coins", 56250000),
            ImmutableMap.of("Construction", 204750, "Construction pet points", totalPetPoints(player, "Construction", 204750)), 750, true, true));
        database.add(new Action("Building oak dungeon doors (w/demon)", Collections.singletonList(new Requirement("Construction", 74)), ImmutableMap.of("Oak plank", 7500, "Coins", 370000),
            ImmutableMap.of("Construction", 450000, "Construction pet points", totalPetPoints(player, "Construction", 450000)), 750, true, true));
        database.add(new Action("Building magic trees", Collections.singletonList(new Requirement("Construction", 75)), ImmutableMap.of("Coins", 25200000),
            ImmutableMap.of("Construction", 112392, "Farming", 112392, "Construction pet points", totalPetPoints(player, "Construction", 112392)), 504, true, true));
        database.add(new Action("Building demons", Collections.singletonList(new Requirement("Construction", 75)), ImmutableMap.of("Coins", 375000000),
            ImmutableMap.of("Construction", 530250, "Construction pet points", totalPetPoints(player, "Construction", 530250)), 750, true, true));
        database.add(new Action("Building marble walls (w/demon)", Collections.singletonList(new Requirement("Construction", 79)), ImmutableMap.of("Marble block", 6000, "Coins", 290000),
            ImmutableMap.of("Construction", 3000000, "Construction pet points", totalPetPoints(player, "Construction", 3000000)), 750, true, true));
        database.add(new Action("Building kalphite soldiers", Collections.singletonList(new Requirement("Construction", 80)), ImmutableMap.of("Coins", 562500000),
            ImmutableMap.of("Construction", 649500, "Construction pet points", totalPetPoints(player, "Construction", 649500)), 750, true, true));
        database.add(new Action("Building marble staircases (w/demon)", Collections.singletonList(new Requirement("Construction", 82)), ImmutableMap.of("Mahogany plank", 3750, "Marble block", 3750,
            "Coins", 370000), ImmutableMap.of("Construction", 2400000, "Construction pet points", totalPetPoints(player, "Construction", 2400000)), 750, true, true));
        database.add(new Action("Building lesser magic cages (w/demon)", Collections.singletonList(new Requirement("Construction", 82)), ImmutableMap.of("Mahogany plank", 3750, "Magic stone", 1500,
            "Coins", 260000), ImmutableMap.of("Construction", 2025000, "Construction pet points", totalPetPoints(player, "Construction", 2025000)), 750, true, true));
        database.add(new Action("Building Tok-Xils", Collections.singletonList(new Requirement("Construction", 85)), ImmutableMap.of("Spirit shards", 150000000),
            ImmutableMap.of("Construction", 1677000, "Construction pet points", totalPetPoints(player, "Construction", 1677000)), 750, true, true));
        database.add(new Action("Building mahogany chests (w/butler)", Collections.singletonList(new Requirement("Construction", 87)), ImmutableMap.of("Mahogany plank", 3750, "Gold leaf", 750,
            "Coins", 145000), ImmutableMap.of("Construction", 750000, "Construction pet points", totalPetPoints(player, "Construction", 750000)), 750, true, true));
        database.add(new Action("Building greater magic cages (w/demon)", Collections.singletonList(new Requirement("Construction", 89)), ImmutableMap.of("Mahogany plank", 3750, "Magic stone", 3000,
            "Coins", 330000), ImmutableMap.of("Construction", 3525000, "Construction pet points", totalPetPoints(player, "Construction", 3525000)), 750, true, true));
        database.add(new Action("Building dagannoths", Collections.singletonList(new Requirement("Construction", 90)), ImmutableMap.of("Spirit shards", 225000000),
            ImmutableMap.of("Construction", 2053500, "Construction pet points", totalPetPoints(player, "Construction", 2053500)), 750, true, true));
        database.add(new Action("Building large orneries (w/demon)", Collections.singletonList(new Requirement("Construction", 95)), ImmutableMap.of("Mahogany plank", 2250, "Gold leaf", 3750,
            "Coins", 290000), ImmutableMap.of("Construction", 1440000, "Construction pet points", totalPetPoints(player, "Construction", 1440000)), 750, true, true));
        database.add(new Action("Building crystal thrones (w/demon)", Collections.singletonList(new Requirement("Construction", 95)), ImmutableMap.of("Magic stone", 9360, "Coins", 450000),
            ImmutableMap.of("Construction", 9360000, "Construction pet points", totalPetPoints(player, "Construction", 9360000)), 624, true, true));
        database.add(new Action("Building steel dragons", Collections.singletonList(new Requirement("Construction", 97)), ImmutableMap.of("Spirit shards", 300000000),
            ImmutableMap.of("Construction", 2371500, "Construction pet points", totalPetPoints(player, "Construction", 2371500)), 750, true, true));
        database.add(new Action("Building marble spirals (w/demon)", Collections.singletonList(new Requirement("Construction", 97)), ImmutableMap.of("Teak plank", 6240, "Marble block", 3120,
            "Coins", 450000), ImmutableMap.of("Construction", 2121600, "Construction pet points", totalPetPoints(player, "Construction", 2121600)), 684, true, true));

        //Cooking (done)
        int beefCooked = (int) Math.floor(1260 * Math.min(1, 1 - (34 - player.getLevel("Cooking")) / 100.0));
        int breadCooked = (int) Math.floor(1260 * Math.min(1, 1 - (37 - player.getLevel("Cooking")) / 100.0));
        int sardineCooked = (int) Math.floor(1260 * Math.min(1, 1 - (38 - player.getLevel("Cooking")) / 100.0));
        int caveEelCooked = (int) Math.floor(1260 * Math.min(1, 1 - (40 - Math.max(38,player.getLevel("Cooking"))) / 100.0));
        int herringCooked = (int) Math.floor(1260 * Math.min(1, 1 - (41 - Math.max(5,player.getLevel("Cooking"))) / 100.0));
        int mackerelCooked = (int) Math.floor(1260 * Math.min(1, 1 - (45 - Math.max(10,player.getLevel("Cooking"))) / 100.0));
        int thinSnailCooked = (int) Math.floor(1260 * Math.min(1, 1 - (47 - Math.max(12,player.getLevel("Cooking"))) / 100.0));
        int scrambledEggCooked = (int) Math.floor(1260 * Math.min(1, 1 - (48 - Math.max(13,player.getLevel("Cooking"))) / 100.0));
        int spiderCooked = (int) Math.floor(1260 * Math.min(1, 1 - (48 - Math.max(16,player.getLevel("Cooking"))) / 100.0));
        int redberryPieCooked = (int) Math.floor(1260 * Math.min(1, 1 - (50 - Math.max(10,player.getLevel("Cooking"))) / 100.0));
        int troutCooked = (int) Math.floor(1260 * Math.min(1, 1 - (50 - Math.max(15,player.getLevel("Cooking"))) / 100.0));
        int leanSnailCooked = (int) Math.floor(1260 * Math.min(1, 1 - (50 - Math.max(17,player.getLevel("Cooking"))) / 100.0));
        int codCooked = (int) Math.floor(1260 * Math.min(1, 1 - (52 - Math.max(18,player.getLevel("Cooking"))) / 100.0));
        int pikeCooked = (int) Math.floor(1260 * Math.min(1, 1 - (53 - Math.max(20,player.getLevel("Cooking"))) / 100.0));
        int sweetcornCooked = (int) Math.floor(1260 * Math.min(1, 1 - (53 - Math.max(28,player.getLevel("Cooking"))) / 100.0));
        int fatSnailCooked = (int) Math.floor(1260 * Math.min(1, 1 - (56 - Math.max(22,player.getLevel("Cooking"))) / 100.0));
        int salmonCooked = (int) Math.floor(1260 * Math.min(1, 1 - (58 - Math.max(25,player.getLevel("Cooking"))) / 100.0));
        int slimyEelCooked = (int) Math.floor(1260 * Math.min(1, 1 - (58 - Math.max(28,player.getLevel("Cooking"))) / 100.0));
        int rainbowFishCooked = (int) Math.floor(1260 * Math.min(1, 1 - (60 - Math.max(35,player.getLevel("Cooking"))) / 100.0));
        int mudPieCooked = (int) Math.floor(1260 * Math.min(1, 1 - (63 - Math.max(29,player.getLevel("Cooking"))) / 100.0));
        int applePieCooked = (int) Math.floor(1260 * Math.min(1, 1 - (63 - Math.max(30,player.getLevel("Cooking"))) / 100.0));
        int tunaCooked = (int) Math.floor(1260 * Math.min(1, 1 - (65 - Math.max(30,player.getLevel("Cooking"))) / 100.0));
        int wineCooked = (int) Math.floor(4662 * Math.min(1, 1 - (68 - Math.max(30,player.getLevel("Cooking"))) / 100.0));
        int gardenPieCooked = (int) Math.floor(1260 * Math.min(1, 1 - (68 - Math.max(34,player.getLevel("Cooking"))) / 100.0));
        int plainPizzaCooked = (int) Math.floor(1260 * Math.min(1, 1 - (68 - Math.max(35,player.getLevel("Cooking"))) / 100.0));
        int lobsterCooked = (int) Math.floor(1260 * Math.min(1, 1 - (73 - Math.max(40,player.getLevel("Cooking"))) / 100.0));
        int cakeCooked = (int) Math.floor(1260 * Math.min(1, 1 - (74 - Math.max(40,player.getLevel("Cooking"))) / 100.0));
        int fishPieCooked = (int) Math.floor(1260 * Math.min(1, 1 - (74 - Math.max(47,player.getLevel("Cooking"))) / 100.0));
        int curryCooked = (int) Math.floor(1260 * Math.min(1, 1 - (74 - Math.max(60,player.getLevel("Cooking"))) / 100.0));
        int friedOnionCooked = (int) Math.floor(1260 * Math.min(1, 1 - (77 - Math.max(42,player.getLevel("Cooking"))) / 100.0));
        int bassCooked = (int) Math.floor(1260 * Math.min(1, 1 - (79 - Math.max(43,player.getLevel("Cooking"))) / 100.0));
        int swordfishCooked = (int) Math.floor(1260 * Math.min(1, 1 - (86 - Math.max(45,player.getLevel("Cooking"))) / 100.0));
        int desertSoleCooked = (int) Math.floor(1260 * Math.min(1, 1 - (87 - Math.max(52,player.getLevel("Cooking"))) / 100.0));
        int catfishCooked = (int) Math.floor(1260 * Math.min(1, 1 - (89 - Math.max(60,player.getLevel("Cooking"))) / 100.0));
        int friedMushroomsCooked = (int) Math.floor(1260 * Math.min(1, 1 - (90 - Math.max(46,player.getLevel("Cooking"))) / 100.0));
        int monkfishCooked = (int) Math.floor(1260 * Math.min(1, 1 - (92 - Math.max(62,player.getLevel("Cooking"))) / 100.0));
        int admiralPieCooked = (int) Math.floor(1260 * Math.min(1, 1 - (94 - Math.max(70,player.getLevel("Cooking"))) / 100.0));
        int birdCooked = (int) Math.floor(1260 * Math.min(1, 1 - (99 - Math.max(11,player.getLevel("Cooking"))) / 100.0));
        int rabbitCooked = (int) Math.floor(1260 * Math.min(1, 1 - (99 - Math.max(16,player.getLevel("Cooking"))) / 100.0));
        int beastCooked = (int) Math.floor(1260 * Math.min(1, 1 - (99 - Math.max(21,player.getLevel("Cooking"))) / 100.0));
        int chompyCooked = (int) Math.floor(1260 * Math.min(1, 1 - (99 - Math.max(30,player.getLevel("Cooking"))) / 100.0));
        int ugthankiCooked = (int) Math.floor(1260 * Math.min(1, 1 - (100 - player.getLevel("Cooking")) / 100.0));
        int karambwanCooked = (int) Math.floor(1260 * Math.min(1, 1 - (100 - Math.max(30,player.getLevel("Cooking"))) / 100.0));
        int jubblyCooked = (int) Math.floor(1260 * Math.min(1, 1 - (100 - Math.max(41,player.getLevel("Cooking"))) / 100.0));
        int beltfishCooked = (int) Math.floor(1260 * Math.min(1, 1 - (102 - Math.max(72,player.getLevel("Cooking"))) / 100.0));
        int sharkCooked = (int) Math.floor(1260 * Math.min(1, 1 - (110 - Math.max(80,player.getLevel("Cooking"))) / 100.0));
        int seaTurtleCooked = (int) Math.floor(1260 * Math.min(1, 1 - (112 - Math.max(82,player.getLevel("Cooking"))) / 100.0));
        int greatWhiteSharkCooked = (int) Math.floor(1260 * Math.min(1, 1 - (114 - Math.max(84,player.getLevel("Cooking"))) / 100.0));
        int wildPieCooked = (int) Math.floor(1260 * Math.min(1, 1 - (115 - Math.max(85,player.getLevel("Cooking"))) / 100.0));
        int cavefishCooked = (int) Math.floor(1260 * Math.min(1, 1 - (118 - Math.max(88,player.getLevel("Cooking"))) / 100.0));
        int wilderPieCooked = (int) Math.floor(1260 * Math.min(1, 1 - (120 - Math.max(90,player.getLevel("Cooking"))) / 100.0));
        int mantaRayCooked = (int) Math.floor(1260 * Math.min(1, 1 - (121 - Math.max(91,player.getLevel("Cooking"))) / 100.0));
        int rocktailCooked = (int) Math.floor(1260 * Math.min(1, 1 - (123 - Math.max(93,player.getLevel("Cooking"))) / 100.0));
        int blueBlubberJellyfishCooked = (int) Math.floor(1260 * Math.min(1, 1 - (125 - Math.max(95,player.getLevel("Cooking"))) / 100.0));
        database.add(new Action("Cooking raw beef", new ArrayList<>(), ImmutableMap.of("Raw beef", 1260), ImmutableMap.of("Cooked meat", beefCooked,
            "Cooking", 30 * beefCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 30 * beefCooked)), beefCooked, true, true));
        database.add(new Action("Cooking chicken", new ArrayList<>(), ImmutableMap.of("Raw chicken", 1260), ImmutableMap.of("Cooked chicken", beefCooked,
            "Cooking", 30 * beefCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 30 * beefCooked)), beefCooked, true, true));
        database.add(new Action("Cooking ugthanki meat", new ArrayList<>(), ImmutableMap.of("Raw ugthanki meat", 1260), ImmutableMap.of("Ugthanki meat", ugthankiCooked,
            "Cooking", 40 * ugthankiCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 40 * ugthankiCooked)), ugthankiCooked, true, true));
        database.add(new Action("Cooking rabbit", new ArrayList<>(), ImmutableMap.of("Raw rabbit", 1260), ImmutableMap.of("Cooked rabbit", beefCooked,
            "Cooking", 30 * beefCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 30 * beefCooked)), beefCooked, true, true));
        database.add(new Action("Cooking bird meat", Collections.singletonList(new Requirement("Cooking", 11)), ImmutableMap.of("Skewered bird meat", 1260),
            ImmutableMap.of("Roast bird meat", birdCooked, "Cooking", 62 * birdCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 62 * birdCooked)), birdCooked, true, true));
        database.add(new Action("Cooking roast rabbit", Collections.singletonList(new Requirement("Cooking", 16)), ImmutableMap.of("Skewered rabbit", 1260),
            ImmutableMap.of("Roast rabbit", rabbitCooked, "Cooking", 72 * rabbitCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 72 * rabbitCooked)), rabbitCooked, true, true));
        database.add(new Action("Cooking spiders on sticks", Collections.singletonList(new Requirement("Cooking", 16)), ImmutableMap.of("Spider on stick (raw)", 1260),
            ImmutableMap.of("Spider on stick", spiderCooked, "Cooking", 80 * spiderCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 80 * spiderCooked)), spiderCooked, true, true));
        database.add(new Action("Cooking roast beast meat", Collections.singletonList(new Requirement("Cooking", 21)), ImmutableMap.of("Skewered beast", 1260),
            ImmutableMap.of("Roast beast meat", beastCooked, "Cooking", 82 * beastCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 82 * beastCooked)), beastCooked, true, true));
        database.add(new Action("Cooking chompies", Collections.singletonList(new Requirement("Big Chompy Bird Hunting", 1)), ImmutableMap.of("Raw chompy", 1260),
            ImmutableMap.of("Cooked chompy", chompyCooked, "Cooking", 140 * chompyCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 140 * chompyCooked)), chompyCooked, true, true));
        database.add(new Action("Cooking jubblies", Collections.singletonList(new Requirement("Recipe for Disaster: Freeing Skrach Uglogwee", 1)), ImmutableMap.of("Raw jubbly", 1260),
            ImmutableMap.of("Cooked jubbly", jubblyCooked, "Cooking", 160 * jubblyCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 160 * jubblyCooked)), chompyCooked, true, true));
        database.add(new Action("Cooking wrapped oomlies", Collections.singletonList(new Requirement("Cooking", 50)), ImmutableMap.of("Wrapped oomlie", 1260),
            ImmutableMap.of("Cooked oomlie wrap", 1260, "Cooking", 138600, "Cooking pet points", totalPetPoints(player, "Cooking", 138600)), 1260, true, true));

        database.add(new Action("Cooking crayfish", new ArrayList<>(), ImmutableMap.of("Raw crayfish", 1260), ImmutableMap.of("Crayfish", beefCooked,
            "Cooking", 30 * beefCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 30 * beefCooked)), beefCooked, true, true));
        database.add(new Action("Cooking shrimps", new ArrayList<>(), ImmutableMap.of("Raw shrimps", 1260), ImmutableMap.of("Shrimps", beefCooked,
            "Cooking", 30 * beefCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 30 * beefCooked)), beefCooked, true, true));
        database.add(new Action("Cooking sardines", new ArrayList<>(), ImmutableMap.of("Raw sardine", 1260), ImmutableMap.of("Sardine", sardineCooked,
            "Cooking", 40 * sardineCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 40 * sardineCooked)), sardineCooked, true, true));
        database.add(new Action("Cooking anchovies", new ArrayList<>(), ImmutableMap.of("Raw anchovies", 1260), ImmutableMap.of("Anchovies", beefCooked,
            "Cooking", 30 * beefCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 30 * beefCooked)), beefCooked, true, true));
        database.add(new Action("Cooking herrings", Collections.singletonList(new Requirement("Cooking", 5)), ImmutableMap.of("Raw herring", 1260),
            ImmutableMap.of("Herring", herringCooked, "Cooking", 50 * herringCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 50 * herringCooked)), herringCooked, true, true));
        database.add(new Action("Cooking mackerel", Collections.singletonList(new Requirement("Cooking", 10)), ImmutableMap.of("Raw mackerel", 1260),
            ImmutableMap.of("Mackerel", mackerelCooked, "Cooking", 60 * mackerelCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 60 * mackerelCooked)), mackerelCooked, true, true));
        database.add(new Action("Cooking trout", Collections.singletonList(new Requirement("Cooking", 15)), ImmutableMap.of("Raw trout", 1260),
            ImmutableMap.of("Trout", troutCooked, "Cooking", 70 * troutCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 70 * troutCooked)), troutCooked, true, true));
        database.add(new Action("Cooking cod", Collections.singletonList(new Requirement("Cooking", 18)), ImmutableMap.of("Raw cod", 1260),
            ImmutableMap.of("Cod", codCooked, "Cooking", 75 * codCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 75 * codCooked)), codCooked, true, true));
        database.add(new Action("Cooking pike", Collections.singletonList(new Requirement("Cooking", 20)), ImmutableMap.of("Raw pike", 1260),
            ImmutableMap.of("Pike", pikeCooked, "Cooking", 80 * pikeCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 80 * pikeCooked)), pikeCooked, true, true));
        database.add(new Action("Cooking salmon", Collections.singletonList(new Requirement("Cooking", 25)), ImmutableMap.of("Raw salmon", 1260),
            ImmutableMap.of("Salmon", salmonCooked, "Cooking", 90 * salmonCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 90 * salmonCooked)), salmonCooked, true, true));
        database.add(new Action("Cooking slimy eel", Collections.singletonList(new Requirement("Cooking", 28)), ImmutableMap.of("Slimy eel", 1260), ImmutableMap.of("Cooked slimy eel",
            slimyEelCooked, "Cooking", 95 * slimyEelCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 95 * slimyEelCooked)), slimyEelCooked, true, true));
        database.add(new Action("Cooking tuna", Collections.singletonList(new Requirement("Cooking", 30)), ImmutableMap.of("Raw tuna", 1260),
            ImmutableMap.of("Tuna", tunaCooked, "Cooking", 100 * tunaCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 100 * tunaCooked)), tunaCooked, true, true));
        database.add(new Action("Cooking karambwan", Arrays.asList(new Requirement("Cooking", 30), new Requirement("Tai Bwo Wannai Trio", 1)), ImmutableMap.of("Raw karambwan", 1260),
            ImmutableMap.of("Cooked karambwan", karambwanCooked, "Cooking", 190 * karambwanCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 190 * karambwanCooked)),
            karambwanCooked, true, true));
        database.add(new Action("Cooking rainbow fish", Collections.singletonList(new Requirement("Cooking", 35)), ImmutableMap.of("Raw rainbow fish", 1260), ImmutableMap.of("Rainbow fish",
            rainbowFishCooked, "Cooking", 110 * rainbowFishCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 110 * rainbowFishCooked)), rainbowFishCooked, true, true));
        database.add(new Action("Cooking cave eel", Collections.singletonList(new Requirement("Cooking", 38)), ImmutableMap.of("Raw cave eel", 1260), ImmutableMap.of("Cave eel",
            caveEelCooked, "Cooking", 115 * caveEelCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 115 * caveEelCooked)), caveEelCooked, true, true));
        database.add(new Action("Cooking lobster", Collections.singletonList(new Requirement("Cooking", 40)), ImmutableMap.of("Raw lobsrer", 1260), ImmutableMap.of("Lobster",
            lobsterCooked, "Cooking", 120 * lobsterCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 120 * lobsterCooked)), lobsterCooked, true, true));
        database.add(new Action("Cooking bass", Collections.singletonList(new Requirement("Cooking", 43)), ImmutableMap.of("Raw bass", 1260), ImmutableMap.of("Bass",
            bassCooked, "Cooking", 130 * bassCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 130 * bassCooked)), bassCooked, true, true));
        database.add(new Action("Cooking swordfish", Collections.singletonList(new Requirement("Cooking", 45)), ImmutableMap.of("Raw swordfish", 1260), ImmutableMap.of("Swordfish",
            swordfishCooked, "Cooking", 140 * swordfishCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 140 * swordfishCooked)), swordfishCooked, true, true));
        database.add(new Action("Cooking desert sole", Collections.singletonList(new Requirement("Cooking", 52)), ImmutableMap.of("Raw desert sole", 1260), ImmutableMap.of("Desert sole",
            desertSoleCooked, "Cooking", (int)(Math.floor(142.5 * desertSoleCooked)), "Cooking pet points", totalPetPoints(player, "Cooking", (int)(Math.floor(142.5 * desertSoleCooked)))),
            desertSoleCooked, true, true));
        database.add(new Action("Cooking catfish", Collections.singletonList(new Requirement("Cooking", 60)), ImmutableMap.of("Raw catfish", 1260), ImmutableMap.of("Catfish",
            catfishCooked, "Cooking", 145 * catfishCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 145 * catfishCooked)), catfishCooked, true, true));
        database.add(new Action("Cooking monkfish", Collections.singletonList(new Requirement("Cooking", 62)), ImmutableMap.of("Raw monkfish", 1260), ImmutableMap.of("Monkfish",
            monkfishCooked, "Cooking", 150 * monkfishCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 150 * monkfishCooked)), monkfishCooked, true, true));
        database.add(new Action("Cooking beltfish", Collections.singletonList(new Requirement("Cooking", 72)), ImmutableMap.of("Raw beltfish", 1260), ImmutableMap.of("Beltfish",
            beltfishCooked, "Cooking", 165 * beltfishCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 165 * beltfishCooked)), beltfishCooked, true, true));
        database.add(new Action("Cooking green blubber jellyfish", Collections.singletonList(new Requirement("Cooking", 72)), ImmutableMap.of("Raw green blubber jellyfish", 1260),
            ImmutableMap.of("Green blubber jellyfish", beltfishCooked, "Cooking", 165 * beltfishCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 165 * beltfishCooked)),
            beltfishCooked, true, true));
        database.add(new Action("Cooking shark", Collections.singletonList(new Requirement("Cooking", 80)), ImmutableMap.of("Raw shark", 1260), ImmutableMap.of("Shark",
            sharkCooked, "Cooking", 210 * sharkCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 210 * sharkCooked)), sharkCooked, true, true));
        database.add(new Action("Cooking sea turtles", Collections.singletonList(new Requirement("Cooking", 82)), ImmutableMap.of("Raw sea turtle", 1260), ImmutableMap.of("Sea turtle",
            seaTurtleCooked, "Cooking", 212 * seaTurtleCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 212 * seaTurtleCooked)), seaTurtleCooked, true, true));
        database.add(new Action("Cooking great white sharks", Collections.singletonList(new Requirement("Cooking", 84)), ImmutableMap.of("Raw great white shark", 1260),
            ImmutableMap.of("Great white shark", greatWhiteSharkCooked, "Cooking", 212 * greatWhiteSharkCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 212 * greatWhiteSharkCooked)),
            greatWhiteSharkCooked, true, true));
        database.add(new Action("Cooking cavefish", Collections.singletonList(new Requirement("Cooking", 88)), ImmutableMap.of("Raw cavefish", 1260), ImmutableMap.of("Cavefish",
            cavefishCooked, "Cooking", 214 * cavefishCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 214 * cavefishCooked)), cavefishCooked, true, true));
        database.add(new Action("Cooking manta rays", Collections.singletonList(new Requirement("Cooking", 91)), ImmutableMap.of("Raw manta ray", 1260), ImmutableMap.of("Manta ray",
            mantaRayCooked, "Cooking", 216 * mantaRayCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 216 * mantaRayCooked)), mantaRayCooked, true, true));
        database.add(new Action("Cooking rocktails", Collections.singletonList(new Requirement("Cooking", 93)), ImmutableMap.of("Raw rocktail", 1260), ImmutableMap.of("Rocktail",
            rocktailCooked, "Cooking", 225 * rocktailCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 225 * rocktailCooked)), rocktailCooked, true, true));
        database.add(new Action("Cooking blue blubber jellyfish", Collections.singletonList(new Requirement("Cooking", 95)), ImmutableMap.of("Raw blue blubber jellyfish", 1260),
            ImmutableMap.of("Blue blubber jellyfish", blueBlubberJellyfishCooked, "Cooking", 235 * blueBlubberJellyfishCooked, "Cooking pet points",
                totalPetPoints(player, "Cooking", 235 * blueBlubberJellyfishCooked)), blueBlubberJellyfishCooked, true, true));
        database.add(new Action("Cooking sailfish", Collections.singletonList(new Requirement("Cooking", 99)), ImmutableMap.of("Raw sailfish", 1260), ImmutableMap.of("Sailfish", 882,
            "Cooking", 238140, "Cooking pet points", totalPetPoints(player, "Cooking", 238140)), 882, true, true));

        database.add(new Action("Cooking thin snails", Collections.singletonList(new Requirement("Cooking", 12)), ImmutableMap.of("Thin snail", 1260), ImmutableMap.of("Thin snail meat",
            thinSnailCooked, "Cooking", 70 * thinSnailCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 70 * thinSnailCooked)), thinSnailCooked, true, true));
        database.add(new Action("Cooking lean snails", Collections.singletonList(new Requirement("Cooking", 17)), ImmutableMap.of("Lean snail", 1260), ImmutableMap.of("Lean snail meat",
            leanSnailCooked, "Cooking", 80 * leanSnailCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 80 * leanSnailCooked)), leanSnailCooked, true, true));
        database.add(new Action("Cooking fat snails", Collections.singletonList(new Requirement("Cooking", 22)), ImmutableMap.of("Fat snail", 1260), ImmutableMap.of("Fat snail meat",
            fatSnailCooked, "Cooking", 95 * fatSnailCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 95 * fatSnailCooked)), fatSnailCooked, true, true));

        database.add(new Action("Cooking bread", new ArrayList<>(), ImmutableMap.of("Bread dough", 1260), ImmutableMap.of("Bread", breadCooked, "Cooking", 40 * breadCooked,
            "Cooking pet points", totalPetPoints(player, "Cooking", 40 * breadCooked)), breadCooked, true, true));
        database.add(new Action("Cooking pitta bread", Collections.singletonList(new Requirement("Cooking", 58)), ImmutableMap.of("Pitta dough", 1260), ImmutableMap.of("Pitta bread", 1260,
            "Cooking", 50400, "Cooking pet points", totalPetPoints(player, "Cooking", 50400)), 1260, true, true));

        database.add(new Action("Cooking redberry pies", Collections.singletonList(new Requirement("Cooking", 10)), ImmutableMap.of("Uncooked berry pie", 1260), ImmutableMap.of("Redberry pie",
            redberryPieCooked, "Cooking", 78 * redberryPieCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 78 * redberryPieCooked)), redberryPieCooked, true, true));
        database.add(new Action("Cooking meat pies", Collections.singletonList(new Requirement("Cooking", 20)), ImmutableMap.of("Uncooked meat pie", 1260), ImmutableMap.of("Meat pie",
            pikeCooked, "Cooking", 110 * pikeCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 110 * pikeCooked)), pikeCooked, true, true));
        database.add(new Action("Cooking mud pies", Collections.singletonList(new Requirement("Cooking", 29)), ImmutableMap.of("Raw mud pie", 1260), ImmutableMap.of("Mud pie",
            mudPieCooked, "Cooking", 128 * mudPieCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 128 * mudPieCooked)), mudPieCooked, true, true));
        database.add(new Action("Cooking apple pies", Collections.singletonList(new Requirement("Cooking", 30)), ImmutableMap.of("Uncooked apple pie", 1260), ImmutableMap.of("Apple pie",
            applePieCooked, "Cooking", 130 * applePieCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 130 * applePieCooked)), applePieCooked, true, true));
        database.add(new Action("Cooking garden pies", Collections.singletonList(new Requirement("Cooking", 34)), ImmutableMap.of("Raw garden pie", 1260), ImmutableMap.of("Garden pie",
            gardenPieCooked, "Cooking", 138 * gardenPieCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 138 * gardenPieCooked)), gardenPieCooked, true, true));
        database.add(new Action("Cooking fish pies", Collections.singletonList(new Requirement("Cooking", 47)), ImmutableMap.of("Raw fish pie", 1260), ImmutableMap.of("Fish pie",
            fishPieCooked, "Cooking", 164 * fishPieCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 164 * fishPieCooked)), fishPieCooked, true, true));
        database.add(new Action("Cooking admiral pies", Collections.singletonList(new Requirement("Cooking", 70)), ImmutableMap.of("Raw admiral pie", 1260), ImmutableMap.of("Admiral pie",
            admiralPieCooked, "Cooking", 210 * admiralPieCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 210 * admiralPieCooked)), admiralPieCooked, true, true));
        database.add(new Action("Cooking wild pies", Collections.singletonList(new Requirement("Cooking", 85)), ImmutableMap.of("Raw wild pie", 1260), ImmutableMap.of("Wild pie",
            wildPieCooked, "Cooking", 240 * wildPieCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 240 * wildPieCooked)), wildPieCooked, true, true));
        database.add(new Action("Cooking wilder pies", Collections.singletonList(new Requirement("Cooking", 90)), ImmutableMap.of("Raw wilder pie", 1260), ImmutableMap.of("Wilder pie",
            wilderPieCooked, "Cooking", 250 * wilderPieCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 250 * wilderPieCooked)), wilderPieCooked, true, true));
        database.add(new Action("Cooking summer pies", Collections.singletonList(new Requirement("Cooking", 95)), ImmutableMap.of("Raw summer pie", 1260), ImmutableMap.of("Summer pie",
            blueBlubberJellyfishCooked, "Cooking", 260 * blueBlubberJellyfishCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 260 * blueBlubberJellyfishCooked)),
            blueBlubberJellyfishCooked, true, true));

        database.add(new Action("Cooking stews", Collections.singletonList(new Requirement("Cooking", 25)), ImmutableMap.of("Uncooked stew", 1260), ImmutableMap.of("Stew",
            salmonCooked, "Cooking", 117 * salmonCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 117 * salmonCooked)), salmonCooked, true, true));
        database.add(new Action("Cooking curry", Collections.singletonList(new Requirement("Cooking", 60)), ImmutableMap.of("Uncooked curry", 1260), ImmutableMap.of("Curry",
            curryCooked, "Cooking", 280 * curryCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 280 * curryCooked)), curryCooked, true, true));

        database.add(new Action("Cooking plain pizzas", Collections.singletonList(new Requirement("Cooking", 35)), ImmutableMap.of("Uncooked pizza", 1260), ImmutableMap.of("Plain pizza",
            plainPizzaCooked, "Cooking", 143 * plainPizzaCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 143 * plainPizzaCooked)), plainPizzaCooked, true, true));

        database.add(new Action("Cooking cakes", Collections.singletonList(new Requirement("Cooking", 40)), ImmutableMap.of("Uncooked cake", 1260), ImmutableMap.of("Cake",
            cakeCooked, "Cooking", 180 * cakeCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 180 * cakeCooked)), cakeCooked, true, true));

        database.add(new Action("Making spicy sauce", Collections.singletonList(new Requirement("Cooking", 9)), ImmutableMap.of("Chopped garlic", 1354, "Gnome spice", 1354),
            ImmutableMap.of("Spicy sauce", 1354, "Cooking", 33850, "Cooking pet points", totalPetPoints(player, "Cooking", 33850)), 1354, true, true));
        database.add(new Action("Making chilli con carne", Collections.singletonList(new Requirement("Cooking", 9)), ImmutableMap.of("Spicy sauce", 1354, "Cooked meat", 1354),
            ImmutableMap.of("Chilli con carne", 1354, "Cooking", 33850, "Cooking pet points", totalPetPoints(player, "Cooking", 33850)), 1354, true, true));
        database.add(new Action("Cooking scrambled eggs", Collections.singletonList(new Requirement("Cooking", 13)), ImmutableMap.of("Uncooked egg", 1260), ImmutableMap.of("Scrambled egg",
            scrambledEggCooked, "Cooking", 50 * scrambledEggCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 50 * scrambledEggCooked)), scrambledEggCooked, true, true));
        database.add(new Action("Making egg and tomato", Collections.singletonList(new Requirement("Cooking", 23)), ImmutableMap.of("Scrambled egg", 1354, "Tomato", 1354),
            ImmutableMap.of("Egg and tomato", 1354, "Cooking", 67700, "Cooking pet points", totalPetPoints(player, "Cooking", 67700)), 1354, true, true));
        database.add(new Action("Cooking fried onions", Collections.singletonList(new Requirement("Cooking", 42)), ImmutableMap.of("Chopped onion", 1260), ImmutableMap.of("Fried onions",
            friedOnionCooked, "Cooking", 60 * friedOnionCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 60 * friedOnionCooked)), friedOnionCooked, true, true));
        database.add(new Action("Cooking fried mushrooms", Collections.singletonList(new Requirement("Cooking", 46)), ImmutableMap.of("Sliced mushrooms", 1260), ImmutableMap.of("Fried mushrooms",
            friedMushroomsCooked, "Cooking", 60 * friedMushroomsCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 60 * friedMushroomsCooked)), friedMushroomsCooked, true, true));
        database.add(new Action("Making mushroom & onion", Collections.singletonList(new Requirement("Cooking", 57)), ImmutableMap.of("Fried mushroom", 1354, "Fried onion", 1354),
            ImmutableMap.of("Mushroom & onion", 1354, "Cooking", 162480, "Cooking pet points", totalPetPoints(player, "Cooking", 162480)), 1354, true, true));
        database.add(new Action("Making tuna and corn", Collections.singletonList(new Requirement("Cooking", 67)), ImmutableMap.of("Cooked sweetcorn", 1354, "Chopped tuna", 1354),
            ImmutableMap.of("Tuna and corn", 1354, "Cooking", 276216, "Cooking pet points", totalPetPoints(player, "Cooking", 276216)), 1354, true, true));

        database.add(new Action("Making uncooked arc gumbo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 94)),
            ImmutableMap.of("Bundle of bamboo", 1260, "Tortle shell bowl", 1260, "Rumberry", 1260, "Fish oil", 1260, "Sea salt", 1260), ImmutableMap.of("Uncooked arc gumbo", 1260,
            "Cooking", 12600, "Cooking pet points", totalPetPoints(player, "Cooking", 12600)), 1260, true, true));
        database.add(new Action("Cooking arc gumbo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 94)),
            ImmutableMap.of("Uncooked arc gumbo", 1260), ImmutableMap.of("Arc gumbo", 1260, "Cooking", 163800, "Cooking pet points", totalPetPoints(player, "Cooking", 163800), "Azure Parrot", 21),
            1260, true, true));
        database.add(new Action("Making uncooked shark soup", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 96)),
            ImmutableMap.of("Bundle of bamboo", 1260, "Shiny tortle shell bowl", 1260, "Sliced mushrooms", 1260, "Wobbegong oil", 1260, "Alaea sea salt", 1260), ImmutableMap.of("Uncooked shark soup", 1260,
            "Cooking", 12600, "Cooking pet points", totalPetPoints(player, "Cooking", 12600)), 1260, true, true));
        database.add(new Action("Cooking shark soup", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Cooking", 96)),
            ImmutableMap.of("Uncooked shark soup", 1260), ImmutableMap.of("Shark soup", 1260, "Cooking", 302400, "Cooking pet points", totalPetPoints(player, "Cooking", 302400), "Azure Parrot", 21),
            1260, true, true));

        database.add(new Action("Making wines", Collections.singletonList(new Requirement("Cooking", 30)), ImmutableMap.of("Jug of water", 4662, "Grapes", 4662),
            ImmutableMap.of("Jug of wine", wineCooked, "Cooking", 200 * wineCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 200 * wineCooked)), wineCooked, true, true));

        database.add(new Action("Cooking sweetcorn", Collections.singletonList(new Requirement("Cooking", 28)), ImmutableMap.of("Sweetcorn", 1260), ImmutableMap.of("Cooked sweetcorn",
            sweetcornCooked, "Cooking", 104 * sweetcornCooked, "Cooking pet points", totalPetPoints(player, "Cooking", 104 * sweetcornCooked)), sweetcornCooked, true, true));


        //Crafting [27]
        database.add(new Action("Crafting molten glass", new ArrayList<>(), ImmutableMap.of("Soda ash", 1354, "Bucket of sand", 1354), ImmutableMap.of("Molten glass", 1354, "Crafting", 27080,
            "Crafting pet points", totalPetPoints(player, "Crafting", 27080)), 1354, true, true));
        database.add(new Action("Making beer glasses", new ArrayList(), ImmutableMap.of("Molten glass", 1848), ImmutableMap.of("Beer glass", 1848, "Crafting", 32340,
            "Crafting pet points", totalPetPoints(player, "Crafting", 32340)), 1848, true, true));
        database.add(new Action("Making candle lanterns", Collections.singletonList(new Requirement("Crafting", 4)), ImmutableMap.of("Molten glass", 1848),
            ImmutableMap.of("Candle lantern (empty)", 1848, "Crafting", 35112, "Crafting pet points", totalPetPoints(player, "Crafting", 35112)), 1848, true, true));
        database.add(new Action("Making oil lamps", Collections.singletonList(new Requirement("Crafting", 12)), ImmutableMap.of("Molten glass", 1848),
            ImmutableMap.of("Oil lamp (empty)", 1848, "Crafting", 46200, "Crafting pet points", totalPetPoints(player, "Crafting", 46200)), 1848, true, true));
        database.add(new Action("Making vials", Collections.singletonList(new Requirement("Crafting", 33)), ImmutableMap.of("Molten glass", 1848),
            ImmutableMap.of("Vial", 1848, "Crafting", 64680, "Crafting pet points", totalPetPoints(player, "Crafting", 64680)), 1848, true, true));
        database.add(new Action("Making fishbowls", Collections.singletonList(new Requirement("Crafting", 42)), ImmutableMap.of("Molten glass", 1848),
            ImmutableMap.of("Fishbowl", 1848, "Crafting", 78540, "Crafting pet points", totalPetPoints(player, "Crafting", 78540)), 1848, true, true));
        database.add(new Action("Making unpowered orbs", Collections.singletonList(new Requirement("Crafting", 46)), ImmutableMap.of("Molten glass", 1848),
            ImmutableMap.of("Unpowered orb", 1848, "Crafting", 97020, "Crafting pet points", totalPetPoints(player, "Crafting", 97020)), 1848, true, true));
        database.add(new Action("Making lantern lenses", Collections.singletonList(new Requirement("Crafting", 49)), ImmutableMap.of("Molten glass", 1848),
            ImmutableMap.of("Unpowered orb", 1848, "Crafting", 101640, "Crafting pet points", totalPetPoints(player, "Crafting", 101640)), 1848, true, true));
        database.add(new Action("Making empty light orbs", Collections.singletonList(new Requirement("Crafting", 87)), ImmutableMap.of("Molten glass", 1848),
            ImmutableMap.of("Empty light orb", 1848, "Crafting", 129360, "Crafting pet points", totalPetPoints(player, "Crafting", 129360)), 1848, true, true));
        database.add(new Action("Crafting light orbs", Collections.singletonList(new Requirement("Crafting", 87)), ImmutableMap.of("Empty light orb", 1820, "Cave goblin wire", 1820),
            ImmutableMap.of("Light orb", 1820, "Crafting", 189280, "Crafting pet points", totalPetPoints(player, "Crafting", 189280)), 1354, true, true));

        database.add(new Action("Spinning flax", new ArrayList(), ImmutableMap.of("Flax", 1610), ImmutableMap.of("Bowstring", 1610, "Crafting", 24150,
            "Crafting pet points", totalPetPoints(player, "Crafting", 24150)), 1610, true, true));

        database.add(new Action("Cutting opals", new ArrayList(), ImmutableMap.of("Uncut opal", 4928), ImmutableMap.of("Opal", (int) (4928 * (.5 + player.getLevel("Crafting") * .005)),
            "Crafting", (int) (18726 + 11.2 * 4928 * (.5 + player.getLevel("Crafting") * .005)), "Crafting pet points",
            totalPetPoints(player, "Crafting", (int) (18726 + 11.2 * 4928 * (.5 + player.getLevel("Crafting") * .005)))), 4928, true, true));
        database.add(new Action("Cutting jades", Collections.singletonList(new Requirement("Crafting", 13)),
            ImmutableMap.of("Uncut jade", 4928), ImmutableMap.of("Jade", (int) (4928 * (.4 + player.getLevel("Crafting") * .006)),
            "Crafting", (int) (24640 + 15 * 4928 * (.4 + player.getLevel("Crafting") * .006)), "Crafting pet points",
            totalPetPoints(player, "Crafting", (int) (24640 + 15 * 4928 * (.4 + player.getLevel("Crafting") * .006)))), 4928, true, true));
        database.add(new Action("Cutting red topaz", Collections.singletonList(new Requirement("Crafting", 16)),
            ImmutableMap.of("Uncut red topaz", 4928), ImmutableMap.of("Red topaz", (int) (4928 * (.3 + player.getLevel("Crafting") * .007)),
            "Crafting", (int) (31046 + 18.7 * 4928 * (.3 + player.getLevel("Crafting") * .007)), "Crafting pet points",
            totalPetPoints(player, "Crafting", (int) (24640 + 18.7 * 4928 * (.3 + player.getLevel("Crafting") * .007)))), 4928, true, true));
        database.add(new Action("Cutting sapphires", Collections.singletonList(new Requirement("Crafting", 20)), ImmutableMap.of("Uncut sapphire", 4928),
            ImmutableMap.of("Sapphire", 4928, "Crafting", 246400, "Crafting pet points", totalPetPoints(player, "Crafting", 246400)), 4928, true, true));
        database.add(new Action("Cutting emeralds", Collections.singletonList(new Requirement("Crafting", 27)), ImmutableMap.of("Uncut emerald", 4928),
            ImmutableMap.of("Emerald", 4928, "Crafting", 332640, "Crafting pet points", totalPetPoints(player, "Crafting", 332640)), 4928, true, true));
        database.add(new Action("Cutting rubies", Collections.singletonList(new Requirement("Crafting", 34)), ImmutableMap.of("Uncut ruby", 4928),
            ImmutableMap.of("Ruby", 4928, "Crafting", 418880, "Crafting pet points", totalPetPoints(player, "Crafting", 418880)), 4928, true, true));
        database.add(new Action("Cutting diamonds", Collections.singletonList(new Requirement("Crafting", 43)), ImmutableMap.of("Uncut diamond", 4928),
            ImmutableMap.of("Diamond", 4928, "Crafting", 529760, "Crafting pet points", totalPetPoints(player, "Crafting", 529760)), 4928, true, true));
        database.add(new Action("Cutting dragonstones", Collections.singletonList(new Requirement("Crafting", 55)), ImmutableMap.of("Uncut dragonstone", 4928),
            ImmutableMap.of("Dragonstone", 4928, "Crafting", 677600, "Crafting pet points", totalPetPoints(player, "Crafting", 677600)), 4928, true, true));
        database.add(new Action("Cutting onyxes", Collections.singletonList(new Requirement("Crafting", 72)), ImmutableMap.of("Uncut onyx", 4928),
            ImmutableMap.of("Onyx", 4928, "Crafting", 825440, "Crafting pet points", totalPetPoints(player, "Crafting", 825440)), 4928, true, true));

        database.add(new Action("Making water battlestaves", Collections.singletonList(new Requirement("Crafting", 54)), ImmutableMap.of("Battlestaff", 2625, "Water orb", 2625),
            ImmutableMap.of("Water battlestaff", 2625, "Crafting", 262500, "Crafting pet points", totalPetPoints(player, "Crafting", 262500)), 2625, true, true));
        database.add(new Action("Making earth battlestaves", Collections.singletonList(new Requirement("Crafting", 58)), ImmutableMap.of("Battlestaff", 2625, "Earth orb", 2625),
            ImmutableMap.of("Earth battlestaff", 2625, "Crafting", 295312, "Crafting pet points", totalPetPoints(player, "Crafting", 295312)), 2625, true, true));
        database.add(new Action("Making fire battlestaves", Collections.singletonList(new Requirement("Crafting", 62)), ImmutableMap.of("Battlestaff", 2625, "Fire orb", 2625),
            ImmutableMap.of("Fire battlestaff", 2625, "Crafting", 328125, "Crafting pet points", totalPetPoints(player, "Crafting", 328125)), 2625, true, true));
        database.add(new Action("Making air battlestaves", Collections.singletonList(new Requirement("Crafting", 66)), ImmutableMap.of("Battlestaff", 2625, "Air orb", 2625),
            ImmutableMap.of("Air battlestaff", 2625, "Crafting", 360937, "Crafting pet points", totalPetPoints(player, "Crafting", 360937)), 2625, true, true));

        database.add(new Action("Ithell harps (w/o VoS)", Collections.singletonList(new Requirement("Plague's End", 1)), new HashMap(),
            ImmutableMap.of("Crafting", 560 * Math.max(75,player.getLevel("Crafting")), "Harmonic dust", 7 * Math.max(75,player.getLevel("Crafting")), "Construction", 10000,
                "Crafting pet points", totalPetPoints(player, "Crafting", 560 * Math.max(75,player.getLevel("Crafting"))),
                "Construction pet points", totalPetPoints(player, "Construction", 10000)), 7 * Math.max(75,player.getLevel("Crafting")), true, true));

        database.add(new Action("Making tortle shell bowls", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Crafting", 91)),
            ImmutableMap.of("Shell chippings", 6800), ImmutableMap.of("Tortle shell bowl", 1700, "Crafting", 127500, "Crafting pet points", totalPetPoints(player, "Crafting", 127500)), 1700, true, true));
        database.add(new Action("Making shiny tortle shell bowls", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Crafting", 92)),
            ImmutableMap.of("Shiny shell chippings", 6800), ImmutableMap.of("Shiny tortle shell bowl", 1700, "Crafting", 170000, "Crafting pet points", totalPetPoints(player, "Crafting", 170000)),
            1700, true, true));
        /*
        database.add(new Action("Crafting leather gloves", new ArrayList(), ImmutableMap.of("Leather", 1836, "Thread", 459), ImmutableMap.of("Leather gloves", 1836, "Crafting", 25336,
            "Crafting pet points", totalPetPoints(player, "Crafting", 25336)), 1836, true, true));
        database.add(new Action("Crafting wizard gloves", new ArrayList(), ImmutableMap.of("Strip of cloth", 1836, "Thread", 459), ImmutableMap.of("Wizard gloves", 1836, "Crafting", 9180,
            "Crafting pet points", totalPetPoints(player, "Crafting", 9180)), 1836, true, true));
        database.add(new Action("Crafting black wizard gloves", new ArrayList(), ImmutableMap.of("Strip of black cloth", 1836, "Thread", 459), ImmutableMap.of("Black wizard gloves", 1836, "Crafting", 9180,
            "Crafting pet points", totalPetPoints(player, "Crafting", 9180)), 1836, true, true));
        database.add(new Action("Making opal rings", new ArrayList(), ImmutableMap.of("Opal", 1354, "Silver bar", 1354), ImmutableMap.of("Opal ring", 1354, "Crafting", 13540,
            "Crafting pet points", totalPetPoints(player, "Crafting", 13540)), 1354, true, true));
        database.add(new Action("Crafting wizard boots", Collections.singletonList(new Requirement("Crafting", 2)), ImmutableMap.of("Strip of cloth", 1836, "Thread", 459),
            ImmutableMap.of("Wizard boots", 1836, "Crafting", 9180, "Crafting pet points", totalPetPoints(player, "Crafting", 9180)), 1836, true, true));
        database.add(new Action("Crafting black wizard boots", Collections.singletonList(new Requirement("Crafting", 2)), ImmutableMap.of("Strip of black cloth", 1836, "Thread", 459),
            ImmutableMap.of("Black wizard boots", 1836, "Crafting", 9180, "Crafting pet points", totalPetPoints(player, "Crafting", 9180)), 1836, true, true));
        database.add(new Action("Making cracked divination urns (nr)", Collections.singletonList(new Requirement("Crafting", 3)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Cracked divination urn (nr)", 560, "Crafting", 16800, "Crafting pet points", totalPetPoints(player, "Crafting", 16800)), 560, true, true));
        database.add(new Action("Making cracked hunter urns (nr)", Collections.singletonList(new Requirement("Crafting", 3)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Cracked hunter urn (nr)", 560, "Crafting", 16800, "Crafting pet points", totalPetPoints(player, "Crafting", 16800)), 560, true, true));
        database.add(new Action("Crafting wizard hats", Collections.singletonList(new Requirement("Crafting", 3)), ImmutableMap.of("Strip of cloth", 1836, "Thread", 459),
            ImmutableMap.of("Wizard hat (blue)", 1836, "Crafting", 9180, "Crafting pet points", totalPetPoints(player, "Crafting", 9180)), 1836, true, true));
        database.add(new Action("Crafting black wizard hats", Collections.singletonList(new Requirement("Crafting", 3)), ImmutableMap.of("Strip of black cloth", 1836, "Thread", 459),
            ImmutableMap.of("Black wizard hat", 1836, "Crafting", 9180, "Crafting pet points", totalPetPoints(player, "Crafting", 9180)), 1836, true, true));
        database.add(new Action("Crafting fungal visors", Collections.singletonList(new Requirement("Crafting", 3)), ImmutableMap.of("Mycelium visor web", 1836, "Fungal flake", 550800),
            ImmutableMap.of("Fungal visor", 1836, "Crafting", 27540, "Crafting pet points", totalPetPoints(player, "Crafting", 27540)), 1836, true, true));
        database.add(new Action("Making unfired clay rings", Collections.singletonList(new Requirement("Crafting", 4)), ImmutableMap.of("Soft clay", 1568), ImmutableMap.of("Clay ring (unfired)", 1568,
            "Crafting", 17718, "Crafting pet points", totalPetPoints(player, "Crafting", 17718)), 1568, true, true));
        database.add(new Action("Firing unfired clay rings", Collections.singletonList(new Requirement("Crafting", 4)), ImmutableMap.of("Clay ring (unfired)", 868),
            ImmutableMap.of("Clay ring", 868, "Crafting", 9548, "Crafting pet points", totalPetPoints(player, "Crafting", 9548)), 868, true, true));
        database.add(new Action("Making cracked runecrafting urns (nr)", Collections.singletonList(new Requirement("Crafting", 4)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Cracked runecrafting urn (nr)", 560, "Crafting", 16800, "Crafting pet points", totalPetPoints(player, "Crafting", 16800)), 560, true, true));
        database.add(new Action("Making cracked smelting urns (nr)", Collections.singletonList(new Requirement("Crafting", 4)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Cracked smelting urn (nr)", 560, "Crafting", 21560, "Crafting pet points", totalPetPoints(player, "Crafting", 21560)), 560, true, true));
        database.add(new Action("Making cracked woodcutting urns (nr)", Collections.singletonList(new Requirement("Crafting", 4)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Cracked woodcutting urn (nr)", 560, "Crafting", 21560, "Crafting pet points", totalPetPoints(player, "Crafting", 21560)), 560, true, true));
        database.add(new Action("Crafting wizard robe skirts", Collections.singletonList(new Requirement("Crafting", 4)), ImmutableMap.of("Strip of cloth", 3458, "Thread", 432),
            ImmutableMap.of("Wizard robe skirt", 1729, "Crafting", 17290, "Crafting pet points", totalPetPoints(player, "Crafting", 17290)), 1729, true, true));
        database.add(new Action("Crafting black wizard robe skirts", Collections.singletonList(new Requirement("Crafting", 4)), ImmutableMap.of("Strip of black cloth", 3458, "Thread", 459),
            ImmutableMap.of("Black wizard robe skirt", 1729, "Crafting", 17290, "Crafting pet points", totalPetPoints(player, "Crafting", 17290)), 1836, true, true));
        database.add(new Action("Making cracked farming urns (nr)", Collections.singletonList(new Requirement("Crafting", 5)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Cracked farming urn (nr)", 560, "Crafting", 16800, "Crafting pet points", totalPetPoints(player, "Crafting", 16800)), 560, true, true));
        database.add(new Action("Crafting wizard robe tops", Collections.singletonList(new Requirement("Crafting", 5)), ImmutableMap.of("Strip of cloth", 3458, "Thread", 432),
            ImmutableMap.of("Wizard robe top", 1729, "Crafting", 17290, "Crafting pet points", totalPetPoints(player, "Crafting", 17290)), 1729, true, true));
        database.add(new Action("Crafting black wizard robe tops", Collections.singletonList(new Requirement("Crafting", 5)), ImmutableMap.of("Strip of black cloth", 3458, "Thread", 459),
            ImmutableMap.of("Black wizard robe top", 1729, "Crafting", 17290, "Crafting pet points", totalPetPoints(player, "Crafting", 17290)), 1836, true, true));
        database.add(new Action("Crafting gold rings", Collections.singletonList(new Requirement("Crafting", 5)), ImmutableMap.of("Gold bar", 1615),
            ImmutableMap.of("Gold ring", 1615, "Crafting", 24225, "Crafting pet points", totalPetPoints(player, "Crafting", 24225)), 1615, true, true));
        database.add(new Action("Crafting wizard books", Collections.singletonList(new Requirement("Crafting", 6)), ImmutableMap.of("Strip of cloth", 4908, "Thread", 409),
            ImmutableMap.of("Wizard book", 1636, "Crafting", 24540, "Crafting pet points", totalPetPoints(player, "Crafting", 24540)), 1636, true, true));
        database.add(new Action("Crafting gold necklaces", Collections.singletonList(new Requirement("Crafting", 6)), ImmutableMap.of("Gold bar", 1615),
            ImmutableMap.of("Gold necklace", 1615, "Crafting", 32300, "Crafting pet points", totalPetPoints(player, "Crafting", 32300)), 1615, true, true));
        database.add(new Action("Crafting wizard wands", Collections.singletonList(new Requirement("Crafting", 7)), ImmutableMap.of("Strip of cloth", 4908, "Thread", 409),
            ImmutableMap.of("Wizard wand", 1636, "Crafting", 24540, "Crafting pet points", totalPetPoints(player, "Crafting", 24540)), 1636, true, true));
        database.add(new Action("Making unfired pie dishes", Collections.singletonList(new Requirement("Crafting", 7)), ImmutableMap.of("Soft clay", 1568), ImmutableMap.of("Pie dish (unfired)", 1568,
            "Crafting", 23520, "Crafting pet points", totalPetPoints(player, "Crafting", 23520)), 1568, true, true));
        database.add(new Action("Firing unfired pie dishes", Collections.singletonList(new Requirement("Crafting", 7)), ImmutableMap.of("Pie dish (unfired)", 868),
            ImmutableMap.of("Pie dish", 868, "Crafting", 8680, "Crafting pet points", totalPetPoints(player, "Crafting", 8680)), 868, true, true));
        database.add(new Action("Crafting leather boots", Collections.singletonList(new Requirement("Crafting", 7)), ImmutableMap.of("Leather", 1836, "Thread", 459),
            ImmutableMap.of("Leather boots", 1836, "Crafting", 29835, "Crafting pet points", totalPetPoints(player, "Crafting", 29835)), 1836, true, true));
        database.add(new Action("Crafting gold bracelets", Collections.singletonList(new Requirement("Crafting", 7)), ImmutableMap.of("Gold bar", 1615),
            ImmutableMap.of("Gold bracelet", 1615, "Crafting", 40375, "Crafting pet points", totalPetPoints(player, "Crafting", 40375)), 1615, true, true));
        database.add(new Action("Making unfired bowls", Collections.singletonList(new Requirement("Crafting", 8)), ImmutableMap.of("Soft clay", 1568), ImmutableMap.of("Bowl (unfired)", 1568,
            "Crafting", 28224, "Crafting pet points", totalPetPoints(player, "Crafting", 28224)), 1568, true, true));
        database.add(new Action("Firing unfired bowls", Collections.singletonList(new Requirement("Crafting", 8)), ImmutableMap.of("Bowl (unfired)", 868),
            ImmutableMap.of("Bowl", 868, "Crafting", 10416, "Crafting pet points", totalPetPoints(player, "Crafting", 10416)), 868, true, true));
        database.add(new Action("Crafting wizard shields", Collections.singletonList(new Requirement("Crafting", 8)), ImmutableMap.of("Strip of cloth", 4908, "Thread", 409),
            ImmutableMap.of("Wizard shield", 1636, "Crafting", 24540, "Crafting pet points", totalPetPoints(player, "Crafting", 24540)), 1636, true, true));
        database.add(new Action("Crafting black wizard shields", Collections.singletonList(new Requirement("Crafting", 8)), ImmutableMap.of("Strip of black cloth", 4908, "Thread", 409),
            ImmutableMap.of("Black wizard shield", 1636, "Crafting", 24540, "Crafting pet points", totalPetPoints(player, "Crafting", 24540)), 1636, true, true));
        database.add(new Action("Crafting gold amulets", Collections.singletonList(new Requirement("Crafting", 8)), ImmutableMap.of("Gold bar", 1615),
            ImmutableMap.of("Gold amulet (unstrung)", 1615, "Crafting", 48450, "Crafting pet points", totalPetPoints(player, "Crafting", 48450)), 1615, true, true));
        database.add(new Action("Crafting leather cowls", Collections.singletonList(new Requirement("Crafting", 9)), ImmutableMap.of("Leather", 1836, "Thread", 459),
            ImmutableMap.of("Leather cowl", 1836, "Crafting", 33966, "Crafting pet points", totalPetPoints(player, "Crafting", 33966)), 1836, true, true));
        database.add(new Action("Crafting imphide gloves", Collections.singletonList(new Requirement("Crafting", 10)), ImmutableMap.of("Imphide", 1836, "Thread", 459),
            ImmutableMap.of("Imphide gloves", 1836, "Crafting", 18360, "Crafting pet points", totalPetPoints(player, "Crafting", 18360)), 1836, true, true));
        database.add(new Action("Spinning maple roots", Collections.singletonList(new Requirement("Crafting", 10)), ImmutableMap.of("Maple roots", 1400),
            ImmutableMap.of("Crossbow string", 1400, "Crafting", 21000, "Crafting pet points", totalPetPoints(player, "Crafting", 21000)), 1400, true, true));
        database.add(new Action("Crafting leather vambraces", Collections.singletonList(new Requirement("Crafting", 11)), ImmutableMap.of("Leather", 1836, "Thread", 459),
            ImmutableMap.of("Leather vambraces", 1836, "Crafting", 40392, "Crafting pet points", totalPetPoints(player, "Crafting", 40392)), 1836, true, true));
        database.add(new Action("Crafting imphide boots", Collections.singletonList(new Requirement("Crafting", 11)), ImmutableMap.of("Imphide", 1836, "Thread", 459),
            ImmutableMap.of("Imphide boots", 1836, "Crafting", 18360, "Crafting pet points", totalPetPoints(player, "Crafting", 18360)), 1836, true, true));
        database.add(new Action("Making fragile cooking urns (nr)", Collections.singletonList(new Requirement("Crafting", 12)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Fragile cooking urn (nr)", 560, "Crafting", 22400, "Crafting pet points", totalPetPoints(player, "Crafting", 22400)), 560, true, true));
        database.add(new Action("Crafting imphide hoods", Collections.singletonList(new Requirement("Crafting", 12)), ImmutableMap.of("Imphide", 3458, "Thread", 422),
            ImmutableMap.of("Imphide hood", 1729, "Crafting", 34580, "Crafting pet points", totalPetPoints(player, "Crafting", 34580)), 1729, true, true));
        database.add(new Action("Crafting fungal leggings", Collections.singletonList(new Requirement("Crafting", 12)), ImmutableMap.of("Mycelium leggings web", 1836, "Fungal flake", 1836000),
            ImmutableMap.of("Fungal leggings", 1836, "Crafting", 91800, "Crafting pet points", totalPetPoints(player, "Crafting", 91800)), 1836, true, true));
        database.add(new Action("Crafting imphide robe bottoms", Collections.singletonList(new Requirement("Crafting", 13)), ImmutableMap.of("Imphide", 3458, "Thread", 422),
            ImmutableMap.of("Imphide robe bottom", 1729, "Crafting", 34580, "Crafting pet points", totalPetPoints(player, "Crafting", 34580)), 1729, true, true));
        database.add(new Action("Making jade rings", Collections.singletonList(new Requirement("Crafting", 13)), ImmutableMap.of("Jade", 1354, "Silver bar", 1354),
            ImmutableMap.of("Jade ring", 1354, "Crafting", 17602, "Crafting pet points", totalPetPoints(player, "Crafting", 17602)), 1354, true, true));
        database.add(new Action("Crafting leather bodies", Collections.singletonList(new Requirement("Crafting", 14)), ImmutableMap.of("Leather", 1836, "Thread", 459),
            ImmutableMap.of("Leather body", 1836, "Crafting", 45900, "Crafting pet points", totalPetPoints(player, "Crafting", 45900)), 1836, true, true));
        database.add(new Action("Crafting imphide robe tops", Collections.singletonList(new Requirement("Crafting", 14)), ImmutableMap.of("Imphide", 4908, "Thread", 409),
            ImmutableMap.of("Imphide robe top", 1636, "Crafting", 49080, "Crafting pet points", totalPetPoints(player, "Crafting", 49080)), 1636, true, true));
        database.add(new Action("Making fragile fishing urns (nr)", Collections.singletonList(new Requirement("Crafting", 15)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Fragile fishing urn (nr)", 560, "Crafting", 28000, "Crafting pet points", totalPetPoints(player, "Crafting", 28000)), 560, true, true));
        database.add(new Action("Making fragile woodcutting urns (nr)", Collections.singletonList(new Requirement("Crafting", 15)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Fragile woodcutting urn (nr)", 560, "Crafting", 28000, "Crafting pet points", totalPetPoints(player, "Crafting", 28000)), 560, true, true));
        database.add(new Action("Crafting imphide books", Collections.singletonList(new Requirement("Crafting", 15)), ImmutableMap.of("Imphide", 4908, "Thread", 409),
            ImmutableMap.of("Imphide book", 1636, "Crafting", 49080, "Crafting pet points", totalPetPoints(player, "Crafting", 49080)), 1636, true, true));
        database.add(new Action("Making snelms", Collections.singletonList(new Requirement("Crafting", 15)), ImmutableMap.of("Blamish red shell (pointed)", 1848),
            ImmutableMap.of("Blood'n'tar snelm (pointed)", 1848, "Crafting", 60060, "Crafting pet points", totalPetPoints(player, "Crafting", 60060)), 1848, true, true));
        database.add(new Action("Making unstrung symbols", Collections.singletonList(new Requirement("Crafting", 16)), ImmutableMap.of("Silver bar", 1615),
            ImmutableMap.of("Unstrung symbol", 1615, "Crafting", 80750, "Crafting pet points", totalPetPoints(player, "Crafting", 80750)), 1615, true, true));
        database.add(new Action("Crafting imp horn wands", Collections.singletonList(new Requirement("Crafting", 16)), ImmutableMap.of("Imphide", 4908, "Thread", 409),
            ImmutableMap.of("Imp horn wand", 1636, "Crafting", 49080, "Crafting pet points", totalPetPoints(player, "Crafting", 49080)), 1636, true, true));
        database.add(new Action("Making fragile divination urns (nr)", Collections.singletonList(new Requirement("Crafting", 16)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Fragile divination urn (nr)", 560, "Crafting", 22400, "Crafting pet points", totalPetPoints(player, "Crafting", 22400)), 560, true, true));
        database.add(new Action("Making opal necklaces", Collections.singletonList(new Requirement("Crafting", 16)), ImmutableMap.of("Opal", 1354, "Silver bar", 1354),
            ImmutableMap.of("Opal necklace", 1354, "Crafting", 15571, "Crafting pet points", totalPetPoints(player, "Crafting", 15571)), 1354, true, true));
        database.add(new Action("Making topaz rings", Collections.singletonList(new Requirement("Crafting", 16)), ImmutableMap.of("Red topaz", 1354, "Silver bar", 1354),
            ImmutableMap.of("Topaz ring", 1354, "Crafting", 20310, "Crafting pet points", totalPetPoints(player, "Crafting", 20310)), 1354, true, true));
        database.add(new Action("Making fragile hunter urns (nr)", Collections.singletonList(new Requirement("Crafting", 17)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Fragile hunter urn (nr)", 560, "Crafting", 22400, "Crafting pet points", totalPetPoints(player, "Crafting", 22400)), 560, true, true));
        database.add(new Action("Making fragile mining urns (nr)", Collections.singletonList(new Requirement("Crafting", 17)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Fragile mining urn (nr)", 560, "Crafting", 29680, "Crafting pet points", totalPetPoints(player, "Crafting", 29680)), 560, true, true));
        database.add(new Action("Making fragile smelting urns (nr)", Collections.singletonList(new Requirement("Crafting", 17)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Fragile smelting urn (nr)", 560, "Crafting", 29680, "Crafting pet points", totalPetPoints(player, "Crafting", 29680)), 560, true, true));
        database.add(new Action("Crafting imphide shield", Collections.singletonList(new Requirement("Crafting", 17)), ImmutableMap.of("Imphide", 6000, "Thread", 375),
            ImmutableMap.of("Imphide shield", 1500, "Crafting", 60000, "Crafting pet points", totalPetPoints(player, "Crafting", 60000)), 1500, true, true));
        database.add(new Action("Making unpowered symbols", Collections.singletonList(new Requirement("Crafting", 17)), ImmutableMap.of("Silver bar", 1615),
            ImmutableMap.of("Unpowered symbol", 1615, "Crafting", 80750, "Crafting pet points", totalPetPoints(player, "Crafting", 80750)), 1615, true, true));
        database.add(new Action("Making fragile farming urns (nr)", Collections.singletonList(new Requirement("Crafting", 18)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Fragile farming urn (nr)", 560, "Crafting", 22400, "Crafting pet points", totalPetPoints(player, "Crafting", 22400)), 560, true, true));
        database.add(new Action("Making fragile runecrafting urns (nr)", Collections.singletonList(new Requirement("Crafting", 18)), ImmutableMap.of("Soft clay", 1120),
            ImmutableMap.of("Fragile runecrafting urn (nr)", 560, "Crafting", 22400, "Crafting pet points", totalPetPoints(player, "Crafting", 22400)), 560, true, true));
        database.add(new Action("Crafting leather chaps", Collections.singletonList(new Requirement("Crafting", 18)), ImmutableMap.of("Leather", 1836, "Thread", 459),
            ImmutableMap.of("Leather chaps", 1836, "Crafting", 49572, "Crafting pet points", totalPetPoints(player, "Crafting", 49572)), 1836, true, true));
        database.add(new Action("Making unfired plant pots", Collections.singletonList(new Requirement("Crafting", 19)), ImmutableMap.of("Soft clay", 1568), ImmutableMap.of("Unfired plant pot", 1568,
            "Crafting", 31360, "Crafting pet points", totalPetPoints(player, "Crafting", 31360)), 1568, true, true));
        database.add(new Action("Firing unfired plant pots", Collections.singletonList(new Requirement("Crafting", 19)), ImmutableMap.of("Unfired plant pot", 868),
            ImmutableMap.of("Plant pot", 868, "Crafting", 15190, "Crafting pet points", totalPetPoints(player, "Crafting", 15190)), 868, true, true));
        database.add(new Action("Crafting leather shields", Collections.singletonList(new Requirement("Crafting", 19)), ImmutableMap.of("Leather", 1836, "Thread", 459),
            ImmutableMap.of("Leather shield", 1836, "Crafting", 55080, "Crafting pet points", totalPetPoints(player, "Crafting", 55080)), 1836, true, true));
        database.add(new Action("Spinning magic roots", Collections.singletonList(new Requirement("Crafting", 19)), ImmutableMap.of("Magic roots", 1400),
            ImmutableMap.of("Magic string", 1400, "Crafting", 42000, "Crafting pet points", totalPetPoints(player, "Crafting", 42000)), 1400, true, true));
*/

        //Divination (1300 harvests, 900 base conversions, 1100 effective conversions (w/ enr)) (done to lv19)
        database.add(new Action("Pale wisps (w/o bought energy)", new ArrayList<>(), new HashMap<>(),
            ImmutableMap.of("Divination", 4000, "Pale energy", 1300, "Memory strand", 288, "Divination level-ticks", 6000 * player.getLevel("Divination")), 1300, true, true));
        database.add(new Action("Pale wisps (w/ bought energy)", new ArrayList<>(), ImmutableMap.of("Pale energy", 3200),
            ImmutableMap.of("Divination", 4630, "Memory strand", 288, "Divination level-ticks", 6000 * player.getLevel("Divination")), 1300, true, true));
        database.add(new Action("Flickering wisps (w/o bought energy)", Collections.singletonList(new Requirement("Business is Booning!", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 7700, "Flickering energy", 1300, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(10, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Flickering wisps (w/ bought energy)", Collections.singletonList(new Requirement("Business is Booning!", 1)), ImmutableMap.of("Flickering energy", 4200),
            ImmutableMap.of("Divination", 8910, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(10, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Bright wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 20)), new HashMap<>(),
            ImmutableMap.of("Divination", 9950, "Bright energy", 1300, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(20, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Bright wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 20)), ImmutableMap.of("Bright energy", 4200),
            ImmutableMap.of("Divination", 11380, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(20, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Glowing wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 30)), new HashMap<>(),
            ImmutableMap.of("Divination", 13670, "Glowing energy", 1300, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(30, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Glowing wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 30)), ImmutableMap.of("Glowing energy", 4200),
            ImmutableMap.of("Divination", 15650, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(30, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Sparkling wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 40)), new HashMap<>(),
            ImmutableMap.of("Divination", 21020, "Sparkling energy", 1300, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(40, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Sparkling wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 40)), ImmutableMap.of("Sparkling energy", 4200),
            ImmutableMap.of("Divination", 24650, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(40, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Gleaming wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 50)), new HashMap<>(),
            ImmutableMap.of("Divination", 30790, "Gleaming energy", 1300, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(50, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Gleaming wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 50)), ImmutableMap.of("Gleaming energy", 4200),
            ImmutableMap.of("Divination", 36400, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(50, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Gleaming wisps (w/o bought energy, 2 per harvest)", Collections.singletonList(new Requirement("Divination", 55)), new HashMap<>(),
            ImmutableMap.of("Divination", 30790, "Gleaming energy", 2600, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(55, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Gleaming wisps (w/ bought energy, 2 per harvest)", Collections.singletonList(new Requirement("Divination", 55)), ImmutableMap.of("Gleaming energy", 2900),
            ImmutableMap.of("Divination", 36400, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(55, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Vibrant wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 60)), new HashMap<>(),
            ImmutableMap.of("Divination", 39350, "Vibrant energy", 2600, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(60, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Vibrant wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 60)), ImmutableMap.of("Vibrant energy", 2900),
            ImmutableMap.of("Divination", 46830, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(60, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Lustrous wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 70)), new HashMap<>(),
            ImmutableMap.of("Divination", 49120, "Lustrous energy", 2600, "Memory strand", 288, "Divination fragments", 1200, "Divination level-ticks",
                6000 * Math.max(70, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Lustrous wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 70)), ImmutableMap.of("Lustrous energy", 2900),
            ImmutableMap.of("Divination", 58800, "Memory strand", 288, "Divination fragments", 1200, "Divination level-ticks", 6000 * Math.max(70, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Elder wisps (w/o bought energy)", Collections.singletonList(new Requirement("Fate of the Gods", 1)), new HashMap(), ImmutableMap.builder().put("Divination", 51530)
            .put("Elder energy", 3900).put("Elder chronicle fragment", 4).put("Hunter", player.getLevel("Hunter") * 40).put("Memory strand", 288)
            .put("Divination level-ticks", 6000 * Math.max(75, player.getLevel("Divination"))).put("Divination fragments", 1200).build(), 1300, true, true));
        database.add(new Action("Elder wisps (w/ bought energy)", Collections.singletonList(new Requirement("Fate of the Gods", 1)), ImmutableMap.of("Elder energy", 1600),
            ImmutableMap.builder().put("Divination", 61540).put("Elder chronicle fragment", 4).put("Hunter", player.getLevel("Hunter") * 40).put("Memory strand", 288)
            .put("Divination level-ticks", 6000 * Math.max(75, player.getLevel("Divination"))).put("Divination fragments", 1200).build(), 1300, true, true));
        database.add(new Action("Brilliant wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 80)), new HashMap<>(),
            ImmutableMap.of("Divination", 54050, "Brilliant energy", 2600, "Memory strand", 288, "Divination fragments", 1200, "Divination level-ticks",
                6000 * Math.max(80, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Brilliant wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 80)), ImmutableMap.of("Brilliant energy", 1600),
            ImmutableMap.of("Divination", 64500, "Memory strand", 288, "Divination fragments", 1200, "Divination level-ticks", 6000 * Math.max(80, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Radiant wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 85)), new HashMap<>(),
            ImmutableMap.of("Divination", 58980, "Radiant energy", 2600, "Memory strand", 288, "Divination fragments", 1200, "Divination level-ticks",
                6000 * Math.max(85, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Radiant wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 85)), ImmutableMap.of("Radiant energy", 1600),
            ImmutableMap.of("Divination", 70420, "Memory strand", 288, "Divination fragments", 1200, "Divination level-ticks", 6000 * Math.max(85, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Luminous wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 90)),
            new HashMap(), ImmutableMap.builder().put("Divination", 65120).put("Luminous energy", 3900).put("Fly dragon", 1).put("Fruit fly", 1).put("Memory strand", 288)
            .put("Divination level-ticks", 6000 * Math.max(90, player.getLevel("Divination"))).put("Divination fragments", 1200).build(), 1300, true, true));
        database.add(new Action("Luminous wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 90)),
            ImmutableMap.of("Luminous energy", 1600), ImmutableMap.builder().put("Divination", 77770).put("Fly dragon", 1).put("Fruit fly", 1).put("Memory strand", 288)
            .put("Divination level-ticks", 6000 * Math.max(90, player.getLevel("Divination"))).put("Divination fragments", 1200).build(), 1300, true, true));
        database.add(new Action("Incandescent wisps (w/o bought energy)", Collections.singletonList(new Requirement("Divination", 95)), new HashMap<>(),
            ImmutableMap.of("Divination", 70050, "Incandescent energy", 2600, "Memory strand", 288, "Divination fragments", 1200, "Divination level-ticks",
                6000 * Math.max(95, player.getLevel("Divination"))), 1300, true, true));
        database.add(new Action("Incandescent wisps (w/ bought energy)", Collections.singletonList(new Requirement("Divination", 95)), ImmutableMap.of("Incandescent energy", 1600),
            ImmutableMap.of("Divination", 83580, "Memory strand", 288, "Divination fragments", 1200, "Divination level-ticks", 6000 * Math.max(95, player.getLevel("Divination"))), 1300, true, true));


        database.add(new Action("Cursed wisps (level 1-9, w/o skull)", new ArrayList(), new HashMap<>(), ImmutableMap.of("Divination", 7650, "Pale energy", 1950, "Memory strand", 288,
            "Divination level-ticks", 6000 * player.getLevel("Divination")), 1300, true, false));
        database.add(new Action("Cursed wisps (level 1-9, w/ skull)", Collections.singletonList(new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 8790, "Pale energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * player.getLevel("Divination")), 1300, true, false));
        database.add(new Action("Cursed wisps (level 10-19, w/o skull)", Collections.singletonList(new Requirement("Divination", 10)), new HashMap<>(),
            ImmutableMap.of("Divination", 10050, "Flickering energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(10, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 10-19, w/ skull)", Arrays.asList(new Requirement("Divination", 10), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 11670, "Flickering energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(10, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 20-29, w/o skull)", Collections.singletonList(new Requirement("Divination", 20)), new HashMap<>(),
            ImmutableMap.of("Divination", 12450, "Bright energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(20, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 20-29, w/ skull)", Arrays.asList(new Requirement("Divination", 20), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 14550, "Bright energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(20, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 30-39, w/o skull)", Collections.singletonList(new Requirement("Divination", 30)), new HashMap<>(),
            ImmutableMap.of("Divination", 15950, "Glowing energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(30, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 30-39, w/ skull)", Arrays.asList(new Requirement("Divination", 30), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 18750, "Glowing energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(30, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 40-49, w/o skull)", Collections.singletonList(new Requirement("Divination", 40)), new HashMap<>(),
            ImmutableMap.of("Divination", 22750, "Sparkling energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(40, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 40-49, w/ skull)", Arrays.asList(new Requirement("Divination", 40), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 26910, "Sparkling energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(40, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 50-54, w/o skull)", Collections.singletonList(new Requirement("Divination", 50)), new HashMap<>(),
            ImmutableMap.of("Divination", 33950, "Gleaming energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(50, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 50-54, w/ skull)", Arrays.asList(new Requirement("Divination", 50), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 40350, "Gleaming energy", 1950, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(50, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 55-59, w/o skull)", Collections.singletonList(new Requirement("Divination", 55)), new HashMap<>(),
            ImmutableMap.of("Divination", 35900, "Gleaming energy", 3900, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(55, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 55-59, w/ skull)", Arrays.asList(new Requirement("Divination", 55), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 42300, "Gleaming energy", 3900, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(55, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 60-69, w/o skull)", Collections.singletonList(new Requirement("Divination", 60)), new HashMap<>(),
            ImmutableMap.of("Divination", 44900, "Vibrant energy", 3900, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(60, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 60-69, w/ skull)", Arrays.asList(new Requirement("Divination", 60), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 53100, "Vibrant energy", 3900, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(60, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 70-74, w/o skull)", Collections.singletonList(new Requirement("Divination", 70)), new HashMap<>(),
            ImmutableMap.of("Divination", 53900, "Lustrous energy", 3900, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(70, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 70-74, w/ skull)", Arrays.asList(new Requirement("Divination", 70), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 63900, "Lustrous energy", 3900, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(70, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 75-79, w/o skull)", Collections.singletonList(new Requirement("Divination", 75)), new HashMap<>(),
            ImmutableMap.of("Divination", 55850, "Lustrous energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(75, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 75-79, w/ skull)", Arrays.asList(new Requirement("Divination", 75), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 65850, "Lustrous energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(75, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 80-84, w/o skull)", Collections.singletonList(new Requirement("Divination", 80)), new HashMap<>(),
            ImmutableMap.of("Divination", 62650, "Brilliant energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(80, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 80-84, w/ skull)", Arrays.asList(new Requirement("Divination", 80), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 74010, "Brilliant energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(80, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 85-89, w/o skull)", Collections.singletonList(new Requirement("Divination", 85)), new HashMap<>(),
            ImmutableMap.of("Divination", 69450, "Radiant energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(85, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 85-89, w/ skull)", Arrays.asList(new Requirement("Divination", 85), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 82170, "Radiant energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(85, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 90-94, w/o skull)", Collections.singletonList(new Requirement("Divination", 90)), new HashMap<>(),
            ImmutableMap.of("Divination", 78450, "Luminous energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(90, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 90-94, w/ skull)", Arrays.asList(new Requirement("Divination", 90), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 92970, "Luminous energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(90, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 95+, w/o skull)", Collections.singletonList(new Requirement("Divination", 95)), new HashMap<>(),
            ImmutableMap.of("Divination", 91850, "Incandescent energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(95, player.getLevel("Divination"))), 1300, true, false));
        database.add(new Action("Cursed wisps (level 95+, w/ skull)", Arrays.asList(new Requirement("Divination", 95), new Requirement("Demonic skull", 1)), new HashMap<>(),
            ImmutableMap.of("Divination", 109050, "Incandescent energy", 5850, "Memory strand", 288, "Divination level-ticks", 6000 * Math.max(95, player.getLevel("Divination"))), 1300, true, false));

        database.add(new Action("Empty Throne Room divination", Arrays.asList(new Requirement("Divination", 65), new Requirement("The Dig Site", 1)), new HashMap(),
            ImmutableMap.of("Divination", 65000, "Divination level-ticks", 6000 * Math.max(65, player.getLevel("Divination"))), 1500, true, true));

        database.add(new Action("Positive springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 90)), new HashMap(), ImmutableMap.of("Divination", 60300, "Positive energy", 600, "Memory strand", 288,
            "Divination level-ticks", 6000 * Math.max(90, player.getLevel("Divination")), "Divination fragments", 1200), 600, true, true));
        database.add(new Action("Ancestral springs", Arrays.asList(new Requirement("Impressing the Locals", 1),
            new Requirement("Divination", 95)), new HashMap(), ImmutableMap.builder().put("Divination", 96300).put("Ancestral energy", 600).put("Cyansoul Kakapo", 1).put("Memory strand", 288)
            .put("Divination level-ticks", 6000 * Math.max(95, player.getLevel("Divination"))).put("Divination fragments", 1200).build(), 600, true, true));

        database.add(new Action("Hall of Memories (lustrous)", Collections.singletonList(new Requirement("Divination", 70)), new HashMap(), ImmutableMap.of("Lustrous hall memories", 300,
            "Divination", 60000, "Divination level-ticks", 6000 * Math.max(70, player.getLevel("Divination"))), 1500, true, true));

        database.add(new Action("Hall of Memories (brilliant)", Collections.singletonList(new Requirement("Divination", 80)), new HashMap(), ImmutableMap.of("Brilliant hall memories", 300,
            "Divination", 90000, "Divination level-ticks", 6000 * Math.max(80, player.getLevel("Divination"))), 1500, true, true));

        database.add(new Action("Hall of Memories (radiant)", Collections.singletonList(new Requirement("Divination", 85)), new HashMap(), ImmutableMap.of("Radiant hall memories", 300,
            "Divination", 135000, "Divination level-ticks", 6000 * Math.max(85, player.getLevel("Divination"))), 1500, true, true));

        database.add(new Action("Hall of Memories (luminous)", Collections.singletonList(new Requirement("Divination", 90)), new HashMap(), ImmutableMap.of("Luminous hall memories", 300,
            "Divination", 200000, "Divination level-ticks", 6000 * Math.max(90, player.getLevel("Divination"))), 1500, true, true));

        database.add(new Action("Hall of Memories (incandescent)", Collections.singletonList(new Requirement("Divination", 95)), new HashMap(), ImmutableMap.of("Incandescent hall memories", 300,
            "Divination", 300000, "Divination level-ticks", 6000 * Math.max(95, player.getLevel("Divination"))), 1500, true, true));

        //Dungeoneering (done) (major approximation, assumes 7.5 minute floors)
        //4000 * Math.pow((player.getLevel("Dungeoneering") + 9.0) / 10.0, 2));
        database.add(new Action("Dungeoneering (floor 1 max)", new ArrayList(), new HashMap(), ImmutableMap.of("Dungeoneering", 4000, "Dungeoneering token", 400,
            "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 4000), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 2 max)", Collections.singletonList(new Requirement("Dungeoneering", 3)), new HashMap(), ImmutableMap.of("Dungeoneering", 5760,
            "Dungeoneering token", 576, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 5760), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 3 max)", Collections.singletonList(new Requirement("Dungeoneering", 5)), new HashMap(), ImmutableMap.of("Dungeoneering", 7840,
            "Dungeoneering token", 784, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 7840), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 4 max)", Collections.singletonList(new Requirement("Dungeoneering", 7)), new HashMap(), ImmutableMap.of("Dungeoneering", 10240,
            "Dungeoneering token", 1024, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 10240), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 5 max)", Collections.singletonList(new Requirement("Dungeoneering", 9)), new HashMap(), ImmutableMap.of("Dungeoneering", 12960,
            "Dungeoneering token", 1296, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 12960), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 6 max)", Collections.singletonList(new Requirement("Dungeoneering", 11)), new HashMap(), ImmutableMap.of("Dungeoneering", 16000,
            "Dungeoneering token", 1600, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 16000), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 7 max)", Collections.singletonList(new Requirement("Dungeoneering", 13)), new HashMap(), ImmutableMap.of("Dungeoneering", 19360,
            "Dungeoneering token", 1936, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 19360), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 8 max)", Collections.singletonList(new Requirement("Dungeoneering", 15)), new HashMap(), ImmutableMap.of("Dungeoneering", 23040,
            "Dungeoneering token", 2304, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 23040), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 9 max)", Collections.singletonList(new Requirement("Dungeoneering", 17)), new HashMap(), ImmutableMap.of("Dungeoneering", 27040,
            "Dungeoneering token", 2704, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 27040), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 10 max)", Collections.singletonList(new Requirement("Dungeoneering", 19)), new HashMap(), ImmutableMap.of("Dungeoneering", 31360,
            "Dungeoneering token", 3136, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 31360), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 11 max)", Collections.singletonList(new Requirement("Dungeoneering", 21)), new HashMap(), ImmutableMap.of("Dungeoneering", 36000,
            "Dungeoneering token", 3600, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 36000), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 12 max)", Collections.singletonList(new Requirement("Dungeoneering", 23)), new HashMap(), ImmutableMap.of("Dungeoneering", 40960,
            "Dungeoneering token", 4096, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 40960), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 13 max)", Collections.singletonList(new Requirement("Dungeoneering", 25)), new HashMap(), ImmutableMap.of("Dungeoneering", 46240,
            "Dungeoneering token", 4624, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 46240), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 14 max)", Collections.singletonList(new Requirement("Dungeoneering", 27)), new HashMap(), ImmutableMap.of("Dungeoneering", 51840,
            "Dungeoneering token", 5184, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 51840), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 15 max)", Collections.singletonList(new Requirement("Dungeoneering", 29)), new HashMap(), ImmutableMap.of("Dungeoneering", 57760,
            "Dungeoneering token", 5776, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 57760), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 16 max)", Collections.singletonList(new Requirement("Dungeoneering", 31)), new HashMap(), ImmutableMap.of("Dungeoneering", 64000,
            "Dungeoneering token", 6400, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 64000), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 17 max)", Collections.singletonList(new Requirement("Dungeoneering", 33)), new HashMap(), ImmutableMap.of("Dungeoneering", 70560,
            "Dungeoneering token", 7056, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 70560), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 18 max)", Collections.singletonList(new Requirement("Dungeoneering", 35)), new HashMap(), ImmutableMap.of("Dungeoneering", 77440,
            "Dungeoneering token", 7744, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 77440), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 19 max)", Collections.singletonList(new Requirement("Dungeoneering", 37)), new HashMap(), ImmutableMap.of("Dungeoneering", 84640,
            "Dungeoneering token", 8464, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 84640), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 20 max)", Collections.singletonList(new Requirement("Dungeoneering", 39)), new HashMap(), ImmutableMap.of("Dungeoneering", 92160,
            "Dungeoneering token", 9216, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 92160), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 21 max)", Collections.singletonList(new Requirement("Dungeoneering", 41)), new HashMap(), ImmutableMap.of("Dungeoneering", 100000,
            "Dungeoneering token", 10000, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 100000), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 22 max)", Collections.singletonList(new Requirement("Dungeoneering", 43)), new HashMap(), ImmutableMap.of("Dungeoneering", 108160,
            "Dungeoneering token", 10816, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 108160), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 23 max)", Collections.singletonList(new Requirement("Dungeoneering", 45)), new HashMap(), ImmutableMap.of("Dungeoneering", 116640,
            "Dungeoneering token", 11664, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 116640), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 24 max)", Collections.singletonList(new Requirement("Dungeoneering", 47)), new HashMap(), ImmutableMap.of("Dungeoneering", 125440,
            "Dungeoneering token", 12544, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 125440), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 25 max)", Collections.singletonList(new Requirement("Dungeoneering", 49)), new HashMap(), ImmutableMap.of("Dungeoneering", 134560,
            "Dungeoneering token", 13456, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 134560), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 26 max)", Collections.singletonList(new Requirement("Dungeoneering", 51)), new HashMap(), ImmutableMap.of("Dungeoneering", 144000,
            "Dungeoneering token", 14400, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 144000), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 27 max)", Collections.singletonList(new Requirement("Dungeoneering", 53)), new HashMap(), ImmutableMap.of("Dungeoneering", 153760,
            "Dungeoneering token", 15376, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 153760), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 28 max)", Collections.singletonList(new Requirement("Dungeoneering", 55)), new HashMap(), ImmutableMap.of("Dungeoneering", 163840,
            "Dungeoneering token", 16384, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 163840), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 29 max)", Collections.singletonList(new Requirement("Dungeoneering", 57)), new HashMap(), ImmutableMap.of("Dungeoneering", 174240,
            "Dungeoneering token", 17424, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 174240), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 30 max)", Collections.singletonList(new Requirement("Dungeoneering", 59)), new HashMap(), ImmutableMap.of("Dungeoneering", 184960,
            "Dungeoneering token", 18496, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 184960), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 31 max)", Collections.singletonList(new Requirement("Dungeoneering", 61)), new HashMap(), ImmutableMap.of("Dungeoneering", 196000,
            "Dungeoneering token", 19600, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 196000), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 32 max)", Collections.singletonList(new Requirement("Dungeoneering", 63)), new HashMap(), ImmutableMap.of("Dungeoneering", 207360,
            "Dungeoneering token", 20736, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 207360), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 33 max)", Collections.singletonList(new Requirement("Dungeoneering", 65)), new HashMap(), ImmutableMap.of("Dungeoneering", 219040,
            "Dungeoneering token", 21904, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 219040), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 34 max)", Collections.singletonList(new Requirement("Dungeoneering", 67)), new HashMap(), ImmutableMap.of("Dungeoneering", 231040,
            "Dungeoneering token", 23104, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 231040), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 35 max)", Collections.singletonList(new Requirement("Dungeoneering", 69)), new HashMap(), ImmutableMap.of("Dungeoneering", 243360,
            "Dungeoneering token", 24336, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 243360), "Dungeoneering floors completed", 8), 8, true, true));
        database.add(new Action("Dungeoneering (floor 35 max, w/fragments)", Collections.singletonList(new Requirement("Dungeoneering", 70)), new HashMap(), ImmutableMap.of("Dungeoneering", 243360,
            "Dungeoneering token", 24336, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 243360), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 36 max)", Collections.singletonList(new Requirement("Dungeoneering", 71)), new HashMap(), ImmutableMap.of("Dungeoneering", 256000,
            "Dungeoneering token", 25600, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 256000), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 37 max)", Collections.singletonList(new Requirement("Dungeoneering", 73)), new HashMap(), ImmutableMap.of("Dungeoneering", 268960,
            "Dungeoneering token", 26896, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 268960), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 38 max)", Collections.singletonList(new Requirement("Dungeoneering", 75)), new HashMap(), ImmutableMap.of("Dungeoneering", 282240,
            "Dungeoneering token", 28224, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 282240), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 39 max)", Collections.singletonList(new Requirement("Dungeoneering", 77)), new HashMap(), ImmutableMap.of("Dungeoneering", 295840,
            "Dungeoneering token", 29584, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 295840), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 40 max)", Collections.singletonList(new Requirement("Dungeoneering", 79)), new HashMap(), ImmutableMap.of("Dungeoneering", 309760,
            "Dungeoneering token", 30976, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 309760), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 41 max)", Collections.singletonList(new Requirement("Dungeoneering", 81)), new HashMap(), ImmutableMap.of("Dungeoneering", 324000,
            "Dungeoneering token", 32400, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 324000), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 42 max)", Collections.singletonList(new Requirement("Dungeoneering", 83)), new HashMap(), ImmutableMap.of("Dungeoneering", 338560,
            "Dungeoneering token", 33856, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 338560), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 43 max)", Collections.singletonList(new Requirement("Dungeoneering", 85)), new HashMap(), ImmutableMap.of("Dungeoneering", 353440,
            "Dungeoneering token", 35344, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 353440), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 44 max)", Collections.singletonList(new Requirement("Dungeoneering", 87)), new HashMap(), ImmutableMap.of("Dungeoneering", 368640,
            "Dungeoneering token", 36864, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 368640), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 45 max)", Collections.singletonList(new Requirement("Dungeoneering", 89)), new HashMap(), ImmutableMap.of("Dungeoneering", 384160,
            "Dungeoneering token", 38416, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 384160), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 46 max)", Collections.singletonList(new Requirement("Dungeoneering", 91)), new HashMap(), ImmutableMap.of("Dungeoneering", 400000,
            "Dungeoneering token", 40000, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 400000), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 47 max)", Collections.singletonList(new Requirement("Dungeoneering", 93)), new HashMap(), ImmutableMap.of("Dungeoneering", 416160,
            "Dungeoneering token", 41616, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 416160), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 48 max)", Collections.singletonList(new Requirement("Dungeoneering", 95)), new HashMap(), ImmutableMap.of("Dungeoneering", 432640,
            "Dungeoneering token", 43264, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 432640), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 49 max)", Collections.singletonList(new Requirement("Dungeoneering", 97)), new HashMap(), ImmutableMap.of("Dungeoneering", 449440,
            "Dungeoneering token", 44944, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 449440), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 50 max)", Collections.singletonList(new Requirement("Dungeoneering", 99)), new HashMap(), ImmutableMap.of("Dungeoneering", 466560,
            "Dungeoneering token", 46656, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 466560), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 51 max)", Collections.singletonList(new Requirement("Dungeoneering", 101)), new HashMap(), ImmutableMap.of("Dungeoneering", 484000,
            "Dungeoneering token", 48400, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 484000), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 52 max)", Collections.singletonList(new Requirement("Dungeoneering", 103)), new HashMap(), ImmutableMap.of("Dungeoneering", 501760,
            "Dungeoneering token", 50176, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 501760), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 53 max)", Collections.singletonList(new Requirement("Dungeoneering", 105)), new HashMap(), ImmutableMap.of("Dungeoneering", 519840,
            "Dungeoneering token", 51984, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 519840), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 54 max)", Collections.singletonList(new Requirement("Dungeoneering", 107)), new HashMap(), ImmutableMap.of("Dungeoneering", 538240,
            "Dungeoneering token", 53824, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 538240), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 55 max)", Collections.singletonList(new Requirement("Dungeoneering", 109)), new HashMap(), ImmutableMap.of("Dungeoneering", 556960,
            "Dungeoneering token", 55696, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 556960), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 56 max)", Collections.singletonList(new Requirement("Dungeoneering", 111)), new HashMap(), ImmutableMap.of("Dungeoneering", 576000,
            "Dungeoneering token", 57600, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 576000), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 57 max)", Collections.singletonList(new Requirement("Dungeoneering", 113)), new HashMap(), ImmutableMap.of("Dungeoneering", 595360,
            "Dungeoneering token", 59536, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 595360), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 58 max)", Collections.singletonList(new Requirement("Dungeoneering", 115)), new HashMap(), ImmutableMap.of("Dungeoneering", 615040,
            "Dungeoneering token", 61504, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 615040), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 59 max)", Collections.singletonList(new Requirement("Dungeoneering", 117)), new HashMap(), ImmutableMap.of("Dungeoneering", 635040,
            "Dungeoneering token", 63504, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 635040), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));
        database.add(new Action("Dungeoneering (floor 60 max)", Collections.singletonList(new Requirement("Dungeoneering", 119)), new HashMap(), ImmutableMap.of("Dungeoneering", 655360,
            "Dungeoneering token", 655360, "Dungeoneering pet points", totalPetPoints(player, "Dungeoneering", 655360), "Dungeoneering floors completed", 8, "Dungeoneering fragment", 800),
            8, true, true));

        //Farming (done to lv5)
        //avg yield 10, 14% death rate w/o payments
        database.add(new Action("Farming potatoes (w/o payments)", new ArrayList(), ImmutableMap.of("Potato seed", 162, "Supercompost", 54),
            ImmutableMap.of("Raw potato", 464, "Farming", 5976, "Farming pet points", totalPetPoints(player, "Farming", 5976)), 6, true, true));
        database.add(new Action("Farming potatoes (w/ payments)", new ArrayList(), ImmutableMap.of("Potato seed", 162, "Supercompost", 54, "Compost", 108),
            ImmutableMap.of("Raw potato", 540, "Farming", 6696, "Farming pet points", totalPetPoints(player, "Farming", 6696)), 6, true, true));
        database.add(new Action("Farming marigolds", Collections.singletonList(new Requirement("Farming", 2)), ImmutableMap.of("Marigold seed", 24, "Supercompost", 24),
            ImmutableMap.of("Marigolds", 24, "Farming", 1956, "Farming pet points", totalPetPoints(player, "Farming", 1596)), 6, true, true));
        database.add(new Action("Farming barley (w/o payments)", Collections.singletonList(new Requirement("Farming", 3)), ImmutableMap.of("Barley seed", 96, "Supercompost", 24),
            ImmutableMap.of("Barley", 206, "Farming", 2785, "Farming pet points", totalPetPoints(player, "Farming", 2785)), 6, true, true));
        database.add(new Action("Farming barley (w payments)", Collections.singletonList(new Requirement("Farming", 3)), ImmutableMap.of("Barley seed", 96, "Supercompost", 24, "Compost", 72),
            ImmutableMap.of("Barley", 240, "Farming", 3108, "Farming pet points", totalPetPoints(player, "Farming", 3108)), 6, true, true));
        database.add(new Action("Farming hammerstone (w/o payments)", Collections.singletonList(new Requirement("Farming", 4)), ImmutableMap.of("Hammerstone seed", 96, "Supercompost", 24),
            ImmutableMap.of("Hamemrstone hops", 206, "Farming", 2900, "Farming pet points", totalPetPoints(player, "Farming", 2900)), 6, true, true));
        database.add(new Action("Farming hammerstone (w payments)", Collections.singletonList(new Requirement("Farming", 4)), ImmutableMap.of("Hammerstone seed", 96, "Supercompost", 24, "Marigolds", 24),
            ImmutableMap.of("Hammerstone hops", 240, "Farming", 3240, "Farming pet points", totalPetPoints(player, "Farming", 3240)), 6, true, true));

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

        //Firemaking (done)
        database.add(new Action("Burning normal logs on bonfire", new ArrayList(), ImmutableMap.of("Logs", 952), ImmutableMap.of("Firemaking", 47600,
            "Firemaking level-ticks", 6000 * player.getLevel("Firemaking")), 952, true, true));
        database.add(new Action("Burning normal logs in lines", new ArrayList(), ImmutableMap.of("Logs", 1260), ImmutableMap.of("Firemaking", 50400,
            "Firemaking level-ticks", 6000 * player.getLevel("Firemaking")), 1260, true, true));
        database.add(new Action("Burning normal logs in lines (w/pitch can)", new ArrayList(), ImmutableMap.of("Logs", 3429, "Pitch can (full)", 2), ImmutableMap.of("Pitch can (empty)", 2,
            "Firemaking", 137160, "Firemaking level-ticks", 6000 * player.getLevel("Firemaking")), 3429, true, true));
        database.add(new Action("Burning achey logs on bonfire", new ArrayList(), ImmutableMap.of("Achey tree logs", 952), ImmutableMap.of("Firemaking", 47600,
            "Firemaking level-ticks", 6000 * player.getLevel("Firemaking")), 976, true, true));
        database.add(new Action("Burning achey logs in lines", new ArrayList(), ImmutableMap.of("Achey tree logs", 1260), ImmutableMap.of("Firemaking", 50400,
            "Firemaking level-ticks", 6000 * player.getLevel("Firemaking")), 1260, true, true));
        database.add(new Action("Burning achey logs in lines (w/pitch can)", new ArrayList(), ImmutableMap.of("Achey tree logs", 3429, "Pitch can (full)", 2), ImmutableMap.of("Pitch can (empty)", 2,
            "Firemaking", 137160, "Firemaking level-ticks", 6000 * player.getLevel("Firemaking")), 3429, true, true));
        database.add(new Action("Burning oak logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 15)), ImmutableMap.of("Oak logs", 952), ImmutableMap.of("Firemaking", 80920,
            "Firemaking level-ticks", 6000 * Math.max(15, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning oak logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 15)), ImmutableMap.of("Oak logs", 3429, "Pitch can (full)", 2),
            ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 205740, "Firemaking level-ticks", 6000 * Math.max(15, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning willow logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 30)), ImmutableMap.of("Willow logs", 952), ImmutableMap.of("Firemaking", 99960,
            "Firemaking level-ticks", 6000 * Math.max(30, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning willow logs in lines", Collections.singletonList(new Requirement("Firemaking", 30)), ImmutableMap.of("Willow logs", 1260), ImmutableMap.of("Firemaking", 113400,
            "Firemaking level-ticks", 6000 * Math.max(30, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning willow logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 30)), ImmutableMap.of("Willow logs", 3429, "Pitch can (full)", 2),
            ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 308610, "Firemaking level-ticks", 6000 * Math.max(30, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning teak logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 35)), ImmutableMap.of("Teak logs", 952), ImmutableMap.of("Firemaking", 114240,
            "Firemaking level-ticks", 6000 * Math.max(35, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning teak logs in lines", Collections.singletonList(new Requirement("Firemaking", 35)), ImmutableMap.of("Teak logs", 1260), ImmutableMap.of("Firemaking", 132300,
            "Firemaking level-ticks", 6000 * Math.max(35, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning teak logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 35)), ImmutableMap.of("Teak logs", 3429, "Pitch can (full)", 2),
            ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 360045, "Firemaking level-ticks", 6000 * Math.max(35, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning arctic pine logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 42)), ImmutableMap.of("Arctic pine logs", 952),
            ImmutableMap.of("Firemaking", 123760, "Firemaking level-ticks", 6000 * Math.max(42, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning arctic pine logs in lines", Collections.singletonList(new Requirement("Firemaking", 42)), ImmutableMap.of("Arctic pine logs", 1260),
            ImmutableMap.of("Firemaking", 157500, "Firemaking level-ticks", 6000 * Math.max(42, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning arctic pine logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 42)), ImmutableMap.of("Arctic pine logs", 3429,
            "Pitch can (full)", 2), ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 428625, "Firemaking level-ticks", 6000 * Math.max(42, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning maple logs in lines", Collections.singletonList(new Requirement("Firemaking", 45)), ImmutableMap.of("Maple logs", 1260), ImmutableMap.of("Firemaking", 170100,
            "Firemaking level-ticks", 6000 * Math.max(45, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning maple logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 45)), ImmutableMap.of("Maple logs", 3429, "Pitch can (full)", 2),
            ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 462915, "Firemaking level-ticks", 6000 * Math.max(45, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning acadia logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 47)), ImmutableMap.of("Acadia logs", 952),
            ImmutableMap.of("Firemaking", 162316, "Menaphite honey bee", 1, "Fruit fly in amber", 1, "Firemaking level-ticks", 6000 * Math.max(47, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning acadia logs in lines", Collections.singletonList(new Requirement("Firemaking", 47)), ImmutableMap.of("Acadia logs", 1260), ImmutableMap.of("Firemaking", 176400,
            "Menaphite honey bee", 1, "Fruit fly in amber", 1, "Firemaking level-ticks", 6000 * Math.max(47, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning acadia logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 47)), ImmutableMap.of("Acadia logs", 3429, "Pitch can (full)", 2),
            ImmutableMap.of("Pitch can (empty)", 2, "Menaphite honey bee", 3, "Fruit fly in amber", 3, "Firemaking", 480060, "Firemaking level-ticks", 6000 * Math.max(47, player.getLevel("Firemaking"))),
            3429, true, true));
        database.add(new Action("Burning mahogany logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 50)), ImmutableMap.of("Mahogany logs", 952),
            ImmutableMap.of("Firemaking", 171360, "Firemaking level-ticks", 6000 * Math.max(50, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning mahogany logs in lines", Collections.singletonList(new Requirement("Firemaking", 50)), ImmutableMap.of("Mahogany logs", 1260),
            ImmutableMap.of("Firemaking", 198450, "Firemaking level-ticks", 6000 * Math.max(50, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning mahogany logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 50)), ImmutableMap.of("Mahogany logs", 3429,
            "Pitch can (full)", 2), ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 540067, "Firemaking level-ticks", 6000 * Math.max(50, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning eucalyptus logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 58)), ImmutableMap.of("Eucalyptus logs", 952),
            ImmutableMap.of("Firemaking", 185640, "Firemaking level-ticks", 6000 * Math.max(58, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning eucalpytus logs in lines", Collections.singletonList(new Requirement("Firemaking", 58)), ImmutableMap.of("Eucalyptus logs", 1260),
            ImmutableMap.of("Firemaking", 243180, "Firemaking level-ticks", 6000 * Math.max(58, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning eucalpytus logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 58)), ImmutableMap.of("Eucalpytus logs", 3429,
            "Pitch can (full)", 2), ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 661797, "Firemaking level-ticks", 6000 * Math.max(58, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning yew logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 60)), ImmutableMap.of("Yew logs", 952),
            ImmutableMap.of("Firemaking", 209440, "Firemaking level-ticks", 6000 * Math.max(60, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning yew logs in lines", Collections.singletonList(new Requirement("Firemaking", 60)), ImmutableMap.of("Yew logs", 1260),
            ImmutableMap.of("Firemaking", 255150, "Firemaking level-ticks", 6000 * Math.max(60, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning yew logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 60)), ImmutableMap.of("Yew logs", 3429,
            "Pitch can (full)", 2), ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 694372, "Firemaking level-ticks", 6000 * Math.max(60, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning magic logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 75)), ImmutableMap.of("Magic logs", 952),
            ImmutableMap.of("Firemaking", 294644, "Firemaking level-ticks", 6000 * Math.max(75, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning magic logs in lines", Collections.singletonList(new Requirement("Firemaking", 75)), ImmutableMap.of("Magic logs", 1260),
            ImmutableMap.of("Firemaking", 382788, "Firemaking level-ticks", 6000 * Math.max(75, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning magic logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 75)), ImmutableMap.of("Magic logs", 3429,
            "Pitch can (full)", 2), ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 1041730, "Firemaking level-ticks", 6000 * Math.max(75, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning corrupted magic logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 75)), ImmutableMap.of("Corrupted magic logs", 952),
            ImmutableMap.of("Firemaking", 309876, "Firemaking level-ticks", 6000 * Math.max(75, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning corrupted magic logs in lines", Collections.singletonList(new Requirement("Firemaking", 75)), ImmutableMap.of("Corrupted magic logs", 1260),
            ImmutableMap.of("Firemaking", 401940, "Firemaking level-ticks", 6000 * Math.max(75, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning corrupted magic logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 75)), ImmutableMap.of("Corrupted magic logs", 3429,
            "Pitch can (full)", 2), ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 1093851, "Firemaking level-ticks", 6000 * Math.max(75, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Burning elder logs on bonfire", Collections.singletonList(new Requirement("Firemaking", 90)), ImmutableMap.of("Elder logs", 952),
            ImmutableMap.of("Firemaking", 428400, "Firemaking level-ticks", 6000 * Math.max(75, player.getLevel("Firemaking"))), 952, true, true));
        database.add(new Action("Burning elder logs in lines", Collections.singletonList(new Requirement("Firemaking", 90)), ImmutableMap.of("Elder logs", 1260),
            ImmutableMap.of("Firemaking", 547218, "Firemaking level-ticks", 6000 * Math.max(75, player.getLevel("Firemaking"))), 1260, true, true));
        database.add(new Action("Burning elder logs in lines (w/pitch can)", Collections.singletonList(new Requirement("Firemaking", 90)), ImmutableMap.of("Elder logs", 3429,
            "Pitch can (full)", 2), ImmutableMap.of("Pitch can (empty)", 2, "Firemaking", 1489214, "Firemaking level-ticks", 6000 * Math.max(75, player.getLevel("Firemaking"))), 3429, true, true));
        database.add(new Action("Char's training cave (XP maxing)", Arrays.asList(new Requirement("Firemaking", 91), new Requirement("The Firemaker's Curse", 1)),
            ImmutableMap.of("Pitch can (empty)", 5), ImmutableMap.of("Pitch can (full)", 5, "Firemaking", 728916), 12, true, true));
        database.add(new Action("Char's training cave (profit maxing)", Arrays.asList(new Requirement("Firemaking", 91), new Requirement("The Firemaker's Curse", 1)),
            ImmutableMap.of("Pitch can (empty)", 10), ImmutableMap.of("Pitch can (full)", 10, "Firemaking", 530304), 12, true, true));

        //Fishing (done to lv5)
        database.add(new Action("Fishing/dropping raw crayfish", new ArrayList<>(), new HashMap<>(), ImmutableMap.of("Fishing", 11500, "Prawn balls", 6,
            "Fishing level-ticks", 6000 * player.getLevel("Fishing")), 1150, true, true));

        database.add(new Action("Fishing/dropping desert sole", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Fishing", 52)),
            new HashMap(), ImmutableMap.builder().put("Fishing", 60 * resourcesGained(70, 5.0, player, 0.0, "Fishing")).put("Menaphos reputation",
            3 * resourcesGained(70, 5.0, player, 0.0, "Fishing")).put("Prawn balls", 1450 * resourcesGained(70, 5.0, player, 0.0, "Fishing") / 35000)
            .put("Clicker kalphite in amber", 1).put("Desert locust in amber", 1).put("Fishing level-ticks", 6000 * Math.max(52, player.getLevel("Fishing")))
            .put("Wavecrest opal", 1).put("Maw coral", 1).build(), resourcesGained(70, 5.0, player, 0.0, "Fishing"), true, true));

        database.add(new Action("Barbarian fly fishing", Arrays.asList(new Requirement("Fishing", 70), new Requirement("Strength", 45), new Requirement("Agility", 45),
            new Requirement("Barbarian Fishing", 1)), new HashMap<>(), ImmutableMap.of("Fishing", 62 * (650 + 5 * player.getLevel("Fishing")), "Strength", (int) Math.floor(4.9 * (650 + 5 * player.getLevel("Fishing"))),
            "Agility", (int) Math.floor(4.9 * (650 + 5 * player.getLevel("Fishing"))), "Shark fragment", 1200, "Fishing level-ticks", 6000 * Math.max(70, player.getLevel("Fishing"))),
            (650 + 5 * player.getLevel("Fishing")), true, true));

        //Fletching (done to lv10)
        database.add(new Action("Fletching arrow shafts with normal logs", new ArrayList(), ImmutableMap.of("Logs", 1848), ImmutableMap.of("Arrow shaft", 27720,
            "Fletching", 9240, "Fletching pet points", totalPetPoints(player, "Fletching", 9240)), 1848, true, true));
        database.add(new Action("Fletching unstrung shortbows", new ArrayList(), ImmutableMap.of("Logs", 1848), ImmutableMap.of("Shortbow (u)", 1848, "Fletching", 9240,
            "Fletching pet points", totalPetPoints(player, "Fletching", 9240)), 1848, true, true));
        database.add(new Action("Stringing shortbows", new ArrayList(), ImmutableMap.of("Shortbow (u)", 2464, "Bowstring", 2464), ImmutableMap.of("Shortbow", 2464, "Fletching", 12320,
            "Fletching pet points", totalPetPoints(player, "Fletching", 12320)), 2464, true, true));
        database.add(new Action("Fletching headless arrows", new ArrayList(), ImmutableMap.of("Arrow shaft", 45000, "Feather", 45000),
            ImmutableMap.of("Headless arrow", 45000, "Fletching", 45000, "Fletching pet points", totalPetPoints(player, "Fletching", 45000)), 3000, true, true));
        database.add(new Action("Fletching bronze arrows", new ArrayList(), ImmutableMap.of("Headless arrow", 45000, "Bronze arrowheads", 45000),
            ImmutableMap.of("Bronze arrow", 45000, "Fletching", 58500, "Fletching pet points", totalPetPoints(player, "Fletching", 58500)), 3000, true, true));
        database.add(new Action("Fletching wooden stocks", Collections.singletonList(new Requirement("Fletching", 9)), ImmutableMap.of("Logs", 1848),
            ImmutableMap.of("Wooden stock", 1848, "Fletching", 11088, "Fletching pet points", totalPetPoints(player, "Fletching", 11088)), 1848, true, true));
        database.add(new Action("Making bronze crossbows (u)", Collections.singletonList(new Requirement("Fletching", 9)), ImmutableMap.of("Wooden stock", 1750, "Bronze limbs", 1750),
            ImmutableMap.of("Bronze crossbow (u)", 1750, "Fletching", 21000, "Fletching pet points", totalPetPoints(player, "Fletching", 21000)), 1750, true, true));
        database.add(new Action("Stringing bronze crossbows", Collections.singletonList(new Requirement("Fletching", 9)), ImmutableMap.of("Bronze crossbow (u)", 2464, "Crossbow string", 2464),
            ImmutableMap.of("Bronze crossbow", 2464, "Fletching", 14784, "Fletching pet points", totalPetPoints(player, "Fletching", 14784)), 2464, true, true));
        database.add(new Action("Making bronze bolts", Collections.singletonList(new Requirement("Fletching", 9)), ImmutableMap.of("Bronze bolts (unf)", 30000, "Feather", 30000),
            ImmutableMap.of("Bronze bolts", 30000, "Fletching", 15000, "Fletching pet points", totalPetPoints(player, "Fletching", 15000)), 3000, true, true));

        //Herblore (done)
        database.add(new Action("Grinding mud runes", new ArrayList(), ImmutableMap.of("Mud rune", 5250), ImmutableMap.of("Ground mud rune", 5250,
            "Herblore", 5250, "Herblore pet points", totalPetPoints(player, "Herblore", 5250)), 5250, true, true));
        database.add(new Action("Cleaning grimy guam", new ArrayList(), ImmutableMap.of("Grimy guam", 5250), ImmutableMap.of("Clean guam", 5250,
            "Herblore", 13125, "Herblore pet points", totalPetPoints(player, "Herblore", 13125)), 5250, true, true));
        database.add(new Action("Cleaning grimy tarromin", Collections.singletonList(new Requirement("Herblore", 5)), ImmutableMap.of("Grimy tarromin", 5250),
            ImmutableMap.of("Clean tarromin", 5250, "Herblore", 19950, "Herblore pet points", totalPetPoints(player, "Herblore", 19950)), 5250, true, true));
        database.add(new Action("Cleaning grimy marrentill", Collections.singletonList(new Requirement("Herblore", 9)), ImmutableMap.of("Grimy marrentill", 5250),
            ImmutableMap.of("Clean marrentill", 5250, "Herblore", 26250, "Herblore pet points", totalPetPoints(player, "Herblore", 26250)), 5250, true, true));
        database.add(new Action("Cleaning grimy harralander", Collections.singletonList(new Requirement("Herblore", 20)), ImmutableMap.of("Grimy harralander", 5250),
            ImmutableMap.of("Clean harralander", 5250, "Herblore", 33075, "Herblore pet points", totalPetPoints(player, "Herblore", 33075)), 5250, true, true));
        database.add(new Action("Cleaning grimy ranarr", Collections.singletonList(new Requirement("Herblore", 25)), ImmutableMap.of("Grimy ranarr", 5250),
            ImmutableMap.of("Clean ranarr", 5250, "Herblore", 39375, "Herblore pet points", totalPetPoints(player, "Herblore", 19950)), 5250, true, true));
        database.add(new Action("Cleaning grimy toadflax", Collections.singletonList(new Requirement("Herblore", 30)), ImmutableMap.of("Grimy toadflax", 5250),
            ImmutableMap.of("Clean toadflax", 5250, "Herblore", 42000, "Herblore pet points", totalPetPoints(player, "Herblore", 42000)), 5250, true, true));
        database.add(new Action("Cleaning grimy spirit weed", Collections.singletonList(new Requirement("Herblore", 35)), ImmutableMap.of("Grimy spirit weed", 5250),
            ImmutableMap.of("Clean spirit weed", 5250, "Herblore", 40950, "Herblore pet points", totalPetPoints(player, "Herblore", 40950)), 5250, true, true));
        database.add(new Action("Cleaning grimy irit", Collections.singletonList(new Requirement("Herblore", 40)), ImmutableMap.of("Grimy irit", 5250),
            ImmutableMap.of("Clean irit", 5250, "Herblore", 46200, "Herblore pet points", totalPetPoints(player, "Herblore", 46200)), 5250, true, true));
        database.add(new Action("Cleaning grimy wergali", Collections.singletonList(new Requirement("Herblore", 41)), ImmutableMap.of("Grimy wergali", 5250),
            ImmutableMap.of("Clean wergali", 5250, "Herblore", 49875, "Herblore pet points", totalPetPoints(player, "Herblore", 49875)), 5250, true, true));
        database.add(new Action("Cleaning grimy avantoe", Collections.singletonList(new Requirement("Herblore", 48)), ImmutableMap.of("Grimy avantoe", 5250),
            ImmutableMap.of("Clean avantoe", 5250, "Herblore", 52500, "Herblore pet points", totalPetPoints(player, "Herblore", 52500)), 5250, true, true));
        database.add(new Action("Cleaning grimy kwuarm", Collections.singletonList(new Requirement("Herblore", 54)), ImmutableMap.of("Grimy kwuarm", 5250),
            ImmutableMap.of("Clean kwuarm", 5250, "Herblore", 59325, "Herblore pet points", totalPetPoints(player, "Herblore", 59325)), 5250, true, true));
        database.add(new Action("Cleaning grimy bloodweed", Collections.singletonList(new Requirement("Herblore", 57)), ImmutableMap.of("Grimy bloodweed", 5250),
            ImmutableMap.of("Clean bloodweed", 5250, "Herblore", 60375, "Herblore pet points", totalPetPoints(player, "Herblore", 60375)), 5250, true, true));
        database.add(new Action("Cleaning grimy snapdragon", Collections.singletonList(new Requirement("Herblore", 59)), ImmutableMap.of("Grimy snapdragon", 5250),
            ImmutableMap.of("Clean snapdragon", 5250, "Herblore", 61950, "Herblore pet points", totalPetPoints(player, "Herblore", 61950)), 5250, true, true));
        database.add(new Action("Cleaning grimy cadantine", Collections.singletonList(new Requirement("Herblore", 65)), ImmutableMap.of("Grimy cadantine", 5250),
            ImmutableMap.of("Clean cadantine", 5250, "Herblore", 65625, "Herblore pet points", totalPetPoints(player, "Herblore", 65625)), 5250, true, true));
        database.add(new Action("Cleaning grimy lantadyme", Collections.singletonList(new Requirement("Herblore", 67)), ImmutableMap.of("Grimy lantadyme", 5250),
            ImmutableMap.of("Clean lantadyme", 5250, "Herblore", 68775, "Herblore pet points", totalPetPoints(player, "Herblore", 68775)), 5250, true, true));
        database.add(new Action("Cleaning grimy dwarf weed", Collections.singletonList(new Requirement("Herblore", 70)), ImmutableMap.of("Grimy dwarf weed", 5250),
            ImmutableMap.of("Clean dwarf weed", 5250, "Herblore", 72450, "Herblore pet points", totalPetPoints(player, "Herblore", 72450)), 5250, true, true));
        database.add(new Action("Cleaning grimy torstol", Collections.singletonList(new Requirement("Herblore", 75)), ImmutableMap.of("Grimy torstol", 5250),
            ImmutableMap.of("Clean torstol", 5250, "Herblore", 78750, "Herblore pet points", totalPetPoints(player, "Herblore", 78750)), 5250, true, true));
        database.add(new Action("Cleaning grimy fellstalk", Collections.singletonList(new Requirement("Herblore", 91)), ImmutableMap.of("Grimy fellstalk", 5250),
            ImmutableMap.of("Clean fellstalk", 5250, "Herblore", 88200, "Herblore pet points", totalPetPoints(player, "Herblore", 88200)), 5250, true, true));

        database.add(new Action("Making attack potions", new ArrayList(), ImmutableMap.of("Guam potion (unf)", 2618, "Eye of newt", 2618),
            ImmutableMap.of("Attack potion (3)", 2618, "Herblore", 65450, "Herblore pet points", totalPetPoints(player, "Herblore", 65450)), 2618, true, true));
        database.add(new Action("Making ranging potions", Collections.singletonList(new Requirement("Herblore", 3)), ImmutableMap.of("Guam potion (unf)", 2618, "Redberries", 2618),
            ImmutableMap.of("Ranging potion (3)", 2618, "Herblore", 78540, "Herblore pet points", totalPetPoints(player, "Herblore", 78540)), 2618, true, true));
        database.add(new Action("Making magic potions", Collections.singletonList(new Requirement("Herblore", 5)), ImmutableMap.of("Tarromin potion (unf)", 2618, "Red bead", 2618),
            ImmutableMap.of("Magic potion (3)", 2618, "Herblore", 91630, "Herblore pet points", totalPetPoints(player, "Herblore", 91630)), 2618, true, true));
        database.add(new Action("Making strength potions", Collections.singletonList(new Requirement("Herblore", 7)), ImmutableMap.of("Tarromin potion (unf)", 2618, "Limpwurt root", 2618),
            ImmutableMap.of("Strength potion (3)", 2618, "Herblore", 104720, "Herblore pet points", totalPetPoints(player, "Herblore", 104720)), 2618, true, true));
        database.add(new Action("Making defence potions", Collections.singletonList(new Requirement("Herblore", 9)), ImmutableMap.of("Marrentill potion (unf)", 2618, "Bear fur", 2618),
            ImmutableMap.of("Defence potion (3)", 2618, "Herblore", 117810, "Herblore pet points", totalPetPoints(player, "Herblore", 117810)), 2618, true, true));
        database.add(new Action("Making antipoisons", Collections.singletonList(new Requirement("Herblore", 13)), ImmutableMap.of("Marrentill potion (unf)", 2618, "Unicorn horn dust", 2618),
            ImmutableMap.of("Antipoison (3)", 2618, "Herblore", 130900, "Herblore pet points", totalPetPoints(player, "Herblore", 130900)), 2618, true, true));
        database.add(new Action("Making Serum 207", Arrays.asList(new Requirement("Herblore", 15), new Requirement("Shades of Mort'ton", 1)),
            ImmutableMap.of("Tarromin potion (unf)", 4662, "Ashes", 4662), ImmutableMap.of("Herblore", 233100, "Herblore pet points", totalPetPoints(player, "Herblore", 233100)), 4662, true, true));
        database.add(new Action("Making restore potions", Collections.singletonList(new Requirement("Herblore", 22)), ImmutableMap.of("Harralander potion (unf)", 2618, "Red spiders' eggs", 2618),
            ImmutableMap.of("Restore potion (3)", 2618, "Herblore", 163625, "Herblore pet points", totalPetPoints(player, "Herblore", 163625)), 2618, true, true));
        database.add(new Action("Making energy potions", Collections.singletonList(new Requirement("Herblore", 26)), ImmutableMap.of("Harralander potion (unf)", 2618, "Chocolate dust", 2618),
            ImmutableMap.of("Energy potion (3)", 2618, "Herblore", 176715, "Herblore pet points", totalPetPoints(player, "Herblore", 176715)), 2618, true, true));
        database.add(new Action("Making agility potions", Collections.singletonList(new Requirement("Herblore", 34)), ImmutableMap.of("Toadflax potion (unf)", 2618, "Toad's legs", 2618),
            ImmutableMap.of("Agility potion (3)", 2618, "Herblore", 209440, "Herblore pet points", totalPetPoints(player, "Herblore", 209440)), 2618, true, true));
        database.add(new Action("Making combat potions", Collections.singletonList(new Requirement("Herblore", 36)), ImmutableMap.of("Harralander potion (unf)", 2618, "Goat horn dust", 2618),
            ImmutableMap.of("Combat potion (3)", 2618, "Herblore", 219912, "Herblore pet points", totalPetPoints(player, "Herblore", 219912)), 2618, true, true));
        database.add(new Action("Making prayer potions", Collections.singletonList(new Requirement("Herblore", 38)), ImmutableMap.of("Ranarr potion (unf)", 2618, "Snape grass", 2618),
            ImmutableMap.of("Prayer potion (3)", 2618, "Herblore", 229015, "Herblore pet points", totalPetPoints(player, "Herblore", 229015)), 2618, true, true));
        database.add(new Action("Making summoning potions", Collections.singletonList(new Requirement("Herblore", 40)), ImmutableMap.of("Spirit weed potion (unf)", 2618, "Cockatrice egg", 2618),
            ImmutableMap.of("Summoning potion (3)", 2618, "Herblore", 240856, "Herblore pet points", totalPetPoints(player, "Herblore", 240856)), 2618, true, true));
        database.add(new Action("Making divination potions", Collections.singletonList(new Requirement("Herblore", 43)), ImmutableMap.of("Spirit weed potion (unf)", 2618, "Rabbit foot", 2618),
            ImmutableMap.of("Divination potion (3)", 2618, "Herblore", 255255, "Herblore pet points", totalPetPoints(player, "Herblore", 255255)), 2618, true, true));
        database.add(new Action("Making super attacks", Collections.singletonList(new Requirement("Herblore", 45)), ImmutableMap.of("Irit potion (unf)", 2618, "Eye of newt", 2618),
            ImmutableMap.of("Super attack (3)", 2618, "Herblore", 261800, "Herblore pet points", totalPetPoints(player, "Herblore", 261800)), 2618, true, true));
        database.add(new Action("Making super antipoisons", Collections.singletonList(new Requirement("Herblore", 48)), ImmutableMap.of("Irit potion (unf)", 2618, "Unicorn horn dust", 2618),
            ImmutableMap.of("Super antipoison (3)", 2618, "Herblore", 278293, "Herblore pet points", totalPetPoints(player, "Herblore", 278293)), 2618, true, true));
        database.add(new Action("Making fishing potions", Collections.singletonList(new Requirement("Herblore", 50)), ImmutableMap.of("Avantoe potion (unf)", 2618, "Snape grass", 2618),
            ImmutableMap.of("Fishing potion (3)", 2618, "Herblore", 294525, "Herblore pet points", totalPetPoints(player, "Herblore", 294525)), 2618, true, true));
        database.add(new Action("Making super energy potions", Collections.singletonList(new Requirement("Herblore", 52)), ImmutableMap.of("Avantoe potion (unf)", 2618, "Mort myre fungus", 2618),
            ImmutableMap.of("Super energy (3)", 2618, "Herblore", 307615, "Herblore pet points", totalPetPoints(player, "Herblore", 307615)), 2618, true, true));
        database.add(new Action("Making hunter potions", Collections.singletonList(new Requirement("Herblore", 53)), ImmutableMap.of("Avantoe potion (unf)", 2618, "Kebbit teeth dust", 2618),
            ImmutableMap.of("Hunter potion (3)", 2618, "Herblore", 314160, "Herblore pet points", totalPetPoints(player, "Herblore", 314160)), 2618, true, true));
        database.add(new Action("Making runecrafting potions", Collections.singletonList(new Requirement("Herblore", 54)), ImmutableMap.of("Wergali potion (unf)", 2618, "Fallfaced wool", 2618),
            ImmutableMap.of("Runecrafting potion (3)", 2618, "Herblore", 320705, "Herblore pet points", totalPetPoints(player, "Herblore", 320705)), 2618, true, true));
        database.add(new Action("Making super strength potions", Collections.singletonList(new Requirement("Herblore", 55)), ImmutableMap.of("Kwuarm potion (unf)", 2618, "Limpwurt root", 2618),
            ImmutableMap.of("Super strength (3)", 2618, "Herblore", 327250, "Herblore pet points", totalPetPoints(player, "Herblore", 327250)), 2618, true, true));
        database.add(new Action("Making fletching potions", Collections.singletonList(new Requirement("Herblore", 58)), ImmutableMap.of("Wergali potion (unf)", 2781, "Wimpy feather", 2781),
            ImmutableMap.of("Fletching potion (3)", 2781, "Herblore", 367092, "Herblore pet points", totalPetPoints(player, "Herblore", 367092)), 2781, true, true));
        database.add(new Action("Making weapon poison", Collections.singletonList(new Requirement("Herblore", 60)), ImmutableMap.of("Kwuarm potion (unf)", 2618, "Dragon scale dust", 2618),
            ImmutableMap.of("Weapon poison (3)", 2618, "Herblore", 359975, "Herblore pet points", totalPetPoints(player, "Herblore", 359975)), 2618, true, true));
        database.add(new Action("Making super restores", Collections.singletonList(new Requirement("Herblore", 63)), ImmutableMap.of("Snapdragon potion (unf)", 2618, "Red spiders' eggs", 2618),
            ImmutableMap.of("Super restore (3)", 2618, "Herblore", 373065, "Herblore pet points", totalPetPoints(player, "Herblore", 373065)), 2618, true, true));
        database.add(new Action("Making super hunters", Collections.singletonList(new Requirement("Herblore", 64)), ImmutableMap.of("Hunter potion (3)", 2618, "Rabbit teeth", 2618),
            ImmutableMap.of("Super hunter (3)", 2618, "Herblore", 379610, "Herblore pet points", totalPetPoints(player, "Herblore", 379610)), 2618, true, true));
        database.add(new Action("Making super defences", Collections.singletonList(new Requirement("Herblore", 66)), ImmutableMap.of("Cadantine potion (unf)", 2618, "White berries", 2618),
            ImmutableMap.of("Super defence (3)", 2618, "Herblore", 392700, "Herblore pet points", totalPetPoints(player, "Herblore", 392700)), 2618, true, true));
        database.add(new Action("Making antifires", Collections.singletonList(new Requirement("Herblore", 69)), ImmutableMap.of("Lantadyme potion (unf)", 2618, "Dragon scale dust", 2618),
            ImmutableMap.of("Antifire (3)", 2618, "Herblore", 412335, "Herblore pet points", totalPetPoints(player, "Herblore", 412335)), 2618, true, true));
        database.add(new Action("Making super divinations", Collections.singletonList(new Requirement("Herblore", 70)), ImmutableMap.of("Divination potion (3)", 2618, "Zygomite fruit", 2618),
            ImmutableMap.of("Super divination (3)", 2618, "Herblore", 418880, "Herblore pet points", totalPetPoints(player, "Herblore", 418880)), 2618, true, true));
        database.add(new Action("Making super ranging potions", Collections.singletonList(new Requirement("Herblore", 72)), ImmutableMap.of("Dwarf weed potion (unf)", 2618, "Wine of Zamorak", 2618),
            ImmutableMap.of("Super ranging potion (3)", 2618, "Herblore", 425425, "Herblore pet points", totalPetPoints(player, "Herblore", 425425)), 2618, true, true));
        database.add(new Action("Making super runecraftings", Collections.singletonList(new Requirement("Herblore", 75)), ImmutableMap.of("Runecrafting potion (3)", 2618, "Yak milk", 2618),
            ImmutableMap.of("Super runecrafting (3)", 2618, "Herblore", 445060, "Herblore pet points", totalPetPoints(player, "Herblore", 445060)), 2618, true, true));
        database.add(new Action("Making super magic potions", Collections.singletonList(new Requirement("Herblore", 76)), ImmutableMap.of("Lantadyme potion (unf)", 2618, "Potato cactus", 2618),
            ImmutableMap.of("Super magic potion (3)", 2618, "Herblore", 451605, "Herblore pet points", totalPetPoints(player, "Herblore", 451605)), 2618, true, true));
        database.add(new Action("Making invention potions", Collections.singletonList(new Requirement("Herblore", 77)), ImmutableMap.of("Snapdragon potion (unf)", 2618, "Chinchompa residue", 2618),
            ImmutableMap.of("Invention potion (3)", 2618, "Herblore", 458150, "Herblore pet points", totalPetPoints(player, "Herblore", 458150)), 2618, true, true));
        database.add(new Action("Making Zamorak brews", Collections.singletonList(new Requirement("Herblore", 78)), ImmutableMap.of("Torstol potion (unf)", 2618, "Jangerberries", 2618),
            ImmutableMap.of("Zamorak brew (3)", 2618, "Herblore", 458150, "Herblore pet points", totalPetPoints(player, "Herblore", 458150)), 2618, true, true));
        database.add(new Action("Making Saradomin brews", Collections.singletonList(new Requirement("Herblore", 81)), ImmutableMap.of("Toadflax potion (unf)", 2618, "Crushed nest", 2618),
            ImmutableMap.of("Saradomin brew (3)", 2618, "Herblore", 471240, "Herblore pet points", totalPetPoints(player, "Herblore", 471240)), 2618, true, true));
        database.add(new Action("Making aggression potions", Collections.singletonList(new Requirement("Herblore", 82)), ImmutableMap.of("Bloodweed potion (unf)", 2618, "Searing ashes", 2618),
            ImmutableMap.of("Aggression potion (3)", 2618, "Herblore", 484330, "Herblore pet points", totalPetPoints(player, "Herblore", 484330)), 2618, true, true));
        database.add(new Action("Making adrenaline potions", Collections.singletonList(new Requirement("Herblore", 84)), ImmutableMap.of("Super energy (3)", 2618, "Papaya fruit", 2618),
            ImmutableMap.of("Herblore", 523600, "Herblore pet points", totalPetPoints(player, "Herblore", 523600)), 2618, true, true));
        database.add(new Action("Making super inventions", Collections.singletonList(new Requirement("Herblore", 87)), ImmutableMap.of("Invention potion (3)", 2618, "Spider fangs", 2618),
            ImmutableMap.of("Super invention (3)", 2618, "Herblore", 575960, "Herblore pet points", totalPetPoints(player, "Herblore", 575960)), 2618, true, true));
        database.add(new Action("Making extreme attacks", Collections.singletonList(new Requirement("Herblore", 88)), ImmutableMap.of("Super attack (3)", 2618, "Clean avantoe", 2618),
            ImmutableMap.of("Extreme attack (3)", 2618, "Herblore", 575960, "Herblore pet points", totalPetPoints(player, "Herblore", 575960)), 2618, true, true));
        database.add(new Action("Making extreme strengths", Collections.singletonList(new Requirement("Herblore", 89)), ImmutableMap.of("Super strength (3)", 2618, "Clean dwarf weed", 2618),
            ImmutableMap.of("Extreme strength (3)", 2618, "Herblore", 602140, "Herblore pet points", totalPetPoints(player, "Herblore", 602140)), 2618, true, true));
        database.add(new Action("Making extreme divinations", Collections.singletonList(new Requirement("Herblore", 89)), ImmutableMap.of("Super divination (3)", 2618, "Yak tuft", 2618),
            ImmutableMap.of("Herblore", 602140, "Herblore pet points", totalPetPoints(player, "Herblore", 602140)), 2618, true, true));
        database.add(new Action("Making extreme defences", Collections.singletonList(new Requirement("Herblore", 90)), ImmutableMap.of("Super defence (3)", 2618, "Clean lantadyme", 2618),
            ImmutableMap.of("Extreme defence (3)", 2618, "Herblore", 628320, "Herblore pet points", totalPetPoints(player, "Herblore", 628320)), 2618, true, true));
        database.add(new Action("Making extreme magics", Collections.singletonList(new Requirement("Herblore", 91)), ImmutableMap.of("Super magic potion (3)", 2781, "Ground mud rune", 2781),
            ImmutableMap.of("Extreme magic (3)", 2781, "Herblore", 695250, "Herblore pet points", totalPetPoints(player, "Herblore", 695250)), 2781, true, true));
        database.add(new Action("Making extreme runecraftings", Collections.singletonList(new Requirement("Herblore", 91)), ImmutableMap.of("Super runecrafting (3)", 2618, "Spider venom", 2618),
            ImmutableMap.of("Herblore", 654500, "Herblore pet points", totalPetPoints(player, "Herblore", 654500)), 2618, true, true));
        database.add(new Action("Making extreme rangings", Collections.singletonList(new Requirement("Herblore", 92)), ImmutableMap.of("Super ranging potion (3)", 2781, "Grenwall spikes", 13905),
            ImmutableMap.of("Extreme ranging (3)", 2618, "Herblore", 723060, "Herblore pet points", totalPetPoints(player, "Herblore", 723060)), 2781, true, true));
        database.add(new Action("Making super Saradomin brews", Collections.singletonList(new Requirement("Herblore", 93)), ImmutableMap.of("Saradomin brew (3)", 2618, "Wine of Saradomin", 2618),
            ImmutableMap.of("Super Saradomin brew (3)", 2618, "Herblore", 471240, "Herblore pet points", totalPetPoints(player, "Herblore", 471240)), 2618, true, true));
        database.add(new Action("Making super Zamorak brews", Collections.singletonList(new Requirement("Herblore", 93)), ImmutableMap.of("Zamorak brew (3)", 2618, "Wine of Zamorak", 2618),
            ImmutableMap.of("Super Zamorak brew (3)", 2618, "Herblore", 471240, "Herblore pet points", totalPetPoints(player, "Herblore", 471240)), 2618, true, true));
        database.add(new Action("Making prayer renewals", Collections.singletonList(new Requirement("Herblore", 94)), ImmutableMap.of("Fellstalk potion (unf)", 2618, "Morchella mushroom", 2618),
            ImmutableMap.of("Prayer renewal (3)", 2618, "Herblore", 484330, "Herblore pet points", totalPetPoints(player, "Herblore", 484330)), 2618, true, true));
        database.add(new Action("Making extreme inventions", Collections.singletonList(new Requirement("Herblore", 95)), ImmutableMap.of("Super invention (3)", 2618, "Mycelial webbing", 2618),
            ImmutableMap.of("Herblore", 785400, "Herblore pet points", totalPetPoints(player, "Herblore", 785400)), 2618, true, true));
        database.add(new Action("Making overloads", Collections.singletonList(new Requirement("Herblore", 96)), ImmutableMap.builder().put("Extreme attack (3)", 1998).put("Extreme strength (3)", 1998)
            .put("Extreme defence (3)", 1998).put("Extreme magic (3)", 1998).put("Extreme ranging (3)", 1998).put("Clean torstol", 1998).build(),
            ImmutableMap.of("Herblore", 1998000, "Herblore pet points", totalPetPoints(player, "Herblore", 1998000)), 1998, true, true));

        //Hunter (done to lv5, 165 snares, 105 kebbits)
        database.add(new Action("Feeding ogleroots to rabbits", new ArrayList(), ImmutableMap.of("Coins", 3000), ImmutableMap.of("Hunter", 9000,
            "Hunter level-ticks", 6000 * player.getLevel("Hunter")), 300, true, true));
        database.add(new Action("Hunting polar kebbits", new ArrayList(), new HashMap(), ImmutableMap.of("Hunter", 3150, "Prayer", 472, "Polar kebbit fur", 105,
            "Hunter level-ticks", 6000 * player.getLevel("Hunter")), 105, true, true));
        database.add(new Action("Catching charm sprites", Collections.singletonList(new Requirement("Hunter", 72)), new HashMap(),
            ImmutableMap.builder().put("Hunter", 60000).put("Crimson charm", 40).put("Blue charm", 28).put("Green charm", 17).put("Gold charm", 6).put("Charm sprites", 435)
                .put("Hunter level-ticks", 6000 * Math.max(72, player.getLevel("Hunter"))).build(), 435, true, true));
        database.add(new Action("Catching plover birds", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Hunter", 73)),
            ImmutableMap.of("Logs", 200), ImmutableMap.builder().put("Plover bird", 68 + player.getLevel("Hunter")).put("Hunter", 510 * (68 + player.getLevel("Hunter")))
            .put("Menaphos reputaton", 30 * (68 + player.getLevel("Hunter"))).put("Pygmy giant scarab", 1).put("Clicker kalphite", 1).put("Hunter level-ticks", 6000 * Math.max(73, player.getLevel("Hunter"))).build(),
            68 + player.getLevel("Hunter"), true, true));
        database.add(new Action("Hunting common jadinkos", Arrays.asList(new Requirement("Hunter", 70), new Requirement("Farming", 54)), new HashMap(), ImmutableMap.of("Hunter", 38500,
            "Lergberry seed", 2, "Kalferberry seed", 2, "Hunter level-ticks", 6000 * Math.max(70, player.getLevel("Hunter"))), 110, true, true));
        database.add(new Action("Hunting tortles", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Hunter", 90)),
            new HashMap(), ImmutableMap.of("Hunter", 258000, "Tortoiseshell Plover", 2, "Shell chippings", 400, "Hunter level-ticks", 6000 * Math.max(90, player.getLevel("Hunter"))), 400, true, true));

        //Invention
        database.add(new Action("Refining junk", new ArrayList(), ImmutableMap.of("Junk refiner", 130, "Junk", 117000), ImmutableMap.of("Refined components", 1170, "Invention", 11700),
            1170, true, true));

        database.add(new Action("Disassembling huge spiky iron salvage", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Huge spiky iron salvage", 3000), ImmutableMap.builder().put("Invention", 900).put("Connector parts", 1757).put("Spiked parts", 1509)
            .put("Crafted parts", 1534).put("Swift components", 49).put("Precise components", 49).put("Light components", 49).put("Junk", 40050)
            .put("Invention pet points", totalPetPoints(player, "Invention", 900) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling huge plated steel salvage", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Huge plated steel salvage", 3000), ImmutableMap.builder().put("Invention", 1800).put("Cover parts", 3514).put("Plated parts", 3019)
            .put("Deflecting parts", 3068).put("Protective components", 99).put("Heavy components", 99).put("Strong components", 99).put("Junk", 35100)
            .put("Invention pet points", totalPetPoints(player, "Invention", 1800) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling lantern lenses", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Lantern lens", 3000), ImmutableMap.builder().put("Invention", 4200).put("Clear parts", 1131).put("Delicate parts", 1034)
            .put("Smooth parts", 970).put("Enhancing components", 97).put("Junk", 2766).put("Invention pet points", totalPetPoints(player, "Invention", 4200) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling harralander tar", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Harralander tar", 3000), ImmutableMap.of("Invention", 6300, "Simple parts", 2286, "Variable components", 23,
            "Junk", 690, "Invention pet points", totalPetPoints(player, "Invention", 6300) / 10), 3000, true, true));
        database.add(new Action("Disassembling super runecrafting (4)", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Super runecrafting (4)", 3000), ImmutableMap.builder().put("Invention", 6600).put("Delicate parts", 4023).put("Organic parts", 3563)
            .put("Crafted parts", 3448).put("Enhancing components", 344).put("Healthy components", 114).put("Junk", 504).put("Invention pet points", totalPetPoints(player, "Invention", 6600) / 10).build(),
            3000, true, true));
        database.add(new Action("Disassembling rune bull rush scrolls", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Rune bull rush scroll", 30000), ImmutableMap.builder().put("Invention", 7500).put("Spiritual parts", 3571)
            .put("Crafted parts", 2202).put("Powerful components", 178).put("Junk", 48).put("Invention pet points", totalPetPoints(player, "Invention", 7500) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling portents of restoration IX", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Portent of restoration IX", 3000), ImmutableMap.builder().put("Invention", 7500).put("Magic parts", 7588)
            .put("Crafted parts", 1160).put("Ethereal components", 178).put("Junk", 72).put("Invention pet points", totalPetPoints(player, "Invention", 7500) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling tortured souls", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Tortured soul", 3000), ImmutableMap.of("Invention", 8100, "Organic parts", 2940, "Pious components", 60,
            "Invention pet points", totalPetPoints(player, "Invention", 8100) / 10), 3000, true, true));
        database.add(new Action("Disassembling fly trap seeds", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Fly trap seed", 3000), ImmutableMap.of("Invention", 8100, "Organic parts", 2970, "Living components", 30,
            "Invention pet points", totalPetPoints(player, "Invention", 8100) / 10), 3000, true, true));
        database.add(new Action("Disassembling unpowered symbols", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Unpowered symbol", 3000), ImmutableMap.builder().put("Invention", 15300).put("Delicate parts", 981)
            .put("Connector parts", 841).put("Smooth parts", 841).put("Precious components", 84).put("Enhancing components", 56).put("Junk", 12194)
            .put("Invention pet points", totalPetPoints(player, "Invention", 15300) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling steel hastae", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Steel hasta", 3000), ImmutableMap.builder().put("Invention", 18000).put("Stave parts", 1848)
            .put("Blade parts", 1583).put("Crafted parts", 1583).put("Precise components", 158).put("Direct components", 105).put("Junk", 18720)
            .put("Invention pet points", totalPetPoints(player, "Invention", 18000) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling black 2h swords", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Black 2h sword", 3000), ImmutableMap.builder().put("Invention", 22500).put("Knightly components", 3000).put("Base parts", 3465)
            .put("Blade parts", 2970).put("Metallic parts", 2970).put("Sharp components", 297).put("Strong components", 198).put("Junk", 26099)
            .put("Invention pet points", totalPetPoints(player, "Invention", 22500) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling off-hand black scimitars", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Off-hand black scimitar", 3000), ImmutableMap.builder().put("Invention", 22500).put("Knightly components", 3000).put("Base parts", 2310)
            .put("Blade parts", 1980).put("Metallic parts", 1980).put("Sharp components", 198).put("Subtle components", 132).put("Junk", 17400)
            .put("Invention pet points", totalPetPoints(player, "Invention", 22500) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling white maces", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("White mace", 3000), ImmutableMap.builder().put("Invention", 22500).put("Knightly components", 3000).put("Base parts", 2310)
            .put("Head parts", 1980).put("Smooth parts", 1980).put("Heavy components", 198).put("Dextrous components", 132).put("Junk", 17400)
            .put("Invention pet points", totalPetPoints(player, "Invention", 22500) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling carapace boots", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Carapace boots", 3000), ImmutableMap.builder().put("Invention", 27000).put("Cover parts", 1386).put("Tensile parts", 1188)
            .put("Padded parts", 1188).put("Evasive components", 118).put("Protective components", 79).put("Junk", 8040)
            .put("Invention pet points", totalPetPoints(player, "Invention", 27000) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling yew shieldbows", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Yew shieldbow", 3000), ImmutableMap.builder().put("Invention", 36000).put("Stave parts", 5544).put("Tensile parts", 4752)
            .put("Flexible parts", 4752).put("Precise components", 475).put("Imbued components", 316).put("Junk", 20160)
            .put("Invention pet points", totalPetPoints(player, "Invention", 36000) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling Slayer's staves", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Slayer's staff", 3000), ImmutableMap.builder().put("Invention", 49500).put("Stave parts", 7623).put("Magic parts", 6534)
            .put("Padded parts", 6534).put("Powerful components", 653).put("Imbued components", 435).put("Junk", 14220)
            .put("Invention pet points", totalPetPoints(player, "Invention", 49500) / 10).build(), 3000, true, true));
        database.add(new Action("Disassembling red salamanders", Arrays.asList(new Requirement("Divination", 80), new Requirement("Crafting", 80),
            new Requirement("Smithing", 80)), ImmutableMap.of("Red salamander", 3000), ImmutableMap.builder().put("Invention", 54000).put("Connector parts", 8316).put("Tensile parts", 7127)
            .put("Crafted parts", 7127).put("Stunning components", 712).put("Dextrous components", 475).put("Junk", 12240)
            .put("Invention pet points", totalPetPoints(player, "Invention", 54000) / 10).build(), 3000, true, true));

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

        //Mining (done)
        database.add(new Action("Mining copper with bronze pickaxe", Collections.singletonList(new Requirement("Bronze pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 5, 0.66), "Copper ore", miningDamage(player, 5) / 40,
            "Copper mined", miningDamage(player, 5) / 40, "Mining level-ticks", 6000 * player.getLevel("Mining")), 1500, true, true));

        database.add(new Action("Mining tin with bronze pickaxe", Collections.singletonList(new Requirement("Bronze pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 5, 0.66), "Tin ore", miningDamage(player, 5) / 40,
            "Tin mined", miningDamage(player, 5) / 40, "Mining level-ticks", 6000 * player.getLevel("Mining")), 1500, true, true));

        database.add(new Action("Mining iron with iron pickaxe + 1", Arrays.asList(new Requirement("Mining", 10), new Requirement("Iron pickaxe + 1", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 11, 0.68), "Iron ore", miningDamage(player, 11) / 120,
            "Iron mined", miningDamage(player, 11) / 120, "Mining level-ticks", 6000 * Math.max(10, player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining coal with steel pickaxe + 1", Arrays.asList(new Requirement("Mining", 20), new Requirement("Steel pickaxe + 1", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 21, 0.7), "Coal", miningDamage(player, 21) / 140,
            "Coal mined", miningDamage(player, 21) / 140, "Mining level-ticks", 6000 * Math.max(20, player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining mithril with mithril pickaxe + 2", Arrays.asList(new Requirement("Mining", 30), new Requirement("Mithril pickaxe + 2", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 32, 0.72), "Mithril ore", miningDamage(player, 32) / 240,
            "Mithril mined", miningDamage(player, 32) / 240, "Mining level-ticks", 6000 * Math.max(30, player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining adamantite with adamant pickaxe + 2", Arrays.asList(new Requirement("Mining", 40), new Requirement("Adamant pickaxe + 2", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 42, 0.74), "Adamantite ore", miningDamage(player, 42) / 380,
            "Adamantite mined", miningDamage(player, 42) / 380, "Mining level-ticks", 6000 * Math.max(40, player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining luminite with adamant pickaxe + 2", Arrays.asList(new Requirement("Mining", 40), new Requirement("Adamant pickaxe + 2", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 42, 0.74), "Luminite", miningDamage(player, 42) / 380,
            "Luminite mined", miningDamage(player, 42) / 380, "Mining level-ticks", 6000 * Math.max(40, player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining runite with rune pickaxe + 3", Arrays.asList(new Requirement("Mining", 50), new Requirement("Rune pickaxe + 3", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 53, 0.76), "Runite ore", miningDamage(player, 53) / 600,
            "Runite mined", miningDamage(player, 53) / 600, "Mining level-ticks", 6000 * Math.max(50, player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining orichalcite with orikalkum pickaxe + 3", Arrays.asList(new Requirement("Mining", 60), new Requirement("Orikalkum pickaxe + 3", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 63, 0.78), "Orichalcite ore", miningDamage(player, 63) / 1400,
            "Orichalcite mined", miningDamage(player, 63) / 1400, "Mining level-ticks", 6000 * Math.max(60, player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining drakolith with orikalkum pickaxe + 3", Arrays.asList(new Requirement("Mining", 60), new Requirement("Orikalkum pickaxe + 3", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 63, 0.78), "Drakolith", miningDamage(player, 63) / 1400,
            "Drakolith mined", miningDamage(player, 63) / 1400, "Mining level-ticks", 6000 * Math.max(60, player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining necrite with necronium pickaxe", Arrays.asList(new Requirement("Mining", 70), new Requirement("Necronium pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 70, 0.8), "Necrite ore", miningDamage(player, 70) / 1300,
            "Necrite mined", miningDamage(player, 70) / 1300, "Mining level-ticks", 6000 * Math.max(70, player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining phasmatite with necronium pickaxe", Arrays.asList(new Requirement("Mining", 70), new Requirement("Necronium pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 70, 0.8), "Phasmatite", miningDamage(player, 70) / 1300,
            "Phasmatite mined", miningDamage(player, 70) / 1300, "Mining level-ticks", 6000 * Math.max(70, player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining banite with bane pickaxe", Arrays.asList(new Requirement("Mining", 80), new Requirement("Bane pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 80, 0.82), "Banite ore", miningDamage(player, 80) / 1700,
            "Banite mined", miningDamage(player, 80) / 1700, "Mining level-ticks", 6000 * Math.max(80, player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining light animica with elder rune pickaxe", Arrays.asList(new Requirement("Mining", 90), new Requirement("Elder rune pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 90, 0.84), "Light animica", miningDamage(player, 90) / 2000,
            "Light animica mined", miningDamage(player, 90) / 2000, "Mining level-ticks", 6000 * Math.max(90, player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining dark animica with elder rune pickaxe", Arrays.asList(new Requirement("Mining", 90), new Requirement("Elder rune pickaxe", 1)),
            new HashMap<>(), ImmutableMap.of("Mining", miningXP(player, 90, 0.84), "Dark animica", miningDamage(player, 90) / 2000,
            "Dark animica mined", miningDamage(player, 90) / 2000, "Mining level-ticks", 6000 * Math.max(90, player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));


        database.add(new Action("Mining/dropping concentrated sandstone with rune pickaxe", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Mining", 50), new Requirement("Rune pickaxe", 1)), new HashMap(), ImmutableMap.builder().put("Mining", miningXP(player, 50, 0.76))
            .put("Menaphos reputation", (int) Math.floor(miningXP(player, 50, 0.76) / 45.6)).put("Menaphite honey bee in amber", 1)
            .put("Pygmy giant scarab in amber", 1).put("Mining level-ticks", 6000 * Math.max(50, player.getLevel("Mining"))).put("Umesco arpos", 1)
            .put("Crondite", 1).build(), 1500, true, true));

        database.add(new Action("Mining/dropping concentrated sandstone with rune pickaxe (VIP area)", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Mining", 50), new Requirement("Rune pickaxe", 1), new Requirement("Menaphos reputation", 141900)), new HashMap(), ImmutableMap.builder().put("Mining", miningXP(player, 50, 0.76))
            .put("Menaphos reputation", (int) Math.floor(miningXP(player, 50, 0.76) / 45.6)).put("Menaphite honey bee in amber", 1)
            .put("Pygmy giant scarab in amber", 1).put("Mining level-ticks", 6000 * Math.max(50, player.getLevel("Mining"))).put("Phenakite", 1)
            .put("Crondite", 1).put("Umesco arpos", 1).build(), 1500, true, true));

        database.add(new Action("Lava Flow Mine with necronium pickaxe", Arrays.asList(new Requirement("King of the Dwarves", 1), new Requirement("Necronium pickaxe", 1)),
            new HashMap(), ImmutableMap.of("Mining", miningXP(player, 70, 0.78), "Imcando pickaxe fragment", 1, "Lava Flow Mine damage", miningDamage(player, 70),
            "Mining level-ticks", 6000 * Math.max(68, player.getLevel("Mining"))), 1500, true, true));

        database.add(new Action("Mining Seren stones with bane pickaxe", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Mining", 89),
            new Requirement("Bane pickaxe", 1)), new HashMap(), ImmutableMap.of("Corrupted ore", miningDamage(player, 80) / 240,
            "Mining", miningXP(player, 80, 1.2), "Mining level-ticks", 6000 * Math.max(89, player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        database.add(new Action("Mining salty crablets with elder rune pickaxe", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Mining", 90),
            new Requirement("Elder rune pickaxe", 1)), new HashMap(), ImmutableMap.of("Sea salt", (int) Math.floor(miningDamage(player, 90) / 1200),
            "Mining", miningXP(player, 90, 0.82), "Awah Guan", 1, "Mining level-ticks", 6000 * Math.max(90, player.getLevel("Mining")),
            "Gemstone golem fragments", 1200), 1500, true, true));

        //Prayer (done)
        database.add(new Action("Offering impious ashes to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Impious ashes", 1400), ImmutableMap.of("Prayer", 19600,
            "Prayer pet points", totalPetPoints(player, "Prayer", 19600)), 1400, true, false));
        database.add(new Action("Offering bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Bones", 1400), ImmutableMap.of("Prayer", 22050,
            "Prayer pet points", totalPetPoints(player, "Prayer", 22050)), 1400, true, false));
        database.add(new Action("Offering accursed ashes to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Accursed ashes", 1400), ImmutableMap.of("Prayer", 61250,
            "Prayer pet points", totalPetPoints(player, "Prayer", 61250)), 1400, true, false));
        database.add(new Action("Offering big bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Big bones", 1400), ImmutableMap.of("Prayer", 73500,
            "Prayer pet points", totalPetPoints(player, "Prayer", 73500)), 1400, true, false));
        database.add(new Action("Offering baby dragon bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Baby dragon bones", 1400), ImmutableMap.of("Prayer", 147000,
            "Prayer pet points", totalPetPoints(player, "Prayer", 147000)), 1400, true, false));
        database.add(new Action("Offering wyvern bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Wyvern bones", 1400), ImmutableMap.of("Prayer", 245000,
            "Prayer pet points", totalPetPoints(player, "Prayer", 245000)), 1400, true, false));
        database.add(new Action("Offering infernal ashes to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Infernal ashes", 1400), ImmutableMap.of("Prayer", 306250,
            "Prayer pet points", totalPetPoints(player, "Prayer", 306250)), 1400, true, false));
        database.add(new Action("Offering dragon bones to Chaos Altar", new ArrayList<>(), ImmutableMap.of("Dragon bones", 1400), ImmutableMap.of("Prayer", 352800,
            "Prayer pet points", totalPetPoints(player, "Prayer", 352800)), 1400, true, false));
        database.add(new Action("Offering dagannoth bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Dagannoth bones", 1400), ImmutableMap.of("Prayer", 612500,
            "Prayer pet points", totalPetPoints(player, "Prayer", 612500)), 1400, true, false));
        database.add(new Action("Offering airut bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Airut bones", 1400), ImmutableMap.of("Prayer", 649250,
            "Prayer pet points", totalPetPoints(player, "Prayer", 649250)), 1400, true, false));
        database.add(new Action("Offering ourg bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Ourg bones (General Graardor)", 1400), ImmutableMap.of("Prayer", 686000,
            "Prayer pet points", totalPetPoints(player, "Prayer", 686000)), 1400, true, false));
        database.add(new Action("Offering hardened dragon bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Hardened dragon bones", 1400), ImmutableMap.of("Prayer", 705600,
            "Prayer pet points", totalPetPoints(player, "Prayer", 705600)), 1400, true, false));
        database.add(new Action("Offering frost dragon bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Frost dragon bones", 1400), ImmutableMap.of("Prayer", 882000,
            "Prayer pet points", totalPetPoints(player, "Prayer", 882000)), 1400, true, false));
        database.add(new Action("Offering reinforced dragon bones to Chaos Altar", new ArrayList(), ImmutableMap.of("Reinforced dragon bones", 1400), ImmutableMap.of("Prayer", 931000,
            "Prayer pet points", totalPetPoints(player, "Prayer", 931000)), 1400, true, false));
        database.add(new Action("Offering searing ashes to Chaos Altar", new ArrayList(), ImmutableMap.of("Searing ashes", 1400), ImmutableMap.of("Prayer", 980000,
            "Prayer pet points", totalPetPoints(player, "Prayer", 980000)), 1400, true, false));
    }

    private void addSkillingActionsToDatabasePart2(Player player) {

        //Runecrafting (done to lv77)
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

        //Slayer (done)
        database.add(new Action("Slayer tasks from Turael", new ArrayList(), new HashMap(), ImmutableMap.of("Slayer",
            SlayerMaster.TURAEL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(), "Slayer pet points", totalPetPoints(player, "Slayer",
                SlayerMaster.TURAEL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        database.add(new Action("Slayer tasks from Mazchna", Collections.singletonList(new Requirement("Combat", 20)), new HashMap(),
            ImmutableMap.of("Slayer", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
                "Slayer point", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue(), "Slayer task streak", 1,
                "Slayer pet points", totalPetPoints(player, "Slayer", SlayerMaster.MAZCHNA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        database.add(new Action("Slayer tasks from Vannaka", Collections.singletonList(new Requirement("Combat", 40)), new HashMap(),
            ImmutableMap.of("Slayer", SlayerMaster.VANNAKA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
                "Slayer point", SlayerMaster.VANNAKA.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue(), "Slayer task streak", 1,
                "Slayer pet points", totalPetPoints(player, "Slayer", SlayerMaster.VANNAKA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        database.add(new Action("Slayer tasks from Chaeldar", Arrays.asList(new Requirement("Combat", 75), new Requirement("Lost City", 1)), new HashMap(),
            ImmutableMap.of("Slayer", SlayerMaster.CHAELDAR.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
                "Slayer point", SlayerMaster.CHAELDAR.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue(), "Slayer task streak", 1,
                "Slayer pet points", totalPetPoints(player, "Slayer", SlayerMaster.CHAELDAR.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        database.add(new Action("Slayer tasks from Sumona", Arrays.asList(new Requirement("Combat", 90), new Requirement("Slayer", 35), new Requirement("Lost City", 1)), new HashMap(),
            ImmutableMap.of("Slayer", SlayerMaster.SUMONA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
                "Slayer point", SlayerMaster.SUMONA.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue(), "Slayer task streak", 1,
                "Slayer pet points", totalPetPoints(player, "Slayer", SlayerMaster.SUMONA.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        database.add(new Action("Slayer tasks from Duradel", Arrays.asList(new Requirement("Combat", 100), new Requirement("Slayer", 50), new Requirement("Shilo Village", 1)), new HashMap(),
            ImmutableMap.of("Slayer", SlayerMaster.DURADEL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
                "Slayer point", SlayerMaster.DURADEL.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue(), "Slayer task streak", 1,
                "Slayer pet points", totalPetPoints(player, "Slayer", SlayerMaster.DURADEL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        database.add(new Action("Slayer tasks from Kuradal", Arrays.asList(new Requirement("Combat", 110), new Requirement("Slayer", 75)), new HashMap(),
            ImmutableMap.of("Slayer", SlayerMaster.KURADAL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
                "Slayer point", SlayerMaster.KURADAL.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue(), "Slayer task streak", 1,
                "Slayer pet points", totalPetPoints(player, "Slayer", SlayerMaster.KURADAL.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        database.add(new Action("Slayer tasks from Morvran", Arrays.asList(new Requirement("Combat", 120), new Requirement("Slayer", 85), new Requirement("Plague's End", 1)), new HashMap(),
            ImmutableMap.of("Slayer", SlayerMaster.MORVRAN.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue(),
                "Slayer point", SlayerMaster.MORVRAN.calculateAvgXpAndSlayerPointsPerHour(player).values().iterator().next().intValue(), "Slayer task streak", 1,
                "Slayer pet points", totalPetPoints(player, "Slayer", SlayerMaster.MORVRAN.calculateAvgXpAndSlayerPointsPerHour(player).keySet().iterator().next().intValue())), 6000, true, true));

        //Smithing
        database.add(new Action("Smithing bronze platebodies", new ArrayList(), ImmutableMap.of("Bronze bar", 450), ImmutableMap.of("Bronze platebody", 90, "Smithing", 6750,
            "Smithing pet points", totalPetPoints(player, "Smithing", 6750)), 90, true, true));
        database.add(new Action("Smithing bronze platebodies (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 3)), ImmutableMap.of("Bronze bar", 475),
            ImmutableMap.of("Bronze platebody", 95, "Smithing", 7125, "Smithing pet points", totalPetPoints(player, "Smithing", 7125)), 95, true, true));
        database.add(new Action("Smithing bronze platebodies (max heat start)", Collections.singletonList(new Requirement("Smithing", 6)), ImmutableMap.of("Bronze bar", 525),
            ImmutableMap.of("Bronze platebody", 105, "Smithing", 7875, "Smithing pet points", totalPetPoints(player, "Smithing", 7875)), 105, true, true));
        database.add(new Action("Smithing bronze platebodies (2-tick max heating)", Collections.singletonList(new Requirement("Smithing", 7)), ImmutableMap.of("Bronze bar", 535),
            ImmutableMap.of("Bronze platebody", 107, "Smithing", 8025, "Smithing pet points", totalPetPoints(player, "Smithing", 8025)), 107, true, true));
        database.add(new Action("Smithing bronze platebodies (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 8)), ImmutableMap.of("Bronze bar", 635),
            ImmutableMap.of("Bronze platebody", 127, "Smithing", 9525, "Smithing pet points", totalPetPoints(player, "Smithing", 9525)), 127, true, true));
        database.add(new Action("Smithing iron platebodies", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 240),
            ImmutableMap.of("Iron platebody", 48, "Smithing", 9600, "Smithing pet points", totalPetPoints(player, "Smithing", 9600)), 48, true, true));
        database.add(new Action("Smithing iron platebodies + 1", Collections.singletonList(new Requirement("Smithing", 10)), ImmutableMap.of("Iron bar", 310, "Iron platebody", 62),
            ImmutableMap.of("Iron platebody + 1", 62, "Smithing", 12400, "Smithing pet points", totalPetPoints(player, "Smithing", 12400)), 62, true, true));
        database.add(new Action("Smithing iron platebodies (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 250),
            ImmutableMap.of("Iron platebody", 50, "Smithing", 10000, "Smithing pet points", totalPetPoints(player, "Smithing", 10000)), 50, true, true));
        database.add(new Action("Smithing iron platebodies + 1 (4-tick max heating)", Collections.singletonList(new Requirement("Smithing", 12)), ImmutableMap.of("Iron bar", 320, "Iron platebody", 64),
            ImmutableMap.of("Iron platebody + 1", 64, "Smithing", 12800, "Smithing pet points", totalPetPoints(player, "Smithing", 12800)), 64, true, true));
        database.add(new Action("Smithing iron platebodies (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 285),
            ImmutableMap.of("Iron platebody", 57, "Smithing", 11400, "Smithing pet points", totalPetPoints(player, "Smithing", 11400)), 57, true, true));
        database.add(new Action("Smithing iron platebodies + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 13)), ImmutableMap.of("Iron bar", 340, "Iron platebody", 68),
            ImmutableMap.of("Iron platebody + 1", 68, "Smithing", 13600, "Smithing pet points", totalPetPoints(player, "Smithing", 13600)), 68, true, true));
        database.add(new Action("Smithing iron platebodies (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 300),
            ImmutableMap.of("Iron platebody", 60, "Smithing", 12000, "Smithing pet points", totalPetPoints(player, "Smithing", 12000)), 60, true, true));
        database.add(new Action("Smithing iron platebodies + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 16)), ImmutableMap.of("Iron bar", 370, "Iron platebody", 74),
            ImmutableMap.of("Iron platebody + 1", 74, "Smithing", 14800, "Smithing pet points", totalPetPoints(player, "Smithing", 14800)), 74, true, true));
        database.add(new Action("Smithing iron platebodies (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 18)), ImmutableMap.of("Iron bar", 305),
            ImmutableMap.of("Iron platebody", 61, "Smithing", 12200, "Smithing pet points", totalPetPoints(player, "Smithing", 12200)), 61, true, true));
        database.add(new Action("Smithing iron platebodies + 1 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 18)), ImmutableMap.of("Iron bar", 375, "Iron platebody", 75),
            ImmutableMap.of("Iron platebody + 1", 75, "Smithing", 15000, "Smithing pet points", totalPetPoints(player, "Smithing", 15000)), 75, true, true));
        database.add(new Action("Smithing steel platebodies", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 170),
            ImmutableMap.of("Steel platebody", 34, "Smithing", 12750, "Smithing pet points", totalPetPoints(player, "Smithing", 12750)), 34, true, true));
        database.add(new Action("Smithing steel platebodies + 1", Collections.singletonList(new Requirement("Smithing", 20)), ImmutableMap.of("Steel bar", 205, "Steel platebody", 41),
            ImmutableMap.of("Steel platebody + 1", 41, "Smithing", 15375, "Smithing pet points", totalPetPoints(player, "Smithing", 15375)), 41, true, true));
        database.add(new Action("Smithing steel platebodies (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 175),
            ImmutableMap.of("Steel platebody", 35, "Smithing", 13125, "Smithing pet points", totalPetPoints(player, "Smithing", 13125)), 35, true, true));
        database.add(new Action("Smithing steel platebodies + 1 (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 22)), ImmutableMap.of("Steel bar", 215, "Steel platebody", 43),
            ImmutableMap.of("Steel platebody + 1", 43, "Smithing", 16125, "Smithing pet points", totalPetPoints(player, "Smithing", 16125)), 43, true, true));
        database.add(new Action("Smithing steel platebodies (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 190),
            ImmutableMap.of("Steel platebody", 38, "Smithing", 14250, "Smithing pet points", totalPetPoints(player, "Smithing", 14250)), 38, true, true));
        database.add(new Action("Smithing steel platebodies + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 25)), ImmutableMap.of("Steel bar", 230, "Steel platebody", 46),
            ImmutableMap.of("Steel platebody + 1", 46, "Smithing", 17250, "Smithing pet points", totalPetPoints(player, "Smithing", 17250)), 46, true, true));
        database.add(new Action("Smithing steel platebodies (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 195),
            ImmutableMap.of("Steel platebody", 39, "Smithing", 14625, "Smithing pet points", totalPetPoints(player, "Smithing", 14625)), 39, true, true));
        database.add(new Action("Smithing steel platebodies + 1 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 26)), ImmutableMap.of("Steel bar", 240, "Steel platebody", 48),
            ImmutableMap.of("Steel platebody + 1", 48, "Smithing", 18000, "Smithing pet points", totalPetPoints(player, "Smithing", 18000)), 48, true, true));
        database.add(new Action("Smithing steel platebodies (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 200),
            ImmutableMap.of("Steel platebody", 40, "Smithing", 15000, "Smithing pet points", totalPetPoints(player, "Smithing", 15000)), 40, true, true));
        database.add(new Action("Smithing steel platebodies + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 28)), ImmutableMap.of("Steel bar", 255, "Steel platebody", 51),
            ImmutableMap.of("Steel platebody + 1", 51, "Smithing", 19125, "Smithing pet points", totalPetPoints(player, "Smithing", 19125)), 51, true, true));
        database.add(new Action("Smithing mithril platebodies", Collections.singletonList(new Requirement("Smithing", 30)), ImmutableMap.of("Mithril bar", 130),
            ImmutableMap.of("Mithril platebody", 26, "Smithing", 15600, "Smithing pet points", totalPetPoints(player, "Smithing", 15600)), 26, true, true));
        database.add(new Action("Smithing mithril platebodies + 1", Collections.singletonList(new Requirement("Smithing", 30)), ImmutableMap.of("Mithril bar", 160, "Mithril platebody", 32),
            ImmutableMap.of("Mithril platebody + 1", 32, "Smithing", 19200, "Smithing pet points", totalPetPoints(player, "Smithing", 19200)), 32, true, true));
        database.add(new Action("Smithing mithril platebodies + 2", Collections.singletonList(new Requirement("Smithing", 30)), ImmutableMap.of("Mithril bar", 260, "Mithril platebody + 1", 26),
            ImmutableMap.of("Mithril platebody + 2", 26, "Smithing", 31200, "Smithing pet points", totalPetPoints(player, "Smithing", 31200)), 26, true, true));
        database.add(new Action("Smithing mithril platebodies (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 34)), ImmutableMap.of("Mithril bar", 140),
            ImmutableMap.of("Mithril platebody", 28, "Smithing", 16800, "Smithing pet points", totalPetPoints(player, "Smithing", 16800)), 28, true, true));
        database.add(new Action("Smithing mithril platebodies + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 34)), ImmutableMap.of("Mithril bar", 175,
            "Mithril platebody", 35), ImmutableMap.of("Mithril platebody + 1", 35, "Smithing", 21000, "Smithing pet points", totalPetPoints(player, "Smithing", 21000)), 35, true, true));
        database.add(new Action("Smithing mithril platebodies + 2 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 34)), ImmutableMap.of("Mithril bar", 280,
            "Mithril platebody + 1", 28), ImmutableMap.of("Mithril platebody + 2", 28, "Smithing", 33600, "Smithing pet points", totalPetPoints(player, "Smithing", 33600)), 28, true, true));
        database.add(new Action("Smithing mithril platebodies + 1 (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 35)), ImmutableMap.of("Mithril bar", 180,
            "Mithril platebody", 36), ImmutableMap.of("Mithril platebody + 1", 36, "Smithing", 21600, "Smithing pet points", totalPetPoints(player, "Smithing", 21600)), 36, true, true));
        database.add(new Action("Smithing mithril platebodies (max heat start)", Collections.singletonList(new Requirement("Smithing", 36)), ImmutableMap.of("Mithril bar", 145),
            ImmutableMap.of("Mithril platebody", 29, "Smithing", 17400, "Smithing pet points", totalPetPoints(player, "Smithing", 17400)), 29, true, true));
        database.add(new Action("Smithing mithril platebodies + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 36)), ImmutableMap.of("Mithril bar", 185,
            "Mithril platebody", 37), ImmutableMap.of("Mithril platebody + 1", 37, "Smithing", 22200, "Smithing pet points", totalPetPoints(player, "Smithing", 22200)), 37, true, true));
        database.add(new Action("Smithing mithril platebodies + 2 (max heat start)", Collections.singletonList(new Requirement("Smithing", 36)), ImmutableMap.of("Mithril bar", 290,
            "Mithril platebody + 1", 29), ImmutableMap.of("Mithril platebody + 2", 29, "Smithing", 34800, "Smithing pet points", totalPetPoints(player, "Smithing", 34800)), 29, true, true));
        database.add(new Action("Smithing mithril platebodies (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 39)), ImmutableMap.of("Mithril bar", 150),
            ImmutableMap.of("Mithril platebody", 30, "Smithing", 18000, "Smithing pet points", totalPetPoints(player, "Smithing", 18000)), 30, true, true));
        database.add(new Action("Smithing mithril platebodies + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 39)), ImmutableMap.of("Mithril bar", 190,
            "Mithril platebody", 38), ImmutableMap.of("Mithril platebody + 1", 38, "Smithing", 22800, "Smithing pet points", totalPetPoints(player, "Smithing", 22800)), 38, true, true));
        database.add(new Action("Smithing mithril platebodies + 2 (max heat start)", Collections.singletonList(new Requirement("Smithing", 39)), ImmutableMap.of("Mithril bar", 300,
            "Mithril platebody + 1", 30), ImmutableMap.of("Mithril platebody + 2", 30, "Smithing", 36000, "Smithing pet points", totalPetPoints(player, "Smithing", 36000)), 30, true, true));
        database.add(new Action("Smithing adamant platebodies", Collections.singletonList(new Requirement("Smithing", 40)), ImmutableMap.of("Adamant bar", 100),
            ImmutableMap.of("Adamant platebody", 20, "Smithing", 17000, "Smithing pet points", totalPetPoints(player, "Smithing", 17000)), 20, true, true));
        database.add(new Action("Smithing adamant platebodies + 1", Collections.singletonList(new Requirement("Smithing", 40)), ImmutableMap.of("Adamant bar", 130,
            "Adamant platebody", 26), ImmutableMap.of("Adamant platebody + 1", 26, "Smithing", 22100, "Smithing pet points", totalPetPoints(player, "Smithing", 22100)), 26, true, true));
        database.add(new Action("Smithing adamant platebodies + 2", Collections.singletonList(new Requirement("Smithing", 40)), ImmutableMap.of("Adamant bar", 200,
            "Adamant platebody + 1", 20), ImmutableMap.of("Adamant platebody + 2", 20, "Smithing", 34000, "Smithing pet points", totalPetPoints(player, "Smithing", 34000)), 20, true, true));
        database.add(new Action("Smithing adamant burial platebodies", Collections.singletonList(new Requirement("Smithing", 40)), ImmutableMap.of("Adamant platebody + 2", 40),
            ImmutableMap.of("Smithing", 68000, "Smithing pet points", totalPetPoints(player, "Smithing", 68000)), 40, true, true));
        database.add(new Action("Smithing adamant burial sets", Collections.singletonList(new Requirement("Smithing", 40)), ImmutableMap.of("Adamant platebody + 2", 17, "Adamant full helm + 2", 17,
            "Adamant platelegs + 2", 17, "Adamant gauntlets + 2", 17, "Adamant armoured boots + 2", 17), ImmutableMap.of("Smithing", 72828,
            "Smithing pet points", totalPetPoints(player, "Smithing", 72828)), 17, true, true));
        database.add(new Action("Smithing adamant platebodies (max heat start)", Collections.singletonList(new Requirement("Smithing", 41)), ImmutableMap.of("Adamant bar", 105),
            ImmutableMap.of("Adamant platebody", 21, "Smithing", 17850, "Smithing pet points", totalPetPoints(player, "Smithing", 17850)), 21, true, true));
        database.add(new Action("Smithing adamant platebodies + 1 (max heat start)", Collections.singletonList(new Requirement("Smithing", 41)), ImmutableMap.of("Adamant bar", 135,
            "Adamant platebody", 27), ImmutableMap.of("Adamant platebody + 1", 27, "Smithing", 22950, "Smithing pet points", totalPetPoints(player, "Smithing", 22950)), 27, true, true));
        database.add(new Action("Smithing adamant platebodies + 2 (max heat start)", Collections.singletonList(new Requirement("Smithing", 41)), ImmutableMap.of("Adamant bar", 210,
            "Adamant platebody + 1", 21), ImmutableMap.of("Adamant platebody + 2", 21, "Smithing", 35700, "Smithing pet points", totalPetPoints(player, "Smithing", 35700)), 21, true, true));
        database.add(new Action("Smithing adamant burial platebodies (max heat start)", Collections.singletonList(new Requirement("Smithing", 41)), ImmutableMap.of("Adamant platebody + 2", 42),
            ImmutableMap.of("Smithing", 71400, "Smithing pet points", totalPetPoints(player, "Smithing", 71400)), 42, true, true));
        database.add(new Action("Smithing adamant burial sets (max heat start)", Collections.singletonList(new Requirement("Smithing", 41)), ImmutableMap.of("Adamant platebody + 2", 18,
            "Adamant full helm + 2", 18, "Adamant platelegs + 2", 18, "Adamant gauntlets + 2", 18, "Adamant armoured boots + 2", 18), ImmutableMap.of("Smithing", 77112,
            "Smithing pet points", totalPetPoints(player, "Smithing", 77112)), 18, true, true));
        database.add(new Action("Smithing adamant burial platebodies (4-tick heating)", Collections.singletonList(new Requirement("Smithing", 42)), ImmutableMap.of("Adamant platebody + 2", 43),
            ImmutableMap.of("Smithing", 73100, "Smithing pet points", totalPetPoints(player, "Smithing", 73100)), 43, true, true));
        database.add(new Action("Smithing adamant platebodies (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 44)), ImmutableMap.of("Adamant bar", 110),
            ImmutableMap.of("Adamant platebody", 22, "Smithing", 18700, "Smithing pet points", totalPetPoints(player, "Smithing", 18700)), 22, true, true));
        database.add(new Action("Smithing adamant platebodies + 2 (2-tick heating)", Collections.singletonList(new Requirement("Smithing", 44)), ImmutableMap.of("Adamant bar", 220,
            "Adamant platebody + 1", 22), ImmutableMap.of("Adamant platebody + 2", 22, "Smithing", 37400, "Smithing pet points", totalPetPoints(player, "Smithing", 37400)), 22, true, true));
        database.add(new Action("Smithing adamant burial platebodies (lv47 heat)", Collections.singletonList(new Requirement("Smithing", 47)), ImmutableMap.of("Adamant platebody + 2", 45),
            ImmutableMap.of("Smithing", 76500, "Smithing pet points", totalPetPoints(player, "Smithing", 76500)), 45, true, true));
        database.add(new Action("Smithing adamant platebodies (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 49)), ImmutableMap.of("Adamant bar", 120),
            ImmutableMap.of("Adamant platebody", 24, "Smithing", 20400, "Smithing pet points", totalPetPoints(player, "Smithing", 20400)), 24, true, true));
        database.add(new Action("Smithing adamant platebodies + 1 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 49)), ImmutableMap.of("Adamant bar", 155,
            "Adamant platebody", 31), ImmutableMap.of("Adamant platebody + 1", 31, "Smithing", 26350, "Smithing pet points", totalPetPoints(player, "Smithing", 26350)), 31, true, true));
        database.add(new Action("Smithing adamant platebodies + 2 (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 49)), ImmutableMap.of("Adamant bar", 240,
            "Adamant platebody + 1", 24), ImmutableMap.of("Adamant platebody + 2", 24, "Smithing", 40800, "Smithing pet points", totalPetPoints(player, "Smithing", 40800)), 24, true, true));
        database.add(new Action("Smithing adamant burial platebodies (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 49)), ImmutableMap.of("Adamant platebody + 2", 50),
            ImmutableMap.of("Smithing", 85000, "Smithing pet points", totalPetPoints(player, "Smithing", 85000)), 50, true, true));
        database.add(new Action("Smithing adamant burial sets (11 progress strikes)", Collections.singletonList(new Requirement("Smithing", 49)), ImmutableMap.of("Adamant platebody + 2", 20,
            "Adamant full helm + 2", 20, "Adamant platelegs + 2", 20, "Adamant gauntlets + 2", 20, "Adamant armoured boots + 2", 20), ImmutableMap.of("Smithing", 85680,
            "Smithing pet points", totalPetPoints(player, "Smithing", 85680)), 20, true, true));
        //57

        //Summoning (done to lv24)
        database.add(new Action("Making spirit wolf pouches", new ArrayList(), ImmutableMap.of("Spirit shards", 10500, "Pouch", 1500,
            "Wolf bones", 1500, "Gold charm", 1500), ImmutableMap.of("Spirit wolf pouch", 1500, "Summoning", 7200,
            "Summoning pet points", totalPetPoints(player, "Summoning", 7200)), 1500, true, true));
        database.add(new Action("Making spirit wolf pouches (selling noted items)", new ArrayList(), ImmutableMap.of("Spirit shards", 70000, "Pouch", 10000,
            "Wolf bones", 10000, "Gold charm", 10000), ImmutableMap.of("Howl scroll", 100000, "Summoning", 58000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 58000)), 400, true, true));
        database.add(new Action("Making dreadfowl pouches", Collections.singletonList(new Requirement("Summoning", 4)), ImmutableMap.of("Spirit shards", 12000,
            "Pouch", 1500, "Raw chicken", 1500, "Gold charm", 1500), ImmutableMap.of("Dreadfowl pouch", 1500, "Summoning", 13950,
            "Summoning pet points", totalPetPoints(player, "Summoning", 13950)), 1500, true, true));
        database.add(new Action("Making dreadfowl pouches (selling noted items)", Collections.singletonList(new Requirement("Summoning", 4)), ImmutableMap.of("Spirit shards", 80000,
            "Pouch", 10000, "Raw chicken", 10000, "Gold charm", 10000, "Coins", 420000), ImmutableMap.of("Dreadfowl strike scroll", 100000, "Summoning", 103000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 103000)), 400, true, true));
        database.add(new Action("Making spirit spider pouches", Collections.singletonList(new Requirement("Summoning", 10)), ImmutableMap.of("Spirit shards", 12000,
            "Pouch", 1500, "Spider carcass", 1500, "Gold charm", 1500), ImmutableMap.of("Spirit spider pouch", 1500, "Summoning", 18900,
            "Summoning pet points", totalPetPoints(player, "Summoning", 18900)), 1500, true, true));
        database.add(new Action("Making spirit spider pouches (selling noted items", Collections.singletonList(new Requirement("Summoning", 10)), ImmutableMap.of("Spirit shards", 80000,
            "Pouch", 10000, "Spider carcass", 10000, "Gold charm", 10000, "Coins", 110000), ImmutableMap.of("Egg spawn scroll", 100000, "Summoning", 146000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 146000)), 400, true, true));
        database.add(new Action("Making thorny snail pouches", Collections.singletonList(new Requirement("Summoning", 13)), ImmutableMap.of("Spirit shards", 13500,
            "Pouch", 1500, "Thin snail", 1500, "Gold charm", 1500), ImmutableMap.of("Thorny snail pouch", 1500, "Summoning", 18900,
            "Summoning pet points", totalPetPoints(player, "Summoning", 18900)), 1500, true, true));
        database.add(new Action("Making thorny snail pouches (selling noted items)", Collections.singletonList(new Requirement("Summoning", 13)), ImmutableMap.of("Spirit shards", 90000,
            "Pouch", 10000, "Thin snail", 10000, "Gold charm", 10000, "Coins", 420000), ImmutableMap.of("Slime spray scroll", 100000, "Summoning", 146000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 146000)), 400, true, true));
        database.add(new Action("Making granite crab pouches", Collections.singletonList(new Requirement("Summoning", 16)), ImmutableMap.of("Spirit shards", 10500,
            "Pouch", 1500, "Iron ore", 1500, "Gold charm", 1500), ImmutableMap.of("Granite crab pouch", 1500, "Summoning", 32400,
            "Summoning pet points", totalPetPoints(player, "Summoning", 32400)), 1500, true, true));
        database.add(new Action("Making granite crab pouches (selling noted items)", Collections.singletonList(new Requirement("Summoning", 16)), ImmutableMap.of("Spirit shards", 70000,
            "Pouch", 10000, "Iron ore", 10000, "Gold charm", 10000, "Coins", 180000), ImmutableMap.of("Stony shell scroll", 100000, "Summoning", 236000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 236000)), 400, true, true));
        database.add(new Action("Making spirit mosquito pouches", Collections.singletonList(new Requirement("Summoning", 17)), ImmutableMap.of("Spirit shards", 1500,
            "Pouch", 1500, "Proboscis", 1500, "Gold charm", 1500), ImmutableMap.of("Spirit mosquito pouch", 1500, "Summoning", 69750,
            "Summoning pet points", totalPetPoints(player, "Summoning", 69750)), 1500, true, true));
        database.add(new Action("Making spirit mosquito pouches (pouches to scrolls)", Collections.singletonList(new Requirement("Summoning", 17)), ImmutableMap.of("Spirit shards", 10000,
            "Pouch", 10000, "Proboscis", 10000, "Gold charm", 10000), ImmutableMap.of("Pester scroll", 100000, "Summoning", 515000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 515000)), 400, true, true));
        database.add(new Action("Making desert wyrm pouches", Collections.singletonList(new Requirement("Summoning", 18)), ImmutableMap.of("Spirit shards", 67500,
            "Pouch", 1500, "Bucket of sand", 1500, "Green charm", 1500), ImmutableMap.of("Desert wyrm pouch", 1500, "Summoning", 46800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 46800)), 1500, true, true));
        database.add(new Action("Making desert wyrm pouches (selling noted items)", Collections.singletonList(new Requirement("Summoning", 18)), ImmutableMap.of("Spirit shards", 450000,
            "Pouch", 10000, "Bucket of sand", 10000, "Green charm", 10000, "Coins", 10000), ImmutableMap.of("Electric lash scroll", 100000, "Summoning", 352000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 352000)), 400, true, true));
        database.add(new Action("Making spirit scorpion pouches", Collections.singletonList(new Requirement("Summoning", 19)), ImmutableMap.of("Spirit shards", 85500,
            "Pouch", 1500, "Bronze claws", 1500, "Crimson charm", 1500), ImmutableMap.of("Spirit scorpion pouch", 1500, "Summoning", 124800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 124800)), 1500, true, true));
        database.add(new Action("Making spirit scorpion pouches (selling noted items)", Collections.singletonList(new Requirement("Summoning", 19)), ImmutableMap.of("Spirit shards", 570000,
            "Pouch", 10000, "Bronze claws", 10000, "Crimson charm", 10000, "Coins", 1180000), ImmutableMap.of("Venom shot scroll", 100000, "Summoning", 922000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 922000)), 400, true, true));
        database.add(new Action("Making spirit tz-kih pouches", Collections.singletonList(new Requirement("Summoning", 22)), ImmutableMap.of("Spirit shards", 96000,
            "Pouch", 1500, "Obsidian charm", 1500, "Crimson charm", 1500), ImmutableMap.of("Spirit tz-kih pouch", 1500, "Summoning", 145200,
            "Summoning pet points", totalPetPoints(player, "Summoning", 145200)), 1500, true, true));
        database.add(new Action("Making albino rat pouches", Collections.singletonList(new Requirement("Summoning", 23)), ImmutableMap.of("Spirit shards", 112500,
            "Pouch", 1500, "Raw rat meat", 1500, "Blue charm", 1500), ImmutableMap.of("Albino rat pouch", 1500, "Summoning", 303600,
            "Summoning pet points", totalPetPoints(player, "Summoning", 303600)), 1500, true, true));
        database.add(new Action("Making albino rat pouches (selling noted items)", Collections.singletonList(new Requirement("Summoning", 23)), ImmutableMap.of("Spirit shards", 750000,
            "Pouch", 10000, "Raw rat meat", 10000, "Blue charm", 10000, "Coins", 280000), ImmutableMap.of("Cheese feast scroll", 100000, "Summoning", 2254000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 2254000)), 400, true, true));
        database.add(new Action("Making spirit kalphite pouches", Collections.singletonList(new Requirement("Summoning", 25)), ImmutableMap.of("Spirit shards", 76500,
            "Pouch", 1500, "Potato cactus", 1500, "Blue charm", 1500), ImmutableMap.of("Spirit kalphite pouch", 1500, "Summoning", 330000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 330000)), 1500, true, true));
        database.add(new Action("Making compost mound pouches", Collections.singletonList(new Requirement("Summoning", 28)), ImmutableMap.of("Spirit shards", 70500,
            "Pouch", 1500, "Compost", 1500, "Green charm", 1500), ImmutableMap.of("Compost mound pouch", 1500, "Summoning", 74700,
            "Summoning pet points", totalPetPoints(player, "Summoning", 74700)), 1500, true, true));
        database.add(new Action("Making giant chinchompa pouches", Collections.singletonList(new Requirement("Summoning", 29)), ImmutableMap.of("Spirit shards", 126000,
            "Pouch", 1500, "Chinchompa", 1500, "Blue charm", 1500), ImmutableMap.of("Giant chinchompa pouch", 1500, "Summoning", 382800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 382800)), 1500, true, true));
        database.add(new Action("Making vampyre bat pouches", Collections.singletonList(new Requirement("Summoning", 31)), ImmutableMap.of("Spirit shards", 121500,
            "Pouch", 1500, "Vampyre dust", 1500, "Crimson charm", 1500), ImmutableMap.of("Vampyre bat pouch", 1500, "Summoning", 204000,
            "Summoning pet points", totalPetPoints(player, "Summoning", 204000)), 1500, true, true));
        database.add(new Action("Making honey badger pouches", Collections.singletonList(new Requirement("Summoning", 32)), ImmutableMap.of("Spirit shards", 126000,
            "Pouch", 1500, "Honeycomb", 1500, "Crimson charm", 1500), ImmutableMap.of("Honey badger pouch", 1500, "Summoning", 211200,
            "Summoning pet points", totalPetPoints(player, "Summoning", 211200)), 1500, true, true));
        database.add(new Action("Making beaver pouches", Collections.singletonList(new Requirement("Summoning", 33)), ImmutableMap.of("Spirit shards", 108000,
            "Pouch", 1500, "Willow logs", 1500, "Green charm", 1500), ImmutableMap.of("Beaver pouch", 1500, "Summoning", 86400,
            "Summoning pet points", totalPetPoints(player, "Summoning", 86400)), 1500, true, true));
        database.add(new Action("Making void ravager pouches", Collections.singletonList(new Requirement("Summoning", 34)), ImmutableMap.of("Spirit shards", 111000,
            "Pouch", 1500, "Thaler", 6000, "Green charm", 1500), ImmutableMap.of("Void ravager pouch", 1500, "Summoning", 89400,
            "Summoning pet points", totalPetPoints(player, "Summoning", 89400)), 1500, true, true));
        database.add(new Action("Making void shifter pouches", Collections.singletonList(new Requirement("Summoning", 34)), ImmutableMap.of("Spirit shards", 111000,
            "Pouch", 1500, "Thaler", 6000, "Blue charm", 1500), ImmutableMap.of("Void shifter pouch", 1500, "Summoning", 89400,
            "Summoning pet points", totalPetPoints(player, "Summoning", 89400)), 1500, true, true));
        database.add(new Action("Making void spinner pouches", Collections.singletonList(new Requirement("Summoning", 34)), ImmutableMap.of("Spirit shards", 111000,
            "Pouch", 1500, "Thaler", 6000, "Blue charm", 1500), ImmutableMap.of("Void spinner pouch", 1500, "Summoning", 89400,
            "Summoning pet points", totalPetPoints(player, "Summoning", 89400)), 1500, true, true));
        database.add(new Action("Making void torcher pouches", Collections.singletonList(new Requirement("Summoning", 34)), ImmutableMap.of("Spirit shards", 111000,
            "Pouch", 1500, "Thaler", 6000, "Blue charm", 1500), ImmutableMap.of("Void torcher pouch", 1500, "Summoning", 89400,
            "Summoning pet points", totalPetPoints(player, "Summoning", 89400)), 1500, true, true));
        database.add(new Action("Making bronze minotaur pouches", Collections.singletonList(new Requirement("Summoning", 36)), ImmutableMap.of("Spirit shards", 153000,
            "Pouch", 1500, "Bronze bar", 1500, "Blue charm", 1500), ImmutableMap.of("Bronze minotaur pouch", 1500, "Summoning", 475200,
            "Summoning pet points", totalPetPoints(player, "Summoning", 475200)), 1500, true, true));
        database.add(new Action("Making bull ant pouches", Collections.singletonList(new Requirement("Summoning", 40)), ImmutableMap.of("Spirit shards", 16500,
            "Pouch", 1500, "Marigolds", 1500, "Gold charm", 1500), ImmutableMap.of("Bull ant pouch", 1500, "Summoning", 79200,
            "Summoning pet points", totalPetPoints(player, "Summoning", 79200)), 1500, true, true));
        database.add(new Action("Making macaw pouches", Collections.singletonList(new Requirement("Summoning", 41)), ImmutableMap.of("Spirit shards", 117000,
            "Pouch", 1500, "Clean guam", 1500, "Green charm", 1500), ImmutableMap.of("Macaw pouch", 1500, "Summoning", 108600,
            "Summoning pet points", totalPetPoints(player, "Summoning", 108600)), 1500, true, true));
        database.add(new Action("Making evil turnip pouches", Collections.singletonList(new Requirement("Summoning", 42)), ImmutableMap.of("Spirit shards", 156000,
            "Pouch", 1500, "Carved evil turnip", 1500, "Crimson charm", 1500), ImmutableMap.of("Evil turnip pouch", 1500, "Summoning", 277200,
            "Summoning pet points", totalPetPoints(player, "Summoning", 277200)), 1500, true, true));
        database.add(new Action("Making spirit cockatrice pouches", Collections.singletonList(new Requirement("Summoning", 43)), ImmutableMap.of("Spirit shards", 132000,
            "Pouch", 1500, "Cockatrice egg", 1500, "Green charm", 1500), ImmutableMap.of("Spirit cockatrice pouch", 1500, "Summoning", 112800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 112800)), 1500, true, true));
        database.add(new Action("Making spirit guthatrice pouches", Collections.singletonList(new Requirement("Summoning", 43)), ImmutableMap.of("Spirit shards", 132000,
            "Pouch", 1500, "Guthatrice egg", 1500, "Green charm", 1500), ImmutableMap.of("Spirit guthatrice pouch", 1500, "Summoning", 112800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 112800)), 1500, true, true));
        database.add(new Action("Making spirit saratrice pouches", Collections.singletonList(new Requirement("Summoning", 43)), ImmutableMap.of("Spirit shards", 132000,
            "Pouch", 1500, "Saratrice egg", 1500, "Green charm", 1500), ImmutableMap.of("Spirit saratrice pouch", 1500, "Summoning", 112800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 112800)), 1500, true, true));
        database.add(new Action("Making spirit zamatrice pouches", Collections.singletonList(new Requirement("Summoning", 43)), ImmutableMap.of("Spirit shards", 132000,
            "Pouch", 1500, "Zamatrice egg", 1500, "Green charm", 1500), ImmutableMap.of("Spirit zamkatrice pouch", 1500, "Summoning", 112800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 112800)), 1500, true, true));
        database.add(new Action("Making spirit pengatrice pouches", Collections.singletonList(new Requirement("Summoning", 43)), ImmutableMap.of("Spirit shards", 132000,
            "Pouch", 1500, "Pengatrice egg", 1500, "Green charm", 1500), ImmutableMap.of("Spirit pengatrice pouch", 1500, "Summoning", 112800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 112800)), 1500, true, true));
        database.add(new Action("Making spirit coraxatrice pouches", Collections.singletonList(new Requirement("Summoning", 43)), ImmutableMap.of("Spirit shards", 132000,
            "Pouch", 1500, "Coraxatrice egg", 1500, "Green charm", 1500), ImmutableMap.of("Spirit coraxatrice pouch", 1500, "Summoning", 112800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 112800)), 1500, true, true));
        database.add(new Action("Making spirit vulatrice pouches", Collections.singletonList(new Requirement("Summoning", 43)), ImmutableMap.of("Spirit shards", 132000,
            "Pouch", 1500, "Vulatrice egg", 1500, "Green charm", 1500), ImmutableMap.of("Spirit vulatrice pouch", 1500, "Summoning", 112800,
            "Summoning pet points", totalPetPoints(player, "Summoning", 112800)), 1500, true, true));

        //Thieving
        double menSuccessRate = Math.min(0.9, (0.49+0.01*player.getLevel("Thieving")));
        int menPockets = (int)Math.floor((6000*menSuccessRate) / (2*menSuccessRate + 9*(1-menSuccessRate)));
        double menapiteMarketeerSuccessRate = Math.min(0.9, (0.04+0.01*Math.max(46,player.getLevel("Thieving"))));
        int menapiteMarketeerPockets = (int)Math.floor((6000*menapiteMarketeerSuccessRate) / (2*menapiteMarketeerSuccessRate + 5*(1-menapiteMarketeerSuccessRate)));

        database.add(new Action("Pickpocketing men/women", new ArrayList(), new HashMap(), ImmutableMap.of("Coins", 3 * menPockets,
            "Thieving", 8 * menPockets, "Thieving level-ticks", 6000 * player.getLevel("Thieving")), menPockets, true, true));
        database.add(new Action("Pickpocketing the Gullible tourist", Collections.singletonList(new Requirement("The Jack of Spades", 1)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 73750).put("Coins", 75000).put("Menaphos reputation", 3250).put("Hornless fly in amber", 1)
                .put("Kalphite wanderer in amber", 1).put("Waikonite", 1).build(), 3000, true, true));
        database.add(new Action("Bakery stalls", Collections.singletonList(new Requirement("Thieving", 5)), new HashMap(), ImmutableMap.of("Thieving", 10500,
            "Thieving level-ticks", 6000 * Math.max(5, player.getLevel("Thieving"))), 656, true, true));
        database.add(new Action("Pyramid Plunder (to room 1)", Arrays.asList(new Requirement("Icthlarin's Little Helper", 1), new Requirement("Thieving", 21)),
            new HashMap(), ImmutableMap.of("Thieving", 17000, "Jenifurr", 1, "Thieving level-ticks", 6000 * Math.max(21, player.getLevel("Thieving")), "Menaphyrite", 1), 12, true, true));
        database.add(new Action("Menaphos silk stall (drop silk)", Arrays.asList(new Requirement("The Jack of Spades", 1), new Requirement("Thieving", 20)),
            new HashMap(), ImmutableMap.of("Thieving", 9600, "Menaphos reputation", 2400, "Fly dragon in amber", 1, "Thieving level-ticks", 6000 * Math.max(20, player.getLevel("Thieving"))), 400, true, true));
        database.add(new Action("Pickpocketing Menaphite marketeers", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Thieving", 46)), new HashMap(), ImmutableMap.builder().put("Thieving", (int) (29.5 * menapiteMarketeerPockets)).put("Menaphos reputation",
            (int) (1.3 * menapiteMarketeerPockets)).put("Coins", 30 * menapiteMarketeerPockets).put("Kalphite wanderer in amber", 1).put("Hornless unicornfly in amber", 1)
            .put("Thieving level-ticks", 6000 * Math.max(46, player.getLevel("Thieving"))).build(), menapiteMarketeerPockets, true, true));
        database.add(new Action("Safecracking (Misthalin)", Arrays.asList(new Requirement("A Guild of Our Own", 1), new Requirement("Thieving", 62)), new HashMap(),
            ImmutableMap.of("Thieving", 300000, "Pilfer Points", 800, "Coins", 200000, "Thieving level-ticks", 6000 * Math.max(62, player.getLevel("Thieving"))), 60, true, true));
        database.add(new Action("Iorwerth workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 91)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 250000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3)
                .put("Prifddinian musician's robe pieces", 1).put("Iorwerth symbol piece", 1).put("Thieving level-ticks", 6000 * Math.max(91, player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Ithell workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 92)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 260000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3)
                .put("Prifddinian musician's robe pieces", 1).put("Ithell symbol piece", 1).put("Thieving level-ticks", 6000 * Math.max(92, player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Cadarn workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 93)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 270000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3)
                .put("Prifddinian musician's robe pieces", 1).put("Cadarn symbol piece", 1).put("Thieving level-ticks", 6000 * Math.max(93, player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Amlodd workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 94)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 280000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3)
                .put("Prifddinian musician's robe pieces", 1).put("Amlodd symbol piece", 1).put("Thieving level-ticks", 6000 * Math.max(94, player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Trahearn workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 95)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 290000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3)
                .put("Prifddinian musician's robe pieces", 1).put("Trahearn symbol piece", 1).put("Thieving level-ticks", 6000 * Math.max(95, player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Hefin workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 96)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 300000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3)
                .put("Prifddinian musician's robe pieces", 1).put("Hefin symbol piece", 1).put("Thieving level-ticks", 6000 * Math.max(96, player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Crwys workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 97)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 310000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3)
                .put("Prifddinian musician's robe pieces", 1).put("Crwys symbol piece", 1).put("Thieving level-ticks", 6000 * Math.max(97, player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));
        database.add(new Action("Meilyr workers", Arrays.asList(new Requirement("Plague's End", 1), new Requirement("Thieving", 98)), new HashMap(),
            ImmutableMap.builder().put("Thieving", 320000).put("Sealed clue scroll (hard)", 6).put("Sealed clue scroll (elite)", 3)
                .put("Prifddinian musician's robe pieces", 1).put("Meilyr symbol piece", 1).put("Thieving level-ticks", 6000 * Math.max(98, player.getLevel("Thieving")))
                .put("Crystal acorn points", 1).build(), 2000, true, true));

        //Woodcutting (done to lv15)
        database.add(new Action("Cutting regular trees with dwarven army axe", new ArrayList(), new HashMap(), ImmutableMap.of("Woodcutting", 14500,
            "Woodcutting level-ticks", 6000 * player.getLevel("Woodcutting")), 580, true, true));

        database.add(new Action("Cutting/dropping acadia logs with rune hatchet in VIP skilling area", Arrays.asList(new Requirement("The Jack of Spades", 1),
            new Requirement("Menaphos reputation", 141900), new Requirement("Woodcutting", 47)), new HashMap(), ImmutableMap.builder().put("Woodcutting", 92 * itemsReceived(player, 600, 1.01, "Woodcutting", 47))
            .put("Menaphos reputation", (int) 4.5 * itemsReceived(player, 600, 1.01, "Woodcutting", 47)).put("Desert locust", 1).put("Hornless unicornfly", 1).put("Kalphite wanderer", 1)
            .put("Woodcutting level-ticks", 6000 * Math.max(47, player.getLevel("Woodcutting"))).build(), itemsReceived(player, 600, 1.01, "Woodcutting", 47), true, true));

        database.add(new Action("Cutting bamboo", Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Woodcutting", 90)),
            new HashMap(), ImmutableMap.of("Bamboo", 3 * player.getLevel("Woodcutting") + 60, "Woodcutting", (int) 202.5 * (3 * player.getLevel("Woodcutting") + 60), "Great Pecker", 1,
            "Woodcutting level-ticks", 6000 * Math.max(90, player.getLevel("Woodcutting"))), 3 * player.getLevel("Woodcutting") + 60, true, true));

        database.add(new Action("Cutting crystal trees with dragon hatchet", Collections.singletonList(new Requirement("Woodcutting", 94)), new HashMap(),
            ImmutableMap.of("Woodcutting", (int) 434.5 * itemsReceived(player, 180, 1.037, "Woodcutting", 94), "Crystal geode", 10, "Woodcutting level-ticks", 6000 * Math.max(94, player.getLevel("Woodcutting"))),
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

        database.add(new Action("Completing city quests", Collections.singletonList(new Requirement("The Jack of Spades", 1)), new HashMap(),
            ImmutableMap.of("City quest", 4, "Menaphos reputation", 9400), 4, true, true));

        database.add(new Action("Completing easy clue scrolls", new ArrayList(), ImmutableMap.of("Sealed clue scroll (easy)", 6), ImmutableMap.of("Clue scrolls", 6,
            "Treasure Trail reward points", 6), 6, true, true));
    }


    private void addCombatActionsToDatabase(Player player) {
        Map<Integer, List<Requirement>> chickenKillsAndReqs = combatKills(new Encounter("Chicken"), player, 0, "Magic", 1, true);
        int chickenKills = chickenKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> chickenReqs = new ArrayList<>(chickenKillsAndReqs.values().iterator().next());
        database.add(new Action("Killing chickens for money", chickenReqs, new HashMap(), ImmutableMap.builder()
            .put("aCombat", (int) Enemy.getEnemyByName("Chicken").getCbxp() * chickenKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Chicken").getHpxp() * chickenKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Chicken").getHpxp() * chickenKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Chicken").getCbxp() * chickenKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Chicken").getCbxp() * chickenKills) / 2))
            .put("Raw chicken", chickenKills).put("Egg", chickenKills).put("Feather", chickenKills * 4).build(), chickenKills, true, true));

        Map<Integer, List<Requirement>> trollBruteKills = combatKills(new Encounter("Troll brute"), player, 28, "Magic", 0, false);
        database.add(new Action("Killing troll brutes", trollBruteKills.values().iterator().next(), new HashMap(), ImmutableMap.of("aCombat", (int) Enemy.getEnemyByName("Troll brute").getCbxp()
                * trollBruteKills.keySet().iterator().next(), "Constitution", (int) Enemy.getEnemyByName("Troll brute").getHpxp() * trollBruteKills.keySet().iterator().next(),
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Troll brute").getHpxp() * trollBruteKills.keySet().iterator().next()),
            "Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Troll brute").getCbxp() * trollBruteKills.keySet().iterator().next()) / 2),
            "Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Troll brute").getCbxp() * trollBruteKills.keySet().iterator().next()) / 2)),
            trollBruteKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> trollChuckerKillsAndReqs = combatKills(new Encounter("Troll chucker"), player, 28, "Melee", 0, false);
        int trollChuckerKills = trollChuckerKillsAndReqs.keySet().iterator().next();
        List<Requirement> trollChuckerReqs = trollChuckerKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing troll chuckers", trollChuckerReqs, new HashMap(), ImmutableMap.builder().put("mCombat", (int) Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills)
            .put("Constitution", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getHpxp() * trollChuckerKills))
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getHpxp() * trollChuckerKills)))
            .put("Attack pet points", totalPetPoints(player, "Attack", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills) / 3))
            .put("Strength pet points", totalPetPoints(player, "Strength", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills) / 3))
            .put("Defence pet points", totalPetPoints(player, "Defence", (int) Math.floor(Enemy.getEnemyByName("Troll chucker").getCbxp() * trollChuckerKills) / 3)).build(), trollChuckerKills, true, true));

        Map<Integer, List<Requirement>> trollShamanKillsAndReqs = combatKills(new Encounter("Troll shaman"), player, 28, "Ranged", 0, false);
        int trollShamanKills = trollShamanKillsAndReqs.keySet().iterator().next();
        List<Requirement> trollShamanReqs = trollShamanKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing troll shamans", trollShamanReqs, new HashMap(), ImmutableMap.of("rCombat", (int) Enemy.getEnemyByName("Troll shaman").getCbxp() * trollShamanKills,
            "Ranged pet points", totalPetPoints(player, "Ranged", (int) Enemy.getEnemyByName("Troll shaman").getCbxp() * trollShamanKills) / 2,
            "Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Troll shaman").getCbxp() * trollShamanKills) / 2,
            "Constitution", (int) Enemy.getEnemyByName("Troll shaman").getHpxp() * trollShamanKills,
            "Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Troll shaman").getHpxp() * trollShamanKills)), trollShamanKills, true, true));


        Map<Integer, List<Requirement>> gelatinousAbominationKills = combatKills(new Encounter("Gelatinous abomination"), player, 27, "Ranged", 0.4, true);
        database.add(new Action("Killing gelatinous abominations for gold charms", gelatinousAbominationKills.values().iterator().next(), new HashMap(), ImmutableMap.builder()
            .put("Gold charm", (int) (gelatinousAbominationKills.keySet().iterator().next() * 0.4)).put("rCombat", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() *
                gelatinousAbominationKills.keySet().iterator().next()).put("Constitution", (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() *
                gelatinousAbominationKills.keySet().iterator().next()).put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Gelatinous abomination").getHpxp() *
                gelatinousAbominationKills.keySet().iterator().next())).put("Ranged pet points", totalPetPoints(player, "Ranged", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() *
                gelatinousAbominationKills.keySet().iterator().next() / 2)).put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Gelatinous abomination").getCbxp() *
                gelatinousAbominationKills.keySet().iterator().next() / 2)).put("Spirit sapphire", gelatinousAbominationKills.keySet().iterator().next() / 400).build(),
            gelatinousAbominationKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> caveBugKillsAndReqs = combatKills(new Encounter("Cave bug"), player, 27, "Melee", 0.36, true);
        int caveBugKills = caveBugKillsAndReqs.keySet().iterator().next();
        List<Requirement> caveBugReqs = caveBugKillsAndReqs.values().iterator().next();
        caveBugReqs.add(new Requirement("Slayer", 7));
        database.add(new Action("Killing cave bugs for green charms", caveBugReqs, new HashMap(), ImmutableMap.builder().put("Green charm", (int) (caveBugKills * 0.36))
            .put("mCombat", (int) Enemy.getEnemyByName("Cave bug").getCbxp() * caveBugKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Cave bug").getHpxp() * caveBugKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Cave bug").getHpxp() * caveBugKills))
            .put("Attack pet points", totalPetPoints(player, "Attack", ((int) Enemy.getEnemyByName("Cave bug").getCbxp() * caveBugKills)) / 3)
            .put("Strength pet points", totalPetPoints(player, "Strength", ((int) Enemy.getEnemyByName("Cave bug").getCbxp() * caveBugKills)) / 3)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Cave bug").getCbxp() * caveBugKills)) / 3).build(), caveBugKills, true, true));

        Map<Integer, List<Requirement>> cockroachWorkerKillsAndReqs = combatKills(new Encounter("Cockroach worker"), player, 27, "Magic", 0.17, true);
        int cockroachWorkerKills = cockroachWorkerKillsAndReqs.keySet().iterator().next();
        List<Requirement> cockroachWorkerReqs = cockroachWorkerKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing cockroach workers for crimson charms", cockroachWorkerReqs, new HashMap(), ImmutableMap.builder().put("Crimson charm", (int) (cockroachWorkerKills * 0.17))
            .put("aCombat", (int) Enemy.getEnemyByName("Cockroach worker").getCbxp() * cockroachWorkerKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Cockroach worker").getHpxp() * cockroachWorkerKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Cockroach worker").getHpxp() * cockroachWorkerKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Cockroach worker").getCbxp() * cockroachWorkerKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Cockroach worker").getCbxp() * cockroachWorkerKills)) / 2).build(), cockroachWorkerKills, true, true));

        Map<Integer, List<Requirement>> cockroachSoldierKillsAndReqs = combatKills(new Encounter("Cockroach soldier"), player, 27, "Magic", 0.26, true);
        int cockroachSoldierKills = cockroachSoldierKillsAndReqs.keySet().iterator().next();
        List<Requirement> cockroachSoldierReqs = cockroachSoldierKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing cockroach soldiers for crimson charms", cockroachSoldierReqs, new HashMap(), ImmutableMap.builder().put("Crimson charm", (int) (cockroachSoldierKills * 0.26))
            .put("aCombat", (int) Enemy.getEnemyByName("Cockroach soldier").getCbxp() * cockroachSoldierKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Cockroach soldier").getHpxp() * cockroachSoldierKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Cockroach soldier").getHpxp() * cockroachSoldierKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Cockroach soldier").getCbxp() * cockroachSoldierKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Cockroach soldier").getCbxp() * cockroachSoldierKills)) / 2).build(), cockroachSoldierKills, true, true));

        Map<Integer, List<Requirement>> iceWarriorKillsAndReqs = combatKills(new Encounter("Ice warrior"), player, 27, "Magic", 0.42, true);
        int iceWarriorKills = iceWarriorKillsAndReqs.keySet().iterator().next();
        List<Requirement> iceWarriorReqs = iceWarriorKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing ice warriors for gold charms", iceWarriorReqs, new HashMap(), ImmutableMap.builder().put("Gold charm", (int) (iceWarriorKills * 0.42))
            .put("aCombat", (int) Enemy.getEnemyByName("Ice warrior").getCbxp() * iceWarriorKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Ice warrior").getHpxp() * iceWarriorKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Ice warrior").getHpxp() * iceWarriorKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Ice warrior").getCbxp() * iceWarriorKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Ice warrior").getCbxp() * iceWarriorKills)) / 2).build(), iceWarriorKills, true, true));

        Map<Integer, List<Requirement>> werewolfKillsAndReqs = combatKills(new Encounter("Werewolf"), player, 27, "Magic", 0.44, true);
        int werewolfKills = werewolfKillsAndReqs.keySet().iterator().next();
        List<Requirement> werewolfReqs = werewolfKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing werewolves for gold charms", werewolfReqs, new HashMap(), ImmutableMap.builder().put("Gold charm", (int) (werewolfKills * 0.44))
            .put("aCombat", (int) Enemy.getEnemyByName("Werewolf").getCbxp() * werewolfKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Werewolf").getHpxp() * werewolfKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Werewolf").getHpxp() * werewolfKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Werewolf").getCbxp() * werewolfKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Werewolf").getCbxp() * werewolfKills)) / 2).build(), werewolfKills, true, true));

        Map<Integer, List<Requirement>> ogressChampionKillsAndReqs = combatKills(new Encounter("Ogress champion"), player, 27, "Magic", 0.79, true);
        int ogressChampionKills = ogressChampionKillsAndReqs.keySet().iterator().next();
        List<Requirement> ogressChampionReqs = ogressChampionKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing ogress champions for gold charms", ogressChampionReqs, new HashMap(), ImmutableMap.builder().put("Gold charm", (int) (ogressChampionKills * 0.79))
            .put("aCombat", (int) Enemy.getEnemyByName("Ogress champion").getCbxp() * ogressChampionKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Ogress champion").getHpxp() * ogressChampionKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Ogress champion").getHpxp() * ogressChampionKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Ogress champion").getCbxp() * ogressChampionKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Ogress champion").getCbxp() * ogressChampionKills)) / 2).build(), ogressChampionKills, true, true));

        Map<Integer, List<Requirement>> giantRockCrabKillsAndReqs = combatKills(new Encounter("Giant rock crab"), player, 27, "Magic", 0.79, true);
        int giantRockCrabKills = giantRockCrabKillsAndReqs.keySet().iterator().next();
        List<Requirement> giantRockCrabReqs = giantRockCrabKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing giant rock crabs for gold charms", giantRockCrabReqs, new HashMap(), ImmutableMap.builder().put("Gold charm", (int) (giantRockCrabKills * 2.37))
            .put("aCombat", (int) Enemy.getEnemyByName("Giant rock crab").getCbxp() * giantRockCrabKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Giant rock crab").getHpxp() * giantRockCrabKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Giant rock crab").getHpxp() * giantRockCrabKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Giant rock crab").getCbxp() * giantRockCrabKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Giant rock crab").getCbxp() * giantRockCrabKills)) / 2).build(), giantRockCrabKills, true, true));

        Map<Integer, List<Requirement>> rockLobsterKillsAndReqs = combatKills(new Encounter("Rock lobster"), player, 27, "Magic", 0.23, true);
        int rockLobsterKills = rockLobsterKillsAndReqs.keySet().iterator().next();
        List<Requirement> rockLobsterReqs = rockLobsterKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing rock lobsters for crimson charms", rockLobsterReqs, new HashMap(), ImmutableMap.builder().put("Crimson charm", (int) (rockLobsterKills * 0.46))
            .put("aCombat", (int) Enemy.getEnemyByName("Rock lobster").getCbxp() * rockLobsterKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Rock lobster").getHpxp() * rockLobsterKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Rock lobster").getHpxp() * rockLobsterKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Rock lobster").getCbxp() * rockLobsterKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Rock lobster").getCbxp() * rockLobsterKills)) / 2).build(), rockLobsterKills, true, true));

        Map<Integer, List<Requirement>> exiledKalphiteMarauderKillsAndReqs = combatKills(new Encounter("Exiled kalphite marauder"), player, 27, "Ranged", 0.26, true);
        int exiledKalphiteMarauderKills = exiledKalphiteMarauderKillsAndReqs.keySet().iterator().next();
        List<Requirement> exiledKalphiteMarauderReqs = exiledKalphiteMarauderKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing exiled kalphite marauders for blue charms", exiledKalphiteMarauderReqs, new HashMap(),
            ImmutableMap.builder().put("Blue charm", (int) (exiledKalphiteMarauderKills * 0.26))
                .put("rCombat", (int) Enemy.getEnemyByName("Exiled kalphite marauder").getCbxp() * exiledKalphiteMarauderKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Exiled kalphite marauder").getHpxp() * exiledKalphiteMarauderKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Exiled kalphite marauder").getHpxp() * exiledKalphiteMarauderKills))
                .put("Ranged pet points", totalPetPoints(player, "Ranged", ((int) Enemy.getEnemyByName("Exiled kalphite marauder").getCbxp() * exiledKalphiteMarauderKills)) / 2)
                .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Exiled kalphite marauder").getCbxp() * exiledKalphiteMarauderKills)) / 2).build(),
            exiledKalphiteMarauderKills, true, true));

        Map<Integer, List<Requirement>> blackDragonKillsAndReqs = combatKills(new Encounter("Black dragon"), player, 27, "Ranged", 0.26, true);
        int blackDragonKills = blackDragonKillsAndReqs.keySet().iterator().next();
        List<Requirement> blackDragonReqs = blackDragonKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing black dragons for green charms", blackDragonReqs, new HashMap(), ImmutableMap.builder().put("Green charm", (int) (blackDragonKills * 0.78))
            .put("rCombat", (int) Enemy.getEnemyByName("Black dragon").getCbxp() * blackDragonKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Black dragon").getHpxp() * blackDragonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Black dragon").getHpxp() * blackDragonKills))
            .put("Ranged pet points", totalPetPoints(player, "Ranged", ((int) Enemy.getEnemyByName("Black dragon").getCbxp() * blackDragonKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Black dragon").getCbxp() * blackDragonKills)) / 2).build(), blackDragonKills, true, true));

        Map<Integer, List<Requirement>> waterfiendKillsAndReqs = combatKills(new Encounter("Waterfiend"), player, 27, "Ranged", 0.78, true);
        int waterfiendKills = waterfiendKillsAndReqs.keySet().iterator().next();
        List<Requirement> waterfiendReqs = waterfiendKillsAndReqs.values().iterator().next();
        waterfiendReqs.add(new Requirement("Barbarian Firemaking", 1));
        database.add(new Action("Killing waterfiends for crimson charms", waterfiendReqs, new HashMap(), ImmutableMap.builder().put("Crimson charm", (int) (waterfiendKills * 0.78))
            .put("rCombat", (int) Enemy.getEnemyByName("Waterfiend").getCbxp() * waterfiendKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Waterfiend").getHpxp() * waterfiendKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Waterfiend").getHpxp() * waterfiendKills))
            .put("Ranged pet points", totalPetPoints(player, "Ranged", ((int) Enemy.getEnemyByName("Waterfiend").getCbxp() * waterfiendKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Waterfiend").getCbxp() * waterfiendKills)) / 2).build(), waterfiendKills, true, true));

        Map<Integer, List<Requirement>> steelDragonKillsAndReqs = combatKills(new Encounter("Steel dragon"), player, 27, "Magic", 0.35, true);
        int steelDragonKills = steelDragonKillsAndReqs.keySet().iterator().next();
        List<Requirement> steelDragonReqs = steelDragonKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing steel dragons for green charms", steelDragonReqs, new HashMap(), ImmutableMap.builder().put("Green charm", (int) (steelDragonKills * 1.05))
            .put("aCombat", (int) Enemy.getEnemyByName("Steel dragon").getCbxp() * steelDragonKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Steel dragon").getHpxp() * steelDragonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Steel dragon").getHpxp() * steelDragonKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Steel dragon").getCbxp() * steelDragonKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Steel dragon").getCbxp() * steelDragonKills)) / 2).build(), steelDragonKills, true, true));

        Map<Integer, List<Requirement>> skeletalWyvernKillsAndReqs = combatKills(new Encounter("Skeletal wyvern"), player, 27, "Magic", 0.54, true);
        int skeletalWyvernKills = skeletalWyvernKillsAndReqs.keySet().iterator().next();
        List<Requirement> skeletalWyvernReqs = skeletalWyvernKillsAndReqs.values().iterator().next();
        skeletalWyvernReqs.add(new Requirement("Slayer", 72));
        database.add(new Action("Killing skeletal wyverns for crimson charms", skeletalWyvernReqs, new HashMap(), ImmutableMap.builder().put("Crimson charm", (int) (skeletalWyvernKills * 1.08))
            .put("aCombat", (int) Enemy.getEnemyByName("Skeletal wyvern").getCbxp() * skeletalWyvernKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Skeletal wyvern").getHpxp() * skeletalWyvernKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Skeletal wyvern").getHpxp() * skeletalWyvernKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Skeletal wyvern").getCbxp() * skeletalWyvernKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Skeletal wyvern").getCbxp() * skeletalWyvernKills)) / 2).build(), skeletalWyvernKills, true, true));

        Map<Integer, List<Requirement>> mithrilDragonKillsAndReqs = combatKills(new Encounter("Mithril dragon"), player, 27, "Magic", 0.48, true);
        int mithrilDragonKills = mithrilDragonKillsAndReqs.keySet().iterator().next();
        List<Requirement> mithrilDragonReqs = mithrilDragonKillsAndReqs.values().iterator().next();
        mithrilDragonReqs.add(new Requirement("Barbarian Firemaking", 1));
        database.add(new Action("Killing mithril dragons for green charms", mithrilDragonReqs, new HashMap(), ImmutableMap.builder().put("Green charm", (int) (mithrilDragonKills * 1.96))
            .put("aCombat", (int) Enemy.getEnemyByName("Mithril dragon").getCbxp() * mithrilDragonKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Mithril dragon").getHpxp() * mithrilDragonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Mithril dragon").getHpxp() * mithrilDragonKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Mithril dragon").getCbxp() * mithrilDragonKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Mithril dragon").getCbxp() * mithrilDragonKills)) / 2).build(), mithrilDragonKills, true, true));

        Map<Integer, List<Requirement>> tormentedDemonKillsAndReqs = combatKills(new Encounter("Tormented demon"), player, 27, "Magic", 0.36, true);
        int tormentedDemonKills = tormentedDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> tormentedDemonReqs = tormentedDemonKillsAndReqs.values().iterator().next();
        tormentedDemonReqs.add(new Requirement("While Guthix Sleeps", 1));
        database.add(new Action("Killing tormented demons for blue charms", tormentedDemonReqs, new HashMap(),
            ImmutableMap.builder().put("Blue charm", (int) (tormentedDemonKills * 1.08))
                .put("aCombat", (int) Enemy.getEnemyByName("Tormented demon").getCbxp() * tormentedDemonKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Tormented demon").getHpxp() * tormentedDemonKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Tormented demon").getHpxp() * tormentedDemonKills))
                .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Tormented demon").getCbxp() * tormentedDemonKills)) / 2)
                .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Tormented demon").getCbxp() * tormentedDemonKills)) / 2).build(),
            tormentedDemonKills, true, true));

        Map<Integer, List<Requirement>> celestialDragonKillsAndReqs = combatKills(new Encounter("Celestial dragon"), player, 27, "Ranged", 0.74, true);
        int celestialDragonKills = celestialDragonKillsAndReqs.keySet().iterator().next();
        List<Requirement> celestialDragonReqs = celestialDragonKillsAndReqs.values().iterator().next();
        celestialDragonReqs.add(new Requirement("One of a Kind", 1));
        database.add(new Action("Killing celestial dragons for crimson charms", celestialDragonReqs, new HashMap(), ImmutableMap.builder().put("Crimson charm", (int) (celestialDragonKills * 1.48))
            .put("rCombat", (int) Enemy.getEnemyByName("Celestial dragon").getCbxp() * celestialDragonKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Celestial dragon").getHpxp() * celestialDragonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Celestial dragon").getHpxp() * celestialDragonKills))
            .put("Ranged pet points", totalPetPoints(player, "Ranged", ((int) Enemy.getEnemyByName("Celestial dragon").getCbxp() * celestialDragonKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Celestial dragon").getCbxp() * celestialDragonKills)) / 2).build(), celestialDragonKills, true, true));

        Map<Integer, List<Requirement>> tzhaarKetKillsAndReqs = combatKills(new Encounter("TzHaar-Ket"), player, 27, "Magic", 0.2, true);
        int tzhaarKetKills = tzhaarKetKillsAndReqs.keySet().iterator().next();
        List<Requirement> tzhaarKetReqs = tzhaarKetKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing TzHaar-Kets for obsidian charms", tzhaarKetReqs, new HashMap(), ImmutableMap.builder().put("Obsidian charm", (int) (tzhaarKetKills * 0.4))
            .put("aCombat", (int) Enemy.getEnemyByName("TzHaar-Ket").getCbxp() * tzhaarKetKills)
            .put("Constitution", (int) Enemy.getEnemyByName("TzHaar-Ket").getHpxp() * tzhaarKetKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("TzHaar-Ket").getHpxp() * tzhaarKetKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("TzHaar-Ket").getCbxp() * tzhaarKetKills)) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("TzHaar-Ket").getCbxp() * tzhaarKetKills)) / 2).build(), tzhaarKetKills, true, true));

        for (SlayerMonster slayerMonster : SlayerMonsterDatabase.getSlayerMonsterDatabase().getSlayerMonsters()) {
            Enemy enemy = Enemy.getEnemyByName(slayerMonster.getMonster());
            if (enemy.getAffmage() > enemy.getAffmelee() && enemy.getAffmage() > enemy.getAffranged()) {
                Map<Integer, List<Requirement>> monsterKillsAndReqs = combatKills(new Encounter(slayerMonster.getMonster()), player, 28, "Magic", 0, true);
                int monsterKills = monsterKillsAndReqs.keySet().iterator().next();
                ArrayList<Requirement> monsterReqs = new ArrayList<>(monsterKillsAndReqs.values().iterator().next());
                monsterReqs.addAll(slayerMonster.getReqs());
                database.add(new Action(String.format("Killing %s", slayerMonster.getMonster()), monsterReqs, new HashMap(), ImmutableMap.builder()
                    .put("aCombat", (int) enemy.getCbxp() * monsterKills)
                    .put("Constitution", (int) enemy.getHpxp() * monsterKills)
                    .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) enemy.getHpxp() * monsterKills))
                    .put("Magic pet points", totalPetPoints(player, "Magic", ((int) enemy.getCbxp() * monsterKills) / 2))
                    .put("Defence pet points", totalPetPoints(player, "Defence", ((int) enemy.getCbxp() * monsterKills) / 2))
                    .put(String.format("%s", slayerMonster.getCategory()), monsterKills)
                    .put(String.format("%s", slayerMonster.getMonster()), monsterKills).build(), monsterKills, true, true));
            } else if (enemy.getAffranged() > enemy.getAffmelee()) {
                Map<Integer, List<Requirement>> monsterKillsAndReqs = combatKills(new Encounter(slayerMonster.getMonster()), player, 28, "Ranged", 0, true);
                int monsterKills = monsterKillsAndReqs.keySet().iterator().next();
                ArrayList<Requirement> monsterReqs = new ArrayList<>(monsterKillsAndReqs.values().iterator().next());
                monsterReqs.addAll(slayerMonster.getReqs());
                database.add(new Action(String.format("Killing %s", slayerMonster.getMonster()), monsterReqs, new HashMap(), ImmutableMap.builder()
                    .put("rCombat", (int) enemy.getCbxp() * monsterKills)
                    .put("Constitution", (int) enemy.getHpxp() * monsterKills)
                    .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) enemy.getHpxp() * monsterKills))
                    .put("Ranged pet points", totalPetPoints(player, "Ranged", ((int) enemy.getCbxp() * monsterKills) / 2))
                    .put("Defence pet points", totalPetPoints(player, "Defence", ((int) enemy.getCbxp() * monsterKills) / 2))
                    .put(String.format("%s", slayerMonster.getCategory()), monsterKills)
                    .put(String.format("%s", slayerMonster.getMonster()), monsterKills).build(), monsterKills, true, true));
            } else {
                Map<Integer, List<Requirement>> monsterKillsAndReqs = combatKills(new Encounter(slayerMonster.getMonster()), player, 28, "Melee", 0, true);
                int monsterKills = monsterKillsAndReqs.keySet().iterator().next();
                ArrayList<Requirement> monsterReqs = new ArrayList<>(monsterKillsAndReqs.values().iterator().next());
                monsterReqs.addAll(slayerMonster.getReqs());
                database.add(new Action(String.format("Killing %s", slayerMonster.getMonster()), monsterReqs, new HashMap(), ImmutableMap.builder()
                    .put("mCombat", (int) enemy.getCbxp() * monsterKills)
                    .put("Constitution", (int) enemy.getHpxp() * monsterKills)
                    .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) enemy.getHpxp() * monsterKills))
                    .put("Attack pet points", totalPetPoints(player, "Attack", ((int) enemy.getCbxp() * monsterKills) / 3))
                    .put("Strength pet points", totalPetPoints(player, "Strength", ((int) enemy.getCbxp() * monsterKills) / 3))
                    .put("Defence pet points", totalPetPoints(player, "Defence", ((int) enemy.getCbxp() * monsterKills) / 3))
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
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Pig").getCbxp() * pigKills.keySet().iterator().next()) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Pig").getCbxp() * pigKills.keySet().iterator().next()) / 2)).build(),
            pigKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> vyreKillsAndReqs = combatKills(new Encounter("Vyrewatch"), player, 0, "Melee", 1, false);
        int vyreKills = vyreKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> vyreReqs = new ArrayList<>(vyreKillsAndReqs.values().iterator().next());
        vyreReqs.add(new Requirement("Legacy of Seergaze", 1));
        database.add(new Action("Killing vyres for corpses", vyreReqs, new HashMap(),
            ImmutableMap.builder().put("Vyre corpse", vyreKills).put("mCombat", (int) Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Vyrewatch").getHpxp() * vyreKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Vyrewatch").getHpxp() * vyreKills))
                .put("Attack pet points", totalPetPoints(player, "Attack", (int) Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills) / 3)
                .put("Strength pet points", totalPetPoints(player, "Strength", (int) Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills) / 3)
                .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Vyrewatch").getCbxp() * vyreKills) / 3)
                .put("Vyrewatch kills", vyreKills).build(), vyreKills, true, true));

        Map<Integer, List<Requirement>> truthfulShadowKillsAndReqs = combatKills(new Encounter("Truthful shadow"), player, 0, "Magic", 0.2, false);
        int truthfulShadowKills = truthfulShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> truthfulShadowReqs = new ArrayList<>(truthfulShadowKillsAndReqs.values().iterator().next());
        truthfulShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing truthful shadows for cores", truthfulShadowReqs, new HashMap(),
            ImmutableMap.builder().put("Truthful shadow core", truthfulShadowKills / 5).put("aCombat", (int) Enemy.getEnemyByName("Truthful shadow").getCbxp() * truthfulShadowKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Truthful shadow").getHpxp() * truthfulShadowKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Truthful shadow").getHpxp() * truthfulShadowKills))
                .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Truthful shadow").getCbxp() * truthfulShadowKills) / 2))
                .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Truthful shadow").getCbxp() * truthfulShadowKills) / 2)).build(), truthfulShadowKills, true, true));

        Map<Integer, List<Requirement>> blissfulShadowKillsAndReqs = combatKills(new Encounter("Blissful shadow"), player, 0, "Magic", 0.2, false);
        int blissfulShadowKills = blissfulShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> blissfulShadowReqs = new ArrayList<>(blissfulShadowKillsAndReqs.values().iterator().next());
        blissfulShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing blissful shadows for cores", blissfulShadowReqs, new HashMap(),
            ImmutableMap.builder().put("Blissful shadow core", blissfulShadowKills / 5).put("aCombat", (int) Enemy.getEnemyByName("Blissful shadow").getCbxp() * blissfulShadowKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Blissful shadow").getHpxp() * blissfulShadowKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Blissful shadow").getHpxp() * blissfulShadowKills))
                .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Blissful shadow").getCbxp() * blissfulShadowKills) / 2))
                .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Blissful shadow").getCbxp() * blissfulShadowKills) / 2)).build(), blissfulShadowKills, true, true));

        Map<Integer, List<Requirement>> manifestShadowKillsAndReqs = combatKills(new Encounter("Manifest shadow"), player, 0, "Magic", 0.2, false);
        int manifestShadowKills = manifestShadowKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> manifestShadowReqs = new ArrayList<>(manifestShadowKillsAndReqs.values().iterator().next());
        manifestShadowReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing manifest shadows for cores", manifestShadowReqs, new HashMap(),
            ImmutableMap.builder().put("Manifest shadow core", manifestShadowKills / 5).put("aCombat", (int) Enemy.getEnemyByName("Manifest shadow").getCbxp() * manifestShadowKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Manifest shadow").getHpxp() * manifestShadowKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Manifest shadow").getHpxp() * manifestShadowKills))
                .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Manifest shadow").getCbxp() * manifestShadowKills) / 2))
                .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Manifest shadow").getCbxp() * manifestShadowKills) / 2)).build(), manifestShadowKills, true, true));

        Map<Integer, List<Requirement>> blackKnightKillsAndReqs = combatKills(new Encounter("Black Knight"), player, 28, "Magic", 0, false);
        int blackKnightKills = blackKnightKillsAndReqs.keySet().iterator().next();
        List<Requirement> blackKnightReqs = blackKnightKillsAndReqs.values().iterator().next();
        blackKnightReqs.add(new Requirement("Wanted!", 1));
        database.add(new Action("Killing Black Knights for rank points", blackKnightReqs, new HashMap(), ImmutableMap.builder().put("Black Knight", blackKnightKills)
            .put("aCombat", (int) Enemy.getEnemyByName("Black Knight").getCbxp() * blackKnightKills).put("Constitution", (int) Enemy.getEnemyByName("Black Knight").getHpxp() * blackKnightKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Black Knight").getHpxp() * blackKnightKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Black Knight").getCbxp() * blackKnightKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Black Knight").getCbxp() * blackKnightKills) / 2))
            .put("White Knight rank points", blackKnightKills).build(), blackKnightKills, true, true));

        Map<Integer, List<Requirement>> goblinKillsAndReqs = combatKills(new Encounter("Goblin"), player, 28, "Magic", 0, false);
        int goblinKills = goblinKillsAndReqs.keySet().iterator().next();
        List<Requirement> goblinReqs = goblinKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing goblins for easy clues", goblinReqs, new HashMap(), ImmutableMap.builder().put("Goblin", goblinKills)
            .put("aCombat", (int) Enemy.getEnemyByName("Goblin").getCbxp() * goblinKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Goblin").getHpxp() * goblinKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Goblin").getHpxp() * goblinKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Goblin").getCbxp() * goblinKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Goblin").getCbxp() * goblinKills) / 2))
            .put("Sealed clue scroll (easy)", goblinKills / 128).build(), goblinKills, true, true));

        Map<Integer, List<Requirement>> hillGiantKillsAndReqs = combatKills(new Encounter("Hill giant"), player, 28, "Magic", 0, false);
        int hillGiantKills = hillGiantKillsAndReqs.keySet().iterator().next();
        List<Requirement> hillGiantReqs = hillGiantKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing hill giants", hillGiantReqs, new HashMap(), ImmutableMap.builder().put("Giant", hillGiantKills)
            .put("aCombat", (int) Enemy.getEnemyByName("Hill giant").getCbxp() * hillGiantKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Hill giant").getHpxp() * hillGiantKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Hill giant").getHpxp() * hillGiantKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Hill giant").getCbxp() * hillGiantKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Hill giant").getCbxp() * hillGiantKills) / 2)).build(), hillGiantKills, true, true));

        Map<Integer, List<Requirement>> ghoulKillsAndReqs = combatKills(new Encounter("Ghoul"), player, 28, "Magic", 0, false);
        int ghoulKills = ghoulKillsAndReqs.keySet().iterator().next();
        List<Requirement> ghoulReqs = ghoulKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing ghouls", ghoulReqs, new HashMap(), ImmutableMap.builder().put("Ghoul", ghoulKills).put("aCombat", (int) Enemy.getEnemyByName("Ghoul").getCbxp() * ghoulKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Ghoul").getHpxp() * ghoulKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Ghoul").getHpxp() * ghoulKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Ghoul").getCbxp() * ghoulKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Ghoul").getCbxp() * ghoulKills) / 2)).build(), ghoulKills, true, true));

        Map<Integer, List<Requirement>> earthWarriorKillsAndReqs = combatKills(new Encounter("Earth warrior"), player, 28, "Magic", 0, false);
        int earthWarriorKills = earthWarriorKillsAndReqs.keySet().iterator().next();
        List<Requirement> earthWarriorReqs = earthWarriorKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing earth warriors", earthWarriorReqs, new HashMap(), ImmutableMap.builder().put("Earth warrior", earthWarriorKills)
            .put("aCombat", (int) Enemy.getEnemyByName("Earth warrior").getCbxp() * earthWarriorKills).put("Constitution", (int) Enemy.getEnemyByName("Earth warrior").getHpxp() * earthWarriorKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Earth warrior").getHpxp() * earthWarriorKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Earth warrior").getCbxp() * earthWarriorKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Earth warrior").getCbxp() * earthWarriorKills) / 2)).build(), earthWarriorKills, true, true));

        Map<Integer, List<Requirement>> cadarnMagusKillsAndReqs = combatKills(new Encounter("Cadarn magus"), player, 28, "Ranged", 0, false);
        int cadarnMagusKills = cadarnMagusKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> cadarnMagusReqs = new ArrayList<>(cadarnMagusKillsAndReqs.values().iterator().next());
        cadarnMagusReqs.add(new Requirement("Plague's End", 1));
        database.add(new Action("Killing Cadarn magi", cadarnMagusReqs, new HashMap(), ImmutableMap.builder().put("Cadarn magus", cadarnMagusKills).put("Elf kills", cadarnMagusKills)
            .put("rCombat", (int) Enemy.getEnemyByName("Cadarn magus").getCbxp() * cadarnMagusKills)
            .put("Ranged pet points", totalPetPoints(player, "Ranged", (int) Enemy.getEnemyByName("Cadarn magus").getCbxp() * cadarnMagusKills) / 2)
            .put("Constitution", (int) Enemy.getEnemyByName("Cadarn magus").getHpxp() * cadarnMagusKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Cadarn magus").getHpxp() * cadarnMagusKills))
            .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Cadarn magus").getCbxp() * cadarnMagusKills) / 2).build(), cadarnMagusKills, true, true));

        Map<Integer, List<Requirement>> jogreKillsAndReqs = combatKills(new Encounter("Jogre"), player, 28, "Magic", 0, false);
        int jogreKills = jogreKillsAndReqs.keySet().iterator().next();
        List<Requirement> jogreReqs = jogreKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing jogres", jogreReqs, new HashMap(), ImmutableMap.builder().put("Jogre", jogreKills).put("aCombat", (int) Enemy.getEnemyByName("Jogre").getCbxp() * jogreKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Jogre").getHpxp() * jogreKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Jogre").getHpxp() * jogreKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Jogre").getCbxp() * jogreKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Jogre").getCbxp() * jogreKills) / 2)).build(), jogreKills, true, true));

        Map<Integer, List<Requirement>> mogreKillsAndReqs = combatKills(new Encounter("Mogre"), player, 28, "Magic", 0, false);
        int mogreKills = mogreKillsAndReqs.keySet().iterator().next();
        List<Requirement> mogreReqs = mogreKillsAndReqs.values().iterator().next();
        mogreReqs.add(new Requirement("Mogre miniquest", 1));
        database.add(new Action("Killing mogres", mogreReqs, new HashMap(), ImmutableMap.builder().put("Mogre", mogreKills).put("aCombat", (int) Enemy.getEnemyByName("Mogre").getCbxp() * mogreKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Mogre").getHpxp() * mogreKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Mogre").getHpxp() * mogreKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Mogre").getCbxp() * mogreKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Mogre").getCbxp() * mogreKills) / 2)).build(), mogreKills, true, true));

        Map<Integer, List<Requirement>> mummyKillsAndReqs = combatKills(new Encounter("Mummy"), player, 28, "Magic", 0, false);
        int mummyKills = mummyKillsAndReqs.keySet().iterator().next();
        List<Requirement> mummyReqs = mummyKillsAndReqs.values().iterator().next();
        mummyReqs.add(new Requirement("Dealing with Scabaras", 1));
        database.add(new Action("Killing mummies (post-Dealing With Scabaras)", mummyReqs, new HashMap(), ImmutableMap.builder().put("Mummy", mummyKills)
            .put("aCombat", (int) Enemy.getEnemyByName("Mummy").getCbxp() * mummyKills).put("Constitution", (int) Enemy.getEnemyByName("Mummy").getHpxp() * mummyKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Mummy").getHpxp() * mummyKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Mummy").getCbxp() * mummyKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Mummy").getCbxp() * mummyKills) / 2)).build(), mummyKills, true, true));

        Map<Integer, List<Requirement>> lesserDemonKillsAndReqs = combatKills(new Encounter("Lesser demon"), player, 28, "Ranged", 0, false);
        int lesserDemonKills = lesserDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> lesserDemonReqs = lesserDemonKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing lesser demons", lesserDemonReqs, new HashMap(), ImmutableMap.builder().put("Lesser demon", lesserDemonKills)
            .put("rCombat", (int) Enemy.getEnemyByName("Lesser demon").getCbxp() * lesserDemonKills)
            .put("Ranged pet points", totalPetPoints(player, "Ranged", (int) Enemy.getEnemyByName("Lesser demon").getCbxp() * lesserDemonKills) / 2)
            .put("Constitution", (int) Enemy.getEnemyByName("Lesser demon").getHpxp() * lesserDemonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Lesser demon").getHpxp() * lesserDemonKills))
            .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Lesser demon").getCbxp() * lesserDemonKills) / 2).build(), lesserDemonKills, true, true));

        Map<Integer, List<Requirement>> ripperDemonKillsAndReqs = combatKills(new Encounter("Ripper demon"), player, 28, "Magic", 0, false);
        int ripperDemonKills = ripperDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> ripperDemonReqs = ripperDemonKillsAndReqs.values().iterator().next();
        ripperDemonReqs.add(new Requirement("Slayer", 96));
        database.add(new Action("Killing ripper demons", ripperDemonReqs, new HashMap(), ImmutableMap.builder().put("Ripper demons", ripperDemonKills)
            .put("aCombat", (int) Enemy.getEnemyByName("Ripper demon").getCbxp() * ripperDemonKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Ripper demon").getHpxp() * ripperDemonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Ripper demon").getHpxp() * ripperDemonKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Ripper demon").getCbxp() * ripperDemonKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Ripper demon").getCbxp() * ripperDemonKills) / 2)).build(), ripperDemonKills, true, true));

        Map<Integer, List<Requirement>> kalgerionDemonKillsAndReqs = combatKills(new Encounter("Kal'gerion demon"), player, 28, "Magic", 0, false);
        int kalgerionDemonKills = kalgerionDemonKillsAndReqs.keySet().iterator().next();
        List<Requirement> kalgerionDemonReqs = kalgerionDemonKillsAndReqs.values().iterator().next();
        kalgerionDemonReqs.add(new Requirement("Dungeoneering", 90));
        database.add(new Action("Killing Kal'gerion demons", kalgerionDemonReqs, new HashMap(), ImmutableMap.builder().put("Kal'gerion demon", kalgerionDemonKills)
            .put("aCombat", (int) Enemy.getEnemyByName("Kal'gerion demon").getCbxp() * kalgerionDemonKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Kal'gerion demon").getHpxp() * kalgerionDemonKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Kal'gerion demon").getHpxp() * kalgerionDemonKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Kal'gerion demon").getCbxp() * kalgerionDemonKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Kal'gerion demon").getCbxp() * kalgerionDemonKills) / 2)).build(), kalgerionDemonKills, true, true));

        Map<Integer, List<Requirement>> impKillsAndReqs = combatKills(new Encounter("Imp"), player, 28, "Magic", 0, false);
        int impKills = impKillsAndReqs.keySet().iterator().next();
        List<Requirement> impReqs = impKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing imps", impReqs, new HashMap(), ImmutableMap.builder().put("Imp", impKills).put("aCombat", (int) Enemy.getEnemyByName("Imp").getCbxp() * impKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Imp").getHpxp() * impKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Imp").getHpxp() * impKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Imp").getCbxp() * impKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Imp").getCbxp() * impKills) / 2)).build(), impKills, true, true));

        Map<Integer, List<Requirement>> cowKills = combatKills(new Encounter("Cow"), player, 28, "Magic", 0, false);
        database.add(new Action("Killing cows", cowKills.values().iterator().next(), new HashMap(), ImmutableMap.builder()
            .put("aCombat", (int) Enemy.getEnemyByName("Cow").getCbxp() * cowKills.keySet().iterator().next())
            .put("Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKills.keySet().iterator().next())
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Cow").getHpxp() * cowKills.keySet().iterator().next()))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Cow").getCbxp() * cowKills.keySet().iterator().next()) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Cow").getCbxp() * cowKills.keySet().iterator().next()) / 2))
            .put("Cow kills", cowKills.keySet().iterator().next()).build(), cowKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> revenantKills = combatKills(new Encounter("Revenant demon"), player, 28, "Ranged", 0, false);
        database.add(new Action("Killing revenants", revenantKills.values().iterator().next(), new HashMap(), ImmutableMap.builder()
            .put("rCombat", (int) Enemy.getEnemyByName("Revenant demon").getCbxp() * revenantKills.keySet().iterator().next())
            .put("Constitution", (int) Enemy.getEnemyByName("Revenant demon").getHpxp() * revenantKills.keySet().iterator().next())
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Revenant demon").getHpxp() * revenantKills.keySet().iterator().next()))
            .put("Ranged pet points", totalPetPoints(player, "Ranged", ((int) Enemy.getEnemyByName("Revenant demon").getCbxp() * revenantKills.keySet().iterator().next()) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Revenant demon").getCbxp() * revenantKills.keySet().iterator().next()) / 2))
            .put("Revenant kills", revenantKills.keySet().iterator().next()).build(), revenantKills.keySet().iterator().next(), true, true));


        Map<Integer, List<Requirement>> yakKillsAndReqs = combatKills(new Encounter("Yak"), player, 28, "Magic", 0, false);
        int yakKills = yakKillsAndReqs.keySet().iterator().next();
        List<Requirement> yakReqs = yakKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing yaks", yakReqs, new HashMap(), ImmutableMap.builder().put("Yak", yakKills).put("aCombat", (int) Enemy.getEnemyByName("Yak").getCbxp() * yakKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Yak").getHpxp() * yakKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Yak").getHpxp() * yakKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", ((int) Enemy.getEnemyByName("Yak").getCbxp() * yakKills) / 2))
            .put("Defence pet points", totalPetPoints(player, "Defence", ((int) Enemy.getEnemyByName("Yak").getCbxp() * yakKills) / 2)).build(), yakKills, true, true));


        //Bossing
        Map<Integer, List<Requirement>> kbdKillsAndReqs = combatKills(new Encounter("King Black Dragon"), player, 28, "Melee", 0, false);
        int kbdKills = kbdKillsAndReqs.keySet().iterator().next();
        List<Requirement> kbdReqs = kbdKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing the King Black Dragon", kbdReqs, new HashMap(), ImmutableMap.builder().put("King Black Dragon", kbdKills).put("Boss kills", kbdKills)
            .put("mCombat", (int) Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills).put("Constitution", (int) Enemy.getEnemyByName("King Black Dragon").getHpxp() * kbdKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("King Black Dragon").getHpxp() * kbdKills))
            .put("Attack pet points", totalPetPoints(player, "Attack", (int) Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills) / 3)
            .put("Strength pet points", totalPetPoints(player, "Strength", (int) Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills) / 3)
            .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("King Black Dragon").getCbxp() * kbdKills) / 3)
            .put("Crimson charm", (int)(Math.floor(kbdKills*2.32))).build(), kbdKills, true, true));

        Map<Integer, List<Requirement>> chaosElementalKillsAndReqs = combatKills(new Encounter("Chaos Elemental"), player, 28, "Ranged", 0, false);
        int chaosElementalKills = chaosElementalKillsAndReqs.keySet().iterator().next();
        List<Requirement> chaosElementalReqs = chaosElementalKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing the Chaos Elemental", chaosElementalReqs, new HashMap(), ImmutableMap.builder().put("Chaos Elemental", chaosElementalKills).put("Boss kills", chaosElementalKills)
            .put("rCombat", (int) Enemy.getEnemyByName("Chaos Elemental").getCbxp() * chaosElementalKills)
            .put("Ranged pet points", totalPetPoints(player, "Ranged", (int) Enemy.getEnemyByName("Chaos Elemental").getCbxp() * chaosElementalKills) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Chaos Elemental").getCbxp() * chaosElementalKills) / 2)
            .put("Constitution", (int) Enemy.getEnemyByName("Chaos Elemental").getHpxp() * chaosElementalKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Chaos Elemental").getHpxp() * chaosElementalKills)).build(), chaosElementalKills, true, true));

        Map<Integer, List<Requirement>> dagannothRexKillsAndReqs = combatKills(new Encounter("Dagannoth Rex"), player, 28, "Magic", 0, false);
        int dagannothRexKills = dagannothRexKillsAndReqs.keySet().iterator().next();
        List<Requirement> dagannothRexReqs = dagannothRexKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing Dagannoth Rex", dagannothRexReqs, new HashMap(), ImmutableMap.builder().put("Dagannoth Rex", dagannothRexKills)
            .put("Dagannoth Kings", dagannothRexKills).put("Boss kills", dagannothRexKills).put("aCombat", (int) Enemy.getEnemyByName("Dagannoth Rex").getCbxp() * dagannothRexKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Dagannoth Rex").getHpxp() * dagannothRexKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Dagannoth Rex").getHpxp() * dagannothRexKills))
            .put("Magic pet points", totalPetPoints(player, "Magic", (int) Enemy.getEnemyByName("Dagannoth Rex").getCbxp() * dagannothRexKills) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Dagannoth Rex").getCbxp() * dagannothRexKills) / 2).build(), dagannothRexKills, true, true));

        Map<Integer, List<Requirement>> dagannothPrimeKillsAndReqs = combatKills(new Encounter("Dagannoth Prime"), player, 28, "Ranged", 0, false);
        int dagannothPrimeKills = dagannothPrimeKillsAndReqs.keySet().iterator().next();
        List<Requirement> dagannothPrimeReqs = dagannothPrimeKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing Dagannoth Prime", dagannothPrimeReqs, new HashMap(), ImmutableMap.builder().put("Dagannoth Prime", dagannothPrimeKills)
            .put("Dagannoth Kings", dagannothPrimeKills).put("Boss kills", dagannothPrimeKills).put("rCombat", (int) Enemy.getEnemyByName("Dagannoth Prime").getCbxp() * dagannothPrimeKills)
            .put("Ranged pet points", totalPetPoints(player, "Ranged", (int) Enemy.getEnemyByName("Dagannoth Prime").getCbxp() * dagannothPrimeKills) / 2)
            .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Dagannoth Prime").getCbxp() * dagannothPrimeKills) / 2)
            .put("Constitution", (int) Enemy.getEnemyByName("Dagannoth Prime").getHpxp() * dagannothPrimeKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Dagannoth Prime").getHpxp() * dagannothPrimeKills)).build(), dagannothPrimeKills, true, true));

        Map<Integer, List<Requirement>> dagannothSupremeKillsAndReqs = combatKills(new Encounter("Dagannoth Supreme"), player, 28, "Melee", 0, false);
        int dagannothSupremeKills = dagannothSupremeKillsAndReqs.keySet().iterator().next();
        List<Requirement> dagannothSupremeReqs = dagannothSupremeKillsAndReqs.values().iterator().next();
        database.add(new Action("Killing Dagannoth Supreme", dagannothSupremeReqs, new HashMap(), ImmutableMap.builder().put("Dagannoth Supreme", dagannothSupremeKills)
            .put("Dagannoth Kings", dagannothSupremeKills).put("Boss kills", dagannothSupremeKills)
            .put("mCombat", (int) Enemy.getEnemyByName("Dagannoth Supreme").getCbxp() * dagannothSupremeKills)
            .put("Constitution", (int) Enemy.getEnemyByName("Dagannoth Supreme").getHpxp() * dagannothSupremeKills)
            .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Dagannoth Supreme").getHpxp() * dagannothSupremeKills))
            .put("Attack pet points", totalPetPoints(player, "Attack", (int) Enemy.getEnemyByName("Dagannoth Supreme").getCbxp() * dagannothSupremeKills))
            .put("Strength pet points", totalPetPoints(player, "Strength", (int) Enemy.getEnemyByName("Dagannoth Supreme").getCbxp() * dagannothSupremeKills))
            .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Dagannoth Supreme").getCbxp() * dagannothSupremeKills)).build(),
            dagannothSupremeKills, true, true));

        Map<Integer, List<Requirement>> qbdKillsAndReqs = combatKills(new Encounter("Queen Black Dragon"), player, 28, "Melee", 0, false);
        int qbdKills = qbdKillsAndReqs.keySet().iterator().next();
        ArrayList<Requirement> qbdReqs = new ArrayList<>(qbdKillsAndReqs.values().iterator().next());
        qbdReqs.add(new Requirement("Summoning", 60));
        database.add(new Action("Killing the Queen Black Dragon", qbdReqs, new HashMap(),
            ImmutableMap.builder().put("Queen Black Dragon", qbdKills).put("Boss kills", qbdKills).put("mCombat", (int) Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills)
                .put("Constitution", (int) Enemy.getEnemyByName("Queen Black Dragon").getHpxp() * qbdKills)
                .put("Constitution pet points", totalPetPoints(player, "Constitution", (int) Enemy.getEnemyByName("Queen Black Dragon").getHpxp() * qbdKills))
                .put("Attack pet points", totalPetPoints(player, "Attack", (int) Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills) / 3)
                .put("Strength pet points", totalPetPoints(player, "Strength", (int) Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills) / 3)
                .put("Defence pet points", totalPetPoints(player, "Defence", (int) Enemy.getEnemyByName("Queen Black Dragon").getCbxp() * qbdKills) / 3).build(), qbdKills, true, true));

        Map<Integer, List<Requirement>> durzagKills = combatKills(new Encounter(Arrays.asList(Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Charger", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Airut", "Charger", "Charger"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Charger", "Charger", "Cormes"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Airut", "Airut", "Airut", "Airut", "Airut", "Airut", "Airut"),
            Arrays.asList("Tuz", "Krar", "Beastmaster Durzag")), 10), player, 28, "Melee", 0, false);
        database.add(new Action("Killing Beastmaster Durzag (10 man)", durzagKills.values().iterator().next(), new HashMap(), ImmutableMap.of("Beastmaster Durzag", durzagKills.keySet().iterator().next(),
            "Boss kills", durzagKills.keySet().iterator().next(), "Liberation of Mazcab", durzagKills.keySet().iterator().next(), "Teci", durzagKills.keySet().iterator().next() * 1000),
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
            "Boss kills", corporealBeastKills.keySet().iterator().next(), "Blue charm", (int)(Math.floor(corporealBeastKills.keySet().iterator().next() * 5.33)),
            "Gold charm", (int)(Math.floor(corporealBeastKills.keySet().iterator().next() * 2.73)), "Crimson charm", (int)(Math.floor(corporealBeastKills.keySet().iterator().next() * 2.73))),
            corporealBeastKills.keySet().iterator().next(), true, true));

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
            "Boss kills", twinFuriesKills.keySet().iterator().next(), "Zaros reputation", 5 * twinFuriesKills.keySet().iterator().next()),
            twinFuriesKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> twinFuriesCMKills = combatKills(new Encounter("Twin Furies (CM)"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> twinFuriesCMReqs = new ArrayList(twinFuriesKills.values().iterator().next());
        twinFuriesReqs.add(new Requirement("Ranged", 80));
        database.add(new Action("Killing the Twin Furies (CM)", twinFuriesCMReqs, new HashMap(), ImmutableMap.of("Twin Furies (CM)", twinFuriesCMKills.keySet().iterator().next(),
            "Boss kills", twinFuriesCMKills.keySet().iterator().next(), "Zaros reputation", 15 * twinFuriesCMKills.keySet().iterator().next()),
            twinFuriesCMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> vindictaKills = combatKills(new Encounter("Vindicta"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> vindictaReqs = new ArrayList(vindictaKills.values().iterator().next());
        vindictaReqs.add(new Requirement("Attack", 80));
        database.add(new Action("Killing Vindicta", vindictaReqs, new HashMap(), ImmutableMap.of("Vindicta", vindictaKills.keySet().iterator().next(),
            "Boss kills", vindictaKills.keySet().iterator().next(), "Seren reputation", 5 * vindictaKills.keySet().iterator().next()),
            vindictaKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> vindictaHMKills = combatKills(new Encounter("Vindicta (hard)"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> vindictaHMReqs = new ArrayList(vindictaHMKills.values().iterator().next());
        vindictaHMReqs.add(new Requirement("Attack", 80));
        database.add(new Action("Killing Vindicta in hard mode", vindictaHMReqs, new HashMap(), ImmutableMap.of("Vindicta (hard)", vindictaHMKills.keySet().iterator().next(),
            "Boss kills", vindictaHMKills.keySet().iterator().next(), "Seren reputation", 15 * vindictaHMKills.keySet().iterator().next()),
            vindictaHMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> helwyrKills = combatKills(new Encounter("Helwyr"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> helwyrReqs = new ArrayList(helwyrKills.values().iterator().next());
        helwyrReqs.add(new Requirement("Magic", 80));
        database.add(new Action("Killing Helwyr", helwyrReqs, new HashMap(), ImmutableMap.of("Helwyr", helwyrKills.keySet().iterator().next(),
            "Boss kills", helwyrKills.keySet().iterator().next(), "Sliske reputation", 5 * helwyrKills.keySet().iterator().next()), helwyrKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> helwyrHMKills = combatKills(new Encounter("Helwyr (hard)"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> helwyrHMReqs = new ArrayList(helwyrHMKills.values().iterator().next());
        helwyrHMReqs.add(new Requirement("Magic", 80));
        database.add(new Action("Killing Helwyr in hard mode", helwyrHMReqs, new HashMap(), ImmutableMap.of("Helwyr (hard)", helwyrHMKills.keySet().iterator().next(),
            "Boss kills", helwyrHMKills.keySet().iterator().next(), "Sliske reputation", 15 * helwyrHMKills.keySet().iterator().next()),
            helwyrHMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> gregKills = combatKills(new Encounter("Gregorovic"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> gregReqs = new ArrayList(gregKills.values().iterator().next());
        gregReqs.add(new Requirement("Prayer", 80));
        database.add(new Action("Killing Gregorovic", gregReqs, new HashMap(), ImmutableMap.of("Gregorovic", gregKills.keySet().iterator().next(),
            "Boss kills", gregKills.keySet().iterator().next(), "Zamorak reputation", 5 * gregKills.keySet().iterator().next()), gregKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> gregCMKills = combatKills(new Encounter("Gregorovic (CM)"), player, 28, "Melee", 0, false);
        ArrayList<Requirement> gregCMReqs = new ArrayList(gregCMKills.values().iterator().next());
        gregCMReqs.add(new Requirement("Prayer", 80));
        database.add(new Action("Killing Gregorovic (CM)", gregCMReqs, new HashMap(), ImmutableMap.of("Gregorovic (hard)", gregCMKills.keySet().iterator().next(),
            "Boss kills", gregCMKills.keySet().iterator().next(), "Zamorak reputation", 15 * gregCMKills.keySet().iterator().next()),
            gregCMKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kreeKills = combatKills(new Encounter("Kree'arra"), player, 28, "Ranged", 0, false);
        ArrayList<Requirement> kreeReqs = new ArrayList<>(kreeKills.values().iterator().next());
        kreeReqs.add(new Requirement("Ranged", 70));
        database.add(new Action("Killing Kree'arra", kreeReqs, new HashMap(), ImmutableMap.of("Kree'arra", kreeKills.keySet().iterator().next(),
            "Boss kills", kreeKills.keySet().iterator().next()), kreeKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> kreeKillsHM = combatKills(new Encounter("Kree'arra (HM)"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> kreeReqsHM = new ArrayList(kreeKillsHM.values().iterator().next());
        kreeReqsHM.add(new Requirement("Ranged", 70));
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
        krilReqsHM.add(new Requirement("Constitution", 70));
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
        yakamaruReqs.add(new Requirement("Beastmaster Durzag", 1));
        database.add(new Action("Killing Yakamaru (10 man)", yakamaruReqs, new HashMap(), ImmutableMap.of("Yakamaru", yakamaruKills.keySet().iterator().next(),
            "Boss kills", yakamaruKills.keySet().iterator().next(), "Liberation of Mazcab", yakamaruKills.keySet().iterator().next()),
            yakamaruKills.keySet().iterator().next(), true, true));

        Map<Integer, List<Requirement>> zilyanaHMKills = combatKills(new Encounter("Commander Zilyana (hard)"), player, 28, "Magic", 0, false);
        ArrayList<Requirement> zilyanaHMReqs = new ArrayList(zilyanaKills.values().iterator().next());
        zilyanaHMReqs.add(new Requirement("Agility", 70));
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
            ImmutableMap.of("Legio Secundus", legioKills.keySet().iterator().next(), "Blue charm", (int)(Math.floor(legioKills.keySet().iterator().next()*1.62)),
                "Crimson charm", (int)(Math.floor(legioKills.keySet().iterator().next()*1.98)), "Legiones", legioKills.keySet().iterator().next(),
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
        database.add(new Action("Killing Nex", nexReqs, new HashMap(), ImmutableMap.of("Nex", nexKills.keySet().iterator().next(), "Boss kills", nexKills.keySet().iterator().next(),
            "Blue charm", (int)(Math.floor(nexKills.keySet().iterator().next()*4.40))), nexKills.keySet().iterator().next(), true, true));

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
            ImmutableMap.of("Reaper point", (int) (Math.floor(reaperPointsPerHour)), "Slayer", (int) (Math.floor(slayerFromReaper))), 2, true, true));
    }

    public List<Action> getDatabase() {
        return database;
    }

    private List<Requirement> getRequirementsForCombat(Encounter combatEncounter, Player player, int invenSpaces, String combatStyle) {
        Map<String, Double> initialXP = new HashMap<>(player.getXp());
        LinkedHashSet<Weapon> initialWeapons = new LinkedHashSet<>(player.getWeapons());
        LinkedHashSet<Armour> initialArmours = new LinkedHashSet<>(player.getArmour());
        CombatResults combatResults;
        while(true) {
            combatResults = combatEncounter.calculateCombat(player, new CombatParameters(invenSpaces, combatStyle, false, 0, false));
            if (combatResults.getKills() == 0) {
                Map<String, Double> nextGear = player.nextGear(combatStyle);
                if (nextGear == null) {
                    break;
                }
                player.addGearToPlayer(nextGear.keySet().iterator().next());
            }
            else {
                List<Requirement> requirements = new ArrayList<>();
                Loadout loadout = combatResults.getLoadoutUsed();
                player.setXp(loadout.getXp());
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
        LinkedHashSet<Weapon> initialWeapons = new LinkedHashSet<>(player.getWeapons());
        LinkedHashSet<Armour> initialArmours = new LinkedHashSet<>(player.getArmour());
        CombatParameters parameters = new CombatParameters(invenSpaces, combatStyle, true, dropRateOfItem, stackable);
        CombatResults combatResults = combatEncounter.calculateCombat(player, parameters);
        List<Requirement> combatReqs = new ArrayList<>();
        if (combatResults.getKills() == 0) {
            combatReqs = getRequirementsForCombat(combatEncounter, player, invenSpaces, combatStyle);
            for (Requirement requirement : combatReqs) {
                if (Player.ALL_SKILLS.contains(requirement.getQualifier())) {
                    player.getXp().put(requirement.getQualifier(), player.getXp().get(requirement.getQualifier()) + player.getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
                }
                else if (WeaponDatabase.getWeaponDatabase().getWeapons().values().stream().map(Weapon::getName).collect(Collectors.toList()).contains(requirement.getQualifier())) {
                    player.getWeapons().add(WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()));
                }
                else if (ArmourDatabase.getArmourDatabase().getArmours().values().stream().map(Armour::getName).collect(Collectors.toList()).contains(requirement.getQualifier())) {
                    player.getArmour().add(ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()));
                }
            }
            combatResults = combatEncounter.calculateCombat(player, parameters);
            if (combatResults.getKills() == 0) {
                player.setXp(initialXP);
                player.setWeapons(initialWeapons);
                player.setArmour(initialArmours);
                return ImmutableMap.of(0, Collections.singletonList(new Requirement("Impossible", 1)));
            }
        }
        player.setXp(initialXP);
        player.setWeapons(initialWeapons);
        player.setArmour(initialArmours);
        if (combatResults.getTicks() >= TICKS_PER_HOUR-100) {
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
            actionDatabase.addSkillingActionsToDatabase(player);
            actionDatabase.addSkillingActionsToDatabasePart2(player);
            actionDatabase.addCombatActionsToDatabase(player);
        }
        return actionDatabase;
    }

    public static void reset() {
        actionDatabase = null;
    }
}