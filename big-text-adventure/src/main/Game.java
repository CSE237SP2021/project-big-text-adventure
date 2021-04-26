package main;
import java.util.*;

public class Game {
	
	Scanner userInput = new Scanner(System.in);
	Scanner fileInput;
	private String yourName;
	private Player mainPlayer;
	
	public void delay(int numSeconds) {
		try {
			Thread.sleep(numSeconds * 1000);
		} catch (InterruptedException e) {
		}
	}
	
	public void classCreate(String className) {
		if (className.equals("Mage")) {
			Weapon staff = new BasicWeapon("Staff of Magic", 10, 15, 15, 0);
			mainPlayer = new Player(yourName, 1, 10, 8, 5, 10, 4, 0, "Mage");
			mainPlayer.addToInventory(staff);
		} else if (className.equals("Warrior")) {
			Weapon sword = new BasicWeapon("Sword of Brutality", 15, 10, 15, 1);
			mainPlayer = new Player(yourName, 1, 20, 5, 10, 4, 5, 0, "Warrior");
			mainPlayer.addToInventory(sword);
		} else if (className.equals("Assassin")) {
			Weapon dagger = new BasicWeapon("Dagger of Stealth", 15, 10, 15, 1);
			mainPlayer = new Player(yourName, 1, 5, 13, 1, 6, 10, 0, "Assassin");
			mainPlayer.addToInventory(dagger);
		}
	}
	
	public Player getMainPlayer() {
		return mainPlayer;
	}
		
	public String getPlayerName() {
		return yourName;
	}
	
