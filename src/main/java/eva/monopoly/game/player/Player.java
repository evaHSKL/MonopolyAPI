package eva.monopoly.game.player;

import java.util.ArrayList;

import eva.monopoly.game.card.cards.UnjailCard;
import eva.monopoly.game.street.Street;

public class Player {
	private String name;
	private int money;
	private ArrayList<Street> streets = new ArrayList<>();
	private Pawn playerPawn;
	private boolean jailed;

	public Player(String name, Pawn playerPawn) {
		money = 1500;
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

	public int getHouses() {
		// TODO über Liste von Straßen iterieren um Anzahl Häuser in Besitz
		// herauszufinden
		int amount = 0;
		for (Street i : streets) {
			// amount += i.getHouse();
		}
		return amount;
	}

	public int getHotels() {
		// TODO über Liste von Straßen iterieren um Anzahl Hotels in Besitz
		// herauszufinden
		int amount = 0;
		for (Street i : streets) {
			// amount += i.getHotel();
		}
		return amount;
	}

	public void modifyMoney(int money) {
		this.money += money;
	}

	public void transferMoney(Player p, int money) {
		modifyMoney(-money);
		p.modifyMoney(money);
	}

	public void sendToJail() {
		// TODO Auto-generated method stub
		// moveToTarget("jail");
		jailed = true;
	}

	public void releaseFromJail() {
		jailed = false;

	}

	public boolean isJailed() {
		return jailed;
	}

	public void moveToTarget(String target) {
		// TODO Auto-generated method stub

	}

	public void moveToNextTarget(String target, double modifire) {
		// TODO Auto-generated method stub

	}

	public void moveAmount(int amount) {
		// TODO Auto-generated method stub

	}

	public void setPayDouble() {
		// TODO Auto-generated method stub

	}

	public void pickupCard(UnjailCard unjailCard) {
		// TODO Auto-generated method stub

	}

}
