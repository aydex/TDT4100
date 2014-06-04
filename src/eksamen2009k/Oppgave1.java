package eksamen2009k;

import junit.framework.TestCase;

public class Oppgave1 extends TestCase{
	
	public boolean isPalindrome(String s, boolean ignoreCase) {
		String reversed = ""; 
		for (int i = s.length()-1; i >=0; i--) {
			reversed += s.charAt(i);
		}
		return (ignoreCase) ? reversed.equalsIgnoreCase(s.toLowerCase()) : reversed.equals(s);
	}
	
	public double average(int[][] array2d, int x, int y, int dx, int dy) {
		double sum = 0.0;
		int count = 0;
		
		while(x >= 0 && x < array2d[y].length && y >= 0 && y < array2d.length) {
			sum+=array2d[y][x];
			x += dx;
			y += dy;
			count++;
		}
		return sum/count;
	}
	
	public static void main(String[] args) {
		Oppgave1 oppg1 = new Oppgave1();
		assertTrue(oppg1.isPalindrome("ada", false));
		assertFalse(oppg1.isPalindrome("Ada", false));
		assertTrue(oppg1.isPalindrome("racecar", false));
		assertFalse(oppg1.isPalindrome("racerar", false));
		
		assertTrue(oppg1.isPalindrome("Agnes i senga", true));
		assertFalse(oppg1.isPalindrome("Agnes i senga", false));
		
		
	}
	
}
