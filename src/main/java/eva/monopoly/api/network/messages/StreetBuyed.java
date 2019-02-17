package eva.monopoly.api.network.messages;

import eva.monopoly.api.game.street.BuyableStreet;
import eva.monopoly.api.network.api.ExchangeMessage;

public class StreetBuyed extends ExchangeMessage {
	private static final long serialVersionUID = 550164991138143917L;

	private final BuyableStreet street;

	public StreetBuyed(String name, BuyableStreet street) {
		super(name);
		this.street = street;
	}

	public BuyableStreet getStreet() {
		return street;
	}
}
