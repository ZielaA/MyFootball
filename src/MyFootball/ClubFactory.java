package MyFootball;

public class ClubFactory implements Factory<Club> {

	public Club create(String s) {
		if(s == null || s == "") throw new NullPointerException();
		return new Club(s);
	}

}
