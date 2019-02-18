package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import MyFootball.Club;
import MyFootball.Match;
import MyFootball.Score;

public class ClubTest {
	
	private Club c;
	private LinkedList<Match> matches;

	@Before
	public void setUp() throws Exception 
	{
		matches = new LinkedList<Match>();
		Match m1 = new Match("club1", "club2", new GregorianCalendar());
		m1.setScore(new Score(3, 1));
		Match m2 = new Match("club1", "club2", new GregorianCalendar());
		m2.setScore(new Score(2, 2));
		Match m3 = new Match("club2", "club1", new GregorianCalendar());
		m3.setScore(new Score(1, 0));
		Match m4 = new Match("club2", "club1", new GregorianCalendar());
		m4.setScore(new Score(0, 2));
		Match m5 = new Match("club1", "club2", new GregorianCalendar());
		matches.add(m1);
		matches.add(m2);
		matches.add(m3);
		matches.add(m4);
		matches.add(m5);
		
		c = new Club("club1", matches);
	}

	@Test
	public void ConstructorTest() {
		assertEquals("club1", c.getName());
		assertEquals(2, c.getWins());
		assertEquals(1, c.getDraws());
		assertEquals(1, c.getDefeats());
		assertEquals(7, c.getPoints());
		assertEquals(7, c.getScoredGoals());
		assertEquals(4, c.getLostGoals());
		assertEquals(3, c.getGoalsDifference());
	}

}
