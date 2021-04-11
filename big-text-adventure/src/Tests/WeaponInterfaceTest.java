package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.BasicWeapon;
import main.Weapon;
class WeaponInterfaceTest {

	
	/*
	 * Shows that weapon getters work
	 */
	@Test
	void TestDamageGetters() {
		Weapon[] weaponList = new Weapon[3]; 
		weaponList[0] = new BasicWeapon("Sword", 20, 5, 150, 2);
		weaponList[1] = new BasicWeapon("Dagger" , 40 , 1, 150, 3);
		weaponList[2] = new BasicWeapon("Staff of Flames", 30, 0, 300, 1);
		assertAll ("Weapon Getters",
				() -> assertEquals(20, weaponList[0].getDamage()),
				() -> assertEquals(40, weaponList[1].getDamage()),
				() -> assertEquals(30,weaponList[2].getDamage()));
	}
	
	
	/*
	 * Tests to make sure Interface works
	 */
	@Test
	void TestInterface() {
		Weapon weaponInterfaceTest = new BasicWeapon("Sword", 20, 5, 150, 2);
		assertEquals(weaponInterfaceTest.getDamage(), getWeaponDamage(weaponInterfaceTest));
	}
	
	
	int getWeaponDamage(Weapon w) {
		return w.getDamage();
	}

}
