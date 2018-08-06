package data.databases;

import data.dataobjects.Armour;
import logic.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArmourDatabase {

    private static ArmourDatabase armourDatabase;

    private List<Armour> armours = new ArrayList<>();

    private ArmourDatabase() {addArmours();}

    private void addArmours() {
        armours.add(new Armour("None", "None", "None", 0, 0, 0, 0, 0, new ArrayList<>()));

        /*armours.add(new Armour("Bronze helm", "Melee", "Head", 26, 0, 0, 0.0006, 0, new ArrayList<>()));
        armours.add(new Armour("Iron helm", "Melee", "Head", 36, 0, 0, 0.0016, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Leather cowl", "Ranged", "Head", 30, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather cowl", "Ranged", "Head", 40, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Wizard hat (blue)", "Magic", "Head", 22, 0, 0, 0.0002, 0, new ArrayList<>()));
        armours.add(new Armour("First tower hat", "Magic", "Head", 40, 0, 0, 0.002, 0, new ArrayList<>()));
        armours.add(new Armour("Bronze chainbody", "Melee", "Torso", 29, 0, 0, 0.0006, 0, new ArrayList<>()));
        armours.add(new Armour("Bronze platebody", "Melee", "Torso", 34, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Iron chainbody", "Melee", "Torso", 41, 0, 0, 0.0016, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Iron platebody", "Melee", "Torso", 46, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Leather body", "Ranged", "Torso", 34, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather body", "Ranged", "Torso", 46, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Wizard robe top", "Magic", "Torso", 25, 0, 0, 0.0002, 0, new ArrayList<>()));
        armours.add(new Armour("Bronze platelegs", "Melee", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Bronze plateskirt", "Melee", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Iron platelegs", "Melee", "Legs", 44, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Iron plateskirt", "Melee", "Legs", 44, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Leather chaps", "Ranged", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather chaps", "Ranged", "Legs", 44, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Wizard robe skirt", "Magic", "Legs", 33, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Bronze sq shield", "Melee", "Shield", 26, 0, 0, 0.003, 0, new ArrayList<>()));
        armours.add(new Armour("Iron sq shield", "Melee", "Shield", 36, 0, 0, 0.008, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Leather shield", "Ranged", "Shield", 30, 0, 0, 0.005, 0, new ArrayList<>()));
        armours.add(new Armour("Shieldbow", "Ranged", "Shield", 30, 0, 0, 0.005, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather shield", "Ranged", "Shield", 40, 0, 0, 0.01, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Wizard shield", "Magic", "Shield", 30, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Leather vambraces", "Ranged", "Hands", 5, 0, 0, 0.0002, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather gloves", "Ranged", "Hands", 10, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Wizard gloves", "Magic", "Hands", 7, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide gloves", "Magic", "Hands", 10, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Leather boots", "Ranged", "Feet", 5, 0, 0, 0.0002, 0, new ArrayList<>()));
        armours.add(new Armour("Hard leather boots", "Ranged", "Feet", 7, 0, 0, 0.001, 0, Collections.singletonList(new Requirement("Defense", 10))));
        armours.add(new Armour("Wizard boots", "Magic", "Feet", 7, 0, 0, 0.001, 0, new ArrayList<>()));
        armours.add(new Armour("Imphide boots", "Magic", "Feet", 10, 0, 0, 0.002, 0, Collections.singletonList(new Requirement("Defense", 10))));*/

        //to resolve most battles, more combat tweaking will be done later
        armours.add(new Armour("Achto Teralith Helmet", "Melee", "Head", 491, 420, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Teralith Cuirass", "Melee", "Torso", 565, 840, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Teralith Leggings", "Melee", "Legs", 540, 630, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Teralith Gauntlets", "Melee", "Hands", 122, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Teralith Boots", "Melee", "Feet", 122, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Tempest Cowl", "Ranged", "Head", 491, 420, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Tempest Body", "Ranged", "Torso", 565, 840, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Tempest Chaps", "Ranged", "Legs", 540, 630, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Tempest Gloves", "Ranged", "Hands", 122, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Tempest Boots", "Ranged", "Feet", 122, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Primeval Mask", "Magic", "Head", 491, 420, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Primeval robe top", "Magic", "Torso", 565, 840, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Primeval robe legs", "Magic", "Legs", 540, 630, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Primeval Gloves", "Magic", "Hands", 122, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Achto Primeval Boots", "Magic", "Feet", 122, 0, 0, 0.018, 0, Collections.singletonList(new Requirement("Defense", 90))));
        armours.add(new Armour("Completionist cape", "All", "Cape", 65, 300, 6, 0, 43, Collections.singletonList(new Requirement("Completionist Cape", 1))));
        armours.add(new Armour("Amulet of souls (or)", "All", "Neck", 0, 0, 5, 0, 48, new ArrayList<>()));
        armours.add(new Armour("Superior leviathan ring", "All", "Ring", 43, 0, 0, 0, 15, Collections.singletonList(new Requirement("Defense", 85))));
    }

    public static ArmourDatabase getArmourDatabase() {
        if (armourDatabase == null) {
            armourDatabase = new ArmourDatabase();
        }
        return armourDatabase;
    }


    public List<Armour> getArmours() {
        return armours;
    }
}