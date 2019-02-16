package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class ReadyStatusChanged extends ExchangeMessage {

	private static final long serialVersionUID = -2752293858671047996L;

	public ReadyStatusChanged(String name) {
		super(name);
	}
}
