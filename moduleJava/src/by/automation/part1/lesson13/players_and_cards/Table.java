package by.automation.part1.lesson13.players_and_cards;

import static java.lang.Thread.sleep;

public class Table {
	static int cardsOnTheTable = 0;

	synchronized void get() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("There are " + cardsOnTheTable + " cards on the table");
		System.out.println("Clean table");
		System.out.println("Players have " + (Player1.card + Player2.card + Player3.card)  + " cards" );
		System.out.println();
		cardsOnTheTable = 0;
	}
}
