package eva.monopoly.game;

import java.util.ArrayList;
import java.util.List;

import eva.monopoly.game.card.Card;
import eva.monopoly.game.card.cards.UnjailCard;
import eva.monopoly.game.player.Player;

public class GameBoard {
	private List<Player> players = new ArrayList<>();
	private List<Card> EventCards = new ArrayList<>();
	private List<Card> CommunityCards = new ArrayList<>();

	public GameBoard() {

	}

	public void pickupCard(UnjailCard eventUnjailCard, Player p) {
		// TODO Auto-generated method stub
	}

	public List<Player> getPlayers() {
		return players;
	}
}
