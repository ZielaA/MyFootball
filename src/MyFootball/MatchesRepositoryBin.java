package MyFootball;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class MatchesRepositoryBin extends MatchesRepository {

	public MatchesRepositoryBin() {
		super();
	}
	
	
	
	@Override
	public void load(String path) throws IOException, ClassNotFoundException
	{
		FileInputStream fstream = new FileInputStream("matches.bin");
		ObjectInputStream objstream = new ObjectInputStream(fstream);
		LinkedList<Match> m = (LinkedList<Match>) objstream.readObject();
		System.out.println(m);
		//setMatches(m);
		
		objstream.close();
	}
	
	

}
