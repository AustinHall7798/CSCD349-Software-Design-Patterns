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
	Dungeon dun1 = new Dungeon(player);
	Dungeon dun2 = new Dungeon(player);
	Dungeon dun3 = new Dungeon(player);
	Dungeon dun4 = new Dungeon(player);
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
		
		dun.printDungeon();
		System.out.println(dun.getCurrentRoom().toString());
		dun.moveSouth();
		System.out.println(dun.getCurrentRoom().toString());
		vp.drinkPotion();
		
		dun.moveSouth();
		System.out.println(dun.getCurrentRoom().toString());
		vp.drinkPotion();
		
		dun.moveSouth();
		dun.moveSouth();
		dun.moveSouth();
		dun.moveSouth();
		dun.moveSouth();
		dun.moveEast();
		System.out.println(dun.getCurrentRoom().toString());
		vp.drinkPotion();
		
		System.out.println(dun.toString());
		System.out.println(dun1.toString());
		System.out.println(dun2.toString());
		System.out.println(dun3.toString());
		System.out.println(dun4.toString());
	}
}
