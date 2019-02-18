package MyFootball;

public class ClubFactory implements Factory<Club> {

	public Club create(String s) {
		if(s == null ) throw new NullPointerException();
		if(s == "") throw new IllegalArgumentException();
		return new Club(s, MatchManager.getInstance().getMatchesForClub(s));
	}

}
