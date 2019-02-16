package eva.monopoly.api.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eva.monopoly.api.network.api.ExchangeMessage;
import eva.monopoly.api.network.api.ExchangeMessageHandle;
import eva.monopoly.api.network.api.HandlerException;
import eva.monopoly.api.network.api.SocketConnector;
import eva.monopoly.api.network.api.messages.Heartbeat;
import eva.monopoly.api.network.api.messages.NameInfo;

public class Server {
	public final static Logger LOG = LoggerFactory.getLogger(Server.class);

	private HashMap<String, SocketConnector> socketConnectors = new HashMap<>();

	private final ConcurrentHashMap<Class<? extends ExchangeMessage>, ExchangeMessageHandle<? extends ExchangeMessage>> handler = new ConcurrentHashMap<>();

	private ServerSocket serverSocket;

	public Server(int port, String name, BiConsumer<SocketConnector, HandlerException> exceptionHandler)
			throws IOException {
		try {
			LOG.info("Starting server...");
			registerClientHandle(NameInfo.class, (con, nameInfo) -> {
				socketConnectors.put(nameInfo.getName(), con);
				LOG.info("Client name: {}", nameInfo.getName());
			});
			registerClientHandle(Heartbeat.class, (con, heartbeat) -> {
			});

			serverSocket = new ServerSocket(port);

			LOG.debug("Starting client runnable...");
			final Runnable clientRunnable = () -> {
				while (!Thread.currentThread().isInterrupted()) {
					try {
						SocketConnector client = new SocketConnector(LOG, serverSocket.accept(), exceptionHandler);
						LOG.info("Client connected: {}", client.getSocket().getInetAddress().getHostAddress());
						handler.forEach(client::registerHandle);
						client.establishConnection();
						client.sendMessage(new NameInfo(name));
					} catch (IOException e) {
						LOG.error("Error initializing the client", e);
					}
				}
			};
			Thread clientThread = new Thread(clientRunnable, "ClientRunnable");
			clientThread.setDaemon(true);
			clientThread.start();
			final Runnable heartbeatRunnable = () -> {
				while (!Thread.currentThread().isInterrupted()) {
					sendMessageToAll(new Heartbeat(null));
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			};
			Thread heartbeatThread = new Thread(heartbeatRunnable);
			heartbeatThread.setDaemon(true);
			heartbeatThread.start();
		} catch (IOException e) {
			LOG.error("Error initializing the server", e);
			throw e;
		}
		LOG.info("Server started");
	}

	public void closeConnection() {
		try {
			LOG.info("Disconnecting all clients...");
			for (String connector : socketConnectors.keySet()) {
				socketConnectors.get(connector).closeConnection();
				LOG.info("Verbindung zu {} getrennt", connector);
				socketConnectors.remove(connector);
			}
			LOG.info("Connection to all clients disconnected");
			serverSocket.close();
		} catch (Exception e) {
		}
		serverSocket = null;
		LOG.info("Server closed");
	}

	public void closeConnection(String name) {
		try {
			socketConnectors.get(name).closeConnection();
			socketConnectors.remove(name);
		} catch (IOException e) {
		}
	}

	public HashMap<String, SocketConnector> getSocketConnectors() {
		return socketConnectors;
	}

	public SocketConnector getSocketConnector(String name) {
		return socketConnectors.get(name);
	}

	public String getSocketConnectorName(SocketConnector connector) {
		for (Entry<String, SocketConnector> e : socketConnectors.entrySet()) {
			if (e.getValue().equals(connector)) {
				return e.getKey();
			}
		}
		return null;
	}

	public boolean sendMessageToAll(final ExchangeMessage exchangeMessage) {
		boolean returnValue = true;
		for (SocketConnector connector : socketConnectors.values()) {
			if (!connector.sendMessage(exchangeMessage)) {
				returnValue = false;
			}
		}
		return returnValue;
	}

	public boolean sendMessageToAllExcept(final ExchangeMessage exchangeMessage, SocketConnector conExemp) {
		boolean returnValue = true;
		for (SocketConnector connector : socketConnectors.values()) {
			if (connector != conExemp && !connector.sendMessage(exchangeMessage)) {
				returnValue = false;
			}
		}
		return returnValue;
	}

	public <T extends ExchangeMessage> void registerClientHandle(Class<T> clazz,
			BiConsumer<SocketConnector, T> consumer) {
		final ExchangeMessageHandle<T> wrapper = new ExchangeMessageHandle<T>(clazz, consumer);
		for (SocketConnector con : socketConnectors.values()) {
			con.registerHandle(clazz, wrapper);
		}
		handler.put(clazz, wrapper);
	}
}
