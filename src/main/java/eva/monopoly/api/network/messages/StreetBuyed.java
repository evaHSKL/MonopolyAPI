package eva.monopoly.api.network.messages;

import eva.monopoly.api.game.street.BuyableStreet;
import eva.monopoly.api.network.api.ExchangeMessage;

public class StreetBuyed extends ExchangeMessage {
	private static final long serialVersionUID = 550164991138143917L;

	private final BuyableStreet street;
	private final int newMoney;

	public StreetBuyed(String name, BuyableStreet street, int newMoney) {
		super(name);
		this.street = street;
		this.newMoney = newMoney;
	}

	public BuyableStreet getStreet() {
		return street;
	}

	public int getNewMoney() {
		return newMoney;
	}

}
