<<<<<<< HEAD
package Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class enemyGenerator extends SimulationWindow {
    static String name;
    static int HP;
    static String attackOne;
    static int attackDMG;
    static String attackTwo;
    String attackEffect;

    static void generate() {
        FileInputStream fileinputstream = null;
        try {
            fileinputstream = new FileInputStream("src/Project/enemyInfo.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner inFS = new Scanner(fileinputstream);

        // Choose a random enemy from the list
        String randomEnemy = selectRandomEnemy();
        name = randomEnemy;

        // Search file for corresponding enemy data
        searchFileForEnemyData(randomEnemy, inFS);

        // Generate a random amount of attack damage
        attackDMG = generateRandomAttackDamage();

        inFS.close();
    }

    private static String selectRandomEnemy() {
        ArrayList<String> enemyList = new ArrayList<>(Arrays.asList("Goblin", "Slime", "Orc", "Skeleton", "Spider", "Golem", "Chimera", "Dragon"));
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        Random random = new Random();
        int randomNumber = numberList.get(random.nextInt(numberList.size()));
        return enemyList.get(randomNumber);
    }

    private static void searchFileForEnemyData(String randomEnemy, Scanner inFS) {
        inFS.nextLine(); // Skips the first line of the file

        boolean searchingFile = true;
        while (searchingFile) {
            String line = inFS.nextLine();
            if (randomEnemy.equals(line)) {
                HP = inFS.nextInt();
                attackOne = inFS.next();
                attackTwo = inFS.next();
                searchingFile = false;
                break;
            }
        }
    }

    private static int generateRandomAttackDamage() {
        List<Integer> damageList = Arrays.asList(28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47);
        Random rng = new Random();
        return damageList.get(rng.nextInt(damageList.size()));
    }

	public static String getName() {
		return name;
	}

	public static int getHP() {
		return HP;
	}

	public static String getAttackOne() {
		return attackOne;
	}

	public int getAttackDMG() {
		return attackDMG;
	}

	public static String getAttackTwo() {
		return attackTwo;
	}

	public String getAttackEffect() {
		return attackEffect;
	}
}
=======
package Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class enemyGenerator extends SimulationWindow {
	static String name;
	static int HP;
	static String attackOne;
	static int attackDMG;
	static String attackTwo;
	String attackEffect;
	
	static void generate() {
		boolean searchingFile = true;
		
		// Implementing Scanner and FileInputStream
		Scanner scanner = new Scanner(System.in);
		FileInputStream fileinputstream = null;
		
		try {
			fileinputstream = new FileInputStream("src/Project/enemyInfo.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner inFS = new Scanner(fileinputstream);
		
		inFS.nextLine(); // Skips the first line of the file
		
		// Choose a random enemy from the list
		ArrayList<String> enemyList = new ArrayList<String>(Arrays.asList("Goblin", "Slime", "Orc", "Skeleton", "Spider", "Golem", "Chimera", "Dragon"));
		List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
	    Random random = new Random();
	    int randomNumber = numberList.get(random.nextInt(numberList.size()));
	    String randomEnemy = enemyList.get(randomNumber);
	    name = randomEnemy;
	    
	    // Search file for corresponding enemy data
		while (searchingFile) {
			
			String line = inFS.nextLine();
			
			if (randomEnemy.equals(line)) {

				HP = inFS.nextInt();
				attackOne = inFS.next();
				attackTwo = inFS.next();
					
				searchingFile = false;
				break;
			}
		}
		
		// Generate a random amount of attack damage
		List<Integer> damageList = Arrays.asList(28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47);
	    Random rng = new Random();
	    attackDMG = damageList.get(rng.nextInt(damageList.size()));
		
		scanner.close();
	}

	public static String getName() {
		return name;
	}

	public static int getHP() {
		return HP;
	}

	public static String getAttackOne() {
		return attackOne;
	}

	public int getAttackDMG() {
		return attackDMG;
	}

	public static String getAttackTwo() {
		return attackTwo;
	}

	public String getAttackEffect() {
		return attackEffect;
	}
}
>>>>>>> 34c23519bb0973b9f2c48977eaf833424bd494a0
