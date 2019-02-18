package eva.monopoly.api.network.messages;

import eva.monopoly.api.game.street.Street;
import eva.monopoly.api.network.api.ExchangeMessage;

public class StreetEntered extends ExchangeMessage {
	private static final long serialVersionUID = 5726050951454441818L;

	private final Street street;
	private final Integer moneyAmount;
	private final int newMoney;

	public StreetEntered(String name, Street street, Integer moneyAmount, int newMoney) {
		super(name);
		this.street = street;
		this.moneyAmount = moneyAmount;
		this.newMoney = newMoney;
	}

	public Street getStreet() {
		return street;
	}

	public Integer getMoneyAmount() {
		return moneyAmount;
	}

	public int getNewMoney() {
		return newMoney;
	}
}
