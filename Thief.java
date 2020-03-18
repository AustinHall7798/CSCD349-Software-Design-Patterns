import java.util.Scanner;

public class Thief extends Hero {
	private Scanner scan = new Scanner(System.in);
	
	private final static String name = "Thief";
	private final static int hitPoints = 75;
	private final static int attackSpeed = 6;
	private final static double chanceToHit = .8;
	private final static int damageMin = 20;
	private final static int damageMax = 40;
	private final static double chanceToBlock = .5;

	public Thief() {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);
	}// end constructor

	public void surpriseAttack(DungeonCharacter opponent) {
		AttackFlyweightPool.getAttack(AttackName.SURPRISEATTACK, this, opponent);
	}// end surpriseAttack method
	
	@Override
	public void attack(DungeonCharacter opponent) {
		AttackFlyweightPool.getAttack(AttackName.STANDARD, this, opponent);
	}
	
	public void battleChoices(DungeonCharacter opponent) {
		super.battleChoices(opponent);
		int choice = 0;

		do {
			System.out.println("1. Attack Opponent");
			System.out.println("2. Surprise Attack");
			System.out.print("Choose an option: ");

			while(choice != 1 && choice != 2) {
				try {
					choice = scan.nextInt();
					scan.nextLine();
				} catch(Exception e) {
					System.out.println("Invalid Input. Try again.");
					choice = 0;
					scan.nextLine();
				}
			}

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
