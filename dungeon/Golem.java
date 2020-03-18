package dungeon;
public class Golem extends Monster {
	
	private final static String name = "Dwayne the Rock Golem";
	private final static int hitPoints = 120;
	private final static int attackSpeed = 2;
	private final static double chanceToHit = .8;
	private final static double chanceToHeal = .7;
	private final static int damageMin = 30;
	private final static int damageMax = 65;
	private final static int minHeal = 20;
	private final static int maxHeal = 35;
	
    public Golem() {
    	super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
    }//end constructor

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " swings at " + opponent.getName() + ":");
		AttackFlyweightPool.getAttack(AttackName.STANDARD, this, opponent);
	}
}