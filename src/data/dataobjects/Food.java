package data.dataobjects;

public enum Food {

    SHRIMPS("Shrimps", 200),
    SARDINE("Sardine", 200),
    COOKED_CHICKEN("Cooked chicken", 200),
    COOKED_MEAT("Cooked meat", 200),
    CRAYFISH("Crayfish", 200);

    private String name;
    private int amountHealed;

    Food(String name, int amountHealed) {
        this.name = name;
        this.amountHealed = amountHealed;
    }

    public String getName() {
        return name;
    }

    public int getAmountHealed() {
        return amountHealed;
    }
}
