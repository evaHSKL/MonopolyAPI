package eva.monopoly.game.street.streets;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;

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
	public void chargeFee(Player p, GameBoard board, int dice, int modifier) {
		Player streetOwner = board.getBuyableStreets().get(this);

		if (streetOwner == null || streetOwner == p) {
			return;
		}

		int fee = getFee(streetOwner, board, dice);
		p.modifyMoney(-fee * modifier);
		streetOwner.modifyMoney(fee * modifier);
	}

	private int getFee(Player p, GameBoard board, int dice) {
		if (hasStreetGroup(p, board, getGroup())) {
			return factorgroup * dice;
		}
		return factorsingle * dice;
	}

}
