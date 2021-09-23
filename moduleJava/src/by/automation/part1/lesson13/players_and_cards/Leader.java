package by.automation.part1.lesson13.players_and_cards;

public class Leader extends Thread {
	Table table;

	public Leader(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		int currentCount;
		do {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentCount = table.getCardsOnTheTable();
			if (currentCount == 0) {
				System.out.println("Finished. Got cards: " + currentCount);
			} else {
				System.out.println("Clean table. Have no cards on table\n");
				table.setCardsOnTheTable();
			}
		} while (currentCount > 0);
	}
}
