package by.automation.part1.lesson7.in_out_system;

import static by.automation.part1.lesson7.in_out_system.Employees.getPlaceInOffice;

public class Main {
	public static void main(String[] args) throws Exception {

		Managers manager1 = new Managers("Ivan", "Ivanov");
		Managers manager2 = new Managers("Ilia", "Petrov");
		Managers manager3 = new Managers("Yura", "Filimonov");
		Managers manager4 = new Managers("Alex", "Kozlov");

		manager1.register_employee(manager1.first_name, manager1.last_name, getPlaceInOffice());
		manager2.register_employee(manager2.first_name, manager2.last_name, getPlaceInOffice());
		manager3.register_employee(manager2.first_name, manager2.last_name, getPlaceInOffice());
		manager4.register_employee(manager2.first_name, manager2.last_name, getPlaceInOffice());
	}
}
