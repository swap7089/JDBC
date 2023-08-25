package bankmanagement;

import java.awt.Color;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.*;
public class SignUp_3 extends JFrame implements ActionListener{

	 JFrame frame;
	JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6,lblNewLabel_7,lblNewLabel_8;
	JRadioButton rbsaving,rbFixed,rbCurrent,rbRecurring;
	JButton bCancel,bSubmit;
	JCheckBox chckbxNewCheckBox_1,chckbxEstatement,chckbxChequeBook,chckbxEmailSms,chckbxMobileBanking,chckbxInternetBanking,chckbxNewCheckBox;
	String formno;
	public SignUp_3(String formno){
		this.formno=formno;
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Page 3:Account Details");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(244, 44, 308, 57);
		
		
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Account Type");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(89, 108, 200, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		rbsaving = new JRadioButton("Saving Account");
		rbsaving.setFont(new Font("Cambria", Font.BOLD, 15));
		rbsaving.setHorizontalAlignment(SwingConstants.CENTER);
		rbsaving.setBounds(130, 167, 159, 23);
		rbsaving.setBackground(Color.WHITE);
		frame.getContentPane().add(rbsaving);
		
		rbFixed = new JRadioButton("Fixed Deposit Account");
		rbFixed.setHorizontalAlignment(SwingConstants.CENTER);
		rbFixed.setFont(new Font("Cambria", Font.BOLD, 15));
		rbFixed.setBounds(317, 167, 185, 23);
		rbFixed.setBackground(Color.WHITE);
		frame.getContentPane().add(rbFixed);
		
		rbCurrent = new JRadioButton("Current Account");
		rbCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		rbCurrent.setFont(new Font("Cambria", Font.BOLD, 15));
		rbCurrent.setBounds(130, 231, 159, 23);
		rbCurrent.setBackground(Color.WHITE);
		frame.getContentPane().add(rbCurrent);
		
		rbRecurring = new JRadioButton("Recurring Deposit Account");
		rbRecurring.setHorizontalAlignment(SwingConstants.CENTER);
		rbRecurring.setFont(new Font("Cambria", Font.BOLD, 15));
		rbRecurring.setBounds(317, 233, 200, 23);
		rbRecurring.setBackground(Color.WHITE);
		frame.getContentPane().add(rbRecurring);
		
		lblNewLabel_2 = new JLabel("Card Number");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 20));
		lblNewLabel_2.setBounds(127, 287, 200, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Your 16 Digit Card Number");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(112, 325, 165, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("XXXX-XXXX-XXXX-7741");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 20));
		lblNewLabel_4.setBounds(330, 287, 222, 50);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Pin");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD, 20));
		lblNewLabel_5.setBounds(127, 359, 200, 50);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("XXXX");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD, 20));
		lblNewLabel_6.setBounds(330, 359, 222, 50);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Your 4 Digit Password");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_7.setBounds(102, 395, 165, 23);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Services Required:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setFont(new Font("Cambria", Font.BOLD, 20));
		lblNewLabel_8.setBounds(130, 444, 200, 50);
		frame.getContentPane().add(lblNewLabel_8);
		
		chckbxNewCheckBox = new JCheckBox("ATM Card");
		chckbxNewCheckBox.setFont(new Font("Cambria", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(130, 509, 97, 23);
		chckbxNewCheckBox.setBackground(Color.WHITE);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		chckbxInternetBanking = new JCheckBox("Internet Banking");
		chckbxInternetBanking.setFont(new Font("Cambria", Font.BOLD, 15));
		chckbxInternetBanking.setBounds(333, 511, 149, 23);
		chckbxInternetBanking.setBackground(Color.WHITE);
		frame.getContentPane().add(chckbxInternetBanking);
		
		chckbxMobileBanking = new JCheckBox("Mobile Banking");
		chckbxMobileBanking.setFont(new Font("Cambria", Font.BOLD, 15));
		chckbxMobileBanking.setBounds(130, 552, 140, 23);
		chckbxMobileBanking.setBackground(Color.WHITE);
		frame.getContentPane().add(chckbxMobileBanking);
		
		chckbxEmailSms = new JCheckBox("Email & SMS Alerts");
		chckbxEmailSms.setFont(new Font("Cambria", Font.BOLD, 15));
		chckbxEmailSms.setBounds(333, 552, 169, 23);
		chckbxEmailSms.setBackground(Color.WHITE);
		frame.getContentPane().add(chckbxEmailSms);
		
		chckbxChequeBook = new JCheckBox("Cheque Book");
		chckbxChequeBook.setFont(new Font("Cambria", Font.BOLD, 15));
		chckbxChequeBook.setBounds(130, 594, 125, 23);
		chckbxChequeBook.setBackground(Color.WHITE);
		frame.getContentPane().add(chckbxChequeBook);
		
		chckbxEstatement = new JCheckBox("E-Statement");
		chckbxEstatement.setFont(new Font("Cambria", Font.BOLD, 15));
		chckbxEstatement.setBounds(333, 594, 149, 23);
		chckbxEstatement.setBackground(Color.WHITE);
		frame.getContentPane().add(chckbxEstatement);
		
		chckbxNewCheckBox_1 = new JCheckBox("I hereby declares that the above entered details are correct.");
		chckbxNewCheckBox_1.setFont(new Font("Cambria", Font.BOLD, 12));
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1.setBounds(230, 630, 359, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		bCancel = new JButton("Cancel");
		bCancel.setBackground(new Color(0, 0, 0));
		bCancel.setFont(new Font("Cambria", Font.BOLD, 18));
		bCancel.setForeground(new Color(255, 255, 255));
		bCancel.setBounds(224, 674, 103, 38);
		bCancel.addActionListener(this);
		frame.getContentPane().add(bCancel);
		
		bSubmit = new JButton("Submit");
		bSubmit.setForeground(Color.WHITE);
		bSubmit.setFont(new Font("Cambria", Font.BOLD, 18));
		bSubmit.setBackground(Color.BLACK);
		bSubmit.setBounds(486, 674, 103, 38);
		bSubmit.addActionListener(this);
		frame.getContentPane().add(bSubmit);
		
		frame.setSize(850,800);
		frame.setLocation(350,10);
		frame.setVisible(true);
	
		
		
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Launch the application.
	 */
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==bSubmit) {
			String accountType=null;
			if(rbsaving.isSelected()) {
				accountType="Savings Account";
			}else if(rbFixed.isSelected()) {
				accountType="Fixed Deposit Account";
			}else if(rbCurrent.isSelected()) {
				accountType="Current Account";
			}else if(rbRecurring.isSelected()) {
				accountType="Reccuring Deposit Account";
			}
			
			Random random = new Random();
			String cardnumber="" + Math.abs(random.nextLong()%90000000L+504093600000000L);
			String pinnumber="" +Math.abs((random.nextLong()%9000L)+1000L);
		
			String facility="";
			if(chckbxNewCheckBox.isSelected())
			{
				facility = facility + "ATM Card";
			}else if(chckbxInternetBanking.isSelected())
			{
				facility = facility + "Internet Banking";
			}else if(chckbxMobileBanking.isSelected())
			{
				facility = facility + "Mobile Banking";
			}else if(chckbxEmailSms.isSelected())
			{
				facility = facility + "Email & SMS";
			}else if(chckbxChequeBook.isSelected())
			{
				facility = facility + "Cheque Book";
			}else if(chckbxEstatement.isSelected())
			{
				facility = facility + "E-Statement";
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");	//To create a check
				}else {
					//Create a Connection
					Database_Connector con=new Database_Connector();
					String query1="insert into signup_3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"');";
					String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"');";
					con.st.executeUpdate(query1);
					con.st.executeUpdate(query2);

					JOptionPane.showMessageDialog(null, "Card Number:"+cardnumber+"\nPin Number:"+pinnumber);
					setVisible(false);
					new Deposit(pinnumber).setVisible(false);
				}    
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		
		}else if(ae.getSource()==bCancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
	
					new SignUp_3("");
					
		
	}
}
