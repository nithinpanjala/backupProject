package com.maximumratingsum;

import java.util.Scanner;

public class MovieRatings {
	public static long maximumSum(int[] arr) {
		/*
		 * long max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
		 * 
		 * for(int i=0; i< arr.length; i++){ max_ending_here = max_ending_here + arr[i];
		 * if(max_so_far < max_ending_here){ max_so_far = max_ending_here; }
		 * if(max_ending_here < 0){ max_ending_here = 0; } } return max_so_far;
		 */
		
		/*
		 * temp_sum = Math.max(intArr[i], temp_sum + intArr[i]); max_sum =
		 * Math.max(max_sum, temp_sum);
		 */
		
		int max_sum = Integer.MIN_VALUE;
		int temp_sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			temp_sum += arr[i];
			if(max_sum < temp_sum) {
				max_sum = temp_sum;
			}
			if(temp_sum < 0) {
				temp_sum = 0;
			}
		}
		
		return max_sum;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of array");
		int n = scanner.nextInt();
		
		int[] myArray = new int[n];
		
		System.out.println("Enter array elements");
		for (int i = 0; i < n; i++) {
			myArray[i] = scanner.nextInt();
		}
		
		scanner.close();
		
		System.out.println(maximumSum(myArray));
	}
}
