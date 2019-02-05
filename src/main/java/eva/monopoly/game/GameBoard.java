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

public class GameBoard {
	private List<Player> players;
	private List<Card> eventCards;
	private List<Card> communityCards;
	private Map<Street, Player> streets;


	public GameBoard() {
		players = new ArrayList<>();
		Entry<ArrayList<Card>, ArrayList<Card>> loadedcards = Cards.loadCards();
		eventCards = loadedcards.getKey();
		communityCards = loadedcards.getValue();
		for (Street s : Streets.loadStreets()) {
			streets.put(s, null);
		}
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Map<Street, Player> getStreets() {
		return streets;
	}
}
