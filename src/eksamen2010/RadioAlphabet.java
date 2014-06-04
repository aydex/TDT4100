package eksamen2010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class RadioAlphabet extends TestCase {
	
	private Map<Character, String> radioAlphabet = new HashMap<Character, String>();
	private ArrayList<RadioAlphabetListener> radioAlphabetListeners = new ArrayList<RadioAlphabetListener>();
	
	protected RadioAlphabet() {
		
	}
	
	private void notifyRadioAlphabetListeners(char c) {
		for (RadioAlphabetListener listener : radioAlphabetListeners) {
			listener.radioAlphabetChanged(this, c);
		}
	}
	
	public void addRadioAlphabetListener(RadioAlphabetListener listener) {
		radioAlphabetListeners.add(listener);
	}
	
	public void removeRadioAlphabetListener(RadioAlphabetListener listener) {
		radioAlphabetListeners.remove(listener);
	}
	
	public RadioAlphabet(String alphabet, String delimiter) {
		String[] alphabetList = alphabet.split("-");
		for (String s : alphabetList) {
			radioAlphabet.put(s.charAt(0), s);
		}
	}
	
	public boolean converts(char c) {
		return radioAlphabet.containsKey(c);
	}
	
	public String convert(char c) {
		return converts(c) ? radioAlphabet.get(c) : null;
	}
	
	public String convert(String word) {
		String convertedString = "";
		for (char c : word.toCharArray()) {
			if(converts(c)) {
				convertedString += convert(c) + " ";
			}
		}
		return convertedString.trim();
	}
	
	public void setWord(String word) {
		if (radioAlphabet.containsKey(word.charAt(0))) {
			radioAlphabet.put(word.charAt(0), word);
			notifyRadioAlphabetListeners(word.charAt(0));
		}
	}
	
	public void removeWord(char c) {
		radioAlphabet.remove(c);
		notifyRadioAlphabetListeners(c);
	}
	
	public static void main(String[] args) {
		RadioAlphabet radioAlphabet = new RadioAlphabet("alpha-bravo-charlie-delta-echo-foxtrot", "-");
		assertEquals(radioAlphabet.convert('a'), "alpha");
		assertEquals(radioAlphabet.convert("abc"), "alpha bravo charlie");
		assertEquals(radioAlphabet.convert("!a!b!c!"), "alpha bravo charlie");
		assertNull(radioAlphabet.convert('!'));
	}
}
