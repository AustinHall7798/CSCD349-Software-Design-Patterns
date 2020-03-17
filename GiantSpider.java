/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class GiantSpider extends Monster {
    public GiantSpider() {
		super("Fluffy the Giant Spider", 35, 10, 1, .2, 5, 20, 10, 25);
		
    }//end constructor

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " bites at " +
							opponent.getName() + ":");
		AttackFlyweightPool.getAttack("standardattack", this, opponent);
	}
}