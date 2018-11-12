package logic;

import java.util.Map;

public class CombatScenario {

    private Encounter encounter;
    private CombatParameters parameters;

    public CombatScenario(Encounter encounter, CombatParameters parameters) {
        this.encounter = encounter;
        this.parameters = parameters;
    }

    public Encounter getEncounter() {
        return encounter;
    }


    public CombatParameters getParameters() {
        return parameters;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CombatScenario)) {
            return false;
        }
        CombatScenario scenario = (CombatScenario) obj;
        return encounter.equals(scenario.getEncounter()) && parameters.equals(scenario.getParameters());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + encounter.hashCode();
        result = 31*result + parameters.hashCode();
        return result;
    }
}
