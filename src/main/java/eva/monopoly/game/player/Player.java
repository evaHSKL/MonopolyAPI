package eva.monopoly.game.player;

import java.util.ArrayList;

import eva.monopoly.game.street.Street;

public class Player {
	private static final int START_MONEY = 1500;
	private String name;
	private int money;
	private ArrayList<Street> streets = new ArrayList<>();
	private Pawn playerPawn;
	private boolean jailed;

	public Player(String name, Pawn playerPawn) {
		money = START_MONEY;
		this.name = name;
		this.playerPawn = playerPawn;
		jailed = false;
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

	public ArrayList<Street> getStreets() {
		return streets;
	}

	public boolean addStreet(Street street) {
		return streets.add(street);
	}

	public boolean removeStreet(Street street) {
		return streets.remove(street);
	}

	public void modifyMoney(int money) {
		this.money += money;
	}

	public void transferMoney(Player p, int money) {
		modifyMoney(-money);
		p.modifyMoney(money);
	}

	public void sendToJail() {
		jailed = true;
	}

	public void releaseFromJail() {
		jailed = false;
	}

	public boolean isJailed() {
		return jailed;
	}

	public static enum Pawn {
		TOPHAT, THIMBLE, IRON, SHOE, BATTLESHIP, WHEELBARROW, DOG, CAR;
	}
}
