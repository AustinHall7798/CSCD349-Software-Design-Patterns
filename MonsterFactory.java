public class MonsterFactory {

	public static Monster createGremlin() {
		return new Gremlin();
	}
	
	public static Monster createOgre() {
		return new Ogre();
	}
	
	public static Monster createSkeleton() {
		return new Skeleton();
	}
}

