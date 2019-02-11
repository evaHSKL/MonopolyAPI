package eva.monopolyapi.game.street.streets;

import eva.monopolyapi.game.GameBoard;
import eva.monopolyapi.game.player.Player;

public class NonBuyableJailStreet extends NonBuyableStreet {

	public NonBuyableJailStreet(String name) {
		super(name);
	}

	@Override
	public void action(Player p, GameBoard board, int dice) {
		p.sendToJail();
	}

}
