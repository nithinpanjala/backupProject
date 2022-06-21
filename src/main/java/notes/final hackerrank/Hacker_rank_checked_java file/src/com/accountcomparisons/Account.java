package com.accountcomparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Account implements OnlineAccount, Comparable<Account> {
	private String ownerName;
	private int noOfRegularMovies;
	private int noOfExclusiveMovies;

	public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
		super();
		this.ownerName = ownerName;
		this.noOfRegularMovies = noOfRegularMovies;
		this.noOfExclusiveMovies = noOfExclusiveMovies;
	}

	public double monthlyCost() {
		return (basePrice + noOfRegularMovies * regularMoviePrice + noOfExclusiveMovies * exclusiveMoviePrice);
	}

	@Override
	public int compareTo(Account o) {

		return this.monthlyCost() < o.monthlyCost() ? 1 : -1;
	}

	@Override
	public String toString() {
		return "Owner is " + this.ownerName + " and monthly cost is " + this.monthlyCost() + " USD.";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter no of accounts");
		int noOfAccounts = scanner.nextInt();
		scanner.nextLine();

		List<Account> accounts = new ArrayList<Account>();

		for (int i = 0; i < noOfAccounts; i++) {
			System.out.println("Enter account-" + (i + 1) + " information");
			String[] s = scanner.nextLine().split(" ");

			Account account = new Account(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]));
			accounts.add(account);
		}
		scanner.close();
		
		Collections.sort(accounts);
		
		System.out.println("Most valuable account details: ");
		for (Account account : accounts) {
			System.out.println(account);
			break;
		}
		
	}

}
