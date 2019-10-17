package logic;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GoalResults {
    private double totalTime;
    private Map<String, Double> actionsWithTimes;
    private List<Requirement> listofAllRequirements;

    public GoalResults(double totalTime, Map actionsWithTimes) {
        this.totalTime = totalTime;
        this.actionsWithTimes = actionsWithTimes;
    }

    public GoalResults(double totalTime, Map actionsWithTimes, List listofAllRequirements) {
        this.totalTime = totalTime;
        this.actionsWithTimes = actionsWithTimes;
        this.listofAllRequirements = listofAllRequirements;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public List<Requirement> getListofAllRequirements() {
        return listofAllRequirements;
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

    public Map<String, Double> getSortedActionsWithTimes() {
        if (actionsWithTimes.containsKey("")) {
            actionsWithTimes.remove("");
        }
        return actionsWithTimes.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
    }

}
