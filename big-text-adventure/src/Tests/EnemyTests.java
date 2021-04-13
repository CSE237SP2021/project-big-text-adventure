package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;

import main.Enemy;

class EnemyTests {
	
	/**
	 * Tests enemy interface functionality
	 */
	
	@Test
	void testInterface() {
		Enemy Evil = new Enemy("Bob", 1, 2, 3, 4);
		assertAll ("Enemy Getters",
				() -> assertEquals(1, Evil.getLevel()),
				() -> assertEquals(2, Evil.getHp()),
				() -> assertEquals(3, Evil.getAtk()),
				() -> assertEquals(4, Evil.getDef()));
	}
	
	@Test
	void testSettersPositive() {
		Enemy Evil = new Enemy("Bob", 1, 2, 3, 4);
		Evil.changeAtk(2);
		Evil.changeDef(2);
		Evil.changeHp(2);
		
		assertAll ("Enemy Getters",
				() -> assertEquals(4, Evil.getHp()),
				() -> assertEquals(5, Evil.getAtk()),
				() -> assertEquals(6, Evil.getDef()));
	}
	
	@Test
	void testSettersNegative() {
		Enemy Evil = new Enemy("Bob", 1, 2, 3, 4);
		
		Evil.changeAtk(-1);
		Evil.changeDef(-1);
		Evil.changeHp(-1);
		
		assertAll ("Enemy Getters",
				() -> assertEquals(1, Evil.getHp()),
				() -> assertEquals(2, Evil.getAtk()),
				() -> assertEquals(3, Evil.getDef()));
	}

}
