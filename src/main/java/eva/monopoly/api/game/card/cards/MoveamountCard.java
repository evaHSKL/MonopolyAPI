package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.GameBoard;
import eva.monopoly.api.game.card.Card;
import eva.monopoly.api.game.player.Player;

public class MoveamountCard extends Card {
	private int amount;

	public MoveamountCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}

	@Override
	public void action(Player p, GameBoard board) {
		GameBoard.LOG.debug(this.getClass().getSimpleName() + " was pulled by Player " + p.getName());
		board.moveAmount(p, amount, 1);
	}
}
