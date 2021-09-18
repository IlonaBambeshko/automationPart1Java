package by.automation.part1.lesson7.in_out_system.system;

public class FreePlacesValidator {

	public static int availablePlacesCount(){
		return Office.getMaximumPlacesInOffice() - Office.getTakenPlaceInOffice();
	}

	public static void validateFreePlacesInOffice() throws NoAvailablePlacesException {
		if (availablePlacesCount() <= 0) {
			throw new NoAvailablePlacesException("Error! There are no free places in Office!");
		}
	}
}
