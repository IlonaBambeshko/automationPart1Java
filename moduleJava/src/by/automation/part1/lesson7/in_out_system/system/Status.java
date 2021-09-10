package by.automation.part1.lesson7.in_out_system.system;

public enum Status {
	OUT_OF_OFFICE("Employee is out of Office"),
	IN_OFFICE("Employee is in Office"),
	IN_OFFICE_WITHOUT_CARD("Employee is in Office without card");

	private final String value;

	Status(final String value) {
		this.value = value;
	}
}

