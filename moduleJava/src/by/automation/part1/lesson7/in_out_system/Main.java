package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.employees.managers.Manager;

import static by.automation.part1.lesson7.in_out_system.employees.Employee.getPlaceInOffice;

public class Main {
	public static void main(String[] args) throws Exception {

		Manager manager1 = new Manager("Ivan", "Ivanov");
		Manager manager2 = new Manager("Ilia", "Petrov");
		Manager manager3 = new Manager("Yura", "Filimonov");
		Manager manager4 = new Manager("Alex", "Kozlov");
		Employee.setMaximumPlacesOfOffice(2);

		manager1.registerEmployee(manager1.firstName, manager1.lastName, getPlaceInOffice());
		manager2.registerEmployee(manager2.firstName, manager2.lastName, getPlaceInOffice());
		manager3.registerEmployee(manager2.firstName, manager2.lastName, getPlaceInOffice());
		manager4.registerEmployee(manager2.firstName, manager2.lastName, getPlaceInOffice());
	}
}
