package eva.monopoly.game.street.streets;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;
import eva.monopoly.game.street.Street;

public abstract class BuyableStreet extends Street {
	private int mortgageValue;
	private String group;
	private int cost;

	public BuyableStreet(String name, int mortgageValue, String group, int cost) {
		super(name);
		this.mortgageValue = mortgageValue;
		this.group = group;
		this.cost = cost;
	}

	public int getMortgageValue() {
		return mortgageValue;
	}

	public String getGroup() {
		return group;
	}

	public int getCost() {
		return cost;
	}

	public abstract int calculateCosts(Player p, GameBoard board, int dice);
}
