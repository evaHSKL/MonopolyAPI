package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoneyCard extends Card {
	protected int amount;

	public MoneyCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}

}
