public abstract class Monster extends DungeonCharacter {
	protected double chanceToHeal;
	protected int minHeal, maxHeal;

	public Monster(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin, int damageMax, int minHeal, int maxHeal) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
	}// end monster constructor

	public void heal() {
		int healPoints;

		if (canHeal()) {
			healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
			addHitPoints(healPoints);
			System.out.println(getName() + " healed itself for " + healPoints + " points.\n"
					+ "Total hit points remaining are: " + getHitPoints());
			System.out.println();
		} // end can heal
	}// end heal method

	public void subtractHitPoints(int hitPoints) {
		super.subtractHitPoints(hitPoints);
		heal();
	}// end subtractHitPoints method
	
	private boolean canHeal() {
		return (Math.random() <= chanceToHeal) && (getHitPoints() > 0);
	}
}// end Monster class