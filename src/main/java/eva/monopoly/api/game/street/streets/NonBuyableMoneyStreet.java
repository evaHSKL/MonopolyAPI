package eva.monopoly.api.game.street.streets;

import eva.monopoly.api.game.street.NonBuyableStreet;

public abstract class NonBuyableMoneyStreet extends NonBuyableStreet {
	protected int amount;

	public NonBuyableMoneyStreet(String name, int amount) {
		super(name);
		this.amount = amount;
	}
}
