import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Lesson 13: Activity - GradeBook
 *
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
public class GradeBook {

	public static void main(String[] args) {

		/* TODO: 1. Create a new ArrayList of Student objects called gradebook. */
		ArrayList <Student> gradebook=new ArrayList<>();


		/* TODO: 2. Create a new File object for gradebook.csv and 
		 * a new Scanner object to parse it. Catch any required 
		 * exceptions and display a useful message to the user.
		 */

		File file=new File("gradebook.csv");

		try {
			Scanner scan =new Scanner(file);

			/* TODO: 3. Use a while loop and the Scanner created above to iterate 
			 * through the lines in the gradebook.csv file.
			 */
			while (scan.hasNextLine()) {
				String line=scan.nextLine();

				/* TODO: 4. For each line (student record), use a second 
				 * Scanner object to tokenize the line using a comma (',')
				 * as the delimiter, extract values for lastName, firstName,
				 * id and grade and store them to local variables.
				 */

				Scanner lineScan=new Scanner(line);
				lineScan.useDelimiter(",");

				String lastName=lineScan.next();
				String firstName=lineScan.next();
				int id=lineScan.nextInt();
				int grade=lineScan.nextInt();

				/* TODO: 5. Create a new Student object using the local variables
				 * create above, set the student's grade, and finally add the 
				 * new Student object to the gradebook ArrayList. 
				 */

				Student s=new Student(firstName, lastName, id);
				s.setGrade(grade);
				gradebook.add(s);		
				lineScan.close();
			}	
			scan.close();
			

		} catch (FileNotFoundException e){
			System.out.println("File "+ file.getName()+ " not found!");
		}


		/* TODO: 6. Use a foreach loop to print out contents of the gradebook */

		for (Student s: gradebook) {
			System.out.println(s);
		}

	}

}
