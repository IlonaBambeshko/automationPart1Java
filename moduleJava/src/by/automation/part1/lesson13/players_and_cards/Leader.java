package by.automation.part1.lesson13.players_and_cards;

public class Leader extends Thread {
	Table table;

	public Leader(Table table) {
		this.table = table;
	}

//	public synchronized void run() {
//		try {
//			sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Clean table");
//		System.out.println("Players have " + (Player1.card)  + " cards" );
//		System.out.println();
//		Table.cardsOnTheTable = 0;


//		@Override
//		public void run() {
//			int currentCount;
//			do {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				currentCount = table.getAllCards();
//				if (currentCount == 0) {
//					System.out.println("Got cards: " + currentCount);
//				} else {
//					System.out.println("Have not cards on table");
//				}
//			} while (currentCount > 0);
//		}
//	}

//	}
}
