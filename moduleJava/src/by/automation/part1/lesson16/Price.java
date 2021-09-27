package by.automation.part1.lesson16;

public class Price {
	private final int value;


	public Price(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Price (" +
				value +
				')';
	}

}
