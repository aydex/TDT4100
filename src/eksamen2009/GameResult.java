package eksamen2009;

public interface GameResult extends Comparable<GameResult> {
	public int score = 0;
	public String getGameString();
	public String getResultString();
}
