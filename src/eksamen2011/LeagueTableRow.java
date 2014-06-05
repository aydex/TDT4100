package eksamen2011;

public class LeagueTableRow implements Comparable<LeagueTableRow>{
	
	private final String participant;
	private int points = 0;
	
	public LeagueTableRow(String participant) {
		this.participant = participant;
	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public String getParticipant() {
		return participant;
	}

	@Override
	public int compareTo(LeagueTableRow o) {
		return o.points - points;
	}
	
	
}
