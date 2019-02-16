package eva.monopoly.api.game.street;

import eva.monopoly.api.game.player.Player;

public abstract class Street {
	private String name;

	public Street(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void action(Player p, int dice, int modifier);
}
