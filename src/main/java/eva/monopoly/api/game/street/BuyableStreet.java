package eva.monopoly.api.game.street;

import java.util.ArrayList;
import java.util.List;

import eva.monopoly.api.game.player.Player;

public abstract class BuyableStreet extends Street {
	private int mortgageValue;
	private String group;
	private int cost;
	private Player owner;
	private boolean hasMortgage;

	public BuyableStreet(String name, int mortgageValue, String group, int cost) {
		super(name);
		this.mortgageValue = mortgageValue;
		this.group = group;
		this.cost = cost;
		this.owner = null;
		this.hasMortgage = false;
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

	protected int chargeFee(Player p, int dice, Player streetOwner, int modifier) {
		if (streetOwner == null || streetOwner == p || hasMortgage) {
			return 0;
		}

		int fee = getFee(streetOwner, dice, modifier);
		p.transferMoney(streetOwner, fee);

		return fee;
	}

	protected abstract int getFee(Player p, int dice, int modifier);

	protected abstract List<BuyableStreet> getAllStreets();

	protected boolean hasStreetGroup(Player p, String group) {
		for (BuyableStreet e : getAllStreets()) {
			if (e.getGroup().equals(group)) {
				if (p.getStreets().contains(e)) {
					return false;
				}
			}
		}
		return true;
	}

	protected List<BuyableStreet> getStreetGroup(Player p, String group) {
		List<BuyableStreet> streetsOfPlayer = new ArrayList<>();
		for (BuyableStreet e : getAllStreets()) {
			if (e.getGroup().equals(group)) {
				if (p.getStreets().contains(e)) {
				}
			}
		}
		return streetsOfPlayer;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public boolean hasMortgage() {
		return hasMortgage;
	}

	public void setHasMortgage(boolean hasMortgage) {
		if (hasMortgage) {
			owner.modifyMoney(mortgageValue);
		} else {
			owner.modifyMoney((int) (-mortgageValue * 1.1));
		}
		this.hasMortgage = hasMortgage;
	}
}
