package logic;

public class CombatParameters {

    private int invenSpaces;
    private String combatStyle;
    private boolean multikill;
    private double droprate;
    private boolean stackable;

    public CombatParameters(int invenSpaces, String combatStyle, boolean multikill, double droprate, boolean stackable) {
        this.invenSpaces = invenSpaces;
        this.combatStyle = combatStyle;
        this.multikill = multikill;
        this.droprate = droprate;
        this.stackable = stackable;
    }

    public String getCombatStyle() {
        return combatStyle;
    }

    public int getInvenSpaces() {
        return invenSpaces;
    }

    public boolean isMultikill() {
        return multikill;
    }

    public double getDroprate() {
        return droprate;
    }

    public boolean isStackable() {
        return stackable;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CombatParameters)) {
            return false;
        }
        CombatParameters parameters = (CombatParameters) obj;
        return invenSpaces == parameters.getInvenSpaces() && combatStyle.equals(parameters.getCombatStyle()) && multikill == parameters.isMultikill() && droprate == parameters.getDroprate()
            && stackable == parameters.isStackable();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + invenSpaces;
        result = 31*result + combatStyle.hashCode();
        result = 31*result + (int)Math.floor(droprate*1000);
        result = 31*result + (multikill ? 1 : 0);
        result = 31*result + (stackable ? 1 : 0);
        return result;
    }
}
