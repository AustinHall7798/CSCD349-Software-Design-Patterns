
public class InheritancePillar extends Pillar{
	String pillarType;
	static InheritancePillar pillar;

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
