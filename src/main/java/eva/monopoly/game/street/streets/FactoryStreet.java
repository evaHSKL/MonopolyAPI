package eva.monopoly.game.street.streets;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;
import eva.monopoly.game.street.Street;

public class FactoryStreet extends Street {

	private int factorsingle;
	private int factorgroup;

	public FactoryStreet(String name, int mortgageValue, String group, int cost, int factorsingle, int factorgroup) {
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
	public int calculateCosts(Player p, GameBoard board, int dice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
