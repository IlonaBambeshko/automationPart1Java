package by.automation.part1.lesson5.task_2;

public class Main {
    public static void main(String[] args) {
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
    }
}
