
public class Card implements Comparable<Card> {
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit=suit;
		this.rank=rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public int getValue() {
		return rank.getFaceValue();
	}
	
	@Override
	public int compareTo(Card c) {
		if (this.getValue()<c.getValue()) {
			return -1;
		} else if (this.getValue()>c.getValue()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		return rank + " of " + suit;
	}

}
