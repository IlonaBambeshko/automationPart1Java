package by.automation.part1.lesson7.in_out_system.employees;

import by.automation.part1.lesson7.in_out_system.system.Status;

public abstract class Employee {
	// TODO: 9/8/2021 Fix encapsulation [Pavel.Chachotkin]
	public final String firstName;
	public final String lastName;
	public String idCard = "empty card";
	public Status status = Status.OUT_OF_OFFICE;

	protected Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
