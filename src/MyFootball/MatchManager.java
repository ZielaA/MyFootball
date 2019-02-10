package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.LinkedList;

public class MatchManager {

	private IRepository<Match, Long> matches;
	private static MatchManager instance = null;
	
	private MatchManager()
	{
		matches = new MatchesRepository(new BinaryIOoperator<AbstractList<Match>>());
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
	
	public void loadMatches() throws FileNotFoundException, IOException, ClassNotFoundException
	{
			if(matches != null)
			{
				matches.load("matches.bin");	
			}
	}
	
	public void saveMatches() throws FileNotFoundException, IOException
	{
			if(matches != null)
			{
				matches.save("matches.bin");	
			}
	}
	
	
	public AbstractList<Match> getAllMatches()
	{
		if(matches != null)
		{
			return matches.getAll();
		}
		else return null;
	}
	
}
