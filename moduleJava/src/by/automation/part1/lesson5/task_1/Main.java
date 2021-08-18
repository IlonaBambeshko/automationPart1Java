package by.automation.part1.lesson5.task_1;

public class Main {
    public static void main(String[] args) {
        Bird.printWeightOfAllBirds();
        System.out.println("");

        Bird vorobey;
        vorobey = new Bird("vorobey", 5);
        System.out.println("Weight of vorobey = " + vorobey.getWeight());
        Bird.printWeightOfAllBirds();
        vorobey.setWeight(3.77);
        System.out.println("Changed weight of vorobey = " + vorobey.getWeight());
        vorobey.getInfo();
        Bird.printWeightOfAllBirds();

        System.out.println("");
        Bird soroka;
        soroka = new Bird("soroka");
        System.out.println("Weight of soroka = " + soroka.getWeight());
        Bird.printWeightOfAllBirds();
        soroka.setWeight(1.22);
        System.out.println("Changed weight of soroka = " + soroka.getWeight());
        soroka.getInfo();
        Bird.printWeightOfAllBirds();

        System.out.println("");
        Bird some_bird;
        some_bird = new Bird("unknown");
        System.out.println("Kind of bird is " + some_bird.getBirdKind());
        System.out.println("Weight of unknown = " + some_bird.getWeight());
        Bird.printWeightOfAllBirds();
        some_bird.setWeight(0.99);
        System.out.println("Changed weight of unknown = " + some_bird.getWeight());
        some_bird.getInfo();
        Bird.printWeightOfAllBirds();
    }
}
