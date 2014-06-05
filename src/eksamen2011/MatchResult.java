package eksamen2011;

public abstract class MatchResult {
	
	private final String participant1, participant2;
	private int[] score = new int[2];
	
	public MatchResult(String participant1, String participant2) {
		this.participant1 = participant1;
		this.participant2 = participant2;
	}
	
	public boolean isWinner(String participant) {
		if (isDraw()) {
			return false;
		}
		if (score[0] > score[1] && participant1.equals(participant)) {
			return true;
		} else if (score[0] < score[1] && participant2.equals(participant)){
			return true;
		}
		return false;
	}
	
	public int getScore(String participant) {
		if (participant1.equals(participant)) {
			return score[0];
		} else if (participant2.equals(participant)) {
			return score[1];
		} else {
			return -1;			
		}
	}
	
	protected void addPoints(String participant, int points) {
		if (participant.equals(participant1)) {
			score[0]+=points;
		} else if (participant.equals(participant2)) {
			score[1] += points;
		}
	}
	
	public int getPoints(String participant) {
		return isDraw() ? 1 : isWinner(participant) ? 3 : 0;
	}
	
	public boolean isParticipant(String participant) {
		return (participant1.equals(participant) || participant2.equals(participant));
	}
	
	public boolean isDraw() {
		return score[0] == score[1];
	}
	
	public void setScore(int[] score) {
		this.score = score;
	}
	
	public String toString() {
		return participant1 + " - " + participant2 + " : " + score[0] + " - " + score[1];
	}

	public String getParticipant1() {
		return participant1;
	}

	public String getParticipant2() {
		return participant2;
	}

	public int[] getScore() {
		return score;
	}
}
