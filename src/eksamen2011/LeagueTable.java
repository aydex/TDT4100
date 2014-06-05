package eksamen2011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public abstract class LeagueTable implements Iterable<LeagueTableRow> {

	private final Set<String> teams;
	private ArrayList<LeagueTableRow> leagueTable = new ArrayList<LeagueTableRow>();
	private ArrayList<MatchResult> matches = new ArrayList<MatchResult>();
	
	public LeagueTable(Set<String> teams) {
		this.teams = teams;
		for (String team : this.teams) {
			leagueTable.add(new LeagueTableRow(team));
		}
		
	}
	
	private LeagueTableRow findEntry(String participant) {
		for (LeagueTableRow entry : leagueTable) {
			if (entry.getParticipant().equals(participant)) {
				return entry;
			}
		}
		return null;
	}
	
	private void updateTable() {
		Collections.sort(leagueTable);
	}
	
	private void addPoints(MatchResult matchResult, String participant) {
		findEntry(participant).addPoints(getParticipantPoints(matchResult, participant));
	}
	
	public void addMatchResult(MatchResult matchResult) {
		if (teams.contains(matchResult.getParticipant1()) && teams.contains(matchResult.getParticipant2()) && !matches.contains(matchResult)) {
			matches.add(matchResult);
			addPoints(matchResult, matchResult.getParticipant1());
			addPoints(matchResult, matchResult.getParticipant2());
			updateTable();
		} else {
			throw new IllegalArgumentException("Both teams must be part of the league");
		}
	}
	
	public int getParticipantPoints(MatchResult matchResult, String participant) {
		if (matchResult.isParticipant(participant)) {
			return matchResult.getPoints(participant);
		} else {
			throw new IllegalArgumentException("Participant " + participant + " not in match");
		}
	}

	@Override
	public Iterator<LeagueTableRow> iterator() {
		return leagueTable.iterator();
	}
}
