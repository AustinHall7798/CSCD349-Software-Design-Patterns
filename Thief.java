import java.util.Scanner;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Thief extends Hero {
	private Scanner scan = new Scanner(System.in);

	public Thief() {
		super("Thief", 75, 6, .8, 20, 40, .5);
	}// end constructor

	public void surpriseAttack(DungeonCharacter opponent) {
		AttackFlyweightPool.getAttack("surpriseattack", this, opponent);
	}// end surpriseAttack method
	
	@Override
	public void attack(DungeonCharacter opponent) {
		AttackFlyweightPool.getAttack("standardattack", this, opponent);
	}

	public void battleChoices(DungeonCharacter opponent) {
		super.battleChoices(opponent);
		int choice;

		do {
			System.out.println("1. Attack Opponent");
			System.out.println("2. Surprise Attack");
			System.out.print("Choose an option: ");

			choice = scan.nextInt();

			switch (choice) {
			case 1:
				attack(opponent);
				break;
			case 2:
				surpriseAttack(opponent);
				break;
			default:
				System.out.println("invalid choice!");
			}// end switch

			numTurns--;
			if (numTurns > 0) {
				System.out.println("Number of turns remaining is: " + numTurns);
			}
		} while (numTurns > 0);
	}


}
