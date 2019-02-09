package eva.monopoly.game.player;

public class Player {
	private static final int START_MONEY = 1500;
	private static final int START_POS = 0;
	private String name;
	private int money;
	private Pawn playerPawn;
	private boolean jailed;
	private int positionIndex;

	public Player(String name, Pawn playerPawn) {
		money = START_MONEY;
		positionIndex = START_POS;
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

	public static enum Pawn {
		TOPHAT, THIMBLE, IRON, SHOE, BATTLESHIP, WHEELBARROW, DOG, CAR;
	}
}
