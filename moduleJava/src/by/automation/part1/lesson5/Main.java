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
//______________________________________________________________________________________
        System.out.println("");
        Chair jysk_chair = new Chair("ADF-123", "red");
        Chair.ChairLeg jysk_legs = jysk_chair.new ChairLeg();
        Chair.ChairSeat jysk_seat = jysk_chair.new ChairSeat();
        Chair.ChairBack jysk_back = jysk_chair.new ChairBack();
        jysk_chair.stay();
        jysk_seat.up();
        jysk_seat.down();
        jysk_back.up();
        jysk_back.down();
        jysk_chair.fall();
        System.out.println("Chair has " + jysk_legs.getQuantity() + " legs");

        System.out.println("");
        Chair ikea_chair = new Chair("ikea12", "blue");
        Chair.ChairLeg ikea_legs = ikea_chair.new ChairLeg(3);
        Chair.ChairSeat ikea_seat = ikea_chair.new ChairSeat();
        Chair.ChairBack ikea_back = ikea_chair.new ChairBack();
        ikea_chair.stay();
        ikea_seat.up();
        ikea_seat.down();
        ikea_back.up();
        ikea_back.down();
        ikea_chair.fall();
        System.out.println("Chair has " + ikea_legs.getQuantity() + " legs");
//______________________________________________________________________________________
        Car mersedes = new Car("S220");
        Car.ActionExample mersedes_voice = new Car.ActionExample();
        mersedes.start();
        mersedes_voice.getAction();

        System.out.println("");
        Car audi = new Car("A100");
        Car.ActionExample audi_voice = new Car.ActionExample();
        audi.start();
        audi_voice.getAction();

        System.out.println("");
        Bicycle aist = new Bicycle("Aist");
        Bicycle.ActionExample aist_voice = new Bicycle.ActionExample();
        aist.start();
        aist_voice.getAction();

        System.out.println("");
        Snail rosa = new Snail("Rosa");
        Snail.ActionExample rosa_voice = new Snail.ActionExample();
        rosa.start();
        rosa_voice.getAction();

    }
}
