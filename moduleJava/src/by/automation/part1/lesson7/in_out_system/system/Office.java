package by.automation.part1.lesson7.in_out_system.system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;

import java.util.ArrayList;

import static java.util.UUID.randomUUID;

public class Office {
	private int takenPlaceInOffice = 0;
	static ArrayList<ArrayList<String>> listOfAllEmployeesInOffice = new ArrayList<>();
	private int maximumPlacesInOffice;

	public Office(int maximumPlacesInOffice) {
		this.maximumPlacesInOffice = maximumPlacesInOffice;
	}

	//	refactor method according to exception theme
	public void getPlaceInOffice() throws Exception {
		takenPlaceInOffice++;
		if (takenPlaceInOffice > maximumPlacesInOffice) {
			throw new Exception("Oops! All seats in office are taken! Try another day");
		}
	}

	public static String generateCodeForIDCard() {
		return randomUUID().toString();
	}

	public void registerEmployee(Employee employee) throws Exception {
		getPlaceInOffice();
		employee.idCard = generateCodeForIDCard();
		addEmployeeDataIntoSystem(employee.firstName, employee.lastName, employee.idCard);
		employee.status = Status.OUTOFOFFICE;
		System.out.println(employee.firstName + " " + employee.lastName + " " + "registered and got ID card with code: " + employee.idCard);
		System.out.println(employee.firstName + " " + employee.lastName + " " + "has status: " + employee.status + "\n");
	}

	public static void addEmployeeDataIntoSystem(String name, String lastName, String idCard) {
		ArrayList<String> listOfEmployee = new ArrayList<>();
		listOfEmployee.add(name);
		listOfEmployee.add(lastName);
		listOfEmployee.add(idCard);
		listOfAllEmployeesInOffice.add(listOfEmployee);
		System.out.println("Information about employee " + name + " " + lastName + " added into registration system");
	}

	public void getTakenPlaceInOffice() {
		System.out.println("There are " + takenPlaceInOffice + " taken places in Office");
	}

	public void getFreePlacesInOffice() {
		int freePlaces = maximumPlacesInOffice - takenPlaceInOffice;
		System.out.println("There are " + freePlaces + " free places in Office");
	}

	public static String checkEmployeeInEmployeeList(String firstName, String lastName, String idCard) {
		System.out.println(listOfAllEmployeesInOffice);
		for (ArrayList employeeArray : listOfAllEmployeesInOffice) {
			if (employeeArray.get(0) == firstName) {
				if (employeeArray.get(1) == lastName) {
					if (employeeArray.get(2) == idCard) {
						return "Has IDCard and registered in system";
					}
					return "Registered but have no ID card";
				}
			}
		}
		return "Is not registered in system";
//		return "Employee checked";
	}

}
