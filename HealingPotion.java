import java.util.Random;

public class HealingPotion {

	Random rand = new Random();
	DungeonCharacter healTarget;
	int healAmount;
	
	public HealingPotion(DungeonCharacter healTarget) {
		this.healTarget = healTarget;
	}
	
	private void generatePotion() {
		healAmount = (int) rand.nextInt(10) + 5;
	}
	
	public void drinkHealingPotion() {
		generatePotion();
		this.healTarget.addHitPoints(healAmount);
	}
}
