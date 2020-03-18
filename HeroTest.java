import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeroTest {
	
	Hero testHero;
	
	@BeforeEach
	public void setup() throws Exception {
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
		
		testHero.addVisionPotion();
		assertEquals(1, testHero.getVisionPotionCount());
		
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
