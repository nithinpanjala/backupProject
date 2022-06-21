package MaxRatingSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxRatingSumSolution {
	/*
	 * maximumSum function
	 *
	 * return a LONG_INTEGER maxSoFar.
	 * 
	 * @param acepts list of integer as a param.
	 */
	public static long maximumSum(List<Integer> arr) {

		int sizeOfArray = arr.size();
		long maxSoFar = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < sizeOfArray; i++) {
			max_ending_here = max_ending_here + arr.get(i);
			if (maxSoFar < max_ending_here) {
				{
					maxSoFar = max_ending_here;
				}
				if (max_ending_here < 0) {
					max_ending_here = 0;
				}

			}
			
		}
		return maxSoFar;
	}
	

/*--------------------------Main Method--------------------------- */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		List<Integer> arr = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int listele = scanner.nextInt();
			arr.add(listele);
		}

		long result = maximumSum(arr);

		System.out.println(result);

		scanner.close();
	}

}
