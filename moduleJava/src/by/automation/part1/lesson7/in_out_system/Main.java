package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.employees.ITSpecialist;
import by.automation.part1.lesson7.in_out_system.employees.managers.*;
import by.automation.part1.lesson7.in_out_system.system.Office;
import by.automation.part1.lesson7.in_out_system.system.NoAvailablePlacesException;

public class Main {
	public static void main(String[] args) {
		Office officeManager = new Office(15);

		Accountant ivanIvanov = new Accountant("Ivan", "Ivanov");
		DeputyBoss iliaPetrov = new DeputyBoss("Ilia", "Petrov");
		TeamLead yuraFilimonov = new TeamLead("Yura", "Filimonov");
		ITSpecialist alexKozlov = new ITSpecialist("Alex", "Kozlov");
		Boss sergeyAntonov = new Boss("Sergey", "Antonov");

		Employee[] employees = {ivanIvanov, iliaPetrov, alexKozlov, sergeyAntonov};
		try {
			officeManager.registerEmployee(employees);
		} catch (NoAvailablePlacesException e) {
			e.printStackTrace();
		}

		ivanIvanov.enterToOffice();
		iliaPetrov.enterToOffice();
		yuraFilimonov.enterToOffice();
		alexKozlov.enterToOffice();

		officeManager.getInfoAboutTakenPlaces();
		officeManager.getInfoAboutFreePlaces();
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
//		Employee[] employees = {ivanIvanov, iliaPetrov};
//		Cabinet<Employee> cabinet = new Cabinet<>(employees);
//		cabinet.printEmployeesInCabinet();


	}
}
