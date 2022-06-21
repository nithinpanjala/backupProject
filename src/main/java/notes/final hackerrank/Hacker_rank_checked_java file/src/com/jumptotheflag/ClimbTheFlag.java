package com.jumptotheflag;

import java.util.Scanner;

public class ClimbTheFlag {
	public static int jumps(int flagHeight, int bigJump) {
		int noOfBigJumps = flagHeight/bigJump;
		
		return noOfBigJumps + (flagHeight%bigJump);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter flag height");
		int flagheight = scanner.nextInt();
		
		System.out.println("Enter big jump height");
		int bigJump = scanner.nextInt();
		scanner.close();
		
		System.out.println(jumps(flagheight, bigJump));
	}
}
