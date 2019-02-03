package eva.monopoly.game.card.cards;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.card.Card;
import eva.monopoly.game.player.Player;

public class MoneybuildingsCard extends Card {
	private int houseCosts;
	private int hotelCosts;

	public MoneybuildingsCard(String text, CardType type, int house, int hotel) {
		super(text, type);
		this.houseCosts = house;
		this.hotelCosts = hotel;
	}

	@Override
	public void action(Player p, GameBoard board) {
		// TODO Auto-generated method stub

	}

}
