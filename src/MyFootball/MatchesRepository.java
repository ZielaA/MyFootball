package MyFootball;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.AbstractList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;



public class MatchesRepository implements IRepository<Match, Long> {

	private AbstractList<Match> matches;
	private IOoperator<AbstractList<Match>> ioop;
	
	
	public MatchesRepository()
	{
		matches = new LinkedList<Match>();
		
	}
	
	public MatchesRepository(IOoperator<AbstractList<Match>> ioop)
	{
		matches = new LinkedList<Match>();
		this.ioop = ioop;
	}
	
	public void load(String path) throws IOException, ClassNotFoundException, NullPointerException {
		if(ioop != null)
		{
			matches = ioop.load(path);
		}
		else 
		{
			throw new NullPointerException();
		}
	}

	public void save(String path) throws IOException, NullPointerException
	{
		if(ioop != null)
		{
			ioop.save(path, matches);
		}
		else 
		{
			throw new NullPointerException();
		}
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
	
	public AbstractList<Match> getAll()
	{
		return matches;
	}

}
