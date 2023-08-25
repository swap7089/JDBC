package bankmanagement;
import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.*;
public class ATM_Machine extends JFrame implements ActionListener{

	
	JFrame frame;
	JLabel text,receipt,cash,card,insert;
	JButton deposit,withdraw,fast,mini,check,exit,chng_pin;
	String pinNumber;
public	ATM_Machine(String pinNumber) {
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
			
			
			deposit = new JButton("Deposit");
			deposit.setBounds(190, 190, 170, 38);
			deposit.setBackground(Color.BLACK);
			deposit.setFont(new Font("Cambria", Font.BOLD, 20));
			deposit.setForeground(new Color(255,255,255));
			deposit.addActionListener(this);
			image.add(deposit);
			
			withdraw = new JButton("Withdraw");
			withdraw.setBounds(190, 240,  170, 38);
			withdraw.setBackground(Color.BLACK);
			withdraw.setFont(new Font("Cambria", Font.BOLD, 20));
			withdraw.setForeground(new Color(255,255,255));
			withdraw.addActionListener(this);
			image.add(withdraw);
		
			check = new JButton("Check Balance");
			check.setBounds(190, 290,  170, 38);
			check.setBackground(Color.BLACK);
			check.setFont(new Font("Cambria", Font.BOLD, 20));
			check.setForeground(new Color(255,255,255));
			check.addActionListener(this);
			image.add(check);
		
			exit = new JButton("Exit");
			exit.setBounds(190, 340,  170, 38);
			exit.setBackground(Color.BLACK);
			exit.setFont(new Font("Cambria", Font.BOLD, 20));
			exit.setForeground(new Color(255,255,255));
			exit.addActionListener(this);
			image.add(exit);
		
			fast = new JButton("Use Fast Cash");
			fast.setBounds(538, 200, 185, 48);
			fast.setBackground(Color.BLACK);
			fast.setFont(new Font("Cambria", Font.BOLD, 20));
			fast.setForeground(new Color(255,255,255));
			fast.addActionListener(this);
			image.add(fast);
			
			mini = new JButton("Mini Statements");
			mini.setBounds(538, 260,  185, 48);
			mini.setBackground(Color.BLACK);
			mini.setFont(new Font("Cambria", Font.BOLD, 20));
			mini.setForeground(new Color(255,255,255));
			mini.addActionListener(this);
			image.add(mini);
		
			chng_pin = new JButton("Change Your Pin");
			chng_pin.setBounds(538, 320,  185, 48);
			chng_pin.setBackground(Color.BLACK);
			chng_pin.setFont(new Font("Cambria", Font.BOLD, 20));
			chng_pin.setForeground(new Color(255,255,255));
			chng_pin.addActionListener(this);
			image.add(chng_pin);
		
		setSize(900, 760);                   //All of these functions are main .Used for JFrame to get visible
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
		}else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}else if(ae.getSource()==withdraw) {
			setVisible(false);
			new Withdraw(pinNumber).setVisible(true);
		}else if(ae.getSource()==check) {
			setVisible(false);
			new Check(pinNumber).setVisible(true);
		}else if(ae.getSource()==fast) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}else if(ae.getSource()==chng_pin) {
			setVisible(false);
			new Change(pinNumber).setVisible(true);
		}else if(ae.getSource()==mini) {
			setVisible(false);
			new MiniStatement("").setVisible(true);
		}
	
	
	}
	public static void main(String[] args) {
		new ATM_Machine("");
			
	}


	
}
