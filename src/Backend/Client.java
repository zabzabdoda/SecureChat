package Backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

public class Client {

	public int port = 1234;
	private String username;
	private String ip;
	private char[] password;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private JTextArea textPane;

	public Client(String name, char[] password, String ip, int port, JTextArea textPane) {
		this.ip = ip;
		this.username = name;
		this.port = port;
		this.password = password;
		this.textPane = textPane;
	}

	public void startClient() {
		setupSocket();
		startClientLoop();
	}
	
	public void setupSocket() {
		try {
			socket = new Socket(ip, port);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			textPane.append("Host Unknown\n");
		} catch (IOException e) {
			textPane.append("There was a problem starting the connection\n");
		}
	}

	public void startClientLoop() {
		Thread inputThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						String inMessage = dis.readUTF();
						textPane.append(inMessage+"\n");
						//System.out.println(inMessage);
					} catch (IOException e) {
						textPane.append("Server Connection Closed\n");
						break;
					}
				}
			}
		};
		inputThread.start();
	}
	
	public void closeClient() {
		sendMessage(username+" Disconnected");
		try {
			socket.close();
			dis.close();
			dos.close();
		} catch (IOException e) {
			
		}
		socket = null;
	}

	public void sendMessage(String message) {
		try {
			dos.writeUTF("<" + username + "> " + message);
		} catch (IOException e) {
			textPane.append("Something went wrong sending that message...\n");
		}
	}

}
