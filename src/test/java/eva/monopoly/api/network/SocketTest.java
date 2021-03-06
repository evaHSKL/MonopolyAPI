package eva.monopoly.api.network;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import eva.monopoly.api.network.client.Client;
import eva.monopoly.api.network.server.Server;

class SocketTest {

	@Test
	void test() {
		final String serverName = "Server";
		final String clientName = "Client";
		try {
			Server server = new Server(25565, serverName, (con, e) -> {
				fail("Fehler mit Client", e);
			});

			Client client = new Client("localhost", 25565, clientName, (con, e) -> {
				fail("Fehler mit Server", e);
			});

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				fail("Interrupted", e);
			}

			assertNotNull(server.getSocketConnector(clientName));
			assertEquals(client.getRemoteName(), serverName);

			server.closeConnection();
			client.closeConnection();
		} catch (IOException e) {
			fail("Fehler beim Erstellen", e);
		}
	}
}
