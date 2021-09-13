package by.automation.part1.lesson13.players_and_cards;

public class Player2 extends Thread {
	static int card = 10;
	Table table;

	public Player2(Table table) {
		this.table = table;
	}

	public void run() {
		while (card != 0) {
			Table.cardsOnTheTable++;
			card--;
			System.out.println("Player2 put 1 card on the table, he has " + card + " cards left");
			table.get();
		}
	}
}