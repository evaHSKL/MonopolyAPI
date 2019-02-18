package eva.monopoly.api.network.messages;

import java.util.List;

import eva.monopoly.api.game.street.BuyableStreet;
import eva.monopoly.api.network.api.ExchangeMessage;

public class GetStreets extends ExchangeMessage {
	private static final long serialVersionUID = -1303534427156165466L;

	private final List<BuyableStreet> streets;

	public GetStreets(String name) {
		super(name);
		this.streets = null;
	}

	public GetStreets(String name, List<BuyableStreet> streets) {
		super(name);
		this.streets = streets;
	}

	public List<BuyableStreet> getStreets() {
		return streets;
	}
}
