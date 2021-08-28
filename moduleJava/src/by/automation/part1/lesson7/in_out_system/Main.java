package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.managers.Manager;
import by.automation.part1.lesson7.in_out_system.system.Office;

public class Main {
	public static void main(String[] args) throws Exception {
		Office officeManager = new Office(15);

		Manager manager1 = new Manager("Ivan", "Ivanov");
		Manager manager2 = new Manager("Ilia", "Petrov");
		Manager manager3 = new Manager("Yura", "Filimonov");
		Manager manager4 = new Manager("Alex", "Kozlov");

		officeManager.registerEmployee(manager1);
		officeManager.registerEmployee(manager2);
		officeManager.registerEmployee(manager3);
		officeManager.registerEmployee(manager4);
		System.out.println(manager1.status);
		System.out.println(manager1.idCard);

		officeManager.getTakenPlaceInOffice();
		officeManager.getFreePlacesInOffice();

		manager1.enterToOffice();
		manager2.enterToOffice();
		manager3.enterToOffice();
		manager4.enterToOffice();



	}
}
