package eksamen2011;

public class FootballMatch extends MatchResult {

	public FootballMatch(String homeName, String awayName) {
		super(homeName, awayName);
	}
	
	public void addHomeGoal() {
		addPoints(getParticipant1(), 1);
		}
	
	public void addAwayGoal() {
		addPoints(getParticipant2(), 2);
	}
}
