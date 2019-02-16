package eva.monopoly.api.network.messages;

import java.util.OptionalInt;

import eva.monopoly.api.game.card.Card;
import eva.monopoly.api.network.api.ExchangeMessage;

public class CardPulled extends ExchangeMessage {
	private static final long serialVersionUID = 864136270152575003L;
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
