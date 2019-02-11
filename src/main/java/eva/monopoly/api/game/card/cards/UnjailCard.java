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
		board.pickupCard(this, p);
	}
}
