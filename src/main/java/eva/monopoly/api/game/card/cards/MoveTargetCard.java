package eva.monopoly.api.game.card.cards;

import eva.monopoly.api.game.card.Card;

public abstract class MoveTargetCard extends Card {
	private static final long serialVersionUID = 4331586191999246254L;

	protected final String target;
	protected final int moneyModyfire;
	protected final boolean buyable;

	public MoveTargetCard(String text, CardType type, String target, int moneyModyfire, boolean buyable) {
		super(text, type);
		this.target = target;
		this.moneyModyfire = moneyModyfire;
		this.buyable = buyable;
	}

}
