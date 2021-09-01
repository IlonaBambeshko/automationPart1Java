package by.automation.part1.lesson7.in_out_system.system;

// TODO: 9/1/2021 Rewrite constant names by UPPER_SNAKE_CASE
// [Pavel.Chachotkin]
public enum Status {
	NOTPRESENT("Employee not present"),
	OUTOFOFFICE("Employee is Out ofOffice"),
	INOFFICE("Employee is in Office"),
	INOFFICEWITHOUTIDCARD("Employee is in Office without card");

	private final String value;

	Status(final String value) {
		this.value = value;
	}
}

