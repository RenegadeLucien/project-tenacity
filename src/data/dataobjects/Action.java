package data.dataobjects;

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
    private boolean dynamic;

    public Action(String name, List reqs, Map inputs, Map outputs, boolean ironman, boolean hardcore, boolean dynamic) {
        this.name = name;
        this.reqs = reqs;
        this.inputs = inputs;
        this.outputs = outputs;
        this.ironman = ironman;
        this.hardcore = hardcore;
        this.dynamic = dynamic;
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
            gainForThisAction = outputs.get(target);
            double timeTakenForInputs = 0.0;
            if (moneyFromAction(player) < 0) {
                timeTakenForInputs += player.efficientGoalCompletion("Coins", (int) moneyFromAction(player) * -1).getTotalTime();
            }
            for (Map.Entry<String, Integer> input : inputs.entrySet()) {
                if (Item.getItemByName(input.getKey()) == null)
                    timeTakenForInputs += player.efficientGoalCompletion(input.getKey(), input.getValue()).getTotalTime();
            }
            gainForThisAction /= (1 + timeTakenForInputs);
        } else if ((player.getStatus() == 1 && ironman == true) || player.getStatus() == 2 && hardcore == true) {
            gainForThisAction = outputs.get(target);
            double timeToCollectInputs = 0.0;
            for (Map.Entry<String, Integer> input : inputs.entrySet()) {
                timeToCollectInputs += player.efficientGoalCompletion(input.getKey(), input.getValue()).getTotalTime();
            }
            gainForThisAction /= (1.0 + timeToCollectInputs);
        }
        return gainForThisAction;
    }

    public double moneyFromAction(Player player) {
        double moneyForThisAction = 0;
        for (Map.Entry<String, Integer> input : inputs.entrySet()) {
            if (Item.getItemByName(input.getKey()) != null)
                moneyForThisAction -= Item.getItemByName(input.getKey()).coinValue(player) * input.getValue();
        }
        for (Map.Entry<String, Integer> output : outputs.entrySet()) {
            if (Item.getItemByName(output.getKey()) != null)
                moneyForThisAction += Item.getItemByName(output.getKey()).coinValue(player) * output.getValue();
        }
        //System.out.println(action.getName() + " produces " + moneyForThisAction + " GP/HR");
        return moneyForThisAction;
    }
}