package by.automation.part1.lesson7.in_out_system.employees;

import by.automation.part1.lesson7.in_out_system.system.Office;
import by.automation.part1.lesson7.in_out_system.system.Status;

// TODO: 9/1/2021 Why this class not abstract?
// [Pavel.Chachotkin]
public class Employee {
	public final String firstName;
	public final String lastName;
	public String idCard = "empty card";
	public Status status = Status.NOTPRESENT;

	protected Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// TODO: 9/1/2021 Replace sout with throwing exceptions
	// [Pavel.Chachotkin]
	public void enterToOffice() {
		String result = Office.checkEmployeeInEmployeeList(firstName, lastName, idCard);
		switch (result) {
			case "Has IDCard and registered in system":
				this.status = Status.INOFFICE;
				System.out.println("Employee entered to Office");
				System.out.println(firstName + " " + lastName + " has status " + status + "\n");
				break;
			case "Registered but have no ID card":
				this.status = Status.INOFFICEWITHOUTIDCARD;
				System.out.println("Employee entered to Office by vahter without card");
				System.out.println(firstName + " " + lastName + " has status " + status + "\n");
				break;
			case "Is not registered in system":
				System.out.println("Employee has no access to enter");
				System.out.println(firstName + " " + lastName + " has status " + status + "\n");
				break;
			default:
				System.out.println("Something wrong happened");
		}
	}
}
