import java.util.Scanner;

public class ConvertToHMS {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many seconds? ");
		int input=scan.nextInt();
		
		int hours=input/3600;
		int minutes=(input % 3600)/ 60;
		int seconds=input % 60;
		
		System.out.println(input + " seconds is: " + hours + " hours, " + 
		minutes + " minutes, and " + seconds + " seconds");
		
		scan.close();
		
	}
}

