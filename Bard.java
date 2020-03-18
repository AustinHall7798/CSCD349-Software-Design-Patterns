import java.util.Scanner;

public class Bard extends Hero implements Attack {
	
	private Scanner scan = new Scanner(System.in);
	
	private final static String name = "Bard";
	private final static int hitPoints = 100;
	private final static int attackSpeed = 5;
	private final static double chanceToHit = .6;
	private final static int damageMin = 5;
	private final static int damageMax = 20;
	private final static double chanceToBlock = .15;

    public Bard() {
    	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);
    }

	public void playMelody(DungeonCharacter opponent) {
		AttackFlyweightPool.getAttack(AttackName.PLAYMELODY, this, opponent);
	}

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " launches his instrument at " + opponent.getName() + ":");
		AttackFlyweightPool.getAttack(AttackName.PLAYMELODY, this, opponent);
	}

    public void battleChoices(DungeonCharacter opponent) {
		super.battleChoices(opponent);
		int choice = 0;

		do {
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Play Melody");
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
			    case 1: attack(opponent);
			        break;
			    case 2: playMelody(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }

			numTurns--;
			if (numTurns > 0) {
			    System.out.println("Number of turns remaining is: " + numTurns);
			}

		} while(numTurns > 0);
    }
}