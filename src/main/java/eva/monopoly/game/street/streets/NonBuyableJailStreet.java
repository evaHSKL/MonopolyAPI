package eva.monopoly.game.street.streets;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;

public class NonBuyableJailStreet extends NonBuyableStreet{

	public NonBuyableJailStreet(String name) {
		super(name);
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {
		// TODO send Player to jail
	}

}
