public class PlayMelody implements Attack {
	DungeonCharacter player;
	DungeonCharacter opponent;

	public PlayMelody(DungeonCharacter player, DungeonCharacter opponent) {
		this.player = player;
		this.opponent = opponent;

		playMelody(opponent);
	}

	 public void playMelody(DungeonCharacter opponent) {
		 System.out.println(player.getName() + " plays a sultry melody for " + opponent.getName() + ":");
	}

	@Override
	public void attack(DungeonCharacter opponent) {

	}

}