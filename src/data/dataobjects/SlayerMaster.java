package data.dataobjects;

import data.databases.SlayerMonsterDatabase;
import logic.Player;
import logic.Requirement;
import logic.SlayerAssignment;

import java.util.Map;

public enum SlayerMaster {

    TURAEL("Turael", Map.ofEntries(
        Map.entry(new SlayerAssignment("Banshees", 33), 30),
        Map.entry(new SlayerAssignment("Bats", 33), 10),
        Map.entry(new SlayerAssignment("Bears", 33), 10),
        Map.entry(new SlayerAssignment("Birds", 33), 10),
        Map.entry(new SlayerAssignment("Cave bugs", 33), 10),
        Map.entry(new SlayerAssignment("Cave slimes", 33), 30),
        Map.entry(new SlayerAssignment("Cows", 33), 10),
        Map.entry(new SlayerAssignment("Crawling hands", 33), 30),
        Map.entry(new SlayerAssignment("Desert lizards", 33), 30),
        Map.entry(new SlayerAssignment("Dogs", 33), 15),
        Map.entry(new SlayerAssignment("Dwarves", 33), 10),
        Map.entry(new SlayerAssignment("Gelatinous abominations", 33), 10),
        Map.entry(new SlayerAssignment("Ghosts", 33), 15),
        Map.entry(new SlayerAssignment("Goblins", 33), 10),
        Map.entry(new SlayerAssignment("Grotworms", 23), 15),
        Map.entry(new SlayerAssignment("Icefiends", 15), 10),
        Map.entry(new SlayerAssignment("Minotaurs", 33), 10),
        Map.entry(new SlayerAssignment("Monnkeys", 33), 10),
        Map.entry(new SlayerAssignment("Pigs", 33), 10),
        Map.entry(new SlayerAssignment("Scorpions", 33), 10),
        Map.entry(new SlayerAssignment("Skeletons", 33), 15),
        Map.entry(new SlayerAssignment("Spiders", 33), 10),
        Map.entry(new SlayerAssignment("Trolls", 33), 10),
        Map.entry(new SlayerAssignment("Wolves", 33), 15),
        Map.entry(new SlayerAssignment("Zombies", 33), 10)
        ));

    private String name;
    private Map<SlayerAssignment, Integer> assignmentsWithWeights;

    SlayerMaster(String name, Map<SlayerAssignment, Integer> assignmentsWithWeights) {
        this.name = name;
        this.assignmentsWithWeights = assignmentsWithWeights;
    }

    public double calculateAvgXpPerHour(Player player) {
        double totalXp = 0.0;
        int totalWeights = 0;
        for (Map.Entry<SlayerAssignment, Integer> assignmentAndWeight : assignmentsWithWeights.entrySet()) {
            SlayerAssignment assignment = assignmentAndWeight.getKey();

            double categoryXp = 0.0;
            for (SlayerMonster monster : SlayerMonsterDatabase.getSlayerMonsterDatabase().getSlayerMonsters()) {
                if (monster.getCategory().equals(assignment.getCategory())) {
                    boolean meetsReqx = true;
                    for (Requirement requirement : monster.getReqs()) {
                        if (!requirement.meetsRequirement(player)) {
                            meetsReqx = false;
                        }
                    }
                    if (!meetsReqx) {
                        continue;
                    }
                    int time = Math.min(monster.timeToTask(player, "Melee", assignment.getAverageNumber()),
                        Math.min(monster.timeToTask(player, "Ranged", assignment.getAverageNumber()),
                            monster.timeToTask(player, "Magic", assignment.getAverageNumber())));
                    double taskXp = monster.getSlayerXp() * assignment.getAverageNumber();
                    categoryXp = Math.max(categoryXp, (taskXp*6000.0)/time);
                }
            }
            if (categoryXp > 0) {
                totalXp += categoryXp * assignmentAndWeight.getValue();
                totalWeights += assignmentAndWeight.getValue();
            }
        }
        return totalXp/totalWeights;
    }
}
