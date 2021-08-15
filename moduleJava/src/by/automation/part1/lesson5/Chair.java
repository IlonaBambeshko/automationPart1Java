package by.automation.part1.lesson5;

public class Chair {

    private String model;
    private String color;

    public Chair(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public void stay() {
        System.out.println(color + " " + model + " chair stays");
    }

    public void fall() {
        System.out.println(color + " " + model + " chair has fallen down...");
    }

    public class ChairLeg {
        public int legQuantity;

        ChairLeg() {
            legQuantity = 4;
        }

        public ChairLeg(int legQuantity) {
            this.legQuantity = legQuantity;
        }

        public int getQuantity() {
            return legQuantity;
        }

    }

    public class ChairSeat {
        public void up() {
            System.out.println("Seat has set up!");
        }

        public void down() {
            System.out.println("Seat has set down!");
        }
    }

    public class ChairBack {
        public void up() {
            System.out.println("Chair back is up");
        }

        public void down() {
            System.out.println("Chair back is down");
        }
    }
}
