package MyFootball;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;



public class MatchesRepository implements IRepository<Match, Long> {

	private LinkedList<Match> matches;
	
	
	public MatchesRepository()
	{
		matches = new LinkedList<Match>();
		try {
			load("");
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
	}
	
	public boolean load(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		matches.add(new Match("Club1", "Club2", new GregorianCalendar(2019, Calendar.FEBRUARY, 8, 20, 07, 0)));
		matches.add(new Match("Club2", "Club3", new GregorianCalendar(2019, Calendar.FEBRUARY, 8, 20, 07, 10)));
		matches.add(new Match("Club3", "Club4", new GregorianCalendar()));
		matches.add(new Match("Club4", "Club1", new GregorianCalendar()));
	
		return false;
	}

	public boolean save(String path) throws IOException
	{
		FileOutputStream fstream = new FileOutputStream("matches.bin");
		ObjectOutputStream objstream = new ObjectOutputStream(fstream);
		//System.out.println(getAll());
		objstream.writeObject(matches);
		
		objstream.close();
		return true;
	}

	public Match get(Long id) {
		for(Match m: matches)
		{
			if(m.getId() == id)
			{
				return m;
			}
		}
		return null;
	}
	
	public LinkedList<Match> getAll()
	{
		return matches;
	}
	
	public void setMatches(LinkedList<Match> matches)
	{
		this.matches = matches;
		System.out.println(matches);
	}

}
