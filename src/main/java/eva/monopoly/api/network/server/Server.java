package eva.monopoly.api.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eva.monopoly.api.network.api.ExchangeMessage;
import eva.monopoly.api.network.api.ExchangeMessageHandle;
import eva.monopoly.api.network.api.HandlerException;
import eva.monopoly.api.network.api.SocketConnector;
import eva.monopoly.api.network.messages.NameInfo;

public class Server {
	public final static Logger LOG = LoggerFactory.getLogger(Server.class);

	private HashMap<String, SocketConnector> socketConnectors = new HashMap<>();

	private final ConcurrentHashMap<Class<? extends ExchangeMessage>, ExchangeMessageHandle<? extends ExchangeMessage>> handler = new ConcurrentHashMap<>();

	private ServerSocket serverSocket;

	public Server(int port, String name, BiConsumer<SocketConnector, HandlerException> shutdownHandler)
			throws IOException {
		try {
			registerClientHandle(NameInfo.class, (con, nameInfo) -> {
				socketConnectors.put(nameInfo.getName(), con);
				LOG.info("Client  Name: {}", nameInfo.getName());
			});

			serverSocket = new ServerSocket(port);

			final Runnable runnable = () -> {
				try {
					SocketConnector client = new SocketConnector(serverSocket.accept(), shutdownHandler);
					LOG.info("Verbunden mit Client: {}", client.getSocket().getInetAddress().getHostAddress());
					handler.forEach(client::registerHandle);
					client.establishConnection();
					client.sendMessage(new NameInfo(name));
				} catch (IOException e) {
					LOG.error("Fehler beim verbinden mit Client!", e);
				}
			};

			new Thread(runnable).start();
		} catch (IOException e) {
			LOG.error("Fehler bei der Initialisierung des Servers:", e);
			throw e;
		}
		LOG.info("Server gestartet");
	}

	public void closeConnection() {
		try {
			for (String connector : socketConnectors.keySet()) {
				socketConnectors.get(connector).closeConnection();
				LOG.info("Verbindung zu {} getrennt", connector);
				socketConnectors.remove(connector);
			}
			serverSocket.close();
			LOG.info("Verbindung zu allen Clients getrennt");
		} catch (Exception e) {
		}
		serverSocket = null;
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
