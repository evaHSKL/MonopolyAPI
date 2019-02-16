package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class PlayerStatusChanged extends ExchangeMessage {
	private static final long serialVersionUID = -8249279662315508713L;

	private final ConnectionState state;

	public PlayerStatusChanged(String name, ConnectionState state) {
		super(name);
		this.state = state;
	}

	public ConnectionState getState() {
		return state;
	}

	public static enum ConnectionState {
		CONNECTED, DISCONNECTED, LOSTCONNECTION, RECONNECTED;
	}
}
