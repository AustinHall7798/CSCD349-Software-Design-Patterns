import java.util.Scanner;

public class Sorceress extends Hero implements Attack {
	
	private Scanner scan = new Scanner(System.in);

	public final int minHealValue = 25;
	public final int maxHealValue = 50;

	public Sorceress() {
		super("Sorceress", 75, 5, .7, 25, 50, .3);
	}

	public void castHeal() {
		int hPoints;

		hPoints = (int) (Math.random() * (maxHealValue - minHealValue + 1)) + minHealValue;
		addHitPoints(hPoints);
		System.out.println(getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + getHitPoints());
		System.out.println();
	}// end increaseHitPoints method

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " casts a spell of fireball at " + opponent.getName() + ":");
		new StandardAttack(this, opponent);
	}// end override of attack method

	public void battleChoices(DungeonCharacter opponent) {
		super.battleChoices(opponent);
		int choice;

		do {
			System.out.println("1. Attack Opponent");
			System.out.println("2. Cast Healing Spell");
			System.out.print("Choose an option: ");
			
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				attack(opponent);
				break;
			case 2:
				castHeal();
				break;
			default:
				System.out.println("invalid choice!");
			}// end switch

			numTurns--;
			if (numTurns > 0) {
				System.out.println("Number of turns remaining is: " + numTurns);
			}
		} while (numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);
	}// end overridden method
}// end class