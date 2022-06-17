import java.util.Scanner;

/**
 * Creates a tool that uses a Library object and allows for the user to print the contents, add Book objects
 * delete Book objects, and read the content of those Book objects.
 * 
 * @author Lindsey Kim
 */

public class LibraryOfBooks {
	
	/**
	 * Prints the menu
	 */
	private static void displayMenu(){
		final String BORDER="*****************************";

		System.out.println();
		System.out.println(BORDER);
		System.out.println( "*      Program Menu         *");
		System.out.println(BORDER);
		System.out.println("(P)rint Contents");
		System.out.println("(A)dd a book");
		System.out.println("(D)elete a book");
		System.out.println("(R)ead a book");
		System.out.println("(Q)uit\n");		
	}
	
	/**
	 * Prints the contents of the library using the toString method
	 */
	private static void printContents(Library l) {
		System.out.println("Your library: \n");
		System.out.println(l.toString());
	}
	
	/**
	 * Adds a new book to the library
	 */
	private static void addNewBook(Library l, Scanner kbd) {
		System.out.println("Please enter Title: " );
		String title=kbd.nextLine();

		System.out.println("Please enter Author: " );
		String author=kbd.nextLine();

		Book newBook=new Book(title,author);

		System.out.println("Please enter Genre: ");
		String genre=kbd.nextLine();
		newBook.setGenre(genre);

		System.out.println("Please enter Filename: " );
		String filename=kbd.nextLine();
		newBook.setFilename(filename);

		l.addBook(newBook);

		System.out.println(title+" has been added to your library!");
	}
	
	/**
	 * Deletes a book from the library
	 */
	private static void deleteBook(Library l,Scanner kbd) {
		System.out.println("Please enter a book index number: ");
		String index= kbd.nextLine();

		try {
			int ind=Integer.parseInt(index);
			
			if (l.getBooks().size()!=0 && ind<l.getBooks().size()) {
				l.removeBook(ind);
				System.out.println("Book has been successfully removed!");
			} else {
				System.out.println("No book found at index: " + index); 
			}
		}
		
		catch(Exception e){
			System.out.println("No book found at index: " + index);
		}
	}

	/**
	 * Opens a specified book's text
	 */
	private static void readBook(Library l, Scanner kbd) {
		System.out.println("Please enter a book index number: ");
		String index= kbd.nextLine();
		
		try {
			int ind=Integer.parseInt(index);
			
			if (l.getBooks().size()!=0 && ind<l.getBooks().size()) {
				Book selectedBook=l.getBook(ind);
				if(selectedBook.isValid()) {	//checks to see if the file is a valid file
					System.out.println(selectedBook.getText());
				} else {
					System.out.println("Book at index " + ind+ " is invalid.");
				}
			} else {
				System.out.println("No book found at index: " + index);
			}
		}
		
		catch(Exception e){
			System.out.println("No book found at index: " + index);
		}
	}
	
	/**
	 * Creates a Library object and uses a while loop in order to provide a menu that allows 
	 * the user to print the library, and add, remove, and read books
	 */
	
	public static void main(String[] args) {
		System.out.println("Welcome to your Library of Books!");
		
		Scanner keyboardScan=new Scanner(System.in);
		Library myLibrary=new Library();
		
		//prints main menu
		displayMenu();
		
		String command="";

		while(!command.toLowerCase().equals("q")) { //menu loop continues until quit command
			System.out.print("\nPlease enter a command (press 'm' for Menu): ");
			command=keyboardScan.nextLine().toLowerCase();//asks for a user command
			switch(command) {
				case("p"): 
					printContents(myLibrary);
					break;
				case("a"):
					addNewBook(myLibrary, keyboardScan);
					break;
				case("d"): 
					deleteBook(myLibrary,keyboardScan);
					break;
				case("r"):
					readBook(myLibrary,keyboardScan);
					break;
				case("q"): //quits the tool if the user inputs a "q"
					System.out.println("Goodbye!");
					break;
				case("m"): //displays menu
					displayMenu();
				default:
					System.out.println("Invalid selection!");
			}
		}
		keyboardScan.close();
	}
}
