package logic;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PriceFetcher {

    private static Map<String, Integer> prices;

    public static int getPrice(String item) {
        if (prices == null) {
            prices = new HashMap<>();
            try {
                URL url = new URL("https://runescape.wiki/w/Module:GEPrices/data?action=raw");
                URLConnection conn = url.openConnection();
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");
                Scanner scan = new Scanner(conn.getInputStream());
                StringBuilder itemData = new StringBuilder();
                while (scan.hasNext()) {
                    itemData.append(scan.nextLine());
                }
                scan.close();
                String[] splitData = itemData.toString().split(",");
                for (int i = 2; i < splitData.length; i++) {
                    String[] splitItemByQuotes = splitData[i].split("\"");
                    String itemName = splitItemByQuotes[1];
                    String itemPriceString = splitItemByQuotes[2].substring(4);
                    if (i + 1 == splitData.length) {
                        itemPriceString = itemPriceString.substring(0, itemPriceString.length()-1);
                    }
                    System.out.println(itemName + " " + itemPriceString);
                    prices.put(itemName, Integer.parseInt(itemPriceString));
                }
                prices.put("Coins", 1);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return prices.get(item) == null ? 0 : prices.get(item);
    }

}
