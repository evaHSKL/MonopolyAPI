package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.GameBoard;
import eva.monopoly.api.game.card.Card;
import eva.monopoly.api.game.player.Player;

public class MoveCard extends Card {
	private String target;

	public MoveCard(String text, CardType type, String target) {
		super(text, type);
		this.target = target;
	}

	@Override
	public void action(Player p, GameBoard board) {
		GameBoard.LOG.debug(this.getClass().getSimpleName() + " was pulled by Player " + p.getName());
		board.moveTarget(p, target, 1);
	}

}
