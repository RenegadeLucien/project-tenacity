package logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoredCombatCalcs {

    private static Map<CombatScenario, List<CombatStats>> calculatedCombats = new HashMap<>();

    public static Map<CombatScenario, List<CombatStats>> getCalculatedCombats() {
        return calculatedCombats;
    }
}
