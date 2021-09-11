package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.DevOps;
import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.employees.ITSpecialist;
import by.automation.part1.lesson7.in_out_system.employees.Staff;
import by.automation.part1.lesson7.in_out_system.employees.managers.*;
import by.automation.part1.lesson7.in_out_system.rooms.Cabinet;
import by.automation.part1.lesson7.in_out_system.system.*;

import static by.automation.part1.lesson7.in_out_system.rooms.Cabinet.getListOfEmployeesInCabinet;

public class Main {
	public static void main(String[] args) throws EmployeeHasNotAccessToEnter, EmployeeIsNotInOfficeException, NoAvailablePlacesException, NobodyInCabinetException {
		Office officeManager = new Office(10);

		Accountant ivanIvanov = new Accountant("Ivan", "Ivanov");
		DeputyBoss iliaPetrov = new DeputyBoss("Ilia", "Petrov");
		TeamLead yuraFilimonov = new TeamLead("Yura", "Filimonov");
		ITSpecialist alexKozlov = new ITSpecialist("Alex", "Kozlov");
		Boss sergeyAntonov = new Boss("Sergey", "Antonov");
		TeamLead annaTitova = new TeamLead("Anna", "Titova");
		Staff dinaMarkoni = new Staff("Dina", "Markoni");
		DevOps sashaJons = new DevOps("Sasha", "Jons");

//		Employee[] employees = {ivanIvanov, iliaPetrov, alexKozlov, sergeyAntonov};
//		officeManager.registerEmployee(employees);
//
//		officeManager.getAccessToEnter(ivanIvanov);
//		officeManager.getAccessToEnterWithoutCard(iliaPetrov);
//		officeManager.getAccessToEnterWithoutCard(yuraFilimonov);
//		System.out.println("There are " + Office.getFreePlacesCount() + " free places in Office\n");
//
//		officeManager.getAccessToEnter(sergeyAntonov);
//		sergeyAntonov.pushDoorToRoom123();

		Cabinet<Employee> cabinet = new Cabinet<>();
		for (Employee empl : getListOfEmployeesInCabinet()) {
			System.out.println(empl.firstName + " " + empl.lastName + " is in Cabinet");
		}

		Employee[] employees2 = {ivanIvanov, iliaPetrov};
		Cabinet<Employee> cabinet2 = new Cabinet<>(employees2);
		Cabinet.addEmployeeToCabinet(sergeyAntonov);
		Employee[] employees3 = {annaTitova, dinaMarkoni, sashaJons};
		Cabinet.addEmployeeToCabinet(employees3);
		for (Employee empl : getListOfEmployeesInCabinet()) {
			System.out.println(empl.firstName + " " + empl.lastName + " is in Cabinet");
		}

	}
}
