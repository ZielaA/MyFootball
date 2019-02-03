/**
 * 
 */
package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import MyFootball.Club;
import MyFootball.Match;
import MyFootball.Score;

/**
 * @author adrian
 *
 */
public class MatchTest {

	private Match m1;
	private Club c1;
	private Club c2;
	
	@Before
	public void setUp() throws Exception {
		c1 = new Club("FC Barcelona");
		c2 = new Club("Real Madrit");
		m1 = new Match(c1, c2, new GregorianCalendar(2019, Calendar.FEBRUARY, 6, 15, 30));
	}

	@Test
	public void ConstructorTest() {
		assertEquals(c1, m1.getHome());
		assertEquals(c2, m1.getAway());
		assertEquals(null, m1.getScore());
		assertNotEquals(0, m1.getId());
		assertNotNull(m1.getMatchTime());
	}
	
	@Test
	public void SetScore1Test()
	{
		m1.setScore(new Score(2, 1));
		assertEquals(2, m1.getScore().getHomeGoals());
		assertEquals(1, m1.getScore().getAwayGoals());
	}
	
	@Test
	public void SetScore2Test()
	{
		m1.setScore(2,1);
		assertEquals(2, m1.getScore().getHomeGoals());
		assertEquals(1, m1.getScore().getAwayGoals());
	}
	
	@Test
	public void generatingIdTest()
	{
		Match m2 = new Match(new Club(""), new Club(""), new GregorianCalendar());
		assertNotEquals(m1.getId(), m2.getId());
		
	}

}
