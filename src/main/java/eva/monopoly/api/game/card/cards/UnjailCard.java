package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.GameBoard;
import eva.monopoly.api.game.card.Card;
import eva.monopoly.api.game.player.Player;

public class UnjailCard extends Card {

	public UnjailCard(String text, CardType type) {
		super(text, type);
	}

	@Override
	public void action(Player p, GameBoard board) {
		GameBoard.LOG.debug(this.getClass().getSimpleName() + " was pulled by Player " + p.getName());
		board.pickupCard(this, p);
	}
}
