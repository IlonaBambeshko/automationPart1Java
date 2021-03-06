package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.DevOps;
import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.employees.ITSpecialist;
import by.automation.part1.lesson7.in_out_system.employees.Staff;
import by.automation.part1.lesson7.in_out_system.employees.managers.Accountant;
import by.automation.part1.lesson7.in_out_system.employees.managers.Boss;
import by.automation.part1.lesson7.in_out_system.employees.managers.DeputyBoss;
import by.automation.part1.lesson7.in_out_system.employees.managers.TeamLead;
import by.automation.part1.lesson7.in_out_system.system.rooms.Cabinet;
import by.automation.part1.lesson7.in_out_system.system.*;
import by.automation.part1.lesson7.in_out_system.system.validation.EmployeeIsNotInOfficeException;
import by.automation.part1.lesson7.in_out_system.system.validation.NobodyInCabinetException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static by.automation.part1.lesson7.in_out_system.system.rooms.Cabinet.getListOfEmployeesInCabinet;

public class Main {
	public static void main(String[] args) {
		Office officeManager = new Office(15);

		// create employees
		Accountant ivanIvanov = new Accountant("Ivan", "Ivanov");
		Accountant ivanIvanov2 = new Accountant("Ivan", "Ivanov");
		DeputyBoss iliaPetrov = new DeputyBoss("Ilia", "Petrov");
		TeamLead yuraFilimonov = new TeamLead("Yura", "Filimonov");
		ITSpecialist alexKozlov = new ITSpecialist("Alex", "Kozlov");
		Boss sergeyAntonov = new Boss("Sergey", "Antonov");
		TeamLead annaTitova = new TeamLead("Anna", "Titova");
		Staff dinaMarkoni = new Staff("Dina", "Markoni");
		DevOps sashaJons = new DevOps("Sasha", "Jons");

		// registration
		List<Employee> employees = new ArrayList<>();
		employees.add(ivanIvanov);
		employees.add(iliaPetrov);
		employees.add(alexKozlov);
		employees.add(sergeyAntonov);

		officeManager.registerEmployee(ivanIvanov);
		officeManager.registerEmployee(ivanIvanov2);
		officeManager.registerEmployees(employees);

		// enter to Office
		officeManager.enterToOffice(ivanIvanov);
		officeManager.enterToOffice(iliaPetrov);
		officeManager.forceEnterToOffice(sergeyAntonov);
		officeManager.enterToOffice(annaTitova);
		officeManager.forceEnterToOffice(annaTitova);

		// leave Office
		officeManager.leaveOffice(ivanIvanov);

		// region Serialization
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("office.obraz"))) {
			oos.writeObject(officeManager);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		// region Deserialization
		Office officeManagerNew = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("office.obraz"))) {
			officeManagerNew = (Office) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		for (Employee employee : officeManagerNew.getListOfAllEmployeesInOffice()) {
			System.out.println("Deserialized: " + employee.getFirstName() + " " + employee.getLastName() + " in Office");
		}

		// Room123
		try {
			sergeyAntonov.pushDoorToRoom123();
		} catch (EmployeeIsNotInOfficeException e) {
			System.err.println(e.getMessage());
		}

		// Cabinet
		Cabinet<Employee> cabinet = new Cabinet();
		try {
			for (Employee employee : getListOfEmployeesInCabinet()) {
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " is in Cabinet");
			}
		} catch (NobodyInCabinetException e) {
			System.err.println(e.getMessage());
		}
		Cabinet.addEmployeeToCabinet(sergeyAntonov);

		List<Employee> employees3 = new ArrayList<>();
		employees3.add(annaTitova);
		employees3.add(dinaMarkoni);
		employees3.add(sashaJons);

		Cabinet.addEmployeeToCabinet(employees3);
		try {
			for (Employee employee : getListOfEmployeesInCabinet()) {
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " is in Cabinet");
			}
		} catch (NobodyInCabinetException e) {
			System.err.println(e.getMessage());
		}

	}
}
