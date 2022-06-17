import java.text.NumberFormat;
import java.util.Scanner;

public class AdGenerator {

	public static void main(String[] args) {
	final String BORDER = "===========================================";
	
	System.out.println("Welcome to Ad Generator!");
	System.out.println("Please enter your profile information.");
	System.out.println(BORDER);
	
	Scanner scan=new Scanner(System.in);
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	//First name
	System.out.print("First name: ");
	String firstName=scan.nextLine();
	
	//Middle name
	System.out.print("Middle name: ");
	String middleName=scan.nextLine();
	
	//Last name
	System.out.print("Last name: ");
	String lastName=scan.nextLine();
	
	//Job title
	System.out.print("Job Title: ");
	String jobTitle=scan.nextLine();
	
	//Phone number
	System.out.print("Phone number (10 digit): ");
	String phoneNumber=scan.nextLine();
	
	//Hourly rate
	System.out.print("Hourly rate: ");
	double hourlyRate=scan.nextDouble();
	
	//Generate ad
	System.out.println(
			BORDER+ "\n" +
			"Need a " + jobTitle + "?\n" +
			"CALL NOW! (" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" +
			phoneNumber.substring(6,10) + "\n" +
			"Ask for " + firstName + " " + middleName.charAt(0) + ". " + lastName + "\n" +
			"(Rates start at " + fmt.format(hourlyRate) + "/hr)\n" +
			BORDER
	);
	
	
	
	scan.close();
	}

}
