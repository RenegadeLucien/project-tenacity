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
    /*This lists not only achievements, but all non-repeatables.
    TODO: put list in topological order of requirements (all achievements are listed after their prerequisites.)*/
    AVOIDING_CONFLICT(new AchievementBuilder("A-Voiding Conflict", 0.05, true).requirement(new Requirement("Combat", 35))),
    A_CAT_IS_FOR_LIFE(new AchievementBuilder("A Cat is for Life...", 0, true).requirement(new Requirement("Plague City", 1))
        .requirement(new Requirement("Gertrude's Cat", 1)).requirement(new Requirement("Cat", 1))),
    A_GAME_OF_TOMBS_I(new AchievementBuilder("A Game of Tombs I", 0, true).requirement(new Requirement("Shifting Tombs", 1))),
    A_GAME_OF_TOMBS_II(new AchievementBuilder("A Game of Tombs II", 0, true).requirement(new Requirement("Shifting Tombs", 10))),
    A_GAME_OF_TOMBS_III(new AchievementBuilder("A Game of Tombs III", 0, true).requirement(new Requirement("Shifting Tombs", 50))),
    A_GAME_OF_TOMBS_IV(new AchievementBuilder("A Game of Tombs IV", 0, true).requirement(new Requirement("Shifting Tombs", 100))),
    A_GAME_OF_TOMBS_V(new AchievementBuilder("A Game of Tombs V", 0, true).requirement(new Requirement("Shifting Tombs", 200))),
    A_GIFT_FROM_KHAZARD(new AchievementBuilder("A Gift From Khazard", 0, true)),
    A_WIZARD_DID_IT(new AchievementBuilder("A Wizard Did It", 0, true)),
    A_WORLD_IN_MICROCOSM(new AchievementBuilder("A World In Microcosm", 0, true)),
    ABYSSAL_REACH(new AchievementBuilder("Abyssal Reach", 0.25, true).requirement(new Requirement("Rune Mysteries", 1))
        .reward(new Reward("Runecrafting", 1000))),
    ABYSSAL_VALET(new AchievementBuilder("Abyssal Valet", 0, true).requirement(new Requirement("Abyssal titan pouch", 1))
        .requirement(new Requirement("Summoning", 93)).requirement(new Requirement("Pure essence", 2)).reward(new Reward("Summoning", 2))),
    ADVANCED_SWEEPING(new AchievementBuilder("Advanced Sweeping", 0, true).requirement(new Requirement("Broomstick enchantments", 5))),
    ADVENTURERS_LOG(new AchievementBuilder("Adventurer's Log", 0, true).reward(new Reward("Logs", 1)).reward(new Reward("Woodcutting", 25))),
    AERECKS_OLD_BONES(new AchievementBuilder("Aereck's Old Bones", 0, true).requirement(new Requirement("The Restless Ghost", 1))),
    AGILE_FROM_HEAD_TO_TOE(new AchievementBuilder("Agile from Head to Toe", 0, true).requirement(new Requirement("Agile top", 1))
        .requirement(new Requirement("Agile legs", 1))),
    AGILITY_DOJO_MOJO(new AchievementBuilder("Agility - Dojo Mojo", 0, true).requirement(new Requirement("Dojo Mojo", 1))),
    AGILITY_5(new AchievementBuilder("Agility 5", 0, true).requirement(new Requirement("Agility", 5))),
    AGILITY_10(new AchievementBuilder("Agility 10", 0, true).requirement(new Requirement("Agility", 10))),
    AGILITY_20(new AchievementBuilder("Agility 20", 0, true).requirement(new Requirement("Agility", 20))),
    AGILITY_30(new AchievementBuilder("Agility 30", 0, true).requirement(new Requirement("Agility", 30))),
    AGILITY_40(new AchievementBuilder("Agility 40", 0, true).requirement(new Requirement("Agility", 40))),
    AGILITY_50(new AchievementBuilder("Agility 50", 0, true).requirement(new Requirement("Agility", 50))),
    AGILITY_60(new AchievementBuilder("Agility 60", 0, true).requirement(new Requirement("Agility", 60))),
    AGILITY_70(new AchievementBuilder("Agility 70", 0, true).requirement(new Requirement("Agility", 70))),
    AGILITY_80(new AchievementBuilder("Agility 80", 0, true).requirement(new Requirement("Agility", 80))),
    AGILITY_90(new AchievementBuilder("Agility 90", 0, true).requirement(new Requirement("Agility", 90))),
    AGILITY_92(new AchievementBuilder("Agility 92", 0, true).requirement(new Requirement("Agility", 92))),
    AGILITY_99(new AchievementBuilder("Agility 99", 0, true).requirement(new Requirement("Agility", 99))),
    AHRIM_BOBBLEHEAD(new AchievementBuilder("Ahrim Bobblehead", 0, true).requirement(new Requirement("Ahrim the Bobbled", 1))),
    AL_KHARID(new AchievementBuilder("Al Kharid", 0, true)),
    ALI_THE_TRADER(new AchievementBuilder("Ali The Trader", 0, true).requirement(new Requirement("Rogue Trader parts", 3))),
    ALL_ABOARD(new AchievementBuilder("All Aboard", 0, true).requirement(new Requirement("Ranged", 70))
        .encounter(new Encounter(Enemy.KREEARRA))),
    ALL_RISE(new AchievementBuilder("All Rise", 0, true).requirement(new Requirement("Court Cases", 16))),
    ALL_TOGETHER_NOW(new AchievementBuilder("All Together Now", 0, true).requirement(new Requirement("Beastmaster Durzag", 1))
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU), Arrays.asList(Enemy.IMAGE_OF_YAKAMARU,
            Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU))))),
    ALMOST_MADE_IN_ARDOUGNE(new AchievementBuilder("Almost Made In Ardougne", 0, true).requirement(new Requirement("Yew logs", 1))
        .requirement(new Requirement("Raw beef", 1)).requirement(new Requirement("Rune bar", 1))
        .requirement(new Requirement("Smithing", 91)).requirement(new Requirement("Fletching", 69))
        .requirement(new Requirement("Crafting", 10)).reward(new Reward("Rune crossbow", 1)).reward(new Reward("Cooking", 3))
        .reward(new Reward("Fletching", 100)).reward(new Reward("Smithing", 75)).reward(new Reward("Crafting", 15))),
    ALMOST_AS_PERKY_AS_A_PRAWN(new AchievementBuilder("Almost as Perky as a Prawn", 0, true)
        .requirement(new Requirement("Prawn perk", 15))),
    ALONG_CAME_A_SPIDER_I(new AchievementBuilder("Along Came A Spider I", 0, true).requirement(new Requirement("Araxxi", 5))),
    ALONG_CAME_A_SPIDER_II(new AchievementBuilder("Along Came A Spider II", 0, true).requirement(new Requirement("Araxxi", 10))),
    ALONG_CAME_A_SPIDER_III(new AchievementBuilder("Along Came A Spider III", 0, true).requirement(new Requirement("Araxxi", 25))),
    ALONG_CAME_A_SPIDER_IV(new AchievementBuilder("Along Came A Spider IV", 0, true).requirement(new Requirement("Araxxi", 50))),
    ALONG_CAME_A_SPIDER_V(new AchievementBuilder("Along Came A Spider V", 0, true).requirement(new Requirement("Araxxi", 75))),
    ALONG_CAME_A_SPIDER_VI(new AchievementBuilder("Along Came A Spider VI", 0, true).requirement(new Requirement("Araxxi", 100))),
    ALTAR_EXPLORER(new AchievementBuilder("Altar Explorer", 0.3, true).requirement(new Requirement("Runecrafting", 50))),
    ANGS_OFF_MY_RING(new AchievementBuilder("Angs off my Ring", 0, true).requirement(new Requirement("Ancient elven wedding ring", 1))),
    ANIMAL_CRUELTY(new AchievementBuilder("Animal Cruelty", 0, true).encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT,
        Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT,
            Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER,
            Enemy.CHARGER, Enemy.CORMES), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT,
            Enemy.AIRUT), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG))))),
    ANNIHILATOR(new AchievementBuilder("Annihilator", 0, true).requirement(new Requirement("Fate of the Gods", 1))
        .encounter(new Encounter(Collections.singletonList(Arrays.asList(Enemy.SMOKE_NIHIL, Enemy.SHADOW_NIHIL,
            Enemy.BLOOD_NIHIL, Enemy.ICE_NIHIL)), new ArrayList<>()))),
    ANY_ODD_CHICKEN(new AchievementBuilder("Any Odd Chicken", 0, true).requirement(new Requirement("Ernest the Chicken", 1))),
    APE_AHOLLOW(new AchievementBuilder("Ape A'hollow", 0.05, true).requirement(new Requirement("Fairy Tale Part III", 1))
        .requirement(new Requirement("Monkey Madness", 1)).requirement(new Requirement("Agility", 48))),
    ARC_ALL_YOUR_ENERGIES(new AchievementBuilder("Arc - All Your Energies", 0, true).requirement(new Requirement("Chimes", 5000))
        .requirement(new Requirement("Tajitu", 5)).requirement(new Requirement("Impressing the Locals", 1))),
    ARC_ANCIENT_EASTERN_TORTLE_PORTALS(new AchievementBuilder("Arc - Ancient Eastern Tortle Portals", 0.05, true)
        .requirement(new Requirement("Divination", 90)).requirement(new Requirement("Ancestral energy", 100))
        .requirement(new Requirement("Impressing the Locals", 1))),
    ARC_BONE_TO_PICK_WITH_YOU(new AchievementBuilder("Arc - Bone to Pick with You", 0, true).requirement(new Requirement("Chimes", 25000))
        .requirement(new Requirement("Tajitu", 25)).requirement(new Requirement("Impressing the Locals", 1))
        .requirement(new Requirement("Bonecrusher", 1))),
    ARC_DONT_CRUSH_MY_MEMORIES(new AchievementBuilder("Arc - Don't Crush My Memories", 0, true).requirement(new Requirement("Chimes", 5000))
        .requirement(new Requirement("Tajitu", 5)).requirement(new Requirement("Impressing the Locals", 1))),
    ARC_FLIPPERS(new AchievementBuilder("Arc - Flippers", 0, true).requirement(new Requirement("Impressing the Locals", 1))
        .requirement(new Requirement("Raw tarpon", 1))),
    ARC_MITTS_AND_WADERS_DEATH_LOTUS(new AchievementBuilder("Arc - Mitts and Waders - Death Lotus", 0, true)
        .requirement(new Requirement("Chimes", 5000)).requirement(new Requirement("Tajitu", 6))
        .requirement(new Requirement("Impressing the Locals", 1))),
    ARC_MITTS_AND_WADERS_SEASINGER(new AchievementBuilder("Arc - Mitts and Waders - Seasinger", 0, true)
        .requirement(new Requirement("Chimes", 5000)).requirement(new Requirement("Tajitu", 6))
        .requirement(new Requirement("Impressing the Locals", 1))),
    ARC_MITTS_AND_WADERS_TETSU(new AchievementBuilder("Arc - Mitts and Waders - Tetsu", 0, true)
        .requirement(new Requirement("Chimes", 5000)).requirement(new Requirement("Tajitu", 6))
        .requirement(new Requirement("Impressing the Locals", 1))),
    ARC_REWARDS(new AchievementBuilder("Arc - Rewards", 0, true).requirement(new Requirement("Impressing the Locals", 1))
        .requirement(new Requirement("Birds of the Arc", 1)).requirement(new Requirement("Berries of the Arc", 1))
        .requirement(new Requirement("Kami", 16)).reward(new Reward("Hunter", 50000))),
    ARC_UNLOCKING_MORE_WAIKO(new AchievementBuilder("Arc - Unlocking More Waiko", 0, true)
        .requirement(new Requirement("Sojobo contract guru", 1)).requirement(new Requirement("Ancestral Divination I", 1))
        .requirement(new Requirement("Ancestral Divination II", 1)).requirement(new Requirement("Ancestral Conversion", 1))
        .requirement(new Requirement("Spirit dragon pet", 1)).requirement(new Requirement("Idol crabletine pet", 1))
        .requirement(new Requirement("Gu ronin outfit", 1)).requirement(new Requirement("Death lotus rogue outfit", 1))
        .requirement(new Requirement("Seasinger acolyte outfit", 1)).requirement(new Requirement("Hunter outfit", 1))
        .requirement(new Requirement("Hanto outfit", 1)).requirement(new Requirement("Thalassia's Revenge", 1))
        .requirement(new Requirement("Winds of Waiko", 1)).requirement(new Requirement("Rage of Hyu-ji", 1))),
    ARC_UNLOCKING_WAIKO(new AchievementBuilder("Arc - Unlocking Waiko", 0, true).requirement(new Requirement("Waiko Grill", 1))
        .requirement(new Requirement("Whale's Maw Camp Fire", 1)).requirement(new Requirement("Whale's Maw Deposit Box", 1))
        .requirement(new Requirement("Arc journal teletabs", 1)).requirement(new Requirement("Crystal tool siphon blueprint", 1))
        .requirement(new Requirement("Impressing the Locals", 1))),
    ARC_UPGRADING_ALL_OF_THE_WAIKO(new AchievementBuilder("Arc - Upgrading All of the Waiko", 0, true)
        .requirement(new Requirement("Commodity sell per day increase", 2)).requirement(new Requirement("Supplies cap increase", 4))
        .requirement(new Requirement("Contracts per day increase", 4)).requirement(new Requirement("Supplies cost reduction", 5))
        .requirement(new Requirement("Commodity sell price increase", 2)).requirement(new Requirement("Impressing the Locals", 1))),
    ARC_UPGRADING_WAIKO(new AchievementBuilder("Arc - Upgrading Waiko", 0, true)
        .requirement(new Requirement("Commodity sell per day increase", 1)).requirement(new Requirement("Supplies cap increase", 1))
        .requirement(new Requirement("Contracts per day increase", 1)).requirement(new Requirement("Supplies cost reduction", 1))
        .requirement(new Requirement("Commodity sell price increase", 1)).requirement(new Requirement("Impressing the Locals", 1))),
    ARC_SALTY(new AchievementBuilder("Arc - Salty", 0, true).requirement(new Requirement("Wushanko Isles: The Arc", 1))
        .requirement(new Requirement("Arc - Unlocking More Waiko", 1)).requirement(new Requirement("Arc - Upgrading All of the Waiko", 1))
        .requirement(new Requirement("Arc - Ancient Eastern Tortle Portals", 1)).requirement(new Requirement("Arc - Flippers", 1))
        .requirement(new Requirement("Arc - Mitts and Waders - Death Lotus", 1)).requirement(new Requirement("Arc - All Your Energies", 1))
        .requirement(new Requirement("Arc - Mitts and Waders - Tetsu", 1)).requirement(new Requirement("Arc - Unlocking Waiko", 1))
        .requirement(new Requirement("Arc - Mitts and Waders - Seasinger", 1)).requirement(new Requirement("Arc - Rewards", 1))
        .requirement(new Requirement("Arc - Don't Crush My Memories", 1)).requirement(new Requirement("Arc - Bone to Pick with You", 1))),
    ARC_III_SPIRITUAL_ENLIGHTENMENT(new AchievementBuilder("Arc III - Spiritual Enlightenment", 0.75, true)
        .requirement(new Requirement("Impressing the Locals", 1)).requirement(new Requirement("Meet the Assassin", 1))
        .requirement(new Requirement("Slayer", 90)).requirement(new Requirement("The Path of the Monk", 1))
        .requirement(new Requirement("The Path of the Elemental", 1)).requirement(new Requirement("The Path of the Dragon", 1))
        .reward(new Reward("Chimes", 250)).reward(new Reward("Tajitu", 3)).lamp(new Lamp(Collections.singletonList("Slayer"), -3, 1))),
    ARC_II_HEAD_OF_THE_FAMILY(new AchievementBuilder("Arc II - Head of the Family", 0.75, true)
        .requirement(new Requirement("Impressing the Locals", 1)).requirement(new Requirement("Fish oil", 15))
        .requirement(new Requirement("Woodcutting", 90)).requirement(new Requirement("Fishing", 90))
        .requirement(new Requirement("Cooking", 91)).requirement(new Requirement("Chimes", 450)).requirement(new Requirement("Bamboo", 5))
        .encounter(new Encounter(Collections.singletonList(Arrays.asList(Enemy.CAPN_EKAHI, Enemy.CYCLOPS_LABOURER,
            Enemy.CYCLOPS_LABOURER)))).reward(new Reward("Chimes", 1300)).reward(new Reward("Fish oil", 30))
        .reward(new Reward("Bundle of bamboo", 4)).reward(new Reward("Tajitu", 5))
        .lamp(new Lamp(Collections.singletonList("Agility"), -3, 1))),
    ARC_I_FLAG_FALL(new AchievementBuilder("Arc I - Flag Fall", 0.5, true).requirement(new Requirement("Impressing the Locals", 1))
        .reward(new Reward("Chimes", 500)).reward(new Reward("Tajitu", 2))),
    ARC_IV_JED_HUNTER(new AchievementBuilder("Arc IV - Jed Hunter", 0.25, true).requirement(new Requirement("Flag Fall", 1))
        .requirement(new Requirement("Spiritual Enlightenment", 1)).requirement(new Requirement("Head of the Family", 1))
        .requirement(new Requirement("Hunter", 90)).requirement(new Requirement("Crafting", 91))
        .requirement(new Requirement("Driftwood", 10)).requirement(new Requirement("Sea shell", 5))
        .requirement(new Requirement("Tortle shell bowl", 2)).requirement(new Requirement("Tajitu", 1))
        .requirement(new Requirement("Chimes", 200)).encounter(new Encounter(Enemy.GU_RONIN)).encounter(new Encounter(Enemy.GU_RONIN))
        .encounter(new Encounter(Enemy.GU_RONIN)).reward(new Reward("Chimes", 2000)).reward(new Reward("Tajitu", 10))
        .lamp(new Lamp(Collections.singletonList("Hunter"), -3, 1))),
    ARC_V_EYE_FOR_AN_EYE(new AchievementBuilder("Arc V - Eye for an Eye", 0.25, true).requirement(new Requirement("Jed Hunter", 1))
        .requirement(new Requirement("Mining", 90)).requirement(new Requirement("Sea salt", 30))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS),Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS),
            Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS),
        Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS),
        Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS,
                Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS))))
        .reward(new Reward("Chimes", 250)).reward(new Reward("Tajitu", 1)).reward(new Reward("Alalea sea salt", 25))
        .lamp(new Lamp(Collections.singletonList("Prayer"), -3, 1))),
    ARC_VI_HARBINGER_OF_DOOM(new AchievementBuilder("Arc VI - Harbinger of Doom", 0.25, true)
        .requirement(new Requirement("Eye for an Eye", 1)).reward(new Reward("Chimes", 250)).reward(new Reward("Tajitu", 2))
        .lamp(new Lamp(Collections.singletonList("Construction"), -3, 1))),
    ARC_IX_DAMAGE_CONTROL(new AchievementBuilder("Arc IX - Damage Control", 0.25, true).requirement(new Requirement("Harbinger", 1))
        .requirement(new Requirement("Chimes", 2500)).reward(new Reward("Chimes", 3000)).reward(new Reward("Tajitu", 2))
        .lamp(new Lamp(Collections.singletonList("Thieving"), -3, 1))),
    ARC_VIII_GHOSTS_FROM_THE_PAST(new AchievementBuilder("Arc VIII - Ghosts from the Past", 0.25, true)
        .requirement(new Requirement("Harbinger", 1)).reward(new Reward("Chimes", 500)).reward(new Reward("Tajitu", 2))
        .lamp(new Lamp(Arrays.asList("Agility", "Herblore", "Fishing", "Thieving", "Cooking", "Prayer", "Runecrafting",
            "Slayer", "Construction", "Hunter", "Dungeoneering", "Divination"), -3, 1))),
    ARC_VII_TUAI_LETS_OWN(new AchievementBuilder("Arc VII - Tuai Let's Own", 0.5, true).requirement(new Requirement("Harbinger", 1))
        .requirement(new Requirement("Farming", 86)).requirement(new Requirement("Divination", 90))
        .requirement(new Requirement("Rumberry", 30)).requirement(new Requirement("Positive energy", 30))
        .requirement(new Requirement("Spirit dragon charm", 1)).reward(new Reward("Chimes", 500)).reward(new Reward("Tajitu", 2))
        .reward(new Reward("Rumberry", 50)).reward(new Reward("Ancestral energy", 50))),
    ARC_X_FINAL_DESTINATION(new AchievementBuilder("Arc X - Final Destination", 0.25, true)
        .requirement(new Requirement("Tuai Let's Own", 1)).requirement(new Requirement("Damage Control", 1))
        .requirement(new Requirement("Ghosts from the Past", 1))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.ZYCLOPS_CANNONEER, Enemy.ZYCLOPS_CANNONEER, Enemy.ZYCLOPS_CANNONEER),
            Arrays.asList(Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI),
            Arrays.asList(Enemy.SKELETON_UI, Enemy.SKELETON_UI), Arrays.asList(Enemy.ZYCLOPS_FD, Enemy.ZYCLOPS_FD))))
        .reward(new Reward("Chimes", 2000)).reward(new Reward("Tajitu", 10))
        .lamp(new Lamp(Arrays.asList("Attack", "Constitution", "Defense", "Strength", "Ranged", "Prayer", "Magic", "Summoning"), -4, 1))),
    ARDOUGNE(new AchievementBuilder("Ardougne", 0, true)),
    ARE_YOU_BEING_SERVED(new AchievementBuilder("Are You Being Served?", 0, true)),
    ARDOUGNE_SET_TASKS_EASY(new AchievementBuilder("Ardougne Set Tasks - Easy", 0, true).requirement(new Requirement("Yoink!", 1))
        .requirement(new Requirement("The Essence of Magic", 1)).requirement(new Requirement("Silky Smooth", 1))
        .requirement(new Requirement("Preaching to the Infected", 1)).requirement(new Requirement("Playing the Waiting Game", 1))
        .requirement(new Requirement("Gone Fishing", 1)).requirement(new Requirement("Boot Camp", 1))
        .requirement(new Requirement("A Cat is for Life...", 1)).requirement(new Requirement("Creator and Destroyer", 1))
        .requirement(new Requirement("Red Revolution", 1)).requirement(new Requirement("Going on a Summer Holiday", 1))
        .requirement(new Requirement("Breaking and Entering", 1)).requirement(new Requirement("P-P-P-Pick Up Some Prizes", 1))
        .requirement(new Requirement("A Gift from Khazard", 1)).requirement(new Requirement("Party Pooper", 1))
        .requirement(new Requirement("Vial Deeds", 1)).requirement(new Requirement("Star Seeker", 1))
        .requirement(new Requirement("Dukes of Khazard", 1)).requirement(new Requirement("Don't Eat the Pointy Bit", 1))
        .requirement(new Requirement("Bargain Hunter", 1)).requirement(new Requirement("Are You Being Served?", 1))
        .requirement(new Requirement("No Time to Lose", 1)).requirement(new Requirement("They're Long and Pointy", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, 1000, 25))),
    ARDOUGNE_SET_TASKS_ELITE(new AchievementBuilder("Ardougne Set Tasks - Elite", 0, true)
        .requirement(new Requirement("Catching Some Rays", 1)).requirement(new Requirement("Abyssal Valet", 1))
        .requirement(new Requirement("You Could Just Knock", 1)).requirement(new Requirement("Honestly, It's Not a Purse", 1))
        .requirement(new Requirement("Almost Made in Ardougne", 1)).lamp(new Lamp(Player.ALL_SKILLS, 50000, 85))
        .lamp(new Lamp(Player.ALL_SKILLS, 50000, 85)).lamp(new Lamp(Player.ALL_SKILLS, 50000, 85))
        .lamp(new Lamp(Player.ALL_SKILLS, 50000, 85))),
    ARDOUGNE_SET_TASKS_HARD(new AchievementBuilder("Ardougne Set Tasks - Hard", 0, true).requirement(new Requirement("Brace Yourself", 1))
        .requirement(new Requirement("Shadow Boxing", 1)).requirement(new Requirement("Just Like That", 1))
        .requirement(new Requirement("Nice View", 1)).requirement(new Requirement("You're the Dirty Rascal", 1))
        .requirement(new Requirement("Ourania Mania", 1)).requirement(new Requirement("Not on My Watch", 1))
        .requirement(new Requirement("It Just Croaked", 1)).requirement(new Requirement("Get Your Stinking Hands Off Me", 1))
        .requirement(new Requirement("Vine-detta", 1)).requirement(new Requirement("Living on a Prayer", 1))
        .requirement(new Requirement("Who Wants to Watch the Watchtower?", 1)).requirement(new Requirement("Monkey Business", 1))
        .requirement(new Requirement("It's My Newt", 1)).requirement(new Requirement("A Taste of the Exotic", 1))
        .requirement(new Requirement("Blood Bank Withdrawal", 1)).requirement(new Requirement("Artillery Strike", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, 28000, 60))),
    ARDOUGNE_SET_TASKS_MEDIUM(new AchievementBuilder("Ardougne Set Tasks - Medium", 0, true)
        .requirement(new Requirement("A Visit to Charlie", 1)).requirement(new Requirement("I Wonder What This Does", 1))
        .requirement(new Requirement("Sandy's Secret Getaway", 1)).requirement(new Requirement("I Know a Shortcut", 1))
        .requirement(new Requirement("Volatile Valuables", 1)).requirement(new Requirement("What, a Melon?", 1))
        .requirement(new Requirement("Ardougne Express", 1)).requirement(new Requirement("Arriving in Style", 1))
        .requirement(new Requirement("By the Bucketload", 1)).requirement(new Requirement("Meeting History, Again", 1))
        .requirement(new Requirement("Fearless Fishing", 1)).requirement(new Requirement("Water Logged", 1))
        .requirement(new Requirement("Green Fingers", 1)).requirement(new Requirement("A Natural Thief", 1))
        .requirement(new Requirement("The Coal Train", 1)).requirement(new Requirement("Are You Chicken?", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, 7500, 45))),
    ARE_YOU_CHICKEN(new AchievementBuilder("Are You Chicken?", 0, true).requirement(new Requirement("Tower of Life", 1))
        .requirement(new Requirement("Raw chicken", 1)).requirement(new Requirement("Raw swordfish", 1))
        .encounter(new Encounter(Enemy.SWORDCHICK))),
    ARE_YOU_NEEDING_ACCESS(new AchievementBuilder("Are You Needing Access?", 0, true).requirement(new Requirement("Do No Evil", 1))
        .requirement(new Requirement("Agility", 80)).reward(new Reward("Agility", 20000))),
    ARISE_FROM_THE_ASH(new AchievementBuilder("Arise from the Ash", 0, true).requirement(new Requirement("In Pyre Need", 1))
        .requirement(new Requirement("Phoenix Lair", 1))),
    AROUND_THE_WORLD_IN_SIX_WAYS(new AchievementBuilder("Around the World in Six Ways", 0, true)
        .requirement(new Requirement("Balloon transport system routes", 6))),
    AS_TAXED_AS_A_YAK(new AchievementBuilder("As Taxed as a Yak", 0, true).requirement(new Requirement("The Fremennik Isles", 1))
        .requirement(new Requirement("Coins", 5000))),
    AS_CLEAR_AS_A_CRYSTAL_SEED(new AchievementBuilder("As Clear as a Crystal Seed", 0, true)
        .requirement(new Requirement("Within the Light", 1))),
    ASHDALE(new AchievementBuilder("Ashdale", 0, true)),
    ATTACK_SIFU(new AchievementBuilder("Attack - Sifu", 0, true).requirement(new Requirement("Sifu", 1))),
    ATTACK_5(new AchievementBuilder("Attack 5", 0, true).requirement(new Requirement("Attack", 5))),
    ATTACK_10(new AchievementBuilder("Attack 10", 0, true).requirement(new Requirement("Attack", 10))),
    ATTACK_20(new AchievementBuilder("Attack 20", 0, true).requirement(new Requirement("Attack", 20))),
    ATTACK_30(new AchievementBuilder("Attack 30", 0, true).requirement(new Requirement("Attack", 30))),
    ATTACK_40(new AchievementBuilder("Attack 40", 0, true).requirement(new Requirement("Attack", 40))),
    ATTACK_50(new AchievementBuilder("Attack 50", 0, true).requirement(new Requirement("Attack", 50))),
    ATTACK_60(new AchievementBuilder("Attack 60", 0, true).requirement(new Requirement("Attack", 60))),
    ATTACK_70(new AchievementBuilder("Attack 70", 0, true).requirement(new Requirement("Attack", 70))),
    ATTACK_80(new AchievementBuilder("Attack 80", 0, true).requirement(new Requirement("Attack", 80))),
    ATTACK_90(new AchievementBuilder("Attack 90", 0, true).requirement(new Requirement("Attack", 90))),
    ATTACK_92(new AchievementBuilder("Attack 92", 0, true).requirement(new Requirement("Attack", 92))),
    ATTACK_99(new AchievementBuilder("Attack 99", 0, true).requirement(new Requirement("Attack", 99))),
    AVA(new AchievementBuilder("Ava", 0, true).requirement(new Requirement("Ava", 1))),
    AZACORAXS_REWARDS(new AchievementBuilder("Azacorax's Rewards", 0, true).requirement(new Requirement("Rune Memories", 1))
        .requirement(new Requirement("Magic", 50)).requirement(new Requirement("Prayer", 50))
        .lamp(new Lamp(Arrays.asList("Magic", "Prayer"), 10000, 50))),
    AZDARAN_BIRTHRIGHT(new AchievementBuilder("Azdaran Birthright", 0, true).requirement(new Requirement("Azdaran fragment", 10))),
    BANDIT_CAMP(new AchievementBuilder("Bandit Camp", 0, true).requirement(new Requirement("Desert Treasure", 1))),
    BANDOSS_MEMORIES(new AchievementBuilder("Bandos's Memories", 0, true).requirement(new Requirement("Bandos chronicles", 13))),
    BANE_TUNER(new AchievementBuilder("Bane Tuner", 0, true).requirement(new Requirement("Tune Bane Ore", 1))),
    BANK_Z(new AchievementBuilder("Bank-Z", 0, true).requirement(new Requirement("Dimension of Disaster: Curse of Arrav", 1))
        .reward(new Reward("Zemomark", 30))),
    BANKING_HISTORY(new AchievementBuilder("Banking History", 0, true).requirement(new Requirement("Enchanted key miniquest", 2))),
    BARBARIAN_SCAVENGER(new AchievementBuilder("Barbarian Scavenger", 0, true).requirement(new Requirement("Ancient page", 26))),
    BARGAIN_HUNTER(new AchievementBuilder("Bargain Hunter", 0, true)),
    BAROO_QUALITY(new AchievementBuilder("Baroo Quality", 0, true).requirement(new Requirement("Yak-hide armour (top)", 1))
        .requirement(new Requirement("Yak-hide armour (legs)", 1)).requirement(new Requirement("Fremennik round shield", 1))
        .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Arrays.asList(new Restriction("Yak-hide armour (top)", 1),
        new Restriction("Yak-hide armour (legs)", 1), new Restriction("Fremennik round shield", 1))))),
    BARROWED_POWER_I(new AchievementBuilder("Barrowed Power I", 0, true).requirement(new Requirement("Rise of the Six", 5))),
    BARROWED_POWER_II(new AchievementBuilder("Barrowed Power II", 0, true).requirement(new Requirement("Rise of the Six", 10))),
    BARROWED_POWER_III(new AchievementBuilder("Barrowed Power III", 0, true).requirement(new Requirement("Rise of the Six", 25))),
    BARROWED_POWER_IV(new AchievementBuilder("Barrowed Power IV", 0, true).requirement(new Requirement("Rise of the Six", 50))),
    BARROWED_POWER_V(new AchievementBuilder("Barrowed Power V", 0, true).requirement(new Requirement("Rise of the Six", 75))),
    BARROWED_POWER_VI(new AchievementBuilder("Barrowed Power VI", 0, true).requirement(new Requirement("Rise of the Six", 100))),
    BARROWED_TIME(new AchievementBuilder("Barrowed Time", 0, true).requirement(new Requirement("Barrows uniques", 38))),
    BARRY(new AchievementBuilder("Barry", 0, true).requirement(new Requirement("Barry", 1))),
    BEGGARS_CANT_BE_CHOOSERS(new AchievementBuilder("Beggars Can't Be Choosers", 0.05, true)
        .requirement(new Requirement("In Aid of the Myreque", 1)).requirement(new Requirement("Great maki", 1))),
    BEHEMOTH_NOTES(new AchievementBuilder("Behemoth Notes", 0, true).requirement(new Requirement("Behemoth notes", 5))),
    BERRIES_OF_THE_ARC(new AchievementBuilder("Berries of the Arc", 0, true).requirement(new Requirement("Arc berries", 16))
        .reward(new Reward("Farming", 50000))),
    BEST_OFFENCE(new AchievementBuilder("Best Offence", 0, true).encounter(new Encounter(Enemy.KALPHITE_KING))),
    BETTER_NOT_TOUCH(new AchievementBuilder("Better Not Touch", 0, true).requirement(new Requirement("Beastmaster Durzag", 1))
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU),
            Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
            Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU))))),
    BIG_CHINCHOMPA(new AchievementBuilder("Big Chinchompa", 0.25, true).requirement(new Requirement("Hunter", 78))
        .reward(new Reward("Competence points", 1111))),
    BIPEDAL_MASK(new AchievementBuilder("Bipedal Mask", 0, true).requirement(new Requirement("Tuska mask", 1))
        .lamp(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic"), 43680, 90))),
    BIRD_IS_THE_WORD_I(new AchievementBuilder("Bird is the Word I", 0, true).requirement(new Requirement("Kree'arra", 5))),
    BIRD_IS_THE_WORD_II(new AchievementBuilder("Bird is the Word II", 0, true).requirement(new Requirement("Kree'arra", 10))),
    BIRD_IS_THE_WORD_III(new AchievementBuilder("Bird is the Word III", 0, true).requirement(new Requirement("Kree'arra", 25))),
    BIRD_IS_THE_WORD_IV(new AchievementBuilder("Bird is the Word IV", 0, true).requirement(new Requirement("Kree'arra", 50))),
    BIRD_IS_THE_WORD_V(new AchievementBuilder("Bird is the Word V", 0, true).requirement(new Requirement("Kree'arra", 75))),
    BIRD_IS_THE_WORD_VI(new AchievementBuilder("Bird is the Word VI", 0, true).requirement(new Requirement("Kree'arra", 100))),
    BIRDS_OF_THE_ARC(new AchievementBuilder("Birds of the Arc", 0, true).requirement(new Requirement("Arc birds", 16))),
    BIRDSTRIKE_I(new AchievementBuilder("Birdstrike I", 0, true).requirement(new Requirement("Kree'arra (HM)", 5))),
    BIRDSTRIKE_II(new AchievementBuilder("Birdstrike II", 0, true).requirement(new Requirement("Kree'arra (HM)", 10))),
    BIRDSTRIKE_III(new AchievementBuilder("Birdstrike III", 0, true).requirement(new Requirement("Kree'arra (HM)", 25))),
    BIRDSTRIKE_IV(new AchievementBuilder("Birdstrike IV", 0, true).requirement(new Requirement("Kree'arra (HM)", 50))),
    BIRDSTRIKE_V(new AchievementBuilder("Birdstrike V", 0, true).requirement(new Requirement("Kree'arra (HM)", 75))),
    BIRDSTRIKE_VI(new AchievementBuilder("Birdstrike VI", 0, true).requirement(new Requirement("Kree'arra (HM)", 100))),
    BLACKOUT(new AchievementBuilder("Blackout", 0, true).requirement(new Requirement("Queen Black Dragon uniques", 12))),
    BLINDED_BY_RAMARNOS_TEACHING(new AchievementBuilder("Blinded by Ramarno's Teaching", 0, true)
        .requirement(new Requirement("Defender of Varrock", 1)).requirement(new Requirement("Redberry pie", 1))
        .reward(new Reward("Smithing", 1000))),
    BLOOD_STAINED_TREASURE(new AchievementBuilder("Blood Stained Treasure", 0.05, true)
        .requirement(new Requirement("Legacy of Seergaze", 1)).reward(new Reward("Blood rune", 100))),
    BOMBI(new AchievementBuilder("Bombi", 0, true).requirement(new Requirement("Bombi", 1))),
    BONE_I_FIRED(new AchievementBuilder("Bone I Fired", 0, true).requirement(new Requirement("Zanik's crossbow", 1))
        .requirement(new Requirement("Bone bolt", 2)).requirement(new Requirement("Rag and Bone Man wish list", 1))
            .requirement(new Requirement("Fur'n'Seek wish list", 1)).requirement(new Requirement("Ranged", 48))
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_1),
        Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_2), Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_3),
        Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_4)), Arrays.asList(new Restriction("Zanik's crossbow", 1),
        new Restriction("Bone bolt", 1)))).reward(new Reward("Slayer", 10000)).reward(new Reward("Prayer", 7000))),
    BOOT_CAMP(new AchievementBuilder("Boot Camp", 0, true).requirement(new Requirement("Biohazard", 1))),
    BOVINE_INTERVENTION(new AchievementBuilder("Bovine Intervention", 0, true).encounter(new Encounter(Enemy.COW))),
    BOYS_TO_MENAPHITES(new AchievementBuilder("Boys to Menaphites", 0, true).requirement(new Requirement("Menaphos reputation", 330000))),
    BRASS_NEX_I(new AchievementBuilder("Brass Nex I", 0, true).requirement(new Requirement("Nex", 5))),
    BRASS_NEX_II(new AchievementBuilder("Brass Nex II", 0, true).requirement(new Requirement("Nex", 10))),
    BRASS_NEX_III(new AchievementBuilder("Brass Nex III", 0, true).requirement(new Requirement("Nex", 25))),
    BRASS_NEX_IV(new AchievementBuilder("Brass Nex IV", 0, true).requirement(new Requirement("Nex", 50))),
    BRASS_NEX_V(new AchievementBuilder("Brass Nex V", 0, true).requirement(new Requirement("Nex", 75))),
    BRASS_NEX_VI(new AchievementBuilder("Brass Nex VI", 0, true).requirement(new Requirement("Nex", 100))),
    BREAKING_AND_ENTERING(new AchievementBuilder("Breaking and Entering", 0, true).requirement(new Requirement("Thieving", 16))),
    BRIDGE_OVER_FREMMY_WATERS(new AchievementBuilder("Bridge over Fremmy Waters", 0, true)
        .requirement(new Requirement("Unabridged Fremennik sagas", 5))),
    BRING_IT_ALL_BACK(new AchievementBuilder("Bring It All Back", 0, true).requirement(new Requirement("Ranged", 80))
        .requirement(new Requirement("Blade of Avaryss", 1)).requirement(new Requirement("Blade of Nymora", 1))
        .requirement(new Requirement("Attack", 85)).encounter(new Encounter(Enemy.TWIN_FURIES,
            Arrays.asList(new Restriction("Blade of Avaryss", 1), new Restriction("Blade of Nymora", 1))))),
    BROTHERS_GOWER(new AchievementBuilder("Brothers Gower", 0, true).requirement(new Requirement("Gower lamp", 3))),
    BROTHERS_IN_ARMS(new AchievementBuilder("Brothers in Arms", 0, true).requirement(new Requirement("Ritual of the Mahjarrat", 1))
        .requirement(new Requirement("Kindred Spirits", 1)).requirement(new Requirement("Ahrim's staff", 1))
        .requirement(new Requirement("Akrisae's war mace", 1)).requirement(new Requirement("Dharok's greataxe", 1))
        .requirement(new Requirement("Guthan's warspear", 1)).requirement(new Requirement("Karil's crossbow", 1))
        .requirement(new Requirement("Linza's hammer", 1)).requirement(new Requirement("Torag's hammer", 1))
        .requirement(new Requirement("Verac's flail", 1)).requirement(new Requirement("Magic", 70))
        .requirement(new Requirement("Attack", 80)).requirement(new Requirement("Prayer", 70))
        .requirement(new Requirement("Strength", 70)).requirement(new Requirement("Ranged", 70))
        .encounter(new Encounter(Enemy.AHRIM_THE_BLIGHTED, Collections.singletonList(new Restriction("Ahrim's staff", 1))))
        .encounter(new Encounter(Enemy.DHAROK_THE_WRETCHED, Collections.singletonList(new Restriction("Dharok's greataxe", 1))))
        .encounter(new Encounter(Enemy.LINZA_THE_DISGRACED, Collections.singletonList(new Restriction("Linza's hammer", 1))))
        .encounter(new Encounter(Enemy.KARIL_THE_TAINTED, Collections.singletonList(new Restriction("Karil's crossbow", 1))))
        .encounter(new Encounter(Enemy.TORAG_THE_CORRUPTED, Collections.singletonList(new Restriction("Torag's hammer", 1))))
        .encounter(new Encounter(Enemy.GUTHAN_THE_INFESTED, Collections.singletonList(new Restriction("Guthan's warspear", 1))))
        .encounter(new Encounter(Enemy.AKRISAE_THE_DOOMED, Collections.singletonList(new Restriction("Akrisae's war mace", 1))))
        .encounter(new Encounter(Enemy.VERAC_THE_DEFILED, Collections.singletonList(new Restriction("Verac's flail", 1))))),
    BROTHERS_IN_MORE_ARMS(new AchievementBuilder("Brothers in More Arms", 0, true).requirement(new Requirement("Barrows totem", 6))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.TORAG_THE_CORRUPTED_ROTS,
            Enemy.DHAROK_THE_WRETCHED_ROTS), Arrays.asList(Enemy.GUTHAN_THE_INFESTED_ROTS, Enemy.AHRIM_THE_BLIGHTED_ROTS,
            Enemy.VERAC_THE_DEFILED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.TORAG_THE_CORRUPTED_ROTS,
            Enemy.DHAROK_THE_WRETCHED_ROTS), Arrays.asList(Enemy.GUTHAN_THE_INFESTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.AHRIM_THE_BLIGHTED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.TORAG_THE_CORRUPTED_ROTS,
            Enemy.DHAROK_THE_WRETCHED_ROTS), Arrays.asList(Enemy.AHRIM_THE_BLIGHTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.GUTHAN_THE_INFESTED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.TORAG_THE_CORRUPTED_ROTS,
            Enemy.GUTHAN_THE_INFESTED_ROTS), Arrays.asList(Enemy.AHRIM_THE_BLIGHTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.DHAROK_THE_WRETCHED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.DHAROK_THE_WRETCHED_ROTS,
            Enemy.GUTHAN_THE_INFESTED_ROTS), Arrays.asList(Enemy.AHRIM_THE_BLIGHTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.TORAG_THE_CORRUPTED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.TORAG_THE_CORRUPTED_ROTS, Enemy.DHAROK_THE_WRETCHED_ROTS,
            Enemy.GUTHAN_THE_INFESTED_ROTS), Arrays.asList(Enemy.AHRIM_THE_BLIGHTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.KARIL_THE_TAINTED_ROTS))))),
    BRUTAL_STUFFIES(new AchievementBuilder("Brutal Stuffies", 0, true).requirement(new Requirement("Zogre Flesh Eaters", 1))
        .requirement(new Requirement("Relicym's balm", 1))),
    BUG_SWATTER_I(new AchievementBuilder("Bug Swatter I", 0, true).requirement(new Requirement("Kalphite Queen", 5))),
    BUG_SWATTER_II(new AchievementBuilder("Bug Swatter II", 0, true).requirement(new Requirement("Kalphite Queen", 10))),
    BUG_SWATTER_III(new AchievementBuilder("Bug Swatter III", 0, true).requirement(new Requirement("Kalphite Queen", 25))),
    BUG_SWATTER_IV(new AchievementBuilder("Bug Swatter IV", 0, true).requirement(new Requirement("Kalphite Queen", 50))),
    BUG_SWATTER_V(new AchievementBuilder("Bug Swatter V", 0, true).requirement(new Requirement("Kalphite Queen", 75))),
    BUG_SWATTER_VI(new AchievementBuilder("Bug Swatter VI", 0, true).requirement(new Requirement("Kalphite Queen", 100))),
    BUG_ZAPPER_I(new AchievementBuilder("Bug Zapper I", 0, true).requirement(new Requirement("Kalphite King", 5))),
    BUG_ZAPPER_II(new AchievementBuilder("Bug Zapper II", 0, true).requirement(new Requirement("Kalphite King", 10))),
    BUG_ZAPPER_III(new AchievementBuilder("Bug Zapper III", 0, true).requirement(new Requirement("Kalphite King", 25))),
    BUG_ZAPPER_IV(new AchievementBuilder("Bug Zapper IV", 0, true).requirement(new Requirement("Kalphite King", 50))),
    BUG_ZAPPER_V(new AchievementBuilder("Bug Zapper V", 0, true).requirement(new Requirement("Kalphite King", 75))),
    BUG_ZAPPER_VI(new AchievementBuilder("Bug Zapper VI", 0, true).requirement(new Requirement("Kalphite King", 100))),
    BURN_FURY_BURN(new AchievementBuilder("Burn, Fury, Burn", 0, true).requirement(new Requirement("Ranged", 80))
        .encounter(new Encounter(Enemy.TWIN_FURIES))),
    BURTHORPE(new AchievementBuilder("Burthorpe", 0, true)),
    BURTHORPE_TROLLS(new AchievementBuilder("Burthorpe Trolls", 0, true)),
    BUSINESS_IS_BOONING(new AchievementBuilder("Business Is Booning!", 0, true).requirement(new Requirement("Divination", 10))
        .requirement(new Requirement("Pale energy", 100)).reward(new Reward("Divination", 3))),
    BUY_AND_SELL_SOME_XP(new AchievementBuilder("Buy and Sell Some XP", 0, true).requirement(new Requirement("Thieving", 62))
        .requirement(new Requirement("Buyers and Cellars", 1)).reward(new Reward("Thieving", 2000))),
    BUYING_UP_ANCIENT_ARTIFACTS(new AchievementBuilder("Buying Up Ancient Artifacts", 0, true)
        .requirement(new Requirement("Desert Treasure", 1)).requirement(new Requirement("Coins", 80000))),
    CANT_MAKE_AN_OMELETTE(new AchievementBuilder("Can't Make and Omelette", 0, true).reward(new Reward("Red spider eggs", 1))),
    CAN_YOU_DIG_IT(new AchievementBuilder("Can You Dig It?", 0, true).requirement(new Requirement("Giant Mole uniques", 3))),
    CANIFIS(new AchievementBuilder("Canifis", 0, true)),
    CAREFUL_THERE_ARE_SNAKES(new AchievementBuilder("Careful, There Are Snakes", 0.05, true).requirement(new Requirement("Thieving", 31))),
    CASTAWAYS_OF_THE_ARC(new AchievementBuilder("Castaways of the Arc", 0, true).requirement(new Requirement("Arc castaways", 10))),
    CASTING_A_SHADOW(new AchievementBuilder("Casting a Shadow", 0, true).requirement(new Requirement("Blissful shadow core", 1))
        .requirement(new Requirement("Divination", 81)).requirement(new Requirement("Plague's End", 1))
        .reward(new Reward("Divination", 455))),
    CASTLES_IN_THE_SKY(new AchievementBuilder("Castles in the Sky", 0, true)),
    CATCHING_SOME_RAYS(new AchievementBuilder("Catching Some Rays", 0.2, true).requirement(new Requirement("Fishing", 81))
        .requirement(new Requirement("Swamp paste", 200)).requirement(new Requirement("Bucket", 10))
        .requirement(new Requirement("Rope", 10)).reward(new Reward("Raw manta ray", 1)).reward(new Reward("Fishing", 40))),
    CATS_BANE(new AchievementBuilder("Cat's Bane", 0, true).requirement(new Requirement("New Varrock stray cats", 4))
        .reward(new Reward("Zemomark", 20))),
    CATHERBY(new AchievementBuilder("Catherby", 0, true)),
    CAVING_INTO_THE_GAINS(new AchievementBuilder("Caving Into the Gains", 0, true)
        .requirement(new Requirement("Myths of the White Lands post-quest rewards", 4))),
    CECELIA_IM_BEGGING_YOU_PLEASE(new AchievementBuilder("Cecelia, I'm Begging You, Please...", 0, true)
        .requirement(new Requirement("One Piercing Note", 1))),
    CHALLENGE_MARIA(new AchievementBuilder("Challenge Maria", 0, true).requirement(new Requirement("Broken Home bonus lamps", 9))
        .requirement(new Requirement("Broken Home replay challenges", 3))),
    CHALLENGING_CHAT(new AchievementBuilder("Challenging Chat", 0, true)),
    CHAMPIONS_WHAT_CHAMPIONS(new AchievementBuilder("Champions? What Champions", 0, true).requirement(new Requirement("Champions", 15))
        .reward(new Reward("Coins", 50000)).lamp(new Lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defense", "Constitution",
            "Prayer", "Summoning"), 10000, 50)).lamp(new Lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defense",
            "Constitution", "Prayer", "Summoning"), 10000, 50)).lamp(new Lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged",
            "Defense", "Constitution", "Prayer", "Summoning"), 10000, 50)).lamp(new Lamp(Arrays.asList("Attack", "Strength", "Magic",
            "Ranged", "Defense", "Constitution", "Prayer", "Summoning"), 10000, 50))),
    CHANGING_OF_THE_GUARD(new AchievementBuilder("Changing of the Guard", 0, true).requirement(new Requirement("Defense", 60))
        .requirement(new Requirement("Black dragonhide coif", 1)).requirement(new Requirement("Black dragonhide body", 1))
        .requirement(new Requirement("Black dragonhide chaps", 1)).requirement(new Requirement("Black dragonhide boots", 1))
        .requirement(new Requirement("Black dragonhide vambraces", 1)).requirement(new Requirement("Black dragonhide shield", 1))
        .encounter(new Encounter(Enemy.KING_BLACK_DRAGON, Arrays.asList(new Restriction("Black dragonhide coif", 1),
            new Restriction("Black dragonhide body", 1), new Restriction("Black dragonhide chaps", 1),
            new Restriction("Black dragonhide boots", 1), new Restriction("Black dragonhide vambraces", 1),
            new Restriction("Black dragonhide shield", 1))))),
    CHAOS_THEORY(new AchievementBuilder("Chaos Theory", 0, true).requirement(new Requirement("Chaos Elemental uniques", 30))),
    CHECKMATE(new AchievementBuilder("Checkmate", 0, true).requirement(new Requirement("Kalphite Queen uniques", 4))),
    CHICKARRA(new AchievementBuilder("Chick'arra", 0, true).requirement(new Requirement("Chick'arra", 1))),
    CHILLING_WITH_ARRAV(new AchievementBuilder("Chilling with Arrav", 0, true).requirement(new Requirement("Ritual of the Mahjarrat", 1))
        .reward(new Reward("Prayer", 3000))),
    CHIPPY_TRANSPORT(new AchievementBuilder("Chippy Transport", 0, true).requirement(new Requirement("Love Story", 1))),
    CHIVALRY_IS_FED(new AchievementBuilder("Chivalry is Fed", 0, true).requirement(new Requirement("The Death of Chivalry", 1))
        .requirement(new Requirement("Cabbage seeds", 12)).requirement(new Requirement("Farming", 7)).reward(new Reward("Farming", 250))),
    CHIVALRY_IS_THREADS(new AchievementBuilder("Chivalry is Threads", 0, true).requirement(new Requirement("Templar armour", 1))
        .requirement(new Requirement("Dulcin armour", 1))),
    CHIVALRY_IS_DEAD(new AchievementBuilder("Chivalry is Dead", 0, true)
        .requirement(new Requirement("The Death of Chivalry post-quest rewards", 4))),
    CHOMPY_MASSACRE(new AchievementBuilder("Chompy Massacre", 0, true).requirement(new Requirement("Chompy kills", 4000))
        .reward(new Reward("Ranged", 30000))),
    CIRCUS_OF_FIRE(new AchievementBuilder("Circus of Fire", 0.05, true).requirement(new Requirement("The Firemaker's Curse", 1))),
    CITADELEMENTARY(new AchievementBuilder("Citadelementary", 0, true)),
    CLAIMING_AZZANADRAS_HEART(new AchievementBuilder("Claiming Azzanadra's Heart", 0, true)
        .requirement(new Requirement("Heart of Stone", 1)).requirement(new Requirement("The Temple at Senntisten", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, -2, 1))),
    CLASS_CROWN(new AchievementBuilder("Class Crown", 0, true).requirement(new Requirement("Imperial reputation", 300000))),
    CLASSIC_DRAGON_KILLING(new AchievementBuilder("Classic Dragon Killing", 0, true).requirement(new Requirement("Attack", 80))
        .requirement(new Requirement("Dragonfire shield", 1)).encounter(new Encounter(Enemy.VINDICTA,
            Collections.singletonList(new Restriction("Dragonfire shield", 1))))),
    CLASSIC_ROCK(new AchievementBuilder("Classic Rock", 0, true).encounter(new Encounter(Enemy.VORAGO,
        Collections.singletonList(new Restriction("Defensive abilities", 0))))),
    CLAUS_IS_RISING(new AchievementBuilder("Claus Is Rising", 0, true).requirement(new Requirement("Claus the chef reward", 1))),
    CLAYMATION(new AchievementBuilder("Claymation", 0.33, true)),
    CLUES_IN_THE_MONKEY_DROOL(new AchievementBuilder("Clue's In The Monkey Drool", 0, true)
        .requirement(new Requirement("Monkey clue scroll", 1))),
    COLLECTING_MEMORABILIA(new AchievementBuilder("Collecting Memorabilia", 0, true).reward(new Reward("Divination", 1))),
    COME_AND_HAVE_VORAGO_I(new AchievementBuilder("Come and Have Vorago I", 0, true).requirement(new Requirement("Vorago", 5))),
    COME_AND_HAVE_VORAGO_II(new AchievementBuilder("Come and Have Vorago II", 0, true).requirement(new Requirement("Vorago", 10))),
    COME_AND_HAVE_VORAGO_III(new AchievementBuilder("Come and Have Vorago III", 0, true).requirement(new Requirement("Vorago", 25))),
    COME_AND_HAVE_VORAGO_IV(new AchievementBuilder("Come and Have Vorago IV", 0, true).requirement(new Requirement("Vorago", 50))),
    COME_AND_HAVE_VORAGO_V(new AchievementBuilder("Come and Have Vorago V", 0, true).requirement(new Requirement("Vorago", 75))),
    COME_AND_HAVE_VORAGO_VI(new AchievementBuilder("Come and Have Vorago VI", 0, true).requirement(new Requirement("Vorago", 100))),
    COMMANDER_MINIANA(new AchievementBuilder("Commander Miniana", 0, true).requirement(new Requirement("Commander Miniana", 1))),
    COMMERCE_BREAK(new AchievementBuilder("Commerce Break", 0, true)),
    COMPLETE_HISTORY_OF_DROALAK(new AchievementBuilder("Complete History of Droalak", 0, true)
        .requirement(new Requirement("Making History", 1))),
    COMPLETE_TREKKY(new AchievementBuilder("Complete Trekky", 0, true).requirement(new Requirement("Temple Trekking total level", 594))),
    COMPLETIONIST_CAPE(new AchievementBuilder("Completionist Cape", 0, true).requirement(new Requirement("Abyssal Reach", 1))
        .requirement(new Requirement("Almost as Perky as a Prawn", 1)).requirement(new Requirement("Annihilator", 1))
        .requirement(new Requirement("Arc - Ancient Eastern Tortle Portals", 1)).requirement(new Requirement("Arc - Unlocking Waiko", 1))
        .requirement(new Requirement("Arc - Upgrading Waiko", 1)).requirement(new Requirement("Arc III - Spiritual Enlightenment", 1))
        .requirement(new Requirement("Arc II - Head of the Family", 1)).requirement(new Requirement("Arc IV - Jed Hunter", 1))
        .requirement(new Requirement("Arc IX - Damage Control", 1)).requirement(new Requirement("Arc I - Flag Fall", 1))
        .requirement(new Requirement("Arc VIII - Ghosts from the Past", 1)).requirement(new Requirement("Arc VII - Tuai Leit's Own", 1))
        .requirement(new Requirement("Arc VI - Harbinger of Doom", 1)).requirement(new Requirement("Arc V - Eye for an Eye", 1))
        .requirement(new Requirement("Arc X - Final Destination", 1)).requirement(new Requirement("Bandos's Memories", 1))
        .requirement(new Requirement("Bane Tuner", 1)).requirement(new Requirement("Big Chinchompa", 1))
        .requirement(new Requirement("Bipedal Mask", 1)).requirement(new Requirement("Bridge over Fremmy Waters", 1))
        .requirement(new Requirement("Claus Is Rising", 1)).requirement(new Requirement("Deadlier Catch", 1))
        .requirement(new Requirement("Desert-ed Ghosts", 1)).requirement(new Requirement("Diaries of the Clans", 1))
        .requirement(new Requirement("Elven Titles", 1)).requirement(new Requirement("Family Spirit Tree", 1))
        .requirement(new Requirement("Famous", 1)).requirement(new Requirement("Heal, Quickly", 1))
        .requirement(new Requirement("I'm Forever Washing Shadows", 1)).requirement(new Requirement("Imping Around", 1))
        .requirement(new Requirement("Invention Gives Me the Blues", 1)).requirement(new Requirement("Kharshai's Memories", 1))
        .requirement(new Requirement("Kiln Fighter", 1)).requirement(new Requirement("Kudos to You", 1))
        .requirement(new Requirement("Long Live the Queen", 1)).requirement(new Requirement("Lost Toys", 1))
        .requirement(new Requirement("Lunar Master", 1)).requirement(new Requirement("Make Them Bleed", 1))
        .requirement(new Requirement("Master Quester", 1)).requirement(new Requirement("Master Skiller", 1))
        .requirement(new Requirement("Memories of Guthis", 1)).requirement(new Requirement("Music Maestro", 1))
        .requirement(new Requirement("Myreque in Memoriam", 1)).requirement(new Requirement("One Foot in the Grave", 1))
        .requirement(new Requirement("Out into the Ourania", 1)).requirement(new Requirement("Peachy Bones", 1))
        .requirement(new Requirement("Pious Prayers", 1)).requirement(new Requirement("Port Life", 1))
        .requirement(new Requirement("Potion Mixer Master", 1)).requirement(new Requirement("Potion for a Lady", 1))
        .requirement(new Requirement("Reaper Crew", 1)).requirement(new Requirement("Rhian in Gold - The Original", 1))
        .requirement(new Requirement("Seren Memories", 1)).requirement(new Requirement("Sing for the Lady", 1))
        .requirement(new Requirement("Slayer Master", 1)).requirement(new Requirement("Stay Safe", 1))
        .requirement(new Requirement("Stay Secure", 1)).requirement(new Requirement("Task Master", 1))
        .requirement(new Requirement("Tell Tale Tarn", 1)).requirement(new Requirement("Trip to the East", 1))
        .requirement(new Requirement("Troublesome Crystals", 1)).requirement(new Requirement("Uncorrupted Ore", 1))
        .requirement(new Requirement("Walking the Reef", 1)).requirement(new Requirement("What's Mine Is Also Doric's", 1))
        .requirement(new Requirement("Yaktwee's a Charm", 1)).requirement(new Requirement("You Be Dead", 1))
        .requirement(new Requirement("Zarosian Memories", 1))),
    CONQUEST_ADORE(new AchievementBuilder("Conquest Adore", 0, true).requirement(new Requirement("Conquest rank", 1250))),
    CONSTITUTION_MORTY(new AchievementBuilder("Constitution - Morty", 0, true).requirement(new Requirement("Morty", 1))),
    CONSTITUTION_15(new AchievementBuilder("Constitution 15", 0, true).requirement(new Requirement("Constitution", 15))),
    CONSTITUTION_20(new AchievementBuilder("Constitution 20", 0, true).requirement(new Requirement("Constitution", 20))),
    CONSTITUTION_30(new AchievementBuilder("Constitution 30", 0, true).requirement(new Requirement("Constitution", 30))),
    CONSTITUTION_40(new AchievementBuilder("Constitution 40", 0, true).requirement(new Requirement("Constitution", 40))),
    CONSTITUTION_50(new AchievementBuilder("Constitution 50", 0, true).requirement(new Requirement("Constitution", 50))),
    CONSTITUTION_60(new AchievementBuilder("Constitution 60", 0, true).requirement(new Requirement("Constitution", 60))),
    CONSTITUTION_70(new AchievementBuilder("Constitution 70", 0, true).requirement(new Requirement("Constitution", 70))),
    CONSTITUTION_80(new AchievementBuilder("Constitution 80", 0, true).requirement(new Requirement("Constitution", 80))),
    CONSTITUTION_90(new AchievementBuilder("Constitution 90", 0, true).requirement(new Requirement("Constitution", 90))),
    CONSTITUTION_92(new AchievementBuilder("Constitution 92", 0, true).requirement(new Requirement("Constitution", 92))),
    CONSTITUTION_99(new AchievementBuilder("Constitution 99", 0, true).requirement(new Requirement("Constitution", 99))),
    CONSTRUCTION_BABA_YAGAS_HOUSE(new AchievementBuilder("Construction - Baba Yaga's House", 0, true)
        .requirement(new Requirement("Baby Yaga's House'", 1))),
    CONSTRUCTION_5(new AchievementBuilder("Construction 5", 0, true).requirement(new Requirement("Construction", 5))),
    CONSTRUCTION_10(new AchievementBuilder("Construction 10", 0, true).requirement(new Requirement("Construction", 10))),
    CONSTRUCTION_20(new AchievementBuilder("Construction 20", 0, true).requirement(new Requirement("Construction", 20))),
    CONSTRUCTION_30(new AchievementBuilder("Construction 30", 0, true).requirement(new Requirement("Construction", 30))),
    CONSTRUCTION_40(new AchievementBuilder("Construction 40", 0, true).requirement(new Requirement("Construction", 40))),
    CONSTRUCTION_50(new AchievementBuilder("Construction 50", 0, true).requirement(new Requirement("Construction", 50))),
    CONSTRUCTION_60(new AchievementBuilder("Construction 60", 0, true).requirement(new Requirement("Construction", 60))),
    CONSTRUCTION_70(new AchievementBuilder("Construction 70", 0, true).requirement(new Requirement("Construction", 70))),
    CONSTRUCTION_80(new AchievementBuilder("Construction 80", 0, true).requirement(new Requirement("Construction", 80))),
    CONSTRUCTION_90(new AchievementBuilder("Construction 90", 0, true).requirement(new Requirement("Construction", 90))),
    CONSTRUCTION_92(new AchievementBuilder("Construction 92", 0, true).requirement(new Requirement("Construction", 92))),
    CONSTRUCTION_99(new AchievementBuilder("Construction 99", 0, true).requirement(new Requirement("Construction", 99))),
    COOKS_DELIGHT(new AchievementBuilder("Cook's Delight", 0, true).requirement(new Requirement("Cook's Assistant", 1))),
    COOKING_RAMSAY(new AchievementBuilder("Cooking - Ramsay", 0, true).requirement(new Requirement("Ramsay", 1))),
    COOKING_5(new AchievementBuilder("Cooking 5", 0, true).requirement(new Requirement("Cooking", 5))),
    COOKING_10(new AchievementBuilder("Cooking 10", 0, true).requirement(new Requirement("Cooking", 10))),
    COOKING_20(new AchievementBuilder("Cooking 20", 0, true).requirement(new Requirement("Cooking", 20))),
    COOKING_30(new AchievementBuilder("Cooking 30", 0, true).requirement(new Requirement("Cooking", 30))),
    COOKING_40(new AchievementBuilder("Cooking 40", 0, true).requirement(new Requirement("Cooking", 40))),
    COOKING_50(new AchievementBuilder("Cooking 50", 0, true).requirement(new Requirement("Cooking", 50))),
    COOKING_60(new AchievementBuilder("Cooking 60", 0, true).requirement(new Requirement("Cooking", 60))),
    COOKING_70(new AchievementBuilder("Cooking 70", 0, true).requirement(new Requirement("Cooking", 70))),
    COOKING_80(new AchievementBuilder("Cooking 80", 0, true).requirement(new Requirement("Cooking", 80))),
    COOKING_90(new AchievementBuilder("Cooking 90", 0, true).requirement(new Requirement("Cooking", 90))),
    COOKING_92(new AchievementBuilder("Cooking 92", 0, true).requirement(new Requirement("Cooking", 92))),
    COOKING_99(new AchievementBuilder("Cooking 99", 0, true).requirement(new Requirement("Cooking", 99))),
    CORMES_AND_GOES(new AchievementBuilder("Cormes and Goes", 0, true).encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT,
        Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT,
            Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER,
            Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG))))),
    CORPOREAL_PUNISHMENT_I(new AchievementBuilder("Corporeal Punishment I", 0, true).requirement(new Requirement("Corporeal Beast", 5))),
    CORPOREAL_PUNISHMENT_II(new AchievementBuilder("Corporeal Punishment II", 0, true).requirement(new Requirement("Corporeal Beast", 10))),
    CORPOREAL_PUNISHMENT_III(new AchievementBuilder("Corporeal Punishment III", 0, true)
        .requirement(new Requirement("Corporeal Beast", 25))),
    CORPOREAL_PUNISHMENT_IV(new AchievementBuilder("Corporeal Punishment IV", 0, true).requirement(new Requirement("Corporeal Beast", 50))),
    CORPOREAL_PUNISHMENT_V(new AchievementBuilder("Corporeal Punishment V", 0, true).requirement(new Requirement("Corporeal Beast", 75))),
    CORPOREAL_PUNISHMENT_VI(new AchievementBuilder("Corporeal Punishment VI", 0, true)
        .requirement(new Requirement("Corporeal Beast", 100))),
    CORPOREAL_PUPPY(new AchievementBuilder("Corporeal Puppy", 0, true).requirement(new Requirement("Corporeal Puppy", 1))),
    COUNT_ALL_LIGHT_FINGERS(new AchievementBuilder("Count All Light Fingers", 0, true).requirement(new Requirement("From Tiny Acorns", 1))
        .requirement(new Requirement("Lost Her Marbles", 1)).requirement(new Requirement("A Guild of Our Own", 1))),
    COURSING_THROUGH_YOU(new AchievementBuilder("Coursing Through You", 0, true).requirement(new Requirement("Max Telos enrage", 95))
       .encounter(new Encounter(Enemy.TELOS_100_ENRAGE))),
    COWER_BEHIND_THE_CHOSEN_COMMANDER(new AchievementBuilder("Cower Behind the Chosen Commander", 0, true)
        .requirement(new Requirement("The Chosen Commander", 1)).lamp(new Lamp(Arrays.asList("Constitution", "Attack", "Defense"),
            1000, 1))),
    CRAFTING_GEMI(new AchievementBuilder("Crafting - Gemi", 0, true).requirement(new Requirement("Gemi", 1))),
    CRAFTING_5(new AchievementBuilder("Crafting 5", 0, true).requirement(new Requirement("Crafting", 5))),
    CRAFTING_10(new AchievementBuilder("Crafting 10", 0, true).requirement(new Requirement("Crafting", 10))),
    CRAFTING_20(new AchievementBuilder("Crafting 20", 0, true).requirement(new Requirement("Crafting", 20))),
    CRAFTING_30(new AchievementBuilder("Crafting 30", 0, true).requirement(new Requirement("Crafting", 30))),
    CRAFTING_40(new AchievementBuilder("Crafting 40", 0, true).requirement(new Requirement("Crafting", 40))),
    CRAFTING_50(new AchievementBuilder("Crafting 50", 0, true).requirement(new Requirement("Crafting", 50))),
    CRAFTING_60(new AchievementBuilder("Crafting 60", 0, true).requirement(new Requirement("Crafting", 60))),
    CRAFTING_70(new AchievementBuilder("Crafting 70", 0, true).requirement(new Requirement("Crafting", 70))),
    CRAFTING_80(new AchievementBuilder("Crafting 80", 0, true).requirement(new Requirement("Crafting", 80))),
    CRAFTING_90(new AchievementBuilder("Crafting 90", 0, true).requirement(new Requirement("Crafting", 90))),
    CRAFTING_92(new AchievementBuilder("Crafting 92", 0, true).requirement(new Requirement("Crafting", 92))),
    CRAFTING_99(new AchievementBuilder("Crafting 99", 0, true).requirement(new Requirement("Crafting", 99))),
    CRAN_DOORS_SECRET(new AchievementBuilder("Cran Door's Secret", 0, true).requirement(new Requirement("Dragon Slayer", 1))),
    CRAYFISH_ROASTING_ON_AN_OPEN_FIRE(new AchievementBuilder("Crayfish Roasting On An Open Fire", 0, true)
        .requirement(new Requirement("Raw crayfish", 1)).reward(new Reward("Crayfish", 1)).reward(new Reward("Cooking", 30))),
    CREATOR_AND_DESTROYER(new AchievementBuilder("Creator and Destroyer", 0, true).requirement(new Requirement("Tower of Life", 1))
        .requirement(new Requirement("Cowhide", 1)).requirement(new Requirement("Unicorn horn", 1)).encounter(new Encounter(Enemy.UNICOW))),
    CROCODILE_TEARS(new AchievementBuilder("Crocodile Tears", 0, true).requirement(new Requirement("Crocodile Tears (quest)", 1))),
    CROSSING_OVER_I(new AchievementBuilder("Crossing Over I", 0, true).requirement(new Requirement("The Magister", 5))),
    CROSSING_OVER_II(new AchievementBuilder("Crossing Over II", 0, true).requirement(new Requirement("The Magister", 10))),
    CROSSING_OVER_III(new AchievementBuilder("Crossing Over III", 0, true).requirement(new Requirement("The Magister", 25))),
    CROSSING_OVER_IV(new AchievementBuilder("Crossing Over IV", 0, true).requirement(new Requirement("The Magister", 50))),
    CROSSING_OVER_V(new AchievementBuilder("Crossing Over V", 0, true).requirement(new Requirement("The Magister", 75))),
    CROSSING_OVER_VI(new AchievementBuilder("Crossing Over VI", 0, true).requirement(new Requirement("The Magister", 100))),
    DAEMONHEIM_SET_TASKS_EASY(new AchievementBuilder("Daemonheim Set Tasks - Easy", 0, true).requirement(new Requirement("Setting Up", 1))
        .requirement(new Requirement("It's Dangerous to go Alone", 1)).requirement(new Requirement("Kitchen Aid", 1))
        .requirement(new Requirement("The Lone Dungeoneer", 1)).requirement(new Requirement("Dere-licked", 1))
        .requirement(new Requirement("Take It From the Top", 1)).requirement(new Requirement("Change of a Dress", 1))
        .requirement(new Requirement("Gorajo Fandago", 1)).requirement(new Requirement("You're Not the Boss of Me", 1))
        .requirement(new Requirement("A Road Less Travelled", 1)).requirement(new Requirement("Invisible Ink", 1))
        .requirement(new Requirement("Untouchable", 1)).requirement(new Requirement("Fashion Victim", 1))
        .requirement(new Requirement("Sinking Fast", 1)).requirement(new Requirement("Tales of Old", 1))
        .requirement(new Requirement("A Flicker in Darkness", 1)).lamp(new Lamp(Player.ALL_SKILLS, 2000, 23))),
    DAEMONHEIM_SET_TASKS_ELITE(new AchievementBuilder("Daemonheim Set Tasks - Elite", 0, true)
        .requirement(new Requirement("Any fin is Possible", 1)).requirement(new Requirement("Orbful", 1))
        .requirement(new Requirement("Top Hat", 1)).requirement(new Requirement("In the Darkness Bind Them", 1))
        .requirement(new Requirement("Pass the Port", 1)).requirement(new Requirement("Gulega-d to Rest", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, 60000, 98)).lamp(new Lamp(Player.ALL_SKILLS, 50000, 90))
        .lamp(new Lamp(Player.ALL_SKILLS, 50000, 90)).lamp(new Lamp(Player.ALL_SKILLS, 50000, 90))),
    DAEMONHEIM_SET_TASKS_HARD(new AchievementBuilder("Daemonheim Set Tasks - Hard", 0, true)
        .requirement(new Requirement("Occult Classic", 1)).requirement(new Requirement("Stacked", 1))
        .requirement(new Requirement("Kinprovements", 1)).requirement(new Requirement("Lawful Crafting", 1))
        .requirement(new Requirement("Thanks for the Memories", 1)).requirement(new Requirement("Healing Factor", 1))
        .requirement(new Requirement("Alcrabholic", 1)).requirement(new Requirement("Hoof Rot", 1))
        .requirement(new Requirement("A Prayer Opportunity", 1)).requirement(new Requirement("The Wanderer", 1))
        .requirement(new Requirement("Get Stuffed", 1)).requirement(new Requirement("Epic Epic", 1))
        .reward(new Reward("Dungeoneering token", 38000)).lamp(new Lamp(Player.ALL_SKILLS, 20000, 74))),
    DAEMONHEIM_SET_TASKS_MEDIUM(new AchievementBuilder("Daemonheim Set Tasks - Medium", 0, true)
        .requirement(new Requirement("You Got Some Nice Drapes There", 1)).requirement(new Requirement("I Want It All", 1))
        .requirement(new Requirement("And I Want It Now", 1)).requirement(new Requirement("Marm's Armoury", 1))
        .requirement(new Requirement("Tactical Retreat", 1)).requirement(new Requirement("Port Enter", 1))
        .requirement(new Requirement("Totem Pole Position", 1)).requirement(new Requirement("Nice to Meet You, Wall", 1))
        .requirement(new Requirement("300", 1)).requirement(new Requirement("Drink Me", 1)).requirement(new Requirement("Spinal Tap", 1))
        .requirement(new Requirement("Cache Box", 1)).requirement(new Requirement("Up to the Gods", 1))
        .reward(new Reward("Dungeoneering token", 2000)).lamp(new Lamp(Player.ALL_SKILLS, 8000, 41))),
    DAEMONOLOGY_OF_CELERITY(new AchievementBuilder("Daemonology of Celerity", 0, true).requirement(new Requirement("Demon flash mob", 1))),
    DAERO_TAKE_THIS_EXPERIENCE(new AchievementBuilder("Daero Take This Experience?", 0, true)
        .requirement(new Requirement("Monkey Madness", 1)).reward(new Reward("Attack", 20000)).reward(new Reward("Strength", 20000))
        .reward(new Reward("Defense", 10000)).reward(new Reward("Constitution", 20000)).lamp(new Lamp(Arrays.asList("Attack", "Strength"),
        15000, 1)).lamp(new Lamp(Arrays.asList("Constitution", "Defense"), 15000, 1))),
    DAGANNOTH_TRAFFIC_WARDENS(new AchievementBuilder("Dagannoth Traffic Wardens", 0, true)
        .requirement(new Requirement("Koschei's Troubles", 1)).encounter(new Encounter(Enemy.DAGANNOTH_SUPREME,
                Collections.singletonList(new Restriction("Achromatic Balmung", 1)))).encounter(new Encounter(Enemy.DAGANNOTH_SUPREME,
                Collections.singletonList(new Restriction("Cobalt Balmung", 1)))).encounter(new Encounter(Enemy.DAGANNOTH_SUPREME,
                Collections.singletonList(new Restriction("Crimson Balmung", 1)))).encounter(new Encounter(Enemy.DAGANNOTH_SUPREME,
                Collections.singletonList(new Restriction("Viridian Balmung", 1))))),
    DAGANNOTH_FOR_EVERYONE_I(new AchievementBuilder("Dagannoth For Everyone I", 0, true).requirement(new Requirement("Dagannoth Kings", 5))),
    DAGANNOTH_FOR_EVERYONE_II(new AchievementBuilder("Dagannoth For Everyone II", 0, true).requirement(new Requirement("Dagannoth Kings", 10))),
    DAGANNOTH_FOR_EVERYONE_III(new AchievementBuilder("Dagannoth For Everyone III", 0, true).requirement(new Requirement("Dagannoth Kings", 25))),
    DAGANNOTH_FOR_EVERYONE_IV(new AchievementBuilder("Dagannoth For Everyone IV", 0, true).requirement(new Requirement("Dagannoth Kings", 50))),
    DAGANNOTH_FOR_EVERYONE_V(new AchievementBuilder("Dagannoth For Everyone V", 0, true).requirement(new Requirement("Dagannoth Kings", 75))),
    DAGANNOTH_FOR_EVERYONE_VI(new AchievementBuilder("Dagannoth For Everyone VI", 0, true).requirement(new Requirement("Dagannoth Kings", 100))),
    DARK_IMPERATORMENT(new AchievementBuilder("Dark Imperator-ment", 0, true).requirement(new Requirement("Constitution", 91))
        .requirement(new Requirement("Attack", 75)).requirement(new Requirement("Magic", 75)).requirement(new Requirement("Ranged", 75))
        .requirement(new Requirement("Dimension of Disaster: Coin of the Realm", 1)).reward(new Reward("Zemomark", 40))),
    DAY_AT_THE_AQUARIUM(new AchievementBuilder("Day at the Aquarium", 0, true).requirement(new Requirement("Beastmaster Durzag", 1))
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU),
            Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
            Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU))))),
    DAY_AT_THE_POUND(new AchievementBuilder("Day at the Pound", 0, true).encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT,
        Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CORMES),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG))))),
    DEADLIER_CATCH(new AchievementBuilder("Deadlier Catch", 0, true).requirement(new Requirement("Thalassus hunts", 10))),
    DEATH_EFFECT(new AchievementBuilder("Death Effect", 0, true).requirement(new Requirement("Book of death", 1))
        .requirement(new Requirement("Reaper's choice", 1)).requirement(new Requirement("Rainbow loot beam", 1))
        .requirement(new Requirement("Grave loot beam", 1)).requirement(new Requirement("Bonfire booster", 1))
        .requirement(new Requirement("Instance cost", 1)).requirement(new Requirement("Additional tasks", 1))
        .requirement(new Requirement("Reaper scroll", 1)).requirement(new Requirement("Death's support", 1))),
    DEATH_TO_THE_MAHJARRAT(new AchievementBuilder("Death to the Mahjarrat", 0, true)
        .requirement(new Requirement("Mahjarrat deathstone", 4))),
    DEEP_AND_BLOODY_EXPERIENCE(new AchievementBuilder("Deep and Bloody Experience", 0, true)
        .requirement(new Requirement("Blood Runs Deep", 1)).lamp(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution",
            "Ranged", "Magic", "Prayer"), 150000, 75)).lamp(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution",
            "Ranged", "Magic", "Prayer"), 150000, 75)).lamp(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution",
            "Ranged", "Magic", "Prayer"), 150000, 75))),
    DEFENSE_WALLACE(new AchievementBuilder("Defence - Wallace", 0, true).requirement(new Requirement("Wallace", 1))),
    DEFENSE_5(new AchievementBuilder("Defense 5", 0, true).requirement(new Requirement("Defense", 5))),
    DEFENSE_10(new AchievementBuilder("Defense 10", 0, true).requirement(new Requirement("Defense", 10))),
    DEFENSE_20(new AchievementBuilder("Defense 20", 0, true).requirement(new Requirement("Defense", 20))),
    DEFENSE_30(new AchievementBuilder("Defense 30", 0, true).requirement(new Requirement("Defense", 30))),
    DEFENSE_40(new AchievementBuilder("Defense 40", 0, true).requirement(new Requirement("Defense", 40))),
    DEFENSE_50(new AchievementBuilder("Defense 50", 0, true).requirement(new Requirement("Defense", 50))),
    DEFENSE_60(new AchievementBuilder("Defense 60", 0, true).requirement(new Requirement("Defense", 60))),
    DEFENSE_70(new AchievementBuilder("Defense 70", 0, true).requirement(new Requirement("Defense", 70))),
    DEFENSE_80(new AchievementBuilder("Defense 80", 0, true).requirement(new Requirement("Defense", 80))),
    DEFENSE_90(new AchievementBuilder("Defense 90", 0, true).requirement(new Requirement("Defense", 90))),
    DEFENSE_92(new AchievementBuilder("Defense 92", 0, true).requirement(new Requirement("Defense", 92))),
    DEFENSE_99(new AchievementBuilder("Defense 99", 0, true).requirement(new Requirement("Defense", 99))),
    DESCENSION_I(new AchievementBuilder("Descension I", 0, true).requirement(new Requirement("Legiones", 5))),
    DESCENSION_II(new AchievementBuilder("Descension II", 0, true).requirement(new Requirement("Legiones", 10))),
    DESCENSION_III(new AchievementBuilder("Descension III", 0, true).requirement(new Requirement("Legiones", 25))),
    DESCENSION_IV(new AchievementBuilder("Descension IV", 0, true).requirement(new Requirement("Legiones", 50))),
    DESCENSION_V(new AchievementBuilder("Descension V", 0, true).requirement(new Requirement("Legiones", 75))),
    DESCENSION_VI(new AchievementBuilder("Descension VI", 0, true).requirement(new Requirement("Legiones", 100))),
    DESERTED_GHOSTS(new AchievementBuilder("Desert-ed Ghosts", 0, true).requirement(new Requirement("The Curse of Zaros", 1))),
    DESERT_SET_TASKS_EASY(new AchievementBuilder("Desert Set Tasks - Easy", 0, true).requirement(new Requirement("Assassin's Feed", 1))
        .requirement(new Requirement("Touring Gear", 1)).requirement(new Requirement("Memento Mori", 1))
        .requirement(new Requirement("Fool's Gold", 1)).requirement(new Requirement("Don't You Dare Close Your Eyes", 1))
        .requirement(new Requirement("Slash Fund", 1)).requirement(new Requirement("Kookookachat", 1))
        .requirement(new Requirement("Fire at Will", 1)).requirement(new Requirement("Seems Legit", 1))
        .requirement(new Requirement("Extra Cheese", 1)).requirement(new Requirement("I Like to Watch", 1))
        .requirement(new Requirement("Wiggle Room", 1)).lamp(new Lamp(Player.ALL_SKILLS, 2000, 29))),
    DESERT_SET_TASKS_ELITE(new AchievementBuilder("Desert Set Tasks - Elite", 0, true).requirement(new Requirement("Staff on Stryke", 1))
        .requirement(new Requirement("Room Service", 1)).requirement(new Requirement("Sun Shade", 1))
        .requirement(new Requirement("A. B. Cithara", 1)).requirement(new Requirement("Ankle Support", 1))
        .requirement(new Requirement("I'm Super", 1)).lamp(new Lamp(Player.ALL_SKILLS, 30000, 77))
        .lamp(new Lamp(Player.ALL_SKILLS, 30000, 77)).lamp(new Lamp(Player.ALL_SKILLS, 50000, 93))
        .lamp(new Lamp(Player.ALL_SKILLS, 50000, 93))),
    DESERT_SET_TASKS_HARD(new AchievementBuilder("Desert Set Tasks - Hard", 0, true).requirement(new Requirement("Skinful", 1))
        .requirement(new Requirement("Water on the Brain", 1)).requirement(new Requirement("More Fletcher than Sumona", 1))
        .requirement(new Requirement("Ug Thankee Kindly", 1)).requirement(new Requirement("Nipped in the Bug", 1))
        .requirement(new Requirement("Drafty in Here", 1)).requirement(new Requirement("Enaqua", 1))
        .requirement(new Requirement("Say It, Don't Spray It", 1)).requirement(new Requirement("1001 Kharidian Spikes", 1))
        .requirement(new Requirement("Ice-Cold Killer", 1)).requirement(new Requirement("Ludikeris", 1))
        .requirement(new Requirement("Security through Obscurity", 1)).requirement(new Requirement("Wake-Up Call", 1))
        .requirement(new Requirement("Open Sesame", 1)).lamp(new Lamp(Player.ALL_SKILLS, 20000, 1))),
    DESERT_SET_TASKS_MEDIUM(new AchievementBuilder("Desert Set Tasks - Medium", 0, true).requirement(new Requirement("So Su Me", 1))
        .requirement(new Requirement("Faster than a Speeding Bullet", 1)).requirement(new Requirement("A Bridge Not Far", 1))
        .requirement(new Requirement("Heathen Idle", 1)).requirement(new Requirement("Away with the Kalphites", 1))
        .requirement(new Requirement("All Square", 1)).requirement(new Requirement("Goat Harralader?", 1))
        .requirement(new Requirement("Taken for Granite", 1)).requirement(new Requirement("Unbeetleable", 1))
        .requirement(new Requirement("An Teak", 1)).requirement(new Requirement("Overcut", 1)).lamp(new Lamp(Player.ALL_SKILLS, 8000, 43))),
    DHAROK_BOBBLEHEAD(new AchievementBuilder("Dharok Bobblehead", 0, true).requirement(new Requirement("Dharok the Bobbled", 1))),
    DIARIES_OF_THE_CLANS(new AchievementBuilder("Diaries of the Clans", 0, true).requirement(new Requirement("Voice of the Elders", 8))),
    DIARY_OF_OREB(new AchievementBuilder("Diary of Oreb", 0, true).requirement(new Requirement("The Magister's Journals", 5))),
    DIARY_OF_THE_GODS(new AchievementBuilder("Diary of the Gods", 0, true).requirement(new Requirement("God journals", 5))),
    DIDDYZAG(new AchievementBuilder("Diddyzag", 0, true).requirement(new Requirement("Diddyzag", 1))),
    DISHONOURABLE_GAINS(new AchievementBuilder("Dishonourable Gains", 0, true)
        .requirement(new Requirement("Zamorak hideout XP chests", 3))),
    DISHONOURABLE_LOOT(new AchievementBuilder("Dishonourable Gains", 0, true)
        .requirement(new Requirement("Zamorak hideout loot chests", 6))),
    DISOWNED(new AchievementBuilder("Disowned", 0, true).requirement(new Requirement("Reforged Sunspear", 1))
        .requirement(new Requirement("House Drakan hood", 1)).requirement(new Requirement("House Drakan top", 1))
        .requirement(new Requirement("House Drakan trousers", 1)).requirement(new Requirement("House Drakan boots", 1))
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.VANSTROM_KLAUSE),
        Collections.singletonList(Enemy.VANSTROM_KLAUSE)), Arrays.asList(new Restriction("Reforged Sunspear", 1),
        new Restriction("House Drakan hood", 1), new Restriction("House Drakan top", 1), new Restriction("House Drakan trousers", 1),
            new Restriction("House Drakan boots", 1))))),
    DISTORTED_DIV(new AchievementBuilder("Distorted Div", 0, true).requirement(new Requirement("Distorted engrammeter", 1))
        .reward(new Reward("Divination", 25000))),
    DIVINATION_WILLOW(new AchievementBuilder("Divination - Willow", 0, true).requirement(new Requirement("Willow", 1))),
    DIVINATION_5(new AchievementBuilder("Divination 5", 0, true).requirement(new Requirement("Divination", 5))),
    DIVINATION_10(new AchievementBuilder("Divination 10", 0, true).requirement(new Requirement("Divination", 10))),
    DIVINATION_20(new AchievementBuilder("Divination 20", 0, true).requirement(new Requirement("Divination", 20))),
    DIVINATION_30(new AchievementBuilder("Divination 30", 0, true).requirement(new Requirement("Divination", 30))),
    DIVINATION_40(new AchievementBuilder("Divination 40", 0, true).requirement(new Requirement("Divination", 40))),
    DIVINATION_50(new AchievementBuilder("Divination 50", 0, true).requirement(new Requirement("Divination", 50))),
    DIVINATION_60(new AchievementBuilder("Divination 60", 0, true).requirement(new Requirement("Divination", 60))),
    DIVINATION_70(new AchievementBuilder("Divination 70", 0, true).requirement(new Requirement("Divination", 70))),
    DIVINATION_80(new AchievementBuilder("Divination 80", 0, true).requirement(new Requirement("Divination", 80))),
    DIVINATION_90(new AchievementBuilder("Divination 90", 0, true).requirement(new Requirement("Divination", 90))),
    DIVINATION_92(new AchievementBuilder("Divination 92", 0, true).requirement(new Requirement("Divination", 92))),
    DIVINATION_99(new AchievementBuilder("Divination 99", 0, true).requirement(new Requirement("Divination", 99))),
    DIVINE_RETRIBUTION(new AchievementBuilder("Divine Retribution", 0, true).requirement(new Requirement("Business Is Booning", 1))
        .requirement(new Requirement("Collecting Memorabilia", 1)).requirement(new Requirement("Energy Generator", 1))
        .requirement(new Requirement("Enrichment Programme", 1)).requirement(new Requirement("Just Give Me a Sign", 1))
        .requirement(new Requirement("Let's Enhance", 1)).requirement(new Requirement("Mighty Morphing", 1))
        .requirement(new Requirement("Portentially Hazardous", 1)).requirement(new Requirement("Simply Divine", 1))
        .requirement(new Requirement("What an Experience", 1)).reward(new Reward("Flickering energy", 500))),
    DO_NO_ELITE(new AchievementBuilder("Do No Elite", 0, true).requirement(new Requirement("Do No Evil elite clue", 1))),
    DO_A_MINION_TAKE_NOTES(new AchievementBuilder("Do a Minion, Take Notes", 0, true).requirement(new Requirement("Dominion page", 20))),
    DOING_THE_IRONING(new AchievementBuilder("Doing the Ironing", 0, true).requirement(new Requirement("Mining", 15))
        .reward(new Reward("Iron ore", 1))),
    DONT_EAT_THE_POINTY_BIT(new AchievementBuilder("Don't Eat the Pointy Bit", 0, true).requirement(new Requirement("Coins", 25))
        .reward(new Reward("Skewered kebab", 1))),
    DONT_FEAR_THE_RIPPER(new AchievementBuilder("Don't Fear the Ripper", 0, true).requirement(new Requirement("Miner's journals", 6))),
    DOUBLE_SWOOP(new AchievementBuilder("Double Swoop", 0, true).requirement(new Requirement("Ranged", 70))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.FLIGHT_KILISA, Enemy.WINGMAN_SKREE, Enemy.FLOCKLEADER_GEERIN),
            Arrays.asList(Enemy.FLIGHT_KILISA, Enemy.WINGMAN_SKREE, Enemy.FLOCKLEADER_GEERIN, Enemy.KREEARRA))))),
    DRAGONKIN_LOGS(new AchievementBuilder("Dragonkin Logs", 0, true).requirement(new Requirement("Dragonkin journals", 4))),
    DRAYNOR(new AchievementBuilder("Draynor", 0, true)),
    DUKES_OF_KHAZARD(new AchievementBuilder("Dukes of Khazard", 0, true).encounter(new Encounter(Enemy.GNOME_TROOP))),
    DUNGEONEERING_GORDIE(new AchievementBuilder("Dungeoneering - Gordie", 0, true).requirement(new Requirement("Gordie", 1))),
    DUNGEONEERING_5(new AchievementBuilder("Dungeoneering 5", 0, true).requirement(new Requirement("Dungeoneering", 5))),
    DUNGEONEERING_10(new AchievementBuilder("Dungeoneering 10", 0, true).requirement(new Requirement("Dungeoneering", 10))),
    DUNGEONEERING_20(new AchievementBuilder("Dungeoneering 20", 0, true).requirement(new Requirement("Dungeoneering", 20))),
    DUNGEONEERING_30(new AchievementBuilder("Dungeoneering 30", 0, true).requirement(new Requirement("Dungeoneering", 30))),
    DUNGEONEERING_40(new AchievementBuilder("Dungeoneering 40", 0, true).requirement(new Requirement("Dungeoneering", 40))),
    DUNGEONEERING_50(new AchievementBuilder("Dungeoneering 50", 0, true).requirement(new Requirement("Dungeoneering", 50))),
    DUNGEONEERING_60(new AchievementBuilder("Dungeoneering 60", 0, true).requirement(new Requirement("Dungeoneering", 60))),
    DUNGEONEERING_70(new AchievementBuilder("Dungeoneering 70", 0, true).requirement(new Requirement("Dungeoneering", 70))),
    DUNGEONEERING_80(new AchievementBuilder("Dungeoneering 80", 0, true).requirement(new Requirement("Dungeoneering", 80))),
    DUNGEONEERING_90(new AchievementBuilder("Dungeoneering 90", 0, true).requirement(new Requirement("Dungeoneering", 90))),
    DUNGEONEERING_99(new AchievementBuilder("Dungeoneering 99", 0, true).requirement(new Requirement("Dungeoneering", 99))),
    DUNGEONEERING_110(new AchievementBuilder("Dungeoneering 110", 0, true).requirement(new Requirement("Dungeoneering", 110))),
    DUNGEONEERING_120(new AchievementBuilder("Dungeoneering 120", 0, true).requirement(new Requirement("Dungeoneering", 120))),
    DUSTING_MURIAL(new AchievementBuilder("Dusting Murial", 0, true).requirement(new Requirement("Dusted murals", 2))),
    EAGLES_PEAK(new AchievementBuilder("Eagles' Peak", 0, true)),
    EASTERN_ADVENTURER(new AchievementBuilder("Eastern Adventurer", 0, true).requirement(new Requirement("Port storylines", 4))),
    EASTERN_EXPLORER(new AchievementBuilder("Eastern Explorer", 0, true).requirement(new Requirement("The Shield region", 1))),
    EAT_TO_LIVE(new AchievementBuilder("Eat to Live", 0, true).requirement(new Requirement("Sardine", 1))),
    EDGEVILLE(new AchievementBuilder("Edgeville", 0, true)),
    EEEAGLE(new AchievementBuilder("Eeeeagle!", 0, true).requirement(new Requirement("Eagle transport routes", 5))),
    ELEMENTAL_KILL_CHAOS_I(new AchievementBuilder("Elemental Kill Chaos I", 0, true).requirement(new Requirement("Chaos Elemental", 5))),
    ELEMENTAL_KILL_CHAOS_II(new AchievementBuilder("Elemental Kill Chaos II", 0, true).requirement(new Requirement("Chaos Elemental", 10))),
    ELEMENTAL_KILL_CHAOS_III(new AchievementBuilder("Elemental Kill Chaos III", 0, true)
        .requirement(new Requirement("Chaos Elemental", 25))),
    ELEMENTAL_KILL_CHAOS_IV(new AchievementBuilder("Elemental Kill Chaos IV", 0, true).requirement(new Requirement("Chaos Elemental", 50))),
    ELEMENTAL_KILL_CHAOS_V(new AchievementBuilder("Elemental Kill Chaos V", 0, true).requirement(new Requirement("Chaos Elemental", 75))),
    ELEMENTAL_KILL_CHAOS_VI(new AchievementBuilder("Elemental Kill Chaos VI", 0, true)
        .requirement(new Requirement("Chaos Elemental", 100))),
    ELLIE(new AchievementBuilder("Ellie", 0, true).requirement(new Requirement("Ellie", 1))),
    ELVEN_TITLES(new AchievementBuilder("Elven Titles", 0, true).requirement(new Requirement("Elf City titles", 8))),
    ENERGY_GENERATOR(new AchievementBuilder("Energy Generator", 0, true).reward(new Reward("Pale energy", 1))
        .reward(new Reward("Divination", 1))),
    ENOUGH_OF_THE_CRAZY_WALKING(new AchievementBuilder("Enough of the Crazy Walking", 0, true)
        .requirement(new Requirement("Mad Ramblings", 2))),
    ENRICHMENT_PROGRAMME(new AchievementBuilder("Enrichment Programme", 0, true).reward(new Reward("Divination", 2))),
    EPI_LOGUEQUE_EXPERIENCE(new AchievementBuilder("Epi Logueque Experience", 0, true)
        .requirement(new Requirement("While Guthix Sleeps", 1)).lamp(new Lamp(Player.ALL_SKILLS, 100000, 65))
        .lamp(new Lamp(Player.ALL_SKILLS, 100000, 65)).lamp(new Lamp(Player.ALL_SKILLS, 100000, 65))
        .lamp(new Lamp(Player.ALL_SKILLS, 100000, 65))),
    ESSENTIAL_FACILITATOR(new AchievementBuilder("Essential Facilitator", 0, true)),
    EVERYBODY_LOVES_COAL(new AchievementBuilder("Everybody Loves Coal", 0, true).requirement(new Requirement("Mining", 30))
        .reward(new Reward("Coal", 1)).reward(new Reward("Mining", 50))),
    EXILED(new AchievementBuilder("Exiled", 0, true).requirement(new Requirement("Kalphite King uniques", 8))),
    EXPERIENCE_THE_FATE_OF_THE_GODS(new AchievementBuilder("Experience the Fate of the Gods", 0, true)
        .requirement(new Requirement("Post-Fate of the Gods lamps", 4))),
    EXPLORE_FOR_NESTOR(new AchievementBuilder("Explore for Nestor", 0, true)),
    FACELESS_AND_READY(new AchievementBuilder("Faceless and Ready", 0, true)),
    FALADOR(new AchievementBuilder("Falador", 0, true)),
    FALADOR_SET_TASKS_EASY(new AchievementBuilder("Falador Set Tasks - Easy", 0, true).requirement(new Requirement("The Good Stuff", 1))
        .requirement(new Requirement("Amulet of Weedspeak", 1)).requirement(new Requirement("Chain Store", 1))
        .requirement(new Requirement("Sir Mitt", 1)).requirement(new Requirement("Family Values", 1))
        .requirement(new Requirement("Sniffing Out the Mole", 1)).requirement(new Requirement("Chinchompa Powered!", 1))
        .requirement(new Requirement("Fill Yer Bucket", 1)).requirement(new Requirement("Elementary Medicine", 1))
        .requirement(new Requirement("It's Not Wabbit Season", 1)).requirement(new Requirement("Stand and Deliver", 1))
        .requirement(new Requirement("Making My Mind Up", 1)).requirement(new Requirement("Mudskip the Light Fantastic", 1))
        .requirement(new Requirement("Disarm and Embark", 1)).requirement(new Requirement("Going Along with the 'Fro", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, 1000, 30))),
    FALADOR_SET_TASKS_ELITE(new AchievementBuilder("Falador Set Tasks - Elite", 0, true)
        .requirement(new Requirement("When This Cavern's Rockin'...", 1)).requirement(new Requirement("You'd Best Come A-cookin'", 1))
        .requirement(new Requirement("Concentration is Key", 1)).requirement(new Requirement("I Swear I Heard It Scream", 1))
        .requirement(new Requirement("I've Changed My Mind!", 1)).requirement(new Requirement("A String and a Flare", 1))
        .requirement(new Requirement("Altar-ed State", 1)).lamp(new Lamp(Player.ALL_SKILLS, 30000, 90))
        .lamp(new Lamp(Player.ALL_SKILLS, 30000, 90)).lamp(new Lamp(Player.ALL_SKILLS, 50000, 84))
        .lamp(new Lamp(Player.ALL_SKILLS, 50000, 72))),
    FALADOR_SET_TASKS_HARD(new AchievementBuilder("Falador Set Tasks - Hard", 0, true).requirement(new Requirement("It Matches My Eyes", 1))
        .requirement(new Requirement("Child of Saradomin", 1)).requirement(new Requirement("Mass Production", 1))
        .requirement(new Requirement("It Spoiled My View", 1)).requirement(new Requirement("The Stonemasons", 1))
        .requirement(new Requirement("I Heard You Like Mudskips", 1)).requirement(new Requirement("The Mogre Mash", 1))
        .requirement(new Requirement("Why Oh Wyvern", 1)).requirement(new Requirement("Banned For Life", 1))
        .requirement(new Requirement("A Knight in the Darkness", 1)).lamp(new Lamp(Player.ALL_SKILLS, 10000, 50))),
    FALADOR_SET_TASKS_MEDIUM(new AchievementBuilder("Falador Set Tasks - Medium", 0, true)
        .requirement(new Requirement("Fruit of the Loom", 1)).requirement(new Requirement("Is It Hard to Walk Round?", 1))
        .requirement(new Requirement("Climbing the Walls", 1)).requirement(new Requirement("It's Nothing Personal", 1))
        .requirement(new Requirement("Ice the Icy", 1)).requirement(new Requirement("Blinded with Science", 1))
        .requirement(new Requirement("They Have Families to Feed", 1)).requirement(new Requirement("Stoic Sweetcorn Guardian", 1))
        .requirement(new Requirement("Look Spiffy For Tiffy", 1)).requirement(new Requirement("Do They Come in Other Colours", 1))
        .requirement(new Requirement("These Aren't the Coins You're Looking For", 1)).requirement(new Requirement("Kitty Litter", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, 5000, 40))),
    FALLEN_ANGEL(new AchievementBuilder("Fallen Angel", 0, true).requirement(new Requirement("Angel of Death uniques", 10))),
    FAMILY_AFFAIR(new AchievementBuilder("Family Affair", 0, true).requirement(new Requirement("Rise of the Six uniques", 10))),
    FAMILY_SPIRIT_TREE(new AchievementBuilder("Family Spirit Tree", 0, true).requirement(new Requirement("Grown spirit trees", 3))
        .reward(new Reward("Farming", 50000))),
    FAMOUS(new AchievementBuilder("Famous", 0, true).requirement(new Requirement("Morvran Slayer challenge", 1))
        .reward(new Reward("Slayer", 50000)).reward(new Reward("Slayer points", 45))),
    FARMING_BRAINS(new AchievementBuilder("Farming - Brains", 0, true).requirement(new Requirement("Brains", 1))),
    FARMING_5(new AchievementBuilder("Farming 5", 0, true).requirement(new Requirement("Farming", 5))),
    FARMING_10(new AchievementBuilder("Farming 10", 0, true).requirement(new Requirement("Farming", 10))),
    FARMING_20(new AchievementBuilder("Farming 20", 0, true).requirement(new Requirement("Farming", 20))),
    FARMING_30(new AchievementBuilder("Farming 30", 0, true).requirement(new Requirement("Farming", 30))),
    FARMING_40(new AchievementBuilder("Farming 40", 0, true).requirement(new Requirement("Farming", 40))),
    FARMING_50(new AchievementBuilder("Farming 50", 0, true).requirement(new Requirement("Farming", 50))),
    FARMING_60(new AchievementBuilder("Farming 60", 0, true).requirement(new Requirement("Farming", 60))),
    FARMING_70(new AchievementBuilder("Farming 70", 0, true).requirement(new Requirement("Farming", 70))),
    FARMING_80(new AchievementBuilder("Farming 80", 0, true).requirement(new Requirement("Farming", 80))),
    FARMING_90(new AchievementBuilder("Farming 90", 0, true).requirement(new Requirement("Farming", 90))),
    FARMING_92(new AchievementBuilder("Farming 92", 0, true).requirement(new Requirement("Farming", 92))),
    FARMING_99(new AchievementBuilder("Farming 99", 0, true).requirement(new Requirement("Farming", 99))),
    FAST_AND_FURIOUS_I(new AchievementBuilder("Fast and Furious I", 0, true).requirement(new Requirement("Twin Furies", 5))),
    FAST_AND_FURIOUS_II(new AchievementBuilder("Fast and Furious II", 0, true).requirement(new Requirement("Twin Furies", 10))),
    FAST_AND_FURIOUS_III(new AchievementBuilder("Fast and Furious III", 0, true).requirement(new Requirement("Twin Furies", 25))),
    FAST_AND_FURIOUS_IV(new AchievementBuilder("Fast and Furious IV", 0, true).requirement(new Requirement("Twin Furies", 50))),
    FAST_AND_FURIOUS_V(new AchievementBuilder("Fast and Furious V", 0, true).requirement(new Requirement("Twin Furies", 75))),
    FAST_AND_FURIOUS_VI(new AchievementBuilder("Fast and Furious VI", 0, true).requirement(new Requirement("Twin Furies", 100))),
    FEROCIOUS_UPGRADE(new AchievementBuilder("Ferocious Upgrade", 0, true).requirement(new Requirement("Slayer", 90))
        .requirement(new Requirement("Slayer point", 100))),
    FINAL_BOSS(new AchievementBuilder("Final Boss", 0, true).requirement(new Requirement("Who's the Boss? VI", 1))
        .requirement(new Requirement("General Mayhem VI", 1)).requirement(new Requirement("Zilly Way to Die VI", 1))
        .requirement(new Requirement("Three Heads are Deader than One VI", 1)).requirement(new Requirement("Mole Removal VI", 1))
        .requirement(new Requirement("Along Came a Spider VI", 1)).requirement(new Requirement("Bug Swatter VI", 1))
        .requirement(new Requirement("Vindictive and Vexatious VI", 1)).requirement(new Requirement("Fast and Furious VI", 1))
        .requirement(new Requirement("Elemental Kill Chaos VI", 1)).requirement(new Requirement("Hardly a Challenge VI", 1))
        .requirement(new Requirement("Barrowed Power VI", 1)).requirement(new Requirement("Come and Have Vorago VI", 1))
        .requirement(new Requirement("Nex Pls VI", 1)).requirement(new Requirement("Yak and Ruin VI", 1))
        .requirement(new Requirement("Bird is the Word VI", 1)).requirement(new Requirement("Kill K'ril VI", 1))
        .requirement(new Requirement("Corporeal Punishment VI", 1)).requirement(new Requirement("Loot Pinata VI", 1))
        .requirement(new Requirement("Descension VI", 1)).requirement(new Requirement("Dagannoth For Everyone VI", 1))
        .requirement(new Requirement("Telos Where it Hurts VI", 1)).requirement(new Requirement("This Helwyr in VI", 1))
        .requirement(new Requirement("Gregorgeous VI", 1)).requirement(new Requirement("Living on a Prayer Switch VI", 1))
        .requirement(new Requirement("Something Barrowed VI", 1)).requirement(new Requirement("Bug Zapper VI", 1))
        .requirement(new Requirement("Brass Nex VI", 1)).requirement(new Requirement("Master of Beatings VI", 1))),
    FINISH_HIM(new AchievementBuilder("Finish Him!", 0, true).encounter(new Encounter(Enemy.VORAGO))),
    FIREMAKING_BERNIE(new AchievementBuilder("Firemaking - Bernie", 0, true).requirement(new Requirement("Bernie", 1))),
    FIREMAKING_5(new AchievementBuilder("Firemaking 5", 0, true).requirement(new Requirement("Firemaking", 5))),
    FIREMAKING_10(new AchievementBuilder("Firemaking 10", 0, true).requirement(new Requirement("Firemaking", 10))),
    FIREMAKING_20(new AchievementBuilder("Firemaking 20", 0, true).requirement(new Requirement("Firemaking", 20))),
    FIREMAKING_30(new AchievementBuilder("Firemaking 30", 0, true).requirement(new Requirement("Firemaking", 30))),
    FIREMAKING_40(new AchievementBuilder("Firemaking 40", 0, true).requirement(new Requirement("Firemaking", 40))),
    FIREMAKING_50(new AchievementBuilder("Firemaking 50", 0, true).requirement(new Requirement("Firemaking", 50))),
    FIREMAKING_60(new AchievementBuilder("Firemaking 60", 0, true).requirement(new Requirement("Firemaking", 60))),
    FIREMAKING_70(new AchievementBuilder("Firemaking 70", 0, true).requirement(new Requirement("Firemaking", 70))),
    FIREMAKING_80(new AchievementBuilder("Firemaking 80", 0, true).requirement(new Requirement("Firemaking", 80))),
    FIREMAKING_90(new AchievementBuilder("Firemaking 90", 0, true).requirement(new Requirement("Firemaking", 90))),
    FIREMAKING_92(new AchievementBuilder("Firemaking 92", 0, true).requirement(new Requirement("Firemaking", 92))),
    FIREMAKING_99(new AchievementBuilder("Firemaking 99", 0, true).requirement(new Requirement("Firemaking", 99))),
    FIRES_ARE_MOSTLY_HARMLESS(new AchievementBuilder("Fires are Mostly Harmless", 0, true)
        .requirement(new Requirement("Fairy Tale III post-quest rewards", 2))),
    FIRST_RULE_OF_FIGHT_CAVES(new AchievementBuilder("First Rule of Fight Caves", 0, true)
        .requirement(new Requirement("TzHaar uniques", 1))),
    FISH_FINGERS(new AchievementBuilder("Fish Fingers", 0, true).requirement(new Requirement("Strength", 35))
        .requirement(new Requirement("Fishing", 55)).requirement(new Requirement("Barbarian Fishing Training", 1))
        .reward(new Reward("Fishing", 80)).reward(new Reward("Raw tuna", 1))),
    FISHING_BUBBLES(new AchievementBuilder("Fishing - Bubbles", 0, true).requirement(new Requirement("Bubbles", 1))),
    FISHING_5(new AchievementBuilder("Fishing 5", 0, true).requirement(new Requirement("Fishing", 5))),
    FISHING_10(new AchievementBuilder("Fishing 10", 0, true).requirement(new Requirement("Fishing", 10))),
    FISHING_20(new AchievementBuilder("Fishing 20", 0, true).requirement(new Requirement("Fishing", 20))),
    FISHING_30(new AchievementBuilder("Fishing 30", 0, true).requirement(new Requirement("Fishing", 30))),
    FISHING_40(new AchievementBuilder("Fishing 40", 0, true).requirement(new Requirement("Fishing", 40))),
    FISHING_50(new AchievementBuilder("Fishing 50", 0, true).requirement(new Requirement("Fishing", 50))),
    FISHING_60(new AchievementBuilder("Fishing 60", 0, true).requirement(new Requirement("Fishing", 60))),
    FISHING_70(new AchievementBuilder("Fishing 70", 0, true).requirement(new Requirement("Fishing", 70))),
    FISHING_80(new AchievementBuilder("Fishing 80", 0, true).requirement(new Requirement("Fishing", 80))),
    FISHING_90(new AchievementBuilder("Fishing 90", 0, true).requirement(new Requirement("Fishing", 90))),
    FISHING_92(new AchievementBuilder("Fishing 92", 0, true).requirement(new Requirement("Fishing", 92))),
    FISHING_99(new AchievementBuilder("Fishing 99", 0, true).requirement(new Requirement("Fishing", 99))),
    FIST_CONTACT(new AchievementBuilder("Fist Contact", 0, true).requirement(new Requirement("Strength", 70))
        .encounter(new Encounter(Enemy.GENERAL_GRAARDOR, Arrays.asList(new Restriction("Main-hand", 0), new Restriction("Off-hand", 0))))),
    FIVE_STAR_GENERAL(new AchievementBuilder("Five-Star General", 0, true).requirement(new Requirement("General Graardor uniques", 18))),
    FLETCHING_FLO(new AchievementBuilder("Fletching - Flo", 0, true).requirement(new Requirement("Flo", 1))),
    FLETCHING_5(new AchievementBuilder("Fletching 5", 0, true).requirement(new Requirement("Fletching", 5))),
    FLETCHING_10(new AchievementBuilder("Fletching 10", 0, true).requirement(new Requirement("Fletching", 10))),
    FLETCHING_20(new AchievementBuilder("Fletching 20", 0, true).requirement(new Requirement("Fletching", 20))),
    FLETCHING_30(new AchievementBuilder("Fletching 30", 0, true).requirement(new Requirement("Fletching", 30))),
    FLETCHING_40(new AchievementBuilder("Fletching 40", 0, true).requirement(new Requirement("Fletching", 40))),
    FLETCHING_50(new AchievementBuilder("Fletching 50", 0, true).requirement(new Requirement("Fletching", 50))),
    FLETCHING_60(new AchievementBuilder("Fletching 60", 0, true).requirement(new Requirement("Fletching", 60))),
    FLETCHING_70(new AchievementBuilder("Fletching 70", 0, true).requirement(new Requirement("Fletching", 70))),
    FLETCHING_80(new AchievementBuilder("Fletching 80", 0, true).requirement(new Requirement("Fletching", 80))),
    FLETCHING_90(new AchievementBuilder("Fletching 90", 0, true).requirement(new Requirement("Fletching", 90))),
    FLETCHING_92(new AchievementBuilder("Fletching 92", 0, true).requirement(new Requirement("Fletching", 92))),
    FLETCHING_99(new AchievementBuilder("Fletching 99", 0, true).requirement(new Requirement("Fletching", 99))),
    FLOOR_IS_LARVAL(new AchievementBuilder("Floor is Larval", 0, true).requirement(new Requirement("Summoning", 60))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM,
            Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM),
            Arrays.asList(Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM,
                Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM), Arrays.asList(Enemy.GIANT_WORM, Enemy.GIANT_WORM,
                Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM,
                Enemy.GIANT_WORM, Enemy.GIANT_WORM), Collections.singletonList(Enemy.QUEEN_BLACK_DRAGON))))),
    FOR_THE_LOVE_OF_MABEL(new AchievementBuilder("For the Love of Mabel", 0, true)
        .requirement(new Requirement("Love Story post-quest rewards", 1))),
    FORCAES_METTLE(new AchievementBuilder("Forcae's Mettle", 0, true).requirement(new Requirement("Forcae's journal page", 10))),
    FREDS_SHEARINGS(new AchievementBuilder("Fred's Shearings", 0, true).requirement(new Requirement("Sheep Shearer", 1))),
    FREMENNIK_PROVINCE(new AchievementBuilder("Fremennik Province", 0, true)),
    FREMENNIK_SET_TASKS_EASY(new AchievementBuilder("Fremennik Set Tasks - Easy", 0, true).requirement(new Requirement("King Conifer", 1))
        .requirement(new Requirement("Bring the Antipoisons", 1)).requirement(new Requirement("Why Won't You Die?", 1))
        .requirement(new Requirement("Assaulted Goodies", 1)).requirement(new Requirement("Oxymoron Incarnate", 1))
        .requirement(new Requirement("Why Did the Lobster Blush?", 1)).requirement(new Requirement("Hunting the Hunter", 1))
        .requirement(new Requirement("Peer of the Pier", 1)).requirement(new Requirement("A Familiar Feeling", 1))
        .requirement(new Requirement("Endangered Species", 1)).lamp(new Lamp(Player.ALL_SKILLS, 5000, 30))),
    FREMENNIK_SET_TASKS_ELITE(new AchievementBuilder("Fremennik Set Tasks - Elite", 0, true).requirement(new Requirement("Jaws Breaker", 1))
        .requirement(new Requirement("Limber Lumber Jumper", 1)).requirement(new Requirement("Astronomical!", 1))
        .requirement(new Requirement("First Stryke", 1)).requirement(new Requirement("Leap of Faith", 1))
        .requirement(new Requirement("No Smoke Without Pyre", 1)).requirement(new Requirement("This Hasta Work", 1))
        .requirement(new Requirement("Potting With Otto", 1)).requirement(new Requirement("Axe'll Grease", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, 40000, 89)).lamp(new Lamp(Player.ALL_SKILLS, 30000, 86))
        .lamp(new Lamp(Player.ALL_SKILLS, 30000, 86)).lamp(new Lamp(Player.ALL_SKILLS, 30000, 86))
        .lamp(new Lamp(Player.ALL_SKILLS, 30000, 86))),
    FREMENNIK_SET_TASKS_HARD(new AchievementBuilder("Fremennik Set Tasks - Hard", 0, true).requirement(new Requirement("Pyre At Will", 1))
        .requirement(new Requirement("Defeating Deadly Dagannoths", 1)).requirement(new Requirement("Dress to Impress", 1))
        .requirement(new Requirement("The Graceful Barbarian", 1)).requirement(new Requirement("Runes on the Moon", 1))
        .requirement(new Requirement("Fish Fingers", 1)).requirement(new Requirement("Easy As Pie", 1))
        .requirement(new Requirement("How to Maim Your Dragon", 1)).requirement(new Requirement("A Periodic Table", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, 15000, 50))),
    FREMENNIK_SET_TASKS_MEDIUM(new AchievementBuilder("Fremennik Set Tasks - Medium", 0, true).requirement(new Requirement("Yak Attack", 1))
        .requirement(new Requirement("Fremennik History 101", 1)).requirement(new Requirement("Cool Story, Bro", 1))
        .requirement(new Requirement("Who's a Good Boy?", 1)).requirement(new Requirement("Only Takes a Little Vial", 1))
        .requirement(new Requirement("You Know You Want It!", 1)).requirement(new Requirement("Fremmental", 1))
        .requirement(new Requirement("Fairy Mountaneering", 1)).requirement(new Requirement("You Really Don't Need Any More Shoes", 1))
        .requirement(new Requirement("Big Game Hunter", 1)).requirement(new Requirement("Grand Theft Fish", 1))
        .lamp(new Lamp(Player.ALL_SKILLS, 10000, 40))),
    FRIENDLY_NEIGHBOUR(new AchievementBuilder("Friendly Neighbour", 0, true).requirement(new Requirement("Araxxor uniques", 15))),
    FRIENDS_WITH_MAX(new AchievementBuilder("Friends with Max", 0, true).requirement(new Requirement("Agility", 99))
        .requirement(new Requirement("Attack", 99)).requirement(new Requirement("Strength", 99)).requirement(new Requirement("Defense", 99))
        .requirement(new Requirement("Ranged", 99)).requirement(new Requirement("Prayer", 99)).requirement(new Requirement("Invention", 99))
        .requirement(new Requirement("Constitution", 99)).requirement(new Requirement("Crafting", 99))
        .requirement(new Requirement("Mining", 99)).requirement(new Requirement("Smithing", 99)).requirement(new Requirement("Fishing", 99))
        .requirement(new Requirement("Cooking", 99)).requirement(new Requirement("Firemaking", 99))
        .requirement(new Requirement("Woodcutting", 99)).requirement(new Requirement("Runecrafting", 99))
        .requirement(new Requirement("Dungeoneering", 99)).requirement(new Requirement("Fletching", 99))
        .requirement(new Requirement("Herblore", 99)).requirement(new Requirement("Thieving", 99)).requirement(new Requirement("Magic", 99))
        .requirement(new Requirement("Slayer", 99)).requirement(new Requirement("Farming", 99))
        .requirement(new Requirement("Construction", 99)).requirement(new Requirement("Hunter", 99))
        .requirement(new Requirement("Summoning", 99)).requirement(new Requirement("Divination", 99))),
    GAME_OVER(new AchievementBuilder("Game Over", 0, true).requirement(new Requirement("Gregorovic uniques", 8))),
    GENERAL_AWWDOR(new AchievementBuilder("General Awwdor", 0, true).requirement(new Requirement("General Awwdor", 1))),
    GENERAL_DISASTER_I(new AchievementBuilder("General Disaster I", 0, true).requirement(new Requirement("General Graardor (hard)", 5))),
    GENERAL_DISASTER_II(new AchievementBuilder("General Disaster II", 0, true).requirement(new Requirement("General Graardor (hard)", 10))),
    GENERAL_DISASTER_III(new AchievementBuilder("General Disaster III", 0, true)
        .requirement(new Requirement("General Graardor (hard)", 25))),
    GENERAL_DISASTER_IV(new AchievementBuilder("General Disaster IV", 0, true).requirement(new Requirement("General Graardor (hard)", 50))),
    GENERAL_DISASTER_V(new AchievementBuilder("General Disaster V", 0, true).requirement(new Requirement("General Graardor (hard)", 75))),
    GENERAL_DISASTER_VI(new AchievementBuilder("General Disaster VI", 0, true)
        .requirement(new Requirement("General Graardor (hard)", 100))),
    GENERAL_MAYHEM_I(new AchievementBuilder("General Mayhem I", 0, true).requirement(new Requirement("General Graardor", 5))),
    GENERAL_MAYHEM_II(new AchievementBuilder("General Mayhem II", 0, true).requirement(new Requirement("General Graardor", 10))),
    GENERAL_MAYHEM_III(new AchievementBuilder("General Mayhem III", 0, true).requirement(new Requirement("General Graardor", 25))),
    GENERAL_MAYHEM_IV(new AchievementBuilder("General Mayhem IV", 0, true).requirement(new Requirement("General Graardor", 50))),
    GENERAL_MAYHEM_V(new AchievementBuilder("General Mayhem V", 0, true).requirement(new Requirement("General Graardor", 75))),
    GENERAL_MAYHEM_VI(new AchievementBuilder("General Mayhem VI", 0, true).requirement(new Requirement("General Graardor", 100))),
    GIFT_FROM_SLISKE(new AchievementBuilder("Gift from Sliske", 0, true).requirement(new Requirement("Sliske after-quest tasks", 2))),
    GLUTTON_FOR_PUNISHMENT(new AchievementBuilder("Glutton for Punishment", 0, true).requirement(new Requirement("Dreadfowl pouch", 1))
        .requirement(new Requirement("Thorny snail pouch", 1)).requirement(new Requirement("Pack pig pouch", 1))
        .requirement(new Requirement("Evil turnip pouch", 1)).requirement(new Requirement("War tortoise pouch", 1))
        .requirement(new Requirement("Fruit bat pouch", 1)).requirement(new Requirement("Granite lobster pouch", 1))
        .requirement(new Requirement("Bringing Home the Bacon", 1)).requirement(new Requirement("Summer's End", 1))
        .requirement(new Requirement("Summoning", 74))),
    GOD_WARS_DUNGEON_TELEPORT(new AchievementBuilder("God Wars Dungeon Teleport", 0, true).requirement(new Requirement("Law rune", 2))
        .requirement(new Requirement("The Mighty Fall", 1)).requirement(new Requirement("Fire rune", 2))
        .requirement(new Requirement("Magic", 61)).reward(new Reward("Magic", 68))),
    GOEBIE_RELICS(new AchievementBuilder("Goebie Relics", 0, true).requirement(new Requirement("Stone fragments", 5))),
    GOING_DOWN_WITH_THE_SHIP(new AchievementBuilder("Going Down with the Ship", 0.2, true).requirement(new Requirement("Fishing", 15))),
    GOING_FOR_A_PUNT(new AchievementBuilder("Going for a Punt", 0, true).requirement(new Requirement("Boater", 1))
        .requirement(new Requirement("Woodcutting", 57)).reward(new Reward("Woodcutting", 150))),
    GOING_ON_A_SUMMER_HOLIDAY(new AchievementBuilder("Going on a Summer Holidat", 0, true).requirement(new Requirement("Coins", 30))),
    GONE_FISHING(new AchievementBuilder("Gone Fishing", 0, true).requirement(new Requirement("Fishing", 15))),
    GONG_MAINTENACE_EXPERT(new AchievementBuilder("Gong Maintenance Expert", 0, true)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CORMES),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
            Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG))))),
    GOOD_ENOUGH_FOR_A_GOBLIN(new AchievementBuilder("Good Enough for a Goblin", 0, true).requirement(new Requirement("Summer's End", 1))
        .encounter(new Encounter(Enemy.CORPOREAL_BEAST, Collections.singletonList(new Restriction("Bronze spear", 1))))),
    GOT_A_VYRE_REPUTATION(new AchievementBuilder("Got a Vyre Reputation", 0, true)
        .requirement(new Requirement("Maximum vyre reputation", 1))),
    GRAARDONE(new AchievementBuilder("Graardone", 0, true).requirement(new Requirement("Strength", 70))
        .encounter(new Encounter(Enemy.GENERAL_GRAARDOR, Collections.singletonList(new Restriction("Ticks", 25))))),
    GREAT_GIELINOR_RUN(new AchievementBuilder("Great Gielinor Run", 0.25, true).requirement(new Requirement("The Branches of Darkmeyer", 1))
        .requirement(new Requirement("Regicide", 1))),
    GREG(new AchievementBuilder("Greg", 0, true).requirement(new Requirement("Greg", 1))),
    GREGOREY_I(new AchievementBuilder("Gregore-Y I", 0, true).requirement(new Requirement("Gregorovic (hard)", 5))),
    GREGOREY_II(new AchievementBuilder("Gregore-Y II", 0, true).requirement(new Requirement("Gregorovic (hard)", 10))),
    GREGOREY_III(new AchievementBuilder("Gregore-Y III", 0, true).requirement(new Requirement("Gregorovic (hard)", 25))),
    GREGOREY_IV(new AchievementBuilder("Gregore-Y IV", 0, true).requirement(new Requirement("Gregorovic (hard)", 50))),
    GREGOREY_V(new AchievementBuilder("Gregore-Y V", 0, true).requirement(new Requirement("Gregorovic (hard)", 75))),
    GREGOREY_VI(new AchievementBuilder("Gregore-Y VI", 0, true).requirement(new Requirement("Gregorovic (hard)", 100))),
    GREGORGEOUS_I(new AchievementBuilder("Gregorgeous I", 0, true).requirement(new Requirement("Gregorovic", 5))),
    GREGORGEOUS_II(new AchievementBuilder("Gregorgeous II", 0, true).requirement(new Requirement("Gregorovic", 10))),
    GREGORGEOUS_III(new AchievementBuilder("Gregorgeous III", 0, true).requirement(new Requirement("Gregorovic", 25))),
    GREGORGEOUS_IV(new AchievementBuilder("Gregorgeous IV", 0, true).requirement(new Requirement("Gregorovic", 50))),
    GREGORGEOUS_V(new AchievementBuilder("Gregorgeous V", 0, true).requirement(new Requirement("Gregorovic", 75))),
    GREGORGEOUS_VI(new AchievementBuilder("Gregorgeous VI", 0, true).requirement(new Requirement("Gregorovic", 100))),
    GRINDING_MY_GEARS(new AchievementBuilder("Grinding My Gears", 0, true).requirement(new Requirement("Wheat", 1))
        .requirement(new Requirement("Empty pot", 1)).reward(new Reward("Pot of flour", 1))),
    GRONDABANS_LEGACY(new AchievementBuilder("Grondaban's legacy", 0, true).requirement(new Requirement("Dishonour among Thieves", 1))),
    GUARD_IS_DEAD(new AchievementBuilder("Guard is Dead", 0, true)
        .requirement(new Requirement("Dimension of Disaster: Coin of the Realm", 1)).encounter(new Encounter(Enemy.NEW_VARROCK_GUARD))
        .reward(new Reward("Zemomark", 80))),
    GUNNING_FOR_JEWELLERY(new AchievementBuilder("Gunning for Jewellery", 0, true).requirement(new Requirement("Dororan's jewellery", 3))),
    GUTHAN_BOBBLEHEAD(new AchievementBuilder("Guthan Bobblehead", 0, true).requirement(new Requirement("Guthan the Bobbled", 1))),
    HAIL_TO_THE_QUEEN(new AchievementBuilder("Hail to the Queen", 0, true)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KALPHITE_GUARDIAN, Enemy.KALPHITE_GUARDIAN, Enemy.KALPHITE_QUEEN_PHASE_1),
            Collections.singletonList(Enemy.KALPHITE_QUEEN_PHASE_2))))),
    HAIL_TO_THE_DUKE_BABY(new AchievementBuilder("Hail to the Duke, Baby", 0, true)),
    HAND_EXCHANGE(new AchievementBuilder("Hand Exchange", 0, true)
        .requirement(new Requirement("Dimension of Disaster: Coin of the Realm", 1)).reward(new Reward("Zemomark", 20))),
    HANDICRAFTS(new AchievementBuilder("Handicrafts", 0, true).requirement(new Requirement("Thread", 1))
        .requirement(new Requirement("Leather", 1)).reward(new Reward("Crafting", 14)).reward(new Reward("Leather gloves", 1))),
    HANG_ON_TO_SOMETHING(new AchievementBuilder("Hang On to Something", 0, true)),
    HAPPY_HOUR(new AchievementBuilder("Happy Hour", 0, true).requirement(new Requirement("Cider", 5))),
    HARD_AS_DAEMONS(new AchievementBuilder("Hard As Daemons", 0, true).requirement(new Requirement("Hard mode floors", 60))),
    HARD_AS_A_ROCK(new AchievementBuilder("Hard as a Rock", 0, true).requirement(new Requirement("Vorago uniques", 11))),
    HARDLY_A_CHALLENGE_I(new AchievementBuilder("Hardly a Challenge I", 0, true).requirement(new Requirement("Har-Aken", 5))),
    HARDLY_A_CHALLENGE_II(new AchievementBuilder("Hardly a Challenge II", 0, true).requirement(new Requirement("Har-Aken", 10))),
    HARDLY_A_CHALLENGE_III(new AchievementBuilder("Hardly a Challenge III", 0, true).requirement(new Requirement("Har-Aken", 25))),
    HARDLY_A_CHALLENGE_IV(new AchievementBuilder("Hardly a Challenge IV", 0, true).requirement(new Requirement("Har-Aken", 50))),
    HARDLY_A_CHALLENGE_V(new AchievementBuilder("Hardly a Challenge V", 0, true).requirement(new Requirement("Har-Aken", 75))),
    HARDLY_A_CHALLENGE_VI(new AchievementBuilder("Hardly a Challenge VI", 0, true).requirement(new Requirement("Har-Aken", 100))),
    HAUL_COMES_TO_TEMPLETON(new AchievementBuilder("Haul Comes to Templeton", 0.05, true)
        .requirement(new Requirement("Dealing with Scabaras", 1))),
    HEAL_QUICKLY(new AchievementBuilder("Heal, Quickly", 0, true).requirement(new Requirement("Rapid Renewal", 1))),
    HEART_TO_HEART(new AchievementBuilder("Heart to Heart", 0, true).requirement(new Requirement("Twin Furies uniques", 9))),
    HEL_IN_A_HANDBASKET_I(new AchievementBuilder("Hel in a Handbasket I", 0, true).requirement(new Requirement("Helwyr (hard)", 5))),
    HEL_IN_A_HANDBASKET_II(new AchievementBuilder("Hel in a Handbasket II", 0, true).requirement(new Requirement("Helwyr (hard)", 10))),
    HEL_IN_A_HANDBASKET_III(new AchievementBuilder("Hel in a Handbasket III", 0, true).requirement(new Requirement("Helwyr (hard)", 25))),
    HEL_IN_A_HANDBASKET_IV(new AchievementBuilder("Hel in a Handbasket IV", 0, true).requirement(new Requirement("Helwyr (hard)", 50))),
    HEL_IN_A_HANDBASKET_V(new AchievementBuilder("Hel in a Handbasket V", 0, true).requirement(new Requirement("Helwyr (hard)", 75))),
    HEL_IN_A_HANDBASKET_VI(new AchievementBuilder("Hel in a Handbasket VI", 0, true).requirement(new Requirement("Helwyr (hard)", 100))),
    HERBIS_FLAX(new AchievementBuilder("Herbi's Flax", 0, true).requirement(new Requirement("Diary of Herbi Flax", 1))
        .reward(new Reward("Herblore", 335))),
    HERBLORE_HERBERT(new AchievementBuilder("Herblore - Herbert", 0, true).requirement(new Requirement("Herbert", 1))),
    HERBLORE_5(new AchievementBuilder("Herblore 5", 0, true).requirement(new Requirement("Herblore", 5))),
    HERBLORE_10(new AchievementBuilder("Herblore 10", 0, true).requirement(new Requirement("Herblore", 10))),
    HERBLORE_20(new AchievementBuilder("Herblore 20", 0, true).requirement(new Requirement("Herblore", 20))),
    HERBLORE_30(new AchievementBuilder("Herblore 30", 0, true).requirement(new Requirement("Herblore", 30))),
    HERBLORE_40(new AchievementBuilder("Herblore 40", 0, true).requirement(new Requirement("Herblore", 40))),
    HERBLORE_50(new AchievementBuilder("Herblore 50", 0, true).requirement(new Requirement("Herblore", 50))),
    HERBLORE_60(new AchievementBuilder("Herblore 60", 0, true).requirement(new Requirement("Herblore", 60))),
    HERBLORE_70(new AchievementBuilder("Herblore 70", 0, true).requirement(new Requirement("Herblore", 70))),
    HERBLORE_80(new AchievementBuilder("Herblore 80", 0, true).requirement(new Requirement("Herblore", 80))),
    HERBLORE_90(new AchievementBuilder("Herblore 90", 0, true).requirement(new Requirement("Herblore", 90))),
    HERBLORE_92(new AchievementBuilder("Herblore 92", 0, true).requirement(new Requirement("Herblore", 92))),
    HERBLORE_99(new AchievementBuilder("Herblore 99", 0, true).requirement(new Requirement("Herblore", 99))),
    HERE_WAS_A_SCABARAS_MASK(new AchievementBuilder("Here Was a Scabaras Mask", 0.05, true).requirement(new Requirement("Mining", 80))
        .requirement(new Requirement("Diamond in the Rough", 1)).reward(new Reward("Mining", 20000)).reward(new Reward("Scabaras mask", 1))
        .reward(new Reward("Was", 1))),
    HERE_WE_RAGO_AGAIN_I(new AchievementBuilder("Here We Rago Again I", 0, true).requirement(new Requirement("Vorago (hard)", 5))),
    HERE_WE_RAGO_AGAIN_II(new AchievementBuilder("Here We Rago Again II", 0, true).requirement(new Requirement("Vorago (hard)", 10))),
    HERE_WE_RAGO_AGAIN_III(new AchievementBuilder("Here We Rago Again III", 0, true).requirement(new Requirement("Vorago (hard)", 25))),
    HERE_WE_RAGO_AGAIN_IV(new AchievementBuilder("Here We Rago Again IV", 0, true).requirement(new Requirement("Vorago (hard)", 50))),
    HERE_WE_RAGO_AGAIN_V(new AchievementBuilder("Here We Rago Again V", 0, true).requirement(new Requirement("Vorago (hard)", 75))),
    HERE_WE_RAGO_AGAIN_VI(new AchievementBuilder("Here We Rago Again VI", 0, true).requirement(new Requirement("Vorago (hard)", 100))),
    HERO_OF_THE_GOEBIES(new AchievementBuilder("Hero of the Goebies", 0, true).requirement(new Requirement("All Together Now", 1))
        .requirement(new Requirement("Animal Cruelty", 1)).requirement(new Requirement("Better Not Touch", 1))
        .requirement(new Requirement("Cormes and Goes", 1)).requirement(new Requirement("Day at the Aquarium", 1))
        .requirement(new Requirement("Day at the Pound", 1)).requirement(new Requirement("Gong Maintenance Expert", 1))
        .requirement(new Requirement("Make Friends and Influence People", 1)).requirement(new Requirement("Prison Break", 1))
        .requirement(new Requirement("Rewind", 1))),
    HIDE_AND_SEEK(new AchievementBuilder("Hide and Seek", 0, true).requirement(new Requirement("Zombie cowhide", 1))
        .requirement(new Requirement("Dimension of Disaster: Coin of the Realm", 1)).reward(new Reward("Leather", 1))
        .reward(new Reward("Zemomark", 20))),
    HISTORY_OF_BILRACH(new AchievementBuilder("History of Bilrach", 0, true).requirement(new Requirement("Mysterious chronicle", 30))),
    HONESTLY_ITS_NOT_A_PURSE(new AchievementBuilder("Honestly, It's Not a Purse", 0, true).requirement(new Requirement("Giant pouch", 1))
        .requirement(new Requirement("Pure essence", 1))),
    HOW_MANY_GAMES(new AchievementBuilder("How Many Games?", 0, true).requirement(new Requirement("Profound helmet", 1))
        .requirement(new Requirement("Profound chestplate", 1)).requirement(new Requirement("Profound platelegs", 1))
        .requirement(new Requirement("Profound sword", 1)).requirement(new Requirement("Profound shield", 1))),
    HOW_TO_SHAME_YOUR_DRAGON(new AchievementBuilder("How to Shame Your Dragon", 0, true)
        .requirement(new Requirement("King Black Dragon uniques", 1))),
    HUNGRY_HUNGRY_REAVERS(new AchievementBuilder("Hungry Hungry Reavers", 0, true).requirement(new Requirement("Frozen key", 1))
        .encounter(new Encounter(Enemy.NEX_ANGEL_OF_DEATH))),
    HUNTER_ACE(new AchievementBuilder("Hunter - Ace", 0, true).requirement(new Requirement("Ace", 1))),
    HUNTER_5(new AchievementBuilder("Hunter 5", 0, true).requirement(new Requirement("Hunter", 5))),
    HUNTER_10(new AchievementBuilder("Hunter 10", 0, true).requirement(new Requirement("Hunter", 10))),
    HUNTER_20(new AchievementBuilder("Hunter 20", 0, true).requirement(new Requirement("Hunter", 20))),
    HUNTER_30(new AchievementBuilder("Hunter 30", 0, true).requirement(new Requirement("Hunter", 30))),
    HUNTER_40(new AchievementBuilder("Hunter 40", 0, true).requirement(new Requirement("Hunter", 40))),
    HUNTER_50(new AchievementBuilder("Hunter 50", 0, true).requirement(new Requirement("Hunter", 50))),
    HUNTER_60(new AchievementBuilder("Hunter 60", 0, true).requirement(new Requirement("Hunter", 60))),
    HUNTER_70(new AchievementBuilder("Hunter 70", 0, true).requirement(new Requirement("Hunter", 70))),
    HUNTER_80(new AchievementBuilder("Hunter 80", 0, true).requirement(new Requirement("Hunter", 80))),
    HUNTER_90(new AchievementBuilder("Hunter 90", 0, true).requirement(new Requirement("Hunter", 90))),
    HUNTER_92(new AchievementBuilder("Hunter 92", 0, true).requirement(new Requirement("Hunter", 92))),
    HUNTER_99(new AchievementBuilder("Hunter 99", 0, true).requirement(new Requirement("Hunter", 99))),
    IM_FOREVER_WASHING_SHADOWS(new AchievementBuilder("I'm Forever Washing Shadows", 0, true)
        .requirement(new Requirement("Blissful shadow core drops", 15)).requirement(new Requirement("Truthful shadow core drops", 15))
        .requirement(new Requirement("Manifest shadow core drops", 15)).reward(new Reward("Divination", 50000))),
    I_CAN_SEE_FOR_MILES_AND_MILES(new AchievementBuilder("I Can See For Miles and Miles", 0, true)
        .requirement(new Requirement("Beacon keepers with macaws", 12))),
    I_DIG_THIS_TRANSPORTATION(new AchievementBuilder("I Dig This Transportation", 0, true)
        .requirement(new Requirement("Digsite pendant unlock", 1))),
    I_GOT_THIS(new AchievementBuilder("I Got This", 0, true).requirement(new Requirement("Slayer", 95))
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.LEGIO), Collections.singletonList(Enemy.LEGIO),
            Collections.singletonList(Enemy.LEGIO), Collections.singletonList(Enemy.LEGIO), Collections.singletonList(Enemy.LEGIO),
            Collections.singletonList(Enemy.LEGIO))))),
    I_PRESUME_THESE_REWARDS_ARE_MINE_DEATH(new AchievementBuilder("I Presume Thes Rewards Are Mine, Death?", 0, true)
        .requirement(new Requirement("Missing, Presumed Death post-quest rewards", 4))),
    ICE_ICE_CHIMPY(new AchievementBuilder("Ice Ice Chimpy", 0, true).requirement(new Requirement("Chimp ice deliveries", 25))),
    ICTHLARINS_LITTLE_CHEST(new AchievementBuilder("Icthlarin's Little Chest", 0, true)
        .requirement(new Requirement("Icthlarin's Little Helper", 1)).reward(new Reward("Coins", 50))),
    IMPING_AROUND(new AchievementBuilder("Imping Around", 0, true).requirement(new Requirement("Daffyd implings", 16))
        .reward(new Reward("Hunter", 50000))),
    IMPRESSING_CHAR(new AchievementBuilder("Impressing Char", 0, true).requirement(new Requirement("The Firemaker's Curse", 1))
        .requirement(new Requirement("Firemaking", 91)).reward(new Reward("Firemaking", 7387))),
    IN_THE_SPIRIT_OF_THINGS(new AchievementBuilder("In the Spirit of Things", 0, true).requirement(new Requirement("Prayer", 80))
        .encounter(new Encounter(Enemy.GREGOROVIC))),
    INSANE_FINAL_BOSS(new AchievementBuilder("Insane Final Boss", 0, true).requirement(new Requirement("Final Boss", 1))
        .requirement(new Requirement("Birdstrike VI", 1)).requirement(new Requirement("General Disaster", 1))
        .requirement(new Requirement("Gregore-Y VI", 1)).requirement(new Requirement("Hel in a Handbasket VI", 1))
        .requirement(new Requirement("Here We Rago Again VI", 1)).requirement(new Requirement("Kill K'ril Vol 2 VI", 1))
        .requirement(new Requirement("More Fast More Furious", 1)).requirement(new Requirement("Vindictive VI", 1))
        .requirement(new Requirement("Whack a Mole VI", 1)).requirement(new Requirement("Zillier Way to Die VI", 1))
        .requirement(new Requirement("Boss pets", 46))),
    INVENTION_MALCOLM(new AchievementBuilder("Invention - Malcolm", 0, true).requirement(new Requirement("Malcolm", 1))),
    INVENTION_5(new AchievementBuilder("Invention 5", 0, true).requirement(new Requirement("Invention", 5))),
    INVENTION_10(new AchievementBuilder("Invention 10", 0, true).requirement(new Requirement("Invention", 10))),
    INVENTION_20(new AchievementBuilder("Invention 20", 0, true).requirement(new Requirement("Invention", 20))),
    INVENTION_30(new AchievementBuilder("Invention 30", 0, true).requirement(new Requirement("Invention", 30))),
    INVENTION_40(new AchievementBuilder("Invention 40", 0, true).requirement(new Requirement("Invention", 40))),
    INVENTION_50(new AchievementBuilder("Invention 50", 0, true).requirement(new Requirement("Invention", 50))),
    INVENTION_60(new AchievementBuilder("Invention 60", 0, true).requirement(new Requirement("Invention", 60))),
    INVENTION_70(new AchievementBuilder("Invention 70", 0, true).requirement(new Requirement("Invention", 70))),
    INVENTION_80(new AchievementBuilder("Invention 80", 0, true).requirement(new Requirement("Invention", 80))),
    INVENTION_90(new AchievementBuilder("Invention 90", 0, true).requirement(new Requirement("Invention", 90))),
    INVENTION_99(new AchievementBuilder("Invention 99", 0, true).requirement(new Requirement("Invention", 99))),
    INVENTION_102(new AchievementBuilder("Invention 102", 0, true).requirement(new Requirement("Invention", 102))),
    INVENTION_110(new AchievementBuilder("Invention 110", 0, true).requirement(new Requirement("Invention", 110))),
    INVENTION_120(new AchievementBuilder("Invention 120", 0, true).requirement(new Requirement("Invention", 120))),
    INVENTION_GIVES_ME_THE_BLUES(new AchievementBuilder("Invention Gives Me the Blues", 0, true)
        .requirement(new Requirement("Dwarven tech tree items", 8)).requirement(new Requirement("Cave goblin tech tree items", 8))),
    ITS_NOT_CALLED_SURGING_TOMBS(new AchievementBuilder("It's Not Called Surging Tombs", 0.05, true)
        .requirement(new Requirement("The Jack of Spades", 1)).reward(new Reward("Shifting Tombs", 1))),
    IVAN_IS_FLAILING(new AchievementBuilder("Ivan is Flailing", 0, true).requirement(new Requirement("Vyre corpses", 500))),
    JACK_OF_ALL_BLADES(new AchievementBuilder("Jack of All Blades", 0, true).requirement(new Requirement("Combat skilling pets", 9))),
    JACK_OF_ALL_TRADES(new AchievementBuilder("Jack of All Trades", 0, true).requirement(new Requirement("Non-combat skilling pets", 18))),
    JACK_OF_BLADES(new AchievementBuilder("Jack of Blades", 0, true).requirement(new Requirement("Combat skilling pets", 3))),
    JACK_OF_TRADES(new AchievementBuilder("Jack of Trades", 0, true).requirement(new Requirement("Non-combat skilling pets", 5))),
    JACK_OF_THE_CIRCUS(new AchievementBuilder("Jack of the Circus", 0, true).requirement(new Requirement("Circus clothing", 26))),
    JUST_GIVE_ME_A_SIGN(new AchievementBuilder("Just Give Me a Sign", 0, true).requirement(new Requirement("Divination", 6))
        .requirement(new Requirement("Pale energy", 30)).requirement(new Requirement("Sapphire necklace", 1))
        .reward(new Reward("Sign of the porter I", 1)).reward(new Reward("Divination", 2))),
    KRIL_TINYROTH(new AchievementBuilder("K'ril Tinyroth", 0, true).requirement(new Requirement("K'ril Tinyroth", 1)));
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
			Collections.singletonList(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Magic", "Ranged"), 1500))),
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
	RECRUITMENT_DRIVE_PRAYER_LAMP("Recruitment Drive prayer lamp", 0, true)Arrays.asList(new Requirement("Recruitment Drive", 1), new Requirement("Prayer", 8)),
			new ArrayList<>(), Collections.singletonList(new Reward("Prayer", 1000)), new ArrayList<>(), false),
	RECRUITMENT_DRIVE_HERBLORE_LAMP("Recruitment Drive herblore lamp", 0, true)Arrays.asList(new Requirement("Recruitment Drive", 1),
			new Requirement("Herblore", 8)), new ArrayList<>(), Collections.singletonList(new Reward("Herblore", 1000)), new ArrayList<>(), false),
	RECRUITMENT_DRIVE_AGILITY_LAMP("Recruitment Drive agility lamp", 0, true)Arrays.asList(new Requirement("Recruitment Drive", 1),
			new Requirement("Agility", 8)), new ArrayList<>(), Collections.singletonList(new Reward("Agility", 1000)), new ArrayList<>(), false),
	BUY_A_PLAYER_OWNED_HOUSE("Buy a player-owned house", 0, true)Collections.singletonList(new Requirement("Coins", 1000)),
			new ArrayList(), Collections.singletonList(new Reward("Player-owned house", 1)), new ArrayList<>(), false),
	BUILD_A_PARLOUR("Build a parlour", 0, true)Arrays.asList(new Requirement("Player-owned house", 1), new Requirement("Coins", 1000)),
			new ArrayList(), Collections.singletonList(new Reward("Parlour", 1)), new ArrayList<>(), false),
	STOLEN_HEARTS("Stolen Hearts", 1, new ArrayList<>(), Collections.singletonList(new Encounter(Arrays.asList(Enemy.SKULLS_MERCENARY, Enemy.SKULLS_MERCENARY, Enemy.SKULLS_MERCENARY))),
			Arrays.asList(new Reward("Quest Points", 3), new Reward("Coins", 2500), new Reward("Constitution", 250),
			new Reward("Agility", 250), new Reward("Thieving", 250), new Reward("Stolen Hearts", 1)),
			Collections.singletonList(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Magic", "Constitution", "Ranged", "Prayer"), 250))),
	DIAMOND_IN_THE_ROUGH("Diamond in the Rough", 1, Collections.singletonList(new Requirement("Stolen Hearts", 1)),
			Arrays.asList(new Encounter(Arrays.asList(Enemy.BANDIT, Enemy.BANDIT, Enemy.BANDIT_KING)), new Encounter(Arrays.asList(Enemy.APEP, Enemy.HERU))),
			Arrays.asList(new Reward("Diamond in the Rough", 1), new Reward("Quest Points", 1), new Reward("Agility", 250),
					new Reward("Thieving", 250), new Reward("Constitution", 250), new Reward("Sapphire", 1),
					new Reward("Emerald", 1), new Reward("Ruby", 1)), Collections.singletonList(new Lamp(Arrays.asList("Attack",
			"Strength", "Defense", "Magic", "Constitution", "Ranged", "Prayer"), 250))),
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
	GERTRUDES_CAT_LAMP("Gertrude's Cat Lamp", 0, true)Arrays.asList(new Requirement("Gertrude's Cat", 1), new Requirement("Cooking", 14)),
			new ArrayList<>(), Collections.singletonList(new Reward("Cooking", 1525)), new ArrayList<>(), false),;*/

    private String name; //name of the task
    private double time; //est. time taken in hours [not including time to gather items/complete requirements]
    private List<Requirement> reqs; //list of requirements
    private List<Encounter> encounters; //list of combat encounters
    private List<Reward> rewards; //list of static rewards
    private List<Lamp> lamps; //list of lamps
    private boolean display; //if task is a "true" achievement, and should be displayed on the task list

    Achievement(AchievementBuilder builder) {
        this.name = builder.name;
        this.time = builder.time;
        this.reqs = builder.reqs;
        this.encounters = builder.encounters;
        this.rewards = builder.rewards;
        this.lamps = builder.lamps;
        this.display = builder.display;
    }

    private static class AchievementBuilder {

        private String name;
        private double time;
        private List<Requirement> reqs;
        private List<Encounter> encounters;
        private List<Reward> rewards;
        private List<Lamp> lamps;
        private boolean display;

        public AchievementBuilder(String name, double time, boolean display) {
            this.name = name;
            this.time = time;
            this.display = display;
            this.reqs = new ArrayList<>();
            this.encounters = new ArrayList<>();
            this.rewards = new ArrayList<>();
            this.lamps = new ArrayList<>();
        }

        public AchievementBuilder requirement(Requirement requirement) {
            reqs.add(requirement);
            return this;
        }

        public AchievementBuilder encounter(Encounter encounter) {
            encounters.add(encounter);
            return this;
        }

        public AchievementBuilder reward(Reward reward) {
            rewards.add(reward);
            return this;
        }

        public AchievementBuilder lamp(Lamp lamp) {
            lamps.add(lamp);
            return this;
        }
    }

    public GoalResults getTimeForRequirements(Player player) {
        double totalTimeForAllReqs = 0;
        Map<String, Double> totalActionsWithTimesForAllReqs = new HashMap<>();
        List<Requirement> recursiveRequirements = new ArrayList<>();
        Map<String, Double> originalMap = player.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        List<Weapon> weaponList = new ArrayList<>(player.getWeapons());
        for (Requirement r : reqs) {
            GoalResults resultsForOneRequirement = r.timeAndActionsToMeetRequirement(player);
            for (Entry<String, Double> actionWithTime : resultsForOneRequirement.getActionsWithTimes().entrySet()) {
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
            CombatResults meleeCombatResults = e.calculateCombat(player, 27, "Melee");
            CombatResults rangedCombatResults = e.calculateCombat(player, 27, "Ranged");
            CombatResults magicCombatResults = e.calculateCombat(player, 27, "Magic");
            if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000) {
                //System.out.println("Time to update the combat simulator");
                totalTimeForAllReqs += 2147000.0;
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
            } catch (NullPointerException e) { //can't access lamp yet
                totalGainFromAllRewards -= 1000000000;
            }
        }
        for (Encounter e : encounters) {
            for (List<Enemy> enemyGroup : e.getEnemyGroups())
                for (Enemy enemy : enemyGroup)
                    totalGainFromAllRewards += player.efficientGoalCompletion("Constitution", (int) enemy.getHpxp()).getTotalTime();
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