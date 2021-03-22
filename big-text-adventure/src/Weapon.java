

public class Weapon {

	String name;
	int damage;
	int defense;
	int value;
	int weaponClass;
	
	/* Could possibly use more then 0-2 for classes if multiclasses weapons. ie 4 for magic and barbarian weapon and 5 for magic and assassin*/
	/**
	 * Constructs a Weapon object
	 * 
	 * @param name
	 * @param damage
	 * @param defense
	 * @param value
	 * @param WeaponClass An int describing the class of weapon: mage, warrior, assassin
	 */
	public Weapon(String name, int damage, int defense, int value, int weaponClass) {
		
		this.name = name;
		this.damage = damage;
		this.defense = defense;
		this.value = value;
		this.weaponClass = weaponClass;
		
		
	}
	
	/**
	 * Get the name of the weapon
	 * 
	 * @return Name of weapon as a String
	 */
	String getName() {
		return this.name;
	}
	
	/** Get the damage of the weapon
	 * 
	 * @return Damage as an int
	 */
	int getDamage() {
		return this.damage;
	}
	
	/**
	 * Gets the defense of the weapon
	 * 
	 * @return Defense as an int
	 */
	int getDefense() {
		return this.defense;
	}
	
	/**
	 * Gets the monetary value of the weapon
	 * 
	 * @return Returns the value as an int
	 */
	int getValue() {
		return this.getValue();
	}
	
	/** 
	 * Sets a new name for the weapon
	 * 
	 * @param  name The new name of the weapon
	 * @return 0
	 */
	int setName(String name) {
		this.name = name;
		return 0;
	}
	
	/**
	 * Updates the damage value of the weapon
	 * 
	 * @param  damage The new attack of the weapon
	 * @return 0
	 */
	int setDamge(int damage) {
		this.damage = damage;
		return 0;
	}
	
	/**
	 * Updates the defense value of the weapon
	 * 
	 * @param defense The new defense of the weapon
	 * @return 0 
	 */
	int setDefense(int defense) {
		this.defense = defense;
		return 0;
	}
	
	/** Updates the value of the weapon
	 * 
	 * @param value New value of the weapon
	 * @return 0
	 */
	int setValue(int value) {
		this.value = value;
		return 0;
	}
	 
	
	
}
