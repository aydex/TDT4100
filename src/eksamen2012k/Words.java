package eksamen2012k;

import java.util.Collection;


public interface Words {
	
	public boolean containsWord(String word);
	public Collection<String> getWordsStartingWith(String word);
	public boolean addWord(String word);
	public boolean removeWord(String word);
	
	

}
