import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents a book with a title, author, genre, and file path
 * 
 * @author Lindsey Kim
 */
public class Book implements BookInterface{
	private String title;
	private String author;
	private String genre;
	private String filename;

	/**
	 * Constructor: Sets the initial title, author, genre, and filename of this book
	 */
	public Book(String title, String author) {
		this.title=title;
		this.author=author;
		genre=null;
		filename=null;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title=title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author=author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre=genre;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename=filename;
	}

	public boolean isValid() {
		try {
			File f=new File(filename);
			if (genre!=null&&title!=null&&author!=null&&f.exists()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public String getText() {
		File f=new File(filename);
		try {
			Scanner file=new Scanner(f); //scanner to parse through the file

			String text = "";

			while(file.hasNextLine()) {
				text+=file.nextLine()+"\n";
			}
			file.close();
			return text;

		} catch (FileNotFoundException e) {
			return ("File not found!"); 
		}

	}

	public String toString() {
		return ("Book Title: " + title + ", Author: " + author +", Genre: " +genre);
	}
}
