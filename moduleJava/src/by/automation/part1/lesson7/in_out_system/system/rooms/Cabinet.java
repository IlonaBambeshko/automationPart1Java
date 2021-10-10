package by.automation.part1.lesson7.in_out_system.system.rooms;

import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.system.validation.NobodyInCabinetException;

import java.util.ArrayList;
import java.util.List;

public class Cabinet<T extends Employee> {
	static List<Employee> listOfEmployeesInCabinet = new ArrayList<>();

	public static List<Employee> getListOfEmployeesInCabinet() throws NobodyInCabinetException {
		if (listOfEmployeesInCabinet.isEmpty()) {
			throw new NobodyInCabinetException("Nobody is in Cabinet!");
		}
		return listOfEmployeesInCabinet;
	}

	public static void addEmployeeToCabinet(List<Employee> employees) {
		listOfEmployeesInCabinet.addAll(employees);
	}

	public static void addEmployeeToCabinet(Employee employee) {
		listOfEmployeesInCabinet.add(employee);
	}
}

