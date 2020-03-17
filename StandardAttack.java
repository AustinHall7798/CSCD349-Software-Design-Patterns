
public class StandardAttack implements Attack {
	DungeonCharacter self;
	DungeonCharacter opponent;

	public StandardAttack(DungeonCharacter self, DungeonCharacter opponent) {
		this.self = self;
		this.opponent = opponent;
		
		attack(opponent);
	}

	public void attack(DungeonCharacter opponent) {
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= self.getChanceToHit();

		if (canAttack) {
			damage = (int) (Math.random() * (self.getDamageMax() - self.getDamageMin() + 1)) + self.getDamageMin();
			opponent.subtractHitPoints(damage);
			
			System.out.println();
		} else {

			System.out.println(self.getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		} // end else

	}
	

}
