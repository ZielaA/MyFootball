package MyFootball;
import java.io.IOException;
import java.util.AbstractList;
import java.util.LinkedList;



public class MatchesRepository implements IRepository<Match, Long> {

	private AbstractList<Match> matches;
	private IOoperator<Match> ioop;
	
	
	/*public MatchesRepository()
	{
		matches = new LinkedList<Match>();
		
	}*/
	
	public MatchesRepository(IOoperator<Match> ioop)
	{
		matches = new LinkedList<Match>();
		this.ioop = ioop;
	}
	
	public void load(String path) throws IOException, ClassNotFoundException, NullPointerException {
		if(ioop != null)
		{
			matches = ioop.loadCollection(path, null);
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
			ioop.saveCollection(path, matches);
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
