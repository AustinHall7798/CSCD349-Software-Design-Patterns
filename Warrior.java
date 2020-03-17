import java.util.Scanner;

public class Warrior extends Hero implements Attack {
	
	private Scanner scan = new Scanner(System.in);

	public Warrior() {
		super("Warrior", 125, 4, .8, 35, 60, .2);
	}

	public void crushingBlow(DungeonCharacter opponent) {
		new CrushingBlow(this, opponent);
	}// end crushingBlow method

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " swings a mighty sword at " + opponent.getName() + ":");
		new StandardAttack(this, opponent);
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