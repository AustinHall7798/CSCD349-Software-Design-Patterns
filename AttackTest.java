import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TEMP NOTE: This class is to contain all testing methods pertaining to any and all attacks
// This includes standardAttack, Attack, and all special attacks. (does not include heal)

public class AttackTest {

	MockDungeonCharacter testHero, testMonster;
	Attack attackTest;
	@BeforeEach
	public void setup() throws Exception {
		testHero = new MockDungeonCharacter();
		testMonster = new MockDungeonCharacter();

	}
	
	@Test
	public void testAttackPool() {
		//test to see if only x amount of attack objects were created
		assertEquals(0, AttackFlyweightPool.getTotalAttackObjectsMade());
		
		attackTest = AttackFlyweightPool.getAttack(AttackName.CRUSHINGBLOW, testHero, testMonster);
		
		assertEquals(1, AttackFlyweightPool.getTotalAttackObjectsMade());
		
		attackTest = AttackFlyweightPool.getAttack(AttackName.DOUBLESHOT, testHero, testMonster);
		
		assertEquals(2, AttackFlyweightPool.getTotalAttackObjectsMade());
		
		for(int i = 0 ; i < 100 ; i++)
		{
			attackTest = AttackFlyweightPool.getAttack(AttackName.STANDARD, testHero, testMonster);
		}

		assertEquals(3, AttackFlyweightPool.getTotalAttackObjectsMade());
		
	}
	
}
