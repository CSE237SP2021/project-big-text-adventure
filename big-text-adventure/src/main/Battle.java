package main;

import java.util.Scanner;

public class Battle {

	static Scanner userInput = new Scanner(System.in);
	private static Player player;
	private static Enemy enemy;
	
	/**
	 * Constructs a Battle object
	 * @param player
	 * @param enemy
	 */
	public Battle(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
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

	public boolean criticalHit() {
		int min = 1;
		int max = 100;
		int randomHit = (int)Math.floor(Math.random()*(max - min + 1) + min);
		if (randomHit == 69) {
			System.out.println("Nice. Critical Hit!");
			return true;
		} else {
			return false;
		}
	}

	public void playerTurn() {
		// Allow player to choose between basic attack, spell, or item
		System.out.println("You move first. Will you attack, use a spell, or use an item?");
		System.out.println("A: Attack");
		System.out.println("B: Spell");
		System.out.println("C: Item");
		
		String moveChoice = userInput.nextLine();
		while (checkResponse(moveChoice) == false) {
			System.out.println("Please enter a valid response by typing A, B, or C.");
			moveChoice = userInput.nextLine();
		}
		
		// Handle attack - apply damage done to enemy based on stats of both	
		if (moveChoice.equalsIgnoreCase("A")) {
			int attackDamage = (player.getPlayerATK()) * -1;
			if (criticalHit()) {
				attackDamage = attackDamage * 3;
			}
			enemy.changeHp(attackDamage);
			System.out.println("You dealt " + player.getPlayerATK() + " damage to " + enemy.getName() + "!");
			System.out.println(enemy.getName() + " has " + enemy.getHp() + " HP left.");
			System.out.println("You have " + player.getPlayerHP() + " HP left.");
		}
		
		// Handle spell - apply damage done to enemy based on stats of both and spell
		// Handle item - apply effects of item
	}
	
	public void enemyTurn() {
		// Enemy uses one of its attacks
		int enemyAttackDamage = enemy.getAtk() * -1;
		player.changeHp(enemyAttackDamage);
		System.out.println(enemy.getName() + " dealt " + enemy.getAtk() + " damage to you!");
		System.out.println("You have " + player.getPlayerHP() + " HP left.");
		System.out.println(enemy.getName() + " has " + enemy.getHp() + " HP left.");
	}
	
	public void startBattle() {
		System.out.println("-----------------------");
		System.out.println(player.getPlayerName() + " VS. " + enemy.getName());
		while (player.getPlayerHP() > 0 && enemy.getHp() > 0) {
			playerTurn();
			if (player.getPlayerHP() > 0 && enemy.getHp() > 0) {
				enemyTurn();
			}
		}
		endBattle();
	}
	
	public static void endBattle() {
		if (player.getPlayerHP() > 0) {
			System.out.println(player.getPlayerName() + " wins!");
		} else {
			System.out.println(enemy.getName() + "wins!");
		}
		System.out.println("-----------------------");
	}
	
	public static void main(String[] args) {
		
	}
	
}
