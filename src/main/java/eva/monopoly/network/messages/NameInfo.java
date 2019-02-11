package eva.monopoly.network.messages;

import eva.monopoly.network.api.ExchangeMessage;

public class NameInfo extends ExchangeMessage {
	private static final long serialVersionUID = 3601976405972934497L;
	private final String name;

	public NameInfo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
