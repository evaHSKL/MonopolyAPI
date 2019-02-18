package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class StartStopRound extends ExchangeMessage {
	private static final long serialVersionUID = 147328409676047602L;

	private final int newMoney;
	private final int newPosition;

	public StartStopRound(String name) {
		super(name);
		this.newMoney = -1;
		this.newPosition = -1;
	}

	public StartStopRound(String name, int newMoney, int newPosition) {
		super(name);
		this.newMoney = newMoney;
		this.newPosition = newPosition;
	}

	public int getNewMoney() {
		return newMoney;
	}

	public int getNewPosition() {
		return newPosition;
	}

}
