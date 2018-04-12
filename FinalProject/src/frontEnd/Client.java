package frontEnd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * The client to communicate with the server.
 * @author Rainer Lim and Thomas Vy
 * @since April 12, 2018
 * @version 1.0
 *
 */
public class Client {
	/**
	 * The socket for communication between server and client
	 */
	Socket socket;
	/**
	 * The object output stream for the socket
	 */
	ObjectOutputStream out;
	/**
	 * The object input stream for the socket
	 */
	ObjectInputStream in;
	
	/**
	 * The client constructor
	 * @param serverName - the server name to connect to
 	 * @param portNumber - the port number of server to connect to
	 */
	public Client(String serverName, int portNumber) {
		try {
			socket = new Socket(serverName, portNumber);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to server.", "Server Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * communicates with server with one item
	 * @param toSend - the object to be sent to the server
	 * @return - the object received from server
	 */
	public Object communicateWithServer(Object toSend) {
		Object readFromServer = -1;
		try {
			out.writeObject(toSend);
			readFromServer = in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return readFromServer;
	}
	/**
	 * communicates with server with two objects
	 * @param toSend - the object to send to server first
	 * @param typeOfRequest - the type of request to do with the object
	 * @return - the object sent from the server
	 */
	public Object communicateWithServer(Object toSend, String typeOfRequest) {
		Object readFromServer = -1;
		try {
			out.reset();
			out.writeObject(toSend);
			out.flush();
			out.writeObject(typeOfRequest);
			out.flush();
			readFromServer = in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return readFromServer;
	}
	/**
	 * Communicate with the server with 3 objects
	 * @param toSend - the object to send first
	 * @param typeOfRequest - the type of request to do with the object
	 * @param file - sends file in bytes to server
	 * @return - an object from server
	 */
	public Object communicateWithServer(Object toSend, String typeOfRequest, Object file) {
		Object readFromServer = -1;
		try {
			out.reset();
			out.writeObject(toSend);
			out.flush();
			out.writeObject(typeOfRequest);
			out.flush();
			out.writeObject(file);
			out.flush();
			readFromServer = in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return readFromServer;
	}
	/**
	 * Communicate with server with 4 objects
	 * @param toSend - sends first object to server 
	 * @param typeOfRequest - the type of request to do with first object
	 * @param file1 - the second object to send to server
	 * @param file2 - the third object to send to server
	 * @return - the object retrieved from server
	 */
	public Object communicateWithServer(Object toSend, String typeOfRequest, Object file1, Object file2) {
		Object readFromServer = -1;
		try {
			out.reset();
			out.writeObject(toSend);
			out.flush();
			out.writeObject(typeOfRequest);
			out.flush();
			out.writeObject(file1);
			out.flush();
			out.writeObject(file2);
			out.flush();
			readFromServer = in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return readFromServer;
		
	}
	/**
	 * Starts the client side
	 * @param args - the command line arguments
	 */
	public static void main(String[] args) {
		Client client = new Client("localhost", 9890);
		LoginWindow login = new LoginWindow("Login Window");
		LoginWindowController loginWindowController = new LoginWindowController(login, client);
	}

}
