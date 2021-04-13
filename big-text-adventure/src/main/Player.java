package main;
import java.util.*;

public class Player {
	
	// Players should have:
	// Name, HP, Attack, Defense, Mana (?), Stamina, XP, Level, Class, and Inventory
	// TODO Define main attributes for the player
	private String playerName;
	private int playerLevel;
	private int playerHP;
	private int playerATK;
	private int playerDEF;
	private int playerMANA;
	private int playerSTAMINA;
	private int playerXP;
	private String playerClass;
	// TODO This will probably be an ArrayList of weapons, rather than just strings
	private ArrayList<String> playerInventory = new ArrayList<String>();
	
	public Player(String playerName, int playerLevel, int playerHP, int playerATK, int playerDEF, 
			int playerMANA, int playerSTAMINA, int playerXP, String playerClass, ArrayList<String> playerInventory) {
		this.playerName = playerName;
		this.playerLevel = playerLevel;
		this.playerHP = playerHP;
		this.playerATK = playerATK;
		this.playerDEF = playerDEF;
		this.playerMANA = playerMANA;
		this.playerSTAMINA = playerSTAMINA;
		this.playerXP = playerXP;
		this.playerClass = playerClass;
		this.playerInventory = playerInventory;
	}


	// Getters and Setters
	public String getPlayerName() {
		return playerName;
	}
	
	
	public int getPlayerLevel() {
		return playerLevel;
	}


	public void setPlayerLevel(int playerLevel) {
		this.playerLevel = playerLevel;
	}


	public int getPlayerHP() {
		return playerHP;
	}


	public void setPlayerHP(int playerHP) {
		this.playerHP = playerHP;
	}


	public int getPlayerATK() {
		return playerATK;
	}


	public void setPlayerATK(int playerATK) {
		this.playerATK = playerATK;
	}


	public int getPlayerDEF() {
		return playerDEF;
	}


	public void setPlayerDEF(int playerDEF) {
		this.playerDEF = playerDEF;
	}


	public int getPlayerMANA() {
		return playerMANA;
	}


	public void setPlayerMANA(int playerMANA) {
		this.playerMANA = playerMANA;
	}


	public int getPlayerSTAMINA() {
		return playerSTAMINA;
	}


	public void setPlayerSTAMINA(int playerSTAMINA) {
		this.playerSTAMINA = playerSTAMINA;
	}


	public int getPlayerXP() {
		return playerXP;
	}


	public void setPlayerXP(int playerXP) {
		this.playerXP = playerXP;
	}


	public String getPlayerClass() {
		return playerClass;
	}


	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}


	public ArrayList<String> getPlayerInventory() {
		return playerInventory;
	}


	public void setPlayerInventory(ArrayList<String> playerInventory) {
		this.playerInventory = playerInventory;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public void changeHp(int hpAmount) {
		this.playerHP += hpAmount;
	}

	public void gainXP(int xpGained) {
		this.playerXP += xpGained;
		if (this.getPlayerXP() >= 100) {
			// Increment all of the player's stats
			this.setPlayerLevel(this.getPlayerLevel() + 1);
			this.setPlayerHP(this.getPlayerHP() + 2);
			this.setPlayerATK(this.getPlayerHP() + 1);
			this.setPlayerDEF(this.getPlayerDEF() + 1);
			this.setPlayerMANA(this.getPlayerMANA() + 2);
			this.setPlayerSTAMINA(this.getPlayerSTAMINA() + 2);
			System.out.println("You leveled up! You are now level " + this.getPlayerLevel() + "!");

			// Set their XP back to 0
			this.setPlayerXP(0);
		}
	}


	public static void main(String[] args) {
		
		
		
	}

}
