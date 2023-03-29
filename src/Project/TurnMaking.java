package Project;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TurnMaking extends SimulationWindow {
	static int boost = 0;
	static int attackRNG;
	static int healRNG;
	static int fireRNG;
	static int messageRNG = 0;
	static boolean specialAttack = false;
	static int enemyBoost = 0;
	
	public static void process(String turnInput) {
		playerTurn(turnInput);
	}
	
	public static void playerTurn(String turnInput) {
	    int playerHP = SimulationWindow.getPlayerHP();
	    int enemyHP = SimulationWindow.getEnemyHP();
	    int playerMP = SimulationWindow.getPlayerMP();

	    switch (turnInput) {
	        case "Attack":
	            attack(playerHP, enemyHP);
	            break;
	        case "Charge":
	            charge(playerMP);
	            break;
	        case "Heal":
	            heal(playerHP, playerMP);
	            break;
	        case "Fire":
	            fire(playerMP, enemyHP);
	            break;
	        default:
	            break;
	    }
	}

	private static void attack(int playerHP, int enemyHP) {
	    List<Integer> range = Arrays.asList(40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 60, 61, 62);
	    Random random = new Random();
	    attackRNG = range.get(random.nextInt(range.size())) + boost;
	    boost = 0;
	    SimulationWindow.setEnemyHP(enemyHP - attackRNG);
	}

	private static void charge(int playerMP) {
	    boost = boost + 15;
	    playerMP = playerMP + 15;
	    SimulationWindow.setPlayerMP(Math.min(playerMP, 70));
	}

	private static void heal(int playerHP, int playerMP) {
	    if (playerMP >= 25) {
	        List<Integer> range = Arrays.asList(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75);
	        Random random = new Random();
	        healRNG = range.get(random.nextInt(range.size()));
	        playerHP = Math.min(playerHP + healRNG, 250);
	        SimulationWindow.setPlayerHP(playerHP);
	        playerMP -= 25;
	        SimulationWindow.setPlayerMP(Math.max(playerMP, 0));
	    }
	}

	private static void fire(int playerMP, int enemyHP) {
	    if (playerMP >= 30) {
	        List<Integer> range = Arrays.asList(70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80);
	        Random random = new Random();
	        fireRNG = range.get(random.nextInt(range.size()));
	        SimulationWindow.setEnemyHP(enemyHP - fireRNG);
	        playerMP -= 30;
	        SimulationWindow.setPlayerMP(Math.max(playerMP, 0));
	    }
	}

	public static String enemyTurnMessage() {
	    String name = enemyGenerator.getName();
	    String attack = enemyGenerator.getAttackOne();
	    String special = enemyGenerator.getAttackTwo();
	    List<Integer> range = Arrays.asList(1, 2, 3);
	    Random random = new Random();
	    messageRNG = range.get(random.nextInt(range.size()));
	    if (messageRNG == 3) {
	        specialAttack = true;
	        return name + " used " + special + "!";
	    }
	    specialAttack = false;
	    return name + " used " + attack + "!";
	}
	
	public static int enemyTurn() {
		int DMG = 0;
		if (specialAttack == false) {
			List<Integer> range = Arrays.asList(42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58);
		    Random random = new Random();
		    DMG = range.get(random.nextInt(range.size())) + enemyBoost;
		    playerHP = playerHP - DMG;
		}
		return DMG;
	}
	
	public static void absorb() {
		int curMP = SimulationWindow.getPlayerMP();
		curMP = curMP - 15;
		SimulationWindow.setPlayerMP(curMP);
		if (curMP < 0) {
			SimulationWindow.setPlayerMP(0);
		}
	}
	
	public static String generateSpecial() {
		List<String> range = Arrays.asList("healed", "grew stronger", "stole MP");
	    Random random = new Random();
	    String special = range.get(random.nextInt(range.size()));
	    return special;
	}

	
	public int getBoost() {
		return boost;
	}

	public void setBoost(int boost) {
		TurnMaking.boost = boost;
	}

	public static boolean isSpecialAttack() {
		return specialAttack;
	}

	public static void setSpecialAttack(boolean specialAttack) {
		TurnMaking.specialAttack = specialAttack;
	}

	public static int getAttackRNG() {
		return attackRNG;
	}

	public static void setAttackRNG(int attackRNG) {
		TurnMaking.attackRNG = attackRNG;
	}

	public static int getHealRNG() {
		return healRNG;
	}

	public static void setHealRNG(int healRNG) {
		TurnMaking.healRNG = healRNG;
	}

	public static int getFireRNG() {
		return fireRNG;
	}

	public static void setFireRNG(int fireRNG) {
		TurnMaking.fireRNG = fireRNG;
	}

	public static int getMessageRNG() {
		return messageRNG;
	}

	public static void setMessageRNG(int messageRNG) {
		TurnMaking.messageRNG = messageRNG;
	}
	
	
}
