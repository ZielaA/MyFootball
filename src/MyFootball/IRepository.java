/**
 * 
 */
package MyFootball;

import java.io.FileNotFoundException;
import java.util.AbstractList;

/**
 * @author adrian
 *
 */
public interface IRepository<T, G>{
	
	public boolean load(String path) throws FileNotFoundException;
	
	public boolean save(String path);
	
	public T get(G id);
	
	public AbstractList<T> getAll();

}
