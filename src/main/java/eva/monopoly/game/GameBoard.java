package eva.monopoly.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import eva.monopoly.game.card.Card;
import eva.monopoly.game.card.cards.UnjailCard;
import eva.monopoly.game.player.Player;
import eva.monopoly.game.street.Street;

public class GameBoard {
	private List<Player> players = new ArrayList<>();
	private List<Card> EventCards = new ArrayList<>();
	private List<Card> CommunityCards = new ArrayList<>();
	private Map<Street, Player> streets = new HashMap<>();

	public GameBoard() {

	}

	public void pickupCard(UnjailCard eventUnjailCard, Player p) {
		// TODO Auto-generated method stub
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setStreetOwner(Street s, Player p) {
		streets.put(s, p);
	}

	public Map<Street, Player> getStreets() {
		return streets;
	}
}
