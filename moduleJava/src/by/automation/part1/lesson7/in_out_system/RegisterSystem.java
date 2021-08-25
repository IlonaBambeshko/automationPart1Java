package by.automation.part1.lesson7.in_out_system;

import java.util.ArrayList;

public interface RegisterSystem {
	ArrayList<ArrayList<String>> employeesAll = new ArrayList<>();

	default String getIDCardBySerialNumber(int serialNumber) {
		return IDCards.getIDCardBySerialNumber(serialNumber);
	}

	default void registerEmployee(String name, String last_name, int serial_number) {
		ArrayList<String> employeeData = new ArrayList<>();
		employeeData.add(name);
		employeeData.add(last_name);
		employeeData.add(getIDCardBySerialNumber(serial_number));
		employeesAll.add(employeeData);

		System.out.println(employeesAll);

	}
}
