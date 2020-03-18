import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTests {
	
		Hero player = new Warrior();
		Room entrance = new Room(player, 0, 0);
		Room exit = new Room(player, 4, 4);
		Room testRoom = new Room(player, 3, 4);
	
	@Test
	void testSetPillarAtEntranceAndExit() {
		assertFalse(entrance.setPillar(AbstractionPillar.createPillar()));
		assertFalse(exit.setPillar(AbstractionPillar.createPillar()));
	}
	
	@Test
	void testSetPillarDuplicatePillar() {
		assertTrue(testRoom.setPillar(AbstractionPillar.createPillar()));
		assertFalse(testRoom.setPillar(AbstractionPillar.createPillar()));
	}
	
	@Test
	void testConstructorFillsRoomWithObject() {
		assertTrue(testRoom.getCurrentObject() != null);
	}
	
	@Test
	void testEntranceAndExitContainNothing() {
		assertTrue(entrance.getCurrentObject() == null);
		assertTrue(exit.getCurrentObject() == null);
	}
		
		Dungeon dun = new Dungeon(player);
	
	@Test
	void testToString() {
		assertEquals(dun.getSpecificRoom(0, 0).toString(), "* * *\n* I |\n* - *\n");
		assertEquals(dun.getSpecificRoom(0, 3).toString(), "* * *\n| " + dun.getSpecificRoom(0, 3).getCurrentObject() + " |\n* - *\n");
		assertEquals(dun.getSpecificRoom(3, 0).toString(), "* - *\n* " + dun.getSpecificRoom(3, 0).getCurrentObject() + " |\n* - *\n");
		assertEquals(dun.getSpecificRoom(3, 3).toString(), "* - *\n| " + dun.getSpecificRoom(3, 3).getCurrentObject() + " |\n* - *\n");
		assertEquals(dun.getSpecificRoom(4, 4).toString(), "* - *\n| O *\n* * *\n");
		assertEquals(dun.getSpecificRoom(4, 0).toString(), "* - *\n* " + dun.getSpecificRoom(4, 0).getCurrentObject() + " |\n* * *\n");
		assertEquals(dun.getSpecificRoom(0, 4).toString(), "* * *\n| " + dun.getSpecificRoom(0, 4).getCurrentObject() + " *\n* - *\n");
	}
}
