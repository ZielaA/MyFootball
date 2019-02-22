package MyFootball;

import java.util.LinkedList;

public class User {
	
	private static User instance = new User();
	private LinkedList<String> favouriteClubs;
	private INotifier notifier;
	
	private User()
	{
		favouriteClubs = new LinkedList<String>();
		notifier = new ConsoleNotifier();
	}
	
	
	public static User getInstance()
	{
		return instance;
	}
	
	public void addFavouriteClub(String clubName)
	{
		favouriteClubs.add(clubName);
	}
	
	
	public boolean isClubFavourite(String clubName)
	{	
		for(String s: favouriteClubs)
		{
			if(s.equals(clubName) == true) return true;
		}
		return false;
	}
	
	public void notify(String message)
	{
		notifier.notifyUser(message);
	}

	
}
