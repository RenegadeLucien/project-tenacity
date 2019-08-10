package data.databases;

import data.dataobjects.Weapon;
import logic.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class WeaponDatabase {

    private static WeaponDatabase weaponDatabase;

    private List<Weapon> weapons = new ArrayList<>();
    private Map<String, Weapon> namedWeapons = new LinkedHashMap<>();

    private WeaponDatabase() {addWeapons();}

    private void addWeapons() {

        //Placeholder for when no off-hand is used (e.g. using a two-handed weapon)
        weapons.add(new Weapon("None", "None", "None", "None", 0, 0, 0, 0, 0, 0, new ArrayList<>()));

        //Melee main-hand (done)
        weapons.add(new Weapon("Bone dagger", "Melee", "Stab", "Mainhand", 96, 223, 4, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze scimitar", "Melee", "Slash", "Mainhand", 48, 150, 4, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze mace", "Melee", "Crush", "Mainhand", 48, 150, 4, 0, 1, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze sword", "Melee", "Stab", "Mainhand", 61, 150, 5, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze battleaxe", "Melee", "Slash", "Mainhand", 74, 150, 6, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bone club", "Melee", "Crush", "Mainhand", 223, 257, 6, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Iron claws", "Melee", "Slash", "Mainhand", 96, 202, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron mace", "Melee", "Crush", "Mainhand", 96, 202, 4, 0, 1, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron sword", "Melee", "Stab", "Mainhand", 122, 202, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron longsword", "Melee", "Slash", "Mainhand", 122, 202, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron battleaxe", "Melee", "Slash", "Mainhand", 149, 202, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Steel dagger", "Melee", "Stab", "Mainhand", 192, 316, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel scimitar", "Melee", "Slash", "Mainhand", 192, 316, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel mace", "Melee", "Crush", "Mainhand", 192, 316, 4, 0, 2, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel sword", "Melee", "Stab", "Mainhand", 245, 316, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel longsword", "Melee", "Slash", "Mainhand", 245, 316, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel battleaxe", "Melee", "Slash", "Mainhand", 298, 316, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel warhammer", "Melee", "Crush", "Mainhand", 298, 316, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Black dagger", "Melee", "Stab", "Mainhand", 240, 381, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Black scimitar", "Melee", "Slash", "Mainhand", 240, 381, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Black mace", "Melee", "Crush", "Mainhand", 240, 381, 4, 0, 2, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Black sword", "Melee", "Stab", "Mainhand", 306, 381, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Black longsword", "Melee", "Slash", "Mainhand", 306, 381, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Black battleaxe", "Melee", "Slash", "Mainhand", 372, 381, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Black warhammer", "Melee", "Crush", "Mainhand", 372, 381, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Mithril dagger", "Melee", "Stab", "Mainhand", 288, 454, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril scimitar", "Melee", "Slash", "Mainhand", 288, 454, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril mace", "Melee", "Crush", "Mainhand", 288, 454, 4, 0, 3, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril sword", "Melee", "Stab", "Mainhand", 367, 454, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Excalibur", "Melee", "Slash", "Mainhand", 367, 454, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril battleaxe", "Melee", "Slash", "Mainhand", 447, 454, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril warhammer", "Melee", "Crush", "Mainhand", 447, 454, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Adamant dagger", "Melee", "Stab", "Mainhand", 384, 628, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant scimitar", "Melee", "Slash", "Mainhand", 384, 628, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant mace", "Melee", "Crush", "Mainhand", 384, 628, 4, 0, 3, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant sword", "Melee", "Stab", "Mainhand", 490, 628, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant longsword", "Melee", "Slash", "Mainhand", 490, 628, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant battleaxe", "Melee", "Slash", "Mainhand", 596, 628, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant warhammer", "Melee", "Crush", "Mainhand", 596, 628, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Rune dagger", "Melee", "Stab", "Mainhand", 480, 850, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune claws", "Melee", "Slash", "Mainhand", 480, 850, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune mace", "Melee", "Crush", "Mainhand", 480, 850, 4, 0, 4, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune sword", "Melee", "Stab", "Mainhand", 612, 850, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune longsword", "Melee", "Slash", "Mainhand", 612, 850, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune battleaxe", "Melee", "Slash", "Mainhand", 745, 850, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune warhammer", "Melee", "Crush", "Mainhand", 745, 850, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Granite mace", "Melee", "Crush", "Mainhand", 528, 983, 4, 0, 4, 0, Arrays.asList(new Requirement("Attack", 55), new Requirement("Strength", 55))));
        weapons.add(new Weapon("Gud raider axe", "Melee", "Slash", "Mainhand", 819, 983, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 55))));
        weapons.add(new Weapon("Toktz-xil-ek", "Melee", "Stab", "Mainhand", 576, 1132, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 60))));
        weapons.add(new Weapon("Dragon claw", "Melee", "Slash", "Mainhand", 576, 1132, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 60))));
        weapons.add(new Weapon("Tzhaar-ket-em", "Melee", "Crush", "Mainhand", 576, 1132, 4, 0, 4, 0, Arrays.asList(new Requirement("Attack", 60), new Requirement("Strength", 60))));
        weapons.add(new Weapon("Toktz-xil-ak", "Melee", "Stab", "Mainhand", 735, 1132, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 60))));
        weapons.add(new Weapon("Dragon longsword", "Melee", "Slash", "Mainhand", 735, 1132, 5, 0, 0, 0, Arrays.asList(new Requirement("Attack", 60), new Requirement("Crafting", 31),
            new Requirement("Woodcutting", 36))));
        weapons.add(new Weapon("Abyssal whip", "Melee", "Slash", "Mainhand", 672, 1486, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 70))));
        weapons.add(new Weapon("Crystal dagger", "Melee", "Slash", "Mainhand", 672, 1486, 4, 0, 0, 0, Arrays.asList(new Requirement("Attack", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10), new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Vesta's longsword", "Melee", "Slash", "Mainhand", 955, 1829, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 78))));
        weapons.add(new Weapon("Statius's warhammer", "Melee", "Crush", "Mainhand", 1162, 1829, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 78))));
        weapons.add(new Weapon("Second-Age sword", "Melee", "Crush", "Mainhand", 768, 1924, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 80))));
        weapons.add(new Weapon("Linza's hammer", "Melee", "Crush", "Mainhand", 768, 1924, 4, 0, 0, 0, Arrays.asList(new Requirement("Attack", 80), new Requirement("Herblore", 60),
            new Requirement("Agility", 60), new Requirement("Crafting", 60), new Requirement("Smithing", 60))));
        weapons.add(new Weapon("Khopesh of the Kharidian", "Melee", "Stab", "Mainhand", 787, 2023, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 82))));
        weapons.add(new Weapon("Blade of Nymora", "Melee", "Stab", "Mainhand", 768, 2458, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 85))));
        weapons.add(new Weapon("Ripper claw", "Melee", "Slash", "Mainhand", 816, 2178, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 85))));
        weapons.add(new Weapon("Drygore mace", "Melee", "Crush", "Mainhand", 864, 2458, 4, 0, 9, 0, Collections.singletonList(new Requirement("Attack", 90))));
        weapons.add(new Weapon("Drygore rapier", "Melee", "Stab", "Mainhand", 1102, 2458, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 90))));
        weapons.add(new Weapon("Drygore longsword", "Melee", "Slash", "Mainhand", 1102, 2458, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 90))));
        weapons.add(new Weapon("Khopesh of Tumeken", "Melee", "Stab", "Mainhand", 883, 2577, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 92))));

        //Melee off-hand (done)
        weapons.add(new Weapon("Bronze offhand dagger", "Melee", "Stab", "Off-hand", 24, 150, 4, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze offhand claws", "Melee", "Slash", "Off-hand", 24, 150, 4, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze offhand mace", "Melee", "Crush", "Off-hand", 24, 150, 4, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze offhand sword", "Melee", "Stab", "Off-hand", 30, 150, 5, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze offhand longsword", "Melee", "Slash", "Off-hand", 30, 150, 5, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze offhand battleaxe", "Melee", "Slash", "Off-hand", 37, 150, 6, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze offhand warhammer", "Melee", "Crush", "Off-hand", 37, 150, 6, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Iron offhand dagger", "Melee", "Stab", "Off-hand", 48, 202, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron offhand claws", "Melee", "Slash", "Off-hand", 48, 202, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron offhand mace", "Melee", "Crush", "Off-hand", 48, 202, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron offhand sword", "Melee", "Stab", "Off-hand", 61, 202, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron offhand longsword", "Melee", "Slash", "Off-hand", 61, 202, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron offhand battleaxe", "Melee", "Slash", "Off-hand", 74, 202, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Iron offhand warhammer", "Melee", "Crush", "Off-hand", 74, 202, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Steel offhand dagger", "Melee", "Stab", "Off-hand", 96, 316, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel offhand claws", "Melee", "Slash", "Off-hand", 96, 316, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel offhand mace", "Melee", "Crush", "Off-hand", 96, 316, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel offhand sword", "Melee", "Stab", "Off-hand", 122, 316, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel offhand longsword", "Melee", "Slash", "Off-hand", 122, 316, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel offhand battleaxe", "Melee", "Slash", "Off-hand", 149, 316, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel offhand warhammer", "Melee", "Crush", "Off-hand", 149, 316, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Off-hand black dagger", "Melee", "Stab", "Off-hand", 120, 381, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Off-hand black claw", "Melee", "Slash", "Off-hand", 120, 381, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Off-hand black mace", "Melee", "Crush", "Off-hand", 120, 381, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Off-hand black sword", "Melee", "Stab", "Off-hand", 153, 381, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Off-hand black longsword", "Melee", "Slash", "Off-hand", 153, 381, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Off-hand black battleaxe", "Melee", "Slash", "Off-hand", 186, 381, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Off-hand black warhammer", "Melee", "Crush", "Off-hand", 186, 381, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Mithril offhand dagger", "Melee", "Stab", "Off-hand", 144, 454, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril offhand claws", "Melee", "Slash", "Off-hand", 144, 454, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril offhand mace", "Melee", "Crush", "Off-hand", 144, 454, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril offhand sword", "Melee", "Stab", "Off-hand", 183, 454, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril offhand longsword", "Melee", "Slash", "Off-hand", 183, 454, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril offhand battleaxe", "Melee", "Slash", "Off-hand", 223, 454, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril offhand warhammer", "Melee", "Crush", "Off-hand", 223, 454, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Adamant offhand dagger", "Melee", "Stab", "Off-hand", 192, 628, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant offhand claws", "Melee", "Slash", "Off-hand", 192, 628, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant offhand mace", "Melee", "Crush", "Off-hand", 192, 628, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant offhand sword", "Melee", "Stab", "Off-hand", 245, 628, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant offhand longsword", "Melee", "Slash", "Off-hand", 245, 628, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant offhand battleaxe", "Melee", "Slash", "Off-hand", 298, 628, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant offhand warhammer", "Melee", "Crush", "Off-hand", 298, 628, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Rune offhand dagger", "Melee", "Stab", "Off-hand", 240, 850, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune offhand claws", "Melee", "Slash", "Off-hand", 240, 850, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune offhand mace", "Melee", "Crush", "Off-hand", 240, 850, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune offhand sword", "Melee", "Stab", "Off-hand", 306, 850, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune offhand longsword", "Melee", "Slash", "Off-hand", 306, 850, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune offhand battleaxe", "Melee", "Slash", "Off-hand", 372, 850, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune offhand warhammer", "Melee", "Crush", "Off-hand", 372, 850, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Off-hand dragon dagger", "Melee", "Stab", "Off-hand", 288, 1132, 4, 0, 0, 0, Arrays.asList(new Requirement("Attack", 60), new Requirement("Crafting", 31),
            new Requirement("Woodcutting", 36))));
        weapons.add(new Weapon("Off-hand dragon claw", "Melee", "Slash", "Off-hand", 288, 1132, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 60))));
        weapons.add(new Weapon("Off-hand dragon longsword", "Melee", "Slash", "Off-hand", 367, 1132, 5, 0, 0, 0, Arrays.asList(new Requirement("Attack", 60), new Requirement("Crafting", 31),
            new Requirement("Woodcutting", 36))));
        weapons.add(new Weapon("Off-hand crystal dagger", "Melee", "Slash", "Off-hand", 336, 1486, 4, 0, 0, 0, Arrays.asList(new Requirement("Attack", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10), new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Off-hand khopesh of the Kharidian", "Melee", "Stab", "Off-hand", 393, 2023, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 82))));
        weapons.add(new Weapon("Blade of Avaryss", "Melee", "Stab", "Off-hand", 384, 2458, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 85))));
        weapons.add(new Weapon("Off-hand ripper claw", "Melee", "Slash", "Off-hand", 408, 2178, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 85))));
        weapons.add(new Weapon("Off-hand drygore mace", "Melee", "Crush", "Off-hand", 432, 2458, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 90))));
        weapons.add(new Weapon("Off-hand drygore rapier", "Melee", "Stab", "Off-hand", 551, 2458, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 90))));
        weapons.add(new Weapon("Off-hand drygore longsword", "Melee", "Slash", "Off-hand", 551, 2458, 5, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 90))));
        weapons.add(new Weapon("Khopesh of Elidinis", "Melee", "Stab", "Off-hand", 441, 2577, 4, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 92))));

        //Melee two-hand (done)
        weapons.add(new Weapon("Bronze 2h sword", "Melee", "Slash", "Two-handed", 111, 150, 6, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Iron halberd", "Melee", "Slash", "Two-handed", 223, 202, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 10))));
        weapons.add(new Weapon("Gadderhammer", "Melee", "Crush", "Two-handed", 223, 202, 6, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bone spear", "Melee", "Stab", "Two-handed", 335, 257, 6, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Steel spear", "Melee", "Stab", "Two-handed", 447, 316, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Steel halberd", "Melee", "Slash", "Two-handed", 447, 316, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 20))));
        weapons.add(new Weapon("Black spear", "Melee", "Stab", "Two-handed", 558, 381, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Black halberd", "Melee", "Slash", "Two-handed", 558, 381, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 25))));
        weapons.add(new Weapon("Mithril spear", "Melee", "Stab", "Two-handed", 670, 454, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Mithril 2h sword", "Melee", "Slash", "Two-handed", 670, 454, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 30))));
        weapons.add(new Weapon("Adamant spear", "Melee", "Stab", "Two-handed", 894, 628, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Adamant 2h sword", "Melee", "Slash", "Two-handed", 894, 628, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 40))));
        weapons.add(new Weapon("Rune spear", "Melee", "Stab", "Two-handed", 1117, 850, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Rune 2h sword", "Melee", "Slash", "Two-handed", 1117, 850, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 50))));
        weapons.add(new Weapon("Granite maul", "Melee", "Crush", "Two-handed", 1229, 983, 6, 0, 0, 0, Arrays.asList(new Requirement("Attack", 55), new Requirement("Strength", 55))));
        weapons.add(new Weapon("Dragon spear", "Melee", "Stab", "Two-handed", 1341, 1132, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 60))));
        weapons.add(new Weapon("Dragon 2h sword", "Melee", "Slash", "Two-handed", 1341, 1132, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 60))));
        weapons.add(new Weapon("Tzhaar-ket-om", "Melee", "Crush", "Two-handed", 1341, 1132, 6, 0, 0, 0, Collections.singletonList(new Requirement("Strength", 60))));
        weapons.add(new Weapon("Guthan's warspear", "Melee", "Stab", "Two-handed", 1564, 1486, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 70))));
        weapons.add(new Weapon("Dharok's greataxe", "Melee", "Slash", "Two-handed", 1564, 1486, 6, 0, 0, 0, Arrays.asList(new Requirement("Attack", 70), new Requirement("Strength", 70))));
        weapons.add(new Weapon("Crystal halberd", "Melee", "Slash", "Two-handed", 1564, 1486, 6, 0, 0, 0, Arrays.asList(new Requirement("Attack", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10), new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Verac's flail", "Melee", "Crush", "Two-handed", 1564, 1486, 6, 0, 2, 0, Collections.singletonList(new Requirement("Attack", 70))));
        weapons.add(new Weapon("Zamorakian spear", "Melee", "Stab", "Two-handed", 1676, 1694, 6, 0, 2, 0, Collections.singletonList(new Requirement("Attack", 75))));
        weapons.add(new Weapon("Bandos godsword", "Melee", "Slash", "Two-handed", 1676, 1694, 6, 0, 4, 0, Collections.singletonList(new Requirement("Attack", 75))));
        weapons.add(new Weapon("Saradomin godsword", "Melee", "Slash", "Two-handed", 1676, 1694, 6, 0, 4, 0, Collections.singletonList(new Requirement("Attack", 75))));
        weapons.add(new Weapon("Armadyl godsword", "Melee", "Slash", "Two-handed", 1676, 1694, 6, 0, 4, 0, Collections.singletonList(new Requirement("Attack", 75))));
        weapons.add(new Weapon("Zamorak godsword", "Melee", "Slash", "Two-handed", 1676, 1694, 6, 0, 4, 0, Collections.singletonList(new Requirement("Attack", 75))));
        weapons.add(new Weapon("Saradomin sword", "Melee", "Crush", "Two-handed", 1378, 1694, 5, 0, 2, 0, Collections.singletonList(new Requirement("Attack", 75))));
        weapons.add(new Weapon("Vesta's spear", "Melee", "Stab", "Two-handed", 1743, 1829, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 78))));
        weapons.add(new Weapon("Masuta's warspear", "Melee", "Stab", "Two-handed", 1832, 2023, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 82))));
        weapons.add(new Weapon("Mizuyari", "Melee", "Stab", "Two-handed", 1899, 2178, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 85))));
        weapons.add(new Weapon("Dragon Rider lance", "Melee", "Slash", "Two-handed", 1788, 2458, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 85))));
        weapons.add(new Weapon("Annihilation", "Melee", "Crush", "Two-handed", 1944, 2287, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 87))));
        weapons.add(new Weapon("Noxious scythe", "Melee", "Slash", "Two-handed", 2011, 2458, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 90))));
        weapons.add(new Weapon("Zaros godsword", "Melee", "Slash", "Two-handed", 2056, 2577, 6, 0, 0, 0, Collections.singletonList(new Requirement("Attack", 92))));

        //Ranged main-hand (done)
        weapons.add(new Weapon("Crossbow", "Ranged", "Bolts", "Mainhand", 0, 150, 4, 48, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze knife", "Ranged", "Thrown", "Mainhand", 48, 150, 4, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Bronze javelin", "Ranged", "Thrown", "Mainhand", 74, 150, 6, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Iron crossbow", "Ranged", "Bolts", "Mainhand", 0, 202, 4, 96, 0, 0, Collections.singletonList(new Requirement("Ranged", 10))));
        weapons.add(new Weapon("Iron knife", "Ranged", "Thrown", "Mainhand", 96, 202, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 10))));
        weapons.add(new Weapon("Iron javelin", "Ranged", "Thrown", "Mainhand", 149, 202, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 10))));
        weapons.add(new Weapon("Steel crossbow", "Ranged", "Bolts", "Mainhand", 0, 316, 4, 192, 0, 0, Collections.singletonList(new Requirement("Ranged", 20))));
        weapons.add(new Weapon("Steel dart", "Ranged", "Thrown", "Mainhand", 192, 316, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 20))));
        weapons.add(new Weapon("Steel javelin", "Ranged", "Thrown", "Mainhand", 298, 316, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 20))));
        weapons.add(new Weapon("Black crossbow", "Ranged", "Bolts", "Mainhand", 0, 502, 4, 240, 0, 0, Collections.singletonList(new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Black knife", "Ranged", "Thrown", "Mainhand", 240, 381, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Dorgeshuun crossbow", "Ranged", "Bolts", "Mainhand", 0, 424, 4, 269, 0, 0, Collections.singletonList(new Requirement("Ranged", 28))));
        weapons.add(new Weapon("Mithril crossbow", "Ranged", "Bolts", "Mainhand", 0, 454, 4, 288, 0, 0, Collections.singletonList(new Requirement("Ranged", 30))));
        weapons.add(new Weapon("Mithril dart", "Ranged", "Thrown", "Mainhand", 288, 454, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 30))));
        weapons.add(new Weapon("Mithril javelin", "Ranged", "Thrown", "Mainhand", 447, 454, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 30))));
        weapons.add(new Weapon("Adamant crossbow", "Ranged", "Bolts", "Mainhand", 0, 628, 4, 384, 0, 0, Collections.singletonList(new Requirement("Ranged", 40))));
        weapons.add(new Weapon("Adamant dart", "Ranged", "Thrown", "Mainhand", 384, 628, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 40))));
        weapons.add(new Weapon("Adamant javelin", "Ranged", "Thrown", "Mainhand", 596, 628, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 40))));
        weapons.add(new Weapon("Chinchompa", "Ranged", "Thrown", "Mainhand", 551, 732, 5, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 45))));
        weapons.add(new Weapon("Hunters' crossbow", "Ranged", "Bolts", "Mainhand", 0, 850, 4, 480, 0, 0, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Rune dart", "Ranged", "Thrown", "Mainhand", 480, 850, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Rune javelin", "Ranged", "Thrown", "Mainhand", 745, 850, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Red chinchompa", "Ranged", "Thrown", "Mainhand", 673, 983, 5, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 55))));
        weapons.add(new Weapon("Demon slayer crossbow", "Ranged", "Bolts", "Mainhand", 0, 1040, 4, 547, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Dragon crossbow", "Ranged", "Bolts", "Mainhand", 0, 1132, 4, 576, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Dragon dart", "Ranged", "Thrown", "Mainhand", 576, 1132, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Toktz-xil-ul", "Ranged", "Thrown", "Mainhand", 894, 1132, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Crystal chakram", "Ranged", "Thrown", "Mainhand", 857, 1486, 5, 0, 0, 0, Arrays.asList(new Requirement("Ranged", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10))));
        weapons.add(new Weapon("Karil's pistol crossbow", "Ranged", "Bolts", "Mainhand", 0, 1486, 4, 672, 0, 0, Collections.singletonList(new Requirement("Ranged", 70))));
        weapons.add(new Weapon("Sagaie", "Ranged", "Thrown", "Mainhand", 1072, 1566, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 72))));
        weapons.add(new Weapon("Armadyl crossbow", "Ranged", "Bolts", "Mainhand", 0, 1694, 4, 720, 0, 0, Collections.singletonList(new Requirement("Ranged", 75))));
        weapons.add(new Weapon("Mechanised chinchompa", "Ranged", "Thrown", "Mainhand", 994, 1694, 5, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 75))));
        weapons.add(new Weapon("Morrigan's throwing axe", "Ranged", "Thrown", "Mainhand", 955, 1829, 5, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 78))));
        weapons.add(new Weapon("Morrigan's javelin", "Ranged", "Thrown", "Mainhand", 1162, 1829, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 78))));
        weapons.add(new Weapon("Shadow glaive", "Ranged", "Thrown", "Mainhand", 980, 2458, 5, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 85))));
        weapons.add(new Weapon("Ascension crossbow", "Ranged", "Bolts", "Mainhand", 0, 2458, 4, 864, 0, 0, Collections.singletonList(new Requirement("Ranged", 90))));
        weapons.add(new Weapon("Blightbound crossbow", "Ranged", "Bolts", "Mainhand", 0, 2577, 4, 883, 0, 0, Collections.singletonList(new Requirement("Ranged", 92))));

        //Ranged off-hand (done)
        weapons.add(new Weapon("Off-hand bronze crossbow", "Ranged", "Bolts", "Off-hand", 0, 150, 4, 24, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Off-hand bronze dart", "Ranged", "Thrown", "Off-hand", 24, 150, 4, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Off-hand bronze throwing axe", "Ranged", "Thrown", "Off-hand", 30, 150, 6, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Off-hand iron crossbow", "Ranged", "Bolts", "Off-hand", 0, 202, 4, 48, 0, 0, Collections.singletonList(new Requirement("Ranged", 10))));
        weapons.add(new Weapon("Off-hand iron dart", "Ranged", "Thrown", "Off-hand", 48, 202, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 10))));
        weapons.add(new Weapon("Off-hand iron throwing axe", "Ranged", "Thrown", "Off-hand", 61, 202, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 10))));
        weapons.add(new Weapon("Off-hand steel crossbow", "Ranged", "Bolts", "Off-hand", 0, 316, 4, 96, 0, 0, Collections.singletonList(new Requirement("Ranged", 20))));
        weapons.add(new Weapon("Off-hand steel dart", "Ranged", "Thrown", "Off-hand", 96, 316, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 20))));
        weapons.add(new Weapon("Off-hand steel throwing axe", "Ranged", "Thrown", "Off-hand", 122, 316, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 20))));
        weapons.add(new Weapon("Off-hand black crossbow", "Ranged", "Bolts", "Off-hand", 0, 502, 4, 120, 0, 0, Collections.singletonList(new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Off-hand black knife", "Ranged", "Thrown", "Off-hand", 120, 381, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Off-hand mithril crossbow", "Ranged", "Bolts", "Off-hand", 0, 454, 4, 144, 0, 0, Collections.singletonList(new Requirement("Ranged", 30))));
        weapons.add(new Weapon("Off-hand mithril dart", "Ranged", "Thrown", "Off-hand", 144, 454, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 30))));
        weapons.add(new Weapon("Off-hand mithril throwing axe", "Ranged", "Thrown", "Off-hand", 183, 454, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 30))));
        weapons.add(new Weapon("Off-hand adamant crossbow", "Ranged", "Bolts", "Off-hand", 0, 628, 4, 192, 0, 0, Collections.singletonList(new Requirement("Ranged", 40))));
        weapons.add(new Weapon("Off-hand adamant dart", "Ranged", "Thrown", "Off-hand", 192, 628, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 40))));
        weapons.add(new Weapon("Off-hand adamant throwing axe", "Ranged", "Thrown", "Off-hand", 245, 628, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 40))));
        weapons.add(new Weapon("Off-hand rune crossbow", "Ranged", "Bolts", "Off-hand", 0, 850, 4, 240, 0, 0, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Off-hand rune dart", "Ranged", "Thrown", "Off-hand", 240, 850, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Off-hand rune throwing axe", "Ranged", "Thrown", "Off-hand", 306, 850, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Off-hand demon slayer crossbow", "Ranged", "Bolts", "Off-hand", 0, 1040, 4, 274, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Off-hand dragon crossbow", "Ranged", "Bolts", "Off-hand", 0, 1132, 4, 288, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Off-hand dragon dart", "Ranged", "Thrown", "Off-hand", 288, 1132, 4, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Off-hand dragon javelin", "Ranged", "Thrown", "Off-hand", 447, 1132, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Off-hand crystal chakram", "Ranged", "Thrown", "Off-hand", 428, 1486, 5, 0, 0, 0, Arrays.asList(new Requirement("Ranged", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10))));
        weapons.add(new Weapon("Karil's off-hand pistol crossbow", "Ranged", "Bolts", "Off-hand", 0, 1486, 4, 336, 0, 0, Collections.singletonList(new Requirement("Ranged", 70))));
        weapons.add(new Weapon("Off-hand Armadyl crossbow", "Ranged", "Bolts", "Off-hand", 0, 1694, 4, 360, 0, 0, Collections.singletonList(new Requirement("Ranged", 75))));
        weapons.add(new Weapon("Off-hand shadow glaive", "Ranged", "Thrown", "Off-hand", 490, 2458, 5, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 85))));
        weapons.add(new Weapon("Off-hand Ascension crossbow", "Ranged", "Bolts", "Off-hand", 0, 2458, 4, 432, 0, 0, Collections.singletonList(new Requirement("Ranged", 90))));
        weapons.add(new Weapon("Off-hand Blightbound crossbow", "Ranged", "Bolts", "Off-hand", 0, 2577, 4, 441, 0, 0, Collections.singletonList(new Requirement("Ranged", 92))));

        //Ranged two-hand (done)
        weapons.add(new Weapon("Chargebow", "Ranged", "Arrows", "Two-handed", 91, 150, 5, 0, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Shieldbow", "Ranged", "Arrows", "Two-handed", 26, 150, 6, 48, 0, 30, new ArrayList<>()));
        weapons.add(new Weapon("Bronze 2h crossbow", "Ranged", "Bolts", "Two-handed", 63, 150, 6, 48, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Oak shortbow", "Ranged", "Arrows", "Two-handed", 87, 202, 5, 96, 0, 0, Collections.singletonList(new Requirement("Ranged", 10))));
        weapons.add(new Weapon("Oak shieldbow", "Ranged", "Arrows", "Two-handed", 53, 202, 6, 96, 0, 40, Arrays.asList(new Requirement("Ranged", 10), new Requirement("Defence", 10))));
        weapons.add(new Weapon("Iron 2h crossbow", "Ranged", "Bolts", "Two-handed", 127, 202, 6, 96, 0, 0, Collections.singletonList(new Requirement("Ranged", 10))));
        weapons.add(new Weapon("Willow shortbow", "Ranged", "Arrows", "Two-handed", 175, 316, 5, 192, 0, 0, Collections.singletonList(new Requirement("Ranged", 20))));
        weapons.add(new Weapon("Willow shieldbow", "Ranged", "Arrows", "Two-handed", 106, 316, 6, 192, 0, 63, Arrays.asList(new Requirement("Ranged", 20), new Requirement("Defence", 20))));
        weapons.add(new Weapon("Willow composite bow", "Ranged", "Arrows", "Two-handed", 106, 316, 6, 192, 0, 63, Collections.singletonList(new Requirement("Ranged", 20))));
        weapons.add(new Weapon("Steel 2h crossbow", "Ranged", "Bolts", "Two-handed", 255, 316, 6, 192, 0, 0, Collections.singletonList(new Requirement("Ranged", 20))));
        weapons.add(new Weapon("Black 2h crossbow", "Ranged", "Bolts", "Two-handed", 318, 381, 6, 240, 0, 0, Collections.singletonList(new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Maple shortbow", "Ranged", "Arrows", "Two-handed", 263, 454, 5, 288, 0, 0, Collections.singletonList(new Requirement("Ranged", 30))));
        weapons.add(new Weapon("Maple shieldbow", "Ranged", "Arrows", "Two-handed", 159, 454, 6, 288, 0, 90, Arrays.asList(new Requirement("Ranged", 30), new Requirement("Defence", 30))));
        weapons.add(new Weapon("Swamp lizard", "Ranged", "Bolts", "Two-handed", 397, 454, 6, 288, 0, 0, Collections.singletonList(new Requirement("Ranged", 30))));
        weapons.add(new Weapon("Yew shortbow", "Ranged", "Arrows", "Two-handed", 351, 628, 5, 384, 0, 0, Collections.singletonList(new Requirement("Ranged", 40))));
        weapons.add(new Weapon("Yew shieldbow", "Ranged", "Arrows", "Two-handed", 212, 628, 6, 384, 0, 125, Arrays.asList(new Requirement("Ranged", 40), new Requirement("Defence", 40))));
        weapons.add(new Weapon("Yew composite bow", "Ranged", "Arrows", "Two-handed", 212, 628, 6, 384, 0, 125, Collections.singletonList(new Requirement("Ranged", 40))));
        weapons.add(new Weapon("Adamant 2h crossbow", "Ranged", "Bolts", "Two-handed", 510, 628, 6, 384, 0, 0, Collections.singletonList(new Requirement("Ranged", 40))));
        weapons.add(new Weapon("Seercull", "Ranged", "Arrows", "Two-handed", 249, 901, 4, 499, 0, 0, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Magic shortbow", "Ranged", "Arrows", "Two-handed", 438, 850, 5, 480, 0, 0, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Magic shieldbow", "Ranged", "Arrows", "Two-handed", 265, 850, 6, 480, 0, 170, Arrays.asList(new Requirement("Ranged", 50), new Requirement("Defence", 50))));
        weapons.add(new Weapon("Magic composite bow", "Ranged", "Arrows", "Two-handed", 265, 850, 6, 480, 0, 170, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Orange salamander", "Ranged", "Bolts", "Two-handed", 662, 850, 6, 480, 0, 0, Collections.singletonList(new Requirement("Ranged", 50))));
        weapons.add(new Weapon("Guthix bow", "Ranged", "Arrows", "Two-handed", 291, 983, 6, 528, 2, 179, Arrays.asList(new Requirement("Ranged", 55), new Requirement("Defence", 55))));
        weapons.add(new Weapon("Elder shortbow", "Ranged", "Arrows", "Two-handed", 526, 1132, 5, 576, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Elder shieldbow", "Ranged", "Arrows", "Two-handed", 318, 1132, 6, 576, 0, 226, Arrays.asList(new Requirement("Ranged", 60), new Requirement("Defence", 60))));
        weapons.add(new Weapon("Red salamander", "Ranged", "Bolts", "Two-handed", 765, 1132, 6, 576, 0, 0, Collections.singletonList(new Requirement("Ranged", 60))));
        weapons.add(new Weapon("Crystal bow", "Ranged", "Arrows", "Two-handed", 1286, 1486, 5, 0, 0, 0, Arrays.asList(new Requirement("Ranged", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10))));
        weapons.add(new Weapon("Dark bow", "Ranged", "Arrows", "Two-handed", 318, 1486, 6, 672, 0, 297, Arrays.asList(new Requirement("Ranged", 70), new Requirement("Defence", 70))));
        weapons.add(new Weapon("Black salamander", "Ranged", "Bolts", "Two-handed", 892, 1486, 6, 672, 0, 0, Collections.singletonList(new Requirement("Ranged", 70))));
        weapons.add(new Weapon("Hexhunter bow", "Ranged", "Arrows", "Two-handed", 384, 1924, 4, 768, 0, 0, Collections.singletonList(new Requirement("Ranged", 80))));
        weapons.add(new Weapon("Zaryte bow", "Ranged", "Arrows", "Two-handed", 1470, 1924, 5, 0, 2, 0, Collections.singletonList(new Requirement("Ranged", 80))));
        weapons.add(new Weapon("Second-Age bow", "Ranged", "Arrows", "Two-handed", 1020, 1924, 6, 768, 0, 0, Collections.singletonList(new Requirement("Ranged", 80))));
        weapons.add(new Weapon("Wyvern crossbow", "Ranged", "Bolts", "Two-handed", 1083, 2178, 6, 816, 0, 0, Collections.singletonList(new Requirement("Ranged", 85))));
        weapons.add(new Weapon("Decimation", "Ranged", "Arrows", "Two-handed", 1598, 2287, 5, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 87))));
        weapons.add(new Weapon("Noxious longbow", "Ranged", "Arrows", "Two-handed", 1147, 2458, 6, 864, 0, 0, Collections.singletonList(new Requirement("Ranged", 90))));
        weapons.add(new Weapon("Seren godbow", "Ranged", "Arrows", "Two-handed", 2056, 2577, 6, 0, 0, 0, Collections.singletonList(new Requirement("Ranged", 92))));

        //Magic main-hand (done)
        weapons.add(new Weapon("Wizard wand", "Magic", "Magic", "Mainhand", 0, 150, 4, 48, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Imp horn wand", "Magic", "Magic", "Mainhand", 0, 202, 4, 96, 0, 0, Collections.singletonList(new Requirement("Magic", 10))));
        weapons.add(new Weapon("Spider wand", "Magic", "Magic", "Mainhand", 0, 316, 4, 192, 0, 0, Collections.singletonList(new Requirement("Magic", 20))));
        weapons.add(new Weapon("Batwing wand", "Magic", "Magic", "Mainhand", 0, 454, 4, 288, 0, 0, Collections.singletonList(new Requirement("Magic", 30))));
        weapons.add(new Weapon("Splitbark wand", "Magic", "Magic", "Mainhand", 0, 628, 4, 384, 0, 0, Collections.singletonList(new Requirement("Magic", 40))));
        weapons.add(new Weapon("Beginner wand", "Magic", "Magic", "Mainhand", 0, 732, 4, 432, 0, 0, Collections.singletonList(new Requirement("Magic", 45))));
        weapons.add(new Weapon("Mystic wand", "Magic", "Magic", "Mainhand", 0, 850, 4, 480, 0, 0, Collections.singletonList(new Requirement("Magic", 50))));
        weapons.add(new Weapon("Teacher wand", "Magic", "Magic", "Mainhand", 0, 983, 4, 528, 0, 0, Collections.singletonList(new Requirement("Magic", 55))));
        weapons.add(new Weapon("Grifolic wand", "Magic", "Magic", "Mainhand", 0, 1132, 4, 576, 0, 0, Collections.singletonList(new Requirement("Magic", 60))));
        weapons.add(new Weapon("Wand of treachery", "Magic", "Magic", "Mainhand", 0, 1486, 4, 672, 0, 0, Collections.singletonList(new Requirement("Magic", 70))));
        weapons.add(new Weapon("Abyssal wand", "Magic", "Magic", "Mainhand", 0, 1694, 4, 720, 0, 0, Collections.singletonList(new Requirement("Magic", 75))));
        weapons.add(new Weapon("Virtus wand", "Magic", "Magic", "Mainhand", 0, 1924, 4, 768, 2, 0, Collections.singletonList(new Requirement("Magic", 80))));
        weapons.add(new Weapon("Wand of the Cywir elders", "Magic", "Magic", "Mainhand", 0, 2458, 4, 768, 0, 0, Collections.singletonList(new Requirement("Magic", 85))));
        weapons.add(new Weapon("Seismic wand", "Magic", "Magic", "Mainhand", 0, 2458, 4, 864, 0, 0, Collections.singletonList(new Requirement("Magic", 90))));
        weapons.add(new Weapon("Wand of the praesul", "Magic", "Magic", "Mainhand", 0, 2577, 4, 883, 0, 0, Collections.singletonList(new Requirement("Magic", 92))));

        //Magic off-hand (done)
        weapons.add(new Weapon("Wizard book", "Magic", "Magic", "Off-hand", 0, 110, 4, 24, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("Imphide book", "Magic", "Magic", "Off-hand", 0, 202, 4, 48, 0, 0, Collections.singletonList(new Requirement("Magic", 10))));
        weapons.add(new Weapon("Spider orb", "Magic", "Magic", "Off-hand", 0, 316, 4, 96, 0, 0, Collections.singletonList(new Requirement("Magic", 20))));
        weapons.add(new Weapon("Batwing book", "Magic", "Magic", "Off-hand", 0, 454, 4, 144, 0, 0, Collections.singletonList(new Requirement("Magic", 30))));
        weapons.add(new Weapon("Splitbark orb", "Magic", "Magic", "Off-hand", 0, 628, 4, 192, 0, 0, Collections.singletonList(new Requirement("Magic", 40))));
        weapons.add(new Weapon("Mystic orb", "Magic", "Magic", "Off-hand", 0, 850, 4, 240, 0, 0, Collections.singletonList(new Requirement("Magic", 50))));
        weapons.add(new Weapon("Grifolic orb", "Magic", "Magic", "Off-hand", 0, 1132, 4, 288, 0, 0, Collections.singletonList(new Requirement("Magic", 60))));
        weapons.add(new Weapon("Ahrim's book of magic", "Magic", "Magic", "Off-hand", 0, 1486, 4, 336, 0, 0, Collections.singletonList(new Requirement("Magic", 70))));
        weapons.add(new Weapon("Crystal orb", "Magic", "Magic", "Off-hand", 0, 1486, 4, 336, 0, 0, Arrays.asList(new Requirement("Magic", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10), new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Abyssal orb", "Magic", "Magic", "Off-hand", 0, 1694, 4, 360, 0, 0, Collections.singletonList(new Requirement("Magic", 75))));
        weapons.add(new Weapon("Virtus book", "Magic", "Magic", "Off-hand", 0, 1924, 4, 384, 2, 0, Collections.singletonList(new Requirement("Magic", 80))));
        weapons.add(new Weapon("Orb of the Cywir elders", "Magic", "Magic", "Off-hand", 0, 2458, 4, 384, 0, 0, Collections.singletonList(new Requirement("Magic", 85))));
        weapons.add(new Weapon("Seismic singularity", "Magic", "Magic", "Off-hand", 0, 2458, 4, 432, 0, 0, Collections.singletonList(new Requirement("Magic", 90))));
        weapons.add(new Weapon("Imperium core", "Magic", "Magic", "Off-hand", 0, 2577, 4, 441, 0, 0, Collections.singletonList(new Requirement("Magic", 92))));

        //Magic two-hand (done)
        weapons.add(new Weapon("Staff", "Magic", "Magic", "Two-handed", 0, 150, 6, 112, 0, 0, new ArrayList<>()));
        weapons.add(new Weapon("White magic staff", "Magic", "Magic", "Two-handed", 0, 381, 6, 559, 0, 0, Arrays.asList(new Requirement("Magic", 25), new Requirement("Herblore", 3),
            new Requirement("Agility", 13), new Requirement("Mining", 17), new Requirement("Thieving", 13))));
        weapons.add(new Weapon("Air battlestaff", "Magic", "Magic", "Two-handed", 0, 454, 6, 671, 0, 0, Collections.singletonList(new Requirement("Magic", 30))));
        weapons.add(new Weapon("Mystic air staff", "Magic", "Magic", "Two-handed", 0, 628, 6, 894, 0, 0, Collections.singletonList(new Requirement("Magic", 40))));
        weapons.add(new Weapon("Slayer's staff", "Magic", "Magic", "Two-handed", 0, 850, 6, 1118, 0, 0, Arrays.asList(new Requirement("Magic", 50), new Requirement("Slayer", 55))));
        weapons.add(new Weapon("Toktz-mej-tal", "Magic", "Magic", "Two-handed", 0, 1132, 6, 1341, 2, 0, Collections.singletonList(new Requirement("Magic", 60))));
        weapons.add(new Weapon("Ahrim's staff", "Magic", "Magic", "Two-handed", 0, 1486, 6, 1565, 0, 0, Collections.singletonList(new Requirement("Magic", 70))));
        weapons.add(new Weapon("Crystal staff", "Magic", "Magic", "Two-handed", 0, 1486, 6, 1565, 0, 0, Arrays.asList(new Requirement("Magic", 70), new Requirement("Agility", 56),
            new Requirement("Crafting", 10), new Requirement("Ranged", 25))));
        weapons.add(new Weapon("Staff of light", "Magic", "Magic", "Two-handed", 0, 1694, 6, 1676, 0, 0, Collections.singletonList(new Requirement("Magic", 75))));
        weapons.add(new Weapon("Armadyl battlestaff", "Magic", "Magic", "Two-handed", 0, 1783, 6, 1721, 0, 0, Collections.singletonList(new Requirement("Magic", 77))));
        weapons.add(new Weapon("Zuriel's staff", "Magic", "Magic", "Two-handed", 0, 1829, 6, 1743, 0, 0, Collections.singletonList(new Requirement("Magic", 78))));
        weapons.add(new Weapon("Second-Age staff", "Magic", "Magic", "Two-handed", 0, 1924, 6, 1788, 0, 0, Collections.singletonList(new Requirement("Magic", 80))));
        weapons.add(new Weapon("Camel staff", "Magic", "Magic", "Two-handed", 0, 2178, 6, 1900, 0, 0, Collections.singletonList(new Requirement("Magic", 85))));
        weapons.add(new Weapon("Staff of darkness", "Magic", "Magic", "Two-handed", 0, 2178, 6, 1900, 0, 0, Collections.singletonList(new Requirement("Magic", 85))));
        weapons.add(new Weapon("Obliteration", "Magic", "Magic", "Two-handed", 0, 2287, 6, 1944, 0, 0, Collections.singletonList(new Requirement("Magic", 87))));
        weapons.add(new Weapon("Noxious staff", "Magic", "Magic", "Two-handed", 0, 2458, 6, 2012, 0, 0, Collections.singletonList(new Requirement("Magic", 90))));
        weapons.add(new Weapon("Staff of Sliske", "Magic", "Magic", "Two-handed", 0, 2577, 6, 2056, 0, 0, Collections.singletonList(new Requirement("Magic", 92))));

        for (Weapon weapon : weapons) {
            namedWeapons.put(weapon.getName(), weapon);
        }
    }

    public static WeaponDatabase getWeaponDatabase() {
        if (weaponDatabase == null) {
            weaponDatabase = new WeaponDatabase();
        }
        return weaponDatabase;
    }


    public Map<String, Weapon> getWeapons() {
        return namedWeapons;
    }
}
