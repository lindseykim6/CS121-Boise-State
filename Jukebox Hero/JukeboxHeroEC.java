import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CS 121 Project 2: Jukebox Hero
 *
 * Creates an analytical tool that takes a customer's music catalog and has the capability of opening the music catalog, 
 * print statistics about it, search for songs in it, and display it.
 *
 * @author Lindsey Kim
 */

public class JukeboxHeroEC {
	
	//prints the main menu 
	private static void displayMenu(){
		final String BORDER="*****************************";
		System.out.println();
		System.out.println(BORDER);
		System.out.println( "*      Program Menu         *");
		System.out.println(BORDER);
		System.out.println("(L)oad catalog");
		System.out.println("(S)earch catalog");
		System.out.println("(A)nalyze catalog");
		System.out.println("(P)rint catalog");
		System.out.println("(Q)uit\n");
	
	//loads the catalog into the arrayList
	} private static void loadCatalog(ArrayList<Song> sl, Scanner kbd) { 
		System.out.print("Load Catalog...\nPlease enter filename: ");
		String fileName=kbd.nextLine();//scans catalog file to load
		File file= new File(fileName);
		
		try { 
			sl.clear();
			Scanner fileScan=new Scanner(file);
			int count=0;//used to count the number of songs
			
			while (fileScan.hasNextLine()) {
				String line=fileScan.nextLine();

				Scanner lineScan=new Scanner(line);
				lineScan.useDelimiter(",");

				String artist=lineScan.next();
				String album=lineScan.next();
				String title=lineScan.next();
				int duration=lineScan.nextInt();
				lineScan.close();

				Song s=new Song(title, artist, album, duration);
				sl.add(s);
				count++;
			}
			
			System.out.println("Successfully loaded "+ count + " songs!");
			fileScan.close();
			
		}catch (FileNotFoundException e) { 
			System.out.println("Unable to open file: " + fileName); //prints if user inputs an invalid file
		}

	//displays the entire catalog
	} private static void printCatalog(ArrayList<Song> sl) {
		String DIVIDER="---------------------------------";
		System.out.println("Song list contains " + sl.size() +" songs...");
		System.out.println(DIVIDER);

		for(Song s:sl) {		
			System.out.println(s.toString());
		}
	
	//parses through the catalog for a certain String 
	} private static void searchCatalog(ArrayList<Song> sl, Scanner kbd) {
		System.out.print("Search Catalog...\nPlease enter the search query: ");
		
		ArrayList<Song> searchResults=new ArrayList<Song>();
		searchResults.clear();
		
		String searchQuery=kbd.nextLine();

		for(Song s: sl) {
			if(s.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
				searchResults.add(s); 
			}
		} 
		
		System.out.println("Found " + searchResults.size()+ " matches");
		System.out.println("---------------------------------");
		
		for(Song s:searchResults) {
			System.out.println(s);
		}
		
	//prints number of songs, albums, and artists and prints total play time 
	} private static void analyseCatalog(ArrayList<Song> sl) {
		System.out.println("Catalog Analysis...");
		
		ArrayList<String> albumList=new ArrayList<String>();
		ArrayList<String> artistList=new ArrayList<String>();

		int playTime=0;
		for(Song s:sl) {
			if(!albumList.contains(s.getAlbum())){
				albumList.add(s.getAlbum());}
			if(!artistList.contains(s.getArtist())){
				artistList.add(s.getArtist());
			} playTime+=s.getPlayTime();
		}

		System.out.println("	Number of Artists: " + artistList.size());
		System.out.println("	Number of Albums: "+ albumList.size());
		System.out.println("	Number of Songs: " + sl.size());
		System.out.println("	Catalog Playtime: " + playTime);
		
		albumList.clear();
		artistList.clear();
	}

	
	public static void main(String[] args) {

		Scanner keyboardScan=new Scanner(System.in);
		ArrayList<Song> songList = new ArrayList<Song>();
		displayMenu();//prints main menu
		
		String command="";

		while(!command.toLowerCase().equals("q")) {
			System.out.print("\nPlease enter a command (press 'm' for Menu): ");
			command=keyboardScan.nextLine().toLowerCase();//asks for a user command
			
			switch(command) {
				case("l"): 
					loadCatalog(songList,keyboardScan);
					break;
					
				case("s"):
					searchCatalog(songList,keyboardScan);
					break;
					
				case("a"): 
					analyseCatalog(songList);
					break;
					
				case("p"):	
					printCatalog(songList);
					break;
					
				case("q"): //quits the tool if the user inputs a "q"
					System.out.println("Goodbye!");
				
					break;
					
				case("m"): 
					displayMenu();
				
					break;
					
				default: // prints if the user inputs an invalid menu item
					System.out.println("Invalid selection!");
				}
	
			}

		keyboardScan.close();
	}

}