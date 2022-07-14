package Airline;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginOption {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Registeration r = new Registeration();
     Scanner sc = new Scanner(System.in);
     Admin ad = new Admin();
     Loginpage l = new Loginpage();
     System.out.println("\n\tAIRLINE MANAGEMENT SYSTEM");
     System.out.println("***********************************");
     System.out.println("\t1.Admin \n \t2.Pasanger\n\t3.Register");
     int option = sc.nextInt();
     if(option == 1){
    	 ad.main(null);
     }
     else if(option == 2) {
    	 l.login();
     }
     else if(option == 3) {
    	 r.main(null);
     }
     else {
    	 System.out.println("Please choose any option......");
     }
	}

}
