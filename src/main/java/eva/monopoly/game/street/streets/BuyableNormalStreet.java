package eva.monopoly.game.street.streets;

import java.util.List;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;

public class BuyableNormalStreet extends BuyableStreet {

	private int nohouse;
	private int onehouse;
	private int twohouses;
	private int threehouses;
	private int fourhouses;
	private int hotel;
	private int housecost;
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

	public boolean addHouse(GameBoard board) {
		Player p = board.getBuyableStreets().get(this);
		if (!hasStreetGroup(p, board, getGroup())) {
			return false;
		}
		List<BuyableStreet> streets = getStreetGroup(p, board, getGroup());
		for (BuyableStreet s : streets) {
			if (((BuyableNormalStreet) s).houses < houses) {
				return false;
			}
		}
		houses++;
		return true;
	}

	@Override
	protected int getFee(Player p, GameBoard board, int dice) {
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
