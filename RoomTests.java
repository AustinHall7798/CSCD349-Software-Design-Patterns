import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomTests {

	Hero player = new Warrior();
	Room[][] roomArray = new Room[10][5];
	String[] counta = new String[50];
	Dungeon dun = new Dungeon(player);
	VisionPotion vp = new VisionPotion(dun);
	int count;
	int k = 0;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testRoom() {
		
		
		System.out.println(dun.getCurrentRoom().toString());
		dun.moveEast();
		dun.moveEast();
		dun.moveEast();
		System.out.println(dun.getCurrentRoom().toString());
		vp.drinkPotion();
		
		
	}
}
