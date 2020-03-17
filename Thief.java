import java.util.Scanner;

public class Thief extends Hero {
	private Scanner scan = new Scanner(System.in);

	public Thief() {
		super("Thief", 75, 6, .8, 20, 40, .5);
	}

	public void surpriseAttack(DungeonCharacter opponent) {
		new SupriseAttack(this, opponent);
	}// end surpriseAttack method

	@Override
	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " attacks from the shadows against " + opponent.getName() + ":");
		new StandardAttack(this, opponent);
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
