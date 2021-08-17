package by.automation.part1.lesson5.task_3;

public class Main {
    public static void main(String[] args) {
        Car mersedes = new Car("S220");
        mersedes.start();
        Car.ActionExample.getAction();

        System.out.println("");
        Car audi = new Car("A100");
        audi.start();
        Car.ActionExample.getAction();

        System.out.println("");
        Bicycle aist = new Bicycle("Aist");
        aist.start();
        Bicycle.ActionExample.getAction();

        System.out.println("");
        Snail rosa = new Snail("Rosa");
        rosa.start();
        Snail.ActionExample.getAction();
    }
}
