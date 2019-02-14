package eva.monopoly.api.network.api;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketConnector {
	public final static Logger LOG = LoggerFactory.getLogger(SocketConnector.class);
	public final static int STD_PORT = 25566;

	final private static ExecutorService EXECUTOR = Executors.newCachedThreadPool();
	final private static ExecutorService MESSAGE_DISPATCHER = Executors.newSingleThreadExecutor();
	final private static int TIMEOUT = 15 * 1000;

	private final Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Future<?> future;
	private BiConsumer<SocketConnector, HandlerException> exceptionHandler;

	private final ConcurrentHashMap<Class<? extends ExchangeMessage>, ExchangeMessageHandle<? extends ExchangeMessage>> handler = new ConcurrentHashMap<>();

	public SocketConnector(final Socket socket, BiConsumer<SocketConnector, HandlerException> exceptionHandler) {
		this.socket = socket;
		this.exceptionHandler = exceptionHandler;

		registerHandle(ExchangeMessage.class, (con, msg) -> LOG.warn("There was an unhandled message of type {}: {}",
				msg.getClass().getSimpleName(), msg.toString()));
	}

	public void establishConnection() throws IOException {
		LOG.info("Establish Connection...");

		this.socket.setSoTimeout(TIMEOUT);
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());

		LOG.debug("Setuped Connection...");

		final Runnable runnable = () -> {
			LOG.debug("Start waiting for messages...");
			while (!future.isCancelled()) {
				try {
					final Object obj = in.readObject();
					LOG.debug("Received message of type: {}", obj.getClass().getSimpleName());
					solveMessage((ExchangeMessage) obj);
				} catch (InterruptedIOException e) {
					if (!future.isCancelled()) {
						future.cancel(false);
						handleException("Unexpected interrupt", e);
					}
					return;
				} catch (SocketException e) {
					handleException("Socket wurde unerwartet geschlossen!", e);
					return;
				} catch (Exception e) {
					handleException("Fehler beim Empfangen der Nachricht", e);
					return;
				}
			}
		};

		future = EXECUTOR.submit(runnable);

		LOG.info("Connection Established");
	}

	public void closeConnection() throws IOException {
		LOG.info("Closing Connection");

		out.flush();
		future.cancel(true);
		out.close();
		in.close();
		socket.close();

		LOG.info("Connection Closed");
	}

	public Socket getSocket() {
		return socket;
	}

	public boolean sendMessage(final ExchangeMessage exchangeMessage) {
		try {
			LOG.debug("Waiting for sending Message");
			synchronized (out) {
				out.writeObject(exchangeMessage);
				LOG.debug("Send Message of type: {}", exchangeMessage.getClass().getSimpleName());
			}
			return true;
		} catch (Exception e) {
			handleException("Konnte Nachricht nicht senden!", e);
		}
		return false;
	}

	private void handleException(String reason, Throwable e) {
		LOG.debug("Handling an Exception while Sending or Receiving a Message...", e);
		exceptionHandler.accept(this, new HandlerException(reason, e));
		LOG.debug("Exception was handled", e);
	}

	private void solveMessage(ExchangeMessage obj) {
		Class<?> clazz = obj.getClass();
		ExchangeMessageHandle<? extends ExchangeMessage> wrapper = handler.get(clazz);
		while (wrapper == null) {
			clazz = clazz.getSuperclass();
			if (clazz == null) {
				LOG.error("No handler registered for type hierarchy of class: {}. This should never happen!",
						obj.getClass().getSimpleName());
				return;
			}
			wrapper = handler.get(clazz.getSuperclass());
		}
		final ExchangeMessageHandle<? extends ExchangeMessage> finWrapper = wrapper;
		MESSAGE_DISPATCHER.execute(() -> finWrapper.handle(this, obj));
	}

	public <T extends ExchangeMessage> void registerHandle(Class<T> clazz, BiConsumer<SocketConnector, T> consumer) {
		final ExchangeMessageHandle<T> wrapper = new ExchangeMessageHandle<T>(clazz, consumer);
		handler.put(clazz, wrapper);
	}

	public ExchangeMessageHandle<? extends ExchangeMessage> registerHandle(Class<? extends ExchangeMessage> key,
			ExchangeMessageHandle<? extends ExchangeMessage> value) {
		return handler.put(key, value);
	}
}
