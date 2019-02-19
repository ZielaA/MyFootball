package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;

public class TestMain {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
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
		
		/*Club club2 = new Club("Club2");
		Club club1 = new Club("Club1");
		System.out.println(club1.playersStats());
		System.out.println(club1.playersStats());
		*/
		
		/*League l1 = new League("Liga");
		System.out.println(l1.showLeagueTable());
		*/
		/*MatchManager.getInstance().setRepository(new MatchesRepository());
		try {
			MatchManager.getInstance().loadMatches();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AbstractList<Match> matches = MatchManager.getInstance().getAllMatches();
		
		for(Match m: matches)
		{
			System.out.println(m.info());
		}
		
		
		
		try {
			MatchManager.getInstance().saveMatches();
			System.out.println("Udalo sie");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//MatchManager.getInstance().setRepository(new MatchesRepositoryBin());
		
//		try {
//			MatchManager.getInstance().loadMatches();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		AbstractList<Match> matches2 = MatchManager.getInstance().getAllMatches();
//		//System.out.print(matches2.size());
//		for(Match m: matches2)
//		{
//			System.out.println(m.getHomeName() + "a");
//		}
//		
//		
//		League league = new League("Moja_liga");
//		System.out.println("\n\n");
//		//league.save();
//		for(Club c: league.getAllClubs())
//		{
//			System.out.println(c.matchesInfo());
//			/*if(c.getName() == matches2.get(0).getHomeName());
//			{
//				System.out.print("a");
//			}*/
//		}
//		//System.out.println("dadad");
//		for(Match m:  MatchManager.getInstance().getAllMatches())
//		{
//			System.out.println(m.info());
//		}
		
		Club club2 = new ClubFactory().create("club2");
		System.out.println(club2.playersStats());
		System.out.println(club2.matchesInfo());
		club2.saveFootballers();
	}
}
