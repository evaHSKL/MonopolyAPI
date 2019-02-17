package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class UnjailCard extends Card {
	private static final long serialVersionUID = 1831089346934528586L;

	public UnjailCard(String text, CardType type) {
		super(text, type);
	}
}
