package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Game;

class GameTests {
	
		Game game = new Game();
		
		@Test
		void testCheckResponses() {
			assertAll ("Testing Response Checker",
					() -> assertEquals(true, game.checkResponse("A")),
					() -> assertEquals(true, game.checkResponse("a")),
					() -> assertEquals(true, game.checkResponse("B")),
					() -> assertEquals(true, game.checkResponse("b")),
					() -> assertEquals(true, game.checkResponse("C")),
					() -> assertEquals(true, game.checkResponse("c")),
					() -> assertEquals(false, game.checkResponse(" ")),
					() -> assertEquals(false, game.checkResponse("v")),
					() -> assertEquals(false, game.checkResponse("AB")),
					() -> assertEquals(false, game.checkResponse("A cmmmc")));
		}
		
		@Test
		void testCreateMage() {
			game.classCreate("Mage");
			assertAll ("Testing attributes of Mage",
					() -> assertEquals(1, game.getMainPlayer().getPlayerLevel()),
					() -> assertEquals(10, game.getMainPlayer().getPlayerHP()),
					() -> assertEquals(8, game.getMainPlayer().getPlayerATK()),
					() -> assertEquals(5, game.getMainPlayer().getPlayerDEF()),
					() -> assertEquals(10, game.getMainPlayer().getPlayerMANA()),
					() -> assertEquals(4, game.getMainPlayer().getPlayerSTAMINA())
					);
		}
		@Test
		void testCreateWarrior() {
			game.classCreate("Warrior");
			assertAll ("Testing attributes of Warrior", 
					() -> assertEquals(1, game.getMainPlayer().getPlayerLevel()),
					() -> assertEquals(20, game.getMainPlayer().getPlayerHP()),
					() -> assertEquals(5, game.getMainPlayer().getPlayerATK()),
					() -> assertEquals(10, game.getMainPlayer().getPlayerDEF()),
					() -> assertEquals(4, game.getMainPlayer().getPlayerMANA()),
					() -> assertEquals(5, game.getMainPlayer().getPlayerSTAMINA())
					);
		}
		@Test
		void testCreateAssassin() {
			game.classCreate("Assassin");
			assertAll ("Testing attributes of Warrior", 
					() -> assertEquals(1, game.getMainPlayer().getPlayerLevel()),
					() -> assertEquals(5, game.getMainPlayer().getPlayerHP()),
					() -> assertEquals(13, game.getMainPlayer().getPlayerATK()),
					() -> assertEquals(1, game.getMainPlayer().getPlayerDEF()),
					() -> assertEquals(6, game.getMainPlayer().getPlayerMANA()),
					() -> assertEquals(10, game.getMainPlayer().getPlayerSTAMINA())
					);
			
		}
		
		

}
