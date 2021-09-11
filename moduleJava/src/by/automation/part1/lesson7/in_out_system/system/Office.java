package by.automation.part1.lesson7.in_out_system.system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;

import java.util.ArrayList;

import static by.automation.part1.lesson7.in_out_system.system.FreePlacesValidator.validateFreePlacesInOffice;
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

	public void getAccessToEnter(Employee employee) throws EmployeeHasNotAccessToEnter, NoAvailablePlacesException {
		enterToOffice(employee, true);
	}

	public void getAccessToEnter(Employee[] employees) throws EmployeeHasNotAccessToEnter, NoAvailablePlacesException {
		for (Employee employee : employees) {
			enterToOffice(employee, true);
		}
	}

	public void getAccessToEnterWithoutCard(Employee employee) throws EmployeeHasNotAccessToEnter, NoAvailablePlacesException {
		enterToOffice(employee, false);
	}

	public void getAccessToEnterWithoutCard(Employee[] employees) throws EmployeeHasNotAccessToEnter, NoAvailablePlacesException {
		for (Employee employee : employees) {
			enterToOffice(employee, false);
		}
	}

	public void enterToOffice(Employee employee, boolean hasCard) throws EmployeeHasNotAccessToEnter, NoAvailablePlacesException {
		validateFreePlacesInOffice(getFreePlacesCount());
		Office.takenPlaceInOffice++;
		String result = Office.checkEmployeeInEmployeeList(employee.firstName, employee.lastName, employee.idCard, hasCard);

		switch (result) {
			case "Has IDCard and registered in system":
				employee.status = Status.IN_OFFICE;
				System.out.println("Employee entered to Office");
				System.out.println(employee.firstName + " " + employee.lastName + " has status " + employee.status + "\n");
				break;
			case "Registered but have no ID card":
				employee.status = Status.IN_OFFICE_WITHOUT_CARD;
				System.out.println("Employee entered to Office by vahter without card");
				System.out.println(employee.firstName + " " + employee.lastName + " has status " + employee.status + "\n");
				break;
			default:
				throw new EmployeeHasNotAccessToEnter("Employee has no access to enter\n" + employee.firstName + " " + employee.lastName + " has status " + employee.status);
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
