package eva.monopoly.api.game.street.streets;

import eva.monopoly.api.game.GameBoard;
import eva.monopoly.api.game.player.Player;

public class NonBuyableCommunityStreet extends NonBuyableStreet {

	public NonBuyableCommunityStreet(String name) {
		super(name);
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {
		board.takeCommunityCard().action(p, board);
	}

}
