package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//import models.LoginModels;
import models.SignupModels;

public class SignupController {
	String dbUrl="jdbc:mysql://localhost:3306/mkce";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
	SignupModels sum;
	
	public SignupController(SignupModels sum)
	{
		this.sum=sum;
	}
	public void toStore(){
		Connection con=null;
		try {
		  Class.forName(dbDriver);
          con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
          String sql = "INSERT INTO student(username,password,email) VALUES('" +sum.getName()+ "','" +sum.getPassword()+ "','" + sum.getEmail()+"')"; 
          Statement s = con.createStatement();
          s.execute(sql);
          con.close();
		}
		 catch(Exception e)
        {
       	 System.out.print(e);
        }
		
	}

}