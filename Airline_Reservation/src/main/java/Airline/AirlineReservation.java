package Airline;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
//import  airlineproj.Airline_connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class AirlineReservation {
	static final int MAX = 100;
	Scanner sc = new Scanner(System.in);
	public Connection getCon() throws ClassNotFoundException, SQLException
	{
		Connection con= null;
		
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline_Reservation?user=root&password=Industry12$;");
		if(con!=null)
		{
			System.out.println("Connected!!");
		}
		return con;
	}
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		AirlineReservation ar = new AirlineReservation();
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		   
		    System.out.println("Welcome to Airline Reservation");
		    System.out.println("*******************************");
        	System.out.print("1.Business\n2.Economy\n3.First class\n");
        	System.out.println("Enter your choice:");
        	int ch = sc.nextInt();
        	if(ch == 1) {
        		ar.Airline_Business();
        	}
        	else if(ch == 2) {
        		ar.Airline_Economy();
        	}
        	else if(ch == 3) {
        		ar.FirstClass();
        	}
        
}


void Airline_Business() throws ClassNotFoundException, SQLException {
	
	System.out.println("1.Direct\n2.One Stop\n3.Two Stop");
	    int basic_rate = 3000;
		int op = sc.nextInt();
		if(op == 1) {
			direct(basic_rate);
			
		}
		if(op == 2) {
			One_stop(basic_rate);
		}
		else {
			Two_stop(basic_rate);
		}
	}
void FirstClass() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	  System.out.println("1.Direct\n2.One Stop\n3.Two Stop");
		int basic_rate = 5000;
		int op = sc.nextInt();
		if(op == 1) {
			direct(basic_rate);
			
		}
		if(op == 2) {
			One_stop(basic_rate);
		}
		else {
			Two_stop(basic_rate);
		}
	}

void Airline_Economy() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
 System.out.println("1.Direct\n2.One Stop\n3.Two Stop");
	int basic_rate = 1500;
	int op = sc.nextInt();
	if(op == 1) {
		direct(basic_rate);
		
	}
	if(op == 2) {
		One_stop(basic_rate);
	}
	else {
		Two_stop(basic_rate);
	}
}
public void  direct(int basic_rate) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
    System.out.println("Route From:");
    String from = sc.next();
    System.out.println("Route to:");
    String to = sc.next();
    int Gst = 13;
	int Cgst = 10;
	int cal1 = basic_rate * Gst/100;
	int cal2 = basic_rate * Cgst/100;
	int calculation = basic_rate + cal1+cal2;
    ticket_available(calculation);
	
}
public void One_stop(int basic_rate) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	int basic_pay = 4000;
	System.out.println("Route From:");
    String from = sc.next();
    System.out.println("Route to:");
    String to = sc.next();
    int Gst = 15;
	int Cgst = 12;
	int cal1 = basic_rate * Gst/100;
	int cal2 = basic_rate * Cgst/100;
	int calculation = basic_rate + cal1+cal2;
    ticket_available(calculation);
}
public void Two_stop(int basic_rate) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
	
	System.out.println("Route From:");
    String from = sc.next();
    System.out.println("Route to:");
    String to = sc.next();
    //System.out.println("Which date you want to travel: ");
    //String date = sc.next();
    int Gst = 16;
	int Cgst = 15;
	int cal1 = basic_rate * Gst/100;
	int cal2 = basic_rate * Cgst/100;
	int calculation = basic_rate + cal1+cal2;
    ticket_available(calculation);
	
	
}
void ticket_available(int calculation) throws ClassNotFoundException, SQLException {
		//int f = sc.nextInt();
		System.out.println("Enter your seats:");
		int seat = sc.nextInt();
	 if(seat >= MAX) {
		 System.out.println("Seat is not available");
	}
	 else {
		 System.out.println("Seat is available");
		 double seatamount  = calculation * seat;
		 passanger(seatamount);
		System.out.println("Your Flight is booked\nPlease be here before half an hour of your flight for Ticket Verification\nHappy journey");
	 }
	 
	}
	
	void passanger(double seatamount) throws ClassNotFoundException, SQLException {
	    //Connection con = getCon();
	    //PreparedStatement ps = null;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Enter your name:");
		String Pasanger_name = sc.next();
		System.out.println("Enter your mobile number:");
		String Mobile_Number = sc.next();
		System.out.println("Enter your Aadhar Number:");
		long Aadhar_card = sc.nextLong();
		System.out.println("Payment Details(1.Gpay/2.cash):");
	    String Payment_type = sc.next();
		System.out.println("Travel Date:");
		String Travel_date=sc.next();		
		System.out.println("Amount:"+seatamount);
		Connection con = getCon();
	    PreparedStatement ps = null;
	    String list = "insert into Airlinereservation1(Pasanger_name,Mobile_Number,Aadhar_card,Payment_type,Travel_date,seatamount)values(?,?,?,?,?,?);";
		ps = con.prepareStatement(list);
		ps.setString(1,Pasanger_name);
		ps.setString(2, Mobile_Number);
		ps.setLong(3, Aadhar_card);
		ps.setString(4, Payment_type);
		ps.setString(5, Travel_date);
		ps.setDouble(6, seatamount);
		ps.executeUpdate();
		PreparedStatement pst=null;
		String s1 = "select*from Airlinereservation1;";
		pst=con.prepareStatement(s1);
		ResultSet rs1=pst.executeQuery();
		System.out.print("\tPasanger_name\t");
		System.out.print("Mobile_Number\t");
		System.out.print("Aadhar_Number   \t");
		System.out.print("Payment_type\t\t");
		System.out.print("Travel_date   \t");
		System.out.print("seatamount \n");
			System.out.println("\t----------------------------------------------------------------------------------------------------------");
			while(rs1.next())
			{   
            System.out.print("\t");
				System.out.print(rs1.getString("Pasanger_name")+"     \t");
				System.out.print(rs1.getString("Mobile_Number")+"     \t");
				System.out.print(rs1.getString("Aadhar_card")+"      \t");
				System.out.print(rs1.getString("Payment_type")+"     \t");
				System.out.print(rs1.getString("Travel_date")+"      \t");
				System.out.print(rs1.getString("seatamount")+"        \t");
				System.out.println();
			}
			
	    System.out.println("\n\n\t--------------------------------------Booking Time: "+df.format(now)+"---------------");
		System.out.print("\t\n\t\tPasanger Name : "+Pasanger_name+"        "+"\tFlight Date:"+Travel_date);
		System.out.println("\t\n\t\tMobile Number : "+Mobile_Number+"        "+"Amount Paid:"+seatamount); 
		System.out.println("\t------------------------------------------------------------------------------------------");
 
 }
}

	


