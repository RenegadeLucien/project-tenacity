package staticdata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Shop {
    GNOME_SHOPKEEPERS_ARMOURY(Arrays.asList("Bronze helm", "Bronze platebody", "Bronze chainbody", "Bronze platelegs",
            "Bronze plateskirt", "Bronze sq shield", "Iron chainbody", "Iron helm", "Iron platebody", "Iron platelegs",
            "Iron plateskirt", "Iron sq shield", "Leather vambraces", "Leather boots", "Leather cowl", "Leather body",
            "Leather chaps", "Leather shield", "Hard leather gloves", "Hard leather boots", "Hard leather cowl", "Hard leather body",
            "Hard leather chaps", "Hard leather shield", "Wizard gloves", "Wizard boots", "Wizard hat (blue)", "Wizard robe top",
            "Wizard robe skirt", "Wizard shield", "Imphide gloves", "Imphide boots", "Imphide hood", "Imphide robe top",
            "Imphide robe bottom", "Imphide shield", "Bronze battleaxe", "Iron battleaxe", "Iron 2h sword", "Bronze arrow",
            "Bronze bolts", "Willow shieldbow", "Bronze 2h crossbow", "Iron crossbow", "Off-hand iron crossbow", "Magic staff",
            "Wizard wand", "Wizard book", "Imp horn wand", "Imphide book"),
            Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                    10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 30, 30, 1, 1, 1, 10, 10, 10, 10, 10));

    Map<String, Integer> itemAndQuantity;

    Shop(List<String> items, List<Integer> quantities) {
        itemAndQuantity = new HashMap<>();
        for (int i = 0; i < items.size(); i++)
            itemAndQuantity.put(items.get(i), quantities.get(i));
    }
}
