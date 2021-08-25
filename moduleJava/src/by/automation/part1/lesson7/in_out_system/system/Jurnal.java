package by.automation.part1.lesson7.in_out_system.system;

import java.util.ArrayList;

import static java.util.UUID.randomUUID;

public class Jurnal {
	private static int takenPlaceInOffice = 0;
	static ArrayList<ArrayList<String>> employeesAll = new ArrayList<>();
	private static int maximumPlacesInOffice;

	public Jurnal(int maximumPlacesInOffice) {
		this.maximumPlacesInOffice = maximumPlacesInOffice;
	}

	public static void getPlaceInOffice() throws Exception {
		takenPlaceInOffice++;
		if (takenPlaceInOffice > maximumPlacesInOffice) {
			throw new Exception("Oops! All seats in office are taken! Try another day");
		}
	}

	public static String generateCodeForIDCard() {
		return randomUUID().toString();
	}

	public static String registerEmployee(String name, String last_name) throws Exception {
		getPlaceInOffice();

		ArrayList<String> employeeData = new ArrayList<>();
		employeeData.add(name);
		employeeData.add(last_name);
		String idCard = generateCodeForIDCard();
		employeeData.add(idCard);
		employeesAll.add(employeeData);

		return idCard;
	}
}
