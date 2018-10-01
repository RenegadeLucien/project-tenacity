package data.dataobjects;

public enum Food {

    TROUT("Trout", 375);
    //SAILFISH_SOUP("Sailfish soup", 2600);


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
