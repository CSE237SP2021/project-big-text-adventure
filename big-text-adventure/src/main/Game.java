package main;
import java.util.*;

public class Game {
	
	static Scanner userInput = new Scanner(System.in);
	private static String yourName;
	private static ArrayList<String> yourInventory = new ArrayList<String>();
	private static Player mainPlayer;
	
	public static void delay(int numSeconds) {
		try {
			Thread.sleep(numSeconds * 1000);
		} catch (InterruptedException e) {
			// Nothing? Not sure if we need to add something here.
		}
	}
	
	public static void classCreate(String className) {
		if (className.equals("Mage")) {
			yourInventory.add("Staff of Magic");
			mainPlayer = new Player(yourName, 1, 10, 8, 5, 10, 4, 0, "Mage", yourInventory);
		} else if (className.equals("Warrior")) {
			yourInventory.add("Sword of Brutality");
			mainPlayer = new Player(yourName, 1, 20, 5, 10, 4, 5, 0, "Warrior", yourInventory);
		} else if (className.equals("Assassin")) {
			yourInventory.add("Dagger of Stealth");
			mainPlayer = new Player(yourName, 1, 5, 13, 1, 6, 10, 0, "Assassin", yourInventory);
		}
	}
	
	public static boolean checkResponse(String response) {
		// This checks the response the user gives, and ensures it is within the allowed responses.
		String[] allowedResponses = {"A", "B", "C"};
		for (String answer : allowedResponses) {
			if (response.equalsIgnoreCase(answer)) {
				return true;
			}
		}
		return false;
	}
	
	public static void thePrologue() {
		// TODO Start the game, ask the player for their name, and create the player
		
		// PROLOGUE
		System.out.println("============================================================");
		System.out.println("You feel a warm breeze across your face as you enter the bazaar.");
		delay(3);
		System.out.println("Looking around the market, you notice a commotion around a nearby stall. Onlookers shout that there's a thief escaping with stolen merchandise. What will you do?");
		delay(2);
		System.out.println("A: Head towards the commotion.");
		System.out.println("B: Head in the opposite direction. ");
		String firstChoice = userInput.nextLine();
		while (checkResponse(firstChoice) == false) {
			System.out.println("Please enter a valid response by typing A or B.");
			firstChoice = userInput.nextLine();
		}
		if (firstChoice.equalsIgnoreCase("A")) {
			System.out.print("As you walk towards the scene, a man bursts out of the crowd, knocking you to the ground. ");
		} else {
			System.out.print("In your rush to get away, you don't notice a man running from the crowd, shoving people out of the way. "
					+ "You're knocked to the ground. ");
		}
		delay(1);
		System.out.println("Recovering from the collision, the man yells out. \"Get out of my way, kid! What's your name?\"");
		System.out.println("(Enter your name.)");
		yourName = userInput.nextLine();
		System.out.format("So what %s, you think you're funny or somethin?", yourName);
		delay(2);
		
		// Canned response block, maybe we can simplify this somehow?
		System.out.println("Choose a response: ");
		System.out.println("A: Yeah. What are you gonna do about it?");
		System.out.println("B: Nope. *You continue walking along*");
		System.out.println("C: Uh. Um. Uh. Yeah? Wait no. No I don't!");
		String reply = userInput.nextLine();
		while (checkResponse(reply) == false) {
			System.out.println("Please enter a valid response by typing A, B, or C.");
			reply = userInput.nextLine();
		}
		
		delay(2);
		System.out.println("A deep scowl appears on the man's face, almost as if nothing you said mattered.");
		System.out.println("You see his fist come towards you and you wince");
		System.out.println("but before you can make sense of the pain, everything turns black.");
		delay(3);
		System.out.println("-------------------------------------");
		System.out.println("Welcome to Big Text Adventure, created by Jeff Su, Ryan Miller, and Jonathan Feehan");
		System.out.println("This is a text adventure game where you interact, fight, chat, and more all through text. Enjoy!");
		delay(2);
		
	}
	
	public static boolean chapterOne() {
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
	
	public static void chapterTwo(boolean pathChoice) {
		Enemy enemy = null;
		String enemyName = ""; 
		
		if (pathChoice) {
			enemy = new Dragon("Dragon", 10, 100, 150, 50);
			enemyName = "dragon";
		} else {
			enemy = new Enemy("Drunken", 10, 100, 150, 50);
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
//			System.out.println("")
		} else {
			System.out.println("You duck into a nearby alley and flee from the enemy. "
					+ "In your haste, you become lost and find yourself in ___");
		}
	}

	
	

	public static void main(String[] args) {
		thePrologue();
		boolean pathChoice = chapterOne();
		System.out.println(pathChoice);
		chapterTwo(pathChoice);
	}
	

}
