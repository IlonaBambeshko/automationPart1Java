package by.automation.part1.lesson13.players_and_cards;

public class Main {
	public static void main(String[] args) {
		Table table = new Table();
		new Thread(new Player1(table)).start();
		new Thread(new Player2(table)).start();
		new Thread(new Player3(table)).start();
	}
}
