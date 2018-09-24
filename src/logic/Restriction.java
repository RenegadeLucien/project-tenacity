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
}
