import java.util.HashMap;

public class AttackFlyweightPool {
	
	private final static HashMap<AttackName, Attack> ATTACKMAP = new HashMap<AttackName, Attack>();

	public static Attack getAttack(AttackName name, DungeonCharacter self, DungeonCharacter opponent) {
		if(name == AttackName.STANDARD) {
			ATTACKMAP.putIfAbsent(name, new StandardAttack(self, opponent));
		} else if(name == AttackName.CRUSHINGBLOW) {
			ATTACKMAP.putIfAbsent(name, new CrushingBlow(self, opponent));
		} else if(name == AttackName.DOUBLESHOT) {
			ATTACKMAP.putIfAbsent(name, new DoubleShot(self, opponent));
		} else if(name == AttackName.PLAYMELODY) {
			ATTACKMAP.putIfAbsent(name, new PlayMelody(self, opponent));
		} else if(name == AttackName.SURPRISEATTACK) {
			ATTACKMAP.putIfAbsent(name, new SurpriseAttack(self, opponent));
		} else {
			ATTACKMAP.putIfAbsent(AttackName.STANDARD, new StandardAttack(self, opponent));
		}
		
		 Attack attackF = ATTACKMAP.get(name);
		 
		 return attackF;
	}
	
	public static int getTotalAttackObjectsMade() {
		return ATTACKMAP.size();
	}
}




