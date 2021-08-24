package by.automation.part1.lesson7.in_out_system;

public enum IDCards {
	QWERTYUI01(1),
	QWERTYUI02(2),
	QWERTYUI03(3),
	QWERTYUI04(4),
	QWERTYUI05(5),
	QWERTYUI06(6),
	QWERTYUI07(7),
	QWERTYUI08(8),
	QWERTYUI09(9),
	QWERTYUI10(10),
	QWERTYUI11(11),
	QWERTYUI12(12),
	QWERTYUI13(13),
	QWERTYUI14(14),
	QWERTYUI15(15);

	private final int serial_number;

	IDCards(int serial_number) {
		this.serial_number = serial_number;
	}

	public int getSerial_number() {
		return serial_number;
	}

	public static String getIDCardBySerialNumber(int serial_number) {
		for (int i = 0; i < IDCards.values().length; i++) {
			if (IDCards.values()[i].getSerial_number() == serial_number){
				return IDCards.values()[i].name();
			}
		}
		return "Office is full!";
	}


}
