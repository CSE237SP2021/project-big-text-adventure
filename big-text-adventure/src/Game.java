import java.util.*;

public class Game {
	
	static Scanner userInput = new Scanner(System.in);
	private static String yourName;
	private static ArrayList<String> yourInventory;
	
	
	public static void delay(int numSeconds) {
		try {
			Thread.sleep(numSeconds * 1000);
		} catch (InterruptedException e) {
			// Nothing? Not sure if we need to add something here.
		}
	}
	
	public static void classCreate(String className) {
		if (className.equals("Mage")) {
			// TODO Replace this with weapon/item class.
			yourInventory.add("Staff of Magic");
			Player mainPlayer = new Player(yourName, 1, 10, 8, 5, 10, 4, 0, "Mage", yourInventory);
		} else if (className.equals("Warrior")) {
			yourInventory.add("Sword of Brutality");
			Player mainPlayer = new Player(yourName, 1, 20, 5, 10, 4, 5, 0, "Warrior", yourInventory);
		} else if (className.equals("Assassin")) {
			yourInventory.add("Dagger of Stealth");
			Player mainPlayer = new Player(yourName, 1, 5, 13, 1, 6, 10, 0, "Assassin", yourInventory);
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
		System.out.println("Wait no, I think that was a fart from that guy. You cover your nose.");
		delay(2);
		System.out.println("The fart culprit turns towards you, 'You think I smell or somethin kid? What's your name?'");
		System.out.println("(Enter your name.)");
		yourName = userInput.nextLine();
		System.out.format("So what %s, you think you're funny or somethin?", yourName);
		delay(2);
		
		// Canned response block, maybe we can simplify this somehow?
		System.out.println("Choose a response: ");
		System.out.println("A: Your fart smells like $%#*!");
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
		System.out.println("Welcome to Big Text Adventure, created by Jeff Su, Ryan Miller, and Jonathan Feehan");
		System.out.println("This is a text adventure game where you interact, fight, chat, and more all through text. Enjoy!");
		delay(2);
		
	}
	
	public static void chapterOne() {
		// CHAPTER 1
		System.out.println("..");
		delay(1);
		System.out.println(".....");
		delay(2);
		System.out.println(".........");
		delay(3);
		System.out.println("You wake up in a dark alley.");
		System.out.println("'I will find you, smelly farter', you whisper under your breath.");
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
		
		
		
		
		
		
		
		
		
		
		


		
		
		
	}

	public static void main(String[] args) {
		
		thePrologue();
		chapterOne();
		
	}

}
