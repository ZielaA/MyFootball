package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import HTMLParser.HtmlScoreReader;

public class League {

	private String leguaName;
	private IRepository<Club, String> clubsRepo;
	private HtmlScoreReader scoreReader;
	private String url;
	
	public League(String leagueName, String url)
	{
		this.leguaName = leagueName;
		clubsRepo = new ClubsRepository(new TextIOoperator<Club>());
		try {
			clubsRepo.load(leguaName + ".txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		scoreReader = new HtmlScoreReader(url);
		this.url = url;
		setScoreReaderForMatches();
		
//		for(Club c: getAllClubs())
//		{
//			MatchManager.getInstance().getScoresForPastMatches(c.getMatches());
//		}
		
		initializePastMatches();
		
		
		for(Club c: getAllClubs())
		{
			c.calculateStatsFromMatches();
		}
		
	}
	
	private void initializePastMatches()
	{
		for(Club c: getAllClubs())
		{
			for(Match m: c.getMatches())
			{
				
					HtmlScoreReader sr = new HtmlScoreReader(url); // CZEMU DZIA£A TYLKO GDY OBIEKT JEST TWORZONY LOKALNIE TO NIE MAM POJECIA!!!!!!!!!! 
					if(m.getScore() == null && m.getMatchTime().before(new GregorianCalendar()))
					{
						m.setScore(sr.getScore(m));
					}
				
			}
		}
	}
	
	public String getLeagueName()
	{
		return leguaName;
	}
	
	public String showLeagueTable()
	{
		String s = "";
		
		for(Club c: clubsRepo.getAll())
		{
			s += c.toString() + "\n";
		}
		System.out.println(clubsRepo.getAll().size());
		
		return s;
	}
	
	public AbstractList<Club> getAllClubs()
	{
		return clubsRepo.getAll();
	}
	
	public void save()
	{
		try {
			clubsRepo.save(leguaName + ".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HtmlScoreReader getScoreReader()
	{
		return scoreReader;
	}
	
	private void setScoreReaderForMatches()
	{
		
		for(Club c: clubsRepo.getAll())
		{
			for(Match m: c.getMatches())
			{
				if(m.getScoreReader() == null)
				{
					m.setScoreReader(this.scoreReader);
				}
			}
		}
	}
	
	public void sort()
	{
		Collections.sort(clubsRepo.getAll());
	}
	
	public void sort(Comparator<Club> c)
	{
		Collections.sort(clubsRepo.getAll(), c);
	}
}
