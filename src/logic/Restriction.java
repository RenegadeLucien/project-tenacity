package logic;

import java.io.Serializable;

public class Restriction implements Serializable {

    private String restriction;
    private int condition;

    public Restriction(String restriction, int condition) {
        this.restriction = restriction;
        this.condition = condition;
    }

    public String getRestriction() {
        return restriction;
    }

    public int getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Restriction)) {
            return false;
        }
        Restriction rest = (Restriction) obj;
        return restriction.equals(rest.getRestriction()) && condition == rest.getCondition();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + restriction.hashCode();
        result = 31*result + condition;
        return result;
    }
}
