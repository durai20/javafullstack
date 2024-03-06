package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import jakarta.servlet.RequestDispatcher;
//import models.LoginModel;
import models.LoginModels;


public class LoginController {
	String dbUrl="jdbc:mysql://localhost:3306/mkce";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
	LoginModels slm;
	
	public LoginController(LoginModels slm) {
		this.slm=slm;
	}

	public boolean toGet() {
		 Connection con = null;
	   		try{
	   			Class.forName(dbDriver);  
	 			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   
	 			String sql = "select * from student where username='"+slm.getName()+"' and password='"+slm.getPass()+"'";
	 			Statement s = con.createStatement();
	 			ResultSet rs=s.executeQuery(sql);
	 			if(rs.next()) {
	 				return true;
	 			}
	 			else {
//	 					return false;
	 			}
	 		   	con.close();
	 		   	return false;
			} catch(Exception e){      
				e.printStackTrace();
			}	
	   		return false;
	}
	

}
