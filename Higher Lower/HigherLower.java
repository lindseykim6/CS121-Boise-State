import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 10: Activity - while Loops and Iterators 
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class HigherLower
{
	public static void main(String[] args)
	{
		final int MAX = 10;
		int answer;
		int guess;
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
	
		
		String playAgain="y";

		while(playAgain.equals("y")) {	
			answer = random.nextInt(MAX) + 1;
			
			System.out.print("I'm thinking of a number between 1 and " + MAX + ". ");
			System.out.print("Guess what it is: ");
			guess=scan.nextInt();
			
			while(guess!=answer) {
				if(guess<1||guess>10) {
					System.out.print("Your guess is out of range. Guess again: ");	
				} else {
					if (guess>answer) {
						System.out.print("Guess lower: ");
						
					} else {
						System.out.print("Guess highter: ");
					}
				}
				guess=scan.nextInt();
			}
			
			System.out.println("You got it! Good guessing!");
			System.out.print("Would you like to play again? ");
			playAgain=scan.next().toLowerCase().substring(0,1);
		}
		
		System.out.println("Game over. Goodbye!");
		
		scan.close();
	}
}
