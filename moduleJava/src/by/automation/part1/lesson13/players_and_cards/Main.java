package by.automation.part1.lesson13.players_and_cards;

public class Main {
	public static void main(String[] args) {
		Table table = new Table();
		Thread player1 = new Thread(new Player1(table));
		Thread player2 = new Thread(new Player1(table));
		Thread leader = new Thread(new Leader(table));

		player1.start();
		player2.start();
		leader.start();
	}
}
