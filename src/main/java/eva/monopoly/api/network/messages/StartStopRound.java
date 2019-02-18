package eva.monopoly.api.network.messages;

import eva.monopoly.api.game.player.Player;
import eva.monopoly.api.network.api.ExchangeMessage;

public class StartStopRound extends ExchangeMessage {
	private static final long serialVersionUID = 147328409676047602L;

	private final Player player;

	public StartStopRound(String name) {
		super(name);
		this.player = null;
	}

	public StartStopRound(String name, Player player) {
		super(name);
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

}
