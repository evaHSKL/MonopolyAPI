package eva.monopoly.game.card.cards;

import eva.monopoly.game.card.Card;
import eva.monopoly.game.player.Player;

public class MoneyplayerCard extends Card {
	int amount;
	public MoneyplayerCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}

	@Override
	public void action(Player p) {
		// TODO jeder Spieler erhält 50 M von dir
	}

}
