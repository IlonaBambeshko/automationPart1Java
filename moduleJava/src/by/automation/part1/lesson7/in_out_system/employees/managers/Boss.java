package by.automation.part1.lesson7.in_out_system.employees.managers;

import by.automation.part1.lesson7.in_out_system.rooms.Room123;
import by.automation.part1.lesson7.in_out_system.system.EmployeeIsNotInOfficeException;

public class Boss extends Manager implements Room123 {
	public Boss(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public void pushDoorToRoom123() throws EmployeeIsNotInOfficeException {
		String messageOfSuccess = "Boss " + firstName + " " + lastName + " came to Room 123!";
		switch (status) {
			case NOT_REGISTERED:
			case REGISTERED_AND_OUT_OF_OFFICE:
				throw new EmployeeIsNotInOfficeException("Boss is not in office and can't come to Room 123!");
			default:
				System.out.println(messageOfSuccess);
		}
	}
}
