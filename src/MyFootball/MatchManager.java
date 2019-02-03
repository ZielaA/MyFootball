package MyFootball;

import java.util.LinkedList;

public class MatchManager {

	private MatchesRepository matches;
	private static MatchManager instance = null;
	
	private MatchManager()
	{
		matches = new MatchesRepository();
		matches.load("");
		
	}
	
	public static MatchManager getInstance()
	{
		if(instance == null)
		{
			instance = new MatchManager();
		}
		return instance;
	}
	
	public LinkedList<Match> getMatchesForClub(String clubName)
	{
		LinkedList<Match> l = new LinkedList<Match>();
		
		for(Match m: matches.getAll())
		{
			if(m.getHomeName() == clubName || m.getAwayName() == clubName)
			{
				l.add(m);
			}
		}
		return l;
	}
}
