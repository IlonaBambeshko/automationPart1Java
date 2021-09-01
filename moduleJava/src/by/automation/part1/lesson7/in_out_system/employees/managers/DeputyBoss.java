package by.automation.part1.lesson7.in_out_system.employees.managers;

import by.automation.part1.lesson7.in_out_system.rooms.Room123;

public class DeputyBoss extends Manager implements Room123 {
	public DeputyBoss(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public void pushDoorToRoom123() {
		String messageOfSuccess = "Deputy boss " + firstName + " " + lastName + " came to Room 123!";
		switch (status) {
			case INOFFICE:
			case INOFFICEWITHOUTIDCARD:
				System.out.println(messageOfSuccess);
				break;
			default:
				// TODO: 9/1/2021 Replace sout with throwing exception or error
				// [Pavel.Chachotkin]
				System.out.println("Deputy boss is not in office and can't come to Room 123!");
		}
	}
}
