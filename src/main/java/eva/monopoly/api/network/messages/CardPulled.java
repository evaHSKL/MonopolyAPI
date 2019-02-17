package eva.monopoly.api.network.messages;

import java.util.OptionalInt;

import eva.monopoly.api.game.card.Card;
import eva.monopoly.api.network.api.ExchangeMessage;

public class CardPulled extends ExchangeMessage {
	private static final long serialVersionUID = 864136270152575003L;

	private final Card card;
	private final OptionalInt moneyAmount;
	private final OptionalInt positionAmount;
	private final int newMoney;
	private final int newPosition;

	public CardPulled(String name, Card card, OptionalInt moneyAmount, int newMoney, OptionalInt positionAmount,
			int newPosition) {
		super(name);
		this.card = card;
		this.moneyAmount = moneyAmount;
		this.newMoney = newMoney;
		this.positionAmount = positionAmount;
		this.newPosition = newPosition;
	}

	public Card getCard() {
		return card;
	}

	public OptionalInt getMoneyAmount() {
		return moneyAmount;
	}

	public int getNewMoney() {
		return newMoney;
	}

	public OptionalInt getPositionAmount() {
		return positionAmount;
	}

	public int getNewPosition() {
		return newPosition;
	}
}
