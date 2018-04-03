package frontEnd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	Socket socket;
	ObjectInputStream in;
	ObjectOutputStream out;

	public Client(int portNumber, String serverName) {
		try {
			socket = new Socket(serverName, portNumber);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void communicateWithServer() {
		// I have no idea
	}
}
