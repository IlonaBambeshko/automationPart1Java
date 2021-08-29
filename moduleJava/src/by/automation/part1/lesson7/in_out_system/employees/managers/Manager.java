package by.automation.part1.lesson7.in_out_system.employees.managers;

import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.rooms.AccessableToGenericRoom;

public class Manager extends Employee implements AccessableToGenericRoom {
	public Manager(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public void goToGenericRoom() {
		System.out.println("Went to generic room");
	}
}
