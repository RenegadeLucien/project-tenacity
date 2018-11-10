package logic;

import java.util.Map;

public class CombatScenario {

    private Encounter encounter;
    private Loadout loadout;
    private Map<String, Double> xp;
    private CombatParameters parameters;

    public CombatScenario(Encounter encounter, Loadout loadout, Map<String, Double> xp, CombatParameters parameters) {
        this.encounter = encounter;
        this.loadout = loadout;
        this.xp = xp;
        this.parameters = parameters;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public Loadout getLoadout() {
        return loadout;
    }

    public Map<String, Double> getXp() {
        return xp;
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
        return encounter.equals(scenario.getEncounter()) && loadout.equals(scenario.getLoadout()) && xp.equals(scenario.getXp()) && parameters.equals(scenario.getParameters());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + encounter.hashCode();
        result = 31*result + loadout.hashCode();
        result = 31*result + xp.hashCode();
        result = 31*result + parameters.hashCode();
        return result;
    }
}
