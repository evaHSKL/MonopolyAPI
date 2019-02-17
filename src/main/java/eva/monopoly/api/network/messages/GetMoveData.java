package eva.monopoly.api.network.messages;

import eva.monopoly.api.network.api.ExchangeMessage;

public class GetMoveData extends ExchangeMessage{


	private static final long serialVersionUID = 8318618029333772408L;

	public GetMoveData(String name) {
		super(name);
	}

}
