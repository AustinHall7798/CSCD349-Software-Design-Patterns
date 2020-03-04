
import java.util.Scanner;


/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public abstract class Hero extends DungeonCharacter {
	protected double chanceToBlock;
	protected int numTurns;
	// REFACTOR 1
	private Scanner scan = new Scanner(System.in);

	//calls base constructor and gets name of hero from user
	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, double chanceToBlock) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		readName();
	}

	//readName obtains a name for the hero from the user
	public void readName() {
		System.out.print("Enter character name: ");
    
		// REFACTOR 1
		name = scan.next();
	}//end readName method

	//defend determines if hero blocks attack
	public boolean defend()
	{
		return Math.random() <= chanceToBlock;
	}//end defend method

	//This method overrides the method inherited from DungeonCharacter
	public void subtractHitPoints(int hitPoints) {
		if (defend()) {
			System.out.println(name + " BLOCKED the attack!");
		}
		else {
			super.subtractHitPoints(hitPoints);
		}
	}//end method

	//battleChoices will be overridden in derived classes.
	public void battleChoices(DungeonCharacter opponent) {
	    numTurns = attackSpeed/opponent.getAttackSpeed();

		if (numTurns == 0) {
			numTurns++;
		}

		System.out.println("Number of turns this round is: " + numTurns);
	}//end battleChoices
}//end Hero class