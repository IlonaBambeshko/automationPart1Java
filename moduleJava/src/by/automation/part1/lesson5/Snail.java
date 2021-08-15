package by.automation.part1.lesson5;

public class Snail {
    private String name;

    public Snail(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println("A snail with name " + name + " starts action!");
    }

    public static class ActionExample {
        public static void getAction() {
            System.out.println("шлеп");
        }
    }
}
