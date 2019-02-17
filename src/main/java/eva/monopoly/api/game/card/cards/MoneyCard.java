package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoneyCard extends Card {
	private static final long serialVersionUID = -5216561556453970152L;

	protected final int amount;

	public MoneyCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}

}
