package by.automation.part1.lesson7.in_out_system.system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;

import java.util.ArrayList;

import static java.util.UUID.randomUUID;

// TODO: 9/1/2021 Check access modifiers for methods [Pavel.Chachotkin]
public class Office {
	private final int maximumPlacesInOffice;
	private int takenPlaceInOffice = 0;
	static ArrayList<Employee> listOfAllEmployeesInOffice = new ArrayList<Employee>();

	public Office(int maximumPlacesInOffice) {
		this.maximumPlacesInOffice = maximumPlacesInOffice;
	}

	public int getFreePlaceInOffice() {
		takenPlaceInOffice++;
		return takenPlaceInOffice;
	}

	public static String generateCodeForIDCard() {
		return randomUUID().toString();
	}

	public void registerEmployee(Employee employee) throws NoAvailablePlacesException {
		int placeToTake = getFreePlaceInOffice();
		if (placeToTake > maximumPlacesInOffice) {
			throw new NoAvailablePlacesException("Error! All " + maximumPlacesInOffice + " seats in office are taken!");
		}
		employee.idCard = generateCodeForIDCard();
		listOfAllEmployeesInOffice.add(employee);
		employee.status = Status.REGISTERED_AND_OUT_OF_OFFICE;
		System.out.println(employee.firstName + " " + employee.lastName + " " + "registered and got ID card with code: " + employee.idCard);
		System.out.println(employee.firstName + " " + employee.lastName + " " + "has status: " + employee.status + "\n");
	}

	public void registerEmployee(Employee[] employees) throws NoAvailablePlacesException {
		for (Employee employee : employees) {
			registerEmployee(employee);
		}
	}

//	public void registerEmployeeWithoutIDCard(Employee employee) throws NoAvailablePlacesException {
//		getFreePlaceInOffice();
//		addEmployeeDataIntoSystem(employee.firstName, employee.lastName, employee.idCard);
//		employee.status = Status.REGISTERED_AND_OUT_OF_OFFICE; // TODO: 9/1/2021 Is this right status? [Pavel.Chachotkin]
//		System.out.println(employee.firstName + " " + employee.lastName + " " + "registered without card");
//		System.out.println(employee.firstName + " " + employee.lastName + " " + "has status: " + employee.status + "\n");
//	}


	public void getInfoAboutTakenPlaces() {
		System.out.println("There are " + takenPlaceInOffice + " taken places in Office");
	}

	public void getInfoAboutFreePlaces() {
		int freePlaces = maximumPlacesInOffice - takenPlaceInOffice;
		System.out.println("There are " + freePlaces + " free places in Office");
	}

	public static String checkEmployeeInEmployeeList(String firstName, String lastName, String idCard) {
		System.out.println(listOfAllEmployeesInOffice);
		for (Employee employee : listOfAllEmployeesInOffice) { // TODO: 9/1/2021 Array list must have type ! [Pavel.Chachotkin] - done
			if (employee.firstName.equals(firstName)) { // TODO: 9/1/2021 Strings can not be compare by '=='. objects must compare by .equals() [Pavel.Chachotkin] - done
				if (employee.lastName.equals(lastName)) {
					if (employee.idCard.equals(idCard) && !idCard.equals("empty card")) {
						return "Has IDCard and registered in system";
					}
					return "Registered but have no ID card";
				}
			}
		}
		return "Is not registered in system";
	}

}
