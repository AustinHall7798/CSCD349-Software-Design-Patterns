public class HeroFactory {
	public static Hero createSorceress() {
		return new Sorceress();
	}
	
	public static Hero createWarrior() {
		return new Warrior();
	}
	
	public static Hero createThief() {
		return new Thief();
	}
}
