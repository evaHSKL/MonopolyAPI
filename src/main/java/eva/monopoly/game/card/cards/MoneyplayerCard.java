package eva.monopoly.game.card.cards;

import eva.monopoly.game.GameBoard;
import eva.monopoly.game.card.Card;
import eva.monopoly.game.player.Player;

public class MoneyplayerCard extends Card {
	private int amount;

	public MoneyplayerCard(String text, CardType type, int amount) {
		super(text, type);
		this.amount = amount;
	}

	@Override
	public void action(Player p, GameBoard board) {
		for (Player pl : board.getPlayers()) {
			if (pl != p) {
				pl.modifyMoney(-amount);
			}
		}
		p.modifyMoney(amount * (board.getPlayers().size() - 1));
	}
}
