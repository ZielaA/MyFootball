package MyFootball;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;

public class BinaryIOoperator<T extends Serializable> implements IOoperator<T> {


	public AbstractList<T> loadCollection(String path) throws IOException, ClassNotFoundException
	{
		FileInputStream fstream = new FileInputStream(path);
		ObjectInputStream objstream = new ObjectInputStream(fstream);
		AbstractList<T> collection = (AbstractList<T>) objstream.readObject();
		//System.out.println(m);
		objstream.close();
		return collection;
	}

	public void saveCollection(String path, AbstractList<T> collection) throws FileNotFoundException, IOException {
		FileOutputStream fstream = new FileOutputStream(path);
		ObjectOutputStream objstream = new ObjectOutputStream(fstream);
		objstream.writeObject(collection);
		objstream.close();
	}

}
