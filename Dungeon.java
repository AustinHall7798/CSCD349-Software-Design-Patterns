import java.util.Random;

public class Dungeon {
	private int healingPotionCount;
	private int visionPotionCount;
	private int pitCount;
	private int pillarCount;
	private int monsterCount;
	private Hero player;
	private Room[][] roomArray = new Room[5][5];
	private Room entrance = roomArray[0][0];
	private int x = 0;
	private int y = 0;
	private Random rand = new Random();
	
	public Dungeon(Hero player) {
		this.player = player;
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