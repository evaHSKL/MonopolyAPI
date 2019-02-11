package eva.monopoly.game.street.streets;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;

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
	public void chargeFee(Player p, GameBoard board, int dice, int modifier) {
		Player streetOwner = board.getBuyableStreets().get(this);

		if (streetOwner == null || streetOwner == p) {
			return;
		}

		int fee = getFee(streetOwner, board);
		p.modifyMoney(-fee * modifier);
		streetOwner.modifyMoney(fee * modifier);
	}

	private int getFee(Player p, GameBoard board) {
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
