package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoneybuildingsCard extends Card {
	protected int houseCosts;
	protected int hotelCosts;

	public MoneybuildingsCard(String text, CardType type, int house, int hotel) {
		super(text, type);
		this.houseCosts = house;
		this.hotelCosts = hotel;
	}
}
