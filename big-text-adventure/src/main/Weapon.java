package main;

public interface Weapon {
	String getName();
	
	/** Get the damage of the weapon
	 * 
	 * @return Damage as an int
	 */
	int getDamage() ;
	
	/**
	 * Gets the defense of the weapon
	 * 
	 * @return Defense as an int
	 */
	int getDefense() ;
	
	/**
	 * Gets the monetary value of the weapon
	 * 
	 * @return Returns the value as an int
	 */
	int getValue() ;
	
	/** 
	 * Sets a new name for the weapon
	 * 
	 * @param  name The new name of the weapon
	 * @return 0
	 */
	int setName(String name) ;
	
	/**
	 * Updates the damage value of the weapon
	 * 
	 * @param  damage The new attack of the weapon
	 * @return 0
	 */
	int setDamge(int damage);
	
	/**
	 * Updates the defense value of the weapon
	 * 
	 * @param defense The new defense of the weapon
	 * @return 0 
	 */
	int setDefense(int defense) ;
	
	/** Updates the value of the weapon
	 * 
	 * @param value New value of the weapon
	 * @return 0
	 */
	int setValue(int value);
}
