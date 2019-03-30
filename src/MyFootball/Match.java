package MyFootball;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import HTMLParser.HtmlScoreReader;

public class Match implements Serializable, Comparable<Match>
{
	
	private String homeName;
	private String awayName;
	private GregorianCalendar matchTime;
	private long id;
	private static long nextId = 1;
	private Score score;
	transient private Timer timer;
	private int roundNumber;
	transient private HtmlScoreReader scoreReader;
	
	
	public Match(String homeName, String awayName, GregorianCalendar matchTime)
	{
		this.homeName = homeName;
		this.awayName = awayName;
		this.matchTime = matchTime;
		this.id = MatchManager.getInstance().lastId() + 1;
		setTimer();
	}
	
	public void initialize()
	{
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
	
	public int getRoundNumber()
	{
		return roundNumber;
	}
	
	public void setRoundNumber(int roundNumber)
	{
		this.roundNumber = roundNumber;
	}
	
	public String info()
	{
		String s = new String();
		s += "Kolejka " + roundNumber; 
		s += "	Id number: " + id + "		" + homeName + " ";
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
					MatchManager.getInstance().checkForMatchUpdate(id);
				}
			}, calculateDateToMiliseconds(matchTime), 6000);
			
			Timer endTimer = new Timer();
			endTimer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					timer.cancel();
					try {
						MatchManager.getInstance().saveMatches();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}, 6000 * 120);
		}
	}
	
	
	public boolean involvesClub(String clubName)
	{
		if(homeName == clubName || awayName == clubName)
		{
			return true;
		}
		else return false;
	}

	@Override
	public int compareTo(Match o) {
		if(this.matchTime.before(o.getMatchTime())) return -1;
		else if(this.matchTime.after(o.getMatchTime())) return 1;
		else return 0;
	}

	public HtmlScoreReader getScoreReader() {
		return scoreReader;
	}

	public void setScoreReader(HtmlScoreReader scoreReader) {
		this.scoreReader = scoreReader;
	}
}
