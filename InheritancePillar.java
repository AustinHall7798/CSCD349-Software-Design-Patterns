
public class InheritancePillar extends Pillar{
	private String pillarType;
	private static InheritancePillar pillar;

	private InheritancePillar(String type) {
		this.pillarType = type;
	}

	public static InheritancePillar createPillar() {
		if (pillar == null) {
			pillar = new InheritancePillar("Inheritance");
			return pillar;
		} else {
			return pillar;
		}
	}
}
