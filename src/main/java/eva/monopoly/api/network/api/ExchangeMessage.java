package eva.monopoly.api.network.api;

import java.io.Serializable;

public abstract class ExchangeMessage implements Serializable {
	private final String name;

	public ExchangeMessage(String name) {
		this.name = name;
	}

	public ExchangeMessage() {
		this.name = null;
	}

	public String getName() {
		return name;
	}

	private static final long serialVersionUID = -2894938167336591768L;

}
