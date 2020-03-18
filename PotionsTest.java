import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PotionsTest {
	
	HealingPotion healingPotion;
	VisionPotion visionPotion;
	
	@BeforeAll
	public void setup() throws Exception {
		healingPotion = new HealingPotion();
		visionPotion = new VisionPotion(new Dungeon(HeroFactory.createWarrior()));
	}
	
	@Test
	public void testHealingPotionHealValue() {
		assertTrue(healingPotion.getHealingPotionHealthValue() >= 5 && healingPotion.getHealingPotionHealthValue() <= 15);
	}
}
