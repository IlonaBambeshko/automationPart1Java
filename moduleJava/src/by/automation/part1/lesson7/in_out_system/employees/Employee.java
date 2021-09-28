package by.automation.part1.lesson7.in_out_system.employees;

import by.automation.part1.lesson7.in_out_system.system.IDCard;
import by.automation.part1.lesson7.in_out_system.system.Status;

import java.io.Serializable;
import java.util.Objects;

public abstract class Employee implements Serializable {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, idCard);
	}
}
