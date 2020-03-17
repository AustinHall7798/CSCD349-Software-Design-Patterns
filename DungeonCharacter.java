/**
 * Title: DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a role playing
 * game
 *
 * class variables (all will NOT be directly accessible from derived classes):
 * name (name of character) hitPoints (points of damage a character can take
 * before killed) attackSpeed (how fast the character can attack) chanceToHit
 * (chance an attack will strike the opponent) damageMin, damageMax (range of
 * damage the character can inflict on opponent)
 *
 * class methods (all are directly accessible by derived classes):
 * DungeonCharacter(String name, int hitPoints, int attackSpeed, double
 * chanceToHit, int damageMin, int damageMax) public String getName() public int
 * getHitPoints() public int getAttackSpeed() public void addHitPoints(int
 * hitPoints) public void subtractHitPoints(int hitPoints) -- this method will
 * be overridden public boolean isAlive() public void attack(DungeonCharacter
 * opponent) -- this method will be overridden
 *
 * Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public abstract class DungeonCharacter implements Attack {
	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;

	public DungeonCharacter(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
	}// end constructor

	public String getName() {
		return name;
	}// end getName

	public void setName(String name) {
		this.name = name;
	}

	public int getHitPoints() {
		return hitPoints;
	}// end getHitPoints

	public int getAttackSpeed() {
		return attackSpeed;
	}// end getAttackSpeed

	public double getChanceToHit() {
		return chanceToHit;
	}

	public int getDamageMin() {
		return damageMin;
	}

	public int getDamageMax() {
		return damageMax;
	}

	// addHitPoints is used to increment the hitpoints a dungeon character has
	public void addHitPoints(int hitPoints) {
		if (hitPoints <= 0)
			System.out.println("Hitpoint amount must be positive.");
		else {
			this.hitPoints += hitPoints;
		}
	}// end addHitPoints method

	// subtractHitPoints is used to decrement the hitpoints a dungeon character has.
	public void subtractHitPoints(int hitPoints) {
		if (hitPoints < 0) {
			System.out.println("Hitpoint amount must be positive.");
		} else if (hitPoints > 0) {
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			printDamageTaken(hitPoints);
			printRemainingHealth();

			System.out.println();
		} // end else if

		if (this.hitPoints == 0) {
			System.out.println(name + " has been killed :-(");
		}
	}// end method

	// isAlive is used to see if a character is still alive by checking hit points
	public boolean isAlive() {
		return (hitPoints > 0);
	}// end isAlive method

	private void printDamageTaken(int hitPoints) {
		System.out.println(getName() + " hit " + "for <" + hitPoints + "> points damage.");
	}

	private void printRemainingHealth() {
		System.out.println(getName() + " now has " + getHitPoints() + " hit points remaining.");
	}
}// end class Character