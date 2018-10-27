package data.databases;

import data.dataobjects.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodDatabase {

    private static FoodDatabase foodDatabase;

    private List<Food> foods = new ArrayList<>();

    private FoodDatabase() {addFoods();}

    private void addFoods() {
        foods.add(new Food("Trout", 375));
        foods.add(new Food("Sailfish soup", 2600));
    }

    public static FoodDatabase getFoodDatabase() {
        if (foodDatabase == null) {
            foodDatabase = new FoodDatabase();
        }
        return foodDatabase;
    }

    public List<Food> getFoods() {
        return foods;
    }
}
