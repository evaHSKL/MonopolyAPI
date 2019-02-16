package eva.monopoly.api.network.messages;

import java.util.OptionalInt;

import eva.monopoly.api.game.card.Card;

public class CardPulled {
	private final Card card;
	private final OptionalInt moneyAmount;

	public CardPulled(Card card, OptionalInt moneyAmount) {
		super();
		this.card = card;
		this.moneyAmount = moneyAmount;
	}

	public Card getCard() {
		return card;
	}

	public OptionalInt getMoneyAmount() {
		return moneyAmount;
	}
}
