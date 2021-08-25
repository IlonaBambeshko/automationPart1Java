package by.automation.part1.lesson7.in_out_system.employees;

import by.automation.part1.lesson7.in_out_system.RegisterSystem;

public class Employee implements RegisterSystem {
	public final String firstName;
	public final String lastName;
	private static int takenPlaceInOffice = 0;
	private static int maximumPlacesInOffice = 20;

	public static int getPlaceInOffice() throws Exception {
		takenPlaceInOffice++;
		if (takenPlaceInOffice > maximumPlacesInOffice) {
			throw new Exception("Oops! All seats in office are taken! Try another day");
		}
		return takenPlaceInOffice;
	}

	public static int setMaximumPlacesOfOffice(int maximumPlaces){
		maximumPlacesInOffice = maximumPlaces;
		return maximumPlacesInOffice;
	}

	protected Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
