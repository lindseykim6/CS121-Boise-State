import java.util.ArrayList;

/**
 * Represents a library of Book objects 
 * 
 * @author Lindsey Kim
 */

public class Library implements LibraryInterface {
	private ArrayList<Book> books;

	/**
	 * Constructor: Instantiates the initial arrayList of this book
	 */
	public Library() {
		books=new ArrayList<>();
	}

	public ArrayList<Book> getBooks() {
		ArrayList<Book> copy=new ArrayList<>(); //encapsulates by creating a copy
		for(Book i: books) {
			copy.add(i);
		}
		return copy;
	}

	public void addBook(Book newBook) {
		books.add(newBook);	
	}

	public void removeBook(int index) {
		if (0<=index&&index<books.size()) {
			books.remove(index);
		}
	}

	public Book getBook(int index) {

		if (0<=index&&index<books.size()) {
			return books.get(index);
		} else {
			return null;
		}
	}

	public String toString() {
		String toString="";
		for (Book i: books) {
			toString+=books.indexOf(i)+ ": "+ i.toString()+"\n";
		}
		return toString;
	}
}
