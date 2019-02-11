package eva.monopolyapi.game.card.cards;

import eva.monopolyapi.game.GameBoard;
import eva.monopolyapi.game.card.Card;
import eva.monopolyapi.game.player.Player;

public class MoveCard extends Card {
	private String target;

	public MoveCard(String text, CardType type, String target) {
		super(text, type);
		this.target = target;
	}

	@Override
	public void action(Player p, GameBoard board) {
		board.moveTarget(p, target, 1);
	}

}
