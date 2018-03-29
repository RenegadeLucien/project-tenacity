package logic;

public class Restriction implements java.io.Serializable {

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
