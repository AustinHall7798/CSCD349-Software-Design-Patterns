
public class CrushingBlow implements AttackInterface {
	DungeonCharacter player;
	DungeonCharacter opponent;

	public CrushingBlow(DungeonCharacter player, DungeonCharacter opponent) {
		this.player = player;
		this.opponent = opponent;

		attack(opponent);
	}

	
	public void attack(DungeonCharacter opponent) {
			if (Math.random() <= .4) {
				int blowPoints = (int)(Math.random() * 76) + 100;
				System.out.println(player.name + " lands a CRUSHING BLOW for " + blowPoints
									+ " damage!");
				opponent.subtractHitPoints(blowPoints);
			}//end blow succeeded
			else {
				System.out.println(player.name + " failed to land a crushing blow");
				System.out.println();
			}//blow failed

		}

}
