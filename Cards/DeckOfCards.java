import java.util.Random;

public class DeckOfCards implements DeckOfCardsInterface {
	private final int DECKSIZE=52;
	
	private Card[] cards;
	
	private int nextCardIndex;
	
	public DeckOfCards(){
		cards=new Card[DECKSIZE];
		
		int i=0;
		for (Suit s: Suit.values()) {
			for (Rank r: Rank.values()) {
				cards[i]=new Card(s,r);
				i++;
			}
		}
	}
	
	@Override
	public void shuffle() {
		Random rand=new Random();
		for (int i=0; i<DECKSIZE; i++) {
			int j=rand.nextInt(DECKSIZE);
			Card temp=cards[i];
			cards[i]=cards[j];
			cards[j]=temp;
		}
		nextCardIndex=0;

	}

	@Override
	public Card draw() {
		if (nextCardIndex==DECKSIZE) {
			return null;
		} else {
			Card drawn= cards[nextCardIndex];
			nextCardIndex++;
			return drawn;
		}
	}

	@Override
	public int numCardsRemaining() {
		return DECKSIZE-nextCardIndex;
	}

	@Override
	public int numCardsDealt() {
		return nextCardIndex;
	}

	@Override
	public Card[] dealtCards() {
		Card[] dealt=new Card[numCardsDealt()];
		for(int i=0; i<nextCardIndex;i++) {
			dealt[i]=cards[i];
		}
		return dealt;
	}

	@Override
	public Card[] remainingCards() {
		Card[] remaining=new Card[numCardsRemaining()];
		for(int i=0; i<remaining.length; i++) {
			remaining[i] = cards[nextCardIndex+i];
		}
		return remaining;
	}
	
	public String toString() {
		String output = "";
		for (Card c : cards) {
			output+= (c +"\n");
		}
		return output;
	}

}
