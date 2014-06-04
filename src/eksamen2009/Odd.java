package eksamen2009;

public class Odd implements HighscoreListener {

	@Override
	public void gameResultAdded(Highscores highscores, GameResult newScore, int position) {
		System.out.println(newScore + " added to " + highscores + " at position " + position);
	}

	@Override
	public void gameResultRemoved(Highscores highscores, GameResult gameResult) {
		System.out.println(gameResult + "removed from " + highscores);
	}
	
	

}
