package Tests;

import static org.junit.jupiter.api.Assertions.*;
import main.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class BattleTest {

	Enemy Evil = new Enemy("Bob", 1, 2, 1, 4);
	Player Bill = new Player( "Bill", 1, 5, 2, 3, 1, 5, 0, "Warrior");
	Battle testBattle = new Battle(Bill, Evil);

	@Test
	/**
	 * test if startBattle() and endBattle() function properly, which also test
	 */
	void testBattle() {
		testBattle.startBattle();
		assertAll("Testing a basic battle",
				() -> assertEquals(true, Evil.getHp() == 0),
				() -> assertEquals(true, Bill.getPlayerHP() > 0)
		);
	}

	@Test
	/**
	 * test that checkResponse accepts the correct inputs
	 */
	void testCheckResponse() {
		assertAll("Testing player response checker",
				() -> assertEquals(true, testBattle.checkResponse("A")),
				() -> assertEquals(true, testBattle.checkResponse("B")),
				() -> assertEquals(true, testBattle.checkResponse("C")),
				() -> assertEquals(true, testBattle.checkResponse("D"))
		);
	}

	@Test
	void testPlayerAttack() {
		Enemy EnemyDummy = new Enemy("EnemyDummy", 1, 100, 0, 0);
		Player AttackDummy = new Player("AttackDummy", 1, 100, 10, 0, 0, 0, 0, "Warrior");

	}

	@Test
	// TODO I'm pretty sure this can't be written like this, but I'm not entirely sure (???)
	void testCriticalHit() {
		for (int i=0; i < 200; i++) {
			if (testBattle.criticalHit()) {
				assert(true);
				return;
			}
		}
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

	@Test
	void testRun() {

	}

	@Test
	void testUseSpell() {

	}

}
