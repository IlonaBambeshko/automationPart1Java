package by.automation.part1.lesson7.in_out_system.system.validation;

import by.automation.part1.lesson7.in_out_system.employees.Employee;
import java.util.ArrayList;

public class Validator {

	public static void validateFreePlacesInOffice(int availablePlacesCount) throws NoAvailablePlacesException {
		if (availablePlacesCount <= 0) {
			throw new NoAvailablePlacesException("Error! There are no free places in Office!");
		}
	}

	public static void validateEmployeeInEmployeeList(Employee employee, ArrayList<Employee> employeeList) throws EmployeeHasNotAccessToEnterException {
		if (!employeeList.contains(employee)) {
			throw new EmployeeHasNotAccessToEnterException(employee.getFirstName() + " " + employee.getLastName() +
					" is not registered and has no access to enter. Please, register employee first");
		}
	}

	public static void validatePresenceEmployeeInEmployeeList(Employee employee, ArrayList<Employee> employeeList) throws EmployeeAlreadyRegisteredException {
		if (employeeList.contains(employee)) {
			throw new EmployeeAlreadyRegisteredException("Employee " + employee.getFirstName() + " " +
					employee.getLastName() + " has already been registered");
		}
	}

}
