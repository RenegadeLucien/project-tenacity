package data.dataobjects;

public class Spawn {

    private String itemName;
    private int quantity;
    private int respawn;
    private boolean hardcore;

    public Spawn(String itemName, int quantity, int respawn, boolean hardcore) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.respawn = respawn;
        this.hardcore = hardcore;
    }
}
