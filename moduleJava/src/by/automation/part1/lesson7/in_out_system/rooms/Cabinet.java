package by.automation.part1.lesson7.in_out_system.rooms;

import by.automation.part1.lesson7.in_out_system.employees.Employee;

public class Cabinet<T extends Employee> {
	T[] employees;

	public Cabinet(T[] employees) {
		this.employees = employees;
	}


	public void printEmployeesInCabinet() {
		for (T employee : employees) {
			System.out.println(employee.firstName + " " + employee.lastName + " is in Cabinet");
		}
	}
}

