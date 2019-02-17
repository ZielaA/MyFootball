package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.LinkedList;

public class ClubsRepository implements IRepository<Club, String> {

	private AbstractList<Club> clubs;
	//private AbstractList<String> clubsNames;
	private IOoperator<Club> ioop;
	
	public ClubsRepository(IOoperator<Club> ioop)
	{
		clubs = new LinkedList<Club>();
		this.ioop = ioop;
		//load("");
	}
	
	public void load(String path) {
			
				try {
					clubs = ioop.loadCollection(path, new ClubFactory());
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	public void save(String path) throws FileNotFoundException, IOException {
		ioop.saveCollection(path, clubs);
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
