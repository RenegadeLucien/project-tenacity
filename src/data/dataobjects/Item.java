package data.dataobjects;

import logic.Player;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.net.URL;
import java.util.Scanner;

public class Item {

    private String name;
    private int geval;
    private int baseval;

    public Item(String n, int baseval) {
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

    public int getData() {
        File geData = new File("gedata.txt");
        String line;
        if (geData.exists()) {
            try {
                FileReader fileReader = new FileReader(geData);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                boolean found = false;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.substring(0, line.lastIndexOf(" ")).equals(this.name)) {
                        found = true;
                        break;
                    }
                }
                bufferedReader.close();
                if (found) {
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