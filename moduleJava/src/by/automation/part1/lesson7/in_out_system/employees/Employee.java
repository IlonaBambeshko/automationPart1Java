package by.automation.part1.lesson7.in_out_system.employees;

import by.automation.part1.lesson7.in_out_system.system.Jurnal;

public class Employee {
	public final String firstName;
	public final String lastName;
	public String IDCard = "";

	protected Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void getIDCard(String name, String last_name) throws Exception {
		this.IDCard = Jurnal.registerEmployee(name, last_name);
		System.out.println(firstName + " " + last_name + " " + "gets ID card with code: " + this.IDCard);
	}

}
