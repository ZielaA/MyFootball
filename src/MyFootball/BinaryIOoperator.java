package MyFootball;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinaryIOoperator<T> implements IOoperator<T> {


	public T load(String path) throws IOException, ClassNotFoundException
	{
		FileInputStream fstream = new FileInputStream(path);
		ObjectInputStream objstream = new ObjectInputStream(fstream);
		T container = (T) objstream.readObject();
		//System.out.println(m);
		objstream.close();
		return container;
	}

	public void save(String path, T t) throws FileNotFoundException, IOException {
		FileOutputStream fstream = new FileOutputStream(path);
		ObjectOutputStream objstream = new ObjectOutputStream(fstream);
		objstream.writeObject(t);
		objstream.close();
	}

}
