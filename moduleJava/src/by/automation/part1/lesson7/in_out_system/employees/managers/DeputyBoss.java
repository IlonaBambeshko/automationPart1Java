package by.automation.part1.lesson7.in_out_system.employees.managers;

import by.automation.part1.lesson7.in_out_system.rooms.Room123;
import by.automation.part1.lesson7.in_out_system.system.EmployeeIsNotInOfficeException;

public class DeputyBoss extends Manager implements Room123 {
	public DeputyBoss(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public void pushDoorToRoom123() throws EmployeeIsNotInOfficeException {
		String messageOfSuccess = "Deputy boss " + super.getFirstName() + " " + super.getLastName() + " came to Room 123!";
		switch (super.getStatus()) {
			case OUT_OF_OFFICE:
				throw new EmployeeIsNotInOfficeException("Deputy boss is not in office and can't come to Room 123!");
			default:
				System.out.println(messageOfSuccess);
		}
	}
}
