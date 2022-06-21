package com.main;

import java.util.Scanner;
import java.lang.Math;

public class jumpMain {

	public static int flagJumps(int flagHeight, int bigJump) {

		int complete_jump = Math.floorDiv(flagHeight, bigJump);
		int rem_jump = flagHeight % bigJump;
		return complete_jump + rem_jump;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the flag height: ");
		int flagHeight = scan.nextInt();

		System.out.println("Enter the big jump: ");
		int bigJump = scan.nextInt();

		int noOfJumps = flagJumps(flagHeight, bigJump);
		System.out.println("No of jumps to reach flag height: " + noOfJumps);

		scan.close();

	}

}
