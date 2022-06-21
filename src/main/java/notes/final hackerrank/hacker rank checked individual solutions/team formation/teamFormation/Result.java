package teamFormation;

import java.util.Arrays;
import java.util.Scanner;

public class Result {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter total no of skills to be added : ");
		int[] skills = new int[scan.nextInt()];
		
		for (int i = 0; i < skills.length; i++) {
			System.out.println("Enter skill " + (i + 1) + " : ");
			skills[i] = scan.nextInt();
		}
		System.out.println("Enter min no of players in a team : ");
		int minPlayers = scan.nextInt();
		System.out.println("Enter min Skill Level of players in a team : ");
		int minLevel = scan.nextInt();
		System.out.println("Enter max Skill Level of players in a team : ");
		int maxLevel = scan.nextInt();

		int count = countTeams(skills, minPlayers, minLevel, maxLevel);
		System.out.println(count);
		scan.close();
	}

	private static int countTeams(int[] skills, int minPlayers, int minLevel, int maxLevel) {
		if (skills.length != 0) {
			int[] filter = Arrays.stream(skills).filter(i -> (i >= minLevel && i <= maxLevel)).toArray();
			if (filter.length > minPlayers) {
				int count = 1;
				for (int i = minPlayers; i < filter.length; i++) {
					count += factorial(filter.length) / ((factorial(i) * factorial(filter.length - i)));
				}
				return count;
			} else {
				return (filter.length == minPlayers ? 1 : 0);
			}

		} else {
			return 0;
		}

	}

	static int factorial(int n) {

		return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);

	}

}