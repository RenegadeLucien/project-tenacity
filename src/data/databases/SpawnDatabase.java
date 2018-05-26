package data.databases;

import data.dataobjects.Spawn;

import java.util.ArrayList;
import java.util.List;

public class SpawnDatabase {

    private static SpawnDatabase spawnDatabase;

    private List<Spawn> spawns = new ArrayList<>();

    private SpawnDatabase() {
        addSpawns();
    }

    private void addSpawns() {
        spawns.add(new Spawn("Supplies", 5, 144000, true));
    }

    public static SpawnDatabase getSpawnDatabase() {
        if (spawnDatabase == null) {
            spawnDatabase = new SpawnDatabase();
        }
        return spawnDatabase;
    }

    public List<Spawn> getSpawns() {
        return spawns;
    }
}
