package eva.monopolyapi.game.street.streets;

import eva.monopolyapi.game.GameBoard;
import eva.monopolyapi.game.player.Player;
import eva.monopolyapi.game.street.Street;

public abstract class NonBuyableStreet extends Street {

	public NonBuyableStreet(String name) {
		super(name);
	}

	public abstract void action(Player p, GameBoard board, int dice);
}
