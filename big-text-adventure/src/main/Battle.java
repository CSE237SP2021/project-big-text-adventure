package main;

import java.util.Scanner;

public class Battle {

	static Scanner userInput = new Scanner(System.in);
	private static Player player;
	private static Enemy enemy;
	private static boolean escaped;
	
	/**
	 * Constructs a Battle object
	 * @param player
	 * @param enemy
	 */
	public Battle(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
		this.escaped = false;
	}
	
	/**
	 * Check response given by user, ensuring it is within the allowed responses
	 * @param response 
	 * @return true if response allowed, false otherwise
	 */
	public boolean checkResponse(String response) {
		String[] allowedResponses = {"A", "B", "C", "D"};
		for (String answer : allowedResponses) {
			if (response.equalsIgnoreCase(answer)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determine if a hit is critical
	 * @return true if critical hit, false otherwise 
	 */
	public boolean criticalHit() {
		int min = 1;
		int max = 100;
		int randomHit = (int)Math.floor(Math.random()*(max - min + 1) + min);
		if (randomHit == 68) {
			System.out.println("Nice. Critical Hit!");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Player takes their turn - given choice of actions depending on their class
	 */
	public void playerTurn() {
		// Allow player to choose between basic attack, spell, or item
		System.out.println("You move first. How will you fight?");
		System.out.println("A: Attack");
		System.out.println("B: Item");
		if (player.getPlayerClass() == "Mage") {
			System.out.println("C: Spell");
			System.out.println("D: Run");
		} else {
			System.out.println("C: Run");
		}
		
		String moveChoice = userInput.nextLine();
		while (checkResponse(moveChoice) == false) {
			System.out.println("Please enter a valid response by typing A, B, or C.");
			moveChoice = userInput.nextLine();
		}
		
		// Handle attack - apply damage done to enemy based on stats of both	
		if (moveChoice.equalsIgnoreCase("A")) {
			playerAttack();
		}
		
		// Handle item - apply effects of item
		if (moveChoice.equalsIgnoreCase("B")) {
			for (Weapon item : player.getPlayerInventory()) {
				// TODO: Handle other types of weapons as they're added
				int itemDamage = (item.getDamage()) * -1;
				if (criticalHit()) {
					itemDamage = itemDamage * 3;
				}
				enemy.changeHp(itemDamage);
				System.out.println("You dealt " + player.getPlayerATK() + " damage to " + enemy.getName() + 
								   " with " + item.getName() + "!");
				System.out.println("Enemy " + enemy.getName() + " has " + enemy.getHp() + " HP left.");
				System.out.println("You have " + player.getPlayerHP() + " HP left.");
			}
		}

		// Handle spell or run - apply damage done to enemy based on stats of both and spell
		if (moveChoice.equalsIgnoreCase("C")) {
			if (player.getPlayerClass() == "Mage") {
				// C is spell
				useSpell();
			} else {
				// C is run
				run();
			}
		}
		if (moveChoice.equalsIgnoreCase("D")) {
			// D is run
			run();
		}
	}

	/**
	 * Player uses an item against an enemy
	 */
	// TODO: Transfer the code from playerTurn into useItem
	public void useItem() {

	}

	/**
	 * Player uses attack against an enemy
	 */
	public void playerAttack() {
		int attackDamage = (player.getPlayerATK() * -1);
		if (criticalHit()) {
			attackDamage = attackDamage * 3;
		}
		enemy.changeHp(attackDamage);
		System.out.println("You dealt " + player.getPlayerATK() + " damage to " + enemy.getName() + "!");
		System.out.println("Enemy " + enemy.getName() + " has " + enemy.getHp() + " HP left.");
		System.out.println("You have " + player.getPlayerHP() + " HP left.");
	}
	
	/**
	 * Player attempts to run - successful if player's level is higher than enemy's level
	 */
	public void run() {
		if (player.getPlayerLevel() > enemy.getLevel()) {
			System.out.println("You escaped from enemy " + enemy.getName() + "!");
			endBattle();
		} else {
			System.out.println("You couldn't get away!");
		}
	}
	
	/**
	 * Player uses spell against enemy
	 */
	public void useSpell() {
		// Handle spell attack - apply damage to enemy based on stats of both
		int spellDamage = player.getPlayerATK() * player.getPlayerMANA() * -1;
		if (criticalHit()) {
			spellDamage *= 3;
		}
		enemy.changeHp(spellDamage);
		player.setPlayerMANA(0);
		System.out.println("You dealt " + player.getPlayerATK() + " spell damage to " + enemy.getName() + "!");
		System.out.println("Enemy " + enemy.getName() + " has " + enemy.getHp() + " HP left.");
		System.out.println("You have " + player.getPlayerHP() + " HP left.");
		System.out.println("You have " + player.getPlayerMANA() + " MANA left.");
	}
	
	/**
	 * Enemy takes its turn by attacking
	 */
	public void enemyTurn() {
		int enemyAttackDamage = enemy.getAtk() * -1;
		player.changeHp(enemyAttackDamage);
		System.out.println(enemy.getName() + " dealt " + enemy.getAtk() + " damage to you!");
		System.out.println("You have " + player.getPlayerHP() + " HP left.");
		System.out.println(enemy.getName() + " has " + enemy.getHp() + " HP left.");
	}
	
	/**
	 * Handle battle starting, and continue running battle until either enemy or player reaches 0 HP
	 */
	public void startBattle() {
		System.out.println("-----------------------");
		System.out.println(player.getPlayerName() + " VS. " + enemy.getName());
		while (player.getPlayerHP() > 0 && enemy.getHp() > 0) {
			playerTurn();
			if (player.getPlayerHP() > 0 && enemy.getHp() > 0) {
				enemyTurn();
			}
			int currentMana = player.getPlayerMANA();
			if (currentMana < 5) {
				player.setPlayerMANA(currentMana + 1);
			}
		}
		endBattle();
	}
	
	/**
	 * Handle ending battle, give XP to player if earned
	 */
	public static void endBattle() {
		if (player.getPlayerHP() > 0 && !escaped) {
			System.out.println(player.getPlayerName() + " wins!");
			player.gainXP(80);
		} else if (player.getPlayerHP() > 0) {
			
		} else {
			System.out.println(enemy.getName() + "wins!");
		}
		System.out.println("-----------------------");
	}
	
	public static void main(String[] args) {
		
	}
	
}
