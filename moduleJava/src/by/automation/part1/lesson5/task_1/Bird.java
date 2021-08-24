package by.automation.part1.lesson5.task_1;

public class Bird {
    private static double allWeight;

    private final String birdKind;
    public double weight;

    public static void printWeightOfAllBirds() {
        System.out.println("Weight of all birds = " + allWeight);
    }

    Bird(String birdKind) {
        this.birdKind = birdKind;
        weight = 0;
    }

    Bird(String birdKind, double weight) {
        this.birdKind = birdKind;
        this.weight = weight;
        allWeight = allWeight + weight;
    }

    public String getBirdKind() {
        return birdKind;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double new_weight) {
        allWeight = allWeight - weight;
        weight = new_weight;
        allWeight = allWeight + weight;
    }

    public void getInfo() {
        System.out.println("This Bird is " + birdKind + " and has weight = " + weight);
    }
}
