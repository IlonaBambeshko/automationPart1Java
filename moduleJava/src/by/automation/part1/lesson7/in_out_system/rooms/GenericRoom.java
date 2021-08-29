package by.automation.part1.lesson7.in_out_system.rooms;

import by.automation.part1.lesson7.in_out_system.employees.managers.Manager;

import java.util.Arrays;

public class GenericRoom<T extends Manager & AccessableToGenericRoom> {
	T[] employees;

	public GenericRoom() {

	}

	public GenericRoom(T[] employees) {
		this.employees = employees;
	}

	public void goToRoom() {
		for (T employee : employees) {
			employee.goToGenericRoom();
			System.out.println("Employee went to generic room\n");
		}
	}

	@Override
	public String toString() {
		return "GenericRoom{" +
				"employees=" + Arrays.toString(employees) +
				'}';
	}
}

