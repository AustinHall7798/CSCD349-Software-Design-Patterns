import java.util.HashMap;

public class AttackFlyweightPool {
	
	private final static HashMap<AttackName, Attack> attackMap = new HashMap<AttackName, Attack>();

	public static Attack getAttack(AttackName name, DungeonCharacter self, DungeonCharacter opponent) {
		if(name == AttackName.STANDARD) {
			attackMap.putIfAbsent(name, new StandardAttack(self, opponent));
		} else if(name == AttackName.CRUSHINGBLOW) {
			attackMap.putIfAbsent(name, new CrushingBlow(self, opponent));
		} else if(name == AttackName.DOUBLESHOT) {
			attackMap.putIfAbsent(name, new DoubleShot(self, opponent));
		} else if(name == AttackName.PLAYMELODY) {
			attackMap.putIfAbsent(name, new PlayMelody(self, opponent));
		} else if(name == AttackName.SURPRISEATTACK) {
			attackMap.putIfAbsent(name, new SurpriseAttack(self, opponent));
		} else {
			System.out.println(self.getName() + ": ERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERROR");
		}
		
		 Attack attackF = attackMap.get(name);
		 
		 return attackF;
	}
	
	public static int getTotalAttackObjectsMade() {
		return attackMap.size();
	}
}




