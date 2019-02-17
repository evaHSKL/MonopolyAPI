package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class BuyStreet extends ExchangeMessage {
	private static final long serialVersionUID = -550355880166328499L;

	private final boolean buy;

	public BuyStreet(String name, boolean buy) {
		super(name);
		this.buy = buy;
	}

	public boolean isBuy() {
		return buy;
	}

}
