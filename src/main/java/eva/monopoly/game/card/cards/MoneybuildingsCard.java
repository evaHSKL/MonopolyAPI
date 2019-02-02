package eva.monopoly.game.card.cards;

import eva.monopoly.game.card.Card;
import eva.monopoly.game.player.Player;

public class MoneybuildingsCard extends Card {
	int house;
	int hotel;

	public MoneybuildingsCard(String text, CardType type, int house, int hotel) {
		super(text, type);
		this.house = house;
		this.hotel = hotel;
	}

	@Override
	public void action(Player p) {
		int amount1 = p.getHouses() * house;
		int amount2 = p.getHotels() * hotel;
		p.modifyMoney(amount1 + amount2);
	}

}
