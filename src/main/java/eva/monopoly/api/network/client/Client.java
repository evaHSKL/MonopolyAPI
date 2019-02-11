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

	public Client(String host, int port, String name, BiConsumer<SocketConnector, HandlerException> shutdownHandler)
			throws UnknownHostException, IOException {
		try {
			SocketConnector socketConnector = new SocketConnector(new Socket(host, port), shutdownHandler);
			socketConnector.registerHandle(NameInfo.class, (con, nameInfo) -> {
				this.socketConnector = socketConnector;
				this.remoteName = nameInfo.getName();
				LOG.info("Server Name: {}", nameInfo.getName());
			});
			socketConnector.establishConnection();
			socketConnector.sendMessage(new NameInfo(name));
		} catch (UnknownHostException e) {
			LOG.error("Ungültige Server Adresse: {}", host, e);
			throw e;
		} catch (IOException e) {
			LOG.error("Fehler bei der Initialisierung des Servers: {}", host, e);
			throw e;
		}
		LOG.info("Verbunden zu Server: {}", host);
	}

	public void closeConnection() {
		try {
			socketConnector.closeConnection();
			LOG.info("Verbindung zum Server getrennt");
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
