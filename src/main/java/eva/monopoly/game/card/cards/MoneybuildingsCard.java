package eva.monopoly.game.card.cards;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.card.Card;
import eva.monopoly.game.player.Player;
import eva.monopoly.game.street.Street;

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
		// TODO Auto-generated method stub

	}

	private int getHouses(Player p) {
		// TODO über Liste von Straßen iterieren um Anzahl Häuser in Besitz
		// herauszufinden
		int amount = 0;
		for (Street i : p.getStreets()) {
			// amount += i.getHouse();
		}
		return amount;
	}

	private int getHotels(Player p) {
		// TODO über Liste von Straßen iterieren um Anzahl Hotels in Besitz
		// herauszufinden
		int amount = 0;
		for (Street i : p.getStreets()) {
			// amount += i.getHotel();
		}
		return amount;
	}
}
