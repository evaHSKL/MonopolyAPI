package eva.monopolyapi.game.street.streets;

import eva.monopolyapi.game.GameBoard;
import eva.monopolyapi.game.player.Player;

public class NonBuyableMoneyStreet extends NonBuyableStreet {
	private int amount;

	public NonBuyableMoneyStreet(String name, int amount) {
		super(name);
		this.amount = amount;
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {
		p.modifyMoney(amount);
	}

}
