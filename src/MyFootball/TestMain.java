package MyFootball;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Footballer f = new Footballer.Builder("Zieliński")
		.build();
		
		System.out.println(f.info());

	}

}
