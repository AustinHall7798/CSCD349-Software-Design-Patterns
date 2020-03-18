import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonsterTest {

	Monster testMonster;
	
	@BeforeEach
	public void setup() throws Exception {
		 testMonster = MonsterFactory.createOgre();
	}
	
	@Test
	public void testHeal() {
		// Default state
		assertEquals(200, testMonster.getHitPoints());
		
		// Heal
		testMonster.heal();
		assertTrue(testMonster.getHitPoints() >= 200);
		
	}
}
