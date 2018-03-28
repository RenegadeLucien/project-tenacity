package staticdata;

import dynamicdata.Player;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.net.URL;
import java.util.Scanner;

public enum Item {
    //Special case. Coins can't be alched so value is so Ironmen perceive it as value of 1
    COINS("Coins", 4),

    BONES("Bones", 1),
    WOLF_BONES("Wolf bones", 1),
    POUCH("Pouch", 1),
    COWHIDE("Cowhide", 1),
    LEATHER("Leather", 1),
    EMPTY_POT("Empty pot", 1),
    TEASING_STICK("Teasing stick", 1),
    TINDERBOX("Tinderbox", 1),
    MORT_MYRE_STEM("Mort myre stem", 1),
    FIYR_REMAINS("Fiyr remains", 1),
    WINE_OF_ZAMORAK("Wine of Zamorak", 1),
    POTATO_CACTUS("Potato cactus", 1),
    MITHRIL_GRAPPLE("Mithril grapple", 1),
    MUDDY_KEY("Muddy key", 1),
    JOGRE_BONES("Jogre bones", 1),
    BUCKET("Bucket", 2),
    BUCKET_OF_SAND("Bucket of sand", 2),
    WIZARD_HAT_BLUE("Wizard hat (blue)", 2),
    SODA_ASH("Soda ash", 2),
    WIZARD_ROBE_SKIRT("Wizard robe skirt", 2),
    TOAD_CRUNCHIES("Toad crunchies", 2),
    WHEAT("Wheat", 2),
    SOFT_CLAY("Soft clay", 2),
    SEARING_ASHES("Searing ashes", 2),
    CIDER("Cider", 2),
    EYE_OF_NEWT("Eye of newt", 3),
    MOLTEN_GLASS("Molten glass", 3),
    PIE_DISH("Pie dish", 3),
    GARLIC("Garlic", 3),
    AIR_TALISMAN("Air talisman", 4),
    DWELLBERRIES("Dwellberries", 4),
    EGG("Egg", 4),
    LOGS("Logs", 4),
    NATURE_TALISMAN("Nature talisman", 4),
    EARTH_TALISMAN("Earth talisman", 4),
    DEATH_TALISMAN("Death talisman", 4),
    WATER_TALISMAN("Water talisman", 4),
    PURE_ESSENCE("Pure essence", 4),
    MIND_TALISMAN("Mind talisman", 4),
    SHRIMPS("Shrimps", 5),
    CRAYFISH("Crayfish", 5),
    RAW_CRAYFISH("Raw crayfish", 5),
    BALL_OF_WOOL("Ball of wool", 5),
    FEATHER("Feather", 6),
    RAW_SHRIMPS("Raw shrimps", 6),
    BLUE_DYE("Blue dye", 6),
    RED_DYE("Red dye", 6),
    YELLOW_DYE("Yellow dye", 6),
    LEATHER_BOOTS("Leather boots", 6),
    PALE_ENERGY("Pale energy", 6),
    UNCOOKED_BERRY_PIE("Uncooked berry pie", 6),
    BUCKET_OF_WATER("Bucket of water", 6),
    BRONZE_ARROW("Bronze arrow", 7),
    BRONZE_NAILS("Bronze nails", 7),
    RED_SPIDERS_EGGS("Red spiders' eggs", 7),
    BRONZE_BAR("Bronze bar", 8),
    CHEESE("Cheese", 8),
    POTATO_SEED("Potato seed", 8),
    SWEETCORN_SEED("Sweetcorn seed", 8),
    RAW_SARDINE("Raw sardine", 10),
    SARDINE("Sardine", 10),
    SNAPE_GRASS("Snape grass", 10),
    BOWL_OF_HOT_WATER("Bowl of hot water", 10),
    BEAR_FUR("Bear fur", 10),
    STRIP_OF_CLOTH("Strip of cloth", 10),
    LIMESTONE("Limestone", 10),
    BUCKET_OF_MILK("Bucket of milk", 12),
    COOKED_CHICKEN("Cooked chicken", 12),
    LIMPWURT_SEED("Limpwurt seed", 12),
    ARROW_SHAFT("Arrow shaft", 12),
    ONION("Onion", 12),
    APPLE_TREE_SEED("Apple tree seed", 13),
    TOMATO("Tomato", 14),
    STAFF("Staff", 15),
    WATERSKIN_0("Waterskin (0)", 15),
    WIZARD_ROBE_TOP("Wizard robe top", 15),
    RAW_POTATO("Raw potato", 16),
    BRONZE_HATCHET("Bronze hatchet", 16),
    RAW_ANCHOVIES("Raw anchovies", 16),
    AIR_RUNE("Air rune", 17),
    EARTH_RUNE("Earth rune", 17),
    MIND_RUNE("Mind rune", 17),
    WATER_RUNE("Water rune", 17),
    FIRE_RUNE("Fire rune", 17),
    IRON_ORE("Iron ore", 17),
    STRAWBERRY("Strawberry", 17),
    LEATHER_VAMBRACES("Leather vambraces", 18),
    ROPE("Rope", 18),
    COOKED_RABBIT("Cooked rabbit", 19),
    LEATHER_CHAPS("Leather chaps", 20),
    CHARGEBOW("Chargebow", 20),
    CHOCOLATE_DUST("Chocolate dust", 20),
    COPPER_ORE("Copper ore", 20),
    TIN_ORE("Tin ore", 20),
    UNICORN_HORN("Unicorn horn", 20),
    CLEAN_HARRALANDER("Clean harralander", 20),
    POISON_CHALICE("Poison chalice", 20),
    CHOCOLATE_BAR("Chocolate bar", 20),
    LEATHER_BODY("Leather body", 21),
    LEATHER_COWL("Leather cowl", 24),
    BRONZE_HELM("Bronze helm", 24),
    SPIRIT_SHARDS("Spirit shards", 25),
    ARCHERY_TICKET("Archery ticket", 25),
    BRONZE_SWORD("Bronze sword", 26),
    RAW_MACKEREL("Raw mackerel", 26),
    IRON_BAR("Iron bar", 28),
    COOKED_MEAT("Cooked meat", 30),
    CLEAN_GUAM("Clean guam", 30),
    GRIMY_GUAM("Grimy guam", 30),
    SWAMP_PASTE("Swamp paste", 31),
    ARCTIC_PINE_LOGS("Arctic pine logs", 35),
    BOX_TRAP("Box trap", 38),
    RAW_RAT_MEAT("Raw rat meat", 39),
    PLANT_CURE("Plant cure", 40),
    COAL("Coal", 45),
    BRONZE_SQ_SHIELD("Bronze sq shield", 48),
    SHORTBOW("Shortbow", 50),
    BRONZE_BATTLEAXE("Bronze battleaxe", 52),
    STEEL_NAILS("Steel nails", 52),
    SILK("Silk", 55),
    CLAY_RING_UNFIRED("Clay ring (unfired)", 55),
    WATERMELON_SEED("Watermelon seed", 56),
    RAW_BEEF("Raw beef", 59),
    RAW_CHICKEN("Raw chicken", 60),
    BRONZE_CHAINBODY("Bronze chainbody", 60),
    FELLSTALK_SEED("Fellstalk seed", 64),
    LEATHER_SHIELD("Leather shield", 68),
    SILVER_ORE("Silver ore", 75),
    SHIELDBOW("Shieldbow", 80),
    BRONZE_PLATELEGS("Bronze platelegs", 80),
    BRONZE_PLATESKIRT("Bronze plateskirt", 80),
    BRONZE_2H_SWORD("Bronze 2h sword", 80),
    MAPLE_LOGS("Maple logs", 80),
    IRON_HELM("Iron helm", 84),
    MORCHELLA_MUSHROOM_SPORE("Morchella mushroom spore", 86),
    BITTERCAP_MUSHROOM_SPORE("Bittercap mushroom spore", 86),
    IRON_SPEAR("Iron spear", 91),
    HARD_LEATHER_COWL("Hard leather cowl", 100),
    WIZARD_GLOVES("Wizard gloves", 100),
    WIZARD_BOOTS("Wizard boots", 100),
    WIZARD_SHIELD("Wizard shield", 100),
    IMPHIDE_GLOVES("Imphide gloves", 100),
    IMPHIDE_BOOTS("Imphide boots", 100),
    DEATH_TIARA("Death tiara", 100),
    BOWSTRING("Bowstring", 100),
    PLANK("Plank", 100),
    UNPOWERED_ORB("Unpowered orb", 100),
    TEAK_PYRE_LOGS("Teak pyre logs", 100),
    STEEL_BAR("Steel bar", 100),
    TIARA("Tiara", 100),
    PAPAYA_TREE_SEED("Papaya tree seed", 115),
    STEEL_DAGGER("Steel dagger", 125),
    REDBERRY_PIE("Redberry pie", 150),
    SILVER_BAR("Silver bar", 150),
    IRON_CROSSBOW("Iron crossbow", 157),
    BRONZE_PLATEBODY("Bronze platebody", 160),
    IRON_SQ_SHIELD("Iron sq shield", 168),
    HARD_LEATHER_BODY("Hard leather body", 170),
    HARD_LEATHER_CHAPS("Hard leather chaps", 170),
    SILVER_SICKLE("Silver sickle", 175),
    IRON_BATTLEAXE("Iron battleaxe", 182),
    WILD_PIE("Wild pie", 182),
    HARD_LEATHER_GLOVES("Hard leather gloves", 200),
    HARD_LEATHER_BOOTS("Hard leather boots", 200),
    MAGIC_STAFF("Magic staff", 200),
    AGILITY_POTION_4("Agility potion (4)", 200),
    BLACK_SALAMANDER("Black salamander", 200),
    IRON_CHAINBODY("Iron chainbody", 210),
    STEEL_MACE("Steel mace", 225),
    COSMIC_RUNE("Cosmic rune", 232),
    HARD_LEATHER_SHIELD("Hard leather shield", 238),
    SAPPHIRE("Sapphire", 250),
    SUPER_DEFENCE_3("Super defence (3)", 264),
    DASHING_KEBBIT_FUR("Dashing kebbit fur", 270),
    IRON_PLATELEGS("Iron platelegs", 280),
    IRON_PLATESKIRT("Iron plateskirt", 280),
    IRON_2H_SWORD("Iron 2h sword", 280),
    RAW_BASS("Raw bass", 280),
    RAW_LOBSTER("Raw lobster", 284),
    GOLD_BAR("Gold bar", 300),
    MITHRIL_SEEDS("Mithril seeds", 300),
    MITHRIL_BAR("Mithril bar", 300),
    MAGIC_LOGS("Magic logs", 320),
    STEEL_SWORD("Steel sword", 325),
    RAW_SWORDFISH("Raw swordfish", 340),
    GOLD_RING("Gold ring", 350),
    SUPER_RANGING_POTION_4("Super ranging potion (4)", 360),
    LAW_RUNE("Law rune", 378),
    RAW_KARAMBWAN("Raw karambwan", 440),
    EMERALD("Emerald", 500),
    STEEL_LONGSWORD("Steel longsword", 500),
    IRON_PLATEBODY("Iron platebody", 560),
    SPIRIT_WOLF_POUCH("Spirit wolf pouch", 599),
    GLOVES_OF_SILENCE("Gloves of silence", 600),
    ADAMANT_BAR("Adamant bar", 640),
    MAGIC_PYRE_LOGS("Magic pyre logs", 640),
    RANGING_POTION_4("Ranging potion (4)", 700),
    MAGIC_SHORTBOW_U("Magic shortbow (u)", 800),
    STEEL_WARHAMMER("Steel warhammer", 832),
    SAPPHIRE_AMULET("Sapphire amulet", 900),
    RUBY("Ruby", 1000),
    UNCUT_DRAGONSTONE("Uncut dragonstone", 1000),
    BAGGED_PLANT_1("Bagged plant 1", 1000),
    DIAMOND("Diamond", 2000),
    IBIS_POUCH("Ibis pouch", 3149),
    PYRELORD_POUCH("Pyrelord pouch", 3199),
    ABYSSAL_TITAN_POUCH("Abyssal titan pouch", 3249),
    HYDRA_POUCH("Hydra pouch", 3624),
    AMULET_OF_ACCURACY("Amulet of accuracy", 5000),
    RUNE_BAR("Rune bar", 5000),
    MOSS_TITAN_POUCH("Moss titan pouch", 5474),
    INITIATE_SALLET("Initiate sallet", 6000),
    BATTLESTAFF("Battlestaff", 7000),
    CREST_OF_SEREN("Crest of Seren", 100000);

