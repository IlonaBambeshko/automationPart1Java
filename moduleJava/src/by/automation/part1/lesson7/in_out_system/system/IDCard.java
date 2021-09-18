package by.automation.part1.lesson7.in_out_system.system;

import static java.util.UUID.randomUUID;

public class IDCard {
	private String idCard;

	private IDCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIDCard() {
		return idCard;
	}

	public static IDCard generateIDCard() {
		return new IDCard(randomUUID().toString().replaceAll("-", "").substring(0, 10));
	}
}
