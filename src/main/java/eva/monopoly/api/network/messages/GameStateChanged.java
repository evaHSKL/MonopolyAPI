package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class GameStateChanged extends ExchangeMessage {
	private static final long serialVersionUID = -2752293858671047996L;

	private final GameState gameState;

	public GameStateChanged(String name, GameState gameState) {
		super(name);
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return gameState;
	}

	public static enum GameState {
		PREGAME, READY, INGAME, FINISED;
	}
}
