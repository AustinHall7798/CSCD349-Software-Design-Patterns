/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

import java.util.Scanner;

public class Warrior extends Hero implements Attack {
	
	private Scanner scan = new Scanner(System.in);
	
	private final static String name = "Warrior";
	private final static int hitPoints = 125;
	private final static int attackSpeed = 4;
	private final static double chanceToHit = .8;
	private final static int damageMin = 35;
	private final static int damageMax = 60;
	private final static double chanceToBlock = .2;

	public Warrior() {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);
	}// end constructor

	public void crushingBlow(DungeonCharacter opponent) {
		AttackFlyweightPool.getAttack("crushingBlow", this, opponent);
	}// end crushingBlow method

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " swings a mighty sword at " + opponent.getName() + ":");
		AttackFlyweightPool.getAttack("standardattack", this, opponent);
	}// end override of attack method

	public void battleChoices(DungeonCharacter opponent) {
		int choice;

		super.battleChoices(opponent);

		do {
			System.out.println("1. Attack Opponent");
			System.out.println("2. Crushing Blow on Opponent");
			System.out.print("Choose an option: ");
			// REFACTOR 1
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				attack(opponent);
				break;
			case 2:
				crushingBlow(opponent);
				break;
			default:
				System.out.println("invalid choice!");
			}// end switch

			numTurns--;
			if (numTurns > 0) {
				System.out.println("Number of turns remaining is: " + numTurns);
			}

		} while (numTurns > 0);

	}// end battleChoices method

}// end Hero class