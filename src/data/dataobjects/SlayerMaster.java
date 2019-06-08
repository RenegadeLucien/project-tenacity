package data.dataobjects;

import com.google.common.collect.ImmutableMap;
import data.databases.SlayerMonsterDatabase;
import logic.Player;
import logic.Requirement;
import logic.SlayerAssignment;

import java.util.Map;

public enum SlayerMaster {

    TURAEL("Turael", ImmutableMap.<SlayerAssignment, Integer>builder()
        .put(new SlayerAssignment("Banshees", 33), 30)
        .put(new SlayerAssignment("Bats", 33), 10)
        .put(new SlayerAssignment("Bears", 33), 10)
        .put(new SlayerAssignment("Birds", 33), 10)
        .put(new SlayerAssignment("Cave bugs", 33), 10)
        .put(new SlayerAssignment("Cave slimes", 33), 30)
        .put(new SlayerAssignment("Cows", 33), 10)
        .put(new SlayerAssignment("Crawling hands", 33), 30)
        .put(new SlayerAssignment("Desert lizards", 33), 30)
        .put(new SlayerAssignment("Dogs", 33), 15)
        .put(new SlayerAssignment("Dwarves", 33), 10)
        .put(new SlayerAssignment("Gelatinous abominations", 33), 10)
        .put(new SlayerAssignment("Ghosts", 33), 15)
        .put(new SlayerAssignment("Goblins", 33), 10)
        .put(new SlayerAssignment("Grotworms", 23), 15)
        .put(new SlayerAssignment("Icefiends", 15), 10)
        .put(new SlayerAssignment("Minotaurs", 33), 10)
        .put(new SlayerAssignment("Monkeys", 33), 10)
        .put(new SlayerAssignment("Pigs", 33), 10)
        .put(new SlayerAssignment("Scorpions", 33), 10)
        .put(new SlayerAssignment("Skeletons", 33), 15)
        .put(new SlayerAssignment("Spiders", 33), 10)
        .put(new SlayerAssignment("Trolls", 33), 10)
        .put(new SlayerAssignment("Wolves", 33), 15)
        .put(new SlayerAssignment("Zombies", 33), 10).build(), 0),
    MAZCHNA("Mazchna", ImmutableMap.<SlayerAssignment, Integer>builder()
        .put(new SlayerAssignment("Banshees", 55), 20)
        .put(new SlayerAssignment("Bats", 55), 10)
        .put(new SlayerAssignment("Bears", 55), 10)
        .put(new SlayerAssignment("Catablepon", 55), 10)
        .put(new SlayerAssignment("Cave crawlers", 55), 20)
        .put(new SlayerAssignment("Cave slimes", 55), 10)
        .put(new SlayerAssignment("Cockatrices", 55), 20)
        .put(new SlayerAssignment("Crawling hands", 55), 20)
        .put(new SlayerAssignment("Cyclopes", 45), 10)
        .put(new SlayerAssignment("Desert lizards", 55), 10)
        .put(new SlayerAssignment("Dogs", 55), 10)
        .put(new SlayerAssignment("Flesh crawlers", 55), 10)
        .put(new SlayerAssignment("Ghouls", 55), 10)
        .put(new SlayerAssignment("Ghosts", 55), 10)
        .put(new SlayerAssignment("Grotworms", 30), 10)
        .put(new SlayerAssignment("Hill giants", 55), 10)
        .put(new SlayerAssignment("Hobgoblins", 55), 10)
        .put(new SlayerAssignment("Ice warriors", 55), 10)
        .put(new SlayerAssignment("Kalphites", 55), 10)
        .put(new SlayerAssignment("Mogres", 55), 10)
        .put(new SlayerAssignment("Pyrefiends", 55), 20)
        .put(new SlayerAssignment("Rockslugs", 55), 15)
        .put(new SlayerAssignment("Skeletons", 55), 10)
        .put(new SlayerAssignment("Vampyres", 55), 10)
        .put(new SlayerAssignment("Wall beasts", 15), 15)
        .put(new SlayerAssignment("Wolves", 33), 10)
        .put(new SlayerAssignment("Zombies", 33), 10).build(), 2),
    VANNAKA("Vannaka", ImmutableMap.<SlayerAssignment, Integer>builder()
        .put(new SlayerAssignment("Aberrant spectres", 90), 25)
        .put(new SlayerAssignment("Ankous", 90), 10)
        .put(new SlayerAssignment("Banshees", 90), 15)
        .put(new SlayerAssignment("Basilisks", 90), 10)
        .put(new SlayerAssignment("Bloodvelds", 90), 20)
        .put(new SlayerAssignment("Brine rats", 90), 20)
        .put(new SlayerAssignment("Cockatrices", 90), 10)
        .put(new SlayerAssignment("Crocodiles", 45), 10)
        .put(new SlayerAssignment("Cyclopes", 90), 10)
        .put(new SlayerAssignment("Dust devils", 90), 25)
        .put(new SlayerAssignment("Earth warriors", 45), 15)
        .put(new SlayerAssignment("Ghouls", 90), 10)
        .put(new SlayerAssignment("Green dragons", 45), 10)
        .put(new SlayerAssignment("Grotworms", 90), 15)
        .put(new SlayerAssignment("Harpie Bug Swarms", 90), 20)
        .put(new SlayerAssignment("Hill giants", 90), 10)
        .put(new SlayerAssignment("Ice giants", 90), 10)
        .put(new SlayerAssignment("Ice warriors", 90), 10)
        .put(new SlayerAssignment("Infernal mages", 90), 10)
        .put(new SlayerAssignment("Jellies", 90), 20)
        .put(new SlayerAssignment("Jungle horrors", 90), 10)
        .put(new SlayerAssignment("Killerwatts", 90), 20)
        .put(new SlayerAssignment("Lesser demons", 90), 10)
        .put(new SlayerAssignment("Mogres", 90), 10)
        .put(new SlayerAssignment("Molanisks", 90), 10)
        .put(new SlayerAssignment("Moss giants", 90), 10)
        .put(new SlayerAssignment("Ogres", 90), 10)
        .put(new SlayerAssignment("Otherworldly beings", 90), 10)
        .put(new SlayerAssignment("Pyrefiends", 90), 10)
        .put(new SlayerAssignment("Sea snakes", 45), 10)
        .put(new SlayerAssignment("Shades", 90), 10)
        .put(new SlayerAssignment("Shadow warriors", 90), 10)
        .put(new SlayerAssignment("Turoths", 90), 20)
        .put(new SlayerAssignment("Vampyres", 90), 15)
        .put(new SlayerAssignment("Werewolves", 90), 10).build(), 4);

