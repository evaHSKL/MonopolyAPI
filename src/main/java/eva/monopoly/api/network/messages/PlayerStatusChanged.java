package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class PlayerStatusChanged extends ExchangeMessage {

	private static final long serialVersionUID = 1L;
	private final ConnectionState state;

	public PlayerStatusChanged(ConnectionState state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ConnectionState getState() {
		return state;
	}

	public static enum ConnectionState {
		CONNECTED, DISCONNECTED, LOSTCONNECTION, RECONNECTED;
	}
}
