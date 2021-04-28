package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.Player;

class PlayerTests {

	@Test
	void testPlayerHasRequiredAttributes() {
		Player Bill = new Player( "PlayerName", 1, 5, 2, 3, 1, 5, 0, "Warrior");
		
		assertAll ("Player Attributes",
				() -> assertEquals(1, Bill.getPlayerLevel()),
				() -> assertEquals(5, Bill.getPlayerHP()),
				() -> assertEquals(2, Bill.getPlayerATK()),
				() -> assertEquals(3, Bill.getPlayerDEF()),
				() -> assertEquals(1, Bill.getPlayerMANA()),
				() -> assertEquals(5, Bill.getPlayerSTAMINA()),
				() -> assertEquals(0, Bill.getPlayerXP()),
				() -> assertEquals("Warrior", Bill.getPlayerClass()));
	}
		
	@Test
	void testPlayerAttributesUpdate() {
		Player Bill = new Player( "PlayerName", 1, 5, 2, 3, 1, 5, 0, "Warrior");
		Bill.setPlayerLevel(2);
		Bill.setPlayerATK(5);
		Bill.setPlayerDEF(6);
		Bill.setPlayerHP(1);
		Bill.setPlayerMANA(0);
		Bill.setPlayerSTAMINA(7);
		Bill.setPlayerXP(15);
		
		
		assertAll ("Player Attributes",
				() -> assertEquals(2, Bill.getPlayerLevel()),
				() -> assertEquals(1, Bill.getPlayerHP()),
				() -> assertEquals(5, Bill.getPlayerATK()),
				() -> assertEquals(6, Bill.getPlayerDEF()),
				() -> assertEquals(0, Bill.getPlayerMANA()),
				() -> assertEquals(7, Bill.getPlayerSTAMINA()),
				() -> assertEquals(15, Bill.getPlayerXP()),
				() -> assertEquals("Warrior", Bill.getPlayerClass()));
	
		
//		Player p = new Player(//attributes here);
//		boolean correctlyConstructed = p.checkPlayer(//stuff here);
//		assertTrue(correctlyConstructed);
//		
		
		
	}

}
