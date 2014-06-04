package eksamen2010;

public class MorseAlphabet extends RadioAlphabet {
	
	private static final String morseAlphabet = "s...,o---,t-,e.";
	private static final String delimiter = ",";

	public MorseAlphabet() {
		super(morseAlphabet, delimiter);
	}
	
	public String convert(char c) {
		String returnString = super.convert(c);
		return returnString != null ? returnString.substring(1) : null;	
	}

	public void setWord(char c, String word) {
		super.setWord(c + word);
	}
}
