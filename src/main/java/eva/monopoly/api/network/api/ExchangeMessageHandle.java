package eva.monopoly.api.network.api;

import java.util.function.BiConsumer;

public class ExchangeMessageHandle<T extends ExchangeMessage> {
	private final Class<T> clazz;
	private final BiConsumer<SocketConnector, T> consumer;

	public ExchangeMessageHandle(final Class<T> clazz, final BiConsumer<SocketConnector, T> consumer) {
		this.clazz = clazz;
		this.consumer = consumer;
	}

	public void handle(final SocketConnector connector, final ExchangeMessage exMsg) {
		final T correctExchangeMsg = clazz.cast(exMsg);
		consumer.accept(connector, correctExchangeMsg);
	}
}
