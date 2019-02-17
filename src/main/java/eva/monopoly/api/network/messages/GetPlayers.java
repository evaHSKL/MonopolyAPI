package eva.monopoly.api.network.messages;

import java.util.List;

import eva.monopoly.api.game.player.Player;
import eva.monopoly.api.network.api.ExchangeMessage;

public class GetPlayers extends ExchangeMessage {
	private static final long serialVersionUID = 2525984343606638234L;

	private final List<Player> players;

	public GetPlayers(String name, List<Player> players) {
		super(name);
		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}

}
