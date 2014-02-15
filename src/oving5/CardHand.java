package oving5;

import java.util.ArrayList;

public class CardHand {
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public int getCardCount() {
		return hand.size();
	}
	
	public Card getCard(int i) {
		if (i < getCardCount()) {
			return hand.get(i);
		} else {
			throw new IllegalArgumentException("Not a valid card");
		}
	}
	
	public void addCard(Card c) {
		hand.add(c);
	}
	
	public Card play(int n) {
		return hand.remove(n);
	}
}
