package eva.monopolyapi.game.street.streets;

import eva.monopolyapi.game.GameBoard;
import eva.monopolyapi.game.player.Player;

public class BuyableTrainstationStreet extends BuyableStreet {

	public int onestation;
	public int twostations;
	public int threestations;
	public int fourstations;

	public BuyableTrainstationStreet(String name, int mortgageValue, String group, int cost, int onestation,
			int twostations, int threestations, int fourstations) {
		super(name, mortgageValue, group, cost);
		this.onestation = onestation;
		this.twostations = twostations;
		this.threestations = threestations;
		this.fourstations = fourstations;
	}

	public int getOnestation() {
		return onestation;
	}

	public int getTwostations() {
		return twostations;
	}

	public int getThreestations() {
		return threestations;
	}

	public int getFourstations() {
		return fourstations;
	}

	@Override
	protected int getFee(Player p, GameBoard board, int dice) {
		switch (getStreetGroup(p, board, getGroup()).size()) {
		case 1:
			return onestation;
		case 2:
			return twostations;
		case 3:
			return threestations;
		case 4:
			return fourstations;
		default:
			return 0;
		}
	}
}
