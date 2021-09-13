package by.automation.part1.lesson13.players_and_cards;

public class Player1 extends Thread {
	static int card = 10;
	Table table;

	public Player1(Table table) {
		this.table = table;
	}

	public void run() {
		while (card != 0) {
			card--;
			Table.cardsOnTheTable++;
			System.out.println("Player1 put 1 card on the table, he has " + card + " cards left");
			table.get();
		}
	}
}