package data.dataobjects;

import data.databases.FoodDatabase;

public class Food {

    private String name;
    private int amountHealed;

    public Food(String name, int amountHealed) {
        this.name = name;
        this.amountHealed = amountHealed;
    }

    public String getName() {
        return name;
    }

    public int getAmountHealed() {
        return amountHealed;
    }

    public static Food getFoodByName(String name) {
        for (Food f : FoodDatabase.getFoodDatabase().getFoods()) {
            if (name.equals(f.getName()))
                return f;
        }
        return null;
    }
}
