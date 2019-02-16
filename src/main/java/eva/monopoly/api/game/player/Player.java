package eva.monopoly.api.game.player;

import java.util.ArrayList;
import java.util.List;

import eva.monopoly.api.game.card.Card;
import eva.monopoly.api.game.street.BuyableStreet;

public class Player {
	private static final int START_MONEY = 1500;
	private static final int START_POS = 0;
	private String name;
	private int money;
	private Pawn playerPawn;
	private boolean jailed;
	private int positionIndex;
	private List<BuyableStreet> streets;
	private List<Card> cards;

	public Player(String name, Pawn playerPawn) {
		money = START_MONEY;
		positionIndex = START_POS;
		this.name = name;
		this.playerPawn = playerPawn;
		jailed = false;
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

	public void sendToJail() {
		positionIndex = 10;
		jailed = true;
	}

	public void releaseFromJail() {
		jailed = false;
	}

	public boolean isJailed() {
		return jailed;
	}

	public List<BuyableStreet> getStreets() {
		return streets;
	}

	public boolean addStreet(BuyableStreet e) {
		return streets.add(e);
	}

	public boolean removeStreet(BuyableStreet o) {
		return streets.remove(o);
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

	public boolean addCard(Card e) {
		return cards.add(e);
	}

	public boolean removeCard(Card o) {
		return cards.remove(o);
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
