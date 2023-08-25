package bankmanagement;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.*;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.*;
import java.lang.*;
public class FastCash extends JFrame implements ActionListener{

	
	JFrame frame;
	JLabel text,receipt,cash,card,insert;
	JButton Rs100,Rs1000,Rs5000,Rs500,Rs2000,exit,Rs10000;
	String pinNumber,amount;
public	FastCash(String pinNumber) {
		this.pinNumber=pinNumber;
		getContentPane().setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm1.png"));
		Image i2=i1.getImage().getScaledInstance(900,760,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,760);
		getContentPane().add(image);
		
			 text = new JLabel("Please Select Your Transaction !");
			getContentPane().add(text);
			text.setForeground(new Color(255-255-255));
			text.setFont(new Font("Cambria", Font.BOLD, 20));
			text.setBounds(300, 155, 700, 35);
			image.add(text);
			
			
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
			
			
			Rs100 = new JButton("100");
			Rs100.setBounds(190, 190, 170, 38);
			Rs100.setBackground(Color.BLACK);
			Rs100.setFont(new Font("Cambria", Font.BOLD, 20));
			Rs100.setForeground(new Color(255,255,255));
			Rs100.addActionListener(this);
			image.add(Rs100);
			
			Rs1000 = new JButton("1000");
			Rs1000.setBounds(190, 240,  170, 38);
			Rs1000.setBackground(Color.BLACK);
			Rs1000.setFont(new Font("Cambria", Font.BOLD, 20));
			Rs1000.setForeground(new Color(255,255,255));
			Rs1000.addActionListener(this);
			image.add(Rs1000);
		
			Rs5000 = new JButton("5000");
			Rs5000.setBounds(190, 290,  170, 38);
			Rs5000.setBackground(Color.BLACK);
			Rs5000.setFont(new Font("Cambria", Font.BOLD, 20));
			Rs5000.setForeground(new Color(255,255,255));
			Rs5000.addActionListener(this);
			image.add(Rs5000);
		
			exit = new JButton("Exit");
			exit.setBounds(370, 340,  170, 38);
			exit.setBackground(Color.BLACK);
			exit.setFont(new Font("Cambria", Font.BOLD, 20));
			exit.setForeground(new Color(255,255,255));
			exit.addActionListener(this);
			image.add(exit);
		
			Rs500 = new JButton("500");
			Rs500.setBounds(550, 190, 170, 38);
			Rs500.setBackground(Color.BLACK);
			Rs500.setFont(new Font("Cambria", Font.BOLD, 20));
			Rs500.setForeground(new Color(255,255,255));
			Rs500.addActionListener(this);
			image.add(Rs500);
			
			Rs2000 = new JButton("2000");
			Rs2000.setBounds(550, 240,  170, 38);
			Rs2000.setBackground(Color.BLACK);
			Rs2000.setFont(new Font("Cambria", Font.BOLD, 20));
			Rs2000.setForeground(new Color(255,255,255));
			Rs2000.addActionListener(this);
			image.add(Rs2000);
		
			Rs10000 = new JButton("10000");
			Rs10000.setBounds(550, 290,  170, 38);
			Rs10000.setBackground(Color.BLACK);
			Rs10000.setFont(new Font("Cambria", Font.BOLD, 20));
			Rs10000.setForeground(new Color(255,255,255));
			Rs10000.addActionListener(this);
			image.add(Rs10000);
		
		setSize(900, 760);                   //All of these functions are main .Used for JFrame to get visible
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			setVisible(false);
			new ATM_Machine(pinNumber).setVisible(true);
		}else {
			 amount=((JButton)ae.getSource()).getText();
			Database_Connector con = new Database_Connector();
			try {
				ResultSet rs=con.st.executeQuery("select * from deposit where pin = '"+pinNumber+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += rs.getInt("amount");
					}else {
						balance -= rs.getInt("amount");
					}
				}
				if(ae.getSource()!= exit) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date = new Date();
				String query="insert into deposit values('"+pinNumber+"','"+date+"','Withdraw','"+amount+"')";
				con.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" withdrawl successfully");
				
				setVisible(false);
				new ATM_Machine(pinNumber).setVisible(true);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	
		
		
	}
	
	
	public static void main(String[] args) {
		new FastCash("");
			
	}


	
}
