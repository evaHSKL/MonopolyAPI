package eva.monopoly.game.street.streets;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;

public class NonBuyableEventStreet extends NonBuyableStreet {

	public NonBuyableEventStreet(String name) {
		super(name);
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {
		board.takeEventCard().action(p, board);
	}

}
