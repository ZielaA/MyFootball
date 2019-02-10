package MyFootball;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

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
		
		MatchManager.getInstance().setRepository(new MatchesRepositoryBin());
		
		try {
			MatchManager.getInstance().loadMatches();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AbstractList<Match> matches2 = MatchManager.getInstance().getAllMatches();
		for(Match m: matches2)
		{
			System.out.println(m.info());
		}
		
		
		/*MatchManager.getInstance().setRepository(new MatchesRepository());
		try {
			MatchManager.getInstance().loadMatches();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AbstractList<Match> matches = MatchManager.getInstance().getAllMatches();
		
		for(Match m: matches)
		{
			System.out.println(m.info());
		}
		
		
		FileOutputStream fstream = new FileOutputStream("matches2.bin");
		ObjectOutputStream objstream = new ObjectOutputStream(fstream);
		
		objstream.writeObject(matches);
		
		objstream.close();
		
		FileInputStream fstream2 = new FileInputStream("matches2.bin");
		ObjectInputStream objstream2 = new ObjectInputStream(fstream2);
		matches = (LinkedList<Match>) objstream2.readObject();
		
		objstream.close();
		
		for(Match m: matches)
		{
			System.out.println(m.info());
		}*/
		
	}

}
