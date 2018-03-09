package dynamicdata;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GoalResults {
    private double totalTime;
    private List<Requirement> requirements;
    private Map<String, Double> actionsWithTimes;

    public GoalResults(double totalTime, List requirements, Map actionsWithTimes) {
        this.totalTime = totalTime;
        this.requirements = requirements;
        this.actionsWithTimes = actionsWithTimes;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public Map<String, Double> getActionsWithTimes() {
        return actionsWithTimes.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
    }
}