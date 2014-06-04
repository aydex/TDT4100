package eksamen2012k;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WordList implements Words {
	
	private List<String> wordList = new ArrayList<String>();

	public boolean containsWord(String word) {
		return wordList.contains(word);
	}
	
	public Collection<String> getWordsStartingWith(String prefix) {
		List<String> wordsStartingWith = new ArrayList<String>();
		for (String s : wordList) {
			if (s.startsWith(prefix)) {
				wordsStartingWith.add(s);
			}
		}
		return wordsStartingWith;
	}
	
	public boolean addWord(String word) {
		word = word.trim();
		return (word.length() > 0 && !containsWord(word)) ? wordList.add(word) : false;
	}
	
	public boolean removeWord(String word) {
		return wordList.remove(word);
	}
	
	public boolean removeWordsStartingWith(String prefix) {
		return wordList.removeAll(getWordsStartingWith(prefix));
	}
	
	public String getPrefix(String word, String suffix) {
		return (word.endsWith(suffix) ? word.substring(0, word.length() - suffix.length()) : null);
	}
	
	public boolean hasSuffixes(String prefix, List<String> suffixes) {
		for (String suffix : suffixes) {
			if (!wordList.contains(prefix + suffix)) {
				return false;
			}
		}
		return true;
	}
	
	public List<String> findPrefixes(List<String> suffixes) {
		List<String> prefixes = new ArrayList<String>();
		for (String word : wordList) {
			String prefix = getPrefix(word, suffixes.get(0));
			if (prefix != null && hasSuffixes(prefix, suffixes)) {
				prefixes.add(prefix);
			}
		}
		return prefixes;
	}
	
	public void read(InputStream input) {
		
	}
	
	public static void main(String[] args) {
		WordList wordList1 = new WordList();
		Words wordList2 = new WordList();
		System.out.println(wordList2 instanceof WordList);
	}
}