	public boolean checkResponse(String response) {
		// This checks the response the user gives, and ensures it is within the allowed responses.
		String[] allowedResponses = {"A", "B", "C"};
		for (String answer : allowedResponses) {
			if (response.equalsIgnoreCase(answer)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkForDelimiter(String line) {
		if (line.equals("\\stop\\")) {
			line = fileInput.nextLine();
			if (line.equals("\\path\\")) {
				goDownPath();
			}
			if (line.equals("\\name\\")) {
				this.yourName = userInput.nextLine();
			}
			if (line.equals("\\battle\\")) {
				String enemyName = fileInput.next();
				int level = fileInput.nextInt();
				int hp = fileInput.nextInt();
				int attack = fileInput.nextInt();
				int def = fileInput.nextInt();
				Enemy enemy = new Enemy(enemyName, hp, level, attack, def);
				Battle playerVsEnemy = new Battle(mainPlayer, enemy);
				playerVsEnemy.startBattle();
			}
			//TODO Address Formatted lines
			
			if (line.equals("\\format_line\\")) {
				line = fileInput.next();
				if (line.equals("\\format_1\\")) {
					System.out.format("So what %s, you think you're funny or somethin'?", yourName);
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void readStoryFile(String filePath) {
		try {
			this.fileInput =new Scanner (Game.class.getResourceAsStream(filePath));	
		}catch (Exception e) {
			System.err.println("Cannot open text file");
		}
		while(this.fileInput.hasNext()) {
			String line = this.fileInput.nextLine();
			if (!checkForDelimiter(line)) {
				delay(1);
				System.out.println(line);
			}
		}
	}
	
	public void goDownPath() {
		char path = 0;
		String line = this.fileInput.nextLine();
		String firstChoice = userInput.nextLine();
		while (checkResponse(firstChoice) == false) {
			System.out.println("Please enter a valid response.");
			firstChoice = userInput.nextLine();
		}
		if (firstChoice.equalsIgnoreCase("A")) {
			path = '1';
		}
		else if (firstChoice.equalsIgnoreCase("B")) {
			path = '2';
		}
		else if (firstChoice.equalsIgnoreCase("C")) {
			path = '3';
		}
		String tempDelimiter = "\\path_" + path + "\\";
		while (!line.equals("\\path_converge\\")) {
			if (line.equals(tempDelimiter)) {
				line = fileInput.nextLine();
				checkForDelimiter(line);
				while (!line.equals("\\end_path\\")) {
					delay(2);
					System.out.println(line);
					line = fileInput.nextLine();
				}
				line=fileInput.nextLine();
			}
			else {
				line = fileInput.nextLine();
			}
		}
	}
	
	
	public boolean chapterOne() {
		// CHAPTER 1
		System.out.println("..");
		delay(1);
		System.out.println(".....");
		delay(2);
		System.out.println(".........");
		delay(3);
		System.out.println("You wake up in a dark alley.");
		System.out.println("'I will find you, Bazaar Thief', you whisper under your breath.");
		System.out.println("Conveniently, before you lay three weapons: a staff of magic, a sword of brutality, and a dagger of stealth.");
		
		// Pick up a weapon
		System.out.println("Pick a weapon. This will decide your class.");
		System.out.println("A: Pick up the staff of magic (become a mage).");
		System.out.println("B: Pick up the sword of brutality (become a warrior).");
		System.out.println("C: Pick up the dagger of stealth (become an assassin).");
		String weaponChoice = userInput.nextLine();
		while (!checkResponse(weaponChoice)) {
			System.out.println("Please enter a valid response by typing A, B, or C.");
			weaponChoice = userInput.nextLine();
		}
		
		// Create Player based on their choice
		if (weaponChoice.equalsIgnoreCase("A")) {
			classCreate("Mage");
		} else if (weaponChoice.equalsIgnoreCase("B")) {
			classCreate("Warrior");
		} else if (weaponChoice.equalsIgnoreCase("C")) {
			classCreate("Assassin");
		}
		
		// Choose path to go down
		System.out.println("You exit the alley onto a bustling street. Which way will you go?");
		System.out.println("A: Left.");
		System.out.println("B: Right.");
		String pathChoice = userInput.nextLine();
		while (!checkResponse(pathChoice)) {
			System.out.println("Please enter a valid response by typing A or B.");
			pathChoice = userInput.nextLine();
		}
		
		if (pathChoice.equalsIgnoreCase("A")) {
			return true;
		}
		
		return false;
	}
	
	public void chapterTwo(boolean pathChoice) {
		Enemy enemy = null;
		String enemyName = ""; 
		
		if (pathChoice) {
			enemy = new Enemy("Rabid Dog", 1, 8, 2, 50);
			enemyName = "rabid dog";
		} else {
			enemy = new Enemy("Drunken", 1, 8, 2, 50);
			enemyName = "drunken man";
		}
		
		System.out.println("You follow the street for a ways, until a " + enemyName + " blocks your path. What will you do?");
		System.out.println("A: Attack.");
		System.out.println("B: Run.");
		String enemyChoice = userInput.nextLine();

		while (!checkResponse(enemyChoice)) {
			System.out.println("Please enter a valid response by typing A or B.");
			enemyChoice = userInput.nextLine();
		}
		
		if (enemyChoice.equalsIgnoreCase("A")) {
			// Handle battle with enemy
			Battle playerVsEnemy = new Battle(mainPlayer, enemy);
			playerVsEnemy.startBattle();
			System.out.println("Phew, that was close!");
			delay(2);
			System.out.println("You walk for a few blocks before you stop to get a drink in a bar.");
		} else {
			System.out.println("You duck into a nearby alley and flee from the enemy. "
					+ "In your haste, you become lost and find yourself in 'Ye Olde Drinking Place', a bar?");
		}

		System.out.println("As you walk in the bar, you overhear a couple of locals talking...");
		delay(2);
		System.out.println("\"So there I was the other week and this guy comes up to me in the bazaar and get this...\"");
		delay(3);
		System.out.println("\"And then BAM, he just socks me right in 'a face! What was that?\"");
		delay(2);
		System.out.println("\"Ey! Same thing happened to me the other day while I was shoppin' for some meat!\"");
		delay(1);
		System.out.println("\"Woah no way, some dude really gave me a headache at the same place!\"");
		delay(2);
		System.out.println("You begin to realize that they're talking about the same man who punched you.");

		// Allow choices, A: continue conversation, B: ask question, C: pass by 


	}

	
	

	public void play() {
		readStoryFile("./prologue.txt");
		boolean pathChoice = chapterOne();
		System.out.println(pathChoice);
		chapterTwo(pathChoice);
	}
	

}
