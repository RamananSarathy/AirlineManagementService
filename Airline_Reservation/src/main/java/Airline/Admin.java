package Airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
	public static Connection getCon() throws ClassNotFoundException, SQLException
  	{
  		Connection con= null;
  		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline?user=root&password=Industry12$;");
  		if(con!=null)
  		{
  			System.out.println("Connected!!");
  		}
  		return con;
  	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		LoginOption p = new LoginOption();
		Scanner s = new Scanner(System.in);
		System.out.println("\tAdmin Login Page");
		System.out.println("*********************");
		System.out.println("Enter Username:");
        String Username = s.next();
        System.out.println("Enter password:");
        String Password = s.next();
        String sql = "Select * from AdminLogin;";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        	//System.out.println("hello");
       	 if(Username.equals(rs.getString("Username"))){
       	 		if(Password.equals(rs.getString("Password"))) 
       	 		{
                   System.out.println("Login Sucessfully.....");
                   System.out.println("FlightName:");
                   String FlightName = s.next();
                   System.out.println("Arrival_Time:");
                   String Arrival_Time = s.next();
                   System.out.println("Takeoff_Time:");
                   String Takeoff_Time = s.next();
                   System.out.println("Date:");
                   String Date = s.next();
                   System.out.println("Place_from:");
                   String Place_From = s.next();
                   System.out.println("Place_to:");
                   String Place_To = s.next();
           			Connection con =getCon();
           			PreparedStatement pss = null;
           	         String st = "insert into Admin(FlightName,Arrival_Time,Takeoff_Time,Date,Place_From,Place_To)values(?,?,?,?,?,?);";
           	         pss = con.prepareStatement(st);
           	         pss.setString(1,FlightName);
           	         pss.setString(2,Arrival_Time);
           	         pss.setString(3,Takeoff_Time);
           	         pss.setString(4,Date);
           	         pss.setString(5,Place_From);
           	         pss.setString(6,Place_To);
           	         pss.executeUpdate();
           	         System.out.println("Your table update sucessfully......");
           	         p.main(null);
           	}
       	 	else {
   	 			System.out.println("Please enter valid username or password");
   	 			p.main(null);
   	 		}
       	 		}
       	 		
       	 }
        }
        
}
