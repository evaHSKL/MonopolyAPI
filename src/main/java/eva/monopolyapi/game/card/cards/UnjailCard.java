package eva.monopolyapi.game.card.cards;

import eva.monopolyapi.game.GameBoard;
import eva.monopolyapi.game.card.Card;
import eva.monopolyapi.game.player.Player;

public class UnjailCard extends Card {

	public UnjailCard(String text, CardType type) {
		super(text, type);
	}

	@Override
	public void action(Player p, GameBoard board) {
		board.pickupCard(this, p);
	}
}
