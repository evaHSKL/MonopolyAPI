package eva.monopoly.api.network.api;

import java.util.function.BiConsumer;

public class ExchangeMessageHandle<T extends ExchangeMessage> {
	private final Class<T> clazz;
	private final BiConsumer<SocketConnector, T> consumer;
	private final boolean inOrder;

	public ExchangeMessageHandle(final Class<T> clazz, final BiConsumer<SocketConnector, T> consumer,
			final boolean inOrder) {
		this.clazz = clazz;
		this.consumer = consumer;
		this.inOrder = inOrder;
	}

	public void handle(final SocketConnector connector, final ExchangeMessage exMsg) {
		final T correctExchangeMsg = clazz.cast(exMsg);
		consumer.accept(connector, correctExchangeMsg);
	}

	public boolean isInOrder() {
		return inOrder;
	}
}
