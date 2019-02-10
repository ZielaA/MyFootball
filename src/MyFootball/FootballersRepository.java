package MyFootball;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ProcessBuilder.Redirect;
import java.security.KeyStore.Entry.Attribute;
import java.util.AbstractList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class FootballersRepository implements IRepository<Footballer, Integer> {

	private LinkedList<Footballer> footballers;
	
	
	public FootballersRepository()
	{
		footballers = new LinkedList<Footballer>();
	}
	
	public void load(String path) throws FileNotFoundException {
		/*path = "/home/adrian/java/workspace/MyFootball/data/" + path;
		Scanner reader = new Scanner(new File(path));
		
		//String text = reader.toString();
		String fData = new String();
		Map<String, String> attributes = new HashMap<String, String>();
		while(reader.hasNext())
		{
			String line = reader.next();
			
			if(line == "#")
			{
				attributes[]
			}
			else
			{	
				String a[] = line.split(":");
				attributes.put(a[0], a[1]);
				fData += line;
			}
			
			System.out.println(fData);
		}
		reader.close();
		return true;	
		*/
		
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

	public void save(String path) {
		;
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
