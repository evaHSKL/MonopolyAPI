package eva.monopoly.api.network.messages;

import java.util.Map;

import eva.monopoly.api.game.player.Player.Pawn;
import eva.monopoly.api.network.api.ExchangeMessage;

public class GetConnectedClients extends ExchangeMessage {
	private static final long serialVersionUID = 5455503451578318408L;

	private final Map<String, Client> clients;

	public GetConnectedClients(String name) {
		super(name);
		this.clients = null;
	}

	public GetConnectedClients(Map<String, Client> clients) {
		super(null);
		this.clients = clients;
	}

	public Map<String, Client> getClients() {
		return clients;
	}

	public static class Client {
		private boolean ready;
		private Pawn playerPawn;

		public Client(boolean ready, Pawn playerPawn) {
			this.ready = ready;
			this.playerPawn = playerPawn;
		}

		public boolean isReady() {
			return ready;
		}

		public void setReady(boolean ready) {
			this.ready = ready;
		}

		public Pawn getPlayerPawn() {
			return playerPawn;
		}

		public void setPlayerPawn(Pawn playerPawn) {
			this.playerPawn = playerPawn;
		}
	}
}
