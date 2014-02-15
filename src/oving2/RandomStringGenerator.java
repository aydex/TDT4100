package oving2;

import java.util.Random;

public class RandomStringGenerator {
	
	public Random random = new Random();
	
	public String getRandomString() {
		int length = this.random.nextInt(10);			
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);
	}
}