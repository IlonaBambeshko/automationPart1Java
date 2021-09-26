package by.automation.part1.lesson7.in_out_system.system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;

import java.io.Serializable;
import java.util.ArrayList;

import static by.automation.part1.lesson7.in_out_system.system.FreePlacesValidator.validateFreePlacesInOffice;

public class Office implements Serializable {
	private static int maximumPlacesInOffice;
	private static int takenPlaceInOffice = 0;
	private static ArrayList<Employee> listOfAllEmployeesInOffice = new ArrayList<>();

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

	// TODO: 9/26/2021 I think we must rename method with multiple count for employee [Pavel.Chachotkin]
	public void registerEmployee(Employee[] employees) {
		for (Employee employee : employees) {
			registerEmployee(employee);
		}
	}

	private boolean checkIfEmployeeExistsInList(Employee employee) {
		if (listOfAllEmployeesInOffice.contains(employee)) { // TODO: 9/26/2021 Does it works for 2 object of employee with same names and lastNames? [Pavel.Chachotkin]
			return true;
		}
		return false;
	}

	public void enterToOffice(Employee employee, boolean withCard) throws EmployeeHasNotAccessToEnterException, NoAvailablePlacesException {
		validateFreePlacesInOffice();
		String result = checkEmployeeInEmployeeList(employee, withCard);

		switch (result) {
			case "Has IDCard and registered in system":
				employee.setStatus(Status.IN_OFFICE);
				setTakenPlaceInOffice(takenPlaceInOffice++);
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " entered to Office");
				break;
			case "Registered but have no ID card":
				employee.setStatus(Status.IN_OFFICE_WITHOUT_CARD);
				setTakenPlaceInOffice(takenPlaceInOffice++);
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " entered to Office by vahter without card");
				break;
			default:
				// TODO: 9/26/2021 Move exception to Validator and catch here [Pavel.Chachotkin]
				throw new EmployeeHasNotAccessToEnterException(employee.getFirstName() + " " + employee.getLastName() + " has no access to enter");
		}
	}

	private String checkEmployeeInEmployeeList(Employee employee, boolean withCard) {
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

	public void leaveOffice(Employee employee){
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
