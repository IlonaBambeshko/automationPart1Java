package by.automation.part1.lesson7.in_out_system.system;

import by.automation.part1.lesson7.in_out_system.employees.Employee;

public class Validator {

	public static int availablePlacesCount() {
		return Office.getMaximumPlacesInOffice() - Office.getTakenPlaceInOffice();
	}

	public static void validateFreePlacesInOffice() throws NoAvailablePlacesException {
		if (availablePlacesCount() <= 0) { // TODO: 10/2/2021 Does it normal if result will be less than 0? [Pavel.Chachotkin]
			throw new NoAvailablePlacesException("Error! There are no free places in Office!");
		}
	}

	// TODO: 10/2/2021 For what this method created? [Pavel.Chachotkin]
	public static void employeeHasNotAccessToEnter(Employee employee) throws EmployeeHasNotAccessToEnterException {
		throw new EmployeeHasNotAccessToEnterException(employee.getFirstName() + " " + employee.getLastName() + " has no access to enter");
	}
}
