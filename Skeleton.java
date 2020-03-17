public class Skeleton extends Monster {
    public Skeleton() {
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
    }//end constructor

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " slices his rusty blade at " + opponent.getName() + ":");
		new StandardAttack(this, opponent);
	}//end override of attack
}//end class Skeleton