package bankmanagement;

import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.Statement;

public class Database_Connector {
	Connection con;
	Statement st;

	public  Database_Connector(){
		try
		{
		String url="jdbc:mysql://localhost:3306/bankmanagementsystem";
		String uname="root";
		String pass="password";
	Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.jdbc.Driver is a mysql driver forName is method used to load the driver & Class is a interface
		 con=DriverManager.getConnection(url,uname,pass);//Connection is a interface
		st=con.createStatement();	
	//select name of those user whose userid=3;

		//st.close();
		//con.close();

	}
		catch(Exception e) {
			System.out.println(e);
		}
		}
}