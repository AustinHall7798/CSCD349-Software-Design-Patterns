public class GiantSpider extends Monster {
    public GiantSpider() {
		super("Fluffy the Giant Spider", 35, 10, 1, .2, 5, 20, 10, 25);
    }

	public void attack(DungeonCharacter opponent) {
		System.out.println(getName() + " bites at " + opponent.getName() + ":");
		new StandardAttack(this, opponent);
	}
}