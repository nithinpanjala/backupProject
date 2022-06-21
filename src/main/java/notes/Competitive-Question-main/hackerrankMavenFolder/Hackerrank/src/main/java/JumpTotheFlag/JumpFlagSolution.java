package JumpTotheFlag;

import java.util.Scanner;

public class JumpFlagSolution {
	
	 /*
	 * Complete the 'jumps' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 * 1. INTEGER flagHeight
	 * 2. INTEGER bigJump
	 */

	 public static int jumps(int flagHeight, int bigJump) {
	 
		return (flagHeight/bigJump)+(flagHeight%bigJump);
		
		 }
	 
/*--------------------------Main Method--------------------------- */
	 
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int flagHeight = scanner.nextInt();
		 int bigJump = scanner.nextInt();
		 
		 int ans = jumps(flagHeight, bigJump);
		 System.out.println(ans);
		 scanner.close();
	}
	
}
