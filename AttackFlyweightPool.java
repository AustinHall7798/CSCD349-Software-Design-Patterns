import java.util.HashMap;

public class AttackFlyweightPool {
	
	private final static HashMap<String, Attack> attackMap = new HashMap<String, Attack>();
	
	
	public static Attack getAttack(String attackName, DungeonCharacter self, DungeonCharacter opponent)
	{
		if(attackName.equalsIgnoreCase("standardattack"))
		{
			attackMap.putIfAbsent(attackName.toLowerCase(), new StandardAttack(self, opponent));
		}
		else if(attackName.equalsIgnoreCase("crushingblow"))
		{
			attackMap.putIfAbsent(attackName.toLowerCase(), new CrushingBlow(self, opponent));
		}
		else if(attackName.equalsIgnoreCase("doubleshot"))
		{
			attackMap.putIfAbsent(attackName.toLowerCase(), new DoubleShot(self, opponent));
		}
		else if(attackName.equalsIgnoreCase("playmelody"))
		{
			attackMap.putIfAbsent(attackName.toLowerCase(), new PlayMelody(self, opponent));
		}
		else if(attackName.equalsIgnoreCase("surpriseattack"))
		{
			attackMap.putIfAbsent(attackName.toLowerCase(), new SurpriseAttack(self, opponent));
		}
		else
		{
			System.out.println(self.getName() + ": ERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERROR");
		}
		
		 Attack attackF = attackMap.get(attackName);
		 
		 return attackF;
	}
	
	public static int getTotalAttackObjectsMade()
	{
		return attackMap.size();
	}

}


