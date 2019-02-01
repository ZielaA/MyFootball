package MyFootball;

import java.util.GregorianCalendar;

public class Footballer extends Person 
{
	
	private int scoredGoals;
	private int assists;
	private int numberOnShirt;
	
	
	
//getter and setters
	public int getScoredGoals() 
	{
		return scoredGoals;
	}

	public int getAssists() 
	{
		return assists;
	}

	public int getNumberOnShirt() 
	{
		return numberOnShirt;
	}

	
	//constructors
	protected Footballer(final Builder builder)
	{
		super(builder.name, builder.surname, builder.dateOfBirth);
		this.scoredGoals = builder.scoredGoals;
		this.assists = builder.assists;
		this.numberOnShirt = builder.numberOnShirt;
		
	}
	
	

	//other methods
	@Override
	public String info()
	{
		String s = super.info();
		if(numberOnShirt > 0 ) s += "		Number on shirt: " + numberOnShirt;
		else s += "		Number on shirt: unknown";
		
		return s + "	  Scored goals: " + scoredGoals + "	Assists: " + assists; 
	}

	public void addScoredGoals(int goalsToAdd)
	{
		scoredGoals += goalsToAdd;
	}
	
	public void addAssists(int assistsToAdd)
	{
		assists += assistsToAdd;
	}
	
	public void resetStats()
	{
		scoredGoals = 0;
		assists = 0;
	}

	
	//fluent builder inner class
	public static class Builder
	{
		private String name;
		private final String surname;
		private GregorianCalendar dateOfBirth;
		private int scoredGoals;
		private int assists;
		private int numberOnShirt;
		
		
		public Builder(final String surname, int numberOnShirt)
		{
			this.surname = surname;
			this.numberOnShirt = numberOnShirt;
		}
		
		public Builder name(final String name)
		{
			this.name = name;
			return this;
		}
		
		public Builder datOfBirth(final GregorianCalendar dateOfBirth)
		{
			this.dateOfBirth = dateOfBirth;
			return this;
		}
		
		public Builder scoredGoals(final int scoredGoals)
		{
			this.scoredGoals = scoredGoals;
			return this;
		}
		
		public Builder assists(final int assists)
		{
			this.assists = assists;
			return this;
		}
		
		
		public Footballer build()
		{
			return new Footballer(this);
		}

	}
}
