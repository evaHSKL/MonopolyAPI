package eva.monopoly.api.network.messages;

import eva.monopoly.api.game.street.Street;
import eva.monopoly.api.network.api.ExchangeMessage;

public class GetStreet extends ExchangeMessage {
	private static final long serialVersionUID = 8318618029333772408L;

	private final Street street;

	public GetStreet(String name) {
		super(name);
		this.street = null;
	}

	public GetStreet(String name, Street street) {
		super(name);
		this.street = street;
	}

	public Street getStreet() {
		return street;
	}

}
