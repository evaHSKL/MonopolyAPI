package eva.monopoly.api.network.messages;

import java.util.List;

import eva.monopoly.api.game.card.Card;
import eva.monopoly.api.network.api.ExchangeMessage;

public class GetCards extends ExchangeMessage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6182294163169916541L;
	private final List<Card> cards;
	public GetCards(String name) {
		super(name);
		this.cards = null;
		// TODO Auto-generated constructor stub
	}
	public GetCards(String name, List<Card> cards) {
		super(name);
		this.cards = cards;
	}
	public List<Card> getCards() {
		return cards;
	}
}
