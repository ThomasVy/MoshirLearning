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

	public Object communicateWithServer(Object toSend) {
		Object readFromServer = -1;
		try {
			out.writeObject(toSend);
			readFromServer = in.readObject();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return readFromServer;
	}
	public static void main(String [] args)
	{
		Client client = new Client(9890, "localhost");
		LoginWindow login = new LoginWindow("Login Window");
		LoginWindowController loginWindowController = new LoginWindowController(login, client);
		
	}
}
