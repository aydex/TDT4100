package eksamen2011;

import java.util.Comparator;

public class LeagueTableComparator implements Comparator<LeagueTableRow>{

	@Override
	public int compare(LeagueTableRow o1, LeagueTableRow o2) {
		return o1.compareTo(o2);
	}

}
