public class DoubleShot implements Attack {
	DungeonCharacter player;
	DungeonCharacter opponent;

	public DoubleShot(DungeonCharacter player, DungeonCharacter opponent) {
		this.player = player;
		this.opponent = opponent;

		doubleShot(opponent);
	}

	 public void doubleShot(DungeonCharacter opponent) {
		for(int i = 0 ; i < 2 ; i++) {
				if(!opponent.isAlive()) {
					break;
				}
			if (Math.random() <= .8) { //shot succeeded
				attack(opponent); 
			} else { //shot failed
				System.out.println(player.getName() + " failed to land a double shot");
				System.out.println();
			}
		}
	}

	@Override
	public void attack(DungeonCharacter opponent) {
		new StandardAttack(player, opponent);
	}
}