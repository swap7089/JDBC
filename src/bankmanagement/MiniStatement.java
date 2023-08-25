package bankmanagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.sql.*;
import java.lang.*
;public class MiniStatement extends JFrame{

		JLabel card,cash,receipt,insert,balance,bank,text ;
		JTextPane textpane;
		String pinNumber;
		int bal = 0;
	MiniStatement(String pinNumber){
		this.pinNumber=pinNumber;
		setLayout(null);
		
		text = new JLabel();
		text.setBounds(20,140,400,200);
		add(text);
		
		bank = new JLabel("Indian Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		
		card = new JLabel("Card Number:");
		card.setBounds(20,80,300,20);
		add(card);
		
		
		balance = new JLabel();
		try {
			Database_Connector con=new Database_Connector();
			ResultSet rs=con.st.executeQuery("Select * from login where pinNumber = '"+pinNumber+"'");
			while(rs.next()) {
				card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(0,4));
				
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		try {
			Database_Connector con=new Database_Connector();
			
			ResultSet rs=con.st.executeQuery("Select * from deposit where pin = '"+pinNumber+"'");
			while(rs.next()) {
				text.setText(text.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><br>");
				if(rs.getString("type").equals("Deposit")) {
					bal += (rs.getInt("amount"));
				}else {
					bal -= (rs.getInt("amount"));
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}	
		balance.setText("Your current account balance is Rs "+ bal);
		balance.setBounds(50, 100, 300, 60);	
		add(balance);
			setSize(400, 600);                   //All of these functions are main .Used for JFrame to get visible
			setLocation(20,20);
			setUndecorated(true);
			getContentPane().setBackground(Color.WHITE);
			setVisible(true);
	}
	public static void main(String[] args) {
	
	new	MiniStatement("");

	}

}
