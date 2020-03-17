

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster {
	
	private final static String name = "Sargath the Skeleton";
	private final static int hitPoints = 100;
	private final static int attackSpeed = 3;
	private final static double chanceToHit = .8;
	private final static double chanceToHeal = .3;
	private final static int damageMin = 30;
	private final static int damageMax = 50;
	private final static int minHeal = 30;
	private final static int maxHeal = 50;

    public Skeleton() {
    	super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
    }//end constructor

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " slices his rusty blade at " + opponent.getName() + ":");
		AttackFlyweightPool.getAttack(AttackName.STANDARD, this, opponent);
	}//end override of attack
}//end class Skeleton