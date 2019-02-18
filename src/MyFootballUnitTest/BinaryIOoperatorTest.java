package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import MyFootball.BinaryIOoperator;
import MyFootball.Person;

public class BinaryIOoperatorTest {

	private LinkedList<Person> testList;
	BinaryIOoperator<Person> op; 
	
	@Before
	public void setUp() throws Exception {
		op = new BinaryIOoperator<Person>();
		testList = new LinkedList<Person>();
		testList.add(new Person("Jan", "Kowalski"));
		testList.add(new Person("John", "Smith"));
		testList.add(new Person("Anna", "Nowak"));
	}

	@Test
	public void SaveAndLoadCollectionTest() throws FileNotFoundException, IOException, ClassNotFoundException {
		op.saveCollection("BinOperatorTest", testList);
		LinkedList<Person> loadedList = (LinkedList<Person>) op.loadCollection("BinOperatorTest", null);
		
			assertEquals("Jan", loadedList.get(0).getName());
			assertEquals("Kowalski", loadedList.get(0).getSurname());
			assertEquals("John", loadedList.get(1).getName());
			assertEquals("Smith", loadedList.get(1).getSurname());
			assertEquals("Anna", loadedList.get(2).getName());
			assertEquals("Nowak", loadedList.get(2).getSurname());
	}

}
