
public class CardDealer {

	public static void main(String[] args) {
		DeckOfCards deck=new DeckOfCards();
		deck.shuffle();
		System.out.println(deck);
		
		System.out.println();
		
		Card card1=deck.draw();
		Card card2=deck.draw();
		Card card3=deck.draw();
		
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		
		System.out.println();
		
		for(Card c: deck.dealtCards()) {
			System.out.println(c);
		}
		
		System.out.println();
		
		for(Card c: deck.remainingCards()) {
			System.out.println(c);
		}
	}

}
