package data.dataobjects;

import data.databases.ActionDatabase;
import data.databases.ItemDatabase;
import logic.GoalResults;
import logic.Player;
import logic.Requirement;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Action {

    private String name;
    private List<Requirement> reqs;
    private Map<String, Integer> inputs;
    private Map<String, Integer> outputs;
    private int actionsPerHour;
    private boolean ironman;
    private boolean hardcore;

    public Action(String name, List reqs, Map inputs, Map outputs, int actionsPerHour, boolean ironman, boolean hardcore) {
        this.name = name;
        this.reqs = reqs;
        this.inputs = inputs;
        this.outputs = outputs;
        this.actionsPerHour = actionsPerHour;
        this.ironman = ironman;
        this.hardcore = hardcore;
    }

    public String getName() {
        return name;
    }

    public List<Requirement> getReqs() {
        return reqs;
    }

    public Map<String, Integer> getInputs() {
        return inputs;
    }

    public Map<String, Integer> getOutputs() {
        return outputs;
    }

    public int getActionsPerHour() {
        return actionsPerHour;
    }

    public boolean getIronman() {
        return ironman;
    }

    public boolean getHardcore() {
        return hardcore;
    }


    public static Action getActionByName(String name, Player player) {
        for (Action a : ActionDatabase.getActionDatabase(player).getDatabase()) {
            if (name.equals(a.getName()))
                return a;
        }
        return null;
    }

}