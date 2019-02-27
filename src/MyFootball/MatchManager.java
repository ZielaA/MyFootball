package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.LinkedList;

public class MatchManager {

	private IRepository<Match, Long> matches;
	private static MatchManager instance = new MatchManager();
	
	private MatchManager()
	{
		matches = new MatchesRepository(new BinaryIOoperator<Match>());
		try {
			loadMatches();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MatchManager getInstance()
	{
		return instance;
	}
	
	public AbstractList<Match> getMatchesForClub(String clubName)
	{
		AbstractList<Match> l = new LinkedList<Match>();
		
		for(Match m: matches.getAll())
		{
			if(m.getHomeName().equals(clubName) || m.getAwayName().equals(clubName))
			{
				l.add(m);
			}
		}
		System.out.println(getAllMatches().size());
		return l;
	}

	public void startMatch(long id)
	{
		Match m = matches.get(id);
		setScore(m, new Score(0, 0));
		//System.out.println(m.getHomeName() + "t");
		
		if(User.getInstance().isClubFavourite(m.getHomeName()) == true || 
		   User.getInstance().isClubFavourite(m.getAwayName()) == true)
		{
			User.getInstance().notify("Match started: " + m.info());
		}
	}
	
	private void setScore(Match match, Score score) 
	{
		match.setScore(score);
	}
	
	
	public void loadMatches() throws FileNotFoundException, IOException, ClassNotFoundException
	{
			if(matches != null)
			{
				matches.load("matches3.bin");	
			}
	}

	
	public void saveMatches() throws FileNotFoundException, IOException
	{
			if(matches != null)
			{
				matches.save("matches3.bin");	
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
	
	public void setMatches(IRepository<Match, Long> matches)
	{
		this.matches = matches;
	}
	
	public void addMatch(Match match)
	{
		matches.add(match);
	}
	
	public long lastId()
	{
		return getAllMatches().get(getAllMatches().size()-1).getId();
	}
	
	public void removeMatch(long id)
	{
		matches.remove(id);
	}
	
	
}
