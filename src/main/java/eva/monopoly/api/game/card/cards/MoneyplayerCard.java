package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoneyplayerCard extends Card {
	protected int amount;

	public MoneyplayerCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}
}
