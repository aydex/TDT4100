package oving5;

public class Card {
	
	private int face;
	private char suit;
	
	Card(char suit, int face) {
		face += 1;
		if (suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C') {
			this.suit = suit;
		} else {
			throw new IllegalArgumentException("Not a valid card suit");
		}
		if (face <= 13 && face > 0) {
			this.face = face;
		} else {
			throw new IllegalArgumentException("Not a valid face");
		}
	}
	
	public int getFace() {
		return this.face;
	}
	
	public char getSuit() {
		return this.suit;
	}
	
	public String toString() {
		return String.valueOf(this.suit) + String.valueOf(this.face);
	}
}
