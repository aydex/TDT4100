package eksamen2009;

import junit.framework.TestCase;

public class Oppgave1 extends TestCase {
	
	public String removeVowels(String text) {
//		text.replaceAll("[AEIOUYaeiou", "");
		for(char c : text.toCharArray()) {
			if ("AEIOUYaeiouy".contains("" + c)) {
				if (text.indexOf(c) == text.length()-1) {
					text = text.substring(0, text.indexOf(c));
				} else {
					text = text.substring(0, text.indexOf(c)) + text.substring(text.indexOf(c)+1);					
				}
			}
		}
		return text;
	}
	
	public void testRemoveVowels() {
		assertEquals("Jv", removeVowels("Java"));
		assertEquals("bjktrntrt prgrmmrng", removeVowels("Objektorientert programmering"));
		String angstskrik = "ngstrskrk";
		assertTrue(angstskrik == removeVowels(angstskrik));
		String emptyString = "";
		assertTrue(emptyString == removeVowels(emptyString));
	}
	
	public int findSequence(char[] cArray, int pos) {
		char c = cArray[pos];
		pos++;
		for (int retVal = 0; pos < cArray.length; pos++, retVal++) {
			if (cArray[pos] == c) {
				return retVal;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Oppgave1 oppg1 = new Oppgave1();
		System.out.println(oppg1.removeVowels("Java"));
		oppg1.testRemoveVowels();
		char[] charArray = new char[] {'x','x','o','o','x','o'};
		System.out.println(oppg1.findSequence(charArray, 0));
		System.out.println(oppg1.findSequence(charArray, 1));
		System.out.println(oppg1.findSequence(charArray, 2));
		System.out.println(oppg1.findSequence(charArray, 3));
		System.out.println(oppg1.findSequence(charArray, 4));
		System.out.println(oppg1.findSequence(charArray, 5));
	}	
}

