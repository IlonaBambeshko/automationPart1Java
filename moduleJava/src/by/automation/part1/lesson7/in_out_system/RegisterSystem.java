package by.automation.part1.lesson7.in_out_system;

import java.util.ArrayList;

public interface RegisterSystem {
	ArrayList<ArrayList<String>> employees_all = new ArrayList<>();

	default String getIDCardBySerialNumber(int serial_number) {
		return IDCards.getIDCardBySerialNumber(serial_number);
	}

	default void register_employee(String name, String last_name, int serial_number) {
		ArrayList<String> employee_data = new ArrayList<>();
		employee_data.add(name);
		employee_data.add(last_name);
		employee_data.add(getIDCardBySerialNumber(serial_number));
		employees_all.add(employee_data);

		System.out.println(employees_all);

	}
}
