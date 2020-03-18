package dungeon;

public class AbstractionPillar extends Pillar {

	private String pillarType;
	private static AbstractionPillar pillar;

	private AbstractionPillar(String type) {
		this.pillarType = type;
	}

	public static AbstractionPillar createPillar() {
		if (pillar == null) {
			pillar = new AbstractionPillar("Abstraction");
			return pillar;
		} else {
			return pillar;
		}
	}
	
	public String getType() {
		return this.pillarType;
	}
}
