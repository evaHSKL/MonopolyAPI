package eva.monopoly.api.game.street.streets;

import java.util.List;

import eva.monopoly.api.game.player.Player;
import eva.monopoly.api.game.street.BuyableStreet;

public abstract class BuyableNormalStreet extends BuyableStreet {
	private static final long serialVersionUID = -1444467315701507275L;

	private final int nohouse;
	private final int onehouse;
	private final int twohouses;
	private final int threehouses;
	private final int fourhouses;
	private final int hotel;
	private final int housecost;
	private int houses;

	public BuyableNormalStreet(String name, int mortgageValue, String group, int cost, int nohouse, int onehouse,
			int twohouses, int threehouses, int fourhouses, int hotel, int housecost) {
		super(name, mortgageValue, group, cost);
		this.nohouse = nohouse;
		this.onehouse = onehouse;
		this.twohouses = twohouses;
		this.threehouses = threehouses;
		this.fourhouses = fourhouses;
		this.hotel = hotel;
		this.housecost = housecost;
		this.houses = 0;
	}

	public int getNohouse() {
		return nohouse;
	}

	public int getOnehouse() {
		return onehouse;
	}

	public int getTwohouses() {
		return twohouses;
	}

	public int getThreehouses() {
		return threehouses;
	}

	public int getFourhouses() {
		return fourhouses;
	}

	public int getHotel() {
		return hotel;
	}

	public int getHousecost() {
		return housecost;
	}

	public int getHouses() {
		return houses;
	}

	public boolean addHouse(Player p) {
		if (!hasStreetGroup(p, getGroup())) {
			return false;
		}
		List<BuyableStreet> streets = getStreetGroup(p, getGroup());
		for (BuyableStreet s : streets) {
			if (((BuyableNormalStreet) s).houses < houses) {
				return false;
			}
		}
		houses++;
		return true;
	}

	@Override
	protected int getFee(Player p, int dice, int modifier) {
		switch (houses) {
		case 0:
			return nohouse;
		case 1:
			return onehouse;
		case 2:
			return twohouses;
		case 3:
			return threehouses;
		case 4:
			return fourhouses;
		case 5:
			return hotel;
		default:
			return 0;
		}
	}

}
