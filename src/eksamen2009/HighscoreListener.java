package eksamen2009;

public interface HighscoreListener {
	public void gameResultAdded(Highscores highscores, GameResult newScore, int position);
	public void gameResultRemoved(Highscores highscores, GameResult gameResult);
}
