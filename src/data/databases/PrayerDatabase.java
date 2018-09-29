package data.databases;

import data.dataobjects.Prayer;

import java.util.ArrayList;
import java.util.List;

public class PrayerDatabase {

    private static PrayerDatabase prayerDatabase;

    private List<Prayer> prayers = new ArrayList<>();

    private PrayerDatabase() {
        addPrayers();
    }

    private void addPrayers() {
        prayers.add(new Prayer("None", 0, 0));
        //prayers.add(new Prayer("Protect from Magic", 37, 1.5));
    }

    public static PrayerDatabase getPrayerDatabase() {
        if (prayerDatabase == null) {
            prayerDatabase = new PrayerDatabase();
        }
        return prayerDatabase;
    }

    public List<Prayer> getPrayers() {
        return prayers;
    }
}
