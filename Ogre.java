public class Ogre extends Monster {
    public Ogre() {
		super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
    }//end constructor

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " slowly swings a club toward's " + opponent.getName() + ":");
		new StandardAttack(this, opponent);
	}//end override of attack
}//end Monster class