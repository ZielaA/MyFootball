package MyFootball;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Collections;
import java.util.LinkedList;



public class MatchesRepository implements IRepository<Match, Long> {

	private AbstractList<Match> matches;
	private IOoperator<Match> ioop;
	
	
	public MatchesRepository(IOoperator<Match> ioop)
	{
		matches = new LinkedList<Match>();
		this.ioop = ioop;
	}
	
	public MatchesRepository(AbstractList<Match> matches)
	{
		this.matches = matches;
		this.ioop = new BinaryIOoperator<Match>();
	}
	
	public void load(String path) throws IOException, ClassNotFoundException, NullPointerException {
		if(ioop != null)
		{
			matches = ioop.loadCollection(path, null);
			Collections.sort(matches);
			
			for(Match m: matches)
			{
				m.initialize();
			}
		}
		else 
		{	
			if(matches == null)
			{
				throw new NullPointerException();
			}
			
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
	
	public void add(Match m)
	{
		matches.add(m);
	}

	@Override
	public void remove(Long id) {
		Match m = get(id);
		int index = matches.indexOf(m);
		if(index != -1)
		{
			matches.remove(index);
		}
		else throw new IllegalArgumentException();
	}

}
