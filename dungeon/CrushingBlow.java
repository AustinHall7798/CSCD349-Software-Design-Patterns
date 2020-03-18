package dungeon;
public class CrushingBlow implements Attack {
	DungeonCharacter player;
	DungeonCharacter opponent;

	public CrushingBlow(DungeonCharacter player, DungeonCharacter opponent) {
		this.player = player;
		this.opponent = opponent;

		attack(opponent);
	}

	public void attack(DungeonCharacter opponent) {
		if (Math.random() <= .4) {
			int blowPoints = (int) (Math.random() * 76) + 100;
			System.out.println(player.getName() + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			opponent.subtractHitPoints(blowPoints);
		} else {
			System.out.println(player.getName() + " failed to land a crushing blow");
			System.out.println();
		} // blow failed
	}
}
