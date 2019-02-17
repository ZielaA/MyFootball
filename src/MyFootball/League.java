package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;

public class League {

	private String leguaName;
	private IRepository<Club, String> clubsRepo;
	public League(String leagueName)
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
}
