package eva.monopoly.game.street.streets;

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

	@Override
	public int calculateCosts(Player p, GameBoard board, int dice, int modifier) {
		// TODO Auto-generated method stub
		return 0;
	}

}
