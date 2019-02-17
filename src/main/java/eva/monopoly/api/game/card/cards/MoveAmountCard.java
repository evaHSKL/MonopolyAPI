package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoveAmountCard extends Card {
	protected final int amount;
	protected final int moneyModyfire;

	public MoveAmountCard(String text, CardType type, int amount, int moneyModyfire) {
		super(text, type);
		this.amount = amount;
		this.moneyModyfire = moneyModyfire;
	}
}
