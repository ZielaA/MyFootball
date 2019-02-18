package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import MyFootball.Club;
import MyFootball.ClubFactory;
import MyFootball.Factory;
import MyFootball.Match;

public class ClubFactoryTest {
	
	private LinkedList<Match> matches;
	private Factory<Club> factory;

	@Before
	public void setUp()
	{
		matches = new LinkedList<Match>();
		matches.add(new Match("club1", "club2", new GregorianCalendar()));
		factory = new ClubFactory();
	}
	
	@Test
	public void createTest() {
		
		Club c = factory.create("club1");
		assertNotNull(c);
		assertEquals("club1", c.getName());
		System.out.println(c.matchesInfo());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void throwException1() {
		Club c = factory.create("");
	}
	
	@Test(expected = NullPointerException.class)
	public void throwException2() {
		Club c = factory.create(null);
	}

}
