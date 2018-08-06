package data.dataobjects;

public class Prayer {

    private String name;
    private int req;
    private double drainPerTick;

    public Prayer(String name, int req, double drainPerTick) {
        this.name = name;
        this.req = req;
        this.drainPerTick = drainPerTick;
    }

    public String getName() {
        return name;
    }

    public double getDrainPerTick() {
        return drainPerTick;
    }
}
