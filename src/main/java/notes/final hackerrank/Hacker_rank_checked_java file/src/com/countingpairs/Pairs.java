package com.countingpairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Pairs {

	public static int countPairs(List<Integer> numbers, int k) {

		int count = 0;
		Set<Integer> set = new HashSet<Integer>();

		for (Integer num : numbers) {
			set.add(num);
		}

		for (Integer num : set) {
			if (set.contains(num + k)) {
				count++;
			}
		}

		return count;

		/*
		 * int kDiffs = 0; Map<Integer, Integer> counter = new HashMap<>(); for (int n:
		 * numbers){ int countOfN = counter.getOrDefault(n, 0); countOfN++;
		 * counter.put(n, countOfN); if(k==0){ if(countOfN == 2){ kDiffs++; } } else
		 * if(countOfN ==1){ if(counter.containsKey(n-k)){ kDiffs++; }
		 * if(counter.containsKey(n+k)){ kDiffs++; } } } return kDiffs;
		 */

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of array");
		int n = scanner.nextInt();

		List<Integer> numbers = new ArrayList<Integer>();

		System.out.println("Enter array elements line by line");
		for (int i = 0; i < n; i++) {
			numbers.add(scanner.nextInt());
		}

		System.out.println("Enter the value of k");
		int k = scanner.nextInt();

		scanner.close();

		int res = countPairs(numbers, k);
		System.out.println(res);
	}
}
