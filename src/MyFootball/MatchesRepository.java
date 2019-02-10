package MyFootball;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;



public class MatchesRepository implements IRepository<Match, Long> {

	private LinkedList<Match> matches;
	
	
	public MatchesRepository()
	{
		matches = new LinkedList<Match>();
	}
	
	public boolean load(String path) {
		// TODO Auto-generated method stub
		
		matches.add(new Match("Club1", "Club2", new GregorianCalendar(2019, Calendar.FEBRUARY, 8, 20, 07, 0)));
		matches.add(new Match("Club2", "Club3", new GregorianCalendar(2019, Calendar.FEBRUARY, 8, 20, 07, 10)));
		matches.add(new Match("Club3", "Club4", new GregorianCalendar()));
		matches.add(new Match("Club4", "Club1", new GregorianCalendar()));
	
		return false;
	}

	public boolean save(String path) {
		// TODO Auto-generated method stub
		return false;
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

}
