package eva.monopoly.game.card.cards;

import eva.monopoly.game.card.Card;
import eva.monopoly.game.player.Player;

public class UnjailCard extends Card {

	public UnjailCard(String text, CardType cardType) {
		super(text, cardType);
	}

	@Override
	public void action(Player p) {
		p.pickupCard(this);
	}
}
