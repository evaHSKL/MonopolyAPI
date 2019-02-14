package eva.monopoly.api.game.street.streets;

import eva.monopoly.api.game.GameBoard;
import eva.monopoly.api.game.player.Player;

public class NonBuyableEventStreet extends NonBuyableStreet {

	public NonBuyableEventStreet(String name) {
		super(name);
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {
		GameBoard.LOG.debug(this.getClass().getSimpleName() + " " + getName() + " was entered by " + p.getName());
		board.takeEventCard().action(p, board);
	}

}
