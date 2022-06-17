

public class WarGames {

	public static void main(String[] args) {
		int rounds;
		try {
			if (args.length!=1) {
				System.out.println("Invalid number of arguments!");
				return;
			} else {
				rounds=Integer.parseInt(args[0]);
				if(rounds<1) {
					System.out.println("Invalid number of rounds!");
					return;
				}
				
			}
		
		} catch (NumberFormatException e) {
			System.out.println("Invalid number of rounds!");
			return;
		}
		
		DeckOfCards deck=new DeckOfCards();
		deck.shuffle();
		
		for(int i=0; i< rounds; i++) {
			System.out.println("Round "+ i+ "...");
			Card card1=deck.draw();
			Card card2=deck.draw();
			
			if (card1.compareTo(card2)>0) {
				System.out.println("Player 1 wins!");
			} else if(card1.compareTo(card2)<0) {
				System.out.println("Player 2 wins!");
			} else {
				System.out.println("Tie!!");
			}
			
		}

	}

}
