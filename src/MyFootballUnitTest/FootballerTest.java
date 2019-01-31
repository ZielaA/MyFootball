package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import MyFootball.Footballer;

public class FootballerTest 
{

	@Test
	public void ConstructorTest1() {
		Footballer f = new Footballer("Jan", "Kowalski", new GregorianCalendar(1990, 4, 10), 10, 11, 24);
		
		assertEquals("Jan", f.getName());
		assertEquals("Kowalski", f.getSurname());
		assertEquals(28, f.getAge());
		assertEquals(10, f.getScoredGoals());
		assertEquals(11, f.getAssists());
		assertEquals(24, f.getNumberOnShirt());
	}

	
	@Test
	public void AddScoredGoalsTest() {
		Footballer f = new Footballer("Jan", "Kowalski", new GregorianCalendar(1990, 4, 10), 10, 11, 24);
		f.addScoredGoals(2);
		assertEquals(12, f.getScoredGoals());
	}
	
	@Test
	public void AddSAssistsTest() {
		Footballer f = new Footballer("Jan", "Kowalski", new GregorianCalendar(1990, 4, 10), 10, 11, 24);
		f.addAssists(1);
		assertEquals(12, f.getAssists());
	}
}
