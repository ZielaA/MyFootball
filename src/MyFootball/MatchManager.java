package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import HTMLParser.HtmlScoreReader;

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
		
		determinMatchesRound();
		getScoresForPastMatches();
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
		if(getAllMatches().size() == 0) return 0;
		else return getAllMatches().get(getAllMatches().size()-1).getId();
	}
	
	public void removeMatch(long id)
	{
		matches.remove(id);
	}
	
	public Match getMatch(long id)
	{
		return matches.get(id);
	}
	
	private void determinMatchesRound()
	{
		
		LinkedList<String> doneClubs = new LinkedList<String>();
		for(Match m: getAllMatches())
		{
			String club = m.getHomeName();
			if(!doneClubs.contains(club))
			{
				doneClubs.add(club);
				AbstractList<Match> mm = getMatchesForClub(club);
				Collections.sort(mm);
				for(int i=0; i<mm.size(); i++)
				{
					mm.get(i).setRoundNumber(i+1);
				}
			}
			
		}
	}
	
	private void getScoresForPastMatches()
	{
		
		for(Match m: getAllMatches())
		{
			HtmlScoreReader sr = new HtmlScoreReader("http://www.sport.pl/pilka/2,116928,,,,178633894,P_SPORT_SLOWNIK.html#wyniki");
			if(m.getScore() == null && m.getMatchTime().before(new GregorianCalendar()))
			{
				m.setScore(sr.getScore(m));
			}
		}
	}
	
	
}
