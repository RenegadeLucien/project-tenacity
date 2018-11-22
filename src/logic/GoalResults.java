package logic;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GoalResults implements Serializable {
    private double totalTime;
    private Map<String, Double> actionsWithTimes;

    public GoalResults(double totalTime, Map actionsWithTimes) {
        this.totalTime = totalTime;
        this.actionsWithTimes = actionsWithTimes;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public Map<String, Double> getActionsWithTimes() {
        return actionsWithTimes/*.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ))*/;
    }
}