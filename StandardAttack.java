
public class StandardAttack implements Attack {
	DungeonCharacter player;
	DungeonCharacter opponent;

	public StandardAttack(DungeonCharacter player, DungeonCharacter opponent) {
		this.player = player;
		this.opponent = opponent;

		attack(opponent);
	}

	public void attack(DungeonCharacter opponent) {
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= player.getChanceToHit();

		if (canAttack) {
			damage = (int) (Math.random() * (player.getDamageMax() - player.getDamageMin() + 1)) + player.getDamageMin();
			opponent.subtractHitPoints(damage);

			System.out.println();
		} else {

			System.out.println(player.getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		} // end else

	}

}
