package by.automation.part1.lesson7.in_out_system.rooms;

import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.system.NobodyInCabinetException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cabinet<T extends Employee> {
	public T employee;
	public T[] employees;
	static List<Employee> listOfEmployeesInCabinet = new ArrayList<>();

	public Cabinet(T[] employees) {
		this.employees = employees;
		addEmployeeToCabinet(employees);
	}

	public Cabinet(T employee) {
		this.employee = employee;
		addEmployeeToCabinet(employee);
	}

	public Cabinet() {
	}

	public static List<Employee> getListOfEmployeesInCabinet() throws NobodyInCabinetException {
		if (listOfEmployeesInCabinet.isEmpty()){
			throw new NobodyInCabinetException("Nobody is in Cabinet!");
		}
		return listOfEmployeesInCabinet;
	}

	public static void addEmployeeToCabinet(Employee[] employees) {
		listOfEmployeesInCabinet.addAll(Arrays.asList(employees));
	}

	public static void addEmployeeToCabinet(Employee employee) {
		listOfEmployeesInCabinet.add(employee);
	}
}

