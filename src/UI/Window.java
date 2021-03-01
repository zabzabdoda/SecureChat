package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Backend.Client;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame implements WindowListener{
	
	private Client client;
	private JTextField textField;
	private String name, ip;
	private char[] password;
	private int port;
	
	public Window(String name, char[] password, String ip, int port) {
		this.name = name;
		this.password = password;
		this.ip = ip;
		this.port = port;
		setTitle("Secure Chat Client");
		getContentPane().setLayout(null);
		this.setSize(300, 400);		
		this.setResizable(false);
		this.addWindowListener(this);
		JScrollPane scrollPane = new JScrollPane();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		scrollPane.setBounds(10, 11, 264, 240);
		getContentPane().add(scrollPane);
		
		JTextArea textPane = new JTextArea();
		textPane.setEditable(false);
		textPane.setWrapStyleWord(true);
		textPane.setLineWrap(true);
		scrollPane.setViewportView(textPane);
		
		JButton btnNewButton_1 = new JButton("Disconnect");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnNewButton_1.setBounds(10, 326, 264, 23);
		getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 250, 208, 32);
		getContentPane().add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane_1.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 293, 127, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendMessage(textArea.getText());
				textPane.append("<"+name+"> "+textArea.getText()+"\n");
				textArea.setText("");
				
			}
		});
		btnNewButton.setBounds(217, 250, 57, 32);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Change Name");
		btnNewButton_1_1.setBounds(147, 292, 127, 23);
		getContentPane().add(btnNewButton_1_1);
		this.setVisible(true);
		new Thread() {
			@Override
			public void run() {
				client = new Client(name, password, ip, port, textPane);
				client.startClient();
			}
		}.start();
	}

	public void closeWindow() {
		client.closeClient();
		client = null;
		this.dispose();
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("CLOSED");
		closeWindow();
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
