package data.databases;

import logic.Requirement;
import data.dataobjects.Ability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbilityDatabase {

    private static AbilityDatabase abilityDatabase;

    private List<Ability> abilities = new ArrayList<>();

    private AbilityDatabase() {
        addAbilities();
    }
    
    private void addAbilities() {
        abilities.add(new Ability("Slice", "Melee", "Any", "Basic", 5, 0.75, new ArrayList<>()));
        abilities.add(new Ability("Slaughter", "Melee", "Any", "Threshold", 50, 1.75, new ArrayList<>()));
        abilities.add(new Ability("Overpower", "Melee", "Any", "Ultimate", 50, 3, Collections.singletonList(new Requirement("Attack", 2))));
        abilities.add(new Ability("Havoc", "Melee", "Dual", "Basic", 17, 0.942, Collections.singletonList(new Requirement("Attack", 5))));
        abilities.add(new Ability("Backhand", "Melee", "Any", "Basic", 25, 0.6, Collections.singletonList(new Requirement("Attack", 10))));
        abilities.add(new Ability("Forceful Backhand", "Melee", "Any", "Threshold", 25, 1.2, Collections.singletonList(new Requirement("Attack", 15))));
        abilities.add(new Ability("Smash", "Melee", "Two-handed", "Basic", 17, 0.942, Collections.singletonList(new Requirement("Attack", 20))));
        abilities.add(new Ability("Barge", "Melee", "Any", "Basic", 34, 0.75, Collections.singletonList(new Requirement("Attack", 30))));
        abilities.add(new Ability("Flurry", "Melee", "Dual", "Threshold", 34, 2.04, Collections.singletonList(new Requirement("Attack", 37))));
        abilities.add(new Ability("Sever", "Melee", "Any", "Basic", 25, 1.128, Collections.singletonList(new Requirement("Attack", 45))));
        abilities.add(new Ability("Kick", "Melee", "Any", "Basic", 25, 0.6, Collections.singletonList(new Requirement("Strength", 3))));
        abilities.add(new Ability("Stomp", "Melee", "Any", "Threshold", 25, 1.2, Collections.singletonList(new Requirement("Strength", 3))));
        abilities.add(new Ability("Punish", "Melee", "Any", "Basic", 5, 0.564, Collections.singletonList(new Requirement("Strength", 8))));
        abilities.add(new Ability("Dismember", "Melee", "Any", "Basic", 25, 1.206, Collections.singletonList(new Requirement("Strength", 14))));
        abilities.add(new Ability("Fury", "Melee", "Any", "Basic", 9, 1.476, Collections.singletonList(new Requirement("Strength", 24))));
        abilities.add(new Ability("Destroy", "Melee", "Dual", "Threshold", 37, 4.512, Collections.singletonList(new Requirement("Strength", 37))));
        abilities.add(new Ability("Wrack", "Magic", "Any", "Basic", 5, 0.564, new ArrayList<>()));
        abilities.add(new Ability("Asphyxiate", "Magic", "Any", "Threshold", 33, 4.512, Collections.singletonList(new Requirement("Magic", 2))));
        abilities.add(new Ability("Omnipower", "Magic", "Any", "Ultimate", 50, 3, Collections.singletonList(new Requirement("Magic", 2))));
        abilities.add(new Ability("Dragon Breath", "Magic", "Any", "Basic", 17, 1.128, Collections.singletonList(new Requirement("Magic", 5))));
        abilities.add(new Ability("Sonic Wave", "Magic", "Two-handed", "Basic", 8, 0.942, Collections.singletonList(new Requirement("Magic", 8))));
        abilities.add(new Ability("Snap Shot", "Ranged", "Any", "Threshold", 34, 2.65, new ArrayList<>()));
        abilities.add(new Ability("Piercing Shot", "Ranged", "Any", "Basic", 5, 0.564, new ArrayList<>()));
        abilities.add(new Ability("Deadshot", "Ranged", "Any", "Ultimate", 50, 4.258, Collections.singletonList(new Requirement("Ranged", 2))));
        abilities.add(new Ability("Snipe", "Ranged", "Any", "Basic", 17, 1.72, Collections.singletonList(new Requirement("Ranged", 5))));
        abilities.add(new Ability("Dazing Shot", "Ranged", "Two-handed", "Basic", 8, 0.942, Collections.singletonList(new Requirement("Ranged", 8))));
    }

    public static AbilityDatabase getAbilityDatabase() {
        if (abilityDatabase == null) {
            abilityDatabase = new AbilityDatabase();
        }
        return abilityDatabase;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
}
