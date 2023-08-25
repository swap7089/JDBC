package bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class Change extends JFrame implements ActionListener{
	
	JLabel text,pintext,repintext,cash,receipt,card,insert;
	JPasswordField repinTextField,pinTextField;
	JButton bchange,back;
	String pinNumber;
	Change(String pinNumber){
	this.pinNumber=pinNumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm1.png"));
		Image i2=i1.getImage().getScaledInstance(900,760,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,760);
		getContentPane().add(image);
		
	
			
			 pintext = new JLabel("New Pin:");
				getContentPane().add(pintext);
				pintext.setForeground(new Color(0,0,0));
				pintext.setFont(new Font("Cambria", Font.BOLD, 24));
				pintext.setBounds(190 ,200, 700, 35);
				image.add(pintext);
				
				text = new JLabel("Change Your Pin.");
				getContentPane().add(text);
				text.setForeground(new Color(0,0,0));
				text.setFont(new Font("Cambria", Font.BOLD, 20));
				text.setBounds(360, 260, 700, 35);
				image.add(text);
					
				
			    pinTextField=new JPasswordField();
			    pinTextField.setFont(new Font("Cambria", Font.BOLD, 25));
			    pinTextField.setBounds(340, 200, 80, 35);
				image.add(pinTextField);

				
				 repintext = new JLabel("Re-enter Pin:");
					getContentPane().add(text);
					repintext.setForeground(new Color(0,0,0));
					repintext.setFont(new Font("Cambria", Font.BOLD, 24));
					repintext.setBounds(190 ,240, 700, 35);
					image.add(repintext);
			
					
					repinTextField=new JPasswordField();
					repinTextField.setFont(new Font("Cambria", Font.BOLD, 25));
					repinTextField.setBounds(340, 240, 80, 35);
					image.add(repinTextField);
					
					
					bchange = new JButton("Change");
					bchange.setBounds(190, 300, 140, 40);
					bchange.setBackground(Color.BLACK);
					bchange.setFont(new Font("Cambria", Font.BOLD, 20));
					bchange.setForeground(new Color(255,255,255));
					bchange.addActionListener(this);
					image.add(bchange);
					
					
					back =new JButton("Back");
					back.setBounds(190, 340, 140, 40);
					back.setBackground(Color.BLACK);
					back.setFont(new Font("Cambria", Font.BOLD, 20));
					back.setForeground(new Color(255,255,255));
					back.addActionListener(this);
					image.add(back);

				
					
			receipt = new JLabel("Receipt");
			getContentPane().add(receipt);
			receipt.setForeground(new Color(0, 0, 0));
			receipt.setFont(new Font("Cambria", Font.BOLD, 20));
			receipt.setBounds(190, 425, 700, 35);
			image.add(receipt);
		
			
			cash = new JLabel("Cash");
			getContentPane().add(cash);
			cash.setForeground(new Color(0, 0, 0));
			cash.setFont(new Font("Cambria", Font.BOLD, 20));
			cash.setBounds(420, 425, 700, 35);
			image.add(cash);
			
			 card = new JLabel("Card");
			getContentPane().add(card);
			card.setForeground(new Color(0, 0, 0));
			card.setFont(new Font("Cambria", Font.BOLD, 20));
			card.setBounds(650, 425, 700, 35);
			image.add(card);
			
			 insert = new JLabel("Insert Card Here");
			getContentPane().add(insert);
			insert.setForeground(new Color(0, 0, 0));
			insert.setFont(new Font("Cambria", Font.BOLD, 15));
			insert.setBounds(625 , 447, 700, 35);
			image.add(insert);
		
			
			setSize(900, 760);                   //All of these functions are main .Used for JFrame to get visible
			setLocation(300,0);
			setUndecorated(true);
			setVisible(true);
	}
	
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==bchange) {
		try {
			String npin=pinTextField.getText();
			String rpin=repinTextField.getText();
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered Pin does not match!");
				return;
			}if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter New Pin.");
				return;
			}if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Pin Again.");
				return;
			}
			Database_Connector con=new Database_Connector();
			String query1="update deposit set pin='"+rpin+"' where pin='"+pinNumber+"'";
			String query2="update login set pinNumber='"+rpin+"' where pinNumber='"+pinNumber+"'";
			String query3="update signup_3 set pinNumber='"+rpin+"' where pinNumber='"+pinNumber+"'";
			con.st.executeUpdate(query1);
			con.st.executeUpdate(query2);
			con.st.executeUpdate(query3);
			JOptionPane.showMessageDialog(null, "PIN changed successfully");
			setVisible(false);
			new ATM_Machine(rpin).setVisible(true);
			}
			catch(Exception e){
				System.out.println(e);
			}
			
		}
		
		
else {
	setVisible(false);
	new ATM_Machine(pinNumber).setVisible(true);
}
}
	public static void main(String args[]) {
		new Change("");
	}

}
