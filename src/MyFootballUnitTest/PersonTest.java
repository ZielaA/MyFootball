/**
 * 
 */
package MyFootballUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import MyFootball.Person;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author adrian
 *
 */
public class PersonTest 
{

	
	@Test
	public void ConstructorTest1() 
	{
		Person p = new Person("Jan", "Kowalski", new GregorianCalendar(1990, 4, 10));
		assertEquals("Jan", p.getName());
		assertEquals("Kowalski", p.getSurname());
		assertEquals(1990, p.getDateOfBirth().get(Calendar.YEAR));
		assertEquals(Calendar.MAY, p.getDateOfBirth().get(Calendar.MONTH));
		assertEquals(10, p.getDateOfBirth().get(Calendar.DAY_OF_MONTH));
		
	}
	
	public void ConstructorTest2() 
	{
		Person p = new Person("Jan", "Kowalski");
		assertEquals("Jan", p.getName());
		assertEquals("Kowalski", p.getSurname());
		assertEquals(null, p.getDateOfBirth());
		assertEquals(-1, p.getAge());
		
	}
	
	@Test
	public void determinAgeTest1()
	{
		Person p = new Person("Jan", "Kowalski", new GregorianCalendar(1990, 4, 10));
		assertEquals(28, p.getAge());
	}

	@Test
	public void determinAgeTest2()
	{
		Person p = new Person("Jan", "Kowalski", new GregorianCalendar(1990, 0, 31));
		assertEquals(29, p.getAge());
	}


}
