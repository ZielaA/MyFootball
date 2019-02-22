package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import MyFootball.Match;
import MyFootball.MatchManager;
import MyFootball.MatchesRepository;
import MyFootball.User;

public class UserTest {
	
	private MatchManager mm;
	private LinkedList<Match> matches;
	private User user;

	@Before
	public void setUp() throws Exception {
	
	mm = MatchManager.getInstance();
	matches = new LinkedList<Match>();
	GregorianCalendar matchTime = new GregorianCalendar();
	matchTime.add(Calendar.SECOND, 1);
	matches.add(new Match("club1", "club2", matchTime));
	matches.add(new Match("club1", "club3", new GregorianCalendar()));
	matches.add(new Match("club4", "club1", new GregorianCalendar()));
	matches.add(new Match("club3", "club5", new GregorianCalendar()));
	matches.add(new Match("club1", "club2", new GregorianCalendar()));
	mm.setMatches(new MatchesRepository(matches));
	
	user = User.getInstance();
	user.addFavouriteClub("club1");
	user.addFavouriteClub("club4");
	
	}

	@Test
	public void isClubFavouriteTest1() {
		
		assertEquals(true, user.isClubFavourite("club1"));
	}
	
	@Test
	public void isClubFavouriteTest2() {
		
		assertEquals(false, user.isClubFavourite("club3"));
	}

}
