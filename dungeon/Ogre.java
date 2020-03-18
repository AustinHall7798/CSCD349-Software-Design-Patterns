package dungeon;
public class Ogre extends Monster {
	
	private final static String name = "Oscar the Ogre";
	private final static int hitPoints = 200;
	private final static int attackSpeed = 2;
	private final static double chanceToHit = .6;
	private final static double chanceToHeal = .1;
	private final static int damageMin = 30;
	private final static int damageMax = 50;
	private final static int minHeal = 30;
	private final static int maxHeal = 50;
	
    public Ogre() {
    	super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
    }//end constructor

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " slowly swings a club toward's " + opponent.getName() + ":");
		AttackFlyweightPool.getAttack(AttackName.STANDARD, this, opponent);
	}//end override of attack
}//end Monster class