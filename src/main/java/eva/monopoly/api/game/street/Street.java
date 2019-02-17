package eva.monopoly.api.game.street;

import java.io.Serializable;

import eva.monopoly.api.game.player.Player;

public abstract class Street implements Serializable {
	private static final long serialVersionUID = 4586875708015097616L;

	private String name;

	public Street(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void action(Player p, int dice, int modifier);
}
