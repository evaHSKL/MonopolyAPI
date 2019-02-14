package eva.monopoly.api.network.messages;

import eva.monopoly.api.game.player.Player.Pawn;
import eva.monopoly.api.network.api.ExchangeMessage;

public class PawnChanged extends ExchangeMessage {

	private static final long serialVersionUID = 8895165723315803824L;
	private final Pawn pawn;

	public PawnChanged(Pawn pawn) {
		this.pawn = pawn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Pawn getPawn() {
		return pawn;
	}

}
