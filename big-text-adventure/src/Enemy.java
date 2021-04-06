import java.util.*;

public class Enemy {

	String name;
	int level, hp, atk, def;
	ArrayList<Weapon> inv;
	
	/**
	 * Constructs an Enemy object
	 * @param name
	 * @param level
	 * @param hp
	 * @param atk
	 * @param def
	 */
	public Enemy(String name, int level, int hp, int atk, int def) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}
	
	/**
	 * Gets the name of the enemy
	 * @return name as String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the level of the enemy
	 * @return level as Int
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * Gets the HP of the enemy
	 * @return HP as Int
	 */
	public int getHp() {
		return this.hp;
	}
	
	/**
	 * Gets the attack of the enemy
	 * @return attack as Int
	 */
	public int getAtk() {
		return this.atk;
	}
	
	/**
	 * Gets the defense of the enemy
	 * @return defense as Int
	 */
	public int getDef() {
		return this.def;
	}
	
	/**
	 * Changes HP by hpAmount
	 * @param hpAmount amount HP is being changed by (can be positive or negative)
	 */
	public void changeHp(int hpAmount) {
		this.hp += hpAmount;
	}

	/**
	 * Changes attack by atkAmount
	 * @param atkAmount amount attack is being changed by (can be positive or negative)
	 */
	public void changeAtk(int atkAmount) {
		this.atk += atkAmount;
	}
	
	/**
	 * Changes defense by defAmount
	 * @param defAmount amount defense is being changed by (can be positive or negative)
	 */
	public void changeDef(int defAmount) {
		this.def += defAmount;
	}
	
	public static void main(String[] args) {
		
	}

}
