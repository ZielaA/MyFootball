package MyFootball;

public class Score
{
	private int homeGoals;
	private int awayGoals;
	
	public Score()
	{
		homeGoals = 0;
		awayGoals = 0;
	}
	
	public Score(int homeGoals, int awayGoals)
	{
		this.homeGoals = homeGoals;
		this.awayGoals = awayGoals;
	}
	
	public int getHomeGoals()
	{
		return homeGoals;
	}
	
	public int getAwayGoals()
	{
		return awayGoals;
	}

	public void setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
	}

	public void setAwayGoals(int awayGoals) {
		this.awayGoals = awayGoals;
	}
}
