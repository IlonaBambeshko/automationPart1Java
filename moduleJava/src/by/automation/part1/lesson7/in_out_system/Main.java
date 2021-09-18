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
	public static void main(String[] args) {
		Office officeManager = new Office(15);

		Accountant ivanIvanov = new Accountant("Ivan", "Ivanov");
		DeputyBoss iliaPetrov = new DeputyBoss("Ilia", "Petrov");
		TeamLead yuraFilimonov = new TeamLead("Yura", "Filimonov");
		ITSpecialist alexKozlov = new ITSpecialist("Alex", "Kozlov");
		Boss sergeyAntonov = new Boss("Sergey", "Antonov");
		TeamLead annaTitova = new TeamLead("Anna", "Titova");
		Staff dinaMarkoni = new Staff("Dina", "Markoni");
		DevOps sashaJons = new DevOps("Sasha", "Jons");

		Employee[] employees = {ivanIvanov, iliaPetrov, alexKozlov, sergeyAntonov};
		officeManager.registerEmployee(ivanIvanov);
		officeManager.registerEmployee(employees);

		try {
			officeManager.enterToOffice(ivanIvanov,true);
			officeManager.enterToOffice(iliaPetrov,true);
			officeManager.enterToOffice(annaTitova, false);
			officeManager.enterToOffice(sergeyAntonov, false);
		} catch (NoAvailablePlacesException | EmployeeHasNotAccessToEnterException e) {
			e.printStackTrace();
		}

		officeManager.leaveOffice(ivanIvanov);

		try {
			sergeyAntonov.pushDoorToRoom123();
		} catch (EmployeeIsNotInOfficeException e) {
			e.printStackTrace();
		}

		Cabinet<Employee> cabinet = new Cabinet<>();
		try {
			for (Employee employee : getListOfEmployeesInCabinet()) {
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " is in Cabinet");
			}
		} catch (NobodyInCabinetException e) {
			e.printStackTrace();
		}

		Employee[] employees2 = {ivanIvanov, iliaPetrov};
		Cabinet<Employee> cabinet2 = new Cabinet<>(employees2);
		Cabinet.addEmployeeToCabinet(sergeyAntonov);
		Employee[] employees3 = {annaTitova, dinaMarkoni, sashaJons};
		Cabinet.addEmployeeToCabinet(employees3);
		try {
			for (Employee employee : getListOfEmployeesInCabinet()) {
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " is in Cabinet");
			}
		} catch (NobodyInCabinetException e) {
			e.printStackTrace();
		}

	}
}
