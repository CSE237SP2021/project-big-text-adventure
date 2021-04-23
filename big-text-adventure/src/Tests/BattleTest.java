package Tests;

import static org.junit.jupiter.api.Assertions.*;

import main.Enemy;
import main.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BattleTest {

	@Test
	void testBattle() {
		Enemy Evil = new Enemy("Bob", 1, 2, 3, 4);
		Player Bill = new Player( "Bill", 1, 5, 2, 3, 1, 5, 0, "Warrior", new ArrayList<String>());
		Battle testBattle = new Battle(Bill, Evil);
		assertAll("Testing a basic battle",
				() -> assertEquals(true, testBattle.startBattle())
				)
	}

	@Test
	void testCheckResponse() {
		fail("Not yet implemented");
	}

	@Test
	void testCriticalHit() {
		fail("Not yet implemented");
	}

	@Test
	void testPlayerTurn() {
		fail("Not yet implemented");
	}

	@Test
	void testEnemyTurn() {
		fail("Not yet implemented");
	}

	@Test
	void testStartBattle() {
		fail("Not yet implemented");
	}

	@Test
	void testEndBattle() {
		fail("Not yet implemented");
	}




}
