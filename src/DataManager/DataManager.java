package DataManager;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Scanner;

import MyFootball.Match;
import MyFootball.MatchManager;

public class DataManager {

	private static void print(String text)
	{
		System.out.println(text);
	}
	
	private static GregorianCalendar createDate(String s)
	{
		String[] ss = s.split("/");
		int day = Integer.parseInt(ss[0]);
		int month = Integer.parseInt(ss[1]) -1;
		int year = Integer.parseInt(ss[2]);
		GregorianCalendar d = new GregorianCalendar(year, month, day);
		return d;
	}
	private static GregorianCalendar setTime(GregorianCalendar cal, String time)
	{
		String[] ss = time.split(" ");
		int hour = Integer.parseInt(ss[0]);
		int minute = Integer.parseInt(ss[1]);
		cal.add(Calendar.HOUR, hour);
		cal.add(Calendar.MINUTE, minute);
		return cal;
	}
	
	public static void main(String[] args) {

		MatchManager mm = MatchManager.getInstance();

		do {

			print("Wybierz opcje:");
			print("1. Wyswietl mecze");
			print("2. Dodaj mecz");
			print("3. Usuń mecz");
			print("4. Zapisz zmiany do pliku");
			print("5. Wyjdź");

			int w;
			Scanner sc = new Scanner(System.in);
			w = Integer.parseInt(sc.nextLine());
			sc.reset();

			switch (w) {
			case 1:
				for (Match m : mm.getAllMatches())
					print(m.info());
				break;
			case 2:
				Match m;
				print("Podaj nazwę klubu gospodarza: ");
				String home = sc.nextLine();
				print("Podaj nazwę klubu gościa: ");
				String away = sc.nextLine();
				print("Podaj datę w formacie dd/mm/yyyy: ");
				String date = sc.nextLine();
				print("Podaj godzinę w formacie hh mm");
				String time = sc.nextLine();

				m = new Match(home, away, setTime(createDate(date), time));
				mm.addMatch(m);

				break;
			case 3:
				print("Podaj ID meczu do usuniecia: ");
				long id = Long.parseLong(sc.nextLine());

				try
				{
					mm.removeMatch(id);
					print("Usunięto mecz o ID " + id);
				}
				catch (IllegalArgumentException e) {
					print("Niepoprawny numer ID");
				}

				break;
				
				case 4:
				try {
					mm.saveMatches();
					print("Zapisano zmiany");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 5: 
					
					System.exit(0);
					break;
			default:
				break;
			}

		} while (true);

	}


}
