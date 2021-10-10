package by.automation.part1.lesson7.in_out_system.system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;
import by.automation.part1.lesson7.in_out_system.system.validation.EmployeeAlreadyRegisteredException;
import by.automation.part1.lesson7.in_out_system.system.validation.EmployeeHasNotAccessToEnterException;
import by.automation.part1.lesson7.in_out_system.system.validation.NoAvailablePlacesException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static by.automation.part1.lesson7.in_out_system.system.validation.Validator.*;

public class Office implements Serializable {
	private final ArrayList<Employee> listOfAllEmployeesInOffice = new ArrayList<>();
	private final int maximumPlacesInOffice;

	public Office(int maximumPlacesInOffice) {
		this.maximumPlacesInOffice = maximumPlacesInOffice;
	}

	public int getMaximumPlacesInOffice() {
		return this.maximumPlacesInOffice;
	}

	public ArrayList<Employee> getListOfAllEmployeesInOffice() {
		return listOfAllEmployeesInOffice;
	}

	public int availablePlacesCount() {
		return this.getMaximumPlacesInOffice() - this.getListOfAllEmployeesInOffice().size();
	}

	public void registerEmployee(Employee employee) {
		try {
			validateFreePlacesInOffice(availablePlacesCount());
			validatePresenceEmployeeInEmployeeList(employee, getListOfAllEmployeesInOffice());
		} catch (NoAvailablePlacesException | EmployeeAlreadyRegisteredException e) {
			System.err.println(e.getMessage());
		}
		employee.setIDCard(IDCard.generateIDCard());
		listOfAllEmployeesInOffice.add(employee);
		System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + "registered");
	}

	public void registerEmployees(List<Employee> employees) {
		try {
			validateFreePlacesInOffice(availablePlacesCount() - employees.size());
			for (Employee employee : employees) {
				registerEmployee(employee);
			}
		} catch (NoAvailablePlacesException e) {
			System.err.println(e.getMessage());
		}
	}

	public void forceEnterToOffice(Employee employee) {
		try {
			validateEmployeeInEmployeeList(employee, getListOfAllEmployeesInOffice());
			employee.setStatus(Status.IN_OFFICE_WITHOUT_CARD);
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " entered to Office by vahter without card");
		} catch (EmployeeHasNotAccessToEnterException e) {
			System.err.println(e.getMessage());
		}
	}

	public void enterToOffice(Employee employee) {
		try {
			validateEmployeeInEmployeeList(employee, getListOfAllEmployeesInOffice());
			employee.setStatus(Status.IN_OFFICE);
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " entered to Office");
		} catch (EmployeeHasNotAccessToEnterException e) {
			System.err.println(e.getMessage());
		}
	}

	public void leaveOffice(Employee employee) {
		if (listOfAllEmployeesInOffice.contains(employee)) {
			listOfAllEmployeesInOffice.remove(employee);
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " left Office");
		} else {
			System.out.println("Employee " + employee.getFirstName() + " " + employee.getLastName() + " wasn't in Office");
		}
	}
}
