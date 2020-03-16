
import java.util.Scanner;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes. It is derived
 * from DungeonCharacter. A Hero has battle choices: regular attack and a
 * special skill which is defined by the classes derived from Hero.
 *
 * class variables (all are directly accessible from derived classes):
 * chanceToBlock -- a hero has a chance to block an opponents attack numTurns --
 * if a hero is faster than opponent, their is a possibility for more than one
 * attack per round of battle
 *
 * class methods (all are public): public Hero(String name, int hitPoints, int
 * attackSpeed, double chanceToHit, int damageMin, int damageMax, double
 * chanceToBlock) public void readName() public boolean defend() public void
 * subtractHitPoints(int hitPoints) public void battleChoices(DungeonCharacter
 * opponent)
 * 
 * Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public abstract class Hero extends DungeonCharacter {
	protected double chanceToBlock;
	protected int numTurns;
	private Scanner scan = new Scanner(System.in);
	private int healingPotionCount = 0;
	private int visionPotionCount = 0;
	private int pillarsOfOOCount = 0;

	// calls base constructor and gets name of hero from user
	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, double chanceToBlock) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		readName();
	}

	// readName obtains a name for the hero from the user
	public void readName() {
		System.out.print("Enter the name of your Hero: ");
    
		setName(scan.next());
	}//end readName method

	// defend determines if hero blocks attack
	public boolean attemptToBlock() {
		return Math.random() <= chanceToBlock;
	}// end attemptToBlock method

	// This method overrides the method inherited from DungeonCharacter
	public void subtractHitPoints(int hitPoints) {
		if (attemptToBlock()) {
			System.out.println(getName() + " BLOCKED the attack!");
		} else {
			super.subtractHitPoints(hitPoints);
		}
	}// end method

	// battleChoices will be overridden in derived classes.
	public void battleChoices(DungeonCharacter opponent) {
		numTurns = getAttackSpeed() / opponent.getAttackSpeed();
		if (numTurns == 0) {
			numTurns++;
		}

		System.out.println("Number of turns this round is: " + numTurns);
	}//end battleChoices
	
	// Menu option call to print character info and inventory
	public String toString() {		
		String heroSheet = String.format("%s's Character Sheet:\nHitPoints: %d\nHealingPotions: %d\nVisionPotions: %d\nPillars of OO Found: %d", super.getName(), super.getHitPoints(), this.getHealingPotionCount(), this.getVisionPotionCount(), this.getPillarsOfOOCount());
		return heroSheet;
	}
	
	public int getHealingPotionCount() {
		return this.healingPotionCount;
	}
	
	public int getVisionPotionCount() {
		return this.visionPotionCount;
	}
	
	public int getPillarsOfOOCount() {
		return this.pillarsOfOOCount;
	}
	
	public void addHealingPotion() {
		healingPotionCount++;
	}
	
	public void addVisionPotion() {
		visionPotionCount++;
	}
	
	// Removes a healing potion from the Hero and increases hero's health
	public void drinkHealingPotion() {
		if(healingPotionCount > 0) {
			int minPotionRestore = 5;
			int maxPotionRestore = 15;
			
			int restoredHitPoints = (int)(Math.random() * (maxPotionRestore - minPotionRestore)) + minPotionRestore;
			super.addHitPoints(restoredHitPoints);
			
			healingPotionCount--;
		} else if(healingPotionCount == 0) {
			System.out.println("You don't have any Healing Potions");
		} else {
			System.out.println("Unexpected negative number.");
		}
	}
	
	public void drinkVisionPotion() {
		if(visionPotionCount > 0) {
			visionPotionCount--;
		} else if(visionPotionCount == 0) {
			System.out.println("You don't have any Vision Potions.");
		} else {
			System.out.println("Unexpected negative number.");
		}
	}
	
	public void addPillarOfOO() {
		pillarsOfOOCount++;
	}
}// end Hero class

