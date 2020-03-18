import java.util.Scanner;

/**
	Team Contributions:
		C. William Bafus:
			Summary
				Implemented Hero
				Implemented Factories
				Implemented DungeonAdventure
				
			Majority author the following classes:
				DungeonAdventure
				Hero
				HeroTest
				MonsterTest
				DungeonCharacterTest
				Hero Factory
				Monster Factory
				
			Assisting author of the following classes:
				Dungeon
				HealingPotion
			
			Miscellaneous
				Reviewed for code standards requirements
			
		Austin Hall:
			Summary
				Implemented Room
				Implemented Dungeon
				Implemented Strategy Pattern for Attacks
				
			Majority author the following classes:
				AbstractionPillar
				Attack (interface)
				Crushing Blow
				Dungeon
				EncapsulationPillar
				HealingPotion
				InheritancePillar
				Pillar
				Pit
				Polymorphism Pillar
				Room
				RoomTests
				StandardAttack
				SupriseAttack
				VisionPotion
				
			Assisting author of the following classes:

			Miscellaneous
				Hosted GitHub Project
				UML Diagram

		Michael Minka: 
			Summary
				Implemented additional Heroes/Monsters
				Implemented Flyweight
				
			Majority author the following classes:
				AttackFlyweightPool
				AttackName
				AttackTest
				Bard
				DoubleShot
				GiantSpider
				Golem
				MockDungeonCharacter
				PlayMelody
				
			Assisting author of the following classes:

			Miscellaneous
			
			
			
 */

public class DungeonAdventure {
	private static final String welcomeMessage = "Welcome to a Dungeon Adventure.\nYou'll take on the role of the wandering adventurer who happens upon the ruins of an ancient city.\nVenturing within, you'll find monsters, traps, and some helpful items.\nSearch the ruins for the four Pillars of OO to win the game.\n";
	
	private static Scanner scan = new Scanner(System.in);
	private static Hero theHero;
	private static Monster theMonster;
	private static Dungeon dungeon;

	public static void main(String[] args) {
		
		System.out.println(welcomeMessage);
		
		do {
			theHero = chooseHero();
			theMonster = generateMonster();
			dungeon = new Dungeon(theHero);
			
			while(theHero.getHitPoints() > 0 && theHero.getPillarsOfOOCount() <= 4) {
				if(theHero.getPillarsOfOOCount() == 4) {
					System.out.println("You've found all the Pillars of OO!");
					break;
				}
				
				printGameStatus(dungeon);
				executePlayerChoice(dungeon);
			}
			
			// TODO print entire dungeon
			
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

	private static void executePlayerChoice(Dungeon dungeon) {		
		System.out.println("Your Choice: ");
		
		int playerChoice = 0;
		while(playerChoice <= 0 || playerChoice >= 7 && playerChoice != 99) {
			try {
				playerChoice = scan.nextInt();
				scan.nextLine();
				System.out.println(playerChoice);
			} catch(Exception e) {
				System.out.println("HI");
				playerChoice = 0;
			}
		}
		
		if(playerChoice == 1) {
			dungeon.moveNorth();
		}else if(playerChoice == 2) {
			dungeon.moveEast();
		}else if(playerChoice == 3) {
			dungeon.moveSouth();
		}else if(playerChoice == 4) {
			dungeon.moveWest();
		}else if(playerChoice == 5) {
			System.out.println(theHero.toString());
		}else if(playerChoice == 6) {
			theHero.drinkHealingPotion();
		}else if(playerChoice == 7) {
			theHero.drinkVisionPotion();
		}else if(playerChoice == 8) {
			System.out.println("GoodBye...");
			System.exit(0);
		}else if(playerChoice == 99) {
			// TODO Hidden menu option: print whole dungeon
		}else {
			System.out.println("Unexpected Error. Closing.");
			System.exit(0);
		}
	}
	
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
	
	private static void printGameStatus(Dungeon dungeon) {
		System.out.println("\nYour Current Location...");
		
		System.out.println(dungeon.getCurrentRoom().toString());
		
		System.out.println("What would you like to do?");
		System.out.println("1. Move North");
		System.out.println("2. Move East");
		System.out.println("3. Move South");
		System.out.println("4. Move West");
		System.out.println("5. Print Hero Info");
		System.out.println("6. Drink Healing Potion");
		System.out.println("7. Drink Vision Potion");
		System.out.println("8. Exit Game");
	}
}// end Dungeon class