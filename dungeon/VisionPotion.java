package dungeon;

public class VisionPotion {
	private Dungeon dungeon;
	private int x, y;
	private String[] lines;
	private String bigString = "";
	public VisionPotion(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	public void drinkPotion() {
		this.x = dungeon.getX();
		this.y = dungeon.getY();
		bigString = "";
		if(x - 1 >= 0 && y - 1 >= 0) {
			bigString += dungeon.getSpecificRoom(x - 1, y - 1).toString();
		}
		if(x - 1 >= 0) {
			bigString += dungeon.getSpecificRoom(x - 1, y).toString();
		}
		if(x - 1 >= 0 && y + 1 <= dungeon.getArrayWidth() - 1) {
			bigString += dungeon.getSpecificRoom(x - 1, y + 1).toString();
		}
		if(y - 1 >= 0) {
			bigString += dungeon.getSpecificRoom(x, y - 1).toString();
		}
		
		bigString += dungeon.getSpecificRoom(x, y).toString();
		
		if(y + 1 <= dungeon.getArrayWidth() - 1) {
			bigString += dungeon.getSpecificRoom(x, y + 1).toString();
		}
		if(x + 1 <= dungeon.getArrayHeight() - 1 && y - 1 >= 0) {
			bigString += dungeon.getSpecificRoom(x + 1, y - 1).toString();
		}
		if(x + 1 <= dungeon.getArrayHeight() - 1) {
			bigString += dungeon.getSpecificRoom(x + 1, y).toString();
		}
		if(x + 1 <= dungeon.getArrayHeight() - 1 && y + 1 <= dungeon.getArrayWidth() - 1) {
			bigString += dungeon.getSpecificRoom(x + 1, y + 1).toString();
		}
		lines = bigString.split("\n");
		printVision();
	}
	
	private void printVision() {
		if(dungeon.getCurrentRoom().equals(dungeon.getEntrance())) {
			printHelper(0, 1, 2, 6, 7, 8);
			printHelper(6, 7, 8, lines.length, lines.length, lines.length);
		} else if (y == 4 || y == 0 || x== 0){
			printHelper(0, 1, 2, 6, 7, 8);
			printHelper(6, 7, 8, 12, 13, 14);
			printHelper(12, 13, 14, lines.length, lines.length, lines.length);
		} else if (x == 4) {
			printHelper(0, 1, 2, 9, 10, 11);
			printHelper(9, 10, 11, lines.length, lines.length, lines.length);
		} else {
			printHelper(0, 1, 2, 9, 10, 11);
			printHelper(9, 10, 11, 18, 19, 20);
			printHelper(18, 19, 20, lines.length, lines.length, lines.length);
		}
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

}
