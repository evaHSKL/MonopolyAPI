package eva.monopoly.api.network.messages;

import java.util.List;

import eva.monopoly.api.game.player.Player.Pawn;
import eva.monopoly.api.network.api.ExchangeMessage;

public class GetConnectedClients extends ExchangeMessage {
	private static final long serialVersionUID = 5455503451578318408L;

	private final List<Client> clients;

	public GetConnectedClients(String name, List<Client> clients) {
		super(name);
		this.clients = clients;
	}

	public List<Client> getClients() {
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
