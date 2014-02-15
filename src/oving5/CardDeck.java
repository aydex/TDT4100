package oving5;

import java.util.ArrayList;

public class CardDeck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	CardDeck(int n) {
		for (int i = 0; i < n; i++) {
			deck.add(new Card('S', i));
		}
		for (int i = 0; i < n; i++) {
			deck.add(new Card('H', i));
		}
		for (int i = 0; i < n; i++) {
			deck.add(new Card('D', i));
		}
		for (int i = 0; i < n; i++) {
			deck.add(new Card('C', i));
		}
	}
	
	public int getCardCount() {
		return this.deck.size();
	}
	
	public Card getCard(int n) {
		if(n < getCardCount()) {
			return deck.get(n);			
		} else {
			throw new IllegalArgumentException("Not a valid card");
		}
	}
	
	public void deal(CardHand ch, int n) {
		for (int i = 0; i < n; i++) {
			ch.addCard(deck.remove(getCardCount()-1));
		}
	}
	
	public void shufflePerfectly() {
		ArrayList<Card> part1 = new ArrayList<Card>();
		part1.addAll(this.deck.subList(0, getCardCount()/2));
		ArrayList<Card> part2 = new ArrayList<Card>();
		part2.addAll(this.deck.subList(getCardCount()/2, getCardCount()));
		deck.clear();
		for (int i = 0; i < part1.size(); i++) {
			deck.add(part1.get(i));
			deck.add(part2.get(i));
		}
	}
	
	public static void main(String[] args) {
		CardDeck cd = new CardDeck(2);
		for (int i = 0; i < cd.getCardCount(); i++) {
			System.out.println(cd.getCard(i));
		}
		System.out.println("_");
		cd.shufflePerfectly();
		System.out.println("_");
		for (int i = 0; i < cd.getCardCount(); i++) {
			System.out.println(cd.getCard(i));
		}
	}
}
