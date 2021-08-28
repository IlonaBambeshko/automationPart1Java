package by.automation.part1.lesson7.in_out_system.employees.managers;

import by.automation.part1.lesson7.in_out_system.Room123;

public class Boss extends Manager implements Room123 {

	public Boss(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public void pushDoorToRoom123() {
		String messageOfSuccess = "Boss " + firstName + " " + lastName + " came to Room 123!";
		switch (status) {
			case INOFFICE:
			case INOFFICEWITHOUTIDCARD:
				System.out.println(messageOfSuccess);
				break;
			default:
				System.out.println("Boss is not in office and can't come to Room 123!");
		}
	}
}
