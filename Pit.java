import java.util.Random;

public class Pit {
	Random rand = new Random();
	DungeonCharacter pitTarget;
	private int damageAmount;
	
	public Pit(DungeonCharacter pitTarget) {
		this.pitTarget = pitTarget;
		generatePitDamage();
		this.pitTarget.subtractHitPoints(damageAmount);;
	}
	
	private void generatePitDamage() {
		damageAmount = (int) rand.nextInt(19) + 1;
	}
}
