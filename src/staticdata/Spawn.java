package staticdata;

public enum Spawn {
    CHARGEBOW_FROM_GNOME_SHOPKEEPERS_ARMOURY("Chargebow", 144000, true),
    BRONZE_HELM_IN_DRAYNOR_MANOR("Bronze helm", 100, true),
    BRONZE_CHAINBODY_IN_DWARVEN_MINES("Bronze chainbody", 100, true),
    BRONZE_SQ_SHIELD_IN_ROGUES_CASTLE("Bronze sq shield", 100, false),
    LEATHER_BODY_IN_VARROCK_HOUSE("Leather body", 100, true);

    private String itemName;
    private int respawn;
    private boolean hardcore;

    Spawn(String itemName, int respawn, boolean hardcore) {
        this.itemName = itemName;
        this.respawn = respawn;
        this.hardcore = hardcore;
    }
}
