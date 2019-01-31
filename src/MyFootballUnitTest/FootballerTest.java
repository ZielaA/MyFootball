package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import MyFootball.Footballer;

public class FootballerTest 
{
	public static Footballer f = new Footballer.Builder("Kowalski").name("Jan").numberOnShirt(24).assists(11).scoredGoals(10).datOfBirth(new GregorianCalendar(1990, 4, 10)).build();
	
	@Test
	public void BuilderTest1() {
		
		assertEquals("Jan", f.getName());
		assertEquals("Kowalski", f.getSurname());
		assertEquals(28, f.getAge());
		assertEquals(10, f.getScoredGoals());
		assertEquals(11, f.getAssists());
		assertEquals(24, f.getNumberOnShirt());
	}

	
	@Test
	public void AddScoredGoalsTest() {
		f.addScoredGoals(2);
		assertEquals(12, f.getScoredGoals());
	}
	
	@Test
	public void AddSAssistsTest() {
		f.addAssists(1);
		assertEquals(12, f.getAssists());
	}
}
