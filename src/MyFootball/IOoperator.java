package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IOoperator<T> {

	public T load(String path) throws IOException, ClassNotFoundException;
	public void save(String path, T t) throws FileNotFoundException, IOException;
}
