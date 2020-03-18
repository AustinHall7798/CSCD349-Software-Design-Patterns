package dungeon;
/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Gremlin extends Monster{
	
	private final static String name = "Gnarltooth the Gremlin";
	private final static int hitPoints = 70;
	private final static int attackSpeed = 5;
	private final static double chanceToHit = .8;
	private final static double chanceToHeal = .4;
	private final static int damageMin = 15;
	private final static int damageMax = 30;
	private final static int minHeal = 20;
	private final static int maxHeal = 40;
	
    public Gremlin() {
    	super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
    }

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " jabs his kris at " + opponent.getName() + ":");      
		AttackFlyweightPool.getAttack(AttackName.STANDARD, this, opponent);
	}//end override of attack
}//end class Gremlin