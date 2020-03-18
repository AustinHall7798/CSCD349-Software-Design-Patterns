package dungeon;

public class EncapsulationPillar extends Pillar {
	private String pillarType;
	private static EncapsulationPillar pillar;

	private EncapsulationPillar(String type) {
		this.pillarType = type;
	}

	public static EncapsulationPillar createPillar() {
		if (pillar == null) {
			pillar = new EncapsulationPillar("Encapsulation");
			return pillar;
		} else {
			return pillar;
		}
	}
	
	public String getType() {
		return this.pillarType;
	}
}