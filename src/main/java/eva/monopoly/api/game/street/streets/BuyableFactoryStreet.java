package eva.monopoly.api.game.street.streets;

import eva.monopoly.api.game.GameBoard;
import eva.monopoly.api.game.player.Player;

public class BuyableFactoryStreet extends BuyableStreet {

	private int factorsingle;
	private int factorgroup;

	public BuyableFactoryStreet(String name, int mortgageValue, String group, int cost, int factorsingle,
			int factorgroup) {
		super(name, mortgageValue, group, cost);
		this.factorsingle = factorsingle;
		this.factorgroup = factorgroup;
	}

	public int getFactorsingle() {
		return factorsingle;
	}

	public int getFactorgroup() {
		return factorgroup;
	}

	@Override
	protected int getFee(Player p, GameBoard board, int dice) {
		if (hasStreetGroup(p, board, getGroup())) {
			return factorgroup * dice;
		}
		return factorsingle * dice;
	}

}
