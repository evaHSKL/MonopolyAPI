package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class RollDice extends ExchangeMessage {
	private static final long serialVersionUID = -4546520837831237947L;

	private final int amount;
	private final boolean doublets;

	public RollDice(String name) {
		super(name);
		this.amount = 0;
		this.doublets = false;
	}

	public RollDice(String name, int amount, boolean doublets) {
		super(name);
		this.amount = amount;
		this.doublets = doublets;
	}

	public int getAmount() {
		return amount;
	}

	public boolean isDoublets() {
		return doublets;
	}
}
