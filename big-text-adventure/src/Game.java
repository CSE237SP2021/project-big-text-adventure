import java.util.*;

public class Game {
	
	static Scanner userInput = new Scanner(System.in);
	
	public static void delay(int numSeconds) {
		try {
			Thread.sleep(numSeconds * 1000);
		} catch (InterruptedException e) {
			// Nothing? Not sure if we need to add something here.
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

	public static void main(String[] args) {
		
		// TODO Start the game, ask the player for their name, and create the player
		// TODO Maybe we should move this to a method or something so this doesn't become unruly.
		
		// PROLOGUE
		System.out.println("============================================================");
		System.out.println("You feel a warm breeze across your face as you enter the bazaar.");
		delay(3);
		System.out.println("Wait no, I think that was a fart from that guy. You cover your nose.");
		delay(2);
		System.out.println("The fart culprit turns towards you, 'You think I smell or somethin kid? What's your name?'");
		System.out.println("(Enter your name below)");
		String yourName = userInput.nextLine();
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

		// CHAPTER 1
		System.out.println("..");
		delay(1);
		System.out.println(".....");
		delay(2);
		System.out.println(".........");
		delay(3);
		
		


		

	}

}
