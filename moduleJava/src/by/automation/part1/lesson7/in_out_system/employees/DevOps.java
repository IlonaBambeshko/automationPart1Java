package by.automation.part1.lesson7.in_out_system.employees;

import by.automation.part1.lesson7.in_out_system.rooms.Room123;

public class DevOps extends Employee implements Room123 {
	public DevOps(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public void pushDoorToRoom123() {
		System.out.println("DevOps " + super.getFirstName() + " " + super.getLastName() + " came to Room 123!");
	}
}
