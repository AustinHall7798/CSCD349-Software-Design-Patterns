/**
 * Title: DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a
 *              role playing game
 *
 *  class variables (all will NOT be directly accessible from derived classes):
 *    name (name of character)
 *    hitPoints (points of damage a character can take before killed)
 *    attackSpeed (how fast the character can attack)
 *    chanceToHit (chance an attack will strike the opponent)
 *    damageMin, damageMax (range of damage the character can inflict on
 *     opponent)
 *
 *  class methods (all are directly accessible by derived classes):
 *    DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	  public String getName()
	  public int getHitPoints()
	  public int getAttackSpeed()
	  public void addHitPoints(int hitPoints)
	  public void subtractHitPoints(int hitPoints) -- this method will be
	    overridden
	  public boolean isAlive()
	  public void attack(DungeonCharacter opponent) -- this method will be
	    overridden
 *
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class DungeonCharacter {
	
	//changed all of these from protected to private
	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;
  
	public DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax) {

		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getHitPoints() {
		return hitPoints;
	}
	
	public int getAttackSpeed() {
		return attackSpeed;
	}

	//addHitPoints is used to increment the hitpoints a dungeon character has
	public void addHitPoints(int hitPoints) {
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else {
			this.hitPoints += hitPoints;
		}
	}

	//subtractHitPoints is used to decrement the hitpoints a dungeon character has.
	public void subtractHitPoints(int hitPoints) {
		if (hitPoints <0) {
			System.out.println("Hitpoint amount must be positive.");
		}
		else if (hitPoints >0) {
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(getName() + " hit " +
								" for <" + hitPoints + "> points damage.");
			System.out.println(getName() + " now has " +
								getHitPoints() + " hit points remaining.");
			System.out.println();
		}

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");
	}


	//isAlive is used to see if a character is still alive by checking hit points
    public boolean isAlive() {
	  return (hitPoints > 0);
	}

	//attack allows character to attempt attack on opponent.  First, chance to hit
	//is considered.  If a hit can occur, then the damage is calculated based on
	//character's damage range.  This damage is then applied to the opponent.
	public void attack(DungeonCharacter opponent) {
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= chanceToHit;

		if (canAttack) {
			damage = (int)(Math.random() * (damageMax - damageMin + 1))
						+ damageMin ;
			opponent.subtractHitPoints(damage);

			System.out.println();
		}
		else {
			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}
	}

}