package eva.monopolyapi.game.card.cards;

import eva.monopolyapi.game.GameBoard;
import eva.monopolyapi.game.card.Card;
import eva.monopolyapi.game.player.Player;
import eva.monopolyapi.game.street.streets.BuyableNormalStreet;
import eva.monopolyapi.game.street.streets.BuyableStreet;

public class MoneybuildingsCard extends Card {
	private int houseCosts;
	private int hotelCosts;

	public MoneybuildingsCard(String text, CardType type, int house, int hotel) {
		super(text, type);
		this.houseCosts = house;
		this.hotelCosts = hotel;
	}

	@Override
	public void action(Player p, GameBoard board) {
		p.modifyMoney(getHouses(p, board) * houseCosts + getHotels(p, board) * hotelCosts);
	}

	private int getHouses(Player p, GameBoard board) {
		int amount = 0;
		for (BuyableStreet i : board.getStreetsOfPlayer(p)) {
			if (i instanceof BuyableNormalStreet) {
				BuyableNormalStreet s = (BuyableNormalStreet) i;
				amount += (s.getHouses() == 5 ? 0 : s.getHouses());
			}
		}
		return amount;
	}

	private int getHotels(Player p, GameBoard board) {
		int amount = 0;
		for (BuyableStreet i : board.getStreetsOfPlayer(p)) {
			if (i instanceof BuyableNormalStreet) {
				BuyableNormalStreet s = (BuyableNormalStreet) i;
				amount += (s.getHouses() == 5 ? 1 : 0);
			}
		}
		return amount;
	}
}
