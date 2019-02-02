package eva.monopoly.game.player;

import eva.monopoly.game.card.cards.UnjailCard;

public interface Player {

	// Player
	public Pawn getPawn();

	public String getName();

	// Money
	public int getMoney();
	
	public int getHouses();
	
	public int getHotels();

	public int modifyMoney(int money);

	public int removeMoney(int money);

	public boolean transferMoney(Player p, int money);

	public void sendToJail();

	public void releaseFromJail();

	public void moveToTarget(String target);

	public void moveToNextTarget(String target, double modifire);

	public void moveAmount(int amount);

	public void setPayDouble();

	public void pickupCard(UnjailCard unjailCard);

}
