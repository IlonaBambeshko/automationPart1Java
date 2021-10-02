package by.automation.part1.lesson13.players_and_cards;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
	private static int allCards = 0;
	int card = 10;
	Table table;

	public Player(Table table) {
		this.table = table;
		allCards = allCards + this.card;
	}

	public static int getAllCards() {
		return allCards;
	}

	@Override
	public void run() {
		while (card != 0) {
			synchronized (table) {
				card--;
				allCards--;
				table.putCardOnTheTable(1);
				System.out.println("Player" + Thread.currentThread().getName() + "put 1 card on the table, he has " + card + " cards left." +
						" \nThere are on the table " + table.getCardsOnTheTable() +
						" \nAll players have " + getAllCards());
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}