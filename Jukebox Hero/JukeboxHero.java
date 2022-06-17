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

public class JukeboxHero {
	public static void main(String[] args) {

		Scanner keyboardScan=new Scanner(System.in);
		
		//prints main menu
		ArrayList<Song> songList = new ArrayList<Song>();
		
		final String BORDER="*****************************";
		final String DIVIDER="---------------------------------";

		System.out.println(BORDER);
		System.out.println( "*      Program Menu         *");
		System.out.println(BORDER);
		System.out.println("(L)oad catalog");
		System.out.println("(S)earch catalog");
		System.out.println("(A)nalyze catalog");
		System.out.println("(P)rint catalog");
		System.out.println("(Q)uit\n");

		String command="";

		while(!command.toLowerCase().equals("q")) {
			System.out.print("\nPlease enter a command (press 'm' for Menu): ");
			command=keyboardScan.nextLine().toLowerCase();//asks for a user command
			
			switch(command) {
				case("l"): //loads the catalog into the arrayList if the user inputs an "l"
					System.out.print("Load Catalog...\nPlease enter filename: ");
					String fileName=keyboardScan.nextLine();//scans catalog file to load
					File file= new File(fileName);
					
					try { 
						songList.clear();
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
							songList.add(s);
							count++;
						}
						
						System.out.println("Successfully loaded "+ count + " songs!");
						fileScan.close();
						
					}catch (FileNotFoundException e) { 
						System.out.println("Unable to open file: " + fileName); //prints if user inputs an invalid file
					} 
					
					break;
					
				case("s"): //parses through the catalog for a certain String if the user inputs an "s"
	
					System.out.print("Search Catalog...\nPlease enter the search query: ");
	
					ArrayList<Song> searchResults=new ArrayList<Song>();
					searchResults.clear();
					
					String searchQuery=keyboardScan.nextLine();
		
					for(Song s: songList) {
						if(s.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
							searchResults.add(s); 
						}
					} 
					
					System.out.println("Found " + searchResults.size()+ " matches");
					System.out.println(DIVIDER);
					
					for(Song s:searchResults) {
						System.out.println(s);
					}
					
					break;
					
				case("a"): //prints number of songs, albums, and artists and prints total play time if the user inputs an "a"
					System.out.println("Catalog Analysis...");
				
					ArrayList<String> albumList=new ArrayList<String>();
					ArrayList<String> artistList=new ArrayList<String>();
					
					int playTime=0;
					for(Song s:songList) {
						if(!albumList.contains(s.getAlbum())){
							albumList.add(s.getAlbum());}
						if(!artistList.contains(s.getArtist())){
							artistList.add(s.getArtist());
						}playTime+=s.getPlayTime();
	
					}
		
					System.out.println("	Number of Artists: " + artistList.size());
					System.out.println("	Number of Albums: "+ albumList.size());
					System.out.println("	Number of Songs: " + songList.size());
					System.out.println("	Catalog Playtime: " + playTime);
					
					albumList.clear();
					artistList.clear();
					break;
					
				case("p"):	//displays the entire catalog if the user inputs a "p"
					System.out.println("Song list contains " + songList.size() +" songs...");
					System.out.println(DIVIDER);
	
					for(Song s:songList) {
						System.out.println(s.toString());
					} 
					
					break;
					
				case("q"): //quits the tool if the user inputs a "q"
					System.out.println("Goodbye!");
				
					break;
					
				case("m"): //prints the main menu if the user inputs a "m"
					System.out.println();
					System.out.println(BORDER);
					System.out.println( "*      Program Menu         *");
					System.out.println(BORDER);
					System.out.println("(L)oad catalog");
					System.out.println("(S)earch catalog");
					System.out.println("(A)nalyze catalog");
					System.out.println("(P)rint catalog");
					System.out.println("(Q)uit\n");
					
					break;
					
				default: // prints if the user inputs an invalid menu item
					System.out.println("Invalid selection!");
				}
	
			}

		keyboardScan.close();
	}

}





