package logic;

public class SlayerAssignment {

    private String category;
    private int averageNumber;

    public SlayerAssignment(String category, int averageNumber) {
        this.category = category;
        this.averageNumber = averageNumber;
    }

    public String getCategory() {
        return category;
    }

    public int getAverageNumber() {
        return averageNumber;
    }
}
