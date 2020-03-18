public class HealingPotion {

	private int restoredHitPoints;
	private final int minPotionRestore = 5;
	private final int maxPotionRestore = 15;
	
	public HealingPotion() {

		this.restoredHitPoints = (int)(Math.random() * (maxPotionRestore - minPotionRestore)) + minPotionRestore;
	}
	
	public int getHealingPotionHealthValue() {
		return restoredHitPoints;
	}
	
}
