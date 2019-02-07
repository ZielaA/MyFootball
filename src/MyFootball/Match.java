package MyFootball;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.management.timer.TimerMBean;

public class Match {
	
	private String homeName;
	private String awayName;
	private GregorianCalendar matchTime;
	private long id;
	private static long nextId = 1;
	private Score score;
	private Timer timer;
	
	public Match(String homeName, String awayName, GregorianCalendar matchTime)
	{
		this.homeName = homeName;
		this.awayName = awayName;
		this.matchTime = matchTime;
		this.id = nextId;
		nextId++;
		setTimer();
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
	
	public void setScore(Score score)
	{
		this.score = score;
	}
	
	public String info()
	{
		String s = new String();
		s += "Id number: " + id + "		" + homeName + " ";
		if(score == null)
		{
			s += "- : - ";
		}
		else
		{
			s += score.getHomeGoals() + " : " + score.getAwayGoals();
		}
		s += " " + awayName;
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
	
	private long calculateDateToMiliseconds(GregorianCalendar time)
	{
		return matchTime.getTimeInMillis() - new GregorianCalendar().getTimeInMillis();
	}
	
	private void setTimer()
	{
		if(new GregorianCalendar().before(matchTime))
		{
			timer = new Timer();
			timer.schedule(new TimerTask(){
				public void run()
				{
					MatchManager.getInstance().startMatch(id);
				}
			}, calculateDateToMiliseconds(matchTime));
		}
	}
}
