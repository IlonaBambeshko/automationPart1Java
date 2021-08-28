package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.managers.Boss;
import by.automation.part1.lesson7.in_out_system.employees.managers.Manager;
import by.automation.part1.lesson7.in_out_system.system.Office;

public class Main {
	public static void main(String[] args) throws Exception {
		Office officeManager = new Office(15);

		Manager manager1 = new Manager("Ivan", "Ivanov");
		Manager manager2 = new Manager("Ilia", "Petrov");
		Manager manager3 = new Manager("Yura", "Filimonov");
		Manager manager4 = new Manager("Alex", "Kozlov");
		Boss sergeyAntonov = new Boss("Sergey", "Antonov");

		officeManager.registerEmployee(manager1);
		officeManager.registerEmployee(manager2);
		officeManager.registerEmployee(manager3);
		officeManager.registerEmployee(manager4);

		officeManager.getInfoAboutTakenPlaces();
		officeManager.getInfoAboutFreePlaces();

		manager1.enterToOffice();
		manager2.enterToOffice();
		manager3.enterToOffice();
		manager4.enterToOffice();

		officeManager.registerEmployee(sergeyAntonov);
		sergeyAntonov.enterToOffice();
		sergeyAntonov.pushDoorToRoom123();
	}
}
