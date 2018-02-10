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
    BUCKET_OF_SAND("Bucket of sand", 2),
    WIZARD_HAT_BLUE("Wizard hat (blue)", 2),
    SODA_ASH("Soda ash", 2),
    WIZARD_ROBE_SKIRT("Wizard robe skirt", 2),
    EYE_OF_NEWT("Eye of newt", 3),
    MOLTEN_GLASS("Molten glass", 3),
    AIR_TALISMAN("Air talisman", 4),
    DWELLBERRIES("Dwellberries", 4),
    EGG("Egg", 4),
    LOGS("Logs", 4),
    SHRIMPS("Shrimps", 5),
    CRAYFISH("Crayfish", 5),
    RAW_CRAYFISH("Raw crayfish", 5),
    FEATHER("Feather", 6),
    RAW_SHRIMPS("Raw shrimps", 6),
    BLUE_DYE("Blue dye", 6),
    RED_DYE("Red dye", 6),
    YELLOW_DYE("Yellow dye", 6),
    LEATHER_BOOTS("Leather boots", 6),
    PALE_ENERGY("Pale energy", 6),
    BRONZE_ARROW("Bronze arrow", 7),
    BRONZE_NAILS("Bronze nails", 7),
    BRONZE_BAR("Bronze bar", 8),
    RAW_SARDINE("Raw sardine", 10),
    SARDINE("Sardine", 10),
    SNAPE_GRASS("Snape grass", 10),
    BOWL_OF_HOT_WATER("Bowl of hot water", 10),
    BUCKET_OF_MILK("Bucket of milk", 12),
    COOKED_CHICKEN("Cooked chicken", 12),
    STAFF("Staff", 15),
    WIZARD_ROBE_TOP("Wizard robe top", 15),
    RAW_POTATO("Raw potato", 16),
    AIR_RUNE("Air rune", 17),
    EARTH_RUNE("Earth rune", 17),
    MIND_RUNE("Mind rune", 17),
    WATER_RUNE("Water rune", 17),
    LEATHER_VAMBRACES("Leather vambraces", 18),
    ROPE("Rope", 18),
    LEATHER_CHAPS("Leather chaps", 20),
    CHARGEBOW("Chargebow", 20),
    CHOCOLATE_DUST("Chocolate dust", 20),
    COPPER_ORE("Copper ore", 20),
    TIN_ORE("Tin ore", 20),
    LEATHER_BODY("Leather body", 21),
    LEATHER_COWL("Leather cowl", 24),
    BRONZE_HELM("Bronze helm", 24),
    SPIRIT_SHARDS("Spirit shards", 25),
    BRONZE_SWORD("Bronze sword", 26),
    IRON_BAR("Iron bar", 28),
    COOKED_MEAT("Cooked meat", 30),
    CLEAN_GUAM("Clean guam", 30),
    GRIMY_GUAM("Grimy guam", 30),
    BRONZE_SQ_SHIELD("Bronze sq shield", 48),
    SHORTBOW("Shortbow", 50),
    BRONZE_BATTLEAXE("Bronze battleaxe", 52),
    RAW_BEEF("Raw beef", 59),
    RAW_CHICKEN("Raw chicken", 60),
    BRONZE_CHAINBODY("Bronze chainbody", 60),
    LEATHER_SHIELD("Leather shield", 68),
    SHIELDBOW("Shieldbow", 80),
    BRONZE_PLATELEGS("Bronze platelegs", 80),
    BRONZE_PLATESKIRT("Bronze plateskirt", 80),
    BRONZE_2H_SWORD("Bronze 2h sword", 80),
    IRON_HELM("Iron helm", 84),
    HARD_LEATHER_COWL("Hard leather cowl", 100),
    WIZARD_GLOVES("Wizard gloves", 100),
    WIZARD_BOOTS("Wizard boots", 100),
    WIZARD_SHIELD("Wizard shield", 100),
    IMPHIDE_GLOVES("Imphide gloves", 100),
    IMPHIDE_BOOTS("Imphide boots", 100),
    PLANK("Plank", 100),
    REDBERRY_PIE("Redberry pie", 150),
    BRONZE_PLATEBODY("Bronze platebody", 160),
    IRON_SQ_SHIELD("Iron sq shield", 168),
    HARD_LEATHER_BODY("Hard leather body", 170),
    HARD_LEATHER_CHAPS("Hard leather chaps", 170),
    IRON_BATTLEAXE("Iron battleaxe", 182),
    HARD_LEATHER_GLOVES("Hard leather gloves", 200),
    HARD_LEATHER_BOOTS("Hard leather boots", 200),
    MAGIC_STAFF("Magic staff", 200),
    IRON_CHAINBODY("Iron chainbody", 210),
    HARD_LEATHER_SHIELD("Hard leather shield", 238),
    SAPPHIRE("Sapphire", 250),
    IRON_PLATELEGS("Iron platelegs", 280),
    IRON_PLATESKIRT("Iron plateskirt", 280),
    IRON_2H_SWORD("Iron 2h sword", 280),
    GOLD_BAR("Gold bar", 300),
    MITHRIL_SEEDS("Mithril seeds", 300),
    GOLD_RING("Gold ring", 350),
    EMERALD("Emerald", 500),
    IRON_PLATEBODY("Iron platebody", 560),
    SPIRIT_WOLF_POUCH("Spirit wolf pouch", 599),
    RUBY("Ruby", 1000),
    DIAMOND("Diamond", 2000),
    AMULET_OF_ACCURACY("Amulet of accuracy", 5000);

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
                    return Integer.parseInt(nameAndPrice[nameAndPrice.length-1]);
                }
            }
            catch (IOException e) {
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
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int coinValue(Player player) {
        if (player.getStatus() == 0) {
            return geval;
        }
        else {
            return (int)Math.floor(baseval*.3);
        }
    }
}