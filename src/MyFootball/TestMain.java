package MyFootball;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Footballer f = new Footballer.Builder("Zieliński")
		.build();
		Goalkeeper gk = (Goalkeeper) new Goalkeeper.GoalkeeperBuilder("Curtois").cleanSheets(3).assists(1).numberOnShirt(1).build();
		System.out.println(f.info());
		System.out.println(gk.info());

	}

}
