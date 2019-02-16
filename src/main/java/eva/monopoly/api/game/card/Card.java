package eva.monopoly.api.game.card;

import eva.monopoly.api.game.player.Player;

public abstract class Card {
	private String text;
	private CardType type;

	public Card(String text, CardType type) {
		this.text = text;
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public CardType getType() {
		return type;
	}

	public abstract void action(Player p);

	public static enum CardType {
		EVENT, COMMUNITY;
	}
}
