package by.automation.part1.lesson13.players_and_cards;

public class Table {
	private int cardsOnTheTable;

	public void setCardsOnTheTable(){
		this.cardsOnTheTable = 0;
	}

	public void putCardOnTheTable(int cards){
		this.cardsOnTheTable = this.cardsOnTheTable + cards;
	}

	public int getCardsOnTheTable(){
		return this.cardsOnTheTable;
	}
}
