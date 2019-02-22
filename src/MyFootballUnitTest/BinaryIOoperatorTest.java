package MyFootballUnitTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import MyFootball.BinaryIOoperator;
import MyFootball.Match;
import MyFootball.Person;

public class BinaryIOoperatorTest {

	private LinkedList<Person> testList;
	private LinkedList<Match> testList2;
	BinaryIOoperator<Person> op; 
	BinaryIOoperator<Match> op2; 
	
	@Before
	public void setUp() throws Exception {
		op = new BinaryIOoperator<Person>();
		testList = new LinkedList<Person>();
		testList.add(new Person("Jan", "Kowalski"));
		testList.add(new Person("John", "Smith"));
		testList.add(new Person("Anna", "Nowak"));
		
		
		op2 = new BinaryIOoperator<Match>();
		testList2 = new LinkedList<Match>();
		testList2.add(new Match("club1", "club2", new GregorianCalendar()));
		testList2.add(new Match("club3", "club4", new GregorianCalendar()));
		testList2.add(new Match("club5", "club6", new GregorianCalendar()));
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
	
	@Test
	public void SaveAndLoadCollectionTest2() throws FileNotFoundException, IOException, ClassNotFoundException {
		op2.saveCollection("BinOperatorTest2", testList2);
		LinkedList<Match> loadedList = (LinkedList<Match>) op2.loadCollection("BinOperatorTest2", null);
		
			assertEquals("club1", loadedList.get(0).getHomeName());
			assertEquals("club2", loadedList.get(0).getAwayName());
			assertEquals("club3", loadedList.get(1).getHomeName());
			assertEquals("club4", loadedList.get(1).getAwayName());
			assertEquals("club5", loadedList.get(2).getHomeName());
			assertEquals("club6", loadedList.get(2).getAwayName());
	}

}
