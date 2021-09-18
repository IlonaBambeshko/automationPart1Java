package by.automation.part1.lesson7.in_out_system.employees;

import by.automation.part1.lesson7.in_out_system.system.IDCard;
import by.automation.part1.lesson7.in_out_system.system.Status;

public abstract class Employee {
	private final String firstName;
	private final String lastName;
	private IDCard idCard;
	private Status status = Status.OUT_OF_OFFICE;

	protected Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public IDCard getIDCard() {
		return idCard;
	}

	public void setIDCard(IDCard idCard) {
		this.idCard = idCard;
	}
}
