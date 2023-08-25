package bankmanagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
	JLabel text,receipt,cash,card,insert;
	JButton deposit,back;
	JTextField dep_amount;
	String pinNumber;
	Deposit(String pinNumber){
		this.pinNumber=pinNumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm1.png"));
		Image i2=i1.getImage().getScaledInstance(900,760,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,760);
		getContentPane().add(image);
		
		 text = new JLabel("Enter Amount You Want To Deposit:");
			getContentPane().add(text);
			text.setForeground(new Color(0,0,0));
			text.setFont(new Font("Cambria", Font.BOLD, 25));
			text.setBounds(190, 160, 700, 35);
			image.add(text);
			
		    dep_amount=new JTextField();
			dep_amount.setFont(new Font("Cambria", Font.BOLD, 25));
			dep_amount.setBounds(190, 230, 450, 35);
			image.add(dep_amount);

			deposit=new JButton("Deposit");
			deposit.setBounds(550, 285, 150, 35);
			deposit.setFont(new Font("Cambria", Font.BOLD, 25));
			deposit.addActionListener(this);
			image.add(deposit);

			back=new JButton("Back");
			back.setBounds(550, 335, 150, 35);
			back.setFont(new Font("Cambria", Font.BOLD, 25));
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
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==deposit) {     // to store the deposited amount we need to create table
			String dep_amount1=dep_amount.getText();
			Date date=new Date();
			if(dep_amount1=="") {
				JOptionPane.showMessageDialog(null, "Please enter the amount to deposit");
			}else {
				try {
				Database_Connector con=new Database_Connector();
				String query="insert into deposit values('"+pinNumber+"','"+date+"','Deposit','"+dep_amount1+"')";
				con.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs"+dep_amount1+"Deposited Successfully");
				setVisible(false);
				new ATM_Machine(pinNumber).setVisible(true);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
			
		}else if(ae.getSource()==back) {
			setVisible(false);
			new ATM_Machine(pinNumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Deposit("");
	}

}
