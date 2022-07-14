package Airline;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registeration {

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
		//Registeration reg = new Registeration();
      Scanner scan = new Scanner(System.in);
      System.out.println("\tREGISTRATION FORM");
      System.out.println("****************************");
      System.out.println("Ente Name:");
      String Pasanger_Name = scan.next();
      System.out.println("Enter Username:");
      String Username = scan.next();
      System.out.println("Enter Email_id:");
      String email_id = scan.next();
      System.out.println("Enter Mobile number:");
      String Mobile_Number = scan.next();
      System.out.println("Enter password:");
      String Password = scan.next();
      Connection con = getCon();
      PreparedStatement ps = null;
      String st = "insert into Register(Pasanger_Name,Username,email_id,Mobile_Number,Password)values(?,?,?,?,?);";
      ps = con.prepareStatement(st);
      ps.setString(1, Pasanger_Name);
      ps.setString(2,Username);
      ps.setString(3, email_id);
      ps.setString(4, Mobile_Number);
      ps.setString(5,Password);
      ps.executeUpdate();
      System.out.println(" Successfully Registered......");
      LoginOption p = new LoginOption();
      p.main(null);
      
      
	}

}

