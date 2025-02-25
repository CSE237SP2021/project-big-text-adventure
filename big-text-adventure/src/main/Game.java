package main;
import java.util.*;

public class Game {
	
	Scanner userInput = new Scanner(System.in);
	Scanner fileInput;
	String chapter_path;
	int nest_level = 0;
	private String yourName;
	private Player mainPlayer;
	boolean skip = false;
	
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
	
	public boolean checkHp() {
		return mainPlayer.getPlayerHP() > 0;
	}
	
	public boolean checkForDelimiter(String line, Scanner fileInput, boolean preserve_scanner_position) {
		if (line.equals("\\stop\\")) {
			if (preserve_scanner_position) {
				return true;
			}
			line = fileInput.nextLine();
			if (line.equals("\\path\\")) {
				char path = 0;
				line = this.fileInput.nextLine();
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
				String tempDelimiter = "\\path_" + path;
				goDownPath(tempDelimiter, line);
			}
			if (line.equals("\\skip\\")) {
				this.skip = true;
				String skip_value = this.fileInput.nextLine();
				skipToLine(skip_value);
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
			if (line.equals("\\class\\")) {
				String weaponChoice = userInput.next();
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
			}
			if (line.equals("\\chapter_path\\")) {
				String choice = userInput.nextLine();
				while (checkResponse(choice) == false) {
					System.out.println("Please enter a valid response.");
					choice = userInput.nextLine();
				}
				if (choice.equalsIgnoreCase("A")) {
					this.chapter_path = "1";
				}
				else if (choice.equalsIgnoreCase("B")) {
					this.chapter_path = "2";
				}
				else if (choice.equalsIgnoreCase("C")) {
					this.chapter_path = "3";
				}
			}
			if (line.equals("\\follow_chapter_path\\")) {
				String path = "\\path_" + this.chapter_path;
				goDownPath(path, this.fileInput.nextLine());
			}
			if (line.equals("\\set_nest\\")) {
				int new_level = fileInput.nextInt();
				this.nest_level = new_level;
			}
			if (line.equals("\\check_hp\\")) {
				if (checkHp()) {
					this.chapter_path = "1";
				} else {
					this.chapter_path = "2";
				}
			}
			if (line.equals("\\give_item\\")) {
				String itemName = fileInput.next();
				int damage = fileInput.nextInt();
				int def = fileInput.nextInt();
				int val = fileInput.nextInt();
				int itemClass = fileInput.nextInt();
				Weapon newItem = new BasicWeapon(itemName, damage, def, val, itemClass);
				mainPlayer.addToInventory(newItem);
			}			
			if (line.equals("\\format_line\\")) {
				line = fileInput.next();
				if (line.equals("\\format_1\\")) {
					System.out.format("So what %s, you think you're funny or somethin'?", yourName);
				}
				if (line.equals("\\format_2\\")) {
					if (this.chapter_path.equals("1")) {
						System.out.println("You follow the street for a ways, until a Rabid Dog blocks your path");
					}
					else {
						System.out.println("You follow the street for a ways, until a Drunkard blocks your path");
					}
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
			if (!checkForDelimiter(line, this.fileInput, false)) {
				delay(1);
				System.out.println(line);
			}
		}
	}
	
	public void goDownPath(String tempDelimiter, String line) {
		this.nest_level++;
		while (!line.equals("\\path_converge_" + String.valueOf(this.nest_level) + "\\")) {
			if (line.equals(tempDelimiter + "_" + String.valueOf(this.nest_level) + "\\")) {
				if (!this.fileInput.hasNext()) {
					return;
				}
				line = this.fileInput.nextLine();
				checkForDelimiter(line, this.fileInput, false);
				if (this.skip) {
					this.skip=false;
					return;
				}
				while (!line.equals("\\end_path\\")) {
					delay(1);
					
					if (!checkForDelimiter(line, this.fileInput, true)) {
						System.out.println(line);
					}
					else {
						checkForDelimiter(line, this.fileInput, false);
					}
					if (this.skip) {
						this.skip=false;
						return;
					}
					if (!this.fileInput.hasNext()) {
						return;
					}
					line = this.fileInput.nextLine();
				}
				if (!this.fileInput.hasNext()) {
					return;
				}
				line=this.fileInput.nextLine();
			}
			else {
				if (this.skip) {
					this.skip=false;
					return;
				}
				if (!this.fileInput.hasNext()) {
					return;
				}
				line = this.fileInput.nextLine();
			}
		}
		this.nest_level--;
	}
	
	public void skipToLine(String skip_value) {
		skip_value = "\\" + skip_value + "_location\\";
		while (!skip_value.equals(fileInput.nextLine())) {
		}
		return;
	}
	
	public void play() {
		readStoryFile("./story_text/prologue.txt");
		readStoryFile("./story_text/chapter_1.txt");
		readStoryFile("./story_text/chapter_2.txt");
		readStoryFile("./story_text/chapter_3.txt");
	}
	

}
