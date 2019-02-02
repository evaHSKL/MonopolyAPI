package eva.monopoly.game.card.cards;

import eva.monopoly.game.card.Card;
import eva.monopoly.game.player.Player;

public class MoneyCard extends Card {
	private int amount;

	public MoneyCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}

	@Override
	public void action(Player p) {
		p.modifyMoney(amount);
	}

}
