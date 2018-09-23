package data.dataobjects;

import data.databases.ItemDatabase;
import logic.Player;
import logic.Requirement;

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

    public double effectiveRate(String target, Player player) {
        double gainForThisAction = 0.0;
        if (player.getStatus() == 0) {
            if (target.equals("Coins")) {
                for (Map.Entry<String, Integer> output : outputs.entrySet()) {
                    Item item = ItemDatabase.getItemDatabase().getItems().get(output.getKey());
                    if (item != null) {
                        gainForThisAction += output.getValue()*item.coinValue(player);
                    }
                }
                double timeTakenForInputs = 0.0;
                for (Map.Entry<String, Integer> input : inputs.entrySet()) {
                    Item item = ItemDatabase.getItemDatabase().getItems().get(input.getKey());
                    if (item == null) {
                        timeTakenForInputs += player.efficientGoalCompletion(input.getKey(), input.getValue()).getTotalTime();
                    }
                    else {
                        gainForThisAction -= input.getValue()*item.coinValue(player);
                    }
                }
                gainForThisAction /= (1 + timeTakenForInputs);
            }
            else {
                gainForThisAction = outputs.get(target);
                double timeTakenForInputs = 0.0;
                for (Map.Entry<String, Integer> input : inputs.entrySet()) {
                    if (ItemDatabase.getItemDatabase().getItems().get(input.getKey()) == null) {
                        timeTakenForInputs += player.efficientGoalCompletion(input.getKey(), input.getValue()).getTotalTime();
                    } else {
                        timeTakenForInputs += player.efficientGoalCompletion("Coins", ItemDatabase.getItemDatabase().getItems().get(input.getKey()).coinValue(player) * input.getValue()).getTotalTime();
                    }
                }
                gainForThisAction /= (1 + timeTakenForInputs);
            }
        } else if ((player.getStatus() == 1 && ironman) || player.getStatus() == 2 && hardcore) {
            gainForThisAction = outputs.get(target);
            double timeToCollectInputs = 0.0;
            for (Map.Entry<String, Integer> input : inputs.entrySet()) {
                timeToCollectInputs += player.efficientGoalCompletion(input.getKey(), input.getValue()).getTotalTime();
            }
            gainForThisAction /= (1.0 + timeToCollectInputs);
        }
        return gainForThisAction;
    }
}