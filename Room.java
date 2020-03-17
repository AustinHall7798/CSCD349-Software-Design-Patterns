import java.util.Random;

public class Room {

	private int healingPotionCount;
	private int visionPotionCount;
	private int pitCount;
	private int pillarCount;
	private int monsterCount;
	private Pillar pillar;
	private Room[][] roomArray = new Room[5][5];
	private int x, y;
	private String currentObject;
	private Random rand = new Random();

	public Room(DungeonCharacter player, int x, int y) {
		this.x = x;
		this.y = y;
		if (rand.nextInt(100) < 20) {
			this.pitCount++;
			this.currentObject = "P";
		}
		if (rand.nextInt(100) < 20) {
			this.healingPotionCount = 1;
			this.currentObject = "H";
		}
		if (rand.nextInt(100) < 20) {
			this.visionPotionCount = 1;
			this.currentObject = "V";
		}
		if (rand.nextInt(100) < 20) {
			this.monsterCount++;
			this.currentObject = "X";
		}
		if (this.currentObject == null) {
			this.currentObject = "E";
		}
		if (this.monsterCount + this.healingPotionCount + this.pillarCount + this.pitCount
				+ this.visionPotionCount > 1) {
			this.currentObject = "M";
		}
	}

	public boolean setPillar(Pillar pillar) {
		if (pillarCount > 0 || (x == 0 && y == 0) || (x == 4 && y == 4)) {
			return false;
		}
		this.pillar = pillar;
		this.pillarCount++;
		return true;

	}

	public Pillar getPillar() {
		return this.pillar;
	}

	public int getHealingPotionCount() {
		return healingPotionCount;
	}

	public void setHealingPotionCount(int healingPotionCount) {
		this.healingPotionCount = healingPotionCount;
	}

	public int getVisionPotionCount() {
		return visionPotionCount;
	}

	public void setVisionPotionCount(int visionPotionCount) {
		this.visionPotionCount = visionPotionCount;
	}

	public int getPitCount() {
		return pitCount;
	}

	public void setPitCount(int pitCount) {
		this.pitCount = pitCount;
	}

	public int getPillarCount() {
		return pillarCount;
	}

	public void setPillarCount(int pillarCount) {
		this.pillarCount = pillarCount;
	}

	public int getMonsterCount() {
		return monsterCount;
	}

	public void setMonsterCount(int monsterCount) {
		this.monsterCount = monsterCount;
	}

	public Room enterRoom(int x, int y) {
		return roomArray[x][y];
	}

	public String toString() {
		if (x == 0 && y == 0) {
			return "* * *\n* I |\n* - *\n";
		} else if (x == roomArray.length - 1 && y == roomArray[0].length - 1) {
			return "* - *\n| O *\n* * *\n";
		} else if (x == roomArray.length - 1 && y == 0) {
			return "* - *\n* " + currentObject + " |\n* * *\n";
		} else if (x == roomArray.length - 1) {
			return "* - *\n| " + currentObject + " |\n* * *\n";
		} else if (y == roomArray[0].length - 1) {
			return "* - *\n* " + currentObject + " *\n* - *\n";
		} else if (x == 0) {
			return "* * *\n| " + currentObject + " |\n* - *\n";
		} else if (y == 0) {
			return "* - *\n* " + currentObject + " |\n* - *\n";
		} else {
			return "* - *\n| " + currentObject + " |\n* - *\n";
		}
	}
}
