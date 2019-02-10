package MyFootball;

import java.util.AbstractList;
import java.util.LinkedList;

public class ClubsRepository implements IRepository<Club, String> {

	private AbstractList<Club> clubs;
	
	public ClubsRepository()
	{
		clubs = new LinkedList<Club>();
		load("");
	}
	
	public boolean load(String path) {
		clubs.add(new Club("club1"));
		//clubs.add(new Club("club2"));
		//clubs.add(new Club("club3"));
		//clubs.add(new Club("club4"));
		return false;
	}

	public boolean save(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	public Club get(String id) {
		for(Club c: clubs)
		{
			if(c.getName() == id)
			{
				return c;
			}
		}
		return null;
	}

	public AbstractList<Club> getAll() {
		return clubs;
	}

	
	
}
