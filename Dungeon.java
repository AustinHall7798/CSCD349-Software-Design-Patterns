import java.util.Random;

public class Dungeon {
	Hero player;
	Room[][] roomArray = new Room[5][5];
	int x = 0;
	int y = 0;
	Room entrance = roomArray[0][0];
	Room exit = roomArray[4][4];
	Random rand = new Random();
	
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
			roomArray[rand.nextInt(4)][rand.nextInt(4)].setPillar(AbstractionPillar.createPillar());
			roomArray[rand.nextInt(4)][rand.nextInt(4)].setPillar(InheritancePillar.createPillar());
			roomArray[rand.nextInt(4)][rand.nextInt(4)].setPillar(PolymorphismPillar.createPillar());
			roomArray[rand.nextInt(4)][rand.nextInt(4)].setPillar(EncapsulationPillar.createPillar());
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getArrayWidth() {
		return this.roomArray[0].length;
	}
	
	public int getArrayHeight() {
		return this.roomArray.length;
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
}