import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TEMP NOTE: This class is to contain all testing methods pertaining to any and all attacks
// This includes standardAttack, Attack, and all special attacks. (does not include heal)

public class AttackTest {

	Hero testHero;
	Monster testMonster;
	Attack attackTest;
	@BeforeEach
	public void setup() throws Exception {
		testHero = HeroFactory.createWarrior();
		testMonster = MonsterFactory.createGolem();
		 attackTest = AttackFlyweightPool.getAttack(AttackName.STANDARD, testHero, testMonster);
	}
	
	@Test
	public void testAttackPool() {
		//test to see if only 1 amount of attack objects were created
		assertEquals(1, AttackFlyweightPool.getTotalAttackObjectsMade());
		
		attackTest = AttackFlyweightPool.getAttack(AttackName.CRUSHINGBLOW, testHero, testMonster);
		assertEquals(2, AttackFlyweightPool.getTotalAttackObjectsMade());
	}
	
}
