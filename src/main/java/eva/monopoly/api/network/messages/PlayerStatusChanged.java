package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class PlayerStatusChanged extends ExchangeMessage {

	private static final long serialVersionUID = 1L;
	private final String name;
	private final ConnectionState state;

	public PlayerStatusChanged(ConnectionState state) {
		this.name = null;
		this.state = state;
	}

	public PlayerStatusChanged(String name, ConnectionState state) {
		this.name = name;
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public ConnectionState getState() {
		return state;
	}

	public static enum ConnectionState {
		CONNECTED, DISCONNECTED, LOSTCONNECTION, RECONNECTED;
	}
}
