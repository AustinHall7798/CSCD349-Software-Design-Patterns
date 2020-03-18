package dungeon;
import java.util.*;

public abstract class Hero extends DungeonCharacter {
	protected double chanceToBlock;
	protected int numTurns;
	private Scanner scan = new Scanner(System.in);
	private ArrayList<HealingPotion> healingPotions = new ArrayList<HealingPotion>();
	private ArrayList<VisionPotion> visionPotions = new ArrayList<VisionPotion>();
	private ArrayList<Pillar> pillars = new ArrayList<Pillar>();

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
		String heroSheet = String.format("%s's Character Sheet:\nHitPoints: %d\nHealing Potions: %d\nVision Potions: %d\nPillars of OO Found: %d", super.getName(), super.getHitPoints(), this.getHealingPotionCount(), this.getVisionPotionCount(), this.getPillarsOfOOCount());
		return heroSheet;
	}
  
	public int getHealingPotionCount() {
		return healingPotions.size();
	}
	
	public int getVisionPotionCount() {
		return visionPotions.size();
	}
	
	public int getPillarsOfOOCount() {
		return pillars.size();
	}
	
	public void addHealingPotion() {
		healingPotions.add(new HealingPotion());
	}
	
	public void addVisionPotion(Dungeon dungeon) {
		visionPotions.add(new VisionPotion(dungeon));
	}
	
	public void addPillarOfOO(Pillar pillar) {
		pillars.add(pillar);
	}
  
	// Removes a healing potion from the Hero and increases hero's health
	public void drinkHealingPotion() {
		if(getHealingPotionCount() > 0) {
			super.addHitPoints(healingPotions.get(0).getHealingPotionHealthValue());
			System.out.println("You drink a healing potion. It restores " + healingPotions.get(0).getHealingPotionHealthValue() + " points of health.");
			System.out.println("You now have " + this.getHitPoints() + " hitpoints.");
			healingPotions.remove(0);
		} else if(getHealingPotionCount() == 0) {
			System.out.println("You don't have any Healing Potions");
		} else {
			System.out.println("Unexpected negative number.");
		}
	}
  
	public void drinkVisionPotion() {
		if(getHealingPotionCount() > 0) {
			visionPotions.get(0).drinkPotion();
			System.out.println("You drink a Vision Potion. It reveals the surrounding rooms.");
			visionPotions.remove(0);
		} else if(getHealingPotionCount() == 0) {
			System.out.println("You don't have any Vision Potions.");
		} else {
			System.out.println("Unexpected negative number.");
		}
	}
}// end Hero class
