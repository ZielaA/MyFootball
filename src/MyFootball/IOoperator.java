package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;

public interface IOoperator<T> {

	public AbstractList<T> loadCollection(String path, Factory<T> f) throws IOException, ClassNotFoundException;
	public void saveCollection(String path, AbstractList<T> collection) throws FileNotFoundException, IOException;
}
