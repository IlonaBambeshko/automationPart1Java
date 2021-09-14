package by.automation.part1.lesson7.in_out_system.system;

// TODO: 9/14/2021 Class exception must contains postfix 'Exception' [Pavel.Chachotkin]
public class EmployeeHasNotAccessToEnter extends Exception {
	public EmployeeHasNotAccessToEnter(String message) {
		super(message);
	}
}
