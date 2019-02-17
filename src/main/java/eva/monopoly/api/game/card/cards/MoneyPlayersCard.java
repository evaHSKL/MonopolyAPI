package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoneyPlayersCard extends Card {
	protected final int amount;

	public MoneyPlayersCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}
}
