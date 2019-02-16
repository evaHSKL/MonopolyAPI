package eva.monopoly.api.network.api.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class Heartbeat extends ExchangeMessage {
	private static final long serialVersionUID = -6544520651393579329L;

	public Heartbeat(String name) {
		super(name);
	}
}
