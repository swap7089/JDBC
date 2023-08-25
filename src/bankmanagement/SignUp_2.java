package bankmanagement;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignUp_2 extends JFrame implements ActionListener{
	
	long random;
	JLabel addDetails,religion,income,category,education,occupation,pan,aadhar,senior,existing;
	JTextField aadhartxt,pantxt;
	JRadioButton yes,no,eyes,eno;
	JComboBox education1,category1,income1,religion1,occupation1;
	JButton next;
	String formno;
	SignUp_2(String formno)
	{
		this.formno=formno;
		setLayout(null);
		
		
		

		addDetails = new JLabel("Page 2:Additional Details");
		addDetails.setFont(new Font("Cambria",Font.BOLD,28));
		addDetails.setBounds(290,80,400,30);
		add(addDetails);
		
		
		religion= new JLabel("Religion:");
		religion.setFont(new Font("Cambria",Font.BOLD,20));
		religion.setBounds(100,140,100,30);
		add(religion);

		String valReligion[] = {"Hindu","Muslim","Sikh","Other"};
		religion1=new JComboBox(valReligion);
		religion1.setBounds(300, 140, 200, 30);;
		religion1.setBackground(Color.WHITE);
		add(religion1);

		
		category= new JLabel("Category:");
		category.setFont(new Font("Cambria",Font.BOLD,20));
		category.setBounds(100,180,300,30);
		add(category);


		
		String valCategory[]={"General","OBC","SC","ST","Other"};
		category1=new JComboBox(valCategory);
		category1.setBounds(300,180,200,30);;
		category1.setBackground(Color.WHITE);
		add(category1);

		
		income= new JLabel("Income:");
		income.setFont(new Font("Cambria",Font.BOLD,20));
		income.setBounds(100,220,300,30);
		add(income);
		

		String valIncome[]={"Null","< 1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
		income1=new JComboBox(valIncome);
		income1.setBounds(300,220,200,30);;
		income1.setBackground(Color.WHITE);
		add(income1);

		education= new JLabel("Education:");
		education.setFont(new Font("Cambria",Font.BOLD,20));
		education.setBounds(100,260,100,30);
		add(education);
		
		String educationalValues[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
		education1=new JComboBox(educationalValues);
		education1.setBounds(300,260,200,30);;
		education1.setBackground(Color.WHITE);
		add(education1);

		
		
		occupation= new JLabel("Occupation:");
		occupation.setFont(new Font("Cambria",Font.BOLD,20));
		occupation.setBounds(100,300,300,30);
		add(occupation);
		
		String occupationValues[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
		occupation1=new JComboBox(occupationValues);
		occupation1.setBounds(300,300,200,30);;
		occupation1.setBackground(Color.WHITE);
		add(occupation1);
		
		pan= new JLabel("PAN Number:");
		pan.setFont(new Font("Cambria",Font.BOLD,20));
		pan.setBounds(100,340,300,30);
		add(pan);
		
		pantxt = new JTextField();
		pantxt.setBounds(300,340,250,30);
		pantxt.setFont(new Font("Cambria",Font.BOLD,20));
		add(pantxt);
		
		aadhar= new JLabel("Aadhar Number:");
		aadhar.setFont(new Font("Cambria",Font.BOLD,20));
		aadhar.setBounds(100,380,300,30);
		add(aadhar);
		
		aadhartxt = new JTextField();
		aadhartxt.setBounds(300,380,250,30);
		aadhartxt.setFont(new Font("Cambria",Font.BOLD,20));
		add(aadhartxt);
		
		senior= new JLabel("Senior Citizen:");
		senior.setFont(new Font("Cambria",Font.BOLD,20));
		senior.setBounds(100,420,300,30);
		add(senior);

		yes=new JRadioButton("Yes");
		yes.setBounds(300,420,120,30);
		yes.setBackground(Color.WHITE);
		add(yes);
		
		no=new JRadioButton("No");
		no.setBounds(450,420,120,30);
		no.setBackground(Color.WHITE);
		add(no);
		
		ButtonGroup citizengroup=new ButtonGroup();
		citizengroup.add(yes);
		citizengroup.add(no);
		
		
		existing= new JLabel("Exsiting Account:");
		existing.setFont(new Font("Cambria",Font.BOLD,20));
		existing.setBounds(100,460,300,30);
		add(existing);
		
		eyes=new JRadioButton("Yes");
		eyes.setBounds(300,460,120,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno=new JRadioButton("No");
		eno.setBounds(450,460,120,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existinggroup=new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);
		
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
		String formno= "" + random;
		String str_religion=(String)religion1.getSelectedItem();
		String str_category=(String)category1.getSelectedItem();
		String str_income=(String)income1.getSelectedItem();
		String str_education=(String)education1.getSelectedItem();
		String str_occupation=(String)occupation1.getSelectedItem();
		
		String str_senior=null;
		if(yes.isSelected()) {
			str_senior="Yes";
		}else if(no.isSelected()) {
			str_senior="No";
		}
		
		String str_existing=null;
		if(eyes.isSelected()) {
			str_existing="Yes";
		}else if(eno.isSelected()) {
			str_existing="No";
		}
		
		String str_pan=pantxt.getText();
		String str_aadhar=aadhartxt.getText();
		try {
			if(str_religion.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}else {
				//Executing query
				Database_Connector con=new Database_Connector();
				String query="insert into signup_2 values('"+formno+"','"+str_religion+"','"+str_category+"','"+str_income+"','"+str_education+"','"+str_occupation+"','"+str_pan+"','"+str_aadhar+"','"+str_senior+"','"+str_existing+"')";
				con.st.executeUpdate(query);
				
				setVisible(false);  //when the whole form is filled and button is closed 
				new SignUp_3(formno).setVisible(true);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void main(String[] args) {
	 new SignUp_2("");
	}

}
