package dungeon;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DungeonCharacterTest {

	DungeonCharacter testCharacter;
	
	@BeforeEach
	public void setup() throws Exception {
		testCharacter = HeroFactory.createWarrior();
	}
	
	@Test
	public void testHitPointManipulations() {
		// Default Hitpoints
		assertEquals(125, testCharacter.getHitPoints());
		
		// Subtract Hitpoints
		testCharacter.subtractHitPoints(-1);
		assertEquals(125, testCharacter.getHitPoints());
				
		testCharacter.subtractHitPoints(0);
		assertEquals(125, testCharacter.getHitPoints());
		
		testCharacter.subtractHitPoints(10);
		assertEquals(115, testCharacter.getHitPoints());
		
		// Add Hitpoints
		testCharacter = HeroFactory.createWarrior();

		testCharacter.addHitPoints(-1);
		assertEquals(125, testCharacter.getHitPoints());

		testCharacter.addHitPoints(0);
		assertEquals(125, testCharacter.getHitPoints());
		
		testCharacter.addHitPoints(10);
		assertEquals(135, testCharacter.getHitPoints());
	}
}
