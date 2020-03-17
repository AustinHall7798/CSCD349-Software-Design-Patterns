import java.util.Random;

public class HealingPotion {

	Random rand = new Random();
	DungeonCharacter healTarget;
	int healAmount;
	
	public HealingPotion(DungeonCharacter healTarget) {
		this.healTarget = healTarget;
		generatePotion();
		this.healTarget.addHitPoints(healAmount);
	}
	
	private void generatePotion() {
		healAmount = (int) rand.nextInt(10) + 5;
	}
}
