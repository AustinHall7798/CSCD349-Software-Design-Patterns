import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PillarTest {

	private PolymorphismPillar polyPillar;
	private EncapsulationPillar encapPillar;
	private InheritancePillar inheriPillar;
	private AbstractionPillar abstractPillar;
	
	@BeforeEach
	public void setup() throws Exception {
		polyPillar = PolymorphismPillar.createPillar();
		encapPillar = EncapsulationPillar.createPillar();
		inheriPillar = InheritancePillar.createPillar();
		abstractPillar = AbstractionPillar.createPillar();
	}
	
	@Test
	public void testPillarType() {
		assertEquals("Polymorphism", polyPillar.getType());
		assertEquals("Encapsulation", encapPillar.getType());
		assertEquals("Inheritance", inheriPillar.getType());
		assertEquals("Abstraction", abstractPillar.getType());
	}
	
	@Test
	public void testPillarSingleton() {
		assertSame(this.polyPillar, PolymorphismPillar.createPillar());
		assertSame(this.encapPillar, EncapsulationPillar.createPillar());
		assertSame(this.inheriPillar, InheritancePillar.createPillar());
		assertSame(this.abstractPillar, AbstractionPillar.createPillar());
	}
}
