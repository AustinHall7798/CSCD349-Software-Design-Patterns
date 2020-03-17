public class GiantSpider extends Monster {
	
	private final static String name = "Fluffy the giant spider";
	private final static int hitPoints = 35;
	private final static int attackSpeed = 10;
	private final static double chanceToHit = 1;
	private final static double chanceToHeal = .2;
	private final static int damageMin = 5;
	private final static int damageMax = 10;
	private final static int minHeal = 10;
	private final static int maxHeal = 25;
	
    public GiantSpider() {
		super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
    }

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " bites at " + opponent.getName() + ":");
		AttackFlyweightPool.getAttack(AttackName.STANDARD, this, opponent);
	}
}