package by.automation.part1.lesson7.in_out_system;

import by.automation.part1.lesson7.in_out_system.employees.managers.Manager;
import by.automation.part1.lesson7.in_out_system.system.Jurnal;

public class Main {
	public static void main(String[] args) throws Exception {
		Jurnal newJurnal = new Jurnal(4);

		Manager manager1 = new Manager("Ivan", "Ivanov");
		Manager manager2 = new Manager("Ilia", "Petrov");
		Manager manager3 = new Manager("Yura", "Filimonov");
		Manager manager4 = new Manager("Alex", "Kozlov");

		manager1.getIDCard(manager1.firstName, manager1.lastName);
		manager2.getIDCard(manager2.firstName, manager2.lastName);
		manager3.getIDCard(manager3.firstName, manager3.lastName);

	}
}
