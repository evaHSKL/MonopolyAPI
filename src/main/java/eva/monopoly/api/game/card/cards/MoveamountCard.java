package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoveamountCard extends Card {
	protected int amount;

	public MoveamountCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}
}
