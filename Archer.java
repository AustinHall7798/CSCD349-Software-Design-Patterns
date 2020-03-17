import java.util.Scanner;


public class Archer extends Hero implements Attack {
	
	private Scanner scan = new Scanner(System.in);

    public Archer() {
    	super("Archer", 75, 10, .95, 20, 45, .15);
    }

  	public void DoubleShot(DungeonCharacter opponent) {
		new DoubleShot(this, opponent);
	}// end DoubleShot method
	
	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " fires his bow at " + opponent.getName() + ":");
		new StandardAttack(this, opponent);
	}

    public void battleChoices(DungeonCharacter opponent) {
		int choice;

		super.battleChoices(opponent);

		do {
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Use Double Shot");
		    System.out.print("Choose an option: ");
		 
		    choice = scan.nextInt();

		    switch (choice) {
			    case 1: attack(opponent);
			        break;
			    case 2: DoubleShot(opponent);
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