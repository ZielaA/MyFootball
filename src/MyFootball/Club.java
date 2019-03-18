package MyFootball;

import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractList;

public class Club implements Serializable, ITextFileOutput, Comparable<Club> {

	final private String name;
	private IRepository<Footballer, Integer> footballers;
	private int points;
	private int wins;
	private int draws;
	private int defeats;
	private int scoredGoals;
	private int lostGoals;
	private int goalDifference;
	private AbstractList<Match> matches;
	private String footballersPath;

	public Club(String name, AbstractList<Match> matches) {
		this.name = name;
		this.matches = matches;
		footballersPath = this.name + ".bin";
		footballers = new FootballersRepository(new BinaryIOoperator<Footballer>());
		try {
			footballers.load(footballersPath);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		calculateStatsFromMatches();
		goalDifference = scoredGoals - lostGoals;
		points = wins * 3 + draws;
	}

	private void calculateStatsFromMatches() {
		reset();
		for (Match m : matches) {
			if (m.getScore() != null) {

				if (m.getHomeName() == this.name) {
					scoredGoals += m.getScore().getHomeGoals();
					lostGoals += m.getScore().getAwayGoals();
					if (m.getScore().getHomeGoals() > m.getScore().getAwayGoals()) {
						wins++;
					} else if (m.getScore().getHomeGoals() == m.getScore().getAwayGoals()) {
						draws++;
					} else {
						defeats++;
					}
				} else {
					scoredGoals += m.getScore().getAwayGoals();
					lostGoals += m.getScore().getHomeGoals();
					if (m.getScore().getHomeGoals() < m.getScore().getAwayGoals()) {
						wins++;
					} else if (m.getScore().getHomeGoals() == m.getScore().getAwayGoals()) {
						draws++;
					} else {
						defeats++;
					}
				}
			}
		}
	}
	
	private void reset()
	{
		wins = 0;
		draws = 0;
		defeats = 0;
		scoredGoals = 0;
		lostGoals = 0;
		goalDifference = 0;
		points = 10;
	}
	
	// getters
	public int getPoints() {
		return points;
	}

	public int getWins() {
		return wins;
	}

	public int getDraws() {
		return draws;
	}

	public int getDefeats() {
		return defeats;
	}

	public int getScoredGoals() {
		return scoredGoals;
	}

	public int getLostGoals() {
		return lostGoals;
	}

	public int getGoalsDifference() {
		return goalDifference;
	}

	public String getName() {
		return name;
	}

	// other methods
	public String playersStats() {
		String s = "";
		for (Footballer f : footballers.getAll()) {
			s += f.info() + "\n";
		}
		return s;
	}

	@Override
	public String toString() {
		return "Club [name=" + name + ", points=" + points + ", wins=" + wins + ", draws=" + draws + ", defeats="
				+ defeats + ", scoredGoals=" + scoredGoals + ", lostGoals=" + lostGoals + ", goalDifference="
				+ goalDifference + "]";
	}

	public String matchesInfo() {
		String s = new String();
		if (matches.size() == 0)
			return "blabla";
		for (Match m : matches) {
			s += m.info() + "\n";
		}
		return s;
	}

	public String textToSaveInFile() {
		return getName();
	}

	public void saveFootballers()
	{
		try {
			footballers.save(footballersPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public AbstractList<Match> getMatches()
	{
		return matches;
	}

	@Override
	public int compareTo(Club o) {
		int res;
		res = this.points - o.points;
		if(res != 0) return res;
		else
		{
			res = this.goalDifference - o.goalDifference;
		}
		if(res != 0) return res;
		else
		{
			res = this.scoredGoals - o.scoredGoals;
		}
		if(res != 0) return res;
		else
		{
			res = this.lostGoals - o.lostGoals;
		}
		return res;
		
		
	}
	
}
