package MyFootball;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Match {
	
	private String homeName;
	private String awayName;
	private GregorianCalendar matchTime;
	private long id;
	private static long nextId = 1;
	private Score score;
	
	public Match(String homeName, String awayName, GregorianCalendar matchTime)
	{
		score = null;
		this.homeName = homeName;
		this.awayName = awayName;
		this.matchTime = matchTime;
		this.id = nextId;
		nextId++;
	}
	
	public String getHomeName()
	{
		return homeName;
	}
	
	public String getAwayName()
	{
		return awayName;
	}
	
	public long getId()
	{
		return id;
	}
	
	public GregorianCalendar getMatchTime()
	{
		return matchTime;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		if(score == null) score = new Score();
		this.score = score;
	}
	
	public void setScore(int homeGoals, int awayGoals) {
		if(score == null) score = new Score();
		this.score.setHomeGoals(homeGoals);
		this.score.setAwayGoals(awayGoals);
	}
	
	public String info()
	{
		String s = new String();
		s += homeName + " ";
		if(score == null)
		{
			s += "- : - ";
		}
		else
		{
			s += score.getHomeGoals() + " : " + score.getAwayGoals();
		}
		s += awayName;
		s +=  "		" + matchTime.get(Calendar.DAY_OF_MONTH) + "/" + (matchTime.get(Calendar.MONTH) + 1) + 
				"/" + matchTime.get(Calendar.YEAR) + " " + matchTime.get(Calendar.HOUR_OF_DAY) + ":";
		if(matchTime.get(Calendar.MINUTE) < 10)
		{
			s += "0";
		}
		s +=  matchTime.get(Calendar.MINUTE) + ":";
		if(matchTime.get(Calendar.SECOND) < 10)
		{
			s += "0";
		}
		s += matchTime.get(Calendar.SECOND);
		return s;
	}
	
	

}
