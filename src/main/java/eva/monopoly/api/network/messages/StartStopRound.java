package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class StartStopRound extends ExchangeMessage {
	private static final long serialVersionUID = 147328409676047602L;

	public StartStopRound(String name) {
		super(name);
	}

}
