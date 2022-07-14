package Airline;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import Airline.AirlineReservation;
public class Loginpage {
     
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
      public static void login() throws ClassNotFoundException, SQLException {
    	  LoginOption p = new LoginOption();
    	  Scanner s = new Scanner(System.in);
          AirlineReservation ar = new AirlineReservation();
    	  System.out.println("\tLogin");
    	  System.out.println("*****************");
    	  System.out.println("Enter Username:");
         String Username = s.next();
         System.out.println("Enter password:");
         String Password = s.next();
         String sql = "Select Username,Password from Register;";
         PreparedStatement ps = getCon().prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         if(rs.next()){
        	 if(Username.equals(rs.getString("Username"))){
        	 		if(Password.equals(rs.getString("Password"))) {
        	 			System.out.println("Login Sucessfully.....\\nNow you login and registering your flight\n");
        	 			Connection con=getCon();
        	 			PreparedStatement pst=null;
        	 			String s1 = "select*from Admin;";
        	 			pst=con.prepareStatement(s1);
        	 			ResultSet rs1=pst.executeQuery();
        	 			System.out.print("\tFlightName\t");
    	 				System.out.print("Arrival_Time\t");
    	 				System.out.print("Takeoff_Time \t");
    	 				System.out.print("Date   \t\t");
    	 				System.out.print("Place_From   \t");
    	 				System.out.print("Place_To \n");
    	 				System.out.println("\t-----------------------------------------------------------------------------------------------");
        	 			while(rs1.next())
        	 			{   
                            System.out.print("\t");
        	 				System.out.print(rs1.getString("FlightName")+"     \t");
        	 				System.out.print(rs1.getString("Arrival_Time")+"     \t");
        	 				System.out.print(rs1.getString("Takeoff_Time")+"   \t");
        	 				System.out.print(rs1.getString("Date")+"  \t");
        	 				System.out.print(rs1.getString("Place_From")+"  \t");
        	 				System.out.print(rs1.getString("Place_To")+"  \t");
        	 				System.out.println();
        	 			}
        	 			
        	 			ar.main(null);    
        	}	
        	 }
        	 
        	 		else {
           	 			System.out.println("Please enter valid username or password or Register your details...");
           	 			p.main(null);
           	 		
        	 }
        	
        }
         
         
      }
      public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Loginpage l = new Loginpage();
        
        //AirlineReservation ar = new AirlineReservation();
        l.login();
       
     
      
      }
}

