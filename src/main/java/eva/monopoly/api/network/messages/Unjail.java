package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class Unjail extends ExchangeMessage {
	private static final long serialVersionUID = -7488473280417125732L;

	private final UnjailReason reason;

	public Unjail(String name, UnjailReason reason) {
		super(name);
		this.reason = reason;
	}

	public UnjailReason getReason() {
		return reason;
	}

	public static enum UnjailReason {
		PAYED, CARD;
	}
}
