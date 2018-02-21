package dynamicdata;

import java.util.List;
import java.util.Map;

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
        return actionsWithTimes;
    }
}