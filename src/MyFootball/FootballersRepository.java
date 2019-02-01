package MyFootball;

import java.util.LinkedList;

public class FootballersRepository implements IRepository<Footballer, Integer> {

	private LinkedList<Footballer> footballers;
	
	
	public FootballersRepository()
	{
		footballers = new LinkedList<Footballer>();
	}
	
	public boolean load(String path) {
		
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
		return true;
	}

	public boolean save(String path) {
		return true;
	}

	public Footballer get(Integer id) {
		for(Footballer f: footballers)
		{
			if(f.getNumberOnShirt() == id) return f;
		}
		
		return null;
	}

	public LinkedList<Footballer> getAll()
	{
		return footballers;
	}
}
