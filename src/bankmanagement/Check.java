package bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.EventQueue;
import java.lang.*;
public class Check extends JFrame implements ActionListener{
	
	
		JLabel text,pintext,repintext,cash,receipt,card,insert;
		JPasswordField repinTextField,pinTextField;
		JButton bchange,back;
		String pinNumber;
		
		Check(String pinNumber){
		this.pinNumber=pinNumber;
			setLayout(null);
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm1.png"));
			Image i2=i1.getImage().getScaledInstance(900,760,Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel image=new JLabel(i3);
			image.setBounds(0,0,900,760);
			getContentPane().add(image);
			
			
			back=new JButton("Back");
			back.setBounds(550, 335, 150, 35);
			back.setBackground(Color.BLACK);
			back.setFont(new Font("Cambria", Font.BOLD, 20));
			back.setForeground(new Color(255,255,255));
			back.addActionListener(this);
			image.add(back);
		
			Database_Connector con = new Database_Connector();
			int balance = 0;

			try {
				ResultSet rs=con.st.executeQuery("select * from deposit where pin = '"+pinNumber+"'");
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += rs.getInt("amount");
					}else {
						balance -= rs.getInt("amount");
					}
				}
			}
				catch(Exception e) {
					System.out.println(e);
					
				}
			
			 text = new JLabel("Your Current Amount Balance Is:"+String.valueOf(balance));
				getContentPane().add(text);
				text.setForeground(new Color(0,0,0));
				text.setFont(new Font("Cambria", Font.BOLD, 25));
				text.setBounds(190, 160, 700, 35);
				image.add(text);
				
			
			setSize(900, 760);                   //All of these functions are main .Used for JFrame to get visible
			setLocation(300,0);
			setUndecorated(true);
			setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
		
				setVisible(false);
				new ATM_Machine(pinNumber).setVisible(true);
				
			}
		}
		
	
	public static void main(String[] args) {
		
	new	Check("");
	}

}
