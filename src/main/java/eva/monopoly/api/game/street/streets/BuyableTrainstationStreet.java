package eva.monopoly.api.game.street.streets;

import eva.monopoly.api.game.player.Player;
import eva.monopoly.api.game.street.BuyableStreet;

public abstract class BuyableTrainstationStreet extends BuyableStreet {
	private static final long serialVersionUID = 2362859921197668094L;

	private final int onestation;
	private final int twostations;
	private final int threestations;
	private final int fourstations;

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
	protected int getFee(Player p, int dice, int modifier) {
		switch (getStreetGroup(p, getGroup()).size()) {
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
