package eva.monopoly.game.card.cards;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.card.Card;
import eva.monopoly.game.player.Player;

public class MovenextCard extends Card {
	private String target;

	public MovenextCard(String text, CardType type, String target) {
		super(text, type);
		this.target = target;
	}

	@Override
	public void action(Player p, GameBoard board) {
		// TODO Auto-generated method stub

	}

}
