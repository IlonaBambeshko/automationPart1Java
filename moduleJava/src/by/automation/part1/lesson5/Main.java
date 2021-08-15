package by.automation.part1.lesson5;

public class Main {
    public static void main(String[] args) {
        Bird.weightOfAllBirds();
        System.out.println("");

        Bird vorobey;
        vorobey = new Bird("vorobey", 5);
        System.out.println("Weight of vorobey = " + vorobey.getWeight());
        vorobey.weightOfAllBirds();
        vorobey.setWeight(3.77);
        System.out.println("Changed weight of vorobey = " + vorobey.getWeight());
        vorobey.getInfo();
        vorobey.weightOfAllBirds();

        System.out.println("");
        Bird soroka;
        soroka = new Bird("soroka");
        System.out.println("Weight of soroka = " + soroka.getWeight());
        Bird.weightOfAllBirds();
        soroka.setWeight(1.22);
        System.out.println("Changed weight of soroka = " + soroka.getWeight());
        soroka.getInfo();
        vorobey.weightOfAllBirds();
    }
}
