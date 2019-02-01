package MyFootballUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import MyFootball.Goalkeeper;

public class GoalkeeperTest {
	
	

	@Test
	public void GoalkeeperBuildertest() {
		Goalkeeper gk = (Goalkeeper) new Goalkeeper.GoalkeeperBuilder("Curtois", 1)
		.lostGoals(13)
		.cleanSheets(3)
		.assists(1)
		.build();
		
		assertEquals(13, gk.getLostGoals());
		assertEquals(3, gk.getCleanSheets());
	}
	
	@Test
	public void addCleanSheetsTest()
	{
		Goalkeeper gk = (Goalkeeper) new Goalkeeper.GoalkeeperBuilder("Curtois", 1)
		.lostGoals(13)
		.cleanSheets(3)
		.assists(1)
		.build();
		
		gk.addCleanSheet();
		assertEquals(4, gk.getCleanSheets());
	}
	
	@Test
	public void addLostGoalsTest()
	{
		Goalkeeper gk = (Goalkeeper) new Goalkeeper.GoalkeeperBuilder("Curtois", 1)
		.lostGoals(13)
		.cleanSheets(3)
		.assists(1)
		.build();
		
		gk.addLostGoals(2);
		assertEquals(15, gk.getLostGoals());
	}
	
	@Test
	public void ResetStatsTest()
	{
		Goalkeeper gk = (Goalkeeper) new Goalkeeper.GoalkeeperBuilder("Curtois", 1)
		.lostGoals(13)
		.cleanSheets(3)
		.assists(1)
		.build();
		
		gk.resetStats();
		assertEquals(0, gk.getAssists());
		assertEquals(0, gk.getScoredGoals());
		assertEquals(0, gk.getCleanSheets());
		assertEquals(0, gk.getLostGoals());
	}

}
