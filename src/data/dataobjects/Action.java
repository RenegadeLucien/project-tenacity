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

    public GoalResults effectiveRate(String target, int quantity, Player player) {
        double gainForThisAction = 0.0;
        Map<String, Double> timeAndActionsTakenForInputs = new HashMap<>();
        if (player.getStatus() == 0) {
            if (target.equals("Coins")) {
                for (Map.Entry<String, Integer> output : outputs.entrySet()) {
                    Item item = ItemDatabase.getItemDatabase().getItems().get(output.getKey());
                    if (item != null) {
                        gainForThisAction += output.getValue()*item.coinValue(player);
                    }
                }
                for (Map.Entry<String, Integer> input : inputs.entrySet()) {
                    Item item = ItemDatabase.getItemDatabase().getItems().get(input.getKey());
                    if (item == null) {
                        GoalResults inputResults = player.efficientGoalCompletion(input.getKey(), input.getValue());
                        player.addItemsToMap(timeAndActionsTakenForInputs, inputResults.getActionsWithTimes());
                    }
                    else {
                        gainForThisAction -= input.getValue()*item.coinValue(player);
                    }
                }
                timeAndActionsTakenForInputs.put(name, 1.0);
                for (String action : timeAndActionsTakenForInputs.keySet()) {
                    timeAndActionsTakenForInputs.put(action, timeAndActionsTakenForInputs.get(action)*(quantity/gainForThisAction));
                }
            }
            else {
                gainForThisAction = outputs.get(target);
                Map<String, Integer> trueInputs = new HashMap<>();
                for (Map.Entry<String, Integer> input : inputs.entrySet()) {
                    if (ItemDatabase.getItemDatabase().getItems().get(input.getKey()) == null) {
                        trueInputs.put(input.getKey(), input.getValue());
                    } else {
                        trueInputs.merge("Coins", input.getValue()*ItemDatabase.getItemDatabase().getItems().get(input.getKey()).coinValue(player), (v1, v2) -> v1+v2);
                    }
                }
                for (Map.Entry<String, Integer> output : outputs.entrySet()) {
                    if (ItemDatabase.getItemDatabase().getItems().get(output.getKey()) == null) {
                        if (trueInputs.get(output.getKey()) != null) {
                            if (output.getValue() > trueInputs.get(output.getKey())) {
                                trueInputs.remove(output.getKey());
                            } else {
                                trueInputs.put(output.getKey(), trueInputs.get(output.getKey()) - output.getValue());
                            }
                        }
                    } else {
                        if (trueInputs.get("Coins") != null) {
                            int coinRecovery = output.getValue()*ItemDatabase.getItemDatabase().getItems().get(output.getKey()).coinValue(player);
                            if (coinRecovery > trueInputs.get("Coins")) {
                                trueInputs.remove("Coins");
                            } else  {
                                trueInputs.put("Coins", trueInputs.get("Coins") - coinRecovery);
                            }
                        }
                    }
                }
                for (Map.Entry<String, Integer> input : trueInputs.entrySet()) {
                    GoalResults inputResults = player.efficientGoalCompletion(input.getKey(), input.getValue());
                    player.addItemsToMap(timeAndActionsTakenForInputs, inputResults.getActionsWithTimes());
                }
                timeAndActionsTakenForInputs.put(name, 1.0);
                for (String action : timeAndActionsTakenForInputs.keySet()) {
                    timeAndActionsTakenForInputs.put(action, timeAndActionsTakenForInputs.get(action)*(quantity/gainForThisAction));
                }
            }
        } else if ((player.getStatus() == 1 && ironman) || player.getStatus() == 2 && hardcore) {
            gainForThisAction = outputs.get(target);
            double timeToCollectInputs = 0.0;
            for (Map.Entry<String, Integer> input : inputs.entrySet()) {
                timeToCollectInputs += player.efficientGoalCompletion(input.getKey(), input.getValue()).getTotalTime();
            }
            gainForThisAction /= (1.0 + timeToCollectInputs);
        }
        return new GoalResults(timeAndActionsTakenForInputs.values().stream().mapToDouble(d->d).sum(), timeAndActionsTakenForInputs);
    }

    public static Action getActionByName(String name, Player player) {
        for (Action a : ActionDatabase.getActionDatabase(player).getDatabase()) {
            if (name.equals(a.getName()))
                return a;
        }
        return null;
    }

}