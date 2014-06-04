package eksamen2009;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Highscores {
		
	private List<GameResult> gameResults = new ArrayList<GameResult>();
	private List<HighscoreListener> highscoreListeners = new ArrayList<HighscoreListener>();
	
	public void addListener(HighscoreListener highscoreListener) {
		highscoreListeners.add(highscoreListener);
	}
	
	public void removeListener(HighscoreListener highscoreListener) {
		highscoreListeners.remove(highscoreListener);
	}
	
	public void addGameResult(GameResult gameResult) {
		int position = 0;
		while (position < gameResults.size()) {
			if (gameResult.compareTo(gameResults.get(position)) < 0) {
				break;
			}
			position++;
		}
		gameResults.add(position, gameResult);
		
		for (HighscoreListener highscoreListener : highscoreListeners) {
			highscoreListener.gameResultAdded(this, gameResult, position);			
		}
	}
	
	public void removeGameResult(GameResult gameResult) {
		gameResults.remove(gameResult);
		
		for (HighscoreListener highscoreListener : highscoreListeners) {
			highscoreListener.gameResultRemoved(this, gameResult);
		}
	}
	
	public void print(PrintWriter writer) {
		for (GameResult gameResult : gameResults) {
			writer.printf("%s for %s\n", gameResult.getResultString(), gameResult.getGameString());
		}
		writer.flush();
	}
	

}
