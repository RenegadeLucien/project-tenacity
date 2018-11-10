package data.databases;

import data.dataobjects.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodDatabase {

    private static FoodDatabase foodDatabase;

    private List<Food> foods = new ArrayList<>();

    private FoodDatabase() {addFoods();}

    private void addFoods() {
        foods.add(new Food("Mackerel", 200));
        foods.add(new Food("Trout", 375));
        foods.add(new Food("Cod", 450));
        foods.add(new Food("Pike", 500));
        foods.add(new Food("Salmon", 625));
        foods.add(new Food("Tuna", 750));
        foods.add(new Food("Lobster", 1200));
        foods.add(new Food("Bass", 1300));
        foods.add(new Food("Swordfish", 1400));
        foods.add(new Food("Desert sole", 1450));
        foods.add(new Food("Catfish", 1500));
        foods.add(new Food("Monkfish", 1600));
        foods.add(new Food("Beltfish", 1650));
        foods.add(new Food("Cooked elligator", 1875));
        foods.add(new Food("Shark", 2000));
        foods.add(new Food("Sea turtle", 2050));
        foods.add(new Food("Great white shark", 2100));
        foods.add(new Food("Tuna potato", 2125));
        foods.add(new Food("Cavefish", 2200));
        foods.add(new Food("Manta ray", 2275));
        foods.add(new Food("Rockfish", 2300));
        foods.add(new Food("Sailfish", 2400));
        foods.add(new Food("Rocktail soup", 2500));
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
