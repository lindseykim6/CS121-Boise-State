import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * CS 121 Project 1: Play List
 *
 * Creates an ordered play list of three songs based on user input and provides a couple statistics about these songs.
 *
 * @author Lindsey Kim
 */



public class PlayList {

	public static void main(String[] args) {
		
		
		//Prompts the user for song one information
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter title: ");
		String title=scan.nextLine();

		System.out.print("Enter artist: ");
		String artist=scan.nextLine();

		System.out.print("Enter album: ");
		String album=scan.nextLine();

		//Converts play time for song one to an integer representing the total number of seconds 
		System.out.print("Enter play time (mm:ss) : ");
		String playTime=scan.nextLine();
		
		int minutes=Integer.parseInt(playTime.substring(0,playTime.indexOf(':')));//minutes as an integer
		int seconds=Integer.parseInt(playTime.substring(playTime.indexOf(':')+1, playTime.length()));//seconds as an integer

		int totalSeconds=minutes*60+seconds;
		
		//Instantiates a new Song object
		Song songOne=new Song(title, artist, album, totalSeconds);
		
		//Prompts the user for song two information
		System.out.print("Enter title: ");
		title=scan.nextLine();

		System.out.print("Enter artist: ");
		artist=scan.nextLine();

		System.out.print("Enter album: ");
		album=scan.nextLine();
		
		System.out.print("Enter play time (mm:ss) : ");
		playTime=scan.nextLine();
		
		///Converts play time for song two to an integer representing the total number of seconds 
		minutes=Integer.parseInt(playTime.substring(0,playTime.indexOf(':')));//minutes as an integer
		seconds=Integer.parseInt(playTime.substring(playTime.indexOf(':')+1, playTime.length()));//seconds as an integer

		totalSeconds=minutes*60+seconds;
		
		//Instantiates second Song object
		Song songTwo=new Song(title, artist, album, totalSeconds);

		//Prompts the user for song three information
		System.out.print("Enter title: ");
		title=scan.nextLine();

		System.out.print("Enter artist: ");
		artist=scan.nextLine();

		System.out.print("Enter album: ");
		album=scan.nextLine();

		System.out.print("Enter play time (mm:ss) : ");
		playTime=scan.nextLine();

		///Converts play time for song three to an integer representing the total number of seconds 
		minutes=Integer.parseInt(playTime.substring(0,playTime.indexOf(':')));//minutes as an integer
		seconds=Integer.parseInt(playTime.substring(playTime.indexOf(':')+1, playTime.length()));//seconds as an integer

		totalSeconds=minutes*60+seconds;

		//Instantiates second Song object
		Song songThree=new Song(title, artist, album, totalSeconds);
		System.out.println();
		
		//Calculates average playTime
		double averagePlayTime=(songOne.getPlayTime()+songTwo.getPlayTime()+songThree.getPlayTime())/3.0;
		DecimalFormat fmt=new DecimalFormat("0.##");
		System.out.println("Average play time: " + fmt.format(averagePlayTime));
		
		//Calculates play time closest to 4 minutes
		
		final int FOUR_MINUTES=240;
		int songOneDifference=Math.abs(songOne.getPlayTime()-FOUR_MINUTES);
		int songTwoDifference=Math.abs(songTwo.getPlayTime()-FOUR_MINUTES);
		int songThreeDifference=Math.abs(songThree.getPlayTime()-FOUR_MINUTES);

		
		int min=Math.min(songOneDifference, Math.min(songTwoDifference, songThreeDifference));
		
		String closestTime;
		if (min==songOneDifference) {
			closestTime=songOne.getTitle();
		} else if(min==songTwoDifference) {
			closestTime=songTwo.getTitle();
		} else {
			closestTime=songThree.getTitle();
		}
		
		System.out.println("Song with play time closest to 240 secs is: " + closestTime);
		
		//Sorted Playlist
		if (songOne.getPlayTime()<=songTwo.getPlayTime()&&songOne.getPlayTime()<=songThree.getPlayTime()) {
			if (songTwo.getPlayTime()<=songThree.getPlayTime()) {
				System.out.println(songOne);
				System.out.println(songTwo);
				System.out.println(songThree);
			} else {
				System.out.println(songOne);
				System.out.println(songThree);
				System.out.println(songTwo);
			}
		} else if(songTwo.getPlayTime()<=songOne.getPlayTime()&&songTwo.getPlayTime()<=songThree.getPlayTime()) {
			if (songOne.getPlayTime()<=songThree.getPlayTime()) {
				System.out.println(songTwo);
				System.out.println(songOne);
				System.out.println(songThree);
			} else {
				System.out.println(songTwo);
				System.out.println(songThree);
				System.out.println(songOne);
			}
		} else {
			if(songOne.getPlayTime()<=songTwo.getPlayTime()) {
				System.out.println(songThree);
				System.out.println(songOne);
				System.out.println(songTwo);
			} else {
				System.out.println(songThree);
				System.out.println(songTwo);
				System.out.println(songOne);
			}
		}
		
		scan.close();
	}
			
			
}
