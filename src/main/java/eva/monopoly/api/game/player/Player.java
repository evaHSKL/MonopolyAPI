package eva.monopoly.api.game.player;

import java.util.ArrayList;
import java.util.List;

import eva.monopoly.api.game.card.Card;
import eva.monopoly.api.game.card.cards.UnjailCard;
import eva.monopoly.api.game.street.BuyableStreet;

public class Player {
	private static final int START_MONEY = 1500;
	private static final int START_POS = 0;
	private String name;
	private int money;
	private Pawn playerPawn;
	private int jailed;
	private int positionIndex;
	private List<BuyableStreet> streets;
	private List<Card> cards;

	public Player(String name, Pawn playerPawn) {
		money = START_MONEY;
		positionIndex = START_POS;
		this.name = name;
		this.playerPawn = playerPawn;
		jailed = 0;
		streets = new ArrayList<BuyableStreet>();
	}

	public Pawn getPawn() {
		return playerPawn;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public int getPositionIndex() {
		return positionIndex;
	}

	public void setPositionIndex(int positionIndex) {
		this.positionIndex = positionIndex;
	}

	public void modifyMoney(int money) {
		this.money += money;
	}

	public void transferMoney(Player p, int money) {
		modifyMoney(-money);
		p.modifyMoney(money);
	}

	public void jail() {
		positionIndex = 10;
		jailed = 1;
	}

	public void unjail() {
		jailed = 0;
	}

	public boolean isJailed() {
		return jailed != 0;
	}

	public boolean hasToLeaveJail() {
		if (jailed == 3) {
			return true;
		}
		jailed++;
		return false;
	}

	public boolean useUnjailCard() {
		for (Card c : cards) {
			if (c instanceof UnjailCard) {
				cards.remove(c);
				return true;
			}
		}
		return false;
	}

	public List<BuyableStreet> getStreets() {
		return streets;
	}

	public boolean addStreet(BuyableStreet s) {
		s.setOwner(this);
		return streets.add(s);
	}

	public boolean removeStreet(BuyableStreet s) {
		s.setOwner(null);
		return streets.remove(s);
	}

	public void transferStreet(Player p, BuyableStreet street) {
		removeStreet(street);
		p.addStreet(street);
	}

	public void transferStreet(Player p, BuyableStreet street, int money) {
		transferStreet(p, street);
		p.transferMoney(this, money);
	}

	public List<Card> getCards() {
		return cards;
	}

	public boolean addCard(Card c) {
		return cards.add(c);
	}

	public boolean removeCard(Card c) {
		return cards.remove(c);
	}

	public void transferCard(Player p, Card card) {
		removeCard(card);
		p.addCard(card);
	}

	public void transferCard(Player p, Card card, int money) {
		transferCard(p, card);
		p.transferMoney(this, money);
	}

	public static enum Pawn {
		TOPHAT, THIMBLE, IRON, SHOE, BATTLESHIP, WHEELBARROW, DOG, CAR;
	}
}
