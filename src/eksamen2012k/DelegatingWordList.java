package eksamen2012k;

import java.util.ArrayList;
import java.util.Collection;

public class DelegatingWordList implements Words {
	
	private Words words1, words2;
	
	public DelegatingWordList(Words words1, Words words2) {
		this.words1 = words1;
		this.words2 = words2;
	}

	@Override
	public boolean containsWord(String word) {
		return words1.containsWord(word) || words2.containsWord(word);
	}

	@Override
	public Collection<String> getWordsStartingWith(String word) {
		Collection<String> wordsStartingWith = new ArrayList<String>();
		wordsStartingWith.addAll(words1.getWordsStartingWith(word));
		wordsStartingWith.addAll(words2.getWordsStartingWith(word));
		return wordsStartingWith;
	}

	@Override
	public boolean addWord(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeWord(String word) {
		// TODO Auto-generated method stub
		return false;
	}

}
