package MyFootball;

import java.io.Serializable;

public class Score implements Serializable
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

	@Override
	public String toString() {
		return homeGoals + ":" + awayGoals;
	}
}
