package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoveTargetCard extends Card {
	protected final String target;
	protected final int moneyModyfire;

	public MoveTargetCard(String text, CardType type, String target, int moneyModyfire) {
		super(text, type);
		this.target = target;
		this.moneyModyfire = moneyModyfire;
	}

}
