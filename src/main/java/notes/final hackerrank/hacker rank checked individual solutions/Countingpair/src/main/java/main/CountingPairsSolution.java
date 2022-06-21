package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountingPairsSolution {

	/*
	 * countPairs function.
	 *
	 * return an INTEGER.
	 * 
	 * @param list of integer numbers, k as int
	 * 
	 */
	public static int countPairs(List<Integer> numbers, int k) {

		int kDifference = 0;
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

		for (int num : numbers) {
			int countOfNumbers = counter.getOrDefault(num, 0);
			countOfNumbers++;
			counter.put(num, countOfNumbers);

			if (k == 0) {

				if (countOfNumbers == 2) {
					kDifference++;
				}
			} else if (countOfNumbers == 1) {

				if (counter.containsKey(num - k)) {
					kDifference++;
				}
				if (counter.containsKey(num + k)) {
					kDifference++;
				}

			}
		}
		return kDifference;
	}

	public static class CountingPairsMain {
		public static void main(String[] args) throws IOException {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Size(n) of the Array : ");

			int n = scanner.nextInt();
			System.out.println("Enter the  Number of Integer: ");

			List<Integer> arr = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				int listele = scanner.nextInt();
				arr.add(listele);
			}
			System.out.println("Enter the K Vlaue: ");
			int k = scanner.nextInt();

			int result = CountingPairsSolution.countPairs(arr, k);

			System.out.println("The Number of Counting Pair is : " + result);

			scanner.close();
		}
	}

}