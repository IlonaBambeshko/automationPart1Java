package by.automation.part1.lesson7.in_out_system.system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;

import java.util.ArrayList;

import static by.automation.part1.lesson7.in_out_system.system.FreePlacesValidator.validateFreePlacesInOffice;

public class Office {
	private static int maximumPlacesInOffice;
	private static int takenPlaceInOffice = 0;
	private static ArrayList<Employee> listOfAllEmployeesInOffice = new ArrayList<>();

	public Office(int maximumPlacesInOffice) {
		Office.maximumPlacesInOffice = maximumPlacesInOffice;
	}

	public static ArrayList<Employee> getListOfAllEmployeesInOffice() {
		return listOfAllEmployeesInOffice;
	}

	public static int getMaximumPlacesInOffice() {
		return maximumPlacesInOffice;
	}

	public static int getTakenPlaceInOffice() {
		return takenPlaceInOffice;
	}

	public void registerEmployee(Employee employee) {
		boolean employeeRegistered = checkIfEmployeeExistsInList(employee);
		if (employeeRegistered == true) {
			System.out.println("Employee " + employee.getFirstName() + " " + employee.getLastName() + " has already been registered");
		} else {
			employee.setIDCard(IDCard.generateIDCard());
			listOfAllEmployeesInOffice.add(employee);
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + "registered");
		}
	}

	public void registerEmployee(Employee[] employees) {
		for (Employee employee : employees) {
			registerEmployee(employee);
		}
	}

	private boolean checkIfEmployeeExistsInList(Employee employee) {
		if (listOfAllEmployeesInOffice.contains(employee)) {
			return true;
		}
		return false;
	}

	public void enterToOffice(Employee employee, boolean withCard) throws
			EmployeeHasNotAccessToEnterException, NoAvailablePlacesException {
		validateFreePlacesInOffice();
		Office.takenPlaceInOffice++;
		String result = Office.checkEmployeeInEmployeeList(employee, withCard);

		switch (result) {
			case "Has IDCard and registered in system":
				employee.setStatus(Status.IN_OFFICE);
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " entered to Office");
				break;
			case "Registered but have no ID card":
				employee.setStatus(Status.IN_OFFICE_WITHOUT_CARD);
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " entered to Office by vahter without card");
				break;
			default:
				throw new EmployeeHasNotAccessToEnterException(employee.getFirstName() + " " + employee.getLastName() + " has no access to enter");
		}
	}

	private static String checkEmployeeInEmployeeList(Employee employee, boolean withCard) {
		if (withCard) {
			for (Employee employeeInList : getListOfAllEmployeesInOffice()) {
				if (employeeInList.getFirstName().equals(employee.getFirstName())
						&& employeeInList.getLastName().equals(employee.getLastName())
						&& employeeInList.getIDCard().equals(employee.getIDCard())) {
					return "Has IDCard and registered in system";
				}
			}
			return "Is not registered in system";
		} else {
			for (Employee employeeInList : getListOfAllEmployeesInOffice()) {
				if (employeeInList.getFirstName().equals(employee.getFirstName())
						&& employeeInList.getLastName().equals(employee.getLastName()))
					return "Registered but have no ID card";
			}
		}
		return "Is not registered in system";
	}
}
