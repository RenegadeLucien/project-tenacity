package staticdata;

import dynamicdata.CombatResults;
import dynamicdata.Loadout;
import dynamicdata.Player;

import java.util.*;
import java.util.Map.Entry;

public enum Enemy {
    COW("Cow", 25, 5, 1.6, 1, 0, 0, 1, 1, 1, 4, 110, 0, 0, 110, 1, "Air", 90, 55, 45, 65),
    CHICKEN("Chicken", 50, 24.9, 8.2, 4, 0, 0, 1, 1, 1, 4, 110, 0, 0, 110, 1, "Fire", 90, 55, 45, 65),
    DUCK("Duck", 50, 24.9, 8.2, 4, 0, 0, 1, 0, 0, 4, 110, 0, 0, 110, 1, "Earth", 90, 55, 45, 65),
    JONNY_THE_BEARD("Jonny the beard", 100, 37.3, 12.3, 4, 0, 0, 1, 0, 0, 4, 110, 0, 0, 110, 1, "Fire", 90, 55, 45, 65),
    BANDIT("Bandit", 100, 0, 0, 72, 0, 0, 5, 0, 0, 4, 150, 0, 0, 0, 5, "Crush", 90, 55, 45, 65),
    SHADOW("Shadow", 100, 3.7, 1.2, 272, 0, 0, 68, 0, 0, 4, 1409, 0, 0, 1409, 68, "Air", 90, 55, 45, 65),
    SHADOW_PE("Shadow (Plague's End)", 100, 220.3, 72.6, 1008, 0, 0, 70, 0, 0, 4, 1694, 0, 0, 1486, 70, "Fire", 90, 55, 45, 65),
    BROKEFACE("Brokeface", 120, 12.7, 4.1, 12, 0, 0, 2, 1, 1, 6, 12, 0, 0, 0, 5, "Crush", 90, 55, 45, 65),
    CHOLERIC_IMP("Choleric imp", 200, 0, 0, 16, 0, 0, 4, 0, 0, 4, 140, 0, 0, 140, 4, "Water", 90, 55, 45, 65),
    BANDIT_KING("Bandit king", 200, 0, 0, 72, 0, 0, 5, 0, 0, 4, 150, 0, 0, 0, 5, "Crush", 90, 55, 45, 65),
    GOBLIN("Goblin", 200, 25.8, 8.5, 24, 0, 0, 4, 0, 0, 6, 140, 0, 0, 140, 4, "Fire", 90, 55, 45, 65),
    GOAT("Goat", 250, 26.7, 8.8, 20, 0, 0, 5, 0, 0, 4, 150, 0, 0, 150, 5, "Air", 90, 55, 45, 65),
    WIGHT_RANGER("Wight ranger", 250, 26.7, 8.8, 0, 27, 0, 0, 5, 0, 6, 0, 150, 0, 150, 5, "Slash", 90, 65, 55, 45),
    GIANT_RAT("Giant rat", 250, 26.7, 8.8, 20, 0, 0, 5, 0, 0, 4, 150, 0, 0, 150, 5, "Earth", 90, 55, 45, 65),
    WIGHT("Wight", 350, 26.7, 8.8, 25, 0, 0, 5, 0, 0, 5, 150, 0, 0, 150, 5, "Air", 90, 55, 45, 65),
    WIGHT_FOOTSOLDIER("Wight footsoldier", 375, 26.7, 8.8, 12, 0, 0, 5, 0, 0, 3, 150, 0, 0, 150, 5, "Fire", 90, 55, 45, 65),
    SKULLS_MERCENARY("Skulls mercenary", 400, 0, 0, 14, 0, 0, 1, 0, 0, 4, 110, 0, 0, 110, 1, "None", 0, 60, 60, 60),
    HIGHWAYMAN("Highwayman", 400, 29.7, 9.8, 32, 0, 0, 8, 0, 0, 4, 181, 0, 0, 181, 8, "Water", 90, 55, 45, 65),
    ZOMBIE("Zombie", 450, 30.9, 10.1, 36, 0, 0, 9, 0, 0, 4, 191, 0, 0, 191, 9, "Fire", 90, 55, 45, 65),
    SIR_LEYE("Sir Leye", 500, 40, 13.2, 10, 0, 0, 5, 0, 0, 5, 150, 0, 0, 110, 5, "Fire", 90, 55, 45, 65),
    APEP("Apep", 500, 0, 0, 72, 0, 0, 5, 0, 0, 4, 150, 0, 0, 150, 5, "Crush", 90, 55, 45, 65),
    HERU("Heru", 500, 0, 0, 91, 0, 0, 5, 0, 0, 5, 150, 0, 0, 150, 5, "Crush", 90, 55, 45, 65),
    BAT("Bat", 500, 32.1, 10.5, 0, 0, 40, 0, 0, 10, 4, 0, 0, 202, 202, 10, "Bolts", 90, 45, 65, 55),
    TOWER_ARCHER_NORTH("Tower Archer (north)", 500, 32.1, 10.5, 0, 40, 0, 0, 10, 0, 4, 0, 202, 0, 202, 10, "Stab", 90, 65, 55, 45),
    HUMAN_WEREWOLF("Human werewolf", 1000, 44.4, 14.6, 100, 0, 0, 20, 0, 0, 5, 316, 0, 0, 316, 20, "Fire", 90, 55, 45, 65),
    TOWER_ARCHER_EAST("Tower Archer (east)", 1000, 44.4, 14.6, 0, 80, 0, 0, 20, 0, 4, 0, 316, 0, 316, 20, "Stab", 90, 65, 55, 45),
    BLACK_UNICORN("Black unicorn", 1200, 51.9, 17.1, 0, 0, 96, 0, 0, 24, 4, 0, 0, 368, 368, 24, "Arrows", 90, 45, 65, 55),
    EXPERIMENT("Experiment", 1250, 54, 17.8, 100, 0, 0, 25, 0, 0, 4, 381, 0, 0, 381, 25, "Fire", 90, 55, 45, 65),
    TOWER_ARCHER_SOUTH("Tower Archer (south)", 1500, 66.9, 22, 0, 120, 0, 0, 30, 0, 4, 0, 454, 0, 454, 30, "Stab", 90, 65, 55, 45),
    REVENANT_IMP("Revenant imp", 1500, 64.2, 21.1, 225, 225, 225, 10, 10, 10, 5, 202, 202, 202, 202, 10, "Nothing", 0, 40, 40, 40),
    GNOME_TROOP("Gnome troop", 1600, 72.6, 23.9, 0, 128, 0, 0, 32, 0, 4, 0, 486, 0, 486, 32, "Slash", 90, 65, 55, 45),
    AIR_ELEMENTAL("Air elemental", 1600, 72.6, 23.9, 0, 192, 0, 0, 32, 0, 4, 0, 486, 0, 486, 32, "Slash", 90, 65, 55, 45),
    WATER_ELEMENTAL("Water elemental", 1600, 72.6, 23.9, 0, 192, 0, 0, 32, 0, 4, 0, 486, 0, 486, 32, "Slash", 90, 65, 55, 45),
    EARTH_ELEMENTAL("Earth elemental", 1600, 72.6, 23.9, 192, 0, 0, 32, 0, 0, 6, 486, 0, 0, 486, 32, "Water", 90, 55, 45, 65),
    FIRE_ELEMENTAL("Fire elemental", 1600, 72.6, 23.9, 0, 0, 192, 0, 0, 32, 4, 0, 0, 486, 486, 32, "Arrows", 90, 45, 65, 55),
    DISCIPLE_OF_IBAN("Disciple of Iban", 1600, 72.6, 23.9, 0, 0, 128, 0, 0, 32, 4, 0, 0, 486, 486, 32, "Arrows", 90, 45, 65, 55),
    SIR_MORDRED("Sir Mordred", 1700, 59.4, 19.6, 68, 0, 0, 17, 0, 0, 4, 280, 0, 0, 280, 17, "Water", 90, 55, 45, 65),
    REVENANT_GOBLIN("Revenant goblin", 1800, 71.4, 23.5, 270, 270, 270, 12, 12, 12, 5, 223, 223, 223, 223, 12, "Nothing", 0, 40, 40, 40),
    KHAZARD_WARLORD("Khazard warlord", 1900, 95.4, 31.4, 152, 0, 0, 38, 0, 0, 4, 590, 0, 0, 590, 38, "Air", 90, 55, 45, 65),
    CAVE_CRAWLER("Cave crawler", 1900, 95.4, 31.4, 0, 152, 0, 0, 38, 0, 4, 0, 590, 0, 590, 38, "Slash", 90, 65, 55, 45),
    MOGRE("Mogre", 1950, 99.3, 32.7, 156, 0, 0, 39, 0, 0, 4, 609, 0, 0, 609, 39, "Air", 90, 55, 45, 65),
    WITCHS_EXPERIMENT_1("Witch's experiment 1", 2000, 89.2, 29.4, 172, 0, 0, 12, 0, 0, 4, 223, 0, 0, 223, 12, "Water", 90, 55, 45, 65),
    TOWER_ARCHER_WEST("Tower Archer (west)", 2000, 103.8, 34.2, 0, 160, 0, 0, 40, 0, 4, 0, 628, 0, 628, 40, "Stab", 90, 65, 55, 45),
    UNICOW("Unicow", 2050, 108.9, 35.9, 0, 0, 164, 0, 0, 41, 4, 0, 0, 648, 648, 41, "Bolts", 90, 45, 65, 55),
    BROODOO_VICTIM("Broodoo victim", 2150, 119.7, 39.5, 172, 0, 0, 43, 0, 0, 4, 689, 0, 0, 689, 43, "Fire", 90, 55, 45, 65),
    SWORDCHICK("Swordchick", 2250, 132, 43.5, 180, 0, 0, 45, 0, 0, 4, 732, 0, 0, 732, 45, "Water", 90, 55, 45, 65),
    SHADOW_WARRIOR("Shadow warrior", 2350, 145.2, 47.9, 188, 0, 0, 47, 0, 0, 4, 778, 0, 0, 778, 47, "Air", 90, 55, 45, 65),
    FROGEEL("Frogeel", 2450, 159.3, 52.5, 0, 196, 0, 0, 49, 0, 4, 0, 825, 0, 825, 49, "Crush", 90, 65, 55, 45),
    ICE_TROLL_MALE("Ice troll male", 2450, 159.3, 52.5, 196, 0, 0, 49, 0, 0, 4, 825, 0, 0, 825, 49, "Fire", 90, 55, 45, 65),
    BLACK_KNIGHT_TITAN("Black Knight Titan", 2500, 63.9, 21, 120, 0, 0, 20, 0, 0, 7, 316, 0, 0, 316, 20, "Nothing", 0, 20, 10, 40),
    GHAST("Ghast", 2500, 81, 26.7, 150, 0, 0, 25, 0, 0, 4, 381, 0, 0, 381, 25, "Fire", 90, 55, 45, 65),
    ROCK_CRAB("Rock Crab", 2550, 232.5, 76.7, 204, 0, 0, 51, 0, 0, 6, 875, 0, 0, 875, 51, "Water", 90, 55, 45, 65),
    DEATH_WING("Death wing", 2750, 211.5, 69.7, 220, 0, 220, 55, 0, 55, 4, 983, 0, 983, 983, 55, "Arrows", 90, 45, 65, 55),
    DAGANNOTH("Dagannoth", 2800, 221.7, 73.1, 224, 0, 0, 56, 0, 0, 4, 1011, 0, 0, 1011, 56, "Earth", 90, 55, 45, 65),
    MOURNER("Mourner", 2850, 233.1, 76.9, 228, 0, 0, 57, 0, 0, 4, 1040, 0, 0, 1040, 57, "Fire", 90, 55, 45, 65),
    COUNT_DRAYNOR("Count Draynor", 3000, 22.2, 7.3, 300, 0, 0, 20, 0, 0, 6, 316, 0, 0, 316, 20, "Fire", 90, 55, 45, 65),
    CYWIR_ALPHA("Cywir Alpha", 3000, 211.5, 69.7, 792, 0, 0, 55, 0, 0, 4, 983, 0, 0, 983, 55, "Water", 90, 55, 45, 65),
    RUM_PUMPED_CRAB("'Rum'-pumped crab", 3000, 269.4, 88.9, 240,  0, 0, 60, 0, 0, 4, 1132, 0, 0, 1132, 60, "Stab", 90, 65, 55, 45),
    TZ_KIH("Tz-Kih", 3000, 141.6, 46.7, 244, 0, 0, 61, 0, 0, 4, 1164, 0, 0, 1164, 61, "Water", 90, 55, 45, 65),
    ELF_WARRIOR("Elf warrior", 3000, 269.4, 88.9, 240, 0, 0, 60, 0, 0, 4, 1132, 0, 0, 1132, 60, "Fire", 90, 55, 45, 65),
    ICE_GIANT("Ice Giant", 3700, 136.3, 44.9, 185, 0, 0, 37, 0, 0, 5, 571, 0, 0, 571, 37, "Fire", 90, 55, 45, 65),
    WITCHS_EXPERIMENT_2("Witch's experiment 2", 4000, 99, 32.6, 244, 0, 0, 17, 0, 0, 4, 280, 0, 0, 280, 17, "Water", 90, 55, 45, 65),
    REVENANT_ICEFIEND("Revenant icefiend", 4050, 117, 38.6, 607, 607, 607, 27, 27, 27, 5, 409, 409, 409, 409, 27, "Nothing", 0, 40, 40, 40),
    JOGRE("Jogre", 4100, 163.3, 53.8, 246, 0, 0, 41, 0, 0, 6, 648, 0, 0, 648, 41, "Water", 90, 55, 45, 65),
    REVENANT_PYREFIEND("Revenant pyrefiend", 4350, 129, 42.5, 652, 652, 652, 29, 29, 29, 5, 439, 439, 439, 439, 29, "Nothing", 0, 40, 40, 40),
    TORMENTED_WRAITH("Tormented wraith", 4500, 100.1, 33, 0, 0, 120, 0, 0, 40, 4, 0, 0, 628, 628, 40, "Bolts", 90, 45, 65, 55),
    REVENANT_HOBGOBLIN("Revenant hobgoblin", 4800, 145.2, 47.9, 720, 720, 720, 32, 32, 32, 5, 486, 486, 486, 486, 32, "Nothing", 0, 40, 40, 40),
    ZOMBIE_UI("Zombie (Uncharted Isles)", 4950, 0, 0, 268, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Fire", 90, 55, 45, 65),
    ZYCLOPS("Zyclops", 4950, 0, 0, 268, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Fire", 90, 55, 45, 65),
    ZYCLOPS_CANNONEER("Zyclops cannoneer", 4950, 0, 0, 268, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Fire", 90, 55, 45, 65),
    BRONZE_DRAGON("Bronze dragon", 5000, 297.3, 98.1, 409, 0, 0, 62, 0, 0, 4, 1197, 0, 0, 1197, 62, "Water", 90, 55, 45, 65),
    INFERNAL_MAGE("Infernal mage", 5000, 267.1, 88.1, 0, 0, 208, 0, 0, 52, 4, 0, 0, 901, 901, 52, "Arrows", 90, 45, 65, 55),
    THE_ILLUSIVE("The Illusive", 5000, 312.3, 103, 907, 907, 907, 63, 63, 63, 4, 1230, 1230, 1230, 1230, 63, "Nothing", 0, 40, 40, 40),
    REVENANT_VAMPYRE("Revenant vampyre", 5100, 159.6, 52.6, 765, 765, 765, 34, 34, 34, 5, 519, 519, 519, 519, 34, "Nothing", 0, 40, 40, 40),
    KALPHITE_GUARDIAN("Kalphite guardian", 5200, 274.5, 90.5, 208, 0, 0, 52, 0, 0, 4, 901, 0, 0, 91, 52, "Water", 90, 55, 45, 65),
    WARPED_TORTOISE("Warped tortoise", 5200, 274.5, 90.5, 0, 0, 208, 0, 0, 52, 4, 0, 0, 901, 901, 52, "Bolts", 90, 45, 65, 55),
    REVENANT_WEREWOLF("Revenant werewolf", 5700, 190.8, 62.9, 855, 855, 855, 38, 38, 38, 5, 590, 590, 590, 590, 38, "Nothing", 0, 40, 40, 40),
    WITCHS_EXPERIMENT_3("Witch's experiment 3", 6000, 146.2, 48.2, 388, 0, 0, 27, 0, 0, 4, 409, 0, 0, 409, 27, "Water", 90, 55, 45, 65),
    TZ_KEK("Tz-Kek", 6200, 445.9, 147.1, 248, 0, 0, 62, 0, 0, 4, 1197, 0, 0, 1197, 62, "Water", 90, 55, 45, 65),
    REVENANT_CYCLOPS("Revenant cyclops", 6450, 239.4, 79, 967, 967, 967, 43, 43, 43, 5, 689, 689, 689, 689, 43, "Nothing", 0, 40, 40, 40),
    GIANT_WORM("Giant worm", 6500, 274.5, 90.5, 0, 0, 600, 0, 0, 65, 5, 0, 0, 1924, 1299, 40, "Bolts", 90, 45, 65, 55),
    REVENANT_HELLHOUND("Revenant hellhound", 7050, 250.2, 82.5, 1057, 1057, 1057, 50, 50, 50, 5, 850, 850, 850, 850, 50, "Nothing", 0, 40, 40, 40),
    REVENANT_DEMON("Revenant demon", 7500, 404.1, 133.3, 1125, 1125, 1125, 60, 60, 60, 5, 1132, 1132, 1132, 1132, 60, "Nothing", 0, 40, 40, 40),
    TOK_XIL("Tok-Xil", 7500, 542.2, 178.9, 0, 288, 0, 0, 60, 0, 4, 0, 1230, 0, 1230, 63, "Slash", 90, 65, 55, 45),
    WITCHS_EXPERIMENT_4("Witch's experiment 4", 8000, 207.7, 68.5, 504, 0, 0, 35, 0, 0, 4, 536, 0, 0, 409, 27, "Water", 90, 55, 45, 65),
    DUST_DEVIL("Dust devil", 8000, 424.8, 140.1, 0, 244, 0, 0, 61, 0, 4, 0, 1164, 0, 1164, 61, "Crush", 90, 65, 55, 45),
    REVENANT_ORK("Revenant ork", 8250, 661, 218.1, 1237, 1237, 1237, 70, 70, 70, 5, 1486, 1486, 1486, 1486, 70, "Nothing", 0, 40, 40, 40),
    ABYSSAL_DEMON("Abyssal demon", 8500, 661, 218.1, 672, 0, 0, 70, 0, 0, 4, 1486, 0, 0, 1608, 70, "Slash", 90, 55, 45, 65),
    REVENANT_DARK_BEAST("Revenant dark beast", 8850, 1085.4, 358.1, 1327, 1327, 1327, 80, 80, 80, 5, 1924, 1924, 1924, 1924, 80, "Nothing", 0, 40, 40, 40),
    GREATER_SHADOW("Greater shadow", 9000, 846.4, 279.3, 0, 0, 1080, 0, 0, 75, 4, 0, 0, 1694, 1694, 75, "Fire", 90, 45, 65, 55),
    REVENANT_KNIGHT("Revenant knight", 9750, 1392.7, 459.5, 1462, 1462, 1462, 85, 85, 85, 5, 2178, 2178, 2178, 1694, 75, "Nothing", 0, 40, 40, 40),
    SKELETON_UI("Skeleton (Uncharted Isles)", 10000, 0, 0, 1316, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Earth", 90, 55, 45, 65),
    YT_MEJKOT("Yt-MejKot", 10000, 569.7, 188, 1152, 0, 0, 70, 0, 0, 4, 1486, 0, 0, 1264, 64, "Water", 90, 55, 45, 65),
    YT_HURKOT("Yt-HurKot", 10000, 688.8, 227.3, 260, 0, 0, 65, 0, 0, 4, 1299, 0, 0, 1299, 65, "Water", 90, 55, 45, 65),
    WINGMAN_SKREE("Wingman Skree", 10000, 766.3, 252.8, 0, 0, 250, 0, 0, 73, 5, 0, 0, 1486, 1299, 73, "Arrows", 90, 45, 66, 55),
    FLOCKLEADER_GEERIN("Flockleader Geerin", 10000, 766.3, 252.8, 0, 250, 0, 0, 73, 0, 5, 0, 1486, 0, 1299, 73, "Bolts", 90, 65, 55, 45),
    FLIGHT_KILISA("Flight Kilisa", 10000, 766.3, 252.8, 250, 0, 0, 73, 0, 0, 5, 1486, 0, 0, 1299, 73, "Air", 90, 55, 45, 65),
    DESERT_STRYKEWYRM("Desert Strykewyrm", 10000, 805, 265.6, 0, 296, 0, 0, 74, 0, 4, 0, 1650, 0, 1526, 74, "Stab", 90, 65, 55, 45),
    IOWERTH_SCOUT("Iowerth scout", 10000, 615, 202.9, 816, 0, 0, 85, 0, 0, 4, 2178, 0, 0, 1694, 90, "Fire", 90, 55, 45, 65),
    CADARN_MAGUS("Cadarn magus", 10000, 615, 202.9, 0, 0, 1083, 0, 0, 85, 6, 0, 0, 2178, 1694, 90, "Arrows", 90, 45, 65, 55),
    REVENANT_DRAGON("Revenant dragon", 10350, 1787.4, 589.8, 1552, 1552, 1552, 90, 90, 90, 5, 2458, 2458, 2458, 2458, 90, "Nothing", 0, 40, 40, 40),
    AHRIM_THE_BLIGHTED("Ahrim the Blighted", 12000, 881.4, 290.8, 0, 0, 1260, 0, 0, 70, 6, 0, 0, 1566, 1299, 70, "Arrows", 90, 45, 65, 55),
    AKRISAE_THE_DOOMED("Akrisae the Doomed", 12000, 881.4, 290.8, 0, 0, 2167, 0, 0, 70, 6, 0, 0, 1486, 1486, 70, "Nothing", 0, 45, 65, 55),
    DHAROK_THE_WRETCHED("Dharok the Wretched", 12000, 881.4, 290.8, 1260, 0, 0, 70, 0, 0, 6, 1566, 0, 0, 1299, 70, "Fire", 90, 55, 45, 65),
    GUTHAN_THE_INFESTED("Guthan the Infested", 12000, 881.4, 290.8, 1260, 0, 0, 70, 0, 0, 6, 1566, 0, 0, 1299, 70, "Air", 90, 55, 45, 65),
    KARIL_THE_TAINTED("Karil the Tainted", 12000, 881.4, 290.8, 0, 1260, 0, 0, 70, 0, 6, 0, 1566, 0, 1299, 70, "Stab", 90, 65, 55, 45),
    TORAG_THE_CORRUPTED("Torag the Corrupted", 12000, 881.4, 290.8, 1260, 0, 0, 70, 0, 0, 6, 1566, 0, 0, 1299, 70, "Water", 90, 55, 45, 65),
    VERAC_THE_DEFILED("Verac the Defiled", 12000, 881.4, 290.8, 1260, 0, 0, 70, 0, 0, 6, 1566, 0, 0, 1299, 70, "Earth", 90, 55, 45, 65),
    WILD_JADE_VINE("Wild Jade Vine", 12000, 151.8, 50, 936, 936, 936, 65, 65, 65, 4, 1299, 1299, 1299, 628, 40, "Nothing", 0, 40, 40 ,40),
    GU_RONIN("Gu ronin", 12500, 1378, 454.7, 2680, 0, 0, 85, 0, 0, 5, 2178, 0, 0, 2178, 85, "Nothing", 0, 55, 45, 65),
    SKELETAL_HORROR_PHASE_1("Skeletal horror (Phase 1)", 12500, 344.4, 113.6, 390, 0, 0, 65, 0, 0, 6, 1299, 0, 0, 1299, 65, "Nothing", 0, 20, 10, 40),
    SKELETAL_HORROR_PHASE_2("Skeletal horror (Phase 2)", 12500, 1932.4, 637.6, 372, 0, 0, 62, 0, 0, 6, 1197, 0, 0, 1197, 62, "Nothing", 0, 55, 55, 55),
    SKELETAL_HORROR_PHASE_3("Skeletal horror (Phase 3)", 12500, 1212.3, 400, 360, 0, 0, 60, 0, 0, 6, 1132, 0, 0, 1132, 60, "Nothing", 0, 55, 55, 55),
    SKELETAL_HORROR_PHASE_4("Skeletal horror (Phase 4)", 12500, 612, 201.9, 348, 0, 0, 58, 0, 0, 6, 1070, 0, 0, 1070, 58, "Nothing", 0, 55, 55, 55),
    SKELETAL_WYVERN("Skeletal Wyvern", 12500, 1309.8, 432.2, 1100, 1100, 1100, 78, 78, 78, 4, 1829, 1829, 1829, 1608, 78, "Fire", 90, 55, 45, 65),
    TRAHAEARN_AUTOMATON("Trahaearn automaton", 12500, 500.4, 165.1, 250, 250, 250, 50, 50, 50, 5, 850, 850, 850, 850, 50, "Nothing", 45, 45, 45, 45),
    CHARGER("Charger", 15000, 1410.7, 465.5, 1564, 0, 0, 80, 0, 0, 4, 1924, 0, 0, 1486, 70, "Crush", 90, 55, 45, 65),
    CYCLOPS_LABOURER("Cyclops labourer", 15000, 0, 0, 1100, 0, 0, 70, 0, 0, 6, 1486, 0, 0, 1486, 70, "Fire", 90, 55, 45, 65),
    SHADOW_NIHIL("Shadow nihil", 15000, 1447.2, 477.5, 0, 1000, 0, 0, 80, 0, 5, 0, 1924, 0, 1924, 80, "Melee", 40, 40, 40, 40),
    ZYCLOPS_FD("Zyclops (Final Destination)", 15000, 0, 0, 268, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Fire", 90, 55, 45, 65),
    KET_ZEK("Ket-Zek", 15000, 1215, 400.9, 0, 0, 1123, 0, 0, 80, 4, 0, 0, 1486, 1299, 65, "Arrows", 90, 45, 65, 55),
    DAGANNOTH_MOTHER_BRD("Dagannoth Mother (BRD)", 15000, 1277.2, 421.4, 700, 700, 700, 73, 73, 73, 4, 1608, 1608, 1608, 1608, 73, "Nothing", 0, 55, 55, 55),
    THE_UNTOUCHABLE("The Untouchable", 15000, 1101.7, 363.5, 864, 864, 864, 65, 65, 65, 4, 1299, 1299, 1299, 1694, 75, "Nothing", 0, 40, 40, 40),
    NEW_VARROCK_GUARD("New Varrock guard", 16250, 1033.2, 340.9, 384, 0, 0, 40, 0, 0, 4, 1486, 0, 0, 1132, 60, "Nothing", 0, 70, 70, 70),
    AIRUT("Airut", 16875, 2052, 677.1, 816, 816, 0, 85, 85, 0, 4, 3031, 3031, 0, 2458, 90, "Nothing", 0, 65, 55, 45),
    CHAOS_ELEMENTAL("Chaos Elemental", 17250, 1257.3, 414.9, 1104, 1104, 1104, 1, 1, 69, 4, 1447, 1447, 2178, 1447, 69, "Bolts", 90, 45, 65, 55),
    HEAD_MOURNER("Head mourner", 17500, 1215, 400.9, 1036, 0, 0, 72, 0, 0, 4, 1566, 0, 0, 1566, 72, "Fire", 90, 55, 45, 65),
    MITHRIL_DRAGON("Mithril dragon", 17800, 1809, 596.9, 1068, 1068, 1068, 80, 80, 80, 4, 1924, 1924, 1924, 2178, 80, "Earth", 90, 55, 45, 65),
    THE_INADEQUACY("The Inadequacy", 18000, 1322.1, 436.2, 1564, 1564, 1565, 70, 70, 70, 6, 1486, 1486, 1486, 1486, 70, "Nothing", 0, 40, 40, 40),
    THE_EVERLASTING("The Everlasting", 18000, 1139.4, 376, 964, 964, 964, 67, 67, 67, 4, 1372, 1372, 1372, 1372, 67, "Nothing", 0, 40, 40, 40),
    SIR_HUGO("Sir Hugo", 18750, 1557, 513.8, 739, 0, 0, 77, 0, 0, 4, 1783, 0, 0, 1783, 77, "Air", 90, 55, 45, 65),
    DARK_LORD("Dark Lord", 19250, 1868.4, 616.5, 1108, 0, 1108, 77, 1, 77, 4, 1783, 0, 1783, 1783, 77, "Fire", 90, 45, 65, 55),
    ICE_NIHIL("Ice nihil", 20000, 2170.8, 716.3, 0, 0, 768, 0, 0, 80, 4, 0, 0, 1924, 1924, 80, "Ranged", 90, 45, 65, 55),
    SMOKE_NIHIL("Smoke nihil", 20000, 2170.8, 716.3, 0, 0, 768, 0, 0, 80, 4, 0, 0, 1924, 1924, 80, "Ranged", 90, 45, 65, 55),
    BLOOD_NIHIL("Blood nihil", 25000, 2532.6, 835.7, 768, 0, 0, 80, 0, 0, 4, 1924, 0, 0, 1924, 80, "Magic", 90, 55, 45, 65),
    ICE_STRYKEWYRM("Ice strykewyrm", 25000, 1067, 352.1, 729, 0, 729, 76, 0, 76, 4, 1566, 0, 1566, 1566, 76, "Fire", 90, 40, 30, 10),
    DAGANNOTH_SENTINEL("Dagannoth sentinel", 25000, 661, 218.1, 1036, 1036, 892, 72, 72, 62, 4, 1566, 1566, 1197, 1486, 70, "Slash", 90, 65, 55, 45),
    LEGIO("Legio", 30000, 3591, 1185, 0, 0, 1102, 0, 0, 90, 10, 0, 0, 2458, 2178, 85, "Ranged", 70, 7, 70, 15),
    LAVA_STRYKEWYRM("Lava strykewyrm", 30000, 1200, 396, 1788, 1152, 1152, 85, 85, 85, 4, 2178, 2178, 2178, 1924, 80, "Nothing", 0, 55, 55, 55),
    DAGANNOTH_PRIME("Dagannoth Prime", 35000, 2194.5, 724.1, 0, 0, 1788, 0, 0, 68, 4, 0, 0, 1924, 1409, 68, "Arrows", 75, 0, 60, 0),
    DAGANNOTH_REX("Dagannoth Rex", 35000, 2194.5, 724.1, 1788, 0, 0, 68, 0, 0, 4, 1924, 0, 0, 1409, 68, "Fire", 75, 0, 0, 60),
    DAGANNOTH_SUPREME("Dagannoth Supreme", 35000, 2194.5, 724.1, 0, 1788, 0, 0, 68, 0, 4, 0, 1924, 0, 1409, 68, "Stab", 75, 60, 0, 0),
    GENERAL_GRAARDOR("General Graardor", 40000, 3204, 1057.3, 3000, 1676, 0, 75, 75, 0, 6, 2178, 1566, 0, 1299, 75, "Nothing", 0, 50, 10, 50),
    VANSTROM_KLAUSE("Vanstrom Klause", 40000, 2644.2, 872.5, 840, 0, 840, 70, 0, 70, 4, 1486, 0, 1486, 1486, 70, "Nothing", 0, 55, 55, 55),
    TZTOK_JAD("TzTok-Jad", 40000, 2644.2, 872.5, 8000, 8000, 8000, 70, 70, 70, 4, 3031, 3031, 3031, 1486, 70, "Nothing", 0, 40, 40, 40),
    KALPHITE_QUEEN_PHASE_1("Kalphite Queen (Phase 1)", 40000, 2680, 884.4, 980, 980, 980, 70, 70, 70, 6, 1486, 1486, 1486, 1486, 70, "Nothing", 0, 40, 10, 10),
    KALPHITE_QUEEN_PHASE_2("Kalphite Queen (Phase 2)", 40000, 2680, 884.4, 980, 980, 980, 70, 70, 70, 6, 1486, 1486, 1486, 1486, 70, "Nothing", 0, 60, 40, 40),
    KING_BLACK_DRAGON("King Black Dragon", 45000, 2155.2, 711.2, 864, 0, 864, 60, 0, 60, 4, 1924, 0, 1132, 1132, 60, "Nothing", 0, 40, 40, 40),
    TOKHAAR_HOK("TokHaar-Hok", 45000, 4341.6, 1432.7, 3136, 0, 0, 80, 0, 0, 4, 1924, 0, 0, 1694, 80, "Nothing", 0, 40, 40, 40),
    AHRIM_THE_BLIGHTED_ROTS("Ahrim the Blighted (ROTS)", 50000, 7149.6, 2359.3, 0, 0, 864, 0, 0, 90, 2, 0, 0, 2458, 1924, 90, "Nothing", 0, 40, 40, 40),
    DHAROK_THE_WRETCHED_ROTS("Dharok the Wretched (ROTS)", 50000, 7149.6, 2359.3, 1296, 0, 0, 90, 0, 0, 5, 2458, 0, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    GUTHAN_THE_INFESTED_ROTS("Guthan the Infested (ROTS)", 50000, 7149.6, 2359.3, 1296, 0, 0, 90, 0, 0, 5, 2458, 0, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    KARIL_THE_TAINTED_ROTS("Karil the Tainted (ROTS)", 50000, 7149.6, 2359.3, 0, 864, 0, 0, 90, 0, 2, 0, 2458, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    TORAG_THE_CORRUPTED_ROTS("Torag the Corrupted (ROTS)", 50000, 7149.6, 2359.3, 1296, 0, 0, 90, 0, 0, 5, 2458, 0, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    VERAC_THE_DEFILED_ROTS("Verac the Defiled (ROTS)", 50000, 7149.6, 2359.3, 1296, 0, 0, 90, 0, 0, 5, 2458, 0, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    KRIL_TSUTSAROTH("K'ril Tsutsaroth", 55000, 5136, 1694.8, 1500, 0, 1500, 75, 0, 75, 5, 1486, 0, 1486, 1299, 75, "Fire", 75, 45, 40, 50),
    COMMANDER_ZILYANA("Commander Zilyana", 60000, 4796.55, 1582.8, 1800, 0, 2200, 75, 0, 75, 2, 2178, 0, 1694, 1299, 75, "Nothing", 0, 40, 40, 40),
    CAPN_EKAHI("Cap'n Ekahi", 65000, 0, 0, 1100, 0, 0, 80, 0, 0, 6, 1924, 0, 0, 1924, 80, "Nothing", 0, 40, 40, 40),
    KREEARRA("Kree'arra", 75000, 6573, 2169, 1676, 1080, 1080, 75, 75, 75, 3, 1694, 1694, 1694, 1299, 75, "Nothing", 0, 10, 70, 70),
    CORPOREAL_BEAST("Corporeal Beast", 100000, 7618, 2513.9, 3000, 0, 4500, 75, 0, 75, 4, 1694, 0, 1694, 1694, 75, "Nothing", 0, 40, 40, 40),
    QUEEN_BLACK_DRAGON("Queen Black Dragon", 100000, 5000, 1650, 2031, 2990, 0, 80, 80, 0, 6, 1924, 1924, 0, 2074, 80, "Nothing", 0, 50, 50, 50),
    ARAXXI("Araxxi", 100000, 13034.1, 4301.2, 1653, 1653, 1653, 99, 99, 99, 4, 2458, 2458, 2458, 1924, 80, "Nothing", 0, 60, 55, 45),
    COMMANDER_ZILYANA_HM("Commander Zilyana (hard)", 100050, 4796.55, 1582.8, 1900, 0, 1990, 75, 0, 75, 3, 1694, 0, 1694, 1694, 75, "Nothing", 0, 45, 40, 50),
    IMAGE_OF_YAKAMARU("Image of Yakamaru", 150000, 28936.9, 9549.1, 0, 0, 1788, 0, 0, 99, 4, 0, 0, 2458, 2765, 99, "Nothing", 0, 55, 55, 55),
    LINZA_THE_DISGRACED("Linza the Disgraced", 150000, 846, 279.1, 1200, 0, 0, 75, 0, 0, 6, 1694, 0, 0, 1694, 75, "Fire", 90, 55, 45, 65),
    TWIN_FURIES("Twin Furies", 200000, 8000, 2640, 816, 816, 0, 85, 85, 0, 3, 2178, 2178, 0, 1486, 70, "Nothing", 0, 40, 40, 40),
    VINDICTA("Vindicta", 200000, 8000, 2640, 3000, 4500, 0, 80, 80, 0, 5, 1924, 1924, 0, 1694, 75, "Nothing", 0, 50, 50, 50),
    GREGOROVIC("Gregorovic", 200000, 8000, 2640, 1152, 1152, 1152, 85, 85, 85, 4, 2178, 2178, 2178, 1694, 75, "Nothing", 0, 55, 55, 55),
    HELWYR("Helwyr", 200000, 8000, 2640, 1224, 0, 0, 85, 0, 0, 4, 2178, 0, 0, 1486, 70, "Nothing", 0, 40, 40, 40),
    NEX("Nex", 200000, 19480, 6428.4, 2500, 2500, 2500, 80, 80, 80, 4, 2023, 2023, 2023, 1924, 80, "Nothing", 0, 40, 40, 40),
    KALPHITE_KING("Kalphite King", 260000, 13231.1, 4366.25, 2560, 2560, 2560, 90, 90, 90, 5, 2343, 2343, 2343, 2178, 85, "Nothing", 0, 30, 30, 30),
    ARAXXOR("Araxxor", 300000, 43441.2, 14335.5, 1341, 1341, 1341, 99, 99, 99, 4, 2458, 2458, 2458, 2458, 85, "Nothing", 0, 50, 40, 40),
    CORMES("Cormes", 500000, 500, 165, 0, 2123, 2123, 0, 85, 85, 4, 0, 2178, 2718, 2178, 80, "Stab", 90, 45, 65, 55),
    TELOS_100_ENRAGE("Telos (100% enrage)", 600000, 5000, 1650, 1424, 0, 1424, 92, 0, 92, 4, 2577, 0, 2577, 1924, 80, "Nothing", 0, 40, 40, 40),
    KRAR("Krar", 700000, 500, 165, 2123, 2123, 0, 85, 85, 0, 5, 2178, 2178, 0, 1924, 80, "Water", 90, 55, 45, 65),
    TUZ("Tuz", 700000, 500, 165, 2123, 0, 2123, 85, 0, 85, 4, 2178, 2178, 2178, 2178, 80, "Bolts", 90, 45, 65, 55),
    VORAGO("Vorago", 1250000, 100000, 33000, 5000, 0, 5000, 90, 0, 90, 4, 2458, 0, 2458, 2178, 90, "Nothing", 0, 40, 40, 40),
    BEASTMASTER_DURZAG("Beastmaster Durzag", 1500000, 1000, 330, 1788, 1788, 0, 85, 85, 0, 6, 2458, 2458, 0, 2458, 95, "Nothing", 0, 55, 55, 55),
    NEX_ANGEL_OF_DEATH("Nex: Angel of Death", 3000000, 8000, 2640, 2123, 0, 2123, 90, 0, 90, 4, 2765, 0, 2765, 2765, 85, "Nothing", 0, 55, 55, 55),
    YAKAMARU("Yakamaru", 5000000, 5000, 1650, 0, 1653, 1653, 0, 99, 99, 4, 0, 2458, 2458, 2765, 99, "Nothing", 0, 55, 55, 55);

    private String name;
    private int lp;
    private double cbxp;
    private double hpxp;
    private int maxhitmelee;
    private int maxhitranged;
    private int maxhitmagic;
    private int attack;
    private int ranged;
    private int magic;
    private int atkspd;
    private int accmelee;
    private int accranged;
    private int accmage;
    private int armor;
    private int def;
    private String weakness;
    private int affweakness;
    private int affmelee;
    private int affranged;
    private int affmage;

    Enemy(String name, int lp, double cbxp, double hpxp, int maxhitmelee, int maxhitranged,
          int maxhitmagic, int attack, int ranged, int magic, int atkspd, int accmelee, int accranged, int accmage,
          int armor, int def, String weakness, int affweakness, int affmelee, int affranged, int affmage) {

        this.name = name;
        this.lp = lp;
        this.cbxp = cbxp;
        this.hpxp = hpxp;
        this.maxhitmelee = maxhitmelee;
        this.maxhitranged = maxhitranged;
        this.maxhitmagic = maxhitmagic;
        this.attack = attack;
        this.ranged = ranged;
        this.magic = magic;
        this.atkspd = atkspd;
        this.accmelee = accmelee;
        this.accranged = accranged;
        this.accmage = accmage;
        this.armor = armor;
        this.def = def;
        this.weakness = weakness;
        this.affweakness = affweakness;
        this.affmelee = affmelee;
        this.affranged = affranged;
        this.affmage = affmage;
    }

    public static Enemy getEnemyByName(String name) {
        for (Enemy e : values()) {
            if (name.equals(e.getName()))
                return e;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public double getCbxp() {
        return cbxp;
    }

    public double getHpxp() {
        return hpxp;
    }

    public int getAffmelee() {
        return affmelee;
    }

    public int getAffranged() {
        return affranged;
    }

    public int getAffmage() {
        return affmage;
    }

    public int getArmor() {
        return armor;
    }

    public int getDef() {
        return def;
    }

    public int getAccmage() {
        return accmage;
    }

    public int getAccmelee() {
        return accmelee;
    }

    public int getAccranged() {
        return accranged;
    }

    public int getAttack() {
        return attack;
    }

    public int getRanged() {
        return ranged;
    }

    public int getMagic() {
        return magic;
    }

    public int getMaxhitmagic() {
        return maxhitmagic;
    }

    public int getMaxhitmelee() {
        return maxhitmelee;
    }

    public int getMaxhitranged() {
        return maxhitranged;
    }

    public int getLp() {
        return lp;
    }

    public int getAtkspd() {
        return atkspd;
    }
}
