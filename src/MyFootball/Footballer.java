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
	public Footballer(String name, String surname, GregorianCalendar dayOfBirth, int scoredGoals, int assists, int numberOnShirt)
	{
		super(name, surname, dayOfBirth);
		this.scoredGoals = scoredGoals;
		this.assists = assists;
		this.numberOnShirt = numberOnShirt;
	}
	
	public Footballer(String name, String surname, GregorianCalendar dayOfBirth) 
	{
		super(name, surname, dayOfBirth);
		scoredGoals = 0;
		assists = 0;
		numberOnShirt = -1;
		
	}

	public Footballer(String name, String surname) 
	{
		super(name, surname);
		scoredGoals = 0;
		assists = 0;
		numberOnShirt = -1;
		
	}

	//other methods
	@Override
	public String info()
	{
		String s = super.info();
		return s + "		Number on shirt: " + numberOnShirt + "	  Scored goals: " + scoredGoals + "	Assists" + assists; 
	}

	public void addScoredGoals(int goalsToAdd)
	{
		scoredGoals += goalsToAdd;
	}
	
	public void addAssists(int assistsToAdd)
	{
		assists += assistsToAdd;
	}
}
