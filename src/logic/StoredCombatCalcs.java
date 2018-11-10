package logic;

import java.util.HashMap;
import java.util.Map;

public class StoredCombatCalcs {

    private static Map<CombatScenario, CombatResults> calculatedCombats = new HashMap<>();

    public static Map<CombatScenario, CombatResults> getCalculatedCombats() {
        return calculatedCombats;
    }
}
