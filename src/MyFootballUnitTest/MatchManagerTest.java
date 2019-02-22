package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.util.AbstractList;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import MyFootball.Club;
import MyFootball.Match;
import MyFootball.MatchManager;
import MyFootball.MatchesRepository;

public class MatchManagerTest {

	private LinkedList<Match> matches;
	//private Club club;
	
	@Before
	public void setUp() throws Exception {
	
	matches = new LinkedList<Match>();
	matches.add(new Match("club1", "club2", new GregorianCalendar()));
	matches.add(new Match("club1", "club3", new GregorianCalendar()));
	matches.add(new Match("club4", "club1", new GregorianCalendar()));
	matches.add(new Match("club3", "club5", new GregorianCalendar()));
	matches.add(new Match("club1", "club2", new GregorianCalendar()));
	MatchManager.getInstance().setMatches(new MatchesRepository(matches));
	}

	@Test
	public void getMatchesForClubTest() {
		AbstractList<Match> l1 = MatchManager.getInstance().getMatchesForClub("club1");
		assertEquals(4, l1.size());
	}
	
	@Test
	public void startMatchTest()
	{
		Match m = matches.get(0);
		assertNull(m.getScore());
		MatchManager.getInstance().startMatch(m.getId());
		assertEquals(0, m.getScore().getHomeGoals());
		assertEquals(0, m.getScore().getAwayGoals());
	}

}
