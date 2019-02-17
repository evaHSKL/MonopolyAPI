package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class JailCard extends Card {
	private static final long serialVersionUID = -6734757715161877608L;

	public JailCard(String text, CardType type) {
		super(text, type);
	}
}
