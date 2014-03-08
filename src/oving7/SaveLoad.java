package oving7;

public interface SaveLoad {
	public void saveGame(String save);
	public void saveGame(String save, String filename);
	public String loadGame();
	public String loadGame(String filename);
}
