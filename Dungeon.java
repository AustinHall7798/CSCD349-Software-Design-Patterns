import java.util.Random;

public class Dungeon {
	private int healingPotionCount;
	private int visionPotionCount;
	private int pitCount;
	private int pillarCount;
	private int monsterCount;
	private Hero player;
	private Pit pit;
	private Room[][] roomArray = new Room[5][5];
	private Room entrance = roomArray[0][0];
	private int x = 0;
	private int y = 0;
	private Random rand = new Random();
	private HealingPotion healPotion;
	private String[] lines;
	private String bigString = "";
	
	public Dungeon(Hero player) {
		this.player = player;
		this.pit = new Pit(player);
		this.healPotion = new HealingPotion(player);
		createDungeon();
	}
	
	private void createDungeon() {
		for(int i = 0; i < roomArray.length; i++) {
			for(int j = 0; j < roomArray[i].length; j++) {
				roomArray[i][j] = new Room(player, i, j);
			}
		}
			while(roomArray[rand.nextInt(4)][rand.nextInt(4)].setPillar(AbstractionPillar.createPillar()) != true);
			while(roomArray[rand.nextInt(4)][rand.nextInt(4)].setPillar(InheritancePillar.createPillar()) != true);
			while(roomArray[rand.nextInt(4)][rand.nextInt(4)].setPillar(PolymorphismPillar.createPillar()) != true);
			while(roomArray[rand.nextInt(4)][rand.nextInt(4)].setPillar(EncapsulationPillar.createPillar()) != true);
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Room getEntrance() {
		return entrance;
	}
	
	public int getArrayWidth() {
		return roomArray[0].length;
	}
	
	public int getArrayHeight() {
		return roomArray.length;
	}
	
	public Room getCurrentRoom() {
		return roomArray[this.x][this.y];
	}
	
	public Room getSpecificRoom(int x, int y) {
		return roomArray[x][y];
	}
	
	public void moveNorth() {
		if(getX() == 0) {
			System.out.println("Not able to move north");
		} else {
			this.x -= 1;
		}
	}
	
	public void moveSouth() {
		if(getX() == roomArray[0].length - 1) {
			System.out.println("Not able to move south");
		} else {
			this.x += 1;
		}
	}
	
	public void moveWest() {
		if(getY() == 0) {
			System.out.println("Not able to move west");
		} else {
			this.y -= 1;
		}
	}
	
	public void moveEast() {
		if(getY() == roomArray.length - 1) {
			System.out.println("Not able to move east");
		} else {
			this.y += 1;
		}
	}
	
	public void checkRoom() {
		if(getCurrentRoom().getHealingPotionCount() > 0) {
			System.out.println("Found a healing potion, added to inventory");
			player.addHealingPotion();
			getCurrentRoom().setHealingPotionCount(0);;
		}
		if(getCurrentRoom().getVisionPotionCount() > 0) {
			System.out.println("Found a vision potion, added to inventory");
			player.addVisionPotion();
			getCurrentRoom().setVisionPotionCount(0);
		}
		if(getCurrentRoom().getPillarCount() > 0) {
			System.out.println("Player found the " + getCurrentRoom().getPillar().getType() + " pillar!");
			player.addPillarOfOO();
			getCurrentRoom().setPillarCount(0);
		}
		if(getCurrentRoom().getPitCount() > 0) {
			pit.fallInPit();
			getCurrentRoom().setPitCount(0);
			System.out.println("Player fell into a pit and took " + pit.getDamage() + " points of damage");
		}
		if(getCurrentRoom().getMonsterCount() > 0) {
			getCurrentRoom().setMonsterCount(0);
			DungeonAdventure.battle(player);
		}
	}
	
	public void printDungeon() {
		for(int i = 0; i < roomArray.length; i++) {
			for(int j = 0; j < roomArray[i].length; j++) {
				bigString += getSpecificRoom(i, j).toString();
			}
		}
		lines = bigString.split("\n");
		printHelper(0, 1, 2, 15, 16, 17);
		printHelper(15, 16, 17, 30, 31, 32);
		printHelper(30, 31, 32, 45, 46, 47);
		printHelper(45, 46, 47, 60, 61, 62);
		printHelper(60, 61, 62, lines.length, lines.length, lines.length);
	}
	
	private void printHelper(int a, int b, int c, int x, int y, int z) {
		for(int i = a; i < x; i += 3) {
			System.out.print(lines[i]);
		}
		System.out.println();
		for(int k = b; k < y; k += 3) {
			System.out.print(lines[k]);
		}
		System.out.println();
		for(int j = c; j < z; j += 3) {
			System.out.print(lines[j]);
		}
		System.out.println();
	}
	
	
	private void getDungeonInfo() {
		for(int i = 0; i < roomArray.length; i++) {
			for(int j = 0; j < roomArray[i].length; j++) {
				healingPotionCount += roomArray[i][j].getHealingPotionCount();
				visionPotionCount += roomArray[i][j].getVisionPotionCount();
				pitCount += roomArray[i][j].getPitCount();
				pillarCount += roomArray[i][j].getPillarCount();
				monsterCount += roomArray[i][j].getMonsterCount();
			}
		}
	}
	
	public String toString() {
		getDungeonInfo();
		return "This dungeon has " + this.healingPotionCount + " healing potions, " + this.visionPotionCount +
				" vision potions, " + this.pitCount + " pits. " + this.pillarCount + " pillars, " +
				" and " + this.monsterCount + " monsters left in it.";
	}
}