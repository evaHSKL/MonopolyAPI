package eva.monopoly.api.network.messages;

import eva.monopoly.api.game.player.Player.Pawn;
import eva.monopoly.api.network.api.ExchangeMessage;

public class PawnChanged extends ExchangeMessage {
	private static final long serialVersionUID = 8895165723315803824L;
	private final Pawn pawn;

	public PawnChanged(Pawn pawn) {
		super();
		this.pawn = pawn;
	}

	public PawnChanged(String name, Pawn pawn) {
		super(name);
		this.pawn = pawn;
	}

	public Pawn getPawn() {
		return pawn;
	}
}
