package MyFootball;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Footballer f = new Footballer.Builder("Zieliński", 24)
		.build();
		Goalkeeper gk = (Goalkeeper) new Goalkeeper.GoalkeeperBuilder("Curtois", 1).cleanSheets(3).assists(1).build();
		System.out.println(f.info());
		System.out.println(gk.info());
		
		Club myClub = new Club("My Club");
		System.out.println(myClub);

	}

}
