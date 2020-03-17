public class SupriseAttack implements Attack {
	Hero player;
	DungeonCharacter opponent;

	public SupriseAttack(Hero player, DungeonCharacter opponent) {
		this.player = player;
		this.opponent = opponent;

		supriseAttack(opponent);
	}

	public void supriseAttack(DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + player.getName() + " gets an additional turn.");
			player.numTurns++;
			attack(opponent);
		} else if (surprise >= .9) {
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" + " blocked your attack!");
		} else {
			attack(opponent);
		}
	}

	@Override
	public void attack(DungeonCharacter opponent) {
		new StandardAttack(player, opponent);
	}

}