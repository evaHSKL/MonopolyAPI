package eva.monopoly.api.network.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eva.monopoly.api.network.api.HandlerException;
import eva.monopoly.api.network.api.SocketConnector;
import eva.monopoly.api.network.messages.NameInfo;

public class Client {
	public final static Logger LOG = LoggerFactory.getLogger(Client.class);

	private SocketConnector socketConnector;
	private String remoteName;

	public Client(String host, int port, String name, BiConsumer<SocketConnector, HandlerException> exceptionHandler)
			throws UnknownHostException, IOException {
		try {
			LOG.info("Starting client...");
			socketConnector = new SocketConnector(LOG, new Socket(host, port), exceptionHandler);
			socketConnector.registerHandle(NameInfo.class, (con, nameInfo) -> {
				this.remoteName = nameInfo.getName();
				LOG.info("Server name: {}", remoteName);
			});
			socketConnector.establishConnection();
			socketConnector.sendMessage(new NameInfo(name));
		} catch (UnknownHostException e) {
			LOG.error("Unknown host adress: {}", host, e);
			throw e;
		} catch (IOException e) {
			LOG.error("Error initializing the server: {}", host, e);
			throw e;
		}
		LOG.info("Client started");
	}

	public void closeConnection() {
		try {
			LOG.info("Disconnecting from server...");
			socketConnector.closeConnection();
			LOG.info("Connection to the server disconnected");
		} catch (Exception e) {
		}
		socketConnector = null;
		remoteName = null;
	}

	public SocketConnector getSocketConnector() {
		return socketConnector;
	}

	public String getRemoteName() {
		return remoteName;
	}
}
