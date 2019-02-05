package eva.monopoly.game.street.streets;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;
import eva.monopoly.game.street.Street;

public abstract class NonBuyableStreet extends Street {

	public NonBuyableStreet(String name) {
		super(name);
	}

	public abstract void action(Player p, GameBoard board, int dice);
}
