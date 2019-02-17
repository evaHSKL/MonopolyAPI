package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class StartRound extends ExchangeMessage {
	private static final long serialVersionUID = 147328409676047602L;

	public StartRound(String name) {
		super(name);
	}

}
