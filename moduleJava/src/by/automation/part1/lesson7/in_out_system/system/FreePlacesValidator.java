package by.automation.part1.lesson7.in_out_system.system;

public class FreePlacesValidator {

	public static void validateFreePlacesInOffice(int placesCount) throws NoAvailablePlacesException {
		if (placesCount <= 0) {
			throw new NoAvailablePlacesException("Error! There are no free places in Office!");
		}
	}
}
