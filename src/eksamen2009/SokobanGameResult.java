package eksamen2009;

public class SokobanGameResult extends SinglePlayerGameResult {
	
	private String sokobanLevelString;
	private int moves, pushes;
	
	
	public SokobanGameResult(String player, String sokobanLevelString,
			int moves, int pushes) {
		super(player);
		this.sokobanLevelString = sokobanLevelString;
		this.moves = moves;
		this.pushes = pushes;
	}

	public String getGameString() {
		return sokobanLevelString + " " + super.getGameString();
	}
	
	public String getResultString() {
		return moves + " moves/" + pushes + " pushes";
	}
	
	@Override
	public int compareTo(GameResult o) {
		if (! (o instanceof SokobanGameResult)) {
			throw new ClassCastException("Cannot compare " + o + " to " + this);
		}
		SokobanGameResult other = (SokobanGameResult)o;
		int diff = (moves + pushes) - (other.moves + other.pushes);
		if (diff == 0) {
			diff = pushes - other.pushes;
		}
		return diff;
	}
}
