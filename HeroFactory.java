public abstract class HeroFactory {
	public static Hero createSorceress() {
		return new Sorceress();
	}
	
	public static Hero createWarrior() {
		return new Warrior();
	}
	
	public static Hero createThief() {
		return new Thief();
	}

	public static Hero createArcher() {
		return new Archer();
	}

	public static Hero createBard() {
		return new Bard();
	}

}
