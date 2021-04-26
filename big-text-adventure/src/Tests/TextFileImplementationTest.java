package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.Game;

class TextFileImplementationTest {

	@Test
	void testDelimiterFunction() {
		Game testGame = new Game();
		Scanner testFile = null;
		int line_counter = 1;
		int array_index_counter = 0;
		int [] correct_line_numbers = new int [] {3,5,7,8,10,13,16,17,19,22};
		try {
			testFile = new Scanner(Game.class.getResourceAsStream("./../Tests/testFile.txt"));
		} catch (Exception E) {
			System.err.println("Could not open file");
		}
		while (testFile.hasNext()) {
			String line = testFile.nextLine();
			if (testGame.checkForDelimiter(line)) {
				assert (line_counter == correct_line_numbers[array_index_counter]);
				array_index_counter++;
			}
			line_counter++;
		}
	}
	
	
	@Test
	void testVariousDelimiters() {
		Game testGame = new Game();
		Scanner testFile_various = null;
		int path_counter = 0;
		int name_counter = 0;
		int battle_counter = 0;
		int enemyName_counter = 0;
		int [] answers = new int[] {2,4,3,1};
		
		try {
			testFile_various = new Scanner(Game.class.getResourceAsStream("./../Tests/testFile_various.txt"));
		} catch (Exception E) {
			System.err.println(E);
		}
		
		while(testFile_various.hasNext()) {
			String line = testFile_various.next();
			if (testGame.checkForDelimiter(line)) {
				line = testFile_various.next();
				if (line.equals("\\path\\")) {
					path_counter++;
				}
				if (line.equals("\\name\\")) {
					name_counter++;
				}
				if (line.equals("\\battle\\")) {
					battle_counter++;
				}
				if (line.equals("\\enemy_name\\")) {
					enemyName_counter++;
				}
				
			}
		}
		assertEquals(answers[0], path_counter );
		assertEquals(answers[1], name_counter );
		assertEquals(answers[2], battle_counter );
		assertEquals(answers[3], enemyName_counter);
		
	}

}