    private String name;
    private Map<SlayerAssignment, Integer> assignmentsWithWeights;
    private double slayerPointsPerTask;

    SlayerMaster(String name, Map<SlayerAssignment, Integer> assignmentsWithWeights, double slayerPointsPerTask) {
        this.name = name;
        this.assignmentsWithWeights = assignmentsWithWeights;
        this.slayerPointsPerTask = slayerPointsPerTask;
    }

    public Map<Double, Double> calculateAvgXpAndSlayerPointsPerHour(Player player) {
        double totalXp = 0.0;
        double totalPoints = 0.0;
        int totalWeights = 0;
        for (Map.Entry<SlayerAssignment, Integer> assignmentAndWeight : assignmentsWithWeights.entrySet()) {
            SlayerAssignment assignment = assignmentAndWeight.getKey();

            double categoryXp = 0.0;
            double categoryPoints = 0.0;
            for (SlayerMonster monster : SlayerMonsterDatabase.getSlayerMonsterDatabase().getSlayerMonsters()) {
                if (monster.getCategory().equals(assignment.getCategory())) {
                    boolean meetsReqs = true;
                    for (Requirement requirement : monster.getReqs()) {
                        if (!requirement.meetsRequirement(player)) {
                            meetsReqs = false;
                        }
                    }
                    if (!meetsReqs) {
                        continue;
                    }
                    int time = Math.min(monster.timeToTask(player, "Melee", assignment.getAverageNumber()),
                        Math.min(monster.timeToTask(player, "Ranged", assignment.getAverageNumber()),
                            monster.timeToTask(player, "Magic", assignment.getAverageNumber())));
                    double taskXp = monster.getSlayerXp() * assignment.getAverageNumber();
                    categoryXp = Math.max(categoryXp, (taskXp*6000.0)/time);
                    categoryPoints = Math.max(categoryPoints, (slayerPointsPerTask*6000.0)/time);
                }
            }
            if (categoryXp > 1) {
                //System.out.println(assignment.getCategory() + " " + categoryXp);
                totalXp += categoryXp * assignmentAndWeight.getValue();
                totalPoints += categoryPoints * assignmentAndWeight.getValue();
                totalWeights += assignmentAndWeight.getValue();
            }
        }
        return ImmutableMap.of(totalXp/totalWeights, totalPoints/totalWeights);
    }
}
