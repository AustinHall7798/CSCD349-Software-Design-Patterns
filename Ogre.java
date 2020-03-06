/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Ogre extends Monster {
    public Ogre() {
		super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
    }

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " slowly swings a club toward's " + opponent.getName() + ":");
		super.attack(opponent);
	}
}