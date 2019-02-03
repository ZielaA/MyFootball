package MyFootball;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Footballer f = new Footballer.Builder("Zieliński", 24)
		.build();
		Goalkeeper gk = (Goalkeeper) new Goalkeeper.GoalkeeperBuilder("Curtois", 1).cleanSheets(3).assists(1).build();
		System.out.println(f.info());
		System.out.println(gk.info());
		
		Club myClub = new Club("My Club");
		System.out.println(myClub);
		
		Match m1;
		Club c1;
		Club c2;
		c1 = new Club("FC Barcelona");
		c2 = new Club("Real Madrit");
		m1 = new Match(c1, c2, new GregorianCalendar(2019, Calendar.FEBRUARY, 6, 15, 30));
		System.out.println(m1.info());
		*/
		
		Club club1 = new Club("Club2");
		System.out.println(club1.matchesInfo());

	}

}
