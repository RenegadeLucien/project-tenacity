package staticdata;

import dynamicdata.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public enum Achievement {
	/*This lists not only achievements, but all non-repeatables. List is in topological order of requirements (all achievements are listed after their prerequisites.)*/
	AVOIDING_CONFLICT("A-Voiding Conflict", 0.05, Collections.singletonList(new Requirement("Combat", 35)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	A_CAT_IS_FOR_LIFE("A Cat is for Life...", 0, Arrays.asList(new Requirement("Plague City", 1), new Requirement("Gertrude's Cat", 1),
			new Requirement("Cat", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	A_GAME_OF_TOMBS_I("A Game of Tombs I", 0, Collections.singletonList(new Requirement("Shifting Tombs", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	A_GAME_OF_TOMBS_II("A Game of Tombs II", 0, Collections.singletonList(new Requirement("Shifting Tombs", 10)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	A_GAME_OF_TOMBS_III("A Game of Tombs III", 0, Collections.singletonList(new Requirement("Shifting Tombs", 50)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	A_GAME_OF_TOMBS_IV("A Game of Tombs IV", 0, Collections.singletonList(new Requirement("Shifting Tombs", 100)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	A_GAME_OF_TOMBS_V("A Game of Tombs V", 0, Collections.singletonList(new Requirement("Shifting Tombs", 200)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	A_GIFT_FROM_KHAZARD("A Gift From Khazard", 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	A_WIZARD_DID_IT("A Wizard Did It", 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	A_WORLD_IN_MICROCOSM("A World In Microcosm", 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ABYSSAL_REACH("Abyssal Reach", 0.25, Collections.singletonList(new Requirement("Rune Mysteries", 1)), new ArrayList<>(),
			Collections.singletonList(new Reward("Runecrafting", 1000)), new ArrayList<>(), true),
	ABYSSAL_VALET("Abyssal Valet", 0, Arrays.asList(new Requirement("Abyssal titan pouch", 1), new Requirement("Summoning", 93),
			new Requirement("Pure essense", 2)), new ArrayList<>(), Collections.singletonList(new Reward("Summoning", 2)),
			new ArrayList<>(), true),
	ADVANCED_SWEEPING("Advanced Sweeping", 0, Collections.singletonList(new Requirement("Broomstick enchantments", 5)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ADVENTURERS_LOG("Adventurer's Log", 0, new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Reward("Logs", 1),
			new Reward("Woodcutting", 25)), new ArrayList<>(), true),
	AERECKS_OLD_BONES("Aereck's Old Bones", 0, Collections.singletonList(new Requirement("The Restless Ghost", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	AGILE_FROM_HEAD_TO_TOE("Agile from Head to Toe", 0, Arrays.asList(new Requirement("Agile top", 1), new Requirement("Agile legs", 1)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	AGILITY_DOJO_MOJO("Agility - Dojo Mojo", 0, Collections.singletonList(new Requirement("Dojo Mojo", 1)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_5("Agility 5", 0, Collections.singletonList(new Requirement("Agility", 5)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_10("Agility 10", 0, Collections.singletonList(new Requirement("Agility", 10)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_20("Agility 20", 0, Collections.singletonList(new Requirement("Agility", 20)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_30("Agility 30", 0, Collections.singletonList(new Requirement("Agility", 30)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_40("Agility 40", 0, Collections.singletonList(new Requirement("Agility", 40)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_50("Agility 50", 0, Collections.singletonList(new Requirement("Agility", 50)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_60("Agility 60", 0, Collections.singletonList(new Requirement("Agility", 60)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_70("Agility 70", 0, Collections.singletonList(new Requirement("Agility", 70)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_80("Agility 80", 0, Collections.singletonList(new Requirement("Agility", 80)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_90("Agility 90", 0, Collections.singletonList(new Requirement("Agility", 90)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_92("Agility 92", 0, Collections.singletonList(new Requirement("Agility", 92)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AGILITY_99("Agility 99", 0, Collections.singletonList(new Requirement("Agility", 99)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AHRIM_BOBBLEHEAD("Ahrim Bobblehead", 0, Arrays.asList(new Requirement("Malevolent energy", 250), new Requirement("Ahrim's hood", 1),
			new Requirement("Ahrim's robe top", 1), new Requirement("Ahrim's robe skirt", 1), new Requirement("Ahrim's staff", 1)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	AL_KHARID("Al Kharid", 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ALI_THE_TRADER("Ali The Trader", 0, Collections.singletonList(new Requirement("Rogue Trader parts", 3)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ALL_ABOARD("All Aboard", 0, Collections.singletonList(new Requirement("Ranged", 70)), Collections.singletonList(new Encounter(Collections.singletonList(Enemy.KREEARRA))),
			new ArrayList<>(), new ArrayList<>(), true),
	ALL_RISE("All Rise", 0, Collections.singletonList(new Requirement("Court Cases", 16)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ALL_TOGETHER_NOW("All Together Now", 0, Collections.singletonList(new Requirement("Beastmaster Durzag", 1)), Collections.singletonList(new Encounter(
			Arrays.asList(Enemy.YAKAMARU, Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU))), new ArrayList<>(),
			new ArrayList<>(), true),
	ALMOST_MADE_IN_ARDOUGNE("Almost Made In Ardougne", 0, Arrays.asList(new Requirement("Yew logs", 1), new Requirement("Raw beef", 1),
			new Requirement("Rune bar", 1), new Requirement("Smithing", 91), new Requirement("Fletching", 69),
			new Requirement("Crafting", 10)), new ArrayList<>(), Arrays.asList(new Reward("Rune crossbow", 1),
			new Reward("Cooking", 3), new Reward("Fletching", 100), new Reward("Smithing", 75),
			new Reward("Crafting", 15)), new ArrayList<>(), true),
	ALMOST_AS_PERKY_AS_A_PRAWN("Almost as Perky as a Prawn", 0, Collections.singletonList(new Requirement("Prawn perk", 15)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ALONG_CAME_A_SPIDER_I("Along Came A Spider I", 0, Collections.singletonList(new Requirement("Araxxi", 5)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ALONG_CAME_A_SPIDER_II("Along Came A Spider II", 0, Collections.singletonList(new Requirement("Araxxi", 10)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ALONG_CAME_A_SPIDER_III("Along Came A Spider III", 0, Collections.singletonList(new Requirement("Araxxi", 25)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ALONG_CAME_A_SPIDER_IV("Along Came A Spider IV", 0, Collections.singletonList(new Requirement("Araxxi", 50)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ALONG_CAME_A_SPIDER_V("Along Came A Spider V", 0, Collections.singletonList(new Requirement("Araxxi", 75)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ALONG_CAME_A_SPIDER_VI("Along Came A Spider VI", 0, Collections.singletonList(new Requirement("Araxxi", 100)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ALTAR_EXPLORER("Altar Explorer", 0.3, Collections.singletonList(new Requirement("Runecrafting", 50)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ANGS_OFF_MY_RING("Angs off my Ring", 0, Collections.singletonList(new Requirement("Ancient elven wedding ring", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ANIMAL_CRUELTY("Animal Cruelty", 0, new ArrayList<>(), Collections.singletonList(new Encounter(Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER,
			Enemy.CHARGER, Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG))), new ArrayList<>(), new ArrayList<>(), true),
	ANNIHILATOR("Annihilator", 0, Collections.singletonList(new Requirement("Fate of the Gods", 1)), Collections.singletonList(
			new Encounter(Arrays.asList(Enemy.SMOKE_NIHIL, Enemy.SHADOW_NIHIL, Enemy.BLOOD_NIHIL, Enemy.ICE_NIHIL))), new ArrayList<>(), new ArrayList<>(), true),
	ANY_ODD_CHICKEN("Any Odd Chicken", 0, Collections.singletonList(new Requirement("Ernest the Chicken", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	APE_AHOLLOW("Ape A'hollow", 0.05, Arrays.asList(new Requirement("Fairy Tale Part III", 1), new Requirement("Monkey Madness", 1),
			new Requirement("Agility", 48)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_ALL_YOUR_ENERGIES("Arc - All Your Energies", 0, Arrays.asList(new Requirement("Chimes", 5000), new Requirement("Tajitu", 5),
			new Requirement("Impressing the Locals", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_ANCIENT_EASTERN_TORTLE_PORTALS("Arc - Ancient Eastern Tortle Portals", 0.05, Arrays.asList(new Requirement("Divination", 90),
			new Requirement("Ancestral energy", 100), new Requirement("Impressing the Locals", 1)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_BONE_TO_PICK_WITH_YOU("Arc - Bone to Pick with You", 0, Arrays.asList(new Requirement("Chimes", 25000), new Requirement("Tajitu", 25),
			new Requirement("Impressing the Locals", 1), new Requirement("Bonecrusher", 1)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ARC_DONT_CRUSH_MY_MEMORIES("Arc - Don't Crush My Memories", 0, Arrays.asList(new Requirement("Chimes", 5000), new Requirement("Tajitu", 5),
			new Requirement("Impressing the Locals", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_FLIPPERS("Arc - Flippers", 0, Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Raw tarpon", 1)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_MITTS_AND_WADERS_DEATH_LOTUS("Arc - Mitts and Waders - Death Lotus", 0, Arrays.asList(new Requirement("Chimes", 5000), new Requirement("Tajitu", 6),
			new Requirement("Impressing the Locals", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_MITTS_AND_WADERS_SEASINGER("Arc - Mitts and Waders - Seasinger", 0, Arrays.asList(new Requirement("Chimes", 5000), new Requirement("Tajitu", 6),
			new Requirement("Impressing the Locals", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_MITTS_AND_WADERS_TETSU("Arc - Mitts and Waders - Tetsu", 0, Arrays.asList(new Requirement("Chimes", 5000), new Requirement("Tajitu", 6),
			new Requirement("Impressing the Locals", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	BERRIES_OF_THE_ARC("Berries of the Arc", 0, Collections.singletonList(new Requirement("Arc berries", 16)), new ArrayList<>(),
			Collections.singletonList(new Reward("Farming", 50000)), new ArrayList<>(), true),
	BIRDS_OF_THE_ARC("Birds of the Arc", 0, Collections.singletonList(new Requirement("Arc birds", 16)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ARC_REWARDS("Arc - Rewards", 0, Arrays.asList(new Requirement("Impressing the Locals", 1), new Requirement("Birds of the Arc", 1),
			new Requirement("Berries of the Arc", 1), new Requirement("Kami", 16)), new ArrayList<>(),
			Collections.singletonList(new Reward("Hunter", 50000)), new ArrayList<>(), true),
	ARC_UNLOCKING_MORE_WAIKO("Arc - Unlocking More Waiko", 0, Arrays.asList(new Requirement("Sojobo contract guru", 1),
			new Requirement("Ancestral Divination I", 1), new Requirement("Ancestral Divination II", 1),
			new Requirement("Ancestral Conversion", 1), new Requirement("Spirit dragon pet", 1),
			new Requirement("Idol crabletine pet", 1), new Requirement("Gu ronin outfit", 1),
			new Requirement("Death lotus rogue outfit", 1), new Requirement("Seasinger acolyte outfit", 1),
			new Requirement("Hunter outfit", 1), new Requirement("Hanto outfit", 1), new Requirement("Thalassia's Revenge", 1),
			new Requirement("Winds of Waiko", 1), new Requirement("Rage of Hyu-ji", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	ARC_UNLOCKING_WAIKO("Arc - Unlocking Waiko", 0, Arrays.asList(new Requirement("Waiko Grill", 1), new Requirement("Whale's Maw Camp Fire", 1),
			new Requirement("Whale's Maw Deposit Box", 1), new Requirement("Arc journal teletabs", 1),
			new Requirement("Crystal tool siphon blueprint", 1), new Requirement("Impressing the Locals", 1)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_UPGRADING_ALL_OF_THE_WAIKO("Arc - Upgrading All of the Waiko", 0, Arrays.asList(new Requirement("Commodity sell per day increase", 2),
			new Requirement("Supplies cap increase", 4), new Requirement("Contracts per day increase", 4),
			new Requirement("Supplies cost reduction", 5), new Requirement("Commodity sell price increase", 2),
			new Requirement("Impressing the Locals", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_UPGRADING_WAIKO("Arc - Upgrading Waiko", 0, Arrays.asList(new Requirement("Commodity sell per day increase", 1),
			new Requirement("Supplies cap increase", 1), new Requirement("Contracts per day increase", 1),
			new Requirement("Supplies cost reduction", 1), new Requirement("Commodity sell price increase", 1),
			new Requirement("Impressing the Locals", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_SALTY("Arc - Salty", 0, Arrays.asList(new Requirement("Wushanko Isles: The Arc", 1), new Requirement("Arc - Rewards", 1),
			new Requirement("Arc - Unlocking Waiko", 1), new Requirement("Arc - Unlocking More Waiko", 1),
			new Requirement("Arc - Upgrading All of the Waiko", 1), new Requirement("Arc - Ancient Eastern Tortle Portals", 1),
			new Requirement("Arc - Mitts and Waders - Death Lotus", 1), new Requirement("Arc - Mitts and Waders - Tetsu", 1),
			new Requirement("Arc - Mitts and Waders - Seasinger", 1), new Requirement("Arc - Don't Crush My Memories", 1),
			new Requirement("Arc - Bone to Pick with You", 1), new Requirement("Arc - All Your Energies", 1),
			new Requirement("Arc - Flippers", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARC_III_SPIRITUAL_ENLIGHTENMENT("Arc III - Spiritual Enlightenment", 0.75, Arrays.asList(new Requirement("Impressing the Locals", 1),
			new Requirement("Meet the Assassin", 1), new Requirement("Slayer", 90), new Requirement("The Path of the Monk", 1),
			new Requirement("The Path of the Elemental", 1), new Requirement("The Path of the Dragon", 1)), new ArrayList<>(),
			Arrays.asList(new Reward("Chimes", 250), new Reward("Tajitu", 3), new Reward("Slayer", 18364)),
			new ArrayList<>(), true),
	ARC_II_HEAD_OF_THE_FAMILY("Arc II - Head of the Family", 0.75, Arrays.asList(new Requirement("Impressing the Locals", 1),
			new Requirement("Woodcutting", 90), new Requirement("Fishing", 90), new Requirement("Cooking", 91),
			new Requirement("Chimes", 450), new Requirement("Bamboo", 5), new Requirement("Fish oil", 15)),
			Collections.singletonList(new Encounter(Arrays.asList(Enemy.CAPN_EKAHI, Enemy.CYCLOPS_LABOURER, Enemy.CYCLOPS_LABOURER))),
			Arrays.asList(new Reward("Chimes", 1300), new Reward("Fish oil", 30), new Reward("Bundle of bamboo", 4),
					new Reward("Tajitu", 5), new Reward("Agility", 187)), new ArrayList<>(), true),
	ARC_I_FLAG_FALL("Arc I - Flag Fall", 0.5, Collections.singletonList(new Requirement("Impressing the Locals", 1)), new ArrayList<>(),
			Arrays.asList(new Reward("Chimes", 500), new Reward("Tajitu", 2)), new ArrayList<>(), true),
	ARC_IV_JED_HUNTER("Arc IV - Jed Hunter", 0.25, Arrays.asList(new Requirement("Flag Fall", 1), new Requirement("Spiritual Enlightenment", 1),
			new Requirement("Head of the Family", 1), new Requirement("Hunter", 90), new Requirement("Crafting", 91),
			new Requirement("Driftwood", 10), new Requirement("Sea shell", 5), new Requirement("Tortle shell bowl", 2),
			new Requirement("Tajitu", 1), new Requirement("Chimes", 200)), Arrays.asList(new Encounter(Collections.singletonList(Enemy.GU_RONIN)),
			new Encounter(Collections.singletonList(Enemy.GU_RONIN)), new Encounter(Collections.singletonList(Enemy.GU_RONIN))), Arrays.asList(new Reward("Chimes", 2000),
			new Reward("Tajitu", 10), new Reward("Hunter", 18364)), new ArrayList<>(), true),
	ARC_V_EYE_FOR_AN_EYE("Arc V - Eye for an Eye", 0.25, Arrays.asList(new Requirement("Jed Hunter", 1), new Requirement("Mining", 90),
			new Requirement("Sea salt", 30)), Collections.singletonList(new Encounter(Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS,
					Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS,
					Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS,
					Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS))), Arrays.asList(new Reward("Chimes", 250),
					new Reward("Tajitu", 1), new Reward("Alalea sea salt", 25), new Reward("Prayer", 187)),
			new ArrayList<>(), true),
	ARC_VI_HARBINGER_OF_DOOM("Arc VI - Harbinger of Doom", 0.25, Collections.singletonList(new Requirement("Eye for an Eye", 1)), new ArrayList<>(),
			Arrays.asList(new Reward("Chimes", 250), new Reward("Tajitu", 2), new Reward("Construction", 187)),
			new ArrayList<>(), true),
	ARC_IX_DAMAGE_CONTROL("Arc IX - Damage Control", 0.25, Arrays.asList(new Requirement("Harbinger", 1),
			new Requirement("Chimes", 2500)), new ArrayList<>(), Arrays.asList(new Reward("Chimes", 3000),
			new Reward("Tajitu", 2), new Reward("Thieving", 187)), new ArrayList<>(), true),
	ARC_VIII_GHOSTS_FROM_THE_PAST("Arc VIII - Ghosts from the Past", 0.25, Collections.singletonList(new Requirement("Harbinger", 1)),
			new ArrayList<>(), Arrays.asList(new Reward("Chimes", 500), new Reward("Tajitu", 2)),
			Collections.singletonList(new Lamp(Arrays.asList("Agility", "Herblore", "Fishing", "Thieving", "Cooking", "Prayer", "Runecrafting",
					"Slayer", "Construction", "Hunter", "Dungeoneering", "Divination"), 187, 1)), true),
	ARC_VII_TUAI_LETS_OWN("Arc VII - Tuai Let's Own", 0.5, Arrays.asList(new Requirement("Harbinger", 1), new Requirement("Farming", 86),
			new Requirement("Divination", 90), new Requirement("Rumberry", 30), new Requirement("Positive energy", 30),
			new Requirement("Spirit dragon charm", 1)), new ArrayList<>(), Arrays.asList(new Reward("Chimes", 500),
			new Reward("Tajitu", 2), new Reward("Rumberry", 50), new Reward("Ancestral energy", 50)), new ArrayList<>(), true),
	ARC_X_FINAL_DESTINATION("Arc X - Final Destination", 0.25, Arrays.asList(new Requirement("Tuai Let's Own", 1),
			new Requirement("Damage Control", 1), new Requirement("Ghosts from the Past", 1)),
			Collections.singletonList(new Encounter(Arrays.asList(Enemy.ZYCLOPS_CANNONEER, Enemy.ZYCLOPS_CANNONEER, Enemy.ZYCLOPS_CANNONEER,
					Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.SKELETON_UI,
					Enemy.SKELETON_UI, Enemy.ZYCLOPS_FD, Enemy.ZYCLOPS_FD))), Arrays.asList(new Reward("Chimes", 2000),
			new Reward("Tajitu", 10)), Collections.singletonList(new Lamp(Arrays.asList("Attack", "Constitution", "Defense",
			"Strength", "Ranged", "Prayer", "Magic", "Summoning"), 250, 1)), true),
	ARDOUGNE("Ardougne", 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARE_YOU_BEING_SERVED("Are You Being Served?", 0, new ArrayList<>(), new ArrayList<>(), Collections.singletonList(new Reward("Are You Being Served?", 1)),
			new ArrayList<>(), true),
	BARGAIN_HUNTER("Bargain Hunter", 0, new ArrayList<>(), new ArrayList<>(), Collections.singletonList(new Reward("Bargain Hunter", 1)),
			new ArrayList<>(), true),
	BOOT_CAMP("Boot Camp", 0, Collections.singletonList(new Requirement("Biohazard", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BREAKING_AND_ENTERING("Breaking and Entering", 0, Collections.singletonList(new Requirement("Thieving", 16)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ARDOUGNE_SET_TASKS_EASY("Ardougne Set Tasks - Easy", 0, Arrays.asList(new Requirement("The Essence of Magic", 1),
			new Requirement("Yoink!", 1), new Requirement("Silky Smooth", 1), new Requirement("Preaching to the Infected", 1),
			new Requirement("Playing the Waiting Game", 1), new Requirement("Gone Fishing", 1),
			new Requirement("Boot Camp", 1), new Requirement("A Cat is for Life...", 1),
			new Requirement("Creator and Destroyer", 1), new Requirement("Red Revolution", 1),
			new Requirement("Going on a Summer Holiday", 1), new Requirement("Breaking and Entering", 1),
			new Requirement("P-P-P-Pick Up Some Prizes", 1), new Requirement("A Gift from Khazard", 1),
			new Requirement("Party Pooper", 1), new Requirement("Vial Deeds", 1), new Requirement("Star Seeker", 1),
			new Requirement("Dukes of Khazard", 1), new Requirement("Don't Eat the Pointy Bit", 1),
			new Requirement("Bargain Hunter", 1), new Requirement("Are You Being Served?", 1),
			new Requirement("No Time to Lose", 1), new Requirement("They're Long and Pointy", 1)),
			new ArrayList<>(), new ArrayList<>(), Collections.singletonList(new Lamp(Player.ALL_SKILLS, 1000, 25)), true),
	ARDOUGE_SET_TASKS_ELITE("Ardougne Set Tasks - Elite", 0, Arrays.asList(new Requirement("Catching Some Rays", 1),
			new Requirement("Abyssal Valet", 1), new Requirement("You Could Just Knock", 1),
			new Requirement("Honestly, It's Not a Purse", 1), new Requirement("Almost Made in Ardougne", 1)),
			new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Lamp(Player.ALL_SKILLS, 50000, 85), new Lamp(Player.ALL_SKILLS, 50000, 85),
			new Lamp(Player.ALL_SKILLS, 50000, 85), new Lamp(Player.ALL_SKILLS, 50000, 85)), true),
	ARDOUGNE_SET_TASKS_HARD("Ardougne Set Tasks - Hard", 0, Arrays.asList(new Requirement("Brace Yourself", 1),
			new Requirement("Shadow Boxing", 1), new Requirement("Just Like That", 1),
			new Requirement("Nice View", 1), new Requirement("You're the Dirty Rascal", 1),
			new Requirement("Ourania Mania", 1), new Requirement("Not on My Watch", 1),
			new Requirement("It Just Croaked", 1), new Requirement("Get Your Stinking Hands Off Me", 1),
			new Requirement("Vine-detta", 1), new Requirement("Living on a Prayer", 1),
			new Requirement("Who Wants to Watch the Watchtower?", 1), new Requirement("Monkey Business", 1),
			new Requirement("It's My Newt", 1), new Requirement("A Taste of the Exotic", 1),
			new Requirement("Blood Bank Withdrawal", 1), new Requirement("Artillery Strike", 1)),
			new ArrayList<>(), new ArrayList<>(), Collections.singletonList(new Lamp(Player.ALL_SKILLS,28000, 60)), true),
	ARE_YOU_CHICKEN("Are You Chicken?", 0, Arrays.asList(new Requirement("Tower of Life", 1), new Requirement("Raw chicken", 1),
			new Requirement("Raw swordfish", 1)), Collections.singletonList(new Encounter(Collections.singletonList(Enemy.SWORDCHICK))),
			new ArrayList<>(), new ArrayList<>(), true),
	ARDOUGNE_SET_TASKS_MEDIUM("Ardougne Set Tasks - Medium", 0, Arrays.asList(new Requirement("A Visit to Charlie", 1),
			new Requirement("I Wonder What This Does", 1), new Requirement("Sandy's Secret Getaway", 1),
			new Requirement("I Know a Shortcut", 1), new Requirement("Volatile Valuables", 1),
			new Requirement("What, a Melon?", 1), new Requirement("Ardougne Express", 1),
			new Requirement("Arriving in Style", 1), new Requirement("By the Bucketload", 1),
			new Requirement("Meeting History, Again", 1), new Requirement("Fearless Fishing", 1),
			new Requirement("Water Logged", 1), new Requirement("Green Fingers", 1), new Requirement("A Natural Thief", 1),
			new Requirement("The Coal Train", 1), new Requirement("Are You Chicken?", 1)),
			new ArrayList<>(), new ArrayList<>(), Collections.singletonList(new Lamp(Player.ALL_SKILLS, 7500, 45)), true),
	ARE_YOU_NEEDING_ACCESS("Are You Needing Access?", 0, Arrays.asList(new Requirement("Do No Evil", 1),
			new Requirement("Agility", 80)), new ArrayList<>(), Collections.singletonList(new Reward("Agility", 20000)),
			new ArrayList<>(), true),
	ARISE_FROM_THE_ASH("Arise from the Ash", 0, Arrays.asList(new Requirement("In Pyre Need", 1), new Requirement("Phoenix Lair", 1)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	AROUND_THE_WORLD_IN_SIX_WAYS("Around the World in Six Ways", 0, Collections.singletonList(new Requirement("Balloon transport system routes", 6)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	AS_TAXED_AS_A_YAK("As Taxed as a Yak", 0, Arrays.asList(new Requirement("The Fremennik Isles", 1), new Requirement("Coins", 5000)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	AS_CLEAR_AS_A_CRYSTAL_SEED("As Clear as a Crystal Seed", 0, Collections.singletonList(new Requirement("Within the Light", 1)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ASHDALE("Ashdale", 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	ATTACK_SIFU("Attack - Sifu", 0, Collections.singletonList(new Requirement("Sifu", 1)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_5("Attack 5", 0, Collections.singletonList(new Requirement("Attack", 5)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_10("Attack 10", 0, Collections.singletonList(new Requirement("Attack", 10)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_20("Attack 20", 0, Collections.singletonList(new Requirement("Attack", 20)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_30("Attack 30", 0, Collections.singletonList(new Requirement("Attack", 30)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_40("Attack 40", 0, Collections.singletonList(new Requirement("Attack", 40)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_50("Attack 50", 0, Collections.singletonList(new Requirement("Attack", 50)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_60("Attack 60", 0, Collections.singletonList(new Requirement("Attack", 60)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_70("Attack 70", 0, Collections.singletonList(new Requirement("Attack", 70)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_80("Attack 80", 0, Collections.singletonList(new Requirement("Attack", 80)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_90("Attack 90", 0, Collections.singletonList(new Requirement("Attack", 90)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_92("Attack 92", 0, Collections.singletonList(new Requirement("Attack", 92)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	ATTACK_99("Attack 99", 0, Collections.singletonList(new Requirement("Attack", 99)), new ArrayList<>(), new ArrayList<>(),
			new ArrayList<>(), true),
	AVA("Ava", 0, Collections.singletonList(new Requirement("Ava", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	AZACORAXS_REWARDS("Azacorax's Rewards", 0, Arrays.asList(new Requirement("Rune Memories", 1), new Requirement("Magic", 50),
			new Requirement("Prayer", 50)), new ArrayList<>(), new ArrayList<>(), Collections.singletonList(new Lamp(Arrays.asList("Magic", "Prayer"),
			10000, 50)), true),
	AZDARAN_BIRTHRIGHT("Azdaran Birthright", 0, Collections.singletonList(new Requirement("Azdaran fragment", 10)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BANDIT_CAMP("Bandit Camp", 0, Collections.singletonList(new Requirement("Desert Treasure", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BANDOSS_MEMORIES("Bandos's Memories", 0, Collections.singletonList(new Requirement("Bandos chronicles", 13)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BANE_TUNER("Bane Tuner", 0, Collections.singletonList(new Requirement("Tune Bane Ore", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BANK_Z("Bank-Z", 0, Collections.singletonList(new Requirement("Dimension of Disaster: Curse of Arrav", 1)), new ArrayList<>(),
			Collections.singletonList(new Reward("Zemomark", 30)), new ArrayList<>(), true),
	BANKING_HISTORY("Banking History", 0, Collections.singletonList(new Requirement("Enchanted key miniquest", 2)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BARBARIAN_SCAVENGER("Barbarian Scavenger", 0, Collections.singletonList(new Requirement("Ancient page", 26)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BAROO_QUALITY("Baroo Quality", 0, Arrays.asList(new Requirement("Yak-hide armour (top)", 1), new Requirement("Yak-hide armour (legs)", 1),
			new Requirement("Fremennik round shield", 1)), Collections.singletonList(new Encounter(Collections.singletonList(Enemy.DAGANNOTH_SUPREME))),
			new ArrayList<>(), new ArrayList<>(), true),
	BARROWED_POWER_I("Barrowed Power I", 0, Collections.singletonList(new Requirement("Rise of the Six", 5)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BARROWED_POWER_II("Barrowed Power II", 0, Collections.singletonList(new Requirement("Rise of the Six", 10)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BARROWED_POWER_III("Barrowed Power III", 0, Collections.singletonList(new Requirement("Rise of the Six", 25)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BARROWED_POWER_IV("Barrowed Power IV", 0, Collections.singletonList(new Requirement("Rise of the Six", 50)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BARROWED_POWER_V("Barrowed Power V", 0, Collections.singletonList(new Requirement("Rise of the Six", 75)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BARROWED_POWER_VI("Barrowed Power VI", 0, Collections.singletonList(new Requirement("Rise of the Six", 100)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BARROWED_TIME("Barrowed Time", 0, Collections.singletonList(new Requirement("Barrows uniques", 38)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BARRY("Barry", 0, Collections.singletonList(new Requirement("Barry", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BEGGARS_CANT_BE_CHOOSERS("Beggars Can't Be Choosers", 0.05, Arrays.asList(new Requirement("In Aid of the Myreque", 1),
			new Requirement("Great maki", 1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	BEHEMOTH_NOTES("Behemoth Notes", 0, Collections.singletonList(new Requirement("Behemoth notes", 5)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BEST_OFFENCE("Best Offence", 0, new ArrayList<>(), Collections.singletonList(new Encounter(Collections.singletonList(Enemy.KALPHITE_KING))),
			new ArrayList<>(), new ArrayList<>(), true),
	BETTER_NOT_TOUCH("Better Not Touch", 0, Collections.singletonList(new Requirement("Beastmaster Durzag", 1)), Collections.singletonList(new Encounter(
			Arrays.asList(Enemy.YAKAMARU, Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU))), new ArrayList<>(),
			new ArrayList<>(), true),
	BIG_CHINCHOMPA("Big Chinchompa", 0.25, Collections.singletonList(new Requirement("Hunter", 78)), new ArrayList<>(),
			Collections.singletonList(new Reward("Competence points", 1111)), new ArrayList<>(), true),
	BIPEDAL_MASK("Bipedal Mask", 0, Collections.singletonList(new Requirement("Tuska mask", 1)), new ArrayList<>(),
			new ArrayList<>(), Collections.singletonList(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic"), 43680, 90)), true),
	BIRD_IS_THE_WORD_I("Bird is the Word I", 0, Collections.singletonList(new Requirement("Kree'arra", 5)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRD_IS_THE_WORD_II("Bird is the Word II", 0, Collections.singletonList(new Requirement("Kree'arra", 10)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRD_IS_THE_WORD_III("Bird is the Word III", 0, Collections.singletonList(new Requirement("Kree'arra", 25)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRD_IS_THE_WORD_IV("Bird is the Word IV", 0, Collections.singletonList(new Requirement("Kree'arra", 50)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRD_IS_THE_WORD_V("Bird is the Word V", 0, Collections.singletonList(new Requirement("Kree'arra", 75)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRD_IS_THE_WORD_VI("Bird is the Word VI", 0, Collections.singletonList(new Requirement("Kree'arra", 100)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRDSTRIKE_I("Birdstrike I", 0, Collections.singletonList(new Requirement("Kree'arra (HM)", 5)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRDSTRIKE_II("Birdstrike II", 0, Collections.singletonList(new Requirement("Kree'arra (HM)", 10)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRDSTRIKE_III("Birdstrike III", 0, Collections.singletonList(new Requirement("Kree'arra (HM)", 25)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRDSTRIKE_IV("Birdstrike IV", 0, Collections.singletonList(new Requirement("Kree'arra (HM)", 50)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRDSTRIKE_V("Birdstrike V", 0, Collections.singletonList(new Requirement("Kree'arra (HM)", 75)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BIRDSTRIKE_VI("Birdstrike VI", 0, Collections.singletonList(new Requirement("Kree'arra (HM)", 100)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BLACKOUT("Blackout", 0, Collections.singletonList(new Requirement("Queen Black Dragon uniques", 12)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BLINDED_BY_RAMARNOS_TEACHING("Blinded by Ramarno's Teaching", 0, Arrays.asList(new Requirement("Defender of Varrock", 1),
			new Requirement("Redberry pie", 1)), new ArrayList<>(), Collections.singletonList(new Reward("Smithing", 1000)),
			new ArrayList<>(), true),
	BLOOD_STAINED_TREASURE("Blood Stained Treasure", 0.05, Collections.singletonList(new Requirement("Legacy of Seergaze", 1)),
			new ArrayList<>(), Collections.singletonList(new Reward("Blood rune", 100)), new ArrayList<>(), true),
	BOMBI("Bombi", 0, Collections.singletonList(new Requirement("Bombi", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BONE_I_FIRED("Bone I Fired", 0, Arrays.asList(new Requirement("Zanik's crossbow", 1), new Requirement("Bone bolt", 2),
			new Requirement("Rag and Bone Man wish list", 1), new Requirement("Fur'n'Seek wish list", 1),
			new Requirement("Ranged", 48)), Collections.singletonList(new Encounter(Arrays.asList(Enemy.SKELETAL_HORROR_PHASE_1,
			Enemy.SKELETAL_HORROR_PHASE_2, Enemy.SKELETAL_HORROR_PHASE_3, Enemy.SKELETAL_HORROR_PHASE_4))), Arrays.asList(new Reward("Slayer", 10000),
			new Reward("Prayer", 7000)), new ArrayList<>(), true),
	BOVINE_INTERVENTION("Bovine Intervention", 0, Collections.singletonList(new Requirement("Cow", 1)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BOYS_TO_MENAPHITES("Boys to Menaphites", 0, Collections.singletonList(new Requirement("Menaphos reputation", 330000)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	BRASS_NEX_I("Brass Nex I", 0, Collections.singletonList(new Requirement("Nex", 5)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BRASS_NEX_II("Brass Nex II", 0, Collections.singletonList(new Requirement("Nex", 10)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BRASS_NEX_III("Brass Nex III", 0, Collections.singletonList(new Requirement("Nex", 25)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BRASS_NEX_IV("Brass Nex IV", 0, Collections.singletonList(new Requirement("Nex", 50)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BRASS_NEX_V("Brass Nex V", 0, Collections.singletonList(new Requirement("Nex", 75)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BRASS_NEX_VI("Brass Nex VI", 0, Collections.singletonList(new Requirement("Nex", 100)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	BRIDGE_OVER_FREMMY_WATERS("Bridge over Fremmy Waters", 0, Collections.singletonList(new Requirement("Unabridged Fremennik sagas", 5)),
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true),
	BRING_IT_ALL_BACK("Bring It All Back", 0, Arrays.asList(new Requirement("Ranged", 80), new Requirement("Blade of Avaryss", 1),
			new Requirement("Blade of Nymora", 1), new Requirement("Attack", 85)),
			Collections.singletonList(new Encounter(Collections.singletonList(Enemy.TWIN_FURIES))), new ArrayList<>(), new ArrayList<>(), true),
	BROTHERS_GOWER("Brothers Gower", 0, Collections.singletonList(new Requirement("Gower lamp", 3)), new ArrayList<>(),
			new ArrayList<>(), new ArrayList<>(), true),
	;
	/* Quests
	COOKS_ASSISTANT("Cook's Assistant", 0.25, new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Reward("Cooking", 300),
			new Reward("Quest Points", 1), new Reward("Coins", 500), new Reward("Sardine", 20)), new ArrayList<>(), true),
	WATERFALL_QUEST("Waterfall Quest", 0.75, Arrays.asList(new Requirement("Air rune", 6), new Requirement("Water rune", 6),
			new Requirement("Earth rune", 6), new Requirement("Rope", 1)), new ArrayList<>(),
			Arrays.asList(new Reward("Quest Points", 1), new Reward("Attack", 13750),
					new Reward("Strength", 13750), new Reward("Gold bar", 2), new Reward("Diamond", 2),
					new Reward("Mithril seeds", 40)), new ArrayList<>(), true),
	CLOCK_TOWER("Clock Tower", 0.25, new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Coins", 500)), new ArrayList<>(), true),
	THE_RESTLESS_GHOST("The Restless Ghost", 0.25, new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Prayer", 1125)), new ArrayList<>(), true),
	MISSING_PRESUMED_DEATH("Missing, Presumed Death", 1, new ArrayList<>(), Arrays.asList(new Encounter(Arrays.asList(Enemy.WIGHT, Enemy.WIGHT, Enemy.WIGHT,
			Enemy.WIGHT)), new Encounter(Arrays.asList(Enemy.WIGHT_FOOTSOLDIER, Enemy.WIGHT_RANGER, Enemy.WIGHT_RANGER, Enemy.WIGHT_FOOTSOLDIER, Enemy.WIGHT_FOOTSOLDIER,
			Enemy.WIGHT_FOOTSOLDIER, Enemy.WIGHT_FOOTSOLDIER))), Arrays.asList(new Reward("Quest Points", 2),
			new Reward("Prayer", 500), new Reward("Agility", 1000)),
			Collections.singletonList(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Magic", "Ranged"), 1500)), true),
	MERLINS_CRYSTAL("Merlin's Crystal", 0.75, new ArrayList<>(), Collections.singletonList(new Encounter(Collections.singletonList(Enemy.SIR_MORDRED))),
			Arrays.asList(new Reward("Quest Points", 6), new Reward("Excalibur", 1),
					new Reward("Merlin's Crystal", 1)), new ArrayList<>(), true),
	HOLY_GRAIL("Holy Grail", 0.5, Arrays.asList(new Requirement("Merlin's Crystal", 1), new Requirement("Attack", 30),
			new Requirement("Excalibur", 1)), Collections.singletonList(new Encounter(Collections.singletonList(Enemy.BLACK_KNIGHT_TITAN))),
			Arrays.asList(new Reward("Quest Points", 2), new Reward("Prayer", 11000),
					new Reward("Defense", 15300)), new ArrayList<>(), true),
	PLAGUE_CITY("Plague City", 0.5, Arrays.asList(new Requirement("Dwellberries", 1), new Requirement("Rope", 1),
			new Requirement("Chocolate dust", 1), new Requirement("Snape grass", 1),
			new Requirement("Bucket of milk", 1)), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Mining", 2425), new Reward("Plague City", 1)), new ArrayList<>(), true),
	TREE_GNOME_VILLAGE("Tree Gnome Village", 0.75, Collections.singletonList(new Requirement("Logs", 5)),
			Collections.singletonList(new Encounter(Collections.singletonList(Enemy.KHAZARD_WARLORD))), Arrays.asList(new Reward("Attack", 11450),
			new Reward("Quest Points", 2)), new ArrayList<>(), true),
	HAZEEL_CULT("Hazeel Cult", 0.25, new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1), new Reward("Thieving", 1500),
			new Reward("Coins", 2005)), new ArrayList<>(), true),
	DRUIDIC_RITUAL("Druidic Ritual", 0.25, Collections.singletonList(new Requirement("Coins", 1)), new ArrayList<>(),
			Arrays.asList(new Reward("Quest Points", 4), new Reward("Herblore", 250), new Reward("Grimy guam", 15),
					new Reward("Eye of newt", 15)), new ArrayList<>(), true),
	RECRUITMENT_DRIVE("Recruitment Drive", 0.75, Collections.singletonList(new Requirement("Herblore", 3)),
			Collections.singletonList(new Encounter(Collections.singletonList(Enemy.SIR_LEYE))), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Recruitment Drive", 1)), new ArrayList<>(), true),
	RECRUITMENT_DRIVE_PRAYER_LAMP("Recruitment Drive prayer lamp", 0, Arrays.asList(new Requirement("Recruitment Drive", 1), new Requirement("Prayer", 8)),
			new ArrayList<>(), Collections.singletonList(new Reward("Prayer", 1000)), new ArrayList<>(), false),
	RECRUITMENT_DRIVE_HERBLORE_LAMP("Recruitment Drive herblore lamp", 0, Arrays.asList(new Requirement("Recruitment Drive", 1),
			new Requirement("Herblore", 8)), new ArrayList<>(), Collections.singletonList(new Reward("Herblore", 1000)), new ArrayList<>(), false),
	RECRUITMENT_DRIVE_AGILITY_LAMP("Recruitment Drive agility lamp", 0, Arrays.asList(new Requirement("Recruitment Drive", 1),
			new Requirement("Agility", 8)), new ArrayList<>(), Collections.singletonList(new Reward("Agility", 1000)), new ArrayList<>(), false),
	BUY_A_PLAYER_OWNED_HOUSE("Buy a player-owned house", 0, Collections.singletonList(new Requirement("Coins", 1000)),
			new ArrayList(), Collections.singletonList(new Reward("Player-owned house", 1)), new ArrayList<>(), false),
	BUILD_A_PARLOUR("Build a parlour", 0, Arrays.asList(new Requirement("Player-owned house", 1), new Requirement("Coins", 1000)),
			new ArrayList(), Collections.singletonList(new Reward("Parlour", 1)), new ArrayList<>(), false),
	STOLEN_HEARTS("Stolen Hearts", 1, new ArrayList<>(), Collections.singletonList(new Encounter(Arrays.asList(Enemy.SKULLS_MERCENARY, Enemy.SKULLS_MERCENARY, Enemy.SKULLS_MERCENARY))),
			Arrays.asList(new Reward("Quest Points", 3), new Reward("Coins", 2500), new Reward("Constitution", 250),
			new Reward("Agility", 250), new Reward("Thieving", 250), new Reward("Stolen Hearts", 1)),
			Collections.singletonList(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Magic", "Constitution", "Ranged", "Prayer"), 250)), true),
	DIAMOND_IN_THE_ROUGH("Diamond in the Rough", 1, Collections.singletonList(new Requirement("Stolen Hearts", 1)),
			Arrays.asList(new Encounter(Arrays.asList(Enemy.BANDIT, Enemy.BANDIT, Enemy.BANDIT_KING)), new Encounter(Arrays.asList(Enemy.APEP, Enemy.HERU))),
			Arrays.asList(new Reward("Diamond in the Rough", 1), new Reward("Quest Points", 1), new Reward("Agility", 250),
					new Reward("Thieving", 250), new Reward("Constitution", 250), new Reward("Sapphire", 1),
					new Reward("Emerald", 1), new Reward("Ruby", 1)), Collections.singletonList(new Lamp(Arrays.asList("Attack",
			"Strength", "Defense", "Magic", "Constitution", "Ranged", "Prayer"), 250)), true),
	THE_JACK_OF_SPADES("The Jack of Spades", 0.5, Collections.singletonList(new Requirement("Diamond in the Rough", 1)),
			new ArrayList(), Arrays.asList(new Reward("The Jack of Spades", 1), new Reward("Quest Points", 1),
			new Reward("Agility", 500), new Reward("Construction", 500), new Reward("Dungeoneering", 500),
			new Reward("Thieving", 500)), new ArrayList<>(), true),
	WITCHS_HOUSE("Witch's House", 0.25, new ArrayList<>(), Collections.singletonList(new Encounter(Arrays.asList(Enemy.WITCHS_EXPERIMENT_1,
			Enemy.WITCHS_EXPERIMENT_2, Enemy.WITCHS_EXPERIMENT_3, Enemy.WITCHS_EXPERIMENT_4))), Arrays.asList(new Reward("Quest Points", 4),
			new Reward("Constitution", 6325)), new ArrayList<>(), true),
	RUNE_MYSTERIES("Rune Mysteries", 1, new ArrayList(), new ArrayList(), Arrays.asList(new Reward("Rune Mysteries", 1),
			new Reward("Magic", 250), new Reward("Runecrafting", 250), new Reward("Quest Points", 1),
			new Reward("Tower mindspike", 1), new Reward("First tower hat", 1), new Reward("Air talisman", 1),
			new Reward("Mind rune", 70)), new ArrayList<>(), true),
	GERTRUDES_CAT("Gertrude's Cat", 0.75, Arrays.asList(new Requirement("Raw sardine", 1), new Requirement("Bucket of milk", 1),
			new Requirement("Coins", 100)), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Kitten", 1), new Reward("Chocolate cake", 1), new Reward("Stew", 1),
			new Reward("Gertrude's Cat", 1)), new ArrayList<>(), true),
	GERTRUDES_CAT_LAMP("Gertrude's Cat Lamp", 0, Arrays.asList(new Requirement("Gertrude's Cat", 1), new Requirement("Cooking", 14)),
			new ArrayList<>(), Collections.singletonList(new Reward("Cooking", 1525)), new ArrayList<>(), false),;*/

	private String name; //name of the task
	private double time; //est. time taken in hours [not including time to gather items/complete requirements]
	private List<Requirement> reqs; //list of requirements
	private List<Encounter> encounters; //list of combat encounters
	private List<Reward> rewards; //list of static rewards
	private List<Lamp> lamps; //list of lamps
	private boolean display; //if task is a "true" achievement, and should be displayed on the task list
	
	Achievement(String name, double time, List<Requirement> reqs, List<Encounter> encounters, List<Reward> rewards, List<Lamp> lamps, boolean display)
	{
		this.name = name;
		this.time = time;
		this.reqs = reqs;
		this.encounters = encounters;
		this.rewards = rewards;
		this.lamps = lamps;
		this.display = display;
	}

	public GoalResults getTimeForRequirements(Player player) {
		double totalTimeForAllReqs = 0;
		Map<String,Double> totalActionsWithTimesForAllReqs = new HashMap<>();
		List<Requirement> recursiveRequirements = new ArrayList<>();
		Map<String,Double> originalMap = player.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		List<Weapon> weaponList = new ArrayList<>(player.getWeapons());
		for (Requirement r : reqs) {
			GoalResults resultsForOneRequirement = r.timeAndActionsToMeetRequirement(player);
			for (Entry<String,Double> actionWithTime : resultsForOneRequirement.getActionsWithTimes().entrySet()) {
				if (Achievement.getAchievementByName(actionWithTime.getKey()) == null || !totalActionsWithTimesForAllReqs.containsKey(actionWithTime.getKey())) {
					totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), actionWithTime.getValue());
					totalTimeForAllReqs += actionWithTime.getValue();
				}
			}
			recursiveRequirements.addAll(resultsForOneRequirement.getRequirements());
			if (Player.ALL_SKILLS.contains(r.getQualifier())) {
				player.getXp().put(r.getQualifier(), player.getXp().get(r.getQualifier()) + player.getXpToLevel(r.getQualifier(), r.getQuantifier()));
			}
			if (Weapon.getWeaponByName(r.getQualifier()) != null) {
				player.addWeapon(Weapon.getWeaponByName(r.getQualifier()));
			}
		}
		for (Requirement r : recursiveRequirements) {
			if (Player.ALL_SKILLS.contains(r.getQualifier())) {
				player.getXp().put(r.getQualifier(), player.getXp().get(r.getQualifier()) + player.getXpToLevel(r.getQualifier(), r.getQuantifier()));
			}
		}
		for (Encounter e : encounters) {
			CombatResults meleeCombatResults = e.calculateCombat(player,27, "Melee");
			CombatResults rangedCombatResults = e.calculateCombat(player,27, "Ranged");
			CombatResults magicCombatResults = e.calculateCombat(player,27, "Magic");
			if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000){
				//System.out.println("Time to update the combat simulator");
				totalTimeForAllReqs += 9001.0;
			}
		}
		player.setXp(originalMap);
		player.setWeapons(weaponList);
		return new GoalResults(totalTimeForAllReqs, recursiveRequirements, totalActionsWithTimesForAllReqs);
	}

	public double getGainFromRewards(Player player) {
		double totalGainFromAllRewards = 0;
		for (Reward r : rewards) {
			totalGainFromAllRewards += r.getGainFromReward(player);
		}
		for (Lamp lamp : lamps) {
			try {
				totalGainFromAllRewards += lamp.getBestReward(player).getGainFromReward(player);
			}
			catch (NullPointerException e) { //can't access lamp yet
				totalGainFromAllRewards -= 1000000000;
			}
		}
		for (Encounter e : encounters) {
			for (Enemy enemy : e.getEnemies())
			totalGainFromAllRewards += player.efficientGoalCompletion("Constitution", (int)enemy.getHpxp()).getTotalTime();
			//totalGainFromAllRewards += player.getActionDatabase().bestEffectiveRate("Combat", player);
		}
		return totalGainFromAllRewards;
	}

	public String getName() {
		return name;
	}

	public double getTime() {
		return time;
	}

	public List<Requirement> getReqs() {
		return reqs;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public List<Lamp> getLamps() {
		return lamps;
	}

	public boolean isDisplay() {
		return display;
	}

	public static Achievement getAchievementByName(String name) {
		for (Achievement a : values()) {
			if (a.getName().equals(name))
				return a;
		}
		return null;
	}
}