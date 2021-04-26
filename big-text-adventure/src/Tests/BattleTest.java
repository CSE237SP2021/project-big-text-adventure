package Tests;

import static org.junit.jupiter.api.Assertions.*;
import main.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;

class BattleTest {

	Enemy Evil = new Enemy("Bob", 1, 2, 1, 4);
	Player Bill = new Player( "Bill", 1, 5, 2, 3, 1, 5, 0, "Warrior");
	Battle testBattle = new Battle(Bill, Evil);

	@Test
	/**
	 * test if startBattle() and endBattle() function properly
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
		Enemy enemyDummy = new Enemy("Enemy Dummy", 1, 100, 0, 0);
		Player playerDummy = new Player("Player Dummy", 1, 100, 10, 0, 0, 0, 0, "Warrior");
		Battle testBattle = new Battle(playerDummy, enemyDummy);
		int expectedDamage = playerDummy.getPlayerATK();
		testBattle.playerAttack();
		assert((enemyDummy.getHp() == (100 - expectedDamage)) || (enemyDummy.getHp() == (100 - expectedDamage*3)));
		return;
	}
	
	@Test
	void testPlayerUseItem() {
		Enemy enemyDummy = new Enemy("Enemy Dummy", 1, 100, 0, 0);
		Player playerDummy = new Player("Player Dummy", 1, 100, 10, 0, 0, 0, 0, "Warrior");
		Battle testBattle = new Battle(playerDummy, enemyDummy);
		Weapon sword = new BasicWeapon("Sword of Brutality", 15, 10, 15, 1);
		int expectedDamage = sword.getDamage();
		playerDummy.addToInventory(sword);
		testBattle.useItem();
		ByteArrayInputStream input = new ByteArrayInputStream("A".getBytes());
		System.setIn(input);
		assert((enemyDummy.getHp() == (100 - expectedDamage)) || (enemyDummy.getHp() == (100 - expectedDamage*3)));
		return;
	}
	
	@Test
	void testPlayerUseSpell() {
		Enemy enemyDummy = new Enemy("Enemy Dummy", 1, 100, 0, 0);
		Player playerDummy = new Player("Player Dummy", 1, 100, 10, 0, 5, 0, 0, "Mage");
		Battle testBattle = new Battle(playerDummy, enemyDummy);
		int expectedDamage = playerDummy.getPlayerATK() * playerDummy.getPlayerMANA() * -1;
		testBattle.useSpell();
		assert((enemyDummy.getHp() == (100 - expectedDamage)) || (enemyDummy.getHp() == (100 - expectedDamage*3)));
		return;
	}
	
	@Test
	void testPlayerRun() {
		// Case where player is able to run
		Enemy enemyDummy = new Enemy("Enemy Dummy", 2, 100, 0, 0);
		Player playerDummy = new Player("Player Dummy", 3, 100, 10, 0, 5, 0, 0, "Mage");
		Battle testBattle = new Battle(playerDummy, enemyDummy);
		testBattle.run();
		assert(testBattle.run());
		// Case where player isn't able to run
		playerDummy.setPlayerLevel(1);
		Battle testBattle2 = new Battle(playerDummy, enemyDummy);
		assert(!testBattle2.run());
		return;
	}

	@Test
	void testCriticalHit() {
		for (int i=0; i < 200; i++) {
			assert(testBattle.criticalHit());
			return;
		}
	}
}
