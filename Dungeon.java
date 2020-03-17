import java.util.Scanner;

public class Dungeon {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Hero theHero;
		Monster theMonster;

		do {
			theHero = chooseHero();
			theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());
	}// end main method

	/*-------------------------------------------------------------------
	chooseHero allows the user to select a hero, creates that hero, and
	returns it.  It utilizes a polymorphic reference (Hero) to accomplish
	this task
	---------------------------------------------------------------------*/
	public static Hero chooseHero() {
		int choice;

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief\n" + "4. Archer\n" + "5. Bard");

		choice = scan.nextInt();

		switch (choice) {
		case 1:
			return HeroFactory.createWarrior();
		case 2:
			return HeroFactory.createSorceress();
		case 3:
			return HeroFactory.createThief();
		case 4:
			return HeroFactory.createArcher();
		case 5:
			return HeroFactory.createBard();
		default:
			System.out.println("invalid choice, returning Thief");
			return HeroFactory.createThief();
		}// end switch
	}// end chooseHero method

	/*-------------------------------------------------------------------
	generateMonster randomly selects a Monster and returns it.  It utilizes
	a polymorphic reference (Monster) to accomplish this task.
	---------------------------------------------------------------------*/
	private static Monster generateMonster() {
		int choice;

		choice = (int) (Math.random() * 5) + 1;

		switch (choice) {
		case 1:
			return MonsterFactory.createOgre();
		case 2:
			return MonsterFactory.createGremlin();
		case 3:
			return MonsterFactory.createSkeleton();
		case 4:
			return MonsterFactory.createGiantSpider();
		case 5:
			return MonsterFactory.createGolem();
		default:
			System.out.println("invalid choice. Choosing Skeleton.");
			return MonsterFactory.createSkeleton();
		}// end switch
	}// end generateMonster method

	/*-------------------------------------------------------------------
	playAgain allows gets choice from user to play another game.  It returns
	true if the user chooses to continue, false otherwise.
	---------------------------------------------------------------------*/

	private static boolean playAgain() {
		String again;

		System.out.println("Play again (y/n)?");
		again = scan.next();

		return (again.equalsIgnoreCase("Y"));
	}// end playAgain method

	/*-------------------------------------------------------------------
	battle is the actual combat portion of the game.  It requires a Hero
	and a Monster to be passed in.  Battle occurs in rounds.  The Hero
	goes first, then the Monster.  At the conclusion of each round, the
	user has the option of quitting.
	---------------------------------------------------------------------*/

	private static void battle(Hero theHero, Monster theMonster) {
		String pause = "p";

		System.out.println(theHero.getName() + " battles " + theMonster.getName());
		System.out.println("---------------------------------------------");

		// do battle

		while (theHero.isAlive() && theMonster.isAlive() && !pause.equalsIgnoreCase("Q")) {
			// hero goes first
			theHero.battleChoices(theMonster);

			// monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
				new StandardAttack(theMonster, theHero);

			// let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");

			pause = scan.next();
		} // end battle loop

		if (!theMonster.isAlive()) {
			System.out.println(theHero.getName() + " was victorious!");
		} else if (!theHero.isAlive()) {
			System.out.println(theHero.getName() + " was defeated :-(");
		} else { // both are alive so user quit the game
			System.out.println("Quitters never win ;-)");
		}
	}// end battle method
}// end Dungeon class