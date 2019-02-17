package eva.monopoly.api.game.card;

import java.io.Serializable;

import eva.monopoly.api.game.player.Player;

public abstract class Card implements Serializable {
	private static final long serialVersionUID = -2539896488029253520L;

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
