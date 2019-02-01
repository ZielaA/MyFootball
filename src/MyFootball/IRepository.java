/**
 * 
 */
package MyFootball;

/**
 * @author adrian
 *
 */
public interface IRepository<T, G>{
	
	public boolean load(String path);
	
	public boolean save(String path);
	
	public T get(G id);

}
