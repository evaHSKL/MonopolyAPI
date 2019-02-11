package eva.monopolyapi.game.street.streets;

import eva.monopolyapi.game.GameBoard;
import eva.monopolyapi.game.player.Player;

public class NonBuyableNormalStreet extends NonBuyableStreet {

	public NonBuyableNormalStreet(String name) {
		super(name);
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {
	}

}
