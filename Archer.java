/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

import java.util.Scanner;


public class Archer extends Hero implements Attack
{
	
	private Scanner scan = new Scanner(System.in);
	private final static String name = "Archer";
	private final static int hitPoints = 75;
	private final static int attackSpeed = 10;
	private final static double chanceToHit = .95;
	private final static int damageMin = 20;
	private final static int damageMax = 45;
	private final static double chanceToBlock = .15;
	
    public Archer() {
    	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);
    }


  	public void DoubleShot(DungeonCharacter opponent) {
		AttackFlyweightPool.getAttack(AttackName.DOUBLESHOT, this, opponent);
	}
	


	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " fires his bow at " +
							opponent.getName() + ":");
		AttackFlyweightPool.getAttack(AttackName.STANDARD, this, opponent);
	}

    public void battleChoices(DungeonCharacter opponent) {
		int choice;

		super.battleChoices(opponent);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Double Shot");
		    System.out.print("Choose an option: ");
		 
		    choice = scan.nextInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: DoubleShot(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }

}