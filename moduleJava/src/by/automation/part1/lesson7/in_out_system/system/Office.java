package by.automation.part1.lesson7.in_out_system.system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static by.automation.part1.lesson7.in_out_system.system.Validator.validateFreePlacesInOffice;
import static by.automation.part1.lesson7.in_out_system.system.Validator.employeeHasNotAccessToEnter;

public class Office implements Serializable {
	private static int maximumPlacesInOffice;
	private static int takenPlaceInOffice = 0;
	private static final ArrayList<Employee> listOfAllEmployeesInOffice = new ArrayList<>();

	public Office(int maximumPlacesInOffice) {
		Office.maximumPlacesInOffice = maximumPlacesInOffice;
	}

	public ArrayList<Employee> getListOfAllEmployeesInOffice() {
		return listOfAllEmployeesInOffice;
	}

	public static int getMaximumPlacesInOffice() {
		return maximumPlacesInOffice;
	}

	public static int getTakenPlaceInOffice() {
		return takenPlaceInOffice;
	}

	public static void setTakenPlaceInOffice(int takenPlaceInOffice) {
		Office.takenPlaceInOffice = takenPlaceInOffice;
	}

	public void registerEmployee(Employee employee) {
		boolean employeeRegistered = checkIfEmployeeExistsInList(employee);
		if (employeeRegistered) {
			System.out.println("Employee " + employee.getFirstName() + " " + employee.getLastName() + " has already been registered");
		} else {
			employee.setIDCard(IDCard.generateIDCard());
			listOfAllEmployeesInOffice.add(employee);
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + "registered");
		}
	}

	public void registerEmployees(List<Employee> employees) {
		for (Employee employee : employees) {
			registerEmployee(employee);
		}
	}

	private boolean checkIfEmployeeExistsInList(Employee employee) {
		return listOfAllEmployeesInOffice.contains(employee);
	}

	public void forceEnterToOffice(Employee employee) throws NoAvailablePlacesException, EmployeeHasNotAccessToEnterException {
		validateFreePlacesInOffice();
		if (getListOfAllEmployeesInOffice().contains(employee)) {
			employee.setStatus(Status.IN_OFFICE_WITHOUT_CARD);
			setTakenPlaceInOffice(takenPlaceInOffice++);
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " entered to Office by vahter without card");
		} else {
			employeeHasNotAccessToEnter(employee);
		}

	}

	public void enterToOffice(Employee employee) throws EmployeeHasNotAccessToEnterException, NoAvailablePlacesException {
		validateFreePlacesInOffice();
		if (checkedEmployeeInEmployeeList(employee)) {
			employee.setStatus(Status.IN_OFFICE);
			setTakenPlaceInOffice(takenPlaceInOffice++);
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " entered to Office");
		} else {
			employeeHasNotAccessToEnter(employee);
		}
	}

	private boolean checkedEmployeeInEmployeeList(Employee employee) {
		for (Employee employeeInList : getListOfAllEmployeesInOffice()) {
			if (employeeInList.equals(employee)) {
				return true;
			}
		}
		return false;
	}

	public void leaveOffice(Employee employee) {
		boolean employeeIsInOffice = checkIfEmployeeExistsInList(employee);
		if (employeeIsInOffice) {
			listOfAllEmployeesInOffice.remove(employee);
			setTakenPlaceInOffice(takenPlaceInOffice--);
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " left Office");
		} else {
			System.out.println("Employee " + employee.getFirstName() + " " + employee.getLastName() + " wasn't in Office");
		}
	}
}
