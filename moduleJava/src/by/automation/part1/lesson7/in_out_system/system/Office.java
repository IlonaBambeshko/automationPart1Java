package by.automation.part1.lesson7.in_out_system.system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;

import java.util.ArrayList;

import static java.util.UUID.randomUUID;

// TODO: 9/1/2021 Check access modifiers for methods [Pavel.Chachotkin]
public class Office {
	private static int maximumPlacesInOffice;
	public static int takenPlaceInOffice = 0;
	static ArrayList<Employee> listOfAllEmployeesInOffice = new ArrayList<>();

	public Office(int maximumPlacesInOffice) {
		Office.maximumPlacesInOffice = maximumPlacesInOffice;
	}

	public static String generateCodeForIDCard() {
		return randomUUID().toString().replaceAll("-", "").substring(0, 10);
	}

	public void registerEmployee(Employee employee) {
		employee.idCard = generateCodeForIDCard();
		System.out.println(employee.idCard);
		listOfAllEmployeesInOffice.add(employee);
		employee.status = Status.OUT_OF_OFFICE;
		System.out.println(employee.firstName + " " + employee.lastName + " " + "registered and got ID card with code: " + employee.idCard);
		System.out.println(employee.firstName + " " + employee.lastName + " " + "has status: " + employee.status + "\n");
	}

	public void registerEmployee(Employee[] employees) {
		for (Employee employee : employees) {
			registerEmployee(employee);
		}
	}

	public void getAccessToEnter(Employee employee) throws EmployeeHasNotAccessToEnter, FreePlacesValidator {
		employee.enterToOffice(true);
	}

	public void getAccessToEnter(Employee[] employees) throws EmployeeHasNotAccessToEnter, FreePlacesValidator {
		for (Employee employee : employees) {
			employee.enterToOffice(true);
		}
	}

	public void getAccessToEnterWithoutCard(Employee employee) throws EmployeeHasNotAccessToEnter, FreePlacesValidator {
		employee.enterToOffice(false);
	}

	public void getAccessToEnterWithoutCard(Employee[] employees) throws EmployeeHasNotAccessToEnter, FreePlacesValidator {
		for (Employee employee : employees) {
			employee.enterToOffice(false);
		}
	}

	public static int getFreePlacesCount() {
		return maximumPlacesInOffice - takenPlaceInOffice;
	}

	//	TO REFACTOR IN FUTURE
	public static String checkEmployeeInEmployeeList(String firstName, String lastName, String idCard, boolean withCard) {
		for (Employee employee : listOfAllEmployeesInOffice) {
			if (employee.firstName.equals(firstName)) {
				if (employee.lastName.equals(lastName) && withCard) {
					if (employee.idCard.equals(idCard) && !idCard.equals("empty card")) {
						return "Has IDCard and registered in system";
					}
				}
				return "Registered but have no ID card";
			}
		}
		return "Is not registered in system";
	}

}
