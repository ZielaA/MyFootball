package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;

import HTMLParser.HtmlScoreReader;

public class League {

	private String leguaName;
	private IRepository<Club, String> clubsRepo;
	private HtmlScoreReader scoreReader;
	
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
				if(m.getScoreReader() != null)
				{
					m.setScoreReader(this.scoreReader);
				}
			}
		}
	}
}
