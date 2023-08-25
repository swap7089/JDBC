package bankmanagement;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignUp extends JFrame implements ActionListener{
	
	JTextField nameTextField,fnameTextField,pinTextField,emailTextField,addressTextField,cityTextField,stateTextField;
	JButton next;
	JRadioButton male,female,married,unmarried,other;
	JLabel formno,personDetails,name, fname,dob ,gender,email,status,address,city,state,pin;
	JDateChooser dateChooser;
	long random;
	SignUp(){
		
		//compulsory to set layout as null or else setbounds() doesn't work
		setLayout(null);
		
		Random ran=new Random();
		random=Math.abs((ran.nextLong()%9000L)+1000L);
		
		 formno = new JLabel("APPLICATION FORM NO."+ random);
		formno.setFont(new Font("Cambria",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
				

		personDetails = new JLabel("Page 1:Person Details");
		personDetails.setFont(new Font("Cambria",Font.BOLD,28));
		personDetails.setBounds(290,80,400,30);
		add(personDetails);
		
		
		name= new JLabel("Name:");
		name.setFont(new Font("Cambria",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);

		nameTextField = new JTextField();
		nameTextField.setBounds(300,140,400,30);
		nameTextField.setFont(new Font("Cambria",Font.BOLD,20));
		add(nameTextField);
		
		 fname= new JLabel("Father's Name:");
		fname.setFont(new Font("Cambria",Font.BOLD,20));
		fname.setBounds(100,180,300,30);
		add(fname);

		fnameTextField = new JTextField();
		fnameTextField.setBounds(300,180,400,30);
		fnameTextField.setFont(new Font("Cambria",Font.BOLD,20));
		add(fnameTextField);
		
		dob= new JLabel("Date Of Birth:");
		dob.setFont(new Font("Cambria",Font.BOLD,20));
		dob.setBounds(100,220,300,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,220,400,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		gender= new JLabel("Gender:");
		gender.setFont(new Font("Cambria",Font.BOLD,20));
		gender.setBounds(100,260,100,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300,260,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(450,260,120,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		
		//To select only one radio button
	 // we use Button Group
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		email= new JLabel("Email Address:");
		email.setFont(new Font("Cambria",Font.BOLD,20));
		email.setBounds(100,300,300,30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(300,300,400,30);
		emailTextField.setFont(new Font("Cambria",Font.BOLD,20));
		add(emailTextField);
		
		status= new JLabel("Marital Status:");
		status.setFont(new Font("Cambria",Font.BOLD,20));
		status.setBounds(100,340,300,30);
		add(status);
		
		married=new JRadioButton("Married");
		married.setBounds(300,340,120,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(450,340,120,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other=new JRadioButton("Other");
		other.setBounds(450,340,120,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		//To select only one radio button
	 // we use Button Group
		ButtonGroup statusgroup=new ButtonGroup();
		statusgroup.add(married);
		statusgroup.add(unmarried);
		statusgroup.add(other);
		
		address= new JLabel("Address:");
		address.setFont(new Font("Cambria",Font.BOLD,20));
		address.setBounds(100,380,100,30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(300,380,400,30);
		addressTextField.setFont(new Font("Cambria",Font.BOLD,20));
		add(addressTextField);
		
		city= new JLabel("City:");
		city.setFont(new Font("Cambria",Font.BOLD,20));
		city.setBounds(100,420,100,30);
		add(city);

		cityTextField = new JTextField();
		cityTextField.setBounds(300,420,400,30);
		cityTextField.setFont(new Font("Cambria",Font.BOLD,20));
		add(cityTextField);
		
		state= new JLabel("State:");
		state.setFont(new Font("Cambria",Font.BOLD,20));
		state.setBounds(100,460,100,30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setBounds(300,460,400,30);
		stateTextField.setFont(new Font("Cambria",Font.BOLD,20));
		add(stateTextField);
		
	    pin= new JLabel("Pin Code:");
		pin.setFont(new Font("Cambria",Font.BOLD,20));
		pin.setBounds(100,500,100,30);
		add(pin);
		
		pinTextField = new JTextField();
		pinTextField.setBounds(300,500,400,30);
		pinTextField.setFont(new Font("Cambria",Font.BOLD,20));
		add(pinTextField);
		
		next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Cambria",Font.BOLD,14));
		next.setBounds(620,600,80,30);
		next.addActionListener(this);   //Action added when button is clicked
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String formno = "" + random;
		String name=nameTextField.getText();
		String fname=fnameTextField.getText();
		String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender="Male";
		}
		else if(female.isSelected()) {
			gender="Female";
		}
		String email=emailTextField.getText();
		String marital=null;
		if(married.isSelected()) {
			marital="Married";
		}
		else if(unmarried.isSelected()) {
			marital="Unmarried";
		}
		else if(other.isSelected()) {
			marital="Other";
		}
		
		String address=addressTextField.getText();
		String city=cityTextField.getText();
		String state=stateTextField.getText();
		String pin=pinTextField.getText();
		
		//Validation if name is empty
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}else {
				//Executing query
				Database_Connector con=new Database_Connector();
				String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				con.st.executeUpdate(query);
				
				setVisible(false);  //when the whole form is filled and button is closed 
				new SignUp_2(formno).setVisible(true);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		
		new SignUp();

	}

}
