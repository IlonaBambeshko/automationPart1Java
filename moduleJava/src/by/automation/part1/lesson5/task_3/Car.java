package by.automation.part1.lesson5.task_3;

public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void start() {
        System.out.println("Car " + model + " starts action!");
    }

    public static class ActionExample {
        public static void getAction() {
            System.out.println("Врум-врум");
        }
    }
}
