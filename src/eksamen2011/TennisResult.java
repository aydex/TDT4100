package eksamen2011;

public class TennisResult extends MatchResult {

	public TennisResult(String participant1, String participant2) {
		super(participant1, participant2);
	}

	@Override
	public boolean isWinner(String participant) {
		// TODO Auto-generated method stub
		return super.isWinner(participant);
	}

	@Override
	public void addPoints(String participant, int points) {
		// TODO Auto-generated method stub
		super.addPoints(participant, points);
	}

	@Override
	public void setScore(int[] score) {
		// TODO Auto-generated method stub
		super.setScore(score);
	}
	
	

}
