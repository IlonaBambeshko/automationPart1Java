package by.automation.part1.lesson7.in_out_system.system;

// TODO: 9/1/2021 Rewrite constant names by UPPER_SNAKE_CASE - done
// [Pavel.Chachotkin]
public enum Status {
	NOT_REGISTERED("Employee is not registered"),
	REGISTERED_AND_OUT_OF_OFFICE("Employee is registered but out of Office"),
	IN_OFFICE("Employee is in Office"),
	IN_OFFICE_WITHOUT_CARD("Employee is in Office without card");

	private final String value;

	Status(final String value) {
		this.value = value;
	}
}

