/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Golem extends Monster {
    public Golem() {
		super("Dwayne the Rock Golem", 120, 2, .8, .7, 30, 65, 20, 35);
		
    }//end constructor

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " swings at " +
							opponent.getName() + ":");
		attack(opponent);
	}
}