/**
 * 
 */
package MyFootball;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;

/**
 * @author adrian
 *
 */
public interface IRepository<T, G>{
	
	public boolean load(String path) throws FileNotFoundException, IOException, ClassNotFoundException;
	
	public boolean save(String path) throws IOException;
	
	public T get(G id);
	
	public AbstractList<T> getAll();

}
