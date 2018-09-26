package data.dataobjects;

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
    private boolean ironman;
    private boolean hardcore;

    public Action(String name, List reqs, Map inputs, Map outputs, boolean ironman, boolean hardcore) {
        this.name = name;
        this.reqs = reqs;
        this.inputs = inputs;
        this.outputs = outputs;
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
                for (Map.Entry<String, Integer> input : inputs.entrySet()) {
                    GoalResults inputResults;
                    if (ItemDatabase.getItemDatabase().getItems().get(input.getKey()) == null) {
                        inputResults = player.efficientGoalCompletion(input.getKey(), input.getValue());
                    } else {
                        inputResults = player.efficientGoalCompletion("Coins", ItemDatabase.getItemDatabase().getItems().get(input.getKey()).coinValue(player) * input.getValue());
                    }
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

}