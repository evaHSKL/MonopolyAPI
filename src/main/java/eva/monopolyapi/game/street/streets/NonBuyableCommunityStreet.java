package eva.monopolyapi.game.street.streets;

import eva.monopolyapi.game.GameBoard;
import eva.monopolyapi.game.player.Player;

public class NonBuyableCommunityStreet extends NonBuyableStreet {

	public NonBuyableCommunityStreet(String name) {
		super(name);
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {
		board.takeCommunityCard().action(p, board);
	}

}
