package dungeon;
public abstract class MonsterFactory {
	public static Monster createGremlin() {
		return new Gremlin();
	}
	
	public static Monster createOgre() {
		return new Ogre();
	}
	
	public static Monster createSkeleton() {
		return new Skeleton();
	}

	public static Monster createGiantSpider() {
		return new GiantSpider();
	}

	public static Monster createGolem() {
		return new Golem();
	}
}
