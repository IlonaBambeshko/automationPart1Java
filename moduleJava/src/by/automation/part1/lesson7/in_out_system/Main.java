package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.employees.ITSpecialist;
import by.automation.part1.lesson7.in_out_system.employees.managers.*;
import by.automation.part1.lesson7.in_out_system.rooms.Cabinet;
import by.automation.part1.lesson7.in_out_system.system.EmployeeHasNotAccessToEnter;
import by.automation.part1.lesson7.in_out_system.system.EmployeeIsNotInOfficeException;
import by.automation.part1.lesson7.in_out_system.system.Office;
import by.automation.part1.lesson7.in_out_system.system.NoAvailablePlacesException;

public class Main {
	public static void main(String[] args) throws EmployeeHasNotAccessToEnter, NoAvailablePlacesException, EmployeeIsNotInOfficeException {
		Office officeManager = new Office(15);

		Accountant ivanIvanov = new Accountant("Ivan", "Ivanov");
		DeputyBoss iliaPetrov = new DeputyBoss("Ilia", "Petrov");
		TeamLead yuraFilimonov = new TeamLead("Yura", "Filimonov");
		ITSpecialist alexKozlov = new ITSpecialist("Alex", "Kozlov");
		Boss sergeyAntonov = new Boss("Sergey", "Antonov");

		Employee[] employees = {ivanIvanov, iliaPetrov, alexKozlov, sergeyAntonov};
		officeManager.registerEmployee(employees);

		officeManager.getAccessToEnter(ivanIvanov);
		officeManager.getAccessToEnterWithoutCard(iliaPetrov);
		officeManager.getAccessToEnterWithoutCard(yuraFilimonov);
		System.out.println("There are " + Office.getFreePlacesCount() + " free places in Office\n");

		officeManager.getAccessToEnter(sergeyAntonov);
		sergeyAntonov.pushDoorToRoom123();

		Employee[] employees2 = {ivanIvanov, iliaPetrov};
		Cabinet<Employee> cabinet = new Cabinet<>(employees2);
		cabinet.printEmployeesInCabinet();

	}
}
