package bankmanagement;

import javax.swing.*;
import java.sql.*;

import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

	JButton login,clear,signup;
	JTextField cardTextField;
	JPasswordField pinTextField;
//Define this above buttons as global so to use them in Action Listener 	
	Login(){
		
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/images.png"));
		Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text=new JLabel("Welcome To ATM");
		text.setBounds(250,40,400,40);
		text.setFont(new Font ("Cambria",Font.BOLD,38));
		add(text);
		
		JLabel cardNo=new JLabel("Card No:");
		cardNo.setBounds(120,150,400,40);
		cardNo.setFont(new Font ("Cambria",Font.BOLD,28));
		add(cardNo);
		
		cardTextField= new JTextField();
		cardTextField.setBounds(300,150,250,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin=new JLabel("Pin No:");
		pin.setBounds(120,220,400,40);
		pin.setFont(new Font ("Cambria",Font.BOLD,28));
		add(pin);
		
	   pinTextField= new JPasswordField();
		pinTextField.setBounds(300,220,250,30);
		add(pinTextField);
		
		login= new JButton("Sign In");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		
		clear= new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
	    signup= new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,450);
		setVisible(true);
		setLocation(350,200);
	}
	
	public void actionPerformed(ActionEvent  ae) {
		if(ae.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if(ae.getSource()==login) {
			Database_Connector con=new Database_Connector();
			String cardNumber = cardTextField.getText();
			String pinNumber = pinTextField.getText();
			String query = "select * from login where cardNumber='"+cardNumber+"' and pinNumber='"+pinNumber+"'";   //to check if the typed cardno and pin is already login 
			try {
				ResultSet rs=con.st.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new ATM_Machine(pinNumber).setVisible(true);          //to pass the pin no. in ATM code then in bracket pin number is attached
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin Number");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource()==signup) {
			setVisible(false);               //the login frame will be closed...
			new SignUp().setVisible(true);           //the new signup frame will be opened...
 		}
	}
	
	public static void main(String[] args) {
		new Login();

	}

}
