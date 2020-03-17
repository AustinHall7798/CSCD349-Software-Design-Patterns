
public class PolymorphismPillar extends Pillar{
	String pillarType;
	static PolymorphismPillar pillar;

	private PolymorphismPillar(String type) {
		this.pillarType = type;
	}

	public static PolymorphismPillar createPillar() {
		if (pillar == null) {
			pillar = new PolymorphismPillar("Polymorphism");
			return pillar;
		} else {
			return pillar;
		}
	}
}
