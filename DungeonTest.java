import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DungeonTest {

	static Dungeon dun;
	@BeforeAll
	public static void setUp() {
		Hero player = new Warrior();
		dun = new Dungeon(player);
	}
	
	@BeforeEach
	public void beforeEach() {
		dun.backtrackToEntrance();
	}

	@Test
	public void testConstructorBuildsDungeonAndHasAllItems() {
		assertNotNull(dun.getRoomArray());
		dun.toString();
		// Only checking if there more than one item of a certain type may return 0
		assertTrue(dun.getPitCount() + dun.getHealingPotionCount() > 0);
		assertTrue(dun.getPillarCount() == 4);
	}

	@Test
	public void testMoveNorthAndWestOnBorder() {
		dun.moveNorth();
		dun.moveWest();
		int x = dun.getX();
		int y = dun.getY();
		assertEquals(0, x);
		assertEquals(0, y);
	}
	
	@Test
	public void testMoveSouthAndEast() {
		dun.moveSouth();
		dun.moveEast();
		int x = dun.getX();
		int y = dun.getY();
		assertEquals(1, x);
		assertEquals(1, y);
	}
	
	@Test
	public void testMoveNorthAndWest() {
		dun.moveSouth();
		dun.moveEast();
		dun.moveNorth();
		dun.moveWest();
		int x = dun.getX();
		int y = dun.getY();
		assertEquals(0, x);
		assertEquals(0, y);
	}
	
	@Test
	public void testMoveSouthAndEastOnBorder() {
		dun.moveSouth();
		dun.moveSouth();
		dun.moveSouth();
		dun.moveSouth();
		dun.moveEast();
		dun.moveEast();
		dun.moveEast();
		dun.moveEast();
		int x = dun.getX();
		int y = dun.getY();
		assertEquals(4, x);
		assertEquals(4, y);
	}
	
	@Test
	public void testCheckRoomRemovesItems() {
		// While loop so grader wont battle monster while testing
		if(dun.getSpecificRoom(0, 1).getMonsterCount() == 0) {
			dun.moveEast();
			checkRoomHelper(0, 1);
		} else {
			if(dun.getSpecificRoom(1, 0).getMonsterCount() == 0) {
				dun.moveSouth();
				checkRoomHelper(1, 0);
			}
		}
	}

	public void checkRoomHelper(int x, int y) {
		int totalRoomItemCountAfter = dun.getSpecificRoom(x, y).getHealingPotionCount() + dun.getSpecificRoom(x, y).getMonsterCount()
				+ dun.getSpecificRoom(x, y).getPillarCount() + dun.getSpecificRoom(x, y).getPitCount() +
				dun.getSpecificRoom(x, y).getVisionPotionCount();
		assertTrue(totalRoomItemCountAfter == 0);
	}
	
}
