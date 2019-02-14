package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.GameBoard;
import eva.monopoly.api.game.card.Card;
import eva.monopoly.api.game.player.Player;

public class MoneyplayerCard extends Card {
	private int amount;

	public MoneyplayerCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}

	@Override
	public void action(Player p, GameBoard board) {
		GameBoard.LOG.debug(this.getClass().getSimpleName() + " was pulled by Player " + p.getName());
		for (Player pl : board.getPlayers()) {
			if (pl != p) {
				pl.modifyMoney(-amount);
			}
		}
		p.modifyMoney(amount * (board.getPlayers().size() - 1));
	}
}
