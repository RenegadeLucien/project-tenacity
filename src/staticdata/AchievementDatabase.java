package staticdata;

import dynamicdata.Encounter;
import dynamicdata.Player;
import dynamicdata.Restriction;
import staticdata.Achievement.AchievementBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*This class lists not only achievements, but all non-repeatables.
TODO: put list in topological order of requirements (all achievements are listed after their prerequisites.)*/
public class AchievementDatabase {

    private static AchievementDatabase achievementDatabase;

    private List<Achievement> achievements;

    private AchievementDatabase() {
        achievements = new ArrayList<>();
        addAchievementsA();
        addAchievementsB();
        addAchievementsC();
        addAchievementsD();
        addAchievementsE();
        addAchievementsF();
        addAchievementsG();
        addAchievementsH();
        addAchievementsI();
        addAchievementsJ();
        addAchievementsK();
        addAchievementsL();
        addAchievementsM();
        addAchievementsN();
        addAchievementsO();
        addAchievementsP();
        addAchievementsQ();
        addAchievementsR();
        addAchievementsS();
        addAchievementsT();
        addAchievementsU();
        addAchievementsV();
        addAchievementsW();
        addAchievementsX();
        addAchievementsY();
        addAchievementsZ();
    }

    private void addAchievementsA() {
        achievements.add(new AchievementBuilder("A-Voiding Conflict", 0.05, true).requirement("Combat", 35).build());
        achievements.add(new AchievementBuilder("A Cat is for Life...", 0, true).requirement("Plague City", 1)
            .requirement("Gertrude's Cat", 1).requirement("Cat", 1).build());
        achievements.add(new AchievementBuilder("A Game of Tombs I", 0, true).requirement("Shifting Tombs", 1).build());
        achievements.add(new AchievementBuilder("A Game of Tombs II", 0, true).requirement("Shifting Tombs", 10).build());
        achievements.add(new AchievementBuilder("A Game of Tombs III", 0, true).requirement("Shifting Tombs", 50).build());
        achievements.add(new AchievementBuilder("A Game of Tombs IV", 0, true).requirement("Shifting Tombs", 100).build());
        achievements.add(new AchievementBuilder("A Game of Tombs V", 0, true).requirement("Shifting Tombs", 200).build());
        achievements.add(new AchievementBuilder("A Gift From Khazard", 0, true).build());
        achievements.add(new AchievementBuilder("A Wizard Did It", 0, true).build());
        achievements.add(new AchievementBuilder("A World In Microcosm", 0, true).build());
        achievements.add(new AchievementBuilder("Abyssal Reach", 0.25, true).requirement("Rune Mysteries", 1).reward("Runecrafting", 1000)
            .build());
        achievements.add(new AchievementBuilder("Abyssal Valet", 0, true).requirement("Abyssal titan pouch", 1).requirement("Summoning", 93)
            .requirement("Pure essence", 2).reward("Summoning", 2).build());
        achievements.add(new AchievementBuilder("Advanced Sweeping", 0, true).requirement("Broomstick enchantments", 5).build());
        achievements.add(new AchievementBuilder("Adventurer's Log", 0, true).reward("Logs", 1).reward("Woodcutting", 25).build());
        achievements.add(new AchievementBuilder("Aereck's Old Bones", 0, true).requirement("The Restless Ghost", 1).build());
        achievements.add(new AchievementBuilder("Agile from Head to Toe", 0, true).requirement("Agile top", 1)
            .requirement("Agile legs", 1).build());
        achievements.add(new AchievementBuilder("Agility - Dojo Mojo", 0, true).requirement("Dojo Mojo", 1).build());
        achievements.add(new AchievementBuilder("Agility 5", 0, true).requirement("Agility", 5).build());
        achievements.add(new AchievementBuilder("Agility 10", 0, true).requirement("Agility", 10).build());
        achievements.add(new AchievementBuilder("Agility 20", 0, true).requirement("Agility", 20).build());
        achievements.add(new AchievementBuilder("Agility 30", 0, true).requirement("Agility", 30).build());
        achievements.add(new AchievementBuilder("Agility 40", 0, true).requirement("Agility", 40).build());
        achievements.add(new AchievementBuilder("Agility 50", 0, true).requirement("Agility", 50).build());
        achievements.add(new AchievementBuilder("Agility 60", 0, true).requirement("Agility", 60).build());
        achievements.add(new AchievementBuilder("Agility 70", 0, true).requirement("Agility", 70).build());
        achievements.add(new AchievementBuilder("Agility 80", 0, true).requirement("Agility", 80).build());
        achievements.add(new AchievementBuilder("Agility 90", 0, true).requirement("Agility", 90).build());
        achievements.add(new AchievementBuilder("Agility 92", 0, true).requirement("Agility", 92).build());
        achievements.add(new AchievementBuilder("Agility 99", 0, true).requirement("Agility", 99).build());
        achievements.add(new AchievementBuilder("Ahrim Bobblehead", 0, true).requirement("Ahrim the Bobbled", 1).build());
        achievements.add(new AchievementBuilder("Al Kharid", 0, true).build());
        achievements.add(new AchievementBuilder("Ali The Trader", 0, true).requirement("Rogue Trader parts", 3).build());
        achievements.add(new AchievementBuilder("All Aboard", 0, true).requirement("Ranged", 70)
            .encounter(new Encounter(Enemy.KREEARRA)).build());
        achievements.add(new AchievementBuilder("All Rise", 0, true).requirement("Court Cases", 16).build());
        achievements.add(new AchievementBuilder("All Together Now", 0, true).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU), Arrays.asList(Enemy.IMAGE_OF_YAKAMARU,
                Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU)))).build());
        achievements.add(new AchievementBuilder("Almost Made In Ardougne", 0, true).requirement("Yew logs", 1).requirement("Raw beef", 1)
            .requirement("Rune bar", 1).requirement("Smithing", 91).requirement("Fletching", 69).requirement("Crafting", 10)
            .reward("Rune crossbow", 1).reward("Cooking", 3).reward("Fletching", 100).reward("Smithing", 75).reward("Crafting", 15)
            .build());
        achievements.add(new AchievementBuilder("Almost as Perky as a Prawn", 0, true).requirement("Prawn perk", 15).build());
        achievements.add(new AchievementBuilder("Along Came A Spider I", 0, true).requirement("Araxxi", 5).build());
        achievements.add(new AchievementBuilder("Along Came A Spider II", 0, true).requirement("Araxxi", 10).build());
        achievements.add(new AchievementBuilder("Along Came A Spider III", 0, true).requirement("Araxxi", 25).build());
        achievements.add(new AchievementBuilder("Along Came A Spider IV", 0, true).requirement("Araxxi", 50).build());
        achievements.add(new AchievementBuilder("Along Came A Spider V", 0, true).requirement("Araxxi", 75).build());
        achievements.add(new AchievementBuilder("Along Came A Spider VI", 0, true).requirement("Araxxi", 100).build());
        achievements.add(new AchievementBuilder("Altar Explorer", 0.3, true).requirement("Runecrafting", 50).build());
        achievements.add(new AchievementBuilder("Angs off my Ring", 0, true).requirement("Ancient elven wedding ring", 1).build());
        achievements.add(new AchievementBuilder("Animal Cruelty", 0, true).encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT,
            Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT,
                Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER,
                Enemy.CHARGER, Enemy.CORMES), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT,
                Enemy.AIRUT), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
            Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG)))).build());
        achievements.add(new AchievementBuilder("Annihilator", 0, true).requirement("Fate of the Gods", 1)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList(Enemy.SMOKE_NIHIL, Enemy.SHADOW_NIHIL,
                Enemy.BLOOD_NIHIL, Enemy.ICE_NIHIL)))).build());
        achievements.add(new AchievementBuilder("Any Odd Chicken", 0, true).requirement("Ernest the Chicken", 1).build());
        achievements.add(new AchievementBuilder("Ape A'hollow", 0.05, true).requirement("Fairy Tale Part III", 1)
            .requirement("Monkey Madness", 1).requirement("Agility", 48).build());
        achievements.add(new AchievementBuilder("Arc - All Your Energies", 0, true).requirement("Chimes", 5000).requirement("Tajitu", 5)
            .requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Ancient Eastern Tortle Portals", 0.05, true).requirement("Divination", 90)
            .requirement("Ancestral energy", 100).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Bone to Pick with You", 0, true).requirement("Chimes", 25000)
            .requirement("Tajitu", 25).requirement("Impressing the Locals", 1).requirement("Bonecrusher", 1).build());
        achievements.add(new AchievementBuilder("Arc - Don't Crush My Memories", 0, true).requirement("Chimes", 5000)
            .requirement("Tajitu", 5).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Flippers", 0, true).requirement("Impressing the Locals", 1)
            .requirement("Raw tarpon", 1).build());
        achievements.add(new AchievementBuilder("Arc - Mitts and Waders - Death Lotus", 0, true).requirement("Chimes", 5000)
            .requirement("Tajitu", 6).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Mitts and Waders - Seasinger", 0, true).requirement("Chimes", 5000)
            .requirement("Tajitu", 6).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Mitts and Waders - Tetsu", 0, true).requirement("Chimes", 5000)
            .requirement("Tajitu", 6).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Rewards", 0, true).requirement("Impressing the Locals", 1)
            .requirement("Birds of the Arc", 1).requirement("Berries of the Arc", 1).requirement("Kami", 16).reward("Hunter", 50000)
            .build());
        achievements.add(new AchievementBuilder("Arc - Unlocking More Waiko", 0, true).requirement("Sojobo contract guru", 1)
            .requirement("Ancestral Divination I", 1).requirement("Ancestral Divination II", 1).requirement("Ancestral Conversion", 1)
            .requirement("Spirit dragon pet", 1).requirement("Idol crabletine pet", 1).requirement("Gu ronin outfit", 1)
            .requirement("Death lotus rogue outfit", 1).requirement("Seasinger acolyte outfit", 1).requirement("Hunter outfit", 1)
            .requirement("Hanto outfit", 1).requirement("Thalassia's Revenge", 1).requirement("Winds of Waiko", 1)
            .requirement("Rage of Hyu-ji", 1).build());
        achievements.add(new AchievementBuilder("Arc - Unlocking Waiko", 0, true).requirement("Waiko Grill", 1)
            .requirement("Whale's Maw Camp Fire", 1).requirement("Whale's Maw Deposit Box", 1).requirement("Arc journal teletabs", 1)
            .requirement("Crystal tool siphon blueprint", 1).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Upgrading All of the Waiko", 0, true)
            .requirement("Commodity sell per day increase", 2).requirement("Supplies cap increase", 4)
            .requirement("Contracts per day increase", 4).requirement("Supplies cost reduction", 5)
            .requirement("Commodity sell price increase", 2).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Upgrading Waiko", 0, true).requirement("Commodity sell per day increase", 1)
            .requirement("Supplies cap increase", 1).requirement("Contracts per day increase", 1).requirement("Supplies cost reduction", 1)
            .requirement("Commodity sell price increase", 1).requirement("Impressing the Locals", 1).build());
        achievements.add(new AchievementBuilder("Arc - Salty", 0, true).requirement("Wushanko Isles: The Arc", 1)
            .requirement("Arc - Unlocking More Waiko", 1).requirement("Arc - Upgrading All of the Waiko", 1)
            .requirement("Arc - Ancient Eastern Tortle Portals", 1).requirement("Arc - Flippers", 1)
            .requirement("Arc - Mitts and Waders - Death Lotus", 1).requirement("Arc - All Your Energies", 1)
            .requirement("Arc - Mitts and Waders - Tetsu", 1).requirement("Arc - Unlocking Waiko", 1)
            .requirement("Arc - Mitts and Waders - Seasinger", 1).requirement("Arc - Rewards", 1)
            .requirement("Arc - Don't Crush My Memories", 1).requirement("Arc - Bone to Pick with You", 1).build());
        achievements.add(new AchievementBuilder("Arc III - Spiritual Enlightenment", 0.75, true)
            .requirement("Impressing the Locals", 1).requirement("Meet the Assassin", 1).requirement("Slayer", 90)
            .requirement("The Path of the Monk", 1).requirement("The Path of the Elemental", 1).requirement("The Path of the Dragon", 1)
            .reward("Chimes", 250).reward("Tajitu", 3).lamp(Collections.singletonList("Slayer"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc II - Head of the Family", 0.75, true).requirement("Impressing the Locals", 1)
            .requirement("Fish oil", 15).requirement("Woodcutting", 90).requirement("Fishing", 90).requirement("Cooking", 91)
            .requirement("Chimes", 450).requirement("Bamboo", 5)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList(Enemy.CAPN_EKAHI, Enemy.CYCLOPS_LABOURER,
                Enemy.CYCLOPS_LABOURER)))).reward("Chimes", 1300).reward("Fish oil", 30).reward("Bundle of bamboo", 4)
            .reward("Tajitu", 5).lamp(Collections.singletonList("Agility"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc I - Flag Fall", 0.5, true).requirement("Impressing the Locals", 1)
            .reward("Chimes", 500).reward("Tajitu", 2).build());
        achievements.add(new AchievementBuilder("Arc IV - Jed Hunter", 0.25, true).requirement("Flag Fall", 1)
            .requirement("Spiritual Enlightenment", 1).requirement("Head of the Family", 1).requirement("Hunter", 90)
            .requirement("Crafting", 91).requirement("Driftwood", 10).requirement("Sea shell", 5).requirement("Tortle shell bowl", 2)
            .requirement("Tajitu", 1).requirement("Chimes", 200).encounter(new Encounter(Enemy.GU_RONIN))
            .encounter(new Encounter(Enemy.GU_RONIN)).encounter(new Encounter(Enemy.GU_RONIN)).reward("Chimes", 2000).reward("Tajitu", 10)
            .lamp(Collections.singletonList("Hunter"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc V - Eye for an Eye", 0.25, true).requirement("Jed Hunter", 1)
            .requirement("Mining", 90).requirement("Sea salt", 30)
            .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS),Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS),
                Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS),
                Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS),
                Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS,
                    Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS))))
            .reward("Chimes", 250).reward("Tajitu", 1).reward("Alalea sea salt", 25).lamp(Collections.singletonList("Prayer"), -3, 1)
            .build());
        achievements.add(new AchievementBuilder("Arc VI - Harbinger of Doom", 0.25, true).requirement("Eye for an Eye", 1)
            .reward("Chimes", 250).reward("Tajitu", 2).lamp(Collections.singletonList("Construction"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc IX - Damage Control", 0.25, true).requirement("Harbinger", 1)
            .requirement("Chimes", 2500).reward("Chimes", 3000).reward("Tajitu", 2).lamp(Collections.singletonList("Thieving"), -3, 1)
            .build());
        achievements.add(new AchievementBuilder("Arc VIII - Ghosts from the Past", 0.25, true).requirement("Harbinger", 1)
            .reward("Chimes", 500).reward("Tajitu", 2).lamp(Arrays.asList("Agility", "Herblore", "Fishing", "Thieving", "Cooking",
                "Prayer", "Runecrafting", "Slayer", "Construction", "Hunter", "Dungeoneering", "Divination"), -3, 1).build());
        achievements.add(new AchievementBuilder("Arc VII - Tuai Let's Own", 0.5, true).requirement("Harbinger", 1)
            .requirement("Farming", 86).requirement("Divination", 90).requirement("Rumberry", 30).requirement("Positive energy", 30)
            .requirement("Spirit dragon charm", 1).reward("Chimes", 500).reward("Tajitu", 2).reward("Rumberry", 50)
            .reward("Ancestral energy", 50).build());
        achievements.add(new AchievementBuilder("Arc X - Final Destination", 0.25, true).requirement("Tuai Let's Own", 1)
            .requirement("Damage Control", 1).requirement("Ghosts from the Past", 1)
            .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.ZYCLOPS_CANNONEER, Enemy.ZYCLOPS_CANNONEER, Enemy.ZYCLOPS_CANNONEER),
                Arrays.asList(Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI),
                Arrays.asList(Enemy.SKELETON_UI, Enemy.SKELETON_UI), Arrays.asList(Enemy.ZYCLOPS_FD, Enemy.ZYCLOPS_FD))))
            .reward("Chimes", 2000).reward("Tajitu", 10)
            .lamp(Arrays.asList("Attack", "Constitution", "Defense", "Strength", "Ranged", "Prayer", "Magic", "Summoning"), -4, 1).build());
        achievements.add(new AchievementBuilder("Ardougne", 0, true).build());
        achievements.add(new AchievementBuilder("Are You Being Served?", 0, true).build());
        achievements.add(new AchievementBuilder("Ardougne Set Tasks - Easy", 0, true).requirement("Yoink!", 1)
            .requirement("The Essence of Magic", 1).requirement("Silky Smooth", 1).requirement("Preaching to the Infected", 1)
            .requirement("Playing the Waiting Game", 1).requirement("Gone Fishing", 1).requirement("Boot Camp", 1)
            .requirement("A Cat is for Life...", 1).requirement("Creator and Destroyer", 1).requirement("Red Revolution", 1)
            .requirement("Going on a Summer Holiday", 1).requirement("Breaking and Entering", 1).requirement("P-P-P-Pick Up Some Prizes", 1)
            .requirement("A Gift from Khazard", 1).requirement("Party Pooper", 1).requirement("Vial Deeds", 1).requirement("Star Seeker", 1)
            .requirement("Dukes of Khazard", 1).requirement("Don't Eat the Pointy Bit", 1).requirement("Bargain Hunter", 1)
            .requirement("Are You Being Served?", 1).requirement("No Time to Lose", 1).requirement("They're Long and Pointy", 1)
            .lamp(Player.ALL_SKILLS, 1000, 25).build());
        achievements.add(new AchievementBuilder("Ardougne Set Tasks - Elite", 0, true).requirement("Catching Some Rays", 1)
            .requirement("Abyssal Valet", 1).requirement("You Could Just Knock", 1).requirement("Honestly, It's Not a Purse", 1)
            .requirement("Almost Made in Ardougne", 1).lamp(Player.ALL_SKILLS, 50000, 85).lamp(Player.ALL_SKILLS, 50000, 85)
            .lamp(Player.ALL_SKILLS, 50000, 85).lamp(Player.ALL_SKILLS, 50000, 85).build());
        achievements.add(new AchievementBuilder("Ardougne Set Tasks - Hard", 0, true).requirement("Brace Yourself", 1)
            .requirement("Shadow Boxing", 1).requirement("Just Like That", 1).requirement("Nice View", 1)
            .requirement("You're the Dirty Rascal", 1).requirement("Ourania Mania", 1).requirement("Not on My Watch", 1)
            .requirement("It Just Croaked", 1).requirement("Get Your Stinking Hands Off Me", 1).requirement("Vine-detta", 1)
            .requirement("Living on a Prayer", 1).requirement("Who Wants to Watch the Watchtower?", 1).requirement("Monkey Business", 1)
            .requirement("It's My Newt", 1).requirement("A Taste of the Exotic", 1).requirement("Blood Bank Withdrawal", 1)
            .requirement("Artillery Strike", 1).lamp(Player.ALL_SKILLS, 28000, 60).build());
        achievements.add(new AchievementBuilder("Ardougne Set Tasks - Medium", 0, true).requirement("A Visit to Charlie", 1)
            .requirement("I Wonder What This Does", 1).requirement("Sandy's Secret Getaway", 1).requirement("I Know a Shortcut", 1)
            .requirement("Volatile Valuables", 1).requirement("What, a Melon?", 1).requirement("Ardougne Express", 1)
            .requirement("Arriving in Style", 1).requirement("By the Bucketload", 1).requirement("Meeting History, Again", 1)
            .requirement("Fearless Fishing", 1).requirement("Water Logged", 1).requirement("Green Fingers", 1)
            .requirement("A Natural Thief", 1).requirement("The Coal Train", 1).requirement("Are You Chicken?", 1)
            .lamp(Player.ALL_SKILLS, 7500, 45).build());
        achievements.add(new AchievementBuilder("Are You Chicken?", 0, true).requirement("Tower of Life", 1).requirement("Raw chicken", 1)
            .requirement("Raw swordfish", 1).encounter(new Encounter(Enemy.SWORDCHICK)).build());
        achievements.add(new AchievementBuilder("Are You Needing Access?", 0, true).requirement("Do No Evil", 1)
            .requirement("Agility", 80).reward("Agility", 20000).build());
        achievements.add(new AchievementBuilder("Arise from the Ash", 0, true).requirement("In Pyre Need", 1).requirement("Phoenix Lair", 1)
            .build());
        achievements.add(new AchievementBuilder("Around the World in Six Ways", 0, true).requirement("Balloon transport system routes", 6)
            .build());
        achievements.add(new AchievementBuilder("As Taxed as a Yak", 0, true).requirement("The Fremennik Isles", 1)
            .requirement("Coins", 5000).build());
        achievements.add(new AchievementBuilder("As Clear as a Crystal Seed", 0, true).requirement("Within the Light", 1).build());
        achievements.add(new AchievementBuilder("Ashdale", 0, true).build());
        achievements.add(new AchievementBuilder("Attack - Sifu", 0, true).requirement("Sifu", 1).build());
        achievements.add(new AchievementBuilder("Attack 5", 0, true).requirement("Attack", 5).build());
        achievements.add(new AchievementBuilder("Attack 10", 0, true).requirement("Attack", 10).build());
        achievements.add(new AchievementBuilder("Attack 20", 0, true).requirement("Attack", 20).build());
        achievements.add(new AchievementBuilder("Attack 30", 0, true).requirement("Attack", 30).build());
        achievements.add(new AchievementBuilder("Attack 40", 0, true).requirement("Attack", 40).build());
        achievements.add(new AchievementBuilder("Attack 50", 0, true).requirement("Attack", 50).build());
        achievements.add(new AchievementBuilder("Attack 60", 0, true).requirement("Attack", 60).build());
        achievements.add(new AchievementBuilder("Attack 70", 0, true).requirement("Attack", 70).build());
        achievements.add(new AchievementBuilder("Attack 80", 0, true).requirement("Attack", 80).build());
        achievements.add(new AchievementBuilder("Attack 90", 0, true).requirement("Attack", 90).build());
        achievements.add(new AchievementBuilder("Attack 92", 0, true).requirement("Attack", 92).build());
        achievements.add(new AchievementBuilder("Attack 99", 0, true).requirement("Attack", 99).build());
        achievements.add(new AchievementBuilder("Ava", 0, true).requirement("Ava", 1).build());
        achievements.add(new AchievementBuilder("Azacorax's Rewards", 0, true).requirement("Rune Memories", 1).requirement("Magic", 50)
            .requirement("Prayer", 50).lamp(Arrays.asList("Magic", "Prayer"), 10000, 50).build());
        achievements.add(new AchievementBuilder("Azdaran Birthright", 0, true).requirement("Azdaran fragment", 10).build());
    }

    private void addAchievementsB() {
        achievements.add(new AchievementBuilder("Balanced Combat Triangle", 0, true).requirement("Lockbox puzzle", 1).build());
        achievements.add(new AchievementBuilder("Bandit Camp", 0, true).requirement("Desert Treasure", 1).build());
        achievements.add(new AchievementBuilder("Bandos's Memories", 0, true).requirement("Bandos chronicles", 13).build());
        achievements.add(new AchievementBuilder("Bane Tuner", 0, true).requirement("Tune Bane Ore", 1).build());
        achievements.add(new AchievementBuilder("Bank-Z", 0, true).requirement("Dimension of Disaster: Curse of Arrav", 1)
            .reward("Zemomark", 30).build());
        achievements.add(new AchievementBuilder("Banking History", 0, true).requirement("Enchanted key miniquest", 2).build());
        achievements.add(new AchievementBuilder("Barbarian Scavenger", 0, true).requirement("Ancient page", 26).build());
        achievements.add(new AchievementBuilder("Bargain Hunter", 0, true).build());
        achievements.add(new AchievementBuilder("Baroo Quality", 0, true).requirement("Yak-hide armour (top)", 1)
            .requirement("Yak-hide armour (legs)", 1).requirement("Fremennik round shield", 1)
            .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Arrays.asList(new Restriction("Yak-hide armour (top)", 1),
                new Restriction("Yak-hide armour (legs)", 1), new Restriction("Fremennik round shield", 1)))).build());
        achievements.add(new AchievementBuilder("Barrowed Power I", 0, true).requirement("Rise of the Six", 5).build());
        achievements.add(new AchievementBuilder("Barrowed Power II", 0, true).requirement("Rise of the Six", 10).build());
        achievements.add(new AchievementBuilder("Barrowed Power III", 0, true).requirement("Rise of the Six", 25).build());
        achievements.add(new AchievementBuilder("Barrowed Power IV", 0, true).requirement("Rise of the Six", 50).build());
        achievements.add(new AchievementBuilder("Barrowed Power V", 0, true).requirement("Rise of the Six", 75).build());
        achievements.add(new AchievementBuilder("Barrowed Power VI", 0, true).requirement("Rise of the Six", 100).build());
        achievements.add(new AchievementBuilder("Barrowed Time", 0, true).requirement("Barrows uniques", 38).build());
        achievements.add(new AchievementBuilder("Barry", 0, true).requirement("Barry", 1).build());
        achievements.add(new AchievementBuilder("Beggars Can't Be Choosers", 0.05, true).requirement("In Aid of the Myreque", 1)
            .requirement("Great maki", 1).build());
        achievements.add(new AchievementBuilder("Behemoth Notes", 0, true).requirement("Behemoth notes", 5).build());
        achievements.add(new AchievementBuilder("Berries of the Arc", 0, true).requirement("Arc berries", 16).reward("Farming", 50000)
            .build());
        achievements.add(new AchievementBuilder("Best Offence", 0, true).encounter(new Encounter(Enemy.KALPHITE_KING)).build());
        achievements.add(new AchievementBuilder("Better Not Touch", 0, true).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU)))).build());
        achievements.add(new AchievementBuilder("Big Chinchompa", 0.25, true).requirement("Hunter", 78).reward("Competence points", 1111)
            .build());
        achievements.add(new AchievementBuilder("Bipedal Mask", 0, true).requirement("Tuska mask", 1)
            .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic"), 43680, 90).build());
        achievements.add(new AchievementBuilder("Bird is the Word I", 0, true).requirement("Kree'arra", 5).build());
        achievements.add(new AchievementBuilder("Bird is the Word II", 0, true).requirement("Kree'arra", 10).build());
        achievements.add(new AchievementBuilder("Bird is the Word III", 0, true).requirement("Kree'arra", 25).build());
        achievements.add(new AchievementBuilder("Bird is the Word IV", 0, true).requirement("Kree'arra", 50).build());
        achievements.add(new AchievementBuilder("Bird is the Word V", 0, true).requirement("Kree'arra", 75).build());
        achievements.add(new AchievementBuilder("Bird is the Word VI", 0, true).requirement("Kree'arra", 100).build());
        achievements.add(new AchievementBuilder("Birds of the Arc", 0, true).requirement("Arc birds", 16).build());
        achievements.add(new AchievementBuilder("Birdstrike I", 0, true).requirement("Kree'arra (HM)", 5).build());
        achievements.add(new AchievementBuilder("Birdstrike II", 0, true).requirement("Kree'arra (HM)", 10).build());
        achievements.add(new AchievementBuilder("Birdstrike III", 0, true).requirement("Kree'arra (HM)", 25).build());
        achievements.add(new AchievementBuilder("Birdstrike IV", 0, true).requirement("Kree'arra (HM)", 50).build());
        achievements.add(new AchievementBuilder("Birdstrike V", 0, true).requirement("Kree'arra (HM)", 75).build());
        achievements.add(new AchievementBuilder("Birdstrike VI", 0, true).requirement("Kree'arra (HM)", 100).build());
        achievements.add(new AchievementBuilder("Blackout", 0, true).requirement("Queen Black Dragon uniques", 12).build());
        achievements.add(new AchievementBuilder("Blinded by Ramarno's Teaching", 0, true).requirement("Defender of Varrock", 1)
            .requirement("Redberry pie", 1).reward("Smithing", 1000).build());
        achievements.add(new AchievementBuilder("Blood Stained Treasure", 0.05, true).requirement("Legacy of Seergaze", 1)
            .reward("Blood rune", 100).build());
        achievements.add(new AchievementBuilder("Bombi", 0, true).requirement("Bombi", 1).build());
        achievements.add(new AchievementBuilder("Bone I Fired", 0, true).requirement("Zanik's crossbow", 1).requirement("Bone bolt", 2)
            .requirement("Rag and Bone Man wish list", 1).requirement("Fur'n'Seek wish list", 1).requirement("Ranged", 48)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_1),
                Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_2), Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_3),
                Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_4)), Arrays.asList(new Restriction("Zanik's crossbow", 1),
                new Restriction("Bone bolt", 1)))).reward("Slayer", 10000).reward("Prayer", 7000).build());
        achievements.add(new AchievementBuilder("Boot Camp", 0, true).requirement("Biohazard", 1).build());
        achievements.add(new AchievementBuilder("Bovine Intervention", 0, true).encounter(new Encounter(Enemy.COW)).build());
        achievements.add(new AchievementBuilder("Boys to Menaphites", 0, true).requirement("Menaphos reputation", 330000).build());
        achievements.add(new AchievementBuilder("Brass Nex I", 0, true).requirement("Nex", 5).build());
        achievements.add(new AchievementBuilder("Brass Nex II", 0, true).requirement("Nex", 10).build());
        achievements.add(new AchievementBuilder("Brass Nex III", 0, true).requirement("Nex", 25).build());
        achievements.add(new AchievementBuilder("Brass Nex IV", 0, true).requirement("Nex", 50).build());
        achievements.add(new AchievementBuilder("Brass Nex V", 0, true).requirement("Nex", 75).build());
        achievements.add(new AchievementBuilder("Brass Nex VI", 0, true).requirement("Nex", 100).build());
        achievements.add(new AchievementBuilder("Breaking and Entering", 0, true).requirement("Thieving", 16).build());
        achievements.add(new AchievementBuilder("Bridge over Fremmy Waters", 0, true)
            .requirement("Unabridged Fremennik sagas", 5).build());
        achievements.add(new AchievementBuilder("Bring It All Back", 0, true).requirement("Ranged", 80).requirement("Blade of Avaryss", 1)
            .requirement("Blade of Nymora", 1).requirement("Attack", 85).encounter(new Encounter(Enemy.TWIN_FURIES,
                Arrays.asList(new Restriction("Blade of Avaryss", 1), new Restriction("Blade of Nymora", 1)))).build());
        achievements.add(new AchievementBuilder("Brothers Gower", 0, true).requirement("Gower lamp", 3).build());
        achievements.add(new AchievementBuilder("Brothers in Arms", 0, true).requirement("Ritual of the Mahjarrat", 1)
            .requirement("Kindred Spirits", 1).requirement("Ahrim's staff", 1).requirement("Akrisae's war mace", 1)
            .requirement("Dharok's greataxe", 1).requirement("Guthan's warspear", 1).requirement("Karil's crossbow", 1)
            .requirement("Linza's hammer", 1).requirement("Torag's hammer", 1).requirement("Verac's flail", 1).requirement("Magic", 70)
            .requirement("Attack", 80).requirement("Prayer", 70).requirement("Strength", 70).requirement("Ranged", 70)
            .encounter(new Encounter(Enemy.AHRIM_THE_BLIGHTED, Collections.singletonList(new Restriction("Ahrim's staff", 1))))
            .encounter(new Encounter(Enemy.DHAROK_THE_WRETCHED, Collections.singletonList(new Restriction("Dharok's greataxe", 1))))
            .encounter(new Encounter(Enemy.LINZA_THE_DISGRACED, Collections.singletonList(new Restriction("Linza's hammer", 1))))
            .encounter(new Encounter(Enemy.KARIL_THE_TAINTED, Collections.singletonList(new Restriction("Karil's crossbow", 1))))
            .encounter(new Encounter(Enemy.TORAG_THE_CORRUPTED, Collections.singletonList(new Restriction("Torag's hammer", 1))))
            .encounter(new Encounter(Enemy.GUTHAN_THE_INFESTED, Collections.singletonList(new Restriction("Guthan's warspear", 1))))
            .encounter(new Encounter(Enemy.AKRISAE_THE_DOOMED, Collections.singletonList(new Restriction("Akrisae's war mace", 1))))
            .encounter(new Encounter(Enemy.VERAC_THE_DEFILED, Collections.singletonList(new Restriction("Verac's flail", 1)))).build());
        achievements.add(new AchievementBuilder("Brothers in More Arms", 0, true).requirement("Barrows totem", 6)
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
                Enemy.KARIL_THE_TAINTED_ROTS)))).build());
        achievements.add(new AchievementBuilder("Brutal Stuffies", 0, true).requirement("Zogre Flesh Eaters", 1)
            .requirement("Relicym's balm", 1).build());
        achievements.add(new AchievementBuilder("Bug Swatter I", 0, true).requirement("Kalphite Queen", 5).build());
        achievements.add(new AchievementBuilder("Bug Swatter II", 0, true).requirement("Kalphite Queen", 10).build());
        achievements.add(new AchievementBuilder("Bug Swatter III", 0, true).requirement("Kalphite Queen", 25).build());
        achievements.add(new AchievementBuilder("Bug Swatter IV", 0, true).requirement("Kalphite Queen", 50).build());
        achievements.add(new AchievementBuilder("Bug Swatter V", 0, true).requirement("Kalphite Queen", 75).build());
        achievements.add(new AchievementBuilder("Bug Swatter VI", 0, true).requirement("Kalphite Queen", 100).build());
        achievements.add(new AchievementBuilder("Bug Zapper I", 0, true).requirement("Kalphite King", 5).build());
        achievements.add(new AchievementBuilder("Bug Zapper II", 0, true).requirement("Kalphite King", 10).build());
        achievements.add(new AchievementBuilder("Bug Zapper III", 0, true).requirement("Kalphite King", 25).build());
        achievements.add(new AchievementBuilder("Bug Zapper IV", 0, true).requirement("Kalphite King", 50).build());
        achievements.add(new AchievementBuilder("Bug Zapper V", 0, true).requirement("Kalphite King", 75).build());
        achievements.add(new AchievementBuilder("Bug Zapper VI", 0, true).requirement("Kalphite King", 100).build());
        achievements.add(new AchievementBuilder("Burn, Fury, Burn", 0, true).requirement("Ranged", 80)
            .encounter(new Encounter(Enemy.TWIN_FURIES)).build());
        achievements.add(new AchievementBuilder("Burthorpe", 0, true).build());
        achievements.add(new AchievementBuilder("Burthorpe Trolls", 0, true).build());
        achievements.add(new AchievementBuilder("Business Is Booning!", 0, true).requirement("Divination", 10)
            .requirement("Pale energy", 100).reward("Divination", 3).build());
        achievements.add(new AchievementBuilder("Buy and Sell Some XP", 0, true).requirement("Thieving", 62)
            .requirement("Buyers and Cellars", 1).reward("Thieving", 2000).build());
        achievements.add(new AchievementBuilder("Buying Up Ancient Artifacts", 0, true).requirement("Desert Treasure", 1)
            .requirement("Coins", 80000).build());
    }

    private void addAchievementsC() {
        achievements.add(new AchievementBuilder("Can't Make and Omelette", 0, true).reward("Red spider eggs", 1).build());
        achievements.add(new AchievementBuilder("Can You Dig It?", 0, true).requirement("Giant Mole uniques", 3).build());
        achievements.add(new AchievementBuilder("Canifis", 0, true).build());
        achievements.add(new AchievementBuilder("Careful, There Are Snakes", 0.05, true).requirement("Thieving", 31).build());
        achievements.add(new AchievementBuilder("Castaways of the Arc", 0, true).requirement("Arc castaways", 10).build());
        achievements.add(new AchievementBuilder("Casting a Shadow", 0, true).requirement("Blissful shadow core", 1)
            .requirement("Divination", 81).requirement("Plague's End", 1).reward("Divination", 455).build());
        achievements.add(new AchievementBuilder("Castles in the Sky", 0, true).build());
        achievements.add(new AchievementBuilder("Catching Some Rays", 0.2, true).requirement("Fishing", 81).requirement("Swamp paste", 200)
            .requirement("Bucket", 10).requirement("Rope", 10).reward("Raw manta ray", 1).reward("Fishing", 40).build());
        achievements.add(new AchievementBuilder("Cat's Bane", 0, true).requirement("New Varrock stray cats", 4).reward("Zemomark", 20)
            .build());
        achievements.add(new AchievementBuilder("Catherby", 0, true).build());
        achievements.add(new AchievementBuilder("Caving Into the Gains", 0, true)
            .requirement("Myths of the White Lands post-quest rewards", 4).build());
        achievements.add(new AchievementBuilder("Cecelia, I'm Begging You, Please...", 0, true)
            .requirement("One Piercing Note", 1).build());
        achievements.add(new AchievementBuilder("Challenge Maria", 0, true).requirement("Broken Home bonus lamps", 9)
            .requirement("Broken Home replay challenges", 3).build());
        achievements.add(new AchievementBuilder("Challenging Chat", 0, true).build());
        achievements.add(new AchievementBuilder("Champions? What Champions", 0, true).requirement("Champions", 15)
            .reward("Coins", 50000).lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defense", "Constitution",
                "Prayer", "Summoning"), 10000, 50).lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defense",
                "Constitution", "Prayer", "Summoning"), 10000, 50).lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged",
                "Defense", "Constitution", "Prayer", "Summoning"), 10000, 50).lamp(Arrays.asList("Attack", "Strength", "Magic",
                "Ranged", "Defense", "Constitution", "Prayer", "Summoning"), 10000, 50).build());
        achievements.add(new AchievementBuilder("Changing of the Guard", 0, true).requirement("Defense", 60)
            .requirement("Black dragonhide coif", 1).requirement("Black dragonhide body", 1).requirement("Black dragonhide chaps", 1)
            .requirement("Black dragonhide boots", 1).requirement("Black dragonhide vambraces", 1).requirement("Black dragonhide shield", 1)
            .encounter(new Encounter(Enemy.KING_BLACK_DRAGON, Arrays.asList(new Restriction("Black dragonhide coif", 1),
                new Restriction("Black dragonhide body", 1), new Restriction("Black dragonhide chaps", 1),
                new Restriction("Black dragonhide boots", 1), new Restriction("Black dragonhide vambraces", 1),
                new Restriction("Black dragonhide shield", 1)))).build());
        achievements.add(new AchievementBuilder("Chaos Theory", 0, true).requirement("Chaos Elemental uniques", 30).build());
        achievements.add(new AchievementBuilder("Checkmate", 0, true).requirement("Kalphite Queen uniques", 4).build());
        achievements.add(new AchievementBuilder("Chick'arra", 0, true).requirement("Chick'arra", 1).build());
        achievements.add(new AchievementBuilder("Chilling with Arrav", 0, true).requirement("Ritual of the Mahjarrat", 1)
            .reward("Prayer", 3000).build());
        achievements.add(new AchievementBuilder("Chippy Transport", 0, true).requirement("Love Story", 1).build());
        achievements.add(new AchievementBuilder("Chivalry is Fed", 0, true).requirement("The Death of Chivalry", 1)
            .requirement("Cabbage seeds", 12).requirement("Farming", 7).reward("Farming", 250).build());
        achievements.add(new AchievementBuilder("Chivalry is Threads", 0, true).requirement("Templar armour", 1)
            .requirement("Dulcin armour", 1).build());
        achievements.add(new AchievementBuilder("Chivalry is Dead", 0, true).requirement("The Death of Chivalry post-quest rewards", 4)
            .build());
        achievements.add(new AchievementBuilder("Chompy Massacre", 0, true).requirement("Chompy kills", 4000).reward("Ranged", 30000)
            .build());
        achievements.add(new AchievementBuilder("Circus of Fire", 0.05, true).requirement("The Firemaker's Curse", 1).build());
        achievements.add(new AchievementBuilder("Citadelementary", 0, true).build());
        achievements.add(new AchievementBuilder("Claiming Azzanadra's Heart", 0, true).requirement("Heart of Stone", 1)
            .requirement("The Temple at Senntisten", 1).lamp(Player.ALL_SKILLS, -2, 1).build());
        achievements.add(new AchievementBuilder("Class Crown", 0, true).requirement("Imperial reputation", 300000).build());
        achievements.add(new AchievementBuilder("Classic Dragon Killing", 0, true).requirement("Attack", 80)
            .requirement("Dragonfire shield", 1).encounter(new Encounter(Enemy.VINDICTA,
                Collections.singletonList(new Restriction("Dragonfire shield", 1)))).build());
        achievements.add(new AchievementBuilder("Classic Rock", 0, true).encounter(new Encounter(Enemy.VORAGO,
            Collections.singletonList(new Restriction("Defensive abilities", 0)))).build());
        achievements.add(new AchievementBuilder("Claus Is Rising", 0, true).requirement("Claus the chef reward", 1).build());
        achievements.add(new AchievementBuilder("Claymation", 0.33, true).build());
        achievements.add(new AchievementBuilder("Clued-Up", 0, true).reward("Sealed clue scroll (easy", 1).build());
        achievements.add(new AchievementBuilder("Clue's In The Monkey Drool", 0, true).requirement("Monkey clue scroll", 1).build());
        achievements.add(new AchievementBuilder("Collecting Memorabilia", 0, true).reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago I", 0, true).requirement("Vorago", 5).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago II", 0, true).requirement("Vorago", 10).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago III", 0, true).requirement("Vorago", 25).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago IV", 0, true).requirement("Vorago", 50).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago V", 0, true).requirement("Vorago", 75).build());
        achievements.add(new AchievementBuilder("Come and Have Vorago VI", 0, true).requirement("Vorago", 100).build());
        achievements.add(new AchievementBuilder("Commander Miniana", 0, true).requirement("Commander Miniana", 1).build());
        achievements.add(new AchievementBuilder("Commerce Break", 0, true).build());
        achievements.add(new AchievementBuilder("Complete History of Droalak", 0, true).requirement("Making History", 1).build());
        achievements.add(new AchievementBuilder("Complete Trekky", 0, true).requirement("Temple Trekking total level", 594).build());
        achievements.add(new AchievementBuilder("Completionist Cape", 0, true).requirement("Abyssal Reach", 1)
            .requirement("Almost as Perky as a Prawn", 1).requirement("Annihilator", 1)
            .requirement("Arc - Ancient Eastern Tortle Portals", 1).requirement("Arc - Unlocking Waiko", 1)
            .requirement("Arc - Upgrading Waiko", 1).requirement("Arc III - Spiritual Enlightenment", 1)
            .requirement("Arc II - Head of the Family", 1).requirement("Arc IV - Jed Hunter", 1).requirement("Arc IX - Damage Control", 1)
            .requirement("Arc I - Flag Fall", 1).requirement("Arc VIII - Ghosts from the Past", 1)
            .requirement("Arc VII - Tuai Leit's Own", 1).requirement("Arc VI - Harbinger of Doom", 1)
            .requirement("Arc V - Eye for an Eye", 1).requirement("Arc X - Final Destination", 1).requirement("Bandos's Memories", 1)
            .requirement("Bane Tuner", 1).requirement("Big Chinchompa", 1).requirement("Bipedal Mask", 1)
            .requirement("Bridge over Fremmy Waters", 1).requirement("Claus Is Rising", 1).requirement("Deadlier Catch", 1)
            .requirement("Desert-ed Ghosts", 1).requirement("Diaries of the Clans", 1).requirement("Elven Titles", 1)
            .requirement("Family Spirit Tree", 1).requirement("Famous", 1).requirement("Heal, Quickly", 1)
            .requirement("I'm Forever Washing Shadows", 1).requirement("Imping Around", 1).requirement("Invention Gives Me the Blues", 1)
            .requirement("Kharshai's Memories", 1).requirement("Kiln Fighter", 1).requirement("Kudos to You", 1)
            .requirement("Long Live the Queen", 1).requirement("Lost Toys", 1).requirement("Lunar Master", 1)
            .requirement("Make Them Bleed", 1).requirement("Master Quester", 1).requirement("Master Skiller", 1)
            .requirement("Memories of Guthis", 1).requirement("Music Maestro", 1).requirement("Myreque in Memoriam", 1)
            .requirement("One Foot in the Grave", 1).requirement("Out into the Ourania", 1).requirement("Peachy Bones", 1)
            .requirement("Pious Prayers", 1).requirement("Port Life", 1).requirement("Potion Mixer Master", 1)
            .requirement("Potion for a Lady", 1).requirement("Reaper Crew", 1).requirement("Rhian in Gold - The Original", 1)
            .requirement("Seren Memories", 1).requirement("Sing for the Lady", 1).requirement("Slayer Master", 1)
            .requirement("Stay Safe", 1).requirement("Stay Secure", 1).requirement("Task Master", 1).requirement("Tell Tale Tarn", 1)
            .requirement("Trip to the East", 1).requirement("Troublesome Crystals", 1).requirement("Uncorrupted Ore", 1)
            .requirement("Walking the Reef", 1).requirement("What's Mine Is Also Doric's", 1).requirement("Yaktwee's a Charm", 1)
            .requirement("You Be Dead", 1).requirement("Zarosian Memories", 1).build());
        achievements.add(new AchievementBuilder("Conquest Adore", 0, true).requirement("Conquest rank", 1250).build());
        achievements.add(new AchievementBuilder("Constitution - Morty", 0, true).requirement("Morty", 1).build());
        achievements.add(new AchievementBuilder("Constitution 15", 0, true).requirement("Constitution", 15).build());
        achievements.add(new AchievementBuilder("Constitution 20", 0, true).requirement("Constitution", 20).build());
        achievements.add(new AchievementBuilder("Constitution 30", 0, true).requirement("Constitution", 30).build());
        achievements.add(new AchievementBuilder("Constitution 40", 0, true).requirement("Constitution", 40).build());
        achievements.add(new AchievementBuilder("Constitution 50", 0, true).requirement("Constitution", 50).build());
        achievements.add(new AchievementBuilder("Constitution 60", 0, true).requirement("Constitution", 60).build());
        achievements.add(new AchievementBuilder("Constitution 70", 0, true).requirement("Constitution", 70).build());
        achievements.add(new AchievementBuilder("Constitution 80", 0, true).requirement("Constitution", 80).build());
        achievements.add(new AchievementBuilder("Constitution 90", 0, true).requirement("Constitution", 90).build());
        achievements.add(new AchievementBuilder("Constitution 92", 0, true).requirement("Constitution", 92).build());
        achievements.add(new AchievementBuilder("Constitution 99", 0, true).requirement("Constitution", 99).build());
        achievements.add(new AchievementBuilder("Construction - Baba Yaga's House", 0, true).requirement("Baby Yaga's House'", 1).build());
        achievements.add(new AchievementBuilder("Construction 5", 0, true).requirement("Construction", 5).build());
        achievements.add(new AchievementBuilder("Construction 10", 0, true).requirement("Construction", 10).build());
        achievements.add(new AchievementBuilder("Construction 20", 0, true).requirement("Construction", 20).build());
        achievements.add(new AchievementBuilder("Construction 30", 0, true).requirement("Construction", 30).build());
        achievements.add(new AchievementBuilder("Construction 40", 0, true).requirement("Construction", 40).build());
        achievements.add(new AchievementBuilder("Construction 50", 0, true).requirement("Construction", 50).build());
        achievements.add(new AchievementBuilder("Construction 60", 0, true).requirement("Construction", 60).build());
        achievements.add(new AchievementBuilder("Construction 70", 0, true).requirement("Construction", 70).build());
        achievements.add(new AchievementBuilder("Construction 80", 0, true).requirement("Construction", 80).build());
        achievements.add(new AchievementBuilder("Construction 90", 0, true).requirement("Construction", 90).build());
        achievements.add(new AchievementBuilder("Construction 92", 0, true).requirement("Construction", 92).build());
        achievements.add(new AchievementBuilder("Construction 99", 0, true).requirement("Construction", 99).build());
        achievements.add(new AchievementBuilder("Cook's Delight", 0, true).requirement("Cook's Assistant", 1).build());
        achievements.add(new AchievementBuilder("Cooking - Ramsay", 0, true).requirement("Ramsay", 1).build());
        achievements.add(new AchievementBuilder("Cooking 5", 0, true).requirement("Cooking", 5).build());
        achievements.add(new AchievementBuilder("Cooking 10", 0, true).requirement("Cooking", 10).build());
        achievements.add(new AchievementBuilder("Cooking 20", 0, true).requirement("Cooking", 20).build());
        achievements.add(new AchievementBuilder("Cooking 30", 0, true).requirement("Cooking", 30).build());
        achievements.add(new AchievementBuilder("Cooking 40", 0, true).requirement("Cooking", 40).build());
        achievements.add(new AchievementBuilder("Cooking 50", 0, true).requirement("Cooking", 50).build());
        achievements.add(new AchievementBuilder("Cooking 60", 0, true).requirement("Cooking", 60).build());
        achievements.add(new AchievementBuilder("Cooking 70", 0, true).requirement("Cooking", 70).build());
        achievements.add(new AchievementBuilder("Cooking 80", 0, true).requirement("Cooking", 80).build());
        achievements.add(new AchievementBuilder("Cooking 90", 0, true).requirement("Cooking", 90).build());
        achievements.add(new AchievementBuilder("Cooking 92", 0, true).requirement("Cooking", 92).build());
        achievements.add(new AchievementBuilder("Cooking 99", 0, true).requirement("Cooking", 99).build());
        achievements.add(new AchievementBuilder("Cormes and Goes", 0, true).encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT,
            Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT,
                Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER,
                Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
            Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG)))).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment I", 0, true).requirement("Corporeal Beast", 5).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment II", 0, true).requirement("Corporeal Beast", 10).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment III", 0, true).requirement("Corporeal Beast", 25).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment IV", 0, true).requirement("Corporeal Beast", 50).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment V", 0, true).requirement("Corporeal Beast", 75).build());
        achievements.add(new AchievementBuilder("Corporeal Punishment VI", 0, true).requirement("Corporeal Beast", 100).build());
        achievements.add(new AchievementBuilder("Corporeal Puppy", 0, true).requirement("Corporeal Puppy", 1).build());
        achievements.add(new AchievementBuilder("Count All Light Fingers", 0, true).requirement("From Tiny Acorns", 1)
            .requirement("Lost Her Marbles", 1).requirement("A Guild of Our Own", 1).build());
        achievements.add(new AchievementBuilder("Coursing Through You", 0, true).requirement("Max Telos enrage", 95)
            .encounter(new Encounter(Enemy.TELOS_100_ENRAGE)).build());
        achievements.add(new AchievementBuilder("Cower Behind the Chosen Commander", 0, true)
            .requirement("The Chosen Commander", 1).lamp(Arrays.asList("Constitution", "Attack", "Defense"), 1000, 1).build());
        achievements.add(new AchievementBuilder("Crafting - Gemi", 0, true).requirement("Gemi", 1).build());
        achievements.add(new AchievementBuilder("Crafting 5", 0, true).requirement("Crafting", 5).build());
        achievements.add(new AchievementBuilder("Crafting 10", 0, true).requirement("Crafting", 10).build());
        achievements.add(new AchievementBuilder("Crafting 20", 0, true).requirement("Crafting", 20).build());
        achievements.add(new AchievementBuilder("Crafting 30", 0, true).requirement("Crafting", 30).build());
        achievements.add(new AchievementBuilder("Crafting 40", 0, true).requirement("Crafting", 40).build());
        achievements.add(new AchievementBuilder("Crafting 50", 0, true).requirement("Crafting", 50).build());
        achievements.add(new AchievementBuilder("Crafting 60", 0, true).requirement("Crafting", 60).build());
        achievements.add(new AchievementBuilder("Crafting 70", 0, true).requirement("Crafting", 70).build());
        achievements.add(new AchievementBuilder("Crafting 80", 0, true).requirement("Crafting", 80).build());
        achievements.add(new AchievementBuilder("Crafting 90", 0, true).requirement("Crafting", 90).build());
        achievements.add(new AchievementBuilder("Crafting 92", 0, true).requirement("Crafting", 92).build());
        achievements.add(new AchievementBuilder("Crafting 99", 0, true).requirement("Crafting", 99).build());
        achievements.add(new AchievementBuilder("Cran Door's Secret", 0, true).requirement("Dragon Slayer", 1).build());
        achievements.add(new AchievementBuilder("Crayfish Roasting On An Open Fire", 0, true).requirement("Raw crayfish", 1)
            .reward("Crayfish", 1).reward("Cooking", 30).build());
        achievements.add(new AchievementBuilder("Creator and Destroyer", 0, true).requirement("Tower of Life", 1).requirement("Cowhide", 1)
            .requirement("Unicorn horn", 1).encounter(new Encounter(Enemy.UNICOW)).build());
        achievements.add(new AchievementBuilder("Crocodile Tears", 0, true).requirement("Crocodile Tears", 1).build());
        achievements.add(new AchievementBuilder("Crossing Over I", 0, true).requirement("The Magister", 5).build());
        achievements.add(new AchievementBuilder("Crossing Over II", 0, true).requirement("The Magister", 10).build());
        achievements.add(new AchievementBuilder("Crossing Over III", 0, true).requirement("The Magister", 25).build());
        achievements.add(new AchievementBuilder("Crossing Over IV", 0, true).requirement("The Magister", 50).build());
        achievements.add(new AchievementBuilder("Crossing Over V", 0, true).requirement("The Magister", 75).build());
        achievements.add(new AchievementBuilder("Crossing Over VI", 0, true).requirement("The Magister", 100).build());
    }

    private void addAchievementsD() {
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Easy", 0, true).requirement("Setting Up", 1)
        .requirement("It's Dangerous to go Alone", 1).requirement("Kitchen Aid", 1).requirement("The Lone Dungeoneer", 1)
        .requirement("Dere-licked", 1).requirement("Take It From the Top", 1).requirement("Change of a Dress", 1)
        .requirement("Gorajo Fandago", 1).requirement("You're Not the Boss of Me", 1).requirement("A Road Less Travelled", 1)
        .requirement("Invisible Ink", 1).requirement("Untouchable", 1).requirement("Fashion Victim", 1).requirement("Sinking Fast", 1)
        .requirement("Tales of Old", 1).requirement("A Flicker in Darkness", 1).lamp(Player.ALL_SKILLS, 2000, 23).build());
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Elite", 0, true).requirement("Any fin is Possible", 1)
            .requirement("Orbful", 1).requirement("Top Hat", 1).requirement("In the Darkness Bind Them", 1).requirement("Pass the Port", 1)
            .requirement("Gulega-d to Rest", 1).lamp(Player.ALL_SKILLS, 60000, 98).lamp(Player.ALL_SKILLS, 50000, 90)
            .lamp(Player.ALL_SKILLS, 50000, 90).lamp(Player.ALL_SKILLS, 50000, 90).build());
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Hard", 0, true).requirement("Occult Classic", 1)
            .requirement("Stacked", 1).requirement("Kinprovements", 1).requirement("Lawful Crafting", 1)
            .requirement("Thanks for the Memories", 1).requirement("Healing Factor", 1).requirement("Alcrabholic", 1)
            .requirement("Hoof Rot", 1).requirement("A Prayer Opportunity", 1).requirement("The Wanderer", 1).requirement("Get Stuffed", 1)
            .requirement("Epic Epic", 1).reward("Dungeoneering token", 38000).lamp(Player.ALL_SKILLS, 20000, 74).build());
        achievements.add(new AchievementBuilder("Daemonheim Set Tasks - Medium", 0, true)
            .requirement("You Got Some Nice Drapes There", 1).requirement("I Want It All", 1).requirement("And I Want It Now", 1)
            .requirement("Marm's Armoury", 1).requirement("Tactical Retreat", 1).requirement("Port Enter", 1)
            .requirement("Totem Pole Position", 1).requirement("Nice to Meet You, Wall", 1).requirement("300", 1).requirement("Drink Me", 1)
            .requirement("Spinal Tap", 1).requirement("Cache Box", 1).requirement("Up to the Gods", 1).reward("Dungeoneering token", 2000)
            .lamp(Player.ALL_SKILLS, 8000, 41).build());
        achievements.add(new AchievementBuilder("Daemonology of Celerity", 0, true).requirement("Demon flash mob", 1).build());
        achievements.add(new AchievementBuilder("Daero Take This Experience?", 0, true).requirement("Monkey Madness", 1)
            .reward("Attack", 20000).reward("Strength", 20000).reward("Defense", 10000).reward("Constitution", 20000)
            .lamp(Arrays.asList("Attack", "Strength"), 15000, 1).lamp(Arrays.asList("Constitution", "Defense"), 15000, 1).build());
        achievements.add(new AchievementBuilder("Dagannoth Traffic Wardens", 0, true).requirement("Koschei's Troubles", 1)
            .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Collections.singletonList(new Restriction("Achromatic Balmung", 1))))
            .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Collections.singletonList(new Restriction("Cobalt Balmung", 1))))
            .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Collections.singletonList(new Restriction("Crimson Balmung", 1))))
            .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Collections.singletonList(new Restriction("Viridian Balmung", 1)))).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone I", 0, true).requirement("Dagannoth Kings", 5).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone II", 0, true).requirement("Dagannoth Kings", 10).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone III", 0, true).requirement("Dagannoth Kings", 25).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone IV", 0, true).requirement("Dagannoth Kings", 50).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone V", 0, true).requirement("Dagannoth Kings", 75).build());
        achievements.add(new AchievementBuilder("Dagannoth For Everyone VI", 0, true).requirement("Dagannoth Kings", 100).build());
        achievements.add(new AchievementBuilder("Dark Imperator-ment", 0, true).requirement("Constitution", 91).requirement("Attack", 75)
            .requirement("Magic", 75).requirement("Ranged", 75).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .reward("Zemomark", 40).build());
        achievements.add(new AchievementBuilder("Day at the Aquarium", 0, true).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU)))).build());
        achievements.add(new AchievementBuilder("Day at the Pound", 0, true)
            .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CORMES),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
            Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG)))).build());
        achievements.add(new AchievementBuilder("Deadlier Catch", 0, true).requirement("Thalassus hunts", 10).build());
        achievements.add(new AchievementBuilder("Death Effect", 0, true).requirement("Book of death", 1).requirement("Reaper's choice", 1)
            .requirement("Rainbow loot beam", 1).requirement("Grave loot beam", 1).requirement("Bonfire booster", 1)
            .requirement("Instance cost", 1).requirement("Additional tasks", 1).requirement("Reaper scroll", 1)
            .requirement("Death's support", 1).build());
        achievements.add(new AchievementBuilder("Death to the Mahjarrat", 0, true).requirement("Mahjarrat deathstone", 4).build());
        achievements.add(new AchievementBuilder("Deep and Bloody Experience", 0, true).requirement("Blood Runs Deep", 1)
            .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75)
            .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75).build());
        achievements.add(new AchievementBuilder("Defence - Wallace", 0, true).requirement("Wallace", 1).build());
        achievements.add(new AchievementBuilder("Defense 5", 0, true).requirement("Defense", 5).build());
        achievements.add(new AchievementBuilder("Defense 10", 0, true).requirement("Defense", 10).build());
        achievements.add(new AchievementBuilder("Defense 20", 0, true).requirement("Defense", 20).build());
        achievements.add(new AchievementBuilder("Defense 30", 0, true).requirement("Defense", 30).build());
        achievements.add(new AchievementBuilder("Defense 40", 0, true).requirement("Defense", 40).build());
        achievements.add(new AchievementBuilder("Defense 50", 0, true).requirement("Defense", 50).build());
        achievements.add(new AchievementBuilder("Defense 60", 0, true).requirement("Defense", 60).build());
        achievements.add(new AchievementBuilder("Defense 70", 0, true).requirement("Defense", 70).build());
        achievements.add(new AchievementBuilder("Defense 80", 0, true).requirement("Defense", 80).build());
        achievements.add(new AchievementBuilder("Defense 90", 0, true).requirement("Defense", 90).build());
        achievements.add(new AchievementBuilder("Defense 92", 0, true).requirement("Defense", 92).build());
        achievements.add(new AchievementBuilder("Defense 99", 0, true).requirement("Defense", 99).build());
        achievements.add(new AchievementBuilder("Descension I", 0, true).requirement("Legiones", 5).build());
        achievements.add(new AchievementBuilder("Descension II", 0, true).requirement("Legiones", 10).build());
        achievements.add(new AchievementBuilder("Descension III", 0, true).requirement("Legiones", 25).build());
        achievements.add(new AchievementBuilder("Descension IV", 0, true).requirement("Legiones", 50).build());
        achievements.add(new AchievementBuilder("Descension V", 0, true).requirement("Legiones", 75).build());
        achievements.add(new AchievementBuilder("Descension VI", 0, true).requirement("Legiones", 100).build());
        achievements.add(new AchievementBuilder("Desert-ed Ghosts", 0, true).requirement("The Curse of Zaros", 1).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Easy", 0, true).requirement("Assassin's Feed", 1)
            .requirement("Touring Gear", 1).requirement("Memento Mori", 1).requirement("Fool's Gold", 1)
            .requirement("Don't You Dare Close Your Eyes", 1).requirement("Slash Fund", 1).requirement("Kookookachat", 1)
            .requirement("Fire at Will", 1).requirement("Seems Legit", 1).requirement("Extra Cheese", 1).requirement("I Like to Watch", 1)
            .requirement("Wiggle Room", 1).lamp(Player.ALL_SKILLS, 2000, 29).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Elite", 0, true).requirement("Staff on Stryke", 1)
            .requirement("Room Service", 1).requirement("Sun Shade", 1).requirement("A. B. Cithara", 1).requirement("Ankle Support", 1)
            .requirement("I'm Super", 1).lamp(Player.ALL_SKILLS, 30000, 77).lamp(Player.ALL_SKILLS, 30000, 77)
            .lamp(Player.ALL_SKILLS, 50000, 93).lamp(Player.ALL_SKILLS, 50000, 93).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Hard", 0, true).requirement("Skinful", 1)
            .requirement("Water on the Brain", 1).requirement("More Fletcher than Sumona", 1).requirement("Ug Thankee Kindly", 1)
            .requirement("Nipped in the Bug", 1).requirement("Drafty in Here", 1).requirement("Enaqua", 1)
            .requirement("Say It, Don't Spray It", 1).requirement("1001 Kharidian Spikes", 1).requirement("Ice-Cold Killer", 1)
            .requirement("Ludikeris", 1).requirement("Security through Obscurity", 1).requirement("Wake-Up Call", 1)
            .requirement("Open Sesame", 1).lamp(Player.ALL_SKILLS, 20000, 1).build());
        achievements.add(new AchievementBuilder("Desert Set Tasks - Medium", 0, true).requirement("So Su Me", 1)
            .requirement("Faster than a Speeding Bullet", 1).requirement("A Bridge Not Far", 1).requirement("Heathen Idle", 1)
            .requirement("Away with the Kalphites", 1).requirement("All Square", 1).requirement("Goat Harralader?", 1)
            .requirement("Taken for Granite", 1).requirement("Unbeetleable", 1).requirement("An Teak", 1).requirement("Overcut", 1)
            .lamp(Player.ALL_SKILLS, 8000, 43).build());
        achievements.add(new AchievementBuilder("Dharok Bobblehead", 0, true).requirement("Dharok the Bobbled", 1).build());
        achievements.add(new AchievementBuilder("Diaries of the Clans", 0, true).requirement("Voice of the Elders", 8).build());
        achievements.add(new AchievementBuilder("Diary of Oreb", 0, true).requirement("The Magister's Journals", 5).build());
        achievements.add(new AchievementBuilder("Diary of the Gods", 0, true).requirement("God journals", 5).build());
        achievements.add(new AchievementBuilder("Diddyzag", 0, true).requirement("Diddyzag", 1).build());
        achievements.add(new AchievementBuilder("Digging for Treasure", 0, true).requirement("Meerkat pouch", 1)
            .requirement("Fetch casket scroll", 1).requirement("Summoning", 4).requirement("Clue scroll", 1).reward("Summoning", 1)
            .build());
        achievements.add(new AchievementBuilder("Dishonourable Gains", 0, true).requirement("Zamorak hideout XP chests", 3).build());
        achievements.add(new AchievementBuilder("Dishonourable Gains", 0, true).requirement("Zamorak hideout loot chests", 6).build());
        achievements.add(new AchievementBuilder("Disowned", 0, true).requirement("Reforged Sunspear", 1).requirement("House Drakan hood", 1)
            .requirement("House Drakan top", 1).requirement("House Drakan trousers", 1).requirement("House Drakan boots", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.VANSTROM_KLAUSE),
                Collections.singletonList(Enemy.VANSTROM_KLAUSE)), Arrays.asList(new Restriction("Reforged Sunspear", 1),
                new Restriction("House Drakan hood", 1), new Restriction("House Drakan top", 1),
                new Restriction("House Drakan trousers", 1), new Restriction("House Drakan boots", 1)))).build());
        achievements.add(new AchievementBuilder("Distorted Div", 0, true).requirement("Distorted engrammeter", 1)
            .reward("Divination", 25000).build());
        achievements.add(new AchievementBuilder("Divination - Willow", 0, true).requirement("Willow", 1).build());
        achievements.add(new AchievementBuilder("Divination 5", 0, true).requirement("Divination", 5).build());
        achievements.add(new AchievementBuilder("Divination 10", 0, true).requirement("Divination", 10).build());
        achievements.add(new AchievementBuilder("Divination 20", 0, true).requirement("Divination", 20).build());
        achievements.add(new AchievementBuilder("Divination 30", 0, true).requirement("Divination", 30).build());
        achievements.add(new AchievementBuilder("Divination 40", 0, true).requirement("Divination", 40).build());
        achievements.add(new AchievementBuilder("Divination 50", 0, true).requirement("Divination", 50).build());
        achievements.add(new AchievementBuilder("Divination 60", 0, true).requirement("Divination", 60).build());
        achievements.add(new AchievementBuilder("Divination 70", 0, true).requirement("Divination", 70).build());
        achievements.add(new AchievementBuilder("Divination 80", 0, true).requirement("Divination", 80).build());
        achievements.add(new AchievementBuilder("Divination 90", 0, true).requirement("Divination", 90).build());
        achievements.add(new AchievementBuilder("Divination 92", 0, true).requirement("Divination", 92).build());
        achievements.add(new AchievementBuilder("Divination 99", 0, true).requirement("Divination", 99).build());
        achievements.add(new AchievementBuilder("Divine Retribution", 0, true).requirement("Business Is Booning", 1)
            .requirement("Collecting Memorabilia", 1).requirement("Energy Generator", 1).requirement("Enrichment Programme", 1)
            .requirement("Just Give Me a Sign", 1).requirement("Let's Enhance", 1).requirement("Mighty Morphing", 1)
            .requirement("Portentially Hazardous", 1).requirement("Simply Divine", 1).requirement("What an Experience", 1)
            .reward("Flickering energy", 500).build());
        achievements.add(new AchievementBuilder("Diving for Clues", 0, true).requirement("Treasure chest decoration", 1)
            .reward("Elite clue scroll", 1).build());
        achievements.add(new AchievementBuilder("Do No Elite", 0, true).requirement("Do No Evil elite clue", 1).build());
        achievements.add(new AchievementBuilder("Do a Minion, Take Notes", 0, true).requirement("Dominion page", 20).build());
        achievements.add(new AchievementBuilder("Doing the Ironing", 0, true).requirement("Mining", 15).reward("Iron ore", 1).build());
        achievements.add(new AchievementBuilder("Don't Eat the Pointy Bit", 0, true).requirement("Coins", 25)
            .reward("Skewered kebab", 1).build());
        achievements.add(new AchievementBuilder("Don't Fear the Ripper", 0, true).requirement("Miner's journals", 6).build());
        achievements.add(new AchievementBuilder("Double Swoop", 0, true).requirement("Ranged", 70)
            .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.FLIGHT_KILISA, Enemy.WINGMAN_SKREE, Enemy.FLOCKLEADER_GEERIN),
                Arrays.asList(Enemy.FLIGHT_KILISA, Enemy.WINGMAN_SKREE, Enemy.FLOCKLEADER_GEERIN, Enemy.KREEARRA)))).build());
        achievements.add(new AchievementBuilder("Dragonkin Logs", 0, true).requirement("Dragonkin journals", 4).build());
        achievements.add(new AchievementBuilder("Draynor", 0, true).build());
        achievements.add(new AchievementBuilder("Dukes of Khazard", 0, true).encounter(new Encounter(Enemy.GNOME_TROOP)).build());
        achievements.add(new AchievementBuilder("Dungeoneering - Gordie", 0, true).requirement("Gordie", 1).build());
        achievements.add(new AchievementBuilder("Dungeoneering 5", 0, true).requirement("Dungeoneering", 5).build());
        achievements.add(new AchievementBuilder("Dungeoneering 10", 0, true).requirement("Dungeoneering", 10).build());
        achievements.add(new AchievementBuilder("Dungeoneering 20", 0, true).requirement("Dungeoneering", 20).build());
        achievements.add(new AchievementBuilder("Dungeoneering 30", 0, true).requirement("Dungeoneering", 30).build());
        achievements.add(new AchievementBuilder("Dungeoneering 40", 0, true).requirement("Dungeoneering", 40).build());
        achievements.add(new AchievementBuilder("Dungeoneering 50", 0, true).requirement("Dungeoneering", 50).build());
        achievements.add(new AchievementBuilder("Dungeoneering 60", 0, true).requirement("Dungeoneering", 60).build());
        achievements.add(new AchievementBuilder("Dungeoneering 70", 0, true).requirement("Dungeoneering", 70).build());
        achievements.add(new AchievementBuilder("Dungeoneering 80", 0, true).requirement("Dungeoneering", 80).build());
        achievements.add(new AchievementBuilder("Dungeoneering 90", 0, true).requirement("Dungeoneering", 90).build());
        achievements.add(new AchievementBuilder("Dungeoneering 99", 0, true).requirement("Dungeoneering", 99).build());
        achievements.add(new AchievementBuilder("Dungeoneering 110", 0, true).requirement("Dungeoneering", 110).build());
        achievements.add(new AchievementBuilder("Dungeoneering 120", 0, true).requirement("Dungeoneering", 120).build());
        achievements.add(new AchievementBuilder("Dusting Murial", 0, true).requirement("Dusted murals", 2).build());
    }

    private void addAchievementsE() {
        achievements.add(new AchievementBuilder("Eagles' Peak", 0, true).build());
        achievements.add(new AchievementBuilder("Eastern Adventurer", 0, true).requirement("Port storylines", 4).build());
        achievements.add(new AchievementBuilder("Eastern Explorer", 0, true).requirement("The Shield region", 1).build());
        achievements.add(new AchievementBuilder("Eat to Live", 0, true).requirement("Sardine", 1).build());
        achievements.add(new AchievementBuilder("Edgeville", 0, true).build());
        achievements.add(new AchievementBuilder("Eeeeagle!", 0, true).requirement("Eagle transport routes", 5).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos I", 0, true).requirement("Chaos Elemental", 5).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos II", 0, true).requirement("Chaos Elemental", 10).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos III", 0, true).requirement("Chaos Elemental", 25).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos IV", 0, true).requirement("Chaos Elemental", 50).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos V", 0, true).requirement("Chaos Elemental", 75).build());
        achievements.add(new AchievementBuilder("Elemental Kill Chaos VI", 0, true).requirement("Chaos Elemental", 100).build());
        achievements.add(new AchievementBuilder("Ellie", 0, true).requirement("Ellie", 1).build());
        achievements.add(new AchievementBuilder("Elven Titles", 0, true).requirement("Elf City titles", 8).build());
        achievements.add(new AchievementBuilder("Energy Generator", 0, true).reward("Pale energy", 1).reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Enough of the Crazy Walking", 0, true).requirement("Mad Ramblings", 2).build());
        achievements.add(new AchievementBuilder("Enrichment Programme", 0, true).reward("Divination", 2).build());
        achievements.add(new AchievementBuilder("Epi Logueque Experience", 0, true).requirement("While Guthix Sleeps", 1)
            .lamp(Player.ALL_SKILLS, 100000, 65).lamp(Player.ALL_SKILLS, 100000, 65).lamp(Player.ALL_SKILLS, 100000, 65)
            .lamp(Player.ALL_SKILLS, 100000, 65).build());
        achievements.add(new AchievementBuilder("Essential Facilitator", 0, true).build());
        achievements.add(new AchievementBuilder("Everybody Loves Coal", 0, true).requirement("Mining", 30).reward("Coal", 1)
            .reward("Mining", 50).build());
        achievements.add(new AchievementBuilder("Exiled", 0, true).requirement("Kalphite King uniques", 8).build());
        achievements.add(new AchievementBuilder("Experience the Fate of the Gods", 0, true)
            .requirement("Post-Fate of the Gods lamps", 4).build());
        achievements.add(new AchievementBuilder("Explore for Nestor", 0, true).build());
    }

    private void addAchievementsF() {
        achievements.add(new AchievementBuilder("Faceless and Ready", 0, true).build());
        achievements.add(new AchievementBuilder("Falador", 0, true).build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Easy", 0, true).requirement("The Good Stuff", 1)
            .requirement("Amulet of Weedspeak", 1).requirement("Chain Store", 1).requirement("Sir Mitt", 1).requirement("Family Values", 1)
            .requirement("Sniffing Out the Mole", 1).requirement("Chinchompa Powered!", 1).requirement("Fill Yer Bucket", 1)
            .requirement("Elementary Medicine", 1).requirement("It's Not Wabbit Season", 1).requirement("Stand and Deliver", 1)
            .requirement("Making My Mind Up", 1).requirement("Mudskip the Light Fantastic", 1).requirement("Disarm and Embark", 1)
            .requirement("Going Along with the 'Fro", 1).lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Elite", 0, true).requirement("When This Cavern's Rockin'...", 1)
            .requirement("You'd Best Come A-cookin'", 1).requirement("Concentration is Key", 1).requirement("I Swear I Heard It Scream", 1)
            .requirement("I've Changed My Mind!", 1).requirement("A String and a Flare", 1).requirement("Altar-ed State", 1)
            .lamp(Player.ALL_SKILLS, 30000, 90).lamp(Player.ALL_SKILLS, 30000, 90).lamp(Player.ALL_SKILLS, 50000, 84)
            .lamp(Player.ALL_SKILLS, 50000, 72).build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Hard", 0, true).requirement("It Matches My Eyes", 1)
            .requirement("Child of Saradomin", 1).requirement("Mass Production", 1).requirement("It Spoiled My View", 1)
            .requirement("The Stonemasons", 1).requirement("I Heard You Like Mudskips", 1).requirement("The Mogre Mash", 1)
            .requirement("Why Oh Wyvern", 1).requirement("Banned For Life", 1).requirement("A Knight in the Darkness", 1)
            .lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("Falador Set Tasks - Medium", 0, true).requirement("Fruit of the Loom", 1)
            .requirement("Is It Hard to Walk Round?", 1).requirement("Climbing the Walls", 1).requirement("It's Nothing Personal", 1)
            .requirement("Ice the Icy", 1).requirement("Blinded with Science", 1).requirement("They Have Families to Feed", 1)
            .requirement("Stoic Sweetcorn Guardian", 1).requirement("Look Spiffy For Tiffy", 1)
            .requirement("Do They Come in Other Colours", 1).requirement("These Aren't the Coins You're Looking For", 1)
            .requirement("Kitty Litter", 1).lamp(Player.ALL_SKILLS, 5000, 40).build());
        achievements.add(new AchievementBuilder("Fallen Angel", 0, true).requirement("Angel of Death uniques", 10).build());
        achievements.add(new AchievementBuilder("Family Affair", 0, true).requirement("Rise of the Six uniques", 10).build());
        achievements.add(new AchievementBuilder("Family Spirit Tree", 0, true).requirement("Grown spirit trees", 3).reward("Farming", 50000)
            .build());
        achievements.add(new AchievementBuilder("Famous", 0, true).requirement("Morvran Slayer challenge", 1).reward("Slayer", 50000)
            .reward("Slayer points", 45).build());
        achievements.add(new AchievementBuilder("Farming - Brains", 0, true).requirement("Brains", 1).build());
        achievements.add(new AchievementBuilder("Farming 5", 0, true).requirement("Farming", 5).build());
        achievements.add(new AchievementBuilder("Farming 10", 0, true).requirement("Farming", 10).build());
        achievements.add(new AchievementBuilder("Farming 20", 0, true).requirement("Farming", 20).build());
        achievements.add(new AchievementBuilder("Farming 30", 0, true).requirement("Farming", 30).build());
        achievements.add(new AchievementBuilder("Farming 40", 0, true).requirement("Farming", 40).build());
        achievements.add(new AchievementBuilder("Farming 50", 0, true).requirement("Farming", 50).build());
        achievements.add(new AchievementBuilder("Farming 60", 0, true).requirement("Farming", 60).build());
        achievements.add(new AchievementBuilder("Farming 70", 0, true).requirement("Farming", 70).build());
        achievements.add(new AchievementBuilder("Farming 80", 0, true).requirement("Farming", 80).build());
        achievements.add(new AchievementBuilder("Farming 90", 0, true).requirement("Farming", 90).build());
        achievements.add(new AchievementBuilder("Farming 92", 0, true).requirement("Farming", 92).build());
        achievements.add(new AchievementBuilder("Farming 99", 0, true).requirement("Farming", 99).build());
        achievements.add(new AchievementBuilder("Fast and Furious I", 0, true).requirement("Twin Furies", 5).build());
        achievements.add(new AchievementBuilder("Fast and Furious II", 0, true).requirement("Twin Furies", 10).build());
        achievements.add(new AchievementBuilder("Fast and Furious III", 0, true).requirement("Twin Furies", 25).build());
        achievements.add(new AchievementBuilder("Fast and Furious IV", 0, true).requirement("Twin Furies", 50).build());
        achievements.add(new AchievementBuilder("Fast and Furious V", 0, true).requirement("Twin Furies", 75).build());
        achievements.add(new AchievementBuilder("Fast and Furious VI", 0, true).requirement("Twin Furies", 100).build());
        achievements.add(new AchievementBuilder("Ferocious Upgrade", 0, true).requirement("Slayer", 90).requirement("Slayer point", 100)
            .build());
        achievements.add(new AchievementBuilder("Fill Them All!", 0, true).requirement("Treasure Trail hidey-holes", 58).build());
        achievements.add(new AchievementBuilder("Final Boss", 0, true).requirement("Who's the Boss? VI", 1)
            .requirement("General Mayhem VI", 1).requirement("Zilly Way to Die VI", 1).requirement("Three Heads are Deader than One VI", 1)
            .requirement("Mole Removal VI", 1).requirement("Along Came a Spider VI", 1).requirement("Bug Swatter VI", 1)
            .requirement("Vindictive and Vexatious VI", 1).requirement("Fast and Furious VI", 1).requirement("Elemental Kill Chaos VI", 1)
            .requirement("Hardly a Challenge VI", 1).requirement("Barrowed Power VI", 1).requirement("Come and Have Vorago VI", 1)
            .requirement("Nex Pls VI", 1).requirement("Yak and Ruin VI", 1).requirement("Bird is the Word VI", 1)
            .requirement("Kill K'ril VI", 1).requirement("Corporeal Punishment VI", 1).requirement("Loot Pinata VI", 1)
            .requirement("Descension VI", 1).requirement("Dagannoth For Everyone VI", 1).requirement("Telos Where it Hurts VI", 1)
            .requirement("This Helwyr in VI", 1).requirement("Gregorgeous VI", 1).requirement("Living on a Prayer Switch VI", 1)
            .requirement("Something Barrowed VI", 1).requirement("Bug Zapper VI", 1).requirement("Brass Nex VI", 1)
            .requirement("Master of Beatings VI", 1).build());
        achievements.add(new AchievementBuilder("Finish Him!", 0, true).encounter(new Encounter(Enemy.VORAGO)).build());
        achievements.add(new AchievementBuilder("Firemaking - Bernie", 0, true).requirement("Bernie", 1).build());
        achievements.add(new AchievementBuilder("Firemaking 5", 0, true).requirement("Firemaking", 5).build());
        achievements.add(new AchievementBuilder("Firemaking 10", 0, true).requirement("Firemaking", 10).build());
        achievements.add(new AchievementBuilder("Firemaking 20", 0, true).requirement("Firemaking", 20).build());
        achievements.add(new AchievementBuilder("Firemaking 30", 0, true).requirement("Firemaking", 30).build());
        achievements.add(new AchievementBuilder("Firemaking 40", 0, true).requirement("Firemaking", 40).build());
        achievements.add(new AchievementBuilder("Firemaking 50", 0, true).requirement("Firemaking", 50).build());
        achievements.add(new AchievementBuilder("Firemaking 60", 0, true).requirement("Firemaking", 60).build());
        achievements.add(new AchievementBuilder("Firemaking 70", 0, true).requirement("Firemaking", 70).build());
        achievements.add(new AchievementBuilder("Firemaking 80", 0, true).requirement("Firemaking", 80).build());
        achievements.add(new AchievementBuilder("Firemaking 90", 0, true).requirement("Firemaking", 90).build());
        achievements.add(new AchievementBuilder("Firemaking 92", 0, true).requirement("Firemaking", 92).build());
        achievements.add(new AchievementBuilder("Firemaking 99", 0, true).requirement("Firemaking", 99).build());
        achievements.add(new AchievementBuilder("Fires are Mostly Harmless", 0, true)
            .requirement("Fairy Tale III post-quest rewards", 2).build());
        achievements.add(new AchievementBuilder("First Rule of Fight Caves", 0, true).requirement("TzHaar uniques", 1).build());
        achievements.add(new AchievementBuilder("Fish Fingers", 0, true).requirement("Strength", 35).requirement("Fishing", 55)
            .requirement("Barbarian Fishing Training", 1).reward("Fishing", 80).reward("Raw tuna", 1).build());
        achievements.add(new AchievementBuilder("Fishing - Bubbles", 0, true).requirement("Bubbles", 1).build());
        achievements.add(new AchievementBuilder("Fishing 5", 0, true).requirement("Fishing", 5).build());
        achievements.add(new AchievementBuilder("Fishing 10", 0, true).requirement("Fishing", 10).build());
        achievements.add(new AchievementBuilder("Fishing 20", 0, true).requirement("Fishing", 20).build());
        achievements.add(new AchievementBuilder("Fishing 30", 0, true).requirement("Fishing", 30).build());
        achievements.add(new AchievementBuilder("Fishing 40", 0, true).requirement("Fishing", 40).build());
        achievements.add(new AchievementBuilder("Fishing 50", 0, true).requirement("Fishing", 50).build());
        achievements.add(new AchievementBuilder("Fishing 60", 0, true).requirement("Fishing", 60).build());
        achievements.add(new AchievementBuilder("Fishing 70", 0, true).requirement("Fishing", 70).build());
        achievements.add(new AchievementBuilder("Fishing 80", 0, true).requirement("Fishing", 80).build());
        achievements.add(new AchievementBuilder("Fishing 90", 0, true).requirement("Fishing", 90).build());
        achievements.add(new AchievementBuilder("Fishing 92", 0, true).requirement("Fishing", 92).build());
        achievements.add(new AchievementBuilder("Fishing 99", 0, true).requirement("Fishing", 99).build());
        achievements.add(new AchievementBuilder("Fist Contact", 0, true).requirement("Strength", 70)
            .encounter(new Encounter(Enemy.GENERAL_GRAARDOR, Arrays.asList(new Restriction("Main-hand", 0),
                new Restriction("Off-hand", 0)))).build());
        achievements.add(new AchievementBuilder("Five-Star General", 0, true).requirement("General Graardor uniques", 18).build());
        achievements.add(new AchievementBuilder("Fletching - Flo", 0, true).requirement("Flo", 1).build());
        achievements.add(new AchievementBuilder("Fletching 5", 0, true).requirement("Fletching", 5).build());
        achievements.add(new AchievementBuilder("Fletching 10", 0, true).requirement("Fletching", 10).build());
        achievements.add(new AchievementBuilder("Fletching 20", 0, true).requirement("Fletching", 20).build());
        achievements.add(new AchievementBuilder("Fletching 30", 0, true).requirement("Fletching", 30).build());
        achievements.add(new AchievementBuilder("Fletching 40", 0, true).requirement("Fletching", 40).build());
        achievements.add(new AchievementBuilder("Fletching 50", 0, true).requirement("Fletching", 50).build());
        achievements.add(new AchievementBuilder("Fletching 60", 0, true).requirement("Fletching", 60).build());
        achievements.add(new AchievementBuilder("Fletching 70", 0, true).requirement("Fletching", 70).build());
        achievements.add(new AchievementBuilder("Fletching 80", 0, true).requirement("Fletching", 80).build());
        achievements.add(new AchievementBuilder("Fletching 90", 0, true).requirement("Fletching", 90).build());
        achievements.add(new AchievementBuilder("Fletching 92", 0, true).requirement("Fletching", 92).build());
        achievements.add(new AchievementBuilder("Fletching 99", 0, true).requirement("Fletching", 99).build());
        achievements.add(new AchievementBuilder("Floor is Larval", 0, true).requirement("Summoning", 60)
            .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM,
                Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM),
                Arrays.asList(Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM,
                    Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM), Arrays.asList(Enemy.GIANT_WORM,
                    Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM,
                    Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM), Collections.singletonList(Enemy.QUEEN_BLACK_DRAGON)))).build());
        achievements.add(new AchievementBuilder("For the Love of Mabel", 0, true).requirement("Love Story post-quest rewards", 1).build());
        achievements.add(new AchievementBuilder("Forcae's Mettle", 0, true).requirement("Forcae's journal page", 10).build());
        achievements.add(new AchievementBuilder("Fred's Shearings", 0, true).requirement("Sheep Shearer", 1).build());
        achievements.add(new AchievementBuilder("Fremennik Province", 0, true).build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Easy", 0, true).requirement("King Conifer", 1)
            .requirement("Bring the Antipoisons", 1).requirement("Why Won't You Die?", 1).requirement("Assaulted Goodies", 1)
            .requirement("Oxymoron Incarnate", 1).requirement("Why Did the Lobster Blush?", 1).requirement("Hunting the Hunter", 1)
            .requirement("Peer of the Pier", 1).requirement("A Familiar Feeling", 1).requirement("Endangered Species", 1)
            .lamp(Player.ALL_SKILLS, 5000, 30).build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Elite", 0, true).requirement("Jaws Breaker", 1)
            .requirement("Limber Lumber Jumper", 1).requirement("Astronomical!", 1).requirement("First Stryke", 1)
            .requirement("Leap of Faith", 1).requirement("No Smoke Without Pyre", 1).requirement("This Hasta Work", 1)
            .requirement("Potting With Otto", 1).requirement("Axe'll Grease", 1).lamp(Player.ALL_SKILLS, 40000, 89)
            .lamp(Player.ALL_SKILLS, 30000, 86).lamp(Player.ALL_SKILLS, 30000, 86).lamp(Player.ALL_SKILLS, 30000, 86)
            .lamp(Player.ALL_SKILLS, 30000, 86).build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Hard", 0, true).requirement("Pyre At Will", 1)
            .requirement("Defeating Deadly Dagannoths", 1).requirement("Dress to Impress", 1).requirement("The Graceful Barbarian", 1)
            .requirement("Runes on the Moon", 1).requirement("Fish Fingers", 1).requirement("Easy As Pie", 1)
            .requirement("How to Maim Your Dragon", 1).requirement("A Periodic Table", 1).lamp(Player.ALL_SKILLS, 15000, 50).build());
        achievements.add(new AchievementBuilder("Fremennik Set Tasks - Medium", 0, true).requirement("Yak Attack", 1)
            .requirement("Fremennik History 101", 1).requirement("Cool Story, Bro", 1).requirement("Who's a Good Boy?", 1)
            .requirement("Only Takes a Little Vial", 1).requirement("You Know You Want It!", 1).requirement("Fremmental", 1)
            .requirement("Fairy Mountaneering", 1).requirement("You Really Don't Need Any More Shoes", 1).requirement("Big Game Hunter", 1)
            .requirement("Grand Theft Fish", 1).lamp(Player.ALL_SKILLS, 10000, 40).build());
        achievements.add(new AchievementBuilder("Friendly Neighbour", 0, true).requirement("Araxxor uniques", 15).build());
        achievements.add(new AchievementBuilder("Friends with Max", 0, true).requirement("Agility", 99).requirement("Attack", 99)
            .requirement("Strength", 99).requirement("Defense", 99).requirement("Ranged", 99).requirement("Prayer", 99)
            .requirement("Invention", 99).requirement("Constitution", 99).requirement("Crafting", 99).requirement("Mining", 99)
            .requirement("Smithing", 99).requirement("Fishing", 99).requirement("Cooking", 99).requirement("Firemaking", 99)
            .requirement("Woodcutting", 99).requirement("Runecrafting", 99).requirement("Dungeoneering", 99).requirement("Fletching", 99)
            .requirement("Herblore", 99).requirement("Thieving", 99).requirement("Magic", 99).requirement("Slayer", 99)
            .requirement("Farming", 99).requirement("Construction", 99).requirement("Hunter", 99).requirement("Summoning", 99)
            .requirement("Divination", 99).build());
        achievements.add(new AchievementBuilder("Fruit of the Loom", 0, true).requirement("Willow branch", 6).requirement("Crafting", 36)
            .reward("Basket", 1).reward("Crafting", 56).build());
    }

    private void addAchievementsG() {
        achievements.add(new AchievementBuilder("Game Over", 0, true).requirement("Gregorovic uniques", 8).build());
        achievements.add(new AchievementBuilder("General Awwdor", 0, true).requirement("General Awwdor", 1).build());
        achievements.add(new AchievementBuilder("General Disaster I", 0, true).requirement("General Graardor (hard)", 5).build());
        achievements.add(new AchievementBuilder("General Disaster II", 0, true).requirement("General Graardor (hard)", 10).build());
        achievements.add(new AchievementBuilder("General Disaster III", 0, true).requirement("General Graardor (hard)", 25).build());
        achievements.add(new AchievementBuilder("General Disaster IV", 0, true).requirement("General Graardor (hard)", 50).build());
        achievements.add(new AchievementBuilder("General Disaster V", 0, true).requirement("General Graardor (hard)", 75).build());
        achievements.add(new AchievementBuilder("General Disaster VI", 0, true).requirement("General Graardor (hard)", 100).build());
        achievements.add(new AchievementBuilder("General Mayhem I", 0, true).requirement("General Graardor", 5).build());
        achievements.add(new AchievementBuilder("General Mayhem II", 0, true).requirement("General Graardor", 10).build());
        achievements.add(new AchievementBuilder("General Mayhem III", 0, true).requirement("General Graardor", 25).build());
        achievements.add(new AchievementBuilder("General Mayhem IV", 0, true).requirement("General Graardor", 50).build());
        achievements.add(new AchievementBuilder("General Mayhem V", 0, true).requirement("General Graardor", 75).build());
        achievements.add(new AchievementBuilder("General Mayhem VI", 0, true).requirement("General Graardor", 100).build());
        achievements.add(new AchievementBuilder("Gift from Sliske", 0, true).requirement("Sliske after-quest tasks", 2).build());
        achievements.add(new AchievementBuilder("Globetrotter", 0, true).requirement("Globetrotter outfit pieces", 5).build());
        achievements.add(new AchievementBuilder("Glutton for Punishment", 0, true).requirement("Dreadfowl pouch", 1)
            .requirement("Thorny snail pouch", 1).requirement("Pack pig pouch", 1).requirement("Evil turnip pouch", 1)
            .requirement("War tortoise pouch", 1).requirement("Fruit bat pouch", 1).requirement("Granite lobster pouch", 1)
            .requirement("Bringing Home the Bacon", 1).requirement("Summer's End", 1).requirement("Summoning", 74).build());
        achievements.add(new AchievementBuilder("God Wars Dungeon Teleport", 0, true).requirement("Law rune", 2)
            .requirement("The Mighty Fall", 1).requirement("Fire rune", 2).requirement("Magic", 61).reward("Magic", 68).build());
        achievements.add(new AchievementBuilder("Goebie Relics", 0, true).requirement("Stone fragments", 5).build());
        achievements.add(new AchievementBuilder("Going Down with the Ship", 0.2, true).requirement("Fishing", 15).build());
        achievements.add(new AchievementBuilder("Going for a Punt", 0, true).requirement("Boater", 1).requirement("Woodcutting", 57)
            .reward("Woodcutting", 150).build());
        achievements.add(new AchievementBuilder("Going on a Summer Holidat", 0, true).requirement("Coins", 30).build());
        achievements.add(new AchievementBuilder("Gone Fishing", 0, true).requirement("Fishing", 15).build());
        achievements.add(new AchievementBuilder("Gong Maintenance Expert", 0, true)
            .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
                Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CORMES),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
                Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG)))).build());
        achievements.add(new AchievementBuilder("Good Enough for a Goblin", 0, true).requirement("Summer's End", 1)
            .encounter(new Encounter(Enemy.CORPOREAL_BEAST, Collections.singletonList(new Restriction("Bronze spear", 1)))).build());
        achievements.add(new AchievementBuilder("Got a Vyre Reputation", 0, true).requirement("Maximum vyre reputation", 1).build());
        achievements.add(new AchievementBuilder("Graardone", 0, true).requirement("Strength", 70)
            .encounter(new Encounter(Enemy.GENERAL_GRAARDOR, Collections.singletonList(new Restriction("Ticks", 25)))).build());
        achievements.add(new AchievementBuilder("Great Gielinor Run", 0.25, true).requirement("The Branches of Darkmeyer", 1)
            .requirement("Regicide", 1).build());
        achievements.add(new AchievementBuilder("Greg", 0, true).requirement("Greg", 1).build());
        achievements.add(new AchievementBuilder("Gregore-Y I", 0, true).requirement("Gregorovic (hard)", 5).build());
        achievements.add(new AchievementBuilder("Gregore-Y II", 0, true).requirement("Gregorovic (hard)", 10).build());
        achievements.add(new AchievementBuilder("Gregore-Y III", 0, true).requirement("Gregorovic (hard)", 25).build());
        achievements.add(new AchievementBuilder("Gregore-Y IV", 0, true).requirement("Gregorovic (hard)", 50).build());
        achievements.add(new AchievementBuilder("Gregore-Y V", 0, true).requirement("Gregorovic (hard)", 75).build());
        achievements.add(new AchievementBuilder("Gregore-Y VI", 0, true).requirement("Gregorovic (hard)", 100).build());
        achievements.add(new AchievementBuilder("Gregorgeous I", 0, true).requirement("Gregorovic", 5).build());
        achievements.add(new AchievementBuilder("Gregorgeous II", 0, true).requirement("Gregorovic", 10).build());
        achievements.add(new AchievementBuilder("Gregorgeous III", 0, true).requirement("Gregorovic", 25).build());
        achievements.add(new AchievementBuilder("Gregorgeous IV", 0, true).requirement("Gregorovic", 50).build());
        achievements.add(new AchievementBuilder("Gregorgeous V", 0, true).requirement("Gregorovic", 75).build());
        achievements.add(new AchievementBuilder("Gregorgeous VI", 0, true).requirement("Gregorovic", 100).build());
        achievements.add(new AchievementBuilder("Grinding My Gears", 0, true).requirement("Wheat", 1).requirement("Empty pot", 1)
            .reward("Pot of flour", 1).build());
        achievements.add(new AchievementBuilder("Grondaban's legacy", 0, true).requirement("Dishonour among Thieves", 1).build());
        achievements.add(new AchievementBuilder("Guard is Dead", 0, true).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .encounter(new Encounter(Enemy.NEW_VARROCK_GUARD)).reward("Zemomark", 80).build());
        achievements.add(new AchievementBuilder("Gunning for Jewellery", 0, true).requirement("Dororan's jewellery", 3).build());
        achievements.add(new AchievementBuilder("Guthan Bobblehead", 0, true).requirement("Guthan the Bobbled", 1).build());
    }

    private void addAchievementsH() {
        achievements.add(new AchievementBuilder("Hail to the Queen", 0, true)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KALPHITE_GUARDIAN, Enemy.KALPHITE_GUARDIAN,
            Enemy.KALPHITE_QUEEN_PHASE_1), Collections.singletonList(Enemy.KALPHITE_QUEEN_PHASE_2)))).build());
        achievements.add(new AchievementBuilder("Hail to the Duke, Baby", 0, true).build());
        achievements.add(new AchievementBuilder("Hand Exchange", 0, true).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .reward("Zemomark", 20).build());
        achievements.add(new AchievementBuilder("Handicrafts", 0, true).requirement("Thread", 1).requirement("Leather", 1)
            .reward("Crafting", 14).reward("Leather gloves", 1).build());
        achievements.add(new AchievementBuilder("Hang On to Something", 0, true).build());
        achievements.add(new AchievementBuilder("Happy Hour", 0, true).requirement("Cider", 5).build());
        achievements.add(new AchievementBuilder("Hard As Daemons", 0, true).requirement("Hard mode floors", 60).build());
        achievements.add(new AchievementBuilder("Hard as a Rock", 0, true).requirement("Vorago uniques", 11).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge I", 0, true).requirement("Har-Aken", 5).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge II", 0, true).requirement("Har-Aken", 10).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge III", 0, true).requirement("Har-Aken", 25).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge IV", 0, true).requirement("Har-Aken", 50).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge V", 0, true).requirement("Har-Aken", 75).build());
        achievements.add(new AchievementBuilder("Hardly a Challenge VI", 0, true).requirement("Har-Aken", 100).build());
        achievements.add(new AchievementBuilder("Haul Comes to Templeton", 0.05, true).requirement("Dealing with Scabaras", 1).build());
        achievements.add(new AchievementBuilder("Heal, Quickly", 0, true).requirement("Rapid Renewal", 1).build());
        achievements.add(new AchievementBuilder("Heart to Heart", 0, true).requirement("Twin Furies uniques", 9).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket I", 0, true).requirement("Helwyr (hard)", 5).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket II", 0, true).requirement("Helwyr (hard)", 10).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket III", 0, true).requirement("Helwyr (hard)", 25).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket IV", 0, true).requirement("Helwyr (hard)", 50).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket V", 0, true).requirement("Helwyr (hard)", 75).build());
        achievements.add(new AchievementBuilder("Hel in a Handbasket VI", 0, true).requirement("Helwyr (hard)", 100).build());
        achievements.add(new AchievementBuilder("Herbi's Flax", 0, true).requirement("Diary of Herbi Flax", 1).reward("Herblore", 335)
            .build());
        achievements.add(new AchievementBuilder("Herblore - Herbert", 0, true).requirement("Herbert", 1).build());
        achievements.add(new AchievementBuilder("Herblore 5", 0, true).requirement("Herblore", 5).build());
        achievements.add(new AchievementBuilder("Herblore 10", 0, true).requirement("Herblore", 10).build());
        achievements.add(new AchievementBuilder("Herblore 20", 0, true).requirement("Herblore", 20).build());
        achievements.add(new AchievementBuilder("Herblore 30", 0, true).requirement("Herblore", 30).build());
        achievements.add(new AchievementBuilder("Herblore 40", 0, true).requirement("Herblore", 40).build());
        achievements.add(new AchievementBuilder("Herblore 50", 0, true).requirement("Herblore", 50).build());
        achievements.add(new AchievementBuilder("Herblore 60", 0, true).requirement("Herblore", 60).build());
        achievements.add(new AchievementBuilder("Herblore 70", 0, true).requirement("Herblore", 70).build());
        achievements.add(new AchievementBuilder("Herblore 80", 0, true).requirement("Herblore", 80).build());
        achievements.add(new AchievementBuilder("Herblore 90", 0, true).requirement("Herblore", 90).build());
        achievements.add(new AchievementBuilder("Herblore 92", 0, true).requirement("Herblore", 92).build());
        achievements.add(new AchievementBuilder("Herblore 99", 0, true).requirement("Herblore", 99).build());
        achievements.add(new AchievementBuilder("Here Was a Scabaras Mask", 0.05, true).requirement("Mining", 80)
            .requirement("Diamond in the Rough", 1).reward("Mining", 20000).reward("Scabaras mask", 1).reward("Was", 1).build());
        achievements.add(new AchievementBuilder("Here We Rago Again I", 0, true).requirement("Vorago (hard)", 5).build());
        achievements.add(new AchievementBuilder("Here We Rago Again II", 0, true).requirement("Vorago (hard)", 10).build());
        achievements.add(new AchievementBuilder("Here We Rago Again III", 0, true).requirement("Vorago (hard)", 25).build());
        achievements.add(new AchievementBuilder("Here We Rago Again IV", 0, true).requirement("Vorago (hard)", 50).build());
        achievements.add(new AchievementBuilder("Here We Rago Again V", 0, true).requirement("Vorago (hard)", 75).build());
        achievements.add(new AchievementBuilder("Here We Rago Again VI", 0, true).requirement("Vorago (hard)", 100).build());
        achievements.add(new AchievementBuilder("Hero of the Goebies", 0, true).requirement("All Together Now", 1)
            .requirement("Animal Cruelty", 1).requirement("Better Not Touch", 1).requirement("Cormes and Goes", 1)
            .requirement("Day at the Aquarium", 1).requirement("Day at the Pound", 1).requirement("Gong Maintenance Expert", 1)
            .requirement("Make Friends and Influence People", 1).requirement("Prison Break", 1).requirement("Rewind", 1).build());
        achievements.add(new AchievementBuilder("Hide and Seek", 0, true).requirement("Zombie cowhide", 1)
            .requirement("Dimension of Disaster: Coin of the Realm", 1).reward("Leather", 1).reward("Zemomark", 20).build());
        achievements.add(new AchievementBuilder("History of Bilrach", 0, true).requirement("Mysterious chronicle", 30).build());
        achievements.add(new AchievementBuilder("Honestly, It's Not a Purse", 0, true).requirement("Giant pouch", 1)
            .requirement("Pure essence", 1).build());
        achievements.add(new AchievementBuilder("How Many Games?", 0, true).requirement("Profound helmet", 1)
            .requirement("Profound chestplate", 1).requirement("Profound platelegs", 1).requirement("Profound sword", 1)
            .requirement("Profound shield", 1).build());
        achievements.add(new AchievementBuilder("How to Shame Your Dragon", 0, true).requirement("King Black Dragon uniques", 1).build());
        achievements.add(new AchievementBuilder("Hungry Hungry Reavers", 0, true).requirement("Frozen key", 1)
            .encounter(new Encounter(Enemy.NEX_ANGEL_OF_DEATH)).build());
        achievements.add(new AchievementBuilder("Hunter - Ace", 0, true).requirement("Ace", 1).build());
        achievements.add(new AchievementBuilder("Hunter 5", 0, true).requirement("Hunter", 5).build());
        achievements.add(new AchievementBuilder("Hunter 10", 0, true).requirement("Hunter", 10).build());
        achievements.add(new AchievementBuilder("Hunter 20", 0, true).requirement("Hunter", 20).build());
        achievements.add(new AchievementBuilder("Hunter 30", 0, true).requirement("Hunter", 30).build());
        achievements.add(new AchievementBuilder("Hunter 40", 0, true).requirement("Hunter", 40).build());
        achievements.add(new AchievementBuilder("Hunter 50", 0, true).requirement("Hunter", 50).build());
        achievements.add(new AchievementBuilder("Hunter 60", 0, true).requirement("Hunter", 60).build());
        achievements.add(new AchievementBuilder("Hunter 70", 0, true).requirement("Hunter", 70).build());
        achievements.add(new AchievementBuilder("Hunter 80", 0, true).requirement("Hunter", 80).build());
        achievements.add(new AchievementBuilder("Hunter 90", 0, true).requirement("Hunter", 90).build());
        achievements.add(new AchievementBuilder("Hunter 92", 0, true).requirement("Hunter", 92).build());
        achievements.add(new AchievementBuilder("Hunter 99", 0, true).requirement("Hunter", 99).build());
    }

    private void addAchievementsI() {
        achievements.add(new AchievementBuilder("I'm Forever Washing Shadows", 0, true).requirement("Blissful shadow core drops", 15)
        .requirement("Truthful shadow core drops", 15).requirement("Manifest shadow core drops", 15).reward("Divination", 50000).build());
        achievements.add(new AchievementBuilder("I Can See For Miles and Miles", 0, true)
            .requirement("Beacon keepers with macaws", 12).build());
        achievements.add(new AchievementBuilder("I Dig This Transportation", 0, true).requirement("Digsite pendant unlock", 1).build());
        achievements.add(new AchievementBuilder("I Got This", 0, true).requirement("Slayer", 95).requirement("Ascension Keystone Primus", 1)
            .requirement("Ascension Keystone Secundus", 1).requirement("Ascension Keystone Tertius", 1)
            .requirement("Ascension Keystone Quartus", 1).requirement("Ascension Keystone Quintus", 1)
            .requirement("Ascension Keystone Sextus", 1).encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.LEGIO),
                Collections.singletonList(Enemy.LEGIO), Collections.singletonList(Enemy.LEGIO), Collections.singletonList(Enemy.LEGIO),
                Collections.singletonList(Enemy.LEGIO), Collections.singletonList(Enemy.LEGIO)))).build());
        achievements.add(new AchievementBuilder("I Presume Thes Rewards Are Mine, Death?", 0, true)
            .requirement("Missing, Presumed Death post-quest rewards", 4).build());
        achievements.add(new AchievementBuilder("Ice Ice Chimpy", 0, true).requirement("Chimp ice deliveries", 25).build());
        achievements.add(new AchievementBuilder("Icthlarin's Little Chest", 0, true).requirement("Icthlarin's Little Helper", 1)
            .reward("Coins", 50).build());
        achievements.add(new AchievementBuilder("Imping Around", 0, true).requirement("Daffyd implings", 16).reward("Hunter", 50000)
            .build());
        achievements.add(new AchievementBuilder("Impressing Char", 0, true).requirement("The Firemaker's Curse", 1)
            .requirement("Firemaking", 91).reward("Firemaking", 7387).build());
        achievements.add(new AchievementBuilder("In the Spirit of Things", 0, true).requirement("Prayer", 80)
            .encounter(new Encounter(Enemy.GREGOROVIC)).build());
        achievements.add(new AchievementBuilder("Insane Final Boss", 0, true).requirement("Final Boss", 1).requirement("Birdstrike VI", 1)
            .requirement("General Disaster", 1).requirement("Gregore-Y VI", 1).requirement("Hel in a Handbasket VI", 1)
            .requirement("Here We Rago Again VI", 1).requirement("Kill K'ril Vol 2 VI", 1).requirement("More Fast More Furious", 1)
            .requirement("Vindictive VI", 1).requirement("Whack a Mole VI", 1).requirement("Zillier Way to Die VI", 1)
            .requirement("Boss pets", 46).build());
        achievements.add(new AchievementBuilder("Invention - Malcolm", 0, true).requirement("Malcolm", 1).build());
        achievements.add(new AchievementBuilder("Invention 5", 0, true).requirement("Invention", 5).build());
        achievements.add(new AchievementBuilder("Invention 10", 0, true).requirement("Invention", 10).build());
        achievements.add(new AchievementBuilder("Invention 20", 0, true).requirement("Invention", 20).build());
        achievements.add(new AchievementBuilder("Invention 30", 0, true).requirement("Invention", 30).build());
        achievements.add(new AchievementBuilder("Invention 40", 0, true).requirement("Invention", 40).build());
        achievements.add(new AchievementBuilder("Invention 50", 0, true).requirement("Invention", 50).build());
        achievements.add(new AchievementBuilder("Invention 60", 0, true).requirement("Invention", 60).build());
        achievements.add(new AchievementBuilder("Invention 70", 0, true).requirement("Invention", 70).build());
        achievements.add(new AchievementBuilder("Invention 80", 0, true).requirement("Invention", 80).build());
        achievements.add(new AchievementBuilder("Invention 90", 0, true).requirement("Invention", 90).build());
        achievements.add(new AchievementBuilder("Invention 99", 0, true).requirement("Invention", 99).build());
        achievements.add(new AchievementBuilder("Invention 102", 0, true).requirement("Invention", 102).build());
        achievements.add(new AchievementBuilder("Invention 110", 0, true).requirement("Invention", 110).build());
        achievements.add(new AchievementBuilder("Invention 120", 0, true).requirement("Invention", 120).build());
        achievements.add(new AchievementBuilder("Invention Gives Me the Blues", 0, true).requirement("Dwarven tech tree items", 8)
            .requirement("Cave goblin tech tree items", 8).build());
        achievements.add(new AchievementBuilder("It's Not Called Surging Tombs", 0.05, true).requirement("The Jack of Spades", 1)
            .reward("Shifting Tombs", 1).build());
        achievements.add(new AchievementBuilder("Ivan is Flailing", 0, true).requirement("Vyre corpses", 500).build());
    }

    private void addAchievementsJ() {
        achievements.add(new AchievementBuilder("Jack of All Blades", 0, true).requirement("Combat skilling pets", 9).build());
        achievements.add(new AchievementBuilder("Jack of All Trades", 0, true).requirement("Non-combat skilling pets", 18).build());
        achievements.add(new AchievementBuilder("Jack of Blades", 0, true).requirement("Combat skilling pets", 3).build());
        achievements.add(new AchievementBuilder("Jack of Trades", 0, true).requirement("Non-combat skilling pets", 5).build());
        achievements.add(new AchievementBuilder("Jack of the Circus", 0, true).requirement("Circus clothing", 26).build());
        achievements.add(new AchievementBuilder("Just Give Me a Sign", 0, true).requirement("Divination", 6).requirement("Pale energy", 30)
            .requirement("Sapphire necklace", 1).reward("Sign of the porter I", 1).reward("Divination", 2).build());
    }

    private void addAchievementsK() {
        achievements.add(new AchievementBuilder("K'ril Tinyroth", 0, true).requirement("K'ril Tinyroth", 1).build());
        achievements.add(new AchievementBuilder("K'ril Will Be Done", 0, true).requirement("Constitution", 70)
            .encounter(new Encounter(Enemy.KRIL_TSUTSAROTH)).build());
        achievements.add(new AchievementBuilder("K'rilow", 0, true).requirement("Constitution", 70).requirement("Willow shieldbow", 1)
            .encounter(new Encounter(Enemy.KRIL_TSUTSAROTH, Collections.singletonList(new Restriction("Willow shieldbow", 1)))).build());
        achievements.add(new AchievementBuilder("Kaiki's Tuska", 0, true).requirement("Kaigi's journal", 1)
            .requirement("Kaigi's journal pages", 4).build());
        achievements.add(new AchievementBuilder("Kal'gerion Commander", 0, true).requirement("Kal'gerion battle commendation", 5).build());
        achievements.add(new AchievementBuilder("Kal'gerion Notes", 0, true).requirement("Kal'gerion Notes", 5).build());
        achievements.add(new AchievementBuilder("Kalphite Grublet (Flying)", 0, true).requirement("Kalphite Grublet", 1).build());
        achievements.add(new AchievementBuilder("Kalphite Grublet", 0, true).requirement("Kalphite Grublet", 1).build());
        achievements.add(new AchievementBuilder("Kalphite Grubling", 0, true).requirement("Kalphite Grubling", 1).build());
        achievements.add(new AchievementBuilder("Kami Spirits of the Arc", 0, true).requirement("Kami", 16).reward("Hunter", 50000)
            .build());
        achievements.add(new AchievementBuilder("Karamja", 0, true).build());
        achievements.add(new AchievementBuilder("Karamja Set Tasks - Easy", 0, true).requirement("Five a Day", 1)
            .requirement("I'm Lichen This!", 1).requirement("Golden Shores", 1).requirement("Put to Port in Port Sarim", 1)
            .requirement("Avast Ardougne!", 1).requirement("Show That You Cairn", 1).requirement("Fruity Catch", 1)
            .requirement("Beachcomber", 1).requirement("TzHaar Wars", 1).requirement("It's a Jungle Ogre", 1)
            .lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("Karamja Set Tasks - Elite", 0, true).requirement("The Power of Lava", 1)
            .requirement("At One Plus Fifty-Five With Nature", 1).requirement("Boxing Clever", 1).requirement("It's a Snap", 1)
            .requirement("Crunchy Coating", 1).requirement("Walkies!", 1).requirement("Tread Carefully", 1).requirement("Ten in a Row", 1)
            .lamp(Player.ALL_SKILLS, 55000, 87).lamp(Player.ALL_SKILLS, 55000, 87).lamp(Player.ALL_SKILLS, 30000, 64).build());
        achievements.add(new AchievementBuilder("Karamja Set Tasks - Hard", 0, true).requirement("Flawless Victory", 1)
            .requirement("Play Dead, Doggy", 1).requirement("I'd Be Kharazi to Eat This", 1).requirement("At One With Nature", 1)
            .requirement("Drop It Like It's Hot", 1).requirement("Deadwing", 1).requirement("Quick As a Shot", 1)
            .requirement("Can Opener", 1).requirement("Yes, My Master", 1).requirement("A Palm For Each Finger", 1)
            .lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("Karamja Set Tasks - Medium", 0, true).requirement("Just the Ticket", 1)
            .requirement("Back Cran-door", 1).requirement("Dungeons and Dragons", 1).requirement("Horseless Carriage", 1)
            .requirement("They Like Me! They Really Like Me!", 1).requirement("Arachnophagia", 1).requirement("Romancing the Stone", 1)
            .requirement("I'm a Lumberjack and I'm Okay", 1).requirement("I Sleep All Night and I Work All Day", 1)
            .requirement("To Catch a Karambwan", 1).requirement("That's Not a Knife", 1).requirement("Falling With Style", 1)
            .requirement("Scourge of Scurvy", 1).requirement("Hungers of the Horned Graahk", 1).requirement("The Roots of All Evil", 1)
            .requirement("Points of No Return", 1).requirement("Stairway to Haven", 1).requirement("Thank You, Madam", 1)
            .requirement("Shipping Out From the Shipyard", 1).lamp(Player.ALL_SKILLS, 5000, 40).build());
        achievements.add(new AchievementBuilder("Karil Bobblehead", 0, true).requirement("Karil the Bobbled", 1).build());
        achievements.add(new AchievementBuilder("Keeper of the Faith", 0, true).requirement("Commander Zilyana uniques", 17).build());
        achievements.add(new AchievementBuilder("Keeping Up with the Carnilleans", 0, true).requirement("Carnillean lamps", 7).build());
        achievements.add(new AchievementBuilder("Kharshai's Memories", 0, true).requirement("Mahjarrat memories", 15)
            .reward("Divination", 150000).build());
        achievements.add(new AchievementBuilder("Kill K'ril I", 0, true).requirement("K'ril Tsutsaroth", 5).build());
        achievements.add(new AchievementBuilder("Kill K'ril II", 0, true).requirement("K'ril Tsutsaroth", 10).build());
        achievements.add(new AchievementBuilder("Kill K'ril III", 0, true).requirement("K'ril Tsutsaroth", 25).build());
        achievements.add(new AchievementBuilder("Kill K'ril IV", 0, true).requirement("K'ril Tsutsaroth", 50).build());
        achievements.add(new AchievementBuilder("Kill K'ril V", 0, true).requirement("K'ril Tsutsaroth", 75).build());
        achievements.add(new AchievementBuilder("Kill K'ril VI", 0, true).requirement("K'ril Tsutsaroth", 100).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 I", 0, true).requirement("K'ril Tsutsaroth (hard)", 5).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 II", 0, true).requirement("K'ril Tsutsaroth (hard)", 10).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 III", 0, true).requirement("K'ril Tsutsaroth (hard)", 25).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 IV", 0, true).requirement("K'ril Tsutsaroth (hard)", 50).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 V", 0, true).requirement("K'ril Tsutsaroth (hard)", 75).build());
        achievements.add(new AchievementBuilder("Kill K'ril Vol 2 VI", 0, true).requirement("K'ril Tsutsaroth (hard)", 100).build());
        achievements.add(new AchievementBuilder("Kiln Fighter", 0, true).requirement("Har-Aken", 1).build());
        achievements.add(new AchievementBuilder("King Black Dragonling", 0, true).requirement("King Black Dragonling", 1).build());
        achievements.add(new AchievementBuilder("Koschei's Cache", 0, true).requirement("Koschei gem colors", 1).build());
        achievements.add(new AchievementBuilder("Krar Jnr", 0, true).requirement("Krar Jnr", 1).build());
        achievements.add(new AchievementBuilder("Kudos to You", 0, true).requirement("Kudos", 198).build());
    }

    private void addAchievementsL() {
        achievements.add(new AchievementBuilder("Last of the Summer Swine", 0, true).requirement("Pig creation machine", 3).build());
        achievements.add(new AchievementBuilder("Learning From Mr Mordaut", 0, true).requirement("One of a Kind", 1)
            .reward("Divination", 5000).build());
        achievements.add(new AchievementBuilder("Legio Primulus", 0, true).requirement("Legio Primulus", 1).build());
        achievements.add(new AchievementBuilder("Legio Quartulus", 0, true).requirement("Legio Quartulus", 1).build());
        achievements.add(new AchievementBuilder("Legio Quintulus", 0, true).requirement("Legio Quintulus", 1).build());
        achievements.add(new AchievementBuilder("Legio Secundulus", 0, true).requirement("Legio Secundulus", 1).build());
        achievements.add(new AchievementBuilder("Legio Sextulus", 0, true).requirement("Legio Sextulus", 1).build());
        achievements.add(new AchievementBuilder("Legio Tertiolus", 0, true).requirement("Legio Tertiolus", 1).build());
        achievements.add(new AchievementBuilder("Let's Enhance", 0, true).requirement("Pale energy", 5).reward("Divination", 4).build());
        achievements.add(new AchievementBuilder("Let Us Give Ugthanks", 0, true).requirement("Ugthanatos journal", 1).build());
        achievements.add(new AchievementBuilder("Liberated", 0, true).requirement("Mazcab uniques", 19).build());
        achievements.add(new AchievementBuilder("Library of Nex", 0, true).requirement("Nex: Angel of Death", 1).build());
        achievements.add(new AchievementBuilder("Light as a Feather", 0, true).requirement("Kree'arra uniques", 18).build());
        achievements.add(new AchievementBuilder("Lighter Log", 0, true).requirement("Logs", 1).reward("Firemaking", 40).build());
        achievements.add(new AchievementBuilder("Like a Boss", 0, true).encounter(new Encounter(Arrays.asList(
            Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN),
            Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN),
            Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN),
            Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN),
            Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN), Collections.singletonList(Enemy.GOBLIN),
            Collections.singletonList(Enemy.BROKEFACE)))).build());
        achievements.add(new AchievementBuilder("Lil' Tuzzy", 0, true).requirement("Lil' Tuzzy", 1).build());
        achievements.add(new AchievementBuilder("Lilwyr", 0, true).requirement("Lilwyr", 1).build());
        achievements.add(new AchievementBuilder("Little Leaguer", 0, true).reward("Agility", 4).reward("Ranged", 4).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch I", 0, true).requirement("TzTok-Jad", 5).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch II", 0, true).requirement("TzTok-Jad", 10).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch III", 0, true).requirement("TzTok-Jad", 25).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch IV", 0, true).requirement("TzTok-Jad", 50).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch V", 0, true).requirement("TzTok-Jad", 75).build());
        achievements.add(new AchievementBuilder("Living on a Prayer Switch VI", 0, true).requirement("TzTok-Jad", 100).build());
        achievements.add(new AchievementBuilder("Load of Bakulla", 0.1, true).requirement("The Fremennik Trials", 1).build());
        achievements.add(new AchievementBuilder("Lock, Stock, and Barrel", 0, true).requirement("Merchant district reputation", 300000)
            .build());
        achievements.add(new AchievementBuilder("Lodestone Network", 0, true).requirement("Lodestones", 25).build());
        achievements.add(new AchievementBuilder("Lodestone Network Free Area", 0, true).requirement("F2P Lodestones", 11).build());
        achievements.add(new AchievementBuilder("Lodestone Network Members Area", 0, true).requirement("P2P Lodestones", 14).build());
        achievements.add(new AchievementBuilder("Long Live the Queen", 0, true).requirement("Queen Black Dragon", 1).build());
        achievements.add(new AchievementBuilder("Loot Pinata I", 0, true).requirement("Queen Black Dragon", 5).build());
        achievements.add(new AchievementBuilder("Loot Pinata II", 0, true).requirement("Queen Black Dragon", 10).build());
        achievements.add(new AchievementBuilder("Loot Pinata III", 0, true).requirement("Queen Black Dragon", 25).build());
        achievements.add(new AchievementBuilder("Loot Pinata IV", 0, true).requirement("Queen Black Dragon", 50).build());
        achievements.add(new AchievementBuilder("Loot Pinata V", 0, true).requirement("Queen Black Dragon", 75).build());
        achievements.add(new AchievementBuilder("Loot Pinata VI", 0, true).requirement("Queen Black Dragon", 100).build());
        achievements.add(new AchievementBuilder("Looting the Demon Throne", 0, true).requirement("The Golem", 1).reward("Sapphire", 2)
            .reward("Emerald", 2).reward("Ruby", 2).build());
        achievements.add(new AchievementBuilder("Lost Toys", 0, true).requirement("Morytania plushes", 14).build());
        achievements.add(new AchievementBuilder("Long Live the Kings!", 0, true).requirement("Dagannoth Kings uniques", 10).build());
        achievements.add(new AchievementBuilder("Loyal Subject", 0.35, true).requirement("Anti-dragon shield (mole)", 1)
            .reward("Anti-dragon shield", 1).build());
        achievements.add(new AchievementBuilder("Lumbridge", 0, true).build());
        achievements.add(new AchievementBuilder("Lumbridge Catacombs", 0, true).requirement("The Blood Pact", 1).build());
        achievements.add(new AchievementBuilder("Lumbridge Set Tasks - Beginner", 0, true).requirement("Master of All I Survey", 1)
            .requirement("Raise the Roof", 1).requirement("Hail to the Duke, Baby", 1).requirement("Doom!", 1).requirement("Sage Advice", 1)
            .requirement("Window Shopping", 1).requirement("Wait, That's Not a Sheep", 1).requirement("The Nexus Has You", 1)
            .requirement("Clay More", 1).requirement("Just Add Water", 1).requirement("Very Potter", 1).requirement("Hotpot", 1)
            .requirement("In the Countyard", 1).requirement("Grinding My Gears", 1).requirement("Beware of Pigzilla", 1)
            .requirement("The Rules of Engagement", 1).requirement("Tower Power", 1).requirement("Take Your Pick", 1)
            .requirement("Shrimpin' Ain't Easy", 1).requirement("The Fruit of the Sea", 1).requirement("A Grave Consideration", 1)
            .requirement("Tickle the Ivories", 1).requirement("Ring My Bell", 1).requirement("Docking Out", 1)
            .lamp(Player.ALL_SKILLS, 500, 1).build());
        achievements.add(new AchievementBuilder("Lumbridge Set Tasks - Easy", 0, true).requirement("Artisan Crafting", 1)
            .requirement("Bless is More", 1).requirement("Morgan the Merrier", 1).requirement("Iron On", 1)
            .requirement("And It Was THIS Big!", 1).requirement("Belter of a Smelter", 1).requirement("Nowt Tool Look At", 1)
            .requirement("You Doity Rat", 1).requirement("It Was Dead Already!", 1).requirement("Camping Trip", 1)
            .requirement("Ratatouille", 1).requirement("Slippery When Wet", 1).requirement("I Can't Hear Dead People", 1)
            .requirement("Come In Here and Say That", 1).requirement("What Is This Place?", 1).requirement("Money Down the Drayn", 1)
            .requirement("Klept-Old-Man-ia", 1).requirement("Eye on the Prize", 1).requirement("Draaaaaiiiiiins...", 1)
            .lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("Lumbridge Set Tasks - Hard", 0, true).requirement("A Body in the Sewers", 1)
            .requirement("Building Up Strength", 1).requirement("Have Your Cake and Eat It", 1).requirement("Blast and Hellfire", 1)
            .requirement("Gods, Give Me Strength", 1).requirement("Not Waving But Drowning", 1)
            .requirement("Are Yew As Fired Up As I Am?", 1).lamp(Player.ALL_SKILLS, 9000, 49).build());
        achievements.add(new AchievementBuilder("Lumbridge Set Tasks - Medium", 0, true).requirement("Steel Justice", 1)
            .requirement("Ease of Access", 1).requirement("Everybody Loves Coal!", 1).requirement("Weeping Willow", 1)
            .requirement("Willow the Wisp of Smoke", 1).requirement("A Meal Fit for a Duke", 1).requirement("Always Be Prepared", 1)
            .requirement("Hi Ho, Silver", 1).requirement("Lovely With a Squeeze of Lemon", 1).requirement("One Day, You Shall Be a Fork", 1)
            .requirement("Made to Order", 1).requirement("Where's The Beef?", 1).lamp(Player.ALL_SKILLS, 1500, 35).build());
        achievements.add(new AchievementBuilder("Lumbridge Strikes Back", 0, true).requirement("Bronze full helm", 1)
            .requirement("Bronze platebody", 1).requirement("Bronze platelegs", 1).requirement("Bronze 2h sword", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.ARAXXOR), Collections.singletonList(Enemy.ARAXXI)),
                Arrays.asList(new Restriction("Bronze full helm", 1), new Restriction("Bronze platebody", 1),
                    new Restriction("Bronze platelegs", 1), new Restriction("Bronze 2h sword", 1)))).build());
        achievements.add(new AchievementBuilder("Lunar Isle", 0, true).requirement("Lunar Diplomacy", 1).build());
        achievements.add(new AchievementBuilder("Lunar Master", 0, true).requirement("Lunar spells", 11).build());
        achievements.add(new AchievementBuilder("Lurgon's Run", 0.05, true).requirement("Death to the Dorgeshuun", 1).build());
    }

    private void addAchievementsM() {
        achievements.add(new AchievementBuilder("Magic - Newton", 0, true).requirement("Newton", 1).build());
        achievements.add(new AchievementBuilder("Magic 5", 0, true).requirement("Magic", 5).build());
        achievements.add(new AchievementBuilder("Magic 10", 0, true).requirement("Magic", 10).build());
        achievements.add(new AchievementBuilder("Magic 20", 0, true).requirement("Magic", 20).build());
        achievements.add(new AchievementBuilder("Magic 30", 0, true).requirement("Magic", 30).build());
        achievements.add(new AchievementBuilder("Magic 40", 0, true).requirement("Magic", 40).build());
        achievements.add(new AchievementBuilder("Magic 50", 0, true).requirement("Magic", 50).build());
        achievements.add(new AchievementBuilder("Magic 60", 0, true).requirement("Magic", 60).build());
        achievements.add(new AchievementBuilder("Magic 70", 0, true).requirement("Magic", 70).build());
        achievements.add(new AchievementBuilder("Magic 80", 0, true).requirement("Magic", 80).build());
        achievements.add(new AchievementBuilder("Magic 90", 0, true).requirement("Magic", 90).build());
        achievements.add(new AchievementBuilder("Magic 92", 0, true).requirement("Magic", 92).build());
        achievements.add(new AchievementBuilder("Magic 99", 0, true).requirement("Magic", 99).build());
        achievements.add(new AchievementBuilder("Magister Smagister", 0.35, true).build());
        achievements.add(new AchievementBuilder("Make Friends and Influence People", 0, true)
            .requirement("Beastmaster Durzag", 1).encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU)))).build());
        achievements.add(new AchievementBuilder("Make Them Bleed", 0, true).requirement("Rush of Blood maximum waves", 20)
            .reward("Slayer", 50000).build());
        achievements.add(new AchievementBuilder("Mallory", 0, true).requirement("Mallory", 1).build());
        achievements.add(new AchievementBuilder("Many Shades of a Cure", 0, true).requirement("Shades of Mort'ton", 1)
            .requirement("Serum 208", 2).reward("Coins", 391).build());
        achievements.add(new AchievementBuilder("Maria, You Gotta See Her", 0, true).requirement("Broken Home challenges", 3).build());
        achievements.add(new AchievementBuilder("Marmaros and Thok Letters", 0, true).requirement("M. and thok letters", 10).build());
        achievements.add(new AchievementBuilder("Master Angler", 0, true).requirement("Champion's tackle box", 1).build());
        achievements.add(new AchievementBuilder("Master Bowgreman", 0, true).requirement("Chompy kills", 30).build());
        achievements.add(new AchievementBuilder("Master Otto", 0, true).requirement("Barbarian Training", 1).build());
        achievements.add(new AchievementBuilder("Master Quest Cape", 0, true).requirement("Abyssal Reach", 1)
            .requirement("Advanced Sweeping", 1).requirement("Aereck's Old Bones", 1).requirement("Ali The Trader", 1)
            .requirement("All Rise", 1).requirement("Angs off my Ring", 1).requirement("Annihilator", 1).requirement("Any Odd Chicken", 1)
            .requirement("Ape A'hollow", 1).requirement("Arc III - Spiritual Enlightenment", 1)
            .requirement("Arc II - Head of the Family", 1).requirement("Arc IV - Jed Hunter", 1).requirement("Arc IX - Damage Control", 1)
            .requirement("Arc I - Flag Fall", 1).requirement("Arc VIII - Ghosts from the Past", 1)
            .requirement("Arc VII - Tuai Leit's Own", 1).requirement("Arc VI - Harbinger of Doom", 1)
            .requirement("Arc V - Eye for an Eye", 1).requirement("Arc X - Final Destination", 1).requirement("Are You Needing Access?", 1)
            .requirement("Arise from the Ash", 1).requirement("Around the World in Six Ways", 1).requirement("As Taxed as a Yak", 1)
            .requirement("As clear as a Crystal Seed", 1).requirement("Azacorax's Rewards", 1).requirement("Azdaran Birthright", 1)
            .requirement("Bandos's Memories", 1).requirement("Bane Tuner", 1).requirement("Banking History", 1)
            .requirement("Behemoth Notes", 1).requirement("Blinded by Ramarno's Teaching", 1).requirement("Blood Stained Treasure", 1)
            .requirement("Bridge over Fremmy Waters", 1).requirement("Brothers Gower", 1).requirement("Brutal Stuffies", 1)
            .requirement("Buy and Sell Some XP", 1).requirement("Buying Up Ancient Artefacts", 1).requirement("Caving Into the Gains", 1)
            .requirement("Cecilia, I'm Begging You, Please...", 1).requirement("Challenge Maria", 1).requirement("Challenging Chat", 1)
            .requirement("Chilling with Arrav", 1).requirement("Chippy Transport", 1).requirement("Chivalry is Fed", 1)
            .requirement("Chivalry is Threads", 1).requirement("Chivalry is Dead", 1).requirement("Circus of Fire", 1)
            .requirement("Claiming Azzanadra's Heart", 1).requirement("Claus is Risng", 1).requirement("Clue's in the Monkey Drool", 1)
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
            .requirement("Got a Vyre Reputation", 1).requirement("Grondabans' legacy", 1).requirement("Gunning for Jewellery", 1)
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
            .requirement("Memories of Guthix", 1).requirement("Memories of a Mahjarrat", 1).requirement("Met Het Yet?", 1)
            .requirement("Milky Teeth", 1).requirement("Miscellaneous Notes", 1).requirement("Mixing in Ancient Circles", 1)
            .requirement("My Adze is Bigger than Yours", 1).requirement("Myreque in Memoriam", 1).requirement("Mysteries of the TokHaar", 1)
            .requirement("Nano To Kipple, Come In Kipple", 1).requirement("Naturally Muspah", 1).requirement("Nomad's Genesis", 1)
            .requirement("Ocellus Virius Notus", 1).requirement("On a Mission From... The Gods", 1).requirement("One Final Ride", 1)
            .requirement("One Foot in the Grave", 1).requirement("One Man's Junk...Is Mine", 1).requirement("Ornate Crockery", 1)
            .requirement("Otto the Ancient", 1).requirement("Out into the Ourania", 1).requirement("Oyster Mash", 1)
            .requirement("Paint it Red", 1).requirement("Penny for Your Life", 1).requirement("Post Fume", 1)
            .requirement("Potion for a Lady", 1).requirement("Power of Three Spirits", 1).requirement("Quiet but Deadly Lore", 1)
            .requirement("Relight my Fire", 1).requirement("Reliquary of Cithara", 1).requirement("Respect the Balance", 1)
            .requirement("Rogue Down", 1).requirement("Rusty Reward", 1).requirement("Scabigail", 1)
            .requirement("Scribbling in the Depths", 1).requirement("Scribblings of a Dragonkin", 1).requirement("Sentient Letters", 1)
            .requirement("Seren Memories", 1).requirement("Shadow Hanging Over Me", 1).requirement("Sheep Shearer", 1)
            .requirement("Sing for the Lady", 1).requirement("Skeletal Wishes", 1).requirement("Slime and Snails and God Wars Tales", 1)
            .requirement("Soft Kitty, Purple Kitty", 1).requirement("Some Old Dusty Journals", 1).requirement("Squeal for Coins", 1)
            .requirement("Stalker Notes", 1).requirement("Stay Safe", 1).requirement("Stay Secure", 1)
            .requirement("Stealing Sedridor's Stones", 1).requirement("Summary Spirits", 1).requirement("Supply and Demand", 1)
            .requirement("Tasty Bobbles", 1).requirement("Tell Tale Tarn", 1).requirement("That'll Teach Bill", 1)
            .requirement("The History of Slayer", 1).requirement("Three's A Kiln", 1).requirement("To Ga'al or Not to Ga'al", 1)
            .requirement("Trials of the Heart", 1).requirement("Triple Trouble", 1).requirement("Troublesome Crystal", 1)
            .requirement("Ultimate Codex", 1).requirement("Uncorrupted Ore", 1).requirement("Under Croc and Key", 1)
            .requirement("Unholy Crafting", 1).requirement("Uzer Master", 1).requirement("What's Mine Is Also Doric's", 1)
            .requirement("White Knight Rises", 1).requirement("Witch's Potion", 1).requirement("Work for Idol Hands", 1)
            .requirement("You're Not My Real Mah", 1).requirement("You Be Dead", 1).requirement("You Mistag This Brooch", 1)
            .requirement("Zarosian Memories", 1).build());
        achievements.add(new AchievementBuilder("Master Quester", 0, true).requirement("Quest points", 396).build());
        achievements.add(new AchievementBuilder("Master Skiller", 0, true).requirement("Attack", 99).requirement("Strength", 99)
            .requirement("Ranged", 99).requirement("Magic", 99).requirement("Defense", 99).requirement("Constitution", 99)
            .requirement("Prayer", 99).requirement("Agility", 99).requirement("Herblore", 99).requirement("Thieving", 99)
            .requirement("Crafting", 99).requirement("Runecrafting", 99).requirement("Mining", 99).requirement("Smithing", 99)
            .requirement("Fishing", 99).requirement("Cooking", 99).requirement("Firemaking", 99).requirement("Woodcutting", 99)
            .requirement("Fletching", 99).requirement("Slayer", 120).requirement("Farming", 99).requirement("Construction", 99)
            .requirement("Hunter", 99).requirement("Summoning", 99).requirement("Dungeoneering", 120).requirement("Divination", 99)
            .requirement("Invention", 120).build());
        achievements.add(new AchievementBuilder("Master of All", 0, true).requirement("Skilling pets", 27).build());
        achievements.add(new AchievementBuilder("Master of Assault", 0, true).requirement("Barbarian Assault attacker rank", 5)
            .requirement("Barbarian Assualt collector rank", 5).requirement("Barbarian Assault defender rank", 5)
            .requirement("Barbarian Assault healer rank", 5).build());
        achievements.add(new AchievementBuilder("Master of Beatings I", 0, true).requirement("Beastmaster Durzag", 5).build());
        achievements.add(new AchievementBuilder("Master of Beatings II", 0, true).requirement("Beastmaster Durzag", 10).build());
        achievements.add(new AchievementBuilder("Master of Beatings III", 0, true).requirement("Beastmaster Durzag", 25).build());
        achievements.add(new AchievementBuilder("Master of Beatings IV", 0, true).requirement("Beastmaster Durzag", 50).build());
        achievements.add(new AchievementBuilder("Master of Beatings V", 0, true).requirement("Beastmaster Durzag", 75).build());
        achievements.add(new AchievementBuilder("Master of Beatings VI", 0, true).requirement("Beastmaster Durzag", 100).build());
        achievements.add(new AchievementBuilder("Matricide", 0, true).requirement("Frozen key", 4).requirement("Blood nihil pouch", 1)
            .requirement("Shadow nihil pouch", 1).requirement("Ice nihil pouch", 1).requirement("Smoke nihil pouch", 1)
            .encounter(new Encounter(Enemy.NEX, Collections.singletonList(new Restriction("Blood nihil", 1))))
            .encounter(new Encounter(Enemy.NEX, Collections.singletonList(new Restriction("Shadow nihil", 1))))
            .encounter(new Encounter(Enemy.NEX, Collections.singletonList(new Restriction("Ice nihil", 1))))
            .encounter(new Encounter(Enemy.NEX, Collections.singletonList(new Restriction("Smoke nihil", 1)))).build());
        achievements.add(new AchievementBuilder("Mazcab Teleport", 0, true).requirement("Mazcab Teleport", 1).build());
        achievements.add(new AchievementBuilder("Measure of Old", 0, true).requirement("Elder chronicle", 4).build());
        achievements.add(new AchievementBuilder("Mega Ducklings", 0, true).requirement("Mega Ducklings", 1).build());
        achievements.add(new AchievementBuilder("Memorialized More Than Once", 0, true).requirement("Memorial to Guthix", 3).build());
        achievements.add(new AchievementBuilder("Memories of Guthix", 0, true).requirement("Memorial to Guthix", 1).build());
        achievements.add(new AchievementBuilder("Memories of a Mahjarrat", 0, true).requirement("Mahjarrat Memories", 1).build());
        achievements.add(new AchievementBuilder("Menaphos", 0, true).requirement("The Jack of Spades", 1).build());
        achievements.add(new AchievementBuilder("Menaphos Pyramid Scheme", 0, true).requirement("The Jack of Spades", 1)
            .requirement("Our Man in the North", 1).requirement("Crocodile Tears", 1).requirement("'Phite Club", 1)
            .requirement("Boys to Menaphites", 1).build());
        achievements.add(new AchievementBuilder("Met Het Yet?", 0, true).requirement("Our Man in the North", 1).requirement("Strength", 80)
            .reward("Strength", 20000).build());
        achievements.add(new AchievementBuilder("Micro Brew", 0, true).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .requirement("Herblore", 65).requirement("Zemomark", 100).reward("Zemomark", 30).build());
        achievements.add(new AchievementBuilder("Mighty Morphing", 0, true).requirement("Divination", 13).requirement("Logs", 3)
            .requirement("Flickering energy", 2).reward("Oak logs", 1).requirement("Divination", 3).build());
        achievements.add(new AchievementBuilder("Milk of Chocolate, Snape of Grass", 0, true).requirement("Nettle tea", 1)
            .requirement("Bucket of water", 1).requirement("Hangover cure", 1).build());
        achievements.add(new AchievementBuilder("Milky Teeth", 0, true).requirement("Tooth creatrue", 1).build());
        achievements.add(new AchievementBuilder("Mining - Rocky", 0, true).requirement("Rocky", 1).build());
        achievements.add(new AchievementBuilder("Mining 5", 0, true).requirement("Mining", 5).build());
        achievements.add(new AchievementBuilder("Mining 10", 0, true).requirement("Mining", 10).build());
        achievements.add(new AchievementBuilder("Mining 20", 0, true).requirement("Mining", 20).build());
        achievements.add(new AchievementBuilder("Mining 30", 0, true).requirement("Mining", 30).build());
        achievements.add(new AchievementBuilder("Mining 40", 0, true).requirement("Mining", 40).build());
        achievements.add(new AchievementBuilder("Mining 50", 0, true).requirement("Mining", 50).build());
        achievements.add(new AchievementBuilder("Mining 60", 0, true).requirement("Mining", 60).build());
        achievements.add(new AchievementBuilder("Mining 70", 0, true).requirement("Mining", 70).build());
        achievements.add(new AchievementBuilder("Mining 80", 0, true).requirement("Mining", 80).build());
        achievements.add(new AchievementBuilder("Mining 90", 0, true).requirement("Mining", 90).build());
        achievements.add(new AchievementBuilder("Mining 92", 0, true).requirement("Mining", 92).build());
        achievements.add(new AchievementBuilder("Mining 99", 0, true).requirement("Mining", 99).build());
        achievements.add(new AchievementBuilder("Minister", 0, true).requirement("Minister", 1).build());
        achievements.add(new AchievementBuilder("Miscellaneous Notes", 0, true).requirement("Miscellaneous journals", 15).build());
        achievements.add(new AchievementBuilder("Mixing in Ancient Circles", 0, true).requirement("Barbarian Firemaking", 1)
            .requirement("Bittercap mushroom", 5).build());
        achievements.add(new AchievementBuilder("Mobilise This", 0, true).requirement("Mobilising Armies rank", 401).build());
        achievements.add(new AchievementBuilder("Mole Removal I", 0, true).requirement("Giant Mole", 5).build());
        achievements.add(new AchievementBuilder("Mole Removal II", 0, true).requirement("Giant Mole", 10).build());
        achievements.add(new AchievementBuilder("Mole Removal III", 0, true).requirement("Giant Mole", 25).build());
        achievements.add(new AchievementBuilder("Mole Removal IV", 0, true).requirement("Giant Mole", 50).build());
        achievements.add(new AchievementBuilder("Mole Removal V", 0, true).requirement("Giant Mole", 75).build());
        achievements.add(new AchievementBuilder("Mole Removal VI", 0, true).requirement("Giant Mole", 100).build());
        achievements.add(new AchievementBuilder("Molly", 0, true).requirement("Molly", 1).build());
        achievements.add(new AchievementBuilder("Moo-er of All Bombs", 0, true).requirement("Dimension of Disaster: The Curse of Arrav", 1)
            .build());
        achievements.add(new AchievementBuilder("More Fast More Furious I", 0, true).requirement("Twin Furies (CM)", 5).build());
        achievements.add(new AchievementBuilder("More Fast More Furious II", 0, true).requirement("Twin Furies (CM)", 10).build());
        achievements.add(new AchievementBuilder("More Fast More Furious III", 0, true).requirement("Twin Furies (CM)", 25).build());
        achievements.add(new AchievementBuilder("More Fast More Furious IV", 0, true).requirement("Twin Furies (CM)", 50).build());
        achievements.add(new AchievementBuilder("More Fast More Furious V", 0, true).requirement("Twin Furies (CM)", 75).build());
        achievements.add(new AchievementBuilder("More Fast More Furious VI", 0, true).requirement("Twin Furies (CM)", 100).build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Easy", 0, true).requirement("Chisellin Conchiolin", 1)
            .requirement("It's Only Water Thin", 1).requirement("Dislike-Anthrope", 1).requirement("Cranius Lupus", 1)
            .requirement("Lab Clean-up Assistant", 1).requirement("Fortified Spirit", 1).requirement("Struck A-Ghast", 1)
            .requirement("Blooming Marvellous", 1).requirement("Only Going Forward, We Can't Find Reverse", 1)
            .requirement("If It Bleeds", 1).requirement("Wurt A Bundle", 1).lamp(Player.ALL_SKILLS, 4000, 25).build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Elite", 0, true).requirement("Whip: It Good", 1)
            .requirement("As You Might Expect", 1).requirement("Thoroughly A-Ghast", 1).requirement("As Good As Renew", 1)
            .requirement("Fremennik Export", 1).requirement("Not Such a Rotten Idea", 1).requirement("Set It On Fiyr", 1)
            .requirement("Bros Before Barrows", 1).requirement("On Wings of Bling", 1).lamp(Player.ALL_SKILLS, 40000, 75)
            .lamp(Player.ALL_SKILLS, 50000, 80).lamp(Player.ALL_SKILLS, 50000, 80).build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Hard", 0, true).requirement("Detarnation", 1)
            .requirement("Runecraft Carrier", 1).requirement("Shade-Shattering Ka-Bloom", 1)
            .requirement("They'll Just Throw It Away Again", 1).requirement("Time Salver", 1).requirement("Huge Success", 1)
            .requirement("I Brought Your Stuff Back", 1).requirement("Just One More Key", 1).requirement("Raising The Stakes", 1)
            .requirement("Trekkin' Ain't Easy", 1).requirement("Better Than Cursing The Darkness", 1).lamp(Player.ALL_SKILLS, 20000, 65)
            .build());
        achievements.add(new AchievementBuilder("Morytania Set Tasks - Medium", 0, true).requirement("Charter A Course", 1)
            .requirement("Travelling On The Slime Trail", 1).requirement("The Yeast They Can Do", 1)
            .requirement("Flamtaer Will Get You Everywhere", 1).requirement("Who You Gonna Ring?", 1)
            .requirement("Barking Up the Wrong Tree", 1).requirement("Gate Spectre-ations", 1).requirement("Ready? Trek!", 1)
            .requirement("Don't Stop Me If I Start To Ramble", 1).requirement("Plenty Mort Where That Came From", 1)
            .requirement("Izzy Wizzy Let's Get Lizzy", 1).requirement("Finding Your Balance", 1).requirement("The Beer Inn-spectre", 1)
            .requirement("Brain Bending", 1).requirement("I Wonder How Far It Ghost?", 1).requirement("Obvious Forgery", 1)
            .requirement("The Higher, The Better", 1).requirement("Fun Guy But Bitter", 1).requirement("Potterheist", 1)
            .requirement("Ad-Myre The Goods", 1).lamp(Player.ALL_SKILLS, 10000, 46).build());
        achievements.add(new AchievementBuilder("Mummy Returns", 0, true).requirement("Cat's Bane", 1).build());
        achievements.add(new AchievementBuilder("Mushrooms of the Arc", 0, true).requirement("Arc mushrooms", 17).build());
        achievements.add(new AchievementBuilder("Music Maestro", 0, true).requirement("Music tracks", 1203).build());
        achievements.add(new AchievementBuilder("My Adze is Bigger than Yours", 0, true).requirement("Inferno adze", 1).build());
        achievements.add(new AchievementBuilder("Myreque in Memoriam", 0, true).requirement("In Memory of the Myreque", 1).build());
        achievements.add(new AchievementBuilder("Mysteries of the TokHaar", 0, true).requirement("One of a Kind statues", 5).build());
    }

    private void addAchievementsN() {
        achievements.add(new AchievementBuilder("Nano to Kipple, Come In Kipple", 0, true).requirement("Nano Kipple", 1).build());
        achievements.add(new AchievementBuilder("Naturally Muspah", 0, true).requirement("The Tale of the Muspah", 1)
            .lamp(Player.ALL_SKILLS, 200, 10).build());
        achievements.add(new AchievementBuilder("Naturist", 0, true).encounter(new Encounter(Enemy.CHAOS_ELEMENTAL)).build());
        achievements.add(new AchievementBuilder("Never Eat Silk Worms", 0, true).encounter(new Encounter(Enemy.KALPHITE_KING)).build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Easy", 0, true).requirement("Hand Exchange", 1)
            .requirement("Trade Parade", 1).requirement("Hide and Seek", 1).requirement("Ready, Deady, Cook", 1).requirement("Pick One", 1)
            .build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Elite", 1, true).requirement("Dark Imperator-ment", 1)
            .requirement("Changing of the Guard", 1).requirement("Steel, Stud, or Silk Salute", 1).requirement("Moo-er of All Bombs", 1)
            .requirement("Top Pick", 1).build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Hard", 0, true).requirement("Bank-Z", 1)
            .requirement("Micro Brew", 1).requirement("Pick All", 1).requirement("South AND West Side Story", 1)
            .requirement("Mummy Returns", 1).build());
        achievements.add(new AchievementBuilder("New Varrock Set Tasks - Medium", 0, true).requirement("Cat's Bane", 1)
            .requirement("They Had a Gudrun", 1).requirement("Pick Half", 1).requirement("Scrying Game", 1).requirement("Tier Gear", 1)
            .build());
        achievements.add(new AchievementBuilder("Nex Pls I", 0, true).requirement("Nex: Angel of Death", 5).build());
        achievements.add(new AchievementBuilder("Nex Pls II", 0, true).requirement("Nex: Angel of Death", 10).build());
        achievements.add(new AchievementBuilder("Nex Pls III", 0, true).requirement("Nex: Angel of Death", 25).build());
        achievements.add(new AchievementBuilder("Nex Pls IV", 0, true).requirement("Nex: Angel of Death", 50).build());
        achievements.add(new AchievementBuilder("Nex Pls V", 0, true).requirement("Nex: Angel of Death", 75).build());
        achievements.add(new AchievementBuilder("Nex Pls VI", 0, true).requirement("Nex: Angel of Death", 100).build());
        achievements.add(new AchievementBuilder("Next to No Power", 0, true).requirement("Frozen key", 1).encounter(new Encounter(Enemy.NEX,
            Collections.singletonList(new Restriction("Prayer", 0)))).build());
        achievements.add(new AchievementBuilder("Nexterminator", 0, true).requirement("Blood-soaked feather", 1).build());
        achievements.add(new AchievementBuilder("No Time to Lose", 0, true).requirement("Ring of duelling", 1).build());
        achievements.add(new AchievementBuilder("Nomad's Genesis", 0, true).requirement("Tales of Nomad", 1).build());
        achievements.add(new AchievementBuilder("Nomad's Mirage", 0, true).requirement("Memory of Nomad", 1).build());
        achievements.add(new AchievementBuilder("Nylessa", 0, true).requirement("Nymora's braid", 1).build());
    }

    private void addAchievementsO() {
        achievements.add(new AchievementBuilder("Ocellus Virius Notus", 0, true).requirement("Order journal page", 22).build());
        achievements.add(new AchievementBuilder("On a Mission From...The Gods", 0, true).requirement("God Emissaries tasks", 15).build());
        achievements.add(new AchievementBuilder("On a Rune High", 0, true).requirement("Large rune casket", 1).build());
        achievements.add(new AchievementBuilder("On the Run", 0, true).build());
        achievements.add(new AchievementBuilder("Once the hunter, now the hunted", 0, true).requirement("Helwyr uniques", 8).build());
        achievements.add(new AchievementBuilder("One Day, You Shall Be a Fork", 0, true).requirement("Silver ore", 1)
            .requirement("Smithing", 20).reward("Smithing", 14).reward("Silver bar", 1).build());
        achievements.add(new AchievementBuilder("One Final Ride", 0, true).requirement("Last riders", 1).build());
        achievements.add(new AchievementBuilder("One Foot in the Grave", 0, true).requirement("Returning Clarence", 1).build());
        achievements.add(new AchievementBuilder("One Man's Junk...Is Mine", 0, true).requirement("Movario's base looting tasks", 5)
            .build());
        achievements.add(new AchievementBuilder("Oo'glog", 0, true).build());
        achievements.add(new AchievementBuilder("Open Bar", 0, true).requirement("Asgarnian ale", 1).requirement("Asgarnian ale (m)", 1)
            .requirement("Asgoldian ale", 1).requirement("Axeman's folly", 1).requirement("Axeman's folly (m)", 1).requirement("Beer", 1)
            .requirement("Bandit's brew", 1).requirement("Beer (tankard)", 1).requirement("Chef's delight", 1).requirement("Cider", 1)
            .requirement("Mature cider", 1).requirement("Dragon bitter", 1).requirement("Dragon bitter (m)", 1)
            .requirement("Dwarven stout", 1).requirement("Dwarven stout (m)", 1).requirement("Greenman's ale", 1).requirement("Grog", 1)
            .requirement("Moonlight mead", 1).requirement("Moonlight mead (m)", 1).requirement("Pigswill", 1)
            .requirement("Mature pigswill", 1).requirement("Ranger's aid", 1).requirement("Ranger's aid (m)", 1)
            .requirement("Slayer's respite", 1).requirement("Slayer's respite (m)", 1).requirement("Squeck juice", 1)
            .requirement("Wizard's mind bomb", 1).requirement("Mature wmb", 1).build());
        achievements.add(new AchievementBuilder("Order of Slayers", 8, true).requirement("While Guthix Sleeps", 1)
            .requirement("Smoking Kills", 1).requirement("Plague's End", 1).requirement("Barbarian Training", 1).requirement("Slayer", 85)
            .requirement("Combat", 120).build());
        achievements.add(new AchievementBuilder("Ornate Crockery", 0, true).requirement("Ornate bowl", 1).build());
        achievements.add(new AchievementBuilder("Otto the Ancient", 0, true).requirement("Ancient page", 26).build());
        achievements.add(new AchievementBuilder("Our Man in the North", 0, true).requirement("Our Man in the North", 1).build());
        achievements.add(new AchievementBuilder("Out into the Ourania", 0, true).requirement("Ourania Teleport", 1).build());
        achievements.add(new AchievementBuilder("Out of Body Experience", 0, true).requirement("Corporeal Beast uniques", 7).build());
        achievements.add(new AchievementBuilder("Oyster Mash", 0, true).requirement("Giant Oyster", 1).build());

    }

    private void addAchievementsP() {
        achievements.add(new AchievementBuilder("P-P-P-Pick Up Some Prizes", 0, true).requirement("Penguin point", 1).build());
        achievements.add(new AchievementBuilder("Paint it Red", 0, true).requirement("Secrets of haemalchemy", 2).build());
        achievements.add(new AchievementBuilder("Party Anima", 0, true).requirement("Telos uniques", 8).build());
        achievements.add(new AchievementBuilder("Party Pooper", 0, true).requirement("Monk's Friend", 1).build());
        achievements.add(new AchievementBuilder("Peachy Bones", 0, true).requirement("Bones to Peaches", 1).build());
        achievements.add(new AchievementBuilder("Penance to the King", 0, true).requirement("Penance King", 1).build());
        achievements.add(new AchievementBuilder("Penny for your Life", 0, true).requirement("Dimension of Disaster post-quest rewards", 12)
            .build());
        achievements.add(new AchievementBuilder("Perky Like a Prawn", 0, true).requirement("Prawn perks", 15).build());
        achievements.add(new AchievementBuilder("Pick All", 0, true).requirement("New Varrock chests", 49).reward("Zemomark", 60).build());
        achievements.add(new AchievementBuilder("Pick Half", 0, true).requirement("New Varrock chests", 25).reward("Zemomark", 40).build());
        achievements.add(new AchievementBuilder("Pick One", 0, true).requirement("New Varrock chests", 1).reward("Zemomark", 20).build());
        achievements.add(new AchievementBuilder("Pious Prayers", 0, true).requirement("Knight Waves training ground", 1).build());
        achievements.add(new AchievementBuilder("Plank You Very Much", 0, true).requirement("Logs", 1).requirement("Coins", 100)
            .reward("Plank", 1).build());
        achievements.add(new AchievementBuilder("Playing the Waiting Game", 0, true).build());
        achievements.add(new AchievementBuilder("Port Life", 0, true).requirement("Player-owned port tutorial", 1).build());
        achievements.add(new AchievementBuilder("Port Sarim", 0, true).build());
        achievements.add(new AchievementBuilder("Portentially Hazardous", 0, true).requirement("Pale energy", 30)
            .requirement("Sardine", 1).reward("Portent of restoration I", 1).reward("Divination", 1).build());
        achievements.add(new AchievementBuilder("Post Fume", 0, true).requirement("Desert Slayer Dungeon bosses", 4).build());
        achievements.add(new AchievementBuilder("Potion Mixer Master", 0, true).requirement("Combination potion recipes", 26).build());
        achievements.add(new AchievementBuilder("Potion for a Lady", 0, true).requirement("Super melee potion", 1)
            .lamp(Arrays.asList("Attack", "Strength"), 50000, 1).build());
        achievements.add(new AchievementBuilder("Power of Three Spirits", 0, true).requirement("Plague's End", 1)
            .requirement("The Prisoner of Glouphrie", 1).requirement("Farming", 89).build());
        achievements.add(new AchievementBuilder("Prayer - Ghostly", 0, true).requirement("Ghostly", 1).build());
        achievements.add(new AchievementBuilder("Prayer 5", 0, true).requirement("Prayer", 5).build());
        achievements.add(new AchievementBuilder("Prayer 10", 0, true).requirement("Prayer", 10).build());
        achievements.add(new AchievementBuilder("Prayer 20", 0, true).requirement("Prayer", 20).build());
        achievements.add(new AchievementBuilder("Prayer 30", 0, true).requirement("Prayer", 30).build());
        achievements.add(new AchievementBuilder("Prayer 40", 0, true).requirement("Prayer", 40).build());
        achievements.add(new AchievementBuilder("Prayer 50", 0, true).requirement("Prayer", 50).build());
        achievements.add(new AchievementBuilder("Prayer 60", 0, true).requirement("Prayer", 60).build());
        achievements.add(new AchievementBuilder("Prayer 70", 0, true).requirement("Prayer", 70).build());
        achievements.add(new AchievementBuilder("Prayer 80", 0, true).requirement("Prayer", 80).build());
        achievements.add(new AchievementBuilder("Prayer 90", 0, true).requirement("Prayer", 90).build());
        achievements.add(new AchievementBuilder("Prayer 92", 0, true).requirement("Prayer", 92).build());
        achievements.add(new AchievementBuilder("Prayer 99", 0, true).requirement("Prayer", 99).build());
        achievements.add(new AchievementBuilder("Preaching to the Infected", 0, true).requirement("Plague City", 1).build());
        achievements.add(new AchievementBuilder("Prifddinas", 0, true).requirement("Plague's End", 1).build());
        achievements.add(new AchievementBuilder("Prime Hatchling", 0, true).requirement("Dagannoth egg", 1).build());
        achievements.add(new AchievementBuilder("Prison Break", 0, true)
            .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
                Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CORMES),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
                Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
                Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG)))).build());
        achievements.add(new AchievementBuilder("Prison Break (feat)", 0, true).requirement("Nex uniques", 21).build());
    }

    private void addAchievementsQ() {
        achievements.add(new AchievementBuilder("Queen Black Dragonling", 0, true).requirement("Queen black dragon scale", 1)
            .requirement("Summoning", 99).build());
        achievements.add(new AchievementBuilder("Quiet but Deadly Lore", 0, true).requirement("Dragonkin journals", 4).build());
    }

    private void addAchievementsR() {
        achievements.add(new AchievementBuilder("Ranged - Sparky", 0, true).requirement("Sparky", 1).build());
        achievements.add(new AchievementBuilder("Ranged 5", 0, true).requirement("Ranged", 5).build());
        achievements.add(new AchievementBuilder("Ranged 10", 0, true).requirement("Ranged", 10).build());
        achievements.add(new AchievementBuilder("Ranged 20", 0, true).requirement("Ranged", 20).build());
        achievements.add(new AchievementBuilder("Ranged 30", 0, true).requirement("Ranged", 30).build());
        achievements.add(new AchievementBuilder("Ranged 40", 0, true).requirement("Ranged", 40).build());
        achievements.add(new AchievementBuilder("Ranged 50", 0, true).requirement("Ranged", 50).build());
        achievements.add(new AchievementBuilder("Ranged 60", 0, true).requirement("Ranged", 60).build());
        achievements.add(new AchievementBuilder("Ranged 70", 0, true).requirement("Ranged", 70).build());
        achievements.add(new AchievementBuilder("Ranged 80", 0, true).requirement("Ranged", 80).build());
        achievements.add(new AchievementBuilder("Ranged 90", 0, true).requirement("Ranged", 90).build());
        achievements.add(new AchievementBuilder("Ranged 92", 0, true).requirement("Ranged", 92).build());
        achievements.add(new AchievementBuilder("Ranged 99", 0, true).requirement("Ranged", 99).build());
        achievements.add(new AchievementBuilder("Rank: Master Finix", 0, true).requirement("Esteem rank", 10).build());
        achievements.add(new AchievementBuilder("Rawrvek", 0, true).requirement("Glimmering scale", 1).build());
        achievements.add(new AchievementBuilder("Ready, Deady, Cook", 0, true).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .requirement("New Varrock raw undead meat", 1).reward("Zemomark", 20).build());
        achievements.add(new AchievementBuilder("Reaper Crew", 0, true).requirement("Bosses defeated", 29).build());
        achievements.add(new AchievementBuilder("Red Revolution", 0, true).requirement("Plague City", 1).build());
        achievements.add(new AchievementBuilder("Reeves", 0, true).requirement("Blood tentacle", 1).build());
        achievements.add(new AchievementBuilder("Relight My Fire", 0, true).requirement("Dragon Forge tasks", 4).build());
        achievements.add(new AchievementBuilder("Reliquary of Cithara", 0, true).requirement("Holy Cithara", 1).reward("Prayer", 50000)
            .build());
        achievements.add(new AchievementBuilder("Respect the Balance", 0, true).requirement("Respects paid", 6).build());
        achievements.add(new AchievementBuilder("Revenge is Sweet", 0, true).requirement("Vindicta uniques", 8).build());
        achievements.add(new AchievementBuilder("Rewind", 0, true).requirement("Beastmaster Durzag", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
                Collections.singletonList(Enemy.YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
                Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU)))).build());
        achievements.add(new AchievementBuilder("Rex Hatchling", 0, true).requirement("Shrivelled dragon claw", 1).build());
        achievements.add(new AchievementBuilder("Rhian In Gold - The Original", 0, true).requirement("Statue of Rhiannon", 1).build());
        achievements.add(new AchievementBuilder("Robot of Sherwood", 0, true).requirement("Plague's End", 1).requirement("Thieving", 95)
            .reward("Thieving", 145).reward("Coins", 135).build());
        achievements.add(new AchievementBuilder("Rogue Down", 0, true).requirement("Wilderness portal rogue trader freed", 1).build());
        achievements.add(new AchievementBuilder("Runecrafting - Rue", 0, true).requirement("Rue", 1).build());
        achievements.add(new AchievementBuilder("Runecrafting 5", 0, true).requirement("Runecrafting", 5).build());
        achievements.add(new AchievementBuilder("Runecrafting 10", 0, true).requirement("Runecrafting", 10).build());
        achievements.add(new AchievementBuilder("Runecrafting 20", 0, true).requirement("Runecrafting", 20).build());
        achievements.add(new AchievementBuilder("Runecrafting 30", 0, true).requirement("Runecrafting", 30).build());
        achievements.add(new AchievementBuilder("Runecrafting 40", 0, true).requirement("Runecrafting", 40).build());
        achievements.add(new AchievementBuilder("Runecrafting 50", 0, true).requirement("Runecrafting", 50).build());
        achievements.add(new AchievementBuilder("Runecrafting 60", 0, true).requirement("Runecrafting", 60).build());
        achievements.add(new AchievementBuilder("Runecrafting 70", 0, true).requirement("Runecrafting", 70).build());
        achievements.add(new AchievementBuilder("Runecrafting 80", 0, true).requirement("Runecrafting", 80).build());
        achievements.add(new AchievementBuilder("Runecrafting 90", 0, true).requirement("Runecrafting", 90).build());
        achievements.add(new AchievementBuilder("Runecrafting 92", 0, true).requirement("Runecrafting", 92).build());
        achievements.add(new AchievementBuilder("Runecrafting 99", 0, true).requirement("Runecrafting", 99).build());
        achievements.add(new AchievementBuilder("Rusty Reward", 0, true).requirement("Rocking Out", 1).reward("Coins", 20).build());
    }

    private void addAchievementsS() {
        achievements.add(new AchievementBuilder("Safety Dance", 0, true).requirement("Summoning", 60)
            .encounter(new Encounter(Enemy.QUEEN_BLACK_DRAGON)).build());
        achievements.add(new AchievementBuilder("Scabigail", 0, true).requirement("Scabaras page", 19).build());
        achievements.add(new AchievementBuilder("Scribbling in the Depths", 0, true).requirement("Song from the Depths", 1)
            .requirement("Constitution", 80).build());
        achievements.add(new AchievementBuilder("Scribblings of a Dragonkin", 0, true).requirement("Vicendithas' Scribblings", 1).build());
        achievements.add(new AchievementBuilder("Scrolling with Power", 0, true).requirement("Dungeoneering scrolls", 8).build());
        achievements.add(new AchievementBuilder("Scrying Game", 0, true).requirement("Dimension of Disaster: Defender of Varrock", 1)
            .requirement("Zemomark", 60).build());
        achievements.add(new AchievementBuilder("Seagullible", 0, true).requirement("Ports reputation", 300000).build());
        achievements.add(new AchievementBuilder("Second Shrubbery", 0, true).requirement("Herring", 1).build());
        achievements.add(new AchievementBuilder("Seeing Lava", 0, true).requirement("Fire cape", 1)
            .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KIH, Enemy.TZ_KIH),
                Collections.singletonList(Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK,
                    Enemy.TZ_KIH),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK), Collections.singletonList(Enemy.TOK_XIL),
                Arrays.asList(Enemy.TOK_XIL, Enemy.TZ_KIH), Arrays.asList(Enemy.TOK_XIL, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.TOK_XIL, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KIH, Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK,
                    Enemy.TZ_KEK),
                Arrays.asList(Enemy.TOK_XIL, Enemy.TOK_XIL), Collections.singletonList(Enemy.YT_MEJKOT),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TZ_KIH), Arrays.asList(Enemy.YT_MEJKOT, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TZ_KEK, Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TZ_KEK, Enemy.TZ_KIH, Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.YT_MEJKOT, Enemy.TOK_XIL),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KIH),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KIH, Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KEK,
                    Enemy.TZ_KEK),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TOK_XIL), Arrays.asList(Enemy.YT_MEJKOT, Enemy.YT_MEJKOT),
                Collections.singletonList(Enemy.KET_ZEK), Arrays.asList(Enemy.KET_ZEK, Enemy.TZ_KIH),
                Arrays.asList(Enemy.KET_ZEK, Enemy.TZ_KIH, Enemy.TZ_KIH), Arrays.asList(Enemy.KET_ZEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.KET_ZEK, Enemy.TZ_KEK, Enemy.TZ_KIH),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.KET_ZEK, Enemy.TZ_KEK, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.KET_ZEK, Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.KET_ZEK, Enemy.TOK_XIL),
                Arrays.asList(Enemy.KET_ZEK, Enemy.TOK_XIL, Enemy.TZ_KIH),
                Arrays.asList(Enemy.KET_ZEK, Enemy.TOK_XIL, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.KET_ZEK, Enemy.TOK_XIL, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.KET_ZEK, Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.TOK_XIL, Enemy.TOK_XIL),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT), Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TZ_KIH),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TZ_KEK, Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TZ_KEK, Enemy.TZ_KIH, Enemy.TZ_KIH), Arrays.asList(Enemy.TZ_KEK,
                    Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TZ_KEK, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK,
                    Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TOK_XIL),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KIH),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KEK), Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KIH),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KIH, Enemy.TZ_KIH),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK, Enemy.TZ_KEK),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.TOK_XIL, Enemy.TOK_XIL),
                Arrays.asList(Enemy.KET_ZEK, Enemy.YT_MEJKOT, Enemy.YT_MEJKOT), Arrays.asList(Enemy.KET_ZEK, Enemy.KET_ZEK),
                Arrays.asList(Enemy.TZTOK_JAD, Enemy.YT_HURKOT, Enemy.YT_HURKOT, Enemy.YT_HURKOT, Enemy.YT_HURKOT)),
                Collections.singletonList(new Restriction("Inventory spaces", 27)))).build());
        achievements.add(new AchievementBuilder("Seers' Village", 0, true).build());
        achievements.add(new AchievementBuilder("Seers' Village Set Tasks - Easy", 0, true).requirement("Reflax Actions", 1)
            .requirement("Why?", 1).requirement("Stir, Galahad", 1).requirement("La Morte D'Arthur", 1)
            .requirement("Another String to Your Bow", 1).requirement("Bunch of Flours", 1).requirement("Happy Hour", 1)
            .requirement("Jute Alors!", 1).requirement("Sinclair Swirling", 1).requirement("Grand Candle", 1)
            .requirement("A Seering Light", 1).requirement("Mack Rolled", 1).lamp(Player.ALL_SKILLS, 1000, 30).build());
        achievements.add(new AchievementBuilder("Seers' Village Set Tasks - Elite", 0, true)
            .requirement("It's a Trap! No, Wait, It's a Pie", 1).requirement("Make a Bolt For It", 1).requirement("The Long of It", 1)
            .requirement("Plenty - potion - entiary", 1).requirement("Moon Raker", 1).lamp(Player.ALL_SKILLS, 30000, 83)
            .lamp(Player.ALL_SKILLS, 30000, 83).lamp(Player.ALL_SKILLS, 30000, 83).lamp(Player.ALL_SKILLS, 30000, 83)
            .lamp(Player.ALL_SKILLS, 25000, 70).build());
        achievements.add(new AchievementBuilder("Seers' Village Set Tasks - Hard", 0, true).requirement("At Home on the Range", 1)
            .requirement("See Yew at Five", 1).requirement("The Short of It", 1).requirement("Prayer of Attorney", 1)
            .requirement("Beware o the Dog", 1).requirement("TWisted Fire Starter", 1).requirement("Alch-aholic", 1)
            .requirement("Gonna Need a Bigger Boat", 1).requirement("Gonna Need a Bigger Range", 1).requirement("Water Palaver", 1)
            .requirement("Island Hopper", 1).lamp(Player.ALL_SKILLS, 10000, 50).build());
        achievements.add(new AchievementBuilder("Seers' Village Set Tasks - Medium", 0, true).requirement("Fleeing the Scene", 1)
            .requirement("It's a Slightly Magical Stick", 1).requirement("King Coal", 1).requirement("I Can Seer My House From Here", 1)
            .requirement("Mastering the Elements", 1).requirement("It's Only a Model", 1).requirement("Sniper Training", 1)
            .requirement("Arch Archer", 1).requirement("What, No Cuddly Toy?", 1).requirement("Familiar Fire Familiarity", 1)
            .requirement("At Least It Doesn't Need Walking", 1).requirement("All Your Bass...", 1).lamp(Player.ALL_SKILLS, 5000, 40)
            .build());
        achievements.add(new AchievementBuilder("Sentient Letters", 0, true).requirement("Empty Throne Room letters", 4).build());
        achievements.add(new AchievementBuilder("Seren memories", 0, true).requirement("Crest of Seren override", 1).build());
        achievements.add(new AchievementBuilder("Seven Colours In Their Hat", 0, true).requirement("Chromatic partyhat", 1).build());
        achievements.add(new AchievementBuilder("Shadow Hanging Over Me", 0, true).requirement("A Shadow over Ashdale", 1)
            .reward("Coins", 757).reward("Uncut sapphire", 4).reward("Uncut emerald", 1).build());
        achievements.add(new AchievementBuilder("Shadows Below", 0, true).requirement("Barrows: Rise of the Six", 1).build());
        achievements.add(new AchievementBuilder("Shattering Worlds I", 0, true).requirement("Shattered Worlds max world", 10).build());
        achievements.add(new AchievementBuilder("Shattering Worlds II", 0, true).requirement("Shattered Worlds max world", 25).build());
        achievements.add(new AchievementBuilder("Shattering Worlds III", 0, true).requirement("Shattered Worlds max world", 50).build());
        achievements.add(new AchievementBuilder("Shattering Worlds IV", 0, true).requirement("Shattered Worlds max world", 100).build());
        achievements.add(new AchievementBuilder("Shattering Worlds V", 0, true).requirement("Shattered Worlds max world", 150).build());
        achievements.add(new AchievementBuilder("Shattering Worlds VI", 0, true).requirement("Shattered Worlds max world", 200).build());
        achievements.add(new AchievementBuilder("Sheep Shearer", 0, true).requirement("Sheep Shearer", 1).build());
        achievements.add(new AchievementBuilder("Shrimpy", 0, true).requirement("Volcanic shard", 1).build());
        achievements.add(new AchievementBuilder("Silky Smooth", 0, true).requirement("Silk", 1).build());
        achievements.add(new AchievementBuilder("Simply Divine", 0, true).requirement("Pale energy", 5).requirement("Raw crayfish", 20)
            .build());
        achievements.add(new AchievementBuilder("Sing for the Lady", 0, true).requirement("Crystal items given to Lady Ithell", 4)
            .reward("Magic", 50000).build());
        achievements.add(new AchievementBuilder("Skeletal Wishes", 0, true).requirement("Skeletal horror", 1).build());
        achievements.add(new AchievementBuilder("Skeletrail Horror", 0, true).requirement("Skeletal horror", 1).build());
        achievements.add(new AchievementBuilder("Slayer - Crabbe", 0, true).requirement("Crabbe", 1).build());
        achievements.add(new AchievementBuilder("Slayer 5", 0, true).requirement("Slayer", 5).build());
        achievements.add(new AchievementBuilder("Slayer 10", 0, true).requirement("Slayer", 10).build());
        achievements.add(new AchievementBuilder("Slayer 20", 0, true).requirement("Slayer", 20).build());
        achievements.add(new AchievementBuilder("Slayer 30", 0, true).requirement("Slayer", 30).build());
        achievements.add(new AchievementBuilder("Slayer 40", 0, true).requirement("Slayer", 40).build());
        achievements.add(new AchievementBuilder("Slayer 50", 0, true).requirement("Slayer", 50).build());
        achievements.add(new AchievementBuilder("Slayer 60", 0, true).requirement("Slayer", 60).build());
        achievements.add(new AchievementBuilder("Slayer 70", 0, true).requirement("Slayer", 70).build());
        achievements.add(new AchievementBuilder("Slayer 80", 0, true).requirement("Slayer", 80).build());
        achievements.add(new AchievementBuilder("Slayer 90", 0, true).requirement("Slayer", 90).build());
        achievements.add(new AchievementBuilder("Slayer 99", 0, true).requirement("Slayer", 99).build());
        achievements.add(new AchievementBuilder("Slayer 110", 0, true).requirement("Slayer", 110).build());
        achievements.add(new AchievementBuilder("Slayer 120", 0, true).requirement("Slayer", 120).build());
        achievements.add(new AchievementBuilder("Slayer Master", 0, true).requirement("Rush of Blood platinum wave max", 20).build());
        achievements.add(new AchievementBuilder("Slide to the Left", 0, true).requirement("Puzzle box solved", 1).build());
        achievements.add(new AchievementBuilder("Slime and Snails and God Wars Tales", 0, true)
            .requirement("Tales of the God Wars", 1).build());
        achievements.add(new AchievementBuilder("Smithing - Smithy", 0, true).requirement("Smithy", 1).build());
        achievements.add(new AchievementBuilder("Smithing 5", 0, true).requirement("Smithing", 5).build());
        achievements.add(new AchievementBuilder("Smithing 10", 0, true).requirement("Smithing", 10).build());
        achievements.add(new AchievementBuilder("Smithing 20", 0, true).requirement("Smithing", 20).build());
        achievements.add(new AchievementBuilder("Smithing 30", 0, true).requirement("Smithing", 30).build());
        achievements.add(new AchievementBuilder("Smithing 40", 0, true).requirement("Smithing", 40).build());
        achievements.add(new AchievementBuilder("Smithing 50", 0, true).requirement("Smithing", 50).build());
        achievements.add(new AchievementBuilder("Smithing 60", 0, true).requirement("Smithing", 60).build());
        achievements.add(new AchievementBuilder("Smithing 70", 0, true).requirement("Smithing", 70).build());
        achievements.add(new AchievementBuilder("Smithing 80", 0, true).requirement("Smithing", 80).build());
        achievements.add(new AchievementBuilder("Smithing 90", 0, true).requirement("Smithing", 90).build());
        achievements.add(new AchievementBuilder("Smithing 92", 0, true).requirement("Smithing", 92).build());
        achievements.add(new AchievementBuilder("Smithing 99", 0, true).requirement("Smithing", 99).build());
        achievements.add(new AchievementBuilder("So You Think You Can Guard?", 0, true).requirement("Max Telos enrage", 2000).build());
        achievements.add(new AchievementBuilder("Soft Kitty, Purple Kitty", 0, true).requirement("Purple Cat", 1).build());
        achievements.add(new AchievementBuilder("Some Old, Dusty Journals", 0, true).requirement("Tarddian journals", 3).build());
        achievements.add(new AchievementBuilder("Something Barrowed I", 0, true).requirement("Barrows", 5).build());
        achievements.add(new AchievementBuilder("Something Barrowed II", 0, true).requirement("Barrows", 10).build());
        achievements.add(new AchievementBuilder("Something Barrowed III", 0, true).requirement("Barrows", 25).build());
        achievements.add(new AchievementBuilder("Something Barrowed IV", 0, true).requirement("Barrows", 50).build());
        achievements.add(new AchievementBuilder("Something Barrowed V", 0, true).requirement("Barrows", 75).build());
        achievements.add(new AchievementBuilder("Something Barrowed VI", 0, true).requirement("Barrows", 100).build());
        achievements.add(new AchievementBuilder("Source of Denial", 0, true).requirement("Diamond in the Rough", 1)
            .reward("Winter sq'irk", 1).reward("Farming", 30).build());
        achievements.add(new AchievementBuilder("South AND West Side Story", 0, true).requirement("Dimension of Disaster", 1)
            .reward("Zemomark", 60).build());
        achievements.add(new AchievementBuilder("Special Slayer Delivery", 0, true).requirement("Slayer crafting abilities", 3).build());
        achievements.add(new AchievementBuilder("Squeal for Coins", 0, true).requirement("The Mighty Fall", 1).reward("Coins", 73105)
            .build());
        achievements.add(new AchievementBuilder("Staff on Stryke", 0, true).requirement("Slayer", 77)
            .encounter(new Encounter(Enemy.DESERT_STRYKEWYRM, Arrays.asList(new Restriction("Fully charged full slayer helmet", 1),
                new Restriction("Ancient staff", 1)))).build());
        achievements.add(new AchievementBuilder("Stalker Notes", 0, true).requirement("Stalker notes", 5).build());
        achievements.add(new AchievementBuilder("Stand Your Ground", 0, true).requirement("Slayer", 95)
            .requirement("Ascension Keystone Primus", 1).requirement("Ascension Keystone Secundus", 1)
            .requirement("Ascension Keystone Tertius", 1).requirement("Ascension Keystone Quartus", 1)
            .requirement("Ascension Keystone Quintus", 1).requirement("Ascension Keystone Sextus", 1)
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList(Enemy.LEGIO))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList(Enemy.LEGIO))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList(Enemy.LEGIO))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList(Enemy.LEGIO))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList(Enemy.LEGIO))))
            .encounter(new Encounter(Collections.singletonList(Collections.singletonList(Enemy.LEGIO)))).build());
        achievements.add(new AchievementBuilder("Star Seeker", 0, true).build());
        achievements.add(new AchievementBuilder("Stay Safe", 0, true).reward("Coins", 10000).reward("Safety gloves", 1)
            .lamp(Player.ALL_SKILLS, 500, 1).lamp(Player.ALL_SKILLS, 500, 1).build());
        achievements.add(new AchievementBuilder("Stay Secure", 0, true).requirement("Stronghold of Security rewards", 4).build());
        achievements.add(new AchievementBuilder("Stealing Sedridor's Stones", 0, true).requirement("Sedridor chest rewards", 99).build());
        achievements.add(new AchievementBuilder("Steel, Stud, or Silk Salute", 0, true).requirement("New Varrock spider silk hood", 1)
            .requirement("New Varrock spider silk robe top", 1).requirement("New Varrock spider silk robe bottoms", 1).build());
        achievements.add(new AchievementBuilder("Stone's Throw Away", 0, true).requirement("Replica statue", 30).build());
        achievements.add(new AchievementBuilder("Strength - Kangali", 0, true).requirement("Kangali", 1).build());
        achievements.add(new AchievementBuilder("Strength 5", 0, true).requirement("Strength", 5).build());
        achievements.add(new AchievementBuilder("Strength 10", 0, true).requirement("Strength", 10).build());
        achievements.add(new AchievementBuilder("Strength 20", 0, true).requirement("Strength", 20).build());
        achievements.add(new AchievementBuilder("Strength 30", 0, true).requirement("Strength", 30).build());
        achievements.add(new AchievementBuilder("Strength 40", 0, true).requirement("Strength", 40).build());
        achievements.add(new AchievementBuilder("Strength 50", 0, true).requirement("Strength", 50).build());
        achievements.add(new AchievementBuilder("Strength 60", 0, true).requirement("Strength", 60).build());
        achievements.add(new AchievementBuilder("Strength 70", 0, true).requirement("Strength", 70).build());
        achievements.add(new AchievementBuilder("Strength 80", 0, true).requirement("Strength", 80).build());
        achievements.add(new AchievementBuilder("Strength 90", 0, true).requirement("Strength", 90).build());
        achievements.add(new AchievementBuilder("Strength 92", 0, true).requirement("Strength", 92).build());
        achievements.add(new AchievementBuilder("Strength 99", 0, true).requirement("Strength", 99).build());
        achievements.add(new AchievementBuilder("Strike a Pose", 0, true).build());
        achievements.add(new AchievementBuilder("Stuffed With Anima", 0, true).requirement("Max Telos enrage", 95)
            .encounter(new Encounter(Enemy.TELOS_100_ENRAGE)).build());
        achievements.add(new AchievementBuilder("Summary Spirits", 0, true).requirement("Wilderness spirit portals", 8).build());
        achievements.add(new AchievementBuilder("Summoning - Shamini", 0, true).requirement("Shamini", 1).build());
        achievements.add(new AchievementBuilder("Summoning 5", 0, true).requirement("Summoning", 5).build());
        achievements.add(new AchievementBuilder("Summoning 10", 0, true).requirement("Summoning", 10).build());
        achievements.add(new AchievementBuilder("Summoning 20", 0, true).requirement("Summoning", 20).build());
        achievements.add(new AchievementBuilder("Summoning 30", 0, true).requirement("Summoning", 30).build());
        achievements.add(new AchievementBuilder("Summoning 40", 0, true).requirement("Summoning", 40).build());
        achievements.add(new AchievementBuilder("Summoning 50", 0, true).requirement("Summoning", 50).build());
        achievements.add(new AchievementBuilder("Summoning 60", 0, true).requirement("Summoning", 60).build());
        achievements.add(new AchievementBuilder("Summoning 70", 0, true).requirement("Summoning", 70).build());
        achievements.add(new AchievementBuilder("Summoning 80", 0, true).requirement("Summoning", 80).build());
        achievements.add(new AchievementBuilder("Summoning 90", 0, true).requirement("Summoning", 90).build());
        achievements.add(new AchievementBuilder("Summoning 92", 0, true).requirement("Summoning", 92).build());
        achievements.add(new AchievementBuilder("Summoning 99", 0, true).requirement("Summoning", 99).build());
        achievements.add(new AchievementBuilder("Sunshine Through the Rain", 0, true).requirement("Agility", 70)
            .encounter(new Encounter(Enemy.COMMANDER_ZILYANA_HM, Collections.singletonList(new Restriction("Sunshine", 1)))).build());
        achievements.add(new AchievementBuilder("Superior Successor", 0, true).requirement("Magister uniques", 8).build());
        achievements.add(new AchievementBuilder("Supply and Demand", 0, true).requirement("Death Plateau supply runs", 5).build());
        achievements.add(new AchievementBuilder("Supreme Hatchling", 0, true).requirement("Dagannoth scale", 1).build());

    }

    private void addAchievementsT() {
        achievements.add(new AchievementBuilder("Talk to Explorer Jack", 0, true).build());
        achievements.add(new AchievementBuilder("Tan Your Hide", 0, true).requirement("Cowhide", 1).reward("Leather", 1).build());
        achievements.add(new AchievementBuilder("Task Master", 0, true).requirement("Ardougne Set Tasks - Easy", 1)
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
        achievements.add(new AchievementBuilder("Tasty Bobbles", 0, true).requirement("Gower Quest", 1).build());
        achievements.add(new AchievementBuilder("Taverley", 0, true).build());
        achievements.add(new AchievementBuilder("Tell Tale Tarn", 0, true).requirement("The Lair of Tarn Razorlor", 1).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry I", 0, true).requirement("Max Telos enrage", 50).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry II", 0, true).requirement("Max Telos enrage", 100).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry III", 0, true).requirement("Max Telos enrage", 250).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry IV", 0, true).requirement("Max Telos enrage", 500).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry V", 0, true).requirement("Max Telos enrage", 750).build());
        achievements.add(new AchievementBuilder("Telos If You're Angry VI", 0, true).requirement("Max Telos enrage", 1000).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts I", 0, true).requirement("Telos", 5).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts II", 0, true).requirement("Telos", 10).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts III", 0, true).requirement("Telos", 25).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts IV", 0, true).requirement("Telos", 50).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts V", 0, true).requirement("Telos", 75).build());
        achievements.add(new AchievementBuilder("Telos Where it Hurts VI", 0, true).requirement("Telos", 100).build());
        achievements.add(new AchievementBuilder("Tess", 0, true).requirement("Telos' tendril", 1).build());
        achievements.add(new AchievementBuilder("That'll Teach Bill", 0, true).requirement("Cabin Fever", 1).reward("Coins", 10000)
            .build());
        achievements.add(new AchievementBuilder("The Crested Guest is Best", 0, true).requirement("Plague's End", 1)
            .requirement("Crest of Seren", 1).build());
        achievements.add(new AchievementBuilder("The Essence of Magic", 0, true).build());
        achievements.add(new AchievementBuilder("The History of Slayer", 0, true).requirement("Souls captured", 110).build());
        achievements.add(new AchievementBuilder("The Jack of Spades", 0, true).requirement("The Jack of Spades", 1).build());
        achievements.add(new AchievementBuilder("The True Warden", 0, true).requirement("Max Telos enrage", 4000).build());
        achievements.add(new AchievementBuilder("There's No Place Like Burthorpe", 0, true).requirement("Burthorpe", 1).build());
        achievements.add(new AchievementBuilder("There's No Place Like Home", 0, true).build());
        achievements.add(new AchievementBuilder("They're Long and Pointy", 0, true).build());
        achievements.add(new AchievementBuilder("They All Fell Down", 0, true)
            .encounter(new Encounter(Collections.singletonList(Arrays.asList(Enemy.DAGANNOTH_SUPREME, Enemy.DAGANNOTH_PRIME,
                Enemy.DAGANNOTH_REX)))).build());
        achievements.add(new AchievementBuilder("They Had a Gudrun", 0, true).requirement("NV Cadava potion", 1)
            .requirement("NV Vial of orange mist", 1).reward("Zemomark", 40).build());
        achievements.add(new AchievementBuilder("Thieving - Ralph", 0, true).requirement("Ralph", 1).build());
        achievements.add(new AchievementBuilder("Thieving 5", 0, true).requirement("Thieving", 5).build());
        achievements.add(new AchievementBuilder("Thieving 10", 0, true).requirement("Thieving", 10).build());
        achievements.add(new AchievementBuilder("Thieving 20", 0, true).requirement("Thieving", 20).build());
        achievements.add(new AchievementBuilder("Thieving 30", 0, true).requirement("Thieving", 30).build());
        achievements.add(new AchievementBuilder("Thieving 40", 0, true).requirement("Thieving", 40).build());
        achievements.add(new AchievementBuilder("Thieving 50", 0, true).requirement("Thieving", 50).build());
        achievements.add(new AchievementBuilder("Thieving 60", 0, true).requirement("Thieving", 60).build());
        achievements.add(new AchievementBuilder("Thieving 70", 0, true).requirement("Thieving", 70).build());
        achievements.add(new AchievementBuilder("Thieving 80", 0, true).requirement("Thieving", 80).build());
        achievements.add(new AchievementBuilder("Thieving 90", 0, true).requirement("Thieving", 90).build());
        achievements.add(new AchievementBuilder("Thieving 92", 0, true).requirement("Thieving", 92).build());
        achievements.add(new AchievementBuilder("Thieving 99", 0, true).requirement("Thieving", 99).build());
        achievements.add(new AchievementBuilder("This Helwyr in I", 0, true).requirement("Helwyr", 5).build());
        achievements.add(new AchievementBuilder("This Helwyr in II", 0, true).requirement("Helwyr", 10).build());
        achievements.add(new AchievementBuilder("This Helwyr in III", 0, true).requirement("Helwyr", 25).build());
        achievements.add(new AchievementBuilder("This Helwyr in IV", 0, true).requirement("Helwyr", 50).build());
        achievements.add(new AchievementBuilder("This Helwyr in V", 0, true).requirement("Helwyr", 75).build());
        achievements.add(new AchievementBuilder("This Helwyr in VI", 0, true).requirement("Helwyr", 100).build());
        achievements.add(new AchievementBuilder("Three's a Kiln", 0, true).requirement("TokHaar-Kal-Ket", 1)
            .requirement("TokHaar-Kal-Xil", 1).requirement("TokHaar-Kal-Mej", 1).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One I", 0, true).requirement("King Black Dragon", 5).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One II", 0, true)
            .requirement("King Black Dragon", 10).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One III", 0, true)
            .requirement("King Black Dragon", 25).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One IV", 0, true)
            .requirement("King Black Dragon", 50).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One V", 0, true)
            .requirement("King Black Dragon", 75).build());
        achievements.add(new AchievementBuilder("Three Heads are Deader than One VI", 0, true)
            .requirement("King Black Dragon", 100).build());
        achievements.add(new AchievementBuilder("Through the Fire and Flames", 0, true)
            .encounter(new Encounter(Enemy.QUEEN_BLACK_DRAGON, Collections.singletonList(new Restriction("Royal crossbow", 1)))).build());
        achievements.add(new AchievementBuilder("Tier Gear", 0, true).requirement("NV imphider", 1).requirement("Crafting", 10)
            .reward("NV imphide gloves", 1).reward("Zemomark", 40).build());
        achievements.add(new AchievementBuilder("Tirannwn", 0, true).requirement("Regicide", 1).build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Easy", 0, true).requirement("Iban You from Hurting Me!", 1)
            .requirement("Driven, Underground", 1).requirement("Arandar-bout Way", 1).requirement("Blowing Your Own Trumpet", 1)
            .requirement("The Motherlode", 1).requirement("Tyrassed to Impress", 1).requirement("Lime Ordeal", 1)
            .requirement("Leaf Me Alone", 1).requirement("Fairy Liquid", 1).requirement("Stand Still, Eluned!", 1)
            .requirement("Casting Shadows", 1).requirement("Sick and Twisted", 1).lamp(Player.ALL_SKILLS, 10000, 47).build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Elite", 0, true).requirement("99 With a Flake", 1)
            .requirement("Robot of Sherwood", 1).requirement("The Crested Guest is Best", 1).requirement("Ace of Dungeones", 1)
            .requirement("Weave Come a Long Way", 1).requirement("Properly Metal", 1).requirement("Respect your Elders", 1)
            .requirement("Xena-Phile", 1).requirement("A Screwball Scramble", 1).requirement("The Expensive Range", 1)
            .reward("Crystal motherload shard", 50).reward("Corrupted ore", 100).reward("Cleansing crystal", 10)
            .reward("Harmonic dust", 1000).reward("Crystal dagger", 1).lamp(Player.ALL_SKILLS, 60000, 95).lamp(Player.ALL_SKILLS, 60000, 95)
            .lamp(Player.ALL_SKILLS, 40000, 87).build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Hard", 0, true).requirement("Sing-Along-a-Seren Verse 1", 1)
            .requirement("Sing-Along-a-Seren Verse 2", 1).requirement("Sing-Along-a-Seren Verse 3", 1)
            .requirement("Sing-Along-a-Seren Verse 4", 1).requirement("Sing-Along-a-Seren Verse 5", 1)
            .requirement("Sing-Along-a-Seren Verse 6", 1).requirement("Sing-Along-a-Seren Verse 7", 1).requirement("What a Rush", 1)
            .requirement("The Diplomatic Approach", 1).requirement("Hefin ad Puffin'", 1).requirement("Long WWay From Home", 1)
            .requirement("Because You're Iorwerth It", 1).requirement("Cadarn Tootin'", 1).requirement("A Face in the Clouds", 1)
            .requirement("Brace for Additional Impact", 1).requirement("Thank You, Deer", 1).requirement("Disco Impling", 1)
            .requirement("Can I Have Some Morvran?", 1).requirement("B Sharp, Not Flat", 1).requirement("Casting a Shadow", 1)
            .requirement("A Clean Slate", 1).lamp(Player.ALL_SKILLS, 40000, 78).build());
        achievements.add(new AchievementBuilder("Tirannwn Set Tasks - Medium", 0, true).requirement("Harrowed Lands", 1)
            .requirement("Bowing Out and About", 1).requirement("An Act of War", 1).requirement("Sharks are Good for the Elf", 1)
            .requirement("Gnome Roaming", 1).requirement("Mufflebirds", 1).requirement("The Circle of Life", 1).requirement("Papa Pawya", 1)
            .requirement("Pretty and Witty and Dead", 1).requirement("Light Transit", 1).requirement("Stranger and Stranger", 1)
            .lamp(Player.ALL_SKILLS, 30000, 68).build());
        achievements.add(new AchievementBuilder("To Be a Master", 0, true).requirement("Souls captured", 151).build());
        achievements.add(new AchievementBuilder("To Ga'al or Not to Ga'al", 0, true).requirement("TzHaar-Ga'al-Kot", 1).build());
        achievements.add(new AchievementBuilder("To the Bone", 0, true).requirement("Worker district reputation", 300000).build());
        achievements.add(new AchievementBuilder("TokHaar-Mok", 0, true).requirement("The Brink of Extinction", 1)
            .encounter(new Encounter(Enemy.TOKHAAR_HOK)).reward("Obsidian shard", 16)
            .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Magic", "Ranged", "Summoning", "Prayer", "Herblore",
                "Slayer"), 20000, 80).build());
        achievements.add(new AchievementBuilder("Top Hat", 0.05, true).requirement("Smithing", 95).build());
        achievements.add(new AchievementBuilder("Top Pick", 0, true).requirement("Dimension of Disaster: The Curse of Arrav", 1)
            .requirement("Thieving", 90).reward("Zemomark", 80).build());
        achievements.add(new AchievementBuilder("Torag Bobblehead", 0, true).requirement("Torag the Bobbled", 1).build());
        achievements.add(new AchievementBuilder("Towering Over Us All", 0, true).requirement("Master clue scroll", 1).build());
        achievements.add(new AchievementBuilder("Trade Parade", 0, true).requirement("Dimension of Disaster: Coin of the Realm", 1)
            .build());
        achievements.add(new AchievementBuilder("Traitorous", 0, true).requirement("Agility", 70)
            .encounter(new Encounter(Enemy.COMMANDER_ZILYANA, Arrays.asList(new Restriction("Proselyte hauberk", 1),
                new Restriction("Proselyte sallet", 1), new Restriction("Proselyte tasset", 1)))).build());
        achievements.add(new AchievementBuilder("Treasure Seeker I", 0, true).requirement("Clue scrolls", 1).build());
        achievements.add(new AchievementBuilder("Treasure Seeker II", 0, true).requirement("Clue scrolls", 5).build());
        achievements.add(new AchievementBuilder("Treasure Seeker III", 0, true).requirement("Clue scrolls", 10).build());
        achievements.add(new AchievementBuilder("Treasure Seeker IV", 0, true).requirement("Clue scrolls", 25).build());
        achievements.add(new AchievementBuilder("Treasure Seeker V", 0, true).requirement("Clue scrolls", 50).build());
        achievements.add(new AchievementBuilder("Treasure Seeker VI", 0, true).requirement("Clue scrolls", 100).build());
        achievements.add(new AchievementBuilder("Treasure Seeker VII", 0, true).requirement("Clue scrolls", 250).build());
        achievements.add(new AchievementBuilder("Treasure Seeker VIII", 0, true).requirement("Clue scrolls", 500).build());
        achievements.add(new AchievementBuilder("Treasure Seeker IX", 0, true).requirement("Clue scrolls", 750).build());
        achievements.add(new AchievementBuilder("Treasure Seeker X", 0, true).requirement("Clue scrolls", 1000).build());
        achievements.add(new AchievementBuilder("Trials of the Heart", 0, true).requirement("Quest points", 300).build());
        achievements.add(new AchievementBuilder("Trimmed Completionist Cape", 0, true).requirement("Advanced Sweeping", 1)
            .requirement("Agile from Head to Toe", 1).requirement("All Rise", 1).requirement("Arc - All Your Energies", 1)
            .requirement("Arc - Bone To Pick With You", 1).requirement("Arc - Don't Crush my Memories", 1)
            .requirement("Arc - Mitts and Waders - Death Lotus", 1).requirement("Arc - Mitts and Waders - Seasinger", 1)
            .requirement("Arc - Mitts and Waders - Tetsu", 1).requirement("Around the World in Six Ways", 1)
            .requirement("Banking History", 1).requirement("Barbarian Scavenger", 1).requirement("Champions, What Champions?", 1)
            .requirement("Chompy Massacre", 1).requirement("Class Crown", 1).requirement("Complete Trekky", 1)
            .requirement("Completionist Cape", 1).requirement("Conquest Adore", 1).requirement("Count All Light Fingers", 1)
            .requirement("Death Effect", 1).requirement("Eastern Adventurer", 1).requirement("Eastern Explorer", 1)
            .requirement("Eeeeagle!", 1).requirement("Ferocious Upgrade", 1).requirement("Finish Him!", 1).requirement("Hard as Daemons", 1)
            .requirement("How Many Games?", 1).requirement("Ice Ice Chimpy", 1).requirement("Impressing Char", 1)
            .requirement("Ivan is Flailing", 1).requirement("Jack of the Circus", 1).requirement("Kal'gerion Commander", 1)
            .requirement("Lock, Stock and Barrel", 1).requirement("Maria, You Gotta See Her", 1).requirement("Master Angler", 1)
            .requirement("Master Otto", 1).requirement("Master of Assault", 1).requirement("Mazcab Teleport", 1)
            .requirement("Memorialised More than Once", 1).requirement("Milk of Chocolate, Snape of Grass", 1)
            .requirement("Mobilise This", 1).requirement("Nomad's Genesis", 1).requirement("Nomad's Mirage", 1)
            .requirement("On a Rune High", 1).requirement("Penance to the King", 1).requirement("Perky like a Prawn", 1)
            .requirement("Post Fume", 1).requirement("Quiet but Deadly Lore", 1).requirement("Rank: Master Finix", 1)
            .requirement("Scabigail", 1).requirement("Scribbling in the Depths", 1).requirement("Scrolling with Power", 1)
            .requirement("Seagullible", 1).requirement("Shadows Below", 1).requirement("Sheep Shearer", 1)
            .requirement("Slime and Snails and God Wars Tales", 1).requirement("Special Slayer Delivery", 1)
            .requirement("Stone's Throw Away", 1).requirement("Telos If You're Angry II", 1).requirement("To Be a Master", 1)
            .requirement("To the Bone", 1).requirement("White Knight Rises", 1).requirement("Who Will Be Her Lover?", 1)
            .requirement("Witch's Potion", 1).requirement("Work On Your Artisan", 1).requirement("You're Not My Real Mah", 1).build());
        achievements.add(new AchievementBuilder("Trip to the East", 0, true).requirement("Trio voyage", 1).build());
        achievements.add(new AchievementBuilder("Triple Trouble", 0, true).requirement("Tai Bwo Wannai Trio rewards", 3).build());
        achievements.add(new AchievementBuilder("Trollheim Teleport", 0, true).requirement("Law rune", 2).requirement("Fire rune", 2)
            .requirement("Eadgar's Ruse", 1).requirement("Magic", 61).reward("Magic", 68).build());
        achievements.add(new AchievementBuilder("Troublesome Crystals", 0, true).requirement("Memoriam crystals", 16).build());
        achievements.add(new AchievementBuilder("TzRek-Jad", 0, true).requirement("TzRek-Jad", 1).build());
    }

    private void addAchievementsU() {
        achievements.add(new AchievementBuilder("Ultimate Codex", 0, true).requirement("Codex Ultimatus", 1).build());
        achievements.add(new AchievementBuilder("Uncorrupted Ore", 0, true).requirement("Corrupted ores smelted", 100)
            .reward("Smithing", 50000).build());
        achievements.add(new AchievementBuilder("Under Croc and Key", 0, true).requirement("Crocodile Tears", 1)
            .requirement("Constitution", 80).reward("Constitution", 20000).build());
        achievements.add(new AchievementBuilder("Unholy Crafting", 0, true).requirement("Observatory Quest", 1).build());
        achievements.add(new AchievementBuilder("Unionised", 0, true).requirement("Prifddinian worker's robes", 1).requirement("Magic", 80)
            .requirement("Prifddinian worker's trousers", 1).requirement("Prifddinian worker's gloves", 1)
            .requirement("Prifddinian worker's boots", 1).encounter(new Encounter(Enemy.HELWYR, Arrays.asList(new Restriction("Torso", 0),
                new Restriction("Hands", 0), new Restriction("Feet", 0), new Restriction("Legs", 0)))).build());
    }

    private void addAchievementsV() {

    }

    private void addAchievementsW() {

    }

    private void addAchievementsX() {

    }

    private void addAchievementsY() {

    }

    private void addAchievementsZ() {

    }

    public static AchievementDatabase getAchievementDatabase() {
        if (achievementDatabase == null) {
            achievementDatabase = new AchievementDatabase();
        }
        return achievementDatabase;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }
}