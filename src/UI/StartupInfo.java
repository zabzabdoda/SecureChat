package UI;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class StartupInfo extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField textField_2;
	private JTextField textField_3;
	public StartupInfo() {
		setTitle("Secure Chat Server");
		setResizable(false);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textField = new JTextField();
		textField.setBounds(138, 11, 146, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Server IP:");
		lblNewLabel.setBounds(10, 14, 118, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(10, 86, 118, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Server Port:");
		lblNewLabel_2.setBounds(10, 39, 118, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 36, 146, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 83, 146, 20);
		getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnNewButton.setBounds(162, 137, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCreate = new JButton("Connect");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window s = new Window(textField_3.getText(),textField_2.getPassword(),textField.getText(),Integer.parseInt(textField_1.getText()));
				closeWindow();
			}
		});
		btnCreate.setBounds(30, 137, 89, 23);
		getContentPane().add(btnCreate);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(138, 60, 146, 20);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Username");
		lblNewLabel_2_1.setBounds(10, 63, 118, 14);
		getContentPane().add(lblNewLabel_2_1);
		this.setVisible(true);
	}
	
	
	public void closeWindow() {
		this.dispose();
	}
}
