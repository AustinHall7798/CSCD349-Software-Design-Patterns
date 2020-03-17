/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

import java.util.Scanner;

public class Bard extends Hero implements Attack{
	
	private Scanner scan = new Scanner(System.in);

    public Bard() {
    	super("Bard", 100, 5, .6, 5, 20, .15);
    }

	public void playMelody(DungeonCharacter opponent) {
		AttackFlyweightPool.getAttack("playmelody", this, opponent);
	}

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " launches his instrument at " +
							opponent.getName() + ":");
		new StandardAttack(this, opponent);
	}

    public void battleChoices(DungeonCharacter opponent) {
		int choice;

		super.battleChoices(opponent);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Play Melody");
		    System.out.print("Choose an option: ");
		 
		    choice = scan.nextInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: playMelody(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }

}