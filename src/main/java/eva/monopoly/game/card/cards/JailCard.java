package eva.monopoly.game.card.cards;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.card.Card;
import eva.monopoly.game.player.Player;

public class JailCard extends Card {

	public JailCard(String text, CardType type) {
		super(text, type);
	}

	@Override
	public void action(Player p, GameBoard board) {
		p.sendToJail();
	}
}
