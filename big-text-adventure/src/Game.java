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
	

	public static void main(String[] args) {
		
		// TODO Start the game, ask the player for their name, and create the player
		// TODO Maybe we should move this to a method or something so this doesn't become unruly.
		System.out.println("====================");
		System.out.println("You feel a warm breeze across your face as you enter the bazaar.");
		delay(3);
		System.out.println("Wait no, I think that was a fart from that guy. You cover your nose.");
		delay(2);
		System.out.println("The fart culprit turns towards you, 'You think I smell or somethin kid? What's your name?'");
		System.out.println("(Enter your name below)");
		String yourName = userInput.nextLine();
		System.out.format("So what %s, you think you're funny or somethin?", yourName);
		delay(2);
		

	}

}
