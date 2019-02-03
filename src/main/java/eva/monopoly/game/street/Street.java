package eva.monopoly.game.street;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;

public abstract class Street {
	private String name;
	private int mortgageValue;
	private String group;
	private int cost;

	public Street(String name, int mortgageValue, String group, int cost) {
		this.name = name;
		this.mortgageValue = mortgageValue;
		this.group = group;
		this.cost = cost;
	}

	public String getName() {
		return name;
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
