package eva.monopoly.api.game.street.streets;

import eva.monopoly.api.game.GameBoard;
import eva.monopoly.api.game.player.Player;
import eva.monopoly.api.game.street.Street;

public abstract class NonBuyableStreet extends Street {

	public NonBuyableStreet(String name) {
		super(name);
	}

	public abstract void action(Player p, GameBoard board, int dice);
}
