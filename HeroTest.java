import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HeroTest {
	
	Hero testHero;
	
	@BeforeAll
	public void setUpBeforeClass() throws Exception {
		testHero = HeroFactory.createWarrior();
	}
	
	@Test
	public void testToString() {
		assertEquals(testHero.getName() + "'s Character Sheet:\nHitPoints: 125\nHealing Potions: 0\nVision Potions: 0\nPillars of OO Found: 0", testHero.toString());
	}
	
	@Test
	public void testPotionCounts() {
		
		//Default count
		assertEquals(0, testHero.getHealingPotionCount());
		assertEquals(0, testHero.getVisionPotionCount());
		
		// Potion added to inventory
		testHero.addHealingPotion();
		assertEquals(1, testHero.getHealingPotionCount());
		
		// Drinking a potion (Hero starts with one potion, drinks, count should be 0)
		testHero.drinkHealingPotion();
		assertEquals(0, testHero.getHealingPotionCount());
		
		testHero.drinkVisionPotion();
		assertEquals(0, testHero.getVisionPotionCount());
		
		// Trying to drink a potion you don't have
		testHero.drinkHealingPotion();
		assertEquals(0, testHero.getHealingPotionCount());
		
		testHero.drinkVisionPotion();
		assertEquals(0, testHero.getVisionPotionCount());
	}
	
	@Test
	public void testHealingPotionAddingHitpoints() {
		testHero.addHealingPotion();
		testHero.drinkHealingPotion();
		
		assertTrue(testHero.getHitPoints() > 125);
	}
}
