package eva.monopoly.api.game.street.streets;

import eva.monopoly.api.game.player.Player;
import eva.monopoly.api.game.street.BuyableStreet;

public abstract class BuyableFactoryStreet extends BuyableStreet {
	private static final long serialVersionUID = 4728362737692371900L;

	private final int factorsingle;
	private final int factorgroup;

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
	protected int getFee(Player p, int dice, int modifier) {
		if (modifier != 1) {
			return dice * modifier;
		}
		if (hasStreetGroup(p, getGroup())) {
			return factorgroup * dice;
		}
		return factorsingle * dice;
	}

}
