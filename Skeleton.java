

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster implements AttackInterface {
    public Skeleton() {
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
    }//end constructor

	public void attack(DungeonCharacter opponent) {
		System.out.println(name + " slices his rusty blade at " +
							opponent.getName() + ":");
		new StandardAttack(this, opponent);
	}//end override of attack
}//end class Skeleton