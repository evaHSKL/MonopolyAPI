package eva.monopoly.game.street.streets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.player.Player;
import eva.monopoly.game.street.Street;

public abstract class BuyableStreet extends Street {
	private int mortgageValue;
	private String group;
	private int cost;

	public BuyableStreet(String name, int mortgageValue, String group, int cost) {
		super(name);
		this.mortgageValue = mortgageValue;
		this.group = group;
		this.cost = cost;
	}

	public int getMortgageValue() {
		return mortgageValue;
	}

	public String getGroup() {
		return group;
	}

	public int getCost() {
		return cost;
	}

	public int chargeFee(Player p, GameBoard board, int dice, int modifier) {
		Player streetOwner = board.getBuyableStreets().get(this);

		if (streetOwner == null || streetOwner == p) {
			return 0;
		}

		int fee = getFee(streetOwner, board, dice);
		fee = fee * modifier;
		p.modifyMoney(-fee);
		streetOwner.modifyMoney(fee);

		return fee;
	}

	protected abstract int getFee(Player p, GameBoard board, int dice);

	public boolean hasStreetGroup(Player p, GameBoard board, String group) {
		for (Entry<BuyableStreet, Player> e : board.getBuyableStreets().entrySet()) {
			if (e.getKey().getGroup().equals(group)) {
				if (e.getValue() != p) {
					return false;
				}
			}
		}
		return true;
	}

	public List<BuyableStreet> getStreetGroup(Player p, GameBoard board, String group) {
		List<BuyableStreet> streetsOfPlayer = new ArrayList<>();
		for (Entry<BuyableStreet, Player> e : board.getBuyableStreets().entrySet()) {
			if (e.getKey().getGroup().equals(group)) {
				if (e.getValue() == p) {
					streetsOfPlayer.add(e.getKey());
				}
			}
		}
		return streetsOfPlayer;
	}
}
