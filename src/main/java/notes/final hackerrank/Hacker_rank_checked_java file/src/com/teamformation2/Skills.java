package com.teamformation2;

import java.util.Arrays;
import java.util.Scanner;
public class Skills {
	public static int countTeams(int[] skills, int minPlayers, int minLevel, int maxLevel) {
		int result = 0;
		
		int[] filteredSkills = Arrays.stream(skills).filter(rating -> (rating >= minLevel && rating <= maxLevel)).toArray();
		
		if(filteredSkills.length >  minPlayers) {
			int count = 1;
			for(int i = minPlayers ; i < filteredSkills.length ; i++) {
				count += factorial(filteredSkills.length)/((factorial(i) * factorial(filteredSkills.length - i)));
                }
			result = count;
		}else if(filteredSkills.length == minPlayers) {
			result=1;
		}

		return result;
	}
	
	static int factorial(int n){
		return (n==1 || n==0) ? 1 : n * factorial(n-1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of an List");
		int n = scanner.nextInt();

		int[] skills = new int[n];

		System.out.println("Enter elements of an array");
		for (int i = 0; i < n; i++) {
			skills[i] = (scanner.nextInt());
		}
		
		System.out.println("Enter min no of players");
		int minPlayers = scanner.nextInt();
		
		System.out.println("Enter min level");
		int minLevel = scanner.nextInt();
		
		System.out.println("Enter max level");
		int maxLevel = scanner.nextInt();
		scanner.close();
		
		System.out.println(countTeams(skills, minPlayers, minLevel, maxLevel));
	}
}
