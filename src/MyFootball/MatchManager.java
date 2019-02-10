package MyFootball;

import java.io.FileNotFoundException;
import java.util.AbstractList;
import java.util.LinkedList;

public class MatchManager {

	private IRepository<Match, Long> matches;
	private static MatchManager instance = null;
	
	private MatchManager()
	{
		matches = new MatchesRepository();
		try {
			matches.load("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static MatchManager getInstance()
	{
		if(instance == null)
		{
			instance = new MatchManager();
		}
		return instance;
	}
	
	public AbstractList<Match> getMatchesForClub(String clubName)
	{
		AbstractList<Match> l = new LinkedList<Match>();
		
		for(Match m: matches.getAll())
		{
			if(m.getHomeName() == clubName || m.getAwayName() == clubName)
			{
				l.add(m);
			}
		}
		return l;
	}

	public void startMatch(long id)
	{
		Match m = matches.get(id);
		setScore(m, new Score(0, 0));
		System.out.println(m.info());
	}
	
	private void setScore(Match match, Score score) 
	{
		match.setScore(score);
	}
	
}