    private String name;
    private int geval;
    private int baseval;

    Item(String n, int baseval) {
        name = n;
        if (!n.equals("Coins"))
            this.geval = getData();
        else
            this.geval = 1;
        this.baseval = baseval;
    }

    public String getName() {
        return name;
    }

    public static Item getItemByName(String name) {
        for (Item i : values()) {
            if (name.equals(i.getName()))
                return i;
        }
        return null;
    }

    public int getData() {
        File geData = new File("gedata.txt");
        String line = null;
        if (geData.exists()) {
            try {
                FileReader fileReader = new FileReader(geData);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                boolean found = false;
                while ((line = bufferedReader.readLine()) != null)
                    if (line.contains(this.getName())) {
                        found = true;
                        break;
                    }
                bufferedReader.close();
                if (found == true) {
                    String[] nameAndPrice = line.split(" ");
                    return Integer.parseInt(nameAndPrice[nameAndPrice.length - 1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(geData, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String alteredName = name.replace(' ', '_');
            URL url = new URL("http://runescape.wikia.com/wiki/Module:Exchange/" + alteredName + "?action=raw");
            Scanner scan = new Scanner(url.openStream());
            String itemData = new String();
            while (scan.hasNext()) {
                itemData += scan.nextLine();
            }
            scan.close();
            String[] splitData = itemData.split(",");
            String priceData = null;
            for (int i = 0; i < splitData.length; i++)
                if (splitData[i].contains("price")) {
                    priceData = splitData[i];
                    break;
                }
            System.out.println(name);
            int price = Integer.parseInt(priceData.substring(17, priceData.length()));
            bufferedWriter.write(this.getName() + " " + price);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return price;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int coinValue(Player player) {
        if (player.getStatus() == 0) {
            return geval;
        } else {
            return (int) Math.floor(baseval * .3);
        }
    }
}