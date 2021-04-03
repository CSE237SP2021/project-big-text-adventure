import java.util.ArrayList;

public class Dragon extends Enemy {

	public Dragon(String name, int level, int hp, int atk, int def, ArrayList<Weapon> inv) {
		super(name, level, hp, atk, def, inv);
	}
	
	
	public static void main(String[] args) {
		
	}
	
//	/**
//	 * Dragon attack which deals fire damage
//	 * @return damage done by attack in HP as Int
//	 */
//	public int breatheFire() {
//		return level * atk;
//	}

}
