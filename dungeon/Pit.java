package dungeon;
import java.util.Random;

public class Pit {
	Random rand = new Random();
	DungeonCharacter pitTarget;
	private int damageAmount;
	
	public Pit(DungeonCharacter pitTarget) {
		this.pitTarget = pitTarget;
	}
	
	private void generatePitDamage() {
		damageAmount = (int) rand.nextInt(19) + 1;
	}
	
	public void fallInPit() {
		generatePitDamage();
		this.pitTarget.subtractHitPoints(damageAmount);
	}
	
	public int getDamage() {
		return damageAmount;
	}
}
