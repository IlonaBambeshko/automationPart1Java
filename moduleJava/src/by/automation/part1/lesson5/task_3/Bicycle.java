package by.automation.part1.lesson5.task_3;

public class Bicycle {
	private final String model;

	public Bicycle(String model) {
		this.model = model;
	}

	public void start() {
		System.out.println("A man uses " + model + " bicycle and starts action!");
	}

	public static class ActionExample {
		public static void getAction() {
			System.out.println("Шарк-шарк");
		}
	}
}
