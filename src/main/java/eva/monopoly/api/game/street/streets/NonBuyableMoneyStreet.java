package eva.monopoly.api.game.street.streets;

import eva.monopoly.api.game.GameBoard;
import eva.monopoly.api.game.player.Player;

public class NonBuyableMoneyStreet extends NonBuyableStreet {
	private int amount;

	public NonBuyableMoneyStreet(String name, int amount) {
		super(name);
		this.amount = amount;
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {
		GameBoard.LOG.debug(this.getClass().getSimpleName() + " " + getName() + " was entered by " + p.getName());
		p.modifyMoney(amount);
	}

}
