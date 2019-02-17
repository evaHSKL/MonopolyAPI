package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoneyBuildingsCard extends Card {
	protected final int houseCosts;
	protected final int hotelCosts;

	public MoneyBuildingsCard(String text, CardType type, int house, int hotel) {
		super(text, type);
		this.houseCosts = house;
		this.hotelCosts = hotel;
	}
}
