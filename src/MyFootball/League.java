package MyFootball;

public class League {

	private String leguaName;
	private IRepository<Club, String> clubsRepo;
	public League(String leagueName)
	{
		this.leguaName = leagueName;
		clubsRepo = new ClubsRepository();
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
	
}
