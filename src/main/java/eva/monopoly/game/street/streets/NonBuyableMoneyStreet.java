package eva.monopoly.game.street.streets;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;

public class NonBuyableMoneyStreet extends NonBuyableStreet {
	private int amount;

	public NonBuyableMoneyStreet(String name, int amount) {
		super(name);
		this.amount = amount;
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {

	}

}
