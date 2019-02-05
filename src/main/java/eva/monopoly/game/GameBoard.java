package eva.monopoly.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import eva.monopoly.game.card.Card;
import eva.monopoly.game.card.Cards;
import eva.monopoly.game.player.Player;
import eva.monopoly.game.street.Street;
import eva.monopoly.game.street.Streets;
import eva.monopoly.game.street.streets.BuyableStreet;

public class GameBoard {
	private List<Player> players;
	private List<Card> eventCards;
	private List<Card> communityCards;
	private Map<BuyableStreet, Player> buyableStreets;
	private final ArrayList<Street> streets;

	public GameBoard() {
		players = new ArrayList<>();
		Entry<ArrayList<Card>, ArrayList<Card>> loadedcards = Cards.loadCards();
		eventCards = loadedcards.getKey();
		communityCards = loadedcards.getValue();
		streets = Streets.loadStreets();
		for (Street s : streets) {
			if (s instanceof BuyableStreet) {
				buyableStreets.put((BuyableStreet) s, null);
			}
		}
	}
}
