package main;

public class Battle {

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
	
	public static void playerTurn() {
		// Allow player to choose between basic attack, spell, or item
		// Handle attack - apply damage done to enemy based on stats of both
		// Handle spell - apply damage done to enemy based on stats of both and spell
		// Handle item - apply effects of item
	}
	
	public static void enemyTurn() {
		// Enemy uses one of its attacks
	}
	
	public static void startBattle() {
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
	}
	
	public static void main(String[] args) {
		
	}
	
}
