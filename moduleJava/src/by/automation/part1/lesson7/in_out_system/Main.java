package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.employees.managers.Boss;
import by.automation.part1.lesson7.in_out_system.employees.managers.Manager;
import by.automation.part1.lesson7.in_out_system.system.Office;
import by.automation.part1.lesson7.in_out_system.system.NoAvailablePlacesException;

public class Main {
	public static void main(String[] args) {
		Office officeManager = new Office(15);

		Manager manager1 = new Manager("Ivan", "Ivanov");
		Manager manager2 = new Manager("Ilia", "Petrov");
		Manager manager3 = new Manager("Yura", "Filimonov");
		Manager manager4 = new Manager("Alex", "Kozlov");
		Boss sergeyAntonov = new Boss("Sergey", "Antonov");

		Employee[] employees = {manager1, manager2, manager4, sergeyAntonov};
		try {
			officeManager.registerEmployee(employees);
		} catch (NoAvailablePlacesException e) {
			e.printStackTrace();
		}

		manager1.enterToOffice();
		manager2.enterToOffice();
		manager3.enterToOffice();
		manager4.enterToOffice();


//		officeManager.getInfoAboutTakenPlaces();
//		officeManager.getInfoAboutFreePlaces();
//
//
//		try {
//			officeManager.registerEmployee(sergeyAntonov);
//		} catch (ValidatorOfAvailiablePlacesException e) {
//			e.printStackTrace();
//		}
//		sergeyAntonov.enterToOffice();
//		sergeyAntonov.pushDoorToRoom123();
//
//		Employee[] employees = {manager1, manager2};
//		Cabinet<Employee> cabinet = new Cabinet<>(employees);
//		cabinet.printEmployeesInCabinet();


	}
}
