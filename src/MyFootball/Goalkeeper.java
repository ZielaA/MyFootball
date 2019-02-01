package MyFootball;

public class Goalkeeper extends Footballer {

	private int cleanSheets;
	private int lostGoals;
	
	//constructors
	public Goalkeeper(GoalkeeperBuilder goalkeeperBuilder) {
		super(goalkeeperBuilder);
		this.cleanSheets = goalkeeperBuilder.cleanSheets;
		this.lostGoals = goalkeeperBuilder.lostGoals;
		
	}
	
	//getters
	public int getCleanSheets()
	{
		return cleanSheets;
	}
	
	public int getLostGoals()
	{
		return lostGoals;
	}
	
	//other methods
	@Override
	public String info()
	{
		String s = super.info();
		s += "	Clean sheets: " + cleanSheets;
		return s;
	}
	
	@Override
	public void resetStats()
	{
		super.resetStats();
		cleanSheets = 0;
		lostGoals = 0;
	}
	
	public void addLostGoals(int lostGoalsToAdd)
	{
		lostGoals += lostGoalsToAdd;
	}
	
	public void addCleanSheet()
	{
		cleanSheets++;
	}
	
	//fluent builder inner class
	public static class GoalkeeperBuilder extends Footballer.Builder
	{
		private int cleanSheets;
		private int lostGoals;
		
		public GoalkeeperBuilder(String surname) {
			super(surname);
		}
		
		public GoalkeeperBuilder cleanSheets(final int cleanSheets)
		{
			this.cleanSheets = cleanSheets;
			return this;
		}
		
		public GoalkeeperBuilder lostGoals(final int lostGoals)
		{
			this.lostGoals = lostGoals;
			return this;
		}
		
		@Override
		public Footballer build()
		{
			return new Goalkeeper(this);
		}
		
		
	}
}
