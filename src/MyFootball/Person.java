package MyFootball;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {

	private final String name;
	private final String surname;
	private int age;
	private final GregorianCalendar dateOfBirth;
	
	// getters and setters
	public String getName() 
	{
		return name;
	}
	
	public String getSurname() 
	{
		return surname;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public GregorianCalendar getDateOfBirth() 
	{
		return (GregorianCalendar)dateOfBirth.clone();
	}
	
	//Constructors
	public Person(String name, String surname, GregorianCalendar dayOfBirth)
	{
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dayOfBirth;
		determinAge();
	}
	
	public Person(String name, String surname)
	{
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = null;
		this.age = -1;
	}
	
	//Other methods
	private void determinAge()
	{
		if(dateOfBirth == null) 
		{
			age = -1;
			return;
		}
		GregorianCalendar now = new GregorianCalendar();
		age = now.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR) -1 ;
		if(now.get(Calendar.MONTH) >= dateOfBirth.get(Calendar.MONTH) && now.get(Calendar.DAY_OF_MONTH) >= dateOfBirth.get(Calendar.DAY_OF_MONTH))
		{
			age++;
		}
	}
	
	public String info()
	{
		String s = new String();
		if(name != null) s+= name + " ";
		s += surname;
		if(age > 0) s += "	Age: " + age;
		else s += "	Age: unknown"; 
		return s;
	}
	
}
