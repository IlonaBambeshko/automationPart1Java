package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.managers.Boss;
import by.automation.part1.lesson7.in_out_system.employees.managers.Manager;
import by.automation.part1.lesson7.in_out_system.rooms.GenericRoom;
import by.automation.part1.lesson7.in_out_system.system.Office;
import by.automation.part1.lesson7.in_out_system.system.ValidatorOfAvailiablePlacesException;

public class Main {
	public static void main(String[] args) {
		Office officeManager = new Office(3);

		Manager manager1 = new Manager("Ivan", "Ivanov");
		Manager manager2 = new Manager("Ilia", "Petrov");
		Manager manager3 = new Manager("Yura", "Filimonov");
		Manager manager4 = new Manager("Alex", "Kozlov");
		Boss sergeyAntonov = new Boss("Sergey", "Antonov");

		try {
			officeManager.registerEmployee(manager1);
		} catch (ValidatorOfAvailiablePlacesException e) {
			e.printStackTrace();
		}
		try {
			officeManager.registerEmployee(manager2);
		} catch (ValidatorOfAvailiablePlacesException e) {
			e.printStackTrace();
		}
		try {
			officeManager.registerEmployee(manager3);
		} catch (ValidatorOfAvailiablePlacesException e) {
			e.printStackTrace();
		}
		try {
			officeManager.registerEmployeeWithoutIDCard(manager4);
		} catch (ValidatorOfAvailiablePlacesException e) {
			e.printStackTrace();
		}
//
//		officeManager.getInfoAboutTakenPlaces();
//		officeManager.getInfoAboutFreePlaces();
//
		manager1.enterToOffice();
		manager2.enterToOffice();
		manager3.enterToOffice();
		manager4.enterToOffice();

//		officeManager.registerEmployee(sergeyAntonov);
//		sergeyAntonov.enterToOffice();
//		sergeyAntonov.pushDoorToRoom123();




	}
}
