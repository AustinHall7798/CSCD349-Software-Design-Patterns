import java.util.Scanner;

/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright: Copyright (c) 2001 Company: Code Dogs Inc. I.M. Knurdy
 *
 * History: 11/4/2001: Wrote program --created DungeonCharacter class --created
 * Hero class --created Monster class --had Hero battle Monster --fixed attack
 * quirks (dead monster can no longer attack) --made Hero and Monster abstract
 * --created Warrior --created Ogre --made Warrior and Ogre battle --added
 * battleChoices to Hero --added special skill to Warrior --made Warrior and
 * Ogre battle --created Sorceress --created Thief --created Skeleton --created
 * Gremlin --added game play features to Dungeon.java (this file) 11/27/2001:
 * Finished documenting program version 1.0
 */

/*
 * This class is the driver file for the Heroes and Monsters project. It will do
 * the following:
 * 
 * 1. Allow the user to choose a hero 2. Randomly select a monster 3. Allow the
 * hero to battle the monster
 * 
 * Once a battle concludes, the user has the option of repeating the above
 * 
 */
public class DungeonAdventure {

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

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");

		choice = scan.nextInt();

		switch (choice) {
		case 1:
			return HeroFactory.createWarrior();
		case 2:
			return HeroFactory.createSorceress();
		case 3:
			return HeroFactory.createThief();
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

		choice = (int) (Math.random() * 3) + 1;

		switch (choice) {
		case 1:
			return MonsterFactory.createOgre();

		case 2:
			return MonsterFactory.createGremlin();

		case 3:
			return MonsterFactory.createSkeleton();

		default:
			System.out.println("invalid choice, returning Skeleton");
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

	public static void battle(Hero theHero) {
		battle(theHero, generateMonster());
	}
	
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