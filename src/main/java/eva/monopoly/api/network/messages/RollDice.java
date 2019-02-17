package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class RollDice extends ExchangeMessage {
	private static final long serialVersionUID = -4546520837831237947L;

	private final int amount;

	public RollDice(String name) {
		super(name);
		this.amount = 0;
	}

	public RollDice(String name, int amount) {
		super(name);
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
}
