package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Game;

class GameTests {
	
		@Test
		void testCheckResponses() {
			assertAll ("Testing Response Chekcer",
					() -> assertEquals(true, main.Game.checkResponse("A")),
					() -> assertEquals(true, main.Game.checkResponse("a")),
					() -> assertEquals(true, main.Game.checkResponse("B")),
					() -> assertEquals(true, main.Game.checkResponse("b")),
					() -> assertEquals(true, main.Game.checkResponse("C")),
					() -> assertEquals(true, main.Game.checkResponse("c")),
					() -> assertEquals(false, main.Game.checkResponse(" ")),
					() -> assertEquals(false, main.Game.checkResponse("v")),
					() -> assertEquals(false, main.Game.checkResponse("AB")),
					() -> assertEquals(false, main.Game.checkResponse("A cmmmc")));
		}
		
		@Test
		void testCreateMage() {
			Game.classCreate("Mage");
			assertAll ("Testing attributes of Mage",
					() -> assertEquals(1, Game.getMainPlayer().getPlayerLevel()),
					() -> assertEquals(10, Game.getMainPlayer().getPlayerHP()),
					() -> assertEquals(8, Game.getMainPlayer().getPlayerATK()),
					() -> assertEquals(5, Game.getMainPlayer().getPlayerDEF()),
					() -> assertEquals(10, Game.getMainPlayer().getPlayerMANA()),
					() -> assertEquals(4, Game.getMainPlayer().getPlayerSTAMINA())
					);
		}
		@Test
		void testCreateWarrior() {
			
			Game.classCreate("Warrior");
			assertAll ("Testing attributes of Warrior", 
					() -> assertEquals(1, Game.getMainPlayer().getPlayerLevel()),
					() -> assertEquals(20, Game.getMainPlayer().getPlayerHP()),
					() -> assertEquals(5, Game.getMainPlayer().getPlayerATK()),
					() -> assertEquals(10, Game.getMainPlayer().getPlayerDEF()),
					() -> assertEquals(4, Game.getMainPlayer().getPlayerMANA()),
					() -> assertEquals(5, Game.getMainPlayer().getPlayerSTAMINA())
					);
		}
		@Test
		void testCreateAssassin() {
			
			Game.classCreate("Assassin");
			assertAll ("Testing attributes of Warrior", 
					() -> assertEquals(1, Game.getMainPlayer().getPlayerLevel()),
					() -> assertEquals(5, Game.getMainPlayer().getPlayerHP()),
					() -> assertEquals(13, Game.getMainPlayer().getPlayerATK()),
					() -> assertEquals(1, Game.getMainPlayer().getPlayerDEF()),
					() -> assertEquals(6, Game.getMainPlayer().getPlayerMANA()),
					() -> assertEquals(10, Game.getMainPlayer().getPlayerSTAMINA())
					);
			
		}
		
		

}
