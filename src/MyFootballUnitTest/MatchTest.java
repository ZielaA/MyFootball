/**
 * 
 */


package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import MyFootball.Club;
import MyFootball.Match;
import MyFootball.MatchManager;
import MyFootball.MatchesRepository;
import MyFootball.Score;

/**
 * @author adrian
 *
 */


public class MatchTest {

	private Match m1;
	private Match m2;
	private Club c1;
	private Club c2;
	private LinkedList<Match> l;
	
	@Before
	public void setUp() throws Exception {
		/*c1 = new Club("FC Barcelona");
		c2 = new Club("Real Madrit");*/
		GregorianCalendar matchTime = new GregorianCalendar();
		matchTime.add(Calendar.SECOND, 1);
		m1 = new Match("FC Barcelona", "Real Madrit", new GregorianCalendar(2019, Calendar.FEBRUARY, 6, 15, 30));
		m2 = new Match("FC Barcelona", "Real Madrit", matchTime);
		l = new LinkedList<Match>();
		l.add(m2);
	}

	@Test
	public void ConstructorTest() {
		assertEquals("FC Barcelona", m1.getHomeName());
		assertEquals("Real Madrit", m1.getAwayName());
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
	public void timerTest()
	{
		MatchManager.getInstance().setMatches(new MatchesRepository(l));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(0, m2.getScore().getHomeGoals());
		assertEquals(0, m2.getScore().getAwayGoals());
	}
	
}
