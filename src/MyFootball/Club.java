package MyFootball;

public class Club {

	private String name;
	private FootballersRepository footballers;
	private int points;
	private int wins;
	private int draws;
	private int defeats;
	private int scoredGoals;
	private int lostGoals;
	private int goalDifference;
	
	//Constructor
	public Club(String name)
	{
		this.name = name;
		footballers = new FootballersRepository();
		footballers.load("");
		points = wins * 3 + draws;
		for(Footballer f: footballers.getAll())
		{
			scoredGoals += f.getScoredGoals();
			if(f instanceof Goalkeeper)
			{
				lostGoals += ((Goalkeeper) f).getLostGoals();
			}
		}
		
		goalDifference = scoredGoals - lostGoals;
	}
	
	//getters
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

	public String getName()
	{
		return name;
	}
	
	//other methods
	public String playersStats()
	{
		String s= "";
		for(Footballer f: footballers.getAll())
		{
			s += f.info() + "\n";
		}
		return s;
	}

	
	@Override
	public String toString() {
		return "Club [name=" + name + ", points=" + points + ", wins=" + wins
				+ ", draws=" + draws + ", defeats=" + defeats
				+ ", scoredGoals=" + scoredGoals + ", lostGoals=" + lostGoals
				+ ", goalDifference=" + goalDifference + "]";
	}
	
	
	
}