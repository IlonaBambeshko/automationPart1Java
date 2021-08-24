package by.automation.part1.lesson7.in_out_system;

public class Employees implements RegisterSystem {
	public final String first_name;
	public final String last_name;
	private static int taken_place_in_office = 0;

	public static int getPlaceInOffice() throws Exception {
		taken_place_in_office++;
		if (taken_place_in_office > 15) {
			throw new Exception("Oops! All seats in office are taken! Try another day");
		}
		return taken_place_in_office;
	}

	Employees(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}

}
