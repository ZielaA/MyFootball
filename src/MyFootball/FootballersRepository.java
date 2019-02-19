package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.LinkedList;

public class FootballersRepository implements IRepository<Footballer, Integer> {

	private AbstractList<Footballer> footballers;
	private IOoperator<Footballer> ioop;
	
	
	public FootballersRepository(IOoperator<Footballer> ioop)
	{
		footballers = new LinkedList<Footballer>();
		this.ioop = ioop; 
	}
	
	public void load(String path) throws FileNotFoundException {
		try {
			footballers = ioop.loadCollection(path, null);
		} catch (ClassNotFoundException | IOException e) {
			Goalkeeper gk = (Goalkeeper) new Goalkeeper.GoalkeeperBuilder("Goalkeeper", 1)
					.lostGoals(13)
					.cleanSheets(3)
					.name("name1")
					.assists(1)
					.build();
					footballers.add(gk);
					for(int i=2; i<=11; i++)
					{
						footballers.add(new Footballer.Builder("Surname" + i, i).name("name"+i).scoredGoals(i).assists(i).build());
					}
		}
		
		
		
	}

	public void save(String path) {
		try {
			ioop.saveCollection(path, footballers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Footballer get(Integer id) {
		for(Footballer f: footballers)
		{
			if(f.getNumberOnShirt() == id) return f;
		}
		
		return null;
	}

	public AbstractList<Footballer> getAll()
	{
		return footballers;
	}
}
