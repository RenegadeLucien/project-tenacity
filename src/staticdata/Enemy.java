package staticdata;

import dynamicdata.CombatResults;
import dynamicdata.Loadout;
import dynamicdata.Player;

import java.util.*;
import java.util.Map.Entry;

public enum Enemy {
    COW("Cow", 25, 5, 1.6, 1, 0, 0, 1, 1, 1, 4, 110, 0, 0, 110, 1, "Air", 90, 55, 45, 65),
    CHICKEN("Chicken", 50, 24.9, 8.2, 4, 0, 0, 1, 1, 1, 4, 110, 0, 0, 110, 1, "Fire", 90, 55, 45, 65),
    JONNY_THE_BEARD("Jonny the beard", 100, 37.3, 12.3, 4, 0, 0, 1, 0, 0, 4, 110, 0, 0, 110, 1, "Fire", 90, 55, 45, 65),
    BANDIT("Bandit", 100, 0, 0, 72, 0, 0, 5, 0, 0, 4, 150, 0, 0, 0, 5, "Crush", 90, 55, 45, 65),
    BROKEFACE("Brokeface", 120, 12.7, 4.1, 12, 0, 0, 2, 1, 1, 6, 12, 0, 0, 0, 5, "Crush", 90, 55, 45, 65),
    CHOLERIC_IMP("Choleric imp", 200, 0, 0, 16, 0, 0, 4, 0, 0, 4, 140, 0, 0, 140, 4, "Water", 90, 55, 45, 65),
    BANDIT_KING("Bandit king", 200, 0, 0, 72, 0, 0, 5, 0, 0, 4, 150, 0, 0, 0, 5, "Crush", 90, 55, 45, 65),
    GOBLIN("Goblin", 200, 25.8, 8.5, 24, 0, 0, 4, 0, 0, 6, 140, 0, 0, 140, 4, "Fire", 90, 55, 45, 65),
    WIGHT_RANGER("Wight ranger", 250, 26.7, 8.8, 0, 27, 0, 0, 5, 0, 6, 0, 150, 0, 150, 5, "Slash", 90, 65, 55, 45),
    WIGHT("Wight", 350, 26.7, 8.8, 25, 0, 0, 5, 0, 0, 5, 150, 0, 0, 150, 5, "Air", 90, 55, 45, 65),
    WIGHT_FOOTSOLDIER("Wight footsoldier", 375, 26.7, 8.8, 12, 0, 0, 5, 0, 0, 3, 150, 0, 0, 150, 5, "Fire", 90, 55, 45, 65),
    SKULLS_MERCENARY("Skulls mercenary", 400, 0, 0, 14, 0, 0, 1, 0, 0, 4, 110, 0, 0, 110, 1, "None", 0, 60, 60, 60),
    SIR_LEYE("Sir Leye", 500, 40, 13.2, 10, 0, 0, 5, 0, 0, 5, 150, 0, 0, 110, 5, "Fire", 90, 55, 45, 65),
    APEP("Apep", 500, 0, 0, 72, 0, 0, 5, 0, 0, 4, 150, 0, 0, 150, 5, "Crush", 90, 55, 45, 65),
    HERU("Heru", 500, 0, 0, 91, 0, 0, 5, 0, 0, 5, 150, 0, 0, 150, 5, "Crush", 90, 55, 45, 65),
    GNOME_TROOP("Gnome troop", 1600, 72.6, 23.9, 0, 128, 0, 0, 32, 0, 4, 0, 486, 0, 486, 32, "Slash", 90, 65, 55, 45),
    SIR_MORDRED("Sir Mordred", 1700, 59.4, 19.6, 68, 0, 0, 17, 0, 0, 4, 280, 0, 0, 280, 17, "Water", 90, 55, 45, 65),
    KHAZARD_WARLORD("Khazard warlord", 1900, 95.4, 31.4, 152, 0, 0, 38, 0, 0, 4, 590, 0, 0, 590, 38, "Air", 90, 55, 45, 65),
    WITCHS_EXPERIMENT_1("Witch's experiment 1", 2000, 89.2, 29.4, 172, 0, 0, 12, 0, 0, 4, 223, 0, 0, 223, 12, "Water", 90, 55, 45, 65),
    UNICOW("Unicow", 2050, 108.9, 35.9, 0, 0, 164, 0, 0, 41, 4, 0, 0, 648, 648, 41, "Bolts", 90, 45, 65, 55),
    SWORDCHICK("Swordchick", 2250, 132, 43.5, 180, 0, 0, 45, 0, 0, 4, 732, 0, 0, 732, 45, "Water", 90, 55, 45, 65),
    BLACK_KNIGHT_TITAN("Black Knight Titan", 2500, 63.9, 21, 120, 0, 0, 20, 0, 0, 7, 316, 0, 0, 316, 20, "Nothing", 0, 20, 10, 40),
    COUNT_DRAYNOR("Count Draynor", 3000, 22.2, 7.3, 300, 0, 0, 20, 0, 0, 6, 316, 0, 0, 316, 20, "Fire", 90, 55, 45, 65),
    WITCHS_EXPERIMENT_2("Witch's experiment 2", 4000, 99, 32.6, 244, 0, 0, 17, 0, 0, 4, 280, 0, 0, 280, 17, "Water", 90, 55, 45, 65),
    ZOMBIE_UI("Zombie (Uncharted Isles)", 4950, 0, 0, 268, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Fire", 90, 55, 45, 65),
    ZYCLOPS("Zyclops", 4950, 0, 0, 268, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Fire", 90, 55, 45, 65),
    ZYCLOPS_CANNONEER("Zyclops cannoneer", 4950, 0, 0, 268, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Fire", 90, 55, 45, 65),
    KALPHITE_GUARDIAN("Kalphite guardian", 5200, 274.5, 90.5, 208, 0, 0, 52, 0, 0, 4, 901, 0, 0, 91, 52, "Water", 90, 55, 45, 65),
    WITCHS_EXPERIMENT_3("Witch's experiment 3", 6000, 146.2, 48.2, 388, 0, 0, 27, 0, 0, 4, 409, 0, 0, 409, 27, "Water", 90, 55, 45, 65),
    GIANT_WORM("Giant worm", 6500, 274.5, 90.5, 0, 0, 600, 0, 0, 65, 5, 0, 0, 1924, 1299, 40, "Bolts", 90, 45, 65, 55),
    WITCHS_EXPERIMENT_4("Witch's experiment 4", 8000, 207.7, 68.5, 504, 0, 0, 35, 0, 0, 4, 536, 0, 0, 409, 27, "Water", 90, 55, 45, 65),
    SKELETON_UI("Skeleton (Uncharted Isles)", 10000, 0, 0, 1316, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Earth", 90, 55, 45, 65),
    WINGMAN_SKREE("Wingman Skree", 10000, 766.3, 252.8, 0, 0, 250, 0, 0, 73, 5, 0, 0, 1486, 1299, 73, "Arrows", 90, 45, 66, 55),
    FLOCKLEADER_GEERIN("Flockleader Geerin", 10000, 766.3, 252.8, 0, 250, 0, 0, 73, 0, 5, 0, 1486, 0, 1299, 73, "Bolts", 90, 65, 55, 45),
    FLIGHT_KILISA("Flight Kilisa", 10000, 766.3, 252.8, 250, 0, 0, 73, 0, 0, 5, 1486, 0, 0, 1299, 73, "Air", 90, 55, 45, 65),
    AHRIM_THE_BLIGHTED("Ahrim the Blighted", 12000, 881.4, 290.8, 0, 0, 1260, 0, 0, 70, 6, 0, 0, 1566, 1299, 70, "Arrows", 90, 45, 65, 55),
    AKRISAE_THE_DOOMED("Akrisae the Doomed", 12000, 881.4, 290.8, 0, 0, 2167, 0, 0, 70, 6, 0, 0, 1486, 1486, 70, "Nothing", 0, 45, 65, 55),
    DHAROK_THE_WRETCHED("Dharok the Wretched", 12000, 881.4, 290.8, 1260, 0, 0, 70, 0, 0, 6, 1566, 0, 0, 1299, 70, "Fire", 90, 55, 45, 65),
    GUTHAN_THE_INFESTED("Guthan the Infested", 12000, 881.4, 290.8, 1260, 0, 0, 70, 0, 0, 6, 1566, 0, 0, 1299, 70, "Air", 90, 55, 45, 65),
    KARIL_THE_TAINTED("Karil the Tainted", 12000, 881.4, 290.8, 0, 1260, 0, 0, 70, 0, 6, 0, 1566, 0, 1299, 70, "Stab", 90, 65, 55, 45),
    TORAG_THE_CORRUPTED("Torag the Corrupted", 12000, 881.4, 290.8, 1260, 0, 0, 70, 0, 0, 6, 1566, 0, 0, 1299, 70, "Water", 90, 55, 45, 65),
    VERAC_THE_DEFILED("Verac the Defiled", 12000, 881.4, 290.8, 1260, 0, 0, 70, 0, 0, 6, 1566, 0, 0, 1299, 70, "Earth", 90, 55, 45, 65),
    GU_RONIN("Gu ronin", 12500, 1378, 454.7, 2680, 0, 0, 85, 0, 0, 5, 2178, 0, 0, 2178, 85, "Nothing", 0, 55, 45, 65),
    SKELETAL_HORROR_PHASE_1("Skeletal horror (Phase 1)", 12500, 344.4, 113.6, 390, 0, 0, 65, 0, 0, 6, 1299, 0, 0, 1299, 65, "Nothing", 0, 20, 10, 40),
    SKELETAL_HORROR_PHASE_2("Skeletal horror (Phase 2)", 12500, 1932.4, 637.6, 372, 0, 0, 62, 0, 0, 6, 1197, 0, 0, 1197, 62, "Nothing", 0, 55, 55, 55),
    SKELETAL_HORROR_PHASE_3("Skeletal horror (Phase 3)", 12500, 1212.3, 400, 360, 0, 0, 60, 0, 0, 6, 1132, 0, 0, 1132, 60, "Nothing", 0, 55, 55, 55),
    SKELETAL_HORROR_PHASE_4("Skeletal horror (Phase 4)", 12500, 612, 201.9, 348, 0, 0, 58, 0, 0, 6, 1070, 0, 0, 1070, 58, "Nothing", 0, 55, 55, 55),
    CHARGER("Charger", 15000, 1410.7, 465.5, 1564, 0, 0, 80, 0, 0, 4, 1924, 0, 0, 1486, 70, "Crush", 90, 55, 45, 65),
    CYCLOPS_LABOURER("Cyclops labourer", 15000, 0, 0, 1100, 0, 0, 70, 0, 0, 6, 1486, 0, 0, 1486, 70, "Fire", 90, 55, 45, 65),
    SHADOW_NIHIL("Shadow nihil", 15000, 1447.2, 477.5, 0, 1000, 0, 0, 80, 0, 5, 0, 1924, 0, 1924, 80, "Melee", 40, 40, 40, 40),
    ZYCLOPS_FD("Zyclops (Final Destination)", 15000, 0, 0, 268, 0, 0, 67, 0, 0, 5, 1372, 0, 0, 1372, 67, "Fire", 90, 55, 45, 65),
    NEW_VARROCK_GUARD("New Varrock guard", 16250, 1033.2, 340.9, 384, 0, 0, 40, 0, 0, 4, 1486, 0, 0, 1132, 60, "Nothing", 0, 70, 70, 70),
    AIRUT("Airut", 16875, 2052, 677.1, 816, 816, 0, 85, 85, 0, 4, 3031, 3031, 0, 2458, 90, "Nothing", 0, 65, 55, 45),
    ICE_NIHIL("Ice nihil", 20000, 2170.8, 716.3, 0, 0, 768, 0, 0, 80, 4, 0, 0, 1924, 1924, 80, "Ranged", 90, 45, 65, 55),
    SMOKE_NIHIL("Smoke nihil", 20000, 2170.8, 716.3, 0, 0, 768, 0, 0, 80, 4, 0, 0, 1924, 1924, 80, "Ranged", 90, 45, 65, 55),
    BLOOD_NIHIL("Blood nihil", 25000, 2532.6, 835.7, 768, 0, 0, 80, 0, 0, 4, 1924, 0, 0, 1924, 80, "Magic", 90, 55, 45, 65),
    LEGIO("Legio", 30000, 3591, 1185, 0, 0, 1102, 0, 0, 90, 10, 0, 0, 2458, 2178, 85, "Ranged", 70, 7, 70, 15),
    DAGANNOTH_SUPREME("Dagannoth Supreme", 35000, 2194.5, 724.1, 0, 1788, 0, 0, 68, 0, 4, 0, 1924, 0, 1409, 68, "Stab", 75, 60, 0, 0),
    GENERAL_GRAARDOR("General Graardor", 40000, 3204, 1057.3, 3000, 1676, 0, 75, 75, 0, 6, 2178, 1566, 0, 1299, 75, "Nothing", 0, 50, 10, 50),
    VANSTROM_KLAUSE("Vanstrom Klause", 40000, 2644.2, 872.5, 840, 0, 840, 70, 0, 70, 4, 1486, 0, 1486, 1486, 70, "Nothing", 0, 55, 55, 55),
    KALPHITE_QUEEN_PHASE_1("Kalphite Queen (Phase 1)", 40000, 2680, 884.4, 980, 980, 980, 70, 70, 70, 6, 1486, 1486, 1486, 1486, 70, "Nothing", 0, 40, 10, 10),
    KALPHITE_QUEEN_PHASE_2("Kalphite Queen (Phase 2)", 40000, 2680, 884.4, 980, 980, 980, 70, 70, 70, 6, 1486, 1486, 1486, 1486, 70, "Nothing", 0, 60, 40, 40),
    KING_BLACK_DRAGON("King Black Dragon", 45000, 2155.2, 711.2, 864, 0, 864, 60, 0, 60, 4, 1924, 0, 1132, 1132, 60, "Nothing", 0, 40, 40, 40),
    AHRIM_THE_BLIGHTED_ROTS("Ahrim the Blighted (ROTS)", 50000, 7149.6, 2359.3, 0, 0, 864, 0, 0, 90, 2, 0, 0, 2458, 1924, 90, "Nothing", 0, 40, 40, 40),
    DHAROK_THE_WRETCHED_ROTS("Dharok the Wretched (ROTS)", 50000, 7149.6, 2359.3, 1296, 0, 0, 90, 0, 0, 5, 2458, 0, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    GUTHAN_THE_INFESTED_ROTS("Guthan the Infested (ROTS)", 50000, 7149.6, 2359.3, 1296, 0, 0, 90, 0, 0, 5, 2458, 0, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    KARIL_THE_TAINTED_ROTS("Karil the Tainted (ROTS)", 50000, 7149.6, 2359.3, 0, 864, 0, 0, 90, 0, 2, 0, 2458, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    TORAG_THE_CORRUPTED_ROTS("Torag the Corrupted (ROTS)", 50000, 7149.6, 2359.3, 1296, 0, 0, 90, 0, 0, 5, 2458, 0, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    VERAC_THE_DEFILED_ROTS("Verac the Defiled (ROTS)", 50000, 7149.6, 2359.3, 1296, 0, 0, 90, 0, 0, 5, 2458, 0, 0, 1924, 90, "Nothing", 0, 40, 40, 40),
    KRIL_TSUTSAROTH("K'ril Tsutsaroth", 55000, 5136, 1694.8, 1500, 0, 1500, 75, 0, 75, 5, 1486, 0, 1486, 1299, 75, "Fire", 75, 45, 40, 50),
    CAPN_EKAHI("Cap'n Ekahi", 65000, 0, 0, 1100, 0, 0, 80, 0, 0, 6, 1924, 0, 0, 1924, 80, "Nothing", 0, 40, 40, 40),
    KREEARRA("Kree'arra", 75000, 6573, 2169, 1676, 1080, 1080, 75, 75, 75, 3, 1694, 1694, 1694, 1299, 75, "Nothing", 0, 10, 70, 70),
    CORPOREAL_BEAST("Corporeal Beast", 100000, 7618, 2513.9, 3000, 0, 4500, 75, 0, 75, 4, 1694, 0, 1694, 1694, 75, "Nothing", 0, 40, 40, 40),
    QUEEN_BLACK_DRAGON("Queen Black Dragon", 100000, 5000, 1650, 2031, 2990, 0, 80, 80, 0, 6, 1924, 1924, 0, 2074, 80, "Nothing", 0, 50, 50, 50),
    IMAGE_OF_YAKAMARU("Image of Yakamaru", 150000, 28936.9, 9549.1, 0, 0, 1788, 0, 0, 99, 4, 0, 0, 2458, 2765, 99, "Nothing", 0, 55, 55, 55),
    LINZA_THE_DISGRACED("Linza the Disgraced", 150000, 846, 279.1, 1200, 0, 0, 75, 0, 0, 6, 1694, 0, 0, 1694, 75, "Fire", 90, 55, 45, 65),
    TWIN_FURIES("Twin Furies", 200000, 8000, 2640, 816, 816, 0, 85, 85, 0, 3, 2178, 2178, 0, 1486, 70, "Nothing", 0, 40, 40, 40),
    VINDICTA("Vindicta", 200000, 8000, 2640, 3000, 4500, 0, 80, 80, 0, 5, 1924, 1924, 0, 1694, 75, "Nothing", 0, 50, 50, 50),
    GREGOROVIC("Gregorovic", 200000, 8000, 2640, 1152, 1152, 1152, 85, 85, 85, 4, 2178, 2178, 2178, 1694, 75, "Nothing", 0, 55, 55, 55),
    KALPHITE_KING("Kalphite King", 260000, 13231.1, 4366.25, 2560, 2560, 2560, 90, 90, 90, 5, 2343, 2343, 2343, 2178, 85, "Nothing", 0, 30, 30, 30),
    TELOS_100_ENRAGE("Telos (100% enrage)", 500000, 5000, 1650, 1424, 0, 1424, 92, 0, 92, 4, 2577, 0, 2577, 1924, 80, "Nothing", 0, 40, 40, 40),
    CORMES("Cormes", 500000, 500, 165, 0, 2123, 2123, 0, 85, 85, 4, 0, 2178, 2718, 2178, 80, "Stab", 90, 45, 65, 55),
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
