package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MovemoneydoubleCard extends Card {
	protected String target;

	public MovemoneydoubleCard(String text, CardType type, String target) {
		super(text, type);
		this.target = target;
	}

}
