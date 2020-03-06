
public class StandardAttack implements AttackInterface {
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

		canAttack = Math.random() <= player.chanceToHit;

		if (canAttack) {
			damage = (int) (Math.random() * (player.damageMax - player.damageMin + 1)) + player.damageMin;
			opponent.subtractHitPoints(damage);

			System.out.println();
		} // end if can attack
		else {

			System.out.println(player.getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		} // end else

	}

}
